package com.vcg.provider.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SearchSellReport {
	    @ApiModelProperty(value = "素材类型: 1:编辑类2:创意")
	    private Integer assetFamily;
	    
	    @ApiModelProperty(value = "供应商id")
	    private Integer providerId;
	    
	    @ApiModelProperty(value = "必填：机构类型: 1:机构2:个人")
	    private Integer agentType;
	    
	    @ApiModelProperty(value = "已发布: 1:已发布2:未发布")
	    private Integer isPublished;
	    
	    @ApiModelProperty(value = "已支付: 1:已支付2:未支付")
	    private Integer isPaied;
	  
	    @ApiModelProperty(value = "报表时间如:201601")
	    private String sellMonth;
	    
		@ApiModelProperty(required=false,value="供应商名称 图片id 图片原始id")
		private String searchName;
		
		@ApiModelProperty(required=false,value="1:供应商名称  2:图片id3:图片原始id")
		private Integer searchType;
	    
		/*当前页*/
		@ApiModelProperty(required=true,value="当前页码")
		private Integer pageNum;
		/*页大小*/
		@ApiModelProperty(required=true,value="每页记录数")
		private Integer pageSize;
		
		
		public String getSearchName() {
			return searchName;
		}
		public void setSearchName(String searchName) {
			this.searchName = searchName;
		}
		public Integer getSearchType() {
			return searchType;
		}
		public void setSearchType(Integer searchType) {
			this.searchType = searchType;
		}
		public Integer getProviderId() {
			return providerId;
		}
		public void setProviderId(Integer providerId) {
			this.providerId = providerId;
		}
		public Integer getIsPublished() {
			return isPublished;
		}
		public void setIsPublished(Integer isPublished) {
			this.isPublished = isPublished;
		}
		public Integer getIsPaied() {
			return isPaied;
		}
		public void setIsPaied(Integer isPaied) {
			this.isPaied = isPaied;
		}
		public Integer getAssetFamily() {
			return assetFamily;
		}
		public void setAssetFamily(Integer assetFamily) {
			this.assetFamily = assetFamily;
		}
 
		public String getSellMonth() {
			return sellMonth;
		}
		public void setSellMonth(String sellMonth) {
			this.sellMonth = sellMonth;
		}
		public Integer getPageNum() {
			return pageNum;
		}
		public void setPageNum(Integer pageNum) {
			this.pageNum = pageNum;
		}
		public Integer getPageSize() {
			return pageSize;
		}
		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}
		public Integer getAgentType() {
			return agentType;
		}
		public void setAgentType(Integer agentType) {
			this.agentType = agentType;
		}
	    
 
		 
		 
	 
    
	 
   
 
	
}
