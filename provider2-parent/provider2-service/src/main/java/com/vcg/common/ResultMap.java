package com.vcg.common;

import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;




/**
 * 继承 hashMap
 * @author kangminggang
 *
 * @param <V>
 */
@SuppressWarnings("rawtypes")
public class ResultMap extends HashMap{


	private static final long serialVersionUID = 8755792260930054771L;
	
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
	
	public boolean containsNoReplaceKey(Object key) {
		return super.containsKey(key);
	}


	public Object putNoReplace(Object key, Object value) {

		return super.put(key, value);
	}
	
	@Override
	public Object get(Object key) {

		Object o=  super.get(getReplaceMapKey(key));
		if(o==null)o="";
		return o;
	}



	@Override
	public boolean containsKey(Object key) {
		return super.containsKey(getReplaceMapKey(key));
	}



	@Override
	public Object remove(Object key) {
		return super.remove(getReplaceMapKey(key));
	}



	@SuppressWarnings("unchecked")
	@Override
	public Object put(Object key, Object value) {
		if (containsKey(key)){
			 throw new IllegalArgumentException(" already contains value for " + key);
		}
		if( value!=null&&value instanceof Date){
			String date=FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(value);
			return super.put( getReplaceMapKey(key), date);
		}/*else if(value instanceof CLOB){
			CLOB clob=(CLOB)value;
			try {
				String a= (clob != null ? clob.getSubString(1, (int) clob.length()) : null);
				return super.put( getReplaceMapKey(key), a);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return super.put( getReplaceMapKey(key), value);
			
		}*/else{
			return super.put( getReplaceMapKey(key), value);
		}
		
	}
	private String getReplaceMapKey(Object key) {
		return ColumnConvert.getReplaceMapKey(key+"");
	}

	
}
