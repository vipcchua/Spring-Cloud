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
import javax.servlet.http.HttpServletRequest;

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
import com.cchuaspace.mapper.OrderInfoMapper;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.DetailedList;
import com.cchuaspace.model.OrderInfo;
import com.cchuaspace.model.TableUser;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.service.OrderInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Scope("prototype")
@Api(value = "购物车列表", description = "订单列表 order_info")
@RequestMapping(value = "/api/orderinfo")
public class OrderInfoController {

	private static SqlSessionFactory sqlSessionFactory;
	/* private Logger logger = Logger.getLogger(TableInfoController.class); */

	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private DiscoveryClient client;

	@Autowired
	private OrderInfoService orderInfoService;

	@Resource
	private Application application;

	/*--------------- -----<----*查询*---->--- ----------------------*/
	@ApiOperation(value = "使用用户Id+商品编号查询订单信息", notes = "", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "UserId", value = "请输入对应参数", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "orderNumber", value = "请输入对应参数", required = true, dataType = "varchar") })

	@RequestMapping(value = "/selectbynumber", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> selectByNumber(@RequestBody String CommodityInfo, Model model) {

		PaginationVo user = orderInfoService.SelectByNumber(CommodityInfo, model);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}





	@ApiOperation(value = "使用用户Id+商品编号查询订单信息", notes = "", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "UserId", value = "请输入对应参数", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "orderNumber", value = "请输入对应参数", required = true, dataType = "varchar") })

	@RequestMapping(value = "/selectbyuserid", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> selectByUserId(@RequestBody String CommodityInfo) {

		PaginationVo user = orderInfoService.SelectByUserId(CommodityInfo);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}







	@ApiOperation(value = "使用用户Id+商品编号查询订单信息", notes = "", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "UserId", value = "请输入对应参数", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "orderNumber", value = "请输入对应参数", required = true, dataType = "varchar") })

	@RequestMapping(value = "/selectbycondition", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> selectByCondition(@RequestBody String CommodityInfo) {

		PaginationVo user = orderInfoService.SelectByCondition(CommodityInfo);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}










	/*--------------- -----<----*删除*---->--- ----------------------*/
	@ApiOperation(value = "使用订单Id删除订单", notes = "使用订单ID", response = OrderInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "OrderNumber", value = "请输入对应参数", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "UserId", value = "请输入对应参数", required = true, dataType = "varchar") })

	@RequestMapping(value = "/deletebynumber", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> deleteByCommodity(@RequestBody String CommodityInfo, Model model) {

		PaginationVo user = orderInfoService.DeleteByCommodity(CommodityInfo, model);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

	@ApiOperation(value = "使用订单Id删除订单对应商品", notes = "使用订单Id删除订单", response = OrderInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "OrderId", value = "请输入对应参数", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "UserId", value = "请输入对应参数", required = true, dataType = "varchar") })

	@RequestMapping(value = "/deletebyid", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> deleteByOrderId(@RequestBody String CommodityInfo, Model model) {

		PaginationVo user = orderInfoService.DeleteByOrderId(CommodityInfo, model);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}
	/*--------------- -----<----*增加*---->--- ----------------------*/

	@ApiOperation(value = "生成订单", notes = "使用各种信息生成一张新的订单", response = OrderInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/generateorder", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> newOrder(@RequestBody String CommodityInfo,HttpServletRequest request) {

		PaginationVo user = orderInfoService.NewOrder(CommodityInfo,request);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

	@ApiOperation(value = "再次生成已生成订单", notes = "使用各种信息生成一张新的订单", response = OrderInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/againneworder", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> againNewOrder(@RequestBody String CommodityInfo,HttpServletRequest request) {

		PaginationVo user = orderInfoService.againNewOrder(CommodityInfo,request);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}







	/*--------------- -----<----*修改*---->--- ----------------------*/

	private String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		return uuid;
	}

}
