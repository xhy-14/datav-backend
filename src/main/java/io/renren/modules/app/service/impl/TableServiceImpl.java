/**
 * 数据表模块
 * @author 谢寒应
 * @time 2024-1-9
 */
package io.renren.modules.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import io.renren.modules.app.dao.TableDao;
import io.renren.modules.app.entity.CSVEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.TableService;
import io.renren.modules.app.service.UserService;
import io.renren.modules.app.utils.CSVUtils;
import io.renren.modules.app.vo.table.TableDataVo;
import io.renren.modules.app.vo.table.TableVo;
import io.renren.modules.file.entity.FileEntity;
import io.renren.modules.file.service.FileService;
import io.renren.modules.table.entity.MetadataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        CSVEntity csvEntity = getCSVObjByPath(dataFile.getPath());
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

    /**
     * 根据文件url获取csv对象
     * @param path
     * @return
     */
    public CSVEntity getCSVObjByPath(String path) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        HttpEntity<InputStream> requestEntity = null;
        requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(path, HttpMethod.POST, requestEntity, String.class, Charset.forName("UTF-8"));

        // 转为csv对象
        String csvData = response.getBody();
        CSVEntity csvEntity = csvUtils.stringToCSV(csvData);
        return csvEntity;
    }
}
