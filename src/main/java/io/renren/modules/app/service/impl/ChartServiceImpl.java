package io.renren.modules.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.R;
import io.renren.modules.app.dao.ChartDao;
import io.renren.modules.app.service.ChartService;
import io.renren.modules.app.vo.ChartTemplateInfoVo;
import io.renren.modules.chart.entity.ChartTypeEntity;
import io.renren.modules.file.dao.FileDao;
import io.renren.modules.file.entity.FileEntity;
import io.renren.modules.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ChartService")
public class ChartServiceImpl extends ServiceImpl<ChartDao, ChartTypeEntity> implements ChartService {

    @Autowired
    private FileService fileService;

    /**
     * 获取所有图表类型
     * @return R
     */
    @Override
    public R allChartTemplates() {

        List<ChartTypeEntity> chartTypeList = baseMapper.selectList(null);
        List<ChartTemplateInfoVo> chartTemplateInfoVoList = new ArrayList<>();
        for ( ChartTypeEntity chartTypeEntity : chartTypeList) {
            FileEntity fileEntity = fileService.getFileById(chartTypeEntity.getCoverId());
            ChartTemplateInfoVo chartTemplateInfoVo = new ChartTemplateInfoVo();

            chartTemplateInfoVo.setId(chartTypeEntity.getId());
            chartTemplateInfoVo.setCover(fileEntity.getPath());
            chartTemplateInfoVo.setName(chartTypeEntity.getName());

            chartTemplateInfoVoList.add(chartTemplateInfoVo);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("total", chartTemplateInfoVoList.size());
        map.put("charts", chartTemplateInfoVoList);

        return R.success(map);
    }
}
