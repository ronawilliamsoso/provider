package com.vcg.provider.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.Contract;
import com.vcg.provider.model.query.ContractExample;
import com.vcg.provider.dao.ContractDao;
import com.vcg.provider.service.ContractService;

@Service
public class ContractServiceImpl extends BaseServiceImpl<Contract,ContractExample,Integer> implements ContractService {

	@Autowired
	private ContractDao contractDao;

	@Override
	public void setDao() {
		this.baseDao = contractDao;
	}

	@Override
	public List<Contract> getContractByProviderId(Integer providerId) {
		if(providerId != null){
			ContractExample example = new ContractExample();
			example.createCriteria().andProviderIdEqualTo(providerId);
			List<Contract> contracts = this.contractDao.selectByExample(example);
			if(CollectionUtils.isNotEmpty(contracts)){
				return contracts;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

}