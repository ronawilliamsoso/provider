package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class ResourceUploadMetaContent extends BaseModel<ResourceUploadMetaContent> {
    private static final long serialVersionUID = 5813802059833549041L;

    /** 数据库自增 */
    @ApiModelProperty(value = "数据库自增")
    private Integer id;

    /** 不带扩展名的文件名 */
    @ApiModelProperty(value = "不带扩展名的文件名")
    private String imageName;

    /** 供应商id */
    @ApiModelProperty(value = "供应商id")
    private Integer providerId;

    /** 批次id */
    @ApiModelProperty(value = "批次id")
    private Integer batchId;

    /** collection 名称 */
    @ApiModelProperty(value = "collection 名称")
    private String collection;

    /** 标题 */
    @ApiModelProperty(value = "标题")
    private String caption;

    /** 1:RM 2:RF */
    @ApiModelProperty(value = "1:RM 2:RF")
    private Integer licenseType;

    /** 关键词 */
    @ApiModelProperty(value = "关键词")
    private String keywords;

    /** 1:Y 0:N */
    @ApiModelProperty(value = "1:Y 0:N")
    private Integer modelRelease;

    /** 肖像权文件,逗号分隔多个 */
    @ApiModelProperty(value = "肖像权文件,逗号分隔多个")
    private String modelReleaseName;

    /** 1:Y 0:N */
    @ApiModelProperty(value = "1:Y 0:N")
    private Integer propertyRelease;

    /** 物权文件名字,多个文件分隔 */
    @ApiModelProperty(value = "物权文件名字,多个文件分隔")
    private String propertyReleaseName;

    /** 签名 */
    @ApiModelProperty(value = "签名")
    private String creditLine;

    /** 限制信息 */
    @ApiModelProperty(value = "限制信息")
    private String rest;

    /**  */
    @ApiModelProperty(value = "")
    private Date createDate;

    /** 1:Photography  2:Illustration 3:Vector */
    @ApiModelProperty(value = "1:Photography  2:Illustration 3:Vector")
    private Integer mediaType;

    /** 2:Color Image  1:Black&White */
    @ApiModelProperty(value = "2:Color Image  1:Black&White")
    private Integer colorType;

    public Integer getId() {
        return id;
    }

    public ResourceUploadMetaContent setId(Integer id) {
        this.id = id;
		return this;
    }

    public String getImageName() {
        return imageName;
    }

    public ResourceUploadMetaContent setImageName(String imageName) {
        this.imageName = imageName == null ? null : imageName.trim();
		return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public ResourceUploadMetaContent setProviderId(Integer providerId) {
        this.providerId = providerId;
		return this;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public ResourceUploadMetaContent setBatchId(Integer batchId) {
        this.batchId = batchId;
		return this;
    }

    public String getCollection() {
        return collection;
    }

    public ResourceUploadMetaContent setCollection(String collection) {
        this.collection = collection == null ? null : collection.trim();
		return this;
    }

    public String getCaption() {
        return caption;
    }

    public ResourceUploadMetaContent setCaption(String caption) {
        this.caption = caption == null ? null : caption.trim();
		return this;
    }

    public Integer getLicenseType() {
        return licenseType;
    }

    public ResourceUploadMetaContent setLicenseType(Integer licenseType) {
        this.licenseType = licenseType;
		return this;
    }

    public String getKeywords() {
        return keywords;
    }

    public ResourceUploadMetaContent setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
		return this;
    }

    public Integer getModelRelease() {
        return modelRelease;
    }

    public ResourceUploadMetaContent setModelRelease(Integer modelRelease) {
        this.modelRelease = modelRelease;
		return this;
    }

    public String getModelReleaseName() {
        return modelReleaseName;
    }

    public ResourceUploadMetaContent setModelReleaseName(String modelReleaseName) {
        this.modelReleaseName = modelReleaseName == null ? null : modelReleaseName.trim();
		return this;
    }

    public Integer getPropertyRelease() {
        return propertyRelease;
    }

    public ResourceUploadMetaContent setPropertyRelease(Integer propertyRelease) {
        this.propertyRelease = propertyRelease;
		return this;
    }

    public String getPropertyReleaseName() {
        return propertyReleaseName;
    }

    public ResourceUploadMetaContent setPropertyReleaseName(String propertyReleaseName) {
        this.propertyReleaseName = propertyReleaseName == null ? null : propertyReleaseName.trim();
		return this;
    }

    public String getCreditLine() {
        return creditLine;
    }

    public ResourceUploadMetaContent setCreditLine(String creditLine) {
        this.creditLine = creditLine == null ? null : creditLine.trim();
		return this;
    }

    public String getRest() {
        return rest;
    }

    public ResourceUploadMetaContent setRest(String rest) {
        this.rest = rest == null ? null : rest.trim();
		return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public ResourceUploadMetaContent setCreateDate(Date createDate) {
        this.createDate = createDate;
		return this;
    }

    public Integer getMediaType() {
        return mediaType;
    }

    public ResourceUploadMetaContent setMediaType(Integer mediaType) {
        this.mediaType = mediaType;
		return this;
    }

    public Integer getColorType() {
        return colorType;
    }

    public ResourceUploadMetaContent setColorType(Integer colorType) {
        this.colorType = colorType;
		return this;
    }
}
