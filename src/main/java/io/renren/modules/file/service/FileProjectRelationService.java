package io.renren.modules.file.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.file.entity.FileProjectRelationEntity;

import java.util.Map;

/**
 * 文件项目关联表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:40:21
 */
public interface FileProjectRelationService extends IService<FileProjectRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

