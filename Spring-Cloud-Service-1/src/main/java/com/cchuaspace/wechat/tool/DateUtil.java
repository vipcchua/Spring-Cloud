package com.cchuaspace.wechat.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {
	
	public static String getTimeStamp() {
		return String.valueOf(System.currentTimeMillis() / 1000);
	}
	
	public static Date getNowDate00() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

	public static Date getNowDate59() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return c.getTime();
	}

	/** 获取月第一天 */
	public static Date getFirstDateOfMonth() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, c.getActualMinimum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	/** 获取月最后 */
	public static Date getLastDateOfMonth() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getTime();

	}

	/** 获取指定月最后的最后一天的日期 */
	public static Date getLastDateOfMonthByDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getTime();

	}

	public static Date addMonth(Date date, int month) {
		if (null == date)
			date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, month);
		return c.getTime();
	}

	/**
	 * 格式化日期
	 * 
	 * @param dateStr
	 *            字符型日期
	 * @param format
	 *            格式
	 * @return 返回日期
	 */
	public static Date parseDate(String dateStr, String format) {
		Date date = null;
		try {
			java.text.DateFormat df = new SimpleDateFormat(format);
			String dt = dateStr;
			// String dt = dateStr.replaceAll("-", "/");
			if ((!dt.equals("")) && (dt.length() < format.length())) {
				dt += format.substring(dt.length()).replaceAll("[YyMmDdHhSs]",
						"0");
			}
			date = df.parse(dt);
		} catch (Exception e) {
		}
		return date;
	}

	/**
	 * @param dateStr
	 * @return Date
	 */
	public static Date parseDate(String dateStr) {
		return parseDate(dateStr, "yyyy-MM-dd");
	}

	public static Date parse2Date(String dateStr) {
		return parseDate(dateStr, "yyyy-MM-dd HH:mm:ss");
	}

	public static Date start2Date(String strDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		try {
			Date date = sdf.parse(strDate);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static Date end2Date(String strDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		try {
			Date beginDate = sdf.parse(strDate);
			Calendar date = Calendar.getInstance();
			date.setTime(beginDate);
			date.set(Calendar.DATE, date.get(Calendar.DATE) + 1);
			Date endDate = sdf.parse(sdf.format(date.getTime()));

			return endDate;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 格式化输出日期
	 * 
	 * @param date
	 *            日期
	 * @param format
	 *            格式
	 * @return 返回字符型日期
	 */
	public static String format(Date date, String format) {
		String result = "";
		try {
			if (date != null) {
				java.text.DateFormat df = new SimpleDateFormat(format);
				result = df.format(date);
			}
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * 返回年份
	 * 
	 * @param date
	 *            日期
	 * @return 返回年份
	 */
	public static int getYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}

	/**
	 * 返回月份
	 * 
	 * @param date
	 *            日期
	 * @return 返回月份
	 */
	public static int getMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH) + 1;
	}

	/**
	 * 返回日份
	 * 
	 * @param date
	 *            日期
	 * @return 返回日份
	 */
	public static int getDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 返回小时
	 * 
	 * @param date
	 *            日期
	 * @return 返回小时
	 */
	public static int getHour(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 返回分钟
	 * 
	 * @param date
	 *            日期
	 * @return 返回分钟
	 */
	public static int getMinute(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MINUTE);
	}

	/**
	 * 返回秒钟
	 * 
	 * @param date
	 *            日期
	 * @return 返回秒钟
	 */
	public static int getSecond(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.SECOND);
	}

	/**
	 * 返回毫秒
	 * 
	 * @param date
	 *            日期
	 * @return 返回毫秒
	 */
	public static long getMillis(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	/**
	 * 返回字符型时间
	 * 
	 * @param date
	 *            日期
	 * @return 返回字符型时间
	 */
	public static String getTime(Date date) {
		return format(date, "HH:mm:ss");
	}

	/**
	 * 返回字符型日期时间
	 * 
	 * @param date
	 *            日期
	 * @return 返回字符型日期时间
	 */
	public static String getDateTime(Date date) {
		return format(date, "yyyy-MM-dd HH:mm");
	}

	public static String getDateTimeSec(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 日期相加
	 * 
	 * @param date
	 *            日期
	 * @param day
	 *            天数
	 * @return 返回相加后的日期
	 */
	public static Date addDate(Date date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);
		return c.getTime();
	}

	/**
	 * 日期相减
	 * 
	 * @param date
	 *            日期
	 * @param date1
	 *            日期
	 * @return 返回相减后的日期
	 */
	public static int diffDate(Date date, Date date1) {
		return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
	}

	/**
	 * 取得指定月份的第一天
	 * 
	 * @param strdate
	 *            String
	 * @return String
	 */
	public static String getMonthBegin(String strdate) {
		Date date = parseDate(strdate);
		return format(date, "yyyy-MM") + "-01";
	}

	/**
	 * 取得指定月份的最后一天
	 * 
	 * @param strdate
	 *            String
	 * @return String
	 */
	public static String getMonthEnd(String strdate) {
		Date date = parseDate(getMonthBegin(strdate));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		return formatDate(calendar.getTime());
	}

	/**
	 * 常用的格式化日期
	 * 
	 * @param date
	 *            Date
	 * @return String
	 */
	public static String formatDate(Date date) {
		// 添加判断
		if (null == date) {
			return "";
		}
		return formatDateByFormat(date, "yyyy-MM-dd");
	}

	public static String format2Date(Date date) {
		// 添加判断
		if (null == date) {
			return "";
		}
		return formatDateByFormat(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static String formatDateSimple(Date date) {
		// 添加判断
		if (null == date) {
			return "";
		}
		return formatDateByFormat(date, "yyyyMMdd");
	}

	public static String formatDateTimeSimple(Date date) {
		// 添加判断
		if (null == date) {
			return "";
		}
		return formatDateByFormat(date, "yyyyMMdd HHmm");
	}

	public static Date parseSimpleDate(String dateStr) {
		return parseDate(dateStr, "yyyyMMdd");
	}

	public static Date parseSimpleDateTime(String dateStr) {
		return parseDate(dateStr, "yyyyMMdd HHmm");
	}

	/**
	 * 以指定的格式来格式化日期
	 * 
	 * @param date
	 *            Date
	 * @param format
	 *            String
	 * @return String
	 */
	public static String formatDateByFormat(Date date, String format) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				result = sdf.format(date);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 去掉Date里面的时分秒
	 * 
	 * @param Date
	 * @return 去掉时分秒后的Date，若参数为空则返回原日期
	 */
	public static Date trimHmsForDate(Date date) {
		Date result = date;
		if (date != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.clear(Calendar.MINUTE);
			cal.clear(Calendar.SECOND);
			cal.clear(Calendar.MILLISECOND);
			result = cal.getTime();
		}
		return result;
	}

	/**
	 * 计算日期差
	 * 
	 * @param startDate
	 *            : 日期参数1
	 * @param endDate
	 *            : 日期参数2
	 * @param diffType
	 *            : 差值计算类别(1:秒数/2:分钟数/3:小时数/4:天数/5:周数/6:月数/7:年数)
	 * @return
	 */
	public static long getDateDiff(Date startDate, Date endDate, int diffType) {
		long diffVal = -1;
		if (startDate.after(endDate))
			return diffVal;

		Calendar firstDay = Calendar.getInstance();
		Calendar lastDay = Calendar.getInstance();
		firstDay.setTime(startDate);
		lastDay.setTime(endDate);

		long fact = 1000;
		switch (diffType) {
		case 1: // 计算秒数差值
			break;
		case 2: // 计算分钟数差值
			fact = fact * 60;
			break;
		case 3: // 计算小时差值
			fact = fact * 60 * 60;
			break;
		case 4: // 计算天数差值
			fact = fact * 24 * 60 * 60;
			break;
		default:// 计算秒数差值
		}
		diffVal = (lastDay.getTimeInMillis() - firstDay.getTimeInMillis())
				/ fact;
		return diffVal;
	}

	public static void main(String[] args) {
		// List<String> dateList = getdiffDayList(30);
		// for (String string : dateList) {
		// System.out.println(string);
		// }
		//System.out.println(formatDateToDate(new Date()));
		//System.out.println(judegeDate("2013-7-1", "2013-7-3", "2013-7-6"));
		//System.out.println(parse2Date("2013-07-13 23:59:58").getTime() > parse2Date("2013-07-12 23:59:59").getTime());
		Date curDate=new Date();
		String dateStr=DateUtil.format(curDate,"yyyy-MM-dd");
		System.out.println(dateStr+" 00:00:00");
		System.out.println(dateStr+" 23:59:59");
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		System.out.println(DateUtil.format(cal.getTime(),"yyyy-MM-dd")+"  00:00:00");
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		System.out.println(DateUtil.format(cal.getTime(),"yyyy-MM-dd")+"  23:59:59");
		
	}

	/**
	 * 获取当前日期的day天
	 */
	public static List<String> getdiffDayList(int day) {
		List<String> dateList = new ArrayList<String>();
		Calendar c = Calendar.getInstance();
		for (int i = 0; i < day; i++) {
			c.add(Calendar.DAY_OF_MONTH, -1);
			dateList.add(format(c.getTime(), "yyyy-MM-dd"));
		}
		return dateList;
	}

	public static boolean isDate(String dateStr) {
		if (dateStr == null || "".equals(dateStr.trim())) {
			return false;
		}
		java.text.DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = df.parse(dateStr.trim());
		} catch (ParseException e1) {
			return false;
		}
		String str = df.format(d); 
		return dateStr.trim().equals(str);
	}
	
	public static Date formatDateToDate(Date date){
		if (date == null) {
			return null;
		}
		return parse2Date(formatDate(date));
	}
	
	/**
	 * 判断指定日期是否在 一个日期之间
	 * @param startDate
	 * @param endDate
	 * @param currentDate
	 * @return
	 */
	public static boolean judegeDate(String startDate, String endDate, String currentDate){
		try {
			if (startDate != null && endDate != null && currentDate != null
					&& !"".equals(startDate.trim()) && !"".equals(endDate.trim()) && !"".equals(currentDate.trim())) {
				Date d_startDate = parse2Date(startDate);
				Date e_endDate = parse2Date(endDate);
				Date c_currentDate = parse2Date(currentDate);
				if (c_currentDate.getTime() >= d_startDate.getTime() && c_currentDate.getTime() <= e_endDate.getTime()) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
}
