package com.CchuaSpace.Mapper;

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

import com.CchuaSpace.Model.CommodityCatalog;
import com.CchuaSpace.Model.CommodityCatalogSql;
import com.CchuaSpace.Model.CommodityInfo;
import com.CchuaSpace.Model.CommodityInfoSql;
import com.CchuaSpace.Model.CommunityRelatives;
import com.CchuaSpace.Model.CommunityRelativesSql;
import com.CchuaSpace.Model.TableUser;
import com.CchuaSpace.Model.TableUserSql;






@Mapper

public interface CommunityRelativesMapper {
	/*--------------- -----<----*查询*---->--- ----------------------*/
	
	@Select("SELECT * FROM community_relatives where parents_id = #{parentsId}")
			/*+ " AND commodity_catalog.parents_id = #{parentsId}"*/
			
	public List<CommunityRelatives> SelectByparentsId(CommunityRelatives communityRelatives);
	

	@Select("SELECT * FROM community_relatives where commodity_number = #{commodityNumber}")
	/*+ " AND commodity_catalog.parents_id = #{parentsId}"*/
	public List<CommunityRelatives> SelectByCommodityNumber(CommunityRelatives communityRelatives);



	@Select("SELECT * FROM community_relatives where"
			+ " commodity_number = #{commodityNumber} And parents_id = #{parentsId}")
	/*+ " AND commodity_catalog.parents_id = #{parentsId}"*/
	public List<CommunityRelatives> SelectByprcn(CommunityRelatives communityRelatives);


	
	
	
	/*--------------- -----<----*增加*---->--- ----------------------*/


	
	@InsertProvider(type = CommunityRelativesSql.class, method = "InsertCommunityRelatives")  
	public List<CommunityRelatives> InsertCommunityRelatives(CommunityRelatives communityRelatives);
	
	
	
	
	/*--------------- -----<----*删除*---->--- ----------------------*/

	@Delete("Delete FROM community_relatives where parents_id = #{parentsId}"
			+ " AND community_relatives.commodity_number = #{commodityNumber}")
	int DeleteCatalog(CommunityRelatives communityRelatives);
	

	
	
	@Delete("Delete FROM community_relatives where id = #{Id}")
	int DeleteCatalogById(CommunityRelatives communityRelatives);
	
	
		
	/*--------------- -----<----*修改*---->--- ----------------------*/



	@Update("UPDATE community_relatives SET community_relatives.parents_id = #{parentsId} "
			+ "Where community_relatives.commodity_number = #{commodityNumber}"
			)
	int UpdateCatalog(CommunityRelatives communityRelatives);
	
	

	
	
	
	
	
}