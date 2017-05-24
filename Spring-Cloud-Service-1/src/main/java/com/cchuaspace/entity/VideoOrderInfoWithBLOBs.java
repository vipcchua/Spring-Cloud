package com.cchuaspace.entity;

import com.cchuaspace.model.VideoOrderInfo;

public class VideoOrderInfoWithBLOBs extends VideoOrderInfo {
    private String wechatPayResult;

    private String wechatRefundResult;

    public String getWechatPayResult() {
        return wechatPayResult;
    }

    public void setWechatPayResult(String wechatPayResult) {
        this.wechatPayResult = wechatPayResult;
    }

    public String getWechatRefundResult() {
        return wechatRefundResult;
    }

    public void setWechatRefundResult(String wechatRefundResult) {
        this.wechatRefundResult = wechatRefundResult;
    }
}