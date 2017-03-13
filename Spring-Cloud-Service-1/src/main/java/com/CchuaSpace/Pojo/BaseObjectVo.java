package com.cchuaspace.pojo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseObjectVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String orderby;

	private int page;

	private int pageRow;

	private String Sorting;

	private String ErrorCode;

	private String ErrorSolve;

	private String SqlState;

	private List<?> list;

	public String getErrorCode() {
		return ErrorCode;
	}

	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageRow() {
		return pageRow;
	}

	public void setPageRow(int pageRow) {
		this.pageRow = pageRow;
	}

	public String getSorting() {
		return Sorting;
	}

	public void setSorting(String sorting) {
		Sorting = sorting;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public String getSqlState() {
		return SqlState;
	}

	public void setSqlState(String sqlState) {
		SqlState = sqlState;
	}

	public String getErrorSolve() {
		return ErrorSolve;
	}

	public void setErrorSolve(String errorSolve) {
		ErrorSolve = errorSolve;
	}

}
