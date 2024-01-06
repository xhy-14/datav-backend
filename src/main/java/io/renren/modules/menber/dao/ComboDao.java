package io.renren.modules.menber.dao;

import io.renren.modules.app.vo.ComboInfoVo;
import io.renren.modules.menber.entity.ComboEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 套餐表
 * 
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:46:46
 */
@Mapper
public interface ComboDao extends BaseMapper<ComboEntity> {
    @Select("select name, price, term, discount from menber_combo")
    List<ComboInfoVo> getList();
}
