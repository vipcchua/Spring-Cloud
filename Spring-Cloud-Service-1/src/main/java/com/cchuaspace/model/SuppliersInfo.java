package com.cchuaspace.model;

public class SuppliersInfo {
    /**
    * 供应商编号
    */
    private Integer supplierNumber;

    private String id;

    /**
    * 供应商全名
    */
    private String supplierName;

    /**
    * 简称
    */
    private String abbreviation;

    /**
    * 厂商地址
    */
    private String address;

    /**
    * 电话
    */
    private String telephone;

    /**
    * 负责人
    */
    private String director;

    /**
    * 单位类型
    */
    private String unitType;

    /**
    * 公司简介
    */
    private String profile;

    public Integer getSupplierNumber() {
        return supplierNumber;
    }

    public void setSupplierNumber(Integer supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}