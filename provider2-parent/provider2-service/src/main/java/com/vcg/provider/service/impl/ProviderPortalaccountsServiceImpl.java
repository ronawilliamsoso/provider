package com.vcg.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.ProviderPortalaccounts;
import com.vcg.provider.model.query.ProviderPortalaccountsExample;
import com.vcg.provider.dao.ProviderPortalaccountsDao;
import com.vcg.provider.service.ProviderPortalaccountsService;

@Service
public class ProviderPortalaccountsServiceImpl extends BaseServiceImpl<ProviderPortalaccounts,ProviderPortalaccountsExample,Integer> implements ProviderPortalaccountsService {

	@Autowired
	private ProviderPortalaccountsDao providerPortalaccountsDao;

	@Override
	public void setDao() {
		this.baseDao = providerPortalaccountsDao;
	}

}