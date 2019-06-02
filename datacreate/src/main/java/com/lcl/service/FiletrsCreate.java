package com.lcl.service;

import com.lcl.pojo.Flight;
import com.lcl.pojo.Person;

public class FiletrsCreate {
	/**
	 * 将person实体类转换为.trs文件格式的字符串
	 * @param p
	 * @return
	 */
	public static String Personformat2trs(Person p) {
		return "<REC>"+"\n"
				+ "<姓名>="+p.getName()+"\n"
				+"<性别>="+p.getSex()+"\n"
				+"<身份证号>="+p.getID()+"\n";
	}
	/**
	 * 将flight实体类转换为.trs文件格式的字符串
	 * @param f 
	 * @return
	 */
	public static String Flightformat2trs(Flight f) {
		return "<REC>"+"\n"
				+ "<航班号>="+f.getFlightID()+"\n"
				+"<出发城市>="+f.getFromcity()+"\n"
				+"<到达城市>="+f.getArrivecity()+"\n";
	}
	public static String Personformat2trsWithoutRec(Person p) {
		return  "<姓名>="+p.getName()+"\n"
				+"<性别>="+p.getSex()+"\n"
				+"<身份证号>="+p.getID()+"\n";
	}
}
