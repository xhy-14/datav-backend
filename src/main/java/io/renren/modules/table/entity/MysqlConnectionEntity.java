package io.renren.modules.table.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * mysql连接表
 * 
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:36:30
 */
@Data
@TableName("data_mysql_connection")
public class MysqlConnectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 连接ID
	 */
	@TableId
	private Long id;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 连接名
	 */
	private String name;
	/**
	 * 主机
	 */
	private String host;
	/**
	 * 端口
	 */
	private String port;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 数据库名
	 */
	private String databaseName;
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

	/**
	 * 数据连接驱动类
	 */
	private String driver;
}
