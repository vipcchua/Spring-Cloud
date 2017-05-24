package com.cchuaspace.mapper;

import com.cchuaspace.model.VideoOrderCommodity;
import com.cchuaspace.entity.VideoOrderCommodityExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VideoOrderCommodityMapper {
    int countByExample(VideoOrderCommodityExample example);

    int deleteByExample(VideoOrderCommodityExample example);

    int deleteByPrimaryKey(String id);

    int insert(VideoOrderCommodity record);

    int insertSelective(VideoOrderCommodity record);

    List<VideoOrderCommodity> selectByExample(VideoOrderCommodityExample example);

    VideoOrderCommodity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") VideoOrderCommodity record, @Param("example") VideoOrderCommodityExample example);

    int updateByExample(@Param("record") VideoOrderCommodity record, @Param("example") VideoOrderCommodityExample example);

    int updateByPrimaryKeySelective(VideoOrderCommodity record);

    int updateByPrimaryKey(VideoOrderCommodity record);




    @Select("SELECT * FROM video_order_commodity where video_number = #{videoNumber} AND user_id = #{UserId}")
    List<VideoOrderCommodity> selectByNumberUser(@Param("videoNumber") int videoNumber,@Param("UserId") String UserId);

    @Select("SELECT * FROM video_order_commodity where video_number = #{videoNumber}")
    List<VideoOrderCommodity> selectByNumber(@Param("videoNumber") int videoNumber);


    @Select("SELECT * FROM video_order_commodity where order_number = #{orderNumber}")
    List<VideoOrderCommodity> selectByOrderNumber(@Param("orderNumber") int orderNumber);
}