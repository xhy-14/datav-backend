package io.renren.modules.home.dao;

import io.renren.modules.home.entity.TutorialEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.home.entity.vo.TutorialVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 教程表
 * 
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:43:50
 */
@Mapper
public interface TutorialDao extends BaseMapper<TutorialEntity> {
    @Select("select home_tutorial.id, file_id, title, content, file_file.path, " +
            "home_tutorial.is_delete, home_tutorial.create_time, home_tutorial.update_time " +
            "from file_file, home_tutorial " +
            "where home_tutorial.file_id=file_file.id " +
            "order by home_tutorial.step")
    List<TutorialVO> queryTutorialVOList();

}
