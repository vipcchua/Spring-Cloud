package com.cchuaspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cchuaspace.currency.CchuaTool;
import com.cchuaspace.mapper.UseDeliveryAddressMapper;
import com.cchuaspace.model.UseDeliveryAddress;
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
public class DeliveryAddressService {

	@Autowired
	private UseDeliveryAddressMapper useDeliveryAddressMapper;

	@Autowired
	private PaginationVo paginationVo;

	@Autowired
	private CchuaTool cchuaTool;

	/*--------------- -----<----*查询*---->--- ----------------------*/

	public PaginationVo selectByUserid(String userid) {

		List<UseDeliveryAddress> data = useDeliveryAddressMapper.SelectByuserList(userid);
		paginationVo.setHtmlState("Success");
		paginationVo.setDataResultList(data);
		return paginationVo;

	}

	/*--------------- -----<----*删除*---->--- ----------------------*/

	public PaginationVo deleteById(String id, String userId) {
		int tostate = useDeliveryAddressMapper.DeleteById(id, userId);

		if (tostate != 0)
			paginationVo.setHtmlState("Success");
		else
			paginationVo.setHtmlState("Error");

		return paginationVo;
	}

	/*--------------- -----<----*增加*---->--- ----------------------*/
	public PaginationVo insertInfo(String insertinfo) {

		UseDeliveryAddress json = JSONObject.parseObject(insertinfo, UseDeliveryAddress.class);

		json.setId(cchuaTool.uuid());

		int tostate = useDeliveryAddressMapper.insertSelective(json);

		if (tostate != 0)
			paginationVo.setHtmlState("Success");
		else
			paginationVo.setHtmlState("Error");

		paginationVo.setDataResultObj(json);

		return paginationVo;

	}

	/*--------------- -----<----*修改*---->--- ----------------------*/

}
