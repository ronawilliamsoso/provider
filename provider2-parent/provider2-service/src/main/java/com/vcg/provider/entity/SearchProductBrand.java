package com.vcg.provider.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SearchProductBrand {
 
 
 
	@ApiModelProperty(required=false,value="1:Brand名字  2:Brand id")
	private Integer searchType;
 
	@ApiModelProperty(required=false,value=" Brand名字   Brand id")
	private String searchName;
	 
	/*当前页*/
	@ApiModelProperty(required=true,value="当前页码")
	private Integer pageNum;
	/*页大小*/
	@ApiModelProperty(required=true,value="每页记录数")
	private Integer pageSize;
	
	 
	public Integer getSearchType() {
		return searchType;
	}
	public void setSearchType(Integer searchType) {
		this.searchType = searchType;
	}
	 
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
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
