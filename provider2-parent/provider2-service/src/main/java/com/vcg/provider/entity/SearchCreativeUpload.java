package com.vcg.provider.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SearchCreativeUpload {
	/*资源类型*/
	@ApiModelProperty(required=true,value="资源类型：1摄影图片 2 插画绘画 5矢量图 6: meta表 7:授权文件-肖像权 8:授权文件-物权")
	private Integer fileType;
	
	@ApiModelProperty(required=true,value="批次id,如268")
	private Integer batchId;
	
	@ApiModelProperty(required=true,value="供应商id 如 419519")
	private Integer providerId;
	/*当前页*/
	@ApiModelProperty(required=true,value="当前页码")
	private Integer pageNum;
	/*页大小*/
	@ApiModelProperty(required=true,value="每页记录数")
	private Integer pageSize;
	
	
	public Integer getProviderId() {
		return providerId;
	}
	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}
	public Integer getFileType() {
		return fileType;
	}
	public void setFileType(Integer fileType) {
		this.fileType = fileType;
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
	public Integer getBatchId() {
		return batchId;
	}
	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}
	
	 
	
}
