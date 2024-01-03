package io.renren.modules.menber.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.menber.entity.ComboEntity;

import java.util.Map;

/**
 * 套餐表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:46:46
 */
public interface ComboService extends IService<ComboEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

