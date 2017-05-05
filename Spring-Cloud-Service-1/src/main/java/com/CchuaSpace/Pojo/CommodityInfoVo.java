package com.cchuaspace.pojo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
public class CommodityInfoVo extends BaseObjectVo{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2670901258346630100L;

	  /**
	    * 商品编号
	    */
	    private int commodityNumber;

	    /**
	    * 商品Id
	    */
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
	    * 产品型号
	    */
	    private String commodityModel;

	    /**
	    * 条形码
	    */
	    private String barCode;

	    /**
	    * 商品产地
	    */
	    private String commodityOrigin;

	    /**
	    * 商品重量
	    */
	    private String commodityWeigh;

	    /**
	    * 产品重量的单位
	    */
	    private String commodityUnit;

	    /**
	    * 商品图片
	    */
	    private String commodityPhoto;

	    /**
	    * 产品适用范围
	    */
	    private String commodityApply;

	    /**
	    * 商品概述
	    */
	    private String commoditySummary;

    
   
     private double DataTotal;
    
     
     
     
     
 	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getCommodityUnit() {
		return commodityUnit;
	}

	public void setCommodityUnit(String commodityUnit) {
		this.commodityUnit = commodityUnit;
	}

	public String getCommodityPhoto() {
		return commodityPhoto;
	}

	public void setCommodityPhoto(String commodityPhoto) {
		this.commodityPhoto = commodityPhoto;
	}

	public String getCommodityApply() {
		return commodityApply;
	}

	public void setCommodityApply(String commodityApply) {
		this.commodityApply = commodityApply;
	}

	public String getCommoditySummary() {
		return commoditySummary;
	}

	public void setCommoditySummary(String commoditySummary) {
		this.commoditySummary = commoditySummary;
	}

	public void setCommodityNumber(int commodityNumber) {
		this.commodityNumber = commodityNumber;
	}
	private List<?> DataResultList;

 	public List<?> getDataResultList() {
 		return DataResultList;
 	}

 	@SuppressWarnings("unchecked")
 	public void setDataResultList(List<?> dataResultList) {
 		this.DataResultList = dataResultList;
 	}
 	private Object DataResultObj;
 	public Object getDataResultObj() {
 		return DataResultObj;
 	}

 	@SuppressWarnings("unchecked")
 	public void setDataResultObj(Object dataResultObj) {
 		this.DataResultObj = dataResultObj;
 	}


 	private List<CommodityInfoDetailsVo> commodityInfoDetailsVo;
     
 	
     
     
     
     

    
    




	public double getDataTotal() {
		return DataTotal;
	}

	public void setDataTotal(double dataTotal) {
		DataTotal = dataTotal;
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


	public String getCommodityModel() {
		return commodityModel;
	}

	public void setCommodityModel(String commodityModel) {
		this.commodityModel = commodityModel;
	}

	public List<CommodityInfoDetailsVo> getCommodityInfoDetailsVo() {
		return commodityInfoDetailsVo;
	}

	public void setCommodityInfoDetailsVo(List<CommodityInfoDetailsVo> commodityInfoDetailsVo) {
		this.commodityInfoDetailsVo = commodityInfoDetailsVo;
	}
}