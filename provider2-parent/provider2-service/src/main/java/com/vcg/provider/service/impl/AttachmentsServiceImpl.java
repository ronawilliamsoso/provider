package com.vcg.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.Attachments;
import com.vcg.provider.model.query.AttachmentsExample;
import com.vcg.provider.dao.AttachmentsDao;
import com.vcg.provider.service.AttachmentsService;

@Service
public class AttachmentsServiceImpl extends BaseServiceImpl<Attachments,AttachmentsExample,Integer> implements AttachmentsService {

	@Autowired
	private AttachmentsDao attachmentsDao;

	@Override
	public void setDao() {
		this.baseDao = attachmentsDao;
	}

}