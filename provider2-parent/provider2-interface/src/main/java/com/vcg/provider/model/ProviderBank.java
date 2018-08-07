package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;
import com.vcg.common.base.BaseModel;


public class ProviderBank extends BaseModel<ProviderBank> {
    private static final long serialVersionUID = 5388560544604537949L;

    @ApiModelProperty(value = "银行卡主键id")
    private Integer id;
    
    @ApiModelProperty(value = "开户名")
    private String payeeName;
    
    @ApiModelProperty(value = "卡号或者支付宝号")
    private String payeeNumber;
    
    @ApiModelProperty(value = "开户行")
    private String bankName;
    
    @ApiModelProperty(value = "开户行名称（支行）")
    private String branchBankname;
  
    @ApiModelProperty(value = "开户地,如北京上海")
    private String openAccountaddress;
    
    @ApiModelProperty(value = "1:银行卡 0:支付宝")
    private Integer isBank;
    
    

	public Integer getIsBank() {
		return isBank;
	}

	public void setIsBank(Integer isBank) {
		this.isBank = isBank;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getPayeeNumber() {
		return payeeNumber;
	}

	public void setPayeeNumber(String payeeNumber) {
		this.payeeNumber = payeeNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchBankname() {
		return branchBankname;
	}

	public void setBranchBankname(String branchBankname) {
		this.branchBankname = branchBankname;
	}

	public String getOpenAccountaddress() {
		return openAccountaddress;
	}

	public void setOpenAccountaddress(String openAccountaddress) {
		this.openAccountaddress = openAccountaddress;
	}
    
    
    
 
}
