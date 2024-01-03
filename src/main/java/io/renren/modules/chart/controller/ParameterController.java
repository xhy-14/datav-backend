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

import io.renren.modules.chart.entity.ParameterEntity;
import io.renren.modules.chart.service.ParameterService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 参数表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:31:13
 */
@RestController
@RequestMapping("chart/parameter")
public class ParameterController {
    @Autowired
    private ParameterService parameterService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("chart:parameter:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = parameterService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("chart:parameter:info")
    public R info(@PathVariable("id") Long id){
		ParameterEntity parameter = parameterService.getById(id);

        return R.ok().put("parameter", parameter);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("chart:parameter:save")
    public R save(@RequestBody ParameterEntity parameter){
		parameterService.save(parameter);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("chart:parameter:update")
    public R update(@RequestBody ParameterEntity parameter){
		parameterService.updateById(parameter);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("chart:parameter:delete")
    public R delete(@RequestBody Long[] ids){
		parameterService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
