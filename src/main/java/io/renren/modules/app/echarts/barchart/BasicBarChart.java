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

@Data
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

        title.setTextStyle(textStyle);

        BasicBarSeries basicBarSeries = new BasicBarSeries();
        Integer[] data = {12, 24, 255, 236, 21};
        basicBarSeries.setData(Arrays.asList(data));

        series.add(basicBarSeries);
    }

}
