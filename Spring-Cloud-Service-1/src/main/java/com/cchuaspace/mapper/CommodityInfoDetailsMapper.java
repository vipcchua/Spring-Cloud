package com.cchuaspace.mapper;

import java.util.List;

import com.cchuaspace.model.CommodityInfoDerailsSql;
import com.cchuaspace.pojo.PaginationVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cchuaspace.entity.CommodityInfoDetailsExample;
import com.cchuaspace.model.CommodityInfo;
import com.cchuaspace.model.CommodityInfoDetails;
import com.cchuaspace.pojo.CommodityInfoDetailsVo;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface CommodityInfoDetailsMapper {


	
	
/*--*/
int countByExample(CommodityInfoDetailsExample example);

    int deleteByExample(CommodityInfoDetailsExample example);

    int deleteByPrimaryKey(String id);

    int insert(CommodityInfoDetails record);

    int insertSelective(CommodityInfoDetails record);

    List<CommodityInfoDetails> selectByExampleWithBLOBs(CommodityInfoDetailsExample example);

    List<CommodityInfoDetails> selectByExample(CommodityInfoDetailsExample example);

    CommodityInfoDetails selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CommodityInfoDetails record, @Param("example") CommodityInfoDetailsExample example);

    int updateByExampleWithBLOBs(@Param("record") CommodityInfoDetails record, @Param("example") CommodityInfoDetailsExample example);

    int updateByExample(@Param("record") CommodityInfoDetails record, @Param("example") CommodityInfoDetailsExample example);

    int updateByPrimaryKeySelective(CommodityInfoDetails record);

    int updateByPrimaryKeyWithBLOBs(CommodityInfoDetails record);

    int updateByPrimaryKey(CommodityInfoDetails record);
    
    /*--*/
    
    
    
    
	@Select("SELECT * FROM commodity_info_details where commodity_number = #{commodityNumber}")
    List<CommodityInfoDetails>  SelectCByNumberObj(@Param("commodityNumber") int commodityNumber);
	
    
	@Select("SELECT * FROM commodity_info_details where commodity_number = #{commodityNumber}")
	CommodityInfoDetailsVo SelectCByNumberObjVo(@Param("commodityNumber") int commodityNumber);

    @Select("SELECT title FROM commodity_info_details where commodity_number = #{commodityNumber}")
    CommodityInfoDetailsVo SelectOrderInfosCByNumber(@Param("commodityNumber") int commodityNumber);


    @SelectProvider(type = CommodityInfoDerailsSql.class, method = "SelectAllByPage")
    public List<CommodityInfoDetailsVo> SelectAllByPage(CommodityInfoDetailsVo commodityInfoDetailsVo);




    @Select("SELECT * FROM commodity_info_details where commodity_number = #{commodityNumber} AND shelf_state = #{shelfState}")
	List<CommodityInfoDetails>  SelectCByNumberList(@Param("commodityNumber") int commodityNumber,@Param("shelfState") int shelfState);
	
    
    @Select("SELECT * FROM commodity_info_details where commodity_number = #{commodityNumber} AND shelf_state = #{shelfState}")
    List<CommodityInfoDetailsVo> SelectCByNumberListVo(@Param("commodityNumber") int commodityNumber,@Param("shelfState") int shelfState);

    @Select("SELECT present_price FROM commodity_info_details where commodity_number = #{commodityNumber}")
 CommodityInfoDetails SelectPriceByNumber(@Param("commodityNumber") int commodityNumber);



    @Select("SELECT * FROM commodity_info_details where commodity_number = #{commodityNumber}")
    CommodityInfoDetails SelectAllByNumber(@Param("commodityNumber") int commodityNumber);



}