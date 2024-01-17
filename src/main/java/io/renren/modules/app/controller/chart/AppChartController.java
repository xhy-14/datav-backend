/**
 *
 * @author xhy
 * @time 2024-1-5
 *
 */
package io.renren.modules.app.controller.chart;

import io.renren.common.utils.R;
import io.renren.modules.app.entity.CSVEntity;
import io.renren.modules.app.service.ChartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/common/chart")
@Api(tags = "图表接口", description = "获取模板图表")
public class AppChartController {
    @Autowired
    private ChartService chartService;

    /**
     * 获取所有模板信息
     */
    @GetMapping("/all")
    @ApiOperation("获取图表模板")
    public R chatsList() {
        return chartService.allChartTemplates();
    }

    @PostMapping("/line")
    @ApiOperation("生成折线图")
    public R line(@ApiParam(name = "图表数据") @RequestBody CSVEntity csvEntity) {
        return chartService.line(csvEntity);
    }

    @PostMapping("/pie")
    @ApiOperation("生成饼状图")
    public R pie(@ApiParam(name = "图表数据") @RequestBody CSVEntity csvEntity) {
        return chartService.pie(csvEntity);
    }
}
