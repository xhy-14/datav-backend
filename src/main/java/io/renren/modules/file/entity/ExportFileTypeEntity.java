package io.renren.modules.file.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 导出文件表
 * 
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:40:21
 */
@Data
@TableName("file_export_file_type")
public class ExportFileTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 导出文件类型ID
	 */
	@TableId
	private Long id;
	/**
	 * 文件类型名称
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
