package io.renren.modules.file.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.file.entity.ExportFileTypeEntity;

import java.util.Map;

/**
 * 导出文件表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:40:21
 */
public interface ExportFileTypeService extends IService<ExportFileTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

