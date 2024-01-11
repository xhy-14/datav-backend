package io.renren.modules.app.controller.data;


import io.renren.common.utils.R;
import io.renren.modules.app.dto.SaveGeneratedChartDTO;
import io.renren.modules.app.service.data.GeneratedChartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/common/generated_chart")
@Api(tags = "已生成图表接口", description = "已生成图表")
public class AppGeneratedChartController {

    @Autowired
    private GeneratedChartService generatedChartService;

    @PostMapping("/save")
    @ApiOperation("保存图表")
    public R saveGeneratedChart(HttpServletRequest request,
                                SaveGeneratedChartDTO dto) {
        return generatedChartService.saveGeneratedChart(request, dto);
    }




}
