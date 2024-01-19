package io.renren.modules.app.echarts.radar;

import io.renren.common.utils.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Radar {

    private List<HashMap<Object, Object>> indicator;

    public Radar() {
        this.indicator = new ArrayList<>();
    }

    public List<HashMap<Object, Object>> getIndicator() {
        return indicator;
    }

    public void setIndicator(List<HashMap<Object, Object>> indicator) {
        this.indicator = indicator;
    }
}
