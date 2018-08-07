package com.vcg.provider.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
 

@ApiModel
public class ReportConfirm {

    /** 月份 */
    @ApiModelProperty(value = "月份")
    private String reportMonth;

    /** 是否已经发布 0:否 1:是 */
    @ApiModelProperty(value = "是否已经发布 0:否 1:是")
    private Integer isPublished;
    
    /** 报表已确认  0:否 1:是 */
    @ApiModelProperty(value = "报表已确认  0:否 1:是")
    private Integer isConfirmed;

    /** 供应商表id */
    @ApiModelProperty(value = "供应商表id")
    private Integer providerId;

    /** 供应商名字 */
    @ApiModelProperty(value = "供应商名字")
    private String providerName;
     
    /** 显示在网站上的合同名字,不是合同表里的 */
    @ApiModelProperty(value = "显示在网站上的合同名字,不是合同表里的")
    private String contractName;
    
    
    
    /** 页 */
    @ApiModelProperty(value = "第几页,从1开始")
    private Integer pageNum;
    
    /** 每页多少条 */
    @ApiModelProperty(value = "每页的大小")
    private Integer pageSize;

	public String getReportMonth() {
		return reportMonth;
	}

	public void setReportMonth(String reportMonth) {
		this.reportMonth = reportMonth;
	}
 

	public Integer getIsPublished() {
		return isPublished;
	}

	public void setIsPublished(Integer isPublished) {
		this.isPublished = isPublished;
	}

	public Integer getIsConfirmed() {
		return isConfirmed;
	}

	public void setIsConfirmed(Integer isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
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
