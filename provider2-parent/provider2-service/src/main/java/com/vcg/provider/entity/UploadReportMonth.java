package com.vcg.provider.entity;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class UploadReportMonth {
 

    /** excel报表存储位置 */
    @ApiModelProperty(value = "excel报表存储位置")
    private String reportPath;

    /** 报表文件名字 */
    @ApiModelProperty(value = "excel文件名字")
    private String reportName;

	public String getReportPath() {
		return reportPath;
	}

	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

 
 
 
 
}
