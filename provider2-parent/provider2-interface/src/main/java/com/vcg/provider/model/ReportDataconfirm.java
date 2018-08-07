package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class ReportDataconfirm extends BaseModel<ReportDataconfirm> {
    private static final long serialVersionUID = 8095063535622862485L;

    /** 数据库自增 */
    @ApiModelProperty(value = "数据库自增")
    private Integer id;

    /**  */
    @ApiModelProperty(value = "")
    private String month;

    /**  */
    @ApiModelProperty(value = "")
    private String year;

    /** 月份 */
    @ApiModelProperty(value = "月份")
    private String reportMonth;

    /** 供应商表id */
    @ApiModelProperty(value = "供应商表id")
    private Integer providerId;

    /** 供应商名字 */
    @ApiModelProperty(value = "供应商名字")
    private String providerName;

    /** 是否已经发布 0:否 1:是 */
    @ApiModelProperty(value = "是否已经发布 0:否 1:是")
    private Integer isPublished;

    /** 报表已确认  0:否 1:是 */
    @ApiModelProperty(value = "报表已确认  0:否 1:是")
    private Integer isConfirmed;

    /** 显示在网站上的合同名字,不是合同表里的 */
    @ApiModelProperty(value = "显示在网站上的合同名字,不是合同表里的")
    private String contractName;

    /** 发票已确认 0:否 1:是 */
    @ApiModelProperty(value = "发票已确认 0:否 1:是")
    private Integer receiptConfirmed;

    /** excel报表存储位置 */
    @ApiModelProperty(value = "excel报表存储位置")
    private String reportPath;

    /** 发票存储位置 */
    @ApiModelProperty(value = "发票存储位置")
    private String receiptPath;

    /** 报表上传时间 */
    @ApiModelProperty(value = "报表上传时间")
    private Date reportUploaddate;

    /** 发票上传时间 */
    @ApiModelProperty(value = "发票上传时间")
    private Date receiptUploaddate;

    /** 报表确认时间 */
    @ApiModelProperty(value = "报表确认时间")
    private Date reportConfirmdate;

    /** 发票确认时间 */
    @ApiModelProperty(value = "发票确认时间")
    private Date receiptConfirmdate;

    /** 是否已支付 0:否 1:是 */
    @ApiModelProperty(value = "是否已支付 0:否 1:是")
    private Integer isPaid;

    /** 支付时间 */
    @ApiModelProperty(value = "支付时间")
    private Date paidDate;

    /** 文件原始名字 */
    @ApiModelProperty(value = "文件原始名字")
    private String reportOriginalname;

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

    public ReportDataconfirm setId(Integer id) {
        this.id = id;
		return this;
    }

    public String getMonth() {
        return month;
    }

    public ReportDataconfirm setMonth(String month) {
        this.month = month == null ? null : month.trim();
		return this;
    }

    public String getYear() {
        return year;
    }

    public ReportDataconfirm setYear(String year) {
        this.year = year == null ? null : year.trim();
		return this;
    }

    public String getReportMonth() {
        return reportMonth;
    }

    public ReportDataconfirm setReportMonth(String reportMonth) {
        this.reportMonth = reportMonth == null ? null : reportMonth.trim();
		return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public ReportDataconfirm setProviderId(Integer providerId) {
        this.providerId = providerId;
		return this;
    }

    public String getProviderName() {
        return providerName;
    }

    public ReportDataconfirm setProviderName(String providerName) {
        this.providerName = providerName == null ? null : providerName.trim();
		return this;
    }

    public Integer getIsPublished() {
        return isPublished;
    }

    public ReportDataconfirm setIsPublished(Integer isPublished) {
        this.isPublished = isPublished;
		return this;
    }

    public Integer getIsConfirmed() {
        return isConfirmed;
    }

    public ReportDataconfirm setIsConfirmed(Integer isConfirmed) {
        this.isConfirmed = isConfirmed;
		return this;
    }

    public String getContractName() {
        return contractName;
    }

    public ReportDataconfirm setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
		return this;
    }

    public Integer getReceiptConfirmed() {
        return receiptConfirmed;
    }

    public ReportDataconfirm setReceiptConfirmed(Integer receiptConfirmed) {
        this.receiptConfirmed = receiptConfirmed;
		return this;
    }

    public String getReportPath() {
        return reportPath;
    }

    public ReportDataconfirm setReportPath(String reportPath) {
        this.reportPath = reportPath == null ? null : reportPath.trim();
		return this;
    }

    public String getReceiptPath() {
        return receiptPath;
    }

    public ReportDataconfirm setReceiptPath(String receiptPath) {
        this.receiptPath = receiptPath == null ? null : receiptPath.trim();
		return this;
    }

    public Date getReportUploaddate() {
        return reportUploaddate;
    }

    public ReportDataconfirm setReportUploaddate(Date reportUploaddate) {
        this.reportUploaddate = reportUploaddate;
		return this;
    }

    public Date getReceiptUploaddate() {
        return receiptUploaddate;
    }

    public ReportDataconfirm setReceiptUploaddate(Date receiptUploaddate) {
        this.receiptUploaddate = receiptUploaddate;
		return this;
    }

    public Date getReportConfirmdate() {
        return reportConfirmdate;
    }

    public ReportDataconfirm setReportConfirmdate(Date reportConfirmdate) {
        this.reportConfirmdate = reportConfirmdate;
		return this;
    }

    public Date getReceiptConfirmdate() {
        return receiptConfirmdate;
    }

    public ReportDataconfirm setReceiptConfirmdate(Date receiptConfirmdate) {
        this.receiptConfirmdate = receiptConfirmdate;
		return this;
    }

    public Integer getIsPaid() {
        return isPaid;
    }

    public ReportDataconfirm setIsPaid(Integer isPaid) {
        this.isPaid = isPaid;
		return this;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public ReportDataconfirm setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
		return this;
    }

    public String getReportOriginalname() {
        return reportOriginalname;
    }

    public ReportDataconfirm setReportOriginalname(String reportOriginalname) {
        this.reportOriginalname = reportOriginalname == null ? null : reportOriginalname.trim();
		return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public ReportDataconfirm setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
		return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public ReportDataconfirm setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
		return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public ReportDataconfirm setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
		return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public ReportDataconfirm setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
		return this;
    }
}
