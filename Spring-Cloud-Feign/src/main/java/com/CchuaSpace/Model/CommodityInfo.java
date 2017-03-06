package com.CchuaSpace.Model;

public class CommodityInfo {
    /**
    * 商品编号
    */
    private Integer commodityNumber;

    private String commodityId;

    /**
    * 商品品牌
    */
    private String commodityBrand;

    /**
    * 商品名称
    */
    private String commodityName;

    /**
    * 商品价格
    */
    private String commodityPrice;

    /**
    * 商品产地
    */
    private String commodityOrigin;

    /**
    * 商品重量
    */
    private String commodityWeigh;

    /**
    * 商品剩余数量
    */
    private Integer commoditySurplus;

    /**
     * 商品图片
     */
     private Integer  commodityPhoto; 
    
     private String sqlstate;
     



 	public String getSqlstate() {
 		return sqlstate;
 	}

 	public void setSqlstate(String sqlstate) {
 		this.sqlstate = sqlstate;
 	}

    
    public Integer getCommodityPhoto() {
		return commodityPhoto;
	}

	public void setCommodityPhoto(Integer commodityPhoto) {
		this.commodityPhoto = commodityPhoto;
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

    public String getCommodityBrand() {
        return commodityBrand;
    }

    public void setCommodityBrand(String commodityBrand) {
        this.commodityBrand = commodityBrand;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(String commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public String getCommodityOrigin() {
        return commodityOrigin;
    }

    public void setCommodityOrigin(String commodityOrigin) {
        this.commodityOrigin = commodityOrigin;
    }

    public String getCommodityWeigh() {
        return commodityWeigh;
    }

    public void setCommodityWeigh(String commodityWeigh) {
        this.commodityWeigh = commodityWeigh;
    }

    public Integer getCommoditySurplus() {
        return commoditySurplus;
    }

    public void setCommoditySurplus(Integer commoditySurplus) {
        this.commoditySurplus = commoditySurplus;
    }
}