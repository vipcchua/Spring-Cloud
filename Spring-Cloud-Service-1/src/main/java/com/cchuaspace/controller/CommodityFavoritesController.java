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

import com.cchuaspace.model.UseCommodityFavorites;
import com.cchuaspace.pojo.PaginationVo;

import com.cchuaspace.service.CommodityFavoritesService;

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
@RequestMapping(value = "/api/favorites")
@Api(value = "收藏商品信息的相关操作", description = "用户商品收藏表 use_commodity_favorites")

public class CommodityFavoritesController {

	@Autowired
	private CommodityFavoritesService commodityFavoritesService;

	@Resource
	private Application computeServiceApplication;

	/*--------------- -----<----*查询*---->--- ----------------------*/
	@ApiOperation(value = "查询该用户收藏夹", notes = "使用用户id查询收藏夹", response = UseCommodityFavorites.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "userid", value = "请输入对应参数", required = true, dataType = "char"),

	})

	@RequestMapping(value = "/selectbyuserid", method = RequestMethod.GET)
	@ResponseBody

	public ResponseEntity<PaginationVo> selectbydeliveryname(
			@RequestParam(value = "userid", required = true) String userid) {

		PaginationVo user = commodityFavoritesService.selectByUserid(userid);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	/*--------------- -----<----*增加·*---->--- ----------------------*/
	@ApiOperation(value = "增加收藏夹商品信息 ", notes = "增加收藏夹的信息", response = UseCommodityFavorites.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({})

	@RequestMapping(value = "/insertinfo", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> insertInfo(@RequestBody String insertinfo) {

		PaginationVo user = commodityFavoritesService.insertInfo(insertinfo);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	/*--------------- -----<----*修改*---->--- ----------------------*/

	/* 删除 */

	@ApiOperation(value = "使用收藏夹编号删除收藏夹对应商品信息", notes = "使用id删除", response = UseCommodityFavorites.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "请输入对应参数", required = true, dataType = "string"),
			@ApiImplicitParam(name = "userid", value = "请输入对应参数", required = true, dataType = "string"),

	})

	@RequestMapping(value = "/DeleteById", method = RequestMethod.GET)
	@ResponseBody

	public ResponseEntity<PaginationVo> deleteById(@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "userid", required = true) String userid) {

		PaginationVo user = commodityFavoritesService.deleteById(id, userid);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

	@ApiOperation(value = "使用商品编号删除收藏夹对应商品信息", notes = "删除收藏夹提供的商息", response = UseCommodityFavorites.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "userid", value = "请输入对应参数", required = true, dataType = "String"),
			@ApiImplicitParam(name = "deliveryNumber", value = "请输入对应参数", required = true, dataType = "int"),

	})

	@RequestMapping(value = "/DeleteByNumber", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<PaginationVo> deleteById(@RequestParam(value = "userid", required = true) String userid,
			@RequestParam(value = "commodityNumber", required = true) int commodityNumber

	) {

		PaginationVo user = commodityFavoritesService.deleteByNumber(userid, commodityNumber);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

}
