package com.cchuaspace.currency;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CchuaTool {
	public String uuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		return uuid;
	}

	public String token() {
		String uuid = UUID.randomUUID().toString();
		String time = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		String token = uuid + time.toString();

		token = sha1(token);
		System.out.println("ShaToken:" + token);
		return token;

	}

	public int getOrderNumber(int info, int zf) {
		int OrderNumber;

		long time = System.currentTimeMillis();

		int nowTimeStamp = new Long(time).intValue();

		OrderNumber = info + zf + nowTimeStamp + getrandomNumber(10000000, 1000000) + getrandomNumber(1000, 9999);
		return OrderNumber;

	}

	public String getCommodityNumber(String classify) {
		String CommodityNumber;
		String time = new SimpleDateFormat("HHmmssSSS").format(new Date());
		CommodityNumber = classify + time + getrandomNumber(100, 999);
		return CommodityNumber;

	}

	public int getrandomNumber(int min, int max) {
		/*
		 * int max = 10000000; int min = 1000000;
		 */
		Random random = new Random();
		int s = random.nextInt(max) % (max - min + 1) + min;
		return s;
	}

	public static String sha1(String text) {
		MessageDigest md = null;
		String outStr = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
			byte[] digest = md.digest(text.getBytes());
			outStr = byteToString(digest);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		return outStr;
	}

	private static String byteToString(byte[] digest) {
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < digest.length; i++) {
			String tempStr = Integer.toHexString(digest[i] & 0xff);
			if (tempStr.length() == 1) {
				buf.append("0").append(tempStr);
			} else {
				buf.append(tempStr);
			}
		}
		return buf.toString().toLowerCase();
	}

	private String attime() {
		Date d = new Date();
		System.out.println(d);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateNowStr = sdf.format(d);
		System.out.println("格式化后的日期：" + dateNowStr);

		String str = "2012-1-13 17:26:33"; // 要跟上面sdf定义的格式一样
		Date today;
		try {
			today = sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* System.out.println("字符串转成日期：" + today); */
		return dateNowStr;
	}

	public Date getDate() {
		Date k = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long rightTime = (long) (k.getTime() + 8 * 60 * 60 * 1000); // 把当前得到的时间用date.getTime()的方法写成时间戳的形式，再加上8小时对应的毫秒数
		String newtime = sd.format(rightTime);// 把得到的新的时间戳再次格式化成时间的格式

		try {
			k = sd.parse(newtime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return k;

	}

}
