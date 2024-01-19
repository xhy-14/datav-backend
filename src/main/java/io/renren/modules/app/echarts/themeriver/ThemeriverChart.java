package io.renren.modules.app.echarts.themeriver;

import io.renren.common.exception.RRException;
import io.renren.modules.app.echarts.TextStyle;
import io.renren.modules.app.echarts.Title;
import io.renren.modules.app.entity.CSVEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ThemeriverChart {

    private Title title;

    private TextStyle textStyle;

    private Tooltip tooltip;

    private Legend legend;

    private SingleAxis singleAxis;

    private List<ThemeriverSeries> series;

    public ThemeriverChart(CSVEntity csvEntity) {

        if (csvEntity.getHeaders().size() < 2) {
            throw new RRException("数据格式错误");
        }

        this.textStyle = new TextStyle();
        this.textStyle.setFontSize(18);
        this.textStyle.setFontFamily("monspace");
        this.textStyle.setColor("black");
        this.title = new Title();
        this.title.setText("");
        this.title.setTextStyle(this.textStyle);

        this.legend = new Legend();
        this.singleAxis = new SingleAxis();
        this.tooltip = new Tooltip();
        this.series = new ArrayList<>();
        this.series.add(new ThemeriverSeries());

        List<Map<Object, Object>> rows = csvEntity.getRows();
        List<Object> headers = csvEntity.getHeaders();

        for (int i=0;i<rows.size();i++) {
            for (int j=1;j<headers.size();j++) {
                ArrayList<Object> dataItem = new ArrayList<>();
                dataItem.add(headers.get(j));
                dataItem.add(rows.get(i).get(headers.get(j)));
                dataItem.add(rows.get(i).get(headers.get(0)));
                this.series.get(0).getData().add(dataItem);
            }
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

    public SingleAxis getSingleAxis() {
        return singleAxis;
    }

    public void setSingleAxis(SingleAxis singleAxis) {
        this.singleAxis = singleAxis;
    }

    public List<ThemeriverSeries> getSeries() {
        return series;
    }

    public void setSeries(List<ThemeriverSeries> series) {
        this.series = series;
    }
}
