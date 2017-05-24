package com.cchuaspace.mapper;

import com.cchuaspace.model.VideoOrderInfo;
import com.cchuaspace.entity.VideoOrderInfoExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface VideoOrderInfoMapper {
    int countByExample(VideoOrderInfoExample example);

    int deleteByExample(VideoOrderInfoExample example);

    int deleteByPrimaryKey(Integer orderNumber);

    int insert(VideoOrderInfo record);

    int insertSelective(VideoOrderInfo record);

    List<VideoOrderInfo> selectByExample(VideoOrderInfoExample example);

    VideoOrderInfo selectByPrimaryKey(Integer orderNumber);

    int updateByExampleSelective(@Param("record") VideoOrderInfo record, @Param("example") VideoOrderInfoExample example);

    int updateByExample(@Param("record") VideoOrderInfo record, @Param("example") VideoOrderInfoExample example);

    int updateByPrimaryKeySelective(VideoOrderInfo record);

    int updateByPrimaryKey(VideoOrderInfo record);

    @Select("SELECT * from video_order_info WHERE order_number = #{orderNumber} AND openid = #{openid}")
    List<VideoOrderInfo> selectAllInfoByNumber(@Param("orderNumber") int orderNumber, @Param("openid") String openid);


    @Update("UPDATE video_order_info SET order_info.payment_state = #{paymentState}," +

            "where video_order_info.order_number = #{orderNumber}")
    int updatePaymentStateBYclose(@Param("orderNumber") int orderNumber,
                                  @Param("paymentState") String paymentState
    );

    @Update("UPDATE video_order_info SET video_order_info.payment_state = #{paymentState}," +
            "video_order_info.wechat_pay_result = #{wechatPayResult}," +
            "video_order_info.transaction_id = #{transactionId} " +
            "where video_order_info.order_number = #{orderNumber}")
    int updatePaymentState(@Param("orderNumber") int orderNumber,
                           @Param("paymentState") String paymentState,
                           @Param("wechatPayResult") String wechatPayResult,
                           @Param("transactionId") String transactionId);


    @Select("SELECT * FROM video_order_info where order_number = #{orderNumber} ")
    List<VideoOrderInfo> selectByNumber(@Param("orderNumber") int orderNumber);

    @Select("SELECT * FROM video_order_info where order_number = #{orderNumber} ")
    VideoOrderInfo selectByNumberObj(@Param("orderNumber") int orderNumber);

    @Select("SELECT wechat_pay_result FROM video_order_info where order_number = #{orderNumber} ")
    VideoOrderInfo selectPayResultByNumber(@Param("orderNumber") int orderNumber);

    @Select("Select * from order_info WHERE  order_info.order_number = #{orderNumber}")
    VideoOrderInfo selectByOrderNumber(@Param("orderNumber") int orderNumber);


    @Update("UPDATE video_order_info SET video_order_info.payment_state = #{paymentState}," +
            "video_order_info.wechat_pay_result = #{wechatPayResult}" +
            "where video_order_info.order_number = #{orderNumber}")
    int updatePayInfo(@Param("orderNumber") int orderNumber,
                      @Param("paymentState") String paymentState,
                      @Param("wechatPayResult") String wechatPayResult
    );


    @Update("UPDATE video_order_info SET video_order_info.payment_state = #{paymentState}," +
            "video_order_info.wechat_refund_result = #{wechatRefundResult}" +
            "where video_order_info.order_number = #{orderNumber}")
    int updateRefundInfo(@Param("orderNumber") int orderNumber,
                         @Param("paymentState") String paymentState,
                         @Param("wechatRefundResult") String wechatRefundResult
    );
}