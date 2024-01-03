package io.renren.modules.home.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 教程表
 * 
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:43:50
 */
@Data
@TableName("home_tutorial")
public class TutorialEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 教程ID
	 */
	@TableId
	private Long id;
	/**
	 * 文件ID
	 */
	private Long fileId;
	/**
	 * 小标题
	 */
	private String title;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 步骤顺序
	 */
	private Integer step;
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
