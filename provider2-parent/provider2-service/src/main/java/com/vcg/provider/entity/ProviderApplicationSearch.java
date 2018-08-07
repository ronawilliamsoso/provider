package com.vcg.provider.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
 

@ApiModel
public class ProviderApplicationSearch {

	 
	@ApiModelProperty(required=false,value="1:姓名2:手机号3：邮箱")
	private Integer searchType;
		
    /** 申请状态 */
    @ApiModelProperty(value = " 1 未审核  4 不通过")
    private Integer status;
 
    /** 搜索框 */
    @ApiModelProperty(value = "名字,手机号,账号其中之一")
    private String searchName;
 
    
    /** 页 */
    @ApiModelProperty(value = "第几页,从1开始")
    private Integer pageNum;
    
    public Integer getSearchType() {
		return searchType;
	}

	public void setSearchType(Integer searchType) {
		this.searchType = searchType;
	}

	/** 每页多少条 */
    @ApiModelProperty(value = "每页的大小")
    private Integer pageSize;
    

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
 
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

  

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
 
     

    
}
