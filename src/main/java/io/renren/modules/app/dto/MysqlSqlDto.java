package io.renren.modules.app.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xiehanying
 */
@Data
public class MysqlSqlDto {
    /**
     * 数据库连接id
     */
    @ApiModelProperty("数据库连接id")
    private long id;

    /**
     * 执行语句
     */
    @ApiModelProperty("执行语句")
    private String code;
}
