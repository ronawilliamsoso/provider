package com.vcg.provider.service ;


import com.vcg.common.RestfulResult;
import com.vcg.common.base.BaseService;
import com.vcg.provider.model.ContactApplication;
import com.vcg.provider.model.ContractApplication;
import com.vcg.provider.model.Provider;
import com.vcg.provider.model.ProviderApplication;
import com.vcg.provider.model.UploadContract;
import com.vcg.provider.model.query.ProviderExample;

public interface MeService extends BaseService<Provider,ProviderExample,Integer>{
 
	
	/**
	 * 增加机构合同
	 * */
	public RestfulResult addMeContract(UploadContract uploadContract,ContactApplication contactApplication,ContractApplication contractApplication,ProviderApplication providerApplication);
}