package com.cchuaspace.pojo;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Component
@Scope("prototype")

public class BaseObjectVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String orderby;

	private int page;

	private int pagerow;


	private String tosort;
	
	private String sorting;

	private String ErrorCode;

	private String ErrorSolve;
	
	private String Token;

	private String SqlState;

	private List<?> list;
	
	private String HtmlState;

	private String classifySon;
	
	private double paginalNumber;
	
	private double dataTotal;
	
	
	private int parentsId;

	public double getDataTotal() {
		return dataTotal;
	}

	public void setDataTotal(double dataTotal) {
		this.dataTotal = dataTotal;
	}

	public int getParentsId() {
		return parentsId;
	}

	public void setParentsId(int parentsId) {
		this.parentsId = parentsId;
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

	public int getPagerow() {
		return pagerow;
	}

	public void setPagerow(int pagerow) {
		this.pagerow = pagerow;
	}

	public String getTosort() {
		return tosort;
	}

	public void setTosort(String tosort) {
		this.tosort = tosort;
	}

	public String getSorting() {
		return sorting;
	}

	public void setSorting(String sorting) {
		this.sorting = sorting;
	}

	public String getErrorCode() {
		return ErrorCode;
	}

	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}

	public String getErrorSolve() {
		return ErrorSolve;
	}

	public void setErrorSolve(String errorSolve) {
		ErrorSolve = errorSolve;
	}

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

	public String getSqlState() {
		return SqlState;
	}

	public void setSqlState(String sqlState) {
		SqlState = sqlState;
	}


	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
	public String getHtmlState() {
		return HtmlState;
	}

	public void setHtmlState(String htmlState) {
		HtmlState = htmlState;
	}

	public String getClassifySon() {
		return classifySon;
	}

	public void setClassifySon(String classifySon) {
		this.classifySon = classifySon;
	}

	public double getPaginalNumber() {
		return paginalNumber;
	}

	public void setPaginalNumber(double paginalNumber) {
		this.paginalNumber = paginalNumber;
	}




}
