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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CchuaSpace.Mapper.CommodityInfoMapper;
import com.CchuaSpace.Mapper.DetailedListMapper;
import com.CchuaSpace.Model.CommodityInfo;
import com.CchuaSpace.Model.DetailedList;
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

public class DetailedListService {
	@Autowired
	private DetailedListMapper detailedListMapper;

	@Autowired
	private PaginationVo paginationVo;
	/*--------------- -----<----*查询*---->--- ----------------------*/

	public PaginationVo SelectDetailedListByUserId(@RequestBody String CommodityInfo, Model model) {
		List<DetailedList> json = JSON.parseArray(CommodityInfo, DetailedList.class);
		List<DetailedList> data = detailedListMapper.SelectDetailedListByUserId(json.get(0).getUserId());

		paginationVo.setDataResult(data);
		return paginationVo;

	}

	public PaginationVo SelectDetailedListByDetailedId(@RequestBody String CommodityInfo, Model model) {
		List<DetailedList> json = JSON.parseArray(CommodityInfo, DetailedList.class);
		List<DetailedList> data = detailedListMapper.SelectDetailedListByDetailedId(json.get(0).getDetailedId());

		paginationVo.setDataResult(data);
		return paginationVo;

	}

	/*--------------- -----<----*删除*---->--- ----------------------*/

	public PaginationVo DeleteByCommodity(@RequestBody String CommodityInfo, Model model) {
		List<DetailedList> json = JSON.parseArray(CommodityInfo, DetailedList.class);
		int tostate = detailedListMapper.DeleteByCommodity(json.get(0).getDetailedId(),
				json.get(0).getCommodityNumber());

		if (tostate != 0)
			if (tostate != 0)
				paginationVo.setSqlState("Success");
			else
				paginationVo.setSqlState("Error");

		paginationVo.setDataResult(json);
		return paginationVo;

	}

	public PaginationVo DeleteBydetailedId(@RequestBody String CommodityInfo, Model model) {
		List<DetailedList> json = JSON.parseArray(CommodityInfo, DetailedList.class);
		int tostate = detailedListMapper.DeleteBydetailedId(json.get(0).getUserId(), json.get(0).getDetailedId());

		if (tostate != 0)
			paginationVo.setSqlState("Success");
		else
			paginationVo.setSqlState("Error");

		paginationVo.setDataResult(json);
		return paginationVo;

	}

	public PaginationVo DeleteCommodity(@RequestBody String CommodityInfo, Model model) {
		List<DetailedList> json = JSON.parseArray(CommodityInfo, DetailedList.class);
		int tostate = detailedListMapper.DeleteCommodity(json.get(0));

		if (tostate != 0)
			paginationVo.setSqlState("Success");
		else
			paginationVo.setSqlState("Error");

		paginationVo.setDataResult(json);
		return paginationVo;

	}

	public PaginationVo DeleteAlldetailed(@RequestBody String CommodityInfo, Model model) {
		List<DetailedList> json = JSON.parseArray(CommodityInfo, DetailedList.class);
		int tostate = detailedListMapper.DeleteAlldetailed(json.get(0).getUserId());

		if (tostate != 0)
			paginationVo.setSqlState("Success");
		else
			paginationVo.setSqlState("Error");

		paginationVo.setDataResult(json);
		return paginationVo;
	}

	/*--------------- -----<----*增加*---->--- ----------------------*/

	public PaginationVo InsertDetailedListInfo(@RequestBody String CommodityInfo, Model model) {
		List<DetailedList> json = JSON.parseArray(CommodityInfo, DetailedList.class);
		json.get(0).setDetailedId(uuid());
		int tostate = detailedListMapper.InsertDetailedList(json.get(0));

		if (tostate != 0)
			paginationVo.setSqlState("Success");
		else
			paginationVo.setSqlState("Error");

		paginationVo.setDataResult(json);
		return paginationVo;

	}

	/*--------------- -----<----*修改*---->--- ----------------------*/

	public PaginationVo UpdateCommodityByUserId(@RequestBody String CommodityInfo, Model model) {
		List<DetailedList> json = JSON.parseArray(CommodityInfo, DetailedList.class);

		int tostate = detailedListMapper.UpdateCommodityByUserId(json.get(0));

		if (tostate != 0)
			paginationVo.setSqlState("Success");
		else
			paginationVo.setSqlState("Error");

		paginationVo.setDataResult(json);
		return paginationVo;

	}

	public PaginationVo UpdateCommodityBydetailedId(@RequestBody String CommodityInfo, Model model) {
		List<DetailedList> json = JSON.parseArray(CommodityInfo, DetailedList.class);
		int tostate = detailedListMapper.UpdateCommodityBydetailedId(json.get(0));

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
