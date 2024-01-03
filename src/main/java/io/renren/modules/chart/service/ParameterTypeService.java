package io.renren.modules.chart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.chart.entity.ParameterTypeEntity;

import java.util.Map;

/**
 * 参数类型表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:31:13
 */
public interface ParameterTypeService extends IService<ParameterTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

