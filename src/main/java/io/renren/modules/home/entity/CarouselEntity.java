package io.renren.modules.home.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 轮播表
 * 
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:43:50
 */
@Data
@TableName("home_carousel")
public class CarouselEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 轮播ID
	 */
	@TableId
	private Long id;
	/**
	 * 文件ID
	 */
	private Long fileId;
	/**
	 * 内容
	 */
	private String content;
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
