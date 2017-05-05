package com.cchuaspace.system.controller;

import javax.annotation.Resource;

import io.swagger.annotations.*;
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
import com.cchuaspace.model.WarehouseStock;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.service.CommodityCatalogService;
import com.cchuaspace.system.service.CommodityPriceService;
import com.cchuaspace.system.service.SuppliersCommodityService;
import com.cchuaspace.system.service.SuppliersInfoService;
import com.cchuaspace.system.service.WarehouseStockService;

/**
 * http://localhost:8080//hhh?name=d62&age=23
 */
@Controller
@RestController
@Scope("prototype")
@RequestMapping(value = "/system/commodity/price")
@ApiModel(value = "System系统价格变动表", description = "System系统价格变动信息 sys_commodity_price")

public class SysCommodityPriceController {

	@Autowired
	private CommodityPriceService commodityPriceService;
	@Resource
	private Application computeServiceApplication;

	/*--------------- -----<----*查询*---->--- ----------------------*/

	@ApiOperation(value = "查询该商品的价格变动信息", notes = "查询该商品的价格变动信息", response = WarehouseStock.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "suppliername", value = "请输入对应参数", required = true, dataType = "int"),

	})

	@RequestMapping(value = "/selectbynumber", method = RequestMethod.GET)
	@ResponseBody

	public ResponseEntity<PaginationVo> suppliername(
			@RequestParam(value = "commoditynumber", required = true) int commoditynumber) {

		PaginationVo user = commodityPriceService.selectbycommoditynumber(commoditynumber);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	@ApiOperation(value = "查询该商品的价格变动信息", notes = "查询该商品的价格变动信息", response = WarehouseStock.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "suppliername", value = "请输入对应参数", required = true, dataType = "int"),

	})

	@RequestMapping(value = "/selectnewbynumber", method = RequestMethod.GET)
	@ResponseBody

	public ResponseEntity<PaginationVo> selectnewbynumber(
			@RequestParam(value = "commoditynumber", required = true) int commoditynumber) {

		PaginationVo user = commodityPriceService.selectnewbynumber(commoditynumber);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	/*--------------- -----<----*增加·*---->--- ----------------------*/
	@ApiOperation(value = "增加对应的价格变动信息", notes = "增加供应商对应的商品信息", response = WarehouseStock.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({})

	@RequestMapping(value = "/insertinfo", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> InsertInfo(@RequestBody String insertinfo) {

		PaginationVo user = commodityPriceService.InsertInfo(insertinfo);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	/*--------------- -----<----*修改*---->--- ----------------------*/

	/* 删除 */

	@ApiOperation(value = "删除价格变动信息", notes = "使用id删除", response = WarehouseStock.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "请输入对应参数", required = true, dataType = "string"),

	})

	@RequestMapping(value = "/DeleteById", method = RequestMethod.GET)
	@ResponseBody

	public ResponseEntity<PaginationVo> DeleteById(@RequestParam(value = "id", required = true) String id) {

		PaginationVo user = commodityPriceService.DeleteById(id);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

}
