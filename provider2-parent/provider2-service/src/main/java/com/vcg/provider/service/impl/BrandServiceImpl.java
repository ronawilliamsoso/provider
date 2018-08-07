package com.vcg.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.Brand;
import com.vcg.provider.model.query.BrandExample;
import com.vcg.provider.dao.BrandDao;
import com.vcg.provider.service.BrandService;

@Service
public class BrandServiceImpl extends BaseServiceImpl<Brand,BrandExample,Integer> implements BrandService {

	@Autowired
	private BrandDao brandDao;

	@Override
	public void setDao() {
		this.baseDao = brandDao;
	}

}