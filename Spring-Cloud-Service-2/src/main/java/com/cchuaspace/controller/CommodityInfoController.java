package com.cchuaspace.controller;

/*
 * ****************<--*---Code information---*-->**************
 * 	
 *		Author: Cchua
 *		GitHub: https://github.com/vipcchua
 *		Blog  : weibo.com/vipcchua
 * 
 * 
 * ************************************************************/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.swing.text.html.HTML.Tag;
import java.util.UUID;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
import com.cchuaspace.mapper.CommodityInfoMapper;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.pojo.CommodityInfoVo;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.service.CommodityInfoService;
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

@RequestMapping(value = "/Commodit")
@Api(value = "商品信息表", description = "商品信息列表commodity_info")

public class CommodityInfoController {

	private static SqlSessionFactory sqlSessionFactory;
	/* private Logger logger = Logger.getLogger(TableInfoController.class); */

	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private DiscoveryClient client;

	@Resource
	private Application computeServiceApplication;

	@Autowired
	private CommodityInfoService commodityInfoService;
	/*--------------- -----<----*查询*---->--- ----------------------*/

	@ApiOperation(value = "使用商品编号查询商品详细信息", notes = "使用商品Id查询商品详细信息，本接口只能传商品Id", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "commodityNumber", value = "请输入商品编码", required = true, dataType = "varchar"), })

	@RequestMapping(value = "/SelectCommodityByNumber", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> SelectCommodityByNumber(@RequestBody String CommodityInfo, Model model) {

		PaginationVo user = commodityInfoService.SelectCommodityByNumber(CommodityInfo, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	@ApiOperation(value = "使用商品iD查询商品详细信息", notes = "使用商品Id查询商品详细信息，本接口只能传商品Id", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "commodityId", value = "请输入商品Id", required = true, dataType = "varchar"), })
	@RequestMapping(value = "/SelectCommodityById", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> SelectCommodityByID(@RequestBody String CommodityByID, Model model) {

		PaginationVo user = commodityInfoService.SelectCommodityByID(CommodityByID, model);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

	@ApiOperation(value = "动态查询商品信息", notes = "本接口为动态查询商品信息", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@RequestMapping(value = "/SelectCommodityInfo", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> SelectCommodityInfo(@RequestBody String CommodityByID, Model model) {
		PaginationVo user = commodityInfoService.SelectCommodityInfo(CommodityByID, model);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

	/*--------------- -----<----*删除*---->--- ----------------------*/

	@ApiOperation(value = "使用商品编号删除商品详细信息", notes = "使用商品编号删除商品详细信息，本接口只能传商编号", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "commodityNumber", value = "请输入商品Id", required = true, dataType = "varchar"), })

	@RequestMapping(value = "/DeleteCommodityByNumber", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<PaginationVo> DeleteCommodityByNumber(@RequestBody String DeleteCommodityByNumber,
			Model model) {

		PaginationVo user = commodityInfoService.DeleteCommodityByNumber(DeleteCommodityByNumber, model);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

	@ApiOperation(value = "使用商品id删除商品详细信息", notes = "使用商品Id删除商品详细信息，本接口只能传商编号", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "commodityId", value = "请输入商品Id", required = true, dataType = "varchar"), })
	@RequestMapping(value = "/DeleteCommodityById", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<PaginationVo> DeleteCommodityById(@RequestBody String DeleteCommodityById, Model model) {

		PaginationVo user = commodityInfoService.DeleteCommodityById(DeleteCommodityById, model);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	
	/*--------------- -----<----*增加*---->--- ----------------------*/
	@ApiOperation(value = "增加商品详细信息", notes = "增加商品详细信息，本接口只能传商品Id", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/InsertCommodityInfo", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> InsertCommodityInfo(@RequestBody String InsertCommodityInfo, Model model) {

		PaginationVo user = commodityInfoService.InsertCommodityInfo(InsertCommodityInfo, model);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

	/*--------------- -----<----*修改*---->--- ----------------------*/

	@ApiOperation(value = "使用商品iD修改商品详细信息", notes = "使用商品Id修改商品详细信息，本接口只能传商品Id", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/UpdCommodityInfoById", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> UpdCommodityInfoById(@RequestBody String CommodityByID, Model model) {

		PaginationVo user = commodityInfoService.UpdCommodityInfoById(CommodityByID, model);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	@ApiOperation(value = "使用商品编号修改商品详细信息", notes = "使用商品编号修改商品详细信息，本接口只能传商品Id", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/UpdCommodityInfoByNumber", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> UpdCommodityInfoByNumber(@RequestBody String UpdCommodityInfoByNumber,
			Model model) {

		PaginationVo user = commodityInfoService.UpdCommodityInfoByNumber(UpdCommodityInfoByNumber, model);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

	private String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		return uuid;
	}

}
