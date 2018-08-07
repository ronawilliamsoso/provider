package com.vcg.provider.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
 

@ApiModel
public class ContractApporive {


    @ApiModelProperty(value = "本行数据里的id")
    private Integer id;


    @ApiModelProperty(value = " pass 0:驳回 1:通过")
    private Integer pass;


    @ApiModelProperty(value = "拒绝的时候必填")
    private String reason;
    
    @ApiModelProperty(value = "通过的时候必填,用于生成pdf")
    private String contractUrl;

 

	public String getContractUrl() {
		return contractUrl;
	}


	public void setContractUrl(String contractUrl) {
		this.contractUrl = contractUrl;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getPass() {
		return pass;
	}


	public void setPass(Integer pass) {
		this.pass = pass;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}
 
 
 
     

    
}
