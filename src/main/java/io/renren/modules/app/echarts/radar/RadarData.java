package io.renren.modules.app.echarts.radar;

import io.renren.common.utils.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RadarData {

    private String name;

    private List<Object> value;

    public RadarData() {
        this.value = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getValue() {
        return value;
    }

    public void setValue(List<Object> value) {
        this.value = value;
    }
}
