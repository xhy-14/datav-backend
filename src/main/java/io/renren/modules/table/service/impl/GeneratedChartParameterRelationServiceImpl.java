package io.renren.modules.table.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.table.dao.GeneratedChartParameterRelationDao;
import io.renren.modules.table.entity.GeneratedChartParameterRelationEntity;
import io.renren.modules.table.service.GeneratedChartParameterRelationService;


@Service("generatedChartParameterRelationService")
public class GeneratedChartParameterRelationServiceImpl extends ServiceImpl<GeneratedChartParameterRelationDao, GeneratedChartParameterRelationEntity> implements GeneratedChartParameterRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GeneratedChartParameterRelationEntity> page = this.page(
                new Query<GeneratedChartParameterRelationEntity>().getPage(params),
                new QueryWrapper<GeneratedChartParameterRelationEntity>()
        );

        return new PageUtils(page);
    }

}