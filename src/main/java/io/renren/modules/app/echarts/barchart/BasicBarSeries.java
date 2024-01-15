package io.renren.modules.app.echarts.barchart;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BasicBarSeries {

    /**
     * series类型,这里是line
     */
    private String type;

    /**
     * 数据
     */
    private List<Object> data;

    public BasicBarSeries() {
        this.type = "bar";
        this.data = new ArrayList<>();
    }

}
