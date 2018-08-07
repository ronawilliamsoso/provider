package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class Brand extends BaseModel<Brand> {
    private static final long serialVersionUID = 5127165055640092327L;

    /**  */
    @ApiModelProperty(value = "")
    private Integer id;

    /** brand 名字 */
    @ApiModelProperty(value = "brand 名字")
    private String brandName;

    /** collection的数量,展示的时候算出来,不需要维护 */
    @ApiModelProperty(value = "collection的数量,展示的时候算出来,不需要维护")
    private Integer collectionNumber;

    /** 1:有效0:失效 2:新建 */
    @ApiModelProperty(value = "1:有效0:失效 2:新建")
    private Integer brandStatus;

    /** 隐藏状态 0:隐藏 1:不隐藏 */
    @ApiModelProperty(value = "隐藏状态 0:隐藏 1:不隐藏")
    private Integer hidenStatus;

    /** 类型 1编辑类2创意类 */
    @ApiModelProperty(value = "类型 1编辑类2创意类")
    private Integer assetFamily;

    /** 媒资类型1图片2视频3音频 */
    @ApiModelProperty(value = "媒资类型1图片2视频3音频")
    private Integer assetType;

    /** 授权客户类型1:RM2:RF3: RR */
    @ApiModelProperty(value = "授权客户类型1:RM2:RF3: RR")
    private Integer licenseType;

    /** brand 名字的拼音 */
    @ApiModelProperty(value = "brand 名字的拼音")
    private String pinYin;

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

    /** 备注 */
    @ApiModelProperty(value = "备注")
    private String comment;

    public Integer getId() {
        return id;
    }

    public Brand setId(Integer id) {
        this.id = id;
		return this;
    }

    public String getBrandName() {
        return brandName;
    }

    public Brand setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
		return this;
    }

    public Integer getCollectionNumber() {
        return collectionNumber;
    }

    public Brand setCollectionNumber(Integer collectionNumber) {
        this.collectionNumber = collectionNumber;
		return this;
    }

    public Integer getBrandStatus() {
        return brandStatus;
    }

    public Brand setBrandStatus(Integer brandStatus) {
        this.brandStatus = brandStatus;
		return this;
    }

    public Integer getHidenStatus() {
        return hidenStatus;
    }

    public Brand setHidenStatus(Integer hidenStatus) {
        this.hidenStatus = hidenStatus;
		return this;
    }

    public Integer getAssetFamily() {
        return assetFamily;
    }

    public Brand setAssetFamily(Integer assetFamily) {
        this.assetFamily = assetFamily;
		return this;
    }

    public Integer getAssetType() {
        return assetType;
    }

    public Brand setAssetType(Integer assetType) {
        this.assetType = assetType;
		return this;
    }

    public Integer getLicenseType() {
        return licenseType;
    }

    public Brand setLicenseType(Integer licenseType) {
        this.licenseType = licenseType;
		return this;
    }

    public String getPinYin() {
        return pinYin;
    }

    public Brand setPinYin(String pinYin) {
        this.pinYin = pinYin == null ? null : pinYin.trim();
		return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public Brand setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
		return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Brand setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
		return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public Brand setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
		return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public Brand setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
		return this;
    }

    public String getComment() {
        return comment;
    }

    public Brand setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
		return this;
    }
}
