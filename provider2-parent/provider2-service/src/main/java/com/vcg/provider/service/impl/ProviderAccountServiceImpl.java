package com.vcg.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.ProviderAccount;
import com.vcg.provider.model.query.ProviderAccountExample;
import com.vcg.provider.dao.ProviderAccountDao;
import com.vcg.provider.service.ProviderAccountService;

@Service
public class ProviderAccountServiceImpl extends BaseServiceImpl<ProviderAccount,ProviderAccountExample,Integer> implements ProviderAccountService {

	@Autowired
	private ProviderAccountDao providerAccountDao;

	@Override
	public void setDao() {
		this.baseDao = providerAccountDao;
	}

}