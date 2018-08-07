package com.vcg.provider.entity;
 
import java.util.List;

 
import com.vcg.provider.model.Collection;
import com.vcg.provider.model.Contract;
import com.vcg.provider.model.ContractAuthorization;
import com.vcg.provider.model.ProviderPayment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class JigouContractPackage {
	
    @ApiModelProperty(value = "供应商简称")
    private   String  shortName;

    @ApiModelProperty(value = "合同")
    private   Contract  contract;
    
    @ApiModelProperty(value = "付款方式")
    private   ProviderPayment  providerPayment;
    
    @ApiModelProperty(value = "合同对应的授权")
    private   List<ContractAuthorization>  contractAuthorizationList;
    
    @ApiModelProperty(value = "合同对应的collection")
    private   List<Collection>  collectionList;

	public Contract getContract() {
		return contract;
	}

	public ProviderPayment getProviderPayment() {
		return providerPayment;
	}

	public void setProviderPayment(ProviderPayment providerPayment) {
		this.providerPayment = providerPayment;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public List<ContractAuthorization> getContractAuthorizationList() {
		return contractAuthorizationList;
	}

	public void setContractAuthorizationList(List<ContractAuthorization> contractAuthorizationList) {
		this.contractAuthorizationList = contractAuthorizationList;
	}

	public List<Collection> getCollectionList() {
		return collectionList;
	}

	public void setCollectionList(List<Collection> collectionList) {
		this.collectionList = collectionList;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
    
    
 
 
}
