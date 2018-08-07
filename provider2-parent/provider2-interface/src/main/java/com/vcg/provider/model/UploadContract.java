package com.vcg.provider.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 上传合同接口参数
 * @author yanhua.ma
 *
 */
@ApiModel
public class UploadContract {
    @ApiModelProperty(value = "合同类型")
	private Integer type;
    @ApiModelProperty(value = "用户中心ID")
	private String userCenterId;
    @ApiModelProperty(value = "合同ID")
	private Integer contractId;
    @ApiModelProperty(value = "合同编号")
	private String contractNum;
    @ApiModelProperty(value = "乙方姓名（授权人）")
	private String name;
    @ApiModelProperty(value = "证件号码")
	private String idNum;
    @ApiModelProperty(value = "证件类型:1:身份证 2:护照")
	private Integer idType;
    @ApiModelProperty(value = "邮编")
	private String postcode;
    @ApiModelProperty(value = "通信地址")
	private String location;
    @ApiModelProperty(value = "移动电话")
	private String mobile;
    @ApiModelProperty(value = "Email")
	private String email;
    @ApiModelProperty(value = "qq")
	private String qq;
    @ApiModelProperty(value = "微信")
	private String weixin;
    @ApiModelProperty(value = "署名")
	private String creditLine;
    @ApiModelProperty(value = "紧急联系人姓名")
	private String emergencyName;
    @ApiModelProperty(value = "紧急联系人性别")
	private Integer emergencySex;
    @ApiModelProperty(value = "紧急联系人身份证号")
	private String emergencyIDNum;
    @ApiModelProperty(value = "紧急联系人手机")
	private String emergencyMobile;
    @ApiModelProperty(value = "紧急联系人地址")
	private String emergencyAddress;
    @ApiModelProperty(value = "紧急联系人邮政编码")
	private String emergencyPostcode;
    @ApiModelProperty(value = "合同开始时间")
	private Date beginDate;
    @ApiModelProperty(value = "合同结束时间")
	private Date endDate;
    @ApiModelProperty(value = "合同期限")
	private String deadline;
    @ApiModelProperty(value = "付款方式")
	private String paymentMethod;
    @ApiModelProperty(value = "开户银行名称")
	private String bankName;
    @ApiModelProperty(value = "支行名称")
    private String branchBankname;
    @ApiModelProperty(value = "账户名称")
	private String payeeName;
    @ApiModelProperty(value = "银行账号")
	private String payeeNumber;
    @ApiModelProperty(value = "开户行地址")
	private String bankAddress;
    @ApiModelProperty(value = "开户地")
	private String openAccountaddress;
	@ApiModelProperty(value = "转银行代码")
	private String swiftCode;
	@ApiModelProperty(value = "编辑类图片分成比例")
	private String editRate;
	@ApiModelProperty(value = "创意类图片分成比例")
	private String creativeRate;
    @ApiModelProperty(value = "国家")
    private String country;
    @ApiModelProperty(value = "省")
    private String province;
    @ApiModelProperty(value = "市")
    private String city;
	@ApiModelProperty(value = "身份证或者护照的图片地址")
	private String     idCardImgPath;

	
	 
	public Integer getIdType() {
		return idType;
	}
	public void setIdType(Integer idType) {
		this.idType = idType;
	}
	public String getBranchBankname() {
		return branchBankname;
	}
	public void setBranchBankname(String branchBankname) {
		this.branchBankname = branchBankname;
	}
	public String getOpenAccountaddress() {
		return openAccountaddress;
	}
	public void setOpenAccountaddress(String openAccountaddress) {
		this.openAccountaddress = openAccountaddress;
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
	public String getIdCardImgPath() {
		return idCardImgPath;
	}
	public void setIdCardImgPath(String idCardImgPath) {
		this.idCardImgPath = idCardImgPath;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getUserCenterId() {
		return userCenterId;
	}
	public void setUserCenterId(String userCenterId) {
		this.userCenterId = userCenterId;
	}
	public String getEditRate() {
		return editRate;
	}
	public void setEditRate(String editRate) {
		this.editRate = editRate;
	}
	public String getCreativeRate() {
		return creativeRate;
	}
	public void setCreativeRate(String creativeRate) {
		this.creativeRate = creativeRate;
	}
	public Integer getContractId() {
		return contractId;
	}
	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}
	public String getContractNum() {
		return contractNum;
	}
	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
 
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	public String getCreditLine() {
		return creditLine;
	}
	public void setCreditLine(String creditLine) {
		this.creditLine = creditLine;
	}
	public String getEmergencyName() {
		return emergencyName;
	}
	public void setEmergencyName(String emergencyName) {
		this.emergencyName = emergencyName;
	}
	public Integer getEmergencySex() {
		return emergencySex;
	}
	public void setEmergencySex(Integer emergencySex) {
		this.emergencySex = emergencySex;
	}
	public String getEmergencyIDNum() {
		return emergencyIDNum;
	}
	public void setEmergencyIDNum(String emergencyIDNum) {
		this.emergencyIDNum = emergencyIDNum;
	}
	public String getEmergencyMobile() {
		return emergencyMobile;
	}
	public void setEmergencyMobile(String emergencyMobile) {
		this.emergencyMobile = emergencyMobile;
	}
	public String getEmergencyAddress() {
		return emergencyAddress;
	}
	public void setEmergencyAddress(String emergencyAddress) {
		this.emergencyAddress = emergencyAddress;
	}
	public String getEmergencyPostcode() {
		return emergencyPostcode;
	}
	public void setEmergencyPostcode(String emergencyPostcode) {
		this.emergencyPostcode = emergencyPostcode;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public String getPayeeNumber() {
		return payeeNumber;
	}
	public void setPayeeNumber(String payeeNumber) {
		this.payeeNumber = payeeNumber;
	}
	public String getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	public String getSwiftCode() {
		return swiftCode;
	}
	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}
	
	public List<String> checkTheNecessary(){
		List<String> list = new ArrayList<>();
		if(this.getUserCenterId() == null && this.getContractId() == null){
			list.add("id或contractId");
		}
		if(this.getType() == null){
			list.add("type");
		}
		if(this.getName() == null){
			list.add("name");
		}
		if(this.getIdNum() == null){
			list.add("IdNum");
		}
 
		if(this.getEmail() == null){
			list.add("email");
		}
		if(this.getWeixin() == null){
			list.add("weixin");
		}
		if(this.getCreditLine() == null){
			list.add("creditLine");
		}
		if(this.getBankName() == null){
			list.add("bankName");
		}
		if(this.getPayeeNumber() == null){
			list.add("payeeNumber");
		}
		return list;
	}
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
}
