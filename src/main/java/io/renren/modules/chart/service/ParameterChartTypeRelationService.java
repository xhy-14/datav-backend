package io.renren.modules.chart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.chart.entity.ParameterChartTypeRelationEntity;

import java.util.Map;

/**
 * 图表-参数关联表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:31:13
 */
public interface ParameterChartTypeRelationService extends IService<ParameterChartTypeRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

