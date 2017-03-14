package com.cchuaspace.pojo;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("serial")
public class PaginationVo extends BaseObjectVo implements java.io.Serializable {

	public PaginationVo() {
	}

	private List<?> list;

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

	public Object getDataResultObj() {
		return DataResultObj;
	}

	@SuppressWarnings("unchecked")
	public void setDataResultObj(Object dataResultObj) {
		this.DataResultObj = dataResultObj;
	}

	private Object DataResultObj;





}
