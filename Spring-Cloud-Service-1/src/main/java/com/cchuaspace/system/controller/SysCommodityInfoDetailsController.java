package com.cchuaspace.system.controller;

/*
 * ****************<--*---Code information---*-->**************
 * 	
 *		Author: Cchua
 *		GitHub: https://github.com/vipcchua
 *		Blog  : weibo.com/vipcchua
 * 
 * 
 * ************************************************************/

import com.cchuaspace.Application;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.service.CommodityInfoDetailsService;
import com.cchuaspace.system.service.SysCommodityInfoDetailsService;
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
@RequestMapping(value = "/system/commoditdetails")
@Api(value = "商品上架信息表", description = "商品上架信息表CommodityInfoDetails")

public class SysCommodityInfoDetailsController {

	@Resource
	private Application computeServiceApplication;

	@Autowired
	private SysCommodityInfoDetailsService commodityInfoDetailsService;
	/*--------------- -----<----*查询*---->--- ----------------------*/

	@ApiOperation(value = "使用商品编号查询商品的上架信息", notes = "使用商品number查询商品详细信息，本接口只能传商品number", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "commoditynumber", value = "请输入商品编码", required = true, dataType = "varchar"), })

	@RequestMapping(value = "/selectbynumber", method = RequestMethod.GET)
	@ResponseBody

	public ResponseEntity<PaginationVo> SelectByNumber(
			@RequestParam(value = "commoditynumber", required = true) int commoditynumber) {

		PaginationVo user = commodityInfoDetailsService.SelectByNumber(commoditynumber);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	@ApiOperation(value = "使用商品编号查询商品的上架信息", notes = "使用商品number查询商品详细信息，本接口只能传商品number", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "commoditynumber", value = "请输入商品编码", required = true, dataType = "varchar"), })

	@RequestMapping(value = "/selectallpage", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> selectallpage(@RequestBody String data) {

		PaginationVo user = commodityInfoDetailsService.SelectAllByPage(data);

		ResponseEntity<PaginationVo> htmldata = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return htmldata;

	}


	/*--------------- -----<----*删除*---->--- ----------------------*/

	/*--------------- -----<----*增加*---->--- ----------------------*/

	@ApiOperation(value = "增加商品上架信息", notes = "增加商品上架信息", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "commoditynumber", value = "请输入商品编码", required = true, dataType = "varchar"), })

	@RequestMapping(value = "/insertinfo", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> InsertInfo(@RequestBody String CommodityInfo) {

		PaginationVo user = commodityInfoDetailsService.InsertInfo(CommodityInfo);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}
	
	
	@ApiOperation(value = "使用商品Id查询商品的上架信息", notes = "使用商品Id查询商品详细信息，本接口只能传商品Id", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "commoditynumber", value = "请输入商品编码", required = true, dataType = "varchar"), })

	@RequestMapping(value = "/insertinfoprice", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> insertinfoprice(@RequestBody String CommodityInfo) {

		PaginationVo user = commodityInfoDetailsService.insertinfoprice(CommodityInfo);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	/*--------------- -----<----*修改*---->--- ----------------------*/

}
