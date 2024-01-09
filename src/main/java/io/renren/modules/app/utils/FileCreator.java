package io.renren.modules.app.utils;

import io.renren.modules.file.entity.FileEntity;
import io.renren.modules.file.service.FileService;
import io.renren.modules.oss.cloud.OSSFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

/**
 * 文件创建对象
 * @author xiehanying
 */
@Component
public class FileCreator {

    @Autowired
    private FileService fileService;

    public FileEntity createFile(String content, long userID) {

        String fileName = System.currentTimeMillis() + ".csv";

        String urlStr = OSSFactory.build().uploadSuffix(content.getBytes(), ".csv");

        FileEntity fileEntity = new FileEntity();

        fileEntity.setDepiction("用户数据生成表");
        fileEntity.setUserId(userID);
        fileEntity.setFileTypeId(1L);

        Date time = new Date(System.currentTimeMillis());
        fileEntity.setCreateTime(time);
        fileEntity.setUpdateTime(time);
        fileEntity.setName(fileName);
        fileEntity.setSize(0);
        fileEntity.setIsDelete(0);
        fileEntity.setPath(urlStr);

        fileService.save(fileEntity);

        return fileEntity;
    }
}
