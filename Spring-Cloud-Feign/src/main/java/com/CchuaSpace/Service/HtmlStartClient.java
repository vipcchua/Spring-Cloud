 package com.cchuaspace.service;

import org.springframework.cloud.netflix.feign.FeignClient;
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
import com.cchuaspace.hystrix.HtmlStartHystrix;


@FeignClient(value = "Server-Service", fallback = HtmlStartHystrix.class)
public interface HtmlStartClient {
  


	@RequestMapping(value = "/")
	String indexstart();


}




