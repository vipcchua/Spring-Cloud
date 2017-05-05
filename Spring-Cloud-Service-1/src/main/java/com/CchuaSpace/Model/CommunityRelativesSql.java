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

import com.cchuaspace.pojo.CommunityRelativesVo;
import org.apache.ibatis.jdbc.SQL;

import com.cchuaspace.pojo.PaginationVo;

public class CommunityRelativesSql {

    public String InsertCommunityRelatives(final CommunityRelatives communityRelatives) {

        return new SQL() {
            {
                INSERT_INTO("community_relatives");

               /* VALUES("community_relatives.catalog_id ", " #{catalogId}");*/
                VALUES("community_relatives.parents_id ", " #{parentsId}");
                VALUES("community_relatives.commodity_number ", " #{commodityNumber}");

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


        return SelectCommodityInfo;

    }

    public String SelectByParentsInfo(final CommunityRelativesVo communityRelatives) {


        String SelectCommodityInfo = new SQL() {
            {
                SELECT("*");
                FROM("commodity_info_details","(SELECT * FROM community_relatives WHERE community_relatives.parents_id = #{parentsId})=relatives");
                WHERE("commodity_info_details.commodity_number=relatives.commodity_number");
                WHERE("shelf_state=1");
                ORDER_BY("present_price");




            }
        }.toString();


       /* String SelectCommodityInfo = "SELECT * FROM commodity_info_details,"
                + "(SELECT * FROM community_relatives WHERE community_relatives.parents_id = #{parentsId} )=relatives "
                + "WHERE commodity_info_details.commodity_number=relatives.commodity_number"
                + " AND shelf_state = 1 ORDER BY present_price";*/

        String sort = communityRelatives.getTosort();
        if (sort.toLowerCase().equals("desc") || sort.toLowerCase().equals("asc")) {
            String tosort = " " + communityRelatives.getTosort();
            SelectCommodityInfo = SelectCommodityInfo + tosort;
        } else {
            System.out.println("黑客,你妈妈喊你回家吃饭");
        }

        String page = " limit #{page},#{pagerow}";

        SelectCommodityInfo = SelectCommodityInfo + page;
        System.out.println(SelectCommodityInfo);




        return SelectCommodityInfo;

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


}