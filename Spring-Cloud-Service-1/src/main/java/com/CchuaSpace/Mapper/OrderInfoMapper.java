package com.CchuaSpace.Mapper;

/*
 * ****************<--*---Code information---*-->**************
 * 	
 *		Author: Cchua
 *		GitHub: https://github.com/vipcchua
 *		Blog  : weibo.com/vipcchua
 * 
 * 
 * ************************************************************/


import java.util.List;



import org.apache.ibatis.annotations.*;

import com.CchuaSpace.Model.CommodityInfo;
import com.CchuaSpace.Model.CommodityInfoSql;
import com.CchuaSpace.Model.DetailedList;
import com.CchuaSpace.Model.OrderInfo;
import com.CchuaSpace.Model.TableUser;
import com.CchuaSpace.Model.TableUserSql;






@Mapper

public interface OrderInfoMapper {


	
	@Select("Select order_info.*,order_commodity.order_detailedid,"
			+ "order_commodity.commodity_number,"
			+ "order_commodity.buy_amount"
			+ " from order_info,order_commodity"
			+ " WHERE order_info.order_number = #{orderNumber}"
			+ " AND order_commodity.order_number = #{orderNumber}"
			+ " AND order_info.user_id = #{userId}")
	List<OrderInfo> SelectByNumber(@Param("userId") String userId,@Param("orderNumber") String orderNumber);
	
	
	
	/*--------------- -----<----*查询*---->--- ----------------------*/
		
	/*--------------- -----<----*增加*---->--- ----------------------*/

	/*--------------- -----<----*删除*---->--- ----------------------*/

	@Delete("Delete FROM order_info where  order_info.order_number = #{orderNumber} AND order_info.user_id = #{userId}")
	int DeleteNumber(@Param("orderNumber") String orderNumber, @Param("UserId") String Userid);
	
	
	@Delete("Delete FROM order_info where order_info.order_id = #{orderId} AND order_info.user_id = #{userId}")
	int DeleteorderId(@Param("orderId") String orderId , @Param("UserId") String Userid);
	

	/*--------------- -----<----*修改*---->--- ----------------------*/


	
}