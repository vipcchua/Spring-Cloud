package com.cchuaspace.wechat.controller;

import com.cchuaspace.Application;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.OrderInfo;
import com.cchuaspace.model.VideoOrderInfo;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.wechat.service.WeChatLoginService;
import com.cchuaspace.wechat.service.WeChatPayService;
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
import javax.servlet.http.HttpServletResponse;

/**
 * http://localhost:8080//hhh?name=d62&age=23
 */
@Controller
@RestController
@Scope("prototype")
@RequestMapping(value = "/api/wechat/pay")
@Api(value = "微信登陆的相关操作", description = "微信登陆的相关操作")

public class WeChatPayController {

    private static SqlSessionFactory sqlSessionFactory;
    /* private Logger logger = Logger.getLogger(TableInfoController.class); */

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private WeChatPayService weChatPayService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private Application computeServiceApplication;
    String AppId = "wx253b97a570d99ccc";
    String AppSecret = "3c91bb1f519ad2604e78b7115deec5a5";

	/*--------------- -----<----*生成订单*---->--- ----------------------*/

    @ApiOperation(value = "生成订单", notes = "生成订单", response = CommodityInfo.class)
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commodityNumber", value = "请输入商品编码", required = true, dataType = "varchar"),})

    @RequestMapping(value = "/generateorder", method = {RequestMethod.POST})
    @ResponseBody

    public ResponseEntity<PaginationVo> GenerateOrder(@RequestBody String GenerateOrder,HttpServletRequest request) {

        PaginationVo user = weChatPayService.GenerateOrder(GenerateOrder);

        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
        return data;

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









/*重订单处直接发送订单信息生成微信订单*/
    public PaginationVo PayResponseOrder(OrderInfo orderInfo,String data) {
        PaginationVo paginationVo= weChatPayService.PayByOrder(orderInfo,data);
        return paginationVo;
    }



    @ApiOperation(value = "获取订单信息后生成订单", notes = "生成订单", response = CommodityInfo.class)
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commodityNumber", value = "请输入商品编码", required = true, dataType = "varchar"),})

    @RequestMapping(value = "/wechatpay", method = {RequestMethod.POST})
    @ResponseBody

    public ResponseEntity<PaginationVo> WechatPay(@RequestBody String GenerateOrder) {

        PaginationVo user = weChatPayService.WechatPay(GenerateOrder);

        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
        return data;

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


    @ApiOperation(value = "微信订单关闭", notes = "微信订单关闭", response = CommodityInfo.class)
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commodityNumber", value = "请输入商品编码", required = true, dataType = "varchar"),})

    @RequestMapping(value = "/closeorder", method = {RequestMethod.POST})
    @ResponseBody

    public ResponseEntity<PaginationVo> WechatCloseorder(@RequestBody String GenerateOrder) {

        PaginationVo user = weChatPayService.WechatCloseorder(GenerateOrder);

        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
        return data;

    }



}
