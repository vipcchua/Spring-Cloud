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


import com.cchuaspace.pojo.OrderInfoVo;
import org.apache.ibatis.annotations.*;

import com.cchuaspace.entity.OrderInfoExample;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.CommodityInfoSql;
import com.cchuaspace.model.CommunityRelatives;
import com.cchuaspace.model.DetailedList;
import com.cchuaspace.model.OrderInfo;
import com.cchuaspace.model.TableUser;
import com.cchuaspace.model.TableUserSql;






@Mapper

public interface OrderInfoMapper {
	int countByExample(OrderInfoExample example);

	int deleteByExample(OrderInfoExample example);

	int deleteByPrimaryKey(Integer orderNumber);

	int insert(OrderInfo record);

	int insertSelective(OrderInfo record);

	List<OrderInfo> selectByExample(OrderInfoExample example);

	OrderInfo selectByPrimaryKey(Integer orderNumber);

	int updateByExampleSelective(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

	int updateByExample(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

	int updateByPrimaryKeySelective(OrderInfo record);

	int updateByPrimaryKey(OrderInfo record);
	/*--------------- -----<----*查询*---->--- ----------------------*/


	
	@Select("Select order_info.*,order_commodity.order_detailedid,"
			+ "order_commodity.commodity_number,"
			+ "order_commodity.buy_amount"
			+ " from order_info,order_commodity"
			+ " WHERE order_info.order_number = #{orderNumber}"
			+ " AND order_commodity.order_number = #{orderNumber}"
			+ " AND order_info.user_id = #{userId}")
	List<OrderInfo> SelectByNumberssss(@Param("userId") String userId,@Param("orderNumber") String orderNumber);
	
	
	
	@Select("Select * from order_info WHERE order_info.order_number = #{userId} AND order_info.order_number = #{orderNumber}")
	OrderInfo SelectByNumber(@Param("userId") String userId,@Param("orderNumber") int orderNumber);

	@Select("Select * from order_info WHERE order_info.order_number = #{orderNumber} " +
			"AND order_info.user_id= #{userId}")
	List<OrderInfo> selectByNumberAndUser(@Param("orderNumber") int orderNumber
			,@Param("userId") String userId);


	@Select("Select order_number,contact_name,order_address,contact_phone," +
			"contact_telephone,order_state,payment_method," +
			"payment_amount,payment_state,express_number,express_business,order_Remarks,generate_time,invoice_type,invoice_header,delivery_number" +
			" from order_info WHERE order_info.user_id = #{userId} AND order_info.order_number = #{orderNumber}")
	List<OrderInfoVo> SelectByNumberList(@Param("userId") String userId,@Param("orderNumber") int orderNumber);

	@Select("Select * from order_info WHERE  order_info.order_number = #{orderNumber}")
	OrderInfo SelectByOrderNumber(@Param("orderNumber") int orderNumber);

	@Select("Select * from order_info WHERE  order_info.order_number = #{orderNumber}")
	List<OrderInfoVo>  selectByOrderNumberList(@Param("orderNumber") int orderNumber);

	@Select("Select order_number,contact_name,order_state,payment_method,payment_amount from order_info WHERE order_info.user_id = #{userId}")
	List<OrderInfoVo>  SelectByUserId(@Param("userId") String userId);

	@Select("Select order_number,contact_name,order_state,payment_method,payment_amount from order_info WHERE order_info.user_id = #{userId}")
	List<OrderInfoVo>  SelectByCondition(OrderInfo orderInfo);



	@Select("SELECT * from order_info WHERE order_number = #{orderNumber} AND openid = #{openid}")
	List<OrderInfo>  SelectAllInfoByNumber(@Param("orderNumber") int orderNumber,@Param("openid") String openid);




	/*--------------- -----<----*增加*---->--- ----------------------*/

	/*--------------- -----<----*删除*---->--- ----------------------*/

	@Delete("Delete FROM order_info where  order_info.order_number = #{orderNumber} AND order_info.user_id = #{userId}")
	int DeleteNumber(@Param("orderNumber") int orderNumber, @Param("UserId") String Userid);
	
	
	@Delete("Delete FROM order_info where order_info.order_id = #{orderId} AND order_info.user_id = #{userId}")
	int DeleteorderId(@Param("orderId") String orderId , @Param("UserId") String Userid);
	

	/*--------------- -----<----*修改*---->--- ----------------------*/

	@Update("UPDATE order_info SET order_info.payment_state = #{paymentState}," +
			"order_info.wechat_pay_result = #{wechatPayResult}," +
			"order_info.transaction_id = #{transactionId} " +
			"where order_info.order_number = #{orderNumber}")
	int UpdatePaymentState(@Param("orderNumber") int orderNumber ,
						   @Param("paymentState") String paymentState,
						   @Param("wechatPayResult")String wechatPayResult,
						   @Param("transactionId")String transactionId);


	@Update("UPDATE order_info SET order_info.payment_state = #{paymentState}," +

			"where order_info.order_number = #{orderNumber}")
	int UpdatePaymentStateBYclose(@Param("orderNumber") int orderNumber ,
						   @Param("paymentState") String paymentState
						  );



	@Update("UPDATE order_info SET order_info.payment_state = #{paymentState}," +
			"order_info.wechat_pay_result = #{wechatPayResult}" +

			"where order_info.order_number = #{orderNumber}")
	int UpdatePayInfo(@Param("orderNumber") int orderNumber ,
						   @Param("paymentState") String paymentState,
						   @Param("wechatPayResult")String wechatPayResult
						);


	@Update("UPDATE order_info SET order_info.payment_state = #{paymentState}," +
			"order_info.wechat_refund_result = #{wechatRefundResult}" +
			"where order_info.order_number = #{orderNumber}")
	int UpdateRefundInfo(@Param("orderNumber") int orderNumber ,
					  @Param("paymentState") String paymentState,
					  @Param("wechatRefundResult")String wechatRefundResult
	);





	
	@Update("UPDATE order_info SET community_relatives.parents_id = #{parentsId} "
			+ "Where community_relatives.commodity_number = #{commodityNumber}")
	int sds(CommunityRelatives communityRelatives);



}