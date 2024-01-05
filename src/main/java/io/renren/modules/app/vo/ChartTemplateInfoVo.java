package io.renren.modules.app.vo;

import lombok.Data;

@Data
public class ChartTemplateInfoVo {
    /**
     * 图表模板id
     */
    private Long id;

    /**
     * 图表模板封面
     */
    private String cover;

    /**
     * 图表名称
     */
    private String name;
}
