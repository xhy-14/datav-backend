package io.renren.modules.chart.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.chart.dao.ParameterDao;
import io.renren.modules.chart.entity.ParameterEntity;
import io.renren.modules.chart.service.ParameterService;


@Service("parameterService")
public class ParameterServiceImpl extends ServiceImpl<ParameterDao, ParameterEntity> implements ParameterService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ParameterEntity> page = this.page(
                new Query<ParameterEntity>().getPage(params),
                new QueryWrapper<ParameterEntity>()
        );

        return new PageUtils(page);
    }

}