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
import com.CchuaSpace.Mapper.OrderInfoMapper;
import com.CchuaSpace.Model.CommodityInfo;
import com.CchuaSpace.Model.DetailedList;
import com.CchuaSpace.Model.OrderInfo;
import com.CchuaSpace.Model.TableUser;
import com.alibaba.fastjson.JSON;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "购物车列表", description = "订单列表 order_info")
@RequestMapping(value = "/OrderInfo")
public class OrderInfoController {

	private static SqlSessionFactory sqlSessionFactory;
	/* private Logger logger = Logger.getLogger(TableInfoController.class); */

	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private DiscoveryClient client;

	@Autowired
	private OrderInfoMapper orderInfoMapper;

	@Resource
	private Application application;

	/*--------------- -----<----*查询*---->--- ----------------------*/
	@ApiOperation(value = "使用用户Id查询购物车", notes = "使用商品Id查询购物车", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "UserId", value = "请输入对应参数", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "orderNumber", value = "请输入对应参数", required = true, dataType = "varchar")
	})

	@RequestMapping(value = "/SelectByNumber", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<List<OrderInfo>> SelectByNumber(@RequestBody String CommodityInfo,
			Model model) {
		List<OrderInfo> json = JSON.parseArray(CommodityInfo, OrderInfo.class);
		List<OrderInfo> user = 
				orderInfoMapper
				.SelectByNumber(json.get(0).getUserId(),json.get(0).getOrderNumber());
		ResponseEntity<List<OrderInfo>> data = new ResponseEntity<List<OrderInfo>>(user, HttpStatus.OK);
		System.out.println(data);
		return data;

	}

	/*--------------- -----<----*删除*---->--- ----------------------*/
	@ApiOperation(value = "使用订单Id删除订单", notes = "使用订单ID", response = OrderInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "OrderNumber", value = "请输入对应参数", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "UserId", value = "请输入对应参数", required = true, dataType = "varchar") })

	@RequestMapping(value = "/DeleteByNumber", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<List<OrderInfo>> DeleteByCommodity(@RequestBody String CommodityInfo, Model model) {
		List<OrderInfo> json = JSON.parseArray(CommodityInfo, OrderInfo.class);
		int tostate = orderInfoMapper.DeleteNumber(json.get(0).getOrderNumber(),json.get(0).getUserId()
				);

		if (tostate != 0)
			json.get(0).setSqlstate("Success");
		else
			json.get(0).setSqlstate("ERROR");

		ResponseEntity<List<OrderInfo>> data = new ResponseEntity<List<OrderInfo>>(json, HttpStatus.OK);

		return data;

	}

	
	
	@ApiOperation(value = "使用订单Id删除订单对应商品", notes = "使用订单Id删除订单", response = OrderInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "OrderId", value = "请输入对应参数", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "UserId", value = "请输入对应参数", required = true, dataType = "varchar") })

	@RequestMapping(value = "/DeleteById", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<List<OrderInfo>> DeleteByOrderId(@RequestBody String CommodityInfo, Model model) {
		List<OrderInfo> json = JSON.parseArray(CommodityInfo, OrderInfo.class);
		int tostate = orderInfoMapper.DeleteorderId(json.get(0).getOrderId(),json.get(0).getUserId()
				);

		if (tostate != 0)
			json.get(0).setSqlstate("Success");
		else
			json.get(0).setSqlstate("ERROR");

		ResponseEntity<List<OrderInfo>> data = new ResponseEntity<List<OrderInfo>>(json, HttpStatus.OK);

		return data;

	}
	/*--------------- -----<----*增加*---->--- ----------------------*/


	/*--------------- -----<----*修改*---->--- ----------------------*/



	private String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		return uuid;
	}

}
