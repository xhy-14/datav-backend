package io.renren.modules.app.service.data;

import io.renren.common.utils.R;
import io.renren.modules.app.dto.SaveGeneratedChartDTO;

import javax.servlet.http.HttpServletRequest;

public interface GeneratedChartService {

    /**
     * 保存已生成图表
     * @param request
     * @param dto
     * @return
     */
    R saveGeneratedChart(HttpServletRequest request, SaveGeneratedChartDTO dto);

    /**
     * 查询是否存在该已生成图表
     * @param chartId
     * @return
     */
    Boolean existsChartId(Long chartId);

}
