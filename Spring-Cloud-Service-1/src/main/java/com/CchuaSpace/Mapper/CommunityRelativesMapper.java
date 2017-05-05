package com.cchuaspace.mapper;

/*
 * ****************<--*---Code information---*-->**************
 * 	
 *		Author: Cchua
 *		GitHub: https://github.com/vipcchua
 *		Blog  : weibo.com/vipcchua
 * 
 * 
 * ************************************************************/

import java.util.List;

import com.cchuaspace.model.*;
import org.apache.ibatis.annotations.*;

import com.cchuaspace.pojo.CommunityRelativesVo;

@Mapper

public interface CommunityRelativesMapper {
    /*--------------- -----<----*查询*---->--- ----------------------*/

    @Select("SELECT * FROM community_relatives where parents_id = #{parentsId}")
    /* + " AND commodity_catalog.parents_id = #{parentsId}" */

    public CommunityRelatives SelectByparentsId(@Param("parentsId") String parentsId);

    @Select("SELECT * FROM community_relatives where parents_id = #{parentsId}")
	/* + " AND commodity_catalog.parents_id = #{parentsId}" */

    public List<CommunityRelatives> SelectByparentsIdList(@Param("parentsId") int parentsId);

    @Select("SELECT * FROM community_relatives where parents_id = #{parentsId} ")
	/* + " AND commodity_catalog.parents_id = #{parentsId}" */

    public CommunityRelatives SelectByparentsIds(@Param("parentsId") int parentsId);


    @Select("SELECT * FROM community_relatives where parents_id = #{parentsId} "
    )
    public List<CommunityRelatives> SelectByparentsall(@Param("parentsId") int
                                                               parentsId);


    @Select("SELECT * FROM commodity_info_details,"
            + "(SELECT * FROM community_relatives WHERE community_relatives.parents_id = #{parentsId} )=relatives "
            + "WHERE commodity_info_details.commodity_ number=relatives.commodity_number"
            + " AND shelf_state = 1 ORDER BY present_price #{tosort} ")
    public List<CommunityRelatives> SelectByparents(CommunityRelativesVo communityRelativesVo);

    @SelectProvider(type = CommunityRelativesSql.class, method = "SelectByParentsInfo")
    public List<CommodityInfoDetails> SelectByParentsInfo(CommunityRelativesVo communityRelatives);



	/*@SelectProvider(type = CommunityRelativesSql.class, method = "SelectByparents")
	public List<CommunityRelatives> SelectByparents(CommunityRelatives communityRelatives);*/

    @Select("SELECT * FROM community_relatives where commodity_number = #{commodityNumber}")
	/* + " AND commodity_catalog.parents_id = #{parentsId}" */
    public List<CommunityRelatives> SelectByCommodityNumber(CommunityRelatives communityRelatives);

    @Select("SELECT * FROM community_relatives where"
            + " commodity_number = #{commodityNumber} And parents_id = #{parentsId}")
	/* + " AND commodity_catalog.parents_id = #{parentsId}" */
    public List<CommunityRelatives> SelectByprcn(CommunityRelatives communityRelatives);

	/*--------------- -----<----*增加*---->--- ----------------------*/

    @InsertProvider(type = CommunityRelativesSql.class, method = "InsertCommunityRelatives")
    public List<CommunityRelatives> InsertCommunityRelatives(CommunityRelatives communityRelatives);

    @InsertProvider(type = CommunityRelativesSql.class, method = "InsertCommunityRelatives")
    int InsertCommunityRelativesObj(CommunityRelatives communityRelatives);

	/*--------------- -----<----*删除*---->--- ----------------------*/

    @Delete("Delete FROM community_relatives where parents_id = #{parentsId}"
            + " AND community_relatives.commodity_number = #{commodityNumber}")
    int DeleteCatalog(CommunityRelatives communityRelatives);

    @Delete("Delete FROM community_relatives where id = #{Id}")
    int DeleteCatalogById(CommunityRelatives communityRelatives);

	/*--------------- -----<----*修改*---->--- ----------------------*/

    @Update("UPDATE community_relatives SET community_relatives.parents_id = #{parentsId} "
            + "Where community_relatives.commodity_number = #{commodityNumber}")
    int UpdateCatalog(CommunityRelatives communityRelatives);

}