package com.vcg.provider.service ;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.vcg.common.RestfulResult;
import com.vcg.common.base.BaseService;
import com.vcg.provider.entity.AddJigouContract;
import com.vcg.provider.entity.AddJigouProvider;
import com.vcg.provider.model.Provider;
import com.vcg.provider.model.query.ProviderExample;

public interface ProviderService extends BaseService<Provider,ProviderExample,Integer>{
	/**
	 * Get provider By userCenterId
	 * @param userCenterId 用户中心ID
	 * @return if userCenterId is null, empty or provider does not exist,return null
	 */
	public List<Provider> getProviderByUserCenterId(String userCenterId);
	
	/**
	 * 增加机构
	 * @throws IOException 
	 * */
	public RestfulResult addJigou(AddJigouProvider addJigouProvider,String userId);
	
	/**
	 * 增加机构合同
	 * */
	public RestfulResult addJigouContract(AddJigouContract hetong,String userId);
}