package com.ztgeo.util;

import org.junit.Test;

public class FormateTime {
	//获得年
	public static int getYear(String timeStr){
		int a = Integer.valueOf(timeStr.substring(0,4)).intValue();
		System.out.println(a);
		return a;
	}
	
	//获得月
	public static int getMonth(String timeStr){
		int a = Integer.valueOf(timeStr.substring(4,6)).intValue();
		System.out.println(a);
		return a;
	}
	
	//获得日
	public static int getDay(String timeStr){
		int a = Integer.valueOf(timeStr.substring(6,8)).intValue();
		System.out.println(a);
		return a;
	}
	
	@Test
	public void test(){
		FormateTime.getYear("20170815");
		FormateTime.getMonth("20170815");
		FormateTime.getDay("20170815");
	}
}
