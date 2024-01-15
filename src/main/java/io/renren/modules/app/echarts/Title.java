package io.renren.modules.app.echarts;

import lombok.Data;

@Data
public class Title {
    /**
     * 标题
     */
    private String text;


    /**
     * 标题字体
     */
    private TextStyle textStyle;

    /**
     * 标题位置
     */
    private String left;
}
