package com.cchuaspace.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cchuaspace.model.OrderCommodity;
import com.cchuaspace.model.OrderInfo;

@Mapper

public interface OrderCommodityMapper {
	

	/*--------------- -----<----*查询*---->--- ----------------------*/

	@Select("Select * from order_commodity WHERE order_commodity.order_number = #{orderNumber} ")
	List<OrderCommodity> SelectByNumber(@Param("orderNumber") int orderNumber);
	
}
