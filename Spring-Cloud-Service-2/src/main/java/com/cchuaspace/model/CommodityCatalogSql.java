package com.cchuaspace.model;

/*
 * ****************<--*---Code information---*-->**************
 * 	
 *		Author: Cchua
 *		GitHub: https://github.com/vipcchua
 *		Blog  : weibo.com/vipcchua
 * 
 * 
 * ************************************************************/

import org.apache.ibatis.jdbc.SQL;

public class CommodityCatalogSql {



	public String InsertCommodityCatalog(final CommodityCatalog commodityCatalog) {

		return new SQL() {
			{
				INSERT_INTO("commodity_catalog");
			
				VALUES("commodity_catalog.catalog_id ", " #{catalogId}");
				VALUES("commodity_catalog.parents_id ", " #{parentsId}");
				VALUES("commodity_catalog.node_name ", " #{nodeName}");
				VALUES("commodity_catalog.depth ", " #{depth}");
				if (commodityCatalog.getCommodityNumber() != null) {
					VALUES("commodity_catalog.commodityNumber ", " #{commodityNumber}");
				}

			}
		}.toString();
	}

}