package io.renren.modules.home.service.impl;

import io.renren.modules.file.entity.FileEntity;
import io.renren.modules.file.service.FileService;
import io.renren.modules.home.entity.dto.TutorialSaveDTO;
import io.renren.modules.home.entity.vo.CarouselVO;
import io.renren.modules.home.entity.vo.TutorialVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.home.dao.TutorialDao;
import io.renren.modules.home.entity.TutorialEntity;
import io.renren.modules.home.service.TutorialService;


@Service("tutorialService")
public class TutorialServiceImpl extends ServiceImpl<TutorialDao, TutorialEntity> implements TutorialService {

    @Autowired
    private FileService fileService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        // 获取分页参数
        Long current = Long.parseLong(params.getOrDefault("current", 1).toString());
        Long size = Long.parseLong(params.getOrDefault("size", 10).toString());

        // 执行查询
        List<TutorialVO> tutorialVOList = baseMapper.queryTutorialVOList((current - 1) * size, size);

        Long total = baseMapper.queryTutorialVOCount();

        // 封装结果到 PageUtils 对象
        PageUtils pageUtils = new PageUtils(tutorialVOList, total.intValue(), 0, 0);

        return pageUtils;

    }

    @Override
    public Boolean tutorialSave(TutorialSaveDTO tutorialSaveDTO) {
        //该过程分为两部分，存储文件表，存储教程表
        //以下为存储文件
        String urlStr = tutorialSaveDTO.getUrl();

        FileEntity fileEntity = fileService.defaultValue(urlStr);
        //保存file实体信息
        fileEntity.setUserId(0L);
        fileEntity.setDepiction(tutorialSaveDTO.getContent());
        //文件大小,预留为0
        fileEntity.setSize(0);

        fileService.save(fileEntity);

        //以下是存储教程表
        TutorialEntity tutorialEntity = new TutorialEntity();
        tutorialEntity.setFileId(fileEntity.getId());
        tutorialEntity.setTitle(tutorialSaveDTO.getTitle());
        tutorialEntity.setContent(tutorialSaveDTO.getContent());
        tutorialEntity.setStep(tutorialSaveDTO.getStep());
        tutorialEntity.setIsDelete(0);
        tutorialEntity.setCreateTime(new Date());
        tutorialEntity.setCreateTime(new Date());

        this.save(tutorialEntity);

        return true;
    }
}