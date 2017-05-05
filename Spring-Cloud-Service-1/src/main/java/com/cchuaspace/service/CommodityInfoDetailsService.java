package com.cchuaspace.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.commons.beanutils.PropertyUtils;
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
import com.cchuaspace.mapper.CommodityInfoDetailsMapper;
import com.cchuaspace.mapper.CommodityInfoMapper;
import com.cchuaspace.mapper.SysCommodityPriceMapper;
import com.cchuaspace.model.CommodityCatalog;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.CommodityInfoDetails;
import com.cchuaspace.model.CommunityRelatives;
import com.cchuaspace.model.SysCommodityPrice;
import com.cchuaspace.pojo.CommodityCatalogVo;
import com.cchuaspace.pojo.CommodityInfoVo;
import com.cchuaspace.pojo.OrderInfoVo;
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
public class CommodityInfoDetailsService {

	@Autowired
	private CommodityInfoMapper commodityInfoMapper;

	@Autowired
	private CommodityInfoDetailsMapper commodityInfoDetailsMapper;

	@Autowired
	private SysCommodityPriceMapper sysCommodityPriceMapper;
	@Autowired
	private PaginationVo paginationVo;

	@Autowired
	private CommodityInfoVo commodityInfoVo;

	@Autowired
	private CchuaTool cchuaTool;

	/* @Qualifier("PaginationVo") */
	/* @Component */

	public PaginationVo SelectByNumber(int commoditynumber) {

		CommodityInfo data = commodityInfoMapper.SelectCommodityByNumberObj(commoditynumber);

		List<CommodityInfoDetails> datas = commodityInfoDetailsMapper.SelectCByNumberObj(data.getCommodityNumber());

		try {
			PropertyUtils.copyProperties(commodityInfoVo, data);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		commodityInfoVo.setDataResultObj(datas);

		paginationVo.setDataResultObj(commodityInfoVo);

		return paginationVo;
	}

	public PaginationVo InsertInfo(String CommodityInfo) {
		CommodityInfoDetails json = JSONObject.parseObject(CommodityInfo, CommodityInfoDetails.class);

		json.setId(cchuaTool.uuid());

		int tostate = commodityInfoDetailsMapper.insertSelective(json);

		if (tostate != 0)
			paginationVo.setSqlState("Success");
		else
			paginationVo.setSqlState("Error");

		return paginationVo;
	}

	public PaginationVo insertinfoprice(String commodityInfo) {
		try {
			HashMap<String, String> map = JSON.parseObject(commodityInfo, new TypeReference<HashMap<String, String>>() {
			});

			CommodityInfoDetails json = JSONObject.parseObject(map.get("info"), CommodityInfoDetails.class);

			SysCommodityPrice price = JSONObject.parseObject(map.get("price"), SysCommodityPrice.class);

			if (json.getCommodityNumber() == 0 && price.getCommodityNumber() == 0) {
				paginationVo.setHtmlState("Error");
				return paginationVo;

			}

			else {
				json.setId(cchuaTool.uuid());
				price.setId(cchuaTool.uuid());
				int tostate = commodityInfoDetailsMapper.insertSelective(json);
				int pricestate = sysCommodityPriceMapper.insertSelective(price);
				if (tostate != 0 && pricestate != 0)
					paginationVo.setHtmlState("Success");
				else
					paginationVo.setHtmlState("Error");
				return paginationVo;

			}
		} catch (Exception e) {
			paginationVo.setHtmlState("Error");
			return paginationVo;
		}

	}





}
