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

public class CommodityInfoSql {

	public String UpdCommodityInfoById(final CommodityInfo commodityInfo) {
		return new SQL() {
			{
				UPDATE("commodity_info");

				if (commodityInfo.getCommodityBrand() != null) {
					SET("commodity_brand = #{commodityBrand}");
				}
				if (commodityInfo.getCommodityName() != null) {
					SET("commodity_name = #{commodityName}");
				}

				if (commodityInfo.getCommodityNumber() != null) {
					SET("commodity_number = #{commodityNumber}");
				}

				if (commodityInfo.getCommodityOrigin() != null) {
					SET("commodity_origin = #{commodityOrigin}");
				}

				if (commodityInfo.getCommodityPhoto() != null) {
					SET("commodity_photo = #{commodityPhoto}");
				}

				if (commodityInfo.getCommodityPrice() != null) {
					SET("commodity_price = #{commodityPrice}");
				}

				if (commodityInfo.getCommoditySurplus() != null) {
					SET("commodity_surplus = #{commoditySurplus}");
				}

				if (commodityInfo.getCommodityWeigh() != null) {
					SET("commodity_weigh = #{commodityWeigh}");
				}

				WHERE("commodity_info.commodity_id = #{commodityId}");
			}
		}.toString();
	}

	public String UpdCommodityInfoByNumber(final CommodityInfo commodityInfo) {
		return new SQL() {
			{
				UPDATE("commodity_info");

				if (commodityInfo.getCommodityBrand() != null) {
					SET("commodity_brand = #{commodityBrand}");
				}
				if (commodityInfo.getCommodityName() != null) {
					SET("commodity_name = #{commodityName}");
				}

				if (commodityInfo.getCommodityOrigin() != null) {
					SET("commodity_origin = #{commodityOrigin}");
				}

				if (commodityInfo.getCommodityPhoto() != null) {
					SET("commodity_photo = #{commodityPhoto}");
				}

				if (commodityInfo.getCommodityPrice() != null) {
					SET("commodity_price = #{commodityPrice}");
				}

				if (commodityInfo.getCommoditySurplus() != null) {
					SET("commodity_surplus = #{commoditySurplus}");
				}

				if (commodityInfo.getCommodityWeigh() != null) {
					SET("commodity_weigh = #{commodityWeigh}");
				}

				WHERE("commodity_info.commodity_number = #{commodityNumber}");
			}
		}.toString();
	}

	public String SelectCommodityInfo(final CommodityInfo commodityInfo) {

		String SelectCommodityInfo = new SQL() {
			{
				SELECT("*");
				FROM("commodity_info");

				if (commodityInfo.getCommodityId() != null) {
					WHERE("commodity_id = #{commodityId}");
				}

				if (commodityInfo.getCommodityBrand() != null) {
					WHERE("commodity_brand = #{commodityBrand}");
				}
				if (commodityInfo.getCommodityName() != null) {
					WHERE("commodity_name = #{commodityName}");
				}

				if (commodityInfo.getCommodityNumber() != null) {
					WHERE("commodity_number = #{commodityNumber}");
				}

				if (commodityInfo.getCommodityOrigin() != null) {
					WHERE("commodity_origin = #{commodityOrigin}");
				}

				if (commodityInfo.getCommodityPhoto() != null) {
					WHERE("commodity_photo = #{commodityPhoto}");
				}

				if (commodityInfo.getCommodityPrice() != null) {
					WHERE("commodity_price = #{commodityPrice}");
				}

				if (commodityInfo.getCommoditySurplus() != null) {
					WHERE("commodity_surplus = #{commoditySurplus}");
				}

				if (commodityInfo.getCommodityWeigh() != null) {
					WHERE("commodity_weigh = #{commodityWeigh}");
				}

				/*
				 * if (tommodityInfo.getCustomerName() != null) {
				 * WHERE("table_info.customer_name like CONCAT('%', #{customerName},'%')"
				 * ); }
				 */

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

	public String InsertCommodityInfo(final CommodityInfo commodityInfo) {

		return new SQL() {
			{
				INSERT_INTO("commodity_info");

				if (commodityInfo.getCommodityId() != null) {
					VALUES("commodity_info.commodity_id ", " #{commodityId}");
				}

				if (commodityInfo.getCommodityBrand() != null) {
					VALUES("commodity_info.commodity_brand ", " #{commodityBrand}");
				}
				if (commodityInfo.getCommodityName() != null) {
					VALUES("commodity_info.commodity_name ", " #{commodityName}");
				}

				if (commodityInfo.getCommodityNumber() != null) {
					VALUES("commodity_info.commodity_number ", " #{commodityNumber}");
				}

				if (commodityInfo.getCommodityOrigin() != null) {
					VALUES("commodity_info.commodity_origin ", " #{commodityOrigin}");
				}

				if (commodityInfo.getCommodityPhoto() != null) {
					VALUES("commodity_info.commodity_photo ", " #{commodityPhoto}");
				}

				if (commodityInfo.getCommodityPrice() != null) {
					VALUES("commodity_info.commodity_price ", " #{commodityPrice}");
				}

				if (commodityInfo.getCommoditySurplus() != null) {
					VALUES("commodity_info.commodity_surplus ", " #{commoditySurplus}");
				}

				if (commodityInfo.getCommodityWeigh() != null) {
					VALUES("commodity_info.commodity_weigh ", " #{commodityWeigh}");
				}

			}
		}.toString();
	}

}