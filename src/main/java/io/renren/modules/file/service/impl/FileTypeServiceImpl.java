package io.renren.modules.file.service.impl;

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

}