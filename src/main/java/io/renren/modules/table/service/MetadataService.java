package io.renren.modules.table.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.table.entity.MetadataEntity;

import java.util.Map;

/**
 * 元数据表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:36:30
 */
public interface MetadataService extends IService<MetadataEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

