package io.renren.modules.app.echarts.barchart;

import io.renren.common.exception.RRException;
import io.renren.modules.app.echarts.TextStyle;
import io.renren.modules.app.echarts.Title;
import io.renren.modules.app.echarts.XAxis;
import io.renren.modules.app.echarts.YAxis;
import io.renren.modules.app.entity.CSVEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MoreBarChart{

    private XAxis xAxis;

    private YAxis yAxis;

    private Title title;

    private TextStyle textStyle;

    private Legend legend;

    private List<MoreBarSeries> series;


    public MoreBarChart() {
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
        yAxis.setName("y");

        title.setText("标题");
        textStyle.setColor("black");
        textStyle.setFontSize(18);
        textStyle.setFontFamily("monspace");
        this.textStyle = textStyle;

        title.setTextStyle(textStyle);

        legend = new Legend();

    }

    public void setData(CSVEntity csvEntity) {
        List<Object> headers = csvEntity.getHeaders();
        List<Map<Object, Object>> rows = csvEntity.getRows();
        if (headers.size() < 1) {
            throw new RRException("数据格式错误");
        }

        this.getxAxis().setData(new ArrayList<>());
        this.getxAxis().setName((String) headers.get(0));
        this.series = new ArrayList<>();

        for (int i=0;i<rows.size();i++) {
            this.getxAxis().getData().add(rows.get(i).get(headers.get(0)));
        }

        for (int i=1;i<headers.size();i++) {
            MoreBarSeries moreBarSeries = new MoreBarSeries();
            moreBarSeries.setType("bar");
            moreBarSeries.setName(headers.get(i));
            moreBarSeries.setData(new ArrayList<>());
            for (int j=0;j < rows.size();j++) {
                moreBarSeries.getData().add(rows.get(j).get(headers.get(i)));
            }
            this.series.add(moreBarSeries);
        }
    }

    public Legend getLegend() {
        return legend;
    }

    public void setLegend(Legend legend) {
        this.legend = legend;
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

    public List<MoreBarSeries> getSeries() {
        return series;
    }

    public void setSeries(List<MoreBarSeries> series) {
        this.series = series;
    }
}
