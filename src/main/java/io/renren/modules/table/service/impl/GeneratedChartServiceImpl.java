package io.renren.modules.table.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.table.dao.GeneratedChartDao;
import io.renren.modules.table.entity.GeneratedChartEntity;
import io.renren.modules.table.service.GeneratedChartService;


@Service("generatedChartService")
public class GeneratedChartServiceImpl extends ServiceImpl<GeneratedChartDao, GeneratedChartEntity> implements GeneratedChartService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GeneratedChartEntity> page = this.page(
                new Query<GeneratedChartEntity>().getPage(params),
                new QueryWrapper<GeneratedChartEntity>()
        );

        return new PageUtils(page);
    }

}