package io.renren.modules.file.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.file.entity.FileEntity;

import java.util.Map;

/**
 * 文件表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:40:21
 */
public interface FileService extends IService<FileEntity> {

    PageUtils queryPage(Map<String, Object> params);

    Long getFileTypeId(String urlStr);

    String getFileName(String urlStr);

    FileEntity defaultValue(String urlStr);

    FileEntity getFileById(Long id);
}

