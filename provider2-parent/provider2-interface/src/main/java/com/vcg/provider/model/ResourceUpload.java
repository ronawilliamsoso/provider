package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class ResourceUpload extends BaseModel<ResourceUpload> {
    private static final long serialVersionUID = 7075452261292894460L;

    /** 数据库自增 */
    @ApiModelProperty(value = "数据库自增")
    private Integer id;

    /** 文件名,也是meta表里的master_id,不包含后缀 */
    @ApiModelProperty(value = "文件名,也是meta表里的master_id,不包含后缀")
    private String fileName;

    /** 供应商id */
    @ApiModelProperty(value = "供应商id")
    private Integer providerId;

    /** 批次id */
    @ApiModelProperty(value = "批次id")
    private Integer batchId;

    /** 1:编辑类 2:创意类 */
    @ApiModelProperty(value = "1:编辑类 2:创意类")
    private Integer assetFamily;

    /** 图片类型：1摄影图片2 插画 3漫画 4图表 5矢量图 */
    @ApiModelProperty(value = "图片类型：1摄影图片2 插画 3漫画 4图表 5矢量图")
    private Integer graphicalStyle;

    /** 对应的collection,必须匹配 */
    @ApiModelProperty(value = "对应的collection,必须匹配")
    private String collection;

    /** 图片标题,仅供创意类 */
    @ApiModelProperty(value = "图片标题,仅供创意类")
    private String caption;

    /** 标题,仅供编辑类 */
    @ApiModelProperty(value = "标题,仅供编辑类")
    private String title;

    /** 同编审系统的代码: 1RM 2RF */
    @ApiModelProperty(value = "同编审系统的代码: 1RM 2RF")
    private Integer licenseType;

    /** 图片关键词 */
    @ApiModelProperty(value = "图片关键词")
    private String keywords;

    /** 有肖像权 1:是 0:否 */
    @ApiModelProperty(value = "有肖像权 1:是 0:否")
    private Integer haveModelRelease;

    /** 模特授权文件,逗号分隔 */
    @ApiModelProperty(value = "模特授权文件,逗号分隔")
    private String modelRelease;

    /** 有物权 1:是 0:否 */
    @ApiModelProperty(value = "有物权 1:是 0:否")
    private Integer havePropertyRelease;

    /** 物权文件,逗号分隔 */
    @ApiModelProperty(value = "物权文件,逗号分隔")
    private String propertyRelease;

    /** 摄影师名字或者品牌名 */
    @ApiModelProperty(value = "摄影师名字或者品牌名")
    private String creditLine;

    /** 限制信息 */
    @ApiModelProperty(value = "限制信息")
    private String restriction;

    /** 拍摄日期 */
    @ApiModelProperty(value = "拍摄日期")
    private Date shootDate;

    /** 拍摄地点 */
    @ApiModelProperty(value = "拍摄地点")
    private String shootPlace;

    /** oss地址,原图 */
    @ApiModelProperty(value = "oss地址,原图")
    private String ossPath;

    /** 小图地址,字段名字勿改 */
    @ApiModelProperty(value = "小图地址,字段名字勿改")
    private String url;

    /** 1黑白2彩色 */
    @ApiModelProperty(value = "1黑白2彩色")
    private Integer colorType;

    /** 界面填写:1:户外 2:室内 3:影棚 4:都市风光 5:自然风光 */
    @ApiModelProperty(value = "界面填写:1:户外 2:室内 3:影棚 4:都市风光 5:自然风光")
    private Integer shootEnvironment;

    /** 1:已上传 2:已匹配  3:入库失败 4: 已入库 5: 上传失败 */
    @ApiModelProperty(value = "1:已上传 2:已匹配  3:入库失败 4: 已入库 5: 上传失败")
    private Integer resourceStatus;

    /** 1:一个人 2: 两个人 3: 3-5人 4:5人以上 5:无人 */
    @ApiModelProperty(value = "1:一个人 2: 两个人 3: 3-5人 4:5人以上 5:无人")
    private Integer personNumber;

    /** 上传时间 */
    @ApiModelProperty(value = "上传时间")
    private Date createdTime;

    /**  */
    @ApiModelProperty(value = "")
    private Date updatedTime;

    /** 可以提交 0:否 1:是   方便前台显示,不需要后台维护 */
    @ApiModelProperty(value = "可以提交 0:否 1:是   方便前台显示,不需要后台维护")
    private Integer canSubmit;

    /** 不能提交的原因 */
    @ApiModelProperty(value = "不能提交的原因")
    private String reason;

    public Integer getId() {
        return id;
    }

    public ResourceUpload setId(Integer id) {
        this.id = id;
		return this;
    }

    public String getFileName() {
        return fileName;
    }

    public ResourceUpload setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
		return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public ResourceUpload setProviderId(Integer providerId) {
        this.providerId = providerId;
		return this;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public ResourceUpload setBatchId(Integer batchId) {
        this.batchId = batchId;
		return this;
    }

    public Integer getAssetFamily() {
        return assetFamily;
    }

    public ResourceUpload setAssetFamily(Integer assetFamily) {
        this.assetFamily = assetFamily;
		return this;
    }

    public Integer getGraphicalStyle() {
        return graphicalStyle;
    }

    public ResourceUpload setGraphicalStyle(Integer graphicalStyle) {
        this.graphicalStyle = graphicalStyle;
		return this;
    }

    public String getCollection() {
        return collection;
    }

    public ResourceUpload setCollection(String collection) {
        this.collection = collection == null ? null : collection.trim();
		return this;
    }

    public String getCaption() {
        return caption;
    }

    public ResourceUpload setCaption(String caption) {
        this.caption = caption == null ? null : caption.trim();
		return this;
    }

    public String getTitle() {
        return title;
    }

    public ResourceUpload setTitle(String title) {
        this.title = title == null ? null : title.trim();
		return this;
    }

    public Integer getLicenseType() {
        return licenseType;
    }

    public ResourceUpload setLicenseType(Integer licenseType) {
        this.licenseType = licenseType;
		return this;
    }

    public String getKeywords() {
        return keywords;
    }

    public ResourceUpload setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
		return this;
    }

    public Integer getHaveModelRelease() {
        return haveModelRelease;
    }

    public ResourceUpload setHaveModelRelease(Integer haveModelRelease) {
        this.haveModelRelease = haveModelRelease;
		return this;
    }

    public String getModelRelease() {
        return modelRelease;
    }

    public ResourceUpload setModelRelease(String modelRelease) {
        this.modelRelease = modelRelease == null ? null : modelRelease.trim();
		return this;
    }

    public Integer getHavePropertyRelease() {
        return havePropertyRelease;
    }

    public ResourceUpload setHavePropertyRelease(Integer havePropertyRelease) {
        this.havePropertyRelease = havePropertyRelease;
		return this;
    }

    public String getPropertyRelease() {
        return propertyRelease;
    }

    public ResourceUpload setPropertyRelease(String propertyRelease) {
        this.propertyRelease = propertyRelease == null ? null : propertyRelease.trim();
		return this;
    }

    public String getCreditLine() {
        return creditLine;
    }

    public ResourceUpload setCreditLine(String creditLine) {
        this.creditLine = creditLine == null ? null : creditLine.trim();
		return this;
    }

    public String getRestriction() {
        return restriction;
    }

    public ResourceUpload setRestriction(String restriction) {
        this.restriction = restriction == null ? null : restriction.trim();
		return this;
    }

    public Date getShootDate() {
        return shootDate;
    }

    public ResourceUpload setShootDate(Date shootDate) {
        this.shootDate = shootDate;
		return this;
    }

    public String getShootPlace() {
        return shootPlace;
    }

    public ResourceUpload setShootPlace(String shootPlace) {
        this.shootPlace = shootPlace == null ? null : shootPlace.trim();
		return this;
    }

    public String getOssPath() {
        return ossPath;
    }

    public ResourceUpload setOssPath(String ossPath) {
        this.ossPath = ossPath == null ? null : ossPath.trim();
		return this;
    }

    public String getUrl() {
        return url;
    }

    public ResourceUpload setUrl(String url) {
        this.url = url == null ? null : url.trim();
		return this;
    }

    public Integer getColorType() {
        return colorType;
    }

    public ResourceUpload setColorType(Integer colorType) {
        this.colorType = colorType;
		return this;
    }

    public Integer getShootEnvironment() {
        return shootEnvironment;
    }

    public ResourceUpload setShootEnvironment(Integer shootEnvironment) {
        this.shootEnvironment = shootEnvironment;
		return this;
    }

    public Integer getResourceStatus() {
        return resourceStatus;
    }

    public ResourceUpload setResourceStatus(Integer resourceStatus) {
        this.resourceStatus = resourceStatus;
		return this;
    }

    public Integer getPersonNumber() {
        return personNumber;
    }

    public ResourceUpload setPersonNumber(Integer personNumber) {
        this.personNumber = personNumber;
		return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public ResourceUpload setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
		return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public ResourceUpload setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
		return this;
    }

    public Integer getCanSubmit() {
        return canSubmit;
    }

    public ResourceUpload setCanSubmit(Integer canSubmit) {
        this.canSubmit = canSubmit;
		return this;
    }

    public String getReason() {
        return reason;
    }

    public ResourceUpload setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
		return this;
    }
}
