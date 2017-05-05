package com.cchuaspace.mapper;

import com.cchuaspace.entity.DeliveryPointExample;
import com.cchuaspace.model.DeliveryPoint;
import com.cchuaspace.model.DeliveryPointSql;
import com.cchuaspace.model.SuppliersCommodity;

import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface DeliveryPointMapper {
	int countByExample(DeliveryPointExample example);

	int deleteByExample(DeliveryPointExample example);

	int deleteByPrimaryKey(String id);

	int insert(DeliveryPoint record);

	int insertSelective(DeliveryPoint record);

	List<DeliveryPoint> selectByExample(DeliveryPointExample example);

	DeliveryPoint selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") DeliveryPoint record, @Param("example") DeliveryPointExample example);

	int updateByExample(@Param("record") DeliveryPoint record, @Param("example") DeliveryPointExample example);

	int updateByPrimaryKeySelective(DeliveryPoint record);

	int updateByPrimaryKey(DeliveryPoint record);

	@Select("SELECT * FROM delivery_point where delivery_name LIKE CONCAT('%',#{deliveryName},'%')")
	List<DeliveryPoint> SelectByNameList(@Param("deliveryName") String deliveryName);

	@Select("SELECT * FROM delivery_point where region_number = #{regionNumber}")
	List<DeliveryPoint> SelectByRegionNumber(@Param("regionNumber") String regionNumber);

	@Select("SELECT * FROM delivery_point where delivery_number = #{deliveryNumber}")
	DeliveryPoint SelectByDeliveryNumber(@Param("deliveryNumber") int deliveryNumber);

	@Delete("Delete FROM delivery_point where id = #{id}")
	int DeleteById(@Param("id") String id);

	@Delete("Delete FROM delivery_point where delivery_number = #{deliveryNumber}")
	int DeleteByNumber(@Param("deliveryNumber") int supplierNumber);


	@SelectProvider(type = DeliveryPointSql.class, method = "SelectPoint")
	public List<DeliveryPoint> SelectPoint(DeliveryPoint deliveryPoint);



}