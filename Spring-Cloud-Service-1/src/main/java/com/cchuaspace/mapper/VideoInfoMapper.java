package com.cchuaspace.mapper;

import com.cchuaspace.entity.VideoInfoExample;
import com.cchuaspace.model.VideoInfo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VideoInfoMapper {
    int countByExample(VideoInfoExample example);

    int deleteByExample(VideoInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(VideoInfo record);

    int insertSelective(VideoInfo record);

    List<VideoInfo> selectByExampleWithBLOBs(VideoInfoExample example);

    List<VideoInfo> selectByExample(VideoInfoExample example);

    VideoInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") VideoInfo record, @Param("example") VideoInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") VideoInfo record, @Param("example") VideoInfoExample example);

    int updateByExample(@Param("record") VideoInfo record, @Param("example") VideoInfoExample example);

    int updateByPrimaryKeySelective(VideoInfo record);

    int updateByPrimaryKeyWithBLOBs(VideoInfo record);

    int updateByPrimaryKey(VideoInfo record);

    @Select("SELECT present_price FROM video_info where video_number = #{videoNumber}")
    VideoInfo selectPriceByNumber(@Param("videoNumber") int videoNumber);


    @Select("SELECT * FROM video_info where video_number = #{videoNumber}")
    List<VideoInfo> selectByNumber(@Param("videoNumber") int videoNumber);

    @Select("SELECT * FROM video_info where video_number = #{videoNumber}")
   VideoInfo selectByNumberObj(@Param("videoNumber") int videoNumber);





}