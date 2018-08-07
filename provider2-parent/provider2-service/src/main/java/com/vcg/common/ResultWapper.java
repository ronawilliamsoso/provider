package com.vcg.common;

public class ResultWapper<T> {

	private static final int STATUS_OK=200;
	
	//返回码：200正常
	private int code;
	//内容信息：返回对象
	private T data;
	//需要返回的业务信息：手写
	private String message;
	
	//异常信息
	private Exception error;
	//返回类型，特殊情况页面解析不同时分类
	private int type;
	//页面回调方法
	private String fun;
	

	public ResultWapper(T t) {
		super();
		this.data=t;
		this.code=STATUS_OK;
	}
	public ResultWapper(T t,int code) {
		super();
		this.data=t;
		this.code=code;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Exception getError() {
		return error;
	}
	public void setError(Exception error) {
		this.error = error;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getFun() {
		return fun;
	}
	public void setFun(String fun) {
		this.fun = fun;
	}
}
