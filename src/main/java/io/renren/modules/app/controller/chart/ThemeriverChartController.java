package io.renren.modules.app.controller.chart;


import io.renren.common.utils.R;
import io.renren.modules.app.echarts.themeriver.ThemeriverChart;
import io.renren.modules.app.entity.CSVEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/chart/themetiver")
@Api(tags = "河流图", description = "河流图")
public class ThemeriverChartController {

    @ApiOperation("获取主题河流图")
    @PostMapping("/draw")
    public R getDraw(@RequestBody CSVEntity csvEntity) {
        return R.success(new ThemeriverChart(csvEntity));
    }

}
