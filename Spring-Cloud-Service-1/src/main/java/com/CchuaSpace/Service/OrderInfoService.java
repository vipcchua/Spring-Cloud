package com.cchuaspace.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.beanutils.PropertyUtils;
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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cchuaspace.mapper.CommodityInfoMapper;
import com.cchuaspace.mapper.OrderCommodityMapper;
import com.cchuaspace.mapper.OrderInfoMapper;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.DetailedList;
import com.cchuaspace.model.OrderCommodity;
import com.cchuaspace.model.OrderInfo;
import com.cchuaspace.pojo.CommodityCatalogVo;
import com.cchuaspace.pojo.CommodityInfoVo;
import com.cchuaspace.pojo.OrderInfoVo;
import com.cchuaspace.pojo.PaginationVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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

public class OrderInfoService {

	@Autowired
	private OrderInfoMapper orderInfoMapper;

	@Autowired
	private OrderCommodityMapper orderCommodityMapper;

	@Autowired
	private PaginationVo paginationVo;

	@Autowired
	private OrderInfoVo orderInfoVo;

	/*--------------- -----<----*查询*---->--- ----------------------*/

	public PaginationVo SelectByNumber(@RequestBody String CommodityInfo, Model model) {

		OrderInfo json = JSONObject.parseObject(CommodityInfo, OrderInfo.class);

		OrderInfo infodata = orderInfoMapper.SelectByNumber(json.getUserId(), json.getOrderNumber());

		List<OrderCommodity> user = orderCommodityMapper.SelectByNumber(infodata.getOrderNumber());

		/* BeanUtils对部分属性不支持null的情况？？？？ */
		/* BeanUtils.copyProperties(orderInfoVo, infodata); */


			try {
				PropertyUtils.copyProperties(orderInfoVo, infodata);
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


		orderInfoVo.setDataResultObj(user);

		paginationVo.setDataResultObj(orderInfoVo);
		return paginationVo;

	}

	/*--------------- -----<----*删除*---->--- ----------------------*/

	public PaginationVo DeleteByCommodity(@RequestBody String CommodityInfo, Model model) {
		OrderInfo json = JSONObject.parseObject(CommodityInfo, OrderInfo.class);

		int tostate = orderInfoMapper.DeleteNumber(json.getOrderNumber(), json.getUserId());

		if (tostate != 0)
			paginationVo.setSqlState("Success");
		else
			paginationVo.setSqlState("Error");

		paginationVo.setDataResultObj(json);
		return paginationVo;

	}

	public PaginationVo DeleteByOrderId(@RequestBody String CommodityInfo, Model model) {

		OrderInfo json = JSONObject.parseObject(CommodityInfo, OrderInfo.class);

		int tostate = orderInfoMapper.DeleteorderId(json.getOrderId(), json.getUserId());

		if (tostate != 0)
			paginationVo.setSqlState("Success");
		else
			paginationVo.setSqlState("Error");

		paginationVo.setDataResultObj(json);
		return paginationVo;

	}
	/*--------------- -----<----*增加*---->--- ----------------------*/

	/*--------------- -----<----*修改*---->--- ----------------------*/

}
