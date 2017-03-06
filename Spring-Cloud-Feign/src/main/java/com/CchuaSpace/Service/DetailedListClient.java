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
import com.CchuaSpace.Hystrix.DetailedListHystrix;
import com.CchuaSpace.Hystrix.TableUserClientHystrix;
import com.CchuaSpace.Model.CommodityInfo;
import com.CchuaSpace.Model.DetailedList;
import com.CchuaSpace.Model.TableUser;


@FeignClient(value = "Server-Service", fallback = DetailedListHystrix.class)

public interface DetailedListClient {

	@RequestMapping(method = RequestMethod.POST, value = "/Detailed/SelectByUserId")
	ResponseEntity<List<DetailedList>> SelectByUserId(String selectByUserId);

	@RequestMapping(method = RequestMethod.POST, value = "/Detailed/SelectByDetailedId")
	ResponseEntity<List<DetailedList>> SelectByDetailedId(String selectByDetailedId);

	@RequestMapping(method = RequestMethod.POST, value = "/Detailed/DeleteByDetailedId")
	ResponseEntity<List<DetailedList>> DeleteByCommodity(String deleteByDetailedId);

	@RequestMapping(method = RequestMethod.POST, value = "/Detailed/DeleteBydetailedId")
	ResponseEntity<List<DetailedList>> DeleteBydetailedId(String deleteByNumber);

	@RequestMapping(method = RequestMethod.POST, value = "/Detailed/DeleteCommodity")
	ResponseEntity<List<DetailedList>> DeleteCommodity(String deleteByNumber);
	
	@RequestMapping(method = RequestMethod.POST, value = "/Detailed/DeleteAll")
	ResponseEntity<List<DetailedList>> DeleteAll(String deleteAll);

	@RequestMapping(method = RequestMethod.POST, value = "/Detailed/InsertDetailed")
	ResponseEntity<List<DetailedList>> InsertDetailed(String insertDetailed);

	@RequestMapping(method = RequestMethod.POST, value = "/Detailed/UpdateByUserId")
	ResponseEntity<List<DetailedList>> UpdateByUserId(String updateByUserId);

	@RequestMapping(method = RequestMethod.POST, value = "/Detailed/UpdateByDetailedId")
	ResponseEntity<List<DetailedList>> UpdateByDetailedId(String updateByDetailedId);
	



	
	
	 
	
}




