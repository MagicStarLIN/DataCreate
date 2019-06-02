package com.lcl.start;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;


import com.lcl.createthread.PassengerCreateThread;
import com.lcl.createthread.PersonCreateThread;
import com.lcl.pojo.Flight;
import com.lcl.service.FlightCreate;
import com.lcl.util.OutputUtil;
import com.lcl.util.PropUtil;

public class Start {
	public static ArrayList<Flight> flightList = new ArrayList<Flight>();
	private static ArrayList<PersonCreateThread> personThreads = new ArrayList<PersonCreateThread>();
	private static ArrayList<PassengerCreateThread> passengerThreads = new ArrayList<PassengerCreateThread>();
	
	static {
		for(int i = 0 ; i < PropUtil.ThreadAmount ; i++) {
			PersonCreateThread pct1 = new PersonCreateThread();
			personThreads.add(pct1);
		}
		for(int i = 0 ; i < PropUtil.ThreadAmount ; i++) {
			PassengerCreateThread pasct1 = new PassengerCreateThread();
			passengerThreads.add(pasct1);
		}
	}
	public static void main(String[] args) throws IOException  {
		boolean flag = true;
		while(flag) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.生成乘客");
		System.out.println("2.生成航班");		
		System.out.println("3.随机分配乘客至各个航班");		
		System.out.println("4.获取当前人数和航班数");		
		System.out.println("5.全部数据生成");
		System.out.println("6.退出");		
		System.out.println("——————————————————————————");
		System.out.println("输入代码数字");
		int n = sc.nextInt();
		switch(n) {
		case 1:
			personProduce();
			break;
		case 2:
			flightProduce();
			break;
		case 3:
			passengerProduce();
			break;
		case 4:
			System.out.println("当前人数为："+PersonCreateThread.persons.size());
			System.out.println("当前航班数为："+flightList.size());
			break;
		case 5:
			personProduce();
			flightProduce();
			passengerProduce();	
			break;
		case 6:
			flag = false;
			break;
		default:
			System.out.println("输入正确数字");
			break;
		}
		}
	}
	private static void personProduce() {
		System.out.println("开始");
		makePersonThreadStart();
		makePersonThreadJoin();
		System.out.println("结束");
	}
	private static void flightProduce() throws IOException {
		File file = OutputUtil.GetFlightFile();
		file.createNewFile();
		OutputStream out = new FileOutputStream(file);
		for(int i = 0 ; i < PropUtil.FlightAmount ; i++) {
			Flight f = FlightCreate.CreateFlight();
			flightList.add(f);
			OutputUtil.FlightWrite2files(f,out);
		}
		out.close();
		System.out.println("结束");
		
	}
	private static void passengerProduce() {
		//信息填充
		System.out.println("填充");
		makePassengerThreadStart();
		makePassengerThreadJoin();
		System.out.println("完成");
		
}
	private static void makePersonThreadStart() {
		for(Thread t : personThreads) {
			t.start();
		}
	}
	private static void makePersonThreadJoin() {
		for(Thread t : personThreads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private static void makePassengerThreadStart() {
		for(PassengerCreateThread t : passengerThreads) {
			t.start();
		}
	}
	private static void makePassengerThreadJoin() {
		for(PassengerCreateThread t : passengerThreads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
