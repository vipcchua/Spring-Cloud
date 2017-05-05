package com.cchuaspace.model;

import java.math.BigDecimal;
import java.util.Date;

public class CommodityInfoDetails {
    private String id;

    /**
     * 商品編號
     */
    private Integer commodityNumber;

    private String commodityId;

    /**
     * 上市日期
     */
    private Date listingDate;

    /**
     * 现价（单位为分）
     */
    private Integer presentPrice;

    /**
     * 页面上显示原价（为了达到营销效果制造制造出来的原价）
     */
    private BigDecimal originalPrice;

    /**
     * 是否在架上 0未上架 1上架且开售  2上架未开售 3上架预售 4上架后缺货 5上架后下级状态
     */
    private Integer shelfState;

    /**
     * 商品描述
     */
    private String describe;

    /**
     * 小标题
     */
    private String smallTitle;

    /**
     * 赠品的商品number
     */
    private Integer giftNumber;

    /**
     * 商品介绍的url
     */
    private String introduceUrl;

    private String introducePhoto;

    /**
     * 销售方式的单位
     */
    private String saleUnit;

    /**
     * 商品标题
     */
    private String title;

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

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public Date getListingDate() {
        return listingDate;
    }

    public void setListingDate(Date listingDate) {
        this.listingDate = listingDate;
    }

    public Integer getPresentPrice() {
        return presentPrice;
    }

    public void setPresentPrice(Integer presentPrice) {
        this.presentPrice = presentPrice;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getShelfState() {
        return shelfState;
    }

    public void setShelfState(Integer shelfState) {
        this.shelfState = shelfState;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getSmallTitle() {
        return smallTitle;
    }

    public void setSmallTitle(String smallTitle) {
        this.smallTitle = smallTitle;
    }

    public Integer getGiftNumber() {
        return giftNumber;
    }

    public void setGiftNumber(Integer giftNumber) {
        this.giftNumber = giftNumber;
    }

    public String getIntroduceUrl() {
        return introduceUrl;
    }

    public void setIntroduceUrl(String introduceUrl) {
        this.introduceUrl = introduceUrl;
    }

    public String getIntroducePhoto() {
        return introducePhoto;
    }

    public void setIntroducePhoto(String introducePhoto) {
        this.introducePhoto = introducePhoto;
    }

    public String getSaleUnit() {
        return saleUnit;
    }

    public void setSaleUnit(String saleUnit) {
        this.saleUnit = saleUnit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}