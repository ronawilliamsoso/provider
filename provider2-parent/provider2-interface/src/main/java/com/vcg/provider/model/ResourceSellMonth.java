package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.math.BigDecimal;

import java.util.Date;

public class ResourceSellMonth extends BaseModel<ResourceSellMonth> {
    private static final long serialVersionUID = 7446110348625229381L;

    /** 数据库自增 */
    @ApiModelProperty(value = "数据库自增")
    private Integer id;

    /** 供应商id,摄影师id */
    @ApiModelProperty(value = "供应商id,摄影师id")
    private Integer providerId;

    /** 统计月份 */
    @ApiModelProperty(value = "统计月份")
    private String sellMonth;

    /** 图片的素材类型 */
    @ApiModelProperty(value = "图片的素材类型")
    private Integer assetFamily;

    /** 根据查询获得，不维护 */
    @ApiModelProperty(value = "根据查询获得，不维护")
    private String providerName;

    /** 销售额总计 */
    @ApiModelProperty(value = "销售额总计")
    private BigDecimal sellTotal;

    /** 销售额总计 美元-根据明细更新获得 */
    @ApiModelProperty(value = "销售额总计 美元-根据明细更新获得")
    private BigDecimal sellTotalus;

    /** 稿费总金额 */
    @ApiModelProperty(value = "稿费总金额")
    private BigDecimal shareTotal;

    /** 销售额总计 美元-根据明细查询获得,不维护 */
    @ApiModelProperty(value = "销售额总计 美元-根据明细查询获得,不维护")
    private BigDecimal shareTotalus;

    /** 坏账金额 根据明细查询获取 */
    @ApiModelProperty(value = "坏账金额 根据明细查询获取")
    private BigDecimal badDebt;

    /** 扣税金额 */
    @ApiModelProperty(value = "扣税金额")
    private BigDecimal tax;

    /** 实发金额 */
    @ApiModelProperty(value = "实发金额")
    private BigDecimal netPayment;

    /** 总销售张数 */
    @ApiModelProperty(value = "总销售张数")
    private Integer sellCount;

    /** 独家奖金 */
    @ApiModelProperty(value = "独家奖金")
    private BigDecimal exclusiveBonus;

    /** 补录稿费 */
    @ApiModelProperty(value = "补录稿费")
    private BigDecimal additionalShare;

    /** 未知数据 */
    @ApiModelProperty(value = "未知数据")
    private BigDecimal exchangeRate;

    /** 稿费支付时间 */
    @ApiModelProperty(value = "稿费支付时间")
    private Date payTime;

    /** 已付款 1:是 0：否 */
    @ApiModelProperty(value = "已付款 1:是 0：否")
    private Integer isPaied;

    /** 月报表已发布 1：是 0：否 */
    @ApiModelProperty(value = "月报表已发布 1：是 0：否")
    private Integer isPublished;

    /** 供应商类型 1：机构 2：个人 根据provider查询获得，不用维护 */
    @ApiModelProperty(value = "供应商类型 1：机构 2：个人 根据provider查询获得，不用维护")
    private Integer agentType;

    public Integer getId() {
        return id;
    }

    public ResourceSellMonth setId(Integer id) {
        this.id = id;
		return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public ResourceSellMonth setProviderId(Integer providerId) {
        this.providerId = providerId;
		return this;
    }

    public String getSellMonth() {
        return sellMonth;
    }

    public ResourceSellMonth setSellMonth(String sellMonth) {
        this.sellMonth = sellMonth == null ? null : sellMonth.trim();
		return this;
    }

    public Integer getAssetFamily() {
        return assetFamily;
    }

    public ResourceSellMonth setAssetFamily(Integer assetFamily) {
        this.assetFamily = assetFamily;
		return this;
    }

    public String getProviderName() {
        return providerName;
    }

    public ResourceSellMonth setProviderName(String providerName) {
        this.providerName = providerName == null ? null : providerName.trim();
		return this;
    }

    public BigDecimal getSellTotal() {
        return sellTotal;
    }

    public ResourceSellMonth setSellTotal(BigDecimal sellTotal) {
        this.sellTotal = sellTotal;
		return this;
    }

    public BigDecimal getSellTotalus() {
        return sellTotalus;
    }

    public ResourceSellMonth setSellTotalus(BigDecimal sellTotalus) {
        this.sellTotalus = sellTotalus;
		return this;
    }

    public BigDecimal getShareTotal() {
        return shareTotal;
    }

    public ResourceSellMonth setShareTotal(BigDecimal shareTotal) {
        this.shareTotal = shareTotal;
		return this;
    }

    public BigDecimal getShareTotalus() {
        return shareTotalus;
    }

    public ResourceSellMonth setShareTotalus(BigDecimal shareTotalus) {
        this.shareTotalus = shareTotalus;
		return this;
    }

    public BigDecimal getBadDebt() {
        return badDebt;
    }

    public ResourceSellMonth setBadDebt(BigDecimal badDebt) {
        this.badDebt = badDebt;
		return this;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public ResourceSellMonth setTax(BigDecimal tax) {
        this.tax = tax;
		return this;
    }

    public BigDecimal getNetPayment() {
        return netPayment;
    }

    public ResourceSellMonth setNetPayment(BigDecimal netPayment) {
        this.netPayment = netPayment;
		return this;
    }

    public Integer getSellCount() {
        return sellCount;
    }

    public ResourceSellMonth setSellCount(Integer sellCount) {
        this.sellCount = sellCount;
		return this;
    }

    public BigDecimal getExclusiveBonus() {
        return exclusiveBonus;
    }

    public ResourceSellMonth setExclusiveBonus(BigDecimal exclusiveBonus) {
        this.exclusiveBonus = exclusiveBonus;
		return this;
    }

    public BigDecimal getAdditionalShare() {
        return additionalShare;
    }

    public ResourceSellMonth setAdditionalShare(BigDecimal additionalShare) {
        this.additionalShare = additionalShare;
		return this;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public ResourceSellMonth setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
		return this;
    }

    public Date getPayTime() {
        return payTime;
    }

    public ResourceSellMonth setPayTime(Date payTime) {
        this.payTime = payTime;
		return this;
    }

    public Integer getIsPaied() {
        return isPaied;
    }

    public ResourceSellMonth setIsPaied(Integer isPaied) {
        this.isPaied = isPaied;
		return this;
    }

    public Integer getIsPublished() {
        return isPublished;
    }

    public ResourceSellMonth setIsPublished(Integer isPublished) {
        this.isPublished = isPublished;
		return this;
    }

    public Integer getAgentType() {
        return agentType;
    }

    public ResourceSellMonth setAgentType(Integer agentType) {
        this.agentType = agentType;
		return this;
    }
}
