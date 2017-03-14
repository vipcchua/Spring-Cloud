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

public class CommunityRelativesSql {

	public String InsertCommunityRelatives(final CommunityRelatives communityRelatives) {

		return new SQL() {
			{
				INSERT_INTO("community_relatives");

				VALUES("community_relatives.catalog_id ", " #{catalogId}");
				VALUES("community_relatives.parents_id ", " #{parentsId}");
				VALUES("community_relatives.commodity_number ", " #{commodityNumber}");
				/* VALUES("community_relatives.depth ", " #{depth}"); */

				/*
				 * if (communityRelatives.getDepth() != null) {
				 * VALUES("community_relatives.depth ", " #{depth}"); }
				 */
			}
		}.toString();
	} 

	public String SelectCommunityRelatives(final CommunityRelatives communityRelatives) {

		String SelectCommodityInfo = new SQL() {
			{
				SELECT("*");
				FROM("community_relatives");

				if (communityRelatives.getcId() != null) {
					WHERE("commodity_id = #{commodityId}");
				}
				

	
		

	
			}
		}.toString();

		/*
		 * String page = " limit #{page},#{pageRow}";
		 * 
		 * SelectTableInfoPage = SelectTableInfoPage + page;
		 * 
		 * System.out.println(SelectTableInfoPage);
		 */
		return SelectCommodityInfo;

	}

}