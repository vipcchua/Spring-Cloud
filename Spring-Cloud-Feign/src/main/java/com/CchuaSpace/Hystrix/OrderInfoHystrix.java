package com.CchuaSpace.Hystrix;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.CchuaSpace.Model.CommodityInfo;
import com.CchuaSpace.Model.OrderInfo;
import com.CchuaSpace.Model.TableUser;
import com.CchuaSpace.Service.CommodityInfoClient;
import com.CchuaSpace.Service.ComputeClient;
import com.CchuaSpace.Service.OrderInfoClient;
import com.CchuaSpace.Service.TableUserClient;

@Component
public class OrderInfoHystrix implements OrderInfoClient {



	@Override
	public ResponseEntity<List<OrderInfo>> DeleteByNumber(String DeleteCommodityByNumber) {
	     return new ResponseEntity<List<OrderInfo>>(HttpStatus.FORBIDDEN); 
	}

	@Override
	public ResponseEntity<List<OrderInfo>> DeleteById(String DeleteCommodityById) {
	     return new ResponseEntity<List<OrderInfo>>(HttpStatus.FORBIDDEN); 
	}


	

}