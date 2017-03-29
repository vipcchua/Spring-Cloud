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

import java.util.UUID;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.cchuaspace.Application;
import com.cchuaspace.currency.AesUtils;
import com.cchuaspace.currency.RSAUtils;
import com.cchuaspace.mapper.CommodityInfoMapper;
import com.cchuaspace.mapper.DetailedListMapper;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.DetailedList;
import com.cchuaspace.model.TableUser;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.service.CommodityInfoService;
import com.cchuaspace.service.DetailedListService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Scope("prototype")
@Api(value = "购物车列表", description = "购物车列表 detailed_list")
@RequestMapping(value = "/api/detailed")
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

	@Autowired
	private DetailedListService detailedListService;

	/*--------------- -----<----*查询*---->--- ----------------------*/
	@ApiOperation(value = "使用用户Id查询购物车", notes = "使用商品Id查询购物车", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "UserId", value = "请输入对应参数", required = true, dataType = "varchar"), })

	@RequestMapping(value = "/SelectByUserId", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> SelectDetailedListByUserId(@RequestBody String CommodityInfo, Model model) {

		PaginationVo user = detailedListService.SelectDetailedListByUserId(CommodityInfo, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

	@ApiOperation(value = "使用购物车Id查询购物车", notes = "使用购物车Id查询购物车", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "detailedId", value = "请输入对应参数", required = true, dataType = "varchar"), })

	@RequestMapping(value = "/SelectByDetailedId", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> SelectDetailedListByDetailedId(@RequestBody String CommodityInfo, Model model) {

		PaginationVo user = detailedListService.SelectDetailedListByDetailedId(CommodityInfo, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
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

	public ResponseEntity<PaginationVo> DeleteByCommodity(@RequestBody String CommodityInfo, Model model) {

		PaginationVo user = detailedListService.DeleteByCommodity(CommodityInfo, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

	@ApiOperation(value = "使用用户Id删除购物车对应商品", notes = "使用用户Id删除购物车对应商品", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "detailedId", value = "请输入对应参数", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "userid", value = "请输入对应参数", required = true, dataType = "varchar") })

	@RequestMapping(value = "/DeleteBydetailedId", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> DeleteBydetailedId(@RequestBody String CommodityInfo, Model model) {

		
		
		PaginationVo user = detailedListService.DeleteBydetailedId(CommodityInfo, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

	@ApiOperation(value = "使用用户Id删除购物车对应商品", notes = "使用用户Id删除购物车对应商品", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "commodityNumber", value = "请输入对应参数", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "userid", value = "请输入对应参数", required = true, dataType = "varchar"),
		
	})

	@RequestMapping(value = "/DeleteCommodity", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> DeleteCommodity(@RequestBody String CommodityInfo, Model model) {

		
		PaginationVo user = detailedListService.DeleteCommodity(CommodityInfo, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;
		
		

	}

	@ApiOperation(value = "使用用户Id删除购物车全部商品", notes = "使用用户Id删除购物车全部商品", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({

			@ApiImplicitParam(name = "UserId", value = "请输入对应参数", required = true, dataType = "varchar") })

	@RequestMapping(value = "/DeleteAll", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> DeleteAlldetailed(@RequestBody String CommodityInfo, Model model) {

		
		
		PaginationVo user = detailedListService.DeleteAlldetailed(CommodityInfo, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;
		

	}

	/*--------------- -----<----*增加*---->--- ----------------------*/

	@ApiOperation(value = "新增对应用户的购物车商品", notes = "新增对应用户的购物车商品", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/InsertDetailed", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> InsertDetailedListInfo(@RequestBody String CommodityInfo, Model model) {

		
		
		PaginationVo user = detailedListService.InsertDetailedListInfo(CommodityInfo, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

	/*--------------- -----<----*修改*---->--- ----------------------*/

	@ApiOperation(value = "使用用户Id修改购物车商品", notes = "使用用户Id修改购物车商品", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({})

	@RequestMapping(value = "/UpdateByUserId", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> UpdateCommodityByUserId(@RequestBody String CommodityInfo, Model model) {
	
		
		PaginationVo user = detailedListService.UpdateCommodityByUserId(CommodityInfo, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;
		
		

	}

	@ApiOperation(value = "使用购物车Id修改购物车商品", notes = "使用购物车Id修改购物车商品", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@RequestMapping(value = "/UpdateByDetailedId", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> UpdateCommodityBydetailedId(@RequestBody String CommodityInfo,
			Model model) {

		PaginationVo user = detailedListService.UpdateCommodityBydetailedId(CommodityInfo, model);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;
		

	}

	private String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		return uuid;
	}

}
