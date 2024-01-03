package io.renren.modules.menber.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.menber.entity.ComboEntity;
import io.renren.modules.menber.service.ComboService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 套餐表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:46:46
 */
@RestController
@RequestMapping("menber/combo")
public class ComboController {
    @Autowired
    private ComboService comboService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("menber:combo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = comboService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("menber:combo:info")
    public R info(@PathVariable("id") Long id){
		ComboEntity combo = comboService.getById(id);

        return R.ok().put("combo", combo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("menber:combo:save")
    public R save(@RequestBody ComboEntity combo){
		comboService.save(combo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("menber:combo:update")
    public R update(@RequestBody ComboEntity combo){
		comboService.updateById(combo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("menber:combo:delete")
    public R delete(@RequestBody Long[] ids){
		comboService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
