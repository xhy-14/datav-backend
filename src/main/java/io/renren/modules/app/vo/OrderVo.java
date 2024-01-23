package io.renren.modules.app.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderVo {
    /**
     * 订单id
     */
    private Long id;
    /**
     * 套餐id
     */
    private Long comboId;
    /**
     * 套餐名
     */
    private String name;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 折扣
     */
    private BigDecimal discount;
    /**
     * 创建时间
     */
    private Date createTime;
}
