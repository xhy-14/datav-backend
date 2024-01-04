package io.renren.modules.home.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.home.dao.CarouselDao;
import io.renren.modules.home.entity.CarouselEntity;
import io.renren.modules.home.service.CarouselService;


@Service("carouselService")
public class CarouselServiceImpl extends ServiceImpl<CarouselDao, CarouselEntity> implements CarouselService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CarouselEntity> page = this.page(
                new Query<CarouselEntity>().getPage(params),
                new QueryWrapper<CarouselEntity>().eq("is_delete", 0).orderByDesc("create_time")
        );

        return new PageUtils(page);
    }

}