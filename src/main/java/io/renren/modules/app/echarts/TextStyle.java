package io.renren.modules.app.echarts;

import lombok.Data;

@Data
public class TextStyle {
    /**
     * 文字颜色
     */
    private String color;

    /**
     * 字体大小
     */
    private int fontSize;

    /**
     * 文字字体
     */
    private String fontFamily;
}
