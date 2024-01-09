package io.renren.modules.file.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.file.entity.FileTypeEntity;

import java.util.Map;

/**
 * 文件类型表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:40:21
 */
public interface FileTypeService extends IService<FileTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取文件类型
     * @param id
     * @return
     */
    FileTypeEntity getFileTypeByID(Long id);
}

