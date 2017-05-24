package com.cchuaspace.wechat.service;

import com.cchuaspace.mapper.CustomerInfoMapper;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.wechat.tool.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import java.util.HashMap;
import java.util.Map;

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
public class WeChatJsSdkService {
    @Autowired
    private PaginationVo paginationVo;


    String AppId = "wx253b97a570d99ccc";
    String AppSecret = "3c91bb1f519ad2604e78b7115deec5a5";
    /*商户号*/
    String MchId = "1449632602";
    /*apiKey--商户Key*/
    String apiKey = "f6f0ba3597ddb4020083b8f808314832";
    /*回调地址*/
    String NotifyUrl = "http://igo.vrdete.com/api/wechat/pay/video/payresponse";

    String pfile = "D://apiclient_cert.p12";

    public PaginationVo wechatConfig() {

return paginationVo;
    }




    /*--------------- -----<----*查询*---->--- ----------------------*/





}
