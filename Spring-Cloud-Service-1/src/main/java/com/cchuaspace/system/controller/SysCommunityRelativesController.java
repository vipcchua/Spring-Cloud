package com.cchuaspace.system.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.swing.text.html.HTML.Tag;
import java.util.UUID;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONStreamAware;
import com.cchuaspace.Application;
import com.cchuaspace.currency.AesUtils;
import com.cchuaspace.currency.RSAUtils;
import com.cchuaspace.mapper.CommodityCatalogMapper;
import com.cchuaspace.mapper.CommodityInfoMapper;
import com.cchuaspace.model.CommodityCatalog;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.OrderInfo;
import com.cchuaspace.pojo.PaginationVo;

import com.cchuaspace.service.OrderInfoService;
import com.cchuaspace.system.service.SysCommunityRelativesService;
import com.mysql.cj.core.exceptions.PasswordExpiredException;

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
@Scope("prototype")
@RestController
@RequestMapping(value = "/system/relatives")
@Api(value = "System目录所对应的商品", description = "System商品目录列表 community_relatives")

public class SysCommunityRelativesController {

	@Autowired
	private SysCommunityRelativesService communityRelativesService;

	/*--------------- -----<----*查询*---->--- ----------------------*/

	@ApiOperation(value = "查询该分类下的商品", notes = "查询该分类下的商品", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "parentsId", value = "请输入商品编码", required = true, dataType = "varchar")
		 })

	@RequestMapping(value = "/selectclassifyproduct", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> SelectCommodityByNumber(@RequestBody String CommodityInfo, Model model) {

		PaginationVo user = communityRelativesService.SelectClassifyProduct(CommodityInfo, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}
	
	

	@ApiOperation(value = "查询该分类下的商品", notes = "查询该分类下正在销售的商品", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "parentsId", value = "请输入商品编码", required = true, dataType = "varchar"),
			 })

	@RequestMapping(value = "/selectallbyparents", method = RequestMethod.GET)
	@ResponseBody

	public ResponseEntity<PaginationVo> selectallbyparents(
			@RequestParam(value = "parentsId", required = true) int parentsId) {

		PaginationVo user = communityRelativesService.selectallbyparents(parentsId);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}
	
	
	
	
	
	

	@ApiOperation(value = "查询该分类下的商品", notes = "查询该分类下正在销售的商品", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "parentsid", value = "请输入商品父亲id", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "shelfstate", value = "请输入商品状态", required = true, dataType = "varchar") })

	@RequestMapping(value = "/selectbyparsts", method = RequestMethod.GET)
	@ResponseBody

	public ResponseEntity<PaginationVo> selectbyparsts(
			@RequestParam(value = "parentsid", required = true) int parentsId
			,@RequestParam(value = "shelfstate", required = true) int shelfState) {

		PaginationVo user = communityRelativesService.selectbyparsts(parentsId,shelfState);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	/*--------------- -----<----*删除*---->--- ----------------------*/
	@ApiOperation(value = "刪除分類下的指定商品", notes = "刪除分類下的指定商品", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "parentsId", value = "请输入商品编码", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "commodityNumber", value = "请输入商品编码", required = true, dataType = "varchar") })

	@RequestMapping(value = "/deletebynumber", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> DeleteByNumber(@RequestBody String CommodityInfo, Model model) {

		PaginationVo user = communityRelativesService.DeleteByNumber(CommodityInfo, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	/*--------------- -----<----*增加*---->--- ----------------------*/
	@ApiOperation(value = "增加商品到某分类下", notes = "增加商品到某分类下", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "catalogId", value = "请输入商品编码", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "parentsId", value = "请输入商品编码", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "commodityNumber", value = "请输入商品编码", required = true, dataType = "varchar") })

	@RequestMapping(value = "/insertrelativesr", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> InsertRelativesr(@RequestBody String CommodityInfo, Model model) {

		PaginationVo user = communityRelativesService.InsertRelativesr(CommodityInfo, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	/*--------------- -----<----*修改*---->--- ----------------------*/
	@ApiOperation(value = "修改某个商品的分类所属", notes = "修改某个商品的分类所属", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "commodityNumber", value = "请输入商品编码", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "parentsId", value = "请输入商品编码", required = true, dataType = "varchar") })

	@RequestMapping(value = "/updatecatalog", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> UpdateCatalog(@RequestBody String CommodityInfo, Model model) {

		PaginationVo user = communityRelativesService.UpdateCatalog(CommodityInfo, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}



}
