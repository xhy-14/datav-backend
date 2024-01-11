package io.renren.modules.app.echarts.barchart;

import io.renren.modules.app.echarts.TextStyle;
import io.renren.modules.app.echarts.Title;
import io.renren.modules.app.echarts.xAxis;
import io.renren.modules.app.echarts.yAxis;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class BasicBarChart {

    private xAxis xAxis;

    private yAxis yAxis;

    private Title title;

    private TextStyle textStyle;

    public BasicBarChart() {
        this.xAxis = new xAxis();
        xAxis.setName("x轴");
        xAxis.setType("category");
        List<String> xData = new ArrayList<>();
        xData.add("列1");
        xData.add("列2");
        xAxis.setData(Collections.singletonList(xData));

        this.yAxis = new yAxis();
        yAxis.setName("y轴");
        yAxis.setType("value");

        this.textStyle = new TextStyle();
        textStyle.setColor("#9a60b4");
        textStyle.setFontSize(18);
        textStyle.setFontFamily("monospace");

        this.title = new Title();
        title.setText("标题");
        title.setTextStyle(textStyle);
    }

}
