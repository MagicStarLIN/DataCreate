package com.lcl.util;

import java.util.UUID;

public class FlightUtil {

	/**
	 * 生成六位字母数字混合航班号
	 * @return
	 */
	public static String getflightId() {
		return UUID.randomUUID().toString().substring(0, 6).toUpperCase();
	}
	  
}
