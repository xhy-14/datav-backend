package io.renren.modules.app.service.impl.file;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import io.renren.modules.app.dto.FileUploadDTO;
import io.renren.modules.app.service.UserService;
import io.renren.modules.app.service.file.FileProjectRelationService;
import io.renren.modules.app.service.file.FileService;
import io.renren.modules.file.dao.FileDao;
import io.renren.modules.file.entity.FileEntity;
import io.renren.modules.file.entity.FileProjectRelationEntity;
import io.renren.modules.oss.cloud.OSSFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@Service
public class FileServiceImpl extends ServiceImpl<FileDao, FileEntity> implements FileService {

    @Autowired
    private UserService userService;

    @Autowired
    private FileProjectRelationService fileProjectRelationService;

    @Override
    public R upLoadFile(HttpServletRequest request, FileUploadDTO fileUploadDTO, MultipartFile file) {
        if (file.isEmpty()) {
            throw new RRException("上传文件不能为空");
        }


        //上传文件
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String urlStr = null;
        try {
            urlStr = OSSFactory.build().uploadSuffix(file.getBytes(), suffix);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //生成文件实体，存储文件表
        FileEntity fileEntity = defaultValue(urlStr);
        fileEntity.setUserId(userService.currentUser(request).getUserId());
        //文件大小，预留为0
        fileEntity.setSize(0);
        fileEntity.setDepiction(fileUploadDTO.getDepicition());
        fileEntity.setName(fileUploadDTO.getName());

        save(fileEntity);

        FileProjectRelationEntity fileProjectRelationEntity = new FileProjectRelationEntity();
        fileProjectRelationEntity.setFileId(fileEntity.getId());
        fileProjectRelationEntity.setDirectoryId(fileUploadDTO.getProjectId());
        fileProjectRelationEntity.setUserId(fileEntity.getUserId());
        fileProjectRelationEntity.setIsDelete(0);
        fileProjectRelationEntity.setCreateTime(new Date());
        fileProjectRelationEntity.setUpdateTime(new Date());

        fileProjectRelationService.save(fileProjectRelationEntity);

        return R.success(fileEntity);
    }

    public FileEntity defaultValue(String urlStr) {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileTypeId(0L);
        fileEntity.setPath(urlStr);
        fileEntity.setIsDelete(0);
        fileEntity.setCreateTime(new Date());
        fileEntity.setUpdateTime(new Date());
        return fileEntity;
    }

}
