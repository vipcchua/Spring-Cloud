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


import com.CchuaSpace.Model.DetailedList;
import com.CchuaSpace.Model.DetailedListSql;
import com.CchuaSpace.Model.TableUser;
import com.CchuaSpace.Model.TableUserSql;






@Mapper

public interface DetailedListMapper {
	/*--------------- -----<----*查询*---->--- ----------------------*/
	@Select("SELECT * FROM detailed_list where User_id = #{userId}")
	List<DetailedList> SelectDetailedListByUserId (@Param("userId") String userId);
	
	@Select("SELECT * FROM detailed_list where detailed_id = #{detailedId}")
	List<DetailedList> SelectDetailedListByDetailedId (@Param("detailedId") String userId);

	/*--------------- -----<----*增加*---->--- ----------------------*/	
	
	@InsertProvider(type = DetailedListSql.class, method = "InsertDetailedListInfo")  
	public List<DetailedList> InsertDetailedListInfoDy(DetailedList detailedList);
	
	
	@Insert("INSERT INTO detailed_list (detailed_id,user_id,commodity_number,need_number)"
			+ " VALUES (#{detailedId},#{userId},#{commodityNumber},#{needNumber})")  
	public int InsertDetailedList(DetailedList detailedList);
	
	/*--------------- -----<----*删除*---->--- ----------------------*/
	@Delete("Delete FROM detailed_list where user_id = #{userId} And detailed_id = #{detailedId} And commodity_number = #{commodityNumber}")
	int DeleteCommodity(DetailedList detailedList);
	
	@Delete("Delete FROM detailed_list where user_id = #{userId} And commodity_number = #{commodityNumber}")
	int DeleteByCommodity(@Param("userId") String userId,@Param("commodityNumber") int commodityNumber);
	
	@Delete("Delete FROM detailed_list where user_id = #{userId} And detailed_id = #{detailedId}")
	int DeleteBydetailedId (@Param("userId") String userId,@Param("detailedId") String detailedId);
		
	@Delete("Delete FROM detailed_list where user_id = #{userId}")
	int DeleteAlldetailed(@Param("userId") String commodityNumber);
	
	
	/*--------------- -----<----*修改*---->--- ----------------------*/

	@UpdateProvider(type = DetailedListSql.class, method = "UpdDetailedList")
	public List<DetailedList> UpdDetailedList(DetailedList detailedList);
	
	
	@Update("UPDATE detailed_list SET need_number = #{needNumber} "
			+ "where detailed_list.commodity_number = #{commodityNumber}"			
			 + " And detailed_list.user_id = #{userId}")
	int UpdateCommodityByUserId (DetailedList detailedList);
	
	
/*	int UpdateCommodityByUserId (@Param("needNumber") int needNumber
			,@Param("commodityNumber") int commodityNumber
			,@Param("userId") String userId);*/
	
	

	
	
	
	
	@Update("UPDATE detailed_list SET need_number = #{needNumber} "
			+ "where detailed_list.commodity_number = #{commodityNumber}"			
			 + " And detailed_list.detailed_id = #{detailedId}")
	
	int UpdateCommodityBydetailedId (DetailedList detailedList);

	
	
	
	
	
	
	
}