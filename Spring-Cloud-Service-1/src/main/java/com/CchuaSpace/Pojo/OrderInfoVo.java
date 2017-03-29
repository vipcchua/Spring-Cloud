package com.cchuaspace.pojo;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cchuaspace.model.OrderCommodity;

@Component
public class OrderInfoVo {
	 /**
	    * 订单编号
	    */
	    private int orderNumber;

	    private String orderId;

	    /**
	    * 用户id
	    */
	    private String userId;

	    /**
	    * 订单收货地址
	    */
	    private String orderAddress;

	    /**
	    * 联系人名称
	    */
	    private String contactName;

	    /**
	    * 联系人名称手机号码
	    */
	    private String contactPhone;

	    /**
	    * 固定电话
	    */
	    private String contactTelephone;

	    /**
	    * 订单存活状态
	    */
	    private String orderState;

	    /**
	    * 付款方式
	    */
	    private String paymentMethod;

	    /**
	    * 付款金额
	    */
	    private String paymentAmount;

	    /**
	    * 付款状态
	    */
	    private String paymentState;

	    /**
	    * 快递编号
	    */
	    private String expressNumber;

	    /**
	    * 快递商家
	    */
	    private String expressBusiness;

	    /**
	    * 订单评论编号
	    */
	    private String orderRemarks;

	    /**
	    * 订单生成时间
	    */
	    private Date generateTime;

	    /**
	    * 发票类型
	    */
	    private String invoiceType;

	    /**
	    * 发票抬头
	    */
	    private String invoiceHeader;


	   
	 
	    
	 
	    
	    
	    

	    private  OrderCommodity orderCommodity;


	private List<?> DataResultList;

	public List<?> getDataResultList() {
		return DataResultList;
	}

	@SuppressWarnings("unchecked")
	public void setDataResultList(List<?> dataResultList) {
		this.DataResultList = dataResultList;
	}

	private Object DataResultObj;

	public Object getDataResultObj() {
		return DataResultObj;
	}

	@SuppressWarnings("unchecked")
	public void setDataResultObj(Object dataResultObj) {
		this.DataResultObj = dataResultObj;
	}


}