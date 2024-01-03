package io.renren.modules.table.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.table.entity.GeneratedChartParameterRelationEntity;

import java.util.Map;

/**
 * 已生成图表-参数关联表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:36:30
 */
public interface GeneratedChartParameterRelationService extends IService<GeneratedChartParameterRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

