package io.renren.modules.app.controller.chart;


import com.fasterxml.jackson.core.JsonProcessingException;
import io.renren.common.utils.R;
import io.renren.modules.app.echarts.barchart.BasicBarChart;
import io.renren.modules.app.echarts.barchart.MoreBarChart;
import io.renren.modules.app.echarts.barchart.radialpolarbar.RadialPolarBarChart;
import io.renren.modules.app.entity.CSVEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/common/chart")
@Api(tags = "柱状图模块", description = "柱状图")
public class BarChartController {


    @ApiOperation("获取柱状图")
    @PostMapping("/bar")
    public R getBarChart(@RequestBody CSVEntity csvEntity) {
        BasicBarChart basicBarChart = new BasicBarChart();
        basicBarChart.setData(csvEntity);
        return R.success(basicBarChart);
    }

    @ApiOperation("获取多柱柱状图")
    @PostMapping("/more_bar")
    public R getMoreChart(@RequestBody CSVEntity csvEntity) {
        MoreBarChart moreBarChart = new MoreBarChart();
        moreBarChart.setData(csvEntity);
        return R.success(moreBarChart);
    }

    @ApiOperation("获取极坐标柱状图")
    @PostMapping("/polar_bar")
    public R getPolarBarChart(@RequestBody CSVEntity csvEntity) {
        return R.success(new RadialPolarBarChart(csvEntity));
    }


}
