package com.vcg.provider.service ;

import java.util.List;

import com.vcg.common.base.BaseService;
import com.vcg.provider.model.Collection;
import com.vcg.provider.model.query.CollectionExample;

public interface CollectionService extends BaseService<Collection,CollectionExample,Integer>{
	/**
	 * Get Collection By providerId
	 * @param providerId
	 * @return If providerId is null or Collection does not exist,return null
	 */
	public List<Collection> getCollectionByProviderId(Integer providerId);
	/**
	 * Get Collection By contractId
	 * @param contractId
	 * @return If contractId is null or Collection does not exist, return null
	 */
	public List<Collection> getCollectionByContractId(Integer contractId);
	
	public List<Collection> getCollectionByContractIdAndProviderId(Integer contractId,Integer providerId);
}