package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class ProviderAccount extends BaseModel<ProviderAccount> {
    private static final long serialVersionUID = 6306388024472383942L;

    /**  */
    @ApiModelProperty(value = "")
    private Integer id;

    /**  */
    @ApiModelProperty(value = "")
    private Integer providerId;

    /**  */
    @ApiModelProperty(value = "")
    private String providerAddress;

    /** 客户给我们的他们的网站的账号 */
    @ApiModelProperty(value = "客户给我们的他们的网站的账号")
    private String userAccount;

    /** 客户给我们的他们的网站的密码 */
    @ApiModelProperty(value = "客户给我们的他们的网站的密码")
    private String userPassword;

    /** 备注 */
    @ApiModelProperty(value = "备注")
    private String mark;

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

    public ProviderAccount setId(Integer id) {
        this.id = id;
		return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public ProviderAccount setProviderId(Integer providerId) {
        this.providerId = providerId;
		return this;
    }

    public String getProviderAddress() {
        return providerAddress;
    }

    public ProviderAccount setProviderAddress(String providerAddress) {
        this.providerAddress = providerAddress == null ? null : providerAddress.trim();
		return this;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public ProviderAccount setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
		return this;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public ProviderAccount setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
		return this;
    }

    public String getMark() {
        return mark;
    }

    public ProviderAccount setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
		return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public ProviderAccount setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
		return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public ProviderAccount setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
		return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public ProviderAccount setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
		return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public ProviderAccount setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
		return this;
    }
}
