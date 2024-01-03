package io.renren.modules.file.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.file.dao.ExportFileTypeDao;
import io.renren.modules.file.entity.ExportFileTypeEntity;
import io.renren.modules.file.service.ExportFileTypeService;


@Service("exportFileTypeService")
public class ExportFileTypeServiceImpl extends ServiceImpl<ExportFileTypeDao, ExportFileTypeEntity> implements ExportFileTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ExportFileTypeEntity> page = this.page(
                new Query<ExportFileTypeEntity>().getPage(params),
                new QueryWrapper<ExportFileTypeEntity>()
        );

        return new PageUtils(page);
    }

}