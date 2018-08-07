package com.vcg.provider.web;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vcg.common.AbstractController;
import com.vcg.common.DateUtils;
import com.vcg.common.RestfulResult;
import com.vcg.common.ResultMap;
import com.vcg.common.Status;
import com.vcg.provider.entity.JigouContractPackage;
import com.vcg.provider.model.Collection;
import com.vcg.provider.model.Contact;
import com.vcg.provider.model.Contract;
import com.vcg.provider.model.ContractAuthorization;
import com.vcg.provider.model.ProviderPayment;
import com.vcg.provider.model.Provider;
import com.vcg.provider.model.ProviderAccess;
import com.vcg.provider.model.ProviderAccount;
import com.vcg.provider.model.ProviderPortalaccounts;
import com.vcg.provider.model.query.ContactExample;
import com.vcg.provider.model.query.ContractAuthorizationExample;
import com.vcg.provider.model.query.ContractExample;
import com.vcg.provider.model.query.ProviderPaymentExample;
import com.vcg.provider.model.query.ProviderAccessExample;
import com.vcg.provider.model.query.ProviderAccountExample;
import com.vcg.provider.model.query.ProviderPortalaccountsExample;
import com.vcg.provider.service.CollectionService;
import com.vcg.provider.service.ContactService;
import com.vcg.provider.service.ContractAuthorizationService;
import com.vcg.provider.service.ProviderPaymentService;
import com.vcg.provider.service.ContractService;
import com.vcg.provider.service.ProviderAccessService;
import com.vcg.provider.service.ProviderAccountService;
import com.vcg.provider.service.ProviderPortalaccountsService;
import com.vcg.provider.service.ProviderService;
import com.vcg.provider.util.AccountUtil;
import com.vcg.provider.util.MessageUtil;
import com.vcg.provider.util.RedisUtil;
import com.vcg.provider.util.UUIDUtil;
import com.vcg.uc.feignClient.PassportClient;
import com.vcg.uc.model.RsetPassword;
import com.vcg.uc.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/providerUpdate")
@Api("更新机构供应商信息")
public class ProviderUpdateController extends AbstractController{
	
	public static Logger log = Logger.getLogger(ProviderUpdateController.class);

	@Autowired
	private ContactService contactService;

	@Autowired
	private ProviderPaymentService contractPayService;
	
	@Autowired
	private ContractService contractService;
	
	
	@Autowired
	private AccountUtil accountUtil;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@Autowired
	private RedisUtil redisUtil;
	
	
	@Value("${mepx.notifyservice}")
	private String notifyservice;
	
	@Autowired
	private ProviderService providerService;
	
	@Autowired
	private ProviderAccessService providerAccessService;
	
	@Autowired
	private ProviderAccountService providerAccountService;
	
	@Autowired
	private PassportClient passportClient;
	
	@Autowired
	private ProviderPortalaccountsService providerPortalService;
 
	@Autowired
	private CollectionService collectionService;
	
	@Autowired
	private ContractAuthorizationService contractAuthorizationService;
 
	

	
	/**
	 * 机构-portal账号列表
	 * @return
	 */
	@ApiOperation(value = "机构-<portal账号列表>", notes = "供应商id",tags="Jigou Update")
	@RequestMapping(value="/getPortalCccountList",method=RequestMethod.POST)
	public Object getPortalCccountList(@ApiParam(value = "本机构的id") @RequestParam Integer ProviderId ){
		Map<String,Object> result = new HashMap<String,Object>();
		List<Map<String,Object>> retlist = new ArrayList<Map<String,Object>>();
		try {
			if(ProviderId==null ){
				return new RestfulResult(Status.ERROR,null, "供应商id为空");
			}else{
				ProviderPortalaccountsExample example = new ProviderPortalaccountsExample();
				example.createCriteria().andProviderIdEqualTo(ProviderId);
				List<ProviderPortalaccounts>  list = providerPortalService.selectByExample(example);
				 if(list.size()>0){
					 for(ProviderPortalaccounts e:list){
							Map<String,Object> map = new  HashMap<String,Object>();
							map.put("id", e.getId());
							map.put("portalAccount", e.getPortalAccount());
							map.put("email", e.getEmail());
							map.put("userCenterId",e.getUserCenterId());
							if(StringUtils.isNotBlank( e.getUserCenterId())){
								User user = passportClient.getByUserId( e.getUserCenterId());
								//{"mobile":"13811855184","modifyTime":1483683999000,"regTime":1470885447000,"status":1,"userFrom":2,"userId":"218b60cb04ba3a03942c7f4c316177180"}
								if(user!=null){
									map.put("accountStatus", user.getStatus());
								} 
							}
							retlist.add(map);
					 }
				 } 
				result.put("status", 200);
				result.put("data", retlist);
				result.put("msg", "ok");
				return  result;
			}
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return new RestfulResult(Status.ERROR,null, fullStackTrace);
		}

	}
	
 
	
	/**
	 * 机构-添加账号
	 * @return
	 */
	@ApiOperation(value = "机构-<添加portal账号>", notes = "供应商id,用户名,邮箱必填",tags="Jigou Update")
	@RequestMapping(value="/addPortalaccount",method=RequestMethod.POST)
	public Object addPortalaccount( @RequestBody ProviderPortalaccounts providerPortalaccounts){
		RestfulResult result = new RestfulResult(200,null, "添加成功");
		try {
 			if(providerPortalaccounts.getProviderId()==null || providerPortalaccounts.getEmail()==null || providerPortalaccounts.getPortalAccount()==null){
				result = new RestfulResult(Status.ERROR,null, "供应商id或者邮箱或者账户名为空");
			}else{
				
				Map<String, Object> mailexist = passportClient.emailIsExist(providerPortalaccounts.getEmail());
				Map<String, Object> accountexist = passportClient.userNameIsExist(providerPortalaccounts.getPortalAccount());
				if(mailexist.get("status").equals("403")){
					return new RestfulResult(Status.ERROR,null, "["+providerPortalaccounts.getEmail()+"]"+mailexist.get("msg").toString());
				}
				if(accountexist.get("status").equals("403")){
					return new RestfulResult(Status.ERROR,null, "["+providerPortalaccounts.getPortalAccount()+"]"+accountexist.get("msg").toString());
				}
				
				
				String password = UUIDUtil.generateUUID().replaceAll("-", "").substring(26);
				//String password = "123456";//密码还是用123456吧，万一邮件别人没收到
				String userCenterId = "";
				User user = new User();
				user.setUserName(providerPortalaccounts.getPortalAccount());
				user.setEmail(providerPortalaccounts.getEmail());
				user.setPassword(password);//默认密码
				user.setRegTime(new Date());
				
				user.setModifyTime(new Date());
				user.setStatus(1);//1有效0无效
				user.setUserType(1);//帐号类型:0-个人,1企业,2部门
				 Map<String, Object> register =   passportClient.register(user);//增加用户
				 if(!register.get("status").equals("200")){//USER_NAME_EXIST
					String message =   register.get("msg").toString();
					if(StringUtils.isNotBlank(message)){
						return  new RestfulResult(Status.ERROR,null,message);
					}else{
						return  new RestfulResult(Status.ERROR,null, "异常");
					}
				 }else{
					 userCenterId =   register.get("userId").toString();
					 
				 }
		    	messageUtil.portalAccountMail(providerPortalaccounts.getEmail(),providerPortalaccounts.getPortalAccount(), password);
				providerPortalaccounts.setUserCenterId(userCenterId);
				providerPortalService.insertSelective(providerPortalaccounts);
			}
  
		} catch (Exception e) {
			e.printStackTrace();
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			result = new RestfulResult(Status.ERROR,null, fullStackTrace);
		}

		return result;
	}
	
	
//	/**
//	 * 机构-修改账号
//	 * @return
//	 */
//	@ApiOperation(value = "机构-<修改Portal账号>", notes = "参数为本条记录的id,本条记录的用户名,本条记录的被修改的邮箱",tags="Jigou Update")
//	@RequestMapping(value="/updatePortalaccount",method=RequestMethod.POST)
//	public RestfulResult updatePortalaccount( @RequestBody ProviderPortalaccounts providerPortalaccounts){
//		RestfulResult result = new RestfulResult(200,null, "操作成功");
//		try {
//			if(providerPortalaccounts.getEmail()==null|| providerPortalaccounts.getPortalAccount()==null){
//				result = new RestfulResult(Status.ERROR,null, "邮箱或者用户名为空");
//			}else{
//				
//				User user = passportClient.getByUserName(providerPortalaccounts.getPortalAccount());
//				User update = new User();
//				update.setUserId(user.getUserId());
//				update.setEmail(providerPortalaccounts.getEmail());
//				user.setModifyTime(new Date());
//				passportClient.updateUser(user);//修改用户中心的邮箱
//				providerPortalService.updateByPrimaryKeySelective(providerPortalaccounts);
//			}
//  
//		} catch (Exception e) {
//			result = new RestfulResult(Status.ERROR,null, "异常");
//		}
//
//		return result;
//	}
	
	@ApiOperation(value = "机构-<账户信息-重置密码>", notes = "重置为123456")
	@RequestMapping(value="/resetUserCenterAccountPassword",method=RequestMethod.POST)
	public Object resetUserCenterAccountPassword(@ApiParam(value = "本供应商用户中心uerCenterId") @RequestParam String uerCenterId) throws IOException{

		User  user  = passportClient.getByUserId(uerCenterId);
		RsetPassword rpd = new RsetPassword();
		if(user!=null){
			rpd.setId(user.getUserId());
			rpd.setNewPassword("123456");
			Map<String, Object> reset =  passportClient.modifyPwd(rpd);
			
			 if(!reset.get("status").equals("200")){//USER_NAME_EXIST
					String message =   reset.get("msg").toString();
					if(StringUtils.isNotBlank(message)){
						return  new RestfulResult(Status.ERROR,null,message);
					}else{
						return  new RestfulResult(Status.ERROR,null, "异常");
					}
				 }else{
						messageUtil.portalAccountMail(user.getEmail(),user.getUserName(), "1223456");
						return new RestfulResult(200,null, "密码重置为123456");
					 
				 } 
			
			

		}else{
			return new RestfulResult(Status.ERROR,null, "用户不存在！");
		}   
	}
	
	
	
	
	@ApiOperation(value = "机构-<账户信息-置为无效>", notes = "")
	@RequestMapping(value="/setUserInvalid",method=RequestMethod.POST)
	public Object setUserInvalid(@ApiParam(value = "本供应商用户中心id") @RequestParam String uerCenterId){
		User  user  = passportClient.getByUserId(uerCenterId);
		if(user!=null){
			User  upddate = new User();
			upddate.setUserId(user.getUserId());
			upddate.setStatus(0);
			Map<String, Object> update = passportClient.updateUser(upddate);
			 if(!update.get("status").toString().equals("200")){
				String message =   update.get("msg").toString();
				if(StringUtils.isNotBlank(message)){
					return  new RestfulResult(Status.ERROR,null,message);
				}else{
					return  new RestfulResult(Status.ERROR,null, "异常");
				}
			 } 
			return new RestfulResult(200,null, "修改成功");
		}else{
			return new RestfulResult(Status.ERROR,null, "用户不存在！");
		}   
	}
	
	@ApiOperation(value = "供稿人基本信息-点击一行详情-<账户信息-置为有效>", notes = "")
	@RequestMapping(value="/setUserValid",method=RequestMethod.POST)
	public Object setUserValid(@ApiParam(value = "本供应商用户中心id") @RequestParam String uerCenterId){
		User  user  = passportClient.getByUserId(uerCenterId);
		if(user!=null){
			User  upddate = new User();
			upddate.setUserId(user.getUserId());
			upddate.setStatus(1);
			Map<String, Object> update  = passportClient.updateUser(upddate);
			 if(!update.get("status").toString().equals("200")){
				String message =   update.get("msg").toString();
				if(StringUtils.isNotBlank(message)){
					return  new RestfulResult(Status.ERROR,null,message);
				}else{
					return  new RestfulResult(Status.ERROR,null, "异常");
				}
			 } 
			
			
			return new RestfulResult(200,null, "修改成功");
		}else{
			return new RestfulResult(Status.ERROR,null, "用户不存在！");
		}   
	}
	
	
	
//	/**
//	 * 机构-冻结账号
//	 * @return
//	 */
//	@ApiOperation(value = "机构-<冻结Portal账号>", notes = "参数为本条记录的id,只需要填写id和用户名就行",tags="Jigou Update")
//	@RequestMapping(value="/blockPortalaccount",method=RequestMethod.POST)
//	public RestfulResult blockPortalaccount( @RequestBody ProviderPortalaccounts providerPortalaccounts){
//		RestfulResult result = new RestfulResult(200,null, "操作成功");
//		try {
//				User user = usercenterClient.getByUserName(providerPortalaccounts.getPortalAccount());
//				User update = new User();
//				update.setUserId(user.getUserId());
//				update.setStatus(0);
//				user.setModifyTime(new Date());
//				usercenterClient.updateUser(user);//修改用户中心状态
//				providerPortalaccounts.setIsFrozen(providerPortalaccounts.getIsFrozen());
//				providerPortalService.updateByPrimaryKeySelective(providerPortalaccounts);
//		} catch (Exception e) {
//			result = new RestfulResult(Status.ERROR,null, "异常");
//		}
//
//		return result;
//	}
	
	
	
	/**
	 * 机构-点击一行-基本信息
	 * @param id 机构id
	 * @return
	 */
	@ApiOperation(value = "个人-点击一行数据获取<基本信息>", notes = "例如419519",tags="Jigou Update")
	@RequestMapping(value="/getJigouBasicInfo",method=RequestMethod.POST)
	public Object getJigouBasicInfo(@ApiParam(value = "本行的供应商id,如419375") @RequestParam Integer id,@ApiParam(required = true)@RequestParam String token){
		
		Map<String,Object> searchParam = new HashMap<String,Object>();
		searchParam.put("id", id);
		ResultMap result = this.queryService.queryOneForCustom("providerManage", "getJigouBasicInfo", searchParam);//详情
		if(result==null){//不存在这个id的供应商
			return new RestfulResult<Map<String,Object>>(Status.ERROR,result,"不存在这个id对应的供应商");
		}else{
			if(result.getValue("createdBy")!=null){
				String userpartyid= result.getValue("createdBy").toString();
				String by = accountUtil.getUserNameByPartyId(userpartyid, token);
				result.putNoReplace("createdBy", by);
			}
			if(result.getValue("createdBy")!=null){
				String userpartyid= result.getValue("updatedBy").toString();
				String by = accountUtil.getUserNameByPartyId(userpartyid, token);
				result.putNoReplace("updatedBy", by);
			}
 
			return new RestfulResult<Map<String,Object>>(200,result,"操作成功");
		}

		 
		
	}
	
 
	@ApiOperation(value = "机构-<修改基本信息>", notes = "Id,NameCn,ShortName,AssetFamily,Attribute,QualityRank,Country,Province,Location",tags="Jigou Update")
	@RequestMapping(value="/updateJigouBasicInfo",method=RequestMethod.POST)
	public Object updateJigouBasicInfo(@ApiParam(value = "本行的供应商id,如419375") @RequestBody Provider provider,@ApiParam(required = true)@RequestParam String token){
		RestfulResult result = new RestfulResult(200,null, "操作成功");

        try {
        	
    		String userId = accountUtil.getUserId(token);
     		 if(StringUtils.isBlank(userId)){
      			 System.err.println("userId is null");
      			 return new RestfulResult(Status.ERROR,null, "Token失效,请重新登录!");
      		 }
            Provider update = new Provider();
            update.setId(provider.getId());
            update.setNameCn(provider.getNameCn());
            update.setShortName(provider.getShortName());
            update.setAssetFamily(provider.getAssetFamily());
            update.setQualityRank(provider.getQualityRank());
            update.setCountry(provider.getCountry());
            update.setProvince(provider.getProvince());
            update.setCity(provider.getCity());
            update.setLocation(provider.getLocation());
    			update.setUpdatedBy(userId);
    			update.setUpdatedTime(DateUtils.getNowDate());
    		providerService.updateByPrimaryKeySelective(update);
    		redisUtil.deleteRedisProvider(update.getId());
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			result = new RestfulResult(Status.ERROR,null, fullStackTrace);
		}
        return result;
	}
	
	
	@ApiOperation(value = "机构-<暂停供应商合作>", notes = "",tags="Jigou Update")
	@RequestMapping(value="/suspendJigouCoperation",method=RequestMethod.POST)
	public RestfulResult suspendJigouCoperation(@ApiParam(value = "本行的供应商id,如419375") @RequestParam Integer providerId,@ApiParam(required = true)@RequestParam String token){
		RestfulResult result = new RestfulResult(200,null, "操作成功");

        try {
    		String userId = accountUtil.getUserId(token);
	   		 if(StringUtils.isBlank(userId)){
	   			 System.err.println("userId is null");
	   			 return new RestfulResult(Status.ERROR,null, "Token失效,请重新登录!");
	   		 }
            Provider update = new Provider();
            update.setId(providerId);
            update.setStatus(5);//状态 1 未审核 2 待签合同 3 开通 4 不通过 5冻结 6关闭
    			update.setCreatedBy(userId);
    		providerService.updateByPrimaryKeySelective(update);
    		redisUtil.deleteRedisProvider(update.getId());
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			result = new RestfulResult(Status.ERROR,null, fullStackTrace);
		}
        return result;
	}
	
	
	/**
	 * 机构-contact列表
	 * @return
	 */
	@ApiOperation(value = "机构-<contact列表>", notes = "供应商id",tags="Jigou Update")
	@RequestMapping(value="/getContactList",method=RequestMethod.POST)
	public RestfulResult getContactList(@ApiParam(value = "本机构的id") @RequestParam Integer ProviderId ){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		try {
			if(ProviderId==null ){
				return new RestfulResult(Status.ERROR,null, "供应商id为空");
			}else{
				ContactExample example = new ContactExample();
				example.createCriteria().andProviderIdEqualTo(ProviderId);
				List<Contact>  list = contactService.selectByExample(example);
				return new RestfulResult(200,list, "操作成功");
			}
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return new RestfulResult(Status.ERROR,null, fullStackTrace);
		}
	}
	
	/**
	 * 机构-添加或者修改联系人
	 * @return
	 */
	@ApiOperation(value = "机构-<添加contact>", notes = "",tags="Jigou Update")
	@RequestMapping(value="/addOrUpdateJigouContact",method=RequestMethod.POST)
	public RestfulResult addOrUpdateJigouContact( @RequestBody Contact contact,@ApiParam(required = true)@RequestParam String token){
		RestfulResult result = new RestfulResult(200,null, "操作成功");

		try {
			String userId = accountUtil.getUserId(token);
			 if(StringUtils.isBlank(userId)){
				 System.err.println("userId is null");
				 return new RestfulResult(Status.ERROR,null, "Token失效,请重新登录!");
			 }
			
			if(contact.getProviderId()==null){
				result = new RestfulResult(Status.ERROR,null, "机构id为空");
			}else{
				if(contact.getId()==null){
					 contact.setCreatedBy(userId);
					 contact.setCreatedTime(DateUtils.getNowDate());
					 contactService.insertSelective(contact);
				}else{
					//可能有取消某人的主要联系人这种功能  
					
					if(contact.getIsDefault()!=null && contact.getIsDefault()==1){//将别人的首要联系人剥夺了,所以还需要修改别人的首要属性去掉
						ContactExample example = new ContactExample();
						example.createCriteria().andProviderIdEqualTo(contact.getProviderId()).andIsDefaultEqualTo(1);
						List<Contact>  list = contactService.selectByExample(example);
						if(list.size()>0){
							Contact other =  new Contact();
							other.setId(list.get(0).getId());
							other.setIsDefault(0);
							other.setUpdatedBy(userId);
							other.setUpdatedTime(DateUtils.getNowDate());
							contactService.updateByPrimaryKeySelective(other);
						}
					}
					 
					 contact.setUpdatedBy(userId);
					 contact.setUpdatedTime(DateUtils.getNowDate());
					 contactService.updateByPrimaryKeySelective(contact);
				}
				
			}
  
		} catch (Exception e) {
			e.printStackTrace();
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			result = new RestfulResult(Status.ERROR,null, fullStackTrace);
		}

		return result;
	}
	
 
	
	/**
	 * 机构-contact列表里删除一条
	 * @return
	 */
	@ApiOperation(value = "机构-<contact删除>", notes = "本条contactd的id",tags="Jigou Update")
	@RequestMapping(value="/deleteProviderContact",method=RequestMethod.POST)
	public RestfulResult deleteProviderContact(@ApiParam(value = "本条contact的id") @RequestParam Integer id ){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		try {
			if(id==null ){
				return new RestfulResult(Status.ERROR,null, "id为空");
			}else{
				contactService.deleteByPrimaryKey(id);
				return new RestfulResult(200,null, "操作成功");
			}
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return new RestfulResult(Status.ERROR,null, fullStackTrace);
		}
	}
	
	
	
	/**
	 * 机构-access列表
	 * @return
	 */
	@ApiOperation(value = "机构-<providerAccess列表>", notes = "供应商id",tags="Jigou Update")
	@RequestMapping(value="/getAccessList",method=RequestMethod.POST)
	public RestfulResult getAccessList(@ApiParam(value = "本机构的id") @RequestParam Integer ProviderId ){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		try {
			if(ProviderId==null ){
				return new RestfulResult(Status.ERROR,null, "供应商id为空");
			}else{
				ProviderAccessExample example = new ProviderAccessExample();
				example.createCriteria().andProviderIdEqualTo(ProviderId);
				List<ProviderAccess>  list = providerAccessService.selectByExample(example);
				return new RestfulResult(200,list, "操作成功");
			}
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return new RestfulResult(Status.ERROR,null, fullStackTrace);
		}
	}
  
	/**
	 * 机构-添加接入方式
	 * @return
	 */
	@ApiOperation(value = "机构-<添加或者修改providerAccess>", notes = "",tags="Jigou Update")
	@RequestMapping(value="/addOrUpdateJigouAccess",method=RequestMethod.POST)
	public Object addOrUpdateJigouAccess( @RequestBody ProviderAccess providerAccess,@ApiParam(required = true)@RequestParam String token){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		
		try {
			String userId = accountUtil.getUserId(token);
			 if(StringUtils.isBlank(userId)){
				 System.err.println("userId is null");
				 return new RestfulResult(Status.ERROR,null, "Token失效,请重新登录!");
			 }
			if(providerAccess.getProviderId()==null){
				result = new RestfulResult(Status.ERROR,null, "机构id为空");
			}else{
				if(providerAccess.getId()==null){
					providerAccess.setCreatedBy(userId);
					providerAccess.setCreatedTime(DateUtils.getNowDate());
					providerAccessService.insertSelective(providerAccess);
					
				}else{
					providerAccess.setUpdatedBy(userId);
					providerAccess.setUpdatedTime(DateUtils.getNowDate());
					providerAccessService.updateByPrimaryKeySelective(providerAccess);
				}
				
			}
  
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			result = new RestfulResult(Status.ERROR,null, fullStackTrace);
		}
		return result;
	}
	 
	
	/**
	 * 机构-access列表里删除一条
	 * @return
	 */
	@ApiOperation(value = "机构-<providerAccess删除>", notes = "本条accessId",tags="Jigou Update")
	@RequestMapping(value="/deleteProviderAccess",method=RequestMethod.POST)
	public RestfulResult deleteProviderAccess( @RequestParam Integer id ){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		try {
			if(id==null ){
				return new RestfulResult(Status.ERROR,null, "id为空");
			}else{
				  providerAccessService.deleteByPrimaryKey(id);
				return new RestfulResult(200,null, "操作成功");
			}
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return new RestfulResult(Status.ERROR,null, fullStackTrace);
		}
	}
	
 
	/**
	 * 机构-bankPay列表
	 * @return
	 */
	@ApiOperation(value = "机构-<Bank列表>", notes = "供应商id",tags="Jigou Update")
	@RequestMapping(value="/getBankList",method=RequestMethod.POST)
	public RestfulResult getBankList(@ApiParam(value = "本机构的id") @RequestParam Integer ProviderId ){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		try {
			if(ProviderId==null ){
				return new RestfulResult(Status.ERROR,null, "供应商id为空");
			}else{
				ProviderPaymentExample example = new ProviderPaymentExample();
				example.createCriteria().andProviderIdEqualTo(ProviderId);
				List<ProviderPayment>  list = contractPayService.selectByExample(example);
				return new RestfulResult(200,list, "操作成功");
			}
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return new RestfulResult(Status.ERROR,null, fullStackTrace);
		}
	}
  
	/**
	 * 机构-添加或者修改payment
	 * @return
	 */
	@ApiOperation(value = "机构-<添加或者修改payment>", notes = "",tags="Jigou Update")
	@RequestMapping(value="/addOrUpdatePayment",method=RequestMethod.POST)
	public RestfulResult addContractPay( @RequestBody ProviderPayment contractPay,@ApiParam(required = true)@RequestParam String token){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		try {
			String userId = accountUtil.getUserId(token);
			 if(StringUtils.isBlank(userId)){
				 System.err.println("userId is null");
				 return new RestfulResult(Status.ERROR,null, "Token失效,请重新登录!");
			 }
			if(contractPay.getProviderId()==null){
				result = new RestfulResult(Status.ERROR,null, "机构id为空");
			}else if(StringUtils.isBlank(contractPay.getPayeeName())){
				result = new RestfulResult(Status.ERROR,null, "账户名为空");
			}else if(StringUtils.isBlank(contractPay.getPayeeNumber())){
				result = new RestfulResult(Status.ERROR,null, "账号为空");
			}else if(StringUtils.isBlank(contractPay.getBankName())){
				result = new RestfulResult(Status.ERROR,null, "银行名为空");
			}else{
				contractPay.setIsBank(1);
				Provider  provider = 	providerService.getById(contractPay.getProviderId());
				contractPay.setAssetFamily(provider.getAssetFamily());
				if(contractPay.getId()==null){
					contractPay.setCreatedBy(userId);
					contractPay.setCreatedTime(DateUtils.getNowDate());
					contractPayService.insertSelective(contractPay);
				}else{
					contractPay.setUpdatedBy(userId);
					contractPay.setUpdatedTime(DateUtils.getNowDate());
					contractPayService.updateByPrimaryKeySelective(contractPay);
				}
				
			}
  
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			result = new RestfulResult(Status.ERROR,null, fullStackTrace);
		}

		return result;
	}
	
 
	
	/**
	 * 机构-ContractPay列表里删除一条
	 * @return
	 */
	@ApiOperation(value = "机构-<ContractPay删除>", notes = "本条ContractPay id",tags="Jigou Update")
	@RequestMapping(value="/deleteContractPay",method=RequestMethod.POST)
	public RestfulResult deleteContractPay( @ApiParam(required = true)@RequestParam Integer id ){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		try {
			if(id==null ){
				return new RestfulResult(Status.ERROR,null, "id为空");
			}else{
				
				 
				ContractExample example = new ContractExample();
				example.createCriteria().andPaymentIdEqualTo(id);
				List<Contract>  list = contractService.selectByExample(example);
				if(list.size()>0){
					return new RestfulResult(Status.ERROR,null, "此付款信息已经和已签约的合同关联,不能删除!");
				}
				
				contractPayService.deleteByPrimaryKey(id);
				return new RestfulResult(200,null, "操作成功");
			}
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return new RestfulResult(Status.ERROR,null, fullStackTrace);
		}
	}
	

	/**
	 * 机构-ProviderAccount列表
	 * @return
	 */
	@ApiOperation(value = "机构-<Account列表>", notes = "这个是供应商提供给我们的他们的网站的用户名和密码",tags="Jigou Update")
	@RequestMapping(value="/getProviderAccountList",method=RequestMethod.POST)
	public RestfulResult getProviderAccountList(@ApiParam(value = "本机构的id") @RequestParam Integer ProviderId ){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		try {
			if(ProviderId==null ){
				return new RestfulResult(Status.ERROR,null, "供应商id为空");
			}else{
				ProviderAccountExample example = new ProviderAccountExample();
				example.createCriteria().andProviderIdEqualTo(ProviderId);
				List<ProviderAccount>  list = providerAccountService.selectByExample(example);
				return new RestfulResult(200,list, "操作成功");
			}
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return new RestfulResult(Status.ERROR,null, fullStackTrace);
		}
	}
  
	/**
	 * 机构-添加ProviderAccount
	 * @return
	 */
	@ApiOperation(value = "机构-<添加ProviderAccount>", notes = "",tags="Jigou Update")
	@RequestMapping(value="/addOrUpdateProviderAccount",method=RequestMethod.POST)
	public RestfulResult addProviderAccount( @RequestBody ProviderAccount providerAccount,@ApiParam(required = true)@RequestParam String token){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		try {
			String userId = accountUtil.getUserId(token);
			 if(StringUtils.isBlank(userId)){
				 System.err.println("userId is null");
				 return new RestfulResult(Status.ERROR,null, "Token失效,请重新登录!");
			 }
			if(providerAccount.getProviderId()==null){
				result = new RestfulResult(Status.ERROR,null, "机构id为空");
			}else{
				if(providerAccount.getId()==null){
					providerAccount.setCreatedBy(userId);
					providerAccount.setCreatedTime(DateUtils.getNowDate());
					providerAccountService.insertSelective(providerAccount);
				}else{
					providerAccount.setUpdatedBy(userId);
					providerAccount.setUpdatedTime(DateUtils.getNowDate());
					providerAccountService.updateByPrimaryKeySelective(providerAccount);
				}
				
			}
  
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			result = new RestfulResult(Status.ERROR,null,fullStackTrace);
		}

		return result;
	}
	
 
	
	/**
	 * 机构-ProviderAccount列表里删除一条
	 * @return
	 */
	@ApiOperation(value = "机构-<ProviderAccount删除>", notes = "本条providerAccount id",tags="Jigou Update")
	@RequestMapping(value="/deleteProviderAccount",method=RequestMethod.POST)
	public RestfulResult deleteProviderAccount( @RequestParam Integer id ){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		try {
			if(id==null ){
				return new RestfulResult(Status.ERROR,null, "id为空");
			}else{
				providerAccountService.deleteByPrimaryKey(id);
				return new RestfulResult(200,null, "操作成功");
			}
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return new RestfulResult(Status.ERROR,null, fullStackTrace);
		}
	}
	
	
	
	
	
	
	/**
	 * 机构-修改资质信息
	 * @return
	 */
	@ApiOperation(value = "机构-<修改资质信息>", notes = "修改资质信息",tags="Jigou Update")
	@RequestMapping(value="/updateProviderPics",method=RequestMethod.POST)
	public RestfulResult updateProviderPic(@ApiParam(value = "本行的供应商营业执照图") @RequestParam String operationLicencePic,@ApiParam(value = "本行的供应商税务登记图")@RequestParam String taxRegistrationPic,@ApiParam(value = "本行的供应商id,如419375")@RequestParam Integer providerId){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		try {
			if(providerId==null ){
				return new RestfulResult(Status.ERROR,null, "id为空");
			}else{
				if(StringUtils.isNoneBlank(operationLicencePic)||StringUtils.isNoneBlank(taxRegistrationPic)){
					Provider update = new Provider();
		            update.setId(providerId);
		            if(StringUtils.isNoneBlank(operationLicencePic)){
		            	 update.setLicencePic(operationLicencePic);
		            }else{
		            	update.setLicencePic(" ");
		            }
		            if(StringUtils.isNoneBlank(taxRegistrationPic)){
		            	update.setTaxPic(taxRegistrationPic);
		            }else{
		            	update.setLicencePic(" ");
		            }
		    		providerService.updateByPrimaryKeySelective(update);
		    		redisUtil.deleteRedisProvider(update.getId());
	 
				}
				return new RestfulResult(200,null, "操作成功");
			}
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return new RestfulResult(Status.ERROR,null, fullStackTrace);
		}
	}
	
	
	/**
	 * 机构-获取资质信息
	 * @return
	 */
	@ApiOperation(value = "机构-<获取资质信息>", notes = "获取资质信息",tags="Jigou Update")
	@RequestMapping(value="/getProviderPics",method=RequestMethod.POST)
	public RestfulResult getProviderPics(@ApiParam(value = "本行的供应商id,如419375")@RequestParam Integer providerId){
		        RestfulResult result = new RestfulResult(200,null, "操作成功");
		    	Provider  provider = 	providerService.getById(providerId);
				return new RestfulResult(200,provider, "操作成功"); 
	}
	
	/**
	 * 机构-修改备注
	 * @return
	 */
	@ApiOperation(value = "机构-<修改备注>", notes = "修改修改备注",tags="Jigou Update")
	@RequestMapping(value="/updateComment",method=RequestMethod.POST)
	public RestfulResult updateComment(@ApiParam(value = "供应商备注") @RequestParam String comment,@ApiParam(value = "本行的供应商id,如419375")@RequestParam Integer providerId){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		try {
			if(providerId==null ){
				return new RestfulResult(Status.ERROR,null, "id为空");
			}else{
				if(StringUtils.isNoneBlank(comment)){
					Provider update = new Provider();
		            update.setId(providerId);
		            update.setComment(comment);
		    		providerService.updateByPrimaryKeySelective(update);
		    		redisUtil.deleteRedisProvider(update.getId());
				}
				return new RestfulResult(200,null, "操作成功");
			}
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return new RestfulResult(Status.ERROR,null, fullStackTrace);
		}
	}
	
	/**
	 * 机构-获取备注信息
	 * @return
	 */
	@ApiOperation(value = "机构-<获取备注信息>", notes = "获取备注信息",tags="Jigou Update")
	@RequestMapping(value="/getProviderComment",method=RequestMethod.POST)
	public RestfulResult getProviderComment(@ApiParam(value = "本行的供应商id,如419375")@RequestParam Integer providerId){
		        RestfulResult result = new RestfulResult(200,null, "操作成功");
		    	Provider  provider = 	providerService.getById(providerId);
		    
				return new RestfulResult(200,provider.getComment(), "操作成功"); 
	}
 
	
	/**
	 * 机构-合同列表
	 * @return
	 */
	@ApiOperation(value = "机构-<Contract列表>", notes = "合同附带授权列表,collection列表",tags="Jigou Update")
	@RequestMapping(value="/getJigouContractList",method=RequestMethod.POST)
	public RestfulResult getJigouContractList(@ApiParam(value = "本机构的id,如 419375") @RequestParam Integer id ){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			if(id==null ){
				return new RestfulResult(Status.ERROR,null, "供应商id为空");
			}else{
				Provider ps = redisUtil.getProvider(id);
				ContractExample exam = new ContractExample();
				exam.createCriteria().andProviderIdEqualTo(id);
				List<Contract> contracts = this.contractService.selectByExample(exam);
				
				List<JigouContractPackage> packagelist= new ArrayList<JigouContractPackage>();
				JigouContractPackage jigouContractPackage = new JigouContractPackage();
				if(contracts.size()>0){
					for(Contract con: contracts){
						jigouContractPackage = new JigouContractPackage();
						jigouContractPackage.setContract(con);
						jigouContractPackage.setShortName(ps.getShortName());
						
						//合同对应的collection列表
						List<Collection> clist =  collectionService.getCollectionByContractIdAndProviderId(con.getId(), id);
						if(clist!=null&&clist.size()>0){
							jigouContractPackage.setCollectionList(clist);
						}
						
						//合同对应的授权列表
						ContractAuthorizationExample example = new ContractAuthorizationExample();
						example.createCriteria().andContractIdEqualTo(con.getId());
						List<ContractAuthorization> alist =  contractAuthorizationService.selectByExample(example);
						if(alist!=null&& alist.size()>0){
							jigouContractPackage.setContractAuthorizationList(alist);
						}
						packagelist.add(jigouContractPackage);
	 
					}
					
				}
				
				map.put("contracts", packagelist);
				return new RestfulResult(200,map, "操作成功");
			}
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return new RestfulResult(Status.ERROR,null, fullStackTrace);
		}
	}
	
	
	
	/**
	 * 机构-合同列表-点击一个合同"修获取这个合同和这个合同的授权和collection
	 * 
	 * @return
	 */
	@ApiOperation(value = "机构-Contract列表-取这个合同和这个合同的授权和collection", notes = "机构-Contract列表-取这个合同和这个合同的授权和collection",tags="Jigou Update")
	@RequestMapping(value="/getJigouOneContract",method=RequestMethod.POST)
	public Object getJigouOneContract(@ApiParam(value = "本合同的id") @RequestParam Integer contractId ){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			if(contractId==null){
				return new RestfulResult(Status.ERROR,null, "供应商合同id为空");
			}else{
				Contract contract = this.contractService.getById(contractId);
				if(contract==null){
					return new RestfulResult(Status.ERROR,null, "合同不存在");
				}
				
				Provider ps = redisUtil.getProvider(contract.getProviderId());
				
				if(ps==null){
					return new RestfulResult(Status.ERROR,null, "本供应商不存在");
				}
			 
				JigouContractPackage jigouContractPackage = new JigouContractPackage();
				jigouContractPackage.setContract(contract);
				jigouContractPackage.setShortName(ps.getShortName());
		 
				ProviderPayment  providerPayment = contractPayService.getById(contract.getPaymentId());
				jigouContractPackage.setProviderPayment(providerPayment);
				
				//合同对应的collection列表
				List<Collection> clist =  collectionService.getCollectionByContractIdAndProviderId(contract.getId(), contract.getProviderId());
				if(clist!=null&&clist.size()>0){
					jigouContractPackage.setCollectionList(clist);
				}
				
				//合同对应的授权列表
				ContractAuthorizationExample example = new ContractAuthorizationExample();
				example.createCriteria().andContractIdEqualTo(contract.getId());
				List<ContractAuthorization> alist =  contractAuthorizationService.selectByExample(example);
				if(alist!=null&& alist.size()>0){
					jigouContractPackage.setContractAuthorizationList(alist);
				}
				return new RestfulResult(200,jigouContractPackage, "操作成功");
			}
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return new RestfulResult(Status.ERROR,null, fullStackTrace);
		}
	}
	 
	
	
	
	
	
	
	/**
	 * 机构-添加或者修改联系人
	 * @return
	 */
	@ApiOperation(value = "机构-修改合同-<添加或者修改Authorization>", notes = "",tags="Jigou Update")
	@RequestMapping(value="/addOrUpdateJigouContractAuthorization",method=RequestMethod.POST)
	public Object addOrUpdateJigouContractAuthorization( @RequestBody ContractAuthorization contractAuthorization,@ApiParam(required = true)@RequestParam String token){
		RestfulResult result = new RestfulResult(200,null, "操作成功");

		try {
			String userId = accountUtil.getUserId(token);
			 if(StringUtils.isBlank(userId)){
				 System.err.println("userId is null");
				 return new RestfulResult(Status.ERROR,null, "Token失效,请重新登录!");
			 }
			
			if(contractAuthorization.getContractId()==null){
				result = new RestfulResult(Status.ERROR,null, "合同id为空");
			}else if(contractAuthorization.getAssetType()==null){
				result = new RestfulResult(Status.ERROR,null, "产品类型为空");
			}else if(contractAuthorization.getAssetType()==null){
				result = new RestfulResult(Status.ERROR,null, "授权方式为空");
			}else if(contractAuthorization.getExclusiveType()==null){
				result = new RestfulResult(Status.ERROR,null, "独家性为空");
			}else if(StringUtils.isBlank(contractAuthorization.getFenchengRate())){
				result = new RestfulResult(Status.ERROR,null, "分成比例为空");
			}else{
				if(contractAuthorization.getId()==null){
					contractAuthorization.setCreatedBy(userId);
					contractAuthorization.setCreatedTime(DateUtils.getNowDate());
					contractAuthorizationService.insertSelective(contractAuthorization);
				}else{
				 
			 
					 
					contractAuthorization.setUpdatedBy(userId);
					contractAuthorization.setUpdatedTime(DateUtils.getNowDate());
					 contractAuthorizationService.updateByPrimaryKeySelective(contractAuthorization);
				}
				
			}
  
		} catch (Exception e) {
			e.printStackTrace();
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			result = new RestfulResult(Status.ERROR,null, fullStackTrace);
		}

		return result;
	}
	
 
	
	/**
	 * 机构-contact列表里删除授权
	 * @return
	 */
	@ApiOperation(value = "机构-修改合同-<删除授权>", notes = "删除授权",tags="Jigou Update")
	@RequestMapping(value="/deleteContractAuthorization",method=RequestMethod.POST)
	public RestfulResult deleteContractAuthorization(@ApiParam(value = "本条authorization的id") @RequestParam Integer id,@ApiParam(required = true)@RequestParam String token ){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		try {
			String userId = accountUtil.getUserId(token);
			 if(StringUtils.isBlank(userId)){
				 System.err.println("userId is null");
				 return new RestfulResult(Status.ERROR,null, "Token失效,请重新登录!");
			 }
			if(id==null ){
				return new RestfulResult(Status.ERROR,null, "id为空");
			}else{
				contractAuthorizationService.deleteByPrimaryKey(id);
				return new RestfulResult(200,null, "操作成功");
			}
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return new RestfulResult(Status.ERROR,null, fullStackTrace);
		}
	}
	
	
	/**
	 * 机构-contact列表里无效授权
	 * @return
	 */
	@ApiOperation(value = "机构-修改合同-<置授权无效>", notes = "将授权置为无效",tags="Jigou Update")
	@RequestMapping(value="/invalidContractAuthorization",method=RequestMethod.POST)
	public RestfulResult invalidContractAuthorization(@ApiParam(value = "本条authorization的id") @RequestParam Integer id,@ApiParam(required = true)@RequestParam String token ){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		try {
			String userId = accountUtil.getUserId(token);
			 if(StringUtils.isBlank(userId)){
				 System.err.println("userId is null");
				 return new RestfulResult(Status.ERROR,null, "Token失效,请重新登录!");
			 }
			if(id==null ){
				return new RestfulResult(Status.ERROR,null, "id为空");
			}else{
				ContractAuthorization contractAuthorization = new ContractAuthorization();
				contractAuthorization.setId(id);
				contractAuthorization.setUpdatedBy(userId);
				contractAuthorization.setUpdatedTime(DateUtils.getNowDate());
				contractAuthorization.setAuthstatus(0);
				contractAuthorizationService.updateByPrimaryKeySelective(contractAuthorization);
				return new RestfulResult(200,null, "操作成功");
			}
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return new RestfulResult(Status.ERROR,null, fullStackTrace);
		}
	}
	
	
	
	/**
	 * 机构-点击一行详细信息-保存或者修改合同的collection
	 * @return
	 */
	@ApiOperation(value = "供稿人-详情-点击修改合同-保存合同collection", notes = "同时也可以做关闭collection用",tags="Jigou Update")
	@RequestMapping(value="/addOrUpdateJigouContractCollection",method=RequestMethod.POST)
	public RestfulResult addOrUpdateJigouContractCollection( @RequestBody Collection collection,@ApiParam(required = true)@RequestParam String token){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		Map<String,Object> res= new HashMap<String,Object>();
 
		try {
			String userId = accountUtil.getUserId(token);
			 if(StringUtils.isBlank(userId)){
				 System.err.println("userId is null");
				 return new RestfulResult(Status.ERROR,null, "Token失效,请重新登录!");
			 }
			 
			 if(collection.getProviderId()==null){
					return  new RestfulResult(Status.ERROR,null, "机构id为空");
				}else if(collection.getContractId()==null){
					return new RestfulResult(Status.ERROR,null, "contractId为空");
				}else{
					if(collection.getId()==null){//新建
						collection.setCreatedBy(userId);
						collection.setCreatedTime(DateUtils.getNowDate());
						collectionService.insertSelective(collection);
					}else{//更新
						collection.setUpdatedBy(userId);
						collection.setUpdatedTime(DateUtils.getNowDate());
						collectionService.updateByPrimaryKeySelective(collection);
						redisUtil.deleteRedisCollection(collection.getId());
						
					}
				}
 
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			result = new RestfulResult(Status.ERROR,null, fullStackTrace);
		}

		return result;
	}
	 
 
	
	/**
	 * 机构-点击一行详细信息-删除合同的collection
	 * @return
	 */
	@ApiOperation(value = "供稿人-详情-点击修改合同- 删除合同的collection", notes = "",tags="Jigou Update")
	@RequestMapping(value="/deleteJigouContractCollection",method=RequestMethod.POST)
	public RestfulResult deleteJigouContractCollection(@ApiParam(value = "本colloction id,例如41") @RequestParam Integer id,@ApiParam(required = true)@RequestParam String token){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		Map<String,Object> res= new HashMap<String,Object>();
 
		try {
			String userId = accountUtil.getUserId(token);
			 if(StringUtils.isBlank(userId)){
				 System.err.println("userId is null");
				 return new RestfulResult(Status.ERROR,null, "Token失效,请重新登录!");
			 }
			if(id==null){
				result = new RestfulResult(Status.ERROR,null, "无主键");
			} else{
					collectionService.deleteByPrimaryKey(id);
				}
				 
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			result = new RestfulResult(Status.ERROR,null, fullStackTrace);
		}

		return result;
	}
	
	
	@ApiOperation(value = "机构-<修改合同基本信息>", notes = "",tags="Jigou Update")
	@RequestMapping(value="/updateContractBasicInfo",method=RequestMethod.POST)
	public Object updateContractBasicInfo(@ApiParam(value = "合同") @RequestBody Contract contract,@ApiParam(required = true)@RequestParam String token){
		RestfulResult result = new RestfulResult(200,null, "操作成功");

        try {
        	
    		String userId = accountUtil.getUserId(token);
     		 if(StringUtils.isBlank(userId)){
      			 return new RestfulResult(Status.ERROR,null, "Token失效,请重新登录!");
      		 }
     		 
     		 if(contract.getId()==null){
      			 return new RestfulResult(Status.ERROR,null, "主键id为空");
      		 }
     		 
     		contract.setUpdatedBy(userId);
     		contract.setUpdatedTime(DateUtils.getNowDate());
			contractService.updateByPrimaryKeySelective(contract);
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			result = new RestfulResult(Status.ERROR,null, fullStackTrace);
		}
        return result;
	}
	
	
	
 
	
}
