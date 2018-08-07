package com.vcg.provider.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.github.pagehelper.StringUtil;
import com.vcg.common.DateUtils;

public class RequestUtil {
	/**
	 * 前台时间转换
	 * yesterday：昨天
	 * today：今天
	 * thisWeek：本周
	 * lastWeek：上周
	 * nextWeek：下周
	 * startTime,endTime：开始时间/结束时间
	 * @param timeParam
	 * @return
	 */
	public static Map<String,Date> changeToInterval(String timeParam){
		Map<String,Date> result = new HashMap<>();
		if(StringUtil.isNotEmpty(timeParam)){
			if("yesterday".equalsIgnoreCase(timeParam)){
				result = DateUtils.getDay(-1);
			}else if("today".equalsIgnoreCase(timeParam)){
				result = DateUtils.getDay(0);
			}else if("thisWeek".equalsIgnoreCase(timeParam)){
				result = DateUtils.getWeekDay(0);
			}else if("lastWeek".equalsIgnoreCase(timeParam)){
				result = DateUtils.getWeekDay(-1);
			}else if("nextWeek".equalsIgnoreCase(timeParam)){
				result = DateUtils.getWeekDay(1);
			}else if(timeParam.contains(",")){
				String[] datestr = timeParam.split(",");
				if(datestr.length > 1){
					result.put("startTime", DateUtils.parseDate(datestr[0], "yyyy-MM-dd HH:mm:ss"));
					result.put("endTime", DateUtils.parseDate(datestr[1], "yyyy-MM-dd HH:mm:ss"));
				}
			}else if("thisMonth".equalsIgnoreCase(timeParam)){
				result = DateUtils.getMonthDay(0);
			}else if("lastMonth".equalsIgnoreCase(timeParam)){
				result = DateUtils.getMonthDay(-1);
			}else if("nextMonth".equalsIgnoreCase(timeParam)){
				result = DateUtils.getMonthDay(1);
			}
			
		}
		return result;
	}
	
	public static Map<String, Object> beanToMap(Object entity){
		Map<String,Object> param = new HashMap<>();
		Field[] fields = entity.getClass().getDeclaredFields();
		for(int i = 0; i < fields.length;i++){
			String fieldName = fields[i].getName();
			Object o = null;
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			StringBuffer getMethodName = new StringBuffer();
			getMethodName.append("get").append(firstLetter).append(fieldName.substring(1));
			try {
				Method getMethod = entity.getClass().getMethod(getMethodName.toString(), new Class[] {});
				o = getMethod.invoke(entity, new Object[] {});
			} catch (Exception e) {
				e.printStackTrace(); 
			}
			if(o != null){
				param.put(fieldName, o);
			}
		}
		return param;	
	}
	public static void main(String[] args){
		String timeParam = "2015-03-05 12:23:34,2016-02-12 12:45:56";
		Map<String,Date> result = new HashMap<>();
		result = RequestUtil.changeToInterval(timeParam);
		System.err.println(DateUtils.fomatToTimeString(result.get("startTime")) + "====" 
				+ DateUtils.fomatToTimeString(result.get("endTime")));
	}
}
