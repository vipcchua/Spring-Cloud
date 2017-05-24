package com.cchuaspace.controller;

import com.cchuaspace.Application;
import com.cchuaspace.model.UseDeliveryAddress;
import com.cchuaspace.model.VideoOrderInfo;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.service.DeliveryAddressService;
import com.cchuaspace.service.VideoOrderInfoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * http://localhost:8080//hhh?name=d62&age=23
 */
@Controller
@RestController
@Scope("prototype")
@RequestMapping(value = "/api/video")
@Api(value = "用户收货地址信息的相关操作", description = "用户收货地址信息表 use_delivery_address")

public class VideoOrderInfoController {

	@Autowired
	private VideoOrderInfoService videoOrderInfoService;

	@Resource
	private Application computeServiceApplication;

	/*--------------- -----<----*查询*---->--- ----------------------*/


	@RequestMapping(value = "/selectandpay", method = RequestMethod.GET)
	@ResponseBody


	public ResponseEntity<String> selectbydeliveryname(
			@RequestParam(value = "userid", required = true) String userid,
			@RequestParam(value = "video", required = true) int video) {
		String user;
		if(video!=1) {


			user = "Error";
			ResponseEntity<String> data = new ResponseEntity<String>(user, HttpStatus.OK);
			return data;
		}
		else {

			user = "http://igo.vrdete.com/mp/video/video.mp4";
			ResponseEntity<String> data = new ResponseEntity<String>(user, HttpStatus.OK);
			return data;

		}


	}




	@ApiOperation(value = "使用用户Id+商品编号查询订单信息", notes = "", response = VideoOrderInfo.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams(
			{ @ApiImplicitParam(name = "UserId", value = "请输入对应参数", required = true, dataType = "varchar"),
			@ApiImplicitParam(name = "orderNumber", value = "请输入对应参数", required = true, dataType = "varchar") })

	@RequestMapping(value = "/selectbynumberpay", method = RequestMethod.POST)
	@ResponseBody


	public ResponseEntity<PaginationVo> selectAndPayByNumber(@RequestBody String CommodityInfo,HttpServletRequest request) {

		PaginationVo user = videoOrderInfoService.selectAndPayByNumber(CommodityInfo,request);
		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
		return data;

	}


}




