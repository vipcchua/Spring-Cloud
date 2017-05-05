package com.cchuaspace.system.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.beanutils.PropertyUtils;
import org.assertj.core.api.IntArrayAssert;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cchuaspace.currency.CchuaTool;
import com.cchuaspace.mapper.CommodityCatalogMapper;
import com.cchuaspace.mapper.CommodityInfoMapper;
import com.cchuaspace.mapper.CommunityRelativesMapper;
import com.cchuaspace.mapper.SuppliersCommodityMapper;
import com.cchuaspace.mapper.SuppliersInfoMapper;
import com.cchuaspace.mapper.WarehouseStockMapper;
import com.cchuaspace.model.CommodityCatalog;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.CommunityRelatives;
import com.cchuaspace.model.SuppliersCommodity;
import com.cchuaspace.model.SuppliersInfo;
import com.cchuaspace.model.WarehouseStock;
import com.cchuaspace.pojo.CommodityCatalogVo;
import com.cchuaspace.pojo.CommodityInfoVo;
import com.cchuaspace.pojo.PaginationVo;

/*
 * ****************<--*---Code information---*-->**************
 * 	
 *		Author: Cchua
 *		GitHub: https://github.com/vipcchua
 *		Blog  : weibo.com/vipcchua
 * 
 * 
 * ************************************************************/
@Service
@Scope("prototype")
public class WarehouseStockService {

	@Autowired
	private WarehouseStockMapper warehouseStockMapper;

	@Autowired
	private PaginationVo paginationVo;

	@Autowired
	private CchuaTool cchuaTool;

	/*--------------- -----<----*查询*---->--- ----------------------*/
	public PaginationVo selectbycommoditynumber(int commodityNumber) {

		List<WarehouseStock> data = warehouseStockMapper.SelectByNumberObj(commodityNumber);

		paginationVo.setHtmlState("Success");
		paginationVo.setDataResultList(data);
		return paginationVo;

	}



	/*--------------- -----<----*删除*---->--- ----------------------*/


	public PaginationVo DeleteById(String id) {

		int tostate = warehouseStockMapper.DeleteById(id);

		if (tostate != 0)
			paginationVo.setHtmlState("Success");
		else
			paginationVo.setHtmlState("Error");

		return paginationVo;

	}

	/*--------------- -----<----*增加*---->--- ----------------------*/
	public PaginationVo InsertInfo(String insertinfo) {

		WarehouseStock json = JSONObject.parseObject(insertinfo, WarehouseStock.class);

		json.setId(cchuaTool.uuid());

		int tostate = warehouseStockMapper.insertSelective(json);

		if (tostate != 0)
			paginationVo.setHtmlState("Success");
		else
			paginationVo.setHtmlState("Error");

		paginationVo.setDataResultObj(json);

		return paginationVo;

	}

	/*--------------- -----<----*修改*---->--- ----------------------*/

}
