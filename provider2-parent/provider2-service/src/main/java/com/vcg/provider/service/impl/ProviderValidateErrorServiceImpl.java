package com.vcg.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.ProviderValidateError;
import com.vcg.provider.model.query.ProviderValidateErrorExample;
import com.vcg.provider.dao.ProviderValidateErrorDao;
import com.vcg.provider.service.ProviderValidateErrorService;

@Service
public class ProviderValidateErrorServiceImpl extends BaseServiceImpl<ProviderValidateError,ProviderValidateErrorExample,Integer> implements ProviderValidateErrorService {

	@Autowired
	private ProviderValidateErrorDao providerValidateErrorDao;

	@Override
	public void setDao() {
		this.baseDao = providerValidateErrorDao;
	}

}