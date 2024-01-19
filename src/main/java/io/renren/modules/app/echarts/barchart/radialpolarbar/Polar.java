package io.renren.modules.app.echarts.barchart.radialpolarbar;

import java.util.ArrayList;
import java.util.List;

public class Polar {
    private List<Object> radius;

    public Polar() {
        this.radius = new ArrayList<>();
        this.radius.add(30);
        this.radius.add("80%");
    }

    public List<Object> getRadius() {
        return radius;
    }

    public void setRadius(List<Object> radius) {
        this.radius = radius;
    }
}
