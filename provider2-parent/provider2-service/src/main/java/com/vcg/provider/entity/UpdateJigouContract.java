package com.vcg.provider.entity;
 

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.vcg.boss.contract.model.Contract;
import com.vcg.provider.model.Contact;
import com.vcg.provider.model.ContractAuthorization;
import com.vcg.provider.model.ProviderAccess;
import com.vcg.provider.model.ProviderAccount;
import com.vcg.provider.model.ProviderPayment;
import com.vcg.provider.model.ProviderPortalaccounts;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UpdateJigouContract {

 
    @ApiModelProperty(value = "供应商数据库id")
    private Integer id;
 
    @ApiModelProperty(value = "供应商编码")
    private String providerId;
    
    @ApiModelProperty(value = "供应商状态:1 未审核 2 待签合同 3 开通 4 不通过 5冻结 6关闭 ")
    private Integer status;
    
 
    @ApiModelProperty(value = "供应商全称（中文名）")
    private String nameCn;
    
    @ApiModelProperty(value = "供应商类型:1编辑类2创意类3编辑类&创意类")
    private Integer assetFamily;
    
    @ApiModelProperty(value = "供应商简称")
    private String shortName;
    
    @ApiModelProperty(value = "内容属性  比如编辑图片RM,音频RF,创意视频等")
    private String contentAttribute;
    
    @ApiModelProperty(value = "供应商等级1A+ 2A3B4C5D")
    private String qualityRank;
    
    @ApiModelProperty(value = "国家")
    private String country;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "具体地点")
    private String location;
    
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    
    @ApiModelProperty(value = "开通人id,也可能是最后修改人")
    private Integer passUserId;
    
    @ApiModelProperty(value = "营业执照上传后的地址")
    private String operationLicencepic;
    
    @ApiModelProperty(value = "税务登记照上传后的地址")
    private String taxRegistrationpic;
    
    @ApiModelProperty(value = "备注")
    private String comment;
 
    
    @ApiModelProperty(value = "账号信息:提供给供应商登录我们系统的数组")
    private List<ProviderPortalaccounts> portalaccList;
    
    @ApiModelProperty(value = "联系人")
    private List<Contact> contactList;
    
    @ApiModelProperty(value = "接入方式")
    private List<ProviderAccess> accessList;
    
    @ApiModelProperty(value = "银行信息")
    private List<ProviderPayment> bankList;
    
    @ApiModelProperty(value = "供应商网站信息:供应商提供给我们的账号数组")
    private List<ProviderAccount> accountList;
    
    @ApiModelProperty(value = "联系人数组")
    private List<Contract> contractList;
    
 
    
   
    
 
}
