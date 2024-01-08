package io.renren.modules.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.app.service.ParameterChartTypeRelationService;
import io.renren.modules.chart.dao.ParameterChartTypeRelationDao;
import io.renren.modules.chart.entity.ParameterChartTypeRelationEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParameterChartTypeRelationServiceImpl extends ServiceImpl<ParameterChartTypeRelationDao, ParameterChartTypeRelationEntity> implements ParameterChartTypeRelationService {

    @Override
    public List<ParameterChartTypeRelationEntity> getListByChartTypeId(Long chartId) {

        QueryWrapper<ParameterChartTypeRelationEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type_id", chartId);

        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public ParameterChartTypeRelationEntity getEntityByRelation(Long parameterId, Long typeId) {

        QueryWrapper<ParameterChartTypeRelationEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parameter_id", parameterId)
                .eq("type_id", typeId);

        return baseMapper.selectOne(queryWrapper);
    }
}
