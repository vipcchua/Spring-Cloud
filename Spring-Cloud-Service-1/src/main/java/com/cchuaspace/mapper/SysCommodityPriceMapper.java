package com.cchuaspace.mapper;

import com.cchuaspace.entity.SysCommodityPriceExample;
import com.cchuaspace.model.CommodityInfoDetails;
import com.cchuaspace.model.SysCommodityPrice;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysCommodityPriceMapper {
	int countByExample(SysCommodityPriceExample example);

	int deleteByExample(SysCommodityPriceExample example);

	int deleteByPrimaryKey(String id);

	int insert(SysCommodityPrice record);

	int insertSelective(SysCommodityPrice record);

	List<SysCommodityPrice> selectByExample(SysCommodityPriceExample example);

	SysCommodityPrice selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") SysCommodityPrice record,
			@Param("example") SysCommodityPriceExample example);

	int updateByExample(@Param("record") SysCommodityPrice record, @Param("example") SysCommodityPriceExample example);

	int updateByPrimaryKeySelective(SysCommodityPrice record);

	int updateByPrimaryKey(SysCommodityPrice record);

	@Select("SELECT * FROM sys_commodity_price where commodity_number = #{commodityNumber}")
	List<SysCommodityPrice> SelectByNumberList(@Param("commodityNumber") int commodityNumber);

	@Delete("Delete FROM sys_commodity_price where id = #{id}")
	int DeleteById(@Param("id") String id);

	@Select("SELECT * FROM sys_commodity_price where commodity_number= #{commodityNumber} group by sys_commodity_price.update_time DESC limit 1")
	SysCommodityPrice SelectNewByNumber(@Param("commodityNumber") int commodityNumber);

	@Select("SELECT * FROM sys_commodity_price where commodity_number= #{commodityNumber} group by sys_commodity_price.update_time DESC limit 1")
	List<SysCommodityPrice> SelectNewByNumberList(@Param("commodityNumber") int commodityNumber);

	@Select("SELECT present_price FROM sys_commodity_price where commodity_number= #{commodityNumber} group by sys_commodity_price.update_time DESC limit 1")
	List<SysCommodityPrice> SelectpresentByNumber(@Param("commodityNumber") int commodityNumber);

}