package io.renren.modules.app.echarts.candlestick;

import io.renren.common.exception.RRException;
import io.renren.modules.app.echarts.TextStyle;
import io.renren.modules.app.echarts.Title;
import io.renren.modules.app.echarts.XAxis;
import io.renren.modules.app.echarts.YAxis;
import io.renren.modules.app.entity.CSVEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CandlestickChart {

    private XAxis xAxis;

    private YAxis yAxis;

    private TextStyle textStyle;

    private Title title;

    private List<CandlestickSeries> series;

    public CandlestickChart(CSVEntity csvEntity) {
        //默认配置
        xAxis = new XAxis();
        yAxis = new YAxis();
        title = new Title();
        series = new ArrayList<>();

        TextStyle textStyle = new TextStyle();
        xAxis.setType("category");
        xAxis.setName("x标题");

        this.yAxis = new YAxis();

        yAxis.setType("category");
        yAxis.setName("y");

        title.setText("标题");
        textStyle.setColor("black");
        textStyle.setFontSize(18);
        textStyle.setFontFamily("monspace");
        this.textStyle = textStyle;

        title.setTextStyle(textStyle);

        List<Object> headers = csvEntity.getHeaders();
        List<Map<Object, Object>> rows = csvEntity.getRows();


        this.xAxis.setName((String) headers.get(0));

        this.xAxis.setData(new ArrayList<>());
        this.series.add(new CandlestickSeries());
        this.series.get(0).setType("candlestick");
        this.series.get(0).setData(new ArrayList<>());

        for (int i = 0; i < rows.size(); i++) {
            xAxis.getData().add(rows.get(i).get(headers.get(0)));
            ArrayList<Object> numbers = new ArrayList<>();
            for (int j = 1; j < 5; j++) {
                numbers.add(rows.get(i).get(headers.get(j)));
            }
            series.get(0).getData().add(numbers);
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

    public TextStyle getTextStyle() {
        return textStyle;
    }

    public void setTextStyle(TextStyle textStyle) {
        this.textStyle = textStyle;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public List<CandlestickSeries> getSeries() {
        return series;
    }

    public void setSeries(List<CandlestickSeries> series) {
        this.series = series;
    }
}
