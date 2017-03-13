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

import org.apache.ibatis.annotations.*;

import com.cchuaspace.model.CommodityCatalog;
import com.cchuaspace.model.CommodityCatalogSql;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.CommodityInfoSql;
import com.cchuaspace.model.CommunityRelatives;
import com.cchuaspace.model.CommunityRelativesSql;
import com.cchuaspace.model.TableUser;
import com.cchuaspace.model.TableUserSql;

@Mapper

public interface CommunityRelativesMapper {
	/*--------------- -----<----*查询*---->--- ----------------------*/

	@Select("SELECT * FROM community_relatives where parents_id = #{parentsId} AND depth = #{depth}")
	/* + " AND commodity_catalog.parents_id = #{parentsId}" */

	public CommunityRelatives SelectByparentsId(@Param("parentsId") String parentsId, @Param("depth") int depth);

	@Select("SELECT * FROM community_relatives where parents_id = #{parentsId} AND depth = #{depth}")
	/* + " AND commodity_catalog.parents_id = #{parentsId}" */

	public List<CommunityRelatives> SelectByparentsIdList(@Param("parentsId") String parentsId,
			@Param("depth") int depth);

	@Select("SELECT * FROM community_relatives where parents_id = #{parentsId} ")
	/* + " AND commodity_catalog.parents_id = #{parentsId}" */

	public CommunityRelatives SelectByparentsIds(@Param("parentsId") String parentsId);

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