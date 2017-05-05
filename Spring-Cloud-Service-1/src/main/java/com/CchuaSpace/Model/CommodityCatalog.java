package com.cchuaspace.model;

public class CommodityCatalog {
    /**
    * id
    */
    private String catalogId;

    /**
    * 父亲ID
    */
    private int parentsId;

    /**
    * 名称
    */
    private String nodeName;

    /**
    * 商品编号
    */
    private Integer commodityNumber;

  
    
    private String Sqlstate;
    
    
    

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }



    public int getParentsId() {
		return parentsId;
	}

	public void setParentsId(int parentsId) {
		this.parentsId = parentsId;
	}

	public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Integer getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(Integer commodityNumber) {
        this.commodityNumber = commodityNumber;
    }


	public String getSqlstate() {
		return Sqlstate;
	}

	public void setSqlstate(String sqlstate) {
		Sqlstate = sqlstate;
	}


}