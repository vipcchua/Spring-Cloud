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
import com.cchuaspace.mapper.CommunityRelativesMapper;
import com.cchuaspace.mapper.SysCommodityPriceMapper;
import com.cchuaspace.model.CommodityCatalog;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.CommodityInfoDetails;
import com.cchuaspace.model.CommunityRelatives;
import com.cchuaspace.model.SysCommodityPrice;
import com.cchuaspace.pojo.CommodityCatalogVo;
import com.cchuaspace.pojo.CommodityInfoDetailsVo;
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

        paginationVo.setDataResultList(sqldata);
        return paginationVo;
    }


}
