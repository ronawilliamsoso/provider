package com.vcg.common;

/**
 * 返回json 結果工廠類
 * 
 * @author kangmg
 *
 */
public class RestfulResultFactory {

	public static <T> RestfulResult<T> getInstance(int code, T data, String msg) {

		return new RestfulResult<T>(code, data, msg);
	}

	public static <T> RestfulResult<T> getInstance(T data) {

		return new RestfulResult<T>(200, data, null);
	}

	public static <T> RestfulResult<T> getInstance(int code, String message) {

		return new RestfulResult<T>(code, null, message);
	}
}
