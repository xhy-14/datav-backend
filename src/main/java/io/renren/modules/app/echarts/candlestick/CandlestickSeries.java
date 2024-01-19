package io.renren.modules.app.echarts.candlestick;

import java.util.List;

public class CandlestickSeries {

    private String type;

    private List<Object> data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
