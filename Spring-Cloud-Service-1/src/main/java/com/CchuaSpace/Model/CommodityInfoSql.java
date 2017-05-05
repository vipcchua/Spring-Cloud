package com.cchuaspace.model;

import java.util.ArrayList;
import java.util.List;

/*
 * ****************<--*---Code information---*-->**************
 * 	
 *		Author: Cchua
 *		GitHub: https://github.com/vipcchua
 *		Blog  : weibo.com/vipcchua
 * 
 * 
 * ************************************************************/

import com.cchuaspace.pojo.CommodityInfoVo;
import org.apache.ibatis.jdbc.SQL;

import com.cchuaspace.pojo.PaginationVo;

public class CommodityInfoSql {
	private static List<String> fieldList = new ArrayList<String>();

	public String UpdCommodityInfoById(final CommodityInfo commodityInfo) {
		return new SQL() {
			{
				UPDATE("commodity_info");

				if (commodityInfo.getCommodityNumber() != null) {
					SET("commodity_number = #{commodityNumber}");
				}

				if (commodityInfo.getCommodityBrand() != null) {
					SET("commodity_brand = #{commodityBrand}");
				}
				if (commodityInfo.getCommodityName() != null) {
					SET("commodity_name = #{commodityName}");
				}
				if (commodityInfo.getCommodityModel() != null) {
					SET("commodity_model = #{commodityModel}");
				}
				if (commodityInfo.getBarCode() != null) {
					SET("bar_code = #{barCode}");
				}

				if (commodityInfo.getCommodityOrigin() != null) {
					SET("commodity_origin = #{commodityOrigin}");
				}

				if (commodityInfo.getCommodityWeigh() != null) {
					SET("commodity_weigh = #{commodityWeigh}");
				}

				if (commodityInfo.getCommodityUnit() != null) {
					SET("commodity_unit = #{commodityUnit}");
				}
				if (commodityInfo.getCommodityPhoto() != null) {
					SET("commodity_photo = #{commodityPhoto}");
				}

				if (commodityInfo.getCommodityApply() != null) {
					SET("commodity_apply = #{commodityApply}");
				}

				if (commodityInfo.getCommoditySummary() != null) {
					SET("commodity_summary = #{commoditySummary}");
				}

				WHERE("commodity_info.commodity_id = #{commodityId}");
			}
		}.toString();
	}

	public String UpdCommodityInfoByNumber(final CommodityInfo commodityInfo) {
		return new SQL() {
			{
				UPDATE("commodity_info");

				if (commodityInfo.getCommodityNumber() != null) {
					SET("commodity_number = #{commodityNumber}");
				}

				if (commodityInfo.getCommodityBrand() != null) {
					SET("commodity_brand = #{commodityBrand}");
				}
				if (commodityInfo.getCommodityName() != null) {
					SET("commodity_name = #{commodityName}");
				}
				if (commodityInfo.getCommodityModel() != null) {
					SET("commodity_model = #{commodityModel}");
				}
				if (commodityInfo.getBarCode() != null) {
					SET("bar_code = #{barCode}");
				}

				if (commodityInfo.getCommodityOrigin() != null) {
					SET("commodity_origin = #{commodityOrigin}");
				}

				if (commodityInfo.getCommodityWeigh() != null) {
					SET("commodity_weigh = #{commodityWeigh}");
				}

				if (commodityInfo.getCommodityUnit() != null) {
					SET("commodity_unit = #{commodityUnit}");
				}
				if (commodityInfo.getCommodityPhoto() != null) {
					SET("commodity_photo = #{commodityPhoto}");
				}

				if (commodityInfo.getCommodityApply() != null) {
					SET("commodity_apply = #{commodityApply}");
				}

				if (commodityInfo.getCommoditySummary() != null) {
					SET("commodity_summary = #{commoditySummary}");
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

				if (commodityInfo.getCommodityNumber() != null) {
					WHERE("commodity_number = #{commodityNumber}");
				}

				if (commodityInfo.getCommodityBrand() != null) {
					WHERE("commodity_brand = #{commodityBrand}");
				}
				if (commodityInfo.getCommodityName() != null) {
					WHERE("commodity_name = #{commodityName}");
				}
				if (commodityInfo.getCommodityModel() != null) {
					WHERE("commodity_model = #{commodityModel}");
				}
				if (commodityInfo.getBarCode() != null) {
					WHERE("bar_code = #{barCode}");
				}

				if (commodityInfo.getCommodityOrigin() != null) {
					WHERE("commodity_origin = #{commodityOrigin}");
				}

				if (commodityInfo.getCommodityWeigh() != null) {
					WHERE("commodity_weigh = #{commodityWeigh}");
				}

				if (commodityInfo.getCommodityUnit() != null) {
					WHERE("commodity_unit = #{commodityUnit}");
				}
				if (commodityInfo.getCommodityPhoto() != null) {
					WHERE("commodity_photo = #{commodityPhoto}");
				}

				if (commodityInfo.getCommodityApply() != null) {
					WHERE("commodity_apply = #{commodityApply}");
				}

				if (commodityInfo.getCommoditySummary() != null) {
					WHERE("commodity_summary = #{commoditySummary}");
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
					VALUES("commodity_id", "#{commodityId}");
				}

				if (commodityInfo.getCommodityNumber() != null) {
					VALUES("commodity_number", "#{commodityNumber}");
				}

				if (commodityInfo.getCommodityBrand() != null) {
					VALUES("commodity_brand", "#{commodityBrand}");
				}
				if (commodityInfo.getCommodityName() != null) {
					VALUES("commodity_name", "#{commodityName}");
				}
				if (commodityInfo.getCommodityModel() != null) {
					VALUES("commodity_model  ", "#{commodityModel}");
				}
				if (commodityInfo.getBarCode() != null) {
					VALUES("bar_code", "#{barCode}");
				}

				if (commodityInfo.getCommodityOrigin() != null) {
					VALUES("commodity_origin", "#{commodityOrigin}");
				}

				if (commodityInfo.getCommodityWeigh() != null) {
					VALUES("commodity_weigh", "#{commodityWeigh}");
				}

				if (commodityInfo.getCommodityUnit() != null) {
					VALUES("commodity_unit", "#{commodityUnit}");
				}
				if (commodityInfo.getCommodityPhoto() != null) {
					VALUES("commodity_photo", "#{commodityPhoto}");
				}

				if (commodityInfo.getCommodityApply() != null) {
					VALUES("commodity_apply ", "#{commodityApply}");
				}

				if (commodityInfo.getCommoditySummary() != null) {
					VALUES("commodity_summary", "#{commoditySummary}");
				}

			}
		}.toString();
	}

	public String SelectAllByPage(final PaginationVo paginationVo) {

		String SelectCommodityInfo = new SQL() {
			{
				SELECT("*", "(SELECT COUNT(*) FROM commodity_info) AS 'DataTotal'");
				FROM("commodity_info");

				if (paginationVo.getSorting() != null) {

					String Sorting = paginationVo.getSorting();

					if (Sorting.toLowerCase().equals("commodity_id") || Sorting.toLowerCase().equals("commodity_number")
							|| Sorting.toLowerCase().equals("commodity_brand")
							|| Sorting.toLowerCase().equals("commodity_name")
							|| Sorting.toLowerCase().equals("commodity_model")
							|| Sorting.toLowerCase().equals("bar_code")
							|| Sorting.toLowerCase().equals("commodity_origin")
							|| Sorting.toLowerCase().equals("commodity_weigh")
							|| Sorting.toLowerCase().equals("commodity_unit")
							|| Sorting.toLowerCase().equals("commodity_photo")
							|| Sorting.toLowerCase().equals("commodity_apply")
							|| Sorting.toLowerCase().equals("commodity_summary")
							|| Sorting.toLowerCase().equals("home_photo")) {
						ORDER_BY(paginationVo.getSorting());
					} else {
						System.out.println("黑客,你妈妈喊你回家吃饭");
					}

				}

			}

		}.toString();

		/*
		 * if (paginationVo.getSorting() != null) { String order = " ORDER BY "
		 * + paginationVo.getSorting(); SelectCommodityInfo =
		 * SelectCommodityInfo + order; }
		 */

		/*
		 * if (paginationVo.getSorting() != null) {
		 *
		 * String Sorting = paginationVo.getSorting();
		 *
		 * if (Sorting.toLowerCase().equals("commodity_id") ||
		 * Sorting.toLowerCase().equals("commodity_number") ||
		 * Sorting.toLowerCase().equals("commodity_brand") ||
		 * Sorting.toLowerCase().equals("commodity_name") ||
		 * Sorting.toLowerCase().equals("commodity_model") ||
		 * Sorting.toLowerCase().equals("bar_code") ||
		 * Sorting.toLowerCase().equals("commodity_origin") ||
		 * Sorting.toLowerCase().equals("commodity_weigh") ||
		 * Sorting.toLowerCase().equals("commodity_unit") ||
		 * Sorting.toLowerCase().equals("commodity_photo") ||
		 * Sorting.toLowerCase().equals("commodity_apply") ||
		 * Sorting.toLowerCase().equals("commodity_summary") ||
		 * Sorting.toLowerCase().equals("home_photo") ) { String order =
		 * " ORDER BY " + paginationVo.getSorting(); SelectCommodityInfo =
		 * SelectCommodityInfo + order; } else {
		 * System.out.println("黑客,你妈妈喊你回家吃饭"); }
		 *
		 * }
		 */

		String sort = paginationVo.getTosort();

		if (sort.toLowerCase().equals("desc") || sort.toLowerCase().equals("asc")) {
			String tosort = " " + paginationVo.getTosort();
			SelectCommodityInfo = SelectCommodityInfo + tosort;
		} else {
			System.out.println("黑客,你妈妈喊你回家吃饭");
		}

		String page = " limit #{page},#{pagerow}";

		SelectCommodityInfo = SelectCommodityInfo + page;

		return SelectCommodityInfo;

	}



	public String SelectCondition(final CommodityInfoVo commodityInfoVo) {

		String SelectCommodityInfo = new SQL() {
			{
				SELECT("*");
				FROM("commodity_info");

				if (commodityInfoVo.getCommodityName()!=null){

					WHERE("commodity_info.commodity_name like CONCAT('%',#{commodityName},'%')");
				}

				if (commodityInfoVo.getCommodityModel()!=null){
					WHERE("commodity_info.commodity_model like CONCAT('%',#{commodityModel},'%')");
				}

				if (commodityInfoVo.getCommodityBrand()!=null){
					WHERE("commodity_info.commodity_brand like CONCAT('%',#{commodityBrand},'%')");
			}

				if (commodityInfoVo.getCommodityNumber()!=0){
					WHERE("commodity_info.commodity_number = #{commodityNumber}");
				}

				if (commodityInfoVo.getCommodityOrigin()!=null){
					WHERE("commodity_info.commodity_origin like CONCAT('%',#{commodityOrigin},'%')");
				}

				if (commodityInfoVo.getSorting() != null) {
					String Sorting = commodityInfoVo.getSorting();

					if (Sorting.toLowerCase().equals("commodity_id") || Sorting.toLowerCase().equals("commodity_number")
							|| Sorting.toLowerCase().equals("commodity_brand")
							|| Sorting.toLowerCase().equals("commodity_name")
							|| Sorting.toLowerCase().equals("commodity_model")
							|| Sorting.toLowerCase().equals("bar_code")
							|| Sorting.toLowerCase().equals("commodity_origin")
							|| Sorting.toLowerCase().equals("commodity_weigh")
							|| Sorting.toLowerCase().equals("commodity_unit")
							|| Sorting.toLowerCase().equals("commodity_photo")
							|| Sorting.toLowerCase().equals("commodity_apply")
							|| Sorting.toLowerCase().equals("commodity_summary")
							|| Sorting.toLowerCase().equals("home_photo")) {
						ORDER_BY(commodityInfoVo.getSorting());
					} else {
						System.out.println("黑客,你妈妈喊你回家吃饭");
					}
				}
			}
		}.toString();


		String sort = commodityInfoVo.getTosort();

		if (sort.toLowerCase().equals("desc") || sort.toLowerCase().equals("asc")) {
			String tosort = " " + commodityInfoVo.getTosort();
			SelectCommodityInfo = SelectCommodityInfo + tosort;
		} else {
			System.out.println("黑客,你妈妈喊你回家吃饭");
		}

		String page = " limit #{page},#{pagerow}";

		SelectCommodityInfo = SelectCommodityInfo + page;

		return SelectCommodityInfo;

	}





	public String SelectConditionCount(final CommodityInfoVo commodityInfoVo) {

		String SelectCommodityInfo = new SQL() {
			{
				SELECT("COUNT(*) AS DataTotal");
				FROM("commodity_info");

				if (commodityInfoVo.getCommodityName()!=null){

					WHERE("commodity_info.commodity_name like CONCAT('%',#{commodityName},'%')");
				}

				if (commodityInfoVo.getCommodityModel()!=null){
					WHERE("commodity_info.commodity_model like CONCAT('%',#{commodityModel},'%')");
				}

				if (commodityInfoVo.getCommodityBrand()!=null){
					WHERE("commodity_info.commodity_brand like CONCAT('%',#{commodityBrand},'%')");
				}

				if (commodityInfoVo.getCommodityNumber()!=0){
					WHERE("commodity_info.commodity_number = #{commodityNumber}");
				}

				if (commodityInfoVo.getCommodityOrigin()!=null){
					WHERE("commodity_info.commodity_origin like CONCAT('%',#{commodityOrigin},'%')");
				}

				if (commodityInfoVo.getSorting() != null) {
					String Sorting = commodityInfoVo.getSorting();

					if (Sorting.toLowerCase().equals("commodity_id") || Sorting.toLowerCase().equals("commodity_number")
							|| Sorting.toLowerCase().equals("commodity_brand")
							|| Sorting.toLowerCase().equals("commodity_name")
							|| Sorting.toLowerCase().equals("commodity_model")
							|| Sorting.toLowerCase().equals("bar_code")
							|| Sorting.toLowerCase().equals("commodity_origin")
							|| Sorting.toLowerCase().equals("commodity_weigh")
							|| Sorting.toLowerCase().equals("commodity_unit")
							|| Sorting.toLowerCase().equals("commodity_photo")
							|| Sorting.toLowerCase().equals("commodity_apply")
							|| Sorting.toLowerCase().equals("commodity_summary")
							|| Sorting.toLowerCase().equals("home_photo")) {
						ORDER_BY(commodityInfoVo.getSorting());
					} else {
						System.out.println("黑客,你妈妈喊你回家吃饭");
					}
				}
			}
		}.toString();


		String sort = commodityInfoVo.getTosort();



		return SelectCommodityInfo;

	}















}