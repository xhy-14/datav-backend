package io.renren.modules.app.vo.table;

import lombok.Data;

@Data
public class TableVo {
    /**
     * 图表id
     */
    private long id;

    /**
     * 数据集名
     */
    private String name;

    /**
     * 用户id
     */
    private long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 数据表文件id
     */
    private long fileID;

    /**
     * 数据表文件地址
     */
    private String tableUrl;

    /**
     * 描述
     */
    private String depiction;
}
