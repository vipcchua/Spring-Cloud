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
import com.CchuaSpace.Model.DetailedList;
import com.CchuaSpace.Service.CommodityInfoClient;
import com.CchuaSpace.Service.DetailedListClient;
import com.CchuaSpace.Service.TableUserClient;

import io.swagger.annotations.Api;

@RestController
@Api(value = "商品信息表", description = "用户信息的相关操作")
@RequestMapping(value = "/Detailed")
public class DetailedListController {
	@Autowired
	DetailedListClient detailedListClient;

	/*--------------- -----<----*查询*---->--- ----------------------*/
	@RequestMapping(value = "/SelectByUserId", method = RequestMethod.POST)
	public ResponseEntity<List<DetailedList>> SelectByUserId(@RequestBody String SelectByUserId, Model model) {
		ResponseEntity<List<DetailedList>> user = detailedListClient.SelectByUserId(SelectByUserId);
		return user;
	}

	@RequestMapping(value = "/SelectByDetailedId", method = RequestMethod.POST)
	public ResponseEntity<List<DetailedList>> SelectByDetailedId(@RequestBody String SelectByDetailedId, Model model) {
		ResponseEntity<List<DetailedList>> user = detailedListClient.SelectByDetailedId(SelectByDetailedId);
		return user;
	}

	/*--------------- -----<----*删除*---->--- ----------------------*/
	@RequestMapping(value = "/DeleteByCommodity", method = RequestMethod.POST)
	public ResponseEntity<List<DetailedList>> DeleteByCommodity(@RequestBody String DeleteByDetailedId, Model model) {
		ResponseEntity<List<DetailedList>> user = detailedListClient.DeleteByCommodity(DeleteByDetailedId);
		return user;
	}
	
	
	@RequestMapping(value = "/DeleteBydetailedId", method = RequestMethod.POST)
	public ResponseEntity<List<DetailedList>> DeleteByNumber(@RequestBody String DeleteByNumber, Model model) {
		ResponseEntity<List<DetailedList>> user = detailedListClient.DeleteBydetailedId(DeleteByNumber);
		return user;
	}
	
	@RequestMapping(value = "/DeleteCommodity", method = RequestMethod.POST)
	public ResponseEntity<List<DetailedList>> DeleteCommodity(@RequestBody String DeleteByNumber, Model model) {
		ResponseEntity<List<DetailedList>> user = detailedListClient.DeleteCommodity(DeleteByNumber);
		return user;
	}
	
	
	
	
	@RequestMapping(value = "/DeleteAll", method = RequestMethod.POST)
	public ResponseEntity<List<DetailedList>> DeleteAll(@RequestBody String DeleteAll, Model model) {
		ResponseEntity<List<DetailedList>> user = detailedListClient.DeleteAll(DeleteAll);
		return user;
	}
	
	
	/*--------------- -----<----*增加*---->--- ----------------------*/

	@RequestMapping(value = "/InsertDetailed", method = RequestMethod.POST)
	public ResponseEntity<List<DetailedList>> InsertDetailed(@RequestBody String InsertDetailed, Model model) {
		ResponseEntity<List<DetailedList>> user = detailedListClient.InsertDetailed(InsertDetailed);
		return user;
	}
	
	
	/*--------------- -----<----*修改*---->--- ----------------------*/

	
	@RequestMapping(value = "/UpdateByUserId", method = RequestMethod.POST)
	public ResponseEntity<List<DetailedList>> UpdateByUserId(@RequestBody String UpdateByUserId, Model model) {
		ResponseEntity<List<DetailedList>> user = detailedListClient.UpdateByUserId(UpdateByUserId);
		return user;
	}
	
	@RequestMapping(value = "/UpdateByDetailedId", method = RequestMethod.POST)
	public ResponseEntity<List<DetailedList>> UpdateByDetailedId(@RequestBody String UpdateByDetailedId, Model model) {
		ResponseEntity<List<DetailedList>> user = detailedListClient.UpdateByDetailedId(UpdateByDetailedId);
		return user;
	}
	
	
	private String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		return uuid;
	}

}
