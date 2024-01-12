package io.renren.modules.app.echarts.line;

import io.renren.modules.app.echarts.TextStyle;
import io.renren.modules.app.echarts.Title;
import io.renren.modules.app.echarts.xAxis;
import io.renren.modules.app.echarts.yAxis;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiehanying
 */
@Data
public class LineChart {
    /**
     * x
     */
    private xAxis xAxis;

    /**
     * y
     */
    private yAxis yAxis;

    /**
     * 标题
     */
    private Title title;


    /**
     * 数据
     */
    private List<LineSeries> series;

    public LineChart() {
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

        title.setTextStyle(textStyle);

        LineSeries lineSeries = new LineSeries();
        Integer[] data = {12, 24, 255, 236, 21};
        lineSeries.setData(Arrays.asList(data));

        series.add(lineSeries);
    }
}
