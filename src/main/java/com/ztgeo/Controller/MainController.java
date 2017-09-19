package com.ztgeo.Controller;

import java.io.File;
import junit.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztgeo.serviceImpl.ServiceImpl;
import com.ztgeo.util.ReadXml;

//控制层
@Controller
public class MainController {
	
	//装配属性 
	@Resource(name="service")
	private ServiceImpl service;
	
	@RequestMapping(value="/aaa",produces="text/html; charset=UTF-8")//method=RequestMethod.POST
	@ResponseBody
	public  void expExcel(HttpServletResponse response,HttpSession session,
			//参数列表
			@RequestParam(value="dah",required=false) String dah,
			@RequestParam(value="username",required=false) String username,
			@RequestParam(value="tablename",required=false) String tablename,
			@RequestParam(value="beginTime",required=false) String beginTime,
			@RequestParam(value="endTime",required=false) String endTime
			){
		System.out.println("进入了方法"+dah+username+tablename+beginTime+endTime);
		//服务器上生成文件
		//File file = this.createFile(session);
		File file  = new File("D://测试周报-魏浩-2017.9.11-9.15.xls");
		
		//获取服务器生成的本地文件
		ReadXml.readXml();
		
		response.setCharacterEncoding("utf-8"); //下载文件就是用servlet 的response写文件
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName="+file.getName());
		//使用流的形式将需要下载的文件写入数组
		try {
			InputStream is = new FileInputStream(file);
			//将相应和输出流绑定
			OutputStream out = response.getOutputStream();
			byte[] bt = new byte[is.available()];//文件流的长度是数组的长度
			int length;
			while((length=is.read(bt))>0){
				out.write(bt, 0, length);
			}
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void test(){
		String dbh ="";
		String username ="";
		String tablename = "";
		String beginTime="20170801";
		String endTime="20170802";
		
		
		//读取xml
		ReadXml.readXml();
		//获得连接 
		new ServiceImpl().getData(dbh,username,tablename,beginTime,endTime);
		//调取service方法
	}
	
}
