package com.cchuaspace.system.service;

import com.alibaba.fastjson.JSONObject;
import com.cchuaspace.mapper.CommodityCatalogMapper;
import com.cchuaspace.mapper.CommunityRelativesMapper;
import com.cchuaspace.model.CommodityCatalog;
import com.cchuaspace.model.CommunityRelatives;
import com.cchuaspace.pojo.CommodityCatalogVo;
import com.cchuaspace.pojo.PaginationVo;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

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
@Scope("prototype")
public class SysCommodityCatalogService {

    @Autowired
    private CommodityCatalogMapper commodityCatalogMapper;

    @Autowired
    private CommunityRelativesMapper communityRelativesMapper;

    @Autowired
    private PaginationVo paginationVo;

    @Autowired
    private CommodityCatalogVo commodityCatalogVo;

    /*--------------- -----<----*查询*---->--- ----------------------*/
    public PaginationVo SelectCatalog(@RequestBody String commodityInfo, Model model) {

        CommodityCatalog json = JSONObject.parseObject(commodityInfo, CommodityCatalog.class);

        List<CommodityCatalogVo> data = commodityCatalogMapper.SelectCatalogs(json);

        for (int a = 0; a < data.size(); a++) {
            List<CommodityCatalog> datas = commodityCatalogMapper.SelectByParents(data.get(a).getCatalogId());

            if (datas.size() <= 0) {
                data.get(a).setClassifySon("false");
            } else {
                data.get(a).setClassifySon("true");
            }
        }
        paginationVo.setHtmlState("Success");
        paginationVo.setDataResultList(data);

        return paginationVo;

    }


    public PaginationVo selectallcatalog() {


        List<CommodityCatalog> data = commodityCatalogMapper.selectallcatalog();

        paginationVo.setHtmlState("Success");
        paginationVo.setDataResultList(data);

        return paginationVo;

    }


    public PaginationVo SelectClassifyProduct(@RequestBody String commodityInfo, Model model) {

		/*
         * List<CommodityCatalog> json = JSON.parseObject(commodityInfo,
		 * CommodityCatalog.class);
		 */

        CommodityCatalog json = JSONObject.parseObject(commodityInfo, CommodityCatalog.class);

        List<CommodityCatalog> data = commodityCatalogMapper.SelectCatalog(json);

        CommunityRelatives asdsa = communityRelativesMapper.SelectByparentsIds(data.get(0).getParentsId());

        try {
            PropertyUtils.copyProperties(commodityCatalogVo, data);
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        commodityCatalogVo.getDataResultList().get(0);

		/* commodityCatalogVo.setDataResultList(data); */

		/* paginationVo.setDataResultList(data); */

        return paginationVo;

    }

    /*--------------- -----<----*删除*---->--- ----------------------*/
    public PaginationVo DeleteByCommodity(@RequestBody String CommodityInfo, Model model) {
		/*
		 * List<CommodityCatalog> json = JSON.parseArray(CommodityInfo,
		 * CommodityCatalog.class);
		 */
        CommodityCatalog json = JSONObject.parseObject(CommodityInfo, CommodityCatalog.class);

        int tostate = commodityCatalogMapper.DeleteCatalog(json);

        if (tostate != 0)
            paginationVo.setHtmlState("Success");
        else
            paginationVo.setHtmlState("Error");

        paginationVo.setDataResultObj(json);

        return paginationVo;

    }

    public PaginationVo DeleteCatalogById(@RequestBody String CommodityInfo, Model model) {

        CommodityCatalog json = JSONObject.parseObject(CommodityInfo, CommodityCatalog.class);

        int tostate = commodityCatalogMapper.DeleteCatalogById(json);

        if (tostate != 0)
            paginationVo.setHtmlState("Success");
        else
            paginationVo.setHtmlState("Error");

        paginationVo.setDataResultObj(json);

        return paginationVo;

    }

	/*--------------- -----<----*增加*---->--- ----------------------*/

    public PaginationVo InsertCommodityInfo(@RequestBody String CommodityInfo, Model model) {

        CommodityCatalog json = JSONObject.parseObject(CommodityInfo, CommodityCatalog.class);

        json.setCatalogId(uuid());
        int user = commodityCatalogMapper.InsertCommodityInfo(json);
        paginationVo.setDataResultObj(json);

        return paginationVo;

    }

    /*--------------- -----<----*修改*---->--- ----------------------*/
    public PaginationVo UpdateCatalog(@RequestBody String CommodityInfo, Model model) {

        CommodityCatalog json = JSONObject.parseObject(CommodityInfo, CommodityCatalog.class);

        int tostate = commodityCatalogMapper.UpdateCatalog(json);

        if (tostate != 0)
            paginationVo.setHtmlState("Success");
        else
            paginationVo.setHtmlState("Error");

        paginationVo.setDataResultObj(json);

        return paginationVo;

    }

    private String uuid() {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);

        return uuid;
    }

}
