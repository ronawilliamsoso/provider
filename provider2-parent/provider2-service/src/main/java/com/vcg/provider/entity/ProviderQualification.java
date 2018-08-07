package com.vcg.provider.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
//供应商资格审核的时候,点击通过和不通过的时候要传的参数
public class ProviderQualification {
	
	@ApiModelProperty(required=true,value="申请ID")
	private Integer id;
	@ApiModelProperty(required=false,value="资源类型：1编辑2创意3编辑&创意，驳回时此参数不用传，通过时必须指定通过哪一类型")
	private Integer assetFamily;
	@ApiModelProperty(required=true,value="是否通过，0否1是")
	private Integer pass;
	@ApiModelProperty(required=false,value="通过原因，不通过必须给出原因")
	private String reason;
	@ApiModelProperty(required=true,value="合同期限(年)")
	private Integer deadline;
	@ApiModelProperty(required=false,value="独家信息：0非独家1内容独家2合作独家，通过时必须提供")
	private String contractZhuti;
	@ApiModelProperty(required=false,value="签约主体例如:汉华易美(天津)图像技术有限公司")
	private String exclusiveAuth;
	@ApiModelProperty(required=false,value="创意类分成比")
	private String creativeSplitRatio;
	@ApiModelProperty(required=false,value="编辑分成比")
	private String editorialSplitRatio;
	@ApiModelProperty(required=false,value="合同类型，1标准，2买断，3解约，4外购 ,5续约")
	private Integer contractType;
	@ApiModelProperty(required=false,value="合同编号")
	private String contractCode;
	
	
 
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	public Integer getContractType() {
		return contractType;
	}
	public void setContractType(Integer contractType) {
		this.contractType = contractType;
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
	public String getContractZhuti() {
		return contractZhuti;
	}
	public void setContractZhuti(String contractZhuti) {
		this.contractZhuti = contractZhuti;
	}
	public Integer getDeadline() {
		return deadline;
	}
	public void setDeadline(Integer deadline) {
		this.deadline = deadline;
	}
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

	public String getExclusiveAuth() {
		return exclusiveAuth;
	}
	public void setExclusiveAuth(String exclusiveAuth) {
		this.exclusiveAuth = exclusiveAuth;
	}
	
}
