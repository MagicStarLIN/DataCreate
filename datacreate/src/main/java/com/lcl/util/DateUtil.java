package com.lcl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	private static Date currentDate = null;
	static {
		try {
			currentDate = format.parse(PropUtil.currentDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static Date makeDateIncrement(int size) {
		currentDate = DatePlusOneDay(currentDate,size);
		return currentDate;
	}
	
	private static Date DatePlusOneDay(Date date,int size) {
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(date);
		rightNow.add(Calendar.DAY_OF_YEAR,size);
		return rightNow.getTime();
	}
	public static String getDateAStrsFormat(Date d,SimpleDateFormat fmt) {
		return "<航班日期>="+fmt.format(d)+"\n";
	}
}
