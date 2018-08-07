package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class ProviderValidateError extends BaseModel<ProviderValidateError> {
    private static final long serialVersionUID = 7121851786054889933L;

    /**  */
    @ApiModelProperty(value = "")
    private Integer id;

    /**  */
    @ApiModelProperty(value = "")
    private Integer providerId;

    /** 批次 */
    @ApiModelProperty(value = "批次")
    private Integer batchId;

    /**  */
    @ApiModelProperty(value = "")
    private String fileName;

    /**  */
    @ApiModelProperty(value = "")
    private String providerResId;

    /**  */
    @ApiModelProperty(value = "")
    private String errorMsg;

    /**  */
    @ApiModelProperty(value = "")
    private Integer assetFormat;

    /**  */
    @ApiModelProperty(value = "")
    private Integer validateType;

    /**  */
    @ApiModelProperty(value = "")
    private String ossUrl;

    /**  */
    @ApiModelProperty(value = "")
    private String memo;

    /**  */
    @ApiModelProperty(value = "")
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

    public ProviderValidateError setId(Integer id) {
        this.id = id;
		return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public ProviderValidateError setProviderId(Integer providerId) {
        this.providerId = providerId;
		return this;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public ProviderValidateError setBatchId(Integer batchId) {
        this.batchId = batchId;
		return this;
    }

    public String getFileName() {
        return fileName;
    }

    public ProviderValidateError setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
		return this;
    }

    public String getProviderResId() {
        return providerResId;
    }

    public ProviderValidateError setProviderResId(String providerResId) {
        this.providerResId = providerResId == null ? null : providerResId.trim();
		return this;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public ProviderValidateError setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg == null ? null : errorMsg.trim();
		return this;
    }

    public Integer getAssetFormat() {
        return assetFormat;
    }

    public ProviderValidateError setAssetFormat(Integer assetFormat) {
        this.assetFormat = assetFormat;
		return this;
    }

    public Integer getValidateType() {
        return validateType;
    }

    public ProviderValidateError setValidateType(Integer validateType) {
        this.validateType = validateType;
		return this;
    }

    public String getOssUrl() {
        return ossUrl;
    }

    public ProviderValidateError setOssUrl(String ossUrl) {
        this.ossUrl = ossUrl == null ? null : ossUrl.trim();
		return this;
    }

    public String getMemo() {
        return memo;
    }

    public ProviderValidateError setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
		return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public ProviderValidateError setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
		return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public ProviderValidateError setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
		return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public ProviderValidateError setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
		return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public ProviderValidateError setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
		return this;
    }
}
