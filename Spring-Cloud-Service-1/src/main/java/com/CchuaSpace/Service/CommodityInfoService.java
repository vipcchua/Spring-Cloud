package com.cchuaspace.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.aspectj.weaver.ast.And;
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
import com.alibaba.fastjson.TypeReference;
import com.cchuaspace.currency.CchuaTool;
import com.cchuaspace.mapper.CommodityCatalogMapper;
import com.cchuaspace.mapper.CommodityInfoDetailsMapper;
import com.cchuaspace.mapper.CommodityInfoMapper;
import com.cchuaspace.model.CommodityCatalog;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.CommodityInfoDetails;
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
public class CommodityInfoService {

	@Autowired
	private CommodityInfoMapper commodityInfoMapper;

	@Autowired
	private CommodityCatalogMapper commodityCatalogMapper;
	

	@Autowired
	private CommodityInfoDetailsMapper commodityInfoDetailsMapper;


	@Autowired
	private PaginationVo paginationVo;

	@Autowired
	private CchuaTool cchuaTool;
	/* @Qualifier("PaginationVo") */
	/* @Component */

	public PaginationVo SelectCommodityByNumber(int commodityNumber) {

		/*
		 * CommodityInfo json =
		 * JSONObject.parseObject(commodityInfo,CommodityInfo.class);
		 */

		List<CommodityInfoVo> data = commodityInfoMapper.SelectCommodityByNumberVo(commodityNumber);


		CommodityInfoDetails datas=commodityInfoDetailsMapper.SelectCByNumberObj(data.get(0).getCommodityNumber());
	
		data.get(0).setDataResultObj(datas);
		

		paginationVo.setDataResultList(data);
		paginationVo.setHtmlState("Success");

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

		CommodityInfo json = JSONObject.parseObject(CommodityByID, CommodityInfo.class);
		List<CommodityInfo> data = commodityInfoMapper.SelectCommodityByID(json.getCommodityId());
		paginationVo.setDataResultList(data);
		return paginationVo;
	}

	public PaginationVo GetSelectCommodityByID(
			@RequestParam(value = "commodityId", required = true) String commodityId) {

		List<CommodityInfo> data = commodityInfoMapper.SelectCommodityByID(commodityId);
		paginationVo.setDataResultList(data);
		return paginationVo;
	}

	public PaginationVo SelectCommodityInfo(@RequestBody String CommodityByID, Model model) {

		CommodityInfo json = JSONObject.parseObject(CommodityByID, CommodityInfo.class);
		List<CommodityInfo> data = commodityInfoMapper.SelectCommodityInfo(json);
		paginationVo.setDataResultList(data);
		return paginationVo;

	}

	public PaginationVo SelectCommodityall() {

		List<CommodityInfo> data = commodityInfoMapper.SelectCommodityall();
		paginationVo.setDataResultList(data);
		return paginationVo;

	}
	


	
	public PaginationVo SelectAllByPage(String data) {
		PaginationVo json = JSONObject.parseObject(data, PaginationVo.class);
		List<CommodityInfo> sqldata = commodityInfoMapper.SelectAllByPage(json);
	
		paginationVo.setDataResultList(sqldata);
		return paginationVo;
	}
	
	
	
	
	
	
	
	
	
	
	

	public PaginationVo DeleteCommodityByNumber(@RequestBody String DeleteCommodityByNumber, Model model) {
		CommodityInfo json = JSONObject.parseObject(DeleteCommodityByNumber, CommodityInfo.class);

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

		CommodityInfo json = JSONObject.parseObject(DeleteCommodityById, CommodityInfo.class);

		int tostate = commodityInfoMapper.DeleteCommodityById(json.getCommodityId());

		if (tostate != 0)
			/* json.get(0).setSqlstate("Success"); */
			paginationVo.setSqlState("Success");
		else
			paginationVo.setSqlState("Error");

		paginationVo.setDataResultObj(json);
		return paginationVo;

	}

	public PaginationVo InsertCommodityInfo(@RequestBody String insertCommodityInfo, Model model) {

		try {

			HashMap<String, String> map = JSON.parseObject(insertCommodityInfo,
					new TypeReference<HashMap<String, String>>() {
					});

			CommodityInfo json = JSONObject.parseObject(map.get("info"), CommodityInfo.class);
			CommodityCatalog jsons = JSONObject.parseObject(map.get("classify"), CommodityCatalog.class);

			/*
			 * CommodityInfo json =
			 * JSONObject.parseObject(insertCommodityInfo.getJSONObject(0).
			 * getJSONObject("info").toString(), CommodityInfo.class);
			 * CommodityCatalog jsons =
			 * JSONObject.parseObject(arinsertCommodityInforay.getJSONObject(0).
			 * getJSONObject("classify").toString(), CommodityCatalog.class);
			 */

			if (json.getCommodityName() == null || jsons.getParentsId() == null) {
				paginationVo.setHtmlState("Error");
				return paginationVo;

			} else {
				json.setCommodityId(uuid());
				json.setCommodityNumber(cchuaTool.getOrderNumber(1, 2));
				int tostate = commodityInfoMapper.InsertCommodityInfo(json);
				int tostates = commodityCatalogMapper.InsertCommodityInfo(jsons);

				if (tostate != 0 && tostates != 0)
					/* json.get(0).setSqlstate("Success"); */
					paginationVo.setHtmlState("Success");
				else
					paginationVo.setHtmlState("Error");

				paginationVo.setDataResultObj(json);

				return paginationVo;

			}

		} catch (Exception e) {
			paginationVo.setHtmlState("Error");
			return paginationVo;
		}
	}

	public PaginationVo UpdCommodityInfoById(@RequestBody String CommodityByID, Model model) {

		CommodityInfo json = JSONObject.parseObject(CommodityByID, CommodityInfo.class);

		List<CommodityInfo> user = commodityInfoMapper.UpdCommodityInfoById(json);

		paginationVo.setDataResultList(user);
		return paginationVo;

	}

	public PaginationVo UpdCommodityInfoByNumber(@RequestBody String UpdCommodityInfoByNumber, Model model) {

		CommodityInfo json = JSONObject.parseObject(UpdCommodityInfoByNumber, CommodityInfo.class);

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
