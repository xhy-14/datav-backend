package io.renren.modules.app.controller.member;


import io.renren.common.utils.R;
import io.renren.modules.app.dto.OrderDTO;
import io.renren.modules.app.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/common/member/order")
@Api(tags = "订单模块", description = "订单")
public class APPOrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation("生成订单")
    @PostMapping ("/save")
    public R saveOrder(HttpServletRequest request,
                       @ApiParam(value = "combo_id", required = true)
                       @RequestBody OrderDTO orderDTO) {
        return R.success(orderService.saveOrder(request, orderDTO));
    }

    @ApiOperation("查询订单列表")
    @GetMapping("/list")
    public R orderList(HttpServletRequest request) {
        return orderService.listOrder(request);
    }

}
