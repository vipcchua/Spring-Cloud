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

import com.cchuaspace.pojo.OrderInfoVo;
import org.apache.ibatis.jdbc.SQL;

public class OrderInfoSql {



    public String SelectConditionCount(final OrderInfoVo orderInfoVo) {

        String SelectConditionCount = new SQL() {
            {
                SELECT("COUNT(*) AS DataTotal");
                FROM("order_info");

                if (orderInfoVo.getGenerateTime()!=null){

                    WHERE("order_info.generate_time = #{generateTime}");
                }
                if (orderInfoVo.getOrderState()!=null){


                    WHERE("order_info.order_state = #{orderState}");
                }

                if (orderInfoVo.getPaymentState()!=null){

                    WHERE("order_info.payment_state = #{paymentState}");
                }


                if (orderInfoVo.getSorting() != null) {

                    String Sorting = orderInfoVo.getSorting();

                    if (Sorting.toLowerCase().equals("payment_state")
                            || Sorting.toLowerCase().equals("commodity_id")

                            ) {
                        ORDER_BY(orderInfoVo.getSorting());
                    } else {
                        System.out.println("黑客,你妈妈喊你回家吃饭");
                    }

                }



            }
        }.toString();

        String sort = orderInfoVo.getTosort();

        if (sort.toLowerCase().equals("desc") || sort.toLowerCase().equals("asc")) {
            String tosort = " " + orderInfoVo.getTosort();
            SelectConditionCount = SelectConditionCount + tosort;
        } else {
            System.out.println("黑客,你妈妈喊你回家吃饭");
        }

        String page = " limit #{page},#{pagerow}";

        SelectConditionCount = SelectConditionCount + page;


        return SelectConditionCount;

    }




}