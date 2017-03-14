package com.cchuaspace.pojo;

public class DetailedListVo {
    private String userId;

    private Integer commodityNumber;

    private Integer needNumber;

    private String detailedId;
    
    private String Sqlstate;
    
    
    
    




	public String getSqlstate() {
		return Sqlstate;
	}

	public void setSqlstate(String sqlstate) {
		Sqlstate = sqlstate;
	}

	public String getDetailedId() {
		return detailedId;
	}

	public void setDetailedId(String detailedId) {
		this.detailedId = detailedId;
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

	public Integer getNeedNumber() {
        return needNumber;
    }

    public void setNeedNumber(Integer needNumber) {
        this.needNumber = needNumber;
    }
}