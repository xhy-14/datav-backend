package io.renren.modules.menber.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.menber.dao.ComboDao;
import io.renren.modules.menber.entity.ComboEntity;
import io.renren.modules.menber.service.ComboService;


@Service("comboService")
public class ComboServiceImpl extends ServiceImpl<ComboDao, ComboEntity> implements ComboService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ComboEntity> page = this.page(
                new Query<ComboEntity>().getPage(params),
                new QueryWrapper<ComboEntity>()
        );

        return new PageUtils(page);
    }

}