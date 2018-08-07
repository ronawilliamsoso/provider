package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class ProviderMessage extends BaseModel<ProviderMessage> {
    private static final long serialVersionUID = 949429840726592234L;

    /** 数据库自增 */
    @ApiModelProperty(value = "数据库自增")
    private Integer id;

    /** 供应商表id */
    @ApiModelProperty(value = "供应商表id")
    private Integer providerId;

    /** 消息标题 */
    @ApiModelProperty(value = "消息标题")
    private String messageTitle;

    /** 消息体 */
    @ApiModelProperty(value = "消息体")
    private String messgeContent;

    /** 是否已经阅读 1:是 0:否 */
    @ApiModelProperty(value = "是否已经阅读 1:是 0:否")
    private Integer isRead;

    /** 收到日期 */
    @ApiModelProperty(value = "收到日期")
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

    public ProviderMessage setId(Integer id) {
        this.id = id;
		return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public ProviderMessage setProviderId(Integer providerId) {
        this.providerId = providerId;
		return this;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public ProviderMessage setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle == null ? null : messageTitle.trim();
		return this;
    }

    public String getMessgeContent() {
        return messgeContent;
    }

    public ProviderMessage setMessgeContent(String messgeContent) {
        this.messgeContent = messgeContent == null ? null : messgeContent.trim();
		return this;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public ProviderMessage setIsRead(Integer isRead) {
        this.isRead = isRead;
		return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public ProviderMessage setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
		return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public ProviderMessage setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
		return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public ProviderMessage setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
		return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public ProviderMessage setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
		return this;
    }
}
