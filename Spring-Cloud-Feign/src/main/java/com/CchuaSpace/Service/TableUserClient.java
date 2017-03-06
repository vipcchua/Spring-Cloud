 package com.CchuaSpace.Service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/*
@FeignClient("Server-Service")
public interface ComputeClient {

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

}
compute-service
*/

import com.CchuaSpace.Hystrix.ComputeClientHystrix;
import com.CchuaSpace.Hystrix.TableUserClientHystrix;
import com.CchuaSpace.Model.TableUser;


@FeignClient(value = "Server-Service", fallback = TableUserClientHystrix.class)
public interface TableUserClient {

	@RequestMapping(method = RequestMethod.POST, value = "/SelectuserID")
	ResponseEntity<List<TableUser>> SelectUserId(String selectUserId);

	
	
	@RequestMapping(method = RequestMethod.POST, value = "/SelectUsername")
	ResponseEntity<List<TableUser>> SelectUserName(String selectUserName);


	@RequestMapping(method = RequestMethod.POST, value = "/UserInfo")
	ResponseEntity<List<TableUser>> UserInfo(String UserInfo);


	@RequestMapping(method = RequestMethod.POST, value = "/SelectUserCondition")
	ResponseEntity<List<TableUser>> SelectUserCondition(String selectUserCondition);


	@RequestMapping(method = RequestMethod.POST, value = "/UpdateUser")
	ResponseEntity<List<TableUser>> UpdateUser(String updateUser);

	
	

}




