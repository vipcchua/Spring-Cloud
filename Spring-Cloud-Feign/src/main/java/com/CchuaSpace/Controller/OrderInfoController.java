package com.cchuaspace.controller;

/*
 * ****************<--*---Code information---*-->**************
 * 	
 *		Author: Cchua
 *		GitHub: https://github.com/vipcchua
 *		Blog  : weibo.com/vipcchua
 * 
 * 
 * ************************************************************/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import java.util.UUID;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cchuaspace.currency.AesUtils;
import com.cchuaspace.currency.RSAUtils;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.DetailedList;
import com.cchuaspace.model.OrderInfo;
import com.cchuaspace.model.PaginationVo;
import com.cchuaspace.service.CommodityInfoClient;
import com.cchuaspace.service.DetailedListClient;
import com.cchuaspace.service.OrderInfoClient;
import com.cchuaspace.service.TableUserClient;

import io.swagger.annotations.Api;

@RestController
@Api(value = "商品信息表", description = "用户信息的相关操作")
@RequestMapping(value = "/OrderInfo")
public class OrderInfoController {
	@Autowired OrderInfoClient orderInfoClient;

	/*--------------- -----<----*查询*---->--- ----------------------*/


	
	@RequestMapping(value = "/SelectByNumber", method = RequestMethod.POST)
	public ResponseEntity<PaginationVo> SelectByNumber(@RequestBody String DeleteByNumber, Model model) {		
  	ResponseEntity<PaginationVo> user = orderInfoClient.SelectByNumber(DeleteByNumber);
	return user;

	}
	
	/*--------------- -----<----*删除*---->--- ----------------------*/

	@RequestMapping(value = "/DeleteByNumber", method = RequestMethod.POST)
	public ResponseEntity<PaginationVo> DeleteByNumber(@RequestBody String DeleteByNumber, Model model) {		
  	ResponseEntity<PaginationVo> user = orderInfoClient.DeleteByNumber(DeleteByNumber);
	return user;

	}
	
	@RequestMapping(value = "/DeleteById", method = RequestMethod.POST)
	public ResponseEntity<PaginationVo> DeleteCommodityById(@RequestBody String DeleteCommodityById, Model model) {		
  	ResponseEntity<PaginationVo> user = orderInfoClient.DeleteById(DeleteCommodityById);
	return user;
	}
	 
	/*--------------- -----<----*增加*---->--- ----------------------*/


	
	
	/*--------------- -----<----*修改*---->--- ----------------------*/

	

	
	
	private String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		return uuid;
	}

}
