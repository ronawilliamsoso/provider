package com.vcg.provider.web;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vcg.common.AbstractController;
import com.vcg.common.DateUtils;
import com.vcg.common.RestfulResultFactory;
import com.vcg.common.ResultMap;
import com.vcg.provider.entity.SearchSellReport;
import com.vcg.provider.model.ResourceSell;
import com.vcg.provider.model.ResourceSellFromBoss;
import com.vcg.provider.model.query.ResourceSellExample;
import com.vcg.provider.model.query.ResourceSellFromBossExample;
import com.vcg.provider.service.ResourceSellFromBossService;
import com.vcg.provider.service.ResourceSellService;
import com.vcg.provider.util.BossDataUtil;
import com.vcg.provider.util.SearchUtil;
import ch.qos.logback.core.status.Status;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/resourceSell")
public class ResourceSellController extends AbstractController {

	@Autowired
	private ResourceSellService resourceSellService;
	
	@Autowired
	private BossDataUtil bossDataUtil;
	
	@Autowired
	private ResourceSellFromBossService resourceSellFromBossService;
	
	
	
	

 
	
//	
//	@ApiOperation(value = "<获取上月数据>", notes = "<获取上月数据>")
//	@RequestMapping(value="/getLastMonthAll", method=RequestMethod.POST)
//	public Object getLastMonthAll(@ApiParam(value = "必填")@RequestBody SellDataByRange requestParam) throws ParseException{
//		
//		//必须是开始时间是一个月的第一天 结束时间是一个月的最后一天
//		
//		//流程是,获取这个月的明细数据插入数据库到日表,然后更新这个月的统计数据到月表
//		
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
//		String dstr=requestParam.getOutbillDateStart();  
//		java.util.Date date=sdf.parse(dstr);
//		
//		 SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
//		 String sellmonth = formatter.format(date);
//		 bossDataUtil.deleteLastMonthAll(sellmonth);
//		
//		PageVO pageVO = new PageVO();
//		NetValueListVO netValueListVO  = new NetValueListVO();
//		
//		
//		pageVO.setPageNum(0);
//		pageVO.setPageSize(bossDataUtil.pagesize);
//		//pageVO.setOrderBy("outbill_date desc");
//		
//		netValueListVO.setOutbillDateStart(requestParam.getOutbillDateStart());	
//		netValueListVO.setOutbillDateEnd(requestParam.getOutbillDateEnd());
//		netValueListVO.setPageVO(pageVO);
//		  
//		    RestTemplate rt=new RestTemplate();
//	        PageRO<List<NetValueListRO>> list =  rt.postForObject("http://contract.boss.vcg.com/sBillDetail/netValueList",netValueListVO, new PageRO<List<NetValueListRO>>().getClass());
//			System.err.println("received data number:"+ list.getTotalNum()); 
// 
//		try {
//
//	    	 
//			//插入这个月的明细数据
//			//PageRO<List<NetValueListRO>> list  =  bossContractbaseClient.netValueList(netValueListVO);
//			
//	       
//	        
// 
//	        
//	        
////	        curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \ 
////	        "outbillDateEnd": "2016-07-31", \ 
////	        "outbillDateStart": "2016-07-01", \ 
////	        "pageVO": { \ 
////	          "orderBy": "outbill_date desc", \ 
////	          "pageNum": 0, \ 
////	          "pageSize": 10 \ 
////	        } \ 
////	      }' 'http://contract.boss.vcg.com/sBillDetail/netValueList'
//	    	  
//	    	  
//
//			//InstorageMsg instorageMsg = JSON.parseObject(result, InstorageMsg.class);
//			
//			
//			
//			long total = list.getTotalNum();
//			if(total>0){
//				bossDataUtil.insertSellData(list);
//				
//				int pageTotal =(int) Math.ceil(total/bossDataUtil.pagesize) ; 
//				for(int pageNum =1;pageNum<pageTotal;pageNum++){
//					pageVO = new PageVO();
//					pageVO.setPageNum(pageNum);
//					pageVO.setPageSize(100);
//					 
//					netValueListVO  = new NetValueListVO();
//					netValueListVO.setOutbillDateStart(requestParam.getOutbillDateStart());	
//					netValueListVO.setOutbillDateEnd(requestParam.getOutbillDateEnd());
//					netValueListVO.setPageVO(pageVO);
//					
//					//PageRO<List<NetValueListRO>> listrepeat  =  bossContractbaseClient.netValueList(netValueListVO);
//					 PageRO<List<NetValueListRO>> listrepeat =  rt.postForObject("http://contract.boss.vcg.com/sBillDetail/netValueList",netValueListVO, new PageRO<List<NetValueListRO>>().getClass());
//					bossDataUtil.insertSellData(listrepeat);
//					
//				}
//				
//				//更新这个月的总计数据
//				if(total>0){
//					bossDataUtil.updateSellSumMonth(sellmonth);
//				}
//				
//			}
//			
//			
//			
//			
//	 		return RestfulResultFactory.getInstance(200, null,  "成功导入"+total+"条数据");		         
//	     } catch (Exception e) {
//	       e.printStackTrace(); 
//	       return RestfulResultFactory.getInstance(Status.ERROR, null,  "失败");
//	     } 
//     }
	
	

	@ApiOperation(value = "<获取起止数据>", notes = "<获取起止数据>")
	@RequestMapping(value="/getBeginToEndAll", method=RequestMethod.POST)
	public Object getBeginToEndAll(@ApiParam(value = "如2016-01-01")@RequestParam String startDate,@ApiParam(value = "如2016-02-31")@RequestParam String endDate) throws ParseException{
 
 
		try {
			//流程是,获取这个月的明细数据插入数据库到日表,然后更新这个月的统计数据到月表
			Integer countsSum=0;
			 String date_start_str = startDate+" 00:00:00";
			 String date_end_str = endDate+" 23:59:59";
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 java.util.Date date_start=formatter.parse(date_start_str); //这天0秒
			 java.util.Date date_end=formatter.parse(date_end_str);//这天59秒
			 ResourceSellFromBossExample example=new ResourceSellFromBossExample();
			 example=new ResourceSellFromBossExample();
			 example.createCriteria().andOutbillDateBetween(date_start, date_end);
			 int counts  = this.resourceSellFromBossService.countByExample(example);
			 countsSum = countsSum+counts;
			 double temp= (double)counts / bossDataUtil.pagesize;
			 Integer pages   =   (int) Math.ceil(temp);
			 List<ResourceSellFromBoss> list=null;
			 for(int pageNum =1;pageNum<=pages;pageNum++){
					
					PageHelper.startPage(pageNum, bossDataUtil.pagesize);
					list = this.resourceSellFromBossService.selectByExample(example);
	                bossDataUtil.insertBossDataMulti(list);
	                
			 }
				
				//先删除然后更新这个月的总计数据
				if(pages>0){
					List<String> months = DateUtils.getMonthListBetween(date_start_str, date_end_str);
					for(String month:months){
	 
						bossDataUtil.updateSellSumMonth(month);
					}	
				}
	 
 
		 	 return RestfulResultFactory.getInstance(200, null,  "成功导入所有数据"+countsSum+"条");		
         
	     } catch (Exception e) {
	       e.printStackTrace(); 
	       String error= org.apache.commons.lang.exception.ExceptionUtils.getStackTrace(e) ;
	       return RestfulResultFactory.getInstance(Status.ERROR, null,  error);
	     } 
     }
	
	
	
	@ApiOperation(value = "<获取一个月当前日期到本月结束的数据>", notes = "<获取一个月当前日期到本月结束的数据>")
	@RequestMapping(value="/getOneMonthAll", method=RequestMethod.POST)
	public Object getOneMonthAll(@ApiParam(value = "如2016-01-01")@RequestParam String startDate) throws ParseException{
 
 
		try {
			//流程是,获取这个月的明细数据插入数据库到日表,然后更新这个月的统计数据到月表
			
			 
			SimpleDateFormat normaldate=new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date currentDate = normaldate.parse(startDate); //当前天的日期
			
			//此月数据
			 SimpleDateFormat formatterformaoth = new SimpleDateFormat("yyyyMM");
			 String sellmonth = formatterformaoth.format(currentDate);
			 //bossDataUtil.deleteLastMonthAll(sellmonth);
			
			 
			 
			 //本月有多少天
			 String date_start_str = startDate+" 00:00:00";
			 String date_end_str = DateUtils.getMonthEnd(currentDate);
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 java.util.Date date_start=formatter.parse(date_start_str); //这个月 当前天0秒
			 java.util.Date date_end=formatter.parse(date_end_str);//这个月最后一天59秒
			 int days = DateUtils.daysBetween(date_start,date_end);//当前输入日期到当前输入日期的对应的月份的月末有多少天
			 
			 Date current = null;
			 Date current_start = null;
			 Date current_end = null;
			 
			 ResourceSellFromBossExample example=new ResourceSellFromBossExample();
			 Integer countsSum=0;
			 for(int i=0;i<=days;i++){
			     Calendar   calendar   =   new   GregorianCalendar(); 
			     calendar.setTime(currentDate); 
			     calendar.add(calendar.DATE,i);//把日期往后增加i天
			     current=calendar.getTime();   // 现在该导入的日期
 
			     current_start = DateUtils.getStartByDay(current);
			     current_end = DateUtils.getEndByDay(current);
			     
			     bossDataUtil.deleteDayAll(current_start,current_end);//删除可能的数据
 
			     example=new ResourceSellFromBossExample();
				 example.createCriteria().andOutbillDateBetween(current_start, current_end);
			     
				  int counts  = this.resourceSellFromBossService.countByExample(example);
				  countsSum = countsSum+counts;
				 double temp= (double)counts / bossDataUtil.pagesize;
				 Integer pages   =   (int) Math.ceil(temp);
				 List<ResourceSellFromBoss> list=null;
				 
				for(int pageNum =1;pageNum<=pages;pageNum++){
					
					PageHelper.startPage(pageNum, bossDataUtil.pagesize);
					list = this.resourceSellFromBossService.selectByExample(example);
	                bossDataUtil.insertBossData(list);
	                
				}
				
				//先删除然后更新这个月的总计数据
				if(pages>0){
					bossDataUtil.updateSellSumMonth(sellmonth);
				}
	 
				System.err.println("成功导入这天的数据:"+current);
				
				
			 }
			 
		 	 return RestfulResultFactory.getInstance(200, null,  "成功导入本月所有数据"+countsSum+"条");		
         
	     } catch (Exception e) {
	       e.printStackTrace(); 
	       return RestfulResultFactory.getInstance(Status.ERROR, null,  "失败");
	     } 
     }
	
	@ApiOperation(value = "供稿人-<一级报表>", notes = "供稿人-<一级报表>")
	@RequestMapping(value="/gerenYiji", method=RequestMethod.POST)
	public Object searchProviderInfo(@ApiParam(value = "只按照assetFamily,month搜索")@RequestBody SearchSellReport requestParam){
		Map<String,Object> ret = new HashMap<String,Object>();
		if(requestParam.getAgentType()==null){
	    	return RestfulResultFactory.getInstance(Status.ERROR, null,  "agentType必填");
	    }
		if(requestParam.getPageNum()==null){
	    	return RestfulResultFactory.getInstance(Status.ERROR, null,  "PageNum必填");
	    }
		if(requestParam.getPageSize()==null){
	    	return RestfulResultFactory.getInstance(Status.ERROR, null,  "PageSize必填");
	    }
		requestParam.setPageNum(requestParam.getPageNum()-1); 
		try {
	    	 
	    	Map<String,Object> searchParam = SearchUtil.gerenYijiReportsParam(requestParam);
	 		PageHelper.startPage(requestParam.getPageNum(), requestParam.getPageSize());
	 		PageInfo<ResultMap> result = this.queryService.queryPageForCustom("ReportManage", "gerenYijiReport", searchParam);
 
	 		
	 		ret.put("status", 200);
	 		ret.put("data", result);
	 		ret.put("total",result.getTotal());
	 		ret.put("message", "成功");
	 		
	 		
	 		return ret;		         
		     } catch (Exception e) {
		       e.printStackTrace(); 
		       return RestfulResultFactory.getInstance(Status.ERROR, null,  "失败");
		     } 
     }
	
	
	@ApiOperation(value = "供稿人-<三级报表>", notes = "供稿人-<三级报表>")
	@RequestMapping(value="/detailList", method=RequestMethod.POST)
	public Object detailList(@ApiParam(value = "只按照vcgId,originalId搜索")@RequestBody SearchSellReport requestParam){
		Map<String,Object> result = new HashMap<String,Object>();
		if(requestParam.getAgentType()==null){
	    	return RestfulResultFactory.getInstance(Status.ERROR, null,  "agentType必填");
	    }
		if(requestParam.getProviderId()==null){
	    	return RestfulResultFactory.getInstance(Status.ERROR, null,  "providerId从上级页面而来，必填");
	    }
		if(requestParam.getAssetFamily()==null){
	    	return RestfulResultFactory.getInstance(Status.ERROR, null,  "assetFamily从上级页面而来，必填");
	    }
		if(StringUtils.isBlank(requestParam.getSellMonth()) ){
	    	return RestfulResultFactory.getInstance(Status.ERROR, null,  "sellMonth从上级页面而来，必填");
	    }
		//requestParam.setPageNum(requestParam.getPageNum()-1); 
		
		try {
			 

			ResourceSellExample example=new ResourceSellExample();
			com.vcg.provider.model.query.ResourceSellExample.Criteria criteria =  example.createCriteria();

			
			criteria.andAgentTypeEqualTo(requestParam.getAgentType());
		    criteria.andAssetFamilyEqualTo(requestParam.getAssetFamily());
			criteria.andSellMonthEqualTo(requestParam.getSellMonth());
			criteria.andProviderIdEqualTo(requestParam.getProviderId());
			if(requestParam.getSearchType()!=null && StringUtils.isNotBlank(requestParam.getSearchName())){
				if(requestParam.getSearchType()==2){
					criteria.andResIdEqualTo(requestParam.getSearchName());
				}if(requestParam.getSearchType()==3){
					criteria.andProviderResIdEqualTo(requestParam.getSearchName());
				} 
			}
			PageHelper.startPage(requestParam.getPageNum(), requestParam.getPageSize());
			List<ResourceSell> lst = this.resourceSellService.selectByExample(example);
			//return  new PageInfo<ResourceSell>(lst);
 
			
			result.put("status", 200);
			result.put("data", lst);
			result.put("total",this.resourceSellService.countByExample(example));
			result.put("message", "成功");
	 		return result;
		     } catch (Exception e) {
		       e.printStackTrace(); 
		        
		       return RestfulResultFactory.getInstance(201, null,  "失败");
		     } 
     }
	
	
	
	
	
	

	

	

	

 
	
	 
	
}
