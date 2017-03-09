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
import com.CchuaSpace.Mapper.OrderInfoMapper;
import com.CchuaSpace.Model.CommodityInfo;
import com.CchuaSpace.Model.OrderInfo;
import com.CchuaSpace.Pojo.CommodityCatalogVo;
import com.CchuaSpace.Pojo.CommodityInfoVo;
import com.CchuaSpace.Pojo.PaginationVo;
import com.alibaba.fastjson.JSON;

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
	private PaginationVo paginationVo;

	/*--------------- -----<----*查询*---->--- ----------------------*/

	public PaginationVo SelectByNumber(@RequestBody String CommodityInfo, Model model) {
		List<OrderInfo> json = JSON.parseArray(CommodityInfo, OrderInfo.class);
		List<OrderInfo> user = orderInfoMapper.SelectByNumber(json.get(0).getUserId(), json.get(0).getOrderNumber());
		paginationVo.setDataResult(user);
		return paginationVo;

	}

	/*--------------- -----<----*删除*---->--- ----------------------*/

	public PaginationVo DeleteByCommodity(@RequestBody String CommodityInfo, Model model) {
		List<OrderInfo> json = JSON.parseArray(CommodityInfo, OrderInfo.class);
		int tostate = orderInfoMapper.DeleteNumber(json.get(0).getOrderNumber(), json.get(0).getUserId());

		if (tostate != 0)
			paginationVo.setSqlState("Success");
		else
			paginationVo.setSqlState("Error");

		paginationVo.setDataResult(json);
		return paginationVo;

	}

	public PaginationVo DeleteByOrderId(@RequestBody String CommodityInfo, Model model) {
		List<OrderInfo> json = JSON.parseArray(CommodityInfo, OrderInfo.class);
		int tostate = orderInfoMapper.DeleteorderId(json.get(0).getOrderId(), json.get(0).getUserId());

		if (tostate != 0)
			paginationVo.setSqlState("Success");
		else
			paginationVo.setSqlState("Error");

		paginationVo.setDataResult(json);
		return paginationVo;

	}
	/*--------------- -----<----*增加*---->--- ----------------------*/

	/*--------------- -----<----*修改*---->--- ----------------------*/

}
