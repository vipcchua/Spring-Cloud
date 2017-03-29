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
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.cchuaspace.currency.RSAUtils;

import io.swagger.annotations.Api;
import net.minidev.json.JSONObject;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping(value = "/api/system")
@Api(value = "工具类接口", description = "工具类接口")

public class SecurityController {

	@RequestMapping("/VerifySuccess")
	@ResponseBody
	public JSONObject VerifySuccess() {
		JSONObject Succress = new JSONObject();
		Succress.put("UserLogin", "Success");
		return Succress;

	}

	@RequestMapping("/VerifyFailure")
	@ResponseBody
	public JSONObject VerifyFailure() {
		JSONObject Error = new JSONObject();
		Error.put("UserLogin", "Error Or Fail");
		return Error;

	}

	@RequestMapping("/LogoutSuccess")
	@ResponseBody
	public JSONObject LogoutSuccess() {
		JSONObject LogoutSuccess = new JSONObject();
		LogoutSuccess.put("UserLogin", "Error Or Fail");
		return LogoutSuccess;

	}

	@RequestMapping("/isadmin")
	@ResponseBody
	public JSONObject admin() {
		JSONObject LogoutSuccess = new JSONObject();
		LogoutSuccess.put("UserLogin", "admin");
		System.out.println("ADMIN");
		return LogoutSuccess;

	}

	@RequestMapping("/isuser")
	@ResponseBody
	public JSONObject isuser() {
		JSONObject LogoutSuccess = new JSONObject();
		LogoutSuccess.put("UserLogin", "isuser");
		System.out.println("isuser");
		return LogoutSuccess;

	}

	@RequestMapping("/Rsa")
	@ResponseBody
	public JSONObject getRSAPublicKey() {
		JSONObject result = new JSONObject();
		String thePubKey = RSAUtils.generateBase64PublicKey();
		result.put("thePubKey", thePubKey);
		return result;

	}

}
