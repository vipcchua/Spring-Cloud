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

import com.CchuaSpace.Mapper.CommodityInfoMapper;
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

public class CommodityInfoService {

	@Autowired
	private CommodityInfoMapper commodityInfoMapper;

	@Autowired
	private PaginationVo paginationVo;
	/* @Qualifier("PaginationVo") */
	/* @Component */

	public PaginationVo SelectCommodityByNumber(String commodityInfo, Model model) {

		List<CommodityInfo> json = JSON.parseArray(commodityInfo, CommodityInfo.class);

		List<CommodityInfo> data = commodityInfoMapper.SelectCommodityByNumber(json.get(0).getCommodityNumber());

		paginationVo.setDataResult(data);

		return paginationVo;
		
		
		
		/*相当于
		 * PaginationVo resultPr=new PaginationVo();
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
	/*	List<CommodityInfo> json = JSON.parseArray(CommodityByID, CommodityInfo.class);
		List<CommodityInfo> user = commodityInfoMapper.SelectCommodityByID(json.get(0).getCommodityId());

		String jsons = JSON.toJSONString(user);
		List<CommodityInfoVo> data = JSON.parseArray(jsons.toString(), CommodityInfoVo.class);

		return data;*/

		
		
		List<CommodityInfo> json = JSON.parseArray(CommodityByID, CommodityInfo.class);

		List<CommodityInfo> data = commodityInfoMapper.SelectCommodityByNumber(json.get(0).getCommodityNumber());

		paginationVo.setDataResult(data);

		return paginationVo;
	}

	public ResponseEntity<List<CommodityInfo>> SelectCommodityInfo(@RequestBody String CommodityByID, Model model) {
		List<CommodityInfo> json = JSON.parseArray(CommodityByID, CommodityInfo.class);
		List<CommodityInfo> user = commodityInfoMapper.SelectCommodityInfo(json.get(0));
		ResponseEntity<List<CommodityInfo>> data = new ResponseEntity<List<CommodityInfo>>(user, HttpStatus.OK);
		return data;

	}

	public ResponseEntity<List<CommodityInfo>> DeleteCommodityByNumber(@RequestBody String DeleteCommodityByNumber,
			Model model) {
		List<CommodityInfo> json = JSON.parseArray(DeleteCommodityByNumber, CommodityInfo.class);

		int tostate = commodityInfoMapper.DeleteCommodityByNumber(json.get(0).getCommodityNumber());

		if (tostate != 0)
			json.get(0).setSqlstate("Success");
		else
			json.get(0).setSqlstate("ERROR");

		ResponseEntity<List<CommodityInfo>> data = new ResponseEntity<List<CommodityInfo>>(json, HttpStatus.OK);

		return data;

	}

	public ResponseEntity<List<CommodityInfo>> DeleteCommodityById(@RequestBody String DeleteCommodityById,
			Model model) {
		List<CommodityInfo> json = JSON.parseArray(DeleteCommodityById, CommodityInfo.class);

		int tostate = commodityInfoMapper.DeleteCommodityById(json.get(0).getCommodityId());
		if (tostate != 0)
			json.get(0).setSqlstate("Success");
		else
			json.get(0).setSqlstate("ERROR");

		ResponseEntity<List<CommodityInfo>> data = new ResponseEntity<List<CommodityInfo>>(json, HttpStatus.OK);

		return data;

	}

	public ResponseEntity<List<CommodityInfo>> InsertCommodityInfo(@RequestBody String InsertCommodityInfo,
			Model model) {

		List<CommodityInfo> json = JSON.parseArray(InsertCommodityInfo, CommodityInfo.class);
		json.get(0).setCommodityId(uuid());
		List<CommodityInfo> user = commodityInfoMapper.InsertCommodityInfo(json.get(0));
		ResponseEntity<List<CommodityInfo>> data = new ResponseEntity<List<CommodityInfo>>(user, HttpStatus.OK);

		return data;

	}

	public ResponseEntity<List<CommodityInfo>> UpdCommodityInfoById(@RequestBody String CommodityByID, Model model) {
		List<CommodityInfo> json = JSON.parseArray(CommodityByID, CommodityInfo.class);
		List<CommodityInfo> user = commodityInfoMapper.UpdCommodityInfoById(json.get(0));
		ResponseEntity<List<CommodityInfo>> data = new ResponseEntity<List<CommodityInfo>>(user, HttpStatus.OK);

		return data;

	}

	public ResponseEntity<List<CommodityInfo>> UpdCommodityInfoByNumber(@RequestBody String UpdCommodityInfoByNumber,
			Model model) {
		List<CommodityInfo> json = JSON.parseArray(UpdCommodityInfoByNumber, CommodityInfo.class);
		List<CommodityInfo> user = commodityInfoMapper.UpdCommodityInfoByNumber(json.get(0));
		ResponseEntity<List<CommodityInfo>> data = new ResponseEntity<List<CommodityInfo>>(user, HttpStatus.OK);

		return data;

	}

	private String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		return uuid;
	}

}
