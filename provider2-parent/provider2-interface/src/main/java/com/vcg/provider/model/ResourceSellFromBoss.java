package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.math.BigDecimal;

import java.util.Date;

public class ResourceSellFromBoss extends BaseModel<ResourceSellFromBoss> {
    private static final long serialVersionUID = 3376535537213000613L;

    /** 主键 */
    @ApiModelProperty(value = "主键")
    private String billDetailId;

    /** 资源id */
    @ApiModelProperty(value = "资源id")
    private String resId;

    /** 区分2:创意类\1:编辑类 */
    @ApiModelProperty(value = "区分2:创意类\1:编辑类")
    private Integer assetFamily;

    /**  */
    @ApiModelProperty(value = "")
    private String currencyCode;

    /** 图片价格 */
    @ApiModelProperty(value = "图片价格")
    private BigDecimal sellPrice;

    /**  */
    @ApiModelProperty(value = "")
    private BigDecimal price;

    /** 稿费 */
    @ApiModelProperty(value = "稿费")
    private BigDecimal netShare;

    /** 分成比例 */
    @ApiModelProperty(value = "分成比例")
    private BigDecimal royaltyRate;

    /** 供应商id */
    @ApiModelProperty(value = "供应商id")
    private Integer providerId;

    /** 提供商名称（或摄影师姓名） */
    @ApiModelProperty(value = "提供商名称（或摄影师姓名）")
    private String providerName;

    /** 账单id */
    @ApiModelProperty(value = "账单id")
    private String invoiceNumber;

    /** 发布区域类型： 0.全球;2.除中国大陆外还包括其他地区;3.除中国大陆外还包括其他国家;42.仅中国大陆 */
    @ApiModelProperty(value = "发布区域类型： 0.全球;2.除中国大陆外还包括其他地区;3.除中国大陆外还包括其他国家;42.仅中国大陆")
    private String territoryId;

    /** 客户类型id(原来的所有二级属性） */
    @ApiModelProperty(value = "客户类型id(原来的所有二级属性）")
    private String clientType;

    /** 客户名称 */
    @ApiModelProperty(value = "客户名称")
    private String clientCn;

    /** 客户英文名 */
    @ApiModelProperty(value = "客户英文名")
    private String clientEn;

    /** 最终客户名称 */
    @ApiModelProperty(value = "最终客户名称")
    private String finaluserCn;

    /** 最终行业 */
    @ApiModelProperty(value = "最终行业")
    private String industryCode;

    /** 行业中文名 */
    @ApiModelProperty(value = "行业中文名")
    private String industryCn;

    /** 行业英文名 */
    @ApiModelProperty(value = "行业英文名")
    private String industryEn;

    /** 图片用途id */
    @ApiModelProperty(value = "图片用途id")
    private String usageCode;

    /** 用途中文名 */
    @ApiModelProperty(value = "用途中文名")
    private String usageCn;

    /** 用途英文名称 */
    @ApiModelProperty(value = "用途英文名称")
    private String usageEn;

    /**  */
    @ApiModelProperty(value = "")
    private Integer duration;

    /** 发布开始时间 */
    @ApiModelProperty(value = "发布开始时间")
    private Date rightStart;

    /** 发布结束时间 */
    @ApiModelProperty(value = "发布结束时间")
    private Date rightEnd;

    /** 买断类型 */
    @ApiModelProperty(value = "买断类型")
    private String protectionCode;

    /** 地区 */
    @ApiModelProperty(value = "地区")
    private String sellRegion;

    /** 生效时间 */
    @ApiModelProperty(value = "生效时间")
    private Date outbillDate;

    /** 下载时间 */
    @ApiModelProperty(value = "下载时间")
    private Date photoDownloadtime;

    /** 确认价格时间 */
    @ApiModelProperty(value = "确认价格时间")
    private Date confirmTime;

    /**  */
    @ApiModelProperty(value = "")
    private Integer status;

    /** 稿费是否确认：0：未确认；1：已确认 */
    @ApiModelProperty(value = "稿费是否确认：0：未确认；1：已确认")
    private String shareConfirmed;

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

    public String getBillDetailId() {
        return billDetailId;
    }

    public ResourceSellFromBoss setBillDetailId(String billDetailId) {
        this.billDetailId = billDetailId == null ? null : billDetailId.trim();
		return this;
    }

    public String getResId() {
        return resId;
    }

    public ResourceSellFromBoss setResId(String resId) {
        this.resId = resId == null ? null : resId.trim();
		return this;
    }

    public Integer getAssetFamily() {
        return assetFamily;
    }

    public ResourceSellFromBoss setAssetFamily(Integer assetFamily) {
        this.assetFamily = assetFamily;
		return this;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public ResourceSellFromBoss setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode == null ? null : currencyCode.trim();
		return this;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public ResourceSellFromBoss setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
		return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ResourceSellFromBoss setPrice(BigDecimal price) {
        this.price = price;
		return this;
    }

    public BigDecimal getNetShare() {
        return netShare;
    }

    public ResourceSellFromBoss setNetShare(BigDecimal netShare) {
        this.netShare = netShare;
		return this;
    }

    public BigDecimal getRoyaltyRate() {
        return royaltyRate;
    }

    public ResourceSellFromBoss setRoyaltyRate(BigDecimal royaltyRate) {
        this.royaltyRate = royaltyRate;
		return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public ResourceSellFromBoss setProviderId(Integer providerId) {
        this.providerId = providerId;
		return this;
    }

    public String getProviderName() {
        return providerName;
    }

    public ResourceSellFromBoss setProviderName(String providerName) {
        this.providerName = providerName == null ? null : providerName.trim();
		return this;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public ResourceSellFromBoss setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber == null ? null : invoiceNumber.trim();
		return this;
    }

    public String getTerritoryId() {
        return territoryId;
    }

    public ResourceSellFromBoss setTerritoryId(String territoryId) {
        this.territoryId = territoryId == null ? null : territoryId.trim();
		return this;
    }

    public String getClientType() {
        return clientType;
    }

    public ResourceSellFromBoss setClientType(String clientType) {
        this.clientType = clientType == null ? null : clientType.trim();
		return this;
    }

    public String getClientCn() {
        return clientCn;
    }

    public ResourceSellFromBoss setClientCn(String clientCn) {
        this.clientCn = clientCn == null ? null : clientCn.trim();
		return this;
    }

    public String getClientEn() {
        return clientEn;
    }

    public ResourceSellFromBoss setClientEn(String clientEn) {
        this.clientEn = clientEn == null ? null : clientEn.trim();
		return this;
    }

    public String getFinaluserCn() {
        return finaluserCn;
    }

    public ResourceSellFromBoss setFinaluserCn(String finaluserCn) {
        this.finaluserCn = finaluserCn == null ? null : finaluserCn.trim();
		return this;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public ResourceSellFromBoss setIndustryCode(String industryCode) {
        this.industryCode = industryCode == null ? null : industryCode.trim();
		return this;
    }

    public String getIndustryCn() {
        return industryCn;
    }

    public ResourceSellFromBoss setIndustryCn(String industryCn) {
        this.industryCn = industryCn == null ? null : industryCn.trim();
		return this;
    }

    public String getIndustryEn() {
        return industryEn;
    }

    public ResourceSellFromBoss setIndustryEn(String industryEn) {
        this.industryEn = industryEn == null ? null : industryEn.trim();
		return this;
    }

    public String getUsageCode() {
        return usageCode;
    }

    public ResourceSellFromBoss setUsageCode(String usageCode) {
        this.usageCode = usageCode == null ? null : usageCode.trim();
		return this;
    }

    public String getUsageCn() {
        return usageCn;
    }

    public ResourceSellFromBoss setUsageCn(String usageCn) {
        this.usageCn = usageCn == null ? null : usageCn.trim();
		return this;
    }

    public String getUsageEn() {
        return usageEn;
    }

    public ResourceSellFromBoss setUsageEn(String usageEn) {
        this.usageEn = usageEn == null ? null : usageEn.trim();
		return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public ResourceSellFromBoss setDuration(Integer duration) {
        this.duration = duration;
		return this;
    }

    public Date getRightStart() {
        return rightStart;
    }

    public ResourceSellFromBoss setRightStart(Date rightStart) {
        this.rightStart = rightStart;
		return this;
    }

    public Date getRightEnd() {
        return rightEnd;
    }

    public ResourceSellFromBoss setRightEnd(Date rightEnd) {
        this.rightEnd = rightEnd;
		return this;
    }

    public String getProtectionCode() {
        return protectionCode;
    }

    public ResourceSellFromBoss setProtectionCode(String protectionCode) {
        this.protectionCode = protectionCode == null ? null : protectionCode.trim();
		return this;
    }

    public String getSellRegion() {
        return sellRegion;
    }

    public ResourceSellFromBoss setSellRegion(String sellRegion) {
        this.sellRegion = sellRegion == null ? null : sellRegion.trim();
		return this;
    }

    public Date getOutbillDate() {
        return outbillDate;
    }

    public ResourceSellFromBoss setOutbillDate(Date outbillDate) {
        this.outbillDate = outbillDate;
		return this;
    }

    public Date getPhotoDownloadtime() {
        return photoDownloadtime;
    }

    public ResourceSellFromBoss setPhotoDownloadtime(Date photoDownloadtime) {
        this.photoDownloadtime = photoDownloadtime;
		return this;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public ResourceSellFromBoss setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
		return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ResourceSellFromBoss setStatus(Integer status) {
        this.status = status;
		return this;
    }

    public String getShareConfirmed() {
        return shareConfirmed;
    }

    public ResourceSellFromBoss setShareConfirmed(String shareConfirmed) {
        this.shareConfirmed = shareConfirmed == null ? null : shareConfirmed.trim();
		return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public ResourceSellFromBoss setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
		return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public ResourceSellFromBoss setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
		return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public ResourceSellFromBoss setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
		return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public ResourceSellFromBoss setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
		return this;
    }
}
