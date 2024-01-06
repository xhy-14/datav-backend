package io.renren.modules.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.app.dao.ChartDao;
import io.renren.modules.app.service.ChartService;
import io.renren.modules.app.vo.ChartTemplateInfoVo;
import io.renren.modules.chart.entity.ChartTypeEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ChartService")
public class ChartServiceImpl extends ServiceImpl<ChartDao, ChartTypeEntity> implements ChartService {

    @Override
    public List<ChartTemplateInfoVo> allChartTemplates() {
        Page<ChartTypeEntity> page = new Page();
        Page<ChartTypeEntity> chartTypeEntityPage = baseMapper.selectPage(page, new QueryWrapper<>());
        System.out.println(chartTypeEntityPage.getTotal());
        return null;
    }
}
