package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class ContractApplication extends BaseModel<ContractApplication> {
    private static final long serialVersionUID = 5363512381264194657L;

    /** 合同id */
    @ApiModelProperty(value = "合同id")
    private Integer id;

    /** 资源类型：1编辑类，2创意类,3混合类型 */
    @ApiModelProperty(value = "资源类型：1编辑类，2创意类,3混合类型")
    private Integer assetFamily;

    /** 合同编号 */
    @ApiModelProperty(value = "合同编号")
    private String contractId;

    /** 供应商id  来自申请表的主键id */
    @ApiModelProperty(value = "供应商id  来自申请表的主键id")
    private Integer providerId;

    /** 付款方式id */
    @ApiModelProperty(value = "付款方式id")
    private Integer payId;

    /** 授权方 */
    @ApiModelProperty(value = "授权方")
    private String providerName;

    /** 合同类型，1标准，2买断，3解约，4外购, 5 续约 6:摄影师协议 */
    @ApiModelProperty(value = "合同类型，1标准，2买断，3解约，4外购, 5 续约 6:摄影师协议")
    private Integer contractType;

    /** 合同名称 */
    @ApiModelProperty(value = "合同名称")
    private String contractName;

    /** 合同期限,资格申请的时候填入 */
    @ApiModelProperty(value = "合同期限,资格申请的时候填入")
    private String deadline;

    /** 签约时间,合同通过上传pdf的那天 */
    @ApiModelProperty(value = "签约时间,合同通过上传pdf的那天")
    private Date signDate;

    /** 开始时间 */
    @ApiModelProperty(value = "开始时间")
    private Date beginDate;

    /** 结束时间 生效时间加上deadline之后的值 */
    @ApiModelProperty(value = "结束时间 生效时间加上deadline之后的值")
    private Date endDate;

    /** 付款方式 */
    @ApiModelProperty(value = "付款方式")
    private String paymentMethod;

    /** 保证金 */
    @ApiModelProperty(value = "保证金")
    private String bond;

    /** 结算周期 */
    @ApiModelProperty(value = "结算周期")
    private String settlementCycle;

    /** 合同状态 0失效 1 有效 */
    @ApiModelProperty(value = "合同状态 0失效 1 有效")
    private Integer contractStatus;

    /** 1未上传2已上传3驳回 4重新上传,5通过 */
    @ApiModelProperty(value = "1未上传2已上传3驳回 4重新上传,5通过")
    private Integer auditingStatus;

    /** 署名 */
    @ApiModelProperty(value = "署名")
    private String creditLine;

    /** 代理方 */
    @ApiModelProperty(value = "代理方")
    private String agentName;

    /** 创意类分成比 */
    @ApiModelProperty(value = "创意类分成比")
    private String creativeRate;

    /** 编辑类分成比 */
    @ApiModelProperty(value = "编辑类分成比")
    private String editRate;

    /** 独家0非独家1 内容独家 2 合作独家 */
    @ApiModelProperty(value = "独家0非独家1 内容独家 2 合作独家")
    private String exclusiveAuth;

    /** 方式名称 */
    @ApiModelProperty(value = "方式名称")
    private String payMethodName;

    /** 开户银行名称 */
    @ApiModelProperty(value = "开户银行名称")
    private String bankName;

    /** 支行名称 */
    @ApiModelProperty(value = "支行名称")
    private String branchBankname;

    /** 账户名称 */
    @ApiModelProperty(value = "账户名称")
    private String payeeName;

    /** 银行账号 */
    @ApiModelProperty(value = "银行账号")
    private String payeeNumber;

    /** 转银行代码 */
    @ApiModelProperty(value = "转银行代码")
    private String swiftCode;

    /** 开户行地址 */
    @ApiModelProperty(value = "开户行地址")
    private String bankAddress;

    /** 开户地: 如北京上海 */
    @ApiModelProperty(value = "开户地: 如北京上海")
    private String openAccountaddress;

    /** 货币类型1 CNY 2USD 3 EUR 4GBP */
    @ApiModelProperty(value = "货币类型1 CNY 2USD 3 EUR 4GBP")
    private Integer currency;

    /** iban */
    @ApiModelProperty(value = "iban")
    private String iban;

    /**  */
    @ApiModelProperty(value = "")
    private String bankRemark;

    /** 税务局代码 */
    @ApiModelProperty(value = "税务局代码")
    private String taxCode;

    /** 用户中心ID */
    @ApiModelProperty(value = "用户中心ID")
    private String userCenterId;

    /** 收款国家 */
    @ApiModelProperty(value = "收款国家")
    private String country;

    /** 合同签约主体 */
    @ApiModelProperty(value = "合同签约主体")
    private String contractZhuti;

    /** 原因（主要是驳回） */
    @ApiModelProperty(value = "原因（主要是驳回）")
    private String reason;

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

    public ContractApplication setId(Integer id) {
        this.id = id;
		return this;
    }

    public Integer getAssetFamily() {
        return assetFamily;
    }

    public ContractApplication setAssetFamily(Integer assetFamily) {
        this.assetFamily = assetFamily;
		return this;
    }

    public String getContractId() {
        return contractId;
    }

    public ContractApplication setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
		return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public ContractApplication setProviderId(Integer providerId) {
        this.providerId = providerId;
		return this;
    }

    public Integer getPayId() {
        return payId;
    }

    public ContractApplication setPayId(Integer payId) {
        this.payId = payId;
		return this;
    }

    public String getProviderName() {
        return providerName;
    }

    public ContractApplication setProviderName(String providerName) {
        this.providerName = providerName == null ? null : providerName.trim();
		return this;
    }

    public Integer getContractType() {
        return contractType;
    }

    public ContractApplication setContractType(Integer contractType) {
        this.contractType = contractType;
		return this;
    }

    public String getContractName() {
        return contractName;
    }

    public ContractApplication setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
		return this;
    }

    public String getDeadline() {
        return deadline;
    }

    public ContractApplication setDeadline(String deadline) {
        this.deadline = deadline == null ? null : deadline.trim();
		return this;
    }

    public Date getSignDate() {
        return signDate;
    }

    public ContractApplication setSignDate(Date signDate) {
        this.signDate = signDate;
		return this;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public ContractApplication setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
		return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public ContractApplication setEndDate(Date endDate) {
        this.endDate = endDate;
		return this;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public ContractApplication setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod == null ? null : paymentMethod.trim();
		return this;
    }

    public String getBond() {
        return bond;
    }

    public ContractApplication setBond(String bond) {
        this.bond = bond == null ? null : bond.trim();
		return this;
    }

    public String getSettlementCycle() {
        return settlementCycle;
    }

    public ContractApplication setSettlementCycle(String settlementCycle) {
        this.settlementCycle = settlementCycle == null ? null : settlementCycle.trim();
		return this;
    }

    public Integer getContractStatus() {
        return contractStatus;
    }

    public ContractApplication setContractStatus(Integer contractStatus) {
        this.contractStatus = contractStatus;
		return this;
    }

    public Integer getAuditingStatus() {
        return auditingStatus;
    }

    public ContractApplication setAuditingStatus(Integer auditingStatus) {
        this.auditingStatus = auditingStatus;
		return this;
    }

    public String getCreditLine() {
        return creditLine;
    }

    public ContractApplication setCreditLine(String creditLine) {
        this.creditLine = creditLine == null ? null : creditLine.trim();
		return this;
    }

    public String getAgentName() {
        return agentName;
    }

    public ContractApplication setAgentName(String agentName) {
        this.agentName = agentName == null ? null : agentName.trim();
		return this;
    }

    public String getCreativeRate() {
        return creativeRate;
    }

    public ContractApplication setCreativeRate(String creativeRate) {
        this.creativeRate = creativeRate == null ? null : creativeRate.trim();
		return this;
    }

    public String getEditRate() {
        return editRate;
    }

    public ContractApplication setEditRate(String editRate) {
        this.editRate = editRate == null ? null : editRate.trim();
		return this;
    }

    public String getExclusiveAuth() {
        return exclusiveAuth;
    }

    public ContractApplication setExclusiveAuth(String exclusiveAuth) {
        this.exclusiveAuth = exclusiveAuth == null ? null : exclusiveAuth.trim();
		return this;
    }

    public String getPayMethodName() {
        return payMethodName;
    }

    public ContractApplication setPayMethodName(String payMethodName) {
        this.payMethodName = payMethodName == null ? null : payMethodName.trim();
		return this;
    }

    public String getBankName() {
        return bankName;
    }

    public ContractApplication setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
		return this;
    }

    public String getBranchBankname() {
        return branchBankname;
    }

    public ContractApplication setBranchBankname(String branchBankname) {
        this.branchBankname = branchBankname == null ? null : branchBankname.trim();
		return this;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public ContractApplication setPayeeName(String payeeName) {
        this.payeeName = payeeName == null ? null : payeeName.trim();
		return this;
    }

    public String getPayeeNumber() {
        return payeeNumber;
    }

    public ContractApplication setPayeeNumber(String payeeNumber) {
        this.payeeNumber = payeeNumber == null ? null : payeeNumber.trim();
		return this;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public ContractApplication setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode == null ? null : swiftCode.trim();
		return this;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public ContractApplication setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress == null ? null : bankAddress.trim();
		return this;
    }

    public String getOpenAccountaddress() {
        return openAccountaddress;
    }

    public ContractApplication setOpenAccountaddress(String openAccountaddress) {
        this.openAccountaddress = openAccountaddress == null ? null : openAccountaddress.trim();
		return this;
    }

    public Integer getCurrency() {
        return currency;
    }

    public ContractApplication setCurrency(Integer currency) {
        this.currency = currency;
		return this;
    }

    public String getIban() {
        return iban;
    }

    public ContractApplication setIban(String iban) {
        this.iban = iban == null ? null : iban.trim();
		return this;
    }

    public String getBankRemark() {
        return bankRemark;
    }

    public ContractApplication setBankRemark(String bankRemark) {
        this.bankRemark = bankRemark == null ? null : bankRemark.trim();
		return this;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public ContractApplication setTaxCode(String taxCode) {
        this.taxCode = taxCode == null ? null : taxCode.trim();
		return this;
    }

    public String getUserCenterId() {
        return userCenterId;
    }

    public ContractApplication setUserCenterId(String userCenterId) {
        this.userCenterId = userCenterId == null ? null : userCenterId.trim();
		return this;
    }

    public String getCountry() {
        return country;
    }

    public ContractApplication setCountry(String country) {
        this.country = country == null ? null : country.trim();
		return this;
    }

    public String getContractZhuti() {
        return contractZhuti;
    }

    public ContractApplication setContractZhuti(String contractZhuti) {
        this.contractZhuti = contractZhuti == null ? null : contractZhuti.trim();
		return this;
    }

    public String getReason() {
        return reason;
    }

    public ContractApplication setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
		return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public ContractApplication setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
		return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public ContractApplication setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
		return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public ContractApplication setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
		return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public ContractApplication setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
		return this;
    }
}
