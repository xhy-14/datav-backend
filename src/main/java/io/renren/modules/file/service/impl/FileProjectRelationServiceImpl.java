package io.renren.modules.file.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.file.dao.FileProjectRelationDao;
import io.renren.modules.file.entity.FileProjectRelationEntity;
import io.renren.modules.file.service.FileProjectRelationService;


@Service("fileProjectRelationService")
public class FileProjectRelationServiceImpl extends ServiceImpl<FileProjectRelationDao, FileProjectRelationEntity> implements FileProjectRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FileProjectRelationEntity> page = this.page(
                new Query<FileProjectRelationEntity>().getPage(params),
                new QueryWrapper<FileProjectRelationEntity>()
        );

        return new PageUtils(page);
    }

}