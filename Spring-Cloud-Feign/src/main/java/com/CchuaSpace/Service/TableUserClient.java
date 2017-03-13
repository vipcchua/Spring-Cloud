package com.cchuaspace.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cchuaspace.hystrix.TableUserClientHystrix;
import com.cchuaspace.model.PaginationVo;

@FeignClient(value = "Server-Service", fallback = TableUserClientHystrix.class)
public interface TableUserClient {

	@RequestMapping(method = RequestMethod.POST, value = "/SelectuserID")
	ResponseEntity<PaginationVo> SelectUserId(String selectUserId);

	@RequestMapping(method = RequestMethod.POST, value = "/SelectUsername")
	ResponseEntity<PaginationVo> SelectUserName(String selectUserName);

	@RequestMapping(method = RequestMethod.POST, value = "/UserInfo")
	ResponseEntity<PaginationVo> UserInfo(String UserInfo);

	@RequestMapping(method = RequestMethod.POST, value = "/SelectUserCondition")
	ResponseEntity<PaginationVo> SelectUserCondition(String selectUserCondition);

	@RequestMapping(method = RequestMethod.POST, value = "/UpdateUser")
	ResponseEntity<PaginationVo> UpdateUser(String updateUser);

}
