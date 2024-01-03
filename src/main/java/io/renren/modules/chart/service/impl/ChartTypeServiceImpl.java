package io.renren.modules.chart.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.chart.dao.ChartTypeDao;
import io.renren.modules.chart.entity.ChartTypeEntity;
import io.renren.modules.chart.service.ChartTypeService;


@Service("chartTypeService")
public class ChartTypeServiceImpl extends ServiceImpl<ChartTypeDao, ChartTypeEntity> implements ChartTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ChartTypeEntity> page = this.page(
                new Query<ChartTypeEntity>().getPage(params),
                new QueryWrapper<ChartTypeEntity>()
        );

        return new PageUtils(page);
    }

}