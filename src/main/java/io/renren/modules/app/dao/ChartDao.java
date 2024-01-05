package io.renren.modules.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.chart.entity.ChartTypeEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChartDao extends BaseMapper<ChartTypeEntity> {

}
