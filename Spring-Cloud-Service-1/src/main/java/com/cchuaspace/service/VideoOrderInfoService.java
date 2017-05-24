package com.cchuaspace.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.TypeReference;
import com.cchuaspace.currency.CchuaTool;
import com.cchuaspace.mapper.*;
import com.cchuaspace.model.*;
import com.cchuaspace.pojo.OrderCommodityVo;
import com.cchuaspace.wechat.controller.WeChatPayController;
import com.cchuaspace.wechat.controller.WeChatPayVideoController;
import com.cchuaspace.wechat.model.WechatOrderPayApi;
import com.cchuaspace.wechat.model.WechatPayInfo;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
public class VideoOrderInfoService {


    @Autowired
    private VideoInfoMapper videoInfoMapper;


    @Autowired
    private VideoOrderInfoMapper videoOrderInfoMapper;
    @Autowired
    private VideoOrderCommodityMapper videoOrderCommodityMapper;


    @Autowired
    private PaginationVo paginationVo;


    @Autowired
    private CchuaTool cchuaTool;

    @Autowired
    private WeChatPayVideoController weChatPayController;


	/*--------------- -----<----*查询*---->--- ----------------------*/


    public PaginationVo selectAndPayByNumber(String commodityInfo, HttpServletRequest request) {
        try {
            HashMap<String, String> map = JSON.parseObject(commodityInfo, new TypeReference<HashMap<String, String>>() {
            });


            List<VideoOrderCommodity> commodity = JSONObject.parseArray(map.get("commodity"), VideoOrderCommodity.class);
            VideoOrderInfo orderInfo = JSONObject.parseObject(map.get("orderinfo"), VideoOrderInfo.class);



            List<VideoOrderCommodity> videoPayInfo = videoOrderCommodityMapper.selectByNumberUser(commodity.get(0).getVideoNumber(), orderInfo.getUserId());

            if (videoPayInfo.size()>0){
                List<VideoOrderInfo> PaySuccess =  videoOrderInfoMapper.selectByNumber(videoPayInfo.get(0).getOrderNumber());

                if (PaySuccess.get(0).getPaymentState().equals("Success")||PaySuccess.get(0).getPaymentState().equals("SUCCESS")) {
                    List<VideoInfo> videoInfo = videoInfoMapper.selectByNumber(commodity.get(0).getVideoNumber());

                    paginationVo.setDataResultList(videoInfo);
                    paginationVo.setHtmlState("Success:Success");
                    return paginationVo;
                }
                else {
                    VideoOrderInfo paytoinfo = videoOrderInfoMapper.selectPayResultByNumber(videoPayInfo.get(0).getOrderNumber());



                    WechatPayInfo topay = JSONObject.parseObject(paytoinfo.getWechatPayResult(), WechatPayInfo.class);

                    paginationVo.setDataResultObj(topay);
                    paginationVo.setHtmlState("Success:PendingPay");
                    return paginationVo;
                }

            }





          else {
                int TotalPay = 0;
                int ToOrderNumber = cchuaTool.getOrderNumber(1, 1);
                for (int i = 0; i < commodity.size(); i++) {
        /*获取该商品信息*/
                    VideoInfo CommodityInfoData =
                            videoInfoMapper.selectPriceByNumber(commodity.get(i).getVideoNumber());
/*id*/
                    commodity.get(i).setId(cchuaTool.uuid());
                /*生成订单号*/

                /*订单编号*/
                    commodity.get(i).setOrderNumber(ToOrderNumber);
                    commodity.get(i).setUserId(orderInfo.getUserId());

                /*购买价格*/
                    commodity.get(i).setCommodityPrice(CommodityInfoData.getPresentPrice());

                /*计算价格*/
                    TotalPay = TotalPay + (CommodityInfoData.getPresentPrice() * commodity.get(i).getBuyAmount());



                    int CommodityInfoState = videoOrderCommodityMapper.insertSelective(commodity.get(i));


                    if (CommodityInfoState == 0) {
                        paginationVo.setHtmlState("Error:商品列表获取失败");
                        return paginationVo;
                    }
                }



/*支付方式的定义*/

/*获取各种信息*/
                orderInfo.setOrderNumber(ToOrderNumber);

                orderInfo.setOrderId(cchuaTool.uuid());

                String UserIp = cchuaTool.getRemoteHost(request);

                orderInfo.setOrderMachineIp(UserIp);

                orderInfo.setPaymentAmount(TotalPay);

                int OrderInfoState = videoOrderInfoMapper.insertSelective(orderInfo);


                if (OrderInfoState != 0) {

                    PaginationVo WechatRequest = weChatPayController.PayResponseOrder(orderInfo, null);

                    if (WechatRequest.getHtmlState() != "Error") {


                        JSONObject ToUserOrderNumber = new JSONObject();

                        ToUserOrderNumber.put("OrderNumber", ToOrderNumber);


                        Map payWaitInfo = new HashMap<String, String>();


                        payWaitInfo.put("orderNumbenr", orderInfo.getOrderNumber());
                        payWaitInfo.put("generateTime", orderInfo.getGenerateTime());
                        payWaitInfo.put("paymentState", "PendingPay");


                        WechatRequest.setDataResultMap(payWaitInfo);
                        WechatRequest.setHtmlState("Success:PendingPay");
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

        } catch (Exception e)

        {
            paginationVo.setHtmlState("Error:传递参数错误");
            return paginationVo;
        }

    }












	/*--------------- -----<----*修改*---->--- ----------------------*/

}
