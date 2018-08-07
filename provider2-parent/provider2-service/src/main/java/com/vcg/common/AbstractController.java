package com.vcg.common;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractController {
	
	public Logger logger=LoggerFactory.getLogger(AbstractController.class);
	
	@Autowired
	public QueryService queryService;
	
	protected Map<String,Object> parseRequestParam(HttpServletRequest  request){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		Enumeration<String> paramNames=request.getParameterNames();
		while(paramNames.hasMoreElements()){
			String key=paramNames.nextElement();
			String value=request.getParameter(key);
			if(StringUtils.isNotBlank(value)){
				if(value.indexOf(",")!=-1){
					List<String> lst=new ArrayList<String>();
					String[] values=value.split(",");
					for(String v:values){
						if(StringUtils.isNotBlank(v)){
							lst.add(v);
						}
					}
					paramMap.put(key, lst);
				}else{
					paramMap.put(key,value);
				}
				
			}
			
		}
		return paramMap;
	}
	
	public Map<String,Object> getParams(){
		return new HashMap<String,Object>();
	}
	
	public Map<String,Object> initParams(Map<String,Object> params){
		if(params==null){
			params=this.getParams();
		}
		
		if(params.get("pageNum")==null){
			params.put("pageNum", 1);
		}
		
		if(params.get("pageSize")==null){
			params.put("pageSize", 10);
		}
		
		
		
		
		return params;
		
	}
	
	public boolean isJava(HttpServletRequest  request){
		
		String ifJava=request.getParameter("ifJava");
		return StringUtils.isBlank(ifJava)?false:true;
	}
}
