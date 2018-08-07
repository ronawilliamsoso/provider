package com.vcg.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.ResourceUpload;
import com.vcg.provider.model.query.ResourceUploadExample;
import com.vcg.provider.dao.ResourceUploadDao;
import com.vcg.provider.service.ResourceUploadService;

@Service
public class ResourceUploadServiceImpl extends BaseServiceImpl<ResourceUpload,ResourceUploadExample,Integer> implements ResourceUploadService {

	@Autowired
	private ResourceUploadDao resourceUploadDao;

	@Override
	public void setDao() {
		this.baseDao = resourceUploadDao;
	}

}