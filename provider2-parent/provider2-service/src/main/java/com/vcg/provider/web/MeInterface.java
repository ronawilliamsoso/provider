package com.vcg.provider.web;
 
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.vcg.oss.util.ProviderOSSClientUtil;
import com.vcg.common.AbstractController;
import com.vcg.common.DateUtils;
import com.vcg.common.RestfulResult;
import com.vcg.common.RestfulResultFactory;
import com.vcg.common.ResultMap;
import com.vcg.provider.model.Contact;
import com.vcg.provider.model.ContactApplication;
import com.vcg.provider.model.Contract;
import com.vcg.provider.model.ContractApplication;
import com.vcg.provider.model.GerenRegister;
import com.vcg.provider.model.Provider;
import com.vcg.provider.model.ProviderApplication;
import com.vcg.provider.model.ProviderBank;
import com.vcg.provider.model.ProviderPayment;
import com.vcg.provider.model.ProviderRegister;
import com.vcg.provider.model.ResourceSell;
import com.vcg.provider.model.ResourceSellFromBoss;
import com.vcg.provider.model.ResourceSellMonth;
import com.vcg.provider.model.UpdateOldInfo;
import com.vcg.provider.model.UploadContract;
import com.vcg.provider.model.query.ContactApplicationExample;
import com.vcg.provider.model.query.ContactExample;
import com.vcg.provider.model.query.ContractApplicationExample;
import com.vcg.provider.model.query.ContractExample;
import com.vcg.provider.model.query.ProviderApplicationExample;
import com.vcg.provider.model.query.ProviderExample;
import com.vcg.provider.model.query.ProviderPaymentExample;
import com.vcg.provider.model.query.ResourceSellExample;
import com.vcg.provider.model.query.ResourceSellFromBossExample;
import com.vcg.provider.model.query.ResourceSellMonthExample;
import com.vcg.provider.model.query.ResourceSellMonthExample.Criteria;
import com.vcg.provider.service.ContactApplicationService;
import com.vcg.provider.service.ContactService;
import com.vcg.provider.service.ContractApplicationService;
import com.vcg.provider.service.ContractService;
import com.vcg.provider.service.MeService;
import com.vcg.provider.service.ProviderApplicationService;
import com.vcg.provider.service.ProviderPaymentService;
import com.vcg.provider.service.ProviderService;
import com.vcg.provider.service.ResourceSellMonthService;
import com.vcg.provider.service.ResourceSellService;
import com.vcg.provider.util.RedisUtil;
import com.vcg.provider.util.UUIDUtil;

import com.vcg.common.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
 
@Api(value = "对应社区接口", description="对应社区接口")
@RestController
@RequestMapping("/providerme")
@Component
public class MeInterface extends AbstractController {
	
	@Autowired
	private ProviderApplicationService providerApplicationService;
	
	@Autowired
	private ContactApplicationService contactApplicationService;
	
	@Autowired
	private ContractApplicationService contractApplicationService;
	
	@Autowired
	private ProviderPaymentService providerPaymentService;
	
	@Autowired
	private ProviderService providerService;
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private ContractService contractService;
	
	@Autowired
	private RedisUtil providerUtil;
 
	@Autowired
	private ResourceSellService resourceSellService;
	
	@Autowired
	private ResourceSellMonthService resourceSellMonthService;
	
	@Value("${oss.isInternal}")
	private Integer isInternal;
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private ProviderOSSClientUtil providerOSSClientUtil;
	
	@Autowired
	private MeService meService;
	
	
	
	
	
	
	@ApiOperation(value = "500px-<申请供稿人资格>", notes = "申请供稿人资格")
	@RequestMapping(value="/providerRegister",method=RequestMethod.POST)
	public Object providerRegister(@RequestBody GerenRegister gerenRegister){		
		//MeRestfulResult msg = new MeRestfulResult(0, "", null);
		/*
		 * 摄影师注册要求：
		 * 每个摄影师最多只能注册两次；
		 * 每次注册申请审核通过（包括合同审核）后才能进行下一次注册申请；
		 * 审核不通过可以继续进行下一次申请。
		 */
		
//		{
//			  "userCenterId": "218b60cb04ba3a03942c7f4c316177180",
//			  "jobType": 2,
//			  "providerCompany": "视觉中国研发部",
//			  "sex": 2,
//			  "email": "ronawilliam@163.com",
//			  "nameCn": "王威真实姓名YY",
//			  "productions": "https://photo-test-community.shijue.me/s/5bb60fd58c79373af72351cfb9d479257726a71c424fafb39ed63d175204b819ddfeab54aa69f903f55bc5d48b6b06ed4435cfee743fcfc6",
//			  "access_token": "4bd23ce00996487691a4c62fd982a658",
//			  "mobile": "13811855184"
//			}

		
		ProviderApplicationExample exam = new ProviderApplicationExample();
		exam.createCriteria().andUserCenterIdEqualTo(gerenRegister.getUserCenterId());
		//查找所有的申请
		List<ProviderApplication> providerApplications = providerApplicationService.selectByExample(exam);
		if(CollectionUtils.isNotEmpty(providerApplications)){
			int appCount = 0;
			for(ProviderApplication providerApplication:providerApplications){
				if(providerApplication.getStatus() == Status.PROVIDER_STATUS_NOAUDITING 
						|| providerApplication.getStatus() == Status.PROVIDER_STATUS_NOCONTRACT){
 
					return RestfulResultFactory.getInstance(400, null,  "尚有申请审核中，无法提交新申请");
				}else if(providerApplication.getStatus() == Status.PROVIDER_STATUS_PASS 
						&& providerApplication.getAssetFamily() == Status.ASSET_FAMILY_MIXED){
					return RestfulResultFactory.getInstance(400, null,  "重复注册");
				}
				if(providerApplication.getStatus() == Status.PROVIDER_STATUS_PASS){
					appCount++;
				}
			}
			if(appCount > 2){
				return RestfulResultFactory.getInstance(400, null,  "重复注册");
			}
		}
		 
		//providerRegister 会传过来id,这个id 是用户中心的id,所以根据它来获取用户的注册信息
//		/User user =   usercenterClient.getByUserId(providerRegister.getUserCenterId());
		
		ProviderApplication providerApplication = new ProviderApplication();
		BeanUtils.copyProperties(gerenRegister, providerApplication);
 
		
		
//		{
//		  "userCenterId": "218b60cb04ba3a03942c7f4c316177180",
//		  "jobType": 2,
//		  "providerCompany": "视觉中国研发部",
//		  "sex": 2,
//		  "email": "ronawilliam@163.com",
//		  "nameCn": "王威真实姓名V",
//		  "productions": "https://photo-test-community.shijue.me/s/5bb60fd58c79373af72351cfb9d479257726a71c424fafb39ed63d175204b819ddfeab54aa69f903f55bc5d48b6b06ed4435cfee743fcfc6",
//		  "access_token": "b9d2b3f360104dd2aaa48b3b50963b36",
//		  "mobile": "13811855184"
//		}
		
		
		
		providerApplication.setStatus(Status.PROVIDER_STATUS_NOAUDITING);//未审核
		providerApplication.setType(Status.PROVIDER_TYPE_PERSONAL);//个人
		providerApplication.setCreatedTime(DateUtils.getNowDate());
		providerApplication.setIsDelete(Status.IS_DELETE_NO);//有效
		providerApplication.setId(null);// 因为是新增,所以需要数据库分配,但是这个字段存了用户的id,防止冲突
		
	 
	    
		JSONObject data = new JSONObject();
		try {
			providerApplicationService.insertSelective(providerApplication);
			
			ContactApplicationExample example = new ContactApplicationExample();
			example.createCriteria().andUserCenterIdEqualTo(gerenRegister.getUserCenterId());
			List<ContactApplication> contactApplicationList = contactApplicationService.selectByExample(example);
			ContactApplication contactApplication = new ContactApplication();
			BeanUtils.copyProperties(gerenRegister, contactApplication);
			contactApplication.setName(gerenRegister.getNameCn());
			contactApplication.setMobile(gerenRegister.getMobile());
			contactApplication.setSex(gerenRegister.getSex());
		 
			if(contactApplicationList.size()>0){//原来已有
				contactApplication.setId(contactApplicationList.get(0).getId());
				contactApplicationService.updateByPrimaryKeySelective(contactApplication);
			}else{
				contactApplication.setCreatedTime(DateUtils.getNowDate());
				contactApplication.setUserCenterId(providerApplication.getUserCenterId());
				contactApplication.setIsDefault(1);//默认联系人
				contactApplicationService.insertSelective(contactApplication);
			}
 
			 
			data.put("userCenterId", providerApplication.getUserCenterId());
			
			redisUtil.putContractApplication(providerApplication.getUserCenterId(),RestfulResultFactory.getInstance(200, data,  "ok"));
 
			return RestfulResultFactory.getInstance(200, data,  "ok");
		} catch (Exception e) {
			// TODO: handle exception
		    e.printStackTrace();
		    String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
		    redisUtil.putContractApplication(providerApplication.getUserCenterId(),RestfulResultFactory.getInstance(400, null,  fullStackTrace));
			return RestfulResultFactory.getInstance(400, null,  fullStackTrace);
		}
		 		 
	}
	
	/*获取access_token*/
	@ApiOperation(value = "获取access_token", notes = "access_token")
	@RequestMapping(value="/oauth2/token",method=RequestMethod.GET)
	public Object getAccessToken(@RequestParam String client_id,
			@RequestParam String client_secret){
		JSONObject data = new JSONObject();
		data.put("access_token", UUID.randomUUID().toString().replace("-", ""));
		data.put("expires_in", 86400);
		return RestfulResultFactory.getInstance(200, data,  "ok");
	}
	
 
	@ApiOperation(value = "获取这个人合同状态信息", notes = "获取缓存中这个人合同状态信息")
	@RequestMapping(value="/getApplicationFromRedis",method=RequestMethod.GET)
	public Object getApplicationFromRedis(@RequestParam String userId){
		String temp =  redisUtil.getContractApplication(userId); 
		return RestfulResultFactory.getInstance(200, temp,  "ok");
	}
	
	@ApiOperation(value = "删除这个人合同状态信息", notes = "删除这个人合同状态信息")
	@RequestMapping(value="/deleteApplicationFromRedis",method=RequestMethod.GET)
	public Object deleteApplicationFromRedis(@RequestParam String userId){
		  redisUtil.deleteContractApplication(userId);
		return RestfulResultFactory.getInstance(200, null,  "ok");
	}
	
	/*上传合同接口*/
	@ApiOperation(value = "500px-<上传合同>", notes = "摄影师上传合同")
	@RequestMapping(value="/uploadContract",method=RequestMethod.POST)
	public Object uploadContract(@RequestBody UploadContract uploadContract){
		
		
//		{
//			  "idCardImgPath": "http://vcg-test.img-cn-beijing.aliyuncs.com/gicIdCard/faf44e8b847ed9011a7e2f1e646d79839/d089ea04551c4be7ae5d84067c1380ca.jpg?Expires=1479457390&OSSAccessKeyId=WvnNiKTI81tvHCTz&Signature=xkQlowH%2BMR3MNaAQGCqTYKrASwU%3D",
//			  "exclusiveAuth": 0,
//			  "idNum": "110102322233333",
//			  "payeeNumber": "pamela",
//			  "location": "涓 A38",
//			  "bankName": "含惰",
//			  "postcode": "100000",
//			  "city": "",
//			  "country": "涓",
//			  "payeeName": "含惰娴锋",
//			  "userCenterId": "faf44e8b847ed9011a7e2f1e646d79839",
//			  "weixin": "wx1234567",
//			  "email": "hua.gu@vcg.me",
//			  "name": "liwentao",
//			  "creditLine": "guhua",
//			  "province": "含",
//			  "qq": "QQ123456",
//			  "access_token": "e578f3a6a90b434a992465344cd4d108",
//			  "mobile": "13366297685",
//		      branchBankname:"",
//		      openAccountaddress:""
//			}

		RestfulResult msg = new RestfulResult(200,null,"ok");
 
		 
		if(uploadContract.getUserCenterId() == null){
			msg.setStatus(400);
			msg.setMessage("请提供摄影师的用户中心ID");
			return msg;
		}
		ProviderApplication providerApplication = new ProviderApplication();
		ContractApplication contractApplication = new ContractApplication();
		ContactApplication contactApplication = new ContactApplication();
		
		/*摄影师校验，只有待签合同状态的摄影师才能上传合同*/
		ProviderApplicationExample exam = new ProviderApplicationExample();
		exam.createCriteria().andUserCenterIdEqualTo(uploadContract.getUserCenterId())
			.andStatusIsNotNull().andStatusEqualTo(Status.PROVIDER_STATUS_NOCONTRACT);
		List<ProviderApplication> providers = providerApplicationService.selectByExample(exam);
		if(CollectionUtils.isEmpty(providers)){
			msg.setStatus(400);
			msg.setMessage("摄影师未注册或未审核通过");
			return msg;
		}else{
			providerApplication = providers.get(0);
		}
		/*获取合同文本*/
		
		
//		{
//			  "idCardImgPath": "",
//			  "exclusiveAuth": 0,
//			  "idNum": "421125198401267346",
//			  "payeeNumber": "123456789801234",
//			  "location": "北京市朝阳区",
//			  "bankName": "北京朝阳区银行",
//			  "city": "0",
//			  "country": "0",
//			  "payeeName": "王威",
//			  "userCenterId": "218b60cb04ba3a03942c7f4c316177180",
//			  "weixin": "mudi977612",
//			  "email": "ronawilliam@163.com",
//			  "name": "王威真实姓名V",
//			  "creditLine": "王威的签名-牧笛",
//			  "province": "0",
//			  "qq": "303781830",
//			  "access_token": "66fb8d8a73d74f8083c1209c00676623",
//			  "mobile": "13811855184"
//			}
		
		
		
		if(uploadContract.getContractId() != null){
			contractApplication = this.contractApplicationService.selectByPrimaryKey(uploadContract.getContractId());
		}else{
			ContractApplicationExample exam_ct = new ContractApplicationExample();
			List<Integer> status = new ArrayList<>();
			status.add(Status.AUDITING_STATUS_NOUPLOAD);/*未上传*/
			status.add(Status.AUDITING_STATUS_REJECT);/*驳回*/
			exam_ct.createCriteria().andUserCenterIdEqualTo(uploadContract.getUserCenterId())
				.andAuditingStatusIn(status);
			List<ContractApplication> contract_list = contractApplicationService.selectByExample(exam_ct);
			if(CollectionUtils.isEmpty(contract_list)){
				msg.setStatus(400);
				msg.setMessage("找不到合同信息");
				return msg;
			}else{
				contractApplication = contract_list.get(0);
			}
		}
		
		/*获取联系人信息*/
		ContactApplicationExample example = new ContactApplicationExample();
		example.createCriteria().andUserCenterIdEqualTo(uploadContract.getUserCenterId());
		List<ContactApplication> contacts= contactApplicationService.selectByExample(example);
		if(CollectionUtils.isNotEmpty(contacts)){
			contactApplication = contacts.get(0);
		} 
		
		//维护contractApplication
		BeanUtils.copyProperties(uploadContract, contractApplication, "contractId");
//		contractApplication.setContractType(uploadContract.getType());
		
		//维护contactApplication 包含国家省市地址 身份证图片
		BeanUtils.copyProperties(uploadContract, contactApplication);
		contactApplication.setEmergencyIdnum(uploadContract.getEmergencyIDNum());
		contactApplication.setAddress(uploadContract.getLocation());
		contactApplication.setIdType(uploadContract.getIdType());
 
		msg = meService.addMeContract(uploadContract, contactApplication, contractApplication, providerApplication);
		//把数据放在缓存
		redisUtil.putContractApplication(providerApplication.getUserCenterId(),msg);
		 
		return msg;
	}
	
	@ApiOperation(value = "500px-<申请供稿人合同列表>", notes = "500px-<申请供稿人合同列表>")
	@RequestMapping(value="/getProviderContractPDFs",method=RequestMethod.GET)
	public Object getProviderContractPDFs(@ApiParam(value = "必填,例如: 218b60cb04ba3a03942c7f4c316177180")@RequestParam String userCenterId ){
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String,Object>> retlist = new ArrayList<Map<String,Object>>();
		
		
		
		Map<String,Object> searchParam = new HashMap<String,Object>();
		searchParam.put("userCenterId", userCenterId);
		
		ProviderExample exam = new ProviderExample();
		exam.createCriteria().andUserCenterIdEqualTo(userCenterId);
		List<Provider>  list = providerService.selectByExample(exam);
		if(list.size()>0){
			Integer providerId= list.get(0).getId();
			ContractExample example = new ContractExample();
			example.setColunms(Arrays.asList("contract_code","deadline","exclusive_auth","sign_date","contract_pdf_path","edit_rate","creative_rate"));
			example.createCriteria().andProviderIdEqualTo(providerId);
			List<Contract>  contractlist = contractService.selectByExample(example);
	        for(Contract contract:contractlist){
	        	map = new HashMap<String,Object>();
	        	
	        	map.put("contractCode", contract.getContractCode() );  
	        	map.put("deadline", contract.getDeadline());
	        	map.put("editRate", contract.getEditRate() );
	        	map.put("creativeRate", contract.getCreativeRate() );
//	        	if(StringUtils.isNoneBlank(contract.getContractCode()) ){
//	        		ContractApplicationExample cexample=new ContractApplicationExample();
//	        		 
//		    		List<ContractApplication> lst = this.contractApplicationService.selectByExample(cexample);
//		    		if(lst.size()>0){
//		    			map.put("editRate", lst.get(0).getEditRate() );
//		    			map.put("creativeRate", lst.get(0).getCreativeRate() );
//		    		}
//	        	}
	        	map.put("exclusiveAuth", contract.getExclusiveAuth());
	        	map.put("signdate", contract.getSignDate());
 
	        	if(StringUtils.isNoneBlank(contract.getContractPdfPath()) ){
	        		String fullFilePath = providerOSSClientUtil.getProviderObject(isInternal, contract.getContractPdfPath());
	        		map.put("contractPdfPath", fullFilePath);
	        	}
	        	
	        	retlist.add(map);
 	
	        }
 
		}
		return RestfulResultFactory.getInstance(200, retlist,  "成功");
		
//		
//		
//		
//        List<ResultMap> list = this.queryService.queryListForCustom("providerManage", "searchContractHistory", searchParam);
//        for(ResultMap map:list){
//        	if(map.getValue("contractPdfPath")!=null){
//        		String fullFilePath = OssClientUtil.getProviderObject(isInternal, map.getValue("contractPdfPath").toString());
//        		map.putNoReplace("contractPdfPath", fullFilePath);
//        	}
//        }
		 	 
	}
	
	
	
	@ApiOperation(value = "500px-<申请供稿人原有信息>", notes = "500px-<申请供稿人原有信息>")
	@RequestMapping(value="/getProviderOldInfo",method=RequestMethod.GET)
	public Object getProviderOldInfo(@ApiParam(value = "必填,例如: 218b60cb04ba3a03942c7f4c316177180")@RequestParam String userCenterId ){
		
 
		JSONObject oldUserInfo = new JSONObject();// 如果是老用户,那么把原先的信息返回
		ProviderExample exam = new ProviderExample();
		exam.createCriteria().andUserCenterIdEqualTo(userCenterId);
		List<Provider>  list = providerService.selectByExample(exam);
		if(list.size()>0){//老用户
			Provider provider = list.get(0);
			Integer providerId= list.get(0).getId();

			ContactExample contactExample = new ContactExample();
			contactExample.createCriteria().andProviderIdEqualTo(providerId);
			List<Contact>  contactlist = contactService.selectByExample(contactExample);
			ProviderPaymentExample  providerPaymentExample = new ProviderPaymentExample();
			providerPaymentExample.createCriteria().andProviderIdEqualTo(providerId);
			List<ProviderPayment> paymentlist =  providerPaymentService.selectByExample(providerPaymentExample);
			if(contactlist.size()>0){
				Contact contact = contactlist.get(0);
				oldUserInfo.put("realName", contact.getName());
				oldUserInfo.put("idNum", contact.getIdNum());
				oldUserInfo.put("mobile", contact.getMobile());
				oldUserInfo.put("email", contact.getEmail());
				oldUserInfo.put("contactId", contact.getId());
				oldUserInfo.put("idType", contact.getIdType());
			}
			oldUserInfo.put("creditLine", provider.getSignatureName());
			oldUserInfo.put("company", provider.getCompany());
			oldUserInfo.put("liveCity", provider.getLiveCity());
			oldUserInfo.put("country", provider.getCountry());
			oldUserInfo.put("province", provider.getProvince());
			oldUserInfo.put("city", provider.getCity());
			oldUserInfo.put("address", provider.getLocation());
			oldUserInfo.put("providerId", providerId);
			if(paymentlist.size()>0){
				oldUserInfo.put("banklist", paymentlist);
			}
		}
		return RestfulResultFactory.getInstance(200, oldUserInfo,  "成功");
 
		 	 
	}
	
	
	
	
	@ApiOperation(value = "500px-<申请供稿人原有信息-更新>", notes = "更新按钮")
	@RequestMapping(value="/updateProviderOldInfo",method=RequestMethod.POST)
	public Object updateProviderOldInfo(@ApiParam(value = "必填")  @RequestBody UpdateOldInfo updateOldInfo ){
		
		if(updateOldInfo.getId()==null){
			return new RestfulResult(Status.ERROR, null,  "供应商id为空");	 
		}

		
		List<ProviderBank> banks = updateOldInfo.getBanklist();
		if(banks!=null && banks.size()>0){
			for(ProviderBank providerBank:banks){
				if(providerBank.getId()==null){
					return new RestfulResult(Status.ERROR, null,  "银行卡或者支付宝id为空");	 
				}
			}
		}
 
		Provider provider =new Provider();
		Contact contact =new Contact();
		
		provider.setId(updateOldInfo.getId());
		provider.setSignatureName(updateOldInfo.getCreditLine());
		provider.setCompany(updateOldInfo.getCompany());
		provider.setLiveCity(updateOldInfo.getLiveCity());
		provider.setProvince(updateOldInfo.getProvince());
		provider.setCountry(updateOldInfo.getCountry());
		provider.setCity(updateOldInfo.getCity());
		provider.setLocation(updateOldInfo.getAddress());
		providerService.updateByPrimaryKeySelective(provider);
		redisUtil.deleteRedisProvider(updateOldInfo.getId());
		
		if(updateOldInfo.getContactId()==null){//新增
			contact.setMobile(updateOldInfo.getMobile());
			contact.setEmail(updateOldInfo.getEmail());
			contact.setIdType(updateOldInfo.getIdType());
			contact.setAddress(updateOldInfo.getAddress());
			contact.setName(updateOldInfo.getName());
			contact.setIdNum(updateOldInfo.getIdNum());
			contactService.insert(contact);
			 
		}else{//修改
			contact.setId(updateOldInfo.getContactId());
			contact.setMobile(updateOldInfo.getMobile());
			contact.setEmail(updateOldInfo.getEmail());
			contact.setIdType(updateOldInfo.getIdType());
			contact.setAddress(updateOldInfo.getAddress());
			contact.setName(updateOldInfo.getName());
			contact.setIdNum(updateOldInfo.getIdNum());
			contactService.updateByPrimaryKeySelective(contact);
			
		}
		
		
		
		for(ProviderBank providerBank:banks){
			ProviderPayment providerPayment = new ProviderPayment();
			providerPayment.setId(providerBank.getId());
			providerPayment.setPayeeName(providerBank.getPayeeName());
			providerPayment.setPayeeNumber(providerBank.getPayeeNumber());
			providerPayment.setBankName(providerBank.getBankName());
			providerPayment.setIsBank(providerBank.getIsBank());
			providerPayment.setBranchBankname(providerBank.getBranchBankname());
			providerPayment.setOpenAccountaddress(providerBank.getOpenAccountaddress());
			providerPaymentService.updateByPrimaryKeySelective(providerPayment);
		}
 
		 return new RestfulResult(200, null,  "更新成功");	 
	}
	
	
	
	@ApiOperation(value = "查询供稿人审核状态", notes = "查询供稿人审核状态")
	@RequestMapping(value="/findProviderAuditStatus",method=RequestMethod.GET)
	public Object findProviderAuditStatus(@RequestParam(required=true) String userCenterId){
		RestfulResult msg = new RestfulResult(0, "ok", null);
		ProviderApplicationExample exam = new ProviderApplicationExample();
		exam.createCriteria().andUserCenterIdEqualTo(userCenterId);
			
		List<ProviderApplication> providers = providerApplicationService.selectByExample(exam);
		
		if(CollectionUtils.isEmpty(providers)){
			msg.setMessage("摄影师未注册");
			msg.setStatus(400);
		}else{
			JSONObject data = new JSONObject();
			boolean needAuditing = false;
			int type = 0;
			ProviderApplication need = null;
			for(ProviderApplication provider: providers){
				//未审核记录
				if(provider.getAssetFamily() == null){
					needAuditing = true;
					need = provider;
					continue;
				}
				Integer contractStatus_edit = null;
				Integer contractStatus_creative = null;
				ContractApplicationExample example = new ContractApplicationExample();
				//标准有效的合同
				example.createCriteria().andContractTypeEqualTo(Status.CONTRACT_TYPE_BIAOZHUN)//标准合同
					.andContractStatusEqualTo(Status.CONTRACT_STATUS_VALID)//有效合同
					.andProviderIdEqualTo(provider.getId());
				List<ContractApplication> contracts = contractApplicationService.selectByExample(example);
				if(CollectionUtils.isNotEmpty(contracts)){
					for(ContractApplication ct: contracts){
						if(ct.getAssetFamily() == Status.ASSET_FAMILY_EDIT){
							contractStatus_edit = ct.getAuditingStatus();
						}else if(ct.getAssetFamily() == Status.ASSET_FAMILY_CREATIVE){
							contractStatus_creative = ct.getAuditingStatus();
						}else{
							contractStatus_edit = ct.getAuditingStatus();
							contractStatus_creative = ct.getAuditingStatus();
						}
					}
					
				}
				
				if(provider.getAssetFamily() == Status.ASSET_FAMILY_CREATIVE){
					type = 2;
					JSONObject creative = new JSONObject();
					creative.put("id", provider.getId());
					creative.put("status", provider.getStatus());
					creative.put("contractStatus", contractStatus_creative);
					data.put("creative", creative);
				}else if(provider.getAssetFamily() == Status.ASSET_FAMILY_EDIT){
					type = 1;
					JSONObject editorial = new JSONObject();
					editorial.put("id", provider.getId());
					editorial.put("status", provider.getStatus());
					editorial.put("contractStatus", contractStatus_edit);
					data.put("editorial", editorial);
				}else if(provider.getAssetFamily() == Status.ASSET_FAMILY_MIXED){
					JSONObject creative = new JSONObject();
					creative.put("id", provider.getId());
					creative.put("status", provider.getStatus());
					creative.put("contractStatus", contractStatus_creative);
					data.put("creative", creative);
					JSONObject editorial = new JSONObject();
					editorial.put("id", provider.getId());
					editorial.put("status", provider.getStatus());
					editorial.put("contractStatus", contractStatus_edit);
					data.put("editorial", editorial);
				}
			}
			if(needAuditing && type == 1){
				/*编辑类资格审核通过（合同审核可能未通过），创意类资格正在审核中*/
				JSONObject creative = new JSONObject();
				creative.put("id", need.getId());
				creative.put("status", need.getStatus());
				creative.put("contractStatus", null);
				data.put("creative", creative);
			}else if(needAuditing && type == 2){
				/*创意类资格审核通过（合同审核可能未通过），编辑类资格正在审核中*/
				JSONObject editorial = new JSONObject();
				editorial.put("id", need.getId());
				editorial.put("status", need.getStatus());
				editorial.put("contractStatus", null);
				data.put("editorial", editorial);
			}else if(needAuditing && type == 0){
				/*摄影师首次申请，编辑类/创意类资格正在审核中*/
				JSONObject creative = new JSONObject();
				creative.put("id", need.getId());
				creative.put("status", need.getStatus());
				creative.put("contractStatus", null);
				data.put("creative", creative);
				JSONObject editorial = new JSONObject();
				editorial.put("id", need.getId());
				editorial.put("status", need.getStatus());
				editorial.put("contractStatus", null);
				data.put("editorial", editorial);
			}
			msg.setData(data);
			msg.setStatus(200);
		}
		return msg;
	}
	
	@ApiOperation(value = "更新供稿人信息", notes = "更新供稿人信息")
	@RequestMapping(value="/providerUpdate",method=RequestMethod.POST)
	public Object providerUpdate(@RequestBody ProviderRegister providerRegister){
		RestfulResult msg = new RestfulResult(0, "ok", null);
		ProviderExample example_p = new ProviderExample();
		example_p.createCriteria().andUserCenterIdEqualTo(providerRegister.getUserCenterId());
		List<Provider> list_p = providerService.selectByExample(example_p);
		if(CollectionUtils.isEmpty(list_p)){
			msg.setMessage("更新失败");
			msg.setStatus(400);
		}else{
			Provider provider = list_p.get(0);
			BeanUtils.copyProperties(providerRegister, provider);
			try {
				providerUtil.providerMerge(provider);
				ContactExample example = new ContactExample();
				example.createCriteria().andProviderIdEqualTo(provider.getId());
				List<Contact> list = contactService.selectByExample(example);
				if(CollectionUtils.isNotEmpty(list)){
					for(Contact contact:list){
						BeanUtils.copyProperties(providerRegister, contact,"id");
						contactService.updateByPrimaryKeySelective(contact);
						msg.setMessage("更新成功");
						msg.setStatus(200);
					}
				}
				
			} catch (Exception e) {
				msg.setMessage("更新失败");
				msg.setStatus(400);
			}
		}
		
		return msg;
	}
 
	
	//获取这个摄影师的本月的发布状态
	public Integer getProviderPublished(Integer provider,Integer assetFamily,String month){
	 
		ResourceSellMonthExample example=new ResourceSellMonthExample();
		example.createCriteria().andProviderIdEqualTo(provider).andSellMonthEqualTo(month).andAssetFamilyEqualTo(assetFamily);
		List<ResourceSellMonth> lst = resourceSellMonthService.selectByExample(example);
		if(lst.size()>0){
			if(lst.get(0).getIsPublished()==1){
				return 1;
			}
		}
		return 0;
	}
	
	
	@ApiOperation(value = "创意类和编辑销售查询", notes = "1:创意类销售明细查询 2:编辑类销售明细查询3:编辑类稿费查询")
	@RequestMapping(value="/getRoyaltiesByMonth",method=RequestMethod.GET)
	public Object getRoyaltiesByMonth(@RequestParam(required=true) Integer providerId,
			@ApiParam(value = "1:创意类销售明细查询 2:编辑类销售明细查询3:编辑类月统计稿费查询")@RequestParam(required=true) Integer searchType,
			@ApiParam(value = "如:2016-11")@RequestParam(required=true) String beginMonth,
			@ApiParam(value = "如:2016-11")@RequestParam(required=true) String endMonth,
			@RequestParam(defaultValue="1") Integer pageNum,
			@RequestParam(defaultValue="10") Integer pageSize) throws Exception{
		
		
		
//		Integer includecurrent=0;
//		String current_date_start_str ="";//本月开始时间字符串
//		 String current_date_end_str = "";//本月结束时间字符串
//		 Date current_date_start_date=null;
//		 Date current_date_end_date = null;
//		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		 SimpleDateFormat formatterdd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		 Date beginMonth_d = formatter.parse(beginMonth+"-01") ;
//		 Date endMonth_t = formatter.parse(endMonth+"-01") ;
		 //如果当前日期在这个范围之内,那么需要查询boss同步表,因为只有这个表里才有本月的数据
//		 if(beginMonth_d.before(DateUtils.getNowDate()) && endMonth_t.after(DateUtils.getNowDate())  ){ 
//			 includecurrent=1; 
//			 
//			  current_date_start_str = DateUtils.getMonthBegin(DateUtils.getNowDate());
//			  current_date_end_str = DateUtils.getMonthEnd(DateUtils.getNowDate());
//			  
//			   current_date_start_date  =  formatterdd.parse(current_date_start_str);
//			   current_date_end_date  =  formatterdd.parse(current_date_end_str);
//		 }
		
		
		
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String,Object>> retdata = new ArrayList<Map<String,Object>>();
		ResourceSellExample example=new ResourceSellExample();
		List<ResourceSell> lst = null;
		if(StringUtils.isEmpty(beginMonth)||StringUtils.isEmpty(endMonth)){
			result.put("status", 201);
			result.put("message", "beginMonth 或者 endMonth 为空");
			return result;
		}
		List<String> months = DateUtils.getMonthListBetween(beginMonth,endMonth);
		if(months.size()<=0){
			result.put("status", 201);
			result.put("message", "起止日期之间的月份数不大于0");
			return result;
		}
		Integer assetFamily=0;
 
		if(searchType==1){
			assetFamily = 2;
		}else if(searchType==2){
			assetFamily = 1;
		}else if(searchType==3){
			assetFamily = 1;
		}
 
		//默认数据状态为 未发布 ,摄影师这时候不能看稿费信息
		//发布后才能看所有字段
		
		if(searchType==1){//创意稿费明细
			example=new ResourceSellExample();
			com.vcg.provider.model.query.ResourceSellExample.Criteria criteria =  example.createCriteria();
			criteria.andAssetFamilyEqualTo(2);
			 
			
		    
			criteria.andSellMonthIn(months);
			criteria.andProviderIdEqualTo(providerId);
			PageHelper.startPage(pageNum, pageSize);
			lst = this.resourceSellService.selectByExample(example);
			for(ResourceSell r:lst){
				map = new HashMap<String,Object>();
				map.put("resId", r.getResId());
				map.put("skeletonPath", r.getSkeletonPath());
				map.put("licenseType", r.getLicenseType());
				if(getProviderPublished(providerId,assetFamily,r.getSellMonth())==1){//发布了才给看
					map.put("price", r.getPrice());
					map.put("royaltyRate", r.getRoyaltyRate());
					map.put("netShare", r.getNetShare());
				}else{
					map.put("price", null);
					map.put("royaltyRate", null);
					map.put("netShare", null);
				}
				map.put("usage", r.getUsageCn());
				map.put("industry", r.getIndustryCn());
				map.put("sellDate", r.getSellDate());
				map.put("duration", r.getDuration());
				map.put("comment", r.getComment());
				retdata.add(map);
			}
			
			
//			if(includecurrent==1){
//				ResourceSellFromBossExample bossexample=new ResourceSellFromBossExample();
//				bossexample.createCriteria().andAssetFamilyEqualTo(2).andProviderIdEqualTo(providerId).andOutbillDateBetween(current_date_start_date, current_date_end_date);
//				List<ResourceSellFromBoss> lst = this.resourceSellFromBossService.selectByExample(example);
//			}
			
			
			
			//这个摄影师的创意稿费的销售额和销售稿费
			Map<String,Object> searchParam = new  HashMap<String,Object>();
		    searchParam.put("providerId", providerId);
		    searchParam.put("sellMonth", months);
		    ResultMap total = this.queryService.queryOneForCustom("ReportManage", "creativeSumByProviderId", searchParam);
			
		    if(total!=null && total.getValue("sellTotalFee")!=null  ){
				result.put("sellTotalFee", total.getValue("sellTotalFee"));
			}
		    if(total!=null && total.getValue("costTotalFee")!=null  ){
				result.put("costTotalFee", total.getValue("costTotalFee"));
			}
			
			result.put("status", 200);
			result.put("data", retdata);
			result.put("total",this.resourceSellService.countByExample(example));
			result.put("message", "成功");
			
			
		}else if(searchType==2){
			example=new ResourceSellExample();
			com.vcg.provider.model.query.ResourceSellExample.Criteria criteria =  example.createCriteria();
		    criteria.andAssetFamilyEqualTo(1);
		 
			criteria.andSellMonthIn(months);
			criteria.andProviderIdEqualTo(providerId);
			PageHelper.startPage(pageNum, pageSize);
			lst = this.resourceSellService.selectByExample(example);
			for(ResourceSell r:lst){
				map = new HashMap<String,Object>();
				map.put("resId", r.getResId());
				map.put("skeletonPath", r.getSkeletonPath());
				map.put("creditLine", r.getCreditLine());
				map.put("clientType", r.getClientType());
				map.put("billConfirmTime", r.getConfirmTime());
				map.put("confirmTime", r.getPhotoDownloadtime());
				retdata.add(map);
			}
			result.put("status", 200);
			result.put("data", retdata);
			result.put("total",this.resourceSellService.countByExample(example));
			result.put("message", "成功");
			
		}else if(searchType==3){//3:编辑类稿费查询 按月
			
            //编辑类的总计数据,默认都是已经发布.
			//未付款的只显示张数和月份
			//已付款的显示全部
			ResourceSellMonthExample rexample=new ResourceSellMonthExample();
			Criteria criteria =  rexample.createCriteria();
			criteria.andAssetFamilyEqualTo(1);
		    criteria.andSellMonthIn(months);
		    criteria.andProviderIdEqualTo(providerId);
			 
 
 
		    PageHelper.startPage(pageNum, pageSize);
			List<ResourceSellMonth> list = this.resourceSellMonthService.selectByExample(rexample);
			
			for(ResourceSellMonth r:list){
				map = new HashMap<String,Object>();
				map.put("month", r.getSellMonth());
				map.put("photoNumber", r.getSellCount());
				if(r.getIsPaied()==1){
					map.put("shareTotal", r.getShareTotal());
					map.put("additionalRoyalty", r.getAdditionalShare());
					map.put("tax", r.getTax());
					map.put("netPayment", r.getNetPayment());
					map.put("bonus", r.getExclusiveBonus());
					map.put("payTime", r.getPayTime());
				}else{
					map.put("shareTotal", null);
					map.put("additionalRoyalty", null);
					map.put("tax", null);
					map.put("netPayment", null);
					map.put("bonus", null);
					map.put("payTime", null);
				}
				retdata.add(map);
			}
			
			
			
			
			   //分成总额
		   	   Map<String,Object> searchParam = new  HashMap<String,Object>();
		   	   searchParam.put("providerId", providerId);
		   	   searchParam.put("sellMonth", months);
			   ResultMap total = this.queryService.queryOneForCustom("ReportManage", "editSumByProviderId", searchParam);
		 
		   if(total!=null && total.getValue("shareTotal")!=null  ){
				result.put("gaofeiTotal", total.getValue("shareTotal"));
			}
			result.put("status", 200);
			result.put("data", retdata);
			result.put("total",this.resourceSellMonthService.countByExample(rexample));
			
		}
		
            return  result;
  
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
	@ApiOperation(value = "查询摄影师详情", notes = "查询摄影师详情")
	@RequestMapping(value="/getProviderByUserCenterId", method=RequestMethod.GET)
	public RestfulResult getProviderByUserCenterId(@RequestParam String userCenterId){
		ProviderExample example = new ProviderExample();
		example.createCriteria().andUserCenterIdEqualTo(userCenterId);
		
		List<Provider> provider = this.providerService.selectByExample(example);
	 
		RestfulResult msg = new RestfulResult(0, "ok", null);
		if(provider.size()>0){
			 
			msg.setStatus(200);
			msg.setData(provider.get(0));
			msg.setMessage("ok");
		} else{
			msg.setStatus(201);
			msg.setData(null);
			msg.setMessage("摄影师不存在");
			 
		}
		return msg;
	}
	
	
	
 
	
//	public void transferToProviderBucket( String receiveMessage){
//		
//		JSONObject object=JSON.parseObject(receiveMessage,JSONObject.class);
//		String ossUrl = object.getString("ossUrl");
//		
//		System.err.println(ossUrl);
//		
//		if(isInternal==1&&ossUrl.indexOf("-internal")!=-1){
//			//外网
//			ossUrl=ossUrl.replace("-internal", "");
//		}
//		String infomsg = RestTemplateFactory.getTemplate().getForObject(ossUrl, String.class);
//		
//		System.err.println(infomsg);
//		
//	 
//		
//		Object objectkey=object.get("objectKey");
//		//删除
//
//
//        OSSClient ossClient = OssClient.getOssClient(isInternal);
//		
//		//删除json
//		ossClient.deleteObject(OssClient.feiyuantuBucket, objectkey+"");
//		//删除图片
//		
//		
//		String key=ossUrl.replace(OssClient.feiyuantu_ossHttpUrl, "");
//		ossClient.deleteObject(OssClient.feiyuantuBucket, key);
//		
// 
//		
//		OssClient.closeClient(ossClient);
// 
//	}
//	public void transferToProviderBucket( String ossUrl){
//		
//		 
//		
//		System.err.println(ossUrl);
//		
//		if(ossUrl.indexOf("-internal")!=-1){
//			//外网
//			ossUrl=ossUrl.replace("-internal", "");
//		}
//		String infomsg = RestTemplateFactory.getTemplate().getForObject(ossUrl, String.class);
//		
//		System.err.println(infomsg);
//		
// 
//        OSSClient ossClient = OssClient.getOssClient(isInternal);
//		
//		//删除json
//		//ossClient.deleteObject(OssClient.feiyuantuBucket, objectkey+"");
//		//删除图片
//		
//		
//		String key=ossUrl.replace(OssClient.feiyuantu_ossHttpUrl, "");
//		ossClient.deleteObject(OssClient.feiyuantuBucket, key);
//		
// 
//		
//		OssClient.closeClient(ossClient);
// 
//	}
 
 
}
