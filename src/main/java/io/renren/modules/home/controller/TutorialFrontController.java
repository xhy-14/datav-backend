package io.renren.modules.home.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import io.renren.modules.home.entity.dto.TutorialSaveDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("common/home/tutorial")
@Api(tags = "教程接口", description = "教程")
public class TutorialFrontController {
    @Autowired
    private TutorialService tutorialService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("教程查询")
    public R list(@ApiParam(value = "当前页", required = true, defaultValue = "1")
                  @RequestParam(value = "current", required = false) Long current,
                  @ApiParam(value = "每页数量", required = true, defaultValue = "10")
                  @RequestParam(value = "size", required = false) Long size){

        Map<String, Object> params = new HashMap<>();
        if (current != null)
            params.put("current", current);
        if (size != null)
            params.put("size", size);

        PageUtils page = tutorialService.queryPage(params);

        return R.ok().put("page", page);
    }

}
