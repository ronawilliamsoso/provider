package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class ResourceUploadBatch extends BaseModel<ResourceUploadBatch> {
    private static final long serialVersionUID = 6060880742211865122L;

    /** 数据库自增 */
    @ApiModelProperty(value = "数据库自增")
    private Integer id;

    /** 批次名称 */
    @ApiModelProperty(value = "批次名称")
    private String batchName;

    /** 供应商id */
    @ApiModelProperty(value = "供应商id")
    private Integer providerId;

    /** 批次状态 1:新建 2:已入库 */
    @ApiModelProperty(value = "批次状态 1:新建 2:已入库")
    private Integer batchStatus;

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    /** 提交时间 */
    @ApiModelProperty(value = "提交时间")
    private Date submitTime;

    public Integer getId() {
        return id;
    }

    public ResourceUploadBatch setId(Integer id) {
        this.id = id;
		return this;
    }

    public String getBatchName() {
        return batchName;
    }

    public ResourceUploadBatch setBatchName(String batchName) {
        this.batchName = batchName == null ? null : batchName.trim();
		return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public ResourceUploadBatch setProviderId(Integer providerId) {
        this.providerId = providerId;
		return this;
    }

    public Integer getBatchStatus() {
        return batchStatus;
    }

    public ResourceUploadBatch setBatchStatus(Integer batchStatus) {
        this.batchStatus = batchStatus;
		return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public ResourceUploadBatch setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
		return this;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public ResourceUploadBatch setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
		return this;
    }
}
