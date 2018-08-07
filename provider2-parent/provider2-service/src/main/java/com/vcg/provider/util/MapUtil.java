package com.vcg.provider.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


@Component
public class MapUtil { 
	
	  public Integer  getInteger(Map<String, Object> map,String valuename) {
		  Object get = map.get(valuename);
		  if(get!=null){
			  String str = get.toString();
			  if(StringUtils.isNoneBlank(str)){
				  return Integer.parseInt(str);
			  }else{
				  return null;
			  }
		  }else{
			  return null;
		  }
	  }  
	  
	  public String  getString(Map<String, Object> map,String valuename) {
		  Object get = map.get(valuename);
		  if(get!=null){
			  String str = get.toString();
			  if(StringUtils.isNoneBlank(str)){
				  return str;
			  }else{
				  return null;
			  }
		  }else{
			  return null;
		  }
	  } 
	  
	  
	  public BigDecimal  getBigDecimal(Map<String, Object> map,String valuename) {
		  Object get = map.get(valuename);
		  if(get!=null){
			  String str = get.toString();
			  if(StringUtils.isNoneBlank(str)){
				  BigDecimal bd=new BigDecimal(str);   
				  bd=bd.setScale(2, BigDecimal.ROUND_HALF_UP); 
				  return bd;
			  }else{
				  return null;
			  }
		  }else{
			  return null;
		  }
	  } 
	  
	  public Date  getDate(Map<String, Object> map,String valuename,String format) {
		  SimpleDateFormat formatter = new SimpleDateFormat(format);
		  
		 
		  
		  
		  Object get = map.get(valuename);
		  if(get!=null){
			  String str = get.toString();
			  if(StringUtils.isNoneBlank(str)){
				  Date time;
				try {
					time = formatter.parse((String)map.get(valuename));
					 return time;
				} catch (ParseException e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
				 
			  }else{
				  return null;
			  }
		  }else{
			  return null;
		  }
	  } 
	  
	  public Date  getDateFromMillSecond(Map<String, Object> map,String valuename,String format) {
		  SimpleDateFormat formatter = new SimpleDateFormat(format);
		  
		 
		  
		  
		  Object get = map.get(valuename);
		  if(get!=null){
			  String str = get.toString();
			  if(StringUtils.isNoneBlank(str)){
				long l = Long.parseLong(str);
				Date date = new Date(l);  
 
				 return date;
				 
			  }else{
				  return null;
			  }
		  }else{
			  return null;
		  }
	  } 
	
	
	
}
