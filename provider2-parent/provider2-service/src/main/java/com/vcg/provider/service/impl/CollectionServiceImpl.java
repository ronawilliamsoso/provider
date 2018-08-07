package com.vcg.provider.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.Collection;
import com.vcg.provider.model.query.CollectionExample;
import com.vcg.provider.dao.CollectionDao;
import com.vcg.provider.service.CollectionService;

@Service
public class CollectionServiceImpl extends BaseServiceImpl<Collection,CollectionExample,Integer> implements CollectionService {

	@Autowired
	private CollectionDao collectionDao;

	@Override
	public void setDao() {
		this.baseDao = collectionDao;
	}

	@Override
	public List<Collection> getCollectionByProviderId(Integer providerId) {
		if(providerId != null){
			CollectionExample example = new CollectionExample();
			example.createCriteria().andProviderIdEqualTo(providerId);
			List<Collection> collections = this.collectionDao.selectByExample(example);
			if(CollectionUtils.isNotEmpty(collections)){
				return collections;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	@Override
	public List<Collection> getCollectionByContractId(Integer contractId) {
		if(contractId != null){
			CollectionExample example = new CollectionExample();
			example.createCriteria().andContractIdEqualTo(contractId);
			List<Collection> collections = this.collectionDao.selectByExample(example);
			if(CollectionUtils.isNotEmpty(collections)){
				return collections;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	@Override
	public List<Collection> getCollectionByContractIdAndProviderId(Integer contractId, Integer providerId) {
		if(contractId != null && providerId!=null ){
			CollectionExample example = new CollectionExample();
			example.createCriteria().andContractIdEqualTo(contractId).andProviderIdEqualTo(providerId);
			List<Collection> collections = this.collectionDao.selectByExample(example);
			if(CollectionUtils.isNotEmpty(collections)){
				return collections;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
}