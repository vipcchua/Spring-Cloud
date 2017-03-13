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
import com.cchuaspace.hystrix.TableUserClientHystrix;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.PaginationVo;
import com.cchuaspace.model.TableUser;


@FeignClient(value = "Server-Service", fallback = CommodityInfoHystrix.class)
public interface CommodityInfoClient {
	/*--------------- -----<----*查询*---->--- ----------------------*/
	@RequestMapping(method = RequestMethod.POST, value = "/Commodit/SelectCommodityByNumber")
	ResponseEntity<PaginationVo> SelectCommodityByNumber(String selectCommodityByNumber);

	@RequestMapping(method = RequestMethod.POST, value = "/Commodit/SelectCommodityById")
	ResponseEntity<PaginationVo> SelectCommodityById(String selectCommodityById);

	@RequestMapping(method = RequestMethod.POST, value = "/Commodit/SelectCommodityInfo")
	ResponseEntity<PaginationVo> SelectCommodityInfo(String SelectCommodityInfo);
	/*--------------- -----<----*删除*---->--- ----------------------*/
	@RequestMapping(method = RequestMethod.POST, value = "/Commodit/DeleteCommodityByNumber")
	ResponseEntity<PaginationVo> DeleteCommodityByNumber(String DeleteCommodityByNumber);
	
	@RequestMapping(method = RequestMethod.POST, value = "/Commodit/DeleteCommodityById")
	ResponseEntity<PaginationVo> DeleteCommodityById(String DeleteCommodityById);
	/*--------------- -----<----*增加*---->--- ----------------------*/
	@RequestMapping(method = RequestMethod.POST, value = "/Commodit/InsertCommodityInfo")
	ResponseEntity<PaginationVo> InsertCommodityInfo(String insertCommodityInfo);
	/*--------------- -----<----*修改*---->--- ----------------------*/
	@RequestMapping(method = RequestMethod.POST, value = "/Commodit/UpdCommodityInfoById")
	ResponseEntity<PaginationVo> UpdCommodityInfoById(String selectCommodityInfo);
	
	@RequestMapping(method = RequestMethod.POST, value = "/Commodit/updCommodityInfoByNumber")
	ResponseEntity<PaginationVo> UpdCommodityInfoByNumber(String updCommodityInfoByNumber);

	
	
	
	
	
}




