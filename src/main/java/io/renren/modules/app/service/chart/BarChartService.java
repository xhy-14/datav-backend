package io.renren.modules.app.service.chart;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.R;
import io.renren.modules.app.echarts.barchart.BasicBarChart;
import io.renren.modules.table.entity.GeneratedChartParameterRelationEntity;

public interface BarChartService extends IService<GeneratedChartParameterRelationEntity> {
    /**
     * 获取柱状图默认参数
     * @return
     */
    R getBasicdefaultValue();

    /**
     * 保存已生成图表参数
     * @param basicBarChart
     * @param generatedChartId
     * @return
     */
    R saveGeneratedChartParameter(BasicBarChart basicBarChart, Long generatedChartId);

    /**
     * 获取图表参数
     * @param generatedChartId
     * @return
     */
    R getParameterByChartId(Long generatedChartId);
}
