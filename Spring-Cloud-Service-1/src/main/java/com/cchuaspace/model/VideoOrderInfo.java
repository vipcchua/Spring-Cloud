package com.cchuaspace.model;

import java.util.Date;

public class VideoOrderInfo {
    /**
     * 订单编号
     */
    private Integer orderNumber;

    private String orderId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 微信用户的openId
     */
    private String openid;

    /**
     * 订单存活状态
     */
    private String orderState;

    /**
     * 付款方式
     */
    private String paymentMethod;

    /**
     * 付款金额
     */
    private Integer paymentAmount;

    /**
     * 付款状态 Unfinished 未完成 PendingPay待付款 Abnormal异常 Success 成功
     */
    private String paymentState;

    /**
     * 视频编号
     */
    private String videoNumber;

    /**
     * 订单评论编号
     */
    private String orderRemarks;

    /**
     * 订单生成时间
     */
    private Date generateTime;

    /**
     * 发票类型
     */
    private String invoiceType;

    /**
     * 发票抬头
     */
    private String invoiceHeader;

    private String orderMachineIp;

    /**
     * 微信支付-自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB"
     */
    private String deviceInfo;

    /**
     * 微信的交易类型
     */
    private String tradeType;

    private String wechatPayResult;

    /**
     * 微信订单号
     */
    private String transactionId;

    private String wechatRefundResult;

    private Date paySuccessTime;

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Integer paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }

    public String getVideoNumber() {
        return videoNumber;
    }

    public void setVideoNumber(String videoNumber) {
        this.videoNumber = videoNumber;
    }

    public String getOrderRemarks() {
        return orderRemarks;
    }

    public void setOrderRemarks(String orderRemarks) {
        this.orderRemarks = orderRemarks;
    }

    public Date getGenerateTime() {
        return generateTime;
    }

    public void setGenerateTime(Date generateTime) {
        this.generateTime = generateTime;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceHeader() {
        return invoiceHeader;
    }

    public void setInvoiceHeader(String invoiceHeader) {
        this.invoiceHeader = invoiceHeader;
    }

    public String getOrderMachineIp() {
        return orderMachineIp;
    }

    public void setOrderMachineIp(String orderMachineIp) {
        this.orderMachineIp = orderMachineIp;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getWechatPayResult() {
        return wechatPayResult;
    }

    public void setWechatPayResult(String wechatPayResult) {
        this.wechatPayResult = wechatPayResult;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getWechatRefundResult() {
        return wechatRefundResult;
    }

    public void setWechatRefundResult(String wechatRefundResult) {
        this.wechatRefundResult = wechatRefundResult;
    }

    public Date getPaySuccessTime() {
        return paySuccessTime;
    }

    public void setPaySuccessTime(Date paySuccessTime) {
        this.paySuccessTime = paySuccessTime;
    }
}