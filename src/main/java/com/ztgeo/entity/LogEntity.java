package com.ztgeo.entity;

import com.google.gson.JsonObject;

//日志实体类
public class LogEntity {
	private String UserId;
	private String Ip;
	private JsonObject OperationTime;
	private String OperationString;
	private String TableName;
	private JsonObject _id;
	private String OracleId;
	private String ProcessId;
	private JsonObject Data;
	
	public LogEntity() {
		// TODO Auto-generated constructor stub
	}

	
	



	public LogEntity(String userId, String ip, JsonObject operationTime, String operationString, String tableName,
			JsonObject _id, String oracleId, String processId, JsonObject data) {
		super();
		UserId = userId;
		Ip = ip;
		OperationTime = operationTime;
		OperationString = operationString;
		TableName = tableName;
		this._id = _id;
		OracleId = oracleId;
		ProcessId = processId;
		Data = data;
	}








	public String getUserId() {
		return UserId;
	}






	public void setUserId(String userId) {
		UserId = userId;
	}






	public String getIp() {
		return Ip;
	}






	public void setIp(String ip) {
		Ip = ip;
	}






	public JsonObject getOperationTime() {
		return OperationTime;
	}






	public void setOperationTime(JsonObject operationTime) {
		OperationTime = operationTime;
	}






	public String getOperationString() {
		return OperationString;
	}






	public void setOperationString(String operationString) {
		OperationString = operationString;
	}






	public String getTableName() {
		return TableName;
	}






	public void setTableName(String tableName) {
		TableName = tableName;
	}






	public JsonObject get_id() {
		return _id;
	}






	public void set_id(JsonObject _id) {
		this._id = _id;
	}






	public String getOracleId() {
		return OracleId;
	}






	public void setOracleId(String oracleId) {
		OracleId = oracleId;
	}






	public String getProcessId() {
		return ProcessId;
	}






	public void setProcessId(String processId) {
		ProcessId = processId;
	}






	public JsonObject getData() {
		return Data;
	}






	public void setData(JsonObject data) {
		Data = data;
	}






	@Override
	public String toString() {
		return "LogEntity [UserId=" + UserId + ", Ip=" + Ip + ", OperationTime=" + OperationTime + ", OperationString="
				+ OperationString + ", TableName=" + TableName + ", _id=" + _id + ", OracleId=" + OracleId
				+ ", ProcessId=" + ProcessId + ", Data=" + Data + "]";
	}
	
	
}
