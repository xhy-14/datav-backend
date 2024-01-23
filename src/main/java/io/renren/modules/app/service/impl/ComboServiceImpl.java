package io.renren.modules.app.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.R;
import io.renren.modules.app.service.ComboService;
import io.renren.modules.app.vo.ComboInfoVo;
import io.renren.modules.menber.dao.ComboDao;
import io.renren.modules.menber.entity.ComboEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ComboServiceImpl extends ServiceImpl<ComboDao, ComboEntity> implements ComboService {

    @Override
    public R getComboList() {
        List<ComboEntity> comboEntities = baseMapper.selectList(new QueryWrapper<>());
        List<ComboInfoVo> comboInfoVos = new ArrayList<>();
        for(ComboEntity combo : comboEntities) {
            ComboInfoVo comboInfoVo = new ComboInfoVo();
            comboInfoVo.setId(combo.getId());
            comboInfoVo.setPrice(combo.getPrice());
            comboInfoVo.setName(combo.getName());
            comboInfoVo.setTerm(combo.getTerm());
            comboInfoVo.setDiscount(combo.getDiscount());
            comboInfoVos.add(comboInfoVo);
        }
        return R.success(comboInfoVos);
    }
}
