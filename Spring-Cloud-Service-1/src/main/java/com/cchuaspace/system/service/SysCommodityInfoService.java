package com.cchuaspace.system.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.cchuaspace.currency.CchuaTool;
import com.cchuaspace.mapper.*;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.CommodityInfoDetails;
import com.cchuaspace.model.CommunityRelatives;
import com.cchuaspace.model.SysCommodityPrice;
import com.cchuaspace.pojo.CommodityInfoDetailsVo;
import com.cchuaspace.pojo.CommodityInfoVo;
import com.cchuaspace.pojo.PaginationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
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
public class SysCommodityInfoService {

	@Autowired
	private CommodityInfoMapper commodityInfoMapper;

	@Autowired
	private CommodityCatalogMapper commodityCatalogMapper;

	@Autowired
	private CommodityInfoDetailsMapper commodityInfoDetailsMapper;

	@Autowired
	private CommunityRelativesMapper communityRelativesMapper;

	@Autowired
	private SysCommodityPriceMapper sysCommodityPriceMapper;

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

		try {
			CommodityInfoDetailsVo datas = commodityInfoDetailsMapper
					.SelectCByNumberObjVo(data.get(0).getCommodityNumber());

			try {
				SysCommodityPrice dataResultObj = sysCommodityPriceMapper
						.SelectNewByNumber(data.get(0).getCommodityNumber());

				datas.setDataResultObj(dataResultObj);
			} catch (Exception e) {
				JSONObject dataerror = new JSONObject();
				dataerror.put("Price", "Error-该商品未定价");
				datas.setDataResultObj(dataerror);
			}

			data.get(0).setDataResultObj(datas);

		} catch (Exception e) {
			JSONObject dataerror = new JSONObject();
			dataerror.put("DetailsInfo", "Error-该商品未有详细信息");
			data.get(0).setDataResultObj(dataerror);
		}

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
		List<CommodityInfoVo> sqldata = commodityInfoMapper.SelectAllByPage(json);

		paginationVo.setPaginalNumber(Math.ceil(sqldata.get(0).getDataTotal() / json.getPagerow()));
		paginationVo.setDataTotal(sqldata.get(0).getDataTotal());
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

			CommunityRelatives jsons = JSONObject.parseObject(map.get("classify"), CommunityRelatives.class);

			if (json.getCommodityName() == null && jsons.getCommodityNumber() == 0) {
				paginationVo.setHtmlState("Error");
				return paginationVo;

			} else {

				json.setCommodityId(cchuaTool.uuid());
				json.setCommodityNumber(cchuaTool.getCommodityNumber(jsons.getParentsId()));
				int tostate = commodityInfoMapper.InsertCommodityInfo(json);
				int tostates = communityRelativesMapper.InsertCommunityRelativesObj(jsons);

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



	public PaginationVo SelectCondition(@RequestBody String datas) {


		CommodityInfoVo json = JSONObject.parseObject(datas, CommodityInfoVo.class);

		CommodityInfoVo jsons = JSONObject.parseObject(datas, CommodityInfoVo.class);



		List<CommodityInfoVo> datasdfs = commodityInfoMapper.SelectConditionCount(jsons);


		List<CommodityInfoVo> data = commodityInfoMapper.SelectCondition(json);


		for (int i = 0; i <data.size() ; i++) {
		CommodityInfoDetails dadata = commodityInfoDetailsMapper.SelectAllByNumber(data.get(i).getCommodityNumber());
			data.get(i).setDataResultObj(dadata);

		}

		paginationVo.setPaginalNumber(Math.ceil(datasdfs.get(0).getDataTotal()/ json.getPagerow()));

			paginationVo.setDataTotal(datasdfs.get(0).getDataTotal());


		paginationVo.setDataResultList(data);
		return paginationVo;
	}



















}
