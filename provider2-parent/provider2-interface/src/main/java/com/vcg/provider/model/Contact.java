package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class Contact extends BaseModel<Contact> {
    private static final long serialVersionUID = 76583274459593521L;

    /**  */
    @ApiModelProperty(value = "")
    private Integer id;

    /** 供应商正式b表的id */
    @ApiModelProperty(value = "供应商正式b表的id")
    private Integer providerId;

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

    /** 证件类型:1:身份证 2:护照 */
    @ApiModelProperty(value = "证件类型:1:身份证 2:护照")
    private Integer idType;

    /** 身份证号 */
    @ApiModelProperty(value = "身份证号")
    private String idNum;

    /** 联系地址 */
    @ApiModelProperty(value = "联系地址")
    private String address;

    /** Skype(网络电话） */
    @ApiModelProperty(value = "Skype(网络电话）")
    private String skype;

    /** 默认联系人1是0不是 */
    @ApiModelProperty(value = "默认联系人1是0不是")
    private Integer isDefault;

    /** 其他 */
    @ApiModelProperty(value = "其他")
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

    /** 身份证id的照片 */
    @ApiModelProperty(value = "身份证id的照片")
    private String idCardimgpath;

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

    public Contact setId(Integer id) {
        this.id = id;
		return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public Contact setProviderId(Integer providerId) {
        this.providerId = providerId;
		return this;
    }

    public String getName() {
        return name;
    }

    public Contact setName(String name) {
        this.name = name == null ? null : name.trim();
		return this;
    }

    public Integer getSex() {
        return sex;
    }

    public Contact setSex(Integer sex) {
        this.sex = sex;
		return this;
    }

    public String getDepartment() {
        return department;
    }

    public Contact setDepartment(String department) {
        this.department = department == null ? null : department.trim();
		return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Contact setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle == null ? null : jobTitle.trim();
		return this;
    }

    public String getRole() {
        return role;
    }

    public Contact setRole(String role) {
        this.role = role == null ? null : role.trim();
		return this;
    }

    public String getEmail() {
        return email;
    }

    public Contact setEmail(String email) {
        this.email = email == null ? null : email.trim();
		return this;
    }

    public String getWorkTel() {
        return workTel;
    }

    public Contact setWorkTel(String workTel) {
        this.workTel = workTel == null ? null : workTel.trim();
		return this;
    }

    public String getMobile() {
        return mobile;
    }

    public Contact setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
		return this;
    }

    public String getFax() {
        return fax;
    }

    public Contact setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
		return this;
    }

    public String getQq() {
        return qq;
    }

    public Contact setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
		return this;
    }

    public String getMsn() {
        return msn;
    }

    public Contact setMsn(String msn) {
        this.msn = msn == null ? null : msn.trim();
		return this;
    }

    public String getWeixin() {
        return weixin;
    }

    public Contact setWeixin(String weixin) {
        this.weixin = weixin == null ? null : weixin.trim();
		return this;
    }

    public Integer getIdType() {
        return idType;
    }

    public Contact setIdType(Integer idType) {
        this.idType = idType;
		return this;
    }

    public String getIdNum() {
        return idNum;
    }

    public Contact setIdNum(String idNum) {
        this.idNum = idNum == null ? null : idNum.trim();
		return this;
    }

    public String getAddress() {
        return address;
    }

    public Contact setAddress(String address) {
        this.address = address == null ? null : address.trim();
		return this;
    }

    public String getSkype() {
        return skype;
    }

    public Contact setSkype(String skype) {
        this.skype = skype == null ? null : skype.trim();
		return this;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public Contact setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
		return this;
    }

    public String getOther() {
        return other;
    }

    public Contact setOther(String other) {
        this.other = other == null ? null : other.trim();
		return this;
    }

    public String getPostcode() {
        return postcode;
    }

    public Contact setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
		return this;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public Contact setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName == null ? null : emergencyName.trim();
		return this;
    }

    public Integer getEmergencySex() {
        return emergencySex;
    }

    public Contact setEmergencySex(Integer emergencySex) {
        this.emergencySex = emergencySex;
		return this;
    }

    public String getEmergencyIdnum() {
        return emergencyIdnum;
    }

    public Contact setEmergencyIdnum(String emergencyIdnum) {
        this.emergencyIdnum = emergencyIdnum == null ? null : emergencyIdnum.trim();
		return this;
    }

    public String getEmergencyMobile() {
        return emergencyMobile;
    }

    public Contact setEmergencyMobile(String emergencyMobile) {
        this.emergencyMobile = emergencyMobile == null ? null : emergencyMobile.trim();
		return this;
    }

    public String getEmergencyAddress() {
        return emergencyAddress;
    }

    public Contact setEmergencyAddress(String emergencyAddress) {
        this.emergencyAddress = emergencyAddress == null ? null : emergencyAddress.trim();
		return this;
    }

    public String getEmergencyPostcode() {
        return emergencyPostcode;
    }

    public Contact setEmergencyPostcode(String emergencyPostcode) {
        this.emergencyPostcode = emergencyPostcode == null ? null : emergencyPostcode.trim();
		return this;
    }

    public String getIdCardimgpath() {
        return idCardimgpath;
    }

    public Contact setIdCardimgpath(String idCardimgpath) {
        this.idCardimgpath = idCardimgpath == null ? null : idCardimgpath.trim();
		return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public Contact setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
		return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Contact setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
		return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public Contact setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
		return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public Contact setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
		return this;
    }
}
