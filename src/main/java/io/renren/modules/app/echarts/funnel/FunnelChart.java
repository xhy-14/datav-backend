package io.renren.modules.app.echarts.funnel;

import io.renren.common.exception.RRException;
import io.renren.modules.app.echarts.TextStyle;
import io.renren.modules.app.echarts.Title;
import io.renren.modules.app.echarts.themeriver.Legend;
import io.renren.modules.app.echarts.themeriver.Tooltip;
import io.renren.modules.app.entity.CSVEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FunnelChart {

    private Title title;

    private TextStyle textStyle;

    private Tooltip tooltip;

    private Legend legend;

    private List<FunnelSeries> series;

    public FunnelChart(CSVEntity csvEntity) {
        this.tooltip = new Tooltip();
        this.tooltip.setTrigger("item");
        this.legend = new Legend();

        this.textStyle = new TextStyle();
        this.textStyle.setFontSize(18);
        this.textStyle.setFontFamily("monspace");
        this.textStyle.setColor("black");
        this.title = new Title();
        this.title.setText("");
        this.title.setTextStyle(this.textStyle);

        this.series = new ArrayList<>();
        this.series.add(new FunnelSeries());

        List<Object> headers = csvEntity.getHeaders();
        List<Map<Object, Object>> rows = csvEntity.getRows();

        if (headers.size() != 2) {
            throw new RRException("数据格式错误");
        }

        for (int i=0;i<rows.size();i++) {
            HashMap<Object, Object> dataItem = new HashMap<>();
            dataItem.put("name", rows.get(i).get(headers.get(0)));
            dataItem.put("value", rows.get(i).get(headers.get(1)));
            this.series.get(0).getData().add(dataItem);
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

    public List<FunnelSeries> getSeries() {
        return series;
    }

    public void setSeries(List<FunnelSeries> series) {
        this.series = series;
    }
}
