package com.ztgeo.mongoConn;

import java.net.UnknownHostException;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.ztgeo.util.ReadXml;

public class Mongo {
	public DBCollection getConn(){
		/*MongoDatabase database =  new MongoClient(ReadXml.mongodbUrl,ReadXml.port).getDatabase(ReadXml.dataBase);
		DBCollection col = (DBCollection) database.getCollection(ReadXml.collectionName);
		System.out.println("collectionname:"+col);*/
		DBCollection col;
		MongoClient mongoClient=new MongoClient(ReadXml.mongodbUrl,ReadXml.port);
		DB db = mongoClient.getDB(ReadXml.dataBase);
		System.out.println("DB"+db);
		col = db.getCollection(ReadXml.collectionName);
		System.out.println("连接成功!!");
		return col;
	}
	
}
