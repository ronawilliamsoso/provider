package com.vcg.provider.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vcg.common.DateUtils;
import com.vcg.common.RestfulResultFactory;
import com.vcg.common.ResultMap;
import com.vcg.provider.entity.SearchSellReport;
import com.vcg.provider.model.Contact;
import com.vcg.provider.model.Provider;
import com.vcg.provider.model.ProviderPayment;
import com.vcg.provider.model.ResourceSellMonth;
import com.vcg.provider.model.query.ContactExample;
import com.vcg.provider.model.query.ProviderExample;
import com.vcg.provider.model.query.ProviderPaymentExample;
import com.vcg.provider.model.query.ResourceSellExample;
import com.vcg.provider.model.query.ResourceSellMonthExample;
import com.vcg.provider.model.query.ResourceSellMonthExample.Criteria;
import com.vcg.provider.service.ContactService;
import com.vcg.provider.service.ProviderPaymentService;
import com.vcg.provider.service.ProviderService;
import com.vcg.provider.service.ResourceSellMonthService;
import com.vcg.provider.util.MessageUtil;
import com.vcg.provider.util.SearchUtil;

import ch.qos.logback.core.status.Status;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

//@Api(value = "user", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/resourceSellMonth")
public class ResourceSellMonthController {

	@Autowired
	private ResourceSellMonthService resourceSellMonthService;
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private ProviderService providerService;
	
	@Autowired
	private ProviderPaymentService providerPaymentService;
	
	
	@Autowired
	private MessageUtil messageUtil;
 
	
	@ApiOperation(value = "供稿人-<二级报表>", notes = "供稿人-<二级报表>")
	@RequestMapping(value="/monthList", method=RequestMethod.POST)
	public Object monthList(@ApiParam(value = "只按照assetFamily,month,assetFamily,isPaied,isPublished搜索")@RequestBody SearchSellReport requestParam){
		Map<String,Object> ret = new HashMap<String,Object>();
		if(requestParam.getAgentType()==null){
	    	return RestfulResultFactory.getInstance(Status.ERROR, null,  "agentType必填");
	    }
//		if(StringUtils.isBlank(requestParam.getSellMonth())){
//	    	return RestfulResultFactory.getInstance(Status.ERROR, null,  "sellMonth从上级页面来，必填");
//	    }
		if(requestParam.getPageNum()==null){
	    	return RestfulResultFactory.getInstance(Status.ERROR, null,  "PageNum必填");
	    }
		if(requestParam.getPageSize()==null){
	    	return RestfulResultFactory.getInstance(Status.ERROR, null,  "PageSize必填");
	    }
		//requestParam.setPageNum(requestParam.getPageNum()-1); 
		
		try {
			 

			ResourceSellMonthExample example=new ResourceSellMonthExample();
			Criteria criteria =  example.createCriteria();
			criteria.andAgentTypeEqualTo(requestParam.getAgentType());
			if(requestParam.getAssetFamily()!=null){
				criteria.andAssetFamilyEqualTo(requestParam.getAssetFamily());
			}
			if(StringUtils.isNotBlank(requestParam.getSellMonth())){
				criteria.andSellMonthEqualTo(requestParam.getSellMonth());
			}
			if(requestParam.getIsPaied()!=null){
				criteria.andIsPaiedEqualTo(requestParam.getIsPaied());
			}
			if(requestParam.getIsPublished()!=null){
				criteria.andIsPublishedEqualTo(requestParam.getIsPublished());
			}
 
			if(requestParam.getSearchType()!=null && StringUtils.isNotBlank(requestParam.getSearchName())){
				if(requestParam.getSearchType()==1){
					criteria.andProviderNameLike("%"+requestParam.getSearchName()+"%");
				} 
			}
			PageHelper.startPage(requestParam.getPageNum(), requestParam.getPageSize());
			List<ResourceSellMonth> lst = this.resourceSellMonthService.selectByExample(example);
	 		ret.put("status", 200);
	 		ret.put("data", lst);
	 		ret.put("total",this.resourceSellMonthService.countByExample(example));
	 		 
	 		return ret;		         
		     } catch (Exception e) {
		       e.printStackTrace(); 
		       return RestfulResultFactory.getInstance(201, null,  "失败");
		     } 
     }
	
	@ApiOperation(value = "供稿人-二级报表-<发布>", notes = "发布")
	@RequestMapping(value="/publish",method=RequestMethod.POST)
	public Object publish(@ApiParam(value = "本条数据id")@RequestParam(required = false) String ids){
		String[] idarray = ids.split(",");
		List<Integer> intlist =  Arrays.asList(idarray).stream().map(e->Integer.parseInt(e)).collect(Collectors.toList());
		try {
			intlist.forEach(e->{
				ResourceSellMonth resourceSellMonth = new ResourceSellMonth();
				resourceSellMonth.setIsPublished(1);
				resourceSellMonth.setId(e);
				 this.resourceSellMonthService.updateByPrimaryKeySelective(resourceSellMonth);
			});
			
			//发邮件催促 只通知首要联系人
			ResourceSellMonthExample example=new ResourceSellMonthExample();
			example.createCriteria().andIdIn(intlist);
			List<ResourceSellMonth> lst = this.resourceSellMonthService.selectByExample(example);
			for(ResourceSellMonth resourceSellMonth: lst){
				
				Provider provider = providerService.getById(resourceSellMonth.getProviderId());
				if(provider!=null){
					Integer isNative = provider.getIsNative();
					ContactExample contactexample = new ContactExample();
					contactexample.createCriteria().andProviderIdEqualTo(resourceSellMonth.getProviderId()).andIsDefaultEqualTo(1);
					List<Contact> contactlist =   contactService.selectByExample(contactexample);
					if(contactlist.size()>0){
						Contact contact = contactlist.get(0);
						 if(StringUtils.isNotBlank(contact.getEmail())){
							 messageUtil.reportMonthEmail(contact.getEmail(),isNative, resourceSellMonth.getSellMonth()+"01");
						 }
					}
				}
			}
			
			
			
			
			
			
			
			
			return RestfulResultFactory.getInstance(200, null,  "成功发布");		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e1);
			return RestfulResultFactory.getInstance(Status.ERROR, null,  fullStackTrace);		
		}
	}
	
	@ApiOperation(value = "供稿人-二级报表-<付款>", notes = "付款")
	@RequestMapping(value="/pay",method=RequestMethod.POST)
	public Object pay(@ApiParam(value = "本条数据id")@RequestParam(required = false) String ids){
		 
		String[] idarray = ids.split(",");
		List<Integer> intlist =  Arrays.asList(idarray).stream().map(e->Integer.parseInt(e)).collect(Collectors.toList());
		
		//检查是否有首要联系人 如果没有 提醒修改
		ResourceSellMonthExample example=new ResourceSellMonthExample();
		example.createCriteria().andIdIn(intlist);
		List<ResourceSellMonth> lst = this.resourceSellMonthService.selectByExample(example);
		
		List<Integer> providerIds =  lst.stream().map(e->e.getProviderId()).collect(Collectors.toList());
		
		ContactExample contactexample = new ContactExample();
		contactexample.createCriteria().andProviderIdIn(providerIds);
		List<Contact> contactlist =   contactService.selectByExample(contactexample);
		List<Integer> cant_notice_providers_id = new ArrayList<Integer>();
		List<String> cant_notice_providers_names = new ArrayList<String>();
		if(contactlist.size()!=providerIds.size()){
			for(Contact c: contactlist){
				if(!providerIds.contains(c.getProviderId())){//说明这个用户没有首要联系人
					//Provider provider = providerService.getById(c.getProviderId());
					cant_notice_providers_id.add(c.getProviderId());
					//return RestfulResultFactory.getInstance(Status.ERROR, null,  provider.getNameCn()+"不存在首要联系人,无法发送给他通知,请维护数据后重试");	
				}
			}
		}
		
		
		
		
		try {
			intlist.forEach(e->{
				ResourceSellMonth resourceSellMonth = new ResourceSellMonth();
				resourceSellMonth.setIsPaied(1);
				resourceSellMonth.setId(e);
				resourceSellMonth.setPayTime(DateUtils.getNowDate());
				this.resourceSellMonthService.updateByPrimaryKeySelective(resourceSellMonth);
			});
			
			//发邮件付款通知
			 example=new ResourceSellMonthExample();
			example.createCriteria().andIdIn(intlist);
			lst = this.resourceSellMonthService.selectByExample(example);
			for(ResourceSellMonth resourceSellMonth: lst){
 
//					contactexample = new ContactExample();
//					contactexample.createCriteria().andProviderIdEqualTo(resourceSellMonth.getProviderId()).andIsDefaultEqualTo(1);
//					contactlist =   contactService.selectByExample(contactexample);
					
					ProviderPaymentExample peyexample = new ProviderPaymentExample();
					peyexample.createCriteria().andProviderIdEqualTo(resourceSellMonth.getProviderId());
					List<ProviderPayment> paylist =   providerPaymentService.selectByExample(peyexample);
 
					if(contactlist.size()>0  && paylist.size()>0 ){
						Contact contact = contactlist.get(0);
						ProviderPayment providerPayment = paylist.get(0);
						 if(StringUtils.isNotBlank(contact.getEmail()) && StringUtils.isNotBlank(providerPayment.getPayeeNumber())){
							 messageUtil.billPaiedMail(contact.getEmail(),providerPayment.getPayeeNumber(),providerPayment.getIsBank(),resourceSellMonth.getShareTotal()+"");
						 }
						 
						 if(StringUtils.isNotBlank(contact.getMobile()) && StringUtils.isNotBlank(providerPayment.getPayeeNumber())){
							 messageUtil.billPaiedMailSms(contact.getMobile(),providerPayment.getPayeeNumber(),providerPayment.getIsBank(),resourceSellMonth.getShareTotal()+"");
						 }
						 
					} 
				 
			}
			if(cant_notice_providers_id.size()>0){
				
				ProviderExample providerexample = new ProviderExample();
				providerexample.createCriteria().andIdIn(cant_notice_providers_id);
				List<Provider> providers =  providerService.selectByExample(providerexample);
				for(Provider p:providers){
					cant_notice_providers_names.add(p.getNameCn());
				}
				
				
				return RestfulResultFactory.getInstance(200, null,  "成功付款,但是如下用户因为联系人信息或者银行卡信息不全,无法通知他们:"+cant_notice_providers_names);		
			}else{
				return RestfulResultFactory.getInstance(200, null,  "成功付款");		
			}
			  
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e1);
			return RestfulResultFactory.getInstance(Status.ERROR, null,  fullStackTrace);		
		}
	}
}
