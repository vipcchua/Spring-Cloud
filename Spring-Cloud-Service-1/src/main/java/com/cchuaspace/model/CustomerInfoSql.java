package com.cchuaspace.model;

/*
 * ****************<--*---Code information---*-->**************
 * 	
 *		Author: Cchua
 *		GitHub: https://github.com/vipcchua
 *		Blog  : weibo.com/vipcchua
 * 
 * 
 * ************************************************************/

import org.apache.ibatis.jdbc.SQL;

public class CustomerInfoSql {

	public String InsertCustomerInfo(final CustomerInfo customerInfo) {

		return new SQL() {
			{
				INSERT_INTO("customer_info");

				if (customerInfo.getId() != null) {
					VALUES("customer_info.id ", " #{id}");
				}

				if (customerInfo.getAppId() != null) {
					VALUES("customer_info.app_id", " #{appId}");
				}
				if (customerInfo.getOpenId() != null) {
					VALUES("customer_info.open_id", "#{openId}");
				}
				if (customerInfo.getNickName() != null) {
					VALUES("customer_info.nick_name ", "#{nickName}");
				}
				if (customerInfo.getHeadimgurl() != null) {
					VALUES("customer_info.headimgurl", "#{headimgurl}");
				}
				if (customerInfo.getProvince() != null) {
					VALUES("customer_info.province", "#{province}");
				}
				if (customerInfo.getSex() != null) {
					VALUES("customer_info.sex", " #{sex}");
				}
				if (customerInfo.getAccount() != null) {
					VALUES("customer_info.account", "#{account}");
				}
				if (customerInfo.getPhone() != null) {
					VALUES("customer_info.phone", "#{phone}");
				}
				if (customerInfo.getPassword() != null) {
					VALUES("customer_info.password", "#{password}");
				}
				if (customerInfo.getEmail() != null) {
					VALUES("customer_info.email", "#{email}");
				}
				if (customerInfo.getPoint() != null) {
					VALUES("customer_info.point", "#{point}");
				}
				if (customerInfo.getType() != null) {
					VALUES("customer_info.type", "#{type}");
				}
				if (customerInfo.getFromOpenId() != null) {
					VALUES("customer_info.from_open_id", "#{fromopenid}");
				}
				if (customerInfo.getStatus() != null) {
					VALUES("customer_info.status", "#{status}");
				}
				if (customerInfo.getCreateDate() != null) {
					VALUES("customer_info.create_date", "#{create_date}");
				}
				if (customerInfo.getUpdateDate() != null) {
					VALUES("customer_info.update_date", "#{update_date}");
				}

				if (customerInfo.getCity() != null) {
					VALUES("customer_info.city", "#{city}");
				}

				if (customerInfo.getCountry() != null) {
					VALUES("customer_info.country", "#{country}");
				}

			}
		}.toString();
	}

	public String UpdateCustomerInfo(final CustomerInfo customerInfo) {

		return new SQL() {
			{
				UPDATE("customer_info");

				if (customerInfo.getId() != null) {
					SET("customer_info.id  =  #{id}");
				}

				if (customerInfo.getAppId() != null) {
					SET("customer_info.app_id  =  #{appId}");
				}

				if (customerInfo.getNickName() != null) {
					SET("customer_info.nick_name = #{nickName}");
				}
				if (customerInfo.getHeadimgurl() != null) {
					SET("customer_info.headimgurl = #{headimgurl}");
				}
				if (customerInfo.getProvince() != null) {
					SET("customer_info.province = #{province}");
				}
				if (customerInfo.getSex() != null) {
					SET("customer_info.sex =  #{sex}");
				}
				if (customerInfo.getAccount() != null) {
					SET("customer_info.account = #{account}");
				}
				if (customerInfo.getPhone() != null) {
					SET("customer_info.phone = #{phone}");
				}
				if (customerInfo.getPassword() != null) {
					SET("customer_info.password = #{password}");
				}
				if (customerInfo.getEmail() != null) {
					SET("customer_info.email = #{email}");
				}
				if (customerInfo.getPoint() != null) {
					SET("customer_info.point = #{point}");
				}
				if (customerInfo.getType() != null) {
					SET("customer_info.type = #{type}");
				}
				if (customerInfo.getFromOpenId() != null) {
					SET("customer_info.from_open_id = #{fromopenid}");
				}
				if (customerInfo.getStatus() != null) {
					SET("customer_info.status = #{status}");
				}
				if (customerInfo.getCreateDate() != null) {
					SET("customer_info.create_date = #{create_date}");
				}
				if (customerInfo.getUpdateDate() != null) {
					SET("customer_info.update_date = #{update_date}");
				}

				if (customerInfo.getCity() != null) {
					SET("customer_info.city = #{city}");
				}

				if (customerInfo.getCountry() != null) {
					SET("customer_info.country = #{country}");
				}

				WHERE("customer_info.open_id = #{openId}");

			}
		}.toString();
	}

}