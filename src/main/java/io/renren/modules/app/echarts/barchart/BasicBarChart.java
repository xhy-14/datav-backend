package io.renren.modules.app.echarts.barchart;

import io.renren.common.exception.RRException;
import io.renren.modules.app.echarts.TextStyle;
import io.renren.modules.app.echarts.Title;
import io.renren.modules.app.echarts.XAxis;
import io.renren.modules.app.echarts.YAxis;
import io.renren.modules.app.entity.CSVEntity;
import lombok.Data;

import java.util.*;


/**
 * @author xiehanying
 */
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

    }

    public void setData(CSVEntity csvEntity) {
        if(csvEntity.getHeaders().size() != 2) {
            throw new RRException("数据格式不正确!");
        }

        List<Object> headers = csvEntity.getHeaders();
        this.xAxis.setName((String) headers.get(0));
        this.yAxis.setName((String) headers.get(1));


        this.xAxis.setData(new ArrayList<>());
        this.series.add(new BasicBarSeries());
        this.series.get(0).setData(new ArrayList<>());
        List<Map<Object, Object>> rows = csvEntity.getRows();

        for (int i = 0;i < rows.size();i++) {
            this.xAxis.getData().add(rows.get(i).get(headers.get(0)));
            this.series.get(0).getData().add(rows.get(i).get(headers.get(1)));
        }
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
