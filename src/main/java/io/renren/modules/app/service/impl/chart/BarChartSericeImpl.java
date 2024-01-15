package io.renren.modules.app.service.impl.chart;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import io.renren.modules.app.echarts.barchart.BasicBarChart;
import io.renren.modules.app.service.chart.BarChartService;
import io.renren.modules.table.dao.GeneratedChartParameterRelationDao;
import io.renren.modules.table.entity.GeneratedChartParameterRelationEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BarChartSericeImpl extends ServiceImpl<GeneratedChartParameterRelationDao, GeneratedChartParameterRelationEntity> implements BarChartService {

    @Override
    public R getBasicdefaultValue() {

        BasicBarChart basicBarChart = new BasicBarChart();
        return R.success(basicBarChart);
    }

    @Override
    public R saveGeneratedChartParameter(BasicBarChart basicBarChart, Long generatedChartId) {

        ObjectMapper objectMapper = new ObjectMapper();
        String basicChartParameterStr = null;
        try {
            basicChartParameterStr = objectMapper.writeValueAsString(basicBarChart);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        GeneratedChartParameterRelationEntity generatedChartParameterRelationEntity = new GeneratedChartParameterRelationEntity();
        generatedChartParameterRelationEntity.setGeneratedChartId(generatedChartId);
        generatedChartParameterRelationEntity.setParameterId(0L);
        generatedChartParameterRelationEntity.setContent(basicChartParameterStr);
        generatedChartParameterRelationEntity.setIsDelete(0);
        generatedChartParameterRelationEntity.setCreateTime(new Date());
        generatedChartParameterRelationEntity.setUpdateTime(new Date());

        try {
            save(generatedChartParameterRelationEntity);
        } catch (Exception e) {
            throw new RRException("数据库错误");
        }

        return R.success();
    }

    @Override
    public R getParameterByChartId(Long generatedChartId) {

        QueryWrapper<GeneratedChartParameterRelationEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("generated_chart_id", generatedChartId);

        GeneratedChartParameterRelationEntity entity = baseMapper.selectOne(queryWrapper);

        String content = entity.getContent();

        ObjectMapper objectMapper = new ObjectMapper();
        BasicBarChart basicBarChart = null;
        try {
            basicBarChart = objectMapper.readValue(content, BasicBarChart.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return R.success(basicBarChart);
    }
}
