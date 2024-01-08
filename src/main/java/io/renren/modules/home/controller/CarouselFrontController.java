package io.renren.modules.home.controller;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import io.renren.modules.home.entity.dto.CarouselSaveDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api(tags = "轮播", description = "轮播")
public class CarouselFrontController {
    @Autowired
    private CarouselService carouselService;
    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("轮播查询")
    public R list(@ApiParam(value = "当前页", required = true, defaultValue = "1")
                  @RequestParam(value = "current", required = false) Long current,
                  @ApiParam(value = "每页数量", required = true, defaultValue = "10")
                  @RequestParam(value = "size", required = false) Long size){

        Map<String, Object> params = new HashMap<>();
        if (current != null)
            params.put("current", current);
        if (size != null)
            params.put("size", size);

        PageUtils page = carouselService.queryPage(params);

        return R.success(page);
    }
}

