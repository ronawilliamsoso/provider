package com.vcg.provider.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SearchBatch {

	
	
	@ApiModelProperty(required=true,value="批次状态 1:新建 2:已匹配  3:已提交 4:已统计")
	private Integer batchStatus;
	
	@ApiModelProperty(required=false,value="批次名字")
	private String searchName;
	
	@ApiModelProperty(required=true,value="提交时间 ")
	private String submitTime;
	
	@ApiModelProperty(required=true,value="供应商id")
	private Integer providerId;
	/*当前页*/
	@ApiModelProperty(required=true,value="当前页码")
	private Integer pageNum;
	/*页大小*/
	@ApiModelProperty(required=true,value="每页记录数")
	private Integer pageSize;
	
	
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public Integer getBatchStatus() {
		return batchStatus;
	}
	public void setBatchStatus(Integer batchStatus) {
		this.batchStatus = batchStatus;
	}
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public Integer getProviderId() {
		return providerId;
	}
	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
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
