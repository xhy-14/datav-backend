package io.renren.modules.app.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GeneratedParameterDTO {

    @ApiModelProperty("参数id")
    Long parameterId;

    @ApiModelProperty("内容")
    String content;

}
