package com.vcg.provider.entity;
 

import java.util.List;

import com.vcg.provider.model.Contact;
import com.vcg.provider.model.ProviderAccess;
import com.vcg.provider.model.ProviderAccount;
import com.vcg.provider.model.ProviderPayment;
import com.vcg.provider.model.ProviderPortalaccounts;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AddJigouProvider {

 
	
    /** 供应商全称（中文名） */
    @ApiModelProperty(value = "供应商全称")
    private String nameCn;
 

    /** 供应商简称 */
    @ApiModelProperty(value = "供应商简称")
    private String shortName;
    
    /** 供应商类型 */
    @ApiModelProperty(value = "供应商类型1编辑类2创意类3编辑类&创意类4:公关")
    private Integer attribute;
    
    @ApiModelProperty(value = "供应商类型1本土0海外")
    private Integer isNative;
    
    

	/** 国家 */
    @ApiModelProperty(value = "国家")
    private String country;

    /** 省 */
    @ApiModelProperty(value = "省")
    private String province;

    /** 市 */
    @ApiModelProperty(value = "市")
    private String city;

    /** 具体地点 */
    @ApiModelProperty(value = "具体地点")
    private String location;
    
    /** 供应商等级1A+ 2A3B4C5D */
    @ApiModelProperty(value = "供应商等级1A+ 2A3B4C5D")
    private String qualityRank;
 
    /** 备注 */
    @ApiModelProperty(value = "备注")
    private String comment;
 
    /** 联系人数组 */
    @ApiModelProperty(value = "联系人数组")
    private List<Contact> contactList;
    
    /** 接入方式数组 */
    @ApiModelProperty(value = "接入方式数组")
    private List<ProviderAccess> accessList;
    
    /** 供应商提供给我们账号数组 */
    @ApiModelProperty(value = "供应商提供给我们的账号数组")
    private List<ProviderAccount> accountList;
    
    /**支付方式数组 */
    @ApiModelProperty(value = "银行信息数组")
    private List<ProviderPayment> bankList;
    
    /** 营业执照上传后的地址 */
    @ApiModelProperty(value = "营业执照上传后的地址")
    private String operationLicencepic;
    
    /** 税务登记照上传后的地址 */
    @ApiModelProperty(value = "税务登记照上传后的地址")
    private String taxRegistrationpic;
    
    /**提供给供应商登录我们系统的数组 */
    @ApiModelProperty(value = "提供给供应商登录我们系统的数组")
    private List<ProviderPortalaccounts> portalaccList;
 
    
 

	public Integer getIsNative() {
		return isNative;
	}

	public void setIsNative(Integer isNative) {
		this.isNative = isNative;
	}

	public Integer getAttribute() {
		return attribute;
	}

	public void setAttribute(Integer attribute) {
		this.attribute = attribute;
	}

	public String getNameCn() {
		return nameCn;
	}

	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getQualityRank() {
		return qualityRank;
	}

	public void setQualityRank(String qualityRank) {
		this.qualityRank = qualityRank;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	public List<ProviderAccess> getAccessList() {
		return accessList;
	}

	public void setAccessList(List<ProviderAccess> accessList) {
		this.accessList = accessList;
	}

	public List<ProviderAccount> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<ProviderAccount> accountList) {
		this.accountList = accountList;
	}

	public List<ProviderPayment> getBankList() {
		return bankList;
	}

	public void setBankList(List<ProviderPayment> bankList) {
		this.bankList = bankList;
	}

	public String getOperationLicencepic() {
		return operationLicencepic;
	}

	public void setOperationLicencepic(String operationLicencepic) {
		this.operationLicencepic = operationLicencepic;
	}

	public String getTaxRegistrationpic() {
		return taxRegistrationpic;
	}

	public void setTaxRegistrationpic(String taxRegistrationpic) {
		this.taxRegistrationpic = taxRegistrationpic;
	}

	public List<ProviderPortalaccounts> getPortalaccList() {
		return portalaccList;
	}

	public void setPortalaccList(List<ProviderPortalaccounts> portalaccList) {
		this.portalaccList = portalaccList;
	}
    
    
    

 
    
 
}
