package io.renren.modules.app.echarts.line.moreline;



import io.renren.modules.app.echarts.TextStyle;
import io.renren.modules.app.echarts.Title;
import io.renren.modules.app.echarts.Tooltip;
import io.renren.modules.app.echarts.YAxis;
import io.renren.modules.app.echarts.barchart.Legend;
import io.renren.modules.app.entity.CSVEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MoreLineChart {

    private Title title;

    private TextStyle textStyle;

    private Tooltip tooltip;

    private Legend legend;

    private MXAxis xAxis;

    private YAxis yAxis;

    private List<MoreLineSeries> series;

    public MoreLineChart(CSVEntity csvEntity)  {

        tooltip = new Tooltip();
        tooltip.setShow(true);
        tooltip.setTrigger("axis");

        legend = new Legend();

        xAxis = new MXAxis();
        yAxis = new YAxis();
        title = new Title();
        series = new ArrayList<>();

        TextStyle textStyle = new TextStyle();

        yAxis.setType("value");

        title.setText("标题");
        textStyle.setColor("black");
        textStyle.setFontSize(18);
        textStyle.setFontFamily("monspace");
        this.textStyle = textStyle;

        title.setTextStyle(textStyle);

        List<Map<Object, Object>> rows = csvEntity.getRows();
        List<Object> headers = csvEntity.getHeaders();

        for (int i = 1 ; i < headers.size() ; i++) {
            xAxis.getData().add(headers.get(i));
        }

        for (int i = 0 ; i < rows.size() ; i++) {
            MoreLineSeries moreLineSeries = new MoreLineSeries();
            moreLineSeries.setName(rows.get(i).get(headers.get(0)));
            for (int j = 1 ; j < headers.size() ; j++) {
                moreLineSeries.getData().add(rows.get(i).get(headers.get(j)));
            }
            series.add(moreLineSeries);
        }

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

    public Tooltip getTooltip() {
        return tooltip;
    }

    public void setTooltip(Tooltip tooltip) {
        this.tooltip = tooltip;
    }

    public Legend getLegend() {
        return legend;
    }

    public void setLegend(Legend legend) {
        this.legend = legend;
    }

    public MXAxis getxAxis() {
        return xAxis;
    }

    public void setxAxis(MXAxis xAxis) {
        this.xAxis = xAxis;
    }

    public YAxis getyAxis() {
        return yAxis;
    }

    public void setyAxis(YAxis yAxis) {
        this.yAxis = yAxis;
    }

    public List<MoreLineSeries> getSeries() {
        return series;
    }

    public void setSeries(List<MoreLineSeries> series) {
        this.series = series;
    }
}
