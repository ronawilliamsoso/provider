package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class ProviderPayment extends BaseModel<ProviderPayment> {
    private static final long serialVersionUID = 4707378879018003336L;

    /**  */
    @ApiModelProperty(value = "")
    private Integer id;

    /** 供应商表里的主键id */
    @ApiModelProperty(value = "供应商表里的主键id")
    private Integer providerId;

    /** 方式名称,转账等 */
    @ApiModelProperty(value = "方式名称,转账等")
    private String paymentMethod;

    /** 支行名称 */
    @ApiModelProperty(value = "支行名称")
    private String branchBankname;

    /** 开户银行名称 */
    @ApiModelProperty(value = "开户银行名称")
    private String bankName;

    /** 账户名称,人名 */
    @ApiModelProperty(value = "账户名称,人名")
    private String payeeName;

    /** 银行账号,卡号 */
    @ApiModelProperty(value = "银行账号,卡号")
    private String payeeNumber;

    /** 转银行代码 */
    @ApiModelProperty(value = "转银行代码")
    private String swiftCode;

    /** 银行详细地址 */
    @ApiModelProperty(value = "银行详细地址")
    private String bankAddress;

    /** 开户地,如北京上海 */
    @ApiModelProperty(value = "开户地,如北京上海")
    private String openAccountaddress;

    /** 货币类型1 CNY 2USD 3 EUR 4GBP */
    @ApiModelProperty(value = "货币类型1 CNY 2USD 3 EUR 4GBP")
    private Integer currency;

    /** iban */
    @ApiModelProperty(value = "iban")
    private String iban;

    /** 支付备注 */
    @ApiModelProperty(value = "支付备注")
    private String bankRemark;

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**  */
    @ApiModelProperty(value = "")
    private Date modifyTime;

    /** 税务局代码 */
    @ApiModelProperty(value = "税务局代码")
    private String taxCode;

    /** 收款国家 */
    @ApiModelProperty(value = "收款国家")
    private String country;

    /** 支付方式所属合同类型: 1:编辑类的支付 2:创意类支付 */
    @ApiModelProperty(value = "支付方式所属合同类型: 1:编辑类的支付 2:创意类支付")
    private Integer assetFamily;

    /** 是否是银行卡: 1:银行卡 0:支付宝 */
    @ApiModelProperty(value = "是否是银行卡: 1:银行卡 0:支付宝")
    private Integer isBank;

    /**  */
    @ApiModelProperty(value = "")
    private String taxRate;

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

    public ProviderPayment setId(Integer id) {
        this.id = id;
		return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public ProviderPayment setProviderId(Integer providerId) {
        this.providerId = providerId;
		return this;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public ProviderPayment setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod == null ? null : paymentMethod.trim();
		return this;
    }

    public String getBranchBankname() {
        return branchBankname;
    }

    public ProviderPayment setBranchBankname(String branchBankname) {
        this.branchBankname = branchBankname == null ? null : branchBankname.trim();
		return this;
    }

    public String getBankName() {
        return bankName;
    }

    public ProviderPayment setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
		return this;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public ProviderPayment setPayeeName(String payeeName) {
        this.payeeName = payeeName == null ? null : payeeName.trim();
		return this;
    }

    public String getPayeeNumber() {
        return payeeNumber;
    }

    public ProviderPayment setPayeeNumber(String payeeNumber) {
        this.payeeNumber = payeeNumber == null ? null : payeeNumber.trim();
		return this;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public ProviderPayment setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode == null ? null : swiftCode.trim();
		return this;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public ProviderPayment setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress == null ? null : bankAddress.trim();
		return this;
    }

    public String getOpenAccountaddress() {
        return openAccountaddress;
    }

    public ProviderPayment setOpenAccountaddress(String openAccountaddress) {
        this.openAccountaddress = openAccountaddress == null ? null : openAccountaddress.trim();
		return this;
    }

    public Integer getCurrency() {
        return currency;
    }

    public ProviderPayment setCurrency(Integer currency) {
        this.currency = currency;
		return this;
    }

    public String getIban() {
        return iban;
    }

    public ProviderPayment setIban(String iban) {
        this.iban = iban == null ? null : iban.trim();
		return this;
    }

    public String getBankRemark() {
        return bankRemark;
    }

    public ProviderPayment setBankRemark(String bankRemark) {
        this.bankRemark = bankRemark == null ? null : bankRemark.trim();
		return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public ProviderPayment setCreateTime(Date createTime) {
        this.createTime = createTime;
		return this;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public ProviderPayment setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
		return this;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public ProviderPayment setTaxCode(String taxCode) {
        this.taxCode = taxCode == null ? null : taxCode.trim();
		return this;
    }

    public String getCountry() {
        return country;
    }

    public ProviderPayment setCountry(String country) {
        this.country = country == null ? null : country.trim();
		return this;
    }

    public Integer getAssetFamily() {
        return assetFamily;
    }

    public ProviderPayment setAssetFamily(Integer assetFamily) {
        this.assetFamily = assetFamily;
		return this;
    }

    public Integer getIsBank() {
        return isBank;
    }

    public ProviderPayment setIsBank(Integer isBank) {
        this.isBank = isBank;
		return this;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public ProviderPayment setTaxRate(String taxRate) {
        this.taxRate = taxRate == null ? null : taxRate.trim();
		return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public ProviderPayment setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
		return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public ProviderPayment setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
		return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public ProviderPayment setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
		return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public ProviderPayment setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
		return this;
    }
}
