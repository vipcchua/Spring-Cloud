package com.cchuaspace.mapper;


import com.cchuaspace.entity.WarehouseStockExample;
import com.cchuaspace.model.SuppliersInfo;
import com.cchuaspace.model.WarehouseStock;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface WarehouseStockMapper {
    int countByExample(WarehouseStockExample example);

    int deleteByExample(WarehouseStockExample example);

    int insert(WarehouseStock record);

    int insertSelective(WarehouseStock record);

    List<WarehouseStock> selectByExample(WarehouseStockExample example);

    int updateByExampleSelective(@Param("record") WarehouseStock record, @Param("example") WarehouseStockExample example);

    int updateByExample(@Param("record") WarehouseStock record, @Param("example") WarehouseStockExample example);
    
    
    
    
    
    
    
    
    
    @Select("SELECT * FROM warehouse_stock where commodity_number = #{commodityNumber}")
    List<WarehouseStock> SelectByNumberObj(@Param("commodityNumber") int commodityNumber);

	

	@Delete("Delete FROM warehouse_stock where id = #{id}")
	int DeleteById(@Param("id") String id);
/*
	@Delete("Delete FROM warehouse_stock where supplier_number = #{supplierNumber}")
	int DeleteByNumber(@Param("supplierNumber") int supplierNumber);/*/
    
    
    
    
    
}