package com.cchuaspace.pojo;

public class OrderCommodityVo {
    private String orderDetailedid;

    /**
    * 订单编号
    */
    private Integer orderNumber;

    /**
    * 商品编号
    */
    private String commodityNumber;

    /**
    * 购买数量
    */
    private Integer buyAmount;



    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(String commodityNumber) {
        this.commodityNumber = commodityNumber;
    }

    public Integer getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(Integer buyAmount) {
        this.buyAmount = buyAmount;
    }

	public String getOrderDetailedid() {
		return orderDetailedid;
	}

	public void setOrderDetailedid(String orderDetailedid) {
		this.orderDetailedid = orderDetailedid;
	}
}