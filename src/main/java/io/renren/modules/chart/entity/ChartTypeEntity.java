package io.renren.modules.chart.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 图表类型表
 * 
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:31:13
 */
@Data
@TableName("chart_chart_type")
public class ChartTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 图表类型ID
	 */
	@TableId
	private Long id;
	/**
	 * 图标文件id
	 */
	private Long coverId;
	/**
	 * 图表类型名称
	 */
	private String name;
	/**
	 * 配置文件
	 */
	private String config;
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
