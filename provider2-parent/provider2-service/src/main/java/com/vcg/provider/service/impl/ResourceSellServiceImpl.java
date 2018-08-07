package com.vcg.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.ResourceSell;
import com.vcg.provider.model.query.ResourceSellExample;
import com.vcg.provider.dao.ResourceSellDao;
import com.vcg.provider.service.ResourceSellService;

@Service
public class ResourceSellServiceImpl extends BaseServiceImpl<ResourceSell,ResourceSellExample,Integer> implements ResourceSellService {

	@Autowired
	private ResourceSellDao resourceSellDao;

	@Override
	public void setDao() {
		this.baseDao = resourceSellDao;
	}

}