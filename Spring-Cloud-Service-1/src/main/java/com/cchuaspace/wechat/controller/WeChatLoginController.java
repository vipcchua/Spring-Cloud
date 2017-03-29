package com.cchuaspace.wechat.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML.Tag;
import java.util.UUID;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONStreamAware;
import com.cchuaspace.Application;
import com.cchuaspace.currency.AesUtils;
import com.cchuaspace.currency.RSAUtils;
import com.cchuaspace.mapper.CommodityCatalogMapper;
import com.cchuaspace.mapper.CommodityInfoMapper;
import com.cchuaspace.model.CommodityCatalog;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.OrderInfo;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.service.CommodityCatalogService;
import com.cchuaspace.wechat.service.WeChatLoginService;
import com.mysql.cj.core.exceptions.PasswordExpiredException;

import groovy.lang.IntRange;
import groovy.transform.builder.InitializerStrategy.SET;

import org.json.JSONObject;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
@RequestMapping(value = "/api/wecaht")
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
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "commodityNumber", value = "请输入商品编码", required = true, dataType = "varchar"), })
	
	@RequestMapping(value = "/authorize", method = { RequestMethod.POST })
	@ResponseBody

	public ResponseEntity<PaginationVo> getAppId(HttpServletRequest request, HttpServletResponse response) {

		PaginationVo user = weChatLoginService.authorize(request, response);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

	
	@ApiOperation(value = "无appid的状况下登陆获取数据", notes = "无appid的状况下登陆获取数据", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "code", value = "请输入当前code 该接口不支持api调试", required = true, dataType = "varchar"), })
	
	
	@RequestMapping(value = "/postwcode", method = { RequestMethod.POST })
	@ResponseBody

	public ResponseEntity<PaginationVo> postwcode(@RequestBody String CommodityInfo) {

		PaginationVo user = weChatLoginService.postwcode(CommodityInfo);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}
	
	
	
	@ApiOperation(value = "有appid的状况下登陆获取数据", notes = "有appid的状况下登陆获取数据", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "code", value = "请输入当前code 该接口不支持api调试", required = true, dataType = "varchar"), })
	
	
	@RequestMapping(value = "/openidata", method = { RequestMethod.POST })
	@ResponseBody

	public ResponseEntity<PaginationVo> appiddata(@RequestBody String openid) {

		PaginationVo user = weChatLoginService.openidata(openid);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}
	
	
	
	
	/*---------------------------------------------------------------------------------*/
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/accesstoken", method = { RequestMethod.POST })
	@ResponseBody

	public ResponseEntity<PaginationVo> getOpenId(@RequestBody String CommodityInfo) {

		PaginationVo user = weChatLoginService.accesstoken(CommodityInfo);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

	@RequestMapping(value = "/refreshtoken", method = { RequestMethod.POST })
	@ResponseBody

	public ResponseEntity<PaginationVo> refreshtoken(@RequestBody String CommodityInfo) {

		PaginationVo user = weChatLoginService.refreshtoken(CommodityInfo);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

	@RequestMapping(value = "/userinfo", method = { RequestMethod.POST })
	@ResponseBody

	public ResponseEntity<PaginationVo> userinfo(@RequestBody String CommodityInfo) {

		PaginationVo user = weChatLoginService.accesstoken(CommodityInfo);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

	/* 检验授权凭证（access_token）是否有效 */
	@RequestMapping(value = "/examinetoken", method = { RequestMethod.POST })
	@ResponseBody

	public ResponseEntity<PaginationVo> examinetoken(@RequestBody String CommodityInfo) {

		PaginationVo user = weChatLoginService.examinetoken(CommodityInfo);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}



	@RequestMapping(value = "/userinfobyopid", method = { RequestMethod.POST })
	@ResponseBody

	public ResponseEntity<PaginationVo> UserInfoByOpenId(@RequestBody String CommodityInfo) {

		PaginationVo user = weChatLoginService.UserInfoByOpenId(CommodityInfo);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

}
