package com.vcg.provider.entity;
 

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ExcelMeta {

 
    @ApiModelProperty(value = "Master_ID")
    private String masterId;
    
    @ApiModelProperty(value = "Creative Collection")
    private String creativeCollection;
    

    @ApiModelProperty(value = "Caption")
    private String caption;
    
    @ApiModelProperty(value = "Keywords")
    private String keywords;
    
    @ApiModelProperty(value = "Release")
    private String release;
    
    @ApiModelProperty(value = "Photographer_Name")
    private String photographerName;
    
    @ApiModelProperty(value = "Rest")
    private String rest;
    
    @ApiModelProperty(value = "Create Date")
    private String createDate;
    
    @ApiModelProperty(value = "Media Type")
    private String   mediaType;
    
    @ApiModelProperty(value = "Visual Color")
    private String   visualColor;
    
    @ApiModelProperty(value = "Release_Name")
    private String   releaseName;
    
    
    
    

	public String getPhotographerName() {
		return photographerName;
	}

	public void setPhotographerName(String photographerName) {
		this.photographerName = photographerName;
	}

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public String getCreativeCollection() {
		return creativeCollection;
	}

	public void setCreativeCollection(String creativeCollection) {
		this.creativeCollection = creativeCollection;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}
 
	public String getRest() {
		return rest;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getVisualColor() {
		return visualColor;
	}

	public void setVisualColor(String visualColor) {
		this.visualColor = visualColor;
	}

	public String getReleaseName() {
		return releaseName;
	}

	public void setReleaseName(String releaseName) {
		this.releaseName = releaseName;
	}
    
    
    
    
  
 
}
