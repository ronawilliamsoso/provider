package com.vcg.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.ContractAuthorization;
import com.vcg.provider.model.query.ContractAuthorizationExample;
import com.vcg.provider.dao.ContractAuthorizationDao;
import com.vcg.provider.service.ContractAuthorizationService;

@Service
public class ContractAuthorizationServiceImpl extends BaseServiceImpl<ContractAuthorization,ContractAuthorizationExample,Integer> implements ContractAuthorizationService {

	@Autowired
	private ContractAuthorizationDao contractAuthorizationDao;

	@Override
	public void setDao() {
		this.baseDao = contractAuthorizationDao;
	}

}