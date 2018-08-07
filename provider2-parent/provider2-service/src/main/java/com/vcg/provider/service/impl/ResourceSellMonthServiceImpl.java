package com.vcg.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.ResourceSellMonth;
import com.vcg.provider.model.query.ResourceSellMonthExample;
import com.vcg.provider.dao.ResourceSellMonthDao;
import com.vcg.provider.service.ResourceSellMonthService;

@Service
public class ResourceSellMonthServiceImpl extends BaseServiceImpl<ResourceSellMonth,ResourceSellMonthExample,Integer> implements ResourceSellMonthService {

	@Autowired
	private ResourceSellMonthDao resourceSellMonthDao;

	@Override
	public void setDao() {
		this.baseDao = resourceSellMonthDao;
	}

}