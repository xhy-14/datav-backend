package io.renren.modules.app.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UpdateGeneratedChartDTO {
    @ApiModelProperty(value = "已生成图表id", required = true)
    private Long generatedChartId;
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

}
