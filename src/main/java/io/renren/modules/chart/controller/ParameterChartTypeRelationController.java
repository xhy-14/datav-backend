package io.renren.modules.chart.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.chart.entity.ParameterChartTypeRelationEntity;
import io.renren.modules.chart.service.ParameterChartTypeRelationService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 图表-参数关联表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:31:13
 */
@RestController
@RequestMapping("chart/parametercharttyperelation")
public class ParameterChartTypeRelationController {
    @Autowired
    private ParameterChartTypeRelationService parameterChartTypeRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("chart:parametercharttyperelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = parameterChartTypeRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("chart:parametercharttyperelation:info")
    public R info(@PathVariable("id") Long id){
		ParameterChartTypeRelationEntity parameterChartTypeRelation = parameterChartTypeRelationService.getById(id);

        return R.ok().put("parameterChartTypeRelation", parameterChartTypeRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("chart:parametercharttyperelation:save")
    public R save(@RequestBody ParameterChartTypeRelationEntity parameterChartTypeRelation){
        parameterChartTypeRelation.setIsDelete(0);
        parameterChartTypeRelation.setCreateTime(new Date());
        parameterChartTypeRelation.setUpdateTime(new Date());
		parameterChartTypeRelationService.save(parameterChartTypeRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("chart:parametercharttyperelation:update")
    public R update(@RequestBody ParameterChartTypeRelationEntity parameterChartTypeRelation){
		parameterChartTypeRelationService.updateById(parameterChartTypeRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("chart:parametercharttyperelation:delete")
    public R delete(@RequestBody Long[] ids){
		parameterChartTypeRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
