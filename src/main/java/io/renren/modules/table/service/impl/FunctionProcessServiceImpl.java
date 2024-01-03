package io.renren.modules.table.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.table.dao.FunctionProcessDao;
import io.renren.modules.table.entity.FunctionProcessEntity;
import io.renren.modules.table.service.FunctionProcessService;


@Service("functionProcessService")
public class FunctionProcessServiceImpl extends ServiceImpl<FunctionProcessDao, FunctionProcessEntity> implements FunctionProcessService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FunctionProcessEntity> page = this.page(
                new Query<FunctionProcessEntity>().getPage(params),
                new QueryWrapper<FunctionProcessEntity>()
        );

        return new PageUtils(page);
    }

}