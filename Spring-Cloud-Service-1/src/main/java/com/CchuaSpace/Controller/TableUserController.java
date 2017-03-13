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

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONStreamAware;
import com.cchuaspace.Application;
import com.cchuaspace.currency.AesUtils;
import com.cchuaspace.currency.RSAUtils;
import com.cchuaspace.mapper.TableUserMapper;
import com.cchuaspace.model.TableUser;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.service.TableUserService;
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

/**
 * http://localhost:8080//hhh?name=d62&age=23
 */
@Controller
@RestController
@Api(value = "用户信息表", description = "用户信息的相关操作 table_user")

public class TableUserController {

	private static SqlSessionFactory sqlSessionFactory;
	/* private Logger logger = Logger.getLogger(TableInfoController.class); */

	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private DiscoveryClient client;

	@Autowired
	private TableUserService tableUserService;
	@Resource
	private Application computeServiceApplication;

	/* 在用 */

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
	public ResponseEntity<PaginationVo> SelectuserID(@RequestBody String UserInfo, Model model) {

		/*
		 * List<TableUser> json = JSON.parseArray(UserInfo, TableUser.class);
		 * List<TableUser> user =
		 * tableUserMapper.SelectuserID(json.get(0).getId());
		 * ResponseEntity<List<TableUser>> str= new
		 * ResponseEntity<List<TableUser>>(user,HttpStatus.OK);
		 * System.out.println(str); return str;
		 */

		PaginationVo user = tableUserService.SelectuserID(UserInfo, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	@ApiOperation(value = "查询用户名是否存在", notes = "使用用户名查询用户名是否存在", response = TableUser.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "UserName", value = "请输入制定信息", required = true, dataType = "varchar"), })

	@RequestMapping(value = "/SelectUsername", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> SelectUsername(@RequestBody String UserInfo, Model model) {

		PaginationVo user = tableUserService.SelectUsername(UserInfo, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	@ApiOperation(value = "使用用户名查询指定用户信息", notes = "使用用户名查询用户所有信息", response = TableUser.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "UserName", value = "请输入制定信息", required = true, dataType = "varchar"), })

	@RequestMapping(value = "/UserInfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<PaginationVo> Loginusers(@RequestBody String UserInfo, Model model) {

		PaginationVo user = tableUserService.Loginusers(UserInfo, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	@ApiOperation(value = "使用多重条件查询指定用户信息", notes = "使用多重条件查询指定用户", response = TableUser.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/SelectUserCondition", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<PaginationVo> SelectUserCondition(@RequestBody String UserInfo, Model model) {

		PaginationVo user = tableUserService.SelectUserCondition(UserInfo, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	@ApiOperation(value = "用户身份修改用户信息", notes = "以用户身份修改用户信息", response = TableUser.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@RequestMapping(value = "/UpdateUser", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<PaginationVo> UpdateUser(@RequestBody String UserInsert, Model model) {

		PaginationVo user = tableUserService.UpdateUser(UserInsert, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	@ApiOperation(value = "查询所有用户", notes = "无条件查询所有的用户信息", response = TableUser.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/Selectalluser", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<PaginationVo> alluser(@RequestBody String selectmodeid, Model model) {

		PaginationVo user = tableUserService.alluser(selectmodeid, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	@ApiOperation(value = "查询所有用户数量", notes = "无条件查询所有的用户数量", response = TableUser.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/SelectalluserNumber", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<PaginationVo> alluserNumber() {

		PaginationVo user = tableUserService.alluserNumber();

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	@ApiOperation(value = "查询所有用户", notes = "无条件查询所有的用户信息", response = TableUser.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	/* 在用 */
	@RequestMapping(value = "/Selectallusers", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<PaginationVo> allusers() {

		PaginationVo user = tableUserService.allusers();

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	@ApiOperation(value = "新增一名用户", notes = "（需要管理员权限）新增一名用户  需要指定role :ROLE_ADMIN为管理员，ROLE_USER为用户 , enabled=1开启用户使用,=0未开启使用", response = TableUser.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/UserInsert", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> UserInsert(@RequestBody String UserInsert, Model model) {

		PaginationVo user = tableUserService.UserInsert(UserInsert, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

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
	public ResponseEntity<String> DeleteUserid(@RequestBody String Dmouldinfo) {

		String user = tableUserService.DeleteUserid(Dmouldinfo);

		ResponseEntity<String> data = new ResponseEntity<String>(user, HttpStatus.OK);

		return data;

	}

	@ApiOperation(value = "使用用户名删除用户", notes = "（需要管理员权限）使用用户名删除用户", response = TableUser.class)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "id"),

	})
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	/* 在用 */
	@RequestMapping(value = "/DeleteUserName", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<PaginationVo> DeleteUserName(@RequestBody String Dmouldinfo) {
		/*
		 * List<TableUser> json = JSON.parseArray(Dmouldinfo, TableUser.class);
		 * int Dmouldinfos =
		 * tableUserMapper.DeleteUserName(json.get(0).getUsername()); if
		 * (Dmouldinfos != 0) return "Success"; else return "Error";
		 */

		PaginationVo user = tableUserService.DeleteUserName(Dmouldinfo);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	/*--------------- -----<----*修改*---->--- ----------------------*/

	@ApiOperation(value = "以管理员身份修改用户信息", notes = "（需要管理员权限）以管理员身份修改用户信息，无需原始密码就可以修改用户密码,如需修改用户密码 请加密", response = TableUser.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/AdminUpdateUser", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> AdminUpdateUser(@RequestBody String UserInsert, Model model)
			throws UnsupportedEncodingException {

		PaginationVo user = tableUserService.AdminUpdateUser(UserInsert, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	@ApiOperation(value = "用户身份修改密码", notes = "以用户身份修改个人密码，需要个人原密码，需加密Post", response = TableUser.class)
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@RequestMapping(value = "/Modifypassword", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<PaginationVo> Modifypassword(@RequestBody String UserInsert, Model model) {

		PaginationVo user = tableUserService.Modifypassword(UserInsert, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

	private String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		return uuid;
	}

}
