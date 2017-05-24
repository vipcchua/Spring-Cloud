package com.cchuaspace.wechat.controller;

import com.cchuaspace.Application;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.OrderInfo;
import com.cchuaspace.model.VideoOrderInfo;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.wechat.service.WeChatPayService;
import com.cchuaspace.wechat.service.WeChatPayVideoService;
import io.swagger.annotations.*;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * http://localhost:8080//hhh?name=d62&age=23
 */
@Controller
@RestController
@Scope("prototype")
@RequestMapping(value = "/api/wechat/pay/video")
@Api(value = "微信登陆的相关操作", description = "微信登陆的相关操作")

public class WeChatPayVideoController {


    @Autowired
    private WeChatPayVideoService weChatPayService;


	/*--------------- -----<----*生成订单*---->--- ----------------------*/

    /*重订单处直接发送订单信息生成微信订单(视频支付)*/
    public PaginationVo PayResponseOrder(VideoOrderInfo orderInfo, String data) {
        PaginationVo paginationVo= weChatPayService.PayByVideoOrder(orderInfo,data);
        return paginationVo;
    }


    @ApiOperation(value = "支付回调URL", notes = "支付回调URL")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})


    @RequestMapping(value = "/payresponse", method = RequestMethod.POST)
    @ResponseBody
    public String PayResponse(@RequestBody String PayResponse) {
        System.out.print(PayResponse);
        String notifySuccess = weChatPayService.Payresponse(PayResponse);


        return notifySuccess;

    }


    @ApiOperation(value = "微信退款", notes = "微信退款", response = CommodityInfo.class)
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commodityNumber", value = "请输入商品编码", required = true, dataType = "varchar"),})

    @RequestMapping(value = "/wechatrefund", method = {RequestMethod.POST})
    @ResponseBody

    public ResponseEntity<PaginationVo> WechatRefund(@RequestBody String GenerateOrder) {

        PaginationVo user = weChatPayService.WechatRefund(GenerateOrder);

        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
        return data;

    }


}
