package com.vcg.provider.model;

import io.swagger.annotations.ApiModelProperty;

import com.vcg.common.base.BaseModel;

import java.util.Date;


public class Product extends BaseModel<Product> {
    private static final long serialVersionUID = 5696059221363916881L;

    /**  */
    @ApiModelProperty(value = "")
    private Integer id;

    /** 父级id */
    @ApiModelProperty(value = "父级id")
    private Integer parentId;

    /** 中文名称 */
    @ApiModelProperty(value = "中文名称")
    private String productName;

    /** 英文名称 */
    @ApiModelProperty(value = "英文名称")
    private String productNameEn;

    /** 1有效0是无效 2新建 */
    @ApiModelProperty(value = "1有效0是无效 2新建")
    private Integer productStatus;

    /** 开始时间 */
    @ApiModelProperty(value = "开始时间")
    private Date startDate;

    /** 结束时间 */
    @ApiModelProperty(value = "结束时间")
    private Date endDate;

    /** 公式 */
    @ApiModelProperty(value = "公式")
    private String formula;

    /** 限价等级(-1到9),同collection相同的字段 cms显示用 */
    @ApiModelProperty(value = "限价等级(-1到9),同collection相同的字段 cms显示用")
    private Integer priceLimitlevel;

    /** 最低价 boss结算时与collection的相同字段取高 */
    @ApiModelProperty(value = "最低价 boss结算时与collection的相同字段取高")
    private String minPrice;

    /** 备注 */
    @ApiModelProperty(value = "备注")
    private String comment;

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

    public Product setId(Integer id) {
        this.id = id;
		return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public Product setParentId(Integer parentId) {
        this.parentId = parentId;
		return this;
    }

    public String getProductName() {
        return productName;
    }

    public Product setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
		return this;
    }

    public String getProductNameEn() {
        return productNameEn;
    }

    public Product setProductNameEn(String productNameEn) {
        this.productNameEn = productNameEn == null ? null : productNameEn.trim();
		return this;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public Product setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
		return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Product setStartDate(Date startDate) {
        this.startDate = startDate;
		return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Product setEndDate(Date endDate) {
        this.endDate = endDate;
		return this;
    }

    public String getFormula() {
        return formula;
    }

    public Product setFormula(String formula) {
        this.formula = formula == null ? null : formula.trim();
		return this;
    }

    public Integer getPriceLimitlevel() {
        return priceLimitlevel;
    }

    public Product setPriceLimitlevel(Integer priceLimitlevel) {
        this.priceLimitlevel = priceLimitlevel;
		return this;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public Product setMinPrice(String minPrice) {
        this.minPrice = minPrice == null ? null : minPrice.trim();
		return this;
    }

    public String getComment() {
        return comment;
    }

    public Product setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
		return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public Product setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
		return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Product setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
		return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public Product setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
		return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public Product setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
		return this;
    }
}
