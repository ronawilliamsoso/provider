package com.vcg.provider.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ViewBrandCollections {
 
 
 
	
	@ApiModelProperty(required=true,value="brand的id")
	private Integer brandId;
 
	@ApiModelProperty(required=true,value="当前页码")
	private Integer pageNum=0;
 
	@ApiModelProperty(required=true,value="每页记录数")
	private Integer pageSize;

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	 
	
	 
	
	 
}
