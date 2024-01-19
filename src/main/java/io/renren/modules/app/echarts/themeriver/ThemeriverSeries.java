package io.renren.modules.app.echarts.themeriver;

import java.util.ArrayList;
import java.util.List;

public class ThemeriverSeries {

    private String type;

    private Emphasis emphasis;

    private List<List<Object>> data;

    public ThemeriverSeries() {
        this.type = "themeRiver";
        this.emphasis = new Emphasis();
        this.data = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Emphasis getEmphasis() {
        return emphasis;
    }

    public void setEmphasis(Emphasis emphasis) {
        this.emphasis = emphasis;
    }

    public List<List<Object>> getData() {
        return data;
    }

    public void setData(List<List<Object>> data) {
        this.data = data;
    }
}
