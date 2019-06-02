package com.lcl.datacreate.datacreate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.junit.Test;

import com.lcl.util.PropUtil;

import cn.binarywang.tools.generator.ChineseIDCardNumberGenerator;
import cn.binarywang.tools.generator.ChineseNameGenerator;

public class GeneratorTest {
	/**
	 * name 生成
	 */
	@Test
	public void test0() {
		long t1 = System.currentTimeMillis();
		for(int i = 0; i < 1000; i ++) {
			String name = ChineseNameGenerator.getInstance().generate();
			System.out.println(name);
		}
		long t2 = System.currentTimeMillis();
		System.out.println("time used :"+(t2-t1));

	}
	@Test
	public void test1() {
        String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
        System.err.println(idCard);
        if (idCard.charAt(idCard.length()-2)%2 == 0){
            System.err.println("女");
        } else {
            System.err.println("男");
        }
	}
	/**
	 * 航班号生成 格式并不符合航班编号标准 
	 * 航班编号标准是两位英文字母（或数字加英文字母组合）航空公司代码加上三到四位数航班号的方式，其中国内航班统一为四位数，国际航班为三位数
	 * 
	 */
	@Test
	public void test2() {
		for(int i = 0 ; i < 20 ; i++) {
			String uuid = UUID.randomUUID().toString().substring(0, 6).toUpperCase();
			System.out.println(uuid);
		}
	}
	
	@Test
	 public void  randomDate() {
	        try {
	            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	            Date start = format.parse("1970-1-1");// 构造开始日期
	            Date end = format.parse("2020-1-1");// 构造结束日期
	            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
	            if (start.getTime() >= end.getTime()) {
//	                return null;
	            }
	            long date = random(start.getTime(), end.getTime());
	            Date d = new Date(date);
	            	System.out.println(d.toString());
	            	System.out.println(format.format(d));
//	            return new Date(date);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
//	        return null;
	    }
	  private  long random(long begin, long end) {
	        long rtn = begin + (long) (Math.random() * (end - begin));
	        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
	        if (rtn == begin || rtn == end) {
	            return random(begin, end);
	        }
	        return rtn;
	    }
	  



	  @Test
	  public void test6() {
		  int num = (int)(Math.random()*1000);
		  System.out.println(num);
	  }
//	  @Test
//	  public void test7() throws IOException {
//		  File file = new File("/Users/liuchanglin/TRS/datacreate/datas/person.trs");
//		  for(int i = 0 ; i < 10 ; i++ ) {
//			  System.out.println(OutputUtil.getRandomLineFromFile(file));
//		  }
//	  }
	  @Test
	  public void test8() {
//		  String amount = PropUtil.getValueOf("PersonAmount");
	  }
	  @Test
	  public void test9() throws ParseException {
		  for(int i = 0 ; i <10 ; i++) {
//			  System.out.print(DateUtil.getDateAStrsFormat());
		  }
	  }
	  @Test
	  public void test10() {
		  System.out.println(PropUtil.PassengerAmount);
		  System.out.println(PropUtil.PersonAmount);
		  System.out.println(PropUtil.ThreadAmount);
	  }
	  @Test
	  public void test11() {
		  int a = 100;
		  for(int i = 0; i < 200 ; i++) {
			  System.out.print(a+" ");
			  if(i == 100) {
				  a = 99;
			  }
		  }
	  }
	  @Test
	  public void test12() {
		  StringBuffer sb = new StringBuffer("");
		  sb.append("1234").append("2312").append("2312");
		  System.out.println(sb.toString());
	  }
	  @Test
	  public void test13() {
		  System.out.println(21%100);
	  }
}
