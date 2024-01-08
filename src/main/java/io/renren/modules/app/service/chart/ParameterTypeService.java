package io.renren.modules.app.service.chart;

import io.renren.modules.chart.entity.ParameterTypeEntity;

public interface ParameterTypeService {
    /**
     * 根据type_id查询entity
     */
    ParameterTypeEntity getEntityByTypeId(Long parameterTypeId);
}
