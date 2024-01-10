package io.renren.modules.app.controller.file;

import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import io.renren.modules.app.dto.FileUploadDTO;
import io.renren.modules.app.service.file.FileService;
import io.renren.modules.file.entity.FileEntity;
import io.renren.modules.oss.cloud.OSSFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/common/file")
@Api(tags = "文件", description = "文件")
public class AppFileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    @ApiOperation("上传用户源文件")
    public R upload(HttpServletRequest request, FileUploadDTO fileUploadDTO) throws Exception {
        return fileService.upLoadFile(request, fileUploadDTO);
    }

}