package io.renren.modules.table.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 函数处理表
 * 
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:36:30
 */
@Data
@TableName("data_function_process")
public class FunctionProcessEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 函数处理ID
	 */
	@TableId
	private Long id;
	/**
	 * 处理类型名称
	 */
	private String name;
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
