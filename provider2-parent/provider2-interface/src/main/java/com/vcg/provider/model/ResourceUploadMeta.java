package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class ResourceUploadMeta extends BaseModel<ResourceUploadMeta> {
    private static final long serialVersionUID = 7448255959059749344L;

    /** 数据库自增 */
    @ApiModelProperty(value = "数据库自增")
    private Integer id;

    /** 带扩展名的文件名 */
    @ApiModelProperty(value = "带扩展名的文件名")
    private String fileName;

    /** 供应商id */
    @ApiModelProperty(value = "供应商id")
    private Integer providerId;

    /** 批次id */
    @ApiModelProperty(value = "批次id")
    private Integer batchId;

    /** oss地址 */
    @ApiModelProperty(value = "oss地址")
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

    public ResourceUploadMeta setId(Integer id) {
        this.id = id;
		return this;
    }

    public String getFileName() {
        return fileName;
    }

    public ResourceUploadMeta setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
		return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public ResourceUploadMeta setProviderId(Integer providerId) {
        this.providerId = providerId;
		return this;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public ResourceUploadMeta setBatchId(Integer batchId) {
        this.batchId = batchId;
		return this;
    }

    public String getOssPath() {
        return ossPath;
    }

    public ResourceUploadMeta setOssPath(String ossPath) {
        this.ossPath = ossPath == null ? null : ossPath.trim();
		return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public ResourceUploadMeta setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
		return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public ResourceUploadMeta setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
		return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public ResourceUploadMeta setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
		return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public ResourceUploadMeta setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
		return this;
    }
}
