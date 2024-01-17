package io.renren.modules.app.echarts;

import lombok.Data;

/**
 * @author xiehanying
 */
@Data
public class Tooltip {
    /**
     * 提示框是否展示
     */
    private boolean show;

    /**
     * 提示显示类型 item, none, axis
     */
    private String trigger;
}
