package io.renren.modules.table.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.table.entity.GeneratedChartEntity;
import io.renren.modules.table.service.GeneratedChartService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 已生成图表表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:36:30
 */
@RestController
@RequestMapping("table/generatedchart")
public class GeneratedChartController {
    @Autowired
    private GeneratedChartService generatedChartService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("table:generatedchart:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = generatedChartService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("table:generatedchart:info")
    public R info(@PathVariable("id") Long id){
		GeneratedChartEntity generatedChart = generatedChartService.getById(id);

        return R.ok().put("generatedChart", generatedChart);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("table:generatedchart:save")
    public R save(@RequestBody GeneratedChartEntity generatedChart){
		generatedChartService.save(generatedChart);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("table:generatedchart:update")
    public R update(@RequestBody GeneratedChartEntity generatedChart){
		generatedChartService.updateById(generatedChart);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("table:generatedchart:delete")
    public R delete(@RequestBody Long[] ids){
		generatedChartService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
