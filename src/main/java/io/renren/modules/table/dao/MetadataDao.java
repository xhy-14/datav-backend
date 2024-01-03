package io.renren.modules.table.dao;

import io.renren.modules.table.entity.MetadataEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 元数据表
 * 
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:36:30
 */
@Mapper
public interface MetadataDao extends BaseMapper<MetadataEntity> {
	
}
