package io.renren.modules.app.echarts.line;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiehanying
 */
@Data
public class LineSeries {
    /**
     * series类型,这里是line
     */
    private String type;

    /**
     * 数据
     */
    private List<Object> data;

    public LineSeries() {
        this.type = "line";
        this.data = new ArrayList<>();
    }
}
