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

import io.renren.modules.table.entity.MysqlConnectionEntity;
import io.renren.modules.table.service.MysqlConnectionService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * mysql连接表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:36:30
 */
@RestController
@RequestMapping("table/mysqlconnection")
public class MysqlConnectionController {
    @Autowired
    private MysqlConnectionService mysqlConnectionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("table:mysqlconnection:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = mysqlConnectionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("table:mysqlconnection:info")
    public R info(@PathVariable("id") Long id){
		MysqlConnectionEntity mysqlConnection = mysqlConnectionService.getById(id);

        return R.ok().put("mysqlConnection", mysqlConnection);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("table:mysqlconnection:save")
    public R save(@RequestBody MysqlConnectionEntity mysqlConnection){
		mysqlConnectionService.save(mysqlConnection);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("table:mysqlconnection:update")
    public R update(@RequestBody MysqlConnectionEntity mysqlConnection){
		mysqlConnectionService.updateById(mysqlConnection);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("table:mysqlconnection:delete")
    public R delete(@RequestBody Long[] ids){
		mysqlConnectionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
