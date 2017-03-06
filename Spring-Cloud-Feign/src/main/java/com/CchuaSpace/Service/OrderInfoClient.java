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

import com.CchuaSpace.Hystrix.CommodityInfoHystrix;
import com.CchuaSpace.Hystrix.ComputeClientHystrix;
import com.CchuaSpace.Hystrix.OrderInfoHystrix;
import com.CchuaSpace.Hystrix.TableUserClientHystrix;
import com.CchuaSpace.Model.CommodityInfo;
import com.CchuaSpace.Model.OrderInfo;
import com.CchuaSpace.Model.TableUser;


@FeignClient(value = "Server-Service", fallback = OrderInfoHystrix.class)
public interface OrderInfoClient {



	
	
	@RequestMapping(method = RequestMethod.POST, value = "/OrderInfo/DeleteByNumber")
	ResponseEntity<List<OrderInfo>> DeleteByNumber(String DeleteCommodityByNumber);
	
	@RequestMapping(method = RequestMethod.POST, value = "/OrderInfo/DeleteById")
	ResponseEntity<List<OrderInfo>> DeleteById(String DeleteCommodityById);
	
	
	
	
	
	
}




