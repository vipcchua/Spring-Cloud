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

import com.cchuaspace.hystrix.CommodityCatalogHystrix;
import com.cchuaspace.hystrix.CommodityInfoHystrix;
import com.cchuaspace.hystrix.CommunityRelativesHystrix;
import com.cchuaspace.hystrix.ComputeClientHystrix;
import com.cchuaspace.hystrix.TableUserClientHystrix;
import com.cchuaspace.model.CommodityCatalog;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.PaginationVo;
import com.cchuaspace.model.TableUser;

@FeignClient(value = "Server-Service", fallback = CommunityRelativesHystrix.class)
public interface CommunityRelativesClient {

	/*--------------- -----<----*查询*---->--- ----------------------*/

	@RequestMapping(method = RequestMethod.POST, value = "/Relatives/SelectClassifyProduct")
	ResponseEntity<PaginationVo> SelectClassifyProduct(String selectCommodityByNumber);

	/*--------------- -----<----*删除*---->--- ----------------------*/
	@RequestMapping(method = RequestMethod.POST, value = "/Relatives/SelectClassifyProduct")
	ResponseEntity<PaginationVo> DeleteByNumber(String selectCommodityByNumber);

	/*--------------- -----<----*增加*---->--- ----------------------*/
	@RequestMapping(method = RequestMethod.POST, value = "/Relatives/SelectClassifyProduct")
	ResponseEntity<PaginationVo> InsertRelativesr(String selectCommodityByNumber);

	/*--------------- -----<----*修改*---->--- ----------------------*/
	@RequestMapping(method = RequestMethod.POST, value = "/Relatives/SelectClassifyProduct")
	ResponseEntity<PaginationVo> UpdateCatalog(String selectCommodityByNumber);

}
