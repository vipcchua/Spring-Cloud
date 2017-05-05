package com.cchuaspace.mapper;

import com.cchuaspace.entity.UseDeliveryAddressExample;

import com.cchuaspace.model.UseDeliveryAddress;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface UseDeliveryAddressMapper {
    int countByExample(UseDeliveryAddressExample example);

    int deleteByExample(UseDeliveryAddressExample example);

    int deleteByPrimaryKey(String id);

    int insert(UseDeliveryAddress record);

    int insertSelective(UseDeliveryAddress record);

    List<UseDeliveryAddress> selectByExample(UseDeliveryAddressExample example);

    UseDeliveryAddress selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UseDeliveryAddress record, @Param("example") UseDeliveryAddressExample example);

    int updateByExample(@Param("record") UseDeliveryAddress record, @Param("example") UseDeliveryAddressExample example);

    int updateByPrimaryKeySelective(UseDeliveryAddress record);

    int updateByPrimaryKey(UseDeliveryAddress record);
    
	@Select("SELECT * FROM use_delivery_address where user_id = #{userId}")
	List<UseDeliveryAddress> SelectByuserList(@Param("userId") String userId);

	
	@Delete("Delete FROM use_delivery_address where id = #{id} AND user_id = #{userId} ")
	int DeleteById(@Param("id") String id, @Param("userId") String userId);
	
	
	
	
    
    
}