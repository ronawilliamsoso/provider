package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class ResourceUploadRelease extends BaseModel<ResourceUploadRelease> {
    private static final long serialVersionUID = 2360114998324111881L;

    /** 数据库自增 */
    @ApiModelProperty(value = "数据库自增")
    private Integer id;

    /** 供应商id */
    @ApiModelProperty(value = "供应商id")
    private Integer providerId;

    /** 批次id */
    @ApiModelProperty(value = "批次id")
    private Integer batchId;

    /** 1肖像权2物权 */
    @ApiModelProperty(value = "1肖像权2物权")
    private Integer releaseType;

    /** 文件名,也是meta表里的master_id */
    @ApiModelProperty(value = "文件名,也是meta表里的master_id")
    private String fileName;

    /**  */
    @ApiModelProperty(value = "")
    private String ossPath;

    /** 拍摄日期 */
    @ApiModelProperty(value = "拍摄日期")
    private Date createdTime;

    /**  */
    @ApiModelProperty(value = "")
    private String createdBy;

    /**  */
    @ApiModelProperty(value = "")
    private Date updatedTime;

    /**  */
    @ApiModelProperty(value = "")
    private String updatedBy;

    public Integer getId() {
        return id;
    }

    public ResourceUploadRelease setId(Integer id) {
        this.id = id;
		return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public ResourceUploadRelease setProviderId(Integer providerId) {
        this.providerId = providerId;
		return this;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public ResourceUploadRelease setBatchId(Integer batchId) {
        this.batchId = batchId;
		return this;
    }

    public Integer getReleaseType() {
        return releaseType;
    }

    public ResourceUploadRelease setReleaseType(Integer releaseType) {
        this.releaseType = releaseType;
		return this;
    }

    public String getFileName() {
        return fileName;
    }

    public ResourceUploadRelease setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
		return this;
    }

    public String getOssPath() {
        return ossPath;
    }

    public ResourceUploadRelease setOssPath(String ossPath) {
        this.ossPath = ossPath == null ? null : ossPath.trim();
		return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public ResourceUploadRelease setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
		return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public ResourceUploadRelease setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
		return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public ResourceUploadRelease setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
		return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public ResourceUploadRelease setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
		return this;
    }
}
