package com.cchuaspace.model;

public class CommodityCatalog {
    /**
    * id
    */
    private String catalogId;

    /**
    * 父亲ID
    */
    private String parentsId;

    /**
    * 名称
    */
    private String nodeName;

    /**
    * 商品编号
    */
    private Integer commodityNumber;

    /**
    * 深度
    */
    private int depth;
    
    private String Sqlstate;
    
    
    

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getParentsId() {
        return parentsId;
    }

    public void setParentsId(String parentsId) {
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

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
}