package io.renren.modules.file.dao;

import io.renren.modules.file.entity.ProjectEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 项目表
 * 
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:40:21
 */
@Mapper
public interface ProjectDao extends BaseMapper<ProjectEntity> {
	
}
