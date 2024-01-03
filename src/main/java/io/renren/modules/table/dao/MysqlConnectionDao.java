package io.renren.modules.table.dao;

import io.renren.modules.table.entity.MysqlConnectionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * mysql连接表
 * 
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:36:30
 */
@Mapper
public interface MysqlConnectionDao extends BaseMapper<MysqlConnectionEntity> {
	
}
