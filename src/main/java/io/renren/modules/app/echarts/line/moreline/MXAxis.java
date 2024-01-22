package io.renren.modules.app.echarts.line.moreline;

import io.renren.modules.app.echarts.XAxis;

import java.util.ArrayList;

public class MXAxis extends XAxis {

    private Boolean boundaryGap;

    public MXAxis() {
        this.boundaryGap = false;
        this.setType("category");
        this.setData(new ArrayList<>());
    }

    public Boolean getBoundaryGap() {
        return boundaryGap;
    }

    public void setBoundaryGap(Boolean boundaryGap) {
        this.boundaryGap = boundaryGap;
    }
}
