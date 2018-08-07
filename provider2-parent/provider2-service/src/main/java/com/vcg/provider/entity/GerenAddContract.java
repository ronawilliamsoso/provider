package com.vcg.provider.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;


@ApiModel
public class GerenAddContract extends BaseModel<GerenAddContract> {
    
    
    
	@ApiModelProperty(required=true,value="provider的主键ID")
	private Integer id;
	
	@ApiModelProperty(required=true,value="资源类型：1编辑2创意")
	private Integer assetFamily;
	
	@ApiModelProperty(required=true,value="合同期限(年)")
	private Integer deadline;
	
	@ApiModelProperty(required=true,value="签约主体例如:汉华易美(天津)图像技术有限公司")
	private String contractZhuti;

	@ApiModelProperty(required=true,value="独家信息：0非独家1内容独家2合作独家，通过时必须提供")
	private String exclusiveAuth;
	
	@ApiModelProperty(required=false,value="创意类分成比")
	private String creativeSplitRatio;
	
	@ApiModelProperty(required=false,value="编辑分成比")
	private String editorialSplitRatio;

	@ApiModelProperty(required=true,value="合同类型，1标准，2买断，3解约，4外购 ,5续约")
	private Integer contractType;
	
	@ApiModelProperty(required=true,value="用户中心id")
	private String userCenterId;
	
	@ApiModelProperty(required=true,value="用户名字")
	private String nameCn;
	
	@ApiModelProperty(required=true,value="1媒体2非媒体")
    private Integer jobType;
    
	@ApiModelProperty(required=true,value="所属公司的名字")
    private String providerCompany;
    
	@ApiModelProperty(required=true,value="移动电话")
    private String mobile;
	
	@ApiModelProperty(required=true,value="邮箱")
    private String email;
    
	@ApiModelProperty(required=true,value="1男 2女")
    private Integer sex;
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAssetFamily() {
		return assetFamily;
	}

	public void setAssetFamily(Integer assetFamily) {
		this.assetFamily = assetFamily;
	}

	public Integer getDeadline() {
		return deadline;
	}

	public void setDeadline(Integer deadline) {
		this.deadline = deadline;
	}

	public String getContractZhuti() {
		return contractZhuti;
	}

	public void setContractZhuti(String contractZhuti) {
		this.contractZhuti = contractZhuti;
	}

	public String getExclusiveAuth() {
		return exclusiveAuth;
	}

	public void setExclusiveAuth(String exclusiveAuth) {
		this.exclusiveAuth = exclusiveAuth;
	}

	public String getCreativeSplitRatio() {
		return creativeSplitRatio;
	}

	public void setCreativeSplitRatio(String creativeSplitRatio) {
		this.creativeSplitRatio = creativeSplitRatio;
	}

	public String getEditorialSplitRatio() {
		return editorialSplitRatio;
	}

	public void setEditorialSplitRatio(String editorialSplitRatio) {
		this.editorialSplitRatio = editorialSplitRatio;
	}

	public Integer getContractType() {
		return contractType;
	}

	public void setContractType(Integer contractType) {
		this.contractType = contractType;
	}

	public String getUserCenterId() {
		return userCenterId;
	}

	public void setUserCenterId(String userCenterId) {
		this.userCenterId = userCenterId;
	}

	public String getNameCn() {
		return nameCn;
	}

	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}

	public Integer getJobType() {
		return jobType;
	}

	public void setJobType(Integer jobType) {
		this.jobType = jobType;
	}

	public String getProviderCompany() {
		return providerCompany;
	}

	public void setProviderCompany(String providerCompany) {
		this.providerCompany = providerCompany;
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

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	
	
	 
 

 
}
