package io.renren.modules.app.service.impl.file;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.app.service.file.FileProjectRelationService;
import io.renren.modules.file.dao.FileProjectRelationDao;
import io.renren.modules.file.entity.FileProjectRelationEntity;
import org.springframework.stereotype.Service;


@Service
public class FileProjectRelationServiceImpl extends ServiceImpl<FileProjectRelationDao, FileProjectRelationEntity> implements FileProjectRelationService {

}
