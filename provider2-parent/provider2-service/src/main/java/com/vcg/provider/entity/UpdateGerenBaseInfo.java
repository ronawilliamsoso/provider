package com.vcg.provider.entity;
 
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UpdateGerenBaseInfo {

 
    @ApiModelProperty(value = "供应商数据库id")
    private Integer id;
    
    @ApiModelProperty(value = "联系人id,在查询页面返回了这个数据")
    private Integer contactId;
    
    
 
    @ApiModelProperty(value = "供应商全称（中文名）")
    private String nameCn;
    
    @ApiModelProperty(value = "供应商署名")
    private String signatureName;
    
    @ApiModelProperty(value = "手机号")
    private String mobile;
    
    @ApiModelProperty(value = "性别，1 男，2 女")
    private Integer sex;
    
    @ApiModelProperty(value = "Email1")
    private String email;
    
    @ApiModelProperty(value = "国家")
    private String country;

    /** 省 */
    @ApiModelProperty(value = "省")
    private String province;

    /** 市 */
    @ApiModelProperty(value = "市")
    private String city;

    /** 具体地点 */
    @ApiModelProperty(value = "具体地点")
    private String location;
    
    @ApiModelProperty(value = "供应商所属公司")
    private String providerCompany;
    
    @ApiModelProperty(value = "微信")
    private String weixin;
    
    @ApiModelProperty(value = "从业类型1媒体2非媒体")
    private Integer jobType;
    
    @ApiModelProperty(value = "QQ")
    private String qq;
    
    @ApiModelProperty(value = "身份证号或者护照号码")
    private String idNum;
    
    @ApiModelProperty(value = "身份证或者护照图片")
    private String idCardImgPath;
    
    @ApiModelProperty(value = "供应商等级1A+ 2A3B4C5D")
    private String qualityRank;
    
    @ApiModelProperty(value = "媒资类型1编辑类2创意类3编辑类&创意类")
    private Integer assetFamily;
    
    
    

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameCn() {
		return nameCn;
	}

	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}

	public String getSignatureName() {
		return signatureName;
	}

	public void setSignatureName(String signatureName) {
		this.signatureName = signatureName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProviderCompany() {
		return providerCompany;
	}

	public void setProviderCompany(String providerCompany) {
		this.providerCompany = providerCompany;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public Integer getJobType() {
		return jobType;
	}

	public void setJobType(Integer jobType) {
		this.jobType = jobType;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getIdCardImgPath() {
		return idCardImgPath;
	}

	public void setIdCardImgPath(String idCardImgPath) {
		this.idCardImgPath = idCardImgPath;
	}

	public String getQualityRank() {
		return qualityRank;
	}

	public void setQualityRank(String qualityRank) {
		this.qualityRank = qualityRank;
	}

	public Integer getAssetFamily() {
		return assetFamily;
	}

	public void setAssetFamily(Integer assetFamily) {
		this.assetFamily = assetFamily;
	}
    
    

    
    
    
    
    
    
     
   
    
 
}
