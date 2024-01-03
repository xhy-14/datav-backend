package io.renren.modules.home.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.home.entity.TutorialEntity;
import io.renren.modules.home.service.TutorialService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 教程表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:43:50
 */
@RestController
@RequestMapping("home/tutorial")
public class TutorialController {
    @Autowired
    private TutorialService tutorialService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("home:tutorial:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tutorialService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("home:tutorial:info")
    public R info(@PathVariable("id") Long id){
		TutorialEntity tutorial = tutorialService.getById(id);

        return R.ok().put("tutorial", tutorial);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("home:tutorial:save")
    public R save(@RequestBody TutorialEntity tutorial){
		tutorialService.save(tutorial);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("home:tutorial:update")
    public R update(@RequestBody TutorialEntity tutorial){
		tutorialService.updateById(tutorial);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("home:tutorial:delete")
    public R delete(@RequestBody Long[] ids){
		tutorialService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
