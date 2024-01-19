package io.renren.modules.app.echarts.radar;

import io.renren.common.utils.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RadarData {

    private Object name;

    private List<Object> value;

    public RadarData() {
        this.value = new ArrayList<>();
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public List<Object> getValue() {
        return value;
    }

    public void setValue(List<Object> value) {
        this.value = value;
    }
}
