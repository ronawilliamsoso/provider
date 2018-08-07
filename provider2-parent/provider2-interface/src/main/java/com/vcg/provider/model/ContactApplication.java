package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class ContactApplication extends BaseModel<ContactApplication> {
    private static final long serialVersionUID = 6289085906747640561L;

    /**  */
    @ApiModelProperty(value = "")
    private Integer id;

    /** 用户中心ID */
    @ApiModelProperty(value = "用户中心ID")
    private String userCenterId;

    /** 姓名 */
    @ApiModelProperty(value = "姓名")
    private String name;

    /** 性别，1 男，2 女 */
    @ApiModelProperty(value = "性别，1 男，2 女")
    private Integer sex;

    /** 部门 */
    @ApiModelProperty(value = "部门")
    private String department;

    /** 职位 */
    @ApiModelProperty(value = "职位")
    private String jobTitle;

    /** 角色 */
    @ApiModelProperty(value = "角色")
    private String role;

    /** Email1 */
    @ApiModelProperty(value = "Email1")
    private String email;

    /** 工作电话 */
    @ApiModelProperty(value = "工作电话")
    private String workTel;

    /** 移动电话 */
    @ApiModelProperty(value = "移动电话")
    private String mobile;

    /** 传真 */
    @ApiModelProperty(value = "传真")
    private String fax;

    /** QQ */
    @ApiModelProperty(value = "QQ")
    private String qq;

    /** MSN */
    @ApiModelProperty(value = "MSN")
    private String msn;

    /** 微信 */
    @ApiModelProperty(value = "微信")
    private String weixin;

    /** 联系地址 */
    @ApiModelProperty(value = "联系地址")
    private String address;

    /** Skype(网络电话） */
    @ApiModelProperty(value = "Skype(网络电话）")
    private String skype;

    /** 证件类型:1:身份证 2:护照 */
    @ApiModelProperty(value = "证件类型:1:身份证 2:护照")
    private Integer idType;

    /** 身份证号 */
    @ApiModelProperty(value = "身份证号")
    private String idNum;

    /** 默认联系人1是0不是 */
    @ApiModelProperty(value = "默认联系人1是0不是")
    private Integer isDefault;

    /**  */
    @ApiModelProperty(value = "")
    private String other;

    /** 邮编 */
    @ApiModelProperty(value = "邮编")
    private String postcode;

    /** 紧急联系人姓名 */
    @ApiModelProperty(value = "紧急联系人姓名")
    private String emergencyName;

    /** 紧急联系人性别，1：男，2：女 */
    @ApiModelProperty(value = "紧急联系人性别，1：男，2：女")
    private Integer emergencySex;

    /** 紧急联系人身份证号 */
    @ApiModelProperty(value = "紧急联系人身份证号")
    private String emergencyIdnum;

    /** 紧急联系人手机 */
    @ApiModelProperty(value = "紧急联系人手机")
    private String emergencyMobile;

    /** 紧急联系人地址 */
    @ApiModelProperty(value = "紧急联系人地址")
    private String emergencyAddress;

    /** 紧急联系人邮编 */
    @ApiModelProperty(value = "紧急联系人邮编")
    private String emergencyPostcode;

    /** 身份证照片的保存位置 */
    @ApiModelProperty(value = "身份证照片的保存位置")
    private String idCardimgpath;

    /** 城市 */
    @ApiModelProperty(value = "城市")
    private String city;

    /** 省份,州 */
    @ApiModelProperty(value = "省份,州")
    private String province;

    /** 国家 */
    @ApiModelProperty(value = "国家")
    private String country;

    /**  */
    @ApiModelProperty(value = "")
    private Date createdTime;

    /**  */
    @ApiModelProperty(value = "")
    private String createdBy;

    /**  */
    @ApiModelProperty(value = "")
    private Date updatedTime;

    /**  */
    @ApiModelProperty(value = "")
    private String updatedBy;

    public Integer getId() {
        return id;
    }

    public ContactApplication setId(Integer id) {
        this.id = id;
		return this;
    }

    public String getUserCenterId() {
        return userCenterId;
    }

    public ContactApplication setUserCenterId(String userCenterId) {
        this.userCenterId = userCenterId == null ? null : userCenterId.trim();
		return this;
    }

    public String getName() {
        return name;
    }

    public ContactApplication setName(String name) {
        this.name = name == null ? null : name.trim();
		return this;
    }

    public Integer getSex() {
        return sex;
    }

    public ContactApplication setSex(Integer sex) {
        this.sex = sex;
		return this;
    }

    public String getDepartment() {
        return department;
    }

    public ContactApplication setDepartment(String department) {
        this.department = department == null ? null : department.trim();
		return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public ContactApplication setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle == null ? null : jobTitle.trim();
		return this;
    }

    public String getRole() {
        return role;
    }

    public ContactApplication setRole(String role) {
        this.role = role == null ? null : role.trim();
		return this;
    }

    public String getEmail() {
        return email;
    }

    public ContactApplication setEmail(String email) {
        this.email = email == null ? null : email.trim();
		return this;
    }

    public String getWorkTel() {
        return workTel;
    }

    public ContactApplication setWorkTel(String workTel) {
        this.workTel = workTel == null ? null : workTel.trim();
		return this;
    }

    public String getMobile() {
        return mobile;
    }

    public ContactApplication setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
		return this;
    }

    public String getFax() {
        return fax;
    }

    public ContactApplication setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
		return this;
    }

    public String getQq() {
        return qq;
    }

    public ContactApplication setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
		return this;
    }

    public String getMsn() {
        return msn;
    }

    public ContactApplication setMsn(String msn) {
        this.msn = msn == null ? null : msn.trim();
		return this;
    }

    public String getWeixin() {
        return weixin;
    }

    public ContactApplication setWeixin(String weixin) {
        this.weixin = weixin == null ? null : weixin.trim();
		return this;
    }

    public String getAddress() {
        return address;
    }

    public ContactApplication setAddress(String address) {
        this.address = address == null ? null : address.trim();
		return this;
    }

    public String getSkype() {
        return skype;
    }

    public ContactApplication setSkype(String skype) {
        this.skype = skype == null ? null : skype.trim();
		return this;
    }

    public Integer getIdType() {
        return idType;
    }

    public ContactApplication setIdType(Integer idType) {
        this.idType = idType;
		return this;
    }

    public String getIdNum() {
        return idNum;
    }

    public ContactApplication setIdNum(String idNum) {
        this.idNum = idNum == null ? null : idNum.trim();
		return this;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public ContactApplication setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
		return this;
    }

    public String getOther() {
        return other;
    }

    public ContactApplication setOther(String other) {
        this.other = other == null ? null : other.trim();
		return this;
    }

    public String getPostcode() {
        return postcode;
    }

    public ContactApplication setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
		return this;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public ContactApplication setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName == null ? null : emergencyName.trim();
		return this;
    }

    public Integer getEmergencySex() {
        return emergencySex;
    }

    public ContactApplication setEmergencySex(Integer emergencySex) {
        this.emergencySex = emergencySex;
		return this;
    }

    public String getEmergencyIdnum() {
        return emergencyIdnum;
    }

    public ContactApplication setEmergencyIdnum(String emergencyIdnum) {
        this.emergencyIdnum = emergencyIdnum == null ? null : emergencyIdnum.trim();
		return this;
    }

    public String getEmergencyMobile() {
        return emergencyMobile;
    }

    public ContactApplication setEmergencyMobile(String emergencyMobile) {
        this.emergencyMobile = emergencyMobile == null ? null : emergencyMobile.trim();
		return this;
    }

    public String getEmergencyAddress() {
        return emergencyAddress;
    }

    public ContactApplication setEmergencyAddress(String emergencyAddress) {
        this.emergencyAddress = emergencyAddress == null ? null : emergencyAddress.trim();
		return this;
    }

    public String getEmergencyPostcode() {
        return emergencyPostcode;
    }

    public ContactApplication setEmergencyPostcode(String emergencyPostcode) {
        this.emergencyPostcode = emergencyPostcode == null ? null : emergencyPostcode.trim();
		return this;
    }

    public String getIdCardimgpath() {
        return idCardimgpath;
    }

    public ContactApplication setIdCardimgpath(String idCardimgpath) {
        this.idCardimgpath = idCardimgpath == null ? null : idCardimgpath.trim();
		return this;
    }

    public String getCity() {
        return city;
    }

    public ContactApplication setCity(String city) {
        this.city = city == null ? null : city.trim();
		return this;
    }

    public String getProvince() {
        return province;
    }

    public ContactApplication setProvince(String province) {
        this.province = province == null ? null : province.trim();
		return this;
    }

    public String getCountry() {
        return country;
    }

    public ContactApplication setCountry(String country) {
        this.country = country == null ? null : country.trim();
		return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public ContactApplication setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
		return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public ContactApplication setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
		return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public ContactApplication setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
		return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public ContactApplication setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
		return this;
    }
}
