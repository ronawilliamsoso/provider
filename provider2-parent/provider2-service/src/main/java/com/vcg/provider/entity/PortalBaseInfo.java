package com.vcg.provider.entity;
 
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class PortalBaseInfo {

 
    @ApiModelProperty(value = "供应商数据库id")
    private Integer pid;
    
    @ApiModelProperty(value = "联系人主键id,必填")
    private Integer cid;
    
 
    @ApiModelProperty(value = "供应商公司名")
    private String company;
    
    @ApiModelProperty(value = "联系人姓名")
    private String name;
    
    @ApiModelProperty(value = "联系人地址")
    private String address;
    
    @ApiModelProperty(value = "mobile")
    private String mobile;
    
    @ApiModelProperty(value = "Email1")
    private String email;
    
    @ApiModelProperty(value = "skype")
    private String skype;
    
    @ApiModelProperty(value = "QQ")
    private String qq;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}
    
    
 
    
     
   
    
 
}
