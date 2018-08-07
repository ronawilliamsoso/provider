package com.vcg.provider.entity;

public class ResourceInfo {
	private Integer model_release;
	private String[] model_release_id;
	private String keywords;
	private long date_camera_shot;
	private String[] property_release_id;
	private String provider_res_id;
	private Integer people;
	private String url;
	private String city;
	private String country;
	private Integer asset_family;
	private String category;
	private Integer property_release;
	private String province;
	private Integer graphical_style;
	private Integer color_type;
	private String credit_line;
	private String caption;
	private String location;
	private String title;
	private String quality_rank;
	private String people_name;
	
	private String fileName;
	
	//中小供应商添加 2016-12-16
	private String collection;
	private String rest;
	private String jpgForEpsUrl;
	private Integer licenseType;
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getColor_type() {
		return color_type;
	}
	public String getPeople_name() {
		return people_name;
	}
	public void setPeople_name(String people_name) {
		this.people_name = people_name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getQuality_rank() {
		return quality_rank;
	}
	public void setQuality_rank(String quality_rank) {
		this.quality_rank = quality_rank;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getModel_release() {
		return model_release;
	}
	public void setModel_release(Integer model_release) {
		this.model_release = model_release;
	}
	public String[] getModel_release_id() {
		return model_release_id;
	}
	public void setModel_release_id(String[] model_release_id) {
		this.model_release_id = model_release_id;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public long getDate_camera_shot() {
		return date_camera_shot;
	}
	public void setDate_camera_shot(long date_camera_shot) {
		this.date_camera_shot = date_camera_shot;
	}
	public String[] getProperty_release_id() {
		return property_release_id;
	}
	public void setProperty_release_id(String[] property_release_id) {
		this.property_release_id = property_release_id;
	}
	public String getProvider_res_id() {
		return provider_res_id;
	}
	public void setProvider_res_id(String provider_res_id) {
		this.provider_res_id = provider_res_id;
	}
	
	public Integer getPeople() {
		return people;
	}
	public void setPeople(Integer people) {
		this.people = people;
	}
	public void setColor_type(Integer color_type) {
		this.color_type = color_type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getAsset_family() {
		return asset_family;
	}
	public void setAsset_family(Integer asset_family) {
		this.asset_family = asset_family;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getProperty_release() {
		return property_release;
	}
	public void setProperty_release(Integer property_release) {
		this.property_release = property_release;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public Integer getGraphical_style() {
		return graphical_style;
	}
	public void setGraphical_style(Integer graphical_style) {
		this.graphical_style = graphical_style;
	}
	
	public String getCredit_line() {
		return credit_line;
	}
	public void setCredit_line(String credit_line) {
		this.credit_line = credit_line;
	}
	
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getCollection() {
		return collection;
	}
	public void setCollection(String collection) {
		this.collection = collection;
	}
	public String getRest() {
		return rest;
	}
	public void setRest(String rest) {
		this.rest = rest;
	}
	public Integer getLicenseType() {
		return licenseType;
	}
	public void setLicenseType(Integer licenseType) {
		this.licenseType = licenseType;
	}
	public String getJpgForEpsUrl() {
		return jpgForEpsUrl;
	}
	public void setJpgForEpsUrl(String jpgForEpsUrl) {
		this.jpgForEpsUrl = jpgForEpsUrl;
	}
	
}
