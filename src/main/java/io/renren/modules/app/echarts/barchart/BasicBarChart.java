package io.renren.modules.app.echarts.barchart;

import com.github.abel533.echarts.Basic;
import io.renren.modules.app.echarts.TextStyle;
import io.renren.modules.app.echarts.Title;
import io.renren.modules.app.echarts.line.LineSeries;
import io.renren.modules.app.echarts.xAxis;
import io.renren.modules.app.echarts.yAxis;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BasicBarChart {

    private xAxis xAxis;

    private yAxis yAxis;

    private Title title;

    private TextStyle textStyle;

    private List<BasicBarSeries> series;

    public BasicBarChart() {
        xAxis = new xAxis();
        yAxis = new yAxis();
        title = new Title();
        series = new ArrayList<>();

        TextStyle textStyle = new TextStyle();

        xAxis.setType("category");
        xAxis.setName("x标题");

        String[] header = {"一", "二", "三", "四", "五"};
        xAxis.setData(Arrays.asList(header));

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

    public io.renren.modules.app.echarts.xAxis getxAxis() {
        return xAxis;
    }

    public void setxAxis(io.renren.modules.app.echarts.xAxis xAxis) {
        this.xAxis = xAxis;
    }

    public io.renren.modules.app.echarts.yAxis getyAxis() {
        return yAxis;
    }

    public void setyAxis(io.renren.modules.app.echarts.yAxis yAxis) {
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
