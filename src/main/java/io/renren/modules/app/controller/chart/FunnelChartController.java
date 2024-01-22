package io.renren.modules.app.controller.chart;


import io.renren.common.utils.R;
import io.renren.modules.app.echarts.funnel.FunnelChart;
import io.renren.modules.app.entity.CSVEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/chart/funnel")
@Api(tags = "漏斗图", description = "漏斗图")
public class FunnelChartController {

    @ApiOperation("获取漏斗图")
    @PostMapping("/draw")
    public R getDraw(@RequestBody CSVEntity csvEntity) {
        return R.success(new FunnelChart(csvEntity));
    }

}
