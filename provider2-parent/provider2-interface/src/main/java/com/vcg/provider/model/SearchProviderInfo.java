package com.vcg.provider.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SearchProviderInfo {
	/*资源类型*/
	@ApiModelProperty(required=false,value="资源类型：1 编辑类 2 创意类 3 编辑&创意类")
	private Integer assetFamily;
	/*权限状态*/
	@ApiModelProperty(required=false,value="状态：3 开通  5冻结 6关闭 ")
	private Integer status;
	/*国家*/
	@ApiModelProperty(required=false,value="国家")
	private String country;
	/*省份*/
	@ApiModelProperty(required=false,value="省份")
	private String province;
	/*城市*/
	@ApiModelProperty(required=false,value="城市")
	private String city;
	/*注册时间*/
	@ApiModelProperty(required=false,value="注册时间")
	private String createTimeBegin;
	/*通过时间*/
	@ApiModelProperty(required=false,value="开通时间")
	private String passTimeBegin;
	/*等级*/
	@ApiModelProperty(required=false,value="供应商等级：1A+ 2A3B4C5D")
	private String qualityRank;
	/*账号/名称/手机号*/
	@ApiModelProperty(required=false,value="账号、名称、手机号")
	private String searchName;
	@ApiModelProperty(required=false,value="1:姓名2:邮箱3：手机号")
	private Integer searchType;
	/*供稿人类型*/
	@ApiModelProperty(required=true,value="供稿人类型：1 机构 2 个人")
	private Integer agentType;
	
	@ApiModelProperty(required=false,value="1本土2国外")
	private Integer isNative;
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
	
	public Integer getIsNative() {
		return isNative;
	}
	public void setIsNative(Integer isNative) {
		this.isNative = isNative;
	}
	public Integer getSearchType() {
		return searchType;
	}
	public void setSearchType(Integer searchType) {
		this.searchType = searchType;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	
 
	
	public String getCreateTimeBegin() {
		return createTimeBegin;
	}
	public void setCreateTimeBegin(String createTimeBegin) {
		this.createTimeBegin = createTimeBegin;
	}
	public String getPassTimeBegin() {
		return passTimeBegin;
	}
	public void setPassTimeBegin(String passTimeBegin) {
		this.passTimeBegin = passTimeBegin;
	}
	public String getQualityRank() {
		return qualityRank;
	}
	public void setQualityRank(String qualityRank) {
		this.qualityRank = qualityRank;
	}
	
 
	
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
 
	
	public Integer getAgentType() {
		return agentType;
	}
	public void setAgentType(Integer agentType) {
		this.agentType = agentType;
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
