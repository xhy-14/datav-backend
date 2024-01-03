package io.renren.modules.chart.dao;

import io.renren.modules.chart.entity.ParameterEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 参数表
 * 
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:31:13
 */
@Mapper
public interface ParameterDao extends BaseMapper<ParameterEntity> {
	
}
