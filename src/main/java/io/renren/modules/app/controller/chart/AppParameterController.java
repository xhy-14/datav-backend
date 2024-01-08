package io.renren.modules.app.controller.chart;

import io.renren.common.utils.R;
import io.renren.modules.app.service.ParameterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common/parameter")
@Api(tags = "参数接口", description = "获取模板参数")
public class AppParameterController {

    @Autowired
    private ParameterService parameterService;

    /**
     * 获取模板参数
     */
    @GetMapping("/parameter_list")
    @ApiOperation("根据模板id获取模板参数")
    public R getParameterByChartType(@ApiParam(value = "模板id", required = true)
                                     @RequestParam("chartId") Long chartId) {
        return parameterService.getParametersByChartType(chartId);
    }

}
