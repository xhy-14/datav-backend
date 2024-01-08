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

import io.renren.modules.chart.entity.ParameterTypeEntity;
import io.renren.modules.chart.service.ParameterTypeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 参数类型表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:31:13
 */
@RestController
@RequestMapping("chart/parametertype")
public class ParameterTypeController {
    @Autowired
    private ParameterTypeService parameterTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("chart:parametertype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = parameterTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("chart:parametertype:info")
    public R info(@PathVariable("id") Long id){
		ParameterTypeEntity parameterType = parameterTypeService.getById(id);

        return R.ok().put("parameterType", parameterType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("chart:parametertype:save")
    public R save(@RequestBody ParameterTypeEntity parameterType){
        parameterType.setIsDelete(0);
        parameterType.setCreateTime(new Date());
        parameterType.setUpdateTime(new Date());
		parameterTypeService.save(parameterType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("chart:parametertype:update")
    public R update(@RequestBody ParameterTypeEntity parameterType){
		parameterTypeService.updateById(parameterType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("chart:parametertype:delete")
    public R delete(@RequestBody Long[] ids){
		parameterTypeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
