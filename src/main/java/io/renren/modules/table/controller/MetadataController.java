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

import io.renren.modules.table.entity.MetadataEntity;
import io.renren.modules.table.service.MetadataService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 元数据表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:36:30
 */
@RestController
@RequestMapping("table/metadata")
public class MetadataController {
    @Autowired
    private MetadataService metadataService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("table:metadata:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = metadataService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("table:metadata:info")
    public R info(@PathVariable("id") Long id){
		MetadataEntity metadata = metadataService.getById(id);

        return R.ok().put("metadata", metadata);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("table:metadata:save")
    public R save(@RequestBody MetadataEntity metadata){
		metadataService.save(metadata);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("table:metadata:update")
    public R update(@RequestBody MetadataEntity metadata){
		metadataService.updateById(metadata);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("table:metadata:delete")
    public R delete(@RequestBody Long[] ids){
		metadataService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
