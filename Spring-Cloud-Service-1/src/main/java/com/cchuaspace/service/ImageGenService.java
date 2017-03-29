package com.cchuaspace.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cchuaspace.currency.CchuaTool;
import com.cchuaspace.currency.RandomValidateCode;
import com.cchuaspace.currency.RandomValidateCode.CodeInfo;
import com.cchuaspace.mapper.CommodityCatalogMapper;
import com.cchuaspace.mapper.CommodityInfoMapper;
import com.cchuaspace.mapper.CommunityRelativesMapper;
import com.cchuaspace.model.CommodityCatalog;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.CommunityRelatives;
import com.cchuaspace.pojo.CommodityCatalogVo;
import com.cchuaspace.pojo.CommodityInfoVo;
import com.cchuaspace.pojo.PaginationVo;

/*
 * ****************<--*---Code information---*-->**************
 * 	
 *		Author: Cchua
 *		GitHub: https://github.com/vipcchua
 *		Blog  : weibo.com/vipcchua
 * 
 * 
 * ************************************************************/
@Service

public class ImageGenService {
	@Autowired
	private PaginationVo paginationVo;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	/*--------------- -----<----*查询*---->--- ----------------------*/

	/*--------------- -----<----*删除*---->--- ----------------------*/

	/*--------------- -----<----*增加*---->--- ----------------------*/

	/*--------------- -----<----*修改*---->--- ----------------------*/

	public PaginationVo imageStrings(HttpServletRequest request, HttpServletResponse response) {

		RandomValidateCode randomValidateCode = new RandomValidateCode();

		CodeInfo Code = randomValidateCode.getBase64code();

		CchuaTool cchuaTool = new CchuaTool();

		String Token = cchuaTool.token();

		String ToCodeimg = Code.getBase64Code().toString();
		String ToCodeText = Code.getCode();
		System.out.println("ToCodeText:" + ToCodeText + "ToCodeimg:" + ToCodeimg);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Token", Token);
		jsonObject.put("Codeimg", ToCodeimg);

	/*	stringRedisTemplate.opsForValue().set(Token, ToCodeText);*/

		stringRedisTemplate.opsForValue().set(Token, ToCodeText, 2, TimeUnit.HOURS);

		paginationVo.setDataResultObj(jsonObject);

		return paginationVo;

	}

	private String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		return uuid;
	}

}
