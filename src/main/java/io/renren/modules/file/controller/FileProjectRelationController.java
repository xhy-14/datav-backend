package io.renren.modules.file.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.file.entity.FileProjectRelationEntity;
import io.renren.modules.file.service.FileProjectRelationService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 文件项目关联表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:40:21
 */
@RestController
@RequestMapping("file/fileprojectrelation")
public class FileProjectRelationController {
    @Autowired
    private FileProjectRelationService fileProjectRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("file:fileprojectrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fileProjectRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("file:fileprojectrelation:info")
    public R info(@PathVariable("id") Long id){
		FileProjectRelationEntity fileProjectRelation = fileProjectRelationService.getById(id);

        return R.ok().put("fileProjectRelation", fileProjectRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("file:fileprojectrelation:save")
    public R save(@RequestBody FileProjectRelationEntity fileProjectRelation){
		fileProjectRelationService.save(fileProjectRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("file:fileprojectrelation:update")
    public R update(@RequestBody FileProjectRelationEntity fileProjectRelation){
		fileProjectRelationService.updateById(fileProjectRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("file:fileprojectrelation:delete")
    public R delete(@RequestBody Long[] ids){
		fileProjectRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
