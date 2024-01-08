package io.renren.modules.app.service;

import io.renren.modules.chart.entity.ParameterChartTypeRelationEntity;

import java.util.List;

public interface ParameterChartTypeRelationService {

    /**
     * 根据图表模板id获取列表
     */
    List<ParameterChartTypeRelationEntity> getListByChartTypeId(Long chartId);
    /**
     *根据parameter_id，type_id组合键关联
     */
    ParameterChartTypeRelationEntity getEntityByRelation(Long parameterId, Long typeId);
}
