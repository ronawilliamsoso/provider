package com.vcg.provider.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.vcg.common.DateUtils;
import com.vcg.common.RestfulResult;
import com.vcg.common.RestfulResultFactory;
import com.vcg.common.Status;
import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.ContractApplication;
import com.vcg.provider.model.ProviderApplication;
import com.vcg.provider.model.query.ProviderApplicationExample;
import com.vcg.provider.dao.ProviderApplicationDao;
import com.vcg.provider.entity.ProviderQualification;
import com.vcg.provider.service.ContactApplicationService;
import com.vcg.provider.service.ContractApplicationService;
import com.vcg.provider.service.ProviderApplicationService;
import com.vcg.provider.util.AccountUtil;
import com.vcg.provider.util.ContactUtil;
import com.vcg.provider.util.MessageUtil;
import com.vcg.provider.util.RedisUtil;
import com.vcg.provider.util.UUIDUtil;

@Service
public class ProviderApplicationServiceImpl extends BaseServiceImpl<ProviderApplication,ProviderApplicationExample,Integer> implements ProviderApplicationService {

	@Autowired
	private ProviderApplicationDao providerApplicationDao;

	@Override
	public void setDao() {
		this.baseDao = providerApplicationDao;
	}
 
	@Autowired
	private ContractApplicationService contractApplicationService;
	
	@Autowired
	private ContactUtil contactUtil;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@Value("${mepx.notifyservice}")
	private String notifyservice;
	
	@Autowired
	private RedisUtil redisUtil;
	
	
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public RestfulResult passApplication(ProviderApplication providerApplication,ProviderQualification requestParam,Integer status, String userId) {
		
		
		try { 
			
			
 
			providerApplication.setStatus(status);
			providerApplication.setAssetFamily(requestParam.getAssetFamily());
			/* 审核时间*/
			providerApplication.setPasstTime(DateUtils.getNowDate());
			/*审核人（测试20521）*/
				providerApplication.setPassUserId(userId);
			
//			record.setPassUserId(20521);
			 this.updateByPrimaryKeySelective(providerApplication);
			/*摄影师资格审核通过后，生成一个合同申请，摄影师提供的合同审核资料也提交到此申请里，一并审核*/
			ContractApplication contractApp = new ContractApplication();
			/*
			 * 初始化合同申请：
			 * 合同状态：失效
			 * 审核状态：供稿人未上传合同
			 * 合同类型：标准
			 */
			contractApp.setContractStatus(Status.CONTRACT_STATUS_INVALID);//未生效
			contractApp.setAuditingStatus(Status.AUDITING_STATUS_NOUPLOAD);//未上传
			contractApp.setDeadline(requestParam.getDeadline()+"");//我们来决定用户的合同期限
			contractApp.setCreatedTime(DateUtils.getNowDate());
			contractApp.setProviderId(providerApplication.getId());  //申请的id作为providerId的临时id
			contractApp.setExclusiveAuth(requestParam.getExclusiveAuth());//我们来决定用户的合同类型
			contractApp.setUserCenterId(providerApplication.getUserCenterId());
			contractApp.setAssetFamily(requestParam.getAssetFamily());//我们来决定用户的类型
			contractApp.setContractType(Status.CONTRACT_TYPE_BIAOZHUN);
			contractApp.setProviderName(providerApplication.getNameCn()); // 只取中文名字,因为社区只维护了中文名字
			contractApp.setContractZhuti(requestParam.getContractZhuti());//我们来决定用户的签约主体
			contractApp.setContractName("供稿人协议");
			contractApp.setEditRate(requestParam.getEditorialSplitRatio());//编辑类分成比
			contractApp.setCreativeRate(requestParam.getCreativeSplitRatio());//创意分成比

			
			//生成ContractId
			String randomstring=UUIDUtil.generateUUID().substring(28);
			SimpleDateFormat sdf =   new SimpleDateFormat( "yyyyMMdd" );
		    String timestemp = sdf.format(new Date());
		    String contractId="VC-"+timestemp+"-"+randomstring.replace(".", "").toUpperCase();
		    contractApp.setContractId(contractId);
		    requestParam.setContractCode(contractId);
			
			if(requestParam.getAssetFamily() == Status.ASSET_FAMILY_EDIT){//分成比
				contractApp.setEditRate(requestParam.getEditorialSplitRatio());
			}else if(requestParam.getAssetFamily() == Status.ASSET_FAMILY_CREATIVE){
				contractApp.setCreativeRate(requestParam.getCreativeSplitRatio());
			}else if(requestParam.getAssetFamily() == Status.ASSET_FAMILY_MIXED){
				contractApp.setEditRate(requestParam.getEditorialSplitRatio());
				contractApp.setCreativeRate(requestParam.getCreativeSplitRatio());
			}
			this.contractApplicationService.insertSelective(contractApp);
			
			//发送短信和邮件
			//获取申请的时候填入的邮箱和手机号
			List<String> mobileandemial = contactUtil.getMobileAndEmailForNoticeInApplication(providerApplication.getUserCenterId());
			String mobile=mobileandemial.get(0);
			String email =mobileandemial.get(1);
			
			 if(StringUtils.isNotBlank(mobile)){
				 messageUtil.zigePassSMS(mobile,  requestParam.getAssetFamily());
			 }
			 if(StringUtils.isNotBlank(email)){
				 messageUtil.zigePassMail(email, requestParam.getAssetFamily());
			 }
			
			
			 //JSONObject re = this.callBackTo500px(providerApplication, requestParam);
			  this.callBackTo500px(providerApplication, requestParam);
			
			 return RestfulResultFactory.getInstance(200, null,  "操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return new RestfulResult(Status.ERROR,null, fullStackTrace);
		}
	}



	@Override
	@Transactional(rollbackFor = Exception.class)
	public RestfulResult nopassApplication(ProviderApplication providerApplication, ProviderQualification requestParam,
			Integer status, String userId) {
		
		try {
 
			providerApplication.setStatus(status);
			providerApplication.setPasstTime(DateUtils.getNowDate());
			providerApplication.setPassUserId(userId);
			providerApplication.setRejectReason(providerApplication.getRejectReason());
			 this.updateByPrimaryKeySelective(providerApplication);
			
			
			List<String> mobileandemial = contactUtil.getMobileAndEmailForNoticeInApplication(providerApplication.getUserCenterId());
			String mobile=mobileandemial.get(0);
			String email =mobileandemial.get(1);
			
			 if(StringUtils.isNotBlank(mobile)){
				 messageUtil.zigeFailSMS(mobile);
			 }
			 if(StringUtils.isNotBlank(email)){
				 messageUtil.zigeFailMail(email);
			 }
			 
			 //通知社区
			this.callBackTo500px(providerApplication, requestParam);
			return RestfulResultFactory.getInstance(200, null,  "操作成功");
		 
			 
		} catch (IOException e) {
			e.printStackTrace();
			return RestfulResultFactory.getInstance(Status.ERROR, null,  "操作失败");
		}
		 
	}
	
	
	private void callBackTo500px(ProviderApplication providerApplication,ProviderQualification providerQualification){

		String url = notifyservice;

		//providerQualification 是发送合同的时候填写的信息

		JSONObject param = new JSONObject();
		param.put("userCenterId", providerApplication.getUserCenterId());
		param.put("reviewType", "0");                                      /*0:资格审核，1：合同审核*/
		
		JSONObject contractInfo = new JSONObject();
		contractInfo.put("id", providerApplication.getId());
		if(providerQualification.getPass() == 0){
			contractInfo.put("state", 0);
			contractInfo.put("message", "申请失败，原因：" + providerQualification.getReason());
		}else{
			contractInfo.put("state", 1);
			contractInfo.put("message", "申请成功，原因：" + providerQualification.getReason());
		}
		contractInfo.put("accessStatus", providerQualification.getAssetFamily());
		contractInfo.put("contractSubject", providerQualification.getContractZhuti());
		contractInfo.put("exclusiveLicence", providerQualification.getExclusiveAuth());
		contractInfo.put("creativeSplitRatio",providerQualification.getCreativeSplitRatio() );
		contractInfo.put("editorialSplitRatio",providerQualification.getEditorialSplitRatio());
		contractInfo.put("contractPeriod",providerQualification.getDeadline());
		contractInfo.put("contractCode",providerQualification.getContractCode());
		
		param.put("contractInfo", contractInfo);

		//RestTemplate rs = new RestTemplate();

		/*社区回调*/

		redisUtil.putContractApplication(providerApplication.getUserCenterId(),param);
		
		
//		JSONObject re = rs.postForObject(url, param, JSONObject.class);
//
//		return re;
		}

}