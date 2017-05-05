package com.cchuaspace.wechat.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cchuaspace.wechat.tool.AesException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.apache.ibatis.session.SqlSessionFactory;

import com.cchuaspace.Application;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.wechat.service.WeChatLoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * http://localhost:8080//hhh?name=d62&age=23
 */
@Controller
@RestController
@Scope("prototype")
@RequestMapping(value = "/api/wechat")
@Api(value = "微信登陆的相关操作", description = "微信登陆的相关操作")

public class WeChatLoginController {

    private static SqlSessionFactory sqlSessionFactory;
    /* private Logger logger = Logger.getLogger(TableInfoController.class); */

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private WeChatLoginService weChatLoginService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private Application computeServiceApplication;
    String AppId = "wx253b97a570d99ccc";
    String AppSecret = "3c91bb1f519ad2604e78b7115deec5a5";

	/*--------------- -----<----*查询*---->--- ----------------------*/

    @ApiOperation(value = "获取appid", notes = "获取appid", response = CommodityInfo.class)
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commodityNumber", value = "请输入商品编码", required = true, dataType = "varchar"),})

    @RequestMapping(value = "/authorize", method = {RequestMethod.POST})
    @ResponseBody

    public ResponseEntity<PaginationVo> getAppId(HttpServletRequest request, HttpServletResponse response) {

        PaginationVo user = weChatLoginService.authorize(request, response);

        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
        return data;

    }


    @ApiOperation(value = "无appid的状况下登陆获取数据", notes = "无appid的状况下登陆获取数据", response = CommodityInfo.class)
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "请输入当前code 该接口不支持api调试", required = true, dataType = "varchar"),})


    @RequestMapping(value = "/postwcode", method = {RequestMethod.POST})
    @ResponseBody

    public ResponseEntity<PaginationVo> postwcode(@RequestBody String CommodityInfo) {

        PaginationVo user = weChatLoginService.postwcode(CommodityInfo);

        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
        return data;

    }


    @ApiOperation(value = "有appid的状况下登陆获取数据", notes = "有appid的状况下登陆获取数据", response = CommodityInfo.class)
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "请输入当前code 该接口不支持api调试", required = true, dataType = "varchar"),})


    @RequestMapping(value = "/openidata", method = {RequestMethod.POST})
    @ResponseBody

    public ResponseEntity<PaginationVo> appiddata(@RequestBody String openid) {

        PaginationVo user = weChatLoginService.openidata(openid);

        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
        return data;

    }

	
	
	
	/*---------------------------------------------------------------------------------*/


    @RequestMapping(value = "/accesstoken", method = {RequestMethod.POST})
    @ResponseBody

    public ResponseEntity<PaginationVo> getOpenId(@RequestBody String CommodityInfo) {

        PaginationVo user = weChatLoginService.accesstoken(CommodityInfo);

        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
        return data;

    }

    @RequestMapping(value = "/refreshtoken", method = {RequestMethod.POST})
    @ResponseBody

    public ResponseEntity<PaginationVo> refreshtoken(@RequestBody String CommodityInfo) {

        PaginationVo user = weChatLoginService.refreshtoken(CommodityInfo);

        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
        return data;

    }

    @RequestMapping(value = "/userinfo", method = {RequestMethod.POST})
    @ResponseBody

    public ResponseEntity<PaginationVo> userinfo(@RequestBody String CommodityInfo) {

        PaginationVo user = weChatLoginService.accesstoken(CommodityInfo);

        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
        return data;

    }

    /* 检验授权凭证（access_token）是否有效 */
    @RequestMapping(value = "/examinetoken", method = {RequestMethod.POST})
    @ResponseBody

    public ResponseEntity<PaginationVo> examinetoken(@RequestBody String CommodityInfo) {

        PaginationVo user = weChatLoginService.examinetoken(CommodityInfo);

        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
        return data;

    }


    @RequestMapping(value = "/userinfobyopid", method = {RequestMethod.POST})
    @ResponseBody

    public ResponseEntity<PaginationVo> UserInfoByOpenId(@RequestBody String CommodityInfo) {

        PaginationVo user = weChatLoginService.UserInfoByOpenId(CommodityInfo);

        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
        return data;

    }


    @RequestMapping(value = "/wechatevent", method = { RequestMethod.GET })
	@ResponseBody

	public String wechatevent(
			@RequestParam(value = "signature", required = true) String signature,
		@RequestParam(value = "timestamp", required = true) String timestamp,
		@RequestParam(value = "nonce", required = true) String nonce,
		@RequestParam(value = "echostr", required = true) String echostr

			) throws AesException {



		String wecdata = weChatLoginService.wechatevent(signature,timestamp,nonce,echostr);

		return wecdata;

	}
    @RequestMapping(value = "/pushserver", method = { RequestMethod.GET })
    @ResponseBody

    public String validateserver(
            @RequestParam(value = "signature", required = true) String signature,
            @RequestParam(value = "timestamp", required = true) String timestamp,
            @RequestParam(value = "nonce", required = true) String nonce,
            @RequestParam(value = "echostr", required = true) String echostr

    )  {

        System.out.print(echostr);


        return echostr;

    }





}


