package io.renren.modules.app.dto;

import io.renren.modules.app.entity.CSVEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author xiehanying
 */
@Data
@ApiModel("数据传输")
public class TableDto {
    @ApiModelProperty("数据表名")
    @NotBlank(message = "表头不能为空")
    private String name;

    @ApiModelProperty("数据")
    private CSVEntity data;
}
