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
                    WHERE("delivery_point.city = #{city}");
                }


                if (deliveryPoint.getCounty() != null) {
                    WHERE("delivery_point.county = #{county}");
                }


                if (deliveryPoint.getTown() != null) {
                    WHERE("delivery_point.town = #{town}");
                }

                if (deliveryPoint.getAddress() != null) {
                    WHERE("delivery_point.address like CONCAT('%',#{address},'%')");
                }


                if (deliveryPoint.getLongitude() != null) {
                    WHERE("delivery_point.longitude = #{longitude}");
                }


                if (deliveryPoint.getLatitude() != null) {
                    WHERE("delivery_point.latitude = #{latitude}");
                }

                if (deliveryPoint.getDeliveryNumber() != null) {
                    WHERE("delivery_point.delivery_number = #{deliveryNumber}");
                }


            }

        }.toString();


        return SelectCommodityInfo;

    }


}