package com.vcg.provider.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vcg.provider.model.ProviderApplication;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GerenRegister {

//	
//	{
//		  "userCenterId": "218b60cb04ba3a03942c7f4c316177180",
//		  "jobType": 2,
//		  "providerCompany": "视觉中国研发部",
//		  "sex": 2,
//		  "email": "ronawilliam@163.com",
//		  "nameCn": "王威真实姓名V",
//		  "productions": "https://photo-test-community.shijue.me/s/5bb60fd58c79373af72351cfb9d479257726a71c424fafb39ed63d175204b819ddfeab54aa69f903f55bc5d48b6b06ed4435cfee743fcfc6",
//		  "access_token": "b9d2b3f360104dd2aaa48b3b50963b36",
//		  "mobile": "13811855184"
//		}
	
	
	  @ApiModelProperty(value = "从业类型: 1媒体2非媒体")
	    private Integer jobType;
	    

	    @ApiModelProperty(value = "手机号")
	    private String mobile;
	    
		 @ApiModelProperty(value = "性别: 1男2女")
		private Integer sex;
		 
	    @ApiModelProperty(value = "用户中心id")
	    private String userCenterId;
	    
		 @ApiModelProperty(value = "电子邮件")
		 private String email;
		 
	    @ApiModelProperty(value = "供应商所属公司")
	    private String providerCompany;
	    
		 @ApiModelProperty(value = "真实姓名")
		 private String nameCn;
		 
		 @ApiModelProperty(value = "作品地址")
		 private String productions;
		 
		 
		 
		 
		 
		 

		public Integer getJobType() {
			return jobType;
		}

		public void setJobType(Integer jobType) {
			this.jobType = jobType;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public Integer getSex() {
			return sex;
		}

		public void setSex(Integer sex) {
			this.sex = sex;
		}

		public String getUserCenterId() {
			return userCenterId;
		}

		public void setUserCenterId(String userCenterId) {
			this.userCenterId = userCenterId;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getProviderCompany() {
			return providerCompany;
		}

		public void setProviderCompany(String providerCompany) {
			this.providerCompany = providerCompany;
		}

		public String getNameCn() {
			return nameCn;
		}

		public void setNameCn(String nameCn) {
			this.nameCn = nameCn;
		}

		public String getProductions() {
			return productions;
		}

		public void setProductions(String productions) {
			this.productions = productions;
		}
		 
		 
	 
    
	 
   
 
	
}
