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

import com.CchuaSpace.Hystrix.CommodityCatalogHystrix;
import com.CchuaSpace.Hystrix.CommodityInfoHystrix;
import com.CchuaSpace.Hystrix.ComputeClientHystrix;
import com.CchuaSpace.Hystrix.TableUserClientHystrix;
import com.CchuaSpace.Model.CommodityCatalog;
import com.CchuaSpace.Model.CommodityInfo;
import com.CchuaSpace.Model.TableUser;


@FeignClient(value = "Server-Service", fallback = CommodityCatalogHystrix.class)
public interface CommodityCatalogClient {



	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/Catalog/SelectCatalog")
	ResponseEntity<List<CommodityCatalog>> SelectCatalog(String selectCommodityByNumber);


	@RequestMapping(method = RequestMethod.POST, value = "/Catalog/DeleteCatalog")
	ResponseEntity<List<CommodityCatalog>> DeleteCatalog(String selectCommodityByNumber);

	@RequestMapping(method = RequestMethod.POST, value = "/Catalog/DeleteCatalogById")
	ResponseEntity<List<CommodityCatalog>> DeleteCatalogById(String selectCommodityByNumber);

	@RequestMapping(method = RequestMethod.POST, value = "/Catalog/InsertCommodityInfo")
	ResponseEntity<List<CommodityCatalog>> InsertCommodityInfo(String selectCommodityByNumber);

	@RequestMapping(method = RequestMethod.POST, value = "/Catalog/UpdateCatalog")
	ResponseEntity<List<CommodityCatalog>> UpdateCatalog(String selectCommodityByNumber);
	
}




