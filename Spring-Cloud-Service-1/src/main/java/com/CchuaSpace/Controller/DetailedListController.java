package com.CchuaSpace.Controller;

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

import java.util.UUID;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.CchuaSpace.Application;
import com.CchuaSpace.Currency.AesUtils;
import com.CchuaSpace.Currency.RSAUtils;
import com.CchuaSpace.Mapper.CommodityInfoMapper;
import com.CchuaSpace.Mapper.DetailedListMapper;
import com.CchuaSpace.Model.CommodityInfo;
import com.CchuaSpace.Model.DetailedList;
import com.CchuaSpace.Model.TableUser;
import com.alibaba.fastjson.JSON;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "购物车列表", description = "购物车列表 detailed_list")
@RequestMapping(value = "/Detailed")
public class DetailedListController {

	private static SqlSessionFactory sqlSessionFactory;
	/* private Logger logger = Logger.getLogger(TableInfoController.class); */

	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private DiscoveryClient client;

	@Autowired
	private DetailedListMapper detailedListMapper;

	@Resource
	private Application computeServiceApplication;

	/*--------------- -----<----*查询*---->--- ----------------------*/
	@ApiOperation(value = "使用用户Id查询购物车", notes = "使用商品Id查询购物车", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "UserId", value = "请输入对应参数", required = true, dataType = "varchar"), })

	@RequestMapping(value = "/SelectByUserId", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<List<DetailedList>> SelectDetailedListByUserId(@RequestBody String CommodityInfo,
			Model model) {
		List<DetailedList> json = JSON.parseArray(CommodityInfo, DetailedList.class);
		List<DetailedList> user = detailedListMapper.SelectDetailedListByUserId(json.get(0).getUserId());
		ResponseEntity<List<DetailedList>> data = new ResponseEntity<List<DetailedList>>(user, HttpStatus.OK);
		System.out.println(data);
		return data;

	}

	@ApiOperation(value = "使用购物车Id查询购物车", notes = "使用购物车Id查询购物车", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "detailedId", value = "请输入对应参数", required = true, dataType = "varchar"), })

	@RequestMapping(value = "/SelectByDetailedId", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<List<DetailedList>> SelectDetailedListByDetailedId(@RequestBody String CommodityInfo,
			Model model) {
		List<DetailedList> json = JSON.parseArray(CommodityInfo, DetailedList.class);
		List<DetailedList> user = detailedListMapper.SelectDetailedListByDetailedId(json.get(0).getDetailedId());
		ResponseEntity<List<DetailedList>> data = new ResponseEntity<List<DetailedList>>(user, HttpStatus.OK);

		return data;

	}

	/*--------------- -----<----*删除*---->--- ----------------------*/

	@ApiOperation(value = "使用购物车Id删除购物车对应商品", notes = "使用购物车Id删除购物车对应商品", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "detailedId", value = "请输入对应参数", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "commodityNumber", value = "请输入对应参数", required = true, dataType = "varchar") })

	@RequestMapping(value = "/DeleteByCommodity", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<List<DetailedList>> DeleteByCommodity(@RequestBody String CommodityInfo, Model model) {
		List<DetailedList> json = JSON.parseArray(CommodityInfo, DetailedList.class);
		int tostate = detailedListMapper.DeleteByCommodity(json.get(0).getDetailedId(),
				json.get(0).getCommodityNumber());

		if (tostate != 0)
			json.get(0).setSqlstate("Success");
		else
			json.get(0).setSqlstate("ERROR");

		ResponseEntity<List<DetailedList>> data = new ResponseEntity<List<DetailedList>>(json, HttpStatus.OK);

		return data;

	}

	@ApiOperation(value = "使用用户Id删除购物车对应商品", notes = "使用用户Id删除购物车对应商品", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "detailedId", value = "请输入对应参数", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "UserId", value = "请输入对应参数", required = true, dataType = "varchar") })

	@RequestMapping(value = "/DeleteBydetailedId", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<List<DetailedList>> DeleteBydetailedId(@RequestBody String CommodityInfo, Model model) {
		List<DetailedList> json = JSON.parseArray(CommodityInfo, DetailedList.class);
		int tostate = detailedListMapper.DeleteBydetailedId(json.get(0).getUserId(), json.get(0).getDetailedId());

		if (tostate != 0)
			json.get(0).setSqlstate("Success");
		else
			json.get(0).setSqlstate("ERROR");

		ResponseEntity<List<DetailedList>> data = new ResponseEntity<List<DetailedList>>(json, HttpStatus.OK);

		return data;

	}

	@ApiOperation(value = "使用用户Id删除购物车对应商品", notes = "使用用户Id删除购物车对应商品", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "commodityNumber", value = "请输入对应参数", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "userid", value = "请输入对应参数", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "detailedId", value = "请输入对应参数", required = true, dataType = "varchar")

	})

	@RequestMapping(value = "/DeleteCommodity", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<List<DetailedList>> DeleteCommodity(@RequestBody String CommodityInfo, Model model) {
		List<DetailedList> json = JSON.parseArray(CommodityInfo, DetailedList.class);
		int tostate = detailedListMapper.DeleteCommodity(json.get(0));

		if (tostate != 0)
			json.get(0).setSqlstate("Success");
		else
			json.get(0).setSqlstate("ERROR");

		ResponseEntity<List<DetailedList>> data = new ResponseEntity<List<DetailedList>>(json, HttpStatus.OK);

		return data;

	}

	@ApiOperation(value = "使用用户Id删除购物车全部商品", notes = "使用用户Id删除购物车全部商品", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({

			@ApiImplicitParam(name = "UserId", value = "请输入对应参数", required = true, dataType = "varchar") })

	@RequestMapping(value = "/DeleteAll", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<List<DetailedList>> DeleteAlldetailed(@RequestBody String CommodityInfo, Model model) {
		List<DetailedList> json = JSON.parseArray(CommodityInfo, DetailedList.class);
		int tostate = detailedListMapper.DeleteAlldetailed(json.get(0).getUserId());

		if (tostate != 0)
			json.get(0).setSqlstate("Success");
		else
			json.get(0).setSqlstate("ERROR");

		ResponseEntity<List<DetailedList>> data = new ResponseEntity<List<DetailedList>>(json, HttpStatus.OK);

		return data;

	}

	/*--------------- -----<----*增加*---->--- ----------------------*/

	@ApiOperation(value = "新增对应用户的购物车商品", notes = "新增对应用户的购物车商品", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/InsertDetailed", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<List<DetailedList>> InsertDetailedListInfo(@RequestBody String CommodityInfo, Model model) {
		List<DetailedList> json = JSON.parseArray(CommodityInfo, DetailedList.class);
		json.get(0).setDetailedId(uuid());
		int tostate = detailedListMapper.InsertDetailedList(json.get(0));

		if (tostate != 0)
			json.get(0).setSqlstate("Success");
		else
			json.get(0).setSqlstate("ERROR");

		ResponseEntity<List<DetailedList>> data = new ResponseEntity<List<DetailedList>>(json, HttpStatus.OK);

		return data;

	}

	/*--------------- -----<----*修改*---->--- ----------------------*/

	@ApiOperation(value = "使用用户Id修改购物车商品", notes = "使用用户Id修改购物车商品", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({})

	@RequestMapping(value = "/UpdateByUserId", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<List<DetailedList>> UpdateCommodityByUserId(@RequestBody String CommodityInfo, Model model) {
		List<DetailedList> json = JSON.parseArray(CommodityInfo, DetailedList.class);

		int tostate = detailedListMapper.UpdateCommodityByUserId(json.get(0));

		if (tostate != 0)
			json.get(0).setSqlstate("Success");
		else
			json.get(0).setSqlstate("ERROR");

		ResponseEntity<List<DetailedList>> data = new ResponseEntity<List<DetailedList>>(json, HttpStatus.OK);

		return data;

	}

	@ApiOperation(value = "使用购物车Id修改购物车商品", notes = "使用购物车Id修改购物车商品", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@RequestMapping(value = "/UpdateByDetailedId", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<List<DetailedList>> UpdateCommodityBydetailedId(@RequestBody String CommodityInfo,
			Model model) {
		List<DetailedList> json = JSON.parseArray(CommodityInfo, DetailedList.class);
		int tostate = detailedListMapper.UpdateCommodityBydetailedId(json.get(0));

		if (tostate != 0)
			json.get(0).setSqlstate("Success");
		else
			json.get(0).setSqlstate("ERROR");

		ResponseEntity<List<DetailedList>> data = new ResponseEntity<List<DetailedList>>(json, HttpStatus.OK);

		return data;

	}

	private String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		return uuid;
	}

}
