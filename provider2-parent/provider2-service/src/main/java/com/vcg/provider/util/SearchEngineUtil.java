package com.vcg.provider.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.naming.directory.SearchResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.alibaba.fastjson.JSON;
import com.vcg.common.JsonUtil;
import com.vcg.common.RestTemplateFactory;
import com.vcg.provider.entity.KCategory;
@Component
public class SearchEngineUtil {
 
 
	
	@Value("${interface.keywordUrl}")
	private String keywordUrl;
	
	@Value("${interface.sousuoUrl}")
	private String sousuoUrl;
	
 
	
	private org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(getClass());
	
 
	
	public static final Logger logger = Logger.getLogger(SearchEngineUtil.class);
	
	private SearchResult searchCommon(String url,Map<String,Object> params){
		log.info(url);
		String jsonString = JSON.toJSONString(params);
		log.info(jsonString);
		SearchResult postForObject = RestTemplateFactory.getTemplate().postForObject(url, jsonString, SearchResult.class);
		return postForObject;
	}
	 
	
    /**
     * 搜索编辑类图片
     * @param params
     * @return
     */
    public SearchResult searchEditorialResource(Map<String,Object> params){
		
    	return searchCommon(sousuoUrl+"editorial_query", params);
	}
    
    /**
     * 搜索地址下级目录
     * @param params
     * @return
     */
    public  String searchLocations(Map<String,Object> params){
		RestTemplate rt= RestTemplateFactory.getTemplate();
		String result = rt.postForObject(keywordUrl+"/location/find",params, String.class);
		return result;
		
	}

	
    /**
     * 搜索创意类图片
	 * @param params
	 * @return
	 */
	public SearchResult searchcreativeResource(Map<String,Object> params){
		String jsonString = JSON.toJSONString(params);
		log.info(jsonString);
		return searchCommon(sousuoUrl+"creative_query", params);
		
	}
	 
 
	 /**
	  * 得到分类
	 * @param pid
	 * @return
	 */
	public List<KCategory> getCategory(Integer pid){
		
		try {

			RestTemplate rt= RestTemplateFactory.getTemplate();
			Map<String,Object> params=new HashMap<String,Object>();
			if(pid!=null){
				params.put("pid", pid);
			}
			String msg= rt.postForObject(keywordUrl+"category/find",params, String.class);
			
			List<KCategory> result=JsonUtil.readJson(msg,List.class,KCategory.class);
			List<KCategory> result2= new LinkedList<>();
			for (int i =0;i<result.size();i++) {
				if(result.get(i).getId()!=220639){//去掉海外这个分类
					result2.add(result.get(i));
				}
				
			}
			return result2;
		}  catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	 
	
}
