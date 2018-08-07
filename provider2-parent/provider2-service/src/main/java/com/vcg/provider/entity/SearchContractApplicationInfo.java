package com.vcg.provider.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 申请供稿人合同审核搜索条件
 * @author yanhua.ma
 *
 */
@ApiModel
public class SearchContractApplicationInfo {
	/*资源类型*/
	@ApiModelProperty(required=false,value="资源类型：1 编辑类 2 创意类 3 编辑&创意类")
	private Integer assetFamily;
	/*审核状态*/
	@ApiModelProperty(required=false,value="审核状态：2未审核3驳回 ")
	private Integer auditingStatus;
	/*国家*/
	@ApiModelProperty(required=false,value="国家")
	private String country;
	/*省份*/
	@ApiModelProperty(required=false,value="省份")
	private String province;
	/*城市*/
	@ApiModelProperty(required=false,value="城市")
	private String city;
	 
	@ApiModelProperty(required=false,value="搜索栏的内容")
	private String searchName;
	
	@ApiModelProperty(required=false,value="1:查姓名 2:邮箱 3:手机号")
	private Integer searchType;
	/*当前页*/
	@ApiModelProperty(required=true,value="当前页码")
	private Integer pageNum;
	/*页大小*/
	@ApiModelProperty(required=true,value="每页记录数")
	private Integer pageSize;
	
 
	public Integer getSearchType() {
		return searchType;
	}
	public void setSearchType(Integer searchType) {
		this.searchType = searchType;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public Integer getAssetFamily() {
		return assetFamily;
	}
	public void setAssetFamily(Integer assetFamily) {
		this.assetFamily = assetFamily;
	}
 
	public Integer getAuditingStatus() {
		return auditingStatus;
	}
	public void setAuditingStatus(Integer auditingStatus) {
		this.auditingStatus = auditingStatus;
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
