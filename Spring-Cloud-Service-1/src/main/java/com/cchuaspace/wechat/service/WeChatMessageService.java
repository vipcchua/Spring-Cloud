package com.cchuaspace.wechat.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cchuaspace.currency.CchuaTool;
import com.cchuaspace.mapper.CustomerInfoMapper;
import com.cchuaspace.mapper.OrderInfoMapper;
import com.cchuaspace.mapper.WechatPayResultMapper;
import com.cchuaspace.model.OrderInfo;
import com.cchuaspace.model.WechatPayResult;
import com.cchuaspace.pojo.OrderInfoVo;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.wechat.model.OrderRequest;
import com.cchuaspace.wechat.model.WechatOrderPayApi;
import com.cchuaspace.wechat.tool.DateUtil;
import com.cchuaspace.wechat.tool.HttpUtil;
import com.cchuaspace.wechat.tool.MD5Util;
import com.cchuaspace.wechat.tool.XmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.*;

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
public class WeChatMessageService {
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

    public PaginationVo SetUp(String info) {


        String AccessToken = weChatFunctionService.ObtainAccessToken(AppId, AppSecret);
        if (AccessToken == "Error") {
            paginationVo.setHtmlState("Error:Redis失去连接");
            return paginationVo;
        } else {

            String url = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=" + AccessToken;

            HttpHeaders headers = new HttpHeaders();
            MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
            headers.setContentType(type);
            headers.add("Accept", MediaType.APPLICATION_JSON.toString());

            HttpEntity<String> formEntity = new HttpEntity<String>(info, headers);

            String result = HttpUtil.doPostSSL(url, info);
            System.out.println(result);
            paginationVo.setDataResultObj(result);
            paginationVo.setHtmlState("Success");
            return paginationVo;
        }

    }

    public PaginationVo SelectSetUp(String generateOrder) {


        String AccessToken = weChatFunctionService.ObtainAccessToken(AppId, AppSecret);
        if (AccessToken == "Error") {
            paginationVo.setHtmlState("Error:Redis失去连接");
            return paginationVo;
        } else {

            String url = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=" + AccessToken;


            String result = HttpUtil.doGet(url);
            System.out.println(result);
            paginationVo.setDataResultObj(result);
            paginationVo.setHtmlState("Success");
            return paginationVo;
        }
    }

    public PaginationVo SelectTmp() {
        String AccessToken = weChatFunctionService.ObtainAccessToken(AppId, AppSecret);
        if (AccessToken == "Error") {
            paginationVo.setHtmlState("Error:Redis失去连接");
            return paginationVo;
        } else {

            String url = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=" + AccessToken;


            String result = HttpUtil.doGet(url);
            System.out.println(result);
            paginationVo.setDataResultObj(result);
            paginationVo.setHtmlState("Success");
            return paginationVo;
        }
    }

    public PaginationVo SelectTmpList() {
        String AccessToken = weChatFunctionService.ObtainAccessToken(AppId, AppSecret);
        if (AccessToken == "Error") {
            paginationVo.setHtmlState("Error:Redis失去连接");
            return paginationVo;
        } else {

            String url = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=" + AccessToken;


            String result = HttpUtil.doGet(url);
            System.out.println(result);
            paginationVo.setDataResultObj(result);
            paginationVo.setHtmlState("Success");
            return paginationVo;
        }
    }

    public String test() {

        String AccessToken = weChatFunctionService.ObtainAccessToken(AppId, AppSecret);
        if (AccessToken == "Error") {


        } else {

            String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + AccessToken;

            HttpHeaders headers = new HttpHeaders();
            MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
            headers.setContentType(type);
            headers.add("Accept", MediaType.APPLICATION_JSON.toString());
            String us = "ohVtswwbUUt91j6TggGOwzh5YhIc";
            String tid = "56X2n1Ee0J26LVQ4G7RRRNbphd762YFBRxJFU_NH9-k";
            String dsadsa = "商品信息";

            StringBuffer PostJson = new StringBuffer();
            PostJson.append("{");
            PostJson.append("\"touser\": \"" + us + "\",");
            PostJson.append("\"template_id\": \"" + tid + "\",");
            PostJson.append("\"data\": {");
            PostJson.append("\"first\": {\"value\": \"您的订单已经支付成功！\",\"color\": \"#173177\"},");
            PostJson.append("\"keyword1\": {\"value\": \"" + dsadsa + "\",\"color\": \"#173177\"},");
            PostJson.append("\"keyword2\": {\"value\": \"" + dsadsa + "G\",\"color\": \"#173177\"},");
            PostJson.append("\"keyword3\": {\"value\": \"9999元\",\"color\": \"#173177\"},");
            PostJson.append("\"keyword4\": {\"value\": \"" + dsadsa + "\",\"color\": \"#173177\"},");
            PostJson.append("\"remark\": {\"value\": \"感谢您的购物！。\",\"color\": \"#173177\"}");
            PostJson.append("}");
            PostJson.append("}");

            String result = HttpUtil.doPostSSL(url, PostJson);
            return result;
        }
        return AccessToken;
    }









    /*--------------- -----<----*直接获取订单信息生成成微信订单*---->--- ----------------------*/


}












