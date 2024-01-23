package io.renren.modules.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.R;
import io.renren.modules.app.dto.OrderDTO;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.ComboService;
import io.renren.modules.app.service.MemberService;
import io.renren.modules.app.service.OrderService;
import io.renren.modules.app.service.UserService;
import io.renren.modules.app.vo.OrderVo;
import io.renren.modules.menber.dao.OrderDao;
import io.renren.modules.menber.entity.ComboEntity;
import io.renren.modules.menber.entity.MemberEntity;
import io.renren.modules.menber.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

    @Autowired
    private UserService userService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private ComboService comboService;

    @Override
    public R saveOrder(HttpServletRequest request, OrderDTO orderDTO) {

        // 获取当前用户
        UserEntity userEntity = userService.currentUser(request);
        // 生成订单
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setComboId(orderDTO.getComboId());
        orderEntity.setUserId(userEntity.getUserId());
        orderEntity.setIsDelete(1);
        orderEntity.setUpdateTime(new Date());
        orderEntity.setCreateTime(new Date());
        baseMapper.insert(orderEntity);

        return R.success(orderEntity.getId());
    }

    @Override
    public R computeMember(HttpServletRequest request, Long orderId) {

        OrderEntity orderEntity = baseMapper.selectById(orderId);
        orderEntity.setIsDelete(0);
        baseMapper.updateById(orderEntity);

        Long comboId = orderEntity.getComboId();

        UserEntity userEntity = userService.getBaseMapper().selectById(orderEntity.getUserId());
        // 获取套餐信息
        ComboEntity comboEntity = comboService.getBaseMapper().selectById(comboId);
        // 查看用户当前会员状态
        QueryWrapper<MemberEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userEntity.getUserId());
        MemberEntity memberEntity = memberService.getBaseMapper()
                .selectOne(queryWrapper);
        if (memberEntity != null && memberEntity.getEndTime().getTime() > System.currentTimeMillis()) {
            // 未过期会员
            Date currentEndTime = memberEntity.getEndTime();
            int term = comboEntity.getTerm();

            // 计算新的到期时间
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentEndTime);
            calendar.add(Calendar.DAY_OF_YEAR, term);
            Date newEndTime = calendar.getTime();

            // 更新会员的到期时间
            memberEntity.setEndTime(newEndTime);
            memberService.updateById(memberEntity);
        } else  {
            // 已过期会员或非会员
            //当前时间
            Date currentTime = new Date();
            int term = comboEntity.getTerm();

            // 计算新的到期时间
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentTime);
            calendar.add(Calendar.DAY_OF_YEAR, term);
            Date newEndTime = calendar.getTime();
            if (memberEntity != null) {
                //是会员但过期
                memberEntity.setEndTime(newEndTime);
                memberService.getBaseMapper().updateById(memberEntity);
            } else {
                //非会员
                MemberEntity newMemberEntity = new MemberEntity();
                newMemberEntity.setUserId(userEntity.getUserId());
                newMemberEntity.setIsDelete(0);
                newMemberEntity.setEndTime(newEndTime);
                newMemberEntity.setUpdateTime(new Date());
                newMemberEntity.setCreateTime(new Date());
                memberService.getBaseMapper().insert(newMemberEntity);
            }
        }
        return null;
    }

    @Override
    public R listOrder(HttpServletRequest request) {

        UserEntity userEntity = userService.currentUser(request);
        QueryWrapper<OrderEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userEntity.getUserId())
                .eq("is_delete", 0);

        List<OrderEntity> orderEntities = baseMapper.selectList(queryWrapper);

        List<OrderVo> orderVos = new ArrayList<>();

        for (OrderEntity orderEntity : orderEntities) {
            OrderVo orderVo = new OrderVo();
            ComboEntity comboEntity = comboService.getBaseMapper().selectById(orderEntity.getComboId());

            orderVo.setId(orderEntity.getId());
            orderVo.setName(comboEntity.getName());
            orderVo.setComboId(comboEntity.getId());
            orderVo.setCreateTime(orderEntity.getCreateTime());
            orderVo.setPrice(comboEntity.getPrice());
            orderVo.setDiscount(comboEntity.getDiscount());
            orderVos.add(orderVo);
        }

        return R.success(orderVos);
    }
}

