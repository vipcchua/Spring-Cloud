package com.cchuaspace.pojo;

import java.util.List;

public class CommunityRelativesVo {

	private String cId;
	
	private int parentsId;
	
	private int commodityNumber;
	
	private String tosort;

	private int pagerow;
	private int page;

	public CommunityRelativesVo() {
	}

	public int getPagerow() {
		return pagerow;
	}

	public void setPagerow(int pagerow) {
		this.pagerow = pagerow;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getTosort() {
		return tosort;
	}

	public void setTosort(String tosort) {
		this.tosort = tosort;
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



	public int getCommodityNumber() {
		return commodityNumber;
	}

	public void setCommodityNumber(int commodityNumber) {
		this.commodityNumber = commodityNumber;
	}



	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public int getParentsId() {
		return parentsId;
	}

	public void setParentsId(int parentsId) {
		this.parentsId = parentsId;
	}



}
