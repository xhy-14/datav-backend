package io.renren.modules.app.echarts.barchart.radialpolarbar;

import io.renren.common.exception.RRException;
import io.renren.modules.app.echarts.TextStyle;
import io.renren.modules.app.echarts.Title;
import io.renren.modules.app.entity.CSVEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RadialPolarBarChart {

    private List<Title> title;

    private Polar polar;

    private RadiusAxis radiusAxis;

    private AngleAxis angleAxis;

    private Series series;

    public RadialPolarBarChart(CSVEntity csvEntity) {
        if (csvEntity.getHeaders().size() != 2){
            throw new RRException("数据格式错误");
        }
        this.polar = new Polar();
        this.angleAxis = new AngleAxis();
        this.series = new Series();
        this.radiusAxis = new RadiusAxis();
        TextStyle textStyle = new TextStyle();
        textStyle.setColor("black");
        textStyle.setFontSize(18);
        textStyle.setFontFamily("monspace");
        Title title1 = new Title();
        title1.setText("极坐标柱状图");
        title1.setTextStyle(textStyle);
        this.title = new ArrayList<>();
        this.title.add(title1);

        List<Object> headers = csvEntity.getHeaders();
        List<Map<Object, Object>> rows = csvEntity.getRows();

        for (int i=0;i<rows.size();i++) {
            this.angleAxis.getData().add(rows.get(i).get(headers.get(0)));
            this.series.getData().add(rows.get(i).get(headers.get(1)));
        }

    }

    public List<Title> getTitle() {
        return title;
    }

    public void setTitle(List<Title> title) {
        this.title = title;
    }

    public Polar getPolar() {
        return polar;
    }

    public void setPolar(Polar polar) {
        this.polar = polar;
    }

    public RadiusAxis getRadiusAxis() {
        return radiusAxis;
    }

    public void setRadiusAxis(RadiusAxis radiusAxis) {
        this.radiusAxis = radiusAxis;
    }

    public AngleAxis getAngleAxis() {
        return angleAxis;
    }

    public void setAngleAxis(AngleAxis angleAxis) {
        this.angleAxis = angleAxis;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }
}
