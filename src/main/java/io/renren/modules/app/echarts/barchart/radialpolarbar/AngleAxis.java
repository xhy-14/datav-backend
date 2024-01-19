package io.renren.modules.app.echarts.barchart.radialpolarbar;

import io.renren.modules.app.echarts.XAxis;

import java.util.ArrayList;
import java.util.List;

public class AngleAxis {

    private String type;

    private Integer startAngle;

    private List<Object> data;

    public AngleAxis() {
        this.type = "category";
        this.startAngle = 90;
        this.data = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStartAngle() {
        return startAngle;
    }

    public void setStartAngle(Integer startAngle) {
        this.startAngle = startAngle;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
