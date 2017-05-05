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

import com.cchuaspace.pojo.CommodityInfoDetailsVo;
import org.apache.ibatis.jdbc.SQL;

public class DeliveryPointSql {


    public String SelectPoint(final DeliveryPoint deliveryPoint) {

        String SelectCommodityInfo = new SQL() {
            {
                SELECT("*");
                FROM("delivery_point");

                if (deliveryPoint.getProvince() != null) {
                    WHERE("delivery_point.province = #{province}");
                }
                if (deliveryPoint.getCity() != null) {
                    WHERE("commodity_info_details.city = #{city}");
                }


                if (deliveryPoint.getCounty() != null) {
                    WHERE("commodity_info_details.county = #{county}");
                }


                if (deliveryPoint.getTown() != null) {
                    WHERE("commodity_info_details.town = #{town}");
                }

                if (deliveryPoint.getAddress() != null) {
                    WHERE("commodity_info.address like CONCAT('%',#{address},'%')");
                }


                if (deliveryPoint.getLongitude() != null) {
                    WHERE("commodity_info_details.longitude = #{longitude}");
                }


                if (deliveryPoint.getLatitude() != null) {
                    WHERE("commodity_info_details.latitude = #{latitude}");
                }

                if (deliveryPoint.getDeliveryNumber() != null) {
                    WHERE("commodity_info_details.delivery_number = #{deliveryNumber}");
                }


            }

        }.toString();


        return SelectCommodityInfo;

    }


}