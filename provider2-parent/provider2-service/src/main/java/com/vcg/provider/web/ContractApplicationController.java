package com.vcg.provider.web;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.vcg.oss.util.ProviderOSSClientUtil;
import com.vcg.common.AbstractController;
import com.vcg.common.DateUtils;
import com.vcg.common.RestfulResult;
import com.vcg.common.RestfulResultFactory;
import com.vcg.common.ResultMap;
import com.vcg.common.Status;
import com.vcg.provider.entity.ContractApporive;
import com.vcg.provider.entity.SearchContractApplicationInfo;
import com.vcg.provider.model.Collection;
import com.vcg.provider.model.Contact;
import com.vcg.provider.model.ContactApplication;
import com.vcg.provider.model.Contract;
import com.vcg.provider.model.ContractApplication;
import com.vcg.provider.model.Provider;
import com.vcg.provider.model.ProviderApplication;
import com.vcg.provider.model.ProviderPayment;
import com.vcg.provider.model.query.ContactApplicationExample;
import com.vcg.provider.model.query.ContractApplicationExample;
import com.vcg.provider.model.query.ProviderApplicationExample;
import com.vcg.provider.model.query.ProviderPaymentExample;
import com.vcg.provider.service.CollectionService;
import com.vcg.provider.service.ContactApplicationService;
import com.vcg.provider.service.ContactService;
import com.vcg.provider.service.ContractApplicationService;
import com.vcg.provider.service.ContractService;
import com.vcg.provider.service.ProviderApplicationService;
import com.vcg.provider.service.ProviderPaymentService;
import com.vcg.provider.service.ProviderService;
import com.vcg.provider.util.AccountUtil;
import com.vcg.provider.util.ContactUtil;
import com.vcg.provider.util.MessageUtil;
import com.vcg.provider.util.RedisUtil;
import com.vcg.provider.util.SearchUtil;
import com.vcg.provider.util.UUIDUtil;
import com.vcg.util.feignClient.UtilClient;
import com.vcg.oss.global.contant.AliContants;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/contractApplication")
public class ContractApplicationController extends AbstractController{
	public static Logger log = Logger.getLogger(ContractApplicationController.class);
	@Autowired
	private ContractApplicationService contractApplicationService;
	
	@Autowired
	private ProviderApplicationService providerApplicationService;
	
	@Autowired
	private ContactApplicationService contactApplicationService;
	
	@Autowired
	private ProviderService providerService;
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private ContractService contractService;
	
	@Autowired
	private CollectionService collectionService;
	
	@Autowired
	private ProviderPaymentService providerPaymentService;
	
	@Autowired
	private AccountUtil accountUtil;
	
	@Autowired
	private RedisUtil providerUtil;
	
	@Value("${oss.isInternal}")
	private Integer isInternal;
	
	@Value("${mepx.notifyservice}")
	private String notifyservice;
	
	@Autowired
	private UtilClient utilClient;
 
	@Autowired
	private ContactUtil contactUtil;
	
	@Autowired
	private ProviderOSSClientUtil providerOSSClientUtil;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@Autowired
	private RedisUtil redisUtil;
	
 
	
	/**
	 * 供稿人资格审核通过后新建合同（申请）
	 * @param contractApplication
	 * @return
	 */
	
	@ApiOperation(value = "资格审核-<添加合同>", notes = "申请供稿人审核页面的")
	@RequestMapping(value="/createContractApplication",method=RequestMethod.POST)
	public Object createContractApplication(@RequestBody ContractApplication contractApplication){
		/*
		 * 新建合同规则：
		 * 摄影师审核通过后可以上传合同；
		 * 摄影师不允许同时申请两份合同（申请编辑类&创意类摄影师只有一份申请合同），即只有前一份合同审核完毕（通过）后才能进行下一份合同申请
		 * 不允许重复申请
		 */
		if(contractApplication.getUserCenterId() == null 
				|| contractApplication.getUserCenterId().trim().isEmpty()){
			return RestfulResultFactory.getInstance(Status.ERROR, null,  "用户中心ID为空");
		}
		
		ProviderApplicationExample exam_p = new ProviderApplicationExample();
		exam_p.createCriteria().andUserCenterIdEqualTo(contractApplication.getUserCenterId())
			.andStatusEqualTo(Status.PROVIDER_STATUS_NOCONTRACT);/*待签合同*/
		List<ProviderApplication> providers = providerApplicationService.selectByExample(exam_p);
		if(CollectionUtils.isEmpty(providers)){
			return RestfulResultFactory.getInstance(Status.ERROR, null,  "已有待通过合同,不符合申请新合同的条件");
		}else{
			ContractApplicationExample exam = new ContractApplicationExample();
			exam.createCriteria().andUserCenterIdEqualTo(contractApplication.getUserCenterId())
				.andAuditingStatusEqualTo(Status.AUDITING_STATUS_NOUPLOAD);/*未上传*/
			List<ContractApplication> list = contractApplicationService.selectByExample(exam);
			if(CollectionUtils.isNotEmpty(list)){
				/*避免重复多次上传*/
				return RestfulResultFactory.getInstance(Status.ERROR, null,  "合同已上传");
			}
			
		}
		
		/*
		 * 初始化合同：
		 * 合同状态：失效
		 * 审核状态：供稿人未上传合同
		 */
		contractApplication.setContractStatus(Status.CONTRACT_STATUS_INVALID);
		contractApplication.setAuditingStatus(Status.AUDITING_STATUS_NOUPLOAD);
		contractApplication.setCreatedTime(DateUtils.getNowDate());
		contractApplication.setProviderId(providers.get(0).getId());
		
	
		return this.contractApplicationService.insertSelective(contractApplication);
	}
	
	/**
	 * 供稿人合同审核
	 * @param id  合同申请id
	 * @param pass  0:驳回
	 * @param reason  理由
	 * @return
	 * @throws IOException 
	 */
	@ApiOperation(value = "申请供稿人审核-合同-查看合同-<合同通过><驳回>", notes = "合同详情页<合同通过><驳回>")
	@RequestMapping(value="/providerContractExamination",method=RequestMethod.POST)
	public Object providerContractExamination(@RequestBody ContractApporive contractApporive,@RequestParam String token) throws IOException{
		String userId ="";
		try{	
		 userId = accountUtil.getUserId(token);
	    } catch (Exception e) {
		 
		e.printStackTrace();
		String error= org.apache.commons.lang.exception.ExceptionUtils.getStackTrace(e) ;
		
		return new RestfulResult(Status.ERROR,null, error);
	    }
		
		
		int status;//'状态 1 未审核 2 待签合同 3 开通 4 不通过 5冻结 6关闭 '
		if(contractApporive.getPass() == 0){
			/*no pass*/
			status = 2;
		}else{
			status = 3;
		}
		ContractApplication contractApplication = this.contractApplicationService.selectByPrimaryKey(contractApporive.getId());
		if(contractApplication == null){
			return RestfulResultFactory.getInstance(Status.ERROR, null,  "没有待审核信息");
		}else{

			/*更新申请合同审核状态*/
			
			//合同审核状态
//			  auditing_status_noupload=1;//未上传
//			  auditing_status_uploaded=2;//已上传
//			  auditing_status_reject=3;//驳回
//			  auditing_status_reupload=4;//重传
//			  auditing_status_pass=5;//通过
			
			if(contractApporive.getPass() == 0){//合同拒绝
				
				RestfulResult msg = contractApplicationService.noPassContract(contractApporive, contractApplication);
				if(msg.getStatus()==200){
					return RestfulResultFactory.getInstance(200, null,  "拒绝成功");
					
				}else{
					return RestfulResultFactory.getInstance(201, null,  "拒绝失败");
				}
				
	 
				 
			}else{//合同通过,供应商的那份申请也通过,然后往供应商表插入新的数据
 
				RestfulResult msg = contractApplicationService.passContract(contractApporive, contractApplication, status, userId);
				if(msg.getStatus()==200){
					return RestfulResultFactory.getInstance(200, null,  "成功");
					
				}else{
					return RestfulResultFactory.getInstance(201, null,  "失败");
				}
 
	 
			}
		}
	}
	
  

public String getContent(String path) {
 
		StringBuffer sb = new StringBuffer();
		FileInputStream is = null;
		BufferedReader br = null;
		try {
			is = new FileInputStream(path);
			br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + "");
			}
		} catch (IOException e) {
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {

			}
		}
		return sb.toString();
	}
	
	
	
	
	/**
	 * 供稿人审核后给社区返回的审核结果 
	 * 这个函数的开发遵照 http://cyupload.mydoc.io/?t=109906  只需要 reviewType 和state
	 * @param record
	 * @param ct_record
	 * @param pass
	 * @param reason
	 * @return
	 */
	
 
	private void callBackTo500px( ContractApplication contractApplication, 
			Integer pass, String reason){
		String url = notifyservice;
		JSONObject param = new JSONObject();
		param.put("userCenterId", contractApplication.getUserCenterId());
		param.put("reviewType", "1"); //0:资格审核，1：合同审核 2:主动发送合同
		JSONObject contractInfo = new JSONObject();
		if(pass == 0){
			contractInfo.put("state", 0);
			contractInfo.put("message", "申请失败，原因：" + reason);
		}else{
			contractInfo.put("state", 1);
			contractInfo.put("message", "申请成功");
		}
		param.put("contractInfo", contractInfo);
		

//		log.debug("合同审核：" + param);
//		RestTemplate rs = new RestTemplate();
//		JSONObject re = rs.postForObject(url, param, JSONObject.class);
		
		redisUtil.putContractApplication(contractApplication.getUserCenterId(),param);
		
//		return re;
	}
	
	/**
	 * 供稿人（个人）审核通过后，如果供稿人之前已注册，则更新其注册类别信息，否则新建注册人信息
	 * @param appRecord
	 * @return
	 */
	private Integer newFormalProvider(ContractApplication contractApplication, ProviderApplication providerApplication){
		Provider provider = new Provider();
		List<Provider> providers = this.providerService
				.getProviderByUserCenterId(contractApplication.getUserCenterId());
		if(CollectionUtils.isNotEmpty(providers)){// 用户原来已经是签约用户了,这次只需要修改   修改什么呢?   待定义
			provider = providers.get(0);  // 一个人只有一个账号  只有一个账号中心的id,这个id 是不会变的,所以可以直接取0
			provider.setAssetFamily(Status.ASSET_FAMILY_MIXED);  //如果以前有这个人,说明本次合同通过是新增一种assetfamily,那么直接改成3 
			provider.setUpdatedTime(DateUtils.getNowDate());
			provider.setCreatedTime(DateUtils.getNowDate());
			this.providerUtil.providerMerge(provider);
		}else{
//			{
			BeanUtils.copyProperties(providerApplication, provider, "id");
//				  "assetFamily": 1,
//				  "createdTime": 1480658976000,
//				  "id": 96,
//				  "isDelete": 1,
//				  "jobType": 1,
//				  "nameCn": "王威真实姓名NNN",
//				  "passtTime": 1480659743225,
//				  "productions": "https://photo-test-community.shijue.me/s/5bb60fd58c79373af72351cfb9d479257726a71c424fafb39ed63d175204b819ddfeab54aa69f903f55bc5d48b6b06ed4435cfee743fcfc6",
//				  "providerCompany": "视觉中国研发部4",
//				  "providerId": "VP-20161202-7F8D",
//				  "status": 3,
//				  "type": 2,
//				  "updatedTime": 1480659031000,
//				  "userCenterId": "218b60cb04ba3a03942c7f4c316177180"
//		    }
			
			ContactApplicationExample exam_cp = new ContactApplicationExample();
			exam_cp.createCriteria().andUserCenterIdEqualTo(providerApplication.getUserCenterId());
			List<ContactApplication> list_cp = this.contactApplicationService.selectByExample(exam_cp);
			if(CollectionUtils.isNotEmpty(list_cp)){
				provider.setProvince(list_cp.get(0).getProvince());
				provider.setCity(list_cp.get(0).getCity());
				provider.setCountry(list_cp.get(0).getCountry());
				provider.setLocation(list_cp.get(0).getAddress());
				
			}
			provider.setCompany(providerApplication.getProviderCompany());
			provider.setAssetFamily(providerApplication.getAssetFamily());
			provider.setStatus(3);// 3 开通 5冻结 6关闭 
			provider.setUserCenterId(providerApplication.getUserCenterId());
			provider.setCreatedTime(DateUtils.getNowDate());
			provider.setCreatedTime(DateUtils.getNowDate());
			provider.setAgentType(providerApplication.getType());
			provider.setUpdatedTime(DateUtils.getNowDate());
			provider.setSignatureName(contractApplication.getCreditLine());
			this.providerUtil.providerMerge(provider);
			/*联系人信息*/

			if(CollectionUtils.isNotEmpty(list_cp)){
				Contact contact = new Contact();
				BeanUtils.copyProperties(list_cp.get(0), contact, "id");
//				{
//					  "city": "0",
//					  "country": "0",
//					  "createdTime": 1480658976000,
//					  "email": "ronawilliam@163.com",
//					  "id": 55,
//					  "idNum": "421125198701263332",
//					  "isDefault": 1,
//					  "mobile": "13811855184",
//					  "name": "王威真实姓名NNN",
//					  "postcode": "postco",
//					  "province": "0",
//					  "qq": "303781830",
//					  "sex": 1,
//					  "updatedTime": 1480659086000,
//					  "userCenterId": "218b60cb04ba3a03942c7f4c316177180",
//					  "weixin": "mudi977612"
//					}
				
				
				contact.setEmail(list_cp.get(0).getEmail());
				contact.setIdNum(list_cp.get(0).getIdNum());
				contact.setIsDefault(list_cp.get(0).getIsDefault());
				contact.setMobile(list_cp.get(0).getMobile());
				contact.setProviderId(provider.getId());
				contact.setPostcode(list_cp.get(0).getPostcode());
				contact.setQq(list_cp.get(0).getQq());
				contact.setWeixin(list_cp.get(0).getWeixin());
				contact.setCreatedTime(DateUtils.getNowDate());
				contact.setSex(list_cp.get(0).getSex());
				contact.setAddress(provider.getLocation());
				contact.setIdCardimgpath(list_cp.get(0).getIdCardimgpath());
				contact.setIdType(list_cp.get(0).getIdType());
				contact.setIsDefault(1);
				this.contactService.insertSelective(contact);
			}
		}
		
		return provider.getId();
	}
	
	
	/**
	 * 新建合同信息（正式）
	 * @param appRecord
	 * @param providerId
	 */
	private void newAFormalContractInfo(ContractApplication contractApplication, Integer providerId,String pdfPath){
		/*支付方信息*/
		
		Integer payid=0;
		ProviderPaymentExample payxeample = new ProviderPaymentExample();
		payxeample.createCriteria().andPayeeNumberEqualTo(contractApplication.getPayeeNumber());
		 List<ProviderPayment> paylist = providerPaymentService.selectByExample(payxeample);
		 if(paylist.size()==0){//新用户
			    ProviderPayment contractPay = new ProviderPayment();
			    BeanUtils.copyProperties(contractApplication, contractPay, "id");
				contractPay.setProviderId(providerId);
				contractPay.setIsBank(1);
				contractPay.setAssetFamily(contractApplication.getAssetFamily());
				contractPay.setPaymentMethod(contractApplication.getPayMethodName());
				contractPay.setCreatedTime(DateUtils.getNowDate());
				this.providerPaymentService.insertSelective(contractPay);
				payid = contractPay.getId();
		 }else{//老用户,这个卡号已经存在了
			 payid = paylist.get(0).getId();
			 ProviderPayment contractPay = new ProviderPayment();
			 contractPay.setId(payid);
			 contractPay.setAssetFamily(3);
			 this.providerPaymentService.updateByPrimaryKeySelective(contractPay);
			 
		 }
		
		/*合同基本信息*/
		Contract contract = new Contract();
		BeanUtils.copyProperties(contractApplication, contract, "id");
		contract.setProviderId(providerId);
		contract.setPaymentId(payid);
		contract.setCreatedTime(DateUtils.getNowDate());
		contract.setContractPdfPath(pdfPath); //pdf合同地址
		contract.setPartyA(contractApplication.getContractZhuti());
		contract.setContractStatus(1);
		contract.setContractCode(contractApplication.getContractId());
		contract.setExclusiveAuth(Integer.parseInt(contractApplication.getExclusiveAuth()));
		contract.setPartyB(contractApplication.getProviderName());
 
		contract.setSignDate(DateUtils.getNowDate()); //签订时间为合同生效时间
		contract.setBeginDate(DateUtils.getNowDate());//生效时间
		Calendar canlandar = Calendar.getInstance();
		canlandar.setTime(DateUtils.getNowDate());
		canlandar.add(canlandar.YEAR,Integer.parseInt(contractApplication.getDeadline()));
		contract.setEndDate( canlandar.getTime());
 
		this.contractService.insertSelective(contract);
		/*合同其他信息*/
		Collection collectionEdit = new Collection();
		BeanUtils.copyProperties(contractApplication, collectionEdit, "id");
		collectionEdit.setProviderId(providerId);
		collectionEdit.setContractId(contract.getId());
		collectionEdit.setRoyaltyRate(contractApplication.getEditRate());
		collectionEdit.setCreatedTime(DateUtils.getNowDate());
		collectionEdit.setAvailableStatus(Status.COLLECTION_STATUS_OPEN);
		collectionEdit.setAssetType(Status.ASSET_TYPE_PICTURE);
		collectionEdit.setAssetFamily(Status.ASSET_FAMILY_EDIT);
		
		Collection collectionCreative = new Collection();
		BeanUtils.copyProperties(contractApplication, collectionCreative, "id");
		collectionCreative.setProviderId(providerId);
		collectionCreative.setContractId(contract.getId());
		collectionCreative.setRoyaltyRate(contractApplication.getCreativeRate());
		collectionCreative.setCreatedTime(DateUtils.getNowDate());
		collectionCreative.setAvailableStatus(Status.COLLECTION_STATUS_OPEN);
		collectionCreative.setAssetType(Status.ASSET_TYPE_PICTURE);
		collectionCreative.setAssetFamily(Status.ASSET_FAMILY_CREATIVE);
		
		if(contract.getAssetFamily() == Status.ASSET_FAMILY_EDIT){
			this.collectionService.insertSelective(collectionEdit);
			
		}else if(contract.getAssetFamily() == Status.ASSET_FAMILY_CREATIVE){
			this.collectionService.insertSelective(collectionCreative);
			
		}else if(contract.getAssetFamily() == Status.ASSET_FAMILY_MIXED){
			this.collectionService.insertSelective(collectionEdit);
			this.collectionService.insertSelective(collectionCreative);
		}
	}
	
	/**
	 * 申请供稿人审核-合同审核-搜索
	 * @param requestParam
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	
	@ApiOperation(value = "申请供稿人资格审核-合同审核-<合同审核查询>", notes = "合同审核主页")
	@RequestMapping(value="/searchContractApplicationInfo",method=RequestMethod.POST)
	public RestfulResult searchContractApplicationInfo(@RequestBody SearchContractApplicationInfo requestParam,@RequestParam String token){
		
		Map<String,Object> searchParam = SearchUtil.parseContractParam(requestParam);
		PageInfo<ResultMap> result = this.queryService.queryPageForCustom("providerManage", "searchContractApplicationInfo", searchParam);
		List<ResultMap> list =  result.getList();
//	 
//		List<String> partyIds = list.stream().map(e->e.v.getValue("passUserId")).filter(f->!f.contains("null")).distinct().collect(Collectors.toList());//去除一列,去重
//		List<Person>  passlist =   partyIds.stream().map(e->accountUtil.getPersonByPartyId(e, token, "yes")).collect(Collectors.toList());
//		for(Person person :passlist){
//			
//		}
		for(ResultMap resultMap:list){
			if(resultMap.getValue("passUserId")!=null && StringUtils.isNotBlank(resultMap.getValue("passUserId").toString())  ){
				String username = accountUtil.getUserNameByPartyId(resultMap.getValue("passUserId").toString(), token);
				resultMap.putNoReplace("passUserName", username);
			}
		}
		return new RestfulResult<PageInfo<ResultMap>>(200, result, "操作成功");
	}
	
	/**
	 * 申请供稿人审核-合同审核-查看合同
	 * @param requestParam
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	
	@ApiOperation(value = "申请供稿人资格审核-合同审核-<查看合同>", notes = "id例如34")
	@RequestMapping(value="/viewContractApplication",method=RequestMethod.GET)
	public RestfulResult viewContractApplication(@RequestParam String id){
		
		Map<String,Object> searchParam = new HashMap<String,Object>();
		searchParam.put("id", id);
		ResultMap result = this.queryService.queryOneForCustom("providerManage", "viewContractApplication", searchParam);
		
 
		if(result!=null && result.getValue("idCardimgpath")!=null  ){
			String fullFilePath = providerOSSClientUtil.getProviderObject(isInternal, result.getValue("idCardimgpath")+"");
			result.putNoReplace("idCardimgpath", fullFilePath);
		}
		 if(result!=null){
			 return RestfulResultFactory.getInstance(200, result,  "成功");
		 }else{
			 return RestfulResultFactory.getInstance(Status.ERROR, null,  "合同不存在!");
		 }
		
	}
	
	 String inputStream2String(InputStream is) throws IOException{
		   
		   BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		   StringBuffer buffer = new StringBuffer();
		   String line = "";
		   
			while ((line = reader.readLine()) != null){
			     buffer.append(line);
			   }
	 
		   return buffer.toString();
		}
 
	public String createHtml(Integer integer) throws IOException{
		//http://bj-feiyuantu.oss-cn-beijing.aliyuncs.com/provider/template/contract.html
		Map<String,Object> searchParam = new HashMap<String,Object>();
		searchParam.put("id", integer);
		ResultMap result = this.queryService.queryOneForCustom("providerManage", "viewContractApplication", searchParam);
		String template = "";
		//摄影师独家信息：0:非独家 1:独家 2:联合独家(非独家) 3.合作独家 
		if(result.getIntegerValue("exclusiveAuth")==0||result.getIntegerValue("exclusiveAuth")==2){
			template = "provider/template/feidujia_hetong.html";
		}else if(result.getIntegerValue("exclusiveAuth")==3){//1 内容独家
			template = "provider/template/hezuodujia_hetong.html";
		}else if(result.getIntegerValue("exclusiveAuth")==1){// 2 合作独家
			template = "provider/template/neirongdujia_hetong.html";
		} 
		template = AliContants.feiyuantu_ossHttpUrl+template;//莫办文件
		String content ="";
		URL url;
		try {
			url = new URL(template);
			InputStream inputStream = url.openStream();
			content = this.inputStream2String(inputStream);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String editValueStr = result.getValue("editRate");
		if(StringUtils.isNotBlank(editValueStr)){
			BigDecimal bd = new BigDecimal(editValueStr);
			BigDecimal bd100 = new BigDecimal(100);
			bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
			bd = bd.multiply(bd100);
			
			content = content.replaceFirst("\\$editRate\\$", bd+"");
		}
		String creativeRateStr = result.getValue("creativeRate");
		if(StringUtils.isNotBlank(creativeRateStr)){
			BigDecimal bd = new BigDecimal(creativeRateStr);
			BigDecimal bd100 = new BigDecimal(100);
			bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
			bd = bd.multiply(bd100);
			content = content.replaceAll("\\$creativeRate\\$", bd+"");
		}
		
		
		content = content.replaceFirst("\\$address\\$", result.getValue("address"));
		content = content.replaceFirst("\\$postcode\\$", result.getValue("postcode"));
		content = content.replaceFirst("\\$mobile\\$", result.getValue("mobile"));
		content = content.replaceAll("\\$nameCn\\$", result.getValue("nameCn"));
		content = content.replaceFirst("\\$idNum\\$", result.getValue("idNum"));
		content = content.replaceFirst("\\$payeeNumber\\$", result.getValue("payeeNumber"));
		content = content.replaceFirst("\\$bankName\\$", result.getValue("bankName"));
		content = content.replaceFirst("\\$payeeName\\$", result.getValue("payeeName"));
		content = content.replaceFirst("\\$country\\$", result.getValue("country"));
		

		content = content.replaceFirst("\\$deadline\\$", result.getValue("deadline"));
		content = content.replaceFirst("\\$contractId\\$", result.getValue("contractId"));
		content = content.replaceFirst("\\$email\\$", result.getValue("email"));
		
		InputStream is=new ByteArrayInputStream(content.getBytes());  
		String randomstring=UUIDUtil.generateUUID().substring(22);
		String filepath = "provider/template/"+randomstring+".html";//最终文件
 
		providerOSSClientUtil.putProviderFeiyuantu(isInternal, filepath, is);
		return AliContants.feiyuantu_ossHttpUrl + filepath ;
	}
	
	
	
	
	
	
	
	
	
}
