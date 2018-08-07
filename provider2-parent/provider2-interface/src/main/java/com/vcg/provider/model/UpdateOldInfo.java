package com.vcg.provider.model;
import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UpdateOldInfo {

 
	    @ApiModelProperty(value = "供应商主键id")
	    private Integer id;
	    
	    @ApiModelProperty(value = "联系人主键id")
	    private Integer contactId;

	    @ApiModelProperty(value = "署名")
	    private String creditLine;
	    
	    @ApiModelProperty(value = "真实姓名")
	    private String name;

	    @ApiModelProperty(value = "手机号")
	    private String mobile;
	    
		 @ApiModelProperty(value = "电子邮件")
		 private String email;
		 
	    @ApiModelProperty(value = "供应商所属公司")
	    private String company;
	    
		 @ApiModelProperty(value = "现在居住城市")
		 private String liveCity;
		 
		 @ApiModelProperty(value = "通讯地址-国家")
		 private String country;
		 
		 @ApiModelProperty(value = "通讯地址-省份")
		 private String province;
		 
		 @ApiModelProperty(value = "通讯地址-城市")
		 private String city;
		 
		 @ApiModelProperty(value = "通讯地址-详细地址")
		 private String address;
		 
		 @ApiModelProperty(value = "银行卡列表")
		 List<ProviderBank> banklist;
		 
	    @ApiModelProperty(value = "证件类型:1:身份证 2:护照 ")
	    private Integer idType;
	    
		 @ApiModelProperty(value = "护照号或者身份证号")
		 private String IdNum;
	    

		public String getIdNum() {
			return IdNum;
		}

		public void setIdNum(String idNum) {
			IdNum = idNum;
		}

		public Integer getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getIdType() {
			return idType;
		}

		public void setIdType(Integer idType) {
			this.idType = idType;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getCreditLine() {
			return creditLine;
		}

		public void setCreditLine(String creditLine) {
			this.creditLine = creditLine;
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

		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}

		public String getLiveCity() {
			return liveCity;
		}

		public void setLiveCity(String liveCity) {
			this.liveCity = liveCity;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getProvince() {
			return province;
		}

		public void setProvince(String province) {
			this.province = province;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public List<ProviderBank> getBanklist() {
			return banklist;
		}

		public void setBanklist(List<ProviderBank> banklist) {
			this.banklist = banklist;
		}

		public Integer getContactId() {
			return contactId;
		}

		public void setContactId(Integer contactId) {
			this.contactId = contactId;
		}
 
}
