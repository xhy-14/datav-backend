package io.renren.modules.app.echarts.heatmap;

import io.renren.modules.app.echarts.TextStyle;
import io.renren.modules.app.echarts.Title;
import io.renren.modules.app.echarts.XAxis;
import io.renren.modules.app.echarts.YAxis;
import io.renren.modules.app.entity.CSVEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Heatmap {

    private Title title;

    private TextStyle textStyle;

    private Tooltip tooltip;

    private Grid grid;

    private XAxis xAxis;

    private XAxis yAxis;

    private VisualMap visualMap;

    private List<HeatMapSeries> series;

    public Heatmap(CSVEntity csvEntity) {
        this.tooltip = new Tooltip();
        this.grid = new Grid();
        this.visualMap = new VisualMap();
        this.xAxis = new XAxis();
        this.xAxis.setType("category");
        this.xAxis.setData(new ArrayList<>());
        this.yAxis = new XAxis();
        this.yAxis.setType("category");
        this.yAxis.setData(new ArrayList<>());

        this.textStyle = new TextStyle();
        this.textStyle.setFontSize(18);
        this.textStyle.setFontFamily("monspace");
        this.textStyle.setColor("black");
        this.title = new Title();
        this.title.setText("");
        this.title.setTextStyle(this.textStyle);

        this.series = new ArrayList<>();
        this.series.add(new HeatMapSeries());

        List<Object> headers = csvEntity.getHeaders();
        List<Map<Object, Object>> rows = csvEntity.getRows();

        for (Map<Object, Object> row : rows) {
            this.xAxis.getData().add(row.get(headers.get(0)));
        }
        for (int i =1 ; i<headers.size();i++) {
            this.yAxis.getData().add(headers.get(i));
        }

        for (int i = 0;i < rows.size(); i++) {
            for (int j = 0;j < headers.size()-1;j++) {
                ArrayList<Object> dataItem = new ArrayList<>();
                dataItem.add(i);
                dataItem.add(j);
                dataItem.add(rows.get(i).get(headers.get(j+1)));
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

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public XAxis getxAxis() {
        return xAxis;
    }

    public void setxAxis(XAxis xAxis) {
        this.xAxis = xAxis;
    }

    public XAxis getyAxis() {
        return yAxis;
    }

    public void setyAxis(XAxis yAxis) {
        this.yAxis = yAxis;
    }

    public VisualMap getVisualMap() {
        return visualMap;
    }

    public void setVisualMap(VisualMap visualMap) {
        this.visualMap = visualMap;
    }

    public List<HeatMapSeries> getSeries() {
        return series;
    }

    public void setSeries(List<HeatMapSeries> series) {
        this.series = series;
    }
}
