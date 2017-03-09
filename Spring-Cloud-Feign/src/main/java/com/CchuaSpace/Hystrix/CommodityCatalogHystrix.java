package com.CchuaSpace.Hystrix;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.CchuaSpace.Model.CommodityCatalog;
import com.CchuaSpace.Model.CommodityInfo;
import com.CchuaSpace.Model.TableUser;
import com.CchuaSpace.Service.CommodityCatalogClient;
import com.CchuaSpace.Service.CommodityInfoClient;
import com.CchuaSpace.Service.ComputeClient;
import com.CchuaSpace.Service.TableUserClient;

@Component
public class CommodityCatalogHystrix implements CommodityCatalogClient {

	@Override
	public ResponseEntity<List<CommodityCatalog>> SelectCatalog(String selectCommodityByNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<CommodityCatalog>> DeleteCatalog(String selectCommodityByNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<CommodityCatalog>> DeleteCatalogById(String selectCommodityByNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<CommodityCatalog>> InsertCommodityInfo(String selectCommodityByNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<CommodityCatalog>> UpdateCatalog(String selectCommodityByNumber) {
		// TODO Auto-generated method stub
		return null;
	}






}