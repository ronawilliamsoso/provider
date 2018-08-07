package com.vcg.provider.web;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vcg.common.AbstractController;
import com.vcg.common.DateUtils;
import com.vcg.common.RestfulResult;
import com.vcg.common.Status;
import com.vcg.provider.entity.PortalBaseInfo;
import com.vcg.provider.model.Contact;
import com.vcg.provider.model.Provider;
import com.vcg.provider.model.query.ContactExample;
import com.vcg.provider.service.ContactService;
import com.vcg.provider.service.ProviderService;
import com.vcg.provider.util.RedisUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/portalupdate")
public class PortalUpdateController extends AbstractController {

	
	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private ProviderService providerService;
	
	/**
	 * portal 基本信息
	 * @param id 机构id
	 * @return
	 */
	@ApiOperation(value = "portal--<基本信息>", notes = "portal--<获取基本信息>")
	@RequestMapping(value="/getPortalBasicInfo",method=RequestMethod.POST)
	public Object getPortalBasicInfo(@ApiParam(value = "本行的供应商id,如468043",required=true) @RequestParam Integer providerId){
 
		PortalBaseInfo info  =  new PortalBaseInfo();
 
		try {
			 Provider p  = redisUtil.getProvider(providerId);
			 if(p==null){
				 return new RestfulResult(Status.ERROR,null,"不存在这个用户");
			 }else{
				 info.setCompany(p.getCompany());
				 info.setPid(p.getId());
				 ContactExample example=new ContactExample();
				 example.createCriteria().andProviderIdEqualTo(providerId).andIsDefaultEqualTo(1);
				 List<Contact>  contactlst = contactService.selectByExample(example);
				 if(contactlst.size()>0){
					 Contact c = contactlst.get(0);
					 info.setCid(c.getId());
					 info.setName(c.getName());
					 info.setAddress(c.getAddress());
					 info.setMobile(c.getMobile());
					 info.setEmail(c.getEmail());
					 info.setSkype(c.getSkype());
					 info.setQq(c.getQq());
				 }
				 return new RestfulResult(200,info,"ok");
			 }

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return new RestfulResult(Status.ERROR,null,fullStackTrace);
		}
	}
	
	
	
	/**
	 * portal-修改portal用户的信息
	 * @return
	 */
 
	@ApiOperation(value = "portal-修改portal用户的信息", notes = "portal-修改portal用户的信息")
	@RequestMapping(value="/updatePortalBasicInfo",method=RequestMethod.POST)
	public RestfulResult updatePortalBasicInfo(@ApiParam(required = true)@RequestBody PortalBaseInfo info ){
		 
		try {
 
				if(info.getPid()==null){
					 return new RestfulResult(Status.ERROR,null,"pid不能为空!");
				}
				if(StringUtils.isNotBlank(info.getCompany())){
					Provider p = new Provider();
					p.setId(info.getPid());
					p.setCompany(info.getCompany());
					p.setUpdatedTime(DateUtils.getNowDate());
					providerService.updateByPrimaryKeySelective(p);
					redisUtil.deleteRedisProvider(info.getPid());
				}
				
				if(info.getCid()==null){//新增首要联系人
					 Contact insert = new Contact();
					 insert.setProviderId(info.getPid());
					 insert.setName(info.getName());
					 insert.setAddress(info.getAddress());
					 insert.setMobile(info.getMobile());
					 insert.setEmail(info.getEmail());
					 insert.setSkype(info.getSkype());
					 insert.setQq(info.getQq());
					 contactService.insert(insert);
					
				}else{//修改首要联系人
					Contact update = new Contact();
					update.setId(info.getCid());
					update.setProviderId(info.getPid());
					update.setName(info.getName());
					update.setAddress(info.getAddress());
					update.setMobile(info.getMobile());
					update.setEmail(info.getEmail());
					update.setSkype(info.getSkype());
					update.setQq(info.getQq());
					 contactService.updateByPrimaryKeySelective(update);
					
				}
				return new RestfulResult(200,info,"ok");
 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return new RestfulResult(Status.ERROR,null,fullStackTrace);
		}
		  

	}
	
	 
	
}
