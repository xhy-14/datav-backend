package io.renren.modules.chart.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 参数类型表
 * 
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:31:13
 */
@Data
@TableName("chart_parameter_type")
public class ParameterTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 参数类型ID
	 */
	@TableId
	private Long id;
	/**
	 * 参数类型名称
	 */
	private String typeName;
	/**
	 * 解析方式id
	 */
	private Integer analyse;
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
