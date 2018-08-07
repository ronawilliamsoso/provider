package com.vcg.provider.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SearchCollection {
 
 
	@ApiModelProperty(required=false,value="机构名,或者brand名,或者collection名  ")
	private String searchName;
	
	@ApiModelProperty(required=false,value="1:查机构名,如'王威雪敏' 2:查brand名,如Aurora 3:查collection名,如:'Sino Images' 4:供应商id 5:brand Id 6:collectionId 7:合同id 8:合同名称")
	private Integer searchType;
 
	@ApiModelProperty(required=true,value="当前页码")
	private Integer pageNum=0;
 
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
