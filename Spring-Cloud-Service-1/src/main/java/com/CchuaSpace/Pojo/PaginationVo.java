package com.CchuaSpace.Pojo;

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

	private List<?> DataResult;

	public List<?> getDataResult() {
		return DataResult;
	}

	@SuppressWarnings("unchecked")
	public void setDataResult(List<?> dataResult) {
		this.DataResult = dataResult;
	}

}
