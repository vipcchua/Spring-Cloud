package com.cchuaspace.controller;

import java.util.List;

import javax.annotation.Resource;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cchuaspace.Application;
import com.cchuaspace.mapper.HomepageBannerMapper;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.HomepageBanner;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.service.HomepageBannerService;
import com.cchuaspace.service.OrderInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController

@Api(value = "首頁活動推送栏", description = "首頁活動推送栏 homepage_banner")
@RequestMapping(value = "/api/homepagebanner")
@Scope("prototype")

public class HomepageBannerController {

	@Autowired
	private HomepageBannerMapper homepageBannerMapper;
	@Autowired
	private HomepageBannerService homepageBannerService;
	@Autowired
	private PaginationVo paginationVo;

	@ApiOperation(value = "查询所有banner", notes = "查询所有banner", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/selectall", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody

	public ResponseEntity<PaginationVo> selectall() {

		/* PaginationVo user = homepageBannerService.selectall(); */

		List<HomepageBanner> user = homepageBannerMapper.selectallbanner();
		paginationVo.setDataResultList(user);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(paginationVo, HttpStatus.OK);
		return data;

	}

	@ApiOperation(value = "插入新banner", notes = "插入新banne", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/insertbanner", method = { RequestMethod.POST })
	@ResponseBody

	public ResponseEntity<PaginationVo> insertBanner(@RequestBody String CommodityInfo, Model model) {

		PaginationVo user = homepageBannerService.insertBanner(CommodityInfo, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}

	@ApiOperation(value = "使用id删除banner", notes = "使用id删除banner", response = CommodityInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "请输入对应参数", required = true, dataType = "varchar"), })

	@RequestMapping(value = "/deletebanner", method = { RequestMethod.POST })
	@ResponseBody

	public ResponseEntity<PaginationVo> deletebanner(@RequestBody String CommodityInfo, Model model) {

		PaginationVo user = homepageBannerService.deletebanner(CommodityInfo, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}
	
	
	
	
	
	

}
