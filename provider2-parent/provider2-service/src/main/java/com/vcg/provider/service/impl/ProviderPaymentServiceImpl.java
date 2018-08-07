package com.vcg.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.ProviderPayment;
import com.vcg.provider.model.query.ProviderPaymentExample;
import com.vcg.provider.dao.ProviderPaymentDao;
import com.vcg.provider.service.ProviderPaymentService;

@Service
public class ProviderPaymentServiceImpl extends BaseServiceImpl<ProviderPayment,ProviderPaymentExample,Integer> implements ProviderPaymentService {

	@Autowired
	private ProviderPaymentDao providerPaymentDao;

	@Override
	public void setDao() {
		this.baseDao = providerPaymentDao;
	}

}