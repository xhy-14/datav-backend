package io.renren.modules.home.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.home.entity.dto.CarouselSaveDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.home.entity.CarouselEntity;
import io.renren.modules.home.service.CarouselService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 轮播表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:43:50
 */
@RestController
@RequestMapping("common/home/carousel")
@Api("轮播接口")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ApiOperation("轮播查询")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = carouselService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("home:carousel:info")
    public R info(@PathVariable("id") Long id){
        CarouselEntity carousel = carouselService.getById(id);

        return R.ok().put("carousel", carousel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CarouselSaveDTO carouselSaveDTO){

        carouselService.caroselSave(carouselSaveDTO);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("home:carousel:update")
    public R update(@RequestBody CarouselEntity carousel){
        carouselService.updateById(carousel);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("home:carousel:delete")
    public R delete(@RequestBody Long[] ids){
        carouselService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
