package com.vcg.provider.smallService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.StringUtil;
import com.vcg.common.DateUtils;
import com.vcg.common.Status;
import com.vcg.provider.model.Royalties;
import com.vcg.provider.service.RoyaltiesService;

@Component
public class MeInterfaceExtend {
	@Autowired
	private RoyaltiesService royaltiesService;
	
	public JSONObject getCreativeRoyaltiesFromBoss(Integer providerId, String beginDate, 
			String endDate,int pageNum,int pageSize){
		StringBuffer url_buf = new StringBuffer();
		url_buf.append("http://boss.visualchina.com/crm/service/getSaledPicList.action?")
			.append("providerId=").append(providerId)
			.append("&beginDate=").append(beginDate)
			.append("&endDate=").append(endDate);
		
		RestTemplate restTem = new RestTemplate();
		String dataStr = restTem.postForObject(url_buf.toString(), null, String.class);
		JSONObject data = new JSONObject();
		if(dataStr == null){
			data.put("total", 0);
			data.put("saleTotalFee", 0);
			data.put("costTotalFee", 0);
			data.put("pages", 0);
			data.put("list", null);
			return data;
		}
		List<JSONObject> list = new ArrayList<>();
		String[] record = dataStr.split("\r\n");
		BigDecimal saleTotalFee = BigDecimal.ZERO;
		BigDecimal costTotalFee = BigDecimal.ZERO;
		for(String r: record){
			String[] sub = r.split(",");
			JSONObject ob = new JSONObject();
			ob.put("resId", sub[0]);
			ob.put("verifyDate", sub[1]);
			ob.put("price", sub[2]);
			ob.put("netRate", sub[3]);
			ob.put("netValue", sub[4]);
			ob.put("useNameZh", sub[5]);
			ob.put("industryNameZh", sub[6]);
			ob.put("collection", sub[7]);
			ob.put("licenseType", sub[8]);
			if("null".equalsIgnoreCase(sub[9])){
				ob.put("publishTimeLimit", null);
			}else{
				ob.put("publishTimeLimit", sub[9]);
			}
			
			if(sub.length > 10){
				ob.put("imgUrl", sub[10]);
			}
			
			ob.put("comment", null);
			if(StringUtil.isNotEmpty(sub[2])){
				saleTotalFee = saleTotalFee.add(new BigDecimal(sub[2]));
			}
			if(StringUtil.isNotEmpty(sub[4])){
				costTotalFee = costTotalFee.add(new BigDecimal(sub[4]));
			}
			list.add(ob);
		}
		
		int pages = list.size() / pageSize;
		if(pages * pageSize < list.size()){
			pages += 1;
		}
		pageNum = pageNum < 1? 1 : pageNum;
		List<JSONObject> onePage = new ArrayList<>();
		if(pageNum < pages){
			onePage = list.subList(pageSize * (pageNum - 1), pageSize * pageNum);
		}else if(pageNum == pages){
			onePage = list.subList(pageSize * (pageNum - 1), list.size());
		}else{
			onePage = null;
		}
		
		
		data.put("total", list.size());
		data.put("saleTotalFee", saleTotalFee);
		data.put("costTotalFee", costTotalFee);
		data.put("pages", pages);
		data.put("list", onePage);
		
		return data;
	}
	
	
	public JSONObject getEditRoyaltiesFromBoss(Integer providerId, Date begin, 
			Date end){
		
		String beginDate;
		String endDate;
		BigDecimal saleTotalFee = BigDecimal.ZERO;
    	BigDecimal costTotalFee = BigDecimal.ZERO;
    	
		Calendar cal = Calendar.getInstance();
		cal.setTime(begin);
		JSONArray editData = new JSONArray();
		/*一个月一个月地读取数据*/
		while(cal.getTime().before(end)){
			beginDate = DateUtils.getMonthBegin(cal.getTime());
			endDate = DateUtils.getMonthEnd(cal.getTime());
			StringBuffer url_buf = new StringBuffer();
			url_buf.append("http://boss.visualchina.com/crm/service/getEditProviderFeeInfo.action?")
				.append("providerId=").append(providerId)
				.append("&beginDate=").append(beginDate)
				.append("&endDate=").append(endDate);
			RestTemplate restTem = new RestTemplate();
			JSONObject dataStr = restTem.postForObject(url_buf.toString(), null, JSONObject.class);
			if(dataStr != null){
				if(dataStr.getBigDecimal("totalPrice") != null){
					saleTotalFee = saleTotalFee.add(dataStr.getBigDecimal("totalPrice"));
				}
				if(dataStr.getBigDecimal("totalCostFee") != null){
					costTotalFee = costTotalFee.add(dataStr.getBigDecimal("totalCostFee"));
				}
				JSONObject ob = new JSONObject();
				ob.put("month", cal.get(Calendar.YEAR) +"-"+(cal.get(Calendar.MONTH)+1));
				ob.put("picTotal", dataStr.getInteger("totalPic"));
				ob.put("costFee", dataStr.getBigDecimal("totalCostFee"));
				ob.put("buluFee", BigDecimal.ZERO);
				ob.put("taxFee", BigDecimal.ZERO);
				ob.put("realFee", BigDecimal.ZERO);
				ob.put("bonus", BigDecimal.ZERO);
				ob.put("payTime", null);
				
				editData.add(ob);
				//下一个月
				cal.add(Calendar.MONTH, 1);
			}
			
		}
		beginDate = DateUtils.getMonthBegin(cal.getTime());
		endDate = DateUtils.getMonthEnd(cal.getTime());
		StringBuffer url_buf = new StringBuffer();
		url_buf.append("http://boss.visualchina.com/crm/service/getEditProviderFeeInfo.action?")
			.append("providerId=").append(providerId)
			.append("&beginDate=").append(beginDate)
			.append("&endDate=").append(endDate);
		RestTemplate restTem = new RestTemplate();
		JSONObject dataStr = restTem.postForObject(url_buf.toString(), null, JSONObject.class);
		if(dataStr != null){
			if(dataStr.getBigDecimal("totalPrice") != null){
				saleTotalFee = saleTotalFee.add(dataStr.getBigDecimal("totalPrice"));
			}
			if(dataStr.getBigDecimal("totalCostFee") != null){
				costTotalFee = costTotalFee.add(dataStr.getBigDecimal("totalCostFee"));
			}
			JSONObject ob = new JSONObject();
			ob.put("month", cal.get(Calendar.YEAR) +"-"+(cal.get(Calendar.MONTH)+1));
			ob.put("picTotal", dataStr.getInteger("totalPic"));
			ob.put("costFee", dataStr.getBigDecimal("totalCostFee"));
			ob.put("buluFee", BigDecimal.ZERO);
			ob.put("taxFee", BigDecimal.ZERO);
			ob.put("realFee", BigDecimal.ZERO);
			ob.put("bonus", BigDecimal.ZERO);
			ob.put("payTime", null);
			
			editData.add(ob);
		}
		
		JSONObject editReturn = new JSONObject();
		editReturn.put("saleTotalFee", saleTotalFee);
		editReturn.put("costTotalFee", costTotalFee);
		editReturn.put("data", editData);
		editReturn.put("status", 200);
		return editReturn;
	}
	
	public JSONObject getEditRoyaltiesInfo(Integer providerId, Date begin, 
			Date end){
		int year,month;
		BigDecimal saleTotalFee = BigDecimal.ZERO;
    	BigDecimal costTotalFee = BigDecimal.ZERO;
		Calendar cal = Calendar.getInstance();
		cal.setTime(begin);
		JSONArray editData = new JSONArray();
		while(cal.getTime().before(end)){
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH) + 1;
			Royalties record = royaltiesService
					.getRoyaltiesByMonth(providerId, Status.ASSET_FAMILY_EDIT, year, month);
			JSONObject ob = new JSONObject();
			if(record != null){
				if(record.getSaleAmount() != null){
					saleTotalFee = saleTotalFee.add(record.getSaleAmount());
				}
				if(record.getCostAmount() != null){
					costTotalFee = costTotalFee.add(record.getCostAmount());
				}
				ob.put("month", year + "-" + month);
				ob.put("picTotal", record.getPicTotal());
				ob.put("costFee", record.getCostAmount());
				ob.put("buluFee", BigDecimal.ZERO);
				ob.put("taxFee", BigDecimal.ZERO);
				ob.put("realFee", BigDecimal.ZERO);
				ob.put("bonus", BigDecimal.ZERO);
				ob.put("payTime", null);
			}else{
				ob.put("month", year + "-" + month);
				ob.put("picTotal", BigDecimal.ZERO);
				ob.put("costFee", BigDecimal.ZERO);
				ob.put("buluFee", BigDecimal.ZERO);
				ob.put("taxFee", BigDecimal.ZERO);
				ob.put("realFee", BigDecimal.ZERO);
				ob.put("bonus", BigDecimal.ZERO);
				ob.put("payTime", null);
			}
			editData.add(ob);
			cal.add(Calendar.MONTH, 1);
		}
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
		Royalties record = royaltiesService
				.getRoyaltiesByMonth(providerId, Status.ASSET_FAMILY_EDIT, year, month);
		JSONObject ob = new JSONObject();
		if(record != null){
			if(record.getSaleAmount() != null){
				saleTotalFee = saleTotalFee.add(record.getSaleAmount());
			}
			if(record.getCostAmount() != null){
				costTotalFee = costTotalFee.add(record.getCostAmount());
			}
			ob.put("month", year + "-" + month);
			ob.put("picTotal", record.getPicTotal());
			ob.put("costFee", record.getCostAmount());
			ob.put("buluFee", BigDecimal.ZERO);
			ob.put("taxFee", BigDecimal.ZERO);
			ob.put("realFee", BigDecimal.ZERO);
			ob.put("bonus", BigDecimal.ZERO);
			ob.put("payTime", null);
		}else{
			ob.put("month", year + "-" + month);
			ob.put("picTotal", BigDecimal.ZERO);
			ob.put("costFee", BigDecimal.ZERO);
			ob.put("buluFee", BigDecimal.ZERO);
			ob.put("taxFee", BigDecimal.ZERO);
			ob.put("realFee", BigDecimal.ZERO);
			ob.put("bonus", BigDecimal.ZERO);
			ob.put("payTime", null);
		}
		editData.add(ob);
		JSONObject editReturn = new JSONObject();
		editReturn.put("saleTotalFee", saleTotalFee);
		editReturn.put("costTotalFee", costTotalFee);
		editReturn.put("data", editData);
		editReturn.put("status", 200);
		return editReturn;
	}
	
	public JSONObject getEditSalesRecordInfo(Integer providerId, String beginDate,
			String endDate,int pageNum,int pageSize){
		StringBuffer url_buf = new StringBuffer();
		url_buf.append("http://boss.visualchina.com/crm/service/getEditSalesRecordInfo.action?")
			.append("providerId=").append(providerId)
			.append("&beginDate=").append(beginDate)
			.append("&endDate=").append(endDate);
		RestTemplate restTem = new RestTemplate();
		JSONObject dataMap = restTem.postForObject(url_buf.toString(), null, JSONObject.class);
		List<Object> data = new ArrayList<>();
		JSONObject rt = new JSONObject();
		if(dataMap != null){
			
			JSONArray zuoDan = dataMap.getJSONArray("zuoDan");
			JSONArray chePian = dataMap.getJSONArray("chePian");
			JSONArray all = new JSONArray();
			if(zuoDan != null){
				for(int i = 0;i < zuoDan.size(); i++){
					JSONObject zd = zuoDan.getJSONObject(i);
					JSONObject ob = new JSONObject();
					ob.put("resId", zd.get("out_id"));
        			ob.put("IP", zd.get("ip"));
        			ob.put("penName", zd.get("pen_name"));
        			ob.put("picUrl", zd.get("pic_url"));
                	ob.put("confirmTime", DateUtils.fomatToTimeString(zd.getDate("confirm_time")));
                	ob.put("verifyDate", DateUtils.fomatToTimeString(zd.getDate("sx_time")));
                	ob.put("accountType", zd.get("type_id"));
                	
                	all.add(ob);
				}
			}
			if(chePian != null){
				for(int i = 0;i < chePian.size(); i++){
					JSONObject zd = chePian.getJSONObject(i);
					JSONObject ob = new JSONObject();
					ob.put("resId", zd.get("out_id"));
        			ob.put("IP", zd.get("ip"));
        			ob.put("penName", zd.get("pen_name"));
        			ob.put("picUrl", zd.get("pic_url"));
        			ob.put("confirmTime", DateUtils.fomatToTimeString(zd.getDate("confirm_time")));
                	ob.put("verifyDate", DateUtils.fomatToTimeString(zd.getDate("sx_time")));
                	ob.put("accountType", zd.get("type_id"));
                	
                	all.add(ob);
				}
			}
			int pages = all.size() / pageSize;
			if(pages * pageSize < all.size()){
				pages += 1;
			}
			pageNum = pageNum < 1? 1 : pageNum;
			List<Object> onePage = new JSONArray();
			if(pageNum < pages){
				onePage = all.subList(pageSize * (pageNum - 1), pageSize * pageNum);
			}else if(pageNum == pages){
				onePage = all.subList(pageSize * (pageNum - 1), all.size());
			}else{
				onePage = null;
			}
			
			data = onePage;
			rt.put("total", all.size());
			rt.put("pages", pages);
		}else{
			rt.put("total", 0);
			rt.put("pages", 0);
		}
		
		rt.put("status", 200);
		rt.put("data", data);
		
		return rt;
	}
}
