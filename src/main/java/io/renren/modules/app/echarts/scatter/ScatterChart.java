package io.renren.modules.app.echarts.scatter;

import io.renren.modules.app.echarts.*;
import io.renren.modules.app.entity.CSVEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiehanying
 */
public class ScatterChart {
    private Title title;
    private XAxis xAxis;
    private YAxis yAxis;
    private Tooltip tooltip;
    private List<ScatterSeries> series;

    public ScatterChart(CSVEntity csvEntity) {
        xAxis = new XAxis();
        yAxis = new YAxis();
        title = new Title();
        series = new ArrayList<>();

        // x轴
        xAxis.setType("category");
        xAxis.setName("x标题");

        // y轴
        yAxis.setType("value");
        yAxis.setName("y坐标轴");

        // 设置标题
        title = new Title();
        title.setText("标题");
        title.setLeft("center");
        TextStyle textStyle = new TextStyle();
        textStyle.setColor("black");
        textStyle.setFontSize(18);
        title.setTextStyle(textStyle);

        // 设置提示框
        tooltip = new Tooltip();
        tooltip.setShow(true);
        tooltip.setTrigger("item");

        ScatterSeries scatterSeries = new ScatterSeries();
        List<List<Object>> data = new ArrayList<>();

        for(int i=0; i<csvEntity.getRows().size(); i++) {
            // 获取所有行
            List<Object> row = new ArrayList<>();
            row.add(csvEntity.getRows().get(i).get(csvEntity.getHeaders().get(0)));
            row.add(csvEntity.getRows().get(i).get(csvEntity.getHeaders().get(1)));
            data.add(row);
        }
        scatterSeries.setSymbolSize(20);
        scatterSeries.setType("scatter");
        scatterSeries.setData(data);

        series.add(scatterSeries);
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
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

    public Tooltip getTooltip() {
        return tooltip;
    }

    public void setTooltip(Tooltip tooltip) {
        this.tooltip = tooltip;
    }

    public List<ScatterSeries> getSeries() {
        return series;
    }

    public void setSeries(List<ScatterSeries> series) {
        this.series = series;
    }
}
