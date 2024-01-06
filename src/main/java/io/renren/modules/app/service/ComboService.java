package io.renren.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.app.vo.ComboInfoVo;
import io.renren.modules.menber.entity.ComboEntity;

import java.util.List;

public interface ComboService extends IService<ComboEntity> {
    List<ComboInfoVo> getComboList();
}
