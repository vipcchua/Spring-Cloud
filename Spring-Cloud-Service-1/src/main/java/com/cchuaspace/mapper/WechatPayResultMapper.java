package com.cchuaspace.mapper;

import com.cchuaspace.entity.WechatPayResultExample;
import com.cchuaspace.model.WechatPayResult;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface WechatPayResultMapper {
    int countByExample(WechatPayResultExample example);

    int deleteByExample(WechatPayResultExample example);

    int insert(WechatPayResult record);

    int insertSelective(WechatPayResult record);

    List<WechatPayResult> selectByExample(WechatPayResultExample example);

    int updateByExampleSelective(@Param("record") WechatPayResult record, @Param("example") WechatPayResultExample example);

    int updateByExample(@Param("record") WechatPayResult record, @Param("example") WechatPayResultExample example);
}