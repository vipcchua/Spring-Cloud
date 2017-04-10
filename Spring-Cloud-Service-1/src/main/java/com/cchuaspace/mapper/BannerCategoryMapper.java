package com.cchuaspace.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cchuaspace.entity.BannerCategoryExample;
import com.cchuaspace.model.BannerCategory;

@Mapper
public interface BannerCategoryMapper {

	@Select("SELECT * FROM banner_category")
	public List<BannerCategory> selectall();

	int countByExample(BannerCategoryExample example);

	int deleteByExample(BannerCategoryExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(BannerCategory record);

	int insertSelective(BannerCategory record);

	List<BannerCategory> selectByExample(BannerCategoryExample example);

	BannerCategory selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") BannerCategory record,
			@Param("example") BannerCategoryExample example);

	int updateByExample(@Param("record") BannerCategory record, @Param("example") BannerCategoryExample example);

	int updateByPrimaryKeySelective(BannerCategory record);

	int updateByPrimaryKey(BannerCategory record);
}