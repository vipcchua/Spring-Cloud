package com.cchuaspace.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.cchuaspace.mapper.*;
import com.cchuaspace.model.*;
import com.cchuaspace.pojo.UseCommodityFavoritesVo;
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
import com.cchuaspace.currency.CchuaTool;
import com.cchuaspace.pojo.CommodityCatalogVo;
import com.cchuaspace.pojo.CommodityInfoVo;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.pojo.UseCommodityFavoritesVo;

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
public class CommodityFavoritesService {

    @Autowired
    private UseCommodityFavoritesMapper useCommodityFavoritesMapper;

    @Autowired
    private CommodityInfoDetailsMapper commodityInfoDetailsMapper;

    @Autowired
    private PaginationVo paginationVo;

    @Autowired
    private CchuaTool cchuaTool;

	/*--------------- -----<----*查询*---->--- ----------------------*/

    public PaginationVo selectByUserid(String userid) {

        List<UseCommodityFavoritesVo> data = useCommodityFavoritesMapper.SelectByuserList(userid);

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

        paginationVo.setHtmlState("Success");
        paginationVo.setDataResultList(data);
        return paginationVo;

    }

	/*--------------- -----<----*删除*---->--- ----------------------*/

    public PaginationVo deleteByNumber(String userid, int commodityNumber) {
        int tostate = useCommodityFavoritesMapper.DeleteByNumber(commodityNumber, userid);

        if (tostate != 0)
            paginationVo.setHtmlState("Success");
        else
            paginationVo.setHtmlState("Error");

        return paginationVo;
    }

    public PaginationVo deleteById(String id, String userid) {

        int tostate = useCommodityFavoritesMapper.DeleteById(id, userid);

        if (tostate != 0)
            paginationVo.setHtmlState("Success");
        else
            paginationVo.setHtmlState("Error");

        return paginationVo;

    }

    /*--------------- -----<----*增加*---->--- ----------------------*/
    public PaginationVo insertInfo(String insertinfo) {

        UseCommodityFavorites json = JSONObject.parseObject(insertinfo, UseCommodityFavorites.class);

        json.setId(cchuaTool.uuid());

        int tostate = useCommodityFavoritesMapper.insertSelective(json);

        if (tostate != 0)
            paginationVo.setHtmlState("Success");
        else
            paginationVo.setHtmlState("Error");

        paginationVo.setDataResultObj(json);

        return paginationVo;

    }

	/*--------------- -----<----*修改*---->--- ----------------------*/

}
