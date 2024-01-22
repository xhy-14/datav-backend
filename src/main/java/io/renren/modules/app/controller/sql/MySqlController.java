package io.renren.modules.app.controller.sql;

import io.renren.common.utils.R;
import io.renren.modules.app.dto.MysqlConnectDto;
import io.renren.modules.app.dto.MysqlSqlDto;
import io.renren.modules.app.service.sql.MysqlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xiehanying
 */
@RestController
@RequestMapping("/app/sql/mysql")
@Api(tags = "mysql模块", description = "mysql数据库链接模块")
public class MySqlController {
    @Autowired
    private MysqlService mysqlService;

    @PostMapping("/test")
    @ApiOperation("mysql数据库连接测试")
    public R mysqlConnectTest(@RequestBody MysqlConnectDto mysqlConnectDto) {
        return mysqlService.connectTest(mysqlConnectDto);
    }

    @PostMapping("/save")
    @ApiOperation("保存mysql连接")
    public R saveMysqlConnection(@RequestBody MysqlConnectDto mysqlConnectDto, HttpServletRequest httpServletRequest) {
        return mysqlService.saveConnection(mysqlConnectDto, httpServletRequest);
    }

    @GetMapping("/get_database/{id}")
    @ApiOperation("id获取数据库")
    public R getDatabaseByID(@ApiParam(name = "id", required = true) @PathVariable Long id) {
        return mysqlService.getDataBaseByID(id);
    }

    @GetMapping("/my-sql")
    @ApiOperation("获取我的所有数据库连接")
    public R getMySqlConnection(HttpServletRequest httpServletRequest) {
        return mysqlService.getMySqlConnections(httpServletRequest);
    }

    @PostMapping("/execute")
    @ApiOperation("执行查询代码")
    public R execute(@RequestBody MysqlSqlDto mysqlSqlDto) {
        return mysqlService.executeSelect(mysqlSqlDto);
    }
}
