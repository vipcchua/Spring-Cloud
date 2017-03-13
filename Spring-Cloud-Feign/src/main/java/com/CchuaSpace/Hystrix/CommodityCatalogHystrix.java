package com.cchuaspace.hystrix;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.cchuaspace.model.CommodityCatalog;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.PaginationVo;
import com.cchuaspace.model.TableUser;
import com.cchuaspace.service.CommodityCatalogClient;
import com.cchuaspace.service.CommodityInfoClient;
import com.cchuaspace.service.ComputeClient;
import com.cchuaspace.service.TableUserClient;

@Component
public class CommodityCatalogHystrix implements CommodityCatalogClient {

	@Override
	public ResponseEntity<PaginationVo> SelectCatalog(String selectCommodityByNumber) {
	     return new ResponseEntity<PaginationVo>(HttpStatus.FORBIDDEN); 
	}

	@Override
	public ResponseEntity<PaginationVo> DeleteCatalog(String selectCommodityByNumber) {
	     return new ResponseEntity<PaginationVo>(HttpStatus.FORBIDDEN); 
	}

	@Override
	public ResponseEntity<PaginationVo> DeleteCatalogById(String selectCommodityByNumber) {
	     return new ResponseEntity<PaginationVo>(HttpStatus.FORBIDDEN); 
	}

	@Override
	public ResponseEntity<PaginationVo> InsertCommodityInfo(String selectCommodityByNumber) {
	     return new ResponseEntity<PaginationVo>(HttpStatus.FORBIDDEN); 
	}

	@Override
	public ResponseEntity<PaginationVo> UpdateCatalog(String selectCommodityByNumber) {
	     return new ResponseEntity<PaginationVo>(HttpStatus.FORBIDDEN); 
	}






}