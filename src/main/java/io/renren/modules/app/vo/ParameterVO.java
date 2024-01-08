package io.renren.modules.app.vo;

import lombok.Data;

@Data
public class ParameterVO {
    /**
     * 参数id
     */
    private Long id;
    /**
     * 参数名称
     */
    private String name;
    /**
     * 参数类型id
     */
    private Long typeId;
    /**
     * 参数类型名
     */
    private String typeName;
    /**
     * 解析方法id
     */
    private Integer analyse;
    /**
     * 默认值
     */
    private String defaultValue;
}
