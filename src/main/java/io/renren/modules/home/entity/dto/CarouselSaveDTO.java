package io.renren.modules.home.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("轮播表单")
public class CarouselSaveDTO {
    @ApiModelProperty(value = "链接")
    @NotBlank(message = "链接不能为空")
    private String url;
    @ApiModelProperty(value = "内容")
    private String content;
}
