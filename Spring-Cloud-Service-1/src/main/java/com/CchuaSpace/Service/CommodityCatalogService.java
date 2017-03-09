package com.CchuaSpace.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

import com.CchuaSpace.Mapper.CommodityCatalogMapper;
import com.CchuaSpace.Mapper.CommodityInfoMapper;
import com.CchuaSpace.Model.CommodityCatalog;
import com.CchuaSpace.Model.CommodityInfo;
import com.CchuaSpace.Pojo.CommodityCatalogVo;
import com.CchuaSpace.Pojo.CommodityInfoVo;
import com.CchuaSpace.Pojo.PaginationVo;
import com.alibaba.fastjson.JSON;

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

public class CommodityCatalogService {

	@Autowired
	private CommodityCatalogMapper commodityCatalogMapper;

	@Autowired
	private PaginationVo paginationVo;

	/*--------------- -----<----*查询*---->--- ----------------------*/
	public PaginationVo SelectCatalog(@RequestBody String commodityInfo, Model model) {

		List<CommodityCatalog> json = JSON.parseArray(commodityInfo, CommodityCatalog.class);

		List<CommodityCatalog> data = commodityCatalogMapper.SelectCatalog(json.get(0));

		paginationVo.setDataResult(data);

		return paginationVo;

	}

	/*--------------- -----<----*删除*---->--- ----------------------*/
	public PaginationVo DeleteByCommodity(@RequestBody String CommodityInfo, Model model) {
		List<CommodityCatalog> json = JSON.parseArray(CommodityInfo, CommodityCatalog.class);
		int tostate = commodityCatalogMapper.DeleteCatalog(json.get(0));

		if (tostate != 0)
			paginationVo.setSqlState("Success");
		else
			paginationVo.setSqlState("Error");

		paginationVo.setDataResult(json);

		return paginationVo;

	}

	public PaginationVo DeleteCatalogById(@RequestBody String CommodityInfo, Model model) {
		List<CommodityCatalog> json = JSON.parseArray(CommodityInfo, CommodityCatalog.class);
		int tostate = commodityCatalogMapper.DeleteCatalog(json.get(0));

		if (tostate != 0)
			paginationVo.setSqlState("Success");
		else
			paginationVo.setSqlState("Error");

		paginationVo.setDataResult(json);

		return paginationVo;

	}

	/*--------------- -----<----*增加*---->--- ----------------------*/

	public PaginationVo InsertCommodityInfo(@RequestBody String CommodityInfo, Model model) {
		List<CommodityCatalog> json = JSON.parseArray(CommodityInfo, CommodityCatalog.class);
		json.get(0).setCatalogId(uuid());
		List<CommodityCatalog> user = commodityCatalogMapper.InsertCommodityInfo(json.get(0));
		paginationVo.setDataResult(json);

		return paginationVo;

	}

	/*--------------- -----<----*修改*---->--- ----------------------*/
	public PaginationVo UpdateCatalog(@RequestBody String CommodityInfo, Model model) {
		List<CommodityCatalog> json = JSON.parseArray(CommodityInfo, CommodityCatalog.class);
		int tostate = commodityCatalogMapper.UpdateCatalog(json.get(0));

		if (tostate != 0)
			paginationVo.setSqlState("Success");
		else
			paginationVo.setSqlState("Error");

		paginationVo.setDataResult(json);

		return paginationVo;

	}

	private String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		return uuid;
	}

}
