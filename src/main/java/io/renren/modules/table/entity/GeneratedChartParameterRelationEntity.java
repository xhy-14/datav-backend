package io.renren.modules.table.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 已生成图表-参数关联表
 * 
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:36:30
 */
@Data
@TableName("data_generated_chart_parameter_relation")
public class GeneratedChartParameterRelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 已生成图表id
	 */
	private Long generatedChartId;
	/**
	 * 参数id
	 */
	private Long parameterId;
	/**
	 * 参数内容
	 */
	private String content;
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
