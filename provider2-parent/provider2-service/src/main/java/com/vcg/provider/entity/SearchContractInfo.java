package com.vcg.provider.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SearchContractInfo {
	/*资源类型*/
	@ApiModelProperty(required=false,value="资源类型：1 编辑类 2 创意类 3 编辑&创意类")
	private Integer assetFamily;
	/*合同类型*/
	@ApiModelProperty(required=false,value="合同属性：1 标准 2 买断 3 解约 4 外购 5续约")
	private Integer contractType;
	/*合同状态*/
	@ApiModelProperty(required=false,value="合同状态：0失效 1 有效")
	private Integer contractStatus;
	/*国家*/
	@ApiModelProperty(required=false,value="地区")
	private String country;
	/*省份*/
	@ApiModelProperty(required=false,value="省份")
	private String province;
	/*城市*/
	@ApiModelProperty(required=false,value="城市")
	private String city;
	/*合同开始时间*/
	@ApiModelProperty(required=false,value="开始时间")
	private String beginDate;
	/*合同结束时间*/
	@ApiModelProperty(required=false,value="结束时间")
	private String endDate;
	/*合同期限*/
	@ApiModelProperty(required=false,value="合同期限")
	private String deadline;
	/*独家授权*/
	@ApiModelProperty(required=false,value="独家信息 0非独家 1 独家")
	private String exclusiveAuth;
	/*授权类型*/
	@ApiModelProperty(required=false,value="授权客户类型：1 RM 2 RF 3 RR")
	private Integer licenseType;
	/*分成比例*/
	@ApiModelProperty(required=false,value="分成比例,由逗号分隔最低值最高值如: 10%-30% 表示为\"0.1,0.3\"")
	private String rate;
	/*账号/名称/手机号*/
	@ApiModelProperty(required=false, value="账号、名称、手机号")
	private String searchName;
	/*供稿人类型*/
	@ApiModelProperty(required=true,value="供稿人类型：1 机构 2 个人")
	private Integer type;
	/*当前页*/
	@ApiModelProperty(required=true,value="当前页码")
	private Integer pageNum;
	/*页大小*/
	@ApiModelProperty(required=true,value="每页记录数")
	private Integer pageSize;
	
	public Integer getAssetFamily() {
		return assetFamily;
	}
	public void setAssetFamily(Integer assetFamily) {
		this.assetFamily = assetFamily;
	}
	
	public Integer getContractType() {
		return contractType;
	}
	public void setContractType(Integer contractType) {
		this.contractType = contractType;
	}
	
	public Integer getContractStatus() {
		return contractStatus;
	}
	public void setContractStatus(Integer contractStatus) {
		this.contractStatus = contractStatus;
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
	
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	public String getExclusiveAuth() {
		return exclusiveAuth;
	}
	public void setExclusiveAuth(String exclusiveAuth) {
		this.exclusiveAuth = exclusiveAuth;
	}
	
	public Integer getLicenseType() {
		return licenseType;
	}
	public void setLicenseType(Integer licenseType) {
		this.licenseType = licenseType;
	}
	
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	
 
	
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
