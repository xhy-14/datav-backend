package io.renren.modules.app.echarts.radar;

import io.renren.common.exception.RRException;
import io.renren.modules.app.echarts.TextStyle;
import io.renren.modules.app.echarts.Title;
import io.renren.modules.app.entity.CSVEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RadarChart {

    private Title title;

    private TextStyle textStyle;

    private Legend legend;

    private Radar radar;

    private List<RadarSeries> series;

    public RadarChart(CSVEntity csvEntity) {
        if (csvEntity.getHeaders().size() < 2) {
            throw new RRException("数据格式错误");
        }
        this.textStyle = new TextStyle();
        this.textStyle.setColor("black");
        this.textStyle.setFontSize(18);
        this.textStyle.setFontFamily("monspace");
        this.title = new Title();
        this.title.setText("标题");
        this.title.setTextStyle(textStyle);
        this.legend = new Legend();
        this.radar = new Radar();
        this.series = new ArrayList<>();
        this.series.add(new RadarSeries());
        this.series.get(0).setType("radar");
        this.series.get(0).setName("");

        List<Object> headers = csvEntity.getHeaders();
        List<Map<Object, Object>> rows = csvEntity.getRows();

        for (int i=1;i< headers.size();i++) {
            HashMap<Object, Object> indicatorObject = new HashMap<>();
            indicatorObject.put("name", headers.get(i));
            this.radar.getIndicator().add(indicatorObject);
        }


        for (int i=0;i< rows.size();i++) {
            RadarData radarData = new RadarData();
            radarData.setName((String) rows.get(i).get(headers.get(0)));
            radarData.setValue(new ArrayList<>());
            for (int j=1;j<headers.size();j++) {
                radarData.getValue().add(rows.get(i).get(headers.get(j)));
            }
            this.series.get(0).getData().add(radarData);
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

    public Legend getLegend() {
        return legend;
    }

    public void setLegend(Legend legend) {
        this.legend = legend;
    }

    public Radar getRadar() {
        return radar;
    }

    public void setRadar(Radar radar) {
        this.radar = radar;
    }

    public List<RadarSeries> getSeries() {
        return series;
    }

    public void setSeries(List<RadarSeries> series) {
        this.series = series;
    }
}
