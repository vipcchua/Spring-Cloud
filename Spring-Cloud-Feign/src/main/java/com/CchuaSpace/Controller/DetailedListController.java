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
import com.cchuaspace.model.DetailedList;
import com.cchuaspace.model.PaginationVo;
import com.cchuaspace.service.CommodityInfoClient;
import com.cchuaspace.service.DetailedListClient;
import com.cchuaspace.service.TableUserClient;

import io.swagger.annotations.Api;

@RestController
@Api(value = "商品信息表", description = "用户信息的相关操作")
@RequestMapping(value = "/Detailed")
public class DetailedListController {
	@Autowired
	DetailedListClient detailedListClient;

	/*--------------- -----<----*查询*---->--- ----------------------*/
	@RequestMapping(value = "/SelectByUserId", method = RequestMethod.POST)
	public ResponseEntity<PaginationVo> SelectByUserId(@RequestBody String SelectByUserId, Model model) {
		ResponseEntity<PaginationVo> user = detailedListClient.SelectByUserId(SelectByUserId);
		return user;
	}

	@RequestMapping(value = "/SelectByDetailedId", method = RequestMethod.POST)
	public ResponseEntity<PaginationVo> SelectByDetailedId(@RequestBody String SelectByDetailedId, Model model) {
		ResponseEntity<PaginationVo> user = detailedListClient.SelectByDetailedId(SelectByDetailedId);
		return user;
	}

	/*--------------- -----<----*删除*---->--- ----------------------*/
	@RequestMapping(value = "/DeleteByCommodity", method = RequestMethod.POST)
	public ResponseEntity<PaginationVo> DeleteByCommodity(@RequestBody String DeleteByDetailedId, Model model) {
		ResponseEntity<PaginationVo> user = detailedListClient.DeleteByCommodity(DeleteByDetailedId);
		return user;
	}
	
	
	@RequestMapping(value = "/DeleteBydetailedId", method = RequestMethod.POST)
	public ResponseEntity<PaginationVo> DeleteByNumber(@RequestBody String DeleteByNumber, Model model) {
		ResponseEntity<PaginationVo> user = detailedListClient.DeleteBydetailedId(DeleteByNumber);
		return user;
	}
	
	@RequestMapping(value = "/DeleteCommodity", method = RequestMethod.POST)
	public ResponseEntity<PaginationVo> DeleteCommodity(@RequestBody String DeleteByNumber, Model model) {
		ResponseEntity<PaginationVo> user = detailedListClient.DeleteCommodity(DeleteByNumber);
		return user;
	}
	
	
	
	
	@RequestMapping(value = "/DeleteAll", method = RequestMethod.POST)
	public ResponseEntity<PaginationVo> DeleteAll(@RequestBody String DeleteAll, Model model) {
		ResponseEntity<PaginationVo> user = detailedListClient.DeleteAll(DeleteAll);
		return user;
	}
	
	
	/*--------------- -----<----*增加*---->--- ----------------------*/

	@RequestMapping(value = "/InsertDetailed", method = RequestMethod.POST)
	public ResponseEntity<PaginationVo> InsertDetailed(@RequestBody String InsertDetailed, Model model) {
		ResponseEntity<PaginationVo> user = detailedListClient.InsertDetailed(InsertDetailed);
		return user;
	}
	
	
	/*--------------- -----<----*修改*---->--- ----------------------*/

	
	@RequestMapping(value = "/UpdateByUserId", method = RequestMethod.POST)
	public ResponseEntity<PaginationVo> UpdateByUserId(@RequestBody String UpdateByUserId, Model model) {
		ResponseEntity<PaginationVo> user = detailedListClient.UpdateByUserId(UpdateByUserId);
		return user;
	}
	
	@RequestMapping(value = "/UpdateByDetailedId", method = RequestMethod.POST)
	public ResponseEntity<PaginationVo> UpdateByDetailedId(@RequestBody String UpdateByDetailedId, Model model) {
		ResponseEntity<PaginationVo> user = detailedListClient.UpdateByDetailedId(UpdateByDetailedId);
		return user;
	}
	
	
	private String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		return uuid;
	}

}
