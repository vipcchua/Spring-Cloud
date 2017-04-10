package com.cchuaspace.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommodityInfoDetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public CommodityInfoDetailsExample() {
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

        public Criteria andCommodityIdIsNull() {
            addCriterion("commodity_id is null");
            return (Criteria) this;
        }

        public Criteria andCommodityIdIsNotNull() {
            addCriterion("commodity_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityIdEqualTo(String value) {
            addCriterion("commodity_id =", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdNotEqualTo(String value) {
            addCriterion("commodity_id <>", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdGreaterThan(String value) {
            addCriterion("commodity_id >", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdGreaterThanOrEqualTo(String value) {
            addCriterion("commodity_id >=", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdLessThan(String value) {
            addCriterion("commodity_id <", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdLessThanOrEqualTo(String value) {
            addCriterion("commodity_id <=", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdLike(String value) {
            addCriterion("commodity_id like", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdNotLike(String value) {
            addCriterion("commodity_id not like", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdIn(List<String> values) {
            addCriterion("commodity_id in", values, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdNotIn(List<String> values) {
            addCriterion("commodity_id not in", values, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdBetween(String value1, String value2) {
            addCriterion("commodity_id between", value1, value2, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdNotBetween(String value1, String value2) {
            addCriterion("commodity_id not between", value1, value2, "commodityId");
            return (Criteria) this;
        }

        public Criteria andListingDateIsNull() {
            addCriterion("listing_date is null");
            return (Criteria) this;
        }

        public Criteria andListingDateIsNotNull() {
            addCriterion("listing_date is not null");
            return (Criteria) this;
        }

        public Criteria andListingDateEqualTo(Date value) {
            addCriterion("listing_date =", value, "listingDate");
            return (Criteria) this;
        }

        public Criteria andListingDateNotEqualTo(Date value) {
            addCriterion("listing_date <>", value, "listingDate");
            return (Criteria) this;
        }

        public Criteria andListingDateGreaterThan(Date value) {
            addCriterion("listing_date >", value, "listingDate");
            return (Criteria) this;
        }

        public Criteria andListingDateGreaterThanOrEqualTo(Date value) {
            addCriterion("listing_date >=", value, "listingDate");
            return (Criteria) this;
        }

        public Criteria andListingDateLessThan(Date value) {
            addCriterion("listing_date <", value, "listingDate");
            return (Criteria) this;
        }

        public Criteria andListingDateLessThanOrEqualTo(Date value) {
            addCriterion("listing_date <=", value, "listingDate");
            return (Criteria) this;
        }

        public Criteria andListingDateIn(List<Date> values) {
            addCriterion("listing_date in", values, "listingDate");
            return (Criteria) this;
        }

        public Criteria andListingDateNotIn(List<Date> values) {
            addCriterion("listing_date not in", values, "listingDate");
            return (Criteria) this;
        }

        public Criteria andListingDateBetween(Date value1, Date value2) {
            addCriterion("listing_date between", value1, value2, "listingDate");
            return (Criteria) this;
        }

        public Criteria andListingDateNotBetween(Date value1, Date value2) {
            addCriterion("listing_date not between", value1, value2, "listingDate");
            return (Criteria) this;
        }

        public Criteria andPresentPriceIsNull() {
            addCriterion("present_price is null");
            return (Criteria) this;
        }

        public Criteria andPresentPriceIsNotNull() {
            addCriterion("present_price is not null");
            return (Criteria) this;
        }

        public Criteria andPresentPriceEqualTo(BigDecimal value) {
            addCriterion("present_price =", value, "presentPrice");
            return (Criteria) this;
        }

        public Criteria andPresentPriceNotEqualTo(BigDecimal value) {
            addCriterion("present_price <>", value, "presentPrice");
            return (Criteria) this;
        }

        public Criteria andPresentPriceGreaterThan(BigDecimal value) {
            addCriterion("present_price >", value, "presentPrice");
            return (Criteria) this;
        }

        public Criteria andPresentPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("present_price >=", value, "presentPrice");
            return (Criteria) this;
        }

        public Criteria andPresentPriceLessThan(BigDecimal value) {
            addCriterion("present_price <", value, "presentPrice");
            return (Criteria) this;
        }

        public Criteria andPresentPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("present_price <=", value, "presentPrice");
            return (Criteria) this;
        }

        public Criteria andPresentPriceIn(List<BigDecimal> values) {
            addCriterion("present_price in", values, "presentPrice");
            return (Criteria) this;
        }

        public Criteria andPresentPriceNotIn(List<BigDecimal> values) {
            addCriterion("present_price not in", values, "presentPrice");
            return (Criteria) this;
        }

        public Criteria andPresentPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("present_price between", value1, value2, "presentPrice");
            return (Criteria) this;
        }

        public Criteria andPresentPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("present_price not between", value1, value2, "presentPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIsNull() {
            addCriterion("original_price is null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIsNotNull() {
            addCriterion("original_price is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceEqualTo(BigDecimal value) {
            addCriterion("original_price =", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotEqualTo(BigDecimal value) {
            addCriterion("original_price <>", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThan(BigDecimal value) {
            addCriterion("original_price >", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("original_price >=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThan(BigDecimal value) {
            addCriterion("original_price <", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("original_price <=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIn(List<BigDecimal> values) {
            addCriterion("original_price in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotIn(List<BigDecimal> values) {
            addCriterion("original_price not in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("original_price between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("original_price not between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andBuyingPriceIsNull() {
            addCriterion("buying_price is null");
            return (Criteria) this;
        }

        public Criteria andBuyingPriceIsNotNull() {
            addCriterion("buying_price is not null");
            return (Criteria) this;
        }

        public Criteria andBuyingPriceEqualTo(BigDecimal value) {
            addCriterion("buying_price =", value, "buyingPrice");
            return (Criteria) this;
        }

        public Criteria andBuyingPriceNotEqualTo(BigDecimal value) {
            addCriterion("buying_price <>", value, "buyingPrice");
            return (Criteria) this;
        }

        public Criteria andBuyingPriceGreaterThan(BigDecimal value) {
            addCriterion("buying_price >", value, "buyingPrice");
            return (Criteria) this;
        }

        public Criteria andBuyingPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("buying_price >=", value, "buyingPrice");
            return (Criteria) this;
        }

        public Criteria andBuyingPriceLessThan(BigDecimal value) {
            addCriterion("buying_price <", value, "buyingPrice");
            return (Criteria) this;
        }

        public Criteria andBuyingPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("buying_price <=", value, "buyingPrice");
            return (Criteria) this;
        }

        public Criteria andBuyingPriceIn(List<BigDecimal> values) {
            addCriterion("buying_price in", values, "buyingPrice");
            return (Criteria) this;
        }

        public Criteria andBuyingPriceNotIn(List<BigDecimal> values) {
            addCriterion("buying_price not in", values, "buyingPrice");
            return (Criteria) this;
        }

        public Criteria andBuyingPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buying_price between", value1, value2, "buyingPrice");
            return (Criteria) this;
        }

        public Criteria andBuyingPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buying_price not between", value1, value2, "buyingPrice");
            return (Criteria) this;
        }

        public Criteria andShelfStateIsNull() {
            addCriterion("shelf_state is null");
            return (Criteria) this;
        }

        public Criteria andShelfStateIsNotNull() {
            addCriterion("shelf_state is not null");
            return (Criteria) this;
        }

        public Criteria andShelfStateEqualTo(Integer value) {
            addCriterion("shelf_state =", value, "shelfState");
            return (Criteria) this;
        }

        public Criteria andShelfStateNotEqualTo(Integer value) {
            addCriterion("shelf_state <>", value, "shelfState");
            return (Criteria) this;
        }

        public Criteria andShelfStateGreaterThan(Integer value) {
            addCriterion("shelf_state >", value, "shelfState");
            return (Criteria) this;
        }

        public Criteria andShelfStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("shelf_state >=", value, "shelfState");
            return (Criteria) this;
        }

        public Criteria andShelfStateLessThan(Integer value) {
            addCriterion("shelf_state <", value, "shelfState");
            return (Criteria) this;
        }

        public Criteria andShelfStateLessThanOrEqualTo(Integer value) {
            addCriterion("shelf_state <=", value, "shelfState");
            return (Criteria) this;
        }

        public Criteria andShelfStateIn(List<Integer> values) {
            addCriterion("shelf_state in", values, "shelfState");
            return (Criteria) this;
        }

        public Criteria andShelfStateNotIn(List<Integer> values) {
            addCriterion("shelf_state not in", values, "shelfState");
            return (Criteria) this;
        }

        public Criteria andShelfStateBetween(Integer value1, Integer value2) {
            addCriterion("shelf_state between", value1, value2, "shelfState");
            return (Criteria) this;
        }

        public Criteria andShelfStateNotBetween(Integer value1, Integer value2) {
            addCriterion("shelf_state not between", value1, value2, "shelfState");
            return (Criteria) this;
        }

        public Criteria andDescribeIsNull() {
            addCriterion("describe is null");
            return (Criteria) this;
        }

        public Criteria andDescribeIsNotNull() {
            addCriterion("describe is not null");
            return (Criteria) this;
        }

        public Criteria andDescribeEqualTo(String value) {
            addCriterion("describe =", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotEqualTo(String value) {
            addCriterion("describe <>", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeGreaterThan(String value) {
            addCriterion("describe >", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("describe >=", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLessThan(String value) {
            addCriterion("describe <", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLessThanOrEqualTo(String value) {
            addCriterion("describe <=", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLike(String value) {
            addCriterion("describe like", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotLike(String value) {
            addCriterion("describe not like", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeIn(List<String> values) {
            addCriterion("describe in", values, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotIn(List<String> values) {
            addCriterion("describe not in", values, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeBetween(String value1, String value2) {
            addCriterion("describe between", value1, value2, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotBetween(String value1, String value2) {
            addCriterion("describe not between", value1, value2, "describe");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andSmaillTitleIsNull() {
            addCriterion("smaill_title is null");
            return (Criteria) this;
        }

        public Criteria andSmaillTitleIsNotNull() {
            addCriterion("smaill_title is not null");
            return (Criteria) this;
        }

        public Criteria andSmaillTitleEqualTo(String value) {
            addCriterion("smaill_title =", value, "smaillTitle");
            return (Criteria) this;
        }

        public Criteria andSmaillTitleNotEqualTo(String value) {
            addCriterion("smaill_title <>", value, "smaillTitle");
            return (Criteria) this;
        }

        public Criteria andSmaillTitleGreaterThan(String value) {
            addCriterion("smaill_title >", value, "smaillTitle");
            return (Criteria) this;
        }

        public Criteria andSmaillTitleGreaterThanOrEqualTo(String value) {
            addCriterion("smaill_title >=", value, "smaillTitle");
            return (Criteria) this;
        }

        public Criteria andSmaillTitleLessThan(String value) {
            addCriterion("smaill_title <", value, "smaillTitle");
            return (Criteria) this;
        }

        public Criteria andSmaillTitleLessThanOrEqualTo(String value) {
            addCriterion("smaill_title <=", value, "smaillTitle");
            return (Criteria) this;
        }

        public Criteria andSmaillTitleLike(String value) {
            addCriterion("smaill_title like", value, "smaillTitle");
            return (Criteria) this;
        }

        public Criteria andSmaillTitleNotLike(String value) {
            addCriterion("smaill_title not like", value, "smaillTitle");
            return (Criteria) this;
        }

        public Criteria andSmaillTitleIn(List<String> values) {
            addCriterion("smaill_title in", values, "smaillTitle");
            return (Criteria) this;
        }

        public Criteria andSmaillTitleNotIn(List<String> values) {
            addCriterion("smaill_title not in", values, "smaillTitle");
            return (Criteria) this;
        }

        public Criteria andSmaillTitleBetween(String value1, String value2) {
            addCriterion("smaill_title between", value1, value2, "smaillTitle");
            return (Criteria) this;
        }

        public Criteria andSmaillTitleNotBetween(String value1, String value2) {
            addCriterion("smaill_title not between", value1, value2, "smaillTitle");
            return (Criteria) this;
        }

        public Criteria andGiftNumberIsNull() {
            addCriterion("gift_number is null");
            return (Criteria) this;
        }

        public Criteria andGiftNumberIsNotNull() {
            addCriterion("gift_number is not null");
            return (Criteria) this;
        }

        public Criteria andGiftNumberEqualTo(Integer value) {
            addCriterion("gift_number =", value, "giftNumber");
            return (Criteria) this;
        }

        public Criteria andGiftNumberNotEqualTo(Integer value) {
            addCriterion("gift_number <>", value, "giftNumber");
            return (Criteria) this;
        }

        public Criteria andGiftNumberGreaterThan(Integer value) {
            addCriterion("gift_number >", value, "giftNumber");
            return (Criteria) this;
        }

        public Criteria andGiftNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("gift_number >=", value, "giftNumber");
            return (Criteria) this;
        }

        public Criteria andGiftNumberLessThan(Integer value) {
            addCriterion("gift_number <", value, "giftNumber");
            return (Criteria) this;
        }

        public Criteria andGiftNumberLessThanOrEqualTo(Integer value) {
            addCriterion("gift_number <=", value, "giftNumber");
            return (Criteria) this;
        }

        public Criteria andGiftNumberIn(List<Integer> values) {
            addCriterion("gift_number in", values, "giftNumber");
            return (Criteria) this;
        }

        public Criteria andGiftNumberNotIn(List<Integer> values) {
            addCriterion("gift_number not in", values, "giftNumber");
            return (Criteria) this;
        }

        public Criteria andGiftNumberBetween(Integer value1, Integer value2) {
            addCriterion("gift_number between", value1, value2, "giftNumber");
            return (Criteria) this;
        }

        public Criteria andGiftNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("gift_number not between", value1, value2, "giftNumber");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlIsNull() {
            addCriterion("introduce_url is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlIsNotNull() {
            addCriterion("introduce_url is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlEqualTo(String value) {
            addCriterion("introduce_url =", value, "introduceUrl");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlNotEqualTo(String value) {
            addCriterion("introduce_url <>", value, "introduceUrl");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlGreaterThan(String value) {
            addCriterion("introduce_url >", value, "introduceUrl");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("introduce_url >=", value, "introduceUrl");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlLessThan(String value) {
            addCriterion("introduce_url <", value, "introduceUrl");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlLessThanOrEqualTo(String value) {
            addCriterion("introduce_url <=", value, "introduceUrl");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlLike(String value) {
            addCriterion("introduce_url like", value, "introduceUrl");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlNotLike(String value) {
            addCriterion("introduce_url not like", value, "introduceUrl");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlIn(List<String> values) {
            addCriterion("introduce_url in", values, "introduceUrl");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlNotIn(List<String> values) {
            addCriterion("introduce_url not in", values, "introduceUrl");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlBetween(String value1, String value2) {
            addCriterion("introduce_url between", value1, value2, "introduceUrl");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlNotBetween(String value1, String value2) {
            addCriterion("introduce_url not between", value1, value2, "introduceUrl");
            return (Criteria) this;
        }

        public Criteria andIntroducePhotoIsNull() {
            addCriterion("introduce_photo is null");
            return (Criteria) this;
        }

        public Criteria andIntroducePhotoIsNotNull() {
            addCriterion("introduce_photo is not null");
            return (Criteria) this;
        }

        public Criteria andIntroducePhotoEqualTo(String value) {
            addCriterion("introduce_photo =", value, "introducePhoto");
            return (Criteria) this;
        }

        public Criteria andIntroducePhotoNotEqualTo(String value) {
            addCriterion("introduce_photo <>", value, "introducePhoto");
            return (Criteria) this;
        }

        public Criteria andIntroducePhotoGreaterThan(String value) {
            addCriterion("introduce_photo >", value, "introducePhoto");
            return (Criteria) this;
        }

        public Criteria andIntroducePhotoGreaterThanOrEqualTo(String value) {
            addCriterion("introduce_photo >=", value, "introducePhoto");
            return (Criteria) this;
        }

        public Criteria andIntroducePhotoLessThan(String value) {
            addCriterion("introduce_photo <", value, "introducePhoto");
            return (Criteria) this;
        }

        public Criteria andIntroducePhotoLessThanOrEqualTo(String value) {
            addCriterion("introduce_photo <=", value, "introducePhoto");
            return (Criteria) this;
        }

        public Criteria andIntroducePhotoLike(String value) {
            addCriterion("introduce_photo like", value, "introducePhoto");
            return (Criteria) this;
        }

        public Criteria andIntroducePhotoNotLike(String value) {
            addCriterion("introduce_photo not like", value, "introducePhoto");
            return (Criteria) this;
        }

        public Criteria andIntroducePhotoIn(List<String> values) {
            addCriterion("introduce_photo in", values, "introducePhoto");
            return (Criteria) this;
        }

        public Criteria andIntroducePhotoNotIn(List<String> values) {
            addCriterion("introduce_photo not in", values, "introducePhoto");
            return (Criteria) this;
        }

        public Criteria andIntroducePhotoBetween(String value1, String value2) {
            addCriterion("introduce_photo between", value1, value2, "introducePhoto");
            return (Criteria) this;
        }

        public Criteria andIntroducePhotoNotBetween(String value1, String value2) {
            addCriterion("introduce_photo not between", value1, value2, "introducePhoto");
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