package com.cchuaspace.mapper;

import com.cchuaspace.entity.HomepageBannerExample;
import com.cchuaspace.model.HomepageBanner;
import com.cchuaspace.model.TableUser;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper

public interface HomepageBannerMapper {
	
	

	
	@Select("SELECT * from homepage_banner")
	List<HomepageBanner> selectallbanner();
	
	
	

	
    int countByExample(HomepageBannerExample example);

    int deleteByExample(HomepageBannerExample example);

    int deleteByPrimaryKey(String id);

    int insert(HomepageBanner record);

    int insertSelective(HomepageBanner record);

    List<HomepageBanner> selectByExample(HomepageBannerExample example);

    HomepageBanner selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") HomepageBanner record, @Param("example") HomepageBannerExample example);

    int updateByExample(@Param("record") HomepageBanner record, @Param("example") HomepageBannerExample example);

    int updateByPrimaryKeySelective(HomepageBanner record);

    int updateByPrimaryKey(HomepageBanner record);
}