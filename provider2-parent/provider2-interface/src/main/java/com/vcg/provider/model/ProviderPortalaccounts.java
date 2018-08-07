package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class ProviderPortalaccounts extends BaseModel<ProviderPortalaccounts> {
    private static final long serialVersionUID = 3984516370198023827L;

    /**  */
    @ApiModelProperty(value = "")
    private Integer id;

    /** 供应商id */
    @ApiModelProperty(value = "供应商id")
    private Integer providerId;

    /** 账号 */
    @ApiModelProperty(value = "账号")
    private String portalAccount;

    /** 显示名字 */
    @ApiModelProperty(value = "显示名字")
    private String displayName;

    /** 用户中心id，创建portal的时候生成的 */
    @ApiModelProperty(value = "用户中心id，创建portal的时候生成的")
    private String userCenterId;

    /** 备注 */
    @ApiModelProperty(value = "备注")
    private String mark;

    /** 邮箱 */
    @ApiModelProperty(value = "邮箱")
    private String email;

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

    public ProviderPortalaccounts setId(Integer id) {
        this.id = id;
		return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public ProviderPortalaccounts setProviderId(Integer providerId) {
        this.providerId = providerId;
		return this;
    }

    public String getPortalAccount() {
        return portalAccount;
    }

    public ProviderPortalaccounts setPortalAccount(String portalAccount) {
        this.portalAccount = portalAccount == null ? null : portalAccount.trim();
		return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public ProviderPortalaccounts setDisplayName(String displayName) {
        this.displayName = displayName == null ? null : displayName.trim();
		return this;
    }

    public String getUserCenterId() {
        return userCenterId;
    }

    public ProviderPortalaccounts setUserCenterId(String userCenterId) {
        this.userCenterId = userCenterId == null ? null : userCenterId.trim();
		return this;
    }

    public String getMark() {
        return mark;
    }

    public ProviderPortalaccounts setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
		return this;
    }

    public String getEmail() {
        return email;
    }

    public ProviderPortalaccounts setEmail(String email) {
        this.email = email == null ? null : email.trim();
		return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public ProviderPortalaccounts setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
		return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public ProviderPortalaccounts setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
		return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public ProviderPortalaccounts setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
		return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public ProviderPortalaccounts setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
		return this;
    }
}
