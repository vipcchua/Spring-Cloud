package com.CchuaSpace.Model;

/*
 * ****************<--*---Code information---*-->**************
 * 	
 *		Author: Cchua
 *		GitHub: https://github.com/vipcchua
 *		Blog  : weibo.com/vipcchua
 * 
 * 
 * ************************************************************/

import org.apache.ibatis.jdbc.SQL;

public class DetailedListSql {

	public String UpdDetailedList(final DetailedList detailedList) {
		
		return new SQL() {
			{
				UPDATE("detailed_list");

				if (detailedList.getNeedNumber() != null) {
					SET("detailed_list.Need_Number = #{needNumber}");
				}
				if (detailedList.getUserId() != null) {
					WHERE("detailed_list.user_id = #{userId}");
				}
				
				if (detailedList.getDetailedId() != null) {
					WHERE("detailed_list.detailed_id = #{detailedId}");
				}

				if (detailedList.getCommodityNumber()!= null) {
					WHERE("detailed_list.commodity_number = #{commodityNumber}");
				}
			
		
			}
		}.toString();
	}
	
	
	
	
	
	
	
	
	
	
	public String InsertDetailedListInfo(final DetailedList detailedList) {

		return new SQL() {
			{
				INSERT_INTO("commodity_info");

				if (detailedList.getDetailedId() != null) {
					VALUES("commodity_info.detailed_id ", "#{detailedId}");
				}					
				
				if (detailedList.getUserId() != null) {
					VALUES("commodity_info.user_id ", "#{userId}");
				}
				
				if (detailedList.getCommodityNumber() != null) {
					VALUES("commodity_info.commodity_number ", "#{commodityNumber}");
				}
				
				if (detailedList.getNeedNumber()!= null) {
					VALUES("commodity_info.need_number ", "#{needNumber}");
				}
				
			
				
		

			}
		}.toString();
	}
	
	
	
	

}