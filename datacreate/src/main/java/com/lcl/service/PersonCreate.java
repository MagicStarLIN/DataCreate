package com.lcl.service;

import com.lcl.bo.IDmes;
import com.lcl.pojo.Person;
import com.lcl.util.PersonUtil;

public class PersonCreate {
		/**
		 * 创建一个person实例
		 * @param f
		 * @return
		 */
	public static Person CreatePerson() {
		IDmes mes = PersonUtil.IDmesCreate();
		Person person = new Person();
		person.setName(PersonUtil.createName());
		person.setID(mes.getIDCard());
		person.setSex(mes.getSex());
		return person;
	}
	
}
