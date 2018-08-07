package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class CreativeUpload extends BaseModel<CreativeUpload> {
    private static final long serialVersionUID = 686098692584264924L;

    /** 数据库自增 */
    @ApiModelProperty(value = "数据库自增")
    private Integer id;

    /** 文件名,也是meta表里的master_id */
    @ApiModelProperty(value = "文件名,也是meta表里的master_id")
    private String fileName;

    /** 图片标题 */
    @ApiModelProperty(value = "图片标题")
    private String caption;

    /** 图片关键词 */
    @ApiModelProperty(value = "图片关键词")
    private String keywords;

    /** NR=>No ReleaseMR=>Model ReleaseMR&PR=>Model Release&Property ReleasePR=>Property ReleaseMR&NPR=>Model Release No Property ReleasePR&NMR=>Property Release No Model ReleaseNMR=>No Model ReleaseNPR=>No Property Release*/
    @ApiModelProperty(value = "NR=>No Release MR=>Model ReleaseMR&PR=>Model Release&Property ReleasePR=>Property ReleaseMR&NPR=>Model Release No Property ReleasePR&NMR=>Property Release No Model ReleaseNMR=>No Model ReleaseNPR=>No Property Release")
    private String releaseType;

    /** 摄影师名字 */
    @ApiModelProperty(value = "摄影师名字")
    private String photographerName;

    /** 限制信息 */
    @ApiModelProperty(value = "限制信息")
    private String restriction;

    /** 拍摄日期 */
    @ApiModelProperty(value = "拍摄日期")
    private Date shootDate;

    /** 媒体类型 1:photography  2:Illustration */
    @ApiModelProperty(value = "媒体类型 1:photography  2:Illustration")
    private Integer mediaType;

    /** 物权文件,逗号分隔 */
    @ApiModelProperty(value = "物权文件,逗号分隔")
    private String propertyRelease;

    /** 模特授权文件,逗号分隔 */
    @ApiModelProperty(value = "模特授权文件,逗号分隔")
    private String modelRelease;

    public Integer getId() {
        return id;
    }

    public CreativeUpload setId(Integer id) {
        this.id = id;
		return this;
    }

    public String getFileName() {
        return fileName;
    }

    public CreativeUpload setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
		return this;
    }

    public String getCaption() {
        return caption;
    }

    public CreativeUpload setCaption(String caption) {
        this.caption = caption == null ? null : caption.trim();
		return this;
    }

    public String getKeywords() {
        return keywords;
    }

    public CreativeUpload setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
		return this;
    }

    public String getReleaseType() {
        return releaseType;
    }

    public CreativeUpload setReleaseType(String releaseType) {
        this.releaseType = releaseType == null ? null : releaseType.trim();
		return this;
    }

    public String getPhotographerName() {
        return photographerName;
    }

    public CreativeUpload setPhotographerName(String photographerName) {
        this.photographerName = photographerName == null ? null : photographerName.trim();
		return this;
    }

    public String getRestriction() {
        return restriction;
    }

    public CreativeUpload setRestriction(String restriction) {
        this.restriction = restriction == null ? null : restriction.trim();
		return this;
    }

    public Date getShootDate() {
        return shootDate;
    }

    public CreativeUpload setShootDate(Date shootDate) {
        this.shootDate = shootDate;
		return this;
    }

    public Integer getMediaType() {
        return mediaType;
    }

    public CreativeUpload setMediaType(Integer mediaType) {
        this.mediaType = mediaType;
		return this;
    }

    public String getPropertyRelease() {
        return propertyRelease;
    }

    public CreativeUpload setPropertyRelease(String propertyRelease) {
        this.propertyRelease = propertyRelease == null ? null : propertyRelease.trim();
		return this;
    }

    public String getModelRelease() {
        return modelRelease;
    }

    public CreativeUpload setModelRelease(String modelRelease) {
        this.modelRelease = modelRelease == null ? null : modelRelease.trim();
		return this;
    }
}
