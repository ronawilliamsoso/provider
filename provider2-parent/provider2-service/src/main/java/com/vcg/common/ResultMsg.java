package com.vcg.common;

public class ResultMsg {
	//状态码
	private int status;
	//请求结果描述
	private String messgae;
	
	//数据
	private Object data;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessgae() {
		return messgae;
	}
	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
