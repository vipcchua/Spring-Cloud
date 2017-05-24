package com.cchuaspace.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cchuaspace.Application;

import com.cchuaspace.model.UseDeliveryAddress;
import com.cchuaspace.pojo.PaginationVo;

import com.cchuaspace.service.CommodityFavoritesService;
import com.cchuaspace.service.DeliveryAddressService;

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
@RequestMapping(value = "/api/delivery/address")
@Api(value = "用户收货地址信息的相关操作", description = "用户收货地址信息表 use_delivery_address")

public class DeliveryAddressController {

	@Autowired
	private DeliveryAddressService deliveryAddressService;

	@Resource
	private Application computeServiceApplication;

	/*--------------- -----<----*查询*---->--- ----------------------*/
	@ApiOperation(value = "查询该用户收货地址", notes = "使用用户id查询收货地址", response = UseDeliveryAddress.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "userid", value = "请输入对应参数", required = true, dataType = "char"),

	})

	@RequestMapping(value = "/selectbyuserid", method = RequestMethod.GET)
	@ResponseBody

	public ResponseEntity<PaginationVo> selectByDeliveryName(
			@RequestParam(value = "userid", required = true) String userid) {

		PaginationVo user = deliveryAddressService.selectByUserid(userid);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	/*--------------- -----<----*增加·*---->--- ----------------------*/
	@ApiOperation(value = "增加收货地址商品信息 ", notes = "增加收货地址的信息", response = UseDeliveryAddress.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({})

	@RequestMapping(value = "/insertinfo", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> insertInfo(@RequestBody String insertinfo) {

		PaginationVo user = deliveryAddressService.insertInfo(insertinfo);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	/*--------------- -----<----*修改*---->--- ----------------------*/

	/* 删除 */

	@ApiOperation(value = "使用id删除用户收货地址", notes = "使用id删除", response = UseDeliveryAddress.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "请输入对应参数", required = true, dataType = "string"),
			@ApiImplicitParam(name = "userid", value = "请输入对应参数", required = true, dataType = "string"),

	})

	@RequestMapping(value = "/DeleteById", method = RequestMethod.GET)
	@ResponseBody

	public ResponseEntity<PaginationVo> deleteById(@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "userid", required = true) String userid) {

		PaginationVo user = deliveryAddressService.deleteById(id, userid);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

}
