package io.renren.modules.table.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.table.entity.GeneratedChartEntity;

import java.util.Map;

/**
 * 已生成图表表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:36:30
 */
public interface GeneratedChartService extends IService<GeneratedChartEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

