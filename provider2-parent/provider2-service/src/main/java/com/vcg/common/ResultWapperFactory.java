package com.vcg.common;

public class ResultWapperFactory {
	
	/**
	 * result mapper 工厂类
	 * @param data
	 * @return
	 */
	public static <T> ResultWapper<T> getResultWrap(T data){
		return new ResultWapper<T>(data);
	}
	
	/**
	 * result mapper 工厂类
	 * @param data
	 * @return
	 */
	public static <T> ResultWapper<T> getResultWrap(T data,int code){
		return new ResultWapper<T>(data,code);
	}
	
	
}
