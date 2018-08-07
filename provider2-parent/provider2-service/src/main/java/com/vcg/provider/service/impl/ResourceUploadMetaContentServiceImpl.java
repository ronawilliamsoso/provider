package com.vcg.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.ResourceUploadMetaContent;
import com.vcg.provider.model.query.ResourceUploadMetaContentExample;
import com.vcg.provider.dao.ResourceUploadMetaContentDao;
import com.vcg.provider.service.ResourceUploadMetaContentService;

@Service
public class ResourceUploadMetaContentServiceImpl extends BaseServiceImpl<ResourceUploadMetaContent,ResourceUploadMetaContentExample,Integer> implements ResourceUploadMetaContentService {

	@Autowired
	private ResourceUploadMetaContentDao resourceUploadMetaContentDao;

	@Override
	public void setDao() {
		this.baseDao = resourceUploadMetaContentDao;
	}

}