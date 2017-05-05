package com.cchuaspace.system.controller;

import com.cchuaspace.Application;
import com.cchuaspace.model.DeliveryPoint;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.service.DeliveryPointService;
import com.cchuaspace.system.service.SysDeliveryPointService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * http://localhost:8080//hhh?name=d62&age=23
 */
@Controller
@RestController
@Scope("prototype")
@RequestMapping(value = "/system/delivery/point")
@Api(value = "提货点信息的相关操作", description = "System提货点信息表 delivery_point")

public class SysDeliveryPointController {

	@Autowired
	private SysDeliveryPointService deliveryPointService;

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

	/*--------------- -----<----*增加·*---->--- ----------------------*/
	@ApiOperation(value = "增加取货点商品信息 ", notes = "增加取货点的信息", response = DeliveryPoint.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({})

	@RequestMapping(value = "/insertinfo", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> InsertInfo(@RequestBody String insertinfo) {

		PaginationVo user = deliveryPointService.InsertInfo(insertinfo);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	/*--------------- -----<----*修改*---->--- ----------------------*/

	/* 删除 */

	@ApiOperation(value = "删除取货点对应商品信息", notes = "使用id删除", response = DeliveryPoint.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "请输入对应参数", required = true, dataType = "string"),

	})

	@RequestMapping(value = "/DeleteById", method = RequestMethod.GET)
	@ResponseBody

	public ResponseEntity<PaginationVo> DeleteById(@RequestParam(value = "id", required = true) String id) {

		PaginationVo user = deliveryPointService.DeleteById(id);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

	@ApiOperation(value = "删除取货点提供的商息", notes = "删除取货点提供的商息", response = DeliveryPoint.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "deliveryNumber", value = "请输入对应参数", required = true, dataType = "int"),

	})

	@RequestMapping(value = "/DeleteByNumber", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<PaginationVo> DeleteById(
			@RequestParam(value = "deliveryNumber", required = true) int deliveryNumber

	) {

		PaginationVo user = deliveryPointService.DeleteByNumber(deliveryNumber);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

}
