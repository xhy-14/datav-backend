package io.renren.modules.app.echarts.barchart.radialpolarbar;

import java.util.ArrayList;
import java.util.List;

public class Series {
    private String type;

    private String coordinateSystem;

    private List<Object> data;

    private Label label;

    public Series() {
        this.type = "bar";
        this.coordinateSystem = "polar";
        this.label = new Label();
        this.data = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCoordinateSystem() {
        return coordinateSystem;
    }

    public void setCoordinateSystem(String coordinateSystem) {
        this.coordinateSystem = coordinateSystem;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
}
