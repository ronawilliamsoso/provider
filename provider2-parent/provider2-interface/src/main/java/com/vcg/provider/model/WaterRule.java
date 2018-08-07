package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class WaterRule extends BaseModel<WaterRule> {
    private static final long serialVersionUID = 1104836034696061043L;

    /**  */
    @ApiModelProperty(value = "")
    private Integer id;

    /** 供应商id */
    @ApiModelProperty(value = "供应商id")
    private Integer providerId;

    /** 品牌id */
    @ApiModelProperty(value = "品牌id")
    private Integer collectionId;

    /**  */
    @ApiModelProperty(value = "")
    private String chineseName;

    /**  */
    @ApiModelProperty(value = "")
    private String waterId;

    /**  */
    @ApiModelProperty(value = "")
    private Integer status;

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

    public WaterRule setId(Integer id) {
        this.id = id;
		return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public WaterRule setProviderId(Integer providerId) {
        this.providerId = providerId;
		return this;
    }

    public Integer getCollectionId() {
        return collectionId;
    }

    public WaterRule setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
		return this;
    }

    public String getChineseName() {
        return chineseName;
    }

    public WaterRule setChineseName(String chineseName) {
        this.chineseName = chineseName == null ? null : chineseName.trim();
		return this;
    }

    public String getWaterId() {
        return waterId;
    }

    public WaterRule setWaterId(String waterId) {
        this.waterId = waterId == null ? null : waterId.trim();
		return this;
    }

    public Integer getStatus() {
        return status;
    }

    public WaterRule setStatus(Integer status) {
        this.status = status;
		return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public WaterRule setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
		return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public WaterRule setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
		return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public WaterRule setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
		return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public WaterRule setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
		return this;
    }
}
