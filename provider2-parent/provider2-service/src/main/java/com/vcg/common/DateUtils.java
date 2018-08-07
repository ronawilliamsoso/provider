package com.vcg.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class DateUtils {

	
	public static Date getNowDate(){
		Calendar c=Calendar.getInstance();
		return c.getTime();
	}
	
	public static Date parseDate(String date,String dateFormat){
		try {
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(StringUtils.isNoneBlank(dateFormat)){
				format=new SimpleDateFormat(dateFormat);
			}
			return format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<String> getMonthListBetween(String minDate, String maxDate) throws ParseException { 
		//minDate = '2017-01'
		//maxDate = '2018-01'
		minDate = minDate+"-01";
		maxDate = maxDate+"-01";
 
		ArrayList<String> result = new ArrayList<String>();
		 
		SimpleDateFormat yyyyMMdd=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");//格式化为
		  Date date1 = null; // 开始日期
		  Date date2 = null; // 结束日期
		  try {
		   date1 = yyyyMMdd.parse(minDate);
		   date2 = yyyyMMdd.parse(maxDate);
		   Calendar c1 = Calendar.getInstance();
		   Calendar c2 = Calendar.getInstance();
	 
		   c1.setTime(date1);
		   c2.setTime(date2);
		   while (c1.compareTo(c2) <= 0) {
			  Date ss = c1.getTime();
			  String str = sdf.format(ss);
			  result.add(str);
		      c1.add(Calendar.MONTH, 1);// 开始日期加一个月直到等于结束日期为止
 
		   }
		  } catch (ParseException e) {
		   e.printStackTrace();
		  }
		  return result;
		
	}
	
	public static Date parseStartDate(String date){
		try {
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date=date+" 00:00:00";
			return format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Date parseEndDate(String date){
		try {
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date=date+" 23:59:59";
			return format.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 得到某月的第一天和最后一天
	 * @param month 
	 * @return
	 */
	public static Map<String,Date> getMonthDay(int month){
		Map<String,Date> result=new HashMap<String,Date>();
		Calendar c=Calendar.getInstance();
		c.add(Calendar.MONTH, month);
		
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		
		Date startTime=c.getTime();
		c.set(Calendar.DAY_OF_MONTH, 
				c.getActualMaximum(Calendar.DAY_OF_MONTH));
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		Date endTime=c.getTime();
		result.put("startTime", startTime);
		result.put("endTime", endTime);
		return result;
	}
	
	/**
	 * 得到某年的第一天和最后一天
	 * @param year 
	 * @return
	 */
	public static Map<String,Date> getYearDay(int year){
		Map<String,Date> result=new HashMap<String,Date>();
		Calendar c=Calendar.getInstance();
		c.add(Calendar.YEAR, year);
		
		c.set(Calendar.DAY_OF_YEAR, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		
		Date startTime=c.getTime();
		c.set(Calendar.DAY_OF_YEAR, 
				c.getActualMaximum(Calendar.DAY_OF_YEAR));
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		Date endTime=c.getTime();
		result.put("startTime", startTime);
		result.put("endTime", endTime);
		return result;
	}
	
	/**
	 * 得到某周的开始时间和结束时间
	 * @param week
	 * @return
	 */
	public static Map<String,Date> getWeekDay(int week){
		Map<String,Date> result=new HashMap<String,Date>();
		Calendar c=Calendar.getInstance();
		c.add(Calendar.WEEK_OF_YEAR, week);
		
		c.set(Calendar.DAY_OF_WEEK, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		
		c.add(Calendar.DAY_OF_YEAR,1);
		Date startTime=c.getTime();
		
		c.set(Calendar.DAY_OF_WEEK, 
				c.getActualMaximum(Calendar.DAY_OF_WEEK));
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.add(Calendar.DAY_OF_YEAR,1);
		Date endTime=c.getTime();
		result.put("startTime", startTime);
		result.put("endTime", endTime);
		return result;
	}
	
	/**
	 * 得到某天的开始时间和结束时间
	 * @param day
	 * @return
	 */
	public static Map<String,Date> getDay(int day){
		Map<String,Date> result=new HashMap<String,Date>();
		Calendar c=Calendar.getInstance();
		c.add(Calendar.DAY_OF_YEAR, day);
		
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		
		Date startTime=c.getTime();
		
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		Date endTime=c.getTime();
		result.put("startTime", startTime);
		result.put("endTime", endTime);
		return result;
	}
	
	/**
	 *今天开始时间
	 * @param date
	 * @return
	 */
	public static Date getStartByDay(Date date){
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	

	/**
	 *今天结束时间
	 * @param date
	 * @return
	 */
	public static Date getEndByDay(Date date){
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return c.getTime();
	}
	
	/**
	 * 日期转时间（包含时分秒）字符串
	 * @param date
	 * @return
	 */
	public static String fomatToTimeString(Date date){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(date != null){
			return format.format(date);
		}else{
			return null;
		}
	}
	/**
	 * 日期转日期（不包含时分秒）字符串
	 * @param date
	 * @return
	 */
	public static String formatToDateString(Date date){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		if(date != null){
			return format.format(date);
		}else{
			return null;
		}
	}
	
	/**
	 * 获取某月开始时间
	 * @param date
	 * @return
	 */
	public static String getMonthBegin(Date date){
		if(date != null){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(Calendar.DAY_OF_MONTH, 1);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			return format.format(cal.getTime());
		}else{
			return null;
		}
		
	}
	
	/**
	 * 获取某月结束时间
	 * @param date
	 * @return
	 */
	public static String getMonthEnd(Date date){
		if(date != null){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(Calendar.DAY_OF_MONTH, 
					cal.getActualMaximum(Calendar.DAY_OF_MONTH));
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			return format.format(cal.getTime());
		}else{
			return null;
		}
	}
	
	
	 public static int daysBetween(Date startdate,Date enddate) throws ParseException    
	    {    
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
	        startdate=sdf.parse(sdf.format(startdate));  
	        enddate=sdf.parse(sdf.format(enddate));  
	        Calendar cal = Calendar.getInstance();    
	        cal.setTime(startdate);    
	        long time1 = cal.getTimeInMillis();                 
	        cal.setTime(enddate);    
	        long time2 = cal.getTimeInMillis();         
	        long between_days=(time2-time1)/(1000*3600*24);  
	            
	       return Integer.parseInt(String.valueOf(between_days));           
	    }  
	 
		public static String formateDate(Date date,String dateFormat){
			
			try {
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				if(StringUtils.isNoneBlank(dateFormat)){
					format=new SimpleDateFormat(dateFormat);
				}
				return format.format(date);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	
	public static void main(String[] args) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.err.println(format.format(getStartByDay(new Date())));
		System.err.println(format.format(getEndByDay(new Date())));
		System.err.println(format.format(getYearDay(-1).get("startTime")));
		System.err.println(format.format(getYearDay(0).get("endTime")));
		Map<String, Date> day = getWeekDay(-1);
		System.err.println(format.format(day.get("startTime")));
		System.err.println(format.format(day.get("endTime")));
		Map<String,Date> day1 = getDay(-1);
		System.err.println(format.format(day1.get("startTime")));
		System.err.println(format.format(day1.get("endTime")));
	}
}
