package com.cchuaspace.wechat.controller;

import com.cchuaspace.Application;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.OrderInfo;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.wechat.service.WeChatMenuService;
import com.cchuaspace.wechat.service.WeChatPayService;
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
@RequestMapping(value = "/api/wechat/menu")
@Api(value = "微信登陆的相关操作", description = "微信登陆的相关操作")

public class WeChatMenuController {

    private static SqlSessionFactory sqlSessionFactory;
	/* private Logger logger = Logger.getLogger(TableInfoController.class); */

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private WeChatMenuService weChatMenuService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private Application computeServiceApplication;
    String AppId = "wx253b97a570d99ccc";
    String AppSecret = "3c91bb1f519ad2604e78b7115deec5a5";

	/*--------------- -----<----*生单*---->--- ----------------------*/

    @ApiOperation(value = "建菜单", notes = "建菜单", response = CommodityInfo.class)
    @ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commodityNumber", value = "请输入商品编码", required = true, dataType = "varchar"), })

    @RequestMapping(value = "/create", method = { RequestMethod.POST })
    @ResponseBody

    public ResponseEntity<PaginationVo> WechatRefund(@RequestBody String GenerateOrder) {

        PaginationVo user = weChatMenuService.MenuCreate(GenerateOrder);

        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
        return data;

    }

    @RequestMapping(value = "/selectmenu")
    @ResponseBody

    public ResponseEntity<PaginationVo> SelectMenu() {

        PaginationVo user = weChatMenuService.SelectMenu();

        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
        return data;

    }

    @RequestMapping(value = "/delmenu")
    @ResponseBody

    public ResponseEntity<PaginationVo> Delmenu() {

        PaginationVo user = weChatMenuService.DelMenu();

        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
        return data;

    }


	/*--------------- -----<----*个性化菜单*---->--- ----------------------*/







    @ApiOperation(value = "建个性菜单", notes = "建菜单", response = CommodityInfo.class)
    @ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commodityNumber", value = "请输入商品编码", required = true, dataType = "varchar"), })

    @RequestMapping(value = "/charactercreate", method = { RequestMethod.POST })
    @ResponseBody

    public ResponseEntity<PaginationVo> CharacterRefund(@RequestBody String GenerateOrder) {

        PaginationVo user = weChatMenuService.CharacterRefund(GenerateOrder);

        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
        return data;

    }









}
