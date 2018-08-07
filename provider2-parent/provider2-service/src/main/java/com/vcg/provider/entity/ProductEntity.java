package com.vcg.provider.entity;

import java.util.ArrayList;
import java.util.List;

import com.vcg.provider.model.Product;

public class ProductEntity extends Product{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3148197271717770382L;
	private List<ProductEntity> list;

	public List<ProductEntity> getList() {
		if(list==null){
			list=new ArrayList<ProductEntity>();
		}
		return list;
	}

	public void setList(List<ProductEntity> list) {
		
		this.list = list;
	}
	
	
}
