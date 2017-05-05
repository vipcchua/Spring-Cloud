package com.cchuaspace.model;

import com.cchuaspace.pojo.CommodityInfoDetailsVo;
import com.cchuaspace.pojo.PaginationVo;
import org.apache.ibatis.jdbc.SQL;

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

public class CommodityInfoDerailsSql {
    private static List<String> fieldList = new ArrayList<String>();


    public String SelectAllByPage(final CommodityInfoDetailsVo commodityInfoDetailsVo) {

        String SelectCommodityInfo = new SQL() {
            {
                SELECT("*");
                FROM("commodity_info_details");
                if (commodityInfoDetailsVo.getShelfState()!=0){
                WHERE("commodity_info_details.shelf_state = #{shelfState}");
            }
                if (commodityInfoDetailsVo.getCommodityNumber()!=0){
                    WHERE("commodity_info_details.commodity_number = #{commodity_number}");
                }


                if (commodityInfoDetailsVo.getSorting() != null) {

                    String Sorting = commodityInfoDetailsVo.getSorting();

                    if (Sorting.toLowerCase().equals("commodity_number")
                            || Sorting.toLowerCase().equals("commodity_id")
                            || Sorting.toLowerCase().equals("listing_date")
                            || Sorting.toLowerCase().equals("present_price")
                            || Sorting.toLowerCase().equals("original_price")
                            || Sorting.toLowerCase().equals("shelf_state")
                            || Sorting.toLowerCase().equals("describe")
                            || Sorting.toLowerCase().equals("title")
                            ) {
                        ORDER_BY(commodityInfoDetailsVo.getSorting());
                    } else {
                        System.out.println("黑客,你妈妈喊你回家吃饭");
                    }

                }

            }

        }.toString();


        String sort = commodityInfoDetailsVo.getTosort();

        if (sort.toLowerCase().equals("desc") || sort.toLowerCase().equals("asc")) {
            String tosort = " " + commodityInfoDetailsVo.getTosort();
            SelectCommodityInfo = SelectCommodityInfo + tosort;
        } else {
            System.out.println("黑客,你妈妈喊你回家吃饭");
        }

        String page = " limit #{page},#{pagerow}";

        SelectCommodityInfo = SelectCommodityInfo + page;

        return SelectCommodityInfo;

    }

}