package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class ContractAuthorization extends BaseModel<ContractAuthorization> {
    private static final long serialVersionUID = 871399976495955187L;

    /**  */
    @ApiModelProperty(value = "")
    private Integer id;

    /** 合同表里的主键id */
    @ApiModelProperty(value = "合同表里的主键id")
    private Integer contractId;

    /** 授权产品编号 */
    @ApiModelProperty(value = "授权产品编号")
    private String productCode;

    /** 1创意图片2:编辑图片3视频4音频 */
    @ApiModelProperty(value = "1创意图片2:编辑图片3视频4音频")
    private Integer assetType;

    /** 1:RM 2:RF 3:RR */
    @ApiModelProperty(value = "1:RM 2:RF 3:RR")
    private Integer authorizationType;

    /** 独家性:0:非独家 1:内容独家  2:联合独家(非独家)3:合作独家 */
    @ApiModelProperty(value = "独家性:0:非独家 1:内容独家  2:联合独家(非独家)3:合作独家")
    private Integer exclusiveType;

    /** 分成比 */
    @ApiModelProperty(value = "分成比")
    private String fenchengRate;

    /** 是否拥有uu权力1:是 0:否 */
    @ApiModelProperty(value = "是否拥有uu权力1:是 0:否")
    private Integer haveUuright;

    /** 是否扣除成本1:是 2:否 */
    @ApiModelProperty(value = "是否扣除成本1:是 2:否")
    private Integer cutCost;

    /** 授权产品状态1:有效 0:失效 */
    @ApiModelProperty(value = "授权产品状态1:有效 0:失效")
    private Integer productStatus;

    /** 授权产品的有效状态 1:有效0:失效 */
    @ApiModelProperty(value = "授权产品的有效状态 1:有效0:失效")
    private Integer authstatus;

    /** 备注 */
    @ApiModelProperty(value = "备注")
    private String comment;

    /**  */
    @ApiModelProperty(value = "")
    private Date createdTime;

    /**  */
    @ApiModelProperty(value = "")
    private String createdBy;

    /**  */
    @ApiModelProperty(value = "")
    private Date updatedTime;

    /**  */
    @ApiModelProperty(value = "")
    private String updatedBy;

    public Integer getId() {
        return id;
    }

    public ContractAuthorization setId(Integer id) {
        this.id = id;
		return this;
    }

    public Integer getContractId() {
        return contractId;
    }

    public ContractAuthorization setContractId(Integer contractId) {
        this.contractId = contractId;
		return this;
    }

    public String getProductCode() {
        return productCode;
    }

    public ContractAuthorization setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
		return this;
    }

    public Integer getAssetType() {
        return assetType;
    }

    public ContractAuthorization setAssetType(Integer assetType) {
        this.assetType = assetType;
		return this;
    }

    public Integer getAuthorizationType() {
        return authorizationType;
    }

    public ContractAuthorization setAuthorizationType(Integer authorizationType) {
        this.authorizationType = authorizationType;
		return this;
    }

    public Integer getExclusiveType() {
        return exclusiveType;
    }

    public ContractAuthorization setExclusiveType(Integer exclusiveType) {
        this.exclusiveType = exclusiveType;
		return this;
    }

    public String getFenchengRate() {
        return fenchengRate;
    }

    public ContractAuthorization setFenchengRate(String fenchengRate) {
        this.fenchengRate = fenchengRate == null ? null : fenchengRate.trim();
		return this;
    }

    public Integer getHaveUuright() {
        return haveUuright;
    }

    public ContractAuthorization setHaveUuright(Integer haveUuright) {
        this.haveUuright = haveUuright;
		return this;
    }

    public Integer getCutCost() {
        return cutCost;
    }

    public ContractAuthorization setCutCost(Integer cutCost) {
        this.cutCost = cutCost;
		return this;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public ContractAuthorization setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
		return this;
    }

    public Integer getAuthstatus() {
        return authstatus;
    }

    public ContractAuthorization setAuthstatus(Integer authstatus) {
        this.authstatus = authstatus;
		return this;
    }

    public String getComment() {
        return comment;
    }

    public ContractAuthorization setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
		return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public ContractAuthorization setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
		return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public ContractAuthorization setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
		return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public ContractAuthorization setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
		return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public ContractAuthorization setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
		return this;
    }
}
