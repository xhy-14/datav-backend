package io.renren.modules.app.dto;

import io.renren.modules.app.entity.CSVEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("数据集修改传输实体")
public class TableUpdateDTO {

    @ApiModelProperty("数据集id")
    @NotBlank(message = "表头不能为空")
    private Long id;


    @ApiModelProperty("数据")
    @NotBlank(message = "数据不能为空")
    private CSVEntity data;

}
