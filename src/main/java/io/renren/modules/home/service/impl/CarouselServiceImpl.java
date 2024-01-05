package io.renren.modules.home.service.impl;

import io.renren.modules.file.entity.FileEntity;
import io.renren.modules.file.service.FileService;
import io.renren.modules.home.entity.dto.CarouselSaveDTO;
import io.renren.modules.home.entity.vo.CarouselVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;

import java.net.URL;

import io.renren.modules.home.dao.CarouselDao;
import io.renren.modules.home.entity.CarouselEntity;
import io.renren.modules.home.service.CarouselService;


@Service("carouselService")
public class CarouselServiceImpl extends ServiceImpl<CarouselDao, CarouselEntity> implements CarouselService {

    @Autowired
    private FileService fileService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        // 获取分页参数
        Long current = Long.parseLong(params.getOrDefault("current", 1).toString());
        Long size = Long.parseLong(params.getOrDefault("size", 10).toString());

        // 执行查询
        List<CarouselVO> carouselVOList = baseMapper.queryCarouselVOList((current - 1) * size, size);

        // 查询总记录数
        Long total = baseMapper.queryCarouselVOCount();

        // 封装结果到 PageUtils 对象
        PageUtils pageUtils = new PageUtils(carouselVOList, total.intValue(), 0, 0);

        return pageUtils;
    }




    @Override
    public Boolean caroselSave(CarouselSaveDTO carouselSaveDTO) {
        //该过程分为两部分，存储文件表，存储轮播表
        //以下为存储文件
        String urlStr = carouselSaveDTO.getUrl();
        FileEntity fileEntity = fileService.defaultValue(urlStr);
        fileEntity.setUserId(0L);
        fileEntity.setDepiction(carouselSaveDTO.getContent());
        //文件大小,预留为0
        fileEntity.setSize(0);
        fileService.save(fileEntity);

        //以下是存储轮播表
        CarouselEntity carouselEntity = new CarouselEntity();
        carouselEntity.setFileId(fileEntity.getId());
        carouselEntity.setIsDelete(0);
        carouselEntity.setContent(fileEntity.getDepiction());
        carouselEntity.setUpdateTime(new Date());
        carouselEntity.setCreateTime(new Date());

        this.save(carouselEntity);

        return true;
    }
}