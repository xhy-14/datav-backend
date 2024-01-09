package io.renren.modules.file.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.renren.common.exception.RRException;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.file.dao.FileTypeDao;
import io.renren.modules.file.entity.FileTypeEntity;
import io.renren.modules.file.service.FileTypeService;


/**
 * @author xiehanying
 */
@Service("fileTypeService")
public class FileTypeServiceImpl extends ServiceImpl<FileTypeDao, FileTypeEntity> implements FileTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FileTypeEntity> page = this.page(
                new Query<FileTypeEntity>().getPage(params),
                new QueryWrapper<FileTypeEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public FileTypeEntity getFileTypeByID(Long id) {
        LambdaQueryWrapper<FileTypeEntity> queryWrapper = new LambdaQueryWrapper();

        FileTypeEntity fileType = baseMapper.selectOne(queryWrapper.eq(FileTypeEntity::getId, id));

        if( fileType == null ) {
            throw new RRException("获取文件类型失败");
        }

        return fileType;
    }
}