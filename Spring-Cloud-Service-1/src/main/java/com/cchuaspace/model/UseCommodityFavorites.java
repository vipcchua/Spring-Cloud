package com.cchuaspace.model;

import java.util.Date;

public class UseCommodityFavorites {
    private String id;

    /**
     * user
     */
    private String userId;

    /**
     * 商品
     */
    private Integer commodityNumber;

    /**
     * 收藏时候的价格
     */
    private String price;

    /**
     * 收藏时间
     */
    private Date addTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}