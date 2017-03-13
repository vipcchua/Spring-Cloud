package com.cchuaspace.hystrix;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.OrderInfo;
import com.cchuaspace.model.PaginationVo;
import com.cchuaspace.model.TableUser;
import com.cchuaspace.service.CommodityInfoClient;
import com.cchuaspace.service.ComputeClient;
import com.cchuaspace.service.OrderInfoClient;
import com.cchuaspace.service.TableUserClient;

@Component
public class OrderInfoHystrix implements OrderInfoClient {



	@Override
	public ResponseEntity<PaginationVo> DeleteByNumber(String DeleteCommodityByNumber) {
	     return new ResponseEntity<PaginationVo>(HttpStatus.FORBIDDEN); 
	}

	@Override
	public ResponseEntity<PaginationVo> DeleteById(String DeleteCommodityById) {
	     return new ResponseEntity<PaginationVo>(HttpStatus.FORBIDDEN); 
	}

	@Override
	public ResponseEntity<PaginationVo> SelectByNumber(String deleteByNumber) {
	     return new ResponseEntity<PaginationVo>(HttpStatus.FORBIDDEN); 
	}


	

}