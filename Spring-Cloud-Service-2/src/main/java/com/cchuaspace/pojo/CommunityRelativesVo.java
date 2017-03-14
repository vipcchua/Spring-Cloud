package com.cchuaspace.pojo;

import java.util.List;

public class CommunityRelativesVo {

	private String cId;
	
	private String parentsId;
	
	private int commodityNumber;
	
	private int depth;
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


	public String getParentsId() {
		return parentsId;
	}

	public void setParentsId(String parentsId) {
		this.parentsId = parentsId;
	}

	public int getCommodityNumber() {
		return commodityNumber;
	}

	public void setCommodityNumber(int commodityNumber) {
		this.commodityNumber = commodityNumber;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}
	
	
	
	
	
}
