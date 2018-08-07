package com.vcg.provider.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SearchUploadFail {
	
 
	@ApiModelProperty(required=true,value="1:编辑类 2:创意类")
	private Integer assetFamily;
	
	@ApiModelProperty(required=true,value="批次id,如274")
	private Integer batchId;
	
	@ApiModelProperty(required=true,value="供应商id 如 419519")
	private Integer providerId;
	/*当前页*/
	@ApiModelProperty(required=true,value="当前页码")
	private Integer pageNum;
	/*页大小*/
	@ApiModelProperty(required=true,value="每页记录数")
	private Integer pageSize;
	public Integer getAssetFamily() {
		return assetFamily;
	}
	public void setAssetFamily(Integer assetFamily) {
		this.assetFamily = assetFamily;
	}
	public Integer getBatchId() {
		return batchId;
	}
	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
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
