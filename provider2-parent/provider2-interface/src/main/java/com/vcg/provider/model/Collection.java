package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class Collection extends BaseModel<Collection> {
    private static final long serialVersionUID = 8993801988979414427L;

    /**  */
    @ApiModelProperty(value = "")
    private Integer id;

    /** 供应商表的主键id */
    @ApiModelProperty(value = "供应商表的主键id")
    private Integer providerId;

    /** 合同表的主键id */
    @ApiModelProperty(value = "合同表的主键id")
    private Integer contractId;

    /** collection名称 */
    @ApiModelProperty(value = "collection名称")
    private String name;

    /** 供应商的原始collection name */
    @ApiModelProperty(value = "供应商的原始collection name")
    private String originalName;

    /** 1 getty品牌1 2:getty品牌2 3:其他 */
    @ApiModelProperty(value = "1 getty品牌1 2:getty品牌2 3:其他")
    private String collectionCode;

    /** 媒资类型1图片2视频3音频 */
    @ApiModelProperty(value = "媒资类型1图片2视频3音频")
    private Integer assetType;

    /** 类型 1编辑类2创意类 */
    @ApiModelProperty(value = "类型 1编辑类2创意类")
    private Integer assetFamily;

    /** 授权客户类型1:RM2:RF3: RR */
    @ApiModelProperty(value = "授权客户类型1:RM2:RF3: RR")
    private Integer licenseType;

    /** 分成比 手写 */
    @ApiModelProperty(value = "分成比 手写")
    private String royaltyRate;

    /** 授权区域1:全球2:中国大陆地区3:中国大陆加港澳台4:大陆加香港5:大陆加台湾6:大陆加澳门7:其他 */
    @ApiModelProperty(value = "授权区域1:全球2:中国大陆地区3:中国大陆加港澳台4:大陆加香港5:大陆加台湾6:大陆加澳门7:其他")
    private String authLocation;

    /** 所属外部品牌,参照brand表 */
    @ApiModelProperty(value = "所属外部品牌,参照brand表")
    private Integer brandId;

    /** 品牌状态 1:有效 2:失效 3:待定 */
    @ApiModelProperty(value = "品牌状态 1:有效 2:失效 3:待定")
    private Integer availableStatus;

    /** 等级  1:Premium , 2:Standard */
    @ApiModelProperty(value = "等级  1:Premium , 2:Standard")
    private String collectionLevel;

    /** 目标网站  多选 逗号分隔 */
    @ApiModelProperty(value = "目标网站  多选 逗号分隔")
    private String targetWebsite;

    /** 内容主题 */
    @ApiModelProperty(value = "内容主题")
    private String contentTopic;

    /** 自有或者合作品牌1:VCG自有品牌 2:合作品牌 */
    @ApiModelProperty(value = "自有或者合作品牌1:VCG自有品牌 2:合作品牌")
    private Integer housePartner;

    /** 是否含有自有内容 1:是 0:否 */
    @ApiModelProperty(value = "是否含有自有内容 1:是 0:否")
    private Integer ownedSelfcontent;

    /** 是否100%自有   1:是  0:否 */
    @ApiModelProperty(value = "是否100%自有   1:是  0:否")
    private Integer whollyOwned;

    /** 0:非独家 1:独家 2:联合独家(非独家) */
    @ApiModelProperty(value = "0:非独家 1:独家 2:联合独家(非独家)")
    private String exclusiveAuth;

    /** ftp子目录 */
    @ApiModelProperty(value = "ftp子目录")
    private String ftpSubpath;

    /** 是否可以商业使用  1:是 0:否 */
    @ApiModelProperty(value = "是否可以商业使用  1:是 0:否")
    private Integer isCommercial;

    /** 是否商业使用-其他 */
    @ApiModelProperty(value = "是否商业使用-其他")
    private String isCommercialNote;

    /** 是否可以买断销售 1:是 0:否 */
    @ApiModelProperty(value = "是否可以买断销售 1:是 0:否")
    private String isExclusivesell;

    /** 是否可以买断销售-其他 */
    @ApiModelProperty(value = "是否可以买断销售-其他")
    private String isExclusivesellNote;

    /** 是否开通小样图 0:否 1:是 */
    @ApiModelProperty(value = "是否开通小样图 0:否 1:是")
    private Integer ezaEnabled;

    /** 是否可以不限量订阅销售1:是 0:否 */
    @ApiModelProperty(value = "是否可以不限量订阅销售1:是 0:否")
    private Integer isSubscription;

    /** 是否可以不限量订阅销售-其他 */
    @ApiModelProperty(value = "是否可以不限量订阅销售-其他")
    private String isSubscriptionNote;

    /** 最低确认价格 */
    @ApiModelProperty(value = "最低确认价格")
    private Integer minPrice;

    /**  */
    @ApiModelProperty(value = "")
    private String minPriceNote;

    /** 销售限制 */
    @ApiModelProperty(value = "销售限制")
    private String salesRestrictions;

    /** 其他限制 */
    @ApiModelProperty(value = "其他限制")
    private String otherRestrictions;

    /** 模特肖像权 */
    @ApiModelProperty(value = "模特肖像权")
    private String modelRelease;

    /** 品牌介绍 */
    @ApiModelProperty(value = "品牌介绍")
    private String collectionIntroduction;

    /** 品牌卖点 */
    @ApiModelProperty(value = "品牌卖点")
    private String sellPoint;

    /** 目标市场 */
    @ApiModelProperty(value = "目标市场")
    private String targetMarket;

    /** 品牌历史 */
    @ApiModelProperty(value = "品牌历史")
    private String collectionHistory;

    /** 0到6级 */
    @ApiModelProperty(value = "0到6级")
    private String priceLimitlevel;

    /** 限价信息 */
    @ApiModelProperty(value = "限价信息")
    private String priceLimitdetail;

    /** 负责人 */
    @ApiModelProperty(value = "负责人")
    private String businessOwner;

    /** 备注 */
    @ApiModelProperty(value = "备注")
    private String notes;

    /** 最后修改人 */
    @ApiModelProperty(value = "最后修改人")
    private Integer modifiedBy;

    /** 隐藏策略 */
    @ApiModelProperty(value = "隐藏策略")
    private String exclusiveStrategy;

    /** 排他策略详情 */
    @ApiModelProperty(value = "排他策略详情")
    private String exclusiveStrategydetail;

    /** 特定客户限制 */
    @ApiModelProperty(value = "特定客户限制")
    private String exclusiveClients;

    /** 特定客户限制详情 */
    @ApiModelProperty(value = "特定客户限制详情")
    private String exclusiveClientsdetail;

    /** 水印签名策略  从水印表里出 */
    @ApiModelProperty(value = "水印签名策略  从水印表里出")
    private Integer waterId;

    /** 隐藏原因 */
    @ApiModelProperty(value = "隐藏原因")
    private String blockReason;

    /** 是否有底片 */
    @ApiModelProperty(value = "是否有底片")
    private String hasNegative;

    /** 产品限制 */
    @ApiModelProperty(value = "产品限制")
    private String productLimitation;

    /** 是否支持api发送 */
    @ApiModelProperty(value = "是否支持api发送")
    private String apiSend;

    /** 默认图片等级 1A 2B 3C 4D 5E  */
    @ApiModelProperty(value = "默认图片等级 1A 2B 3C 4D 5E ")
    private Integer defaultQualityRank;

    /** 是否拥有UU权利, 1:是   0:否 */
    @ApiModelProperty(value = "是否拥有UU权利, 1:是   0:否")
    private Integer haveUuright;

    /** 扣除成本 0:否 1:是 */
    @ApiModelProperty(value = "扣除成本 0:否 1:是")
    private Integer deductCost;

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

    public Collection setId(Integer id) {
        this.id = id;
		return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public Collection setProviderId(Integer providerId) {
        this.providerId = providerId;
		return this;
    }

    public Integer getContractId() {
        return contractId;
    }

    public Collection setContractId(Integer contractId) {
        this.contractId = contractId;
		return this;
    }

    public String getName() {
        return name;
    }

    public Collection setName(String name) {
        this.name = name == null ? null : name.trim();
		return this;
    }

    public String getOriginalName() {
        return originalName;
    }

    public Collection setOriginalName(String originalName) {
        this.originalName = originalName == null ? null : originalName.trim();
		return this;
    }

    public String getCollectionCode() {
        return collectionCode;
    }

    public Collection setCollectionCode(String collectionCode) {
        this.collectionCode = collectionCode == null ? null : collectionCode.trim();
		return this;
    }

    public Integer getAssetType() {
        return assetType;
    }

    public Collection setAssetType(Integer assetType) {
        this.assetType = assetType;
		return this;
    }

    public Integer getAssetFamily() {
        return assetFamily;
    }

    public Collection setAssetFamily(Integer assetFamily) {
        this.assetFamily = assetFamily;
		return this;
    }

    public Integer getLicenseType() {
        return licenseType;
    }

    public Collection setLicenseType(Integer licenseType) {
        this.licenseType = licenseType;
		return this;
    }

    public String getRoyaltyRate() {
        return royaltyRate;
    }

    public Collection setRoyaltyRate(String royaltyRate) {
        this.royaltyRate = royaltyRate == null ? null : royaltyRate.trim();
		return this;
    }

    public String getAuthLocation() {
        return authLocation;
    }

    public Collection setAuthLocation(String authLocation) {
        this.authLocation = authLocation == null ? null : authLocation.trim();
		return this;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public Collection setBrandId(Integer brandId) {
        this.brandId = brandId;
		return this;
    }

    public Integer getAvailableStatus() {
        return availableStatus;
    }

    public Collection setAvailableStatus(Integer availableStatus) {
        this.availableStatus = availableStatus;
		return this;
    }

    public String getCollectionLevel() {
        return collectionLevel;
    }

    public Collection setCollectionLevel(String collectionLevel) {
        this.collectionLevel = collectionLevel == null ? null : collectionLevel.trim();
		return this;
    }

    public String getTargetWebsite() {
        return targetWebsite;
    }

    public Collection setTargetWebsite(String targetWebsite) {
        this.targetWebsite = targetWebsite == null ? null : targetWebsite.trim();
		return this;
    }

    public String getContentTopic() {
        return contentTopic;
    }

    public Collection setContentTopic(String contentTopic) {
        this.contentTopic = contentTopic == null ? null : contentTopic.trim();
		return this;
    }

    public Integer getHousePartner() {
        return housePartner;
    }

    public Collection setHousePartner(Integer housePartner) {
        this.housePartner = housePartner;
		return this;
    }

    public Integer getOwnedSelfcontent() {
        return ownedSelfcontent;
    }

    public Collection setOwnedSelfcontent(Integer ownedSelfcontent) {
        this.ownedSelfcontent = ownedSelfcontent;
		return this;
    }

    public Integer getWhollyOwned() {
        return whollyOwned;
    }

    public Collection setWhollyOwned(Integer whollyOwned) {
        this.whollyOwned = whollyOwned;
		return this;
    }

    public String getExclusiveAuth() {
        return exclusiveAuth;
    }

    public Collection setExclusiveAuth(String exclusiveAuth) {
        this.exclusiveAuth = exclusiveAuth == null ? null : exclusiveAuth.trim();
		return this;
    }

    public String getFtpSubpath() {
        return ftpSubpath;
    }

    public Collection setFtpSubpath(String ftpSubpath) {
        this.ftpSubpath = ftpSubpath == null ? null : ftpSubpath.trim();
		return this;
    }

    public Integer getIsCommercial() {
        return isCommercial;
    }

    public Collection setIsCommercial(Integer isCommercial) {
        this.isCommercial = isCommercial;
		return this;
    }

    public String getIsCommercialNote() {
        return isCommercialNote;
    }

    public Collection setIsCommercialNote(String isCommercialNote) {
        this.isCommercialNote = isCommercialNote == null ? null : isCommercialNote.trim();
		return this;
    }

    public String getIsExclusivesell() {
        return isExclusivesell;
    }

    public Collection setIsExclusivesell(String isExclusivesell) {
        this.isExclusivesell = isExclusivesell == null ? null : isExclusivesell.trim();
		return this;
    }

    public String getIsExclusivesellNote() {
        return isExclusivesellNote;
    }

    public Collection setIsExclusivesellNote(String isExclusivesellNote) {
        this.isExclusivesellNote = isExclusivesellNote == null ? null : isExclusivesellNote.trim();
		return this;
    }

    public Integer getEzaEnabled() {
        return ezaEnabled;
    }

    public Collection setEzaEnabled(Integer ezaEnabled) {
        this.ezaEnabled = ezaEnabled;
		return this;
    }

    public Integer getIsSubscription() {
        return isSubscription;
    }

    public Collection setIsSubscription(Integer isSubscription) {
        this.isSubscription = isSubscription;
		return this;
    }

    public String getIsSubscriptionNote() {
        return isSubscriptionNote;
    }

    public Collection setIsSubscriptionNote(String isSubscriptionNote) {
        this.isSubscriptionNote = isSubscriptionNote == null ? null : isSubscriptionNote.trim();
		return this;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public Collection setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
		return this;
    }

    public String getMinPriceNote() {
        return minPriceNote;
    }

    public Collection setMinPriceNote(String minPriceNote) {
        this.minPriceNote = minPriceNote == null ? null : minPriceNote.trim();
		return this;
    }

    public String getSalesRestrictions() {
        return salesRestrictions;
    }

    public Collection setSalesRestrictions(String salesRestrictions) {
        this.salesRestrictions = salesRestrictions == null ? null : salesRestrictions.trim();
		return this;
    }

    public String getOtherRestrictions() {
        return otherRestrictions;
    }

    public Collection setOtherRestrictions(String otherRestrictions) {
        this.otherRestrictions = otherRestrictions == null ? null : otherRestrictions.trim();
		return this;
    }

    public String getModelRelease() {
        return modelRelease;
    }

    public Collection setModelRelease(String modelRelease) {
        this.modelRelease = modelRelease == null ? null : modelRelease.trim();
		return this;
    }

    public String getCollectionIntroduction() {
        return collectionIntroduction;
    }

    public Collection setCollectionIntroduction(String collectionIntroduction) {
        this.collectionIntroduction = collectionIntroduction == null ? null : collectionIntroduction.trim();
		return this;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public Collection setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint == null ? null : sellPoint.trim();
		return this;
    }

    public String getTargetMarket() {
        return targetMarket;
    }

    public Collection setTargetMarket(String targetMarket) {
        this.targetMarket = targetMarket == null ? null : targetMarket.trim();
		return this;
    }

    public String getCollectionHistory() {
        return collectionHistory;
    }

    public Collection setCollectionHistory(String collectionHistory) {
        this.collectionHistory = collectionHistory == null ? null : collectionHistory.trim();
		return this;
    }

    public String getPriceLimitlevel() {
        return priceLimitlevel;
    }

    public Collection setPriceLimitlevel(String priceLimitlevel) {
        this.priceLimitlevel = priceLimitlevel == null ? null : priceLimitlevel.trim();
		return this;
    }

    public String getPriceLimitdetail() {
        return priceLimitdetail;
    }

    public Collection setPriceLimitdetail(String priceLimitdetail) {
        this.priceLimitdetail = priceLimitdetail == null ? null : priceLimitdetail.trim();
		return this;
    }

    public String getBusinessOwner() {
        return businessOwner;
    }

    public Collection setBusinessOwner(String businessOwner) {
        this.businessOwner = businessOwner == null ? null : businessOwner.trim();
		return this;
    }

    public String getNotes() {
        return notes;
    }

    public Collection setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
		return this;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public Collection setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
		return this;
    }

    public String getExclusiveStrategy() {
        return exclusiveStrategy;
    }

    public Collection setExclusiveStrategy(String exclusiveStrategy) {
        this.exclusiveStrategy = exclusiveStrategy == null ? null : exclusiveStrategy.trim();
		return this;
    }

    public String getExclusiveStrategydetail() {
        return exclusiveStrategydetail;
    }

    public Collection setExclusiveStrategydetail(String exclusiveStrategydetail) {
        this.exclusiveStrategydetail = exclusiveStrategydetail == null ? null : exclusiveStrategydetail.trim();
		return this;
    }

    public String getExclusiveClients() {
        return exclusiveClients;
    }

    public Collection setExclusiveClients(String exclusiveClients) {
        this.exclusiveClients = exclusiveClients == null ? null : exclusiveClients.trim();
		return this;
    }

    public String getExclusiveClientsdetail() {
        return exclusiveClientsdetail;
    }

    public Collection setExclusiveClientsdetail(String exclusiveClientsdetail) {
        this.exclusiveClientsdetail = exclusiveClientsdetail == null ? null : exclusiveClientsdetail.trim();
		return this;
    }

    public Integer getWaterId() {
        return waterId;
    }

    public Collection setWaterId(Integer waterId) {
        this.waterId = waterId;
		return this;
    }

    public String getBlockReason() {
        return blockReason;
    }

    public Collection setBlockReason(String blockReason) {
        this.blockReason = blockReason == null ? null : blockReason.trim();
		return this;
    }

    public String getHasNegative() {
        return hasNegative;
    }

    public Collection setHasNegative(String hasNegative) {
        this.hasNegative = hasNegative == null ? null : hasNegative.trim();
		return this;
    }

    public String getProductLimitation() {
        return productLimitation;
    }

    public Collection setProductLimitation(String productLimitation) {
        this.productLimitation = productLimitation == null ? null : productLimitation.trim();
		return this;
    }

    public String getApiSend() {
        return apiSend;
    }

    public Collection setApiSend(String apiSend) {
        this.apiSend = apiSend == null ? null : apiSend.trim();
		return this;
    }

    public Integer getDefaultQualityRank() {
        return defaultQualityRank;
    }

    public Collection setDefaultQualityRank(Integer defaultQualityRank) {
        this.defaultQualityRank = defaultQualityRank;
		return this;
    }

    public Integer getHaveUuright() {
        return haveUuright;
    }

    public Collection setHaveUuright(Integer haveUuright) {
        this.haveUuright = haveUuright;
		return this;
    }

    public Integer getDeductCost() {
        return deductCost;
    }

    public Collection setDeductCost(Integer deductCost) {
        this.deductCost = deductCost;
		return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public Collection setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
		return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Collection setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
		return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public Collection setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
		return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public Collection setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
		return this;
    }
}
