package com.cchuaspace.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cchuaspace.model.TableUser;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.service.LoginService;
import com.cchuaspace.service.TableUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping(value = "/api/system")
@Api(value = "后台登陆接口", description = "后台登陆接口")

public class LoignController {
	@Autowired
	private LoginService loginService;

	@ApiOperation(value = "以管理员身份修改用户信息", notes = "（需要管理员权限）以管理员身份修改用户信息，无需原始密码就可以修改用户密码,如需修改用户密码 请加密", response = TableUser.class)

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<PaginationVo> AdminUpdateUser(@RequestBody String userlogin, Model model)
			throws UnsupportedEncodingException {

		PaginationVo user = loginService.userlogin(userlogin, model);

		ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

		return data;

	}

}
