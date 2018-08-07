package com.vcg.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.ProviderAccess;
import com.vcg.provider.model.query.ProviderAccessExample;
import com.vcg.provider.dao.ProviderAccessDao;
import com.vcg.provider.service.ProviderAccessService;

@Service
public class ProviderAccessServiceImpl extends BaseServiceImpl<ProviderAccess,ProviderAccessExample,Integer> implements ProviderAccessService {

	@Autowired
	private ProviderAccessDao providerAccessDao;

	@Override
	public void setDao() {
		this.baseDao = providerAccessDao;
	}

}