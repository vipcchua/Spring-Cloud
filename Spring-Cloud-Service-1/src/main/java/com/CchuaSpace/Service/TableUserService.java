package com.cchuaspace.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cchuaspace.currency.AesUtils;
import com.cchuaspace.currency.RSAUtils;
import com.cchuaspace.mapper.CommodityInfoMapper;
import com.cchuaspace.mapper.TableUserMapper;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.OrderInfo;
import com.cchuaspace.model.TableUser;
import com.cchuaspace.pojo.CommodityCatalogVo;
import com.cchuaspace.pojo.CommodityInfoVo;
import com.cchuaspace.pojo.PaginationVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

public class TableUserService {
	@Autowired
	private TableUserMapper tableUserMapper;

	@Autowired
	private PaginationVo paginationVo;

	@Autowired
	private DiscoveryClient client;

	private final Logger logger = Logger.getLogger(getClass());

	@ApiOperation(value = "使用id查询指定用户信息", notes = "使用用户id查询用户所有信息", response = TableUser.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@ApiImplicitParams({ @ApiImplicitParam(name = "Id", value = "请输入用户Id", required = true, dataType = "Char"), })

	/* 在用 */
	/*
	 * @RequestMapping(value = "/SelectuserID", method = RequestMethod.POST)
	 * 
	 * @ResponseBody public List<TableUser> SelectuserID(@RequestBody String
	 * UserInfo, Model model) {
	 * 
	 * List<TableUser> json = JSON.parseArray(UserInfo, TableUser.class);
	 * 
	 * List<TableUser> user = tableUserMapper.SelectuserID(json.get(0).getId());
	 * 
	 * System.out.println(user); return user; }
	 */

	@RequestMapping(value = "/SelectuserID", method = RequestMethod.POST)
	public PaginationVo SelectuserID(@RequestBody String UserInfo, Model model) {

		TableUser json = JSONObject.parseObject(UserInfo, TableUser.class);

		List<TableUser> user = tableUserMapper.SelectuserID(json.getId());
		paginationVo.setDataResultObj(json);

		return paginationVo;

	}

	@ApiOperation(value = "查询用户名是否存在", notes = "使用用户名查询用户名是否存在", response = TableUser.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "UserName", value = "请输入制定信息", required = true, dataType = "varchar"), })

	@RequestMapping(value = "/SelectUsername", method = RequestMethod.POST)
	@ResponseBody

	public PaginationVo SelectUsername(@RequestBody String UserInfo, Model model) {

		TableUser json = JSONObject.parseObject(UserInfo, TableUser.class);

		List<TableUser> data = tableUserMapper.SelectUsername(json.getUsername());

		paginationVo.setDataResultObj(data);

		return paginationVo;

	}

	@ApiOperation(value = "使用用户名查询指定用户信息", notes = "使用用户名查询用户所有信息", response = TableUser.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "UserName", value = "请输入制定信息", required = true, dataType = "varchar"), })

	@RequestMapping(value = "/UserInfo", method = RequestMethod.POST)
	@ResponseBody
	public PaginationVo Loginusers(@RequestBody String UserInfo, Model model) {

		TableUser json = JSONObject.parseObject(UserInfo, TableUser.class);

		List<TableUser> data = tableUserMapper.UserInfo(json.getUsername());
		paginationVo.setDataResultObj(data);

		return paginationVo;

	}

	@ApiOperation(value = "使用多重条件查询指定用户信息", notes = "使用多重条件查询指定用户", response = TableUser.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/SelectUserCondition", method = RequestMethod.POST)
	@ResponseBody
	public PaginationVo SelectUserCondition(@RequestBody String UserInfo, Model model) {

		TableUser json = JSONObject.parseObject(UserInfo, TableUser.class);

		List<TableUser> data = tableUserMapper.SelectUserCondition(json);
		paginationVo.setDataResultObj(data);

		return paginationVo;
	}

	@ApiOperation(value = "用户身份修改用户信息", notes = "以用户身份修改用户信息", response = TableUser.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@RequestMapping(value = "/UpdateUser", method = RequestMethod.POST)
	@ResponseBody
	public PaginationVo UpdateUser(@RequestBody String UserInsert, Model model) {

		TableUser json = JSONObject.parseObject(UserInsert, TableUser.class);

		int tostate = tableUserMapper.UpdateUser(json);

		if (tostate != 0)
			paginationVo.setSqlState("Success");
		else
			paginationVo.setSqlState("Error");

		paginationVo.setDataResultObj(json);

		return paginationVo;
	}

	@ApiOperation(value = "查询所有用户", notes = "无条件查询所有的用户信息", response = TableUser.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/Selectalluser", method = RequestMethod.POST)
	@ResponseBody
	public PaginationVo alluser(@RequestBody String selectmodeid, Model model) {

		TableUser json = JSONObject.parseObject(selectmodeid, TableUser.class);

		List<TableUser> data = tableUserMapper.alluser(json.getPage(), json.getPageRow());

		paginationVo.setDataResultObj(data);

		return paginationVo;

	}

	@ApiOperation(value = "查询所有用户数量", notes = "无条件查询所有的用户数量", response = TableUser.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/SelectalluserNumber", method = RequestMethod.POST)
	@ResponseBody
	public PaginationVo alluserNumber() {
		List<TableUser> data = tableUserMapper.alluserNumber();

		paginationVo.setDataResultObj(data);

		return paginationVo;
	}

	@ApiOperation(value = "查询所有用户", notes = "无条件查询所有的用户信息", response = TableUser.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	/* 在用 */
	@RequestMapping(value = "/Selectallusers", method = RequestMethod.POST)
	@ResponseBody
	public PaginationVo allusers() {

		ServiceInstance instance = client.getLocalServiceInstance();

		List<TableUser> data = tableUserMapper.allusers();
		logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
		paginationVo.setDataResultObj(data);

		return paginationVo;

	}

	@ApiOperation(value = "新增一名用户", notes = "（需要管理员权限）新增一名用户  需要指定role :ROLE_ADMIN为管理员，ROLE_USER为用户 , enabled=1开启用户使用,=0未开启使用", response = TableUser.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/UserInsert", method = RequestMethod.POST)
	@ResponseBody

	public PaginationVo UserInsert(@RequestBody String UserInsert, Model model) {

		TableUser json = JSONObject.parseObject(UserInsert, TableUser.class);

		json.setId(uuid());

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
		 * JSONObject usernameobj = JSONObject(rsausername.toString()); //
		 * 在这里转换。 JSONObject passwordobj = JSONObject(rsapassword.toString());
		 * // 在这里转换。
		 */

		JSONObject usernameobj = JSONObject.parseObject(rsausername.toString());
		JSONObject passwordobj = JSONObject.parseObject(rsausername.toString());

		rsausername = usernameobj.get("username").toString();
		rsapassword = passwordobj.get("password").toString();

		json.setUsername(rsausername);
		json.setPassword(rsapassword);

		tableUserMapper.UserInsert(json);

		paginationVo.setDataResultObj(json);

		return paginationVo;

	}

	/*--------------- -----<----*删除*---->--- ----------------------*/
	@ApiOperation(value = "使用ID删除用户", notes = "（需要管理员权限）使用用户ID删除用户", response = TableUser.class)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "id"),

	})
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	/* 在用 */
	@RequestMapping(value = "/DeleteUserid", method = RequestMethod.POST)
	@ResponseBody
	public String DeleteUserid(@RequestBody String Dmouldinfo) {
		/*
		 * List<TableUser> json = JSON.parseArray(Dmouldinfo, TableUser.class);
		 */

		TableUser json = JSONObject.parseObject(Dmouldinfo, TableUser.class);

		int Dmouldinfos = tableUserMapper.DeleteUserid(json.getId());
		if (Dmouldinfos == 1)
			return "Success";
		else
			return "Error";

	}

	@ApiOperation(value = "使用用户名删除用户", notes = "（需要管理员权限）使用用户名删除用户", response = TableUser.class)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "id"),

	})
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	/* 在用 */
	@RequestMapping(value = "/DeleteUserName", method = RequestMethod.POST)
	@ResponseBody
	public PaginationVo DeleteUserName(@RequestBody String Dmouldinfo) {

		/*
		 * List<TableUser> json = JSON.parseArray(Dmouldinfo, TableUser.class);
		 */

		TableUser json = JSONObject.parseObject(Dmouldinfo, TableUser.class);

		int Dmouldinfos = tableUserMapper.DeleteUserName(json.getUsername());

		if (Dmouldinfos != 0)
			paginationVo.setSqlState("Success");
		else
			paginationVo.setSqlState("Error");

		paginationVo.setDataResultObj(json);

		return paginationVo;

	}

	/*--------------- -----<----*修改*---->--- ----------------------*/

	@ApiOperation(value = "以管理员身份修改用户信息", notes = "（需要管理员权限）以管理员身份修改用户信息，无需原始密码就可以修改用户密码,如需修改用户密码 请加密", response = TableUser.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/AdminUpdateUser", method = RequestMethod.POST)
	@ResponseBody

	public PaginationVo AdminUpdateUser(@RequestBody String UserInsert, Model model)
			throws UnsupportedEncodingException {

		String decodeStr = URLDecoder.decode(UserInsert.toString(), "UTF-8");

		/*
		 * List<TableUser> json = JSON.parseArray(decodeStr, TableUser.class);
		 */
		TableUser json = JSONObject.parseObject(decodeStr, TableUser.class);

		String rsausername = json.getUsername().toString();
		String rsapassword = json.getPassword().toString();
		String rsanewpassword = json.getNewpassword().toString();

		try {
			rsausername = AesUtils.aesDecrypt(rsausername, "abcdefgabcdefghi");
			rsapassword = AesUtils.aesDecrypt(rsapassword, "abcdefgabcdefghi");
			rsanewpassword = AesUtils.aesDecrypt(rsanewpassword, "abcdefgabcdefghi");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rsausername = RSAUtils.decryptBase64(rsausername);
		/* username.replaceAll("\"",""); */

		rsapassword = RSAUtils.decryptBase64(rsapassword);
		rsanewpassword = RSAUtils.decryptBase64(rsanewpassword);
		/*
		 * JSONObject usernameobj = new JSONObject(rsausername.toString()); //
		 * 在这里转换。 JSONObject passwordobj = new
		 * JSONObject(rsapassword.toString()); // 在这里转换。 JSONObject
		 * newpasswordobj = new JSONObject(rsanewpassword.toString()); // 在这里转换。
		 */
		JSONObject usernameobj = JSONObject.parseObject(rsausername.toString());
		JSONObject passwordobj = JSONObject.parseObject(rsapassword.toString());
		JSONObject newpasswordobj = JSONObject.parseObject(rsanewpassword.toString());

		rsausername = usernameobj.get("username").toString();
		rsapassword = passwordobj.get("password").toString();
		rsanewpassword = newpasswordobj.get("newpassword").toString();

		json.setUsername(rsausername);
		json.setPassword(rsapassword);
		json.setNewpassword(rsapassword);

		tableUserMapper.AdminUpdateUser(json);

		paginationVo.setDataResultObj(json);

		return paginationVo;

	}

	@ApiOperation(value = "用户身份修改密码", notes = "以用户身份修改个人密码，需要个人原密码，需加密Post", response = TableUser.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@RequestMapping(value = "/Modifypassword", method = RequestMethod.POST)
	@ResponseBody
	public PaginationVo Modifypassword(@RequestBody String UserInsert, Model model) {

		/*
		 * List<TableUser> json = JSON.parseArray(UserInsert, TableUser.class);
		 */

		TableUser json = JSONObject.parseObject(UserInsert, TableUser.class);

		String rsausername = json.getUsername().toString();
		String rsapassword = json.getPassword().toString();
		String rsanewpassword = json.getNewpassword().toString();
		try {
			rsausername = AesUtils.aesDecrypt(rsausername, "abcdefgabcdefghi");
			rsapassword = AesUtils.aesDecrypt(rsapassword, "abcdefgabcdefghi");
			rsanewpassword = AesUtils.aesDecrypt(rsanewpassword, "abcdefgabcdefghi");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rsausername = RSAUtils.decryptBase64(rsausername);
		rsapassword = RSAUtils.decryptBase64(rsapassword);
		rsanewpassword = RSAUtils.decryptBase64(rsanewpassword);

		/*
		 * JSONObject usernameobj = new JSONObject(rsausername.toString()); //
		 * 在这里转换。 JSONObject passwordobj = new
		 * JSONObject(rsapassword.toString()); // 在这里转换。 JSONObject
		 * newpasswordobj = new JSONObject(rsanewpassword.toString()); // 在这里转换。
		 */

		JSONObject usernameobj = JSONObject.parseObject(rsausername.toString());
		JSONObject passwordobj = JSONObject.parseObject(rsapassword.toString());
		JSONObject newpasswordobj = JSONObject.parseObject(rsanewpassword.toString());

		rsausername = usernameobj.get("username").toString();
		rsapassword = passwordobj.get("password").toString();
		rsanewpassword = newpasswordobj.get("newpassword").toString();

		json.setUsername(rsausername);
		json.setPassword(rsapassword);

		List<TableUser> olduserpassword = tableUserMapper.SelectUserpassword(json.getId());

		JSONObject ModifyPassword = new JSONObject();

		if (olduserpassword != null && olduserpassword.size() > 0) {
			if (rsapassword.equals(olduserpassword.get(0).getPassword())) {

				tableUserMapper.userudpassword(json);

				/*ModifyPassword.put("Modify_Password", "Success");
				return ModifyPassword;*/
				paginationVo.setSqlState("Success");
				

			} else {

				/*ModifyPassword.put("Modify_Password", "Error");
				return ModifyPassword;*/
				paginationVo.setSqlState("Error");
			}

		} else {

		/*	ModifyPassword.put("Modify_Password", "Error");
			return ModifyPassword;*/
			paginationVo.setSqlState("Error");
		}
		return paginationVo;

	}

	private String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		return uuid;
	}

}
