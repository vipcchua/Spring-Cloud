package com.cchuaspace.wechat.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cchuaspace.currency.CchuaTool;
import com.cchuaspace.mapper.CustomerInfoMapper;
import com.cchuaspace.model.CustomerInfo;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.pojo.WechatVo;
import com.cchuaspace.wechat.tool.AesException;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class WeChatMenuService {
	/*
	 * @Autowired private PaginationVo paginationVo;
	 */

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RestOperations restOperations;

    @Autowired
    private CustomerInfoMapper customerInfoMapper;

    @Autowired
    private PaginationVo paginationVo;

    @Autowired
    private WeChatFunctionService weChatFunctionService;

    String AppId = "wx253b97a570d99ccc";
    String AppSecret = "3c91bb1f519ad2604e78b7115deec5a5";

    /*--------------- -----<----*查询*---->--- ----------------------*/
    public PaginationVo SelectMenu() {
        String AccessToken = weChatFunctionService.ObtainAccessToken(AppId, AppSecret);
        if (AccessToken == "Error") {
            paginationVo.setHtmlState("Error:Redis失去连接");
            return paginationVo;
        } else {

            Map<String, Object> uriVariables = new HashMap<String, Object>();

            uriVariables.put("access_token",AccessToken);

            String url = "https://api.weixin.qq.com/cgi-bin/menu/get";

            HttpHeaders headers = new HttpHeaders();
            MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
            headers.setContentType(type);
            headers.add("Accept", MediaType.APPLICATION_JSON.toString());

            String result = HttpUtil.doGet(url, uriVariables);

            paginationVo.setDataResultObj(result);

            return paginationVo;
        }
    }
    /*--------------- -----<----*删除*---->--- ----------------------*/
    public PaginationVo DelMenu() {
        String AccessToken = weChatFunctionService.ObtainAccessToken(AppId, AppSecret);
        if (AccessToken == "Error") {
            paginationVo.setHtmlState("Error:Redis失去连接");
            return paginationVo;
        } else {

            Map<String, Object> uriVariables = new HashMap<String, Object>();

            uriVariables.put("access_token",AccessToken);

            String url = "https://api.weixin.qq.com/cgi-bin/menu/delete";

            HttpHeaders headers = new HttpHeaders();
            MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
            headers.setContentType(type);
            headers.add("Accept", MediaType.APPLICATION_JSON.toString());

            String result = HttpUtil.doGet(url, uriVariables);

            paginationVo.setDataResultObj(result);

            return paginationVo;
        }
    }
    /*--------------- -----<----*增加*---->--- ----------------------*/
    public PaginationVo MenuCreate(String MenuCreate) {
        String AccessToken = weChatFunctionService.ObtainAccessToken(AppId, AppSecret);
        if (AccessToken == "Error") {
            paginationVo.setHtmlState("Error:Redis失去连接");
            return paginationVo;
        } else {

            String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + AccessToken;

            HttpHeaders headers = new HttpHeaders();
            MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
            headers.setContentType(type);
            headers.add("Accept", MediaType.APPLICATION_JSON.toString());

            HttpEntity<String> formEntity = new HttpEntity<String>(MenuCreate, headers);

            String result = HttpUtil.doPostSSL(url, MenuCreate);

            paginationVo.setHtmlState(result);
            return paginationVo;
        }

    }
	/*--------------- -----<----*个性化菜单*---->--- ----------------------*/

    /*--------------- -----<----*创建个性化菜单*---->--- ----------------------*/
    public PaginationVo CharacterRefund(String MenuCreate) {

        return paginationVo;

    }



    public PaginationVo CharacterDelMenu(String MenuCreate) {

        return paginationVo;
    }




}
