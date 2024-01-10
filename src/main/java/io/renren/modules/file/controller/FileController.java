package io.renren.modules.file.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import io.renren.common.exception.RRException;
import io.renren.modules.oss.cloud.OSSFactory;
import io.renren.modules.oss.entity.SysOssEntity;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.file.entity.FileEntity;
import io.renren.modules.file.service.FileService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import org.springframework.web.multipart.MultipartFile;


/**
 * 文件表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:40:21
 */
@RestController
@RequestMapping("/file/file")
public class FileController extends AbstractController {
    @Autowired
    private FileService fileService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("file:file:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fileService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("file:file:info")
    public R info(@PathVariable("id") Long id){
        FileEntity file = fileService.getById(id);

        return R.ok().put("file", file);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("file:file:save")
    public R save(@RequestBody FileEntity file){
        fileService.save(file);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("file:file:update")
    public R update(@RequestBody FileEntity file){
        fileService.updateById(file);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("file:file:delete")
    public R delete(@RequestBody Long[] ids){
        fileService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @PostMapping("/upload")
    public R upload(@RequestParam("file") MultipartFile file,
                    @RequestParam(value = "content", required = false) String content) throws Exception {
        if (file.isEmpty()) {
            throw new RRException("上传文件不能为空");
        }

        //上传文件
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String urlStr = OSSFactory.build().uploadSuffix(file.getBytes(), suffix);

        FileEntity fileEntity = fileService.defaultValue(urlStr);
        fileEntity.setUserId(getUserId());
        //文件大小，预留为0
        fileEntity.setSize(0);
        fileEntity.setDepiction(content);
        fileService.save(fileEntity);

        return R.ok().put("url", urlStr);
    }

}
