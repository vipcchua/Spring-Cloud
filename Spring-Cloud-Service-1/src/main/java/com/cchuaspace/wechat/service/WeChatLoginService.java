package com.cchuaspace.wechat.service;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.wechat.tool.AesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import com.alibaba.fastjson.JSONObject;
import com.cchuaspace.currency.CchuaTool;
import com.cchuaspace.mapper.CustomerInfoMapper;
import com.cchuaspace.model.CustomerInfo;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.pojo.WechatVo;

import com.cchuaspace.wechat.tool.AesException;

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
public class WeChatLoginService {
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

    String AppId = "wx253b97a570d99ccc";
    String AppSecret = "3c91bb1f519ad2604e78b7115deec5a5";

	/*--------------- -----<----*查询*---->--- ----------------------*/

	/*--------------- -----<----*删除*---->--- ----------------------*/

	/*--------------- -----<----*增加*---->--- ----------------------*/

	/*--------------- -----<----*修改*---->--- ----------------------*/

    public PaginationVo authorize(HttpServletRequest request, HttpServletResponse response) {

		/*
		 * PaginationVo paginationVo = new PaginationVo();
		 */
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("AppId", AppId);

        paginationVo.setDataResultObj(jsonObject);

        return paginationVo;

    }

    public PaginationVo postwcode(String postwcode) {

        WechatVo json = JSONObject.parseObject(postwcode, WechatVo.class);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?" + "appid={appid}&" + "secret={secret}&"
                + "code={code}&" + "grant_type={granttype}";

        Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("appid", AppId);
        uriVariables.put("secret", AppSecret);
        uriVariables.put("code", json.getCode());
        uriVariables.put("granttype", "authorization_code");

        String result = restOperations.getForObject(url, String.class, uriVariables);
		/* 保留用户返回openid到数据库 */

        json = JSONObject.parseObject(result, WechatVo.class);
        if (json.getOpenid() != null) {
            stringRedisTemplate.opsForValue().set(json.getOpenid(), result, json.getExpiresIn(), TimeUnit.SECONDS);
        }

		/*
		 * rd astoK 去拿用户数据
		 */
        if (json.getAccessToken().isEmpty()) {

            paginationVo.setErrorCode("w-10001");
            paginationVo.setErrorSolve("Code过期，请重新获取Code");
        } else {
            Map<String, Object> userinfourlvar = new HashMap<String, Object>();
            userinfourlvar.put("accessToken", json.getAccessToken());
            userinfourlvar.put("openid", json.getOpenid());
            userinfourlvar.put("language", "zh_CN");
            String userinfourl = "https://api.weixin.qq.com/sns/userinfo?access_token={accessToken}&openid={openid}&lang={language}";
            String userinforesult = restOperations.getForObject(userinfourl, String.class, userinfourlvar);

            CustomerInfo customerInfo = JSONObject.parseObject(userinforesult, CustomerInfo.class);
            paginationVo.setDataResultObj(customerInfo);

            List<CustomerInfo> useriddata =  customerInfoMapper.SelectUserid(customerInfo.getOpenId());
            paginationVo.setDataResultList(useriddata);


            List<CustomerInfo> customerInfos = customerInfoMapper.selectcustomerinfobyopid(customerInfo.getOpenId());

            if (customerInfos.size() <= 0) {
                CchuaTool cchuaTool = new CchuaTool();
                customerInfo.setId(cchuaTool.uuid());

                int tostate = customerInfoMapper.InsertCustomerInfo(customerInfo);

                if (tostate != 0)
                    if (tostate != 0)
                        paginationVo.setSqlState("Success");
                    else
                        paginationVo.setSqlState("Error");
            } else {

                int tostate = customerInfoMapper.UpdateCustomerInfo(customerInfo);

                if (tostate != 0)
                    if (tostate != 0)
                        paginationVo.setSqlState("Success");
                    else
                        paginationVo.setSqlState("Error");
            }

        }

        paginationVo.setHtmlState("Success");
        return paginationVo;
    }

    /* 刷新access_token */
    public PaginationVo refreshtoken(String communityRelatives) {

        WechatVo json = JSONObject.parseObject(communityRelatives, WechatVo.class);
        String accessToken = stringRedisTemplate.opsForValue().get(json.getOpenid());
        json = JSONObject.parseObject(accessToken, WechatVo.class);

        String url = "https://api.weixin.qq.com/sns/oauth2/refresh_token?" + "appid={appid}" + "&grant_type={grantType}"
                + "&refresh_token={refreshToken}";

        Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("appid", AppId);
        uriVariables.put("grantType", "refresh_token");
        uriVariables.put("refreshToken", json.getRefreshToken());

        String result = restOperations.getForObject(url, String.class, uriVariables);

        json = JSONObject.parseObject(result, WechatVo.class);

        stringRedisTemplate.opsForValue().set(json.getOpenid(), result, json.getExpiresIn(), TimeUnit.SECONDS);

		/* paginationVo.setDataString(result); */
        paginationVo.setSqlState("Success");
        return paginationVo;
    }

    /* 刷新access_token 的方法 */
    public WechatVo refreshtokenfun(String openid) {

		/*
		 * WechatVo json = JSONObject.parseObject(openid, WechatVo.class);
		 */
        String accessToken = stringRedisTemplate.opsForValue().get(openid);

        WechatVo json = JSONObject.parseObject(accessToken, WechatVo.class);

        String url = "https://api.weixin.qq.com/sns/oauth2/refresh_token?" + "appid={appid}" + "&grant_type={grantType}"
                + "&refresh_token={refreshToken}";

        Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("appid", AppId);
        uriVariables.put("grantType", "refresh_token");
        uriVariables.put("refreshToken", json.getRefreshToken());

        String result = restOperations.getForObject(url, String.class, uriVariables);

        json = JSONObject.parseObject(result, WechatVo.class);

        stringRedisTemplate.opsForValue().set(json.getOpenid(), result, json.getExpiresIn(), TimeUnit.SECONDS);

        return json;
    }

    public PaginationVo openidata(String openid) {
        WechatVo json = JSONObject.parseObject(openid, WechatVo.class);

        try {
            Long accessTokenTime = stringRedisTemplate.getExpire(json.getOpenid());
			/* token时间不足20秒时刷新 */
            if (accessTokenTime < 20) {
                json = refreshtokenfun(json.getOpenid());
            } else {

                String accessToken = stringRedisTemplate.opsForValue().get(json.getOpenid());

                json = JSONObject.parseObject(accessToken, WechatVo.class);
            }

            Map<String, Object> userinfourlvar = new HashMap<String, Object>();
            userinfourlvar.put("accessToken", json.getAccessToken());
            userinfourlvar.put("openid", json.getOpenid());
            userinfourlvar.put("language", "zh_CN");
            String userinfourl = "https://api.weixin.qq.com/sns/userinfo?access_token={accessToken}&openid={openid}&lang={language}";
            String userinforesult = restOperations.getForObject(userinfourl, String.class, userinfourlvar);

            CustomerInfo customerInfo = JSONObject.parseObject(userinforesult, CustomerInfo.class);
            paginationVo.setDataResultObj(customerInfo);
            List<CustomerInfo> customerInfos = customerInfoMapper.selectcustomerinfobyopid(customerInfo.getOpenId());

            if (customerInfos.size() <= 0) {
                CchuaTool cchuaTool = new CchuaTool();
                customerInfo.setId(cchuaTool.uuid());

                int tostate = customerInfoMapper.InsertCustomerInfo(customerInfo);


                if (tostate != 0)
                    if (tostate != 0)
                        paginationVo.setSqlState("Success");
                    else
                        paginationVo.setSqlState("Error:数据库记录新用户数据错误");
            } else {
                int tostate = customerInfoMapper.UpdateCustomerInfo(customerInfo);
                if (tostate != 0)
                    if (tostate != 0)
                        paginationVo.setSqlState("Success");
                    else
                        paginationVo.setSqlState("Error:数据库更新新老用户数据Error");
            }

            List<CustomerInfo> useriddata =  customerInfoMapper.SelectUserid(customerInfo.getOpenId());
            paginationVo.setDataResultList(useriddata);

            paginationVo.setHtmlState("Success");
            return paginationVo;

        } catch (Exception e) {
            paginationVo.setHtmlState("Error:用户accessToken请重新过期，请重新登录或与Redis失去连接");
            return paginationVo;
        }

    }

    public PaginationVo accesstoken(String communityRelatives) {

        WechatVo json = JSONObject.parseObject(communityRelatives, WechatVo.class);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?" + "appid={appid}&" + "secret={secret}&"
                + "code={code}&" + "grant_type={grant_type}";

        Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("appid", AppId);
        uriVariables.put("secret", AppSecret);
        uriVariables.put("code", json.getCode());
        uriVariables.put("grant_type", "authorization_code");

        String result = restOperations.getForObject(url, String.class, uriVariables);
		/* 保留用户返回openid到数据库 */
		/*
		 * paginationVo.setDataString(result);
		 */
        return paginationVo;
    }

    /* 检验授权凭证（access_token）是否有效 */
    public PaginationVo examinetoken(String communityRelatives) {

        WechatVo json = JSONObject.parseObject(communityRelatives, WechatVo.class);

        String accessToken = stringRedisTemplate.opsForValue().get(json.getOpenid());

        json = JSONObject.parseObject(accessToken, WechatVo.class);

        String url = "https://api.weixin.qq.com/sns/auth?" + "access_token={access_token}" + "&openid={openid}";

        Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("access_token", json.getAccessToken());
        uriVariables.put("openid", json.getOpenid());

        String result = restOperations.getForObject(url, String.class, uriVariables);

        WechatVo resultjson = JSONObject.parseObject(result, WechatVo.class);

        paginationVo.setDataResultObj(resultjson);

        return paginationVo;
    }

    public PaginationVo userinfo(String communityRelatives) {

        WechatVo json = JSONObject.parseObject(communityRelatives, WechatVo.class);
		/*
		 * rd astoK 去拿用户数据
		 */
        String url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&" + "openid=OPENID&"
                + "lang={zh_CN}";

        Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("access_token", json.getAccessToken());
        uriVariables.put("openid", json.getOpenid());
        uriVariables.put("lang", "zh_CN");

        String result = restOperations.getForObject(url, String.class, uriVariables);
        WechatVo resultjson = JSONObject.parseObject(result, WechatVo.class);

		/* paginationVo.setDataString(result); */

        return paginationVo;
    }

    public PaginationVo UserInfoByOpenId(String commodityInfo) {
        WechatVo json = JSONObject.parseObject(commodityInfo, WechatVo.class);

        String userinfourl = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN";

        Map<String, Object> userinfourlvar = new HashMap<String, Object>();
        userinfourlvar.put("openid", json.getOpenid());
        userinfourlvar.put("lang", "zh-CN");

        String userinforesult = restOperations.postForObject(userinfourl, userinfourlvar, String.class);

        CustomerInfo customerInfo = JSONObject.parseObject(userinforesult, CustomerInfo.class);


        paginationVo.setDataResultObj(customerInfo);
        return paginationVo;
    }


    public final static String EncodingAESKey = "Tp82Rr5bREMsbKhWNc9pr7DgLTYiN7TPXDXZ80zlSmm";//公众平台上面自己填写的43位EncodingAESKey
    public final static String AppID = "wx253b97a570d99ccc";
    public final static String token = "78faf82371944fe38c4f1d99be71bc9c";

    public String wechatevent(String signature, String timestamp, String nonce, String echostr) throws AesException {

        try {
            String[] array = new String[]{token, timestamp, nonce};
            StringBuffer sb = new StringBuffer();
            // 字符串排序
            Arrays.sort(array);
            for (int i = 0; i < 4; i++) {
                sb.append(array[i]);
            }
            String str = sb.toString();
            // SHA1签名生成
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes());
            byte[] digest = md.digest();

            StringBuffer hexstr = new StringBuffer();
            String shaHex = "";
            for (int i = 0; i < digest.length; i++) {
                shaHex = Integer.toHexString(digest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexstr.append(0);
                }
                hexstr.append(shaHex);
            }
            return hexstr.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new AesException(AesException.ComputeSignatureError);
        }
    }
}

		/*return null;*/




