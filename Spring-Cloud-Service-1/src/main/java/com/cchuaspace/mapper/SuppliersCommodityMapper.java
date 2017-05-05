package com.cchuaspace.mapper;

import com.cchuaspace.entity.SuppliersCommodityExample;
import com.cchuaspace.model.SuppliersCommodity;
import com.cchuaspace.model.SuppliersInfo;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SuppliersCommodityMapper {
    int countByExample(SuppliersCommodityExample example);

    int deleteByExample(SuppliersCommodityExample example);

    int insert(SuppliersCommodity record);

    int insertSelective(SuppliersCommodity record);

    List<SuppliersCommodity> selectByExample(SuppliersCommodityExample example);

    int updateByExampleSelective(@Param("record") SuppliersCommodity record, @Param("example") SuppliersCommodityExample example);

    int updateByExample(@Param("record") SuppliersCommodity record, @Param("example") SuppliersCommodityExample example);
    
    
    
    
    
    
    @Select("SELECT * FROM suppliers_commodity where supplier_number = #{supplierNumber}")
    SuppliersCommodity SelectByNumberObj(@Param("supplierNumber") int supplierNumber);

	@Select("SELECT * FROM suppliers_commodity where commodity_number = #{commodityNumber}")
	List<SuppliersCommodity> SelectByCommoditynumber(@Param("commodityNumber") String commodityNumber);

	@Delete("Delete FROM suppliers_commodity where id = #{id}")
	int DeleteById(@Param("id") String id);

	@Delete("Delete FROM suppliers_commodity where supplier_number = #{supplierNumber} AND commodity_number = #{commodityNumber}")
	int DeleteByNumber(@Param("supplierNumber") int supplierNumber,@Param("commodityNumber") int commodityNumber);
    
    
    
    
    
    
}