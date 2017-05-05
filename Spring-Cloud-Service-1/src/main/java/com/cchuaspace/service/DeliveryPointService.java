package com.cchuaspace.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
import com.cchuaspace.mapper.CommodityCatalogMapper;
import com.cchuaspace.mapper.CommodityInfoMapper;
import com.cchuaspace.mapper.CommunityRelativesMapper;
import com.cchuaspace.mapper.DeliveryPointMapper;
import com.cchuaspace.mapper.SuppliersCommodityMapper;
import com.cchuaspace.mapper.SuppliersInfoMapper;
import com.cchuaspace.model.CommodityCatalog;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.CommunityRelatives;
import com.cchuaspace.model.DeliveryPoint;
import com.cchuaspace.model.SuppliersCommodity;
import com.cchuaspace.model.SuppliersInfo;
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
public class DeliveryPointService {

    @Autowired
    private DeliveryPointMapper deliveryPointMapper;

    @Autowired
    private PaginationVo paginationVo;

    @Autowired
    private CchuaTool cchuaTool;

	/*--------------- -----<----*查询*---->--- ----------------------*/

    public PaginationVo SelectByDeliveryname(String deliveryname) {

        List<DeliveryPoint> data = deliveryPointMapper.SelectByNameList(deliveryname);

        paginationVo.setHtmlState("Success");
        paginationVo.setDataResultList(data);
        return paginationVo;

    }

    public PaginationVo SelectByDeliveryNumber(int deliverynumber) {
        DeliveryPoint data = deliveryPointMapper.SelectByDeliveryNumber(deliverynumber);

        paginationVo.setHtmlState("Success");
        paginationVo.setDataResultObj(data);
        return paginationVo;
    }

    public PaginationVo SelectByRegionNumber(String commoditynumber) {

        List<DeliveryPoint> data = deliveryPointMapper.SelectByRegionNumber(commoditynumber);
        paginationVo.setHtmlState("Success");
        paginationVo.setDataResultObj(data);
        return paginationVo;

    }

    public PaginationVo SelectPoint(String selectPoint) {


        try {
            DeliveryPoint json = JSONObject.parseObject(selectPoint, DeliveryPoint.class);
            List<DeliveryPoint> datas = deliveryPointMapper.SelectPoint(json);
            paginationVo.setHtmlState("Success");
            paginationVo.setDataResultList(datas);
        } catch (Exception e) {
            paginationVo.setHtmlState("Error:" + e);
        }


        return paginationVo;

    }


	/*--------------- -----<----*删除*---->--- ----------------------*/


}
