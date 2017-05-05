package com.cchuaspace.model;

import java.math.BigDecimal;
import java.util.Date;

public class SysCommodityPrice {
    private String id;

    /**
    * 商品number
    */
    private Integer commodityNumber;

    /**
    * 现价
    */
    private BigDecimal presentPrice;

    /**
    * 原价
    */
    private BigDecimal originalPrice;

    /**
    * 上传时间
    */
    private Date updateTime;

    /**
    * 操作人员
    */
    private String operator;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(Integer commodityNumber) {
        this.commodityNumber = commodityNumber;
    }

    public BigDecimal getPresentPrice() {
        return presentPrice;
    }

    public void setPresentPrice(BigDecimal presentPrice) {
        this.presentPrice = presentPrice;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}