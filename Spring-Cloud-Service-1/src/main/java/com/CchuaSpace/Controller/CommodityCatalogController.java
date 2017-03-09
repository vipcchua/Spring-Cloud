package com.CchuaSpace.Controller;

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
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.CchuaSpace.Application;
import com.CchuaSpace.Currency.AesUtils;
import com.CchuaSpace.Currency.RSAUtils;
import com.CchuaSpace.Mapper.CommodityCatalogMapper;
import com.CchuaSpace.Mapper.CommodityInfoMapper;
import com.CchuaSpace.Model.CommodityCatalog;
import com.CchuaSpace.Model.CommodityInfo;
import com.CchuaSpace.Model.OrderInfo;
import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONStreamAware;
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
@RequestMapping(value = "/Catalog")
@Api(value = "目录列表的相关操作", description = "目录列表 commodity_catalog")

public class CommodityCatalogController {

	private static SqlSessionFactory sqlSessionFactory;
	/* private Logger logger = Logger.getLogger(TableInfoController.class); */

	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private DiscoveryClient client;

	@Autowired
	private CommodityCatalogMapper commodityCatalogMapper;

	@Resource
	private Application computeServiceApplication;

	/*--------------- -----<----*查询*---->--- ----------------------*/
	@ApiOperation(value = "查询目录", notes = "传入深度 父亲ID 查询该深度的目录信息 如果是首层 父亲Id请使用0", response = CommodityCatalog.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "parentsId", value = "请输入对应参数", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "depth", value = "请输入对应参数", required = true, dataType = "varchar"), })

	@RequestMapping(value = "/SelectCatalog", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<List<CommodityCatalog>> SelectCatalog(@RequestBody String CommodityInfo, Model model) {
		List<CommodityCatalog> json = JSON.parseArray(CommodityInfo, CommodityCatalog.class);
		List<CommodityCatalog> user = commodityCatalogMapper.SelectCatalog(json.get(0));
		ResponseEntity<List<CommodityCatalog>> data = new ResponseEntity<List<CommodityCatalog>>(user, HttpStatus.OK);

		return data;

	}

	/*--------------- -----<----*删除*---->--- ----------------------*/

	@ApiOperation(value = "使用3种条件使用目录中的一项", notes = "删除", response = CommodityCatalog.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "parentsId", value = "请输入对应参数", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "nodeName", value = "请输入对应参数", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "depth", value = "请输入对应参数", required = true, dataType = "varchar")

	})

	@RequestMapping(value = "/DeleteCatalog", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<List<CommodityCatalog>> DeleteByCommodity(@RequestBody String CommodityInfo, Model model) {
		List<CommodityCatalog> json = JSON.parseArray(CommodityInfo, CommodityCatalog.class);
		int tostate = commodityCatalogMapper.DeleteCatalog(json.get(0));

		if (tostate != 0)
			json.get(0).setSqlstate("Success");
		else
			json.get(0).setSqlstate("ERROR");

		ResponseEntity<List<CommodityCatalog>> data = new ResponseEntity<List<CommodityCatalog>>(json, HttpStatus.OK);

		return data;

	}

	@ApiOperation(value = "直接使用Id删除目录中的一项", notes = "删除", response = CommodityCatalog.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "catalog_id", value = "请输入对应参数", required = true, dataType = "varchar"), })

	@RequestMapping(value = "/DeleteCatalogById", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<List<CommodityCatalog>> DeleteCatalogById(@RequestBody String CommodityInfo, Model model) {
		List<CommodityCatalog> json = JSON.parseArray(CommodityInfo, CommodityCatalog.class);
		int tostate = commodityCatalogMapper.DeleteCatalog(json.get(0));

		if (tostate != 0)
			json.get(0).setSqlstate("Success");
		else
			json.get(0).setSqlstate("ERROR");

		ResponseEntity<List<CommodityCatalog>> data = new ResponseEntity<List<CommodityCatalog>>(json, HttpStatus.OK);

		return data;

	}

	/*--------------- -----<----*增加*---->--- ----------------------*/

	@ApiOperation(value = "新增目录信息", notes = "新增目录信息", response = CommodityCatalog.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "parentsId", value = "请输入对应信息", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "nodeName", value = "输入对应信息", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "depth", value = "输入对应信息", required = true, dataType = "varchar")

	})

	@RequestMapping(value = "/InsertCommodityInfo", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<List<CommodityCatalog>> InsertCommodityInfo(@RequestBody String CommodityInfo, Model model) {
		List<CommodityCatalog> json = JSON.parseArray(CommodityInfo, CommodityCatalog.class);
		json.get(0).setCatalogId(uuid());
		List<CommodityCatalog> user = commodityCatalogMapper.InsertCommodityInfo(json.get(0));
		ResponseEntity<List<CommodityCatalog>> data = new ResponseEntity<List<CommodityCatalog>>(user, HttpStatus.OK);

		return data;

	}

	/*--------------- -----<----*修改*---->--- ----------------------*/

	@ApiOperation(value = "修改目录名称", notes = "修改目录名称", response = CommodityCatalog.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "catalogId", value = "请输入商品编码", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "nodeName", value = "请输入商品编码", required = true, dataType = "varchar")

	})

	@RequestMapping(value = "/UpdateCatalog", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<List<CommodityCatalog>> UpdateCatalog(@RequestBody String CommodityInfo, Model model) {
		List<CommodityCatalog> json = JSON.parseArray(CommodityInfo, CommodityCatalog.class);
		int tostate = commodityCatalogMapper.UpdateCatalog(json.get(0));

		if (tostate != 0)
			json.get(0).setSqlstate("Success");
		else
			json.get(0).setSqlstate("ERROR");

		ResponseEntity<List<CommodityCatalog>> data = new ResponseEntity<List<CommodityCatalog>>(json, HttpStatus.OK);

		return data;

	}

	private String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		return uuid;
	}

}
