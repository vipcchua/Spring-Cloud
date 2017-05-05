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
import com.cchuaspace.mapper.SuppliersInfoMapper;
import com.cchuaspace.model.CommodityCatalog;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.CommunityRelatives;
import com.cchuaspace.model.SuppliersInfo;
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
public class SuppliersInfoService {

	@Autowired
	private SuppliersInfoMapper suppliersInfoMapper;

	@Autowired
	private PaginationVo paginationVo;

	@Autowired
	private CchuaTool cchuaTool;

	/*--------------- -----<----*查询*---->--- ----------------------*/
	public PaginationVo selectbynumber(int supplierNumber) {

		SuppliersInfo data = suppliersInfoMapper.SelectByNumberObj(supplierNumber);

		paginationVo.setHtmlState("Success");
		paginationVo.setDataResultObj(data);
		return paginationVo;

	}

	public PaginationVo suppliername(String supplierName) {
		try {
			List<SuppliersInfo> data = suppliersInfoMapper.SelectByNameList(supplierName);
			paginationVo.setDataResultList(data);
			paginationVo.setHtmlState("Success");

			return paginationVo;

		} catch (Exception e) {
			paginationVo.setHtmlState("Error");
			return paginationVo;
		}

	}



	/*--------------- -----<----*删除*---->--- ----------------------*/

	public PaginationVo DeleteByNumber(int supplierNumber) {
		
		
		
		int tostate =suppliersInfoMapper.DeleteByNumber(supplierNumber);
		
		if (tostate != 0)
			paginationVo.setHtmlState("Success");
		else
			paginationVo.setHtmlState("Error");

		
		return paginationVo;

	}
	
	public PaginationVo DeleteById(String id) {
		
			
		int tostate =suppliersInfoMapper.DeleteById(id);
		
		if (tostate != 0)
			paginationVo.setHtmlState("Success");
		else
			paginationVo.setHtmlState("Error");
		
		return paginationVo;

	}
	
	
	
	
	/*--------------- -----<----*增加*---->--- ----------------------*/
	public PaginationVo InsertInfo(String insertinfo) {
	
		SuppliersInfo json = JSONObject.parseObject(insertinfo, SuppliersInfo.class);
		json.setId(cchuaTool.uuid());
		json.setSupplierNumber(cchuaTool.getOrderNumber(0, 1));
		int tostate =suppliersInfoMapper.insertSelective(json);
		
		if (tostate != 0)
			paginationVo.setHtmlState("Success");
		else
			paginationVo.setHtmlState("Error");
		
		paginationVo.setDataResultObj(json);

		
		return paginationVo;

	}
	
	/*--------------- -----<----*修改*---->--- ----------------------*/

}
