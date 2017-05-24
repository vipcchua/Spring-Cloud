package com.cchuaspace.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VideoOrderInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public VideoOrderInfoExample() {
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

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(Integer value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(Integer value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(Integer value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(Integer value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(Integer value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<Integer> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<Integer> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(Integer value1, Integer value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("openid is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("openid is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("openid =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("openid <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("openid >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("openid >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("openid <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("openid <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("openid like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("openid not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("openid in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("openid not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("openid between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("openid not between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNull() {
            addCriterion("order_state is null");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNotNull() {
            addCriterion("order_state is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStateEqualTo(String value) {
            addCriterion("order_state =", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotEqualTo(String value) {
            addCriterion("order_state <>", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThan(String value) {
            addCriterion("order_state >", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThanOrEqualTo(String value) {
            addCriterion("order_state >=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThan(String value) {
            addCriterion("order_state <", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThanOrEqualTo(String value) {
            addCriterion("order_state <=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLike(String value) {
            addCriterion("order_state like", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotLike(String value) {
            addCriterion("order_state not like", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateIn(List<String> values) {
            addCriterion("order_state in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotIn(List<String> values) {
            addCriterion("order_state not in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateBetween(String value1, String value2) {
            addCriterion("order_state between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotBetween(String value1, String value2) {
            addCriterion("order_state not between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIsNull() {
            addCriterion("payment_method is null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIsNotNull() {
            addCriterion("payment_method is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodEqualTo(String value) {
            addCriterion("payment_method =", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotEqualTo(String value) {
            addCriterion("payment_method <>", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThan(String value) {
            addCriterion("payment_method >", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThanOrEqualTo(String value) {
            addCriterion("payment_method >=", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThan(String value) {
            addCriterion("payment_method <", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThanOrEqualTo(String value) {
            addCriterion("payment_method <=", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLike(String value) {
            addCriterion("payment_method like", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotLike(String value) {
            addCriterion("payment_method not like", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIn(List<String> values) {
            addCriterion("payment_method in", values, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotIn(List<String> values) {
            addCriterion("payment_method not in", values, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodBetween(String value1, String value2) {
            addCriterion("payment_method between", value1, value2, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotBetween(String value1, String value2) {
            addCriterion("payment_method not between", value1, value2, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentAmountIsNull() {
            addCriterion("payment_amount is null");
            return (Criteria) this;
        }

        public Criteria andPaymentAmountIsNotNull() {
            addCriterion("payment_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentAmountEqualTo(Integer value) {
            addCriterion("payment_amount =", value, "paymentAmount");
            return (Criteria) this;
        }

        public Criteria andPaymentAmountNotEqualTo(Integer value) {
            addCriterion("payment_amount <>", value, "paymentAmount");
            return (Criteria) this;
        }

        public Criteria andPaymentAmountGreaterThan(Integer value) {
            addCriterion("payment_amount >", value, "paymentAmount");
            return (Criteria) this;
        }

        public Criteria andPaymentAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("payment_amount >=", value, "paymentAmount");
            return (Criteria) this;
        }

        public Criteria andPaymentAmountLessThan(Integer value) {
            addCriterion("payment_amount <", value, "paymentAmount");
            return (Criteria) this;
        }

        public Criteria andPaymentAmountLessThanOrEqualTo(Integer value) {
            addCriterion("payment_amount <=", value, "paymentAmount");
            return (Criteria) this;
        }

        public Criteria andPaymentAmountIn(List<Integer> values) {
            addCriterion("payment_amount in", values, "paymentAmount");
            return (Criteria) this;
        }

        public Criteria andPaymentAmountNotIn(List<Integer> values) {
            addCriterion("payment_amount not in", values, "paymentAmount");
            return (Criteria) this;
        }

        public Criteria andPaymentAmountBetween(Integer value1, Integer value2) {
            addCriterion("payment_amount between", value1, value2, "paymentAmount");
            return (Criteria) this;
        }

        public Criteria andPaymentAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("payment_amount not between", value1, value2, "paymentAmount");
            return (Criteria) this;
        }

        public Criteria andPaymentStateIsNull() {
            addCriterion("payment_state is null");
            return (Criteria) this;
        }

        public Criteria andPaymentStateIsNotNull() {
            addCriterion("payment_state is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentStateEqualTo(String value) {
            addCriterion("payment_state =", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateNotEqualTo(String value) {
            addCriterion("payment_state <>", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateGreaterThan(String value) {
            addCriterion("payment_state >", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateGreaterThanOrEqualTo(String value) {
            addCriterion("payment_state >=", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateLessThan(String value) {
            addCriterion("payment_state <", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateLessThanOrEqualTo(String value) {
            addCriterion("payment_state <=", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateLike(String value) {
            addCriterion("payment_state like", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateNotLike(String value) {
            addCriterion("payment_state not like", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateIn(List<String> values) {
            addCriterion("payment_state in", values, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateNotIn(List<String> values) {
            addCriterion("payment_state not in", values, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateBetween(String value1, String value2) {
            addCriterion("payment_state between", value1, value2, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateNotBetween(String value1, String value2) {
            addCriterion("payment_state not between", value1, value2, "paymentState");
            return (Criteria) this;
        }

        public Criteria andVideoNumberIsNull() {
            addCriterion("video_number is null");
            return (Criteria) this;
        }

        public Criteria andVideoNumberIsNotNull() {
            addCriterion("video_number is not null");
            return (Criteria) this;
        }

        public Criteria andVideoNumberEqualTo(String value) {
            addCriterion("video_number =", value, "videoNumber");
            return (Criteria) this;
        }

        public Criteria andVideoNumberNotEqualTo(String value) {
            addCriterion("video_number <>", value, "videoNumber");
            return (Criteria) this;
        }

        public Criteria andVideoNumberGreaterThan(String value) {
            addCriterion("video_number >", value, "videoNumber");
            return (Criteria) this;
        }

        public Criteria andVideoNumberGreaterThanOrEqualTo(String value) {
            addCriterion("video_number >=", value, "videoNumber");
            return (Criteria) this;
        }

        public Criteria andVideoNumberLessThan(String value) {
            addCriterion("video_number <", value, "videoNumber");
            return (Criteria) this;
        }

        public Criteria andVideoNumberLessThanOrEqualTo(String value) {
            addCriterion("video_number <=", value, "videoNumber");
            return (Criteria) this;
        }

        public Criteria andVideoNumberLike(String value) {
            addCriterion("video_number like", value, "videoNumber");
            return (Criteria) this;
        }

        public Criteria andVideoNumberNotLike(String value) {
            addCriterion("video_number not like", value, "videoNumber");
            return (Criteria) this;
        }

        public Criteria andVideoNumberIn(List<String> values) {
            addCriterion("video_number in", values, "videoNumber");
            return (Criteria) this;
        }

        public Criteria andVideoNumberNotIn(List<String> values) {
            addCriterion("video_number not in", values, "videoNumber");
            return (Criteria) this;
        }

        public Criteria andVideoNumberBetween(String value1, String value2) {
            addCriterion("video_number between", value1, value2, "videoNumber");
            return (Criteria) this;
        }

        public Criteria andVideoNumberNotBetween(String value1, String value2) {
            addCriterion("video_number not between", value1, value2, "videoNumber");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksIsNull() {
            addCriterion("order_Remarks is null");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksIsNotNull() {
            addCriterion("order_Remarks is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksEqualTo(String value) {
            addCriterion("order_Remarks =", value, "orderRemarks");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksNotEqualTo(String value) {
            addCriterion("order_Remarks <>", value, "orderRemarks");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksGreaterThan(String value) {
            addCriterion("order_Remarks >", value, "orderRemarks");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("order_Remarks >=", value, "orderRemarks");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksLessThan(String value) {
            addCriterion("order_Remarks <", value, "orderRemarks");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksLessThanOrEqualTo(String value) {
            addCriterion("order_Remarks <=", value, "orderRemarks");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksLike(String value) {
            addCriterion("order_Remarks like", value, "orderRemarks");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksNotLike(String value) {
            addCriterion("order_Remarks not like", value, "orderRemarks");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksIn(List<String> values) {
            addCriterion("order_Remarks in", values, "orderRemarks");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksNotIn(List<String> values) {
            addCriterion("order_Remarks not in", values, "orderRemarks");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksBetween(String value1, String value2) {
            addCriterion("order_Remarks between", value1, value2, "orderRemarks");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksNotBetween(String value1, String value2) {
            addCriterion("order_Remarks not between", value1, value2, "orderRemarks");
            return (Criteria) this;
        }

        public Criteria andGenerateTimeIsNull() {
            addCriterion("generate_time is null");
            return (Criteria) this;
        }

        public Criteria andGenerateTimeIsNotNull() {
            addCriterion("generate_time is not null");
            return (Criteria) this;
        }

        public Criteria andGenerateTimeEqualTo(Date value) {
            addCriterion("generate_time =", value, "generateTime");
            return (Criteria) this;
        }

        public Criteria andGenerateTimeNotEqualTo(Date value) {
            addCriterion("generate_time <>", value, "generateTime");
            return (Criteria) this;
        }

        public Criteria andGenerateTimeGreaterThan(Date value) {
            addCriterion("generate_time >", value, "generateTime");
            return (Criteria) this;
        }

        public Criteria andGenerateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("generate_time >=", value, "generateTime");
            return (Criteria) this;
        }

        public Criteria andGenerateTimeLessThan(Date value) {
            addCriterion("generate_time <", value, "generateTime");
            return (Criteria) this;
        }

        public Criteria andGenerateTimeLessThanOrEqualTo(Date value) {
            addCriterion("generate_time <=", value, "generateTime");
            return (Criteria) this;
        }

        public Criteria andGenerateTimeIn(List<Date> values) {
            addCriterion("generate_time in", values, "generateTime");
            return (Criteria) this;
        }

        public Criteria andGenerateTimeNotIn(List<Date> values) {
            addCriterion("generate_time not in", values, "generateTime");
            return (Criteria) this;
        }

        public Criteria andGenerateTimeBetween(Date value1, Date value2) {
            addCriterion("generate_time between", value1, value2, "generateTime");
            return (Criteria) this;
        }

        public Criteria andGenerateTimeNotBetween(Date value1, Date value2) {
            addCriterion("generate_time not between", value1, value2, "generateTime");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIsNull() {
            addCriterion("invoice_type is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIsNotNull() {
            addCriterion("invoice_type is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeEqualTo(String value) {
            addCriterion("invoice_type =", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotEqualTo(String value) {
            addCriterion("invoice_type <>", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeGreaterThan(String value) {
            addCriterion("invoice_type >", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_type >=", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLessThan(String value) {
            addCriterion("invoice_type <", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLessThanOrEqualTo(String value) {
            addCriterion("invoice_type <=", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLike(String value) {
            addCriterion("invoice_type like", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotLike(String value) {
            addCriterion("invoice_type not like", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIn(List<String> values) {
            addCriterion("invoice_type in", values, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotIn(List<String> values) {
            addCriterion("invoice_type not in", values, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeBetween(String value1, String value2) {
            addCriterion("invoice_type between", value1, value2, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotBetween(String value1, String value2) {
            addCriterion("invoice_type not between", value1, value2, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceHeaderIsNull() {
            addCriterion("invoice_header is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceHeaderIsNotNull() {
            addCriterion("invoice_header is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceHeaderEqualTo(String value) {
            addCriterion("invoice_header =", value, "invoiceHeader");
            return (Criteria) this;
        }

        public Criteria andInvoiceHeaderNotEqualTo(String value) {
            addCriterion("invoice_header <>", value, "invoiceHeader");
            return (Criteria) this;
        }

        public Criteria andInvoiceHeaderGreaterThan(String value) {
            addCriterion("invoice_header >", value, "invoiceHeader");
            return (Criteria) this;
        }

        public Criteria andInvoiceHeaderGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_header >=", value, "invoiceHeader");
            return (Criteria) this;
        }

        public Criteria andInvoiceHeaderLessThan(String value) {
            addCriterion("invoice_header <", value, "invoiceHeader");
            return (Criteria) this;
        }

        public Criteria andInvoiceHeaderLessThanOrEqualTo(String value) {
            addCriterion("invoice_header <=", value, "invoiceHeader");
            return (Criteria) this;
        }

        public Criteria andInvoiceHeaderLike(String value) {
            addCriterion("invoice_header like", value, "invoiceHeader");
            return (Criteria) this;
        }

        public Criteria andInvoiceHeaderNotLike(String value) {
            addCriterion("invoice_header not like", value, "invoiceHeader");
            return (Criteria) this;
        }

        public Criteria andInvoiceHeaderIn(List<String> values) {
            addCriterion("invoice_header in", values, "invoiceHeader");
            return (Criteria) this;
        }

        public Criteria andInvoiceHeaderNotIn(List<String> values) {
            addCriterion("invoice_header not in", values, "invoiceHeader");
            return (Criteria) this;
        }

        public Criteria andInvoiceHeaderBetween(String value1, String value2) {
            addCriterion("invoice_header between", value1, value2, "invoiceHeader");
            return (Criteria) this;
        }

        public Criteria andInvoiceHeaderNotBetween(String value1, String value2) {
            addCriterion("invoice_header not between", value1, value2, "invoiceHeader");
            return (Criteria) this;
        }

        public Criteria andOrderMachineIpIsNull() {
            addCriterion("order_machine_ip is null");
            return (Criteria) this;
        }

        public Criteria andOrderMachineIpIsNotNull() {
            addCriterion("order_machine_ip is not null");
            return (Criteria) this;
        }

        public Criteria andOrderMachineIpEqualTo(String value) {
            addCriterion("order_machine_ip =", value, "orderMachineIp");
            return (Criteria) this;
        }

        public Criteria andOrderMachineIpNotEqualTo(String value) {
            addCriterion("order_machine_ip <>", value, "orderMachineIp");
            return (Criteria) this;
        }

        public Criteria andOrderMachineIpGreaterThan(String value) {
            addCriterion("order_machine_ip >", value, "orderMachineIp");
            return (Criteria) this;
        }

        public Criteria andOrderMachineIpGreaterThanOrEqualTo(String value) {
            addCriterion("order_machine_ip >=", value, "orderMachineIp");
            return (Criteria) this;
        }

        public Criteria andOrderMachineIpLessThan(String value) {
            addCriterion("order_machine_ip <", value, "orderMachineIp");
            return (Criteria) this;
        }

        public Criteria andOrderMachineIpLessThanOrEqualTo(String value) {
            addCriterion("order_machine_ip <=", value, "orderMachineIp");
            return (Criteria) this;
        }

        public Criteria andOrderMachineIpLike(String value) {
            addCriterion("order_machine_ip like", value, "orderMachineIp");
            return (Criteria) this;
        }

        public Criteria andOrderMachineIpNotLike(String value) {
            addCriterion("order_machine_ip not like", value, "orderMachineIp");
            return (Criteria) this;
        }

        public Criteria andOrderMachineIpIn(List<String> values) {
            addCriterion("order_machine_ip in", values, "orderMachineIp");
            return (Criteria) this;
        }

        public Criteria andOrderMachineIpNotIn(List<String> values) {
            addCriterion("order_machine_ip not in", values, "orderMachineIp");
            return (Criteria) this;
        }

        public Criteria andOrderMachineIpBetween(String value1, String value2) {
            addCriterion("order_machine_ip between", value1, value2, "orderMachineIp");
            return (Criteria) this;
        }

        public Criteria andOrderMachineIpNotBetween(String value1, String value2) {
            addCriterion("order_machine_ip not between", value1, value2, "orderMachineIp");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoIsNull() {
            addCriterion("device_info is null");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoIsNotNull() {
            addCriterion("device_info is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoEqualTo(String value) {
            addCriterion("device_info =", value, "deviceInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoNotEqualTo(String value) {
            addCriterion("device_info <>", value, "deviceInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoGreaterThan(String value) {
            addCriterion("device_info >", value, "deviceInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoGreaterThanOrEqualTo(String value) {
            addCriterion("device_info >=", value, "deviceInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoLessThan(String value) {
            addCriterion("device_info <", value, "deviceInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoLessThanOrEqualTo(String value) {
            addCriterion("device_info <=", value, "deviceInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoLike(String value) {
            addCriterion("device_info like", value, "deviceInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoNotLike(String value) {
            addCriterion("device_info not like", value, "deviceInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoIn(List<String> values) {
            addCriterion("device_info in", values, "deviceInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoNotIn(List<String> values) {
            addCriterion("device_info not in", values, "deviceInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoBetween(String value1, String value2) {
            addCriterion("device_info between", value1, value2, "deviceInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoNotBetween(String value1, String value2) {
            addCriterion("device_info not between", value1, value2, "deviceInfo");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNull() {
            addCriterion("trade_type is null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNotNull() {
            addCriterion("trade_type is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeEqualTo(String value) {
            addCriterion("trade_type =", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotEqualTo(String value) {
            addCriterion("trade_type <>", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThan(String value) {
            addCriterion("trade_type >", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("trade_type >=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThan(String value) {
            addCriterion("trade_type <", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThanOrEqualTo(String value) {
            addCriterion("trade_type <=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLike(String value) {
            addCriterion("trade_type like", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotLike(String value) {
            addCriterion("trade_type not like", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIn(List<String> values) {
            addCriterion("trade_type in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotIn(List<String> values) {
            addCriterion("trade_type not in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeBetween(String value1, String value2) {
            addCriterion("trade_type between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotBetween(String value1, String value2) {
            addCriterion("trade_type not between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andWechatPayResultIsNull() {
            addCriterion("wechat_pay_result is null");
            return (Criteria) this;
        }

        public Criteria andWechatPayResultIsNotNull() {
            addCriterion("wechat_pay_result is not null");
            return (Criteria) this;
        }

        public Criteria andWechatPayResultEqualTo(String value) {
            addCriterion("wechat_pay_result =", value, "wechatPayResult");
            return (Criteria) this;
        }

        public Criteria andWechatPayResultNotEqualTo(String value) {
            addCriterion("wechat_pay_result <>", value, "wechatPayResult");
            return (Criteria) this;
        }

        public Criteria andWechatPayResultGreaterThan(String value) {
            addCriterion("wechat_pay_result >", value, "wechatPayResult");
            return (Criteria) this;
        }

        public Criteria andWechatPayResultGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_pay_result >=", value, "wechatPayResult");
            return (Criteria) this;
        }

        public Criteria andWechatPayResultLessThan(String value) {
            addCriterion("wechat_pay_result <", value, "wechatPayResult");
            return (Criteria) this;
        }

        public Criteria andWechatPayResultLessThanOrEqualTo(String value) {
            addCriterion("wechat_pay_result <=", value, "wechatPayResult");
            return (Criteria) this;
        }

        public Criteria andWechatPayResultLike(String value) {
            addCriterion("wechat_pay_result like", value, "wechatPayResult");
            return (Criteria) this;
        }

        public Criteria andWechatPayResultNotLike(String value) {
            addCriterion("wechat_pay_result not like", value, "wechatPayResult");
            return (Criteria) this;
        }

        public Criteria andWechatPayResultIn(List<String> values) {
            addCriterion("wechat_pay_result in", values, "wechatPayResult");
            return (Criteria) this;
        }

        public Criteria andWechatPayResultNotIn(List<String> values) {
            addCriterion("wechat_pay_result not in", values, "wechatPayResult");
            return (Criteria) this;
        }

        public Criteria andWechatPayResultBetween(String value1, String value2) {
            addCriterion("wechat_pay_result between", value1, value2, "wechatPayResult");
            return (Criteria) this;
        }

        public Criteria andWechatPayResultNotBetween(String value1, String value2) {
            addCriterion("wechat_pay_result not between", value1, value2, "wechatPayResult");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIsNull() {
            addCriterion("transaction_id is null");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIsNotNull() {
            addCriterion("transaction_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionIdEqualTo(String value) {
            addCriterion("transaction_id =", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotEqualTo(String value) {
            addCriterion("transaction_id <>", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdGreaterThan(String value) {
            addCriterion("transaction_id >", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_id >=", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLessThan(String value) {
            addCriterion("transaction_id <", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLessThanOrEqualTo(String value) {
            addCriterion("transaction_id <=", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLike(String value) {
            addCriterion("transaction_id like", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotLike(String value) {
            addCriterion("transaction_id not like", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIn(List<String> values) {
            addCriterion("transaction_id in", values, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotIn(List<String> values) {
            addCriterion("transaction_id not in", values, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdBetween(String value1, String value2) {
            addCriterion("transaction_id between", value1, value2, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotBetween(String value1, String value2) {
            addCriterion("transaction_id not between", value1, value2, "transactionId");
            return (Criteria) this;
        }

        public Criteria andWechatRefundResultIsNull() {
            addCriterion("wechat_refund_result is null");
            return (Criteria) this;
        }

        public Criteria andWechatRefundResultIsNotNull() {
            addCriterion("wechat_refund_result is not null");
            return (Criteria) this;
        }

        public Criteria andWechatRefundResultEqualTo(String value) {
            addCriterion("wechat_refund_result =", value, "wechatRefundResult");
            return (Criteria) this;
        }

        public Criteria andWechatRefundResultNotEqualTo(String value) {
            addCriterion("wechat_refund_result <>", value, "wechatRefundResult");
            return (Criteria) this;
        }

        public Criteria andWechatRefundResultGreaterThan(String value) {
            addCriterion("wechat_refund_result >", value, "wechatRefundResult");
            return (Criteria) this;
        }

        public Criteria andWechatRefundResultGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_refund_result >=", value, "wechatRefundResult");
            return (Criteria) this;
        }

        public Criteria andWechatRefundResultLessThan(String value) {
            addCriterion("wechat_refund_result <", value, "wechatRefundResult");
            return (Criteria) this;
        }

        public Criteria andWechatRefundResultLessThanOrEqualTo(String value) {
            addCriterion("wechat_refund_result <=", value, "wechatRefundResult");
            return (Criteria) this;
        }

        public Criteria andWechatRefundResultLike(String value) {
            addCriterion("wechat_refund_result like", value, "wechatRefundResult");
            return (Criteria) this;
        }

        public Criteria andWechatRefundResultNotLike(String value) {
            addCriterion("wechat_refund_result not like", value, "wechatRefundResult");
            return (Criteria) this;
        }

        public Criteria andWechatRefundResultIn(List<String> values) {
            addCriterion("wechat_refund_result in", values, "wechatRefundResult");
            return (Criteria) this;
        }

        public Criteria andWechatRefundResultNotIn(List<String> values) {
            addCriterion("wechat_refund_result not in", values, "wechatRefundResult");
            return (Criteria) this;
        }

        public Criteria andWechatRefundResultBetween(String value1, String value2) {
            addCriterion("wechat_refund_result between", value1, value2, "wechatRefundResult");
            return (Criteria) this;
        }

        public Criteria andWechatRefundResultNotBetween(String value1, String value2) {
            addCriterion("wechat_refund_result not between", value1, value2, "wechatRefundResult");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeIsNull() {
            addCriterion("pay_success_time is null");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeIsNotNull() {
            addCriterion("pay_success_time is not null");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeEqualTo(Date value) {
            addCriterion("pay_success_time =", value, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeNotEqualTo(Date value) {
            addCriterion("pay_success_time <>", value, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeGreaterThan(Date value) {
            addCriterion("pay_success_time >", value, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_success_time >=", value, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeLessThan(Date value) {
            addCriterion("pay_success_time <", value, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_success_time <=", value, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeIn(List<Date> values) {
            addCriterion("pay_success_time in", values, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeNotIn(List<Date> values) {
            addCriterion("pay_success_time not in", values, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeBetween(Date value1, Date value2) {
            addCriterion("pay_success_time between", value1, value2, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_success_time not between", value1, value2, "paySuccessTime");
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