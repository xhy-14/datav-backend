package io.renren.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.menber.entity.MemberEntity;

public interface MemberService extends IService<MemberEntity> {

    Boolean memberIdentify(Long userId);

}
