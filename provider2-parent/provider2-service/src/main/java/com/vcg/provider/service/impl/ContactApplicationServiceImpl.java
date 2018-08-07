package com.vcg.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.ContactApplication;
import com.vcg.provider.model.query.ContactApplicationExample;
import com.vcg.provider.dao.ContactApplicationDao;
import com.vcg.provider.service.ContactApplicationService;

@Service
public class ContactApplicationServiceImpl extends BaseServiceImpl<ContactApplication,ContactApplicationExample,Integer> implements ContactApplicationService {

	@Autowired
	private ContactApplicationDao contactApplicationDao;

	@Override
	public void setDao() {
		this.baseDao = contactApplicationDao;
	}

}