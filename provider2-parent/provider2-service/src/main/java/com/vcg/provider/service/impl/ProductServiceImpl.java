package com.vcg.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.Product;
import com.vcg.provider.model.query.ProductExample;
import com.vcg.provider.dao.ProductDao;
import com.vcg.provider.service.ProductService;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product,ProductExample,Integer> implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public void setDao() {
		this.baseDao = productDao;
	}

}