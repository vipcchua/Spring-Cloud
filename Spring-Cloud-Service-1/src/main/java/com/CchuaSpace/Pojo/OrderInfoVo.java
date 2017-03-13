package com.cchuaspace.pojo;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class OrderInfoVo {
	private String orderNumber;

	/**
	 * 订单ID
	 */
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
	 * 付款状态
	 */
	private String paymentState;

	/**
	 * 快递编号
	 */
	private String expressNumber;

	private String expressBusiness;

	private String orderRemarks;
	private Date generateTime;

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

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactTelephone() {
		return contactTelephone;
	}

	public void setContactTelephone(String contactTelephone) {
		this.contactTelephone = contactTelephone;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentState() {
		return paymentState;
	}

	public void setPaymentState(String paymentState) {
		this.paymentState = paymentState;
	}

	public String getExpressNumber() {
		return expressNumber;
	}

	public void setExpressNumber(String expressNumber) {
		this.expressNumber = expressNumber;
	}

	public String getExpressBusiness() {
		return expressBusiness;
	}

	public void setExpressBusiness(String expressBusiness) {
		this.expressBusiness = expressBusiness;
	}

	public String getOrderRemarks() {
		return orderRemarks;
	}

	public void setOrderRemarks(String orderRemarks) {
		this.orderRemarks = orderRemarks;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getGenerateTime() {
		return generateTime;
	}

	public void setGenerateTime(Date generateTime) {
		this.generateTime = generateTime;
	}

}