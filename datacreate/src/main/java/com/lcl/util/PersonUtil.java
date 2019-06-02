package com.lcl.util;


import com.lcl.bo.IDmes;

import cn.binarywang.tools.generator.ChineseIDCardNumberGenerator;
import cn.binarywang.tools.generator.ChineseNameGenerator;
/**
 * 创建person工具类
 * @author liuchanglin
 *
 */
public class PersonUtil {
	/**
	 * 姓名生成
	 * @return
	 */
	public static String createName() {
		return ChineseNameGenerator.getInstance().generate();
	}
	/**
	 * 身份证信息和性别一起创建
	 * @return
	 */
	public static IDmes IDmesCreate() {
		IDmes result = new IDmes();
        String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
        result.setIDCard(idCard);
        if (idCard.charAt(idCard.length()-2)%2 == 0){
        	result.setSex("女");
        } else {
        	result.setSex("男");
	}
        return result;
	}
}
