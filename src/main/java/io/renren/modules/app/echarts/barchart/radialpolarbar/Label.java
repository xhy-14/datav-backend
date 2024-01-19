package io.renren.modules.app.echarts.barchart.radialpolarbar;

public class Label {

    private Boolean show;

    private String position;

    private String formatter;

    public Label() {
        this.show = true;
        this.position = "middle";
        this.formatter = "{b}: {c}";
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

    public String getFormatter() {
        return formatter;
    }

    public void setFormatter(String formatter) {
        this.formatter = formatter;
    }
}
