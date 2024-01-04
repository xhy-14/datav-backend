package io.renren.modules.home.dao;

import io.renren.modules.home.entity.CarouselEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.home.entity.vo.CarouselVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 轮播表
 * 
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:43:50
 */
@Mapper
public interface CarouselDao extends BaseMapper<CarouselEntity> {
    @Select("SELECT home_carousel.id, file_id, content, path " +
            "FROM file_file, home_carousel " +
            "WHERE file_file.id = home_carousel.file_id " +
            "LIMIT #{offset}, #{limit}")
    List<CarouselVO> queryCarouselVOList(@Param("offset") Long offset, @Param("limit") Long limit);

    @Select("SELECT COUNT(*) " +
            "FROM file_file, home_carousel " +
            "WHERE file_file.id = home_carousel.file_id")
    Long queryCarouselVOCount();
}
