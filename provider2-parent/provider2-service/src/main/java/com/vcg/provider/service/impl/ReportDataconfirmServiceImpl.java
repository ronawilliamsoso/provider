package com.vcg.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.ReportDataconfirm;
import com.vcg.provider.model.query.ReportDataconfirmExample;
import com.vcg.provider.dao.ReportDataconfirmDao;
import com.vcg.provider.service.ReportDataconfirmService;

@Service
public class ReportDataconfirmServiceImpl extends BaseServiceImpl<ReportDataconfirm,ReportDataconfirmExample,Integer> implements ReportDataconfirmService {

	@Autowired
	private ReportDataconfirmDao reportDataconfirmDao;

	@Override
	public void setDao() {
		this.baseDao = reportDataconfirmDao;
	}

}