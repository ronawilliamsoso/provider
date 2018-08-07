package com.vcg.provider.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.github.pagehelper.StringUtil;
import com.vcg.provider.entity.SearchSellReport;
import com.vcg.provider.model.SearchProviderInfo;
import com.vcg.provider.entity.ProviderApplicationSearch;
import com.vcg.provider.entity.ReportConfirm;
import com.vcg.provider.entity.SearchBatch;
import com.vcg.provider.entity.SearchContractApplicationInfo;
import com.vcg.provider.entity.SearchContractInfo;
import com.vcg.common.DateUtils;
import com.vcg.common.Status;

public class SearchUtil {
 
	public static Map<String,Object> parseProviderParam(SearchProviderInfo requestParam){
		//searchParam
		Map<String,Object> searchParam=new HashMap<String,Object>();
		
		if(requestParam.getPageNum()==null){
			searchParam.put("pageNum", 0);
		}else{
			searchParam.put("pageNum", requestParam.getPageNum());
		}
		
		if(requestParam.getPageSize()==null){
			searchParam.put("pageSize", 20);
		}else{
			searchParam.put("pageSize", requestParam.getPageSize());
		}
		
		//资源类型 1:编辑类 2: 创意类
		if(requestParam.getAssetFamily()!=null){
			searchParam.put("assetFamily", requestParam.getAssetFamily());
		}
		if(requestParam.getAgentType()!=null){
			searchParam.put("type", requestParam.getAgentType());
		}
		if(requestParam.getStatus()!=null){
			searchParam.put("status", requestParam.getStatus());
		}
		if(requestParam.getQualityRank()!=null){
			searchParam.put("qualityRank", requestParam.getQualityRank());
		}
		if(requestParam.getIsNative()!=null){
			searchParam.put("isNative", requestParam.getIsNative());
		}
//		//搜索框
//		if( StringUtil.isNotEmpty( requestParam.getSearchName())){
//			 searchParam.put("searchName", requestParam.getSearchName());
//		 
//		}
		
		if(requestParam.getSearchType()!=null){ //1:查姓名 2:邮箱 3:手机号
			if(requestParam.getSearchType()==1){
				searchParam.put("nameCn", requestParam.getSearchName());
			}else if(requestParam.getSearchType()==2){
				searchParam.put("email", requestParam.getSearchName());
			}else if(requestParam.getSearchType()==3){
				searchParam.put("mobile", requestParam.getSearchName());
			}
			
		}
		 
        //因为是精确的值,所以有城市就只有城市,或者只有省,或者只有国家id
		if(requestParam.getCity()!=null&&StringUtils.isNotBlank((requestParam.getCity()))){
			searchParam.put("city",requestParam.getCity());
		}else if(requestParam.getProvince()!=null &&StringUtils.isNotBlank(requestParam.getProvince())){
			searchParam.put("province", requestParam.getProvince());
		}else if(requestParam.getCountry()!=null &&StringUtils.isNotBlank(requestParam.getCountry())){
			searchParam.put("country", requestParam.getCountry());
		}	
		

		//申请时间
		if(StringUtil.isNotEmpty(requestParam.getCreateTimeBegin())){//申请时间
			String uploadTime=requestParam.getCreateTimeBegin();
			if(uploadTime.equals("today")){
				//今天
				Map<String, Date> days = DateUtils.getDay(0);
				searchParam.put("createFrom",DateUtils.formateDate(days.get("startTime"),""));
				searchParam.put("createTo",DateUtils.formateDate(days.get("endTime"),""));
			}else if(uploadTime.equals("thisWeek")){
				//本周
				Map<String, Date> beans = DateUtils.getWeekDay(0);
				searchParam.put("createFrom",DateUtils.formateDate(beans.get("startTime"),""));
				searchParam.put("createTo",DateUtils.formateDate(beans.get("endTime"),""));
			}else if(uploadTime.equals("lastWeek")){
				//上周
				Map<String, Date> beans = DateUtils.getWeekDay(-1);
				searchParam.put("createFrom",DateUtils.formateDate(beans.get("startTime"),""));
				searchParam.put("createTo",DateUtils.formateDate(beans.get("endTime"),""));
			}else if(uploadTime.equals("lastMonth")){
				//上月
				Map<String, Date> beans = DateUtils.getMonthDay(-1);
				searchParam.put("passFrom",DateUtils.formateDate(beans.get("startTime"),""));
				searchParam.put("passTo",DateUtils.formateDate(beans.get("endTime"),""));
			}else if(uploadTime.equals("thisMonth")){
				//这个月
				Map<String, Date> beans = DateUtils.getMonthDay(0);
				searchParam.put("passFrom",DateUtils.formateDate(beans.get("startTime"),""));
				searchParam.put("passTo",DateUtils.formateDate(beans.get("endTime"),""));
			}else{
				String[] split = uploadTime.split(",");
				
				searchParam.put("createFrom",DateUtils.formateDate(DateUtils.parseStartDate(split[0]),""));
				searchParam.put("createTo",DateUtils.formateDate(DateUtils.parseEndDate(split[1]),""));
			}
 	
		}
		//通过
		if( StringUtil.isNotEmpty( requestParam.getPassTimeBegin())){//申请时间
			String uploadTime= requestParam.getPassTimeBegin();
			if(uploadTime.equals("today")){
				//今天
				Map<String, Date> days = DateUtils.getDay(0);
				searchParam.put("passFrom",DateUtils.formateDate(days.get("startTime"),""));
				searchParam.put("passTo",DateUtils.formateDate(days.get("endTime"),""));
			}else if(uploadTime.equals("thisWeek")){
				//本周
				Map<String, Date> beans = DateUtils.getWeekDay(0);
				searchParam.put("passFrom",DateUtils.formateDate(beans.get("startTime"),""));
				searchParam.put("passTo",DateUtils.formateDate(beans.get("endTime"),""));
			}else if(uploadTime.equals("lastWeek")){
				//上周
				Map<String, Date> beans = DateUtils.getWeekDay(-1);
				searchParam.put("passFrom",DateUtils.formateDate(beans.get("startTime"),""));
				searchParam.put("passTo",DateUtils.formateDate(beans.get("endTime"),""));
			}else if(uploadTime.equals("lastMonth")){
				//上月
				Map<String, Date> beans = DateUtils.getMonthDay(-1);
				searchParam.put("passFrom",DateUtils.formateDate(beans.get("startTime"),""));
				searchParam.put("passTo",DateUtils.formateDate(beans.get("endTime"),""));
			}else if(uploadTime.equals("thisMonth")){
				//这个月
				Map<String, Date> beans = DateUtils.getMonthDay(0);
				searchParam.put("passFrom",DateUtils.formateDate(beans.get("startTime"),""));
				searchParam.put("passTo",DateUtils.formateDate(beans.get("endTime"),""));
			}else{
				String[] split = uploadTime.split(",");
				
				searchParam.put("passFrom",DateUtils.formateDate(DateUtils.parseStartDate(split[0]),""));
				searchParam.put("passTo",DateUtils.formateDate(DateUtils.parseEndDate(split[1]),""));
			}
 	
		}
 
 
		return searchParam;
	}
	
	public static Map<String,Object> parseContractsParam(SearchContractInfo params){
		//searchParam
		Map<String,Object> searchParam=new HashMap<String,Object>();
		
		if(params.getPageNum()==null){
			searchParam.put("pageNum", 0);
		}else{
			searchParam.put("pageNum", params.getPageNum()-1);
		}
		
		if(params.getPageSize()==null){
			searchParam.put("pageSize", 20);
		}else{
			searchParam.put("pageSize", params.getPageSize());
		}
		
		//资源类型 1:编辑类 2: 创意类
		if(params.getAssetFamily()!=null){
			searchParam.put("assetFamily", params.getAssetFamily());
		}
		//合同属性：1 标准 2 买断 3 解约 4 外购 5续约
		if(params.getContractType()!=null){
			searchParam.put("contractType", params.getContractType());
		}
        //因为是精确的值,所以有城市就只有城市,或者只有省,或者只有国家id
		if(params.getCity()!=null&&StringUtils.isNotBlank((params.getCity()))){
			searchParam.put("city",params.getCity());
		}else if(params.getProvince()!=null &&StringUtils.isNotBlank(params.getProvince())){
			searchParam.put("province", params.getProvince());
		}else if(params.getCountry()!=null &&StringUtils.isNotBlank(params.getCountry())){
			searchParam.put("country", params.getCountry());
		}	
		//合同状态：0失效 1 有效
		if(params.getContractStatus()!=null){
			searchParam.put("contractStatus", params.getContractStatus());
		}
		

		//开始时间
		if(StringUtil.isNotEmpty(params.getBeginDate())){//申请时间
			String uploadTime=params.getBeginDate();
			if(uploadTime.equals("today")){
				//今天
				Map<String, Date> days = DateUtils.getDay(0);
				searchParam.put("beginFrom",DateUtils.formateDate(days.get("startTime"),""));
				searchParam.put("beginTo",DateUtils.formateDate(days.get("endTime"),""));
			}else if(uploadTime.equals("thisWeek")){
				//本周
				Map<String, Date> beans = DateUtils.getWeekDay(0);
				searchParam.put("beginFrom",DateUtils.formateDate(beans.get("startTime"),""));
				searchParam.put("beginTo",DateUtils.formateDate(beans.get("endTime"),""));
			}else if(uploadTime.equals("lastWeek")){
				//上周
				Map<String, Date> beans = DateUtils.getWeekDay(-1);
				searchParam.put("beginFrom",DateUtils.formateDate(beans.get("startTime"),""));
				searchParam.put("beginTo",DateUtils.formateDate(beans.get("endTime"),""));
			}else{
				String[] split = uploadTime.split(",");
				
				searchParam.put("beginFrom",DateUtils.formateDate(DateUtils.parseStartDate(split[0]),""));
				searchParam.put("beginTo",DateUtils.formateDate(DateUtils.parseEndDate(split[1]),""));
			}
 	
		}
		//通过
		if( StringUtil.isNotEmpty( params.getEndDate())){//申请时间
			String uploadTime= params.getEndDate();
			if(uploadTime.equals("today")){
				//今天
				Map<String, Date> days = DateUtils.getDay(0);
				searchParam.put("endFrom",DateUtils.formateDate(days.get("startTime"),""));
				searchParam.put("endTo",DateUtils.formateDate(days.get("endTime"),""));
			}else if(uploadTime.equals("thisWeek")){
				//本周
				Map<String, Date> beans = DateUtils.getWeekDay(0);
				searchParam.put("endFrom",DateUtils.formateDate(beans.get("startTime"),""));
				searchParam.put("endTo",DateUtils.formateDate(beans.get("endTime"),""));
			}else if(uploadTime.equals("lastWeek")){
				//上周
				Map<String, Date> beans = DateUtils.getWeekDay(-1);
				searchParam.put("endFrom",DateUtils.formateDate(beans.get("startTime"),""));
				searchParam.put("endTo",DateUtils.formateDate(beans.get("endTime"),""));
			}else{
				String[] split = uploadTime.split(",");
				
				searchParam.put("endFrom",DateUtils.formateDate(DateUtils.parseStartDate(split[0]),""));
				searchParam.put("endTo",DateUtils.formateDate(DateUtils.parseEndDate(split[1]),""));
			}
 	
		}
		
		//期限
		if(params.getDeadline()!=null){
			searchParam.put("deadline", params.getDeadline());
		}
		//搜索框
		if( StringUtil.isNotEmpty( params.getSearchName())){
			 searchParam.put("searchName", params.getSearchName());
		 
		}
		if(params.getExclusiveAuth()!=null){
			searchParam.put("exclusiveAuth", params.getExclusiveAuth());
		}
		if(params.getLicenseType()!=null){
			searchParam.put("licenseType", params.getLicenseType());
		}
		if(params.getRate()!=null){
			String[] rate = params.getRate().split(",");
			if(rate.length > 1){
				searchParam.put("rateFrom", rate[0]);
				searchParam.put("rateTo",  rate[1]);
			}

		}
		if(params.getType()!=null){
			searchParam.put("type", params.getType());
		}
 
		return searchParam;
	}
	
	public static Map<String,Object> parseconfirmReportsParam(ReportConfirm params){
		//searchParam
		Map<String,Object> searchParam=new HashMap<String,Object>();
		
		if(params.getPageNum()==null){
			searchParam.put("pageNum", 0);
		}else{
			searchParam.put("pageNum", params.getPageNum()-1);
		}
		
		if(params.getPageSize()==null){
			searchParam.put("pageSize", 20);
		}else{
			searchParam.put("pageSize", params.getPageSize());
		}
		 
		if(params.getReportMonth()!=null){
			searchParam.put("reportMonth", params.getReportMonth());
		}
		searchParam.put("isDefault", 1);
		
		if(params.getIsPublished()!=null){
			searchParam.put("isPublished", params.getIsPublished());
		}
		if(params.getIsConfirmed()!=null){
			searchParam.put("isConfirmed", params.getIsConfirmed());
		}
		if(params.getProviderId()!=null){
			searchParam.put("providerId", params.getProviderId());
		}
		if(params.getProviderName()!=null){
			searchParam.put("providerName", params.getProviderName());
		}
		if(params.getContractName()!=null){
			searchParam.put("contractName", params.getContractName());
		}
  
		return searchParam;
	}
	
	public static Map<String,Object> getSubmitTime(SearchBatch params){

		Date[] time = {};
		Map<String, Date> beans = null;
		Map<String,Object> searchtime=new HashMap<String,Object>();
		
		if(StringUtil.isNotEmpty(params.getSubmitTime())){//申请时间
			String uploadTime=params.getSubmitTime();
			if(uploadTime.equals("today")){
				//今天
				 beans = DateUtils.getDay(0);
				searchtime.put("createFrom",DateUtils.formateDate(beans.get("startTime"),""));
				searchtime.put("createTo",DateUtils.formateDate(beans.get("endTime"),""));
			}else if(uploadTime.equals("thisWeek")){
				//本周
				beans = DateUtils.getWeekDay(0);
				searchtime.put("createFrom",DateUtils.formateDate(beans.get("startTime"),""));
				searchtime.put("createTo",DateUtils.formateDate(beans.get("endTime"),""));
			}else if(uploadTime.equals("lastWeek")){
				//上周
				beans = DateUtils.getWeekDay(-1);
				searchtime.put("createFrom",DateUtils.formateDate(beans.get("startTime"),""));
				searchtime.put("createTo",DateUtils.formateDate(beans.get("endTime"),""));
			}else if(uploadTime.equals("thisMonth")){
				//本月
				beans = DateUtils.getMonthDay(0);
				searchtime.put("createFrom",DateUtils.formateDate(beans.get("startTime"),""));
				searchtime.put("createTo",DateUtils.formateDate(beans.get("endTime"),""));
			}else if(uploadTime.equals("lastMonth")){
				//上月
				beans = DateUtils.getMonthDay(-1);
				searchtime.put("createFrom",DateUtils.formateDate(beans.get("startTime"),""));
				searchtime.put("createTo",DateUtils.formateDate(beans.get("endTime"),""));
			}else{
				String[] split = uploadTime.split(",");
				
				searchtime.put("createFrom",DateUtils.formateDate(DateUtils.parseStartDate(split[0]),""));
				searchtime.put("createTo",DateUtils.formateDate(DateUtils.parseEndDate(split[1]),""));
			}
 	
		}
		return  searchtime;
		
		
		
//		 
//		//提交时间
//		if(StringUtil.isNotEmpty(params.getSubmitTime())){//申请时间
//			String uploadTime=params.getSubmitTime();
//			if(uploadTime.equals("today")||uploadTime.equals("thisWeek")||uploadTime.equals("lastWeek")||uploadTime.equals("lastMonth")||uploadTime.equals("thisMonth")){
//				if(uploadTime.equals("today")){
//					//今天
//					beans = DateUtils.getDay(0);
//				}else if(uploadTime.equals("thisWeek")){
//					//本周
//					beans = DateUtils.getWeekDay(0);
//				}else if(uploadTime.equals("lastWeek")){
//					//上周
//					beans = DateUtils.getWeekDay(-1); 
//				}else if(uploadTime.equals("lastMonth")){
//					//上月
//					beans = DateUtils.getMonthDay(-1);
//				}else if(uploadTime.equals("thisMonth")){
//					//本月
//					beans = DateUtils.getMonthDay(0);
//				}
//				time[0] = beans.get("startTime");
//				time[1] = beans.get("endTime");
//			}else{
//				String[] split = uploadTime.split(",");
//				time[0] =DateUtils.parseStartDate(split[0]);
//				time[1] = DateUtils.parseEndDate(split[1]);
//			}
//		}
//		return time;
	}

	public static Map<String,Object> parseContractParam(SearchContractApplicationInfo params){
		//searchParam
		Map<String,Object> searchParam=new HashMap<String,Object>();
		
		if(params.getPageNum()==null){
			searchParam.put("pageNum", 0);
		}else{
			searchParam.put("pageNum",  params.getPageNum()-1);
		}
		
		if(params.getPageSize()==null){
			searchParam.put("pageSize", 20);
		}else{
			searchParam.put("pageSize", params.getPageSize());
		}
		
		//资源类型 1:编辑类 2: 创意类
		if(params.getAssetFamily()!=null){
			searchParam.put("assetFamily", params.getAssetFamily());
		}
		//审核状态  1未上传2已上传3驳回 4重新上传
		if(params.getAuditingStatus()!=null){
			searchParam.put("auditingStatus", params.getAuditingStatus());
		}
        //因为是精确的值,所以有城市就只有城市,或者只有省,或者只有国家id
		if(params.getCity()!=null&&StringUtils.isNotBlank((params.getCity()))){
			searchParam.put("city",params.getCity());
		}else if(params.getProvince()!=null &&StringUtils.isNotBlank(params.getProvince())){
			searchParam.put("province", params.getProvince());
		}else if(params.getCountry()!=null &&StringUtils.isNotBlank(params.getCountry())){
			searchParam.put("country", params.getCountry());
		}	
		//provider_name	 email mobile
		if(params.getSearchType()!=null){ //1:查姓名 2:邮箱 3:手机号
			if(params.getSearchType()==1){
				searchParam.put("providerName", params.getSearchName());
			}else if(params.getSearchType()==2){
				searchParam.put("email", params.getSearchName());
			}else if(params.getSearchType()==3){
				searchParam.put("mobile", params.getSearchName());
			}
			
		}
 
		return searchParam;
	}
	
	
	public static Map<String,Object> parseProviderApplicationParam(ProviderApplicationSearch params){
		//searchParam
		Map<String,Object> searchParam=new HashMap<String,Object>();
		
		if(params.getPageNum()==null){
			searchParam.put("pageNum", 0);
		}else{
			searchParam.put("pageNum", params.getPageNum()-1);
		}
		
		if(params.getPageSize()==null){
			searchParam.put("pageSize", 20);
		}else{
			searchParam.put("pageSize", params.getPageSize());
		}
		 
		//审核状态  1 未审核 2 待签合同 3 开通 4 不通过
		if(params.getStatus()!=null){
			searchParam.put("status", params.getStatus());
		}
	 
		//搜索框
		if(params.getSearchType()!=null){ //1:查姓名 2:邮箱 3:手机号
			if(params.getSearchType()==1){
				searchParam.put("nameCn", params.getSearchName());
			}else if(params.getSearchType()==2){
				searchParam.put("email", params.getSearchName());
			}else if(params.getSearchType()==3){
				searchParam.put("mobile", params.getSearchName());
			}
			
		}

 
 
		return searchParam;
	}
	
	
	
	public static Map<String,Object> gerenYijiReportsParam(SearchSellReport params){
		Map<String,Object> searchParam=new HashMap<String,Object>();
		if(params.getPageNum()==null){
			searchParam.put("pageNum", 0);
		}else{
			searchParam.put("pageNum",params.getPageNum()-1);
		}
		
		if(params.getPageSize()==null){
			searchParam.put("pageSize", 20);
		}else{
			searchParam.put("pageSize", params.getPageSize());
		}
		if(StringUtils.isNotBlank(params.getSellMonth()) ){
			searchParam.put("sellMonth", params.getSellMonth());
		}
		if(params.getAssetFamily()!=null){
			searchParam.put("assetFamily", params.getAssetFamily());
		}		
		if(params.getAgentType()!=null){
			searchParam.put("agentType", params.getAgentType());
		}
		if(params.getIsPaied()!=null){
			searchParam.put("isPaied", params.getIsPaied());
		}
		if(params.getIsPublished()!=null){
			searchParam.put("isPublished", params.getIsPublished());
		}

		return searchParam;
	}
 
}
