package io.renren.modules.file.service.impl;

import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import io.renren.modules.app.dto.FileUploadDTO;
import io.renren.modules.app.service.UserService;
import io.renren.modules.file.entity.FileTypeEntity;
import io.renren.modules.file.service.FileTypeService;
import io.renren.modules.oss.cloud.OSSFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


@Service("fileService")
public class FileServiceImpl extends ServiceImpl<FileDao, FileEntity> implements FileService {

    @Autowired
    private FileTypeService fileTypeService;

    @Autowired
    private UserService userService;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FileEntity> page = this.page(
                new Query<FileEntity>().getPage(params),
                new QueryWrapper<FileEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public FileTypeEntity getFileTypeId(Long id) {
        FileEntity file = this.getFileById(id);
        FileTypeEntity fileType = fileTypeService.getFileTypeByID(file.getFileTypeId());
        return fileType;
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
        fileEntity.setFileTypeId(0L);
        fileEntity.setName(getFileName(urlStr));
        fileEntity.setPath(urlStr);
        fileEntity.setIsDelete(0);
        fileEntity.setCreateTime(new Date());
        fileEntity.setUpdateTime(new Date());
        return fileEntity;
    }

    @Override
    public FileEntity getFileById(Long id) {
        FileEntity file = baseMapper.selectOne(new QueryWrapper<FileEntity>().eq("id", id));
        if(file == null) {
            throw new RRException("文件不见了", 404);
        }
        return file;
    }
}