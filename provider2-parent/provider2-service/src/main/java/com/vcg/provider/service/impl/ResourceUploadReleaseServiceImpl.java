package com.vcg.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.ResourceUploadRelease;
import com.vcg.provider.model.query.ResourceUploadReleaseExample;
import com.vcg.provider.dao.ResourceUploadReleaseDao;
import com.vcg.provider.service.ResourceUploadReleaseService;

@Service
public class ResourceUploadReleaseServiceImpl extends BaseServiceImpl<ResourceUploadRelease,ResourceUploadReleaseExample,Integer> implements ResourceUploadReleaseService {

	@Autowired
	private ResourceUploadReleaseDao resourceUploadReleaseDao;

	@Override
	public void setDao() {
		this.baseDao = resourceUploadReleaseDao;
	}

}