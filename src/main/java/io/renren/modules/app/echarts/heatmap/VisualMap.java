package io.renren.modules.app.echarts.heatmap;

public class VisualMap {

    private Integer min;

    private Integer max;

    private Boolean calculable;

    private String orient;

    private String left;

    private String bottom;

    public VisualMap() {
        this.min = 0;
        this.max = 50;
        this.calculable = true;
        this.orient = "horizontal";
        this.left = "center";
        this.bottom = "15%";
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Boolean getCalculable() {
        return calculable;
    }

    public void setCalculable(Boolean calculable) {
        this.calculable = calculable;
    }

    public String getOrient() {
        return orient;
    }

    public void setOrient(String orient) {
        this.orient = orient;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }
}
