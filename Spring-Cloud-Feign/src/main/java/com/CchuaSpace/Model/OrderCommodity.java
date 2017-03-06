package com.CchuaSpace.Model;

public class OrderCommodity {
    private String orderId;

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

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
}