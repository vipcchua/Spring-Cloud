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
import com.CchuaSpace.Hystrix.TableUserClientHystrix;
import com.CchuaSpace.Model.CommodityInfo;
import com.CchuaSpace.Model.TableUser;


@FeignClient(value = "Server-Service", fallback = CommodityInfoHystrix.class)
public interface CommodityInfoClient {

	@RequestMapping(method = RequestMethod.POST, value = "/SelectCommodityByNumber")
	ResponseEntity<List<CommodityInfo>> SelectCommodityByNumber(String selectCommodityByNumber);

	@RequestMapping(method = RequestMethod.POST, value = "/SelectCommodityById")
	ResponseEntity<List<CommodityInfo>> SelectCommodityById(String selectCommodityById);

	@RequestMapping(method = RequestMethod.POST, value = "/SelectCommodityInfo")
	ResponseEntity<List<CommodityInfo>> SelectCommodityInfo(String SelectCommodityInfo);

	@RequestMapping(method = RequestMethod.POST, value = "/DeleteCommodityByNumber")
	ResponseEntity<List<CommodityInfo>> DeleteCommodityByNumber(String DeleteCommodityByNumber);
	
	@RequestMapping(method = RequestMethod.POST, value = "/DeleteCommodityById")
	ResponseEntity<List<CommodityInfo>> DeleteCommodityById(String DeleteCommodityById);
	
	@RequestMapping(method = RequestMethod.POST, value = "/InsertCommodityInfo")
	ResponseEntity<List<CommodityInfo>> InsertCommodityInfo(String insertCommodityInfo);
	
	@RequestMapping(method = RequestMethod.POST, value = "/UpdCommodityInfoById")
	ResponseEntity<List<CommodityInfo>> UpdCommodityInfoById(String selectCommodityInfo);
	
	@RequestMapping(method = RequestMethod.POST, value = "/updCommodityInfoByNumber")
	ResponseEntity<List<CommodityInfo>> UpdCommodityInfoByNumber(String updCommodityInfoByNumber);

	
	
	
	
	
}




