package com.cchuaspace.model;

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
				
				if (detailedList.getAddPrice()!= null) {
					WHERE("detailed_list.add_price = #{addPrice}");
				}
				
				if (detailedList.getAddTime()!= null) {
					WHERE("detailed_list.add_time = #{addTime}");
				}
			
			
		   
			}
		}.toString();
	}
	
	
	
	
	
	
	
	
	
	
	public String InsertDetailedListInfo(final DetailedList detailedList) {

		return new SQL() {
			{
				INSERT_INTO("detailed_list");

				if (detailedList.getDetailedId() != null) {
					VALUES("detailed_list.detailed_id ", "#{detailedId}");
				}					
				
				if (detailedList.getUserId() != null) {
					VALUES("detailed_list.user_id", "#{userId}");
				}
				
				if (detailedList.getCommodityNumber() != null) {
					VALUES("detailed_list.commodity_number", "#{commodityNumber}");
				}
				
				if (detailedList.getNeedNumber()!= null) {
					VALUES("detailed_list.need_number", "#{needNumber}");
				}
				
			
				if (detailedList.getAddPrice()!= null) {
					VALUES("detailed_list.add_price", "#{addPrice}");
				}
		
				if (detailedList.getAddTime()!= null) {
					VALUES("detailed_list.add_time ", " #{addTime}");
				}
				

			}
		}.toString();
	}
	
	
	
	

}