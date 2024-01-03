package io.renren.modules.chart.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.chart.dao.ParameterTypeDao;
import io.renren.modules.chart.entity.ParameterTypeEntity;
import io.renren.modules.chart.service.ParameterTypeService;


@Service("parameterTypeService")
public class ParameterTypeServiceImpl extends ServiceImpl<ParameterTypeDao, ParameterTypeEntity> implements ParameterTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ParameterTypeEntity> page = this.page(
                new Query<ParameterTypeEntity>().getPage(params),
                new QueryWrapper<ParameterTypeEntity>()
        );

        return new PageUtils(page);
    }

}