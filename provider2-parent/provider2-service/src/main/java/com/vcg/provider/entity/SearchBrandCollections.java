package com.vcg.provider.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SearchBrandCollections {
 
	
	@ApiModelProperty(required=true,value=" 授权客户类型1:RM2:RF3: RR")
	private Integer licenseType;
	
	@ApiModelProperty(required=true,value=" 1编辑类2创意类")
	private Integer assetFamily;
	
	@ApiModelProperty(required=true,value="媒资类型1图片2视频3音频")
	private Integer assetType;
	
	@ApiModelProperty(required=true,value="brand的id,必填")
	private Integer brandId;
	
	@ApiModelProperty(required=false,value="collectionId  collection 名字 供应商id 供应商名称")
	private String searchName;
	
	@ApiModelProperty(required=false,value="1:collectionId  2:collection 名字 3:供应商id 4:供应商名称")
	private Integer searchType;
 
	@ApiModelProperty(required=true,value="当前页码")
	private Integer pageNum=0;
 
	@ApiModelProperty(required=true,value="每页记录数")
	private Integer pageSize;

	
	
	
	public Integer getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(Integer licenseType) {
		this.licenseType = licenseType;
	}

	public Integer getAssetFamily() {
		return assetFamily;
	}

	public void setAssetFamily(Integer assetFamily) {
		this.assetFamily = assetFamily;
	}

	public Integer getAssetType() {
		return assetType;
	}

	public void setAssetType(Integer assetType) {
		this.assetType = assetType;
	}

 

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
