package com.cchuaspace.pojo;

import java.util.List;

public class OrderCommodityVo {
    private String orderDetailedid;

    /**
     * 订单编号
     */
    private Integer orderNumber;

    /**
     * 商品编号
     */
    private Integer commodityNumber;

    /**
     * 购买数量
     */
    private Integer buyAmount;

    /**
     * 購買價格
     */
    private Integer commodityPrice;

    private List<?> list;
    @SuppressWarnings("unchecked")
    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }



    public Object getDataResultObj() {
        return DataResultObj;
    }

    @SuppressWarnings("unchecked")
    public void setDataResultObj(Object dataResultObj) {
        this.DataResultObj = dataResultObj;
    }

    private Object DataResultObj;

    public String getOrderDetailedid() {
        return orderDetailedid;
    }

    public void setOrderDetailedid(String orderDetailedid) {
        this.orderDetailedid = orderDetailedid;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(Integer commodityNumber) {
        this.commodityNumber = commodityNumber;
    }

    public Integer getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(Integer buyAmount) {
        this.buyAmount = buyAmount;
    }

    public Integer getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(Integer commodityPrice) {
        this.commodityPrice = commodityPrice;
    }
}