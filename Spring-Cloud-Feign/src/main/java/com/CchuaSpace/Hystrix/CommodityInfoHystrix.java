package com.CchuaSpace.Hystrix;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.CchuaSpace.Model.CommodityInfo;
import com.CchuaSpace.Model.TableUser;
import com.CchuaSpace.Service.CommodityInfoClient;
import com.CchuaSpace.Service.ComputeClient;
import com.CchuaSpace.Service.TableUserClient;

@Component
public class CommodityInfoHystrix implements CommodityInfoClient {

	@Override
	public ResponseEntity<List<CommodityInfo>> SelectCommodityByNumber(String selectCommodityByNumber) {
	     return new ResponseEntity<List<CommodityInfo>>(HttpStatus.FORBIDDEN); 
	}

	@Override
	public ResponseEntity<List<CommodityInfo>> SelectCommodityById(String selectCommodityById) {
	     return new ResponseEntity<List<CommodityInfo>>(HttpStatus.FORBIDDEN);
	}

	@Override
	public ResponseEntity<List<CommodityInfo>> SelectCommodityInfo(String SelectCommodityInfo) {
	     return new ResponseEntity<List<CommodityInfo>>(HttpStatus.FORBIDDEN);
	}

	@Override
	public ResponseEntity<List<CommodityInfo>> DeleteCommodityByNumber(String DeleteCommodityByNumber) {
		 return new ResponseEntity<List<CommodityInfo>>(HttpStatus.FORBIDDEN);
	}

	@Override
	public ResponseEntity<List<CommodityInfo>> DeleteCommodityById(String DeleteCommodityById) {
		 return new ResponseEntity<List<CommodityInfo>>(HttpStatus.FORBIDDEN);
	}

	@Override
	public ResponseEntity<List<CommodityInfo>> InsertCommodityInfo(String insertCommodityInfo) {
		 return new ResponseEntity<List<CommodityInfo>>(HttpStatus.FORBIDDEN);
	}

	@Override
	public ResponseEntity<List<CommodityInfo>> UpdCommodityInfoById(String selectCommodityInfo) {
		 return new ResponseEntity<List<CommodityInfo>>(HttpStatus.FORBIDDEN);
	}

	@Override
	public ResponseEntity<List<CommodityInfo>> UpdCommodityInfoByNumber(String updCommodityInfoByNumber) {
		 return new ResponseEntity<List<CommodityInfo>>(HttpStatus.FORBIDDEN);
	}

	

}