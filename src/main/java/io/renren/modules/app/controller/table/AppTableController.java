/**
 * @author 谢寒应
 * @time 2024-1-9
 */

package io.renren.modules.app.controller.table;

import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import io.renren.modules.app.service.TableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/table")
@Api(tags = "数据模块", description = "数据信息")
public class AppTableController {

    @Autowired
    private TableService tableService;

    @GetMapping("/info")
    @ApiOperation("获取数据表")
    public R getTableByID(@ApiParam(name = "id", required = true, type = "long")
                          @RequestParam("id") Long id) {
        if(id == null) {
            throw new RRException("缺少参数");
        }
        return tableService.getTableByID(id);
    }

    @GetMapping("/data/{id}")
    @ApiOperation("获取数据表数据")
    public R getTableDataByID(@ApiParam(name = "id", value = "数据表id",required = true, type = "long")
                              @PathVariable Long id) {
        return tableService.getTableDataByID(id);
    }
}
