package com.cchuaspace.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cchuaspace.mapper.CommodityInfoDetailsMapper;
import com.cchuaspace.mapper.CommodityInfoMapper;
import com.cchuaspace.mapper.CommunityRelativesMapper;
import com.cchuaspace.mapper.OrderCommodityMapper;
import com.cchuaspace.mapper.SysCommodityPriceMapper;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.CommodityInfoDetails;
import com.cchuaspace.model.CommunityRelatives;
import com.cchuaspace.model.OrderInfo;
import com.cchuaspace.model.SysCommodityPrice;
import com.cchuaspace.pojo.CommodityCatalogVo;
import com.cchuaspace.pojo.CommodityInfoDetailsVo;
import com.cchuaspace.pojo.CommodityInfoVo;
import com.cchuaspace.pojo.CommunityRelativesVo;
import com.cchuaspace.pojo.PaginationVo;

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
public class CommunityRelativesService {

    @Autowired
    private CommunityRelativesMapper communityRelativesMapper;

    @Autowired
    private CommodityInfoMapper commodityInfoMapper;

    @Autowired
    private SysCommodityPriceMapper sysCommodityPriceMapper;

    @Autowired
    private CommodityInfoDetailsMapper commodityInfoDetailsMapper;

    @Autowired
    private PaginationVo paginationVo;

	/*--------------- -----<----*查询*---->--- ----------------------*/

    public PaginationVo selectallbyparents(String data) {

        CommunityRelativesVo json = JSONObject.parseObject(data, CommunityRelativesVo.class);


        List<CommodityInfoDetails> infodata = communityRelativesMapper.SelectByParentsInfo(json);

        paginationVo.setDataResultList(infodata);


        paginationVo.setHtmlState("Success");

        return paginationVo;

    }

    public PaginationVo selectallbyparentjs(String data) {

        CommunityRelativesVo json = JSONObject.parseObject(data, CommunityRelativesVo.class);
        String sort = json.getTosort();

        if (sort.toLowerCase().equals("desc") || sort.toLowerCase().equals("asc")) {
            List<CommunityRelatives> infodata = communityRelativesMapper.SelectByparents(json);

            List<CommodityInfoVo> list = new ArrayList<CommodityInfoVo>();

            int shelfState = 1;
            for (int a = 0; a < infodata.size(); a++) {
                CommodityInfoVo datas = commodityInfoMapper
                        .SelectCommodityByNumberObjVo(infodata.get(a).getCommodityNumber());

                List<CommodityInfoDetailsVo> cinfodetails = commodityInfoDetailsMapper
                        .SelectCByNumberListVo(infodata.get(a).getCommodityNumber(), shelfState);

                if (cinfodetails.size() <= 0) {
                    JSONObject dataerror = new JSONObject();
                    dataerror.put("DetailsInfo", "Error-该商品未有上架信息");
                    datas.getCommodityInfoDetailsVo().get(0).setDataResultObj(dataerror);

                } else {
                    datas.setCommodityInfoDetailsVo(cinfodetails);

                    List<SysCommodityPrice> dataResultObj = sysCommodityPriceMapper
                            .SelectpresentByNumber(datas.getCommodityNumber());

                    if (dataResultObj.size() <= 0) {
                        JSONObject dataerror = new JSONObject();
                        dataerror.put("Price", "Error-该商品未定价");
                        datas.getCommodityInfoDetailsVo().get(0).setDataResultObj(dataerror);
                    } else {
                        datas.getCommodityInfoDetailsVo().get(0).setDataResultObj(dataResultObj);
                    }

                }

                list.add(datas);

            }

            paginationVo.setHtmlState("Success");
            paginationVo.setDataResultList(list);
            return paginationVo;
        } else {
            System.out.println("黑客,你妈妈喊你回家吃饭");
            return paginationVo;
        }

    }

}
