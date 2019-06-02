package com.lcl.pojo;
/**
 * 实体类 Person
 */
public class Person {
	private String name;//姓名
	private String ID;//身份证号
	private String sex;//性别
//	private Flight flight;//航班
	
	
	public Person() {
	}
	
	
	public Person(String name, String iD, String sex, Flight flight) {
		this.name = name;
		this.ID = iD;
		this.sex = sex;
//		this.flight = flight;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
//	public Flight getFlight() {
//		return flight;
//	}
//	public void setFlight(Flight flight) {
//		this.flight = flight;
//	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", ID=" + ID + ", sex=" + sex +  "]";
	}
	
	
}
