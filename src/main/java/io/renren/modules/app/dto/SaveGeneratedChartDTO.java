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
    @ApiModelProperty(value = "图表类型id", required = true)
    private Long chartTypeId;
    /**
     * 元数据id
     */
    @ApiModelProperty(value = "元数据id", required = true)
    private Long metadataId;
    /**
     * 图表名称
     */
    @ApiModelProperty(value = "图表名", required = true)
    private String name;
    /**
     * 描述
     */
    @ApiModelProperty(value = "图表描述")
    private String depicition;
    /**
     * option字符串
     */
    @ApiModelProperty(value = "option对象")
    private Object option;
}
