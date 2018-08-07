package com.vcg.provider.entity;

import java.util.List;

import com.vcg.provider.model.Provider;

 

public class GroupInfo {
	
	private Integer asset_family;
	private String provider_id;
	private String title;
	private String source;
	private String group_desc;
	private String group_id;
	private Integer graphical_style;
	private String usage_restrictions;
	private String category;
	
	private String editor_provider_id;
	
	private String creative_provider_id;
	
	private Provider providerIds;
	
	
	private List<ResourceInfo> pics;
	
	//批次id
	private Integer creativeBatchId;
	
	
	
	public String getEditor_provider_id() {
		return editor_provider_id;
	}
	public void setEditor_provider_id(String editor_provider_id) {
		this.editor_provider_id = editor_provider_id;
	}
	public String getCreative_provider_id() {
		return creative_provider_id;
	}
	public void setCreative_provider_id(String creative_provider_id) {
		this.creative_provider_id = creative_provider_id;
	}
	
	
	public Provider getProviderIds() {
		return providerIds;
	}
	public void setProviderIds(Provider providerIds) {
		this.providerIds = providerIds;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUsage_restrictions() {
		return usage_restrictions;
	}
	public void setUsage_restrictions(String usage_restrictions) {
		this.usage_restrictions = usage_restrictions;
	}
	public Integer getAsset_family() {
		return asset_family;
	}
	public void setAsset_family(Integer asset_family) {
		this.asset_family = asset_family;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<ResourceInfo> getPics() {
		return pics;
	}
	public void setPics(List<ResourceInfo> pics) {
		this.pics = pics;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getProvider_id() {
		return provider_id;
	}
	public void setProvider_id(String provider_id) {
		this.provider_id = provider_id;
	}
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public Integer getGraphical_style() {
		return graphical_style;
	}
	public void setGraphical_style(Integer graphical_style) {
		this.graphical_style = graphical_style;
	}
	
	public String getGroup_desc() {
		return group_desc;
	}
	public void setGroup_desc(String group_desc) {
		this.group_desc = group_desc;
	}
	public Integer getCreativeBatchId() {
		return creativeBatchId;
	}
	public void setCreativeBatchId(Integer creativeBatchId) {
		this.creativeBatchId = creativeBatchId;
	}

	
	
	
}
