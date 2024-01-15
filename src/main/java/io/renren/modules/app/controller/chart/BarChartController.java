package io.renren.modules.app.controller.chart;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.renren.common.utils.R;
import io.renren.modules.app.echarts.barchart.BasicBarChart;
import io.renren.modules.app.service.chart.BarChartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/common/bar_chart")
@Api(tags = "柱状图模块", description = "柱状图")
public class BarChartController {

    @Autowired
    private BarChartService barChartService;

    @ApiOperation("获取基础柱状图默认参数")
    @GetMapping("/get_default_basic_bar")
    public R getDefaultBasicBar() {
        return barChartService.getBasicdefaultValue();
    }

    @ApiOperation("存储参数")
    @PostMapping("/save_parameter")
    public R saveBasicBarParameter(@RequestBody BasicBarChart basicBarChart,
                                   @ApiParam(value = "已生成图表id", required = true)
                                   @RequestParam("generatedChartId")Long generatedChartId) throws JsonProcessingException {
        return barChartService.saveGeneratedChartParameter(basicBarChart, generatedChartId);
    }

    @ApiOperation("获取某一图表参数")
    @GetMapping("/get_parameter")
    public R getParameterByChartId(@ApiParam(value = "已生成图表id", required = true)
                                   @RequestParam("generatedChartId")Long generatedChartId) {
        return barChartService.getParameterByChartId(generatedChartId);
    }

}
