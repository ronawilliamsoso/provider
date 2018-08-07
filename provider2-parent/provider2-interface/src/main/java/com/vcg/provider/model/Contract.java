package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class Contract extends BaseModel<Contract> {
    private static final long serialVersionUID = 3460001470590960960L;

    /** 合同id */
    @ApiModelProperty(value = "合同id")
    private Integer id;

    /** 资源类型：1编辑类，2创意类,3编辑&创意类型 */
    @ApiModelProperty(value = "资源类型：1编辑类，2创意类,3编辑&创意类型")
    private Integer assetFamily;

    /** 合同编号 */
    @ApiModelProperty(value = "合同编号")
    private String contractCode;

    /** 供应商表里的主键id 授权方 */
    @ApiModelProperty(value = "供应商表里的主键id 授权方")
    private Integer providerId;

    /** 付款方式id,contract_pay表里的主键 */
    @ApiModelProperty(value = "付款方式id,contract_pay表里的主键")
    private Integer paymentId;

    /** 授权方,乙方 */
    @ApiModelProperty(value = "授权方,乙方")
    private String partyB;

    /** 合同类型 1标准，2买断，3解约，4外购 ,5续约 */
    @ApiModelProperty(value = "合同类型 1标准，2买断，3解约，4外购 ,5续约")
    private Integer contractType;

    /** 合同名称 */
    @ApiModelProperty(value = "合同名称")
    private String contractName;

    /** 合同期限 */
    @ApiModelProperty(value = "合同期限")
    private String deadline;

    /** 签约时间 */
    @ApiModelProperty(value = "签约时间")
    private Date signDate;

    /** 开始时间 */
    @ApiModelProperty(value = "开始时间")
    private Date beginDate;

    /** 结束时间 */
    @ApiModelProperty(value = "结束时间")
    private Date endDate;

    /** 保证金 */
    @ApiModelProperty(value = "保证金")
    private String bond;

    /** 结算周期 */
    @ApiModelProperty(value = "结算周期")
    private String settlementCycle;

    /** 合同状态 0失效 1 有效 */
    @ApiModelProperty(value = "合同状态 0失效 1 有效")
    private Integer contractStatus;

    /** 电子合同附件地址,多个文件逗号分隔 */
    @ApiModelProperty(value = "电子合同附件地址,多个文件逗号分隔")
    private String contractPdfPath;

    /** 摄影师&供应商签名 */
    @ApiModelProperty(value = "摄影师&供应商签名")
    private String creditLine;

    /** 代理方 甲方 */
    @ApiModelProperty(value = "代理方 甲方")
    private String partyA;

    /** 电子合同时间戳 */
    @ApiModelProperty(value = "电子合同时间戳")
    private String electronicStamp;

    /** 摄影师独家信息：1合作独家2 内容独家3:联合独家(非独家) 4:非独家 */
    @ApiModelProperty(value = "摄影师独家信息：1合作独家2 内容独家3:联合独家(非独家) 4:非独家")
    private Integer exclusiveAuth;

    /** 备注 */
    @ApiModelProperty(value = "备注")
    private String comment;

    /** 合同剩余天数，查询临时查出，不用系统维护 */
    @ApiModelProperty(value = "合同剩余天数，查询临时查出，不用系统维护")
    private Integer leftDays;

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

    /** 编辑类分成比 */
    @ApiModelProperty(value = "编辑类分成比")
    private String editRate;

    /** 创意类分成比 */
    @ApiModelProperty(value = "创意类分成比")
    private String creativeRate;

    public Integer getId() {
        return id;
    }

    public Contract setId(Integer id) {
        this.id = id;
		return this;
    }

    public Integer getAssetFamily() {
        return assetFamily;
    }

    public Contract setAssetFamily(Integer assetFamily) {
        this.assetFamily = assetFamily;
		return this;
    }

    public String getContractCode() {
        return contractCode;
    }

    public Contract setContractCode(String contractCode) {
        this.contractCode = contractCode == null ? null : contractCode.trim();
		return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public Contract setProviderId(Integer providerId) {
        this.providerId = providerId;
		return this;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public Contract setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
		return this;
    }

    public String getPartyB() {
        return partyB;
    }

    public Contract setPartyB(String partyB) {
        this.partyB = partyB == null ? null : partyB.trim();
		return this;
    }

    public Integer getContractType() {
        return contractType;
    }

    public Contract setContractType(Integer contractType) {
        this.contractType = contractType;
		return this;
    }

    public String getContractName() {
        return contractName;
    }

    public Contract setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
		return this;
    }

    public String getDeadline() {
        return deadline;
    }

    public Contract setDeadline(String deadline) {
        this.deadline = deadline == null ? null : deadline.trim();
		return this;
    }

    public Date getSignDate() {
        return signDate;
    }

    public Contract setSignDate(Date signDate) {
        this.signDate = signDate;
		return this;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public Contract setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
		return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Contract setEndDate(Date endDate) {
        this.endDate = endDate;
		return this;
    }

    public String getBond() {
        return bond;
    }

    public Contract setBond(String bond) {
        this.bond = bond == null ? null : bond.trim();
		return this;
    }

    public String getSettlementCycle() {
        return settlementCycle;
    }

    public Contract setSettlementCycle(String settlementCycle) {
        this.settlementCycle = settlementCycle == null ? null : settlementCycle.trim();
		return this;
    }

    public Integer getContractStatus() {
        return contractStatus;
    }

    public Contract setContractStatus(Integer contractStatus) {
        this.contractStatus = contractStatus;
		return this;
    }

    public String getContractPdfPath() {
        return contractPdfPath;
    }

    public Contract setContractPdfPath(String contractPdfPath) {
        this.contractPdfPath = contractPdfPath == null ? null : contractPdfPath.trim();
		return this;
    }

    public String getCreditLine() {
        return creditLine;
    }

    public Contract setCreditLine(String creditLine) {
        this.creditLine = creditLine == null ? null : creditLine.trim();
		return this;
    }

    public String getPartyA() {
        return partyA;
    }

    public Contract setPartyA(String partyA) {
        this.partyA = partyA == null ? null : partyA.trim();
		return this;
    }

    public String getElectronicStamp() {
        return electronicStamp;
    }

    public Contract setElectronicStamp(String electronicStamp) {
        this.electronicStamp = electronicStamp == null ? null : electronicStamp.trim();
		return this;
    }

    public Integer getExclusiveAuth() {
        return exclusiveAuth;
    }

    public Contract setExclusiveAuth(Integer exclusiveAuth) {
        this.exclusiveAuth = exclusiveAuth;
		return this;
    }

    public String getComment() {
        return comment;
    }

    public Contract setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
		return this;
    }

    public Integer getLeftDays() {
        return leftDays;
    }

    public Contract setLeftDays(Integer leftDays) {
        this.leftDays = leftDays;
		return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public Contract setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
		return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Contract setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
		return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public Contract setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
		return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public Contract setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
		return this;
    }

    public String getEditRate() {
        return editRate;
    }

    public Contract setEditRate(String editRate) {
        this.editRate = editRate == null ? null : editRate.trim();
		return this;
    }

    public String getCreativeRate() {
        return creativeRate;
    }

    public Contract setCreativeRate(String creativeRate) {
        this.creativeRate = creativeRate == null ? null : creativeRate.trim();
		return this;
    }
}
