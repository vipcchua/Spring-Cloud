package com.cchuaspace.pojo;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@SuppressWarnings("serial")
@Component
@Scope("prototype")
public class PaginationVo extends BaseObjectVo implements java.io.Serializable {

	public PaginationVo() {
	}

	private List<?> list;
	
	private String DataString;

	/**
	 * 获得分页内容
	 * 
	 * @return
	 */
	public List<?> getList() {
		return list;
	}

	/**
	 * 设置分页内容
	 * 
	 * @param list
	 */
	@SuppressWarnings("unchecked")
	public void setList(List list) {
		this.list = list;
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

	public String getDataString() {
		return DataString;
	}
	@SuppressWarnings("unchecked")
	public void setDataString(String dataString) {
		this.DataString = dataString;
	}







}
