package io.renren.modules.app.controller.chart;

import io.renren.common.utils.R;
import io.renren.modules.app.echarts.scatter.ScatterChart;
import io.renren.modules.app.entity.CSVEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author xiehanying
 */
@RestController
@RequestMapping("/app/chart/scatter")
@Api(tags = "散点图", description = "散点图")
public class ScatterController {
    @PostMapping("/draw")
    @ApiOperation("绘制散点图")
    public R drawScatter(@RequestBody CSVEntity csvEntity) {
        return R.success(new ScatterChart(csvEntity));
    }
}
