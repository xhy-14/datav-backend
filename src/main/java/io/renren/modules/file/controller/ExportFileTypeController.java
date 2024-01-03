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

import io.renren.modules.file.entity.ExportFileTypeEntity;
import io.renren.modules.file.service.ExportFileTypeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 导出文件表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:40:21
 */
@RestController
@RequestMapping("file/exportfiletype")
public class ExportFileTypeController {
    @Autowired
    private ExportFileTypeService exportFileTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("file:exportfiletype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = exportFileTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("file:exportfiletype:info")
    public R info(@PathVariable("id") Long id){
		ExportFileTypeEntity exportFileType = exportFileTypeService.getById(id);

        return R.ok().put("exportFileType", exportFileType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("file:exportfiletype:save")
    public R save(@RequestBody ExportFileTypeEntity exportFileType){
		exportFileTypeService.save(exportFileType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("file:exportfiletype:update")
    public R update(@RequestBody ExportFileTypeEntity exportFileType){
		exportFileTypeService.updateById(exportFileType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("file:exportfiletype:delete")
    public R delete(@RequestBody Long[] ids){
		exportFileTypeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
