package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class ProviderAccess extends BaseModel<ProviderAccess> {
    private static final long serialVersionUID = 7433630764099396729L;

    /** 数据库自增 */
    @ApiModelProperty(value = "数据库自增")
    private Integer id;

    /** 供应商表id */
    @ApiModelProperty(value = "供应商表id")
    private Integer providerId;

    /** 1:FTP 2:API 3:其他 */
    @ApiModelProperty(value = "1:FTP 2:API 3:其他")
    private Byte accessType;

    /** 账号 */
    @ApiModelProperty(value = "账号")
    private String userName;

    /** 密码 */
    @ApiModelProperty(value = "密码")
    private String passWord;

    /**  */
    @ApiModelProperty(value = "")
    private String mark;

    /** 服务器地址 */
    @ApiModelProperty(value = "服务器地址")
    private String accessAddress;

    /** ftp目录 */
    @ApiModelProperty(value = "ftp目录")
    private String ftpPath;

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

    public ProviderAccess setId(Integer id) {
        this.id = id;
		return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public ProviderAccess setProviderId(Integer providerId) {
        this.providerId = providerId;
		return this;
    }

    public Byte getAccessType() {
        return accessType;
    }

    public ProviderAccess setAccessType(Byte accessType) {
        this.accessType = accessType;
		return this;
    }

    public String getUserName() {
        return userName;
    }

    public ProviderAccess setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
		return this;
    }

    public String getPassWord() {
        return passWord;
    }

    public ProviderAccess setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
		return this;
    }

    public String getMark() {
        return mark;
    }

    public ProviderAccess setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
		return this;
    }

    public String getAccessAddress() {
        return accessAddress;
    }

    public ProviderAccess setAccessAddress(String accessAddress) {
        this.accessAddress = accessAddress == null ? null : accessAddress.trim();
		return this;
    }

    public String getFtpPath() {
        return ftpPath;
    }

    public ProviderAccess setFtpPath(String ftpPath) {
        this.ftpPath = ftpPath == null ? null : ftpPath.trim();
		return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public ProviderAccess setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
		return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public ProviderAccess setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
		return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public ProviderAccess setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
		return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public ProviderAccess setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
		return this;
    }
}
