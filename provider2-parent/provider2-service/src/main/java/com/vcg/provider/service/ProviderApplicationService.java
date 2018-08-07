package com.vcg.provider.service ;

import com.vcg.common.RestfulResult;
import com.vcg.common.base.BaseService;
import com.vcg.provider.entity.ProviderQualification;
import com.vcg.provider.model.ProviderApplication;
import com.vcg.provider.model.query.ProviderApplicationExample;

public interface ProviderApplicationService extends BaseService<ProviderApplication,ProviderApplicationExample,Integer>{
	
	/**
	 * 通过资格审核
	 * */
	public RestfulResult passApplication(ProviderApplication providerApplication ,ProviderQualification requestParam,Integer status,String userId);
	
	/**
	 * 不通过资格审核
	 * */
	public RestfulResult nopassApplication(ProviderApplication providerApplication ,ProviderQualification requestParam,Integer status,String userId);

}