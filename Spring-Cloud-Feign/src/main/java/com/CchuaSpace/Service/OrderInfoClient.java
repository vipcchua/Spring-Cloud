 package com.cchuaspace.service;

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

import com.cchuaspace.hystrix.CommodityInfoHystrix;
import com.cchuaspace.hystrix.ComputeClientHystrix;
import com.cchuaspace.hystrix.OrderInfoHystrix;
import com.cchuaspace.hystrix.TableUserClientHystrix;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.OrderInfo;
import com.cchuaspace.model.PaginationVo;
import com.cchuaspace.model.TableUser;


@FeignClient(value = "Server-Service", fallback = OrderInfoHystrix.class)
public interface OrderInfoClient {



	
	
	@RequestMapping(method = RequestMethod.POST, value = "/OrderInfo/DeleteByNumber")
	ResponseEntity<PaginationVo> DeleteByNumber(String DeleteCommodityByNumber);
	
	@RequestMapping(method = RequestMethod.POST, value = "/OrderInfo/DeleteById")
	ResponseEntity<PaginationVo> DeleteById(String DeleteCommodityById);

	
	@RequestMapping(method = RequestMethod.POST, value = "/OrderInfo/DeleteById")
	ResponseEntity<PaginationVo> SelectByNumber(String deleteByNumber);
	
	
	
	
	
	
}




