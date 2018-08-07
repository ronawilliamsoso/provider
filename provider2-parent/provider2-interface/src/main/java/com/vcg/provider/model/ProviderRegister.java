package com.vcg.provider.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vcg.provider.model.ProviderApplication;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ProviderRegister extends ProviderApplication {


	
 
 
	
    /** 供应商全称（中文名） */
    @ApiModelProperty(value = "供应商全称")
    private String nameCn;
 

    /** 供应商简称 */
    @ApiModelProperty(value = "供应商简称")
    private String shortName;
    
    /** 供应商属性 */
    @ApiModelProperty(value = "供应商属性")
    private String attribute;

    /** 1机构2 个人 */
    @ApiModelProperty(value = "1机构2 个人")
    private Integer type;
    
    /** 内容接入方式 */
    @ApiModelProperty(value = "1:ftp 2:网页 3:API")
    private Integer provideType;
   

    /** 具体地点 */
    @ApiModelProperty(value = "具体地点")
    private String location;
    
    /** 供应商等级1A+ 2A3B4C5D */
    @ApiModelProperty(value = "供应商等级1A+ 2A3B4C5D")
    private String qualityRank;
    
 

    public class Contents{  
    	  /** 供应商等级1A+ 2A3B4C5D */
        @ApiModelProperty(value = "供应商等级1A+ 2A3B4C5D")
    	private String qualityRank1111111111111111; 
    } 
    
    
    
    
    
    
    
    
    
    /** 媒资类型1编辑类2创意类3编辑类&创意类 */
    @ApiModelProperty(value = "媒资类型1编辑类2创意类3编辑类&创意类")
    private Integer assetFamily;

    /** 媒资分类1 图片2视频3音频 */
    @ApiModelProperty(value = "媒资分类1 图片2视频3音频")
    private Integer assetType;


    /** 供应商所属公司 */
    @ApiModelProperty(value = "供应商所属公司")
    private String providerCompany;

    /** 从业类型1媒体2非媒体 */
    @ApiModelProperty(value = "从业类型1媒体2非媒体")
    private Integer jobType;



    /** 描述 */
    @ApiModelProperty(value = "描述")
    private String description;

    /** 作品 */
    @ApiModelProperty(value = "作品")
    private String productions;

    /**  */
    @ApiModelProperty(value = "")
    private Integer createUserId;

    /**  */
    @ApiModelProperty(value = "")
    private Date createTime;

    /** 最后修改时间 */
    @ApiModelProperty(value = "最后修改时间")
    private Date modifyTime;

    /** 通过时间 */
    @ApiModelProperty(value = "通过时间")
    private Date passtTime;

    /** 开通人id */
    @ApiModelProperty(value = "开通人id")
    private Integer passUserId;

    /**  */
    @ApiModelProperty(value = "")
    private String userCenterId;

    /** 状态 1 未审核 2 待签合同 3 开通 4 不通过  */
    @ApiModelProperty(value = "状态 1 未审核 2 待签合同 3 开通 4 不通过 ")
    private Integer status;

    /** 排序 */
    @ApiModelProperty(value = "排序")
    private Integer orders;

    /** 0删除1有效 */
    @ApiModelProperty(value = "0删除1有效")
    private Integer isDelete;



    /** 供应商网站 */
    @ApiModelProperty(value = "供应商网站")
    private String providerWebsite;

    /** 供应商网站账号 */
    @ApiModelProperty(value = "供应商网站账号")
    private String websiteName;

    /** 供应商网站密码 */
    @ApiModelProperty(value = "供应商网站密码")
    private String websitePassword;

    /** 1国内2国外 */
    @ApiModelProperty(value = "1国内2国外")
    private Integer isNative;

    /** 限价 */
    @ApiModelProperty(value = "限价")
    private String limitedPrice;

    /** 备注 */
    @ApiModelProperty(value = "备注")
    private String comment;

    /** 拒绝理由 */
    @ApiModelProperty(value = "拒绝理由")
    private String rejectReason;
	
 

	 @ApiModelProperty(value = "电子邮件")
	private String email;
	
	 @ApiModelProperty(value = "手机号")
	private String mobile;
	
	 @ApiModelProperty(value = "QQ号")
	private String qq;
	
	 @ApiModelProperty(value = "性别")
	private Integer sex;
 
    /** 拒绝理由 */
    @ApiModelProperty(value = "身份证或者护照的照片")
    private String idCardImgPath;
    
    
    
    
 
    /** 姓名 */
    @ApiModelProperty(value = "姓名")
    private String name;

    /** 职位 */
    @ApiModelProperty(value = "职位")
    private String jobTitle;

    /** 工作电话 */
    @ApiModelProperty(value = "办公电话")
    private String workTel;
 
    /** 联系地址 */
    @ApiModelProperty(value = "联系地址")
    private String address;

    /** Skype(网络电话） */
    @ApiModelProperty(value = "Skype(网络电话）")
    private String skype;
    
    /** 其他 */
    @ApiModelProperty(value = "其他")
    private String other;

    /** 默认联系人1是0不是 */
    @ApiModelProperty(value = "首要联系人1是0不是")
    private Integer isDefault;

    
 
	
}
