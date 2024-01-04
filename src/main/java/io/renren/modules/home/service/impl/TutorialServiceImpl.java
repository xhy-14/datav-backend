package io.renren.modules.home.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.home.dao.TutorialDao;
import io.renren.modules.home.entity.TutorialEntity;
import io.renren.modules.home.service.TutorialService;


@Service("tutorialService")
public class TutorialServiceImpl extends ServiceImpl<TutorialDao, TutorialEntity> implements TutorialService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TutorialEntity> page = this.page(
                new Query<TutorialEntity>().getPage(params),
                new QueryWrapper<TutorialEntity>().eq("is_delete", 0).orderByDesc("create_time")
        );

        return new PageUtils(page);
    }

}