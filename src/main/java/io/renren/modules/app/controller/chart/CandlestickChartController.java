package io.renren.modules.app.controller.chart;


import io.renren.common.utils.R;
import io.renren.modules.app.echarts.candlestick.CandlestickChart;
import io.renren.modules.app.entity.CSVEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common/chart")
@Api(tags = "k线图模块", description = "k线图")
public class CandlestickChartController {

    @ApiOperation("获取k线图")
    @PostMapping("/candlestick")
    public R getCandleStickChart(@RequestBody CSVEntity csvEntity) {
        return R.success(new CandlestickChart(csvEntity));
    }

}
