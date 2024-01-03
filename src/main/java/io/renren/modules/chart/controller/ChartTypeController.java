package io.renren.modules.chart.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.chart.entity.ChartTypeEntity;
import io.renren.modules.chart.service.ChartTypeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 图表类型表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:31:13
 */
@RestController
@RequestMapping("chart/charttype")
public class ChartTypeController {
    @Autowired
    private ChartTypeService chartTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("chart:charttype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = chartTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("chart:charttype:info")
    public R info(@PathVariable("id") Long id){
		ChartTypeEntity chartType = chartTypeService.getById(id);

        return R.ok().put("chartType", chartType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("chart:charttype:save")
    public R save(@RequestBody ChartTypeEntity chartType){
		chartTypeService.save(chartType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("chart:charttype:update")
    public R update(@RequestBody ChartTypeEntity chartType){
		chartTypeService.updateById(chartType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("chart:charttype:delete")
    public R delete(@RequestBody Long[] ids){
		chartTypeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
