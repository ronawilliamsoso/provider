package com.vcg.provider.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.StringUtil;
import com.vcg.boss.util.CollectionUtils;
import com.vcg.common.DateUtils;
import com.vcg.common.RestfulResult;
import com.vcg.common.Status;
import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.Contact;
import com.vcg.provider.model.Contract;
import com.vcg.provider.model.ContractAuthorization;
import com.vcg.provider.model.Provider;
import com.vcg.provider.model.ProviderAccess;
import com.vcg.provider.model.ProviderAccount;
import com.vcg.provider.model.ProviderPayment;
import com.vcg.provider.model.ProviderPortalaccounts;
import com.vcg.provider.model.query.ProviderExample;
import com.vcg.provider.dao.ProviderDao;
import com.vcg.provider.entity.AddJigouContract;
import com.vcg.provider.entity.AddJigouProvider;
import com.vcg.provider.service.CollectionService;
import com.vcg.provider.service.ContactService;
import com.vcg.provider.service.ContractApplicationService;
import com.vcg.provider.service.ContractAuthorizationService;
import com.vcg.provider.service.ContractService;
import com.vcg.provider.service.ProviderAccessService;
import com.vcg.provider.service.ProviderAccountService;
import com.vcg.provider.service.ProviderPaymentService;
import com.vcg.provider.service.ProviderPortalaccountsService;
import com.vcg.provider.service.ProviderService;
import com.vcg.provider.util.AccountUtil;
import com.vcg.provider.util.MessageUtil;
import com.vcg.provider.util.UUIDUtil;
import com.vcg.uc.feignClient.PassportClient;
import com.vcg.uc.model.User;

@Service
public class ProviderServiceImpl extends BaseServiceImpl<Provider,ProviderExample,Integer> implements ProviderService {

	@Autowired
	private ProviderDao providerDao;
	
	@Override
	public void setDao() {
		this.baseDao = providerDao;
	}
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private ProviderPaymentService providerPaymentService;
	
	@Value("${mepx.notifyservice}")
	private String notifyservice;
	
	
	@Autowired
	private ProviderAccessService providerAccessService;
	
	@Autowired
	private ProviderAccountService providerAccountService;
	
	@Autowired
	private PassportClient passportClient;
	
	@Autowired
	private ProviderPortalaccountsService providerPortalService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@Autowired
	private ContractService contractService;
	
	@Autowired
	private ContractAuthorizationService contractAuthorizationService;



	@Override
	public List<Provider> getProviderByUserCenterId(String userCenterId) {
		if(StringUtil.isNotEmpty(userCenterId)){
			ProviderExample example = new ProviderExample();
			example.createCriteria().andUserCenterIdEqualTo(userCenterId);
			List<Provider> list = this.providerDao.selectByExample(example);
			if(CollectionUtils.notEmpty(list)){
				return list;
			}else{
				return null;
			}
		}else{
			return null;
		}
		
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public RestfulResult addJigou(AddJigouProvider jigou,String userId)  {


		try {
			Provider provider = new Provider();
			provider.setCity(jigou.getCity());
			provider.setComment(jigou.getComment());
			provider.setCountry(jigou.getCountry());
			provider.setLocation(jigou.getLocation());
			provider.setNameCn(jigou.getNameCn());
			provider.setProvince(jigou.getProvince());
			provider.setQualityRank(jigou.getQualityRank());
			provider.setShortName(jigou.getShortName());
			provider.setAgentType(1);//机构
			provider.setStatus(3);//1 有效
			provider.setAssetFamily(jigou.getAttribute());
			provider.setLicencePic(jigou.getOperationLicencepic());
			provider.setTaxPic(jigou.getTaxRegistrationpic());
			provider.setCreatedBy(userId);
			provider.setCreatedTime(DateUtils.getNowDate());
			provider.setIsNative(jigou.getIsNative());
			this.providerDao.insert(provider);
			
			Integer providerId = provider.getId();
			
			//这机构的联系人
			if(jigou.getContactList()!=null && jigou.getContactList().size()>0){
				for(Contact contact:jigou.getContactList()){
					contact.setProviderId(providerId);
				}
				contactService.insertBatch(jigou.getContactList());
			}
			
			//这个机构给我们的连入他们系统的网站或者API的用户名和密码
			if(jigou.getAccessList()!=null && jigou.getAccessList().size()>0){
				for(ProviderAccess providerAccess:jigou.getAccessList()){
					providerAccess.setProviderId(providerId);
				}
				providerAccessService.insertBatch(jigou.getAccessList());
			}
			//机构提供给我们的他们的网站的登录名密码
			if(jigou.getAccountList() !=null && jigou.getAccountList().size()>0){
				for(ProviderAccount providerAccount:jigou.getAccountList()){
					providerAccount.setProviderId(providerId);
				}
				providerAccountService.insertBatch(jigou.getAccountList());
			}
			//支付方式
			if(jigou.getBankList()!=null && jigou.getBankList().size()>0){
				for(ProviderPayment contractPay:jigou.getBankList()){
					contractPay.setProviderId(providerId);
					contractPay.setCreatedTime(DateUtils.getNowDate());
				}
				providerPaymentService.insertBatch(jigou.getBankList());
			}
			//我们提供给机构的多个账户密码,用来登录portal系统看账单和上传发票
			if(jigou.getPortalaccList()!=null && jigou.getPortalaccList().size()>0){
				for(ProviderPortalaccounts providerPortalaccounts:jigou.getPortalaccList()){
					providerPortalaccounts.setProviderId(providerId);
					
					//String password = UUIDUtil.generateUUID().replaceAll("-", "").substring(26);
					String password = "123456";
					String userCenterId =  UUIDUtil.generateUUID();
					providerPortalaccounts.setUserCenterId(userCenterId);
					User user = new User();
					user.setUserName(providerPortalaccounts.getPortalAccount());
					user.setEmail(providerPortalaccounts.getEmail());
					user.setPassword(password);//默认密码  入用户中心的时候会再加密
					user.setRegTime(new Date());
					user.setUserId(userCenterId);//用户中心id
					user.setModifyTime(new Date());
					user.setStatus(1);//1有效0无效
					user.setUserType(1);//帐号类型:0-个人,1企业,2部门
					passportClient.register(user);//增加用户
					messageUtil.portalAccountMail(providerPortalaccounts.getEmail(),providerPortalaccounts.getPortalAccount(), password);

					
				}
				providerPortalService.insertBatch(jigou.getPortalaccList() );
			}
			return new RestfulResult(200,null, "ok");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String error= org.apache.commons.lang.exception.ExceptionUtils.getStackTrace(e) ;
			
			return new RestfulResult(Status.ERROR,null, error);
		}
 
	 
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public RestfulResult addJigouContract(AddJigouContract hetong, String userId) {
		// TODO Auto-generated method stub
		
		
		try {
			Contract contract = new Contract();
			contract.setPartyA(hetong.getAgentName());//代理方 甲方
			contract.setPartyB(hetong.getProviderName());//授权方 乙方
			contract.setBond(hetong.getBond());
			contract.setContractName(hetong.getContractName());
			contract.setContractPdfPath(hetong.getContractPdfPath());
			contract.setContractType(hetong.getContractType());
			contract.setDeadline(hetong.getDeadline());
			contract.setBeginDate(hetong.getBeginDate());
			contract.setEndDate(hetong.getEndDate());
			contract.setPaymentId(hetong.getPayId());
			contract.setSettlementCycle(hetong.getSettlementCycle());
			contract.setComment(hetong.getComment());
			contract.setProviderId(hetong.getProviderId());
			contract.setCreatedBy(userId);
			contract.setCreatedTime(DateUtils.getNowDate());
			contract.setContractCode(hetong.getContractCode());
			contract.setContractStatus(1);
			contract.setExclusiveAuth(hetong.getExclusiveAuth());
			contractService.insertSelective(contract);
			Integer contractId = contract.getId();
			
			
			if(hetong.getAuthorizeList()!=null && hetong.getAuthorizeList().size()>0){
				for(ContractAuthorization contractAuthorization: hetong.getAuthorizeList()){
					contractAuthorization.setContractId(contractId);
					contractAuthorization.setProductStatus(1);
					contractAuthorization.setCreatedBy(userId);
					contractAuthorization.setCreatedTime(DateUtils.getNowDate());
					contractAuthorizationService.insert(contractAuthorization);
				}
				 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String error= org.apache.commons.lang.exception.ExceptionUtils.getStackTrace(e) ;
			return new RestfulResult(Status.ERROR,null, error);
		}
		
		
		return new RestfulResult(200,null, "ok");
	}

}