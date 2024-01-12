/**
 * 数据表模块
 * @author 谢寒应
 * @time 2024-1-9
 */
package io.renren.modules.app.service.impl;

import cn.hutool.core.io.resource.MultiFileResource;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import io.renren.modules.app.dao.TableDao;
import io.renren.modules.app.dto.TableDto;
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
import io.renren.modules.file.entity.FileTypeEntity;
import io.renren.modules.file.service.FileService;
import io.renren.modules.file.service.FileTypeService;
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

        // 保存在metadata中
        return R.success(fileEntity);
    }

    @Override
    public R generateTableByFile(MultipartFile file) {
        String fileType = file.getContentType();
        BaseGenerator factory = GeneratorFactor.factory(fileType);
        CSVEntity csvEntity = factory.generateTable(file);
        return R.success(csvEntity);
    }
}
