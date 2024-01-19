package io.renren.modules.app.controller.chart;

import io.renren.common.utils.R;
import io.renren.modules.app.echarts.radar.RadarChart;
import io.renren.modules.app.entity.CSVEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common/chart")
@Api(tags = "雷达图模块", description = "雷达图")
public class RadarChartController {

    @ApiOperation("获取雷达图")
    @PostMapping("/radar")
    public R getRadarChart(@RequestBody CSVEntity csvEntity) {
        return R.success(new RadarChart(csvEntity));
    }

}
