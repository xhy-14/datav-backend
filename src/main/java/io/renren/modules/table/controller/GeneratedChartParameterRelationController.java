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

import io.renren.modules.table.entity.GeneratedChartParameterRelationEntity;
import io.renren.modules.table.service.GeneratedChartParameterRelationService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 已生成图表-参数关联表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:36:30
 */
@RestController
@RequestMapping("table/generatedchartparameterrelation")
public class GeneratedChartParameterRelationController {
    @Autowired
    private GeneratedChartParameterRelationService generatedChartParameterRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("table:generatedchartparameterrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = generatedChartParameterRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("table:generatedchartparameterrelation:info")
    public R info(@PathVariable("id") Long id){
		GeneratedChartParameterRelationEntity generatedChartParameterRelation = generatedChartParameterRelationService.getById(id);

        return R.ok().put("generatedChartParameterRelation", generatedChartParameterRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("table:generatedchartparameterrelation:save")
    public R save(@RequestBody GeneratedChartParameterRelationEntity generatedChartParameterRelation){
		generatedChartParameterRelationService.save(generatedChartParameterRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("table:generatedchartparameterrelation:update")
    public R update(@RequestBody GeneratedChartParameterRelationEntity generatedChartParameterRelation){
		generatedChartParameterRelationService.updateById(generatedChartParameterRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("table:generatedchartparameterrelation:delete")
    public R delete(@RequestBody Long[] ids){
		generatedChartParameterRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
