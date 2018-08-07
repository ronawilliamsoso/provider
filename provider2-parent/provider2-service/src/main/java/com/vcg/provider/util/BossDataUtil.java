package com.vcg.provider.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vcg.boss.bill.model.RO.NetValueListRO;
import com.vcg.boss.constant.RO.PageRO;
import com.vcg.common.AbstractController;
import com.vcg.common.ResultMap;
import com.vcg.common.global.ro.RestfulResult;
import com.vcg.resource.feignClient.*;
import com.vcg.resource.model.ResImage;
import com.vcg.provider.model.Collection;
import com.vcg.provider.model.Provider;
import com.vcg.provider.model.ResourceSell;
import com.vcg.provider.model.ResourceSellFromBoss;
import com.vcg.provider.model.ResourceSellMonth;
import com.vcg.provider.model.query.ResourceSellExample;
import com.vcg.provider.model.query.ResourceSellMonthExample;
import com.vcg.provider.service.ResourceSellMonthService;
import com.vcg.provider.service.ResourceSellService;

@Component
public class BossDataUtil  extends AbstractController { 
	
	@Autowired
	private ResourceSellService resourceSellService;

	@Autowired
	private ResourceSellMonthService resourceSellMonthService;
	

	
	@Autowired
	private ResourceEdgeClientForData resourceEdgeClient;
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private MapUtil mapUtil;
	
	
	public int pagesize = 2000;
	
	
	
	
	public void deleteLastMonthAll(String month ){
		ResourceSellExample example=new ResourceSellExample();
		example.createCriteria().andSellMonthEqualTo(month);
	    this.resourceSellService.deleteByExample(example);
		 
	}
	
	public void deleteDayAll(Date selldate_start,Date selldate_end ){
		ResourceSellExample example=new ResourceSellExample();
		example.createCriteria().andOutbillDateBetween(selldate_start, selldate_end);
	    this.resourceSellService.deleteByExample(example);
		 
	}
	
	public void updateSellSumMonth(String month ){
		//删除这月数据
		ResourceSellMonthExample resourceSellMonthExample=new ResourceSellMonthExample();
		resourceSellMonthExample.createCriteria().andSellMonthEqualTo(month);
	   resourceSellMonthService.deleteByExample(resourceSellMonthExample);
	   
	   ResourceSellMonth insert = new ResourceSellMonth();
	   
   	   Map<String,Object> searchParam = new  HashMap<String,Object>();
   	   searchParam.put("sellMonth", month);
   	
   	   List<ResultMap> result = this.queryService.queryListForCustom("ReportManage", "selectSumIntoMonth", searchParam);
//		s.provider_id,
//		s.provider_name,
//		s.agent_type,
//		s.sell_month,
//		s.asset_family,
//		SUM(s.sell_price) sell_price,
//		SUM(s.net_share) net_share,
//		COUNT(s.id) sell_count
   	   BigDecimal bd=null;
   	   //重新计算本月的合计数据
   	   for(ResultMap r:result){
   		   if(r.getValue("netShare")!=null && r.getValue("sellPrice")!=null && StringUtils.isNotBlank(r.getValue("netShare"))  ){
   			   
   			   
   			   
   			insert = new ResourceSellMonth();
   	   		insert.setProviderId(r.getIntegerValue("providerId"));
   	   		insert.setProviderName(r.getValue("providerName"));
   	   		insert.setAgentType(r.getIntegerValue("agentType"));
   	   		insert.setSellMonth(r.getValue("sellMonth"));
   	   		insert.setAssetFamily(r.getIntegerValue("assetFamily"));
   	   		insert.setIsPaied(0);
   	   		if(r.getIntegerValue("assetFamily")==1){//编辑类的数据默认都是已发布,编辑类供稿人随时可以看 
   	   			insert.setIsPublished(1);
   	   		}else if(r.getIntegerValue("assetFamily")==2){//创意类类的数据默认都是未发布
   	   			insert.setIsPublished(0);
   	   		}
   	   		bd=new BigDecimal(r.getValue("sellPrice"));   
   	   	    bd=bd.setScale(2, BigDecimal.ROUND_HALF_UP);  //设置小数位数，第一个变量是小数位数，第二个变量是取舍方法(四舍五入) 
   	   	    insert.setSellTotal(bd);
   	   	    bd=new BigDecimal(r.getValue("netShare"));  
   	   	    bd=bd.setScale(2, BigDecimal.ROUND_HALF_UP); 
   	   		insert.setShareTotal(bd);
   	   		insert.setSellCount(r.getIntegerValue("sellCount"));
   	   		
   	   		resourceSellMonthService.insert(insert);
   			   
   		   } 
   		
   	   }
   	   
		 
	}
	
	public void insertSellData(PageRO<List<NetValueListRO>> list ){
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
		 ResourceSell  insert=new ResourceSell();
		 Collection collection = null;
		 List<NetValueListRO> datalist = list.getData();
		 Provider provider = null;
		 List<String> residss= new ArrayList<String>();
		 Map map = new LinkedHashMap<String,Object>();
		
		 
		 
		 //因为boss的数据还没有清洗,所以我们查询edit接口需要加上前缀,未来清洗完,不需要前缀查询
		 for(int i =0;i<datalist.size();i++){
			 map = (Map) datalist.get(i);
			String temp = map.get("resId").toString();
			String providerName = mapUtil.getString(map, "providerName");
			Integer assetFamily =  mapUtil.getInteger(map, "assetFamily");
			 if(assetFamily!=null && StringUtils.isNoneBlank(providerName)){
				 if(providerName.toLowerCase().indexOf("getty")!=-1){
					 if(assetFamily==1){
						 temp ="E"+temp;
					 }else if(assetFamily==2){
						 temp ="0101"+temp;
					 }
				 }else{
					 if(assetFamily==1){
						 temp ="0101"+temp;
					 }else if(assetFamily==2){
						 temp ="0102"+temp;
					 }
				 }
			 }
			 map.put("resId", temp);
			 residss.add(temp);
		 }
		 
		  
//		 List<String> resids = datalist.stream().map(e->e.getResId()).collect(Collectors.toList());
//		 String residss = listToString(resids);
		 String sellmonth="";
		 String resColumns="res_id,caption,collection_id,provider_id,provider_res_id,credit_line,oss_176";
		 RestfulResult<List<ResImage>> restfulResult = resourceEdgeClient.findResImageByLargeResIds(residss,resColumns);
		 List<ResImage> resourcelist =  restfulResult.getData();
		 if(datalist.size()>0){
			 map = (Map) datalist.get(0);
			 String selldate = mapUtil.getString(map, "sellDate");
			 if(StringUtils.isNotBlank(selldate)){
//				 long l = Long.parseLong(selldate);
				// Date date = new Date(selldate);  
				  
 				 SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMM");
 				 SimpleDateFormat formatterorigin = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 				Date selldate1;
				try {
					selldate1 = formatterorigin.parse(selldate);
					sellmonth = formatter1.format(selldate1); 
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			 }
		 }
		 
		 
		 map = new LinkedHashMap<String,Object>();
		 for(int i =0;i<datalist.size();i++){
			 map = (Map) datalist.get(i);
			 
			 insert=new ResourceSell();
			 insert.setSellMonth(sellmonth);
			 insert.setResId(mapUtil.getString(map, "resId"));
			
			 insert.setAssetFamily(mapUtil.getInteger(map, "assetFamily") );
			 insert.setSellDate(mapUtil.getDate(map, "sellDate", "yyyy-MM-dd"));
			 insert.setCurrencyCode(mapUtil.getString(map, "currencyCode") );
			 insert.setSellPrice(mapUtil.getBigDecimal(map, "sellPrice"));
			 insert.setPrice(mapUtil.getBigDecimal(map, "price"));
			 insert.setRoyaltyRate(mapUtil.getBigDecimal(map, "royaltyRate"));
			 insert.setNetShare(mapUtil.getBigDecimal(map, "netShare"));
			 insert.setProviderName(mapUtil.getString(map, "providerName"));
			 insert.setInvoiceNumber(mapUtil.getString(map, "invoiceNumber"));
			 insert.setTerritoryId(mapUtil.getString(map, "territoryId"));
			 insert.setClientType(mapUtil.getString(map, "clientType"));
			 insert.setClientCn(mapUtil.getString(map, "clientCn"));
			 insert.setClientEn(mapUtil.getString(map, "clientEn"));
			 insert.setFinaluserCn(mapUtil.getString(map, "finaluserCn"));
			 insert.setFinaluserEn(mapUtil.getString(map, "finaluserEn"));
			 insert.setIndustryCode(mapUtil.getString(map, "industryCode"));
			 insert.setIndustryCn(mapUtil.getString(map, "industryCn"));
			 insert.setIndustryEn(mapUtil.getString(map, "industryEn"));
			 insert.setUsageCode(mapUtil.getString(map, "usageCode"));
			 insert.setUsageCn(mapUtil.getString(map, "usageCn"));
			 insert.setUsageEn(mapUtil.getString(map, "usageEn"));
			 insert.setDuration(mapUtil.getInteger(map, "duration"));
			 insert.setRightEnd(mapUtil.getDate(map, "rightEnd", "yyyy-MM-dd"));
			 insert.setRightStart(mapUtil.getDate(map, "rightStart", "yyyy-MM-dd"));
			 insert.setProtectionCode(mapUtil.getString(map, "protectionCode"));
			 insert.setSellRegion(mapUtil.getString(map, "sellRegion"));
			 insert.setOutbillDate(mapUtil.getDate(map, "outbillDate",  "yyyy-MM-dd"));
			 insert.setPhotoDownloadtime(mapUtil.getDate(map, "photoDownloadtime",  "yyyy-MM-dd"));
			 insert.setConfirmTime(mapUtil.getDate(map, "confirmTime",  "yyyy-MM-dd"));
			 insert.setOrderConfirmed(mapUtil.getInteger(map, "orderConfirmed"));
			 insert.setShareConfirmed(mapUtil.getInteger(map, "shareConfirmed"));
			 
			 for(ResImage resource: resourcelist){
				 if(resource.getResId().equals(insert.getResId())){
					 if(StringUtils.isNotBlank(resource.getCaption())){
						 if(resource.getCaption().length()>300){
							 insert.setCaption(resource.getCaption().substring(0,300));
						 }
						 
					 }
					 insert.setCollectionId(resource.getCollectionId());
					 insert.setProviderId(resource.getProviderId());
					 if(insert.getCollectionId()!=null && StringUtils.isNumeric(insert.getCollectionId()+"") ){
						 collection = redisUtil.getCollection(insert.getCollectionId());
						 if(collection!=null){
							 insert.setCollectionName(collection.getName());
							 insert.setLicenseType(collection.getLicenseType());
						 }
					 }
					 insert.setProviderResId(resource.getProviderResId() );
					 insert.setCreditLine(resource.getCreditLine());
					 insert.setSkeletonPath("http://bj-feiyuantu.oss-cn-beijing.aliyuncs.com/"+resource.getOss176());
					 
				 }
			 }
			 if(insert.getProviderId()!=null){
				 provider = redisUtil.getProvider(insert.getProviderId());
				 if(provider!=null){
					 insert.setAgentType(provider.getAgentType());
					 
					 insert.setProviderName(provider.getNameCn());
				 }
			 }

			 this.resourceSellService.insert(insert);
  
			 
		 }
		 
		 
		 // client调用的话可以直接用这段代码
//		 for(NetValueListRO n:list.getData()){
//			 insert=new ResourceSell();
//			 insert.setSellMonth(formatter.format(n.getSellDate()));
//			 insert.setResId(n.getResId());
//			
//			 insert.setAssetFamily(n.getAssetFamily());
//			 insert.setSellDate(n.getSellDate());
//			 insert.setCurrencyCode(n.getCurrencyCode());
//			 insert.setSellPrice(n.getSellPrice());
//			 insert.setPrice(n.getPrice());
//			 insert.setRoyaltyRate(n.getRoyaltyRate());
//			 insert.setNetShare(n.getNetShare());
//			 insert.setProviderName(n.getProviderName());
//			 insert.setInvoiceNumber(n.getInvoiceNumber());
//			 insert.setTerritoryId(n.getTerritoryId());
//			 insert.setClientType(n.getClientType());
//			 insert.setClientCn(n.getClientCn());
//			 insert.setClientEn(n.getClientEn());
//			 insert.setFinaluserCn(n.getFinaluserCn());
//			 insert.setFinaluserEn(n.getClientEn());
//			 insert.setIndustryCode(n.getIndustryCode());
//			 insert.setIndustryCn(n.getIndustryCn());
//			 insert.setIndustryEn(n.getIndustryEn());
//			 insert.setUsageCode(n.getUsageCode());
//			 insert.setUsageCn(n.getUsageCn());
//			 insert.setUsageEn(n.getUsageEn());
//			 insert.setDuration(n.getDuration());
//			 insert.setRightEnd(n.getRightEnd());
//			 insert.setRightStart(n.getRightStart());
//			 insert.setProtectionCode(n.getProtectionCode());
//			 insert.setSellRegion(n.getSellRegion());
//			 insert.setOutbillDate(n.getOutbillDate());
//			 insert.setPhotoDownloadtime(n.getPhotoDownloadtime());
//			 insert.setConfirmTime(n.getConfirmTime());
//			 insert.setOrderConfirmed(n.getStatus());
//			 insert.setShareConfirmed(n.getShareConfirmed());
// 
//			 for(ResImageRo resource: resourcelist){
//				 if(resource.getResId().equals(insert.getResId())){
//					 if(StringUtils.isNotBlank(resource.getCaption())){
//						 if(resource.getCaption().length()>300){
//							 insert.setCaption(resource.getCaption().substring(0,300));
//						 }
//						 
//					 }
//					 insert.setCollectionId(resource.getCollectionId());
//					 insert.setProviderId(resource.getProviderId());
//					 if(insert.getCollectionId()!=null && StringUtils.isNumeric(insert.getCollectionId()+"") ){
//						 collection = providerUtil.getCollection(insert.getCollectionId());
//						 if(collection!=null){
//							 insert.setCollectionName(collection.getName());
//							 insert.setLicenseType(collection.getLicenseType());
//						 }
//					 }
//					 insert.setProviderResId(resource.getProviderResId() );
//					 insert.setCreditLine(resource.getCreditLine());
//					 insert.setSkeletonPath("http://bj-feiyuantu.oss-cn-beijing.aliyuncs.com/"+resource.getOss176());
//					 
//				 }
//			 }
//			 if(insert.getProviderId()!=null){
//				 provider = providerUtil.getProvider(insert.getProviderId());
//				 if(provider!=null){
//					 insert.setAgentType(provider.getAgentType());
//					 
//					 insert.setProviderName(provider.getNameCn());
//				 }
//			 }
//
//			 this.resourceSellService.insert(insert);
//
//		 }
		
	     
		 
	}
	
	
	
	public void insertBossData(List<ResourceSellFromBoss> list ){
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
		 ResourceSell  insert=new ResourceSell();
		 Collection collection = null;
		 
		 Provider provider = null;
		 List<String> residss= new ArrayList<String>();
		// Map map = new LinkedHashMap<String,Object>();
		
		 
		 
		 //因为boss的数据还没有清洗,所以我们查询edit接口需要加上前缀,未来清洗完,不需要前缀查询
		 for(int i =0;i<list.size();i++){
			 ResourceSellFromBoss  data =  list.get(i);
 			String temp = data.getResId();
//			String providerName =data.getProviderName();
//			Integer assetFamily =  data.getAssetFamily();
//			 if(assetFamily!=null && StringUtils.isNoneBlank(providerName)){
//				 if(providerName.toLowerCase().indexOf("getty")!=-1){
//					 if(assetFamily==1){
//						 temp ="E"+temp;
//					 }else if(assetFamily==2){
//						 temp ="0101"+temp;
//					 }
//				 }else{
//					 if(assetFamily==1){
//						 temp ="0101"+temp;
//					 }else if(assetFamily==2){
//						 temp ="0102"+temp;
//					 }
//				 }
//			 }
//			 
//			 data.setResId(temp);
 			if(StringUtils.isNotBlank(temp)){
 				residss.add(temp);
 			}
			 
		 }

//		 String sellmonth="";
		 String resColumns="res_id,caption,collection_id,provider_id,provider_res_id,credit_line,oss_176";
		 RestfulResult<List<ResImage>> restfulResult = resourceEdgeClient.findResImageByLargeResIds(residss,resColumns);
		 List<ResImage> resourcelist =  restfulResult.getData();
//		 if(list.size()>0){
//			 ResourceSellFromBoss  data =  list.get(0);
//			 Date selldate = data.getOutbillDate();
//			 
//			 SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMM");
//			 sellmonth = formatter1.format(selldate); 
//			 
// 
//		 }
		 
 
		 
		 
	 
		 for( ResourceSellFromBoss n:list){
		 
			 insert=new ResourceSell();
			 insert.setSellMonth(formatter.format(n.getOutbillDate()));
			 insert.setResId(n.getResId());
			
			 insert.setAssetFamily(n.getAssetFamily());
			 insert.setSellDate(n.getOutbillDate());
			 insert.setCurrencyCode(n.getCurrencyCode());
			 insert.setSellPrice(n.getSellPrice());
			 insert.setPrice(n.getPrice());
			 insert.setRoyaltyRate(n.getRoyaltyRate());
			 insert.setNetShare(n.getNetShare());
			 insert.setProviderName(n.getProviderName());
			 insert.setInvoiceNumber(n.getInvoiceNumber());
			 insert.setTerritoryId(n.getTerritoryId());
			 insert.setClientType(n.getClientType());
			 insert.setClientCn(n.getClientCn());
			 insert.setClientEn(n.getClientEn());
			 insert.setFinaluserCn(n.getFinaluserCn());
			 insert.setFinaluserEn(n.getClientEn());
			 insert.setIndustryCode(n.getIndustryCode());
			 insert.setIndustryCn(n.getIndustryCn());
			 insert.setIndustryEn(n.getIndustryEn());
			 insert.setUsageCode(n.getUsageCode());
			 insert.setUsageCn(n.getUsageCn());
			 insert.setUsageEn(n.getUsageEn());
			 insert.setDuration(n.getDuration());
			 insert.setRightEnd(n.getRightEnd());
			 insert.setRightStart(n.getRightStart());
			 insert.setProtectionCode(n.getProtectionCode());
			 insert.setSellRegion(n.getSellRegion());
			 insert.setOutbillDate(n.getOutbillDate());
			 insert.setPhotoDownloadtime(n.getPhotoDownloadtime());
			 insert.setConfirmTime(n.getConfirmTime());
			 insert.setOrderConfirmed(n.getStatus());
			 insert.setShareConfirmed(Integer.parseInt(n.getShareConfirmed()));
			 insert.setBillDetailId(n.getBillDetailId());
			 insert.setProviderId(n.getProviderId());
			 for(ResImage resource: resourcelist){
				 if(resource.getResId().equals(insert.getResId())){
					 if(StringUtils.isNotBlank(resource.getCaption())){
						 if(resource.getCaption().length()>300){
							 insert.setCaption(resource.getCaption().substring(0,300));
						 }
						 
					 }
					 insert.setCollectionId(resource.getCollectionId());
					 
					 if(insert.getCollectionId()!=null && StringUtils.isNumeric(insert.getCollectionId()+"") ){
						 collection = redisUtil.getCollection(insert.getCollectionId());
						 if(collection!=null){
							 insert.setCollectionName(collection.getName());
							 insert.setLicenseType(collection.getLicenseType());
						 }
					 }
					 insert.setProviderResId(resource.getProviderResId() );
					 insert.setCreditLine(resource.getCreditLine());
					 insert.setSkeletonPath("http://bj-feiyuantu.oss-cn-beijing.aliyuncs.com/"+resource.getOss176());
					 
				 }
			 }
			 if(insert.getProviderId()!=null){
				 provider = redisUtil.getProvider(insert.getProviderId());
				 if(provider!=null){
					 insert.setAgentType(provider.getAgentType());
					 
					 insert.setProviderName(provider.getNameCn());
				 }
			 }

			 this.resourceSellService.insert(insert);

		 }
		
	     
		 
	}
	
	
	public void insertBossDataMulti(List<ResourceSellFromBoss> list ){
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
		
		 
		 
		
		 List<String> residssforquery = list.stream().map(e->e.getResId()).collect(Collectors.toList()); //用来查询的resid
		 String resColumns="res_id,caption,collection_id,provider_id,provider_res_id,credit_line,oss_176";
		 RestfulResult<List<ResImage>> restfulResult = resourceEdgeClient.findResImageByLargeResIds(residssforquery,resColumns);
		 List<ResImage> resourcelist =  restfulResult.getData();
		 
		 list.stream().parallel().forEach(n->{
			 Provider provider = null;
			 ResourceSell  insert=new ResourceSell();
			 
			 insert.setSellMonth(formatter.format(n.getOutbillDate()));
			 insert.setResId(n.getResId());
			
			 insert.setAssetFamily(n.getAssetFamily());
			 insert.setSellDate(n.getOutbillDate());
			 insert.setCurrencyCode(n.getCurrencyCode());
			 insert.setSellPrice(n.getSellPrice());
			 insert.setPrice(n.getPrice());
			 insert.setRoyaltyRate(n.getRoyaltyRate());
			 insert.setNetShare(n.getNetShare());
			 insert.setProviderName(n.getProviderName());
			 insert.setInvoiceNumber(n.getInvoiceNumber());
			 insert.setTerritoryId(n.getTerritoryId());
			 insert.setClientType(n.getClientType());
			 insert.setClientCn(n.getClientCn());
			 insert.setClientEn(n.getClientEn());
			 insert.setFinaluserCn(n.getFinaluserCn());
			 insert.setFinaluserEn(n.getClientEn());
			 insert.setIndustryCode(n.getIndustryCode());
			 insert.setIndustryCn(n.getIndustryCn());
			 insert.setIndustryEn(n.getIndustryEn());
			 insert.setUsageCode(n.getUsageCode());
			 insert.setUsageCn(n.getUsageCn());
			 insert.setUsageEn(n.getUsageEn());
			 insert.setDuration(n.getDuration());
			 insert.setRightEnd(n.getRightEnd());
			 insert.setRightStart(n.getRightStart());
			 insert.setProtectionCode(n.getProtectionCode());
			 insert.setSellRegion(n.getSellRegion());
			 insert.setOutbillDate(n.getOutbillDate());
			 insert.setPhotoDownloadtime(n.getPhotoDownloadtime());
			 insert.setConfirmTime(n.getConfirmTime());
			 insert.setOrderConfirmed(n.getStatus());
			 insert.setShareConfirmed(Integer.parseInt(n.getShareConfirmed()));
			 insert.setBillDetailId(n.getBillDetailId());
			 insert.setProviderId(n.getProviderId());
			 for(ResImage resource: resourcelist){
				 if(resource.getResId().equals(insert.getResId())){
					 if(StringUtils.isNotBlank(resource.getCaption())){
						 if(resource.getCaption().length()>300){
							 insert.setCaption(resource.getCaption().substring(0,300));
						 }
						 
					 }
					 insert.setCollectionId(resource.getCollectionId());
					 Collection collection = null;
					 if(insert.getCollectionId()!=null && StringUtils.isNumeric(insert.getCollectionId()+"") ){
						 collection = redisUtil.getCollection(insert.getCollectionId());
						 if(collection!=null){
							 insert.setCollectionName(collection.getName());
							 insert.setLicenseType(collection.getLicenseType());
						 }
					 }
					 insert.setProviderResId(resource.getProviderResId() );
					 insert.setCreditLine(resource.getCreditLine());
					 insert.setSkeletonPath("http://bj-feiyuantu.oss-cn-beijing.aliyuncs.com/"+resource.getOss176());
					 
				 }
			 }
			 if(insert.getProviderId()!=null){
				 provider = redisUtil.getProvider(insert.getProviderId());
				 if(provider!=null){
					 insert.setAgentType(provider.getAgentType());
					 
					 insert.setProviderName(provider.getNameCn());
				 }
			 }

			 this.resourceSellService.insert(insert);
			 
			 
		 });
		 
 
		
	     
		 
	}
	
	 public  String listToString(List<String> stringList){
	        if (stringList==null) {
	            return null;
	        }
	        StringBuilder result=new StringBuilder();
	        boolean flag=false;
	        for (String string : stringList) {
	            if (flag) {
	                result.append(",");
	            }else {
	                flag=true;
	            }
	            result.append(string);
	        }
	        return result.toString();
	    }
	
}
 
