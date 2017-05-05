package com.cchuaspace.model;

import java.math.BigDecimal;
import java.sql.Date;

public class DetailedList {
	/**
	 * 购物车ID
	 */
	private String detailedId;

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 商品编号
	 */
	private Integer commodityNumber;

	/**
	 * 需求数量
	 */
	private Integer needNumber;

	/**
	 * 加入购物车时候的价格
	 */
	private BigDecimal addPrice;

	private Date addTime;


	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getDetailedId() {
		return detailedId;
	}

	public void setDetailedId(String detailedId) {
		this.detailedId = detailedId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getCommodityNumber() {
		return commodityNumber;
	}

	public void setCommodityNumber(Integer commodityNumber) {
		this.commodityNumber = commodityNumber;
	}

	public Integer getNeedNumber() {
		return needNumber;
	}

	public void setNeedNumber(Integer needNumber) {
		this.needNumber = needNumber;
	}

	public BigDecimal getAddPrice() {
		return addPrice;
	}

	public void setAddPrice(BigDecimal addPrice) {
		this.addPrice = addPrice;
	}
}