package com.vcg.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.ResourceSellFromBoss;
import com.vcg.provider.model.query.ResourceSellFromBossExample;
import com.vcg.provider.dao.ResourceSellFromBossDao;
import com.vcg.provider.service.ResourceSellFromBossService;

@Service
public class ResourceSellFromBossServiceImpl extends BaseServiceImpl<ResourceSellFromBoss,ResourceSellFromBossExample,String> implements ResourceSellFromBossService {

	@Autowired
	private ResourceSellFromBossDao resourceSellFromBossDao;

	@Override
	public void setDao() {
		this.baseDao = resourceSellFromBossDao;
	}

}