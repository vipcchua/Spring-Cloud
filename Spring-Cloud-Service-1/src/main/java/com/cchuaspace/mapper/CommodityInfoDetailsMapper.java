package com.cchuaspace.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cchuaspace.entity.CommodityInfoDetailsExample;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.CommodityInfoDetails;

@Mapper
public interface CommodityInfoDetailsMapper {


	
	
/*--*/
    int countByExample(CommodityInfoDetailsExample example);

    int deleteByExample(CommodityInfoDetailsExample example);

    int deleteByPrimaryKey(String id);

    int insert(CommodityInfoDetails record);

    int insertSelective(CommodityInfoDetails record);

    List<CommodityInfoDetails> selectByExample(CommodityInfoDetailsExample example);

    CommodityInfoDetails selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CommodityInfoDetails record, @Param("example") CommodityInfoDetailsExample example);

    int updateByExample(@Param("record") CommodityInfoDetails record, @Param("example") CommodityInfoDetailsExample example);

    int updateByPrimaryKeySelective(CommodityInfoDetails record);

    int updateByPrimaryKey(CommodityInfoDetails record);
    
    
    
    /*--*/
    
    
    
    
	@Select("SELECT * FROM commodity_info_details where commodity_number = #{commodityNumber}")
	CommodityInfoDetails SelectCByNumberObj(@Param("commodityNumber") int commodityNumber);
	
    

	
    
	@Select("SELECT * FROM commodity_info_details where commodity_number = #{commodityNumber} AND shelf_state = #{shelfState}")
	List<CommodityInfoDetails>  SelectCByNumberList(@Param("commodityNumber") int commodityNumber,@Param("shelfState") int shelfState);
}