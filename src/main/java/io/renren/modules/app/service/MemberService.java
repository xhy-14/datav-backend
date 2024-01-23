package io.renren.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.R;
import io.renren.modules.menber.entity.MemberEntity;

import javax.servlet.http.HttpServletRequest;

public interface MemberService extends IService<MemberEntity> {

    Boolean memberIdentify(Long userId);


}
