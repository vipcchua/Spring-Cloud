package com.cchuaspace.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cchuaspace.currency.AesUtils;
import com.cchuaspace.currency.RSAUtils;
import com.cchuaspace.mapper.TableUserMapper;
import com.cchuaspace.model.TableUser;
import com.cchuaspace.pojo.PaginationVo;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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

public class LoginService {

	@Autowired
	private TableUserMapper tableUserMapper;

	@Autowired
	private PaginationVo paginationVo;

	@Autowired
	private DiscoveryClient client;

	private final Logger logger = Logger.getLogger(getClass());

	/* login */

	public PaginationVo userlogin(@RequestBody String userlogin, Model model) throws UnsupportedEncodingException {

		String decodeStr = URLDecoder.decode(userlogin.toString(), "UTF-8");

		/*
		 * List<TableUser> json = JSON.parseArray(decodeStr, TableUser.class);
		 */
		TableUser json = JSONObject.parseObject(decodeStr, TableUser.class);

		String rsausername = json.getUsername().toString();
		String rsapassword = json.getPassword().toString();

		try {
			rsausername = AesUtils.aesDecrypt(rsausername, "abcdefgabcdefghi");
			rsapassword = AesUtils.aesDecrypt(rsapassword, "abcdefgabcdefghi");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rsausername = RSAUtils.decryptBase64(rsausername);
		/* username.replaceAll("\"",""); */

		rsapassword = RSAUtils.decryptBase64(rsapassword);

		/*
		 * JSONObject usernameobj = new JSONObject(rsausername.toString()); //
		 * 在这里转换。 JSONObject passwordobj = new
		 * JSONObject(rsapassword.toString()); // 在这里转换。 JSONObject
		 * newpasswordobj = new JSONObject(rsanewpassword.toString()); // 在这里转换。
		 */
		JSONObject usernameobj = JSONObject.parseObject(rsausername.toString());
		JSONObject passwordobj = JSONObject.parseObject(rsapassword.toString());

		rsausername = usernameobj.get("username").toString();
		rsapassword = passwordobj.get("password").toString();

		json.setUsername(rsausername);
		json.setPassword(rsapassword);
		json.setNewpassword(rsapassword);

		tableUserMapper.AdminUpdateUser(json);

		paginationVo.setDataResultObj(json);

		return paginationVo;

	}
}
