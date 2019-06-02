package com.lcl.util;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import com.lcl.pojo.Flight;
import com.lcl.pojo.Person;
import com.lcl.service.FiletrsCreate;

public class OutputUtil {
	//文件创建
	public static File GetPersonFile() {
		return new File(PropUtil.PersonFile+UUID.randomUUID()+".trs");
	}
	
	public static File GetPassengerFile() {
		return new File(PropUtil.PassengerFile+UUID.randomUUID()+".trs");
	}
	
	public static File GetFlightFile() {
		return new File(PropUtil.FlightFile+UUID.randomUUID()+".trs");
	}
	/**
	 * 将乘客信息写入文件
	 * @param p
	 * @param file
	 * @throws IOException
	 */
	public static void PersonWrite2files(Person p,OutputStream out) {
		String str = FiletrsCreate.Personformat2trs(p);
		byte[] b = str.getBytes();
		try {
			out.flush();
			out.write(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
		
	/**
	 * 将航班信息写入文件
	 * @param f
	 * @param file
	 * @throws IOException
	 */
	public  static void  FlightWrite2files(Flight f,OutputStream out) {
		String str = FiletrsCreate.Flightformat2trs(f);
		byte[] b = str.getBytes();
		try {
			out.flush();
			out.write(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void PassengerWriter2files(String str ,OutputStream out) {
		byte[] b = str.getBytes();
		try {
			out.flush();
			out.write(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	/**
//	 * 获取文件中的随机行内容
//	 * @param f
//	 * @throws IOException
//	 */
//	public static String getRandomLineFromFile(File f) throws IOException {
//		LineIterator it = FileUtils.lineIterator(f, "UTF-8");	  
//		int i = 0;
//		try {
//			String line = "";
//			int num = (int)(Math.random()*1000);
//		    while (it.hasNext()) {
//		    	i++;
//		    	if( i == num) {
//		    		for(int j = 0 ; j < num ; j++) {
//		    			line = it.nextLine();
//		    		 }
//		    		return line;
//		    	 }		    	  
//		      } 
//		  } finally {
//		      LineIterator.closeQuietly(it);
//		  }
//		return null;
//	}

}
