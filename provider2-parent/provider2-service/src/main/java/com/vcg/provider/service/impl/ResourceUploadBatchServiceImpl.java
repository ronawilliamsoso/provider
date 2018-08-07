package com.vcg.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.ResourceUploadBatch;
import com.vcg.provider.model.query.ResourceUploadBatchExample;
import com.vcg.provider.dao.ResourceUploadBatchDao;
import com.vcg.provider.service.ResourceUploadBatchService;

@Service
public class ResourceUploadBatchServiceImpl extends BaseServiceImpl<ResourceUploadBatch,ResourceUploadBatchExample,Integer> implements ResourceUploadBatchService {

	@Autowired
	private ResourceUploadBatchDao resourceUploadBatchDao;

	@Override
	public void setDao() {
		this.baseDao = resourceUploadBatchDao;
	}

}