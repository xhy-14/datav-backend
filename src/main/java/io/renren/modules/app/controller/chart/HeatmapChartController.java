package io.renren.modules.app.controller.chart;


import io.renren.common.utils.R;
import io.renren.modules.app.echarts.heatmap.Heatmap;
import io.renren.modules.app.entity.CSVEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/chart/heatmap")
@Api(tags = "热力图", description = "热力图")
public class HeatmapChartController {

    @ApiOperation("获取热力图")
    @PostMapping("/draw")
    public R getDraw(@RequestBody CSVEntity csvEntity) {
        return R.success(new Heatmap(csvEntity));
    }

}
