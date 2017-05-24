package com.cchuaspace.model;

public class VideoOrderCommodity {
    private String id;

    private Integer orderNumber;

    private Integer videoNumber;

    private Integer buyAmount;

    private Integer commodityPrice;

    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getVideoNumber() {
        return videoNumber;
    }

    public void setVideoNumber(Integer videoNumber) {
        this.videoNumber = videoNumber;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}