package com.cchuaspace.pojo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CommodityCatalogVo {
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
    private Integer depth;
    
    private String Sqlstate;
    
    
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

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

	public String getSqlstate() {
		return Sqlstate;
	}

	public void setSqlstate(String sqlstate) {
		Sqlstate = sqlstate;
	}
}