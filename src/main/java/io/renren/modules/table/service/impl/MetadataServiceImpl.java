package io.renren.modules.table.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.table.dao.MetadataDao;
import io.renren.modules.table.entity.MetadataEntity;
import io.renren.modules.table.service.MetadataService;


@Service("metadataService")
public class MetadataServiceImpl extends ServiceImpl<MetadataDao, MetadataEntity> implements MetadataService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MetadataEntity> page = this.page(
                new Query<MetadataEntity>().getPage(params),
                new QueryWrapper<MetadataEntity>()
        );

        return new PageUtils(page);
    }

}