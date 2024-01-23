package io.renren.modules.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.R;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.ComboService;
import io.renren.modules.app.service.OrderService;
import io.renren.modules.app.service.UserService;
import io.renren.modules.menber.dao.MemberDao;
import io.renren.modules.menber.entity.ComboEntity;
import io.renren.modules.menber.entity.MemberEntity;
import io.renren.modules.app.service.MemberService;
import io.renren.modules.menber.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Service
public class MemberServiceImpl extends ServiceImpl<MemberDao, MemberEntity> implements MemberService {


    @Override
    public Boolean memberIdentify(Long userId) {
        // 获取当前系统时间
        LocalDateTime now = LocalDateTime.now();

        // 构建 LambdaQueryWrapper 查询条件
        LambdaQueryWrapper<MemberEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MemberEntity::getUserId, userId)
                .ge(MemberEntity::getEndTime, now);

        // 执行查询并返回是否存在符合条件的记录
        return baseMapper.selectCount(queryWrapper) > 0;
    }

}
