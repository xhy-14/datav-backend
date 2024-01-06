/**
 *
 * xhy
 * 2024-1-5
 *
 */
package io.renren.modules.app.controller.chart;

import io.renren.common.utils.R;
import io.renren.modules.app.service.ChartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        chartService.allChartTemplates();
        return R.ok();
    }
}
