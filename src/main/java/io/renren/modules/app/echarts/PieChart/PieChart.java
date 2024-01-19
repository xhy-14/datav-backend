package io.renren.modules.app.echarts.PieChart;

import io.renren.common.exception.RRException;
import io.renren.modules.app.echarts.Legend;
import io.renren.modules.app.echarts.TextStyle;
import io.renren.modules.app.echarts.Title;
import io.renren.modules.app.echarts.Tooltip;
import io.renren.modules.app.echarts.line.LineSeries;
import io.renren.modules.app.entity.CSVEntity;
import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiehanying
 */
public class PieChart {
    /**
     * 标题
     */
    private Title title;

    /**
     * 提示栏
     */
    private Tooltip tooltip;

    private Legend legend;
    /**
     * 数据
     */
    private List<PieSeries> series;

    public PieChart(CSVEntity csvEntity) {
        // 设置标题
        title = new Title();
        title.setText("标题");
        title.setLeft("center");
        TextStyle textStyle = new TextStyle();
        textStyle.setColor("black");
        textStyle.setFontSize(18);
        title.setTextStyle(textStyle);

        // 设置提示框
        tooltip = new Tooltip();
        tooltip.setShow(true);
        tooltip.setTrigger("item");

        // 设置注释
        legend = new Legend();
        legend.setOrient("vertical");
        legend.setLeft("left");

        // 设置series
        series = new ArrayList<>();
        PieSeries pieSeries = new PieSeries();
        pieSeries.setName("图表");
        pieSeries.setRadius("50%");
        pieSeries.setType("pie");

        if(csvEntity.getHeaders().size() < 1) {
            throw new RRException("数据格式错误");
        }

        List<Object> data = new ArrayList<>();

        for(int i=0; i<csvEntity.getRows().size(); i++) {
            // 获取所有行
            Map<Object, Object> map = new HashMap<>();
            map.put("name", csvEntity.getRows().get(i).get(csvEntity.getHeaders().get(0)));
            map.put("value", csvEntity.getRows().get(i).get(csvEntity.getHeaders().get(1)));
            data.add(map);
        }

        pieSeries.setData(data);

        series.add(pieSeries);
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
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

    public List<PieSeries> getSeries() {
        return series;
    }

    public void setSeries(List<PieSeries> series) {
        this.series = series;
    }
}
