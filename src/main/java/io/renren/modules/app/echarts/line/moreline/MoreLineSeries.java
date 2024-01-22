package io.renren.modules.app.echarts.line.moreline;

import java.util.ArrayList;
import java.util.List;

public class MoreLineSeries {

    private Object name;

    private String type;

    private String stack;

    private List<Object> data;

    public MoreLineSeries() {
        this.type = "line";
        this.stack = "total";
        this.data = new ArrayList<>();
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
