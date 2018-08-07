package com.vcg.provider.model;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class ContractInfo extends BaseModel<ContractInfo> {
    private static final long serialVersionUID = 6049048999101956769L;

    private Integer id;

    private Integer providerId;

    private Integer contractId;

    private Integer sex;

    private String email;

    private String mobile;

    private String fax;

    private String qq;

    private String msn;

    private Date createTime;

    private Date modifyTime;

    private String weixin;

    private String address;

    private String skype;

    private String idNum;

    private String postcode;

    private String emergencyName;

    private Integer emergencySex;

    private String emergencyIdnum;

    private String emergencyMobile;

    private String emergencyAddress;

    private String emergencyPostcode;

    public Integer getId() {
        return id;
    }

    public ContractInfo setId(Integer id) {
        this.id = id;
		return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public ContractInfo setProviderId(Integer providerId) {
        this.providerId = providerId;
		return this;
    }

    public Integer getContractId() {
        return contractId;
    }

    public ContractInfo setContractId(Integer contractId) {
        this.contractId = contractId;
		return this;
    }

    public Integer getSex() {
        return sex;
    }

    public ContractInfo setSex(Integer sex) {
        this.sex = sex;
		return this;
    }

    public String getEmail() {
        return email;
    }

    public ContractInfo setEmail(String email) {
        this.email = email == null ? null : email.trim();
		return this;
    }

    public String getMobile() {
        return mobile;
    }

    public ContractInfo setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
		return this;
    }

    public String getFax() {
        return fax;
    }

    public ContractInfo setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
		return this;
    }

    public String getQq() {
        return qq;
    }

    public ContractInfo setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
		return this;
    }

    public String getMsn() {
        return msn;
    }

    public ContractInfo setMsn(String msn) {
        this.msn = msn == null ? null : msn.trim();
		return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public ContractInfo setCreateTime(Date createTime) {
        this.createTime = createTime;
		return this;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public ContractInfo setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
		return this;
    }

    public String getWeixin() {
        return weixin;
    }

    public ContractInfo setWeixin(String weixin) {
        this.weixin = weixin == null ? null : weixin.trim();
		return this;
    }

    public String getAddress() {
        return address;
    }

    public ContractInfo setAddress(String address) {
        this.address = address == null ? null : address.trim();
		return this;
    }

    public String getSkype() {
        return skype;
    }

    public ContractInfo setSkype(String skype) {
        this.skype = skype == null ? null : skype.trim();
		return this;
    }

    public String getIdNum() {
        return idNum;
    }

    public ContractInfo setIdNum(String idNum) {
        this.idNum = idNum == null ? null : idNum.trim();
		return this;
    }

    public String getPostcode() {
        return postcode;
    }

    public ContractInfo setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
		return this;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public ContractInfo setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName == null ? null : emergencyName.trim();
		return this;
    }

    public Integer getEmergencySex() {
        return emergencySex;
    }

    public ContractInfo setEmergencySex(Integer emergencySex) {
        this.emergencySex = emergencySex;
		return this;
    }

    public String getEmergencyIdnum() {
        return emergencyIdnum;
    }

    public ContractInfo setEmergencyIdnum(String emergencyIdnum) {
        this.emergencyIdnum = emergencyIdnum == null ? null : emergencyIdnum.trim();
		return this;
    }

    public String getEmergencyMobile() {
        return emergencyMobile;
    }

    public ContractInfo setEmergencyMobile(String emergencyMobile) {
        this.emergencyMobile = emergencyMobile == null ? null : emergencyMobile.trim();
		return this;
    }

    public String getEmergencyAddress() {
        return emergencyAddress;
    }

    public ContractInfo setEmergencyAddress(String emergencyAddress) {
        this.emergencyAddress = emergencyAddress == null ? null : emergencyAddress.trim();
		return this;
    }

    public String getEmergencyPostcode() {
        return emergencyPostcode;
    }

    public ContractInfo setEmergencyPostcode(String emergencyPostcode) {
        this.emergencyPostcode = emergencyPostcode == null ? null : emergencyPostcode.trim();
		return this;
    }
}
