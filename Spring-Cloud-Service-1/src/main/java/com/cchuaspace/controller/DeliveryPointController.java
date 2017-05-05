package com.cchuaspace.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cchuaspace.Application;

import com.cchuaspace.model.CommodityCatalog;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.DeliveryPoint;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.service.CommodityCatalogService;
import com.cchuaspace.service.DeliveryPointService;
import com.cchuaspace.system.service.SuppliersCommodityService;
import com.cchuaspace.system.service.SuppliersInfoService;

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
@RequestMapping(value = "/api/delivery/point")
@Api(value = "提货点信息的相关操作", description = "提货点信息表 delivery_point")

public class DeliveryPointController {

	@Autowired
	private DeliveryPointService deliveryPointService;

	@Resource
	private Application computeServiceApplication;

	/*--------------- -----<----*查询*---->--- ----------------------*/
	@ApiOperation(value = "查询该取货点", notes = "使用名称查询取货点", response = DeliveryPoint.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "deliveryname", value = "请输入对应参数", required = true, dataType = "int"),

	})

	@RequestMapping(value = "/selectbyname", method = RequestMethod.GET)
	@ResponseBody

	public ResponseEntity<PaginationVo> selectbydeliveryname(
			@RequestParam(value = "deliveryname", required = true) String deliveryname) {

		PaginationVo user = deliveryPointService.SelectByDeliveryname(deliveryname);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	@ApiOperation(value = "查询该商品的取货点信息", notes = "查询该商品的取货点信息", response = DeliveryPoint.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "suppliername", value = "请输入对应参数", required = true, dataType = "int"),

	})

	@RequestMapping(value = "/selectbynumber", method = RequestMethod.GET)
	@ResponseBody

	public ResponseEntity<PaginationVo> suppliername(
			@RequestParam(value = "deliverynumber", required = true) int deliverynumber) {

		PaginationVo user = deliveryPointService.SelectByDeliveryNumber(deliverynumber);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	@ApiOperation(value = "查询该商品的取货点信息", notes = "查询该商品的取货点信息", response = DeliveryPoint.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "suppliername", value = "请输入对应参数", required = true, dataType = "int"),

	})

	@RequestMapping(value = "/selectbyregion", method = RequestMethod.GET)
	@ResponseBody

	public ResponseEntity<PaginationVo> selectbyregion(
			@RequestParam(value = "regionnumber", required = true) String commoditynumber) {

		PaginationVo user = deliveryPointService.SelectByRegionNumber(commoditynumber);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}





	@ApiOperation(value = "动态查询自提点", notes = "动态查询自提点", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
	})

	@RequestMapping(value = "/selectpoint", method = RequestMethod.GET)
	@ResponseBody

	public ResponseEntity<PaginationVo> SelectPoint(@RequestBody String SelectPoint) {

		PaginationVo user = deliveryPointService.SelectPoint(SelectPoint);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}







	/*--------------- -----<----*增加·*---->--- ----------------------*/


}
