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

import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cchuaspace.currency.RandomValidateCode;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.security.InterfaceData;
import com.cchuaspace.service.CommodityInfoService;
import com.cchuaspace.service.ImageGenService;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping(value = "/api/system")
public class ImageGenController {

	@Autowired
	private ImageGenService imageGenService;

	@Autowired
	private PaginationVo paginationVo;
	
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	String Usersession;

	public String getUsersession() {
		return Usersession;
	}

	public void setUsersession(String usersession) {
		Usersession = usersession;
	}



	// 登录获取验证码
	@RequestMapping("/getSysManageLoginCodes")
	@ResponseBody
	public String getSysManageLoginCode(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
		response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Set-Cookie", "name=value; HttpOnly");// 设置HttpOnly属性,防止Xss攻击
		response.setDateHeader("Expire", 0);
		RandomValidateCode randomValidateCode = new RandomValidateCode();
		try {
			randomValidateCode.getRandcode(request, response, "imagecode");// 输出图片方法

		} catch (Exception e) {
			e.printStackTrace();
		}
		return uuid();
	}

	@RequestMapping("/api/system/getverifiCode")

	@ResponseBody
	public ResponseEntity<PaginationVo> imageStrings(HttpServletRequest request, HttpServletResponse response) {

		PaginationVo user = imageGenService.imageStrings(request, response);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		// 这里我没有进行字母大小模糊的验证处理，感兴趣的你可以去试一下！

		
		
		
		return data;
	}

	@RequestMapping(value = "/SelectByCode")
	@ResponseBody

	public String SelectByNumber(HttpServletRequest request, HttpServletResponse response) {
	
		
		String data = request.getHeader("Token");
		
	System.out.println(data);
	
		return data;

	}
	
	
	
	@RequestMapping(value = "/checkimagecode")
	@ResponseBody
	public String checkTcode(HttpServletRequest request, HttpServletResponse response) {
		String validateCode = request.getParameter("ValidateCode");
		String code = null;
		// 1:获取cookie里面的验证码信息
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("imagecode".equals(cookie.getName())) {
				code = cookie.getValue();
				break;
			}
		}

		// 1:获取session验证码的信息
		// String code1 = (String) request.getSession().getAttribute("");
		// 2:判断验证码是否正确

		String session = (String) request.getSession().getAttribute("ValidateCode");

		System.out.println(session);

		if (!StringUtils.isEmpty(validateCode) && validateCode.equals(code)) {
			return "ok";

		}
		return "error";
		// 这里我没有进行字母大小模糊的验证处理，感兴趣的你可以去试一下！
	}

	// 验证码验证

	@RequestMapping("/verifiCode")
	@ResponseBody
	public String validateCode(HttpServletRequest request, @RequestBody String validateCode) {

		List<InterfaceData> json = JSON.parseArray(validateCode, InterfaceData.class);
		String systemcookie = json.get(0).getInterface();
		String cookies = request.getSession().getAttribute("ValidateCode").toString();

		if (systemcookie.equalsIgnoreCase(cookies)) {
			return "ok";

		} else {

			Enumeration<String> em = request.getSession().getAttributeNames();

			while (em.hasMoreElements()) {
				request.getSession().removeAttribute(em.nextElement().toString());
			}
			request.getSession().removeAttribute("da");
			return "Code error";

		}

	}


	
	
	
	
	private String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		return uuid;
	}

}