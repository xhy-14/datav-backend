package io.renren.modules.menber.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 套餐表
 * 
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:46:46
 */
@Data
@TableName("menber_combo")
public class ComboEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 套餐ID
	 */
	@TableId
	private Long id;
	/**
	 * 套餐名称，唯一且不能为空
	 */
	private String name;
	/**
	 * 价格
	 */
	private BigDecimal price;
	/**
	 * 时长
	 */
	private Integer term;
	/**
	 * 折扣
	 */
	private BigDecimal discount;
	/**
	 * 是否删除，默认为0表示未删除
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
