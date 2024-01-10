package io.renren.modules.app.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 创建项目（文件夹）
 */
@Data
public class ProjectDTO {
    /**
     * 项目id,创建项目时为空
     */
    @ApiModelProperty(value = "项目id,创建项目时为空")
    Long projectId;
    /**
     * 项目名
     */
    @ApiModelProperty(value = "项目名（文件夹名称）", required = true)
    String name;
    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    String depicition;

}
