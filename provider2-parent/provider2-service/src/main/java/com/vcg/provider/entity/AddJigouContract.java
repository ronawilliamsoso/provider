package com.vcg.provider.entity;
 

import java.util.Date;
import java.util.List;
import com.vcg.provider.model.ContractAuthorization;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AddJigouContract {

 
    /** 合同名称 */
    @ApiModelProperty(value = "合同id")
    private Integer providerId;
    
    /** 合同名称 */
    @ApiModelProperty(value = "合同名称")
    private String contractName;
    
    /** 合同编号 */
    @ApiModelProperty(value = "合同编号")
    private String contractCode;
    
    

    /** 合同类型，1标准，2买断，3解约，4外购 ,5续约 */
    @ApiModelProperty(value = "合同类型，1标准，2买断，3解约，4外购 ,5续约 6代理 7服务协议 8 海外销售 9其他")
    private Integer contractType;
    
    /** 授权方 */
    @ApiModelProperty(value = "授权方")
    private String providerName;
    
    /** 授权方 */
    @ApiModelProperty(value = "独家信息：0:非独家 1:独家 2:联合独家(非独家) 3.合作独家 ")
    private Integer exclusiveAuth;
    
    
    /** 授权方 */
    @ApiModelProperty(value = "备注")
    private String comment;
    
    public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getExclusiveAuth() {
		return exclusiveAuth;
	}

	public void setExclusiveAuth(Integer exclusiveAuth) {
		this.exclusiveAuth = exclusiveAuth;
	}

	/** 代理方 */
    @ApiModelProperty(value = "代理方")
    private String agentName;
    
    /** 开始时间 */
    @ApiModelProperty(value = "开始时间")
    private Date beginDate;
    
    /** 结束时间 */
    @ApiModelProperty(value = "结束时间")
    private Date endDate;
    

    /** 结算周期 */
    @ApiModelProperty(value = "结算周期")
    private String settlementCycle;
    
    /** 合同期限 */
    @ApiModelProperty(value = "合同期限")
    private String deadline;

    
    /** 付款方式id,contract_pay表里的主键 */
    @ApiModelProperty(value = "银行信息,实际填的是卡号后面对应的主键id")
    private Integer payId;
 
  
    /** 保证金 */
    @ApiModelProperty(value = "保证金,涉及到汇率  所以直接填数据吧")
    private String bond;
 
    
    /** 电子合同附件地址 */
    @ApiModelProperty(value = "电子合同附件地址")
    private String contractPdfPath;
    
    /** 授权数组 */
    @ApiModelProperty(value = "授权数组")
    private List<ContractAuthorization> authorizeList;
    
  
	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public List<ContractAuthorization> getAuthorizeList() {
		return authorizeList;
	}

	public void setAuthorizeList(List<ContractAuthorization> authorizeList) {
		this.authorizeList = authorizeList;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public Integer getContractType() {
		return contractType;
	}

	public void setContractType(Integer contractType) {
		this.contractType = contractType;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getSettlementCycle() {
		return settlementCycle;
	}

	public void setSettlementCycle(String settlementCycle) {
		this.settlementCycle = settlementCycle;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public Integer getPayId() {
		return payId;
	}

	public void setPayId(Integer payId) {
		this.payId = payId;
	}
 
 
	public String getBond() {
		return bond;
	}

	public void setBond(String bond) {
		this.bond = bond;
	}
 

	public String getContractPdfPath() {
		return contractPdfPath;
	}

	public void setContractPdfPath(String contractPdfPath) {
		this.contractPdfPath = contractPdfPath;
	}
    
    
    
 
}
