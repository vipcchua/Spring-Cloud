package com.cchuaspace.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WarehouseStockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public WarehouseStockExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberIsNull() {
            addCriterion("commodity_number is null");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberIsNotNull() {
            addCriterion("commodity_number is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberEqualTo(Integer value) {
            addCriterion("commodity_number =", value, "commodityNumber");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberNotEqualTo(Integer value) {
            addCriterion("commodity_number <>", value, "commodityNumber");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberGreaterThan(Integer value) {
            addCriterion("commodity_number >", value, "commodityNumber");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("commodity_number >=", value, "commodityNumber");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberLessThan(Integer value) {
            addCriterion("commodity_number <", value, "commodityNumber");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberLessThanOrEqualTo(Integer value) {
            addCriterion("commodity_number <=", value, "commodityNumber");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberIn(List<Integer> values) {
            addCriterion("commodity_number in", values, "commodityNumber");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberNotIn(List<Integer> values) {
            addCriterion("commodity_number not in", values, "commodityNumber");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberBetween(Integer value1, Integer value2) {
            addCriterion("commodity_number between", value1, value2, "commodityNumber");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("commodity_number not between", value1, value2, "commodityNumber");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceIsNull() {
            addCriterion("commodity_price is null");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceIsNotNull() {
            addCriterion("commodity_price is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceEqualTo(BigDecimal value) {
            addCriterion("commodity_price =", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceNotEqualTo(BigDecimal value) {
            addCriterion("commodity_price <>", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceGreaterThan(BigDecimal value) {
            addCriterion("commodity_price >", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commodity_price >=", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceLessThan(BigDecimal value) {
            addCriterion("commodity_price <", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("commodity_price <=", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceIn(List<BigDecimal> values) {
            addCriterion("commodity_price in", values, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceNotIn(List<BigDecimal> values) {
            addCriterion("commodity_price not in", values, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commodity_price between", value1, value2, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commodity_price not between", value1, value2, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andTotalityIsNull() {
            addCriterion("totality is null");
            return (Criteria) this;
        }

        public Criteria andTotalityIsNotNull() {
            addCriterion("totality is not null");
            return (Criteria) this;
        }

        public Criteria andTotalityEqualTo(Integer value) {
            addCriterion("totality =", value, "totality");
            return (Criteria) this;
        }

        public Criteria andTotalityNotEqualTo(Integer value) {
            addCriterion("totality <>", value, "totality");
            return (Criteria) this;
        }

        public Criteria andTotalityGreaterThan(Integer value) {
            addCriterion("totality >", value, "totality");
            return (Criteria) this;
        }

        public Criteria andTotalityGreaterThanOrEqualTo(Integer value) {
            addCriterion("totality >=", value, "totality");
            return (Criteria) this;
        }

        public Criteria andTotalityLessThan(Integer value) {
            addCriterion("totality <", value, "totality");
            return (Criteria) this;
        }

        public Criteria andTotalityLessThanOrEqualTo(Integer value) {
            addCriterion("totality <=", value, "totality");
            return (Criteria) this;
        }

        public Criteria andTotalityIn(List<Integer> values) {
            addCriterion("totality in", values, "totality");
            return (Criteria) this;
        }

        public Criteria andTotalityNotIn(List<Integer> values) {
            addCriterion("totality not in", values, "totality");
            return (Criteria) this;
        }

        public Criteria andTotalityBetween(Integer value1, Integer value2) {
            addCriterion("totality between", value1, value2, "totality");
            return (Criteria) this;
        }

        public Criteria andTotalityNotBetween(Integer value1, Integer value2) {
            addCriterion("totality not between", value1, value2, "totality");
            return (Criteria) this;
        }

        public Criteria andShelfNumberIsNull() {
            addCriterion("shelf_number is null");
            return (Criteria) this;
        }

        public Criteria andShelfNumberIsNotNull() {
            addCriterion("shelf_number is not null");
            return (Criteria) this;
        }

        public Criteria andShelfNumberEqualTo(Integer value) {
            addCriterion("shelf_number =", value, "shelfNumber");
            return (Criteria) this;
        }

        public Criteria andShelfNumberNotEqualTo(Integer value) {
            addCriterion("shelf_number <>", value, "shelfNumber");
            return (Criteria) this;
        }

        public Criteria andShelfNumberGreaterThan(Integer value) {
            addCriterion("shelf_number >", value, "shelfNumber");
            return (Criteria) this;
        }

        public Criteria andShelfNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("shelf_number >=", value, "shelfNumber");
            return (Criteria) this;
        }

        public Criteria andShelfNumberLessThan(Integer value) {
            addCriterion("shelf_number <", value, "shelfNumber");
            return (Criteria) this;
        }

        public Criteria andShelfNumberLessThanOrEqualTo(Integer value) {
            addCriterion("shelf_number <=", value, "shelfNumber");
            return (Criteria) this;
        }

        public Criteria andShelfNumberIn(List<Integer> values) {
            addCriterion("shelf_number in", values, "shelfNumber");
            return (Criteria) this;
        }

        public Criteria andShelfNumberNotIn(List<Integer> values) {
            addCriterion("shelf_number not in", values, "shelfNumber");
            return (Criteria) this;
        }

        public Criteria andShelfNumberBetween(Integer value1, Integer value2) {
            addCriterion("shelf_number between", value1, value2, "shelfNumber");
            return (Criteria) this;
        }

        public Criteria andShelfNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("shelf_number not between", value1, value2, "shelfNumber");
            return (Criteria) this;
        }

        public Criteria andStorageTimeIsNull() {
            addCriterion("storage_time is null");
            return (Criteria) this;
        }

        public Criteria andStorageTimeIsNotNull() {
            addCriterion("storage_time is not null");
            return (Criteria) this;
        }

        public Criteria andStorageTimeEqualTo(Date value) {
            addCriterion("storage_time =", value, "storageTime");
            return (Criteria) this;
        }

        public Criteria andStorageTimeNotEqualTo(Date value) {
            addCriterion("storage_time <>", value, "storageTime");
            return (Criteria) this;
        }

        public Criteria andStorageTimeGreaterThan(Date value) {
            addCriterion("storage_time >", value, "storageTime");
            return (Criteria) this;
        }

        public Criteria andStorageTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("storage_time >=", value, "storageTime");
            return (Criteria) this;
        }

        public Criteria andStorageTimeLessThan(Date value) {
            addCriterion("storage_time <", value, "storageTime");
            return (Criteria) this;
        }

        public Criteria andStorageTimeLessThanOrEqualTo(Date value) {
            addCriterion("storage_time <=", value, "storageTime");
            return (Criteria) this;
        }

        public Criteria andStorageTimeIn(List<Date> values) {
            addCriterion("storage_time in", values, "storageTime");
            return (Criteria) this;
        }

        public Criteria andStorageTimeNotIn(List<Date> values) {
            addCriterion("storage_time not in", values, "storageTime");
            return (Criteria) this;
        }

        public Criteria andStorageTimeBetween(Date value1, Date value2) {
            addCriterion("storage_time between", value1, value2, "storageTime");
            return (Criteria) this;
        }

        public Criteria andStorageTimeNotBetween(Date value1, Date value2) {
            addCriterion("storage_time not between", value1, value2, "storageTime");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberIsNull() {
            addCriterion("supplier_number is null");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberIsNotNull() {
            addCriterion("supplier_number is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberEqualTo(String value) {
            addCriterion("supplier_number =", value, "supplierNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberNotEqualTo(String value) {
            addCriterion("supplier_number <>", value, "supplierNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberGreaterThan(String value) {
            addCriterion("supplier_number >", value, "supplierNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_number >=", value, "supplierNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberLessThan(String value) {
            addCriterion("supplier_number <", value, "supplierNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberLessThanOrEqualTo(String value) {
            addCriterion("supplier_number <=", value, "supplierNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberLike(String value) {
            addCriterion("supplier_number like", value, "supplierNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberNotLike(String value) {
            addCriterion("supplier_number not like", value, "supplierNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberIn(List<String> values) {
            addCriterion("supplier_number in", values, "supplierNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberNotIn(List<String> values) {
            addCriterion("supplier_number not in", values, "supplierNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberBetween(String value1, String value2) {
            addCriterion("supplier_number between", value1, value2, "supplierNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberNotBetween(String value1, String value2) {
            addCriterion("supplier_number not between", value1, value2, "supplierNumber");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}