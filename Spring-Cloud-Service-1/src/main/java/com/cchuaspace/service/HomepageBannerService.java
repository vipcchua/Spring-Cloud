package com.cchuaspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.alibaba.fastjson.JSONObject;
import com.cchuaspace.currency.CchuaTool;
import com.cchuaspace.mapper.CommodityInfoMapper;
import com.cchuaspace.mapper.HomepageBannerMapper;
import com.cchuaspace.model.CommodityCatalog;
import com.cchuaspace.model.HomepageBanner;
import com.cchuaspace.model.OrderInfo;
import com.cchuaspace.pojo.PaginationVo;

@Service
public class HomepageBannerService {

	@Autowired
	private HomepageBannerMapper homepageBannerMapper;

	@Autowired
	private PaginationVo paginationVo;



	public PaginationVo insertBanner(String commodityInfo, Model model) {

		
		
		HomepageBanner json = JSONObject.parseObject(commodityInfo, HomepageBanner.class);
		
		CchuaTool cchuaTool = new CchuaTool();
		json.setId(cchuaTool.uuid());
		json.setReleaseTime(cchuaTool.getDate());
		
		int tostate = homepageBannerMapper.insertSelective(json);

		if (tostate != 0)
			paginationVo.setSqlState("Success");
		else
			paginationVo.setSqlState("Error");

		paginationVo.setDataResultObj(json);
		return paginationVo;

	}



	public PaginationVo deletebanner(String commodityInfo, Model model) {

		HomepageBanner json = JSONObject.parseObject(commodityInfo, HomepageBanner.class);

		int tostate = homepageBannerMapper.deleteByPrimaryKey(json.getId());

		if (tostate != 0)
			paginationVo.setSqlState("Success");
		else
			paginationVo.setSqlState("Error");

		paginationVo.setDataResultObj(json);
		return paginationVo;
	}

}
