package io.renren.modules.file.dao;

import io.renren.modules.file.entity.FileProjectRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件项目关联表
 * 
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:40:21
 */
@Mapper
public interface FileProjectRelationDao extends BaseMapper<FileProjectRelationEntity> {
	
}
