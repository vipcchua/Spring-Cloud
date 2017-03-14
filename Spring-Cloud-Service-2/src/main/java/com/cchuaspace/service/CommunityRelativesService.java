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
import com.cchuaspace.mapper.CommunityRelativesMapper;
import com.cchuaspace.mapper.OrderCommodityMapper;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.CommunityRelatives;
import com.cchuaspace.model.OrderInfo;
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

public class CommunityRelativesService {

	@Autowired
	private CommunityRelativesMapper communityRelativesMapper;

	@Autowired
	private CommodityInfoMapper commodityInfoMapper;

	@Autowired
	private PaginationVo paginationVo;

	/*--------------- -----<----*查询*---->--- ----------------------*/
	public PaginationVo SelectClassifyProduct(String communityRelatives, Model model) {
		CommunityRelatives json = JSONObject.parseObject(communityRelatives, CommunityRelatives.class);
		List<CommunityRelatives> infodata = communityRelativesMapper.SelectByparentsIdList(json.getParentsId(),
				json.getDepth());

		ArrayList<CommodityInfo> list = new ArrayList<CommodityInfo>();

		for (int a = 0; a < infodata.size(); a++) {

			CommodityInfo datas = commodityInfoMapper.SelectCommodityByNumberObj(infodata.get(a).getCommodityNumber());

			list.add(datas);
			/* data.get(a).setDataResultObj(datas); */

		}

		paginationVo.setDataResultList(list);
		return paginationVo;

	}

	public PaginationVo DeleteByNumber(String communityRelatives, Model model) {
		CommunityRelatives json = JSONObject.parseObject(communityRelatives, CommunityRelatives.class);

		int tostate = communityRelativesMapper.DeleteCatalog(json);

		if (tostate != 0)
			paginationVo.setSqlState("Success");
		else
			paginationVo.setSqlState("Error");

		paginationVo.setDataResultObj(json);
		return paginationVo;

	}

	public PaginationVo InsertRelativesr(String communityRelatives, Model model) {
		CommunityRelatives json = JSONObject.parseObject(communityRelatives, CommunityRelatives.class);

		int tostate = communityRelativesMapper.InsertCommunityRelativesObj(json);

		if (tostate != 0)
			paginationVo.setSqlState("Success");
		else
			paginationVo.setSqlState("Error");

		paginationVo.setDataResultObj(json);
		return paginationVo;

	}

	public PaginationVo UpdateCatalog(String communityRelatives, Model model) {
		CommunityRelatives json = JSONObject.parseObject(communityRelatives, CommunityRelatives.class);

		int tostate = communityRelativesMapper.UpdateCatalog(json);

		if (tostate != 0)
			paginationVo.setSqlState("Success");
		else
			paginationVo.setSqlState("Error");

		paginationVo.setDataResultObj(json);
		return paginationVo;

	}

}
