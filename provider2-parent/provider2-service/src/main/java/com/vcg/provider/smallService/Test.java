package com.vcg.provider.smallService;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.vcg.common.ResultMap;

@Component
public class Test {
	
	public static void ts(){
		String url = "http://192.168.3.77:8080/crm1/service/getSaledPicList.action?"
				+ "providerId=1074&beginDate=2015-06-01&endDate=2015-06-30";
		RestTemplate rs = new RestTemplate();
		String re = rs.postForObject(url, null, String.class);
		String[] record = re.split("\r\n");
		for(String s: record){
			String[] sub = s.split(",");
			
			for(String d : sub){
				System.err.print(d + " , ");
			}
			System.err.println(sub.length);
		}
		
	}
	
	public static void tt(){
		ResultMap map = new ResultMap();
		map.put("account_name", "ok");
		System.err.println(map);
	}
	
//	@Scheduled(cron="0 15 16 * * *")
	public void schedule(){
		System.err.println("Hello World");
	}
	
	public static void main(String[] args) throws ParseException {
		
		
	}

}
