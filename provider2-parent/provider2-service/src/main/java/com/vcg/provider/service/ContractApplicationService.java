package com.vcg.provider.service ;

import com.vcg.common.RestfulResult;
import com.vcg.common.base.BaseService;
import com.vcg.provider.entity.ContractApporive;
import com.vcg.provider.model.ContractApplication;
import com.vcg.provider.model.query.ContractApplicationExample;

public interface ContractApplicationService extends BaseService<ContractApplication,ContractApplicationExample,Integer>{
	
	
	
	public RestfulResult passContract(ContractApporive contractApporive, ContractApplication contractApplication,Integer status,String userId);

	public RestfulResult noPassContract(ContractApporive contractApporive, ContractApplication contractApplication);
}