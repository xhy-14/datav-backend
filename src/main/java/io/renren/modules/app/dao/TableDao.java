/**
 * @author 谢寒应
 * @time 2024-1-9
 */
package io.renren.modules.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.table.entity.MetadataEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TableDao extends BaseMapper<MetadataEntity> {

}
