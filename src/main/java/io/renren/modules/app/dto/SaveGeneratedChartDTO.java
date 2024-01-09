package io.renren.modules.app.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 保存已生成图表
 */
@Data
public class SaveGeneratedChartDTO {
    /**
     * 图表类型id
     */
    @ApiModelProperty("图表类型id")
    private Long chartTypeId;
    /**
     * 元数据id
     */
    @ApiModelProperty("元数据id")
    private Long metadataId;
    /**
     * 图表名称
     */
    @ApiModelProperty("图表名")
    private String name;
    /**
     * 描述
     */
    @ApiModelProperty("图表描述")
    private String depicition;
}
