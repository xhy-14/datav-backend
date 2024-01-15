package io.renren.modules.app.echarts;

import lombok.Data;

import java.util.List;

/**
 * @author xiehanying
 */
@Data
public class XAxis {

    /**
     * x轴类型
     */
    private String type;

    /**
     * x轴数据
     */
    private List<Object> data;

    /**
     * x轴名
     */
    private String name;
}
