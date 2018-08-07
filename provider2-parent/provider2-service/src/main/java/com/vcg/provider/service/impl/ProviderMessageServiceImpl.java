package com.vcg.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.ProviderMessage;
import com.vcg.provider.model.query.ProviderMessageExample;
import com.vcg.provider.dao.ProviderMessageDao;
import com.vcg.provider.service.ProviderMessageService;

@Service
public class ProviderMessageServiceImpl extends BaseServiceImpl<ProviderMessage,ProviderMessageExample,Integer> implements ProviderMessageService {

	@Autowired
	private ProviderMessageDao providerMessageDao;

	@Override
	public void setDao() {
		this.baseDao = providerMessageDao;
	}

}