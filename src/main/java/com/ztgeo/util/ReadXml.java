package com.ztgeo.util;

import java.io.File;
import java.util.List;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ReadXml {
	public static String mongodbUrl;//mongodb数据库url
	public static String dataBase;//mongodb数据库名称
	public static String collectionName;//mongodb集合名称
	public static int port;//mongodb的集合名称
	public static String localExcelPath;//本地文件存放目录
	
	public static void readXml(){
		SAXReader reader = new SAXReader();
		try {
			String userdir = System.getProperty("catalina.home");
			//测试使用 发布环境需要修改
			String filePath ="D:\\apache-tomcat-8.0.46-windows-x64\\apache-tomcat-8.0.46\\webapps\\MongoLogEXP\\static\\xml\\property.xml";
			//String filePath =userdir+"D:\\apache-tomcat-8.0.46-windows-x64\\apache-tomcat-8.0.46\\webapps\\MongoLogEXP\\static\\xml\\property.xml";
			System.out.println("当前的配置文件地址:"+filePath);
			Document doc = reader.read(new File(filePath));
			Element root = doc.getRootElement();
			List<Element> elements = root.elements();
			for (Element e : elements) {
				String elementName = e.getName();
				switch (elementName) {
				case "mongodbUrl":
					mongodbUrl = e.getText();
					System.out.println("mongodbUrl:"+mongodbUrl);
					break;
				case "dataBase":
					dataBase = e.getText();
					System.out.println("dataBase:"+dataBase);
					break;
				case "collectionName":
					collectionName = e.getText();
					System.out.println("collectionName:"+collectionName);
					break;
				case "port":
					String portStr = e.getText();
					port = Integer.valueOf(portStr).intValue();
					System.out.println("port:"+port);
					break;	
				case "localExcelPath":
				    localExcelPath = e.getText();
					System.out.println("localExcelPath:"+localExcelPath);
					break;		
				default:
					break;
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
