package com.vcg.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.ResourceUploadMeta;
import com.vcg.provider.model.query.ResourceUploadMetaExample;
import com.vcg.provider.dao.ResourceUploadMetaDao;
import com.vcg.provider.service.ResourceUploadMetaService;

@Service
public class ResourceUploadMetaServiceImpl extends BaseServiceImpl<ResourceUploadMeta,ResourceUploadMetaExample,Integer> implements ResourceUploadMetaService {

	@Autowired
	private ResourceUploadMetaDao resourceUploadMetaDao;

	@Override
	public void setDao() {
		this.baseDao = resourceUploadMetaDao;
	}

}