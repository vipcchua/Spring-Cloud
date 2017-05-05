package com.cchuaspace.pojo;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cchuaspace.model.OrderCommodity;

@Component
public class OrderInfoVo {
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
     * 订单收货地址
     */
    private String orderAddress;

    /**
     * 联系人名称
     */
    private String contactName;

    /**
     * 联系人名称手机号码
     */
    private String contactPhone;

    /**
     * 固定电话
     */
    private String contactTelephone;

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
     * 付款状态 Unfinished 未完成（待付款） Abnormal异常 Success 成功
     */
    private String paymentState;

    /**
     * 快递编号
     */
    private String expressNumber;

    /**
     * 快递商家
     */
    private String expressBusiness;

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

    /**
     * 取货点编码
     */
    private Integer deliveryNumber;

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

    private int refundFee;






    private  OrderCommodity orderCommodity;


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

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone;
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

    public String getExpressNumber() {
        return expressNumber;
    }

    public void setExpressNumber(String expressNumber) {
        this.expressNumber = expressNumber;
    }

    public String getExpressBusiness() {
        return expressBusiness;
    }

    public void setExpressBusiness(String expressBusiness) {
        this.expressBusiness = expressBusiness;
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

    public Integer getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(Integer deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
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

    public int getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(int refundFee) {
        this.refundFee = refundFee;
    }

    public OrderCommodity getOrderCommodity() {
        return orderCommodity;
    }

    public void setOrderCommodity(OrderCommodity orderCommodity) {
        this.orderCommodity = orderCommodity;
    }


}