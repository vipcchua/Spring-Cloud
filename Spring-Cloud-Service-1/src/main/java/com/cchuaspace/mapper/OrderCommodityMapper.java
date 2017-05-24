package com.cchuaspace.mapper;

import com.cchuaspace.model.OrderCommodity;
import com.cchuaspace.entity.OrderCommodityExample;
import java.util.List;

import com.cchuaspace.pojo.OrderCommodityVo;
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

    @Select("Select * from order_commodity WHERE order_commodity.order_number = #{orderNumber}")
    List<OrderCommodity> SelectByNumber(@Param("orderNumber") int orderNumber);



    @Select("Select commodity_number,buy_amount from order_commodity WHERE " +
            "order_commodity.order_number = #{orderNumber}")
    List<OrderCommodityVo> SelectorderlistByNumber(@Param("orderNumber") int orderNumber);

    @Select("Select commodity_number,buy_amount,commodity_price,order_number from " +
            "order_commodity WHERE order_commodity.order_number = #{orderNumber}")
    List<OrderCommodityVo> SelectorderinfoByNumber(@Param("orderNumber") int orderNumber);

}