package io.renren.modules.app.echarts.barchart;

import io.renren.modules.app.echarts.TextStyle;
import io.renren.modules.app.echarts.Title;
import io.renren.modules.app.echarts.XAxis;
import io.renren.modules.app.echarts.YAxis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicBarChart {

    private XAxis xAxis;

    private YAxis yAxis;

    private Title title;

    private TextStyle textStyle;

    private List<BasicBarSeries> series;

    public BasicBarChart() {
        xAxis = new XAxis();
        yAxis = new YAxis();
        title = new Title();
        series = new ArrayList<>();

        TextStyle textStyle = new TextStyle();
        xAxis.setType("category");
        xAxis.setName("x标题");

        String[] header = {"一", "二", "三", "四", "五"};
        xAxis.setData(Arrays.asList(header));

        this.yAxis = new YAxis();
        yAxis.setName("y轴");
        yAxis.setType("value");
        yAxis.setName("y坐标轴");

        title.setText("标题");
        textStyle.setColor("black");
        textStyle.setFontSize(18);
        textStyle.setFontFamily("monspace");
        this.textStyle = textStyle;

        title.setTextStyle(textStyle);

        BasicBarSeries basicBarSeries = new BasicBarSeries();
        Integer[] data = {12, 24, 255, 236, 21};
        basicBarSeries.setData(Arrays.asList(data));

        series.add(basicBarSeries);
    }

    public XAxis getxAxis() {
        return xAxis;
    }

    public void setxAxis(XAxis xAxis) {
        this.xAxis = xAxis;
    }

    public YAxis getyAxis() {
        return yAxis;
    }

    public void setyAxis(YAxis yAxis) {
        this.yAxis = yAxis;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public TextStyle getTextStyle() {
        return textStyle;
    }

    public void setTextStyle(TextStyle textStyle) {
        this.textStyle = textStyle;
    }

    public List<BasicBarSeries> getSeries() {
        return series;
    }

    public void setSeries(List<BasicBarSeries> series) {
        this.series = series;
    }
}
