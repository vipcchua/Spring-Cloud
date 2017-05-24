package com.cchuaspace.wechat.controller;

import com.cchuaspace.Application;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.wechat.service.WeChatLoginService;
import com.cchuaspace.wechat.service.WeChatMessageService;
import com.cchuaspace.wechat.tool.AesException;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http://localhost:8080//hhh?name=d62&age=23
 */
@Controller
@RestController
@Scope("prototype")
@RequestMapping(value = "/api/wechat/message")
@Api(value = "微信登陆的相关操作", description = "微信登陆的相关操作")

public class WeChatMessageController {

    private static SqlSessionFactory sqlSessionFactory;
    /* private Logger logger = Logger.getLogger(TableInfoController.class); */

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private WeChatMessageService weChatMessageService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;



    @Resource
    private Application computeServiceApplication;
    String AppId = "wx253b97a570d99ccc";
    String AppSecret = "3c91bb1f519ad2604e78b7115deec5a5";

	/*--------------- -----<----*查询*---->--- ----------------------*/


    @ApiOperation(value = "初始化消息", notes = "初始化消息", response = CommodityInfo.class)
    @ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commodityNumber", value = "请输入商品编码", required = true, dataType = "varchar"), })

    @RequestMapping(value = "/SetUp", method = { RequestMethod.POST })
    @ResponseBody

    public ResponseEntity<PaginationVo> SetUp(@RequestBody String GenerateOrder) {

        PaginationVo user = weChatMessageService.SetUp(GenerateOrder);

        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
        return data;

    }



    @ApiOperation(value = "查询初始化消息", notes = "初始化消息", response = CommodityInfo.class)
    @ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commodityNumber", value = "请输入商品编码", required = true, dataType = "varchar"), })

    @RequestMapping(value = "/SelectSetUp", method = { RequestMethod.POST })
    @ResponseBody

    public ResponseEntity<PaginationVo> SelectSetUp(@RequestBody String GenerateOrder) {

        PaginationVo user = weChatMessageService.SelectSetUp(GenerateOrder);

        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
        return data;

    }


    @ApiOperation(value = "获取模板", notes = "获取模板", response = CommodityInfo.class)
    @ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commodityNumber", value = "请输入商品编码", required = true, dataType = "varchar"), })

    @RequestMapping(value = "/selecttmpid", method = { RequestMethod.GET })
    @ResponseBody

    public ResponseEntity<PaginationVo> SelectTmp() {

        PaginationVo user = weChatMessageService.SelectTmp();

        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
        return data;

    }

    @ApiOperation(value = "获取模板", notes = "获取模板", response = CommodityInfo.class)
    @ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commodityNumber", value = "请输入商品编码", required = true, dataType = "varchar"), })

    @RequestMapping(value = "/selecttmplist", method = { RequestMethod.GET })
    @ResponseBody

    public ResponseEntity<PaginationVo> SelectTmpList() {

        PaginationVo user = weChatMessageService.SelectTmpList();

        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
        return data;

    }


    @RequestMapping(value = "/test")
    @ResponseBody

    public String test(

    )  {

        String user = weChatMessageService.test();

        ;
        return user.toString();



    }



}


