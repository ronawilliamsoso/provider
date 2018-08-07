package com.vcg.provider.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SearchTopic {
 
 
	@ApiModelProperty(required=false,value="专题名称   专题id")
	private String searchName;
	
	@ApiModelProperty(required=false,value="1:专题名称  2:专题id")
	private Integer searchType;
 
 
	@ApiModelProperty(required=true,value="当前页码")
	private Integer pageNum;
 
	@ApiModelProperty(required=true,value="每页记录数")
	private Integer pageSize;

 

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public Integer getSearchType() {
		return searchType;
	}

	public void setSearchType(Integer searchType) {
		this.searchType = searchType;
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
