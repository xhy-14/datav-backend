package io.renren.modules.table.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.table.dao.MysqlConnectionDao;
import io.renren.modules.table.entity.MysqlConnectionEntity;
import io.renren.modules.table.service.MysqlConnectionService;


@Service("mysqlConnectionService")
public class MysqlConnectionServiceImpl extends ServiceImpl<MysqlConnectionDao, MysqlConnectionEntity> implements MysqlConnectionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MysqlConnectionEntity> page = this.page(
                new Query<MysqlConnectionEntity>().getPage(params),
                new QueryWrapper<MysqlConnectionEntity>()
        );

        return new PageUtils(page);
    }

}