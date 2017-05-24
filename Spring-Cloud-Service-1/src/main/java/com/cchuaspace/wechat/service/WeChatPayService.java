package com.cchuaspace.wechat.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cchuaspace.currency.CchuaTool;
import com.cchuaspace.mapper.*;
import com.cchuaspace.model.*;

import com.cchuaspace.pojo.OrderInfoVo;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.pojo.WechatVo;
import com.cchuaspace.wechat.model.OrderRequest;
import com.cchuaspace.wechat.model.PaymentState;
import com.cchuaspace.wechat.model.WechatOrderPayApi;
import com.cchuaspace.wechat.tool.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URI;
import java.security.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

/*
 * ****************<--*---Code information---*-->**************
 * 	
 *		Author: Cchua
 *		GitHub: https://github.com/vipcchua
 *		Blog  : weibo.com/vipcchua
 * 
 * 
 * ************************************************************/
@Service

@Component

@Scope("prototype")
public class WeChatPayService {
    /*
     * @Autowired private PaginationVo paginationVo;
	 */

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestOperations restOperations;

    @Autowired
    private CustomerInfoMapper customerInfoMapper;

    @Autowired
    private WechatPayResultMapper wechatPayResultMapper;

    @Autowired
    private OrderInfoMapper orderInfoMapper;


    @Autowired
    private CchuaTool cchuaTool;

    @Autowired
    private OrderCommodityMapper orderCommodityMapper;

    @Autowired
    private CommodityInfoDetailsMapper commodityInfoDetailsMapper;
    @Autowired
    private PaginationVo paginationVo;
    @Autowired
    private WeChatFunctionService weChatFunctionService;

    String AppId = "wx253b97a570d99ccc";
    String AppSecret = "3c91bb1f519ad2604e78b7115deec5a5";
    /*商户号*/
    String MchId = "1449632602";
    /*apiKey--商户Key*/
    String apiKey = "f6f0ba3597ddb4020083b8f808314832";
    /*回调地址*/
    String NotifyUrl = "http://igo.vrdete.com/api/wechat/pay/payresponse";

    String pfile = "D://apiclient_cert.p12";

    /*--------------- -----<----*直接获取订单信息生成成微信订单*---->--- ----------------------*/
    public PaginationVo PayByOrder(OrderInfo orderInfo, String data) {
       /* OrderBy= JSONObject.parseObject(GenerateOrder, OrderRequest.class);*/
        OrderRequest json = new OrderRequest();
       /* String OrderNumber = String.valueOf(cchuaTool.getOrderNumber(11, 2));*/

        json.setAppid(AppId);
        json.setAttach("Igo商城支付");
        json.setBody("Igo商城" + orderInfo.getContactName() + "用户的订单");


        json.setDeviceInfo("WEB");/*自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB"*/

        json.setMchId(MchId);
        json.setNonceStr(cchuaTool.henuuid());
        json.setNotifyUrl(NotifyUrl);
        json.setOpenid(orderInfo.getOpenid());

        json.setOutTradeNo(orderInfo.getOrderNumber().toString());/*商户系统内部订单号*/
        json.setSpbillCreateIp(orderInfo.getOrderMachineIp());
        json.setTotalFee(orderInfo.getPaymentAmount());
        json.setTradeType("JSAPI");/*交易类型*/

/*-----------------《----以下进行Sign加密----》----------------*/
        SortedMap<String, String> parameters = new TreeMap<String, String>();
        parameters.put("appid", json.getAppid());
        parameters.put("attach", json.getAttach());
        parameters.put("body", json.getBody());
        parameters.put("device_info", json.getDeviceInfo());

        parameters.put("mch_id", json.getMchId());
        parameters.put("nonce_str", json.getNonceStr());
        parameters.put("notify_url", json.getNotifyUrl());
        parameters.put("openid", json.getOpenid());

        parameters.put("out_trade_no", json.getOutTradeNo());// 商户系统内部订单号
        parameters.put("spbill_create_ip", json.getSpbillCreateIp());// 电脑ip地址
        parameters.put("total_fee", String.valueOf(json.getTotalFee()));// 标价金额（分）*/
        parameters.put("trade_type", json.getTradeType());

        String KeysignStr = MD5Util.getWXPayMD5(parameters, apiKey);

        System.out.print(KeysignStr + "\n");

        json.setSign(KeysignStr);
/*-----------------《----得到加密好的Sign----》----------------*/

/*-----------------《----进行第一次生成订单访问----》----------------*/
        String preOrderXml =
                "<xml>"
                        + "<appid>" + json.getAppid() + "</appid>"
                        + "<attach>" + "<![CDATA[" + json.getAttach() + "]]></attach>"
                        + "<body><![CDATA[" + json.getBody() + "]]></body>"
                        + "<device_info>" + json.getDeviceInfo() + "</device_info>"
                        + "<mch_id>" + json.getMchId() + "</mch_id>"
                        + "<nonce_str>" + json.getNonceStr() + "</nonce_str>"
                        + "<notify_url>" + json.getNotifyUrl() + "</notify_url>"
                        + "<openid>" + json.getOpenid() + "</openid>"
                        + "<out_trade_no>" + json.getOutTradeNo() + "</out_trade_no>"
                        + "<spbill_create_ip>" + json.getSpbillCreateIp() + "</spbill_create_ip>"
                        + "<total_fee>" + json.getTotalFee() + "</total_fee>"
                        + "<trade_type>" + json.getTradeType() + "</trade_type>"
                        + "<sign>" + json.getSign() + "</sign>"
                        + "</xml>";

        String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";

      /*  RestTemplate restTemplate = new RestTemplate();*/
     /*   String result = restOperations.postForObject(url, formEntity, String.class);*/
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(preOrderXml, headers);
        String result = HttpUtil.doPostSSL(url, preOrderXml);


/*-----------------《----进行第一次生成订单访问成功 得到微信生成的支付订单信息----》----------------*/

/*-----------------《----将回调回来的订单信息进行解析----》----------------*/

        XmlUtil xmlUtil = new XmlUtil();
        try {
            Map<String, String> Xmldata = xmlUtil.XmlAnalysis(result);


            String theTimestamp = DateUtil.getTimeStamp();

            SortedMap<String, String> thePaySign = new TreeMap<String, String>();

            /*-----------------《----生成PaySigin----》----------------*/
            String PaynonceStr = cchuaTool.henuuid();
            thePaySign.put("appId", AppId);
            thePaySign.put("timeStamp", theTimestamp);
            thePaySign.put("nonceStr", PaynonceStr);
            thePaySign.put("package", "prepay_id=" + Xmldata.get("prepay_id"));
            thePaySign.put("signType", "MD5");
            String PaySigin = MD5Util.getWXPayMD5(thePaySign, apiKey);

           /*-----------------《----将支付信息打包 回调给前端----》----------------*/
            WechatOrderPayApi PayApi = new WechatOrderPayApi();
            PayApi.setAppId(AppId);
            PayApi.setTimeStamp(theTimestamp);
            PayApi.setNonceStr(PaynonceStr);
            PayApi.setPrepayId("prepay_id=" + Xmldata.get("prepay_id"));
            PayApi.setPaySign(PaySigin);

            System.out.print("PaySigin:" + PaySigin + "\n" + result + "\n");

          /* orderInfoMapper.UpdatePaymentStateBYclose(orderInfo.getOrderNumber(), "PendingPay");*/

            orderInfoMapper.UpdatePayInfo(orderInfo.getOrderNumber(), "PendingPay", JSON.toJSONString(PayApi));


            paginationVo.setDataResultObj(PayApi);


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }


        return paginationVo;

    }
/*--*/



    /*--------------- -----<----*获取订单信息后生成微信订单*---->--- ----------------------*/
    public PaginationVo WechatPay(String orderInfodata) {
       /* OrderBy= JSONObject.parseObject(GenerateOrder, OrderRequest.class);*/
        OrderInfo Datas = JSONObject.parseObject(orderInfodata, OrderInfo.class);


        OrderRequest json = new OrderRequest();
       /* String OrderNumber = String.valueOf(cchuaTool.getOrderNumber(11, 2));*/

        OrderInfo orderInfo = orderInfoMapper.SelectByOrderNumber(Datas.getOrderNumber());

        json.setAppid(AppId);
        json.setAttach("Igo商城支付");
        json.setBody("Igo商城" + orderInfo.getContactName() + "用户的订单");
        json.setDeviceInfo("WEB");/*自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB"*/

        json.setMchId(MchId);
        json.setNonceStr(cchuaTool.henuuid());
        json.setNotifyUrl(NotifyUrl);
        json.setOpenid(orderInfo.getOpenid());

        json.setOutTradeNo(orderInfo.getOrderNumber().toString());/*商户系统内部订单号*/
        json.setSpbillCreateIp(orderInfo.getOrderMachineIp());
        json.setTotalFee(orderInfo.getPaymentAmount());
        json.setTradeType("JSAPI");/*交易类型*/

/*-----------------《----以下进行Sign加密----》----------------*/
        SortedMap<String, String> parameters = new TreeMap<String, String>();
        parameters.put("appid", json.getAppid());
        parameters.put("attach", json.getAttach());
        parameters.put("body", json.getBody());
        parameters.put("device_info", json.getDeviceInfo());

        parameters.put("mch_id", json.getMchId());
        parameters.put("nonce_str", json.getNonceStr());
        parameters.put("notify_url", json.getNotifyUrl());
        parameters.put("openid", json.getOpenid());

        parameters.put("out_trade_no", json.getOutTradeNo());// 商户系统内部订单号
        parameters.put("spbill_create_ip", json.getSpbillCreateIp());// 电脑ip地址
        parameters.put("total_fee", String.valueOf(json.getTotalFee()));// 标价金额（分）*/
        parameters.put("trade_type", json.getTradeType());

        String KeysignStr = MD5Util.getWXPayMD5(parameters, apiKey);

        System.out.print(KeysignStr + "\n");

        json.setSign(KeysignStr);
/*-----------------《----得到加密好的Sign----》----------------*/

/*-----------------《----进行第一次生成订单访问----》----------------*/
        String preOrderXml =
                "<xml>"
                        + "<appid>" + json.getAppid() + "</appid>"
                        + "<attach>" + "<![CDATA[" + json.getAttach() + "]]></attach>"
                        + "<body><![CDATA[" + json.getBody() + "]]></body>"
                        + "<device_info>" + json.getDeviceInfo() + "</device_info>"
                        + "<mch_id>" + json.getMchId() + "</mch_id>"
                        + "<nonce_str>" + json.getNonceStr() + "</nonce_str>"
                        + "<notify_url>" + json.getNotifyUrl() + "</notify_url>"
                        + "<openid>" + json.getOpenid() + "</openid>"
                        + "<out_trade_no>" + json.getOutTradeNo() + "</out_trade_no>"
                        + "<spbill_create_ip>" + json.getSpbillCreateIp() + "</spbill_create_ip>"
                        + "<total_fee>" + json.getTotalFee() + "</total_fee>"
                        + "<trade_type>" + json.getTradeType() + "</trade_type>"
                        + "<sign>" + json.getSign() + "</sign>"
                        + "</xml>";

        String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";

      /*  RestTemplate restTemplate = new RestTemplate();*/
     /*   String result = restOperations.postForObject(url, formEntity, String.class);*/
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(preOrderXml, headers);
        String result = HttpUtil.doPostSSL(url, preOrderXml);


/*-----------------《----进行第一次生成订单访问成功 得到微信生成的支付订单信息----》----------------*/

/*-----------------《----将回调回来的订单信息进行解析----》----------------*/

        XmlUtil xmlUtil = new XmlUtil();
        try {
            Map<String, String> Xmldata = xmlUtil.XmlAnalysis(result);


            String theTimestamp = DateUtil.getTimeStamp();

            SortedMap<String, String> thePaySign = new TreeMap<String, String>();

            /*-----------------《----生成PaySigin----》----------------*/
            String PaynonceStr = cchuaTool.henuuid();
            thePaySign.put("appId", AppId);
            thePaySign.put("timeStamp", theTimestamp);
            thePaySign.put("nonceStr", PaynonceStr);
            thePaySign.put("package", "prepay_id=" + Xmldata.get("prepay_id"));
            thePaySign.put("signType", "MD5");
            String PaySigin = MD5Util.getWXPayMD5(thePaySign, apiKey);

           /*-----------------《----将支付信息打包 回调给前端----》----------------*/
            WechatOrderPayApi PayApi = new WechatOrderPayApi();
            PayApi.setAppId(AppId);
            PayApi.setTimeStamp(theTimestamp);
            PayApi.setNonceStr(PaynonceStr);
            PayApi.setPrepayId("prepay_id=" + Xmldata.get("prepay_id"));
            PayApi.setPaySign(PaySigin);

            System.out.print("PaySigin:" + PaySigin + "\n" + result + "\n");


            paginationVo.setDataResultObj(PayApi);
            paginationVo.setHtmlState("Success");


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            paginationVo.setHtmlState("Error");
        }


        return paginationVo;

    }

    /*--------------- -----<----*退款*---->--- ----------------------*/
    public PaginationVo WechatRefund(String orderInfodata) {

        OrderInfoVo Datas = JSONObject.parseObject(orderInfodata, OrderInfoVo.class);

        OrderRequest json = new OrderRequest();


        List<OrderInfoVo> orderInfo = orderInfoMapper.selectByOrderNumberList(Datas.getOrderNumber());
        if (orderInfo.size()==1){
        json.setAppid(AppId);
        json.setMchId(MchId);
        json.setNonceStr(cchuaTool.henuuid());
        json.setOpUserId(MchId);


        json.setOutRefundNo(String.valueOf(cchuaTool.getOrderNumber(1, 2)));
        json.setOutTradeNo(orderInfo.get(0).getOrderNumber().toString());/*商户系统内部订单号*/
        json.setRefundFee(Datas.getRefundFee());
        json.setTotalFee(orderInfo.get(0).getPaymentAmount());

        json.setTransactionId("");



/*-----------------《----以下进行Sign加密----》----------------*/
        SortedMap<String, String> parameters = new TreeMap<String, String>();
        parameters.put("appid", json.getAppid());
        parameters.put("mch_id", json.getMchId());
        parameters.put("nonce_str", json.getNonceStr());

        parameters.put("op_user_id", json.getOpUserId());
        parameters.put("out_refund_no", json.getOutRefundNo());// 商户系统内部退款订单号
        parameters.put("out_trade_no", json.getOutTradeNo());// 商户系统内部订单号

        parameters.put("refund_fee", String.valueOf(json.getRefundFee()));// 标价金额（分）*/
        parameters.put("total_fee", String.valueOf(json.getTotalFee()));// 标价金额（分）*/
        parameters.put("transaction_id", json.getTransactionId());


        String KeysignStr = MD5Util.getWXPayMD5(parameters, apiKey);

        System.out.print(KeysignStr + "\n");

        json.setSign(KeysignStr);
/*-----------------《----得到加密好的Sign----》----------------*/

/*-----------------《----进行第一次生成订单访问----》----------------*/
        String preOrderXml =
                "<xml>"
                        + "<appid>" + json.getAppid() + "</appid>"
                        + "<mch_id>" + json.getMchId() + "</mch_id>"
                        + "<nonce_str>" + json.getNonceStr() + "</nonce_str>"

                        + "<op_user_id>" + json.getOpUserId() + "</op_user_id>"
                        + "<out_refund_no>" + json.getOutRefundNo() + "</out_refund_no>"
                        + "<out_trade_no>" + json.getOutTradeNo() + "</out_trade_no>"

                        + "<refund_fee>" + json.getRefundFee() + "</refund_fee>"
                        + "<total_fee>" + json.getTotalFee() + "</total_fee>"
                        + "<transaction_id>" + json.getTransactionId() + "</transaction_id>"

                        + "<sign>" + json.getSign() + "</sign>"

                        + "</xml>";

        String url = "https://api.mch.weixin.qq.com/secapi/pay/refund";


        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(preOrderXml, headers);

       /* String result = HttpUtil.doPostSSL(url, preOrderXml);*/

        String result = null;
        try {
            result = HttpUtil.SslPost(url.trim(), preOrderXml.trim(), pfile.trim(), json.getMchId());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
/*-----------------《----进行第一次生成订单访问成功 得到微信生成的支付订单信息----》----------------*/

/*-----------------《----将回调回来的订单信息进行解析----》----------------*/

        XmlUtil xmlUtil = new XmlUtil();
        try {
            Map<String, String> Xmldata = xmlUtil.XmlAnalysis(result);


            String theTimestamp = DateUtil.getTimeStamp();

            SortedMap<String, String> thePaySign = new TreeMap<String, String>();
            if (Xmldata.get("result_code").equals("SUCCESS") & Xmldata.get("return_msg").equals("OK")) {
                orderInfoMapper.UpdateRefundInfo(orderInfo.get(0).getOrderNumber(), "Refund_Success", JSON.toJSONString(Xmldata));

            } else {
                orderInfoMapper.UpdateRefundInfo(orderInfo.get(0).getOrderNumber(), "Refund_Error", JSON.toJSONString(Xmldata));
            }


            paginationVo.setHtmlState("Success:" + orderInfo.get(0).getOrderNumber() + "退款成功");

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            paginationVo.setHtmlState("Error");
        }
        }
        else{
            paginationVo.setHtmlState("Error:不存在的订单或存在重复的订单，请管理员核对数据库");
        }


        return paginationVo;

    }


    /*--------------- -----<----*关闭微信支付订单*---->--- ----------------------*/
    public PaginationVo WechatCloseorder(String orderInfodata) {

        OrderInfo Datas = JSONObject.parseObject(orderInfodata, OrderInfo.class);

        OrderRequest json = new OrderRequest();

        OrderInfo orderInfo = orderInfoMapper.SelectByOrderNumber(Datas.getOrderNumber());

        json.setAppid(AppId);
        json.setMchId(MchId);
        json.setNonceStr(cchuaTool.henuuid());
        json.setOutTradeNo(orderInfo.getOrderNumber().toString());/*商户系统内部订单号*/





/*-----------------《----以下进行Sign加密----》----------------*/
        SortedMap<String, String> parameters = new TreeMap<String, String>();
        parameters.put("appid", json.getAppid());
        parameters.put("mch_id", json.getMchId());
        parameters.put("nonce_str", json.getNonceStr());
        parameters.put("out_trade_no", json.getOutTradeNo());// 商户系统内部订单号
     /*   parameters.put("signType", "MD5");*/

        String KeysignStr = MD5Util.getWXPayMD5(parameters, apiKey);

        System.out.print(KeysignStr + "\n");

        json.setSign(KeysignStr);
/*-----------------《----得到加密好的Sign----》----------------*/

/*-----------------《----进行第一次访问----》----------------*/
        String preOrderXml = "<xml>"
                + "<appid>" + json.getAppid() + "</appid>"
                + "<mch_id>" + json.getMchId() + "</mch_id>"
                + "<nonce_str>" + json.getNonceStr() + "</nonce_str>"
                + "<out_trade_no>" + json.getOutTradeNo() + "</out_trade_no>"
                + "<sign>" + json.getSign() + "</sign>"
                + "</xml>";

        String url = "https://api.mch.weixin.qq.com/pay/closeorder";

      /*  RestTemplate restTemplate = new RestTemplate();*/
     /*   String result = restOperations.postForObject(url, formEntity, String.class);*/
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(preOrderXml, headers);
        String result = HttpUtil.doPostSSL(url, preOrderXml);


/*-----------------《----进行第一次生成订单访问成功 得到微信生成的支付订单信息----》----------------*/

/*-----------------《----将回调回来的订单信息进行解析----》----------------*/

        XmlUtil xmlUtil = new XmlUtil();
        try {
            Map<String, String> Xmldata = xmlUtil.XmlAnalysis(result);


            Xmldata.get("return_msg");
            Xmldata.get("err_code");

           /*-----------------《----将支付信息打包 回调给前端----》----------------*/

            if (Xmldata.get("return_code") == "Success") {

                JSONObject resultCode = new JSONObject();
                resultCode.put("resultCode", Xmldata.get("return_code"));
                resultCode.put("return_msg", Xmldata.get("return_msg"));

                orderInfoMapper.UpdatePaymentStateBYclose(orderInfo.getOrderNumber(), "Close");

                paginationVo.setDataResultObj(resultCode);


                paginationVo.setHtmlState("Success");

            } else {
                JSONObject resultCode = new JSONObject();

                resultCode.put("resultCode", Xmldata.get("return_code"));
                resultCode.put("return_msg", Xmldata.get("result_msg"));
                resultCode.put("err_code", Xmldata.get("err_code"));
                resultCode.put("err_code_des", Xmldata.get("err_code_des"));
                orderInfoMapper.UpdatePaymentStateBYclose(orderInfo.getOrderNumber(), "Abnormal");

                paginationVo.setDataResultObj(resultCode);


                paginationVo.setHtmlState("Error:");

            }


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            paginationVo.setHtmlState("Error");
        }


        return paginationVo;

    }


    /*--------------- -----<----*微信支付结果回调处理*---->--- ----------------------*/
    public String Payresponse(String PayResponse) {
     /*   System.out.print(PayResponse);*/


        if (!PayResponse.toString().equals("")) {
            Thread t = new Thread(new Runnable() {

                public void run() {

                    XmlUtil xmlUtil = new XmlUtil();
                    try {
                        Map<String, String> Xmldata = xmlUtil.XmlAnalysis(PayResponse);
                        try {

                            WechatPayResult wechatPayResult = JSONObject.parseObject(JSON.toJSONString(Xmldata), WechatPayResult.class);

                            List<OrderInfo> OrderInfoData = orderInfoMapper.SelectAllInfoByNumber(wechatPayResult.getOutTradeNo(), wechatPayResult.getOpenid());

                            if (OrderInfoData.size() <= 0) {

                                int i = orderInfoMapper.UpdatePaymentStateBYclose(wechatPayResult.getOutTradeNo(), "Abnormal");
                                if (i == 0) {
                                    OrderInfo errorinfo = new OrderInfo();
                                    errorinfo.setPaymentState("Error:未生成的系统订单");
                                    errorinfo.setOrderNumber(cchuaTool.getOrderNumber(0, 0));
                                    errorinfo.setWechatPayResult(PayResponse);
/*这里偷懒没写的transaction_id*/
                                    orderInfoMapper.insertSelective(errorinfo);
                                }

                            } else {
                                if (wechatPayResult.getTotalFee() == OrderInfoData.get(0).getPaymentAmount()) {

                                    orderInfoMapper.
                                            UpdatePaymentState(wechatPayResult.getOutTradeNo(),
                                                    "Success", PayResponse,
                                                    Xmldata.get("transaction_id"));

                                    String AccessToken = weChatFunctionService.ObtainAccessToken(AppId, AppSecret);

                                    if (AccessToken.equals("Error")) {


                                    } else {

                                        String OrderAddress = orderInfoMapper.
                                                SelectByOrderNumber(Integer.valueOf(Xmldata.get("out_trade_no"))).getOrderAddress();
                                        List<OrderCommodity> comm = orderCommodityMapper.SelectByNumber(Integer.valueOf(Xmldata.get("out_trade_no")));
                                        String FirstCommTitle = commodityInfoDetailsMapper.SelectCByNumberObj(comm.get(0).getCommodityNumber()).get(0).getTitle();

                                        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + AccessToken;

                                        HttpHeaders headers = new HttpHeaders();
                                        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
                                        headers.setContentType(type);
                                        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

                                        String tid = "56X2n1Ee0J26LVQ4G7RRRNbphd762YFBRxJFU_NH9-k";
                                        String orderdatainfo = "Igo商城微信支付订单";
                                        String orderurl = "http://weixin.qq.com/download";

                                        /*double ordertotalfeee = Integer.valueOf(Xmldata.get("total_fee")) / 100;*/

                                    /*    Long ordertotalfeee=new Long((long)Integer.valueOf(Xmldata.get("total_fee")));*/

                                        String ordertotalfeee = AmountUtils.changeY2F(Xmldata.get("total_fee"));


                                        StringBuffer PostJson = new StringBuffer();
                                        PostJson.append("{");
                                        PostJson.append("\"touser\": \"" + Xmldata.get("openid") + "\",");
                                        PostJson.append("\"template_id\": \"" + tid + "\",");
                                        PostJson.append("\"url\": \"" + orderurl + "\",");

                                        PostJson.append("\"data\": {");
                                        PostJson.append("\"first\": {\"value\": \"您的订单已经支付成功，我们将尽快发货\",\"color\": \"#173177\"},");
                                        PostJson.append("\"keyword1\": {\"value\": \"" + ordertotalfeee + "\",\"color\": \"#173177\"},");

                                        if (comm.size() <= 1) {
                                            PostJson.append("\"keyword2\": {\"value\": \"" + FirstCommTitle + "\",\"color\": \"#173177\"},");
                                        } else {
                                            PostJson.append("\"keyword2\": {\"value\": \"" + FirstCommTitle + "等商品\",\"color\": \"#173177\"},");
                                        }


                                        PostJson.append("\"keyword3\": {\"value\": \"" + OrderAddress + "\",\"color\": \"#173177\"},");
                                        PostJson.append("\"keyword4\": {\"value\": \"" + Xmldata.get("out_trade_no") + "\",\"color\": \"#173177\"},");
                                        PostJson.append("\"remark\": {\"value\": \"您的订单已经支付成功。\",\"color\": \"#173177\"}");
                                        PostJson.append("}");
                                        PostJson.append("}");

                                        String result = HttpUtil.doPostSSL(url, PostJson.toString());


                                    }






                               /*int a =  wechatPayResultMapper.insertSelective(wechatPayResult);
                                System.out.println(a);*/

                                } else {
                                    orderInfoMapper.UpdatePaymentState(wechatPayResult.getOutTradeNo(), "Abnormal", PayResponse, Xmldata.get("transaction_id"));
                                }

                            }
                        } catch (Exception e) {
                            OrderInfo errorinfo = new OrderInfo();
                            errorinfo.setPaymentState("Error:未生成的系统订单");
                            errorinfo.setOrderNumber(cchuaTool.getOrderNumber(0, 0));
                            errorinfo.setWechatPayResult(PayResponse);
/*这里偷懒没写的transaction_id*/
                            orderInfoMapper.insertSelective(errorinfo);
                        }


                    } catch (
                            ParserConfigurationException e)

                    {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }


        String returnWXresult = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";

        return returnWXresult;

    }








    /*--------------- -----<----*其他*---->--- ----------------------*/


    /*--------------- -----<----*支付测试*---->--- ----------------------*/
    public PaginationVo GenerateOrder(String GenerateOrder) {


        OrderRequest json = JSONObject.parseObject(GenerateOrder, OrderRequest.class);

        String OrderNumber = String.valueOf(cchuaTool.getOrderNumber(11, 2));

        json.setAppid(AppId);
        json.setAttach("支付测试");
        json.setBody("JSAPI支付测试");
        json.setMchId(MchId);


        json.setNonceStr(cchuaTool.henuuid());
       /*商品详情	单品优惠字段(暂未上线)*/
        json.setDetail("");
/*通知地址*/
        json.setNotifyUrl("http://igo.vrdete.com/api/wechat/pay/payresponse");
      /*  json.setOpenid("oUpF8uMuAJO_M2pxb1Q9zNjWeS6o");*/
        json.setDeviceInfo("WEB");
        /*商户订单号*/
        json.setOutTradeNo(OrderNumber);

        json.setSpbillCreateIp("58.250.198.81");
       /*支付价钱*/
        json.setTotalFee(1);

        json.setTradeType("JSAPI");

/*-----------------《----以下进行Sign加密----》----------------*/
        SortedMap<String, String> parameters = new TreeMap<String, String>();
        parameters.put("appid", json.getAppid());
        parameters.put("attach", json.getAttach());
        parameters.put("body", json.getBody());
        parameters.put("device_info", json.getDeviceInfo());
        parameters.put("mch_id", json.getMchId());
        parameters.put("nonce_str", json.getNonceStr());
        parameters.put("notify_url", json.getNotifyUrl());
        parameters.put("openid", json.getOpenid());
        parameters.put("out_trade_no", json.getOutTradeNo());// 用户订单号
        parameters.put("spbill_create_ip", json.getSpbillCreateIp());// 电脑测试
        parameters.put("total_fee", String.valueOf(json.getTotalFee()));// 标价金额（分）*/
        // parameters.put("spbill_create_ip",IpAddressUtil.getIpAddr(request));
        // parameters.put("spbill_create_ip",NetworkUtil.getIpAddress(request));

        parameters.put("trade_type", "JSAPI");

        String KeysignStr = MD5Util.getWXPayMD5(parameters, apiKey);

        System.out.print(KeysignStr + "\n");

        json.setSign(KeysignStr);
/*-----------------《----得到加密好的Sign----》----------------*/

/*-----------------《----进行第一次生成订单访问----》----------------*/
        String preOrderXml =
                "<xml>"
                        + "<appid>" + json.getAppid() + "</appid>"
                        + "<attach>" + "<![CDATA[" + json.getAttach() + "]]></attach>"
                        + "<body><![CDATA[" + json.getBody() + "]]></body>"
                        + "<device_info>WEB</device_info>"
                        + "<mch_id>" + json.getMchId() + "</mch_id>"
                        + "<nonce_str>" + json.getNonceStr() + "</nonce_str>"
                        + "<notify_url>" + json.getNotifyUrl() + "</notify_url>"
                        + "<openid>" + json.getOpenid() + "</openid>"
                        + "<out_trade_no>" + json.getOutTradeNo() + "</out_trade_no>"
                        + "<spbill_create_ip>" + json.getSpbillCreateIp() + "</spbill_create_ip>"
                        + "<total_fee>" + json.getTotalFee() + "</total_fee>"
                        + "<trade_type>" + json.getTradeType() + "</trade_type>"
                        + "<sign>" + json.getSign() + "</sign>"
                        + "</xml>";

        String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";

      /*  RestTemplate restTemplate = new RestTemplate();*/
     /*   String result = restOperations.postForObject(url, formEntity, String.class);*/
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(preOrderXml, headers);
        String result = HttpUtil.doPostSSL(url, preOrderXml);


/*-----------------《----进行第一次生成订单访问成功 得到微信生成的支付订单信息----》----------------*/

/*-----------------《----将回调回来的订单信息进行解析----》----------------*/

        XmlUtil xmlUtil = new XmlUtil();
        try {
            Map<String, String> Xmldata = xmlUtil.XmlAnalysis(result);


            String theTimestamp = DateUtil.getTimeStamp();

            SortedMap<String, String> thePaySign = new TreeMap<String, String>();

            /*-----------------《----生成PaySigin----》----------------*/
            String PaynonceStr = cchuaTool.henuuid();
            thePaySign.put("appId", AppId);
            thePaySign.put("timeStamp", theTimestamp);
            thePaySign.put("nonceStr", PaynonceStr);
            thePaySign.put("package", "prepay_id=" + Xmldata.get("prepay_id"));
            thePaySign.put("signType", "MD5");
            String PaySigin = MD5Util.getWXPayMD5(thePaySign, apiKey);

           /*-----------------《----将支付信息打包 回调给前端----》----------------*/
            WechatOrderPayApi PayApi = new WechatOrderPayApi();
            PayApi.setAppId(AppId);
            PayApi.setTimeStamp(theTimestamp);
            PayApi.setNonceStr(PaynonceStr);
            PayApi.setPrepayId("prepay_id=" + Xmldata.get("prepay_id"));
            PayApi.setPaySign(PaySigin);

            System.out.print("PaySigin:" + PaySigin + "\n" + result + "\n");


            paginationVo.setDataResultObj(PayApi);


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }


        return paginationVo;

    }

    /*--------------- -----<----*支付测试*---->--- ----------------------*/
    public PaginationVo GenerateOrderTest(String GenerateOrder) {


        OrderRequest json = JSONObject.parseObject(GenerateOrder, OrderRequest.class);

        String OrderNumber = String.valueOf(cchuaTool.getOrderNumber(11, 2));

        json.setAppid(AppId);
        json.setAttach("支付测试");
        json.setBody("JSAPI支付测试");
        json.setMchId(MchId);


        json.setNonceStr(cchuaTool.henuuid());
       /*商品详情	单品优惠字段(暂未上线)*/
        json.setDetail("");
/*通知地址*/
        json.setNotifyUrl("http://igo.vrdete.com/api/wechat/pay/payresponse");
      /*  json.setOpenid("oUpF8uMuAJO_M2pxb1Q9zNjWeS6o");*/
        json.setDeviceInfo("WEB");
        /*商户订单号*/
        json.setOutTradeNo(OrderNumber);

        json.setSpbillCreateIp("58.250.198.81");
       /*支付价钱*/
        json.setTotalFee(1);

        json.setTradeType("JSAPI");

/*-----------------《----以下进行Sign加密----》----------------*/
        SortedMap<String, String> parameters = new TreeMap<String, String>();
        parameters.put("appid", json.getAppid());
        parameters.put("attach", json.getAttach());
        parameters.put("body", json.getBody());
        parameters.put("device_info", json.getDeviceInfo());
        parameters.put("mch_id", json.getMchId());
        parameters.put("nonce_str", json.getNonceStr());
        parameters.put("notify_url", json.getNotifyUrl());
        parameters.put("openid", json.getOpenid());
        parameters.put("out_trade_no", json.getOutTradeNo());// 用户订单号
        parameters.put("spbill_create_ip", json.getSpbillCreateIp());// 电脑测试
        parameters.put("total_fee", String.valueOf(json.getTotalFee()));// 标价金额（分）*/
        // parameters.put("spbill_create_ip",IpAddressUtil.getIpAddr(request));
        // parameters.put("spbill_create_ip",NetworkUtil.getIpAddress(request));

        parameters.put("trade_type", "JSAPI");

        String KeysignStr = MD5Util.getWXPayMD5(parameters, apiKey);

        System.out.print(KeysignStr + "\n");

        json.setSign(KeysignStr);
/*-----------------《----得到加密好的Sign----》----------------*/

/*-----------------《----进行第一次生成订单访问----》----------------*/
        String preOrderXml =
                "<xml>"
                        + "<appid>" + json.getAppid() + "</appid>"
                        + "<attach>" + "<![CDATA[" + json.getAttach() + "]]></attach>"
                        + "<body><![CDATA[" + json.getBody() + "]]></body>"
                        + "<device_info>WEB</device_info>"
                        + "<mch_id>" + json.getMchId() + "</mch_id>"
                        + "<nonce_str>" + json.getNonceStr() + "</nonce_str>"
                        + "<notify_url>" + json.getNotifyUrl() + "</notify_url>"
                        + "<openid>" + json.getOpenid() + "</openid>"
                        + "<out_trade_no>" + json.getOutTradeNo() + "</out_trade_no>"
                        + "<spbill_create_ip>" + json.getSpbillCreateIp() + "</spbill_create_ip>"
                        + "<total_fee>" + json.getTotalFee() + "</total_fee>"
                        + "<trade_type>" + json.getTradeType() + "</trade_type>"
                        + "<sign>" + json.getSign() + "</sign>"
                        + "</xml>";

        String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";

      /*  RestTemplate restTemplate = new RestTemplate();*/
     /*   String result = restOperations.postForObject(url, formEntity, String.class);*/
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(preOrderXml, headers);
        String result = HttpUtil.doPostSSL(url, preOrderXml);


/*-----------------《----进行第一次生成订单访问成功 得到微信生成的支付订单信息----》----------------*/

/*-----------------《----将回调回来的订单信息进行解析----》----------------*/

        XmlUtil xmlUtil = new XmlUtil();
        try {
            Map<String, String> Xmldata = xmlUtil.XmlAnalysis(result);


            String theTimestamp = DateUtil.getTimeStamp();

            SortedMap<String, String> thePaySign = new TreeMap<String, String>();

            /*-----------------《----生成PaySigin----》----------------*/
            String PaynonceStr = cchuaTool.henuuid();
            thePaySign.put("appId", AppId);
            thePaySign.put("timeStamp", theTimestamp);
            thePaySign.put("nonceStr", PaynonceStr);
            thePaySign.put("package", "prepay_id=" + Xmldata.get("prepay_id"));
            thePaySign.put("signType", "MD5");
            String PaySigin = MD5Util.getWXPayMD5(thePaySign, apiKey);

           /*-----------------《----将支付信息打包 回调给前端----》----------------*/
            WechatOrderPayApi PayApi = new WechatOrderPayApi();
            PayApi.setAppId(AppId);
            PayApi.setTimeStamp(theTimestamp);
            PayApi.setNonceStr(PaynonceStr);
            PayApi.setPrepayId("prepay_id=" + Xmldata.get("prepay_id"));
            PayApi.setPaySign(PaySigin);

            System.out.print("PaySigin:" + PaySigin + "\n" + result + "\n");


            paginationVo.setDataResultObj(PayApi);


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }


        return paginationVo;

    }


}












