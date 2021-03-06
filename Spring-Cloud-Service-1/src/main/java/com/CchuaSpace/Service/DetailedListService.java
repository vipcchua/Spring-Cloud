package com.cchuaspace.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.cchuaspace.mapper.CommodityInfoDetailsMapper;
import com.cchuaspace.model.CommodityInfoDetails;
import com.cchuaspace.pojo.DetailedListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cchuaspace.mapper.CommodityInfoMapper;
import com.cchuaspace.mapper.DetailedListMapper;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.DetailedList;
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
public class DetailedListService {
    @Autowired
    private DetailedListMapper detailedListMapper;

    @Autowired
    private PaginationVo paginationVo;

    @Autowired
    private CommodityInfoDetailsMapper commodityInfoDetailsMapper;
    /*--------------- -----<----*查询*---->--- ----------------------*/

    public PaginationVo selectDetailedListByUserId(String userid) {

	/*	DetailedList json = JSONObject.parseObject(CommodityInfo, DetailedList.class);*/

        List<DetailedListVo> data = detailedListMapper.SelectDetailedListByUserId(userid);

        for (int i = 0; i < data.size(); i++) {


            List<CommodityInfoDetails> InfoDetails = commodityInfoDetailsMapper.SelectCByNumberObj(data.get(i).getCommodityNumber());

            if (InfoDetails.size() <= 0) {
                JSONObject dataerror = new JSONObject();
                dataerror.put("Sqlstatus", "Error-商品不存在");
                data.get(i).setDataResultObj(dataerror);
            } else {
                data.get(i).setDataResultObj(InfoDetails);
            }


        }

        paginationVo.setDataResultList(data);
        return paginationVo;

    }

    public PaginationVo selectDetailedListByDetailedId(@RequestBody String CommodityInfo, Model model) {

        DetailedList json = JSONObject.parseObject(CommodityInfo, DetailedList.class);
        List<DetailedList> data = detailedListMapper.SelectDetailedListByDetailedId(json.getDetailedId());

        paginationVo.setDataResultList(data);
        return paginationVo;

    }

	/*--------------- -----<----*删除*---->--- ----------------------*/

    public PaginationVo deleteByCommodity(@RequestBody String CommodityInfo, Model model) {

        DetailedList json = JSONObject.parseObject(CommodityInfo, DetailedList.class);
        int tostate = detailedListMapper.DeleteByCommodity(json.getDetailedId(), json.getCommodityNumber());

        if (tostate != 0)
            if (tostate != 0)
                paginationVo.setSqlState("Success");
            else
                paginationVo.setSqlState("Error");

        paginationVo.setDataResultObj(json);
        return paginationVo;

    }

    public PaginationVo deleteBydetailedId(@RequestBody String CommodityInfo, Model model) {
        DetailedList json = JSONObject.parseObject(CommodityInfo, DetailedList.class);

        int tostate = detailedListMapper.DeleteBydetailedId(json.getUserId(), json.getDetailedId());

        if (tostate != 0)
            paginationVo.setSqlState("Success");
        else
            paginationVo.setSqlState("Error");

        paginationVo.setDataResultObj(json);
        return paginationVo;

    }

    public PaginationVo deleteCommodity(@RequestBody String CommodityInfo, Model model) {
        DetailedList json = JSONObject.parseObject(CommodityInfo, DetailedList.class);

        int tostate = detailedListMapper.DeleteCommodity(json);

        if (tostate != 0)
            paginationVo.setSqlState("Success");
        else
            paginationVo.setSqlState("Error");

        paginationVo.setDataResultObj(json);
        return paginationVo;

    }

    public PaginationVo deleteAlldetailed(@RequestBody String CommodityInfo, Model model) {
        DetailedList json = JSONObject.parseObject(CommodityInfo, DetailedList.class);

        int tostate = detailedListMapper.DeleteAlldetailed(json.getUserId());

        if (tostate != 0)
            paginationVo.setSqlState("Success");
        else
            paginationVo.setSqlState("Error");

        paginationVo.setDataResultObj(json);
        return paginationVo;
    }

	/*--------------- -----<----*增加*---->--- ----------------------*/

    public PaginationVo insertDetailedListInfo(@RequestBody String CommodityInfo, Model model) {

        DetailedList json = JSONObject.parseObject(CommodityInfo, DetailedList.class);

        json.setDetailedId(uuid());
        int tostate = detailedListMapper.InsertDetailedListInfoDy(json);

        if (tostate != 0)
            paginationVo.setSqlState("Success");
        else
            paginationVo.setSqlState("Error");

        paginationVo.setDataResultObj(json);
        return paginationVo;

    }

	/*--------------- -----<----*修改*---->--- ----------------------*/

    public PaginationVo updateCommodityByUserId(@RequestBody String CommodityInfo, Model model) {

        DetailedList json = JSONObject.parseObject(CommodityInfo, DetailedList.class);

        int tostate = detailedListMapper.UpdateCommodityByUserId(json);

        if (tostate != 0)
            paginationVo.setSqlState("Success");
        else
            paginationVo.setSqlState("Error");

        paginationVo.setDataResultObj(json);
        return paginationVo;

    }

    public PaginationVo updateCommodityBydetailedId(@RequestBody String CommodityInfo, Model model) {

        DetailedList json = JSONObject.parseObject(CommodityInfo, DetailedList.class);
        int tostate = detailedListMapper.UpdateCommodityBydetailedId(json);

        if (tostate != 0)
            paginationVo.setSqlState("Success");
        else
            paginationVo.setSqlState("Error");

        paginationVo.setDataResultObj(json);
        return paginationVo;

    }

    private String uuid() {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);

        return uuid;
    }

}
