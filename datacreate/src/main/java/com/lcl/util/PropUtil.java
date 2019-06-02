package com.lcl.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropUtil {
	public static long PersonAmount;
	public static int ThreadAmount;
	public static long PassengerAmount;
	public static int FlightAmount; 
	public static String currentDate;
	public static String PersonFile;
	public static String FlightFile;
	public static String PassengerFile;
	
	static {
		PersonAmount = Long.parseLong(PropUtil.getValueOf("PersonAmount"));
		ThreadAmount = Integer.parseInt(PropUtil.getValueOf("ThreadAmount"));
		PassengerAmount = Long.parseLong(PropUtil.getValueOf("PassengerAmount"));
		FlightAmount = Integer.parseInt(PropUtil.getValueOf("FlightAmount"));
		currentDate = PropUtil.getValueOf("StartDate");
		PersonFile = PropUtil.getValueOf("PersonFile");
		FlightFile = PropUtil.getValueOf("FlightFile");
		PassengerFile = PropUtil.getValueOf("PassengerFile");
		
	}
	private static Properties getProLoad() {
		Properties pro = new Properties();
		InputStream in = null;
		try {
			in = PropUtil.class.getClassLoader().getResourceAsStream("Config.properties");
			pro.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro;
	}
	
	private static String getValueOf(String key) {
		return getProLoad().getProperty(key);
	}
	
}
