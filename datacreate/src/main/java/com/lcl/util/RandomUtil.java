package com.lcl.util;

import org.apache.commons.lang3.RandomUtils;


public class RandomUtil {
	public static int getRandomIndex() {
		//包含1而不包含max
		 	int min = 1;
		   int max = (int)PropUtil.PersonAmount;
		   int Index = RandomUtils.nextInt(min, max);
		   return Index;
	}
}
