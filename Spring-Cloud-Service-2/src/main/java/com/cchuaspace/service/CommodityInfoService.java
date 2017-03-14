package com.cchuaspace.service;

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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cchuaspace.mapper.CommodityInfoMapper;
import com.cchuaspace.model.CommodityCatalog;
import com.cchuaspace.model.CommodityInfo;
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

public class CommodityInfoService {

	@Autowired
	private CommodityInfoMapper commodityInfoMapper;

	@Autowired
	private PaginationVo paginationVo;
	/* @Qualifier("PaginationVo") */
	/* @Component */

	public PaginationVo SelectCommodityByNumber(String commodityInfo, Model model) {

		
		CommodityInfo json = JSONObject.parseObject(commodityInfo,CommodityInfo.class);
		
		List<CommodityInfo> data = commodityInfoMapper.SelectCommodityByNumber(json.getCommodityNumber());

		paginationVo.setDataResultList(data);

		return paginationVo;

		/*
		 * 相当于 PaginationVo resultPr=new PaginationVo();
		 * resultPr.setDataResult(data);
		 */

		/* CommodityInfoVo theVo ; */

		/*
		 * String jsons = JSON.toJSONString(user);
		 * 
		 * List<CommodityInfoVo> data = JSON.parseArray(jsons.toString(),
		 * CommodityInfoVo.class);
		 */

	}

	public PaginationVo SelectCommodityByID(@RequestBody String CommodityByID, Model model) {

	
		CommodityInfo json = JSONObject.parseObject(CommodityByID,CommodityInfo.class);
		List<CommodityInfo> data = commodityInfoMapper.SelectCommodityByID(json.getCommodityId());
		paginationVo.setDataResultList(data);
		return paginationVo;
	}

	public PaginationVo SelectCommodityInfo(@RequestBody String CommodityByID, Model model) {

		CommodityInfo json = JSONObject.parseObject(CommodityByID,CommodityInfo.class);
		List<CommodityInfo> data = commodityInfoMapper.SelectCommodityInfo(json);
		paginationVo.setDataResultList(data);
		return paginationVo;

	}

	public PaginationVo DeleteCommodityByNumber(@RequestBody String DeleteCommodityByNumber, Model model) {
		CommodityInfo json = JSONObject.parseObject(DeleteCommodityByNumber,CommodityInfo.class);

		int tostate = commodityInfoMapper.DeleteCommodityByNumber(json.getCommodityNumber());

		if (tostate != 0)
			paginationVo.setSqlState("Success");
		else
			paginationVo.setSqlState("Error");

		List<CommodityInfo> data = commodityInfoMapper.SelectCommodityInfo(json);

		paginationVo.setDataResultList(data);
		return paginationVo;

	}

	public PaginationVo DeleteCommodityById(@RequestBody String DeleteCommodityById, Model model) {


		CommodityInfo json = JSONObject.parseObject(DeleteCommodityById,CommodityInfo.class);

		int tostate = commodityInfoMapper.DeleteCommodityById(json.getCommodityId());

		if (tostate != 0)
			/* json.get(0).setSqlstate("Success"); */
			paginationVo.setSqlState("Success");
		else
			paginationVo.setSqlState("Error");

		paginationVo.setDataResultObj(json);
		return paginationVo;

	}

	public PaginationVo InsertCommodityInfo(@RequestBody String InsertCommodityInfo, Model model) {


		CommodityInfo json = JSONObject.parseObject(InsertCommodityInfo,CommodityInfo.class);

		json.setCommodityId(uuid());
		List<CommodityInfo> user = commodityInfoMapper.InsertCommodityInfo(json);

		paginationVo.setDataResultList(user);
		return paginationVo;

	}

	public PaginationVo UpdCommodityInfoById(@RequestBody String CommodityByID, Model model) {

		CommodityInfo json = JSONObject.parseObject(CommodityByID,CommodityInfo.class);
	
		List<CommodityInfo> user = commodityInfoMapper.UpdCommodityInfoById(json);

		paginationVo.setDataResultList(user);
		return paginationVo;

	}

	public PaginationVo UpdCommodityInfoByNumber(@RequestBody String UpdCommodityInfoByNumber, Model model) {
		
		CommodityInfo json = JSONObject.parseObject(UpdCommodityInfoByNumber,CommodityInfo.class);
		
		List<CommodityInfo> user = commodityInfoMapper.UpdCommodityInfoByNumber(json);

		paginationVo.setDataResultList(user);
		return paginationVo;

	}

	private String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);
		return uuid;
	}

}
