package com.cchuaspace.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CommodityInfoDetailsVo {

    private String id;

    /**
     * 商品編號
     */
    private int commodityNumber;

    private String commodityId;

    /**
     * 上市日期
     */
    private Date listingDate;

    /**
     * 现价
     */
    private BigDecimal presentPrice;

    /**
     * 页面上显示原价（为了达到营销效果制造制造出来的原价）
     */
    private BigDecimal originalPrice;

    /**
     * 是否在架上 0未上架 1上架且开售  2上架未开售 3上架预售 4上架后缺货 5上架后下级状态
     */
    private int shelfState;

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
    private int giftNumber;

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



    private double DataTotal;


    private String classifySon;

    private String parentsId;

    private String tosort;

    private int page;

    private int pagerow;

    private String sorting;

    public String getSorting() {
        return sorting;
    }

    public void setSorting(String sorting) {
        this.sorting = sorting;
    }

    public String getParentsId() {
        return parentsId;
    }

    public void setParentsId(String parentsId) {
        this.parentsId = parentsId;
    }

    public String getTosort() {
        return tosort;
    }

    public void setTosort(String tosort) {
        this.tosort = tosort;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPagerow() {
        return pagerow;
    }

    public void setPagerow(int pagerow) {
        this.pagerow = pagerow;
    }

    public double getDataTotal() {
        return DataTotal;
    }

    public void setDataTotal(double dataTotal) {
        DataTotal = dataTotal;
    }

    public String getClassifySon() {
        return classifySon;
    }

    public void setClassifySon(String classifySon) {
        this.classifySon = classifySon;
    }

    private List<?> DataResultList;

    public List<?> getDataResultList() {
        return DataResultList;
    }

    @SuppressWarnings("unchecked")
    public void setDataResultList(List<?> dataResultList) {
        this.DataResultList = dataResultList;
    }

    public Object getDataResultObj() {
        return DataResultObj;
    }

    @SuppressWarnings("unchecked")
    public void setDataResultObj(Object dataResultObj) {
        this.DataResultObj = dataResultObj;
    }

    private Object DataResultObj;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(int commodityNumber) {
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

    public int getShelfState() {
        return shelfState;
    }

    public void setShelfState(int shelfState) {
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

    public int getGiftNumber() {
        return giftNumber;
    }

    public void setGiftNumber(int giftNumber) {
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