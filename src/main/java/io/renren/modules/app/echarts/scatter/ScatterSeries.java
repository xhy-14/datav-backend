package io.renren.modules.app.echarts.scatter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author xiehanying
 */
@Data
public class ScatterSeries {
    private int symbolSize;
    private List<List<Object>> data;
    private String type;

    public ScatterSeries() {
        this.data = new ArrayList<>();
    }
}
