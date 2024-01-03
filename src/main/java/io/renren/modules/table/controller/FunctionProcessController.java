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

import io.renren.modules.table.entity.FunctionProcessEntity;
import io.renren.modules.table.service.FunctionProcessService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 函数处理表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:36:30
 */
@RestController
@RequestMapping("table/functionprocess")
public class FunctionProcessController {
    @Autowired
    private FunctionProcessService functionProcessService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("table:functionprocess:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = functionProcessService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("table:functionprocess:info")
    public R info(@PathVariable("id") Long id){
		FunctionProcessEntity functionProcess = functionProcessService.getById(id);

        return R.ok().put("functionProcess", functionProcess);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("table:functionprocess:save")
    public R save(@RequestBody FunctionProcessEntity functionProcess){
		functionProcessService.save(functionProcess);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("table:functionprocess:update")
    public R update(@RequestBody FunctionProcessEntity functionProcess){
		functionProcessService.updateById(functionProcess);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("table:functionprocess:delete")
    public R delete(@RequestBody Long[] ids){
		functionProcessService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
