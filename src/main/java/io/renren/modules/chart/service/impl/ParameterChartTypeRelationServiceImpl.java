package io.renren.modules.chart.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.chart.dao.ParameterChartTypeRelationDao;
import io.renren.modules.chart.entity.ParameterChartTypeRelationEntity;
import io.renren.modules.chart.service.ParameterChartTypeRelationService;


@Service("parameterChartTypeRelationService")
public class ParameterChartTypeRelationServiceImpl extends ServiceImpl<ParameterChartTypeRelationDao, ParameterChartTypeRelationEntity> implements ParameterChartTypeRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ParameterChartTypeRelationEntity> page = this.page(
                new Query<ParameterChartTypeRelationEntity>().getPage(params),
                new QueryWrapper<ParameterChartTypeRelationEntity>()
        );

        return new PageUtils(page);
    }

}