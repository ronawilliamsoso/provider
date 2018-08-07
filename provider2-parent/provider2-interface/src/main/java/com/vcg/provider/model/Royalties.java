package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.math.BigDecimal;

import java.util.Date;

public class Royalties extends BaseModel<Royalties> {
    private static final long serialVersionUID = 3042226390622431290L;

    /** 自增主键 */
    @ApiModelProperty(value = "自增主键")
    private Integer id;

    /** 供应商ID */
    @ApiModelProperty(value = "供应商ID")
    private Integer providerId;

    /** 媒资类型1编辑类2创意类 */
    @ApiModelProperty(value = "媒资类型1编辑类2创意类")
    private Integer assetFamily;

    /** 年份 */
    @ApiModelProperty(value = "年份")
    private Integer year;

    /** 月份 */
    @ApiModelProperty(value = "月份")
    private Integer month;

    /** 销售总额 */
    @ApiModelProperty(value = "销售总额")
    private BigDecimal saleAmount;

    /** 稿酬总额 */
    @ApiModelProperty(value = "稿酬总额")
    private BigDecimal costAmount;

    /** 补录金额 */
    @ApiModelProperty(value = "补录金额")
    private BigDecimal buluAmount;

    /** 个税金额 */
    @ApiModelProperty(value = "个税金额")
    private BigDecimal taxAmount;

    /** 奖金 */
    @ApiModelProperty(value = "奖金")
    private BigDecimal bonus;

    /** 付款（出账）时间 */
    @ApiModelProperty(value = "付款（出账）时间")
    private Date payTime;

    /** 图片数量 */
    @ApiModelProperty(value = "图片数量")
    private Integer picTotal;

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

    public Royalties setId(Integer id) {
        this.id = id;
		return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public Royalties setProviderId(Integer providerId) {
        this.providerId = providerId;
		return this;
    }

    public Integer getAssetFamily() {
        return assetFamily;
    }

    public Royalties setAssetFamily(Integer assetFamily) {
        this.assetFamily = assetFamily;
		return this;
    }

    public Integer getYear() {
        return year;
    }

    public Royalties setYear(Integer year) {
        this.year = year;
		return this;
    }

    public Integer getMonth() {
        return month;
    }

    public Royalties setMonth(Integer month) {
        this.month = month;
		return this;
    }

    public BigDecimal getSaleAmount() {
        return saleAmount;
    }

    public Royalties setSaleAmount(BigDecimal saleAmount) {
        this.saleAmount = saleAmount;
		return this;
    }

    public BigDecimal getCostAmount() {
        return costAmount;
    }

    public Royalties setCostAmount(BigDecimal costAmount) {
        this.costAmount = costAmount;
		return this;
    }

    public BigDecimal getBuluAmount() {
        return buluAmount;
    }

    public Royalties setBuluAmount(BigDecimal buluAmount) {
        this.buluAmount = buluAmount;
		return this;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public Royalties setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
		return this;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public Royalties setBonus(BigDecimal bonus) {
        this.bonus = bonus;
		return this;
    }

    public Date getPayTime() {
        return payTime;
    }

    public Royalties setPayTime(Date payTime) {
        this.payTime = payTime;
		return this;
    }

    public Integer getPicTotal() {
        return picTotal;
    }

    public Royalties setPicTotal(Integer picTotal) {
        this.picTotal = picTotal;
		return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public Royalties setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
		return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Royalties setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
		return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public Royalties setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
		return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public Royalties setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
		return this;
    }
}
