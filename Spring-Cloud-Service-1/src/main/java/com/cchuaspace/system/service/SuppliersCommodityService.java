package com.cchuaspace.system.service;

import com.alibaba.fastjson.JSONObject;
import com.cchuaspace.currency.CchuaTool;
import com.cchuaspace.mapper.SuppliersCommodityMapper;
import com.cchuaspace.model.SuppliersCommodity;
import com.cchuaspace.pojo.PaginationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

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
public class SuppliersCommodityService {

	@Autowired
	private SuppliersCommodityMapper SuppliersCommodityMapper;

	@Autowired
	private PaginationVo paginationVo;

	@Autowired
	private CchuaTool cchuaTool;

	/*--------------- -----<----*查询*---->--- ----------------------*/
	public PaginationVo selectbynumber(int supplierNumber) {

		SuppliersCommodity data = SuppliersCommodityMapper.SelectByNumberObj(supplierNumber);

		paginationVo.setHtmlState("Success");
		paginationVo.setDataResultObj(data);
		return paginationVo;

	}

	public PaginationVo SelectByCommoditynumber(String commoditynumber) {
		try {
			List<SuppliersCommodity> data = SuppliersCommodityMapper.SelectByCommoditynumber(commoditynumber);
			paginationVo.setDataResultList(data);
			paginationVo.setHtmlState("Success");

			return paginationVo;

		} catch (Exception e) {
			paginationVo.setHtmlState("Error");
			return paginationVo;
		}

	}

	/*--------------- -----<----*删除*---->--- ----------------------*/

	public PaginationVo DeleteByNumber(int supplierNumber,int commodityNumber) {

		int tostate = SuppliersCommodityMapper.DeleteByNumber(supplierNumber,commodityNumber);

		if (tostate != 0)
			paginationVo.setHtmlState("Success");
		else
			paginationVo.setHtmlState("Error");

		return paginationVo;

	}

	public PaginationVo DeleteById(String id) {

		int tostate = SuppliersCommodityMapper.DeleteById(id);

		if (tostate != 0)
			paginationVo.setHtmlState("Success");
		else
			paginationVo.setHtmlState("Error");

		return paginationVo;

	}

	/*--------------- -----<----*增加*---->--- ----------------------*/
	public PaginationVo InsertInfo(String insertinfo) {

		SuppliersCommodity json = JSONObject.parseObject(insertinfo, SuppliersCommodity.class);

		json.setId(cchuaTool.uuid());

		int tostate = SuppliersCommodityMapper.insertSelective(json);

		if (tostate != 0)
			paginationVo.setHtmlState("Success");
		else
			paginationVo.setHtmlState("Error");

		paginationVo.setDataResultObj(json);

		return paginationVo;

	}

	/*--------------- -----<----*修改*---->--- ----------------------*/

}
