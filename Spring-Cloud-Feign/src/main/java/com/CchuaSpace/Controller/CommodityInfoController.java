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
import java.util.Map;

import javax.annotation.Resource;
import javax.swing.text.html.HTML.Tag;
import java.util.UUID;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import com.CchuaSpace.Currency.AesUtils;
import com.CchuaSpace.Currency.RSAUtils;

import com.CchuaSpace.Model.CommodityInfo;
import com.CchuaSpace.Model.TableUser;
import com.CchuaSpace.Service.CommodityInfoClient;
import com.CchuaSpace.Service.TableUserClient;
import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONStreamAware;
import com.mysql.cj.core.exceptions.PasswordExpiredException;

import groovy.lang.IntRange;
import groovy.transform.builder.InitializerStrategy.SET;

import org.json.JSONObject;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
@RequestMapping(value = "/Commodit")
@Api(value = "商品信息表", description = "用户信息的相关操作")

public class CommodityInfoController {
	   @Autowired
	   CommodityInfoClient commodityInfoClient;

		/*--------------- -----<----*查询*---->--- ----------------------*/

	@RequestMapping(value = "/SelectCommodityByNumber", method = RequestMethod.POST)
		public ResponseEntity<List<CommodityInfo>> SelectCommodityByNumber(@RequestBody String SelectCommodityByNumber, Model model) {		
      	ResponseEntity<List<CommodityInfo>> user = commodityInfoClient.SelectCommodityByNumber(SelectCommodityByNumber);
    	return user;

	
	}
	
	
	@RequestMapping(value = "/SelectCommodityById", method = RequestMethod.POST)
	public ResponseEntity<List<CommodityInfo>> SelectCommodityById(@RequestBody String SelectCommodityById, Model model) {		
  	ResponseEntity<List<CommodityInfo>> user = commodityInfoClient.SelectCommodityById(SelectCommodityById);
	return user;

	}
	
	@RequestMapping(value = "/SelectCommodityInfo", method = RequestMethod.POST)
	public ResponseEntity<List<CommodityInfo>> SelectCommodityInfo(@RequestBody String SelectCommodityInfo, Model model) {		
  	ResponseEntity<List<CommodityInfo>> user = commodityInfoClient.SelectCommodityInfo(SelectCommodityInfo);
	return user;

	}
	
	/*--------------- -----<----*删除*---->--- ----------------------*/

	@RequestMapping(value = "/DeleteCommodityByNumber", method = RequestMethod.POST)
	public ResponseEntity<List<CommodityInfo>> DeleteCommodityByNumber(@RequestBody String DeleteCommodityByNumber, Model model) {		
  	ResponseEntity<List<CommodityInfo>> user = commodityInfoClient.DeleteCommodityByNumber(DeleteCommodityByNumber);
	return user;

	}
	
	@RequestMapping(value = "/DeleteCommodityById", method = RequestMethod.POST)
	public ResponseEntity<List<CommodityInfo>> DeleteCommodityById(@RequestBody String DeleteCommodityById, Model model) {		
  	ResponseEntity<List<CommodityInfo>> user = commodityInfoClient.DeleteCommodityById(DeleteCommodityById);
	return user;
	}
	
	/*--------------- -----<----*增加*---->--- ----------------------*/


	@RequestMapping(value = "/InsertCommodityInfo", method = RequestMethod.POST)
	public ResponseEntity<List<CommodityInfo>> InsertCommodityInfo(@RequestBody String InsertCommodityInfo, Model model) {		
  	ResponseEntity<List<CommodityInfo>> user = commodityInfoClient.InsertCommodityInfo(InsertCommodityInfo);
	return user;
	}
	
	
	/*--------------- -----<----*修改*---->--- ----------------------*/
	
	
	@RequestMapping(value = "/UpdCommodityInfoById", method = RequestMethod.POST)
	public ResponseEntity<List<CommodityInfo>> UpdCommodityInfoById(@RequestBody String UpdCommodityInfoById, Model model) {		
  	ResponseEntity<List<CommodityInfo>> user = commodityInfoClient.UpdCommodityInfoById(UpdCommodityInfoById);
	return user;

	}
	
	@RequestMapping(value = "/UpdCommodityInfoByNumber", method = RequestMethod.POST)
	public ResponseEntity<List<CommodityInfo>> UpdCommodityInfoByNumber(@RequestBody String UpdCommodityInfoByNumber, Model model) {		
  	ResponseEntity<List<CommodityInfo>> user = commodityInfoClient.UpdCommodityInfoByNumber(UpdCommodityInfoByNumber);
	return user;

	}
	
	
	
	
	private String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		return uuid;
	}

}
