/**
 * 数据表模块
 * @author 谢寒应
 * @time 2024-1-9
 */
package io.renren.modules.app.service.impl;

import cn.hutool.core.io.resource.MultiFileResource;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import io.renren.modules.app.dao.TableDao;
import io.renren.modules.app.dto.TableDto;
import io.renren.modules.app.dto.TableUpdateDTO;
import io.renren.modules.app.entity.CSVEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.generator.BaseGenerator;
import io.renren.modules.app.generator.CSVGenerator;
import io.renren.modules.app.generator.GeneratorFactor;
import io.renren.modules.app.service.TableService;
import io.renren.modules.app.service.UserService;
import io.renren.modules.app.utils.CSVUtils;
import io.renren.modules.app.utils.FileCreator;
import io.renren.modules.app.vo.table.TableDataVo;
import io.renren.modules.app.vo.table.TableVo;
import io.renren.modules.file.entity.FileEntity;
import io.renren.modules.file.entity.FileProjectRelationEntity;
import io.renren.modules.file.entity.FileTypeEntity;
import io.renren.modules.file.entity.ProjectEntity;
import io.renren.modules.file.service.FileProjectRelationService;
import io.renren.modules.file.service.FileService;
import io.renren.modules.file.service.FileTypeService;
import io.renren.modules.file.service.ProjectService;
import io.renren.modules.table.entity.MetadataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TableServiceImpl extends ServiceImpl<TableDao, MetadataEntity> implements TableService {

    @Autowired
    private UserService userService;

    @Autowired
    private FileService fileService;

    @Autowired
    private CSVUtils csvUtils;

    @Autowired
    private FileTypeService fileTypeService;

    @Autowired
    private FileCreator fileCreator;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private FileProjectRelationService projectRelationService;

    /**
     * 获取数据表
     * @param id
     * @return
     */
    @Override
    public R getTableByID(Long id) {
        // 查询metadata
        MetadataEntity metadataEntity = this.getTableInfoByID(id);

        // 获取用户
        UserEntity user = userService.getUserByID(metadataEntity.getUserId());
        // 获取文件元数据
        FileEntity file = fileService.getFileById(metadataEntity.getDataFileId());

        TableVo tableVo = new TableVo();
        tableVo.setId(metadataEntity.getId());
        tableVo.setUserId(user.getUserId());
        tableVo.setUsername(user.getUsername());
        tableVo.setDepiction(metadataEntity.getDepiction());
        tableVo.setTableUrl(file.getPath());
        tableVo.setFileID(metadataEntity.getDataFileId());

        return R.success(tableVo);
    }

    /**
     * 获取数据表数据
     * @param id
     * @return
     */
    @Override
    public R getTableDataByID(Long id) {

        // 查询metadata
        MetadataEntity metadataEntity = this.getTableInfoByID(id);

        // 获取csv存贮文件
        FileEntity dataFile = fileService.getFileById(metadataEntity.getDataFileId());
        CSVEntity csvEntity = csvUtils.getCSVByUrl(dataFile.getPath());

        TableDataVo tableDataVo = new TableDataVo();

        tableDataVo.setId(id);
        tableDataVo.setName(metadataEntity.getName());
        tableDataVo.setRowSum(csvEntity.getRows().size());
        tableDataVo.setData(csvEntity);

        return R.success(tableDataVo);
    }

    /**
     * 获取数据表信息
     * @param id
     * @return
     */
    @Override
    public MetadataEntity getTableInfoByID(Long id) {
        LambdaQueryWrapper<MetadataEntity> queryWrapper = new LambdaQueryWrapper<>();
        MetadataEntity metadataEntity = baseMapper.selectOne(
                queryWrapper.eq(MetadataEntity::getId, id)
        );

        if(metadataEntity == null) {
            throw new RRException("读取数据表为空");
        }

        return metadataEntity;
    }

    @Override
    public boolean generateTableByExcel(Long id) {
        return false;
    }

    /**
     * 生成table
     * @param id
     * @return
     */
    @Override
    public R generateTableByFileID(Long id) {
        // 查询文件
        FileEntity file = fileService.getFileById(id);
        FileTypeEntity fileType = fileTypeService.getFileTypeByID(file.getFileTypeId());

        // 生成对应的生成器
        BaseGenerator generator = GeneratorFactor.factory(fileType.getName());

        CSVEntity csvEntity = generator.generateTable(file.getPath());

        return R.success(csvEntity);
    }

    @Override
    public R saveTable(TableDto tableDto, HttpServletRequest httpServletRequest) {
        String csvString = csvUtils.CSVToString(tableDto.getData());
        UserEntity userEntity = userService.currentUser(httpServletRequest);

        FileEntity fileEntity = fileCreator.createFile(csvString, userEntity.getUserId());

        LambdaQueryWrapper<ProjectEntity> queryWrapper = new LambdaQueryWrapper<>();
        BaseMapper<ProjectEntity> projectBaseMapper = projectService.getBaseMapper();
        List<ProjectEntity> projectEntities = projectBaseMapper.selectList(queryWrapper.eq(ProjectEntity::getUserId, userEntity.getUserId()));

        boolean isUserProject = false;

        for( ProjectEntity projectEntity: projectEntities) {
            if(projectEntity.getId().equals(tableDto.getPid())) {
                isUserProject = true;
                break;
            }
        }

        if( !isUserProject ) {
            throw new RRException("该文件不属于该用户");
        }
        Date time = new Date(System.currentTimeMillis());
        FileProjectRelationEntity fileProjectRelationEntity = new FileProjectRelationEntity();
        fileProjectRelationEntity.setUserId(userEntity.getUserId());
        fileProjectRelationEntity.setIsDelete(0);
        fileProjectRelationEntity.setDirectoryId(tableDto.getPid());
        fileProjectRelationEntity.setUpdateTime(time);
        fileProjectRelationEntity.setCreateTime(time);
        fileProjectRelationEntity.setFileId(fileEntity.getId());
        projectRelationService.getBaseMapper().insert(fileProjectRelationEntity);

        // 保存在metadata中
        MetadataEntity metadataEntity = new MetadataEntity();
        metadataEntity.setName(tableDto.getName());
        metadataEntity.setDataFileId(fileEntity.getId());
        metadataEntity.setIsDelete(0);
        metadataEntity.setFileId(0L);
        metadataEntity.setUserId(userEntity.getUserId());
        metadataEntity.setDepiction("");
        metadataEntity.setCreateTime(time);
        metadataEntity.setUpdateTime(time);

        this.baseMapper.insert(metadataEntity);

        return R.success(metadataEntity.getId());
    }

    @Override
    public R updateTable(TableUpdateDTO tableDto) {
        String csvString = csvUtils.CSVToString(tableDto.getData());
        MetadataEntity metadataEntity = baseMapper.selectById(tableDto.getId());
        FileEntity fileEntity = fileCreator.createFile(csvString, metadataEntity.getUserId());
        baseMapper.updateById(metadataEntity);

        QueryWrapper<FileProjectRelationEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("file_id", metadataEntity.getDataFileId());
        FileProjectRelationEntity relationEntity = projectRelationService.getBaseMapper().selectOne(queryWrapper);
        relationEntity.setFileId(fileEntity.getId());

        metadataEntity.setDataFileId(fileEntity.getId());

        baseMapper.updateById(metadataEntity);
        projectRelationService.getBaseMapper().updateById(relationEntity);
        return R.success();
    }

    @Override
    public R generateTableByFile(MultipartFile file) {
        String fileType = file.getContentType();
        BaseGenerator factory = GeneratorFactor.factory(fileType);
        CSVEntity csvEntity = factory.generateTable(file);
        return R.success(csvEntity);
    }

    @Override
    public R datasetList(HttpServletRequest httpServletRequest) {
        UserEntity userEntity = userService.currentUser(httpServletRequest);
        LambdaQueryWrapper<MetadataEntity> queryWrapper = new LambdaQueryWrapper<>();
        List<MetadataEntity> metadataEntities = baseMapper.selectList(
                queryWrapper.eq(MetadataEntity::getUserId, userEntity.getUserId())
        );
        List<TableVo> tableVos = new ArrayList<>();

        for(MetadataEntity metadataEntity: metadataEntities) {
            TableVo tableVo = new TableVo();
            tableVo.setFileID(metadataEntity.getFileId());
            tableVo.setName(metadataEntity.getName());
            tableVo.setDepiction(metadataEntity.getDepiction());
            tableVo.setId(metadataEntity.getId());

            QueryWrapper<FileProjectRelationEntity> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("file_id", metadataEntity.getDataFileId());
            FileProjectRelationEntity relationEntity = projectRelationService.getBaseMapper().selectOne(queryWrapper1);
            tableVo.setProjectId(relationEntity.getDirectoryId());

            tableVos.add(tableVo);
        }
        return R.success(tableVos);
    }
}
