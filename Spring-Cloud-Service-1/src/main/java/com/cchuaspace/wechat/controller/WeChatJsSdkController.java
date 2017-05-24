package com.cchuaspace.wechat.controller;

import com.cchuaspace.Application;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.wechat.service.WeChatJsSdkService;
import com.cchuaspace.wechat.service.WeChatMenuService;
import io.swagger.annotations.*;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * http://localhost:8080//hhh?name=d62&age=23
 */
@Controller
@RestController
@Scope("prototype")
@RequestMapping(value = "/api/wechat/jssdk")
@Api(value = "微信登陆的相关操作", description = "微信登陆的相关操作")

public class WeChatJsSdkController {



    @Autowired
    private WeChatJsSdkService weChatJsSdkService;



	/*--------------- -----<----*生单*---->--- ----------------------*/

    @ApiOperation(value = "建菜单", notes = "建菜单", response = CommodityInfo.class)
    @ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commodityNumber", value = "请输入商品编码", required = true, dataType = "varchar"), })

    @RequestMapping(value = "/config", method = { RequestMethod.GET })
    @ResponseBody

    public ResponseEntity<PaginationVo> wechatConfig() {

        PaginationVo user = weChatJsSdkService.wechatConfig();

        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
        return data;

    }










}
