package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;
import java.util.List;


public class Provider extends BaseModel<Provider> {
    private static final long serialVersionUID = 2751330468867517234L;

    /** 最终正式供应商ID */
    @ApiModelProperty(value = "最终正式供应商ID")
    private Integer id;

    /** 供应商全称（中文名） */
    @ApiModelProperty(value = "供应商全称（中文名）")
    private String nameCn;

    /** 供应商全称（英文名） */
    @ApiModelProperty(value = "供应商全称（英文名）")
    private String nameEn;

    /** 供应商简称 */
    @ApiModelProperty(value = "供应商简称")
    private String shortName;

    /** 1机构2 个人 */
    @ApiModelProperty(value = "1机构2 个人")
    private Integer agentType;

    /** 供应商类型1编辑类2创意类3编辑类&创意类4:公关 */
    @ApiModelProperty(value = "供应商类型1编辑类2创意类3编辑类&创意类4:公关")
    private Integer assetFamily;

    /** 1:个人摄影师 2:个人摄影师(漫画/插画) 3:公司上传账号 4:海外代理商(getty) 5:海外代理商(非getty)6:海外摄影师7:合同续存期非独家摄影师8核心摄影师9:买断供应商10买断摄影师 */
    @ApiModelProperty(value = "1:个人摄影师 2:个人摄影师(漫画/插画) 3:公司上传账号 4:海外代理商(getty) 5:海外代理商(非getty)6:海外摄影师7:合同续存期非独家摄影师8核心摄影师9:买断供应商10买断摄影师")
    private Integer photographerType;

    /** 国家 */
    @ApiModelProperty(value = "国家")
    private String country;

    /** 省 */
    @ApiModelProperty(value = "省")
    private String province;

    /** 市 */
    @ApiModelProperty(value = "市")
    private String city;

    /** 目前居住城市 */
    @ApiModelProperty(value = "目前居住城市")
    private String liveCity;

    /** 具体地点 */
    @ApiModelProperty(value = "具体地点")
    private String location;

    /** 供应商所属公司 */
    @ApiModelProperty(value = "供应商所属公司")
    private String company;

    /** 从业类型1媒体2非媒体 */
    @ApiModelProperty(value = "从业类型1媒体2非媒体")
    private Integer jobType;

    /** 供应商等级1A+ 2A3B4C5D */
    @ApiModelProperty(value = "供应商等级1A+ 2A3B4C5D")
    private String qualityRank;

    /** 用户中心id */
    @ApiModelProperty(value = "用户中心id")
    private String userCenterId;

    /** 状态 3 开通 5冻结 6关闭  */
    @ApiModelProperty(value = "状态 3 开通 5冻结 6关闭 ")
    private Integer status;

    /** 1本土2国外 */
    @ApiModelProperty(value = "1本土2国外")
    private Integer isNative;

    /** 营业执照照片 */
    @ApiModelProperty(value = "营业执照照片")
    private String licencePic;

    /** 税务登记照片 */
    @ApiModelProperty(value = "税务登记照片")
    private String taxPic;

    /** 备注 */
    @ApiModelProperty(value = "备注")
    private String comment;

    /** 署名 供应商笔名  摄影师艺名 */
    @ApiModelProperty(value = "署名 供应商笔名  摄影师艺名")
    private String signatureName;

    /**  */
    @ApiModelProperty(value = "")
    private Date createdTime;

    /**  */
    @ApiModelProperty(value = "")
    private String createdBy;

    /**  */
    @ApiModelProperty(value = "")
    private Date updatedTime;

    @ApiModelProperty(value = "collections")
    private List<Collection> colls;
    
    /**  */
    @ApiModelProperty(value = "")
    private String updatedBy;

    public Integer getId() {
        return id;
    }

    public List<Collection> getColls() {
		return colls;
	}

	public void setColls(List<Collection> colls) {
		this.colls = colls;
	}

	public Provider setId(Integer id) {
        this.id = id;
		return this;
    }

    public String getNameCn() {
        return nameCn;
    }

    public Provider setNameCn(String nameCn) {
        this.nameCn = nameCn == null ? null : nameCn.trim();
		return this;
    }

    public String getNameEn() {
        return nameEn;
    }

    public Provider setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
		return this;
    }

    public String getShortName() {
        return shortName;
    }

    public Provider setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
		return this;
    }

    public Integer getAgentType() {
        return agentType;
    }

    public Provider setAgentType(Integer agentType) {
        this.agentType = agentType;
		return this;
    }

    public Integer getAssetFamily() {
        return assetFamily;
    }

    public Provider setAssetFamily(Integer assetFamily) {
        this.assetFamily = assetFamily;
		return this;
    }

    public Integer getPhotographerType() {
        return photographerType;
    }

    public Provider setPhotographerType(Integer photographerType) {
        this.photographerType = photographerType;
		return this;
    }

    public String getCountry() {
        return country;
    }

    public Provider setCountry(String country) {
        this.country = country == null ? null : country.trim();
		return this;
    }

    public String getProvince() {
        return province;
    }

    public Provider setProvince(String province) {
        this.province = province == null ? null : province.trim();
		return this;
    }

    public String getCity() {
        return city;
    }

    public Provider setCity(String city) {
        this.city = city == null ? null : city.trim();
		return this;
    }

    public String getLiveCity() {
        return liveCity;
    }

    public Provider setLiveCity(String liveCity) {
        this.liveCity = liveCity == null ? null : liveCity.trim();
		return this;
    }

    public String getLocation() {
        return location;
    }

    public Provider setLocation(String location) {
        this.location = location == null ? null : location.trim();
		return this;
    }

    public String getCompany() {
        return company;
    }

    public Provider setCompany(String company) {
        this.company = company == null ? null : company.trim();
		return this;
    }

    public Integer getJobType() {
        return jobType;
    }

    public Provider setJobType(Integer jobType) {
        this.jobType = jobType;
		return this;
    }

    public String getQualityRank() {
        return qualityRank;
    }

    public Provider setQualityRank(String qualityRank) {
        this.qualityRank = qualityRank == null ? null : qualityRank.trim();
		return this;
    }

    public String getUserCenterId() {
        return userCenterId;
    }

    public Provider setUserCenterId(String userCenterId) {
        this.userCenterId = userCenterId == null ? null : userCenterId.trim();
		return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Provider setStatus(Integer status) {
        this.status = status;
		return this;
    }

    public Integer getIsNative() {
        return isNative;
    }

    public Provider setIsNative(Integer isNative) {
        this.isNative = isNative;
		return this;
    }

    public String getLicencePic() {
        return licencePic;
    }

    public Provider setLicencePic(String licencePic) {
        this.licencePic = licencePic == null ? null : licencePic.trim();
		return this;
    }

    public String getTaxPic() {
        return taxPic;
    }

    public Provider setTaxPic(String taxPic) {
        this.taxPic = taxPic == null ? null : taxPic.trim();
		return this;
    }

    public String getComment() {
        return comment;
    }

    public Provider setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
		return this;
    }

    public String getSignatureName() {
        return signatureName;
    }

    public Provider setSignatureName(String signatureName) {
        this.signatureName = signatureName == null ? null : signatureName.trim();
		return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public Provider setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
		return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Provider setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
		return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public Provider setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
		return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public Provider setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
		return this;
    }
}
