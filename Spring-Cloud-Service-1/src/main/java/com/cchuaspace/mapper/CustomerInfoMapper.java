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
import com.cchuaspace.model.CommunityRelatives;
import com.cchuaspace.model.CommunityRelativesSql;
import com.cchuaspace.model.CustomerInfo;
import com.cchuaspace.model.CustomerInfoSql;
import com.cchuaspace.model.DetailedList;
import com.cchuaspace.model.TableUser;
import com.cchuaspace.model.TableUserSql;

@Mapper

public interface CustomerInfoMapper {
	/*--------------- -----<----*查询*---->--- ----------------------*/

	@Select("SELECT * FROM customer_info where open_id = #{openId}")
	List<CustomerInfo> selectcustomerinfobyopid(@Param("openId") String openId);
	/*--------------- -----<----*增加*---->--- ----------------------*/

	@InsertProvider(type = CustomerInfoSql.class, method = "InsertCustomerInfo")
	int InsertCustomerInfo(CustomerInfo customerInfo);

	/*--------------- -----<----*删除*---->--- ----------------------*/

	/*--------------- -----<----*修改*---->--- ----------------------*/

	@UpdateProvider(type = CustomerInfoSql.class, method = "UpdateCustomerInfo")
	int UpdateCustomerInfo(CustomerInfo customerInfo);

}