package io.renren.modules.menber.dao;

import io.renren.modules.menber.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单表
 * 
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:46:46
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
