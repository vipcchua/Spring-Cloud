package com.cchuaspace.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.cchuaspace.mapper.CommodityInfoDetailsMapper;
import com.cchuaspace.pojo.CommodityInfoDetailsVo;
import org.apache.commons.beanutils.PropertyUtils;
import org.assertj.core.api.IntArrayAssert;
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
import com.cchuaspace.mapper.CommodityCatalogMapper;
import com.cchuaspace.mapper.CommodityInfoMapper;
import com.cchuaspace.mapper.CommunityRelativesMapper;
import com.cchuaspace.model.CommodityCatalog;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.CommunityRelatives;
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
public class CommodityCatalogService {

	@Autowired
	private CommodityCatalogMapper commodityCatalogMapper;

	@Autowired
	private CommunityRelativesMapper communityRelativesMapper;
	@Autowired
	private CommodityInfoMapper commodityInfoMapper;

	@Autowired
	private CommodityInfoDetailsMapper commodityInfoDetailsMapper;




	@Autowired
	private PaginationVo paginationVo;

	@Autowired
	private CommodityCatalogVo commodityCatalogVo;

	/*--------------- -----<----*查询*---->--- ----------------------*/
	public PaginationVo selectCatalog(@RequestBody String commodityInfo, Model model) {

		CommodityCatalog json = JSONObject.parseObject(commodityInfo, CommodityCatalog.class);

		List<CommodityCatalogVo> data = commodityCatalogMapper.SelectCatalogs(json);

		for (int a = 0; a < data.size(); a++) {
			List<CommodityCatalog> datas = commodityCatalogMapper.SelectByParents(data.get(a).getCatalogId());

			if (datas.size() <= 0) {
				data.get(a).setClassifySon("false");
			} else {
				data.get(a).setClassifySon("true");
			}
		}
		paginationVo.setHtmlState("Success");
		paginationVo.setDataResultList(data);

		return paginationVo;

	}









	public PaginationVo selectClassifyProduct(@RequestBody String commodityInfo, Model model) {

		/*
		 * List<CommodityCatalog> json = JSON.parseObject(commodityInfo,
		 * CommodityCatalog.class);
		 */

		CommodityCatalog json = JSONObject.parseObject(commodityInfo, CommodityCatalog.class);

		List<CommodityCatalog> data = commodityCatalogMapper.SelectCatalog(json);

		CommunityRelatives asdsa = communityRelativesMapper.SelectByparentsIds(data.get(0).getParentsId());

		try {
			PropertyUtils.copyProperties(commodityCatalogVo, data);
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
		commodityCatalogVo.getDataResultList().get(0);

		/* commodityCatalogVo.setDataResultList(data); */

		/* paginationVo.setDataResultList(data); */

		return paginationVo;

	}

	public PaginationVo selectAllByPage(String data) {
		CommodityInfoDetailsVo json = JSONObject.parseObject(data, CommodityInfoDetailsVo.class);

		json.setShelfState(1);

		List<CommodityInfoDetailsVo> sqldata = commodityInfoDetailsMapper.SelectAllByPage(json);

		for (int i = 0; i < sqldata.size(); i++) {


			try {
				List<CommodityInfo> commodityInfodata = commodityInfoMapper.SelectCommodityByNumber(sqldata.get(i).getCommodityNumber());

				sqldata.get(i).setDataResultList(commodityInfodata);
			} catch (Exception e) {


				sqldata.get(i).setDataResultObj("Error");
			}

		}




		paginationVo.setPaginalNumber(Math.ceil(sqldata.get(0).getDataTotal() / json.getPagerow()));

		paginationVo.setDataResultList(sqldata);
		return paginationVo;

	}






}
