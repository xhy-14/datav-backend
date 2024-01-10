package io.renren.modules.file.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.app.dto.FileUploadDTO;
import io.renren.modules.file.entity.FileEntity;
import io.renren.modules.file.entity.FileTypeEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 文件表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:40:21
 */
public interface FileService extends IService<FileEntity> {

    /**
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     *
     * @param id
     * @return FileTypeEntity
     */
    FileTypeEntity getFileTypeId(Long id);

    /**
     *
     * @param urlStr
     * @return
     */
    String getFileName(String urlStr);

    /**
     *
     * @param urlStr
     * @return
     */
    FileEntity defaultValue(String urlStr);

    /**
     *
     * @param id
     * @return
     */
    FileEntity getFileById(Long id);

}

