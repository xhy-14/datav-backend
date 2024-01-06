package io.renren.modules.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.app.service.ComboService;
import io.renren.modules.app.vo.ComboInfoVo;
import io.renren.modules.menber.dao.ComboDao;
import io.renren.modules.menber.entity.ComboEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComboServiceImpl extends ServiceImpl<ComboDao, ComboEntity> implements ComboService {

    @Override
    public List<ComboInfoVo> getComboList() {
        List<ComboInfoVo> list = baseMapper.getList();
        return list;
    }
}
