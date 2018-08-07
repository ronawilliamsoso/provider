package com.vcg.provider.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class MeUpdateProvider {

	
    /** 最终正式供应商ID */
    @ApiModelProperty(value = "最终正式供应商ID")
    private Integer id;
    
    /** 供应商全称（中文名） */
    @ApiModelProperty(value = "供应商名字")
    private String nameCn;
    
    
    /** 供应商身份证 */
    @ApiModelProperty(value = "供应商身份证")
    private String idNum;

    /** 移动电话 */
    @ApiModelProperty(value = "移动电话")
    private String mobile;
    /** Email1 */
    @ApiModelProperty(value = "Email1")
    private String email;
    
    /** 供应商所属公司 */
    @ApiModelProperty(value = "供应商所属公司")
    private String providerCompany;
    
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
    
    
    /** 支付方式id */
    @ApiModelProperty(value = "支付方式id")
    private Integer bankId;
    
    /** 开户银行名称 */
    @ApiModelProperty(value = "开户银行名称")
    private String bankName;
    
    /** 银行账号 */
    @ApiModelProperty(value = "银行账号")
    private String payeeNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProviderCompany() {
		return providerCompany;
	}

	public void setProviderCompany(String providerCompany) {
		this.providerCompany = providerCompany;
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

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getPayeeNumber() {
		return payeeNumber;
	}

	public void setPayeeNumber(String payeeNumber) {
		this.payeeNumber = payeeNumber;
	}
    
 
}
