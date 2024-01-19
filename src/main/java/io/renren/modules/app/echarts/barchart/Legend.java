package io.renren.modules.app.echarts.barchart;

import lombok.Data;


public class Legend {
    private Boolean show;
    public Legend(){
        show = true;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }
}
