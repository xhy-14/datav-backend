package io.renren.modules.app.service.file;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.R;
import io.renren.modules.app.dto.FileUploadDTO;
import io.renren.modules.file.entity.FileEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface FileService extends IService<FileEntity> {

    R upLoadFile(HttpServletRequest request, FileUploadDTO fileUploadDTO, MultipartFile file);

    R upLoadOtherFile(MultipartFile file);
}
