package io.renren.modules.table.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 元数据表
 * 
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:36:30
 */
@Data
@TableName("data_metadata")
public class MetadataEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 元数据ID
	 */
	@TableId
	private Long id;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 文件id
	 */
	private Long fileId;
	/**
	 * 数据集文件
	 */
	private Long dataFileId;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 描述
	 */
	private String depiction;
	/**
	 * 是否删除
	 */
	private Integer isDelete;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
