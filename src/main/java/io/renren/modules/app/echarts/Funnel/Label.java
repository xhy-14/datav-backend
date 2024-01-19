package io.renren.modules.app.echarts.Funnel;

public class Label {

    private Boolean show;

    private String position;

    public Label() {
        this.show = true;
        this.position = "inside";
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
