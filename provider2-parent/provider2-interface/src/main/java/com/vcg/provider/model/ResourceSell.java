package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.math.BigDecimal;

import java.util.Date;

public class ResourceSell extends BaseModel<ResourceSell> {
    private static final long serialVersionUID = 2923613792254942985L;

    /** 数据库自增 */
    @ApiModelProperty(value = "数据库自增")
    private Integer id;

    /** 订单号 */
    @ApiModelProperty(value = "订单号")
    private String billDetailId;

    /** 每月取上月的数据，取过来的时候写入 */
    @ApiModelProperty(value = "每月取上月的数据，取过来的时候写入")
    private String sellMonth;

    /** vcg图片id,cfp图片编号-boss  */
    @ApiModelProperty(value = "vcg图片id,cfp图片编号-boss ")
    private String resId;

    /** 供应原始图片编号,getty图片编号-编审 */
    @ApiModelProperty(value = "供应原始图片编号,getty图片编号-编审")
    private String providerResId;

    /** 供应商id,摄影师id-编审 */
    @ApiModelProperty(value = "供应商id,摄影师id-编审")
    private Integer providerId;

    /** vcg的collectionId-编审 */
    @ApiModelProperty(value = "vcg的collectionId-编审")
    private Integer collectionId;

    /** collection名字-provider */
    @ApiModelProperty(value = "collection名字-provider")
    private String collectionName;

    /** 授权客户类型1:RM2:RF3: RR 来自collection */
    @ApiModelProperty(value = "授权客户类型1:RM2:RF3: RR 来自collection")
    private Integer licenseType;

    /** 图片的素材类型-编审出 */
    @ApiModelProperty(value = "图片的素材类型-编审出")
    private Integer assetFamily;

    /** 图片说明-来自编审 */
    @ApiModelProperty(value = "图片说明-来自编审")
    private String caption;

    /** 销售日期-boss */
    @ApiModelProperty(value = "销售日期-boss")
    private Date sellDate;

    /** CNY等 */
    @ApiModelProperty(value = "CNY等")
    private String currencyCode;

    /** 售价,销售价格,实际销售金额,对用户保密-boss */
    @ApiModelProperty(value = "售价,销售价格,实际销售金额,对用户保密-boss")
    private BigDecimal sellPrice;

    /** 标价,不是售价,给用户看的-boss */
    @ApiModelProperty(value = "标价,不是售价,给用户看的-boss")
    private BigDecimal price;

    /** 分成比-boss */
    @ApiModelProperty(value = "分成比-boss")
    private BigDecimal royaltyRate;

    /** 稿费-boss */
    @ApiModelProperty(value = "稿费-boss")
    private BigDecimal netShare;

    /** 供应商名称-provider */
    @ApiModelProperty(value = "供应商名称-provider")
    private String providerName;

    /** 摄影师名字或者品牌名-编审 */
    @ApiModelProperty(value = "摄影师名字或者品牌名-编审")
    private String creditLine;

    /** 报价单号-boss */
    @ApiModelProperty(value = "报价单号-boss")
    private String invoiceNumber;

    /** 授权区域-boss */
    @ApiModelProperty(value = "授权区域-boss")
    private String territoryId;

    /** meta授权区域-boss */
    @ApiModelProperty(value = "meta授权区域-boss")
    private Integer metaTerritoryId;

    /** 客户类型-boss */
    @ApiModelProperty(value = "客户类型-boss")
    private String clientType;

    /** 客户中文名称-boss */
    @ApiModelProperty(value = "客户中文名称-boss")
    private String clientCn;

    /** 客户英文名称-boss */
    @ApiModelProperty(value = "客户英文名称-boss")
    private String clientEn;

    /** 最终用户-中文名-boss */
    @ApiModelProperty(value = "最终用户-中文名-boss")
    private String finaluserCn;

    /** 最终用户英文名称-boss,没有这个数据 */
    @ApiModelProperty(value = "最终用户英文名称-boss,没有这个数据")
    private String finaluserEn;

    /** 行业类型code-boss */
    @ApiModelProperty(value = "行业类型code-boss")
    private String industryCode;

    /** 行业名称英文-boss */
    @ApiModelProperty(value = "行业名称英文-boss")
    private String industryEn;

    /** 行业名称中文-boss */
    @ApiModelProperty(value = "行业名称中文-boss")
    private String industryCn;

    /** 使用用途code-boss */
    @ApiModelProperty(value = "使用用途code-boss")
    private String usageCode;

    /** 用途-中文-boss */
    @ApiModelProperty(value = "用途-中文-boss")
    private String usageCn;

    /** 用途-英文-boss */
    @ApiModelProperty(value = "用途-英文-boss")
    private String usageEn;

    /** 使用期限-boss */
    @ApiModelProperty(value = "使用期限-boss")
    private Integer duration;

    /** 授权结束日期-boss */
    @ApiModelProperty(value = "授权结束日期-boss")
    private Date rightEnd;

    /** 授权开始日期-boss */
    @ApiModelProperty(value = "授权开始日期-boss")
    private Date rightStart;

    /** 限制code  -boss */
    @ApiModelProperty(value = "限制code  -boss")
    private String protectionCode;

    /** 销售区域-boss */
    @ApiModelProperty(value = "销售区域-boss")
    private String sellRegion;

    /** 出账单时间-boss */
    @ApiModelProperty(value = "出账单时间-boss")
    private Date outbillDate;

    /** 图片下载时间-boss */
    @ApiModelProperty(value = "图片下载时间-boss")
    private Date photoDownloadtime;

    /** 订单确认时间-boss */
    @ApiModelProperty(value = "订单确认时间-boss")
    private Date confirmTime;

    /** 缩略图的地址-boss */
    @ApiModelProperty(value = "缩略图的地址-boss")
    private String skeletonPath;

    /** 订单已确认 1：是 0：否,意思是价格确认了订单没确认,本月数据会这样,上月数据不会  -boss */
    @ApiModelProperty(value = "订单已确认 1：是 0：否,意思是价格确认了订单没确认,本月数据会这样,上月数据不会  -boss")
    private Integer orderConfirmed;

    /** 稿费已经确认： 1：是 0：否  -boss */
    @ApiModelProperty(value = "稿费已经确认： 1：是 0：否  -boss")
    private Integer shareConfirmed;

    /** 供应商类型 1：机构 2：个人 --provider */
    @ApiModelProperty(value = "供应商类型 1：机构 2：个人 --provider")
    private Integer agentType;

    /** 数据确认状态 0：未确认（刚从boss取得) 1：供应商已确认   通过portal维护 */
    @ApiModelProperty(value = "数据确认状态 0：未确认（刚从boss取得) 1：供应商已确认   通过portal维护")
    private Integer monthlyConfirmed;

    /** 备注-管理部门自己维护 */
    @ApiModelProperty(value = "备注-管理部门自己维护")
    private String comment;

    public Integer getId() {
        return id;
    }

    public ResourceSell setId(Integer id) {
        this.id = id;
		return this;
    }

    public String getBillDetailId() {
        return billDetailId;
    }

    public ResourceSell setBillDetailId(String billDetailId) {
        this.billDetailId = billDetailId == null ? null : billDetailId.trim();
		return this;
    }

    public String getSellMonth() {
        return sellMonth;
    }

    public ResourceSell setSellMonth(String sellMonth) {
        this.sellMonth = sellMonth == null ? null : sellMonth.trim();
		return this;
    }

    public String getResId() {
        return resId;
    }

    public ResourceSell setResId(String resId) {
        this.resId = resId == null ? null : resId.trim();
		return this;
    }

    public String getProviderResId() {
        return providerResId;
    }

    public ResourceSell setProviderResId(String providerResId) {
        this.providerResId = providerResId == null ? null : providerResId.trim();
		return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public ResourceSell setProviderId(Integer providerId) {
        this.providerId = providerId;
		return this;
    }

    public Integer getCollectionId() {
        return collectionId;
    }

    public ResourceSell setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
		return this;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public ResourceSell setCollectionName(String collectionName) {
        this.collectionName = collectionName == null ? null : collectionName.trim();
		return this;
    }

    public Integer getLicenseType() {
        return licenseType;
    }

    public ResourceSell setLicenseType(Integer licenseType) {
        this.licenseType = licenseType;
		return this;
    }

    public Integer getAssetFamily() {
        return assetFamily;
    }

    public ResourceSell setAssetFamily(Integer assetFamily) {
        this.assetFamily = assetFamily;
		return this;
    }

    public String getCaption() {
        return caption;
    }

    public ResourceSell setCaption(String caption) {
        this.caption = caption == null ? null : caption.trim();
		return this;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public ResourceSell setSellDate(Date sellDate) {
        this.sellDate = sellDate;
		return this;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public ResourceSell setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode == null ? null : currencyCode.trim();
		return this;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public ResourceSell setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
		return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ResourceSell setPrice(BigDecimal price) {
        this.price = price;
		return this;
    }

    public BigDecimal getRoyaltyRate() {
        return royaltyRate;
    }

    public ResourceSell setRoyaltyRate(BigDecimal royaltyRate) {
        this.royaltyRate = royaltyRate;
		return this;
    }

    public BigDecimal getNetShare() {
        return netShare;
    }

    public ResourceSell setNetShare(BigDecimal netShare) {
        this.netShare = netShare;
		return this;
    }

    public String getProviderName() {
        return providerName;
    }

    public ResourceSell setProviderName(String providerName) {
        this.providerName = providerName == null ? null : providerName.trim();
		return this;
    }

    public String getCreditLine() {
        return creditLine;
    }

    public ResourceSell setCreditLine(String creditLine) {
        this.creditLine = creditLine == null ? null : creditLine.trim();
		return this;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public ResourceSell setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber == null ? null : invoiceNumber.trim();
		return this;
    }

    public String getTerritoryId() {
        return territoryId;
    }

    public ResourceSell setTerritoryId(String territoryId) {
        this.territoryId = territoryId == null ? null : territoryId.trim();
		return this;
    }

    public Integer getMetaTerritoryId() {
        return metaTerritoryId;
    }

    public ResourceSell setMetaTerritoryId(Integer metaTerritoryId) {
        this.metaTerritoryId = metaTerritoryId;
		return this;
    }

    public String getClientType() {
        return clientType;
    }

    public ResourceSell setClientType(String clientType) {
        this.clientType = clientType == null ? null : clientType.trim();
		return this;
    }

    public String getClientCn() {
        return clientCn;
    }

    public ResourceSell setClientCn(String clientCn) {
        this.clientCn = clientCn == null ? null : clientCn.trim();
		return this;
    }

    public String getClientEn() {
        return clientEn;
    }

    public ResourceSell setClientEn(String clientEn) {
        this.clientEn = clientEn == null ? null : clientEn.trim();
		return this;
    }

    public String getFinaluserCn() {
        return finaluserCn;
    }

    public ResourceSell setFinaluserCn(String finaluserCn) {
        this.finaluserCn = finaluserCn == null ? null : finaluserCn.trim();
		return this;
    }

    public String getFinaluserEn() {
        return finaluserEn;
    }

    public ResourceSell setFinaluserEn(String finaluserEn) {
        this.finaluserEn = finaluserEn == null ? null : finaluserEn.trim();
		return this;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public ResourceSell setIndustryCode(String industryCode) {
        this.industryCode = industryCode == null ? null : industryCode.trim();
		return this;
    }

    public String getIndustryEn() {
        return industryEn;
    }

    public ResourceSell setIndustryEn(String industryEn) {
        this.industryEn = industryEn == null ? null : industryEn.trim();
		return this;
    }

    public String getIndustryCn() {
        return industryCn;
    }

    public ResourceSell setIndustryCn(String industryCn) {
        this.industryCn = industryCn == null ? null : industryCn.trim();
		return this;
    }

    public String getUsageCode() {
        return usageCode;
    }

    public ResourceSell setUsageCode(String usageCode) {
        this.usageCode = usageCode == null ? null : usageCode.trim();
		return this;
    }

    public String getUsageCn() {
        return usageCn;
    }

    public ResourceSell setUsageCn(String usageCn) {
        this.usageCn = usageCn == null ? null : usageCn.trim();
		return this;
    }

    public String getUsageEn() {
        return usageEn;
    }

    public ResourceSell setUsageEn(String usageEn) {
        this.usageEn = usageEn == null ? null : usageEn.trim();
		return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public ResourceSell setDuration(Integer duration) {
        this.duration = duration;
		return this;
    }

    public Date getRightEnd() {
        return rightEnd;
    }

    public ResourceSell setRightEnd(Date rightEnd) {
        this.rightEnd = rightEnd;
		return this;
    }

    public Date getRightStart() {
        return rightStart;
    }

    public ResourceSell setRightStart(Date rightStart) {
        this.rightStart = rightStart;
		return this;
    }

    public String getProtectionCode() {
        return protectionCode;
    }

    public ResourceSell setProtectionCode(String protectionCode) {
        this.protectionCode = protectionCode == null ? null : protectionCode.trim();
		return this;
    }

    public String getSellRegion() {
        return sellRegion;
    }

    public ResourceSell setSellRegion(String sellRegion) {
        this.sellRegion = sellRegion == null ? null : sellRegion.trim();
		return this;
    }

    public Date getOutbillDate() {
        return outbillDate;
    }

    public ResourceSell setOutbillDate(Date outbillDate) {
        this.outbillDate = outbillDate;
		return this;
    }

    public Date getPhotoDownloadtime() {
        return photoDownloadtime;
    }

    public ResourceSell setPhotoDownloadtime(Date photoDownloadtime) {
        this.photoDownloadtime = photoDownloadtime;
		return this;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public ResourceSell setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
		return this;
    }

    public String getSkeletonPath() {
        return skeletonPath;
    }

    public ResourceSell setSkeletonPath(String skeletonPath) {
        this.skeletonPath = skeletonPath == null ? null : skeletonPath.trim();
		return this;
    }

    public Integer getOrderConfirmed() {
        return orderConfirmed;
    }

    public ResourceSell setOrderConfirmed(Integer orderConfirmed) {
        this.orderConfirmed = orderConfirmed;
		return this;
    }

    public Integer getShareConfirmed() {
        return shareConfirmed;
    }

    public ResourceSell setShareConfirmed(Integer shareConfirmed) {
        this.shareConfirmed = shareConfirmed;
		return this;
    }

    public Integer getAgentType() {
        return agentType;
    }

    public ResourceSell setAgentType(Integer agentType) {
        this.agentType = agentType;
		return this;
    }

    public Integer getMonthlyConfirmed() {
        return monthlyConfirmed;
    }

    public ResourceSell setMonthlyConfirmed(Integer monthlyConfirmed) {
        this.monthlyConfirmed = monthlyConfirmed;
		return this;
    }

    public String getComment() {
        return comment;
    }

    public ResourceSell setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
		return this;
    }
}
