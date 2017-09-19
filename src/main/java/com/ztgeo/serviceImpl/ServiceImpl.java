package com.ztgeo.serviceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.Bytes;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.ztgeo.entity.LogEntity;
import com.ztgeo.mongoConn.Mongo;
import com.ztgeo.util.FormateTime;

@Repository("service")
public class ServiceImpl {
	//装配mongo连接
	
	//获取数据的方法
	public void getData(String dbh, String username, String tablename, String beginTime, String endTime) {
		List<LogEntity> logEntities = new ArrayList<>();
		 System.out.println("进入了service方法!!");
		 //获得连接
		 Mongo m = new Mongo();
		 DBCollection col = m.getConn();
		 //拼接参数
		 BasicDBObject query = new BasicDBObject();
		 if(dbh!=null&&!"".equals(dbh)){
			 query.append("TaskInfoId", dbh);
		 }
		 if(username!=null&&!"".equals(username)){
			 query.append("UserId", username);
		 }
		 if(tablename!=null&&!"".equals(tablename)){
			 query.append("TableName", tablename);
		 }
		 
		 //开始时间以及结束时间
		 int startYear=FormateTime.getYear(beginTime),endYear=FormateTime.getYear(endTime);  
		 int startMonth=FormateTime.getMonth(beginTime),endMonth=FormateTime.getMonth(endTime);  
		 int startDay=FormateTime.getDay(beginTime),endDay=FormateTime.getDay(endTime);  
		 query.put("OperationTime", BasicDBObjectBuilder.start("$gte", new Date(startYear - 1900, startMonth - 1, startDay)).add("$lt", new Date(endYear - 1900, endMonth - 1, endDay)).get());  
		 
		 //定义需要显示的字段
		 BasicDBObject keys = new BasicDBObject();
		 keys.put("UserId", 1);
		 keys.put("Ip", 1);
		 keys.put("OperationTime", 1);
		 keys.put("OperationString", 1);
		 keys.put("TableName", 1);
		 keys.put("_id", 1);
		 keys.put("OracleId", 1);
		 keys.put("ProcessId", 1);
		 keys.put("Data", 1);
		 DBCursor cursor = col.find(query,keys).addOption(Bytes.QUERYOPTION_NOTIMEOUT);//设置游标不超时 防止被回收游标报错
		 try {
			   while(cursor.hasNext()) {
				  logEntities.add(saveAsEntity(cursor.next().toString()));//加入数组
			   }
			} finally {
			   cursor.close();
			}
		 //遍历结束 将结果集 写入到文件中
		 
	}

	//分析json数据 保存到 相关 表中
	public LogEntity saveAsEntity(String jsonStr){
		return new Gson().fromJson(jsonStr, LogEntity.class);
	}
	
	//连接mongo  组织参数进行查询  
	
}
