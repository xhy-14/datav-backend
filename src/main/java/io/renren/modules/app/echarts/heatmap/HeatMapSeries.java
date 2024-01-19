package io.renren.modules.app.echarts.heatmap;

import io.renren.modules.app.echarts.themeriver.Emphasis;

import java.util.ArrayList;
import java.util.List;

public class HeatMapSeries {

    private String type;

    private List<Object> data;

    private Label label;

    private Emphasis emphasis;

    public HeatMapSeries() {
        this.type = "heatmap";
        this.data = new ArrayList<>();
        this.label = new Label();
        this.emphasis = new Emphasis();
    }

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

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Emphasis getEmphasis() {
        return emphasis;
    }

    public void setEmphasis(Emphasis emphasis) {
        this.emphasis = emphasis;
    }
}
