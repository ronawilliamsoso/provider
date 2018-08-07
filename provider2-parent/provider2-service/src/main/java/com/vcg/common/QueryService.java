package com.vcg.common;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;



@Component
public class QueryService {
	
	@Autowired
	private BaseDao baseDao;
	
	
	/**
	 * @param namespace
	 * @param queryName
	 * @param pageNum
	 * @param pageSize
	 * @param paramsMap
	 * @return
	 */
	public PageInfo<ResultMap> queryPageForCustom(String namespace,String queryName,Object paramsMap,int pageNum,int pageSize){
		
		 PageHelper.startPage(pageNum, pageSize);
		 
		 List<ResultMap> rowLst=  baseDao.findList("mapper.custom." +namespace+"." +  queryName,paramsMap);
		 return new PageInfo<ResultMap>(rowLst);
	}
	
	/**
	 * @param namespace
	 * @param queryName
	 * @param pageNum
	 * @param pageSize
	 * @param paramsMap
	 * @return
	 */
	public PageInfo<ResultMap> queryPageForCustom(String namespace,String queryName,Map<String,Object> paramsMap){
		
		int pageNum=paramsMap.get("pageNum")==null?1:Integer.parseInt(paramsMap.get("pageNum")+"");
		int pageSize=paramsMap.get("pageSize")==null?10:Integer.parseInt(paramsMap.get("pageSize")+"");
		if(paramsMap.get("orderBy") == null){
			PageHelper.startPage(pageNum, pageSize);
		}else{
			PageHelper.startPage(pageNum, pageSize, paramsMap.get("orderBy").toString());
		}
		 
		 
		 List<ResultMap> rowLst=  baseDao.findList("mapper.custom." +namespace+"." +  queryName,paramsMap);
		 return new PageInfo<ResultMap>(rowLst);
	}
	
	
	/**
	 * 不分页查询
	 * @param namespace
	 * @param queryName
	 * @param pageNum
	 * @param pageSize
	 * @param paramsMap
	 * @return
	 */
	public List<ResultMap> queryListForCustom(String namespace,String queryName,Map<String,Object> paramsMap){
		
		 List<ResultMap> rowLst=  baseDao.findList("mapper.custom." +namespace+"." +  queryName,paramsMap);
		 return rowLst;
	}

	

	/**
	 * 不分页查询
	 * @param namespace
	 * @param queryName
	 * @param pageNum
	 * @param pageSize
	 * @param paramsMap
	 * @return
	 */
	public ResultMap queryOneForCustom(String namespace,String queryName,Map<String,Object> paramsMap){
		
		 ResultMap resultMap=  baseDao.findOne("mapper.custom." +namespace+"." +  queryName,paramsMap);
		 return resultMap;
	}
	

	/**
	 * 自定义更新
	 * 
	 * @param namespace
	 * @param queryName
	 * @param paramsMap
	 * @return
	 */
	public int updateForCustom(String namespace,String queryName,Map<String,Object> paramsMap){
		
		 return baseDao.update("mapper.custom." +namespace+"." +  queryName,paramsMap);
	}
}
