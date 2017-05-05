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
import com.cchuaspace.service.CommodityInfoService;
import com.cchuaspace.system.service.SysCommodityInfoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * http://localhost:8080//hhh?name=d62&age=23
 */
@Controller
@RestController
@Scope("prototype")
@RequestMapping(value = "/system/commodity")
@Api(value = "System商品信息表", description = "System商品信息列表commodity_info")

public class SysCommodityInfoController {

	@Resource
	private Application computeServiceApplication;

	@Autowired
	private SysCommodityInfoService commodityInfoService;
	/*--------------- -----<----*查询*---->--- ----------------------*/

	@ApiOperation(value = "使用商品编号查询商品详细信息", notes = "使用商品Id查询商品详细信息，本接口只能传商品Id", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "commoditynumber", value = "请输入商品编码", required = true, dataType = "varchar"), })

	@RequestMapping(value = "/selectbynumber", method = RequestMethod.GET)
	@ResponseBody

	public ResponseEntity<PaginationVo> SelectCommodityByNumber(
			@RequestParam(value = "commoditynumber", required = true) int commodityNumber) {

		PaginationVo user = commodityInfoService.SelectCommodityByNumber(commodityNumber);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	@ApiOperation(value = "使用商品iD查询商品详细信息", notes = "使用商品Id查询商品详细信息，本接口只能传商品Id", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "commodityId", value = "请输入商品Id", required = true, dataType = "varchar"), })
	@RequestMapping(value = "/selectcommoditybyid", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> SelectCommodityByID(@RequestBody String CommodityByID, Model model) {

		PaginationVo user = commodityInfoService.SelectCommodityByID(CommodityByID, model);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

	@ApiOperation(value = "Get使用商品iD查询商品详细信息", notes = "Get使用商品Id查询商品详细信息，本接口只能传商品Id", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "commodityId", value = "请输入商品Id", required = true, dataType = "varchar"), })

	@RequestMapping(value = "/getcommoditybyid", method = RequestMethod.GET)
	@ResponseBody

	public ResponseEntity<PaginationVo> GetSelectCommodityByID(
			@RequestParam(value = "commodityid", required = true) String commodityId) {

		PaginationVo user = commodityInfoService.GetSelectCommodityByID(commodityId);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

	@ApiOperation(value = "动态查询商品信息", notes = "本接口为动态查询商品信息", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@RequestMapping(value = "/selectcommodityinfo", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> SelectCommodityInfo(@RequestBody String CommodityByID, Model model) {
		PaginationVo user = commodityInfoService.SelectCommodityInfo(CommodityByID, model);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

	@ApiOperation(value = "查询所有商品信息", notes = "本接口为查询所有商品信息息", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@RequestMapping(value = "/selectall", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody

	public ResponseEntity<PaginationVo> SelectCommodityall() {
		PaginationVo user = commodityInfoService.SelectCommodityall();
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

	@ApiOperation(value = "查询所有商品信息", notes = "本接口为查询所有商品信息息", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@RequestMapping(value = "/selectallpage", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody

	public ResponseEntity<PaginationVo> SelectCommodityallpage(@RequestBody String data) {

		PaginationVo user = commodityInfoService.SelectAllByPage(data);

		ResponseEntity<PaginationVo> htmldata = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return htmldata;

	}

	@ApiOperation(value = "查询所有商品信息", notes = "本接口为查询所有商品信息息", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@RequestMapping(value = "/selectcondition", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody

	public ResponseEntity<PaginationVo> SelectCondition(@RequestBody String data) {

		PaginationVo user = commodityInfoService.SelectCondition(data);

		ResponseEntity<PaginationVo> htmldata = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return htmldata;

	}



	/*--------------- -----<----*删除*---->--- ----------------------*/

	@ApiOperation(value = "使用商品编号删除商品详细信息", notes = "使用商品编号删除商品详细信息，本接口只能传商编号", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "commoditynumber", value = "请输入商品Id", required = true, dataType = "varchar"), })

	@RequestMapping(value = "/deletecommoditybynumber", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<PaginationVo> DeleteCommodityByNumber(@RequestBody String DeleteCommodityByNumber,
			Model model) {

		PaginationVo user = commodityInfoService.DeleteCommodityByNumber(DeleteCommodityByNumber, model);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

	@ApiOperation(value = "使用商品id删除商品详细信息", notes = "使用商品Id删除商品详细信息，本接口只能传商编号", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "commodityid", value = "请输入商品Id", required = true, dataType = "varchar"), })
	@RequestMapping(value = "/deletecommoditybyid", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<PaginationVo> DeleteCommodityById(@RequestBody String DeleteCommodityById, Model model) {

		PaginationVo user = commodityInfoService.DeleteCommodityById(DeleteCommodityById, model);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	/*--------------- -----<----*增加*---->--- ----------------------*/
	@ApiOperation(value = "增加商品详细信息", notes = "增加商品详细信息，本接口只能传商品Id", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/insertcommodityinfo", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> InsertCommodityInfo(@RequestBody String InsertCommodityInfo, Model model) {

		PaginationVo user = commodityInfoService.InsertCommodityInfo(InsertCommodityInfo, model);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

	/*--------------- -----<----*修改*---->--- ----------------------*/

	@ApiOperation(value = "使用商品iD修改商品详细信息", notes = "使用商品Id修改商品详细信息，本接口只能传商品Id", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/updcommodityinfobyid", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> UpdCommodityInfoById(@RequestBody String CommodityByID, Model model) {

		PaginationVo user = commodityInfoService.UpdCommodityInfoById(CommodityByID, model);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	@ApiOperation(value = "使用商品编号修改商品详细信息", notes = "使用商品编号修改商品详细信息，本接口只能传商品Id", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/updcommodityinfobynumber", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> UpdCommodityInfoByNumber(@RequestBody String UpdCommodityInfoByNumber,
			Model model) {

		PaginationVo user = commodityInfoService.UpdCommodityInfoByNumber(UpdCommodityInfoByNumber, model);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

}
