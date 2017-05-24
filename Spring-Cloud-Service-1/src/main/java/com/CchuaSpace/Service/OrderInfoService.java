package com.cchuaspace.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.TypeReference;
import com.cchuaspace.currency.CchuaTool;
import com.cchuaspace.mapper.CommodityInfoDetailsMapper;
import com.cchuaspace.mapper.CommodityInfoMapper;
import com.cchuaspace.model.CommodityInfoDetails;
import com.cchuaspace.pojo.OrderCommodityVo;
import com.cchuaspace.wechat.controller.WeChatPayController;
import com.cchuaspace.wechat.model.WechatOrderPayApi;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cchuaspace.mapper.OrderCommodityMapper;
import com.cchuaspace.mapper.OrderInfoMapper;
import com.cchuaspace.model.OrderCommodity;
import com.cchuaspace.model.OrderInfo;
import com.cchuaspace.pojo.OrderInfoVo;
import com.cchuaspace.pojo.PaginationVo;

import javax.servlet.http.HttpServletRequest;

/*
 * ****************<--*---Code information---*-->**************
 * 	
 *		Author: Cchua
 *		GitHub: https://github.com/vipcchua
 *		Blog  : weibo.com/vipcchua
 * 
 * 
 * ************************************************************/
@Service
@Scope("prototype")
public class OrderInfoService {


    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private OrderCommodityMapper orderCommodityMapper;

    @Autowired
    private CommodityInfoDetailsMapper commodityInfoDetailsMapper;

    @Autowired
    private CommodityInfoMapper commodityInfoMapper;

    @Autowired
    private PaginationVo paginationVo;

    @Autowired
    private OrderInfoVo orderInfoVo;

    @Autowired
    private CchuaTool cchuaTool;

    @Autowired
    private WeChatPayController weChatPayController;


	/*--------------- -----<----*查询*---->--- ----------------------*/

    public PaginationVo SelectByNumbers(@RequestBody String CommodityInfo, Model model) {

        OrderInfo json = JSONObject.parseObject(CommodityInfo, OrderInfo.class);

        OrderInfo infodata = orderInfoMapper.SelectByNumber(json.getUserId(), json.getOrderNumber());

        List<OrderCommodity> user = orderCommodityMapper.SelectByNumber(infodata.getOrderNumber());

        // BeanUtils对部分属性不支持null的情况？？？？
        // BeanUtils.copyProperties(orderInfoVo, infodata);


        try {
            PropertyUtils.copyProperties(orderInfoVo, infodata);
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        orderInfoVo.setDataResultObj(user);

        paginationVo.setDataResultObj(orderInfoVo);
        return paginationVo;

    }


    public PaginationVo SelectByNumber(@RequestBody String CommodityInfo, Model model) {

        OrderInfo json = JSONObject.parseObject(CommodityInfo, OrderInfo.class);

        List<OrderInfoVo> infodata = orderInfoMapper.SelectByNumberList(json.getUserId(), json.getOrderNumber());


        for (int i = 0; i < infodata.size(); i++) {
            infodata.get(i)
                    .setOrderCommodityVo(orderCommodityMapper.SelectorderinfoByNumber(infodata.get(i).getOrderNumber()));

            for (int j = 0; j < infodata.get(i).getOrderCommodityVo().size(); j++) {
                infodata.get(i).getOrderCommodityVo().get(j).
                        setList(commodityInfoMapper.SelectOrderListByNumberVo(infodata.get(i).getOrderCommodityVo().get(j).getCommodityNumber()));
                infodata.get(i).getOrderCommodityVo().get(j).
                        setDataResultObj(commodityInfoDetailsMapper.SelectOrderInfosCByNumber(infodata.get(i).getOrderCommodityVo().get(j).getCommodityNumber()));


            }

        }


        System.out.println(infodata);


        paginationVo.setDataResultList(infodata);
        return paginationVo;

    }
    /*--------------- -----<----*删除*---->--- ----------------------*/

    public PaginationVo DeleteByCommodity(@RequestBody String CommodityInfo, Model model) {
        OrderInfo json = JSONObject.parseObject(CommodityInfo, OrderInfo.class);

        int tostate = orderInfoMapper.DeleteNumber(json.getOrderNumber(), json.getUserId());

        if (tostate != 0)
            paginationVo.setSqlState("Success");
        else
            paginationVo.setSqlState("Error");

        paginationVo.setDataResultObj(json);
        return paginationVo;

    }

    public PaginationVo DeleteByOrderId(@RequestBody String CommodityInfo, Model model) {

        OrderInfo json = JSONObject.parseObject(CommodityInfo, OrderInfo.class);

        int tostate = orderInfoMapper.DeleteorderId(json.getOrderId(), json.getUserId());

        if (tostate != 0)
            paginationVo.setSqlState("Success");
        else
            paginationVo.setSqlState("Error");

        paginationVo.setDataResultObj(json);
        return paginationVo;

    }
    /*--------------- -----<----*增加*---->--- ----------------------*/

    public PaginationVo NewOrder(String commodityInfo, HttpServletRequest request) {

        try {
            HashMap<String, String> map = JSON.parseObject(commodityInfo, new TypeReference<HashMap<String, String>>() {
            });


/*生成订单号*/
            int ToOrderNumber = cchuaTool.getOrderNumber(1, 1);

            List<OrderCommodity> commodity = JSONObject.parseArray(map.get("commodity"), OrderCommodity.class);
            int TotalPay = 0;

            for (int i = 0; i < commodity.size(); i++) {
        /*获取该商品信息*/
                CommodityInfoDetails CommodityInfoData =
                        commodityInfoDetailsMapper.SelectPriceByNumber(commodity.get(i).getCommodityNumber());
/*id*/
                commodity.get(i).setOrderDetailedid(cchuaTool.uuid());

                /*订单编号*/
                commodity.get(i).setOrderNumber(ToOrderNumber);

                /*购买价格*/
                commodity.get(i).setCommodityPrice(CommodityInfoData.getPresentPrice());

                /*计算价格*/
                TotalPay = TotalPay + (CommodityInfoData.getPresentPrice() * commodity.get(i).getBuyAmount());


                int CommodityInfoState = orderCommodityMapper.insertSelective(commodity.get(i));


                if (CommodityInfoState == 0) {
                    paginationVo.setHtmlState("Error:商品列表获取失败");
                    return paginationVo;
                }
            }


            OrderInfo orderinfo = JSONObject.parseObject(map.get("orderinfo"), OrderInfo.class);

/*支付方式的定义*/
            if (orderinfo.getPaymentMethod() == "Wechat") {
                int zf = 1;
            } else {
                int zf = 2;
            }

/*获取各种信息*/
            orderinfo.setOrderNumber(ToOrderNumber);

            orderinfo.setOrderId(cchuaTool.uuid());

            String UserIp = cchuaTool.getRemoteHost(request);

            orderinfo.setOrderMachineIp(UserIp);

            orderinfo.setPaymentAmount(TotalPay);

            int OrderInfoState = orderInfoMapper.insertSelective(orderinfo);


            if (OrderInfoState != 0) {

                /*传第一个商品以及收货地址给微信*/

              /* String firstName= commodityInfoDetailsMapper.SelectPriceByNumber(commodity.get(0).getCommodityNumber()).getTitle();*/



                PaginationVo WechatRequest = weChatPayController.PayResponseOrder(orderinfo,null);

                if (WechatRequest.getHtmlState() != "Error") {


                    JSONObject ToUserOrderNumber = new JSONObject();

                    ToUserOrderNumber.put("OrderNumber", ToOrderNumber);



                    Map payWaitInfo=new HashMap<String, String>();


                    payWaitInfo.put("orderNumbenr",orderinfo.getOrderNumber());
                    payWaitInfo.put("generateTime",orderinfo.getGenerateTime());
                    payWaitInfo.put("paymentState","PendingPay");



                    WechatRequest.setDataResultMap(payWaitInfo);
                    WechatRequest.setHtmlState("Success:订单生成功");
                    return WechatRequest;


                } else {
                    paginationVo.setHtmlState("Error:微信支付订单生成失败，请重传输正确用户数据！");
                    return paginationVo;
                }


            } else {
                paginationVo.setHtmlState("Error:后台订单生成失败，请重新生成订单");
                return paginationVo;
            }


        } catch (Exception e)

        {
            paginationVo.setHtmlState("Error:传递参数错误");
            return paginationVo;
        }

    }


    public PaginationVo NewOrderThenWechat(String commodityInfo, HttpServletRequest request) {

        try {
            HashMap<String, String> map = JSON.parseObject(commodityInfo, new TypeReference<HashMap<String, String>>() {
            });


/*生成订单号*/
            int ToOrderNumber = cchuaTool.getOrderNumber(1, 1);

            List<OrderCommodity> commodity = JSONObject.parseArray(map.get("commodity"), OrderCommodity.class);
            int TotalPay = 0;

            for (int i = 0; i < commodity.size(); i++) {
        /*获取该商品信息*/
                CommodityInfoDetails CommodityInfoData =
                        commodityInfoDetailsMapper.SelectPriceByNumber(commodity.get(i).getCommodityNumber());
/*id*/
                commodity.get(i).setOrderDetailedid(cchuaTool.uuid());

                /*订单编号*/
                commodity.get(i).setOrderNumber(ToOrderNumber);

                /*购买价格*/
                commodity.get(i).setCommodityPrice(CommodityInfoData.getPresentPrice());

                /*计算价格*/
                TotalPay = TotalPay + (CommodityInfoData.getPresentPrice() * commodity.get(i).getBuyAmount());


                int CommodityInfoState = orderCommodityMapper.insertSelective(commodity.get(i));


                if (CommodityInfoState == 0) {
                    paginationVo.setHtmlState("Error:商品列表获取失败");
                    return paginationVo;
                }
            }


            OrderInfo orderinfo = JSONObject.parseObject(map.get("orderinfo"), OrderInfo.class);

/*支付方式的定义*/
            if (orderinfo.getPaymentMethod() == "Wechat") {
                int zf = 1;
            } else {
                int zf = 2;
            }

/*获取各种信息*/
            orderinfo.setOrderNumber(ToOrderNumber);

            orderinfo.setOrderId(cchuaTool.uuid());

            String UserIp = cchuaTool.getRemoteHost(request);

            orderinfo.setOrderMachineIp(UserIp);

            orderinfo.setPaymentAmount(TotalPay);

            int OrderInfoState = orderInfoMapper.insertSelective(orderinfo);


            if (OrderInfoState != 0) {
               /* PaginationVo WechatRequest = weChatPayController.PayResponseOrder(orderinfo);

                if (WechatRequest.getHtmlState() != "Error") {

                    return WechatRequest;


                } else {
                    paginationVo.setHtmlState("Error:微信支付订单生成失败，请重传输正确用户数据！");
                    return paginationVo;
                }*/
                paginationVo.setHtmlState("Success:订单生成功");

                JSONObject ToUserOrderNumber = new JSONObject();

                ToUserOrderNumber.put("OrderNumber", ToOrderNumber);


                paginationVo.setDataResultObj(ToUserOrderNumber);
                return paginationVo;
            } else {
                paginationVo.setHtmlState("Error:后台订单生成失败，请重新生成订单");
                return paginationVo;
            }


        } catch (
                Exception e)

        {
            paginationVo.setHtmlState("Error");
            return paginationVo;
        }

    }

    public PaginationVo SelectByUserId(String commodityInfo) {
        try {
            OrderInfo json = JSONObject.parseObject(commodityInfo, OrderInfo.class);

            List<OrderInfoVo> infodata = orderInfoMapper.SelectByUserId(json.getUserId());

            for (int i = 0; i < infodata.size(); i++) {
                infodata.get(i)
                        .setOrderCommodityVo(orderCommodityMapper.SelectorderlistByNumber(infodata.get(i).getOrderNumber()));

                for (int j = 0; j < infodata.get(i).getOrderCommodityVo().size(); j++) {
                    infodata.get(i).getOrderCommodityVo().get(j).
                            setList(commodityInfoMapper.SelectOrderListByNumberVo(infodata.get(i).getOrderCommodityVo().get(j).getCommodityNumber()));

                }

            }

            paginationVo.setHtmlState("Success");
            paginationVo.setDataResultList(infodata);
        } catch (Exception e) {
            paginationVo.setHtmlState("Error:" + e);

        }
        return paginationVo;
    }


    public PaginationVo SelectByCondition(String commodityInfo) {
        try {
            OrderInfo json = JSONObject.parseObject(commodityInfo, OrderInfo.class);

            List<OrderInfoVo> infodata = orderInfoMapper.SelectByCondition(json);

            for (int i = 0; i < infodata.size(); i++) {
                infodata.get(i)
                        .setOrderCommodityVo(orderCommodityMapper.SelectorderlistByNumber(infodata.get(i).getOrderNumber()));

                for (int j = 0; j < infodata.get(i).getOrderCommodityVo().size(); j++) {
                    infodata.get(i).getOrderCommodityVo().get(j).
                            setList(commodityInfoMapper.SelectOrderListByNumberVo(infodata.get(i).getOrderCommodityVo().get(j).getCommodityNumber()));

                }

            }

            paginationVo.setHtmlState("Success");
            paginationVo.setDataResultList(infodata);
        } catch (Exception e) {
            paginationVo.setHtmlState("Error:" + e);

        }
        return paginationVo;
    }

    public PaginationVo againNewOrder(String commodityInfo, HttpServletRequest request) {





        OrderInfo json = JSONObject.parseObject(commodityInfo, OrderInfo.class);

        List<OrderInfo> orderinfo= orderInfoMapper
                .selectByNumberAndUser(json.getOrderNumber(),json.getUserId());


            if (orderinfo.size() > 0) {

                PaginationVo WechatRequest = weChatPayController.PayResponseOrder(orderinfo.get(0),null);

                if (WechatRequest.getHtmlState() != "Error") {
                    WechatRequest.setHtmlState("Success:订单生成功");

                    JSONObject ToUserOrderNumber = new JSONObject();

                    ToUserOrderNumber.put("OrderNumber", orderinfo.get(0).getOrderNumber());
                    return WechatRequest;


                } else {
                    paginationVo.setHtmlState("Error:微信支付订单生成失败，请重传输正确用户数据！");
                    return paginationVo;
                }


            } else {
                paginationVo.setHtmlState("Error:后台订单生成失败，请重新生成订单");
                return paginationVo;
            }




    }











	/*--------------- -----<----*修改*---->--- ----------------------*/

}
