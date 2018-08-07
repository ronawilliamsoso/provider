package com.vcg.common;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("rawtypes")
@ApiModel
public class RestfulResult<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 700746643833129896L;

	 @ApiModelProperty(value = "返回状态  200:为成功,201:失败")
	private int status;

	 @ApiModelProperty(value = "包含List,pageNum,pageSize,total,isFirstPage等信息")
	private T data;

	 @ApiModelProperty(value = "消息")
	private String message;

	public RestfulResult(int status, T data, String message) {
		super();
		this.status = status;
		this.data = data;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public void setMessage(String msg) {
		this.message = msg;
	}

}
