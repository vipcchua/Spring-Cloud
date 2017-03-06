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
import com.CchuaSpace.Model.TableUser;
import com.CchuaSpace.Model.TableUserSql;






@Mapper

public interface CommodityInfoMapper {
	/*--------------- -----<----*查询*---->--- ----------------------*/
	
	@Select("SELECT * FROM commodity_info where commodity_number = #{commodityNumber}")
	List<CommodityInfo> SelectCommodityByNumber (@Param("commodityNumber") int commodityNumber);

	
	@Select("SELECT * FROM commodity_info where commodity_id = #{commodityId}")
	List<CommodityInfo> SelectCommodityByID (@Param("commodityId") String commodityId);

	
	@SelectProvider(type = CommodityInfoSql.class, method = "SelectCommodityInfo")  
	public List<CommodityInfo> SelectCommodityInfo(CommodityInfo tableInfo);
	
	
	
	
	/*--------------- -----<----*增加*---->--- ----------------------*/


	
	@InsertProvider(type = CommodityInfoSql.class, method = "InsertCommodityInfo")  
	@Options(useGeneratedKeys=true, keyProperty="tutorId") 
	public List<CommodityInfo> InsertCommodityInfo(CommodityInfo tommodityInfo);
	
	
	
	
	/*--------------- -----<----*删除*---->--- ----------------------*/

	@Delete("Delete FROM commodity_info where commodity_id = #{commodityId}")
	int DeleteCommodityById(@Param("commodityId") String commodityId);
	
	@Delete("Delete FROM commodity_info where commodity_number = #{commodityNumber}")
	int DeleteCommodityByNumber (@Param("commodityNumber") int commodityNumber);
	
	
	
	/*--------------- -----<----*修改*---->--- ----------------------*/

	@UpdateProvider(type = CommodityInfoSql.class, method = "UpdCommodityInfoById")
	public List<CommodityInfo> UpdCommodityInfoById(CommodityInfo tommodityInfo);
	
	@UpdateProvider(type = CommodityInfoSql.class, method = "UpdCommodityInfoByNumber")
	public List<CommodityInfo> UpdCommodityInfoByNumber(CommodityInfo tommodityInfo);
	
	
	
	
	
	
	
}