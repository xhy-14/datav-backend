package io.renren.modules.app.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.R;
import io.renren.modules.app.dto.SaveGeneratedChartDTO;
import io.renren.modules.app.dto.UpdateGeneratedChartDTO;
import io.renren.modules.table.entity.GeneratedChartEntity;

import javax.servlet.http.HttpServletRequest;

public interface GeneratedChartService extends IService<GeneratedChartEntity> {
    /**
     * 保存已生成图表
     * @param request
     * @param saveGeneratedChartDTO
     * @return
     */
    R saveGeneratedChart(HttpServletRequest request, SaveGeneratedChartDTO saveGeneratedChartDTO);

    /**
     * 删除已生成图表
     * @param request
     * @param generatedChartId
     * @return
     */
    R deleteGeneratedChart(HttpServletRequest request, Long generatedChartId);

    /**
     * 修改已生成图表
     * @param request
     * @param updateGeneratedChartDTO
     * @return
     */
    R updateGeneratedChart(HttpServletRequest request, UpdateGeneratedChartDTO updateGeneratedChartDTO);

    /**
     * 查询我的已生成图表
     * @param request
     * @return
     */
    R listMyGeneratedChart(HttpServletRequest request);
}
