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

import io.renren.modules.file.entity.FileTypeEntity;
import io.renren.modules.file.service.FileTypeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 文件类型表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:40:21
 */
@RestController
@RequestMapping("file/filetype")
public class FileTypeController {
    @Autowired
    private FileTypeService fileTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("file:filetype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fileTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("file:filetype:info")
    public R info(@PathVariable("id") Long id){
		FileTypeEntity fileType = fileTypeService.getById(id);

        return R.ok().put("fileType", fileType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("file:filetype:save")
    public R save(@RequestBody FileTypeEntity fileType){
		fileTypeService.save(fileType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("file:filetype:update")
    public R update(@RequestBody FileTypeEntity fileType){
		fileTypeService.updateById(fileType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("file:filetype:delete")
    public R delete(@RequestBody Long[] ids){
		fileTypeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
