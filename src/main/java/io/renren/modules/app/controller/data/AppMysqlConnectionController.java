package io.renren.modules.app.controller.data;


import io.renren.common.utils.R;
import io.renren.modules.app.dto.SaveMysqlConnectionDTO;
import io.renren.modules.app.dto.UpdateMysqlConnectionDTO;
import io.renren.modules.app.service.data.MysqlConnectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/common/mysql_connection")
@Api(tags = "数据库连接", description = "数据模块")
public class AppMysqlConnectionController {

    @Autowired
    private MysqlConnectionService mysqlConnectionService;

    @ApiOperation("添加数据库连接")
    @PostMapping("/save")
    public R saveMysqlConnection(HttpServletRequest request, SaveMysqlConnectionDTO saveMysqlConnectionDTO) {
        return mysqlConnectionService.saveMysqlConnection(request, saveMysqlConnectionDTO);
    }

    @ApiOperation("删除数据库连接")
    @PostMapping("/delete")
    public R deleteMysqlConnection(HttpServletRequest request,
                                   @ApiParam(value = "数据库连接id", required = true)
                                   @RequestParam("mysqlConnectionId") Long mysqlConnectionId) {
        return mysqlConnectionService.deleteMysqlConnection(request, mysqlConnectionId);
    }

    @ApiOperation("修改数据库配置")
    @PostMapping("/update")
    public R updateMysqlConnection(HttpServletRequest request, UpdateMysqlConnectionDTO updateMysqlConnectionDTO) {
        return mysqlConnectionService.updateMysqlConnection(request, updateMysqlConnectionDTO);
    }

    @ApiOperation("查看我的数据库连接")
    @GetMapping("/list")
    public R listMysqlConnection(HttpServletRequest request) {
        return mysqlConnectionService.listMysqlConnection(request);
    }

}
