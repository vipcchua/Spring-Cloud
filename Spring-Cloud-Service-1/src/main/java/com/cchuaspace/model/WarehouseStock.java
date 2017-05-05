package com.cchuaspace.model;

import java.math.BigDecimal;
import java.util.Date;

public class WarehouseStock {
    private String id;

    /**
    * 商品Number
    */
    private Integer commodityNumber;

    /**
    * 入庫價格
    */
    private BigDecimal commodityPrice;

    /**
    * 入货总数
    */
    private Integer totality;

    /**
    * 倉庫货架编号
    */
    private Integer shelfNumber;

    /**
    * 入庫時間
    */
    private Date storageTime;

    /**
    * 供应商編號
    */
    private String supplierNumber;

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

    public BigDecimal getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(BigDecimal commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public Integer getTotality() {
        return totality;
    }

    public void setTotality(Integer totality) {
        this.totality = totality;
    }

    public Integer getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(Integer shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public Date getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(Date storageTime) {
        this.storageTime = storageTime;
    }

    public String getSupplierNumber() {
        return supplierNumber;
    }

    public void setSupplierNumber(String supplierNumber) {
        this.supplierNumber = supplierNumber;
    }
}