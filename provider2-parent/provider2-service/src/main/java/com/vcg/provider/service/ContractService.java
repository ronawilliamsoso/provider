package com.vcg.provider.service ;

import java.util.List;

import com.vcg.common.base.BaseService;
import com.vcg.provider.model.Contract;
import com.vcg.provider.model.query.ContractExample;

public interface ContractService extends BaseService<Contract,ContractExample,Integer>{
	/**
	 * Get Contract By providerId
	 * @param providerId
	 * @return If providerId is null or contract does not exist,return null
	 */
	public List<Contract> getContractByProviderId(Integer providerId);
}