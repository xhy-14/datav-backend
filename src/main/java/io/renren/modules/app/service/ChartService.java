package io.renren.modules.app.service;

import io.renren.common.utils.R;
import io.renren.modules.app.entity.CSVEntity;
import io.renren.modules.app.vo.ChartTemplateInfoVo;

import java.util.List;

public interface ChartService {
    public R allChartTemplates();

    R line(CSVEntity csvEntity);

    R pie(CSVEntity csvEntity);

    R scatter(CSVEntity csvEntity);
}
