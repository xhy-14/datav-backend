package io.renren.modules.chart.dao;

import io.renren.modules.chart.entity.ParameterChartTypeRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 图表-参数关联表
 * 
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:31:13
 */
@Mapper
public interface ParameterChartTypeRelationDao extends BaseMapper<ParameterChartTypeRelationEntity> {
	
}
