package io.renren.modules.app.echarts.PieChart;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiehanying
 */
@Data
public class PieSeries {
    /**
     * 图表名
     */
    private String name;
    /**
     * series类型,这里是pie
     */
    private String type;

    /**
     * 圆的大小, 默认50%
     */
    private String radius;

    /**
     * 数据
     */
    private List<Object> data;

    public PieSeries() {
        this.data = new ArrayList<>();
    }
}
