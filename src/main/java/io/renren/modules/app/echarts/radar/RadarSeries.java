package io.renren.modules.app.echarts.radar;

import java.util.ArrayList;
import java.util.List;

public class RadarSeries {

    private String name;

    private String type;

    private List<RadarData> data;

    public RadarSeries() {
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<RadarData> getData() {
        return data;
    }

    public void setData(List<RadarData> data) {
        this.data = data;
    }
}
