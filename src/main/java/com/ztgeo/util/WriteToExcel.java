package com.ztgeo.util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.junit.Test;

public class WriteToExcel {
	public static File loadDataBytes(){
		ReadXml.readXml();
		//指针一  指向不确定有无的文件夹
		File filePath = new File(ReadXml.localExcelPath);
		if(!filePath.exists()){//目录不存在
			filePath .mkdir();  //目录创建成功
		}
		
		
		
		//指针二 指向不确定是否有无的文件
		File fileExcel = new File(filePath.getAbsolutePath()+ "\\"+Calendar.getInstance().getTimeInMillis()+".xls");//用当前时间戳做名字
		if(!fileExcel.exists()){
			try {
				fileExcel.createNewFile();
			} catch (IOException e) {
				System.out.println("文件创建失败!!");
				e.printStackTrace();
			}
		}
		
		//写入文档
		
		
		return fileExcel;
	}
	
	@Test
	public void test(){
		WriteToExcel.loadDataBytes();
		
	}
}
