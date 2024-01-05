package io.renren.modules.file.service.impl;

import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.file.dao.FileDao;
import io.renren.modules.file.entity.FileEntity;
import io.renren.modules.file.service.FileService;


@Service("fileService")
public class FileServiceImpl extends ServiceImpl<FileDao, FileEntity> implements FileService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FileEntity> page = this.page(
                new Query<FileEntity>().getPage(params),
                new QueryWrapper<FileEntity>()
        );

        return new PageUtils(page);
    }

    //根据url判断文件类型
    @Override
    public Long getFileTypeId(String url) {
        return 0l;
    }

    @Override
    public String getFileName(String urlStr) {
        URL url = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        // 从 URL 中获取文件名
        String fileName = url.getFile();
        fileName = fileName.substring(fileName.lastIndexOf('/') + 1);

        return fileName;
    }

    @Override
    public FileEntity defaultValue(String urlStr) {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileTypeId(getFileTypeId(urlStr));
        fileEntity.setName(getFileName(urlStr));
        fileEntity.setPath(urlStr);
        fileEntity.setIsDelete(0);
        fileEntity.setCreateTime(new Date());
        fileEntity.setUpdateTime(new Date());
        return fileEntity;
    }
}