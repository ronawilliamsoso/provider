package com.vcg.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.ContractInfo;
import com.vcg.provider.model.query.ContractInfoExample;
import com.vcg.provider.dao.ContractInfoDao;
import com.vcg.provider.service.ContractInfoService;

@Service
public class ContractInfoServiceImpl extends BaseServiceImpl<ContractInfo,ContractInfoExample,Integer> implements ContractInfoService {

	@Autowired
	private ContractInfoDao contractInfoDao;

	@Override
	public void setDao() {
		this.baseDao = contractInfoDao;
	}

}