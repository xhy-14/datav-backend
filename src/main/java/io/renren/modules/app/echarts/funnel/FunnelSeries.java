package io.renren.modules.app.echarts.funnel;

import java.util.ArrayList;
import java.util.List;

public class FunnelSeries {

    private String name;

    private String type;

    private Label label;

    private List<Object> data;

    public FunnelSeries() {
        this.name = "";
        this.label = new Label();
        this.type = "funnel";
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

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
