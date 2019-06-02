package com.lcl.createthread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import com.lcl.pojo.Flight;
import com.lcl.pojo.Person;
import com.lcl.service.FiletrsCreate;
import com.lcl.start.Start;
import com.lcl.util.DateUtil;
import com.lcl.util.OutputUtil;
import com.lcl.util.PropUtil;
import com.lcl.util.RandomUtil;

public class PassengerCreateThread extends Thread{
	private static AtomicLong count = new AtomicLong();
	public static AtomicInteger Day = new AtomicInteger();
	@Override
	public void run() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		File file = OutputUtil.GetPassengerFile();
		OutputStream out = null;
		try {
			out = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(count.get() <= PropUtil.PassengerAmount) {
			Date date = DateUtil.makeDateIncrement(Day.getAndIncrement());
			for(Flight f : Start.flightList) {
				String flightcontent = FiletrsCreate.Flightformat2trs(f);
				String datecontent = DateUtil.getDateAStrsFormat(date,format);
				for(int i = 0 ; i < 200 ; i++) {
					Person p = PersonCreateThread.persons.get(RandomUtil.getRandomIndex());
					String personcontent = FiletrsCreate.Personformat2trsWithoutRec(p);
					StringBuffer sb = new StringBuffer("");
					sb.append(flightcontent).append(datecontent).append(personcontent);
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
					OutputUtil.PassengerWriter2files(sb.toString(), out);
					count.getAndIncrement();
					if(count.get()%100000==0) {
						System.out.println(count.decrementAndGet());
					}
					}
				}
		}
		
	}

	}
	

