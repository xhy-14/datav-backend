package io.renren.modules.home.dao;

import io.renren.modules.home.entity.CarouselEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 轮播表
 * 
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:43:50
 */
@Mapper
public interface CarouselDao extends BaseMapper<CarouselEntity> {
	
}
