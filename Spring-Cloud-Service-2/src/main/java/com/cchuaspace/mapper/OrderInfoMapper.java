package com.cchuaspace.mapper;

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

import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.CommodityInfoSql;
import com.cchuaspace.model.CommunityRelatives;
import com.cchuaspace.model.DetailedList;
import com.cchuaspace.model.OrderInfo;
import com.cchuaspace.model.TableUser;
import com.cchuaspace.model.TableUserSql;






@Mapper

public interface OrderInfoMapper {
	
	/*--------------- -----<----*查询*---->--- ----------------------*/


	
	@Select("Select order_info.*,order_commodity.order_detailedid,"
			+ "order_commodity.commodity_number,"
			+ "order_commodity.buy_amount"
			+ " from order_info,order_commodity"
			+ " WHERE order_info.order_number = #{orderNumber}"
			+ " AND order_commodity.order_number = #{orderNumber}"
			+ " AND order_info.user_id = #{userId}")
	List<OrderInfo> SelectByNumberssss(@Param("userId") String userId,@Param("orderNumber") String orderNumber);
	
	
	
	@Select("Select * from order_info WHERE order_info.order_number = #{orderNumber} AND order_info.order_number = #{orderNumber}")
	OrderInfo SelectByNumber(@Param("userId") String userId,@Param("orderNumber") String orderNumber);
	

	/*--------------- -----<----*增加*---->--- ----------------------*/

	/*--------------- -----<----*删除*---->--- ----------------------*/

	@Delete("Delete FROM order_info where  order_info.order_number = #{orderNumber} AND order_info.user_id = #{userId}")
	int DeleteNumber(@Param("orderNumber") String orderNumber, @Param("UserId") String Userid);
	
	
	@Delete("Delete FROM order_info where order_info.order_id = #{orderId} AND order_info.user_id = #{userId}")
	int DeleteorderId(@Param("orderId") String orderId , @Param("UserId") String Userid);
	

	/*--------------- -----<----*修改*---->--- ----------------------*/

	
	@Update("UPDATE order_info SET community_relatives.parents_id = #{parentsId} "
			+ "Where community_relatives.commodity_number = #{commodityNumber}"
			)
	int sds(CommunityRelatives communityRelatives);
	
	
	
	
	

	
}