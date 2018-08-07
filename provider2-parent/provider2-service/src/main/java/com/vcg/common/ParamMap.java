package com.vcg.common;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

public class ParamMap extends HashMap<String, Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public String getValue(Object key) {

		Object o= super.get(key);
		if(o==null){
			o="";
		}
		return o+"";
	}
	
	public Integer getIntegerValue(Object key) {

		Object o= super.get(key);
		if(o==null){
			o="";
		}
		String result=o+"";
		if(StringUtils.isNotBlank(result)){
			return Integer.parseInt(result);
		}
		return null;
	}

}
