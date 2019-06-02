package com.lcl.createthread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicLong;

import com.lcl.pojo.Person;
import com.lcl.service.PersonCreate;
import com.lcl.util.OutputUtil;
import com.lcl.util.PropUtil;

public class PersonCreateThread extends Thread{
	public static Vector<Person> persons = new Vector<Person>();
	public static AtomicLong personcount = new AtomicLong();
	@Override
	public void run() {
			//文件夹需要提前创建好
			OutputStream out = null;
			File file = OutputUtil.GetPersonFile();
				try {
					out = new FileOutputStream(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
		while(personcount.getAndIncrement() <= PropUtil.PersonAmount) {
			Person p = PersonCreate.CreatePerson();
			persons.add(p);
			if(file.length() >= 1073741824) {
				try {
					out.close();
					file = OutputUtil.GetPassengerFile();
					out = new FileOutputStream(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			OutputUtil.PersonWrite2files(p,out);
			if(personcount.get()%10000 == 0) {
				System.out.println("已生成："+personcount.get());
			}
		}
		
		}
	
	
	
}
