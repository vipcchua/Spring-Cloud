 package com.cchuaspace.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
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

import com.cchuaspace.hystrix.ComputeClientHystrix;
import com.cchuaspace.model.PaginationVo;
import com.cchuaspace.model.TableUser;


@FeignClient(value = "Server-Service", fallback = ComputeClientHystrix.class)
public interface ComputeClient {
  
	@RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

	
	@RequestMapping(value = "/Selectallusers")
	String Selectalluser();

	

	@RequestMapping(value = "/Seldsada")
	String Seldsada();

	@RequestMapping(value = "/login")
	String login();

	@RequestMapping(method = RequestMethod.POST, value = "/SelectuserID")
	ResponseEntity<PaginationVo> SelectUserId(String selectUserId);


}




