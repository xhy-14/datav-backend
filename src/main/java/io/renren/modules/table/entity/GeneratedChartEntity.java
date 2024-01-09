package io.renren.modules.table.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 已生成图表表
 * 
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:36:30
 */
@Data
@TableName("data_generated_chart")
public class GeneratedChartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 已生成图表ID
	 */
	@TableId
	private Long id;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 图表类型id
	 */
	private Long chartTypeId;
	/**
	 * 元数据id
	 */
	private Long metadataId;
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
