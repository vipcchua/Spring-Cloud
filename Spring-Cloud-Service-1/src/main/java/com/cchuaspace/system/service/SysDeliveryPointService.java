package com.cchuaspace.system.service;

import com.alibaba.fastjson.JSONObject;
import com.cchuaspace.currency.CchuaTool;
import com.cchuaspace.mapper.DeliveryPointMapper;
import com.cchuaspace.model.DeliveryPoint;
import com.cchuaspace.pojo.PaginationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

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
public class SysDeliveryPointService {

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

	/*--------------- -----<----*删除*---->--- ----------------------*/

	public PaginationVo DeleteByNumber(int deliveryNumber) {

		int tostate = deliveryPointMapper.DeleteByNumber(deliveryNumber);

		if (tostate != 0)
			paginationVo.setHtmlState("Success");
		else
			paginationVo.setHtmlState("Error");

		return paginationVo;

	}

	public PaginationVo DeleteById(String id) {

		int tostate = deliveryPointMapper.DeleteById(id);

		if (tostate != 0)
			paginationVo.setHtmlState("Success");
		else
			paginationVo.setHtmlState("Error");

		return paginationVo;

	}

	/*--------------- -----<----*增加*---->--- ----------------------*/
	public PaginationVo InsertInfo(String insertinfo) {

		DeliveryPoint json = JSONObject.parseObject(insertinfo, DeliveryPoint.class);

		json.setId(cchuaTool.uuid());

		int tostate = deliveryPointMapper.insertSelective(json);

		if (tostate != 0)
			paginationVo.setHtmlState("Success");
		else
			paginationVo.setHtmlState("Error");

		paginationVo.setDataResultObj(json);

		return paginationVo;

	}

	/*--------------- -----<----*修改*---->--- ----------------------*/
	public PaginationVo UpdatetInfo(String insertinfo) {

		DeliveryPoint json = JSONObject.parseObject(insertinfo, DeliveryPoint.class);


		int tostate = deliveryPointMapper.updateByPrimaryKey(json);

		if (tostate != 0)
			paginationVo.setHtmlState("Success");
		else
			paginationVo.setHtmlState("Error");

		paginationVo.setDataResultObj(json);

		return paginationVo;

	}






}
