package io.renren.modules.app.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ComboInfoVo {
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer term;
    private BigDecimal discount;
}
