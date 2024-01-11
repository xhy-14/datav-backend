package io.renren.modules.app.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UpdateMysqlConnectionDTO {

    @ApiModelProperty(value = "数据库id", required = true)
    private Long mysqlConnectionId;

    @ApiModelProperty(value = "主机号", required = true)
    private String host;

    @ApiModelProperty(value = "端口", required = true)
    private String port;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "数据库名", required = true)
    private String databaseName;

}
