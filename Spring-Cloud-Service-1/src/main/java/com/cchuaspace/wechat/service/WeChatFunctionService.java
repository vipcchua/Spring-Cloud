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
public class WeChatFunctionService {
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

    public String ObtainAccessToken(String AppId, String AppSecret) {

        try {
            Long accessTokenTime = stringRedisTemplate.getExpire(AppId + "_AccessToken");

            if (accessTokenTime < 20) {

                Map<String, Object> uriVariables = new HashMap<String, Object>();
                uriVariables.put("grant_type", "client_credential");
                uriVariables.put("appid", AppId);
                uriVariables.put("secret", AppSecret);

                String url = "https://api.weixin.qq.com/cgi-bin/token";

                HttpHeaders headers = new HttpHeaders();
                MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
                headers.setContentType(type);
                headers.add("Accept", MediaType.APPLICATION_JSON.toString());

                String result = HttpUtil.doGet(url, uriVariables);

                JSONObject tokenjson = JSON.parseObject(result);
                tokenjson.get("access_token");

                stringRedisTemplate.opsForValue().set(AppId + "_AccessToken", tokenjson.get("access_token").toString(),
                        7200, TimeUnit.SECONDS);
				/*
				 * {"access_token":"7fJBiFWK","expires_in":7200}
				 * {"errcode":0,"errmsg":"ok"}
				 */

                return tokenjson.get("access_token").toString();

            } else {
                String accessToken = stringRedisTemplate.opsForValue().get(AppId + "_AccessToken");
                return accessToken;
            }

        } catch (Exception e) {
            return "Error";
        }

    }

	/*--------------- -----<----*查询*---->--- ----------------------*/

	/*--------------- -----<----*删除*---->--- ----------------------*/

	/*--------------- -----<----*增加*---->--- ----------------------*/

	/*--------------- -----<----*修改*---->--- ----------------------*/

}
