package com.cchuaspace.mapper;

import com.cchuaspace.entity.SuppliersInfoExample;
import com.cchuaspace.model.CommodityInfoDetails;
import com.cchuaspace.model.SuppliersInfo;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper

public interface SuppliersInfoMapper {
	int countByExample(SuppliersInfoExample example);

	int deleteByExample(SuppliersInfoExample example);

	int deleteByPrimaryKey(Integer supplierNumber);

	int insert(SuppliersInfo record);

	int insertSelective(SuppliersInfo record);

	List<SuppliersInfo> selectByExample(SuppliersInfoExample example);

	SuppliersInfo selectByPrimaryKey(Integer supplierNumber);

	int updateByExampleSelective(@Param("record") SuppliersInfo record, @Param("example") SuppliersInfoExample example);

	int updateByExample(@Param("record") SuppliersInfo record, @Param("example") SuppliersInfoExample example);

	int updateByPrimaryKeySelective(SuppliersInfo record);

	int updateByPrimaryKey(SuppliersInfo record);

	@Select("SELECT * FROM suppliers_info where supplier_number = #{supplierNumber}")
	SuppliersInfo SelectByNumberObj(@Param("supplierNumber") int supplierNumber);

	@Select("SELECT * FROM suppliers_info where supplier_name LIKE CONCAT('%',#{supplierName},'%')")
	List<SuppliersInfo> SelectByNameList(@Param("supplierName") String supplierName);

	@Delete("Delete FROM suppliers_info where id = #{id}")
	int DeleteById(@Param("id") String id);

	@Delete("Delete FROM suppliers_info where supplier_number = #{supplierNumber}")
	int DeleteByNumber(@Param("supplierNumber") int supplierNumber);

}