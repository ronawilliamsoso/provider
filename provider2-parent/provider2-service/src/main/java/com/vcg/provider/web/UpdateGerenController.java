package com.vcg.provider.web;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
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
import com.vcg.common.Status;
import com.vcg.provider.entity.JigouContractPackage;
import com.vcg.provider.entity.UpdateGerenBaseInfo;
import com.vcg.provider.model.Collection;
import com.vcg.provider.model.Contact;
import com.vcg.provider.model.Contract;
import com.vcg.provider.model.ProviderPayment;
import com.vcg.provider.model.Provider;
import com.vcg.provider.model.query.ContractExample;
import com.vcg.provider.service.CollectionService;
import com.vcg.provider.service.ContactService;
import com.vcg.provider.service.ProviderPaymentService;
import com.vcg.provider.service.ContractService;
import com.vcg.provider.service.ProviderService;
import com.vcg.provider.util.RedisUtil;
import com.vcg.uc.feignClient.PassportClient;
import com.vcg.uc.model.RsetPassword;
import com.vcg.uc.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/updateGeren")
@Api("个人信息修改")
public class UpdateGerenController extends AbstractController{
	
	public static Logger log = Logger.getLogger(UpdateGerenController.class);

	@Autowired
	private ContactService contactService;

	
	@Autowired
	private ProviderPaymentService contractPayService;
	
	@Autowired
	private ContractService contractService;
	
	@Value("${mepx.notifyservice}")
	private String notifyservice;
	
	@Autowired
	private ProviderService providerService;
	
	
	@Autowired
	private PassportClient passportClient;
	
	
	@Autowired
	private CollectionService collectionService;
	
	@Autowired
	private RedisUtil redisUtil;
	
   
	
	/**
	 * 供稿人-点击一行-详细信息-修改基本信息
	 * @param id 供稿人申请id
	 * @return
	 */
	@ApiOperation(value = "个人-点击一行详情-<修改供应商基本信息>", notes = "供稿人基本信息-点击一行详情-<修改供应商基本信息>",tags="geren Update")
	@RequestMapping(value="/updateGerenInfo",method=RequestMethod.POST)
	public RestfulResult updateProviderInfo( @RequestBody UpdateGerenBaseInfo up){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		try {
			if(up.getId()==null){
				result = new RestfulResult(Status.ERROR,null, "无供应商主键");
			}if(up.getContactId()==null){
				result = new RestfulResult(Status.ERROR,null, "无contact主键");
			}else{
				
				Provider provider =  new Provider();
				Contact contact = new Contact();
				
				provider.setId(up.getId());
				provider.setNameCn(up.getNameCn());
				provider.setSignatureName(up.getSignatureName());
				provider.setCountry(up.getCountry());
				provider.setProvince(up.getProvince());
				provider.setCity(up.getCity());
				provider.setLocation(up.getLocation());
				provider.setCompany(up.getProviderCompany());
				provider.setJobType(up.getJobType());
				provider.setQualityRank(up.getQualityRank());
				provider.setAssetFamily(up.getAssetFamily());
 
				contact.setId(up.getContactId());
				contact.setMobile(up.getMobile());
				contact.setSex(up.getSex());
				contact.setEmail(up.getEmail());
				contact.setWeixin(up.getWeixin());
				contact.setQq(up.getQq());
				contact.setIdNum(up.getIdNum());
				contact.setIdCardimgpath(up.getIdCardImgPath());
 
				providerService.updateByPrimaryKeySelective(provider);
				redisUtil.deleteRedisProvider(up.getId());
				contactService.updateByPrimaryKeySelective(contact);
			}
 
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			result = new RestfulResult(Status.ERROR,null, fullStackTrace);
		}

		return result;
		
	}
	
	/**
	 * 供稿人-点击一行-详细信息-修改银行信息
	 * @return
	 */
	@ApiOperation(value = "供稿人基本信息-点击一行详情-<修改银行信息>", notes = "供稿人基本信息-点击一行详情-<修改银行信息>",tags="geren Update")
	@RequestMapping(value="/updateGerenBankInfo",method=RequestMethod.POST)
	public RestfulResult updateProviderBankInfo( @RequestBody ProviderPayment contractPay){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		try {
			if(contractPay.getId()==null){
				result = new RestfulResult(Status.ERROR,null, "无主键");
			}else{
				
				ContractExample example =new ContractExample();
				example.createCriteria().andPaymentIdEqualTo(contractPay.getId());
				List<Contract> list = contractService.selectByExample(example);
				if(list.size()>0){
					result = new RestfulResult(Status.ERROR,null, "此支付方式已存在原有合同里,无法修改");
				}else{
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
	 * 供稿人-点击一行-详细信息-增加银行信息
	 * @return
	 */
	@ApiOperation(value = "供稿人基本信息-点击一行详情-<增加银行信息>", notes = "新增不要id",tags="geren Update")
	@RequestMapping(value="/addGerenBankInfo",method=RequestMethod.POST)
	public RestfulResult addProviderBankInfo( @RequestBody ProviderPayment contractPay){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		try {
			if(contractPay.getId()!=null){
				result = new RestfulResult(Status.ERROR,null, "无效主键");
			}else{
				contractPayService.insertSelective(contractPay);
			}
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			result = new RestfulResult(Status.ERROR,null, fullStackTrace);
		}

		return result;
	}
	
	
	/**
	 * 供稿人-点击一行-详细信息-增加银行信息
	 * @return
	 */
	@ApiOperation(value = "供稿人基本信息-点击一行详情-<删除银行信息>", notes = "新增不要id",tags="geren Update")
	@RequestMapping(value="/deleteGerenBankInfo",method=RequestMethod.POST)
	public RestfulResult deleteGerenBankInfo( @RequestBody Integer id){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		try {
			if(id ==null){
				result = new RestfulResult(Status.ERROR,null, "无效主键");
			}else{
				
				ContractExample example =new ContractExample();
				example.createCriteria().andPaymentIdEqualTo(id);
				List<Contract> list = contractService.selectByExample(example);
				if(list.size()>0){
					result = new RestfulResult(Status.ERROR,null, "此支付方式已存在原有合同里,无法删除");
				}else{
					contractPayService.deleteByPrimaryKey(id);
				}
				
				
			}
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			result = new RestfulResult(Status.ERROR,null, fullStackTrace);
		}

		return result;
	}
	
	
	/**
	 * 供稿人或者机构-点击一行详细信息-修改合同
	 * @return
	 */
	@ApiOperation(value = "供稿人或者机构-点击一行详情-<获取修改合同基本>", notes = "合同id,供应商id",tags="geren Update")
	@RequestMapping(value="/getGerenContractInfo",method=RequestMethod.POST)
	public RestfulResult getGerenContractInfo(@ApiParam(value = "本合同的id,例如41") @RequestParam Integer id,@ApiParam(value = "本供应商的id,例如419375") @RequestParam Integer providerId){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		Map<String,Object> res= new HashMap<String,Object>();
 
		try {
			if(id ==null||providerId==null){
				result = new RestfulResult(Status.ERROR,null, "无合同主键或者供应商主键");
			}else{
				Contract contract = contractService.getById(id);
				if(contract!=null){
					
					int days  = DateUtils.daysBetween(DateUtils.getNowDate(), contract.getEndDate()); 
					contract.setLeftDays(days);
					JigouContractPackage jigouContractPackage = new JigouContractPackage();
					jigouContractPackage.setContract(contract);
					List<Collection> clist =  collectionService.getCollectionByContractIdAndProviderId(contract.getId(), providerId);
					if(clist!=null&&clist.size()>0){
						jigouContractPackage.setCollectionList(clist);
					}
					res.put("contracts", jigouContractPackage);
				}
				result = new RestfulResult(200,res, "成功");
			}
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			result = new RestfulResult(Status.ERROR,null, fullStackTrace);
		}

		return result;
	}
	
	
	
	
	/**
	 * 供稿人-点击一行详细信息-保存合同的collection
	 * @return
	 */
	@ApiOperation(value = "供稿人-详情-点击修改合同-保存合同collection", notes = "同时也可以做关闭collection用",tags="geren Update")
	@RequestMapping(value="/updateGerenContractCollection",method=RequestMethod.POST)
	public RestfulResult updateGerenContractCollection( @RequestBody Collection collection){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		Map<String,Object> res= new HashMap<String,Object>();
 
		try {
			if(collection.getId()==null){
				result = new RestfulResult(Status.ERROR,null, "无主键");
			}else{
					collectionService.updateByPrimaryKeySelective(collection);
					redisUtil.deleteRedisCollection(collection.getId());
				}
				 
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			result = new RestfulResult(Status.ERROR,null, fullStackTrace);
		}

		return result;
	}
	 
	
	/**
	 * 供稿人-点击一行详细信息-新增合同的collection
	 * @return
	 */
	@ApiOperation(value = "供稿人-详情-点击修改合同- 新增合同collection", notes = "",tags="geren Update")
	@RequestMapping(value="/addGerenContractCollection",method=RequestMethod.POST)
	public RestfulResult addGerenContractCollection(@ApiParam(value = "本合同的id,例如41") @RequestBody Collection collection){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		Map<String,Object> res= new HashMap<String,Object>();
 
		try {
			 
			if(collection.getContractId()==null){
				result = new RestfulResult(Status.ERROR,null, "无合同主键");
			}if(collection.getProviderId()==null){
				result = new RestfulResult(Status.ERROR,null, "无供应商主键");
			}else{
					collectionService.insertSelective(collection);
				}
				 
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			result = new RestfulResult(Status.ERROR,null, fullStackTrace);
		}

		return result;
	}
	
	
	/**
	 * 供稿人-点击一行详细信息-删除合同的collection
	 * @return
	 */
	@ApiOperation(value = "供稿人-详情-点击修改合同- 删除合同的collection", notes = "",tags="geren Update")
	@RequestMapping(value="/deleteGerenContractCollection",method=RequestMethod.POST)
	public RestfulResult deleteGerenContractCollection(@ApiParam(value = "本colloction id,例如41") @RequestBody Integer id){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		Map<String,Object> res= new HashMap<String,Object>();
 
		try {
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
	
	
	
 
	@ApiOperation(value = "供稿人基本信息-点击一行详情-<账户信息>", notes = "从用户中心获取")
	@RequestMapping(value="/getUserCenterAccount",method=RequestMethod.POST)
	public Object getUserCenterAccount(@ApiParam(value = "本供应商providerId,如510015") @RequestParam Integer id){
		
		 Provider  provider = providerService.getById(id);
		 if(provider!=null){
			 if(StringUtils.isNoneBlank(provider.getUserCenterId())){
					User  user  = passportClient.getByUserId(provider.getUserCenterId());
//					{
//						  "mobile": "13811855184",
//						  "regTime": 1470885447000,
//						  "status": 1,
//						  "userFrom": 2,
//						  "userId": "218b60cb04ba3a03942c7f4c316177180"
//						}
					Map<String,Object> res= new HashMap<String,Object>();
					if(user!=null){
						if(StringUtils.isNotBlank(user.getUserName())){
							res.put("accountName", user.getUserName());
						}else if(StringUtils.isNotBlank(user.getEmail())){
							res.put("accountName", user.getEmail());
						}else if(StringUtils.isNotBlank(user.getMobile())){
							res.put("accountName", user.getMobile());
						}
						res.put("userCenterId", user.getUserId());
						res.put("userStatus", user.getStatus());
					}
					return new RestfulResult(200,res, "查询成功");
			 }else{
				 return new RestfulResult(Status.ERROR,null, "供应商用户中心id为空");
			 }
			 
		 }else{
			 return new RestfulResult(Status.ERROR,null, "供应商不存在");
		 }
		 

		   
	}
	
	@ApiOperation(value = "供稿人基本信息-点击一行详情-<账户信息-重置密码>", notes = "重置为123456")
	@RequestMapping(value="/resetUserCenterAccountPassword",method=RequestMethod.POST)
	public Object resetUserCenterAccountPassword(@ApiParam(value = "本供应商用户中心id") @RequestParam String uerCenterId){

		User  user  = passportClient.getByUserId(uerCenterId);
		RsetPassword rpd = new RsetPassword();
		if(user!=null){
			rpd.setId(user.getUserId());
			rpd.setNewPassword("123456");
			passportClient.modifyPwd(rpd);
			return new RestfulResult(200,null, "密码重置为123456");
		}else{
			return new RestfulResult(Status.ERROR,null, "用户不存在！");
		}   
	}
	
	@ApiOperation(value = "供稿人基本信息-点击一行详情-<账户信息-置为无效>", notes = "")
	@RequestMapping(value="/setUserInvalid",method=RequestMethod.POST)
	public Object setUserInvalid(@ApiParam(value = "本供应商用户中心id") @RequestParam String uerCenterId){
		User  user  = passportClient.getByUserId(uerCenterId);
		if(user!=null){
			User  upddate = new User();
			upddate.setUserId(user.getUserId());
			upddate.setStatus(0);
			passportClient.updateUser(upddate);
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
			passportClient.updateUser(upddate);
			return new RestfulResult(200,null, "修改成功");
		}else{
			return new RestfulResult(Status.ERROR,null, "用户不存在！");
		}   
	}
	
	 
  
 
  
	
 
	
}
