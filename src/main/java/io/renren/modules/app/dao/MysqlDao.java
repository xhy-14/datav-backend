package io.renren.modules.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.table.entity.MysqlConnectionEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xiehanying
 */
@Mapper
public interface MysqlDao extends BaseMapper<MysqlConnectionEntity> {
}
