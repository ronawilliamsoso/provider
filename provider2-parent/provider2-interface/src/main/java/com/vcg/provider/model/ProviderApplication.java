package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class ProviderApplication extends BaseModel<ProviderApplication> {
    private static final long serialVersionUID = 1944797235580988607L;

    /** 申请ID,这个id会被存到合同审核表作为供应商id */
    @ApiModelProperty(value = "申请ID,这个id会被存到合同审核表作为供应商id")
    private Integer id;

    /** 供应商编号 */
    @ApiModelProperty(value = "供应商编号")
    private String providerId;

    /** 供应商账号 */
    @ApiModelProperty(value = "供应商账号")
    private String account;

    /** 供应商全称（中文名） */
    @ApiModelProperty(value = "供应商全称（中文名）")
    private String nameCn;

    /** 供应商全称（英文名） */
    @ApiModelProperty(value = "供应商全称（英文名）")
    private String nameEn;

    /** 供应商简称 */
    @ApiModelProperty(value = "供应商简称")
    private String shortName;

    /** 1机构2 个人 */
    @ApiModelProperty(value = "1机构2 个人")
    private Integer type;

    /** 媒资类型1编辑类2创意类3编辑类&创意类 */
    @ApiModelProperty(value = "媒资类型1编辑类2创意类3编辑类&创意类")
    private Integer assetFamily;

    /** 媒资分类1 图片2视频3音频 */
    @ApiModelProperty(value = "媒资分类1 图片2视频3音频")
    private Integer assetType;

    /** 国家 */
    @ApiModelProperty(value = "国家")
    private String country;

    /** 省 */
    @ApiModelProperty(value = "省")
    private String province;

    /** 市 */
    @ApiModelProperty(value = "市")
    private String city;

    /** 具体地点 */
    @ApiModelProperty(value = "具体地点")
    private String location;

    /** 供应商所属公司 */
    @ApiModelProperty(value = "供应商所属公司")
    private String providerCompany;

    /** 从业类型1媒体2非媒体 */
    @ApiModelProperty(value = "从业类型1媒体2非媒体")
    private Integer jobType;

    /** 供应商等级1A+ 2A3B4C5D */
    @ApiModelProperty(value = "供应商等级1A+ 2A3B4C5D")
    private String qualityRank;

    /** 描述 */
    @ApiModelProperty(value = "描述")
    private String description;

    /** 作品 */
    @ApiModelProperty(value = "作品")
    private String productions;

    /** 通过时间 */
    @ApiModelProperty(value = "通过时间")
    private Date passtTime;

    /** 开通人id */
    @ApiModelProperty(value = "开通人id")
    private String passUserId;

    /**  */
    @ApiModelProperty(value = "")
    private String userCenterId;

    /** 状态 1 未审核 2 待签合同 3 开通 4 不通过  */
    @ApiModelProperty(value = "状态 1 未审核 2 待签合同 3 开通 4 不通过 ")
    private Integer status;

    /** 排序 */
    @ApiModelProperty(value = "排序")
    private Integer orders;

    /** 0删除1有效 */
    @ApiModelProperty(value = "0删除1有效")
    private Integer isDelete;

    /** 供应商属性 */
    @ApiModelProperty(value = "供应商属性")
    private String attribute;

    /** 供应商网站 */
    @ApiModelProperty(value = "供应商网站")
    private String providerWebsite;

    /** 供应商网站账号 */
    @ApiModelProperty(value = "供应商网站账号")
    private String websiteName;

    /** 供应商网站密码 */
    @ApiModelProperty(value = "供应商网站密码")
    private String websitePassword;

    /** 1国内2国外 */
    @ApiModelProperty(value = "1国内2国外")
    private Integer isNative;

    /** 限价 */
    @ApiModelProperty(value = "限价")
    private String limitedPrice;

    /** 备注 */
    @ApiModelProperty(value = "备注")
    private String comment;

    /** 拒绝理由 */
    @ApiModelProperty(value = "拒绝理由")
    private String rejectReason;

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

    public ProviderApplication setId(Integer id) {
        this.id = id;
		return this;
    }

    public String getProviderId() {
        return providerId;
    }

    public ProviderApplication setProviderId(String providerId) {
        this.providerId = providerId == null ? null : providerId.trim();
		return this;
    }

    public String getAccount() {
        return account;
    }

    public ProviderApplication setAccount(String account) {
        this.account = account == null ? null : account.trim();
		return this;
    }

    public String getNameCn() {
        return nameCn;
    }

    public ProviderApplication setNameCn(String nameCn) {
        this.nameCn = nameCn == null ? null : nameCn.trim();
		return this;
    }

    public String getNameEn() {
        return nameEn;
    }

    public ProviderApplication setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
		return this;
    }

    public String getShortName() {
        return shortName;
    }

    public ProviderApplication setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
		return this;
    }

    public Integer getType() {
        return type;
    }

    public ProviderApplication setType(Integer type) {
        this.type = type;
		return this;
    }

    public Integer getAssetFamily() {
        return assetFamily;
    }

    public ProviderApplication setAssetFamily(Integer assetFamily) {
        this.assetFamily = assetFamily;
		return this;
    }

    public Integer getAssetType() {
        return assetType;
    }

    public ProviderApplication setAssetType(Integer assetType) {
        this.assetType = assetType;
		return this;
    }

    public String getCountry() {
        return country;
    }

    public ProviderApplication setCountry(String country) {
        this.country = country == null ? null : country.trim();
		return this;
    }

    public String getProvince() {
        return province;
    }

    public ProviderApplication setProvince(String province) {
        this.province = province == null ? null : province.trim();
		return this;
    }

    public String getCity() {
        return city;
    }

    public ProviderApplication setCity(String city) {
        this.city = city == null ? null : city.trim();
		return this;
    }

    public String getLocation() {
        return location;
    }

    public ProviderApplication setLocation(String location) {
        this.location = location == null ? null : location.trim();
		return this;
    }

    public String getProviderCompany() {
        return providerCompany;
    }

    public ProviderApplication setProviderCompany(String providerCompany) {
        this.providerCompany = providerCompany == null ? null : providerCompany.trim();
		return this;
    }

    public Integer getJobType() {
        return jobType;
    }

    public ProviderApplication setJobType(Integer jobType) {
        this.jobType = jobType;
		return this;
    }

    public String getQualityRank() {
        return qualityRank;
    }

    public ProviderApplication setQualityRank(String qualityRank) {
        this.qualityRank = qualityRank == null ? null : qualityRank.trim();
		return this;
    }

    public String getDescription() {
        return description;
    }

    public ProviderApplication setDescription(String description) {
        this.description = description == null ? null : description.trim();
		return this;
    }

    public String getProductions() {
        return productions;
    }

    public ProviderApplication setProductions(String productions) {
        this.productions = productions == null ? null : productions.trim();
		return this;
    }

    public Date getPasstTime() {
        return passtTime;
    }

    public ProviderApplication setPasstTime(Date passtTime) {
        this.passtTime = passtTime;
		return this;
    }

    public String getPassUserId() {
        return passUserId;
    }

    public ProviderApplication setPassUserId(String passUserId) {
        this.passUserId = passUserId == null ? null : passUserId.trim();
		return this;
    }

    public String getUserCenterId() {
        return userCenterId;
    }

    public ProviderApplication setUserCenterId(String userCenterId) {
        this.userCenterId = userCenterId == null ? null : userCenterId.trim();
		return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ProviderApplication setStatus(Integer status) {
        this.status = status;
		return this;
    }

    public Integer getOrders() {
        return orders;
    }

    public ProviderApplication setOrders(Integer orders) {
        this.orders = orders;
		return this;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public ProviderApplication setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
		return this;
    }

    public String getAttribute() {
        return attribute;
    }

    public ProviderApplication setAttribute(String attribute) {
        this.attribute = attribute == null ? null : attribute.trim();
		return this;
    }

    public String getProviderWebsite() {
        return providerWebsite;
    }

    public ProviderApplication setProviderWebsite(String providerWebsite) {
        this.providerWebsite = providerWebsite == null ? null : providerWebsite.trim();
		return this;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public ProviderApplication setWebsiteName(String websiteName) {
        this.websiteName = websiteName == null ? null : websiteName.trim();
		return this;
    }

    public String getWebsitePassword() {
        return websitePassword;
    }

    public ProviderApplication setWebsitePassword(String websitePassword) {
        this.websitePassword = websitePassword == null ? null : websitePassword.trim();
		return this;
    }

    public Integer getIsNative() {
        return isNative;
    }

    public ProviderApplication setIsNative(Integer isNative) {
        this.isNative = isNative;
		return this;
    }

    public String getLimitedPrice() {
        return limitedPrice;
    }

    public ProviderApplication setLimitedPrice(String limitedPrice) {
        this.limitedPrice = limitedPrice == null ? null : limitedPrice.trim();
		return this;
    }

    public String getComment() {
        return comment;
    }

    public ProviderApplication setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
		return this;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public ProviderApplication setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason == null ? null : rejectReason.trim();
		return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public ProviderApplication setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
		return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public ProviderApplication setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
		return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public ProviderApplication setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
		return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public ProviderApplication setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
		return this;
    }
}
