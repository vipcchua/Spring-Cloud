package com.cchuaspace.system.controller;

import com.cchuaspace.Application;
import com.cchuaspace.model.CommodityCatalog;
import com.cchuaspace.pojo.PaginationVo;
import com.cchuaspace.service.CommodityCatalogService;
import com.cchuaspace.system.service.SysCommodityCatalogService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * http://localhost:8080//hhh?name=d62&age=23
 */
@Controller
@RestController
@Scope("prototype")
@RequestMapping(value = "/system/catalog")
@Api(value = "目录列表的相关操作", description = "System目录列表 commodity_catalog")

public class SysCommodityCatalogController {

    @Autowired
    private SysCommodityCatalogService commodityCatalogService;

    @Resource
    private Application computeServiceApplication;

    /*--------------- -----<----*查询*---->--- ----------------------*/
    @ApiOperation(value = "查询目录", notes = "传入深度 父亲ID 查询该深度的目录信息 如果是首层 父亲Id请使用0", response = CommodityCatalog.class)
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentsId", value = "请输入对应参数", required = true, dataType = "varchar")})

    @RequestMapping(value = "/selectcatalog", method = RequestMethod.POST)
    @ResponseBody

    public ResponseEntity<PaginationVo> SelectCatalog(@RequestBody String CommodityInfo, Model model) {

        PaginationVo user = commodityCatalogService.SelectCatalog(CommodityInfo, model);

        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

        return data;

    }


    @ApiOperation(value = "查询所有目录", notes = "查询所有目录信息", response = CommodityCatalog.class)
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @ApiImplicitParams({
    })

    @RequestMapping(value = "/selectallcatalog")
    @ResponseBody

    public ResponseEntity<PaginationVo> selectallcatalog() {

        PaginationVo user = commodityCatalogService.selectallcatalog();

        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

        return data;

    }



	/*--------------- -----<----*删除*---->--- ----------------------*/

    @ApiOperation(value = "使用3种条件使用目录中的一项", notes = "删除", response = CommodityCatalog.class)
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentsId", value = "请输入对应参数", required = true, dataType = "varchar"),
            @ApiImplicitParam(name = "nodeName", value = "请输入对应参数", required = true, dataType = "varchar"),


    })

    @RequestMapping(value = "/deletecatalog", method = RequestMethod.POST)
    @ResponseBody

    public ResponseEntity<PaginationVo> DeleteByCommodity(@RequestBody String CommodityInfo, Model model) {

        PaginationVo user = commodityCatalogService.DeleteByCommodity(CommodityInfo, model);
        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

        return data;

    }

    @ApiOperation(value = "直接使用Id删除目录中的一项", notes = "删除", response = CommodityCatalog.class)
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "catalogId", value = "请输入对应参数", required = true, dataType = "varchar"),})

    @RequestMapping(value = "/deletecatalogbyId", method = RequestMethod.POST)
    @ResponseBody

    public ResponseEntity<PaginationVo> DeleteCatalogById(@RequestBody String CommodityInfo, Model model) {

        PaginationVo user = commodityCatalogService.DeleteCatalogById(CommodityInfo, model);
        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);

        return data;

    }

	/*--------------- -----<----*增加*---->--- ----------------------*/

    @ApiOperation(value = "新增目录信息", notes = "新增目录信息", response = CommodityCatalog.class)
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentsId", value = "请输入对应信息", required = true, dataType = "varchar"),
            @ApiImplicitParam(name = "nodeName", value = "输入对应信息", required = true, dataType = "varchar")


    })

    @RequestMapping(value = "/insertcommodityinfo", method = RequestMethod.POST)
    @ResponseBody

    public ResponseEntity<PaginationVo> InsertCommodityInfo(@RequestBody String CommodityInfo, Model model) {

        PaginationVo user = commodityCatalogService.InsertCommodityInfo(CommodityInfo, model);
        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
        return data;

    }

	/*--------------- -----<----*修改*---->--- ----------------------*/

    @ApiOperation(value = "修改目录名称", notes = "修改目录名称", response = CommodityCatalog.class)
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "catalogId", value = "请输入商品编码", required = true, dataType = "varchar"),
            @ApiImplicitParam(name = "nodeName", value = "请输入商品编码", required = true, dataType = "varchar")

    })

    @RequestMapping(value = "/updatecatalog", method = RequestMethod.POST)
    @ResponseBody

    public ResponseEntity<PaginationVo> UpdateCatalog(@RequestBody String CommodityInfo, Model model) {

        PaginationVo user = commodityCatalogService.UpdateCatalog(CommodityInfo, model);
        ResponseEntity<PaginationVo> data = new ResponseEntity<PaginationVo>(user, HttpStatus.OK);
        return data;

    }

}
