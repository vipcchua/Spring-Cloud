package com.cchuaspace.mapper;

import com.cchuaspace.model.OrderCommodity;
import com.cchuaspace.entity.OrderCommodityExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderCommodityMapper {
    int countByExample(OrderCommodityExample example);

    int deleteByExample(OrderCommodityExample example);

    int insert(OrderCommodity record);

    int insertSelective(OrderCommodity record);

    List<OrderCommodity> selectByExample(OrderCommodityExample example);

    int updateByExampleSelective(@Param("record") OrderCommodity record, @Param("example") OrderCommodityExample example);

    int updateByExample(@Param("record") OrderCommodity record, @Param("example") OrderCommodityExample example);

    @Select("Select * from order_commodity WHERE order_info.order_number = #{orderNumber}")
    List<OrderCommodity> SelectByNumber(@Param("orderNumber") int orderNumber);


}