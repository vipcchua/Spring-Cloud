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
import com.CchuaSpace.Model.TableUser;
import com.CchuaSpace.Model.TableUserSql;






@Mapper

public interface CommodityCatalogMapper {
	/*--------------- -----<----*查询*---->--- ----------------------*/
	
	@Select("SELECT * FROM commodity_catalog where parents_id = #{parentsId}"
			/*+ " AND commodity_catalog.parents_id = #{parentsId}"*/
			+ " AND commodity_catalog.depth = #{depth}")
	public List<CommodityCatalog> SelectCatalog(CommodityCatalog commodityCatalog);
	

	
	
	/*--------------- -----<----*增加*---->--- ----------------------*/


	
	@InsertProvider(type = CommodityCatalogSql.class, method = "InsertCommodityCatalog")  
	public List<CommodityCatalog> InsertCommodityInfo(CommodityCatalog commodityCatalog);
	
	
	
	
	/*--------------- -----<----*删除*---->--- ----------------------*/

	@Delete("Delete FROM commodity_catalog where parents_id = #{parentsId}"
			+ " AND commodity_catalog.depth = #{depth}"
			+ " And commodity_catalog.node_name = #{nodeName}")
	int DeleteCatalog(CommodityCatalog commodityCatalog);
	

	
	
	@Delete("Delete FROM commodity_catalog where catalog_id = #{catalogId}"
			)
	int DeleteCatalogById(CommodityCatalog commodityCatalog);
	
	
	
	/*--------------- -----<----*修改*---->--- ----------------------*/



	@Update("UPDATE commodity_catalog SET commodity_catalog.node_name = #{nodeName} "
			+ "Where commodity_catalog.catalogId = #{catalogId}"
			)
	int UpdateCatalog(CommodityCatalog commodityCatalog);
	
	

	
	
	
	
	
}