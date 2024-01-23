package io.renren.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.R;
import io.renren.modules.app.dto.OrderDTO;
import io.renren.modules.menber.entity.OrderEntity;

import javax.servlet.http.HttpServletRequest;

public interface OrderService extends IService<OrderEntity> {

    /**
     * 生成订单
     * @param request
     * @param
     * @return
     */
    R saveOrder(HttpServletRequest request, OrderDTO orderDTO);
    /**
     * 用户订单查询
     * @param request
     * @return
     */
    R listOrder(HttpServletRequest request);

    R computeMember(HttpServletRequest request, Long orderId);

}
