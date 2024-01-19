package io.renren.modules.app.controller.data;


import io.renren.common.utils.R;
import io.renren.modules.app.dto.SaveGeneratedChartDTO;
import io.renren.modules.app.dto.UpdateGeneratedChartDTO;
import io.renren.modules.app.service.data.GeneratedChartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/common/generated_chart")
@Api(tags = "已生成图表", description = "已生成图表模块")
public class AppGeneratedChartController {

    @Autowired
    private GeneratedChartService generatedChartService;

    @ApiOperation("添加已生成图表")
    @PostMapping("/save")
    public R saveGeneratedChart(HttpServletRequest request,
                                @RequestBody SaveGeneratedChartDTO saveGeneratedChartDTO) {
        return generatedChartService.saveGeneratedChart(request, saveGeneratedChartDTO);
    }

    @ApiOperation("删除已生成图表")
    @GetMapping("/delete")
    public R deleteGeneratedChart(HttpServletRequest request,
                                  @ApiParam(value = "已生成图表id", name = "generatedChartId", required = true)
                                  @RequestParam("generatedChartId") Long generatedChartId) {
        return generatedChartService.deleteGeneratedChart(request, generatedChartId);
    }

//    @ApiOperation("修改已生成图表")
//    @PostMapping("/update")
//    public R updateGeneratedChart(HttpServletRequest request, UpdateGeneratedChartDTO updateGeneratedChartDTO) {
//        return generatedChartService.updateGeneratedChart(request, updateGeneratedChartDTO);
//    }

    @ApiOperation("查询我的已生成图表列表")
    @GetMapping("/list")
    public R listMyGeneratedChart(HttpServletRequest request) {
        return generatedChartService.listMyGeneratedChart(request);
    }

    @ApiOperation("根据id查询已生成图表信息")
    @GetMapping("/get_generated_chart_by_id")
    public R getGeneratedChartById(HttpServletRequest request,
                                   @ApiParam(value = "图表id",name = "generatedChartId")
                                   @RequestParam("generatedChartId") Long generatedChartId) {
        return generatedChartService.getGeneratedChartById(request, generatedChartId);
    }
}
