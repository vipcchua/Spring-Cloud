package com.CchuaSpace.Controller;

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

import com.CchuaSpace.Currency.AesUtils;
import com.CchuaSpace.Currency.RSAUtils;
import com.CchuaSpace.Model.CommodityInfo;
import com.CchuaSpace.Model.DetailedList;
import com.CchuaSpace.Model.OrderInfo;
import com.CchuaSpace.Service.CommodityInfoClient;
import com.CchuaSpace.Service.DetailedListClient;
import com.CchuaSpace.Service.OrderInfoClient;
import com.CchuaSpace.Service.TableUserClient;

import io.swagger.annotations.Api;

@RestController
@Api(value = "商品信息表", description = "用户信息的相关操作")
@RequestMapping(value = "/OrderInfo")
public class OrderInfoController {
	@Autowired OrderInfoClient orderInfoClient;

	/*--------------- -----<----*查询*---->--- ----------------------*/


	/*--------------- -----<----*删除*---->--- ----------------------*/

	@RequestMapping(value = "/DeleteByNumber", method = RequestMethod.POST)
	public ResponseEntity<List<OrderInfo>> DeleteByNumber(@RequestBody String DeleteByNumber, Model model) {		
  	ResponseEntity<List<OrderInfo>> user = orderInfoClient.DeleteByNumber(DeleteByNumber);
	return user;

	}
	
	@RequestMapping(value = "/DeleteById", method = RequestMethod.POST)
	public ResponseEntity<List<OrderInfo>> DeleteCommodityById(@RequestBody String DeleteCommodityById, Model model) {		
  	ResponseEntity<List<OrderInfo>> user = orderInfoClient.DeleteById(DeleteCommodityById);
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
