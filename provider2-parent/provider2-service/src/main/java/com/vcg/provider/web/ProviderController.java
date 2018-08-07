package com.vcg.provider.web;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vcg.common.AbstractController;
import com.vcg.common.DateUtils;
import com.vcg.common.RestfulResult;
import com.vcg.common.RestfulResultFactory;
import com.vcg.common.ResultMap;
import com.vcg.common.Status;
import com.vcg.provider.entity.AddJigouContract;
import com.vcg.provider.entity.AddJigouProvider;
import com.vcg.provider.entity.GerenAddContract;
import com.vcg.provider.entity.JigouContractPackage;
import com.vcg.provider.model.Collection;
import com.vcg.provider.model.Contract;
import com.vcg.provider.model.ContractApplication;
import com.vcg.provider.model.ContractAuthorization;
import com.vcg.provider.model.Provider;
import com.vcg.provider.model.ProviderPayment;
import com.vcg.provider.model.ProviderPortalaccounts;
import com.vcg.provider.model.SearchProviderInfo;
import com.vcg.provider.model.query.ContractAuthorizationExample;
import com.vcg.provider.model.query.ContractExample;
import com.vcg.provider.model.query.ProviderExample;
import com.vcg.provider.model.query.ProviderPaymentExample;
import com.vcg.provider.model.query.ProviderPortalaccountsExample;
import com.vcg.provider.service.CollectionService;
import com.vcg.provider.service.ContractApplicationService;
import com.vcg.provider.service.ContractAuthorizationService;
import com.vcg.provider.service.ProviderPaymentService;
import com.vcg.provider.service.ContractService;
import com.vcg.provider.service.ProviderPortalaccountsService;
import com.vcg.provider.service.ProviderService;
import com.vcg.provider.util.AccountUtil;
import com.vcg.provider.util.RedisUtil;
import com.vcg.provider.util.SearchUtil;
import com.vcg.provider.util.UUIDUtil;
import com.vcg.uc.feignClient.PassportClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/provider")
@Api("供应商信息")
public class ProviderController extends AbstractController{
	
	public static Logger log = Logger.getLogger(ProviderController.class);
	@Autowired
	private ProviderPaymentService providerPaymentService;
	
	@Autowired
	private ContractService contractService;
 
	@Autowired
	private AccountUtil accountUtil;

	@Autowired
	private ContractApplicationService contractApplicationService;
	
	@Value("${mepx.notifyservice}")
	private String notifyservice;
	
	@Autowired
	private ProviderService providerService;
	
	@Autowired
	private ContractAuthorizationService contractAuthorizationService;
	
	@Autowired
	private PassportClient passportClient;
	
	@Autowired
	private CollectionService collectionService;
	
	@Autowired
	private ProviderPortalaccountsService providerPortalaccountsService;
	
	@Autowired
	private RedisUtil redisUtil;
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	/**
	 * 供稿人-基本信息-搜索
	 * @param requestParam
	 * @param token
	 * @return
	 */
	@ApiOperation(value = "供稿人基本信息-<搜索>", notes = "供稿人基本信息-<搜索>")
	@RequestMapping(value="/searchProviderInfo", method=RequestMethod.POST)
	public Object searchProviderInfo(@RequestBody SearchProviderInfo requestParam,
			 @ApiParam(required = true)@RequestParam String token){
		if(requestParam.getAgentType() ==null){
			return RestfulResultFactory.getInstance(Status.ERROR, null,  "type参数必须有值");
		}
		
		 Map<String,Object> searchParam = SearchUtil.parseProviderParam(requestParam);
		 
		 PageHelper.startPage(requestParam.getPageNum(), requestParam.getPageSize());
		PageInfo<ResultMap> result = this.queryService.queryPageForCustom("providerManage", "searchProviderInfo", searchParam);
		List<ResultMap> providers = result.getList();
		
		if(requestParam.getAgentType()==1){//如果是机构 需要取出创建人
			for(ResultMap resultMap:providers){
				 
				 if(resultMap.getIntegerValue("createdBy")!=null){
					String username = accountUtil.getUserNameByPartyId(resultMap.getValue("createdBy").toString(), token);
					resultMap.putNoReplace("createdBy", username);
				 }
			}
			
		}

		result.setList(providers);
		return RestfulResultFactory.getInstance(200, result,  "成功");
	}
	
	/**
	 * 供稿人-点击一行-详细信息
	 * @param id 供稿人申请id
	 * @return
	 */
	@ApiOperation(value = "个人-点击一行数据获取<供稿人详情>", notes = "例如419375")
	@RequestMapping(value="/getGerenMoreInfo",method=RequestMethod.GET)
	public RestfulResult getProviderMoreApplicationInfo(@ApiParam(value = "本行的供应商id,如419375") @RequestParam Integer id){
		
		Map<String,Object> searchParam = new HashMap<String,Object>();
		searchParam.put("id", id);
		ResultMap result = this.queryService.queryOneForCustom("providerManage", "getProviderDetailedInformation", searchParam);//详情
		if(result==null){//不存在这个id的供应商
			return new RestfulResult<Map<String,Object>>(Status.ERROR,result,"不存在这个id对应的供应商");
		}else{
			//获取已经签过的合同列表
			ContractExample exam = new ContractExample();
			exam.createCriteria().andProviderIdEqualTo(id);
			List<Contract> contracts = this.contractService.selectByExample(exam);
			
			List<JigouContractPackage> packagelist= new ArrayList<JigouContractPackage>();
			JigouContractPackage jigouContractPackage = new JigouContractPackage();
			if(contracts.size()>0){
				for(Contract con: contracts){
					jigouContractPackage = new JigouContractPackage();
					jigouContractPackage.setContract(con);
					
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
			
			result.put("contracts", packagelist);
 
			//获取付款银行列表
			ProviderPaymentExample payexample = new ProviderPaymentExample();
			payexample.createCriteria().andProviderIdEqualTo(id);
			List<ProviderPayment> contractPays = this.providerPaymentService.selectByExample(payexample);
			result.put("contractPays", contractPays);
			
		}

		 
		return new RestfulResult<Map<String,Object>>(200,result,"操作成功");
	}
	
	
	
	/**
	 * 供稿人-点击一行-详细信息
	 * @param id 供稿人申请id
	 * @return
	 */
	@ApiOperation(value = "个人-点击一行数据获取<基本信息>", notes = "例如419519")
	@RequestMapping(value="/getGerenBaseInfo",method=RequestMethod.POST)
	public Object getGerenBaseInfo(@ApiParam(value = "本行的供应商id,如419375") @RequestParam Integer id){
		
		Map<String,Object> searchParam = new HashMap<String,Object>();
		searchParam.put("id", id);
		ResultMap result = this.queryService.queryOneForCustom("providerManage", "getProviderDetailedInformation", searchParam);//详情
		if(result==null){//不存在这个id的供应商
			return new RestfulResult<Map<String,Object>>(Status.ERROR,result,"不存在这个id对应的供应商");
		}else{
			
			
 
			return new RestfulResult<Map<String,Object>>(200,result,"操作成功");
		}

		 
		
	}
	
	/**
	 * 供稿人-点击一行-详细信息
	 * @param id 供稿人申请id
	 * @return
	 */
	@ApiOperation(value = "个人-点击一行数据获取<基本信息>", notes = "例如510015")
	@RequestMapping(value="/getGerenBankInfo",method=RequestMethod.POST)
	public Object getGerenBankInfo(@ApiParam(value = "本行的供应商id,如510015") @RequestParam Integer id){
		
		ProviderPaymentExample payexample = new ProviderPaymentExample();
		payexample.createCriteria().andProviderIdEqualTo(id);
		List<ProviderPayment> contractPays = this.providerPaymentService.selectByExample(payexample);
		Map<String,Object> result = new HashMap<String,Object>();
		List<Map<String,Object>> retlist = new ArrayList<Map<String,Object>>();
		 if(contractPays.size()>0){
				contractPays.forEach(e->{
					Map<String,Object> map = new  HashMap<String,Object>();
					map.put("payeeNumber", e.getPayeeNumber());
					map.put("payeeName", e.getPayeeName());
					map.put("bankName", e.getBankName());
					map.put("branchBankname", e.getBranchBankname());
					map.put("id", e.getId());
					retlist.add(map);
					});

		 } 
			result.put("status", 200);
			result.put("data", retlist);
			result.put("msg", "ok");
			return  result;
 
	}
	
	
	/**
	 * 供稿人-点击一行-详细信息
	 * @param id 供稿人申请id
	 * @return
	 */
	@ApiOperation(value = "个人-点击一行数据获取<合同信息>", notes = "例如510015")
	@RequestMapping(value="/getGerenContractInfo",method=RequestMethod.POST)
	public Object getGerenContractInfo(@ApiParam(value = "本行的供应商id,如510015") @RequestParam Integer id){
		Map<String,Object> result = new HashMap<String,Object>();
		//获取已经签过的合同列表
		ContractExample exam = new ContractExample();
		exam.createCriteria().andProviderIdEqualTo(id);
		List<Contract> contracts = this.contractService.selectByExample(exam);
		
		List<JigouContractPackage> packagelist= new ArrayList<JigouContractPackage>();
		JigouContractPackage jigouContractPackage = new JigouContractPackage();
		if(contracts.size()>0){
			for(Contract con: contracts){
				jigouContractPackage = new JigouContractPackage();
				jigouContractPackage.setContract(con);
				
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
		
		
		result.put("status", 200);
		result.put("data", packagelist);
		result.put("msg", "ok");
		return  result;
		
		
 
	}
	
 
 
 
	
	/**
	 * 供应商-添加供应商
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "机构-<添加供应商>", notes = "机构-<添加供应商>")
	@RequestMapping(value="/addProvider",method=RequestMethod.POST)
	public RestfulResult addProvider( @RequestBody AddJigouProvider jigou , @ApiParam(required = true)@RequestParam String token){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		String userId = accountUtil.getUserId(token);
		 if(StringUtils.isBlank(userId)){
			 return new RestfulResult(Status.ERROR,null, "无法获取当前登录用户信息"); 
		 }
		 
			 List<ProviderPortalaccounts> lst  = jigou.getPortalaccList();
			 HashSet mailset = new HashSet();
			 HashSet accountset = new HashSet();
			 for(ProviderPortalaccounts acc:lst){
				 mailset.add(acc.getEmail());
				 accountset.add(acc.getPortalAccount());
			 }
			 if(mailset.size()<lst.size()){
				 return new RestfulResult(Status.ERROR,null, "Portal邮箱不能重复");
			 }
			 if(accountset.size()<lst.size()){
				 return new RestfulResult(Status.ERROR,null, "Portal登录账号不能重复");
			 }
			 
			 
			 
			 for(ProviderPortalaccounts acc:lst){
					Map<String, Object> mailexist = passportClient.emailIsExist(acc.getEmail());
					Map<String, Object> accountexist = passportClient.userNameIsExist(acc.getPortalAccount());
					if(mailexist.get("status").equals("403")){
						return new RestfulResult(Status.ERROR,null, "Portal邮箱["+acc.getEmail()+"]"+ "已存在,请换一个邮箱");
					}
					if(accountexist.get("status").equals("403")){
						return new RestfulResult(Status.ERROR,null, "Portal登录账号["+acc.getPortalAccount()+"]" + "已存在,请换一个账号");
					}
				 
			 }
			 
			
 
		  
			result = providerService.addJigou(jigou, userId);
			 
 
		return result;

	}
	
	
	/**
	 * 供应商-添加供应商-当输入用户名之后,检查用户明是否已经存在了
	 * @return
	 */
	@ApiOperation(value = "机构-添加供应商-<检查我们给的用户名是否已经存在>", notes = "机构-添加供应商-<检查我们给的用户名是否已经存在>")
	@RequestMapping(value="/checkUserExist",method=RequestMethod.POST)
	public Object checkUserExist( String userName){
		RestfulResult result = new RestfulResult(200,null, "用户名可用");
        try {
        	Map<String, Object> instance =   passportClient.userIsExist(userName);
        	if("200".equals(instance.get("status").toString())){
        		return result;
        	}else{
        		return   new RestfulResult(Status.ERROR,null, "用户已经存在");
        	}
        	
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return result = new RestfulResult(Status.ERROR,null, fullStackTrace);
		}
 
	}
 
	
	/**
	 * 供应商-增加合同
	 * @return
	 */
	@ApiOperation(value = "机构-<添加合同>", notes = "机构-<添加合同>")
	@RequestMapping(value="/addJigouContract",method=RequestMethod.POST)
	public RestfulResult addJigouContract( @RequestBody AddJigouContract hetong , @ApiParam(required = true)@RequestParam String token){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
 
		try {
			String userId = accountUtil.getUserId(token);
			 if(StringUtils.isBlank(userId)){
				 return new RestfulResult(Status.ERROR,null, "Token失效,请重新登录!");
			 }
			
//			{
//				  "agentName": "string",
//				  "beginDate": "2016-11-14T10:27:51.346Z",
//				  "bond": 0,
//				  "contractName": "string",
//				  "contractPdfPath": "string",
//				  "contractType": 0,
//				  "deadline": "string",
//				  "endDate": "2016-11-14T10:27:51.347Z",
//				  "payId": 0,
//				  "payNote": "string",
//				  "paymentMethod": "string",
//				  "providerName": "string",
//				  "settlementCycle": "string"
//				}
			
			if(hetong.getProviderId()==null){
				return new RestfulResult(Status.ERROR,null, "ProviderId为空!"); 
			}
			result = providerService.addJigouContract(hetong, userId);
		} catch (Exception e) {
			e.printStackTrace();
			String error= org.apache.commons.lang.exception.ExceptionUtils.getStackTrace(e) ;
			return new RestfulResult(Status.ERROR,null, error);
			 
		}

		return result;
	}
	
	
	
	/**
	 * 供应商-银行卡列表  添加合同页面的下拉框
	 * @return
	 */
	@ApiOperation(value = "供应商-添加合同-<银行卡列表数据>", notes = "providerId例如419429")
	@RequestMapping(value="/getBankList",method=RequestMethod.POST)
	public RestfulResult getBankList( @RequestParam Integer providerId){
		RestfulResult result = new RestfulResult(200,null, "操作成功");
		try {
			ProviderPaymentExample example = new ProviderPaymentExample();
			example.setColunms(Arrays.asList("id","payee_number"));
			example.createCriteria().andProviderIdEqualTo(providerId);
			List<ProviderPayment> list =  providerPaymentService.selectByExample(example);
			 
			result = new RestfulResult(200,list, "操作成功");
		} catch (Exception e) {
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			result = new RestfulResult(Status.ERROR,null,fullStackTrace); 
		}

		return result;
	}
	
	
 
	
 
	
	/**
	 * 给供稿人 发送合同
	 * @param requestParam
	 * @param token
	 * @return
	 * @throws IOException
	 * @throws RestClientException
	 * @throws URISyntaxException
	 */
	@ApiOperation(value = "供稿人-<发送合同>", notes = "供稿人-<发送合同>")
	@RequestMapping(value="/gerenAddContract",method=RequestMethod.POST)
	public RestfulResult gerenAddContract(@RequestBody GerenAddContract gerenAddContract,@ApiParam(value = "token") @RequestParam String token){
		String userId = accountUtil.getUserId(token);

 
				 
				ContractApplication contractApp = new ContractApplication();
				/*
				 * 初始化合同申请：
				 * 合同状态：失效
				 * 审核状态：供稿人未上传合同
				 * 合同类型：标准
				 */
				contractApp.setContractStatus(Status.CONTRACT_STATUS_INVALID);//未生效
				contractApp.setAuditingStatus(Status.AUDITING_STATUS_NOUPLOAD);//未上传
				contractApp.setDeadline(gerenAddContract.getDeadline()+"");//我们来决定用户的合同期限
				contractApp.setCreatedTime(DateUtils.getNowDate());
//				contractApp.setProviderId(providerApplication.getId());  //申请的id作为providerId的临时id
				contractApp.setExclusiveAuth(gerenAddContract.getExclusiveAuth());//我们来决定用户的合同类型
				contractApp.setUserCenterId(gerenAddContract.getUserCenterId());
				contractApp.setAssetFamily(gerenAddContract.getAssetFamily());//我们来决定用户的类型
		       //合同名字 1标准，2买断，3解约，4外购 ,5续约
				contractApp.setContractType(gerenAddContract.getContractType());
				if (gerenAddContract.getContractType()==1){
					contractApp.setContractName("标准合同");
				}else if (gerenAddContract.getContractType()==2){
					contractApp.setContractName("买断合同");
				}else if (gerenAddContract.getContractType()==3){
					contractApp.setContractName("解约合同");
				}else if (gerenAddContract.getContractType()==4){
					contractApp.setContractName("外购合同");
				}else if (gerenAddContract.getContractType()==5){
					contractApp.setContractName("续约合同");
				}
				contractApp.setProviderName(gerenAddContract.getNameCn()); // 只取中文名字,因为社区只维护了中文名字
				contractApp.setContractZhuti(gerenAddContract.getContractZhuti());//我们来决定用户的签约主体
				contractApp.setEditRate(gerenAddContract.getEditorialSplitRatio());//编辑类分成比
				contractApp.setCreativeRate(gerenAddContract.getCreativeSplitRatio());//创意分成比
				contractApp.setProviderId(gerenAddContract.getId());
				contractApp.setProviderName(gerenAddContract.getNameCn());
				
				
			 
 
				
				//生成ContractId
				String randomstring=UUIDUtil.generateUUID().substring(28);
				SimpleDateFormat sdf =   new SimpleDateFormat( "yyyyMMdd" );
			    String timestemp = sdf.format(new Date());
			    String contractId="VC-"+timestemp+"-"+randomstring.replace(".", "").toUpperCase();
			    contractApp.setContractId(contractId);
 
			    this.contractApplicationService.insertSelective(contractApp);
			 

		 
			/*社区回调*/
			JSONObject re = this.callBackTo500px(contractApp, gerenAddContract);
			log.debug("社区回调" + re);
			return RestfulResultFactory.getInstance(200, null,  "操作成功");
		 
	}
	
	//这个函数的开发和维护参考  http://cyupload.mydoc.io/?t=109906
	private JSONObject callBackTo500px(ContractApplication contractApplication,GerenAddContract gerenAddContract){

				String url = notifyservice;

				//providerQualification 是发送合同的时候填写的信息

				JSONObject param = new JSONObject();
				param.put("userCenterId", contractApplication.getUserCenterId());
				param.put("reviewType", "2");                                      //0:资格审核，1：合同审核 2:主动发送合同
				
				
//				   {
//					id:"00001",//创意类摄影师id
//					state："0"，//0：通过   1：不通过
//					message:"提示信息"//如申请通过，申请失败，原因。。。
//					accessStatus："1"//签约类型， 1： 编辑类 ；2创意类 ； 3创意类和编辑类
//					contractSubject:"//签约主体
//					creativeSplitRatio:“” //创意类分成比例
//					editorialSplitRatio:“” //编辑类分成比例
//					contractPeriod:"" 合同期限
//					exclusiveLicence：“”//独家授权，独家0非独家1 内容独家 2 合作独家
//					jobType：2 // 1：媒体     2：非媒体
//					sex：2 //1：男  2：女
//					providerCompany："",//工作单位
//					nameCn：“”,//真实姓名
//					mobile：“”,//手机号
//					email：“”,//邮箱
//					}
				
				
				JSONObject contractInfo = new JSONObject();
				contractInfo.put("id", contractApplication.getId());//刚刚插入的申请的id
				contractInfo.put("accessStatus", gerenAddContract.getAssetFamily());
				contractInfo.put("contractSubject", gerenAddContract.getContractZhuti());
				contractInfo.put("exclusiveLicence", gerenAddContract.getExclusiveAuth());
				contractInfo.put("creativeSplitRatio",gerenAddContract.getCreativeSplitRatio() );
				contractInfo.put("editorialSplitRatio",gerenAddContract.getEditorialSplitRatio());
				contractInfo.put("contractPeriod",gerenAddContract.getDeadline());
				contractInfo.put("jobType",gerenAddContract.getJobType() );
				contractInfo.put("providerCompany", gerenAddContract.getProviderCompany());
				contractInfo.put("mobile", gerenAddContract.getMobile());
				contractInfo.put("email", gerenAddContract.getEmail());
				contractInfo.put("sex", gerenAddContract.getSex());
				contractInfo.put("nameCn", gerenAddContract.getNameCn());
				contractInfo.put("contractType",gerenAddContract.getContractType());
				
 
				param.put("contractInfo", contractInfo);
				
				log.debug("资格审核" + param);
				RestTemplate rs = new RestTemplate();
				/*社区回调*/
				JSONObject re = rs.postForObject(url, param, JSONObject.class);
				return re;
				}
	
	
	
	
	
	
	/**
	 * 机构登录之后,获取登录人的机构id
	 * @param id 供稿人申请id
	 * @return
	 */
	@ApiOperation(value = "机构登录之后,获取登录人的机构id", notes = "例如wangweiportal")
	@RequestMapping(value="/getJigouProviderIdByAccountName",method=RequestMethod.GET)
	public RestfulResult getJigouProviderIdByAccountName(@ApiParam(value = "本行的供应商登录名account,如wangweiportal") @RequestParam String portalAccount){
		ProviderPortalaccountsExample example = new ProviderPortalaccountsExample();
		example.createCriteria().andPortalAccountEqualTo(portalAccount);
		List<ProviderPortalaccounts> list = providerPortalaccountsService.selectByExample(example);
		
		if(list.size()==0){//不存在这个id的供应商
			return new RestfulResult(Status.ERROR,null,"不存在这个account对应的供应商");
		}else{
			Provider p=redisUtil.getProvider(list.get(0).getProviderId());
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("providerId", list.get(0).getProviderId());
			if(p.getColls().size()==0){
				map.put("havecolletion", 0);
			}else{
				map.put("havecolletion", 1);
			}
			return  new RestfulResult(200,map, "操作成功");
			 
				
			}
 
	 

	}
	
	
 
	
}
