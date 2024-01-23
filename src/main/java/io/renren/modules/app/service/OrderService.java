package io.renren.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.R;
import io.renren.modules.menber.entity.OrderEntity;

import javax.servlet.http.HttpServletRequest;

public interface OrderService extends IService<OrderEntity> {

    /**
     * 生成订单
     * @param request
     * @param comboId
     * @return
     */
    R saveOrder(HttpServletRequest request, Long comboId);
    /**
     * 用户订单查询
     * @param request
     * @return
     */
    R listOrder(HttpServletRequest request);

}
