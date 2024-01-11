package io.renren.modules.app.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileUploadDTO {

    @ApiModelProperty("文件夹id")
    Long projectId;


    @ApiModelProperty("文件名")
    String name;

    @ApiModelProperty("描述")
    String depicition;

}
