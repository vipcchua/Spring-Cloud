package com.cchuaspace.mapper;



import java.util.List;

import com.cchuaspace.entity.UseCommodityFavoritesExample;
import com.cchuaspace.model.UseCommodityFavorites;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.cchuaspace.pojo.UseCommodityFavoritesVo;
@Mapper
public interface UseCommodityFavoritesMapper {
	int countByExample(UseCommodityFavoritesExample example);

	int deleteByExample(UseCommodityFavoritesExample example);

	int deleteByPrimaryKey(String id);

	int insert(UseCommodityFavorites record);

	int insertSelective(UseCommodityFavorites record);

	List<UseCommodityFavorites> selectByExample(UseCommodityFavoritesExample example);

	UseCommodityFavorites selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") UseCommodityFavorites record, @Param("example") UseCommodityFavoritesExample example);

	int updateByExample(@Param("record") UseCommodityFavorites record, @Param("example") UseCommodityFavoritesExample example);

	int updateByPrimaryKeySelective(UseCommodityFavorites record);

	int updateByPrimaryKey(UseCommodityFavorites record);

	@Select("SELECT * FROM use_commodity_favorites where user_id = #{userid}")
	List<UseCommodityFavoritesVo> SelectByuserList(@Param("userid") String userid);

	@Delete("Delete FROM use_commodity_favorites where commodity_number = #{commodityNumber} AND user_id = #{userId} ")
	int DeleteByNumber(@Param("commodityNumber") int commodityNumber, @Param("userId") String userId);

	@Delete("Delete FROM use_commodity_favorites where id = #{id} AND user_id = #{userId} ")
	int DeleteById(@Param("id") String id, @Param("userId") String userId);




}