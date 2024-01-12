package io.renren.modules.app.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileUploadDTO {

    @ApiModelProperty(value = "文件夹id", required = true)
    Long projectId;


    @ApiModelProperty(value = "文件名", required = true)
    String name;

    @ApiModelProperty("描述")
    String depicition;

}
