package io.renren.modules.app.service.impl.chart;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.app.service.chart.ParameterTypeService;
import io.renren.modules.chart.dao.ParameterTypeDao;
import io.renren.modules.chart.entity.ParameterTypeEntity;
import org.springframework.stereotype.Service;

@Service
public class ParameterTypeServiceImpl extends ServiceImpl<ParameterTypeDao, ParameterTypeEntity> implements ParameterTypeService {

    @Override
    public ParameterTypeEntity getEntityByTypeId(Long parameterTypeId) {

        QueryWrapper<ParameterTypeEntity> queryWrapper = new QueryWrapper<>();

        return baseMapper.selectOne(queryWrapper.eq("id", parameterTypeId));

    }
}
