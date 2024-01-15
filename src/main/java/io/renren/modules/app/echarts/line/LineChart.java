package io.renren.modules.app.echarts.line;

import io.renren.common.exception.RRException;
import io.renren.modules.app.echarts.TextStyle;
import io.renren.modules.app.echarts.Title;
import io.renren.modules.app.echarts.XAxis;
import io.renren.modules.app.echarts.YAxis;
import io.renren.modules.app.entity.CSVEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiehanying
 */
public class LineChart {
    /**
     * x
     */
    private XAxis xAxis;

    /**
     * y
     */
    private YAxis yAxis;

    /**
     * 标题
     */
    private Title title;

    /**
     * 数据
     */
    private List<LineSeries> series;

    public LineChart() {
        xAxis = new XAxis();
        yAxis = new YAxis();
        title = new Title();
        series = new ArrayList<>();

        TextStyle textStyle = new TextStyle();

        xAxis.setType("category");
        xAxis.setName("x标题");

        yAxis.setType("value");
        yAxis.setName("y坐标轴");

        title.setText("标题");
        title.
        textStyle.setColor("black");
        textStyle.setFontSize(18);

        title.setTextStyle(textStyle);

        LineSeries lineSeries = new LineSeries();
        Integer[] data = {12, 24, 255, 236, 21};
        lineSeries.setData(Arrays.asList(data));

        series.add(lineSeries);
    }

    public void setData(CSVEntity csvEntity) {
        if(csvEntity.getHeaders().size() != 2) {
            throw new RRException("数据格式不正确!");
        }

        List<Object> data = new ArrayList<>();
        List<Object> headers = new ArrayList<>();

        // 数据
        for(int i=0; i<csvEntity.getRows().size(); i++) {
            headers.add(csvEntity.getRows().get(i).get(csvEntity.getHeaders().get(0)));
            data.add(csvEntity.getRows().get(i).get(csvEntity.getHeaders().get(1)));
        }
        this.getxAxis().setData(headers);
        this.getSeries().get(0).setData(data);
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

    public List<LineSeries> getSeries() {
        return series;
    }

    public void setSeries(List<LineSeries> series) {
        this.series = series;
    }
}
