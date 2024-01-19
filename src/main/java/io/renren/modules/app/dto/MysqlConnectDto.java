package io.renren.modules.app.dto;

import io.renren.modules.table.entity.MysqlConnectionEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xiehanying
 */
@Data
public class MysqlConnectDto {

    @ApiModelProperty("连接名")
    private String name;

    @ApiModelProperty("IP地址")
    private String ip;

    @ApiModelProperty("端口")
    private String port;

    @ApiModelProperty("数据库名")
    private String database;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("是否是mysql8+以上")
    private boolean isMysql8;

    public MysqlConnectDto(MysqlConnectionEntity mysqlConnectionEntity) {
        this.name = mysqlConnectionEntity.getDatabaseName();
        this.ip = mysqlConnectionEntity.getHost();
        this.port = mysqlConnectionEntity.getPort();
        this.database = mysqlConnectionEntity.getDatabaseName();
        this.username = mysqlConnectionEntity.getUserName();
        this.password = mysqlConnectionEntity.getPassword();
        if( "com.mysql.cj.jdbc.Driver".equals(mysqlConnectionEntity.getDriver()) ) {
            this.isMysql8 = true;
        } else {
            this.isMysql8 = false;
        }
    }

    public MysqlConnectDto() {}
}
