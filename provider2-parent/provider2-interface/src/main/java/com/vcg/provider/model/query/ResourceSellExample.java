package com.vcg.provider.model.query;

import java.io.Serializable;
import com.vcg.common.base.BaseExample;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ResourceSellExample extends BaseExample {

	private static final long serialVersionUID = 2093309266835417710L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourceSellExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

protected abstract static class GeneratedCriteria implements Serializable {

	private static final long serialVersionUID = 6436604866630201605L;

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdIsNull() {
            addCriterion("bill_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdIsNotNull() {
            addCriterion("bill_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdEqualTo(String value) {
            addCriterion("bill_detail_id =", value, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdNotEqualTo(String value) {
            addCriterion("bill_detail_id <>", value, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdGreaterThan(String value) {
            addCriterion("bill_detail_id >", value, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("bill_detail_id >=", value, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdLessThan(String value) {
            addCriterion("bill_detail_id <", value, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdLessThanOrEqualTo(String value) {
            addCriterion("bill_detail_id <=", value, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdLike(String value) {
            addCriterion("bill_detail_id like", value, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdNotLike(String value) {
            addCriterion("bill_detail_id not like", value, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdIn(List<String> values) {
            addCriterion("bill_detail_id in", values, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdNotIn(List<String> values) {
            addCriterion("bill_detail_id not in", values, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdBetween(String value1, String value2) {
            addCriterion("bill_detail_id between", value1, value2, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdNotBetween(String value1, String value2) {
            addCriterion("bill_detail_id not between", value1, value2, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andSellMonthIsNull() {
            addCriterion("sell_month is null");
            return (Criteria) this;
        }

        public Criteria andSellMonthIsNotNull() {
            addCriterion("sell_month is not null");
            return (Criteria) this;
        }

        public Criteria andSellMonthEqualTo(String value) {
            addCriterion("sell_month =", value, "sellMonth");
            return (Criteria) this;
        }

        public Criteria andSellMonthNotEqualTo(String value) {
            addCriterion("sell_month <>", value, "sellMonth");
            return (Criteria) this;
        }

        public Criteria andSellMonthGreaterThan(String value) {
            addCriterion("sell_month >", value, "sellMonth");
            return (Criteria) this;
        }

        public Criteria andSellMonthGreaterThanOrEqualTo(String value) {
            addCriterion("sell_month >=", value, "sellMonth");
            return (Criteria) this;
        }

        public Criteria andSellMonthLessThan(String value) {
            addCriterion("sell_month <", value, "sellMonth");
            return (Criteria) this;
        }

        public Criteria andSellMonthLessThanOrEqualTo(String value) {
            addCriterion("sell_month <=", value, "sellMonth");
            return (Criteria) this;
        }

        public Criteria andSellMonthLike(String value) {
            addCriterion("sell_month like", value, "sellMonth");
            return (Criteria) this;
        }

        public Criteria andSellMonthNotLike(String value) {
            addCriterion("sell_month not like", value, "sellMonth");
            return (Criteria) this;
        }

        public Criteria andSellMonthIn(List<String> values) {
            addCriterion("sell_month in", values, "sellMonth");
            return (Criteria) this;
        }

        public Criteria andSellMonthNotIn(List<String> values) {
            addCriterion("sell_month not in", values, "sellMonth");
            return (Criteria) this;
        }

        public Criteria andSellMonthBetween(String value1, String value2) {
            addCriterion("sell_month between", value1, value2, "sellMonth");
            return (Criteria) this;
        }

        public Criteria andSellMonthNotBetween(String value1, String value2) {
            addCriterion("sell_month not between", value1, value2, "sellMonth");
            return (Criteria) this;
        }

        public Criteria andResIdIsNull() {
            addCriterion("res_id is null");
            return (Criteria) this;
        }

        public Criteria andResIdIsNotNull() {
            addCriterion("res_id is not null");
            return (Criteria) this;
        }

        public Criteria andResIdEqualTo(String value) {
            addCriterion("res_id =", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotEqualTo(String value) {
            addCriterion("res_id <>", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdGreaterThan(String value) {
            addCriterion("res_id >", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdGreaterThanOrEqualTo(String value) {
            addCriterion("res_id >=", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLessThan(String value) {
            addCriterion("res_id <", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLessThanOrEqualTo(String value) {
            addCriterion("res_id <=", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLike(String value) {
            addCriterion("res_id like", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotLike(String value) {
            addCriterion("res_id not like", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdIn(List<String> values) {
            addCriterion("res_id in", values, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotIn(List<String> values) {
            addCriterion("res_id not in", values, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdBetween(String value1, String value2) {
            addCriterion("res_id between", value1, value2, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotBetween(String value1, String value2) {
            addCriterion("res_id not between", value1, value2, "resId");
            return (Criteria) this;
        }

        public Criteria andProviderResIdIsNull() {
            addCriterion("provider_res_id is null");
            return (Criteria) this;
        }

        public Criteria andProviderResIdIsNotNull() {
            addCriterion("provider_res_id is not null");
            return (Criteria) this;
        }

        public Criteria andProviderResIdEqualTo(String value) {
            addCriterion("provider_res_id =", value, "providerResId");
            return (Criteria) this;
        }

        public Criteria andProviderResIdNotEqualTo(String value) {
            addCriterion("provider_res_id <>", value, "providerResId");
            return (Criteria) this;
        }

        public Criteria andProviderResIdGreaterThan(String value) {
            addCriterion("provider_res_id >", value, "providerResId");
            return (Criteria) this;
        }

        public Criteria andProviderResIdGreaterThanOrEqualTo(String value) {
            addCriterion("provider_res_id >=", value, "providerResId");
            return (Criteria) this;
        }

        public Criteria andProviderResIdLessThan(String value) {
            addCriterion("provider_res_id <", value, "providerResId");
            return (Criteria) this;
        }

        public Criteria andProviderResIdLessThanOrEqualTo(String value) {
            addCriterion("provider_res_id <=", value, "providerResId");
            return (Criteria) this;
        }

        public Criteria andProviderResIdLike(String value) {
            addCriterion("provider_res_id like", value, "providerResId");
            return (Criteria) this;
        }

        public Criteria andProviderResIdNotLike(String value) {
            addCriterion("provider_res_id not like", value, "providerResId");
            return (Criteria) this;
        }

        public Criteria andProviderResIdIn(List<String> values) {
            addCriterion("provider_res_id in", values, "providerResId");
            return (Criteria) this;
        }

        public Criteria andProviderResIdNotIn(List<String> values) {
            addCriterion("provider_res_id not in", values, "providerResId");
            return (Criteria) this;
        }

        public Criteria andProviderResIdBetween(String value1, String value2) {
            addCriterion("provider_res_id between", value1, value2, "providerResId");
            return (Criteria) this;
        }

        public Criteria andProviderResIdNotBetween(String value1, String value2) {
            addCriterion("provider_res_id not between", value1, value2, "providerResId");
            return (Criteria) this;
        }

        public Criteria andProviderIdIsNull() {
            addCriterion("provider_id is null");
            return (Criteria) this;
        }

        public Criteria andProviderIdIsNotNull() {
            addCriterion("provider_id is not null");
            return (Criteria) this;
        }

        public Criteria andProviderIdEqualTo(Integer value) {
            addCriterion("provider_id =", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotEqualTo(Integer value) {
            addCriterion("provider_id <>", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdGreaterThan(Integer value) {
            addCriterion("provider_id >", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("provider_id >=", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdLessThan(Integer value) {
            addCriterion("provider_id <", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdLessThanOrEqualTo(Integer value) {
            addCriterion("provider_id <=", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdIn(List<Integer> values) {
            addCriterion("provider_id in", values, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotIn(List<Integer> values) {
            addCriterion("provider_id not in", values, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdBetween(Integer value1, Integer value2) {
            addCriterion("provider_id between", value1, value2, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("provider_id not between", value1, value2, "providerId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdIsNull() {
            addCriterion("collection_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectionIdIsNotNull() {
            addCriterion("collection_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionIdEqualTo(Integer value) {
            addCriterion("collection_id =", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdNotEqualTo(Integer value) {
            addCriterion("collection_id <>", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdGreaterThan(Integer value) {
            addCriterion("collection_id >", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("collection_id >=", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdLessThan(Integer value) {
            addCriterion("collection_id <", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdLessThanOrEqualTo(Integer value) {
            addCriterion("collection_id <=", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdIn(List<Integer> values) {
            addCriterion("collection_id in", values, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdNotIn(List<Integer> values) {
            addCriterion("collection_id not in", values, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdBetween(Integer value1, Integer value2) {
            addCriterion("collection_id between", value1, value2, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("collection_id not between", value1, value2, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionNameIsNull() {
            addCriterion("collection_name is null");
            return (Criteria) this;
        }

        public Criteria andCollectionNameIsNotNull() {
            addCriterion("collection_name is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionNameEqualTo(String value) {
            addCriterion("collection_name =", value, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameNotEqualTo(String value) {
            addCriterion("collection_name <>", value, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameGreaterThan(String value) {
            addCriterion("collection_name >", value, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameGreaterThanOrEqualTo(String value) {
            addCriterion("collection_name >=", value, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameLessThan(String value) {
            addCriterion("collection_name <", value, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameLessThanOrEqualTo(String value) {
            addCriterion("collection_name <=", value, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameLike(String value) {
            addCriterion("collection_name like", value, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameNotLike(String value) {
            addCriterion("collection_name not like", value, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameIn(List<String> values) {
            addCriterion("collection_name in", values, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameNotIn(List<String> values) {
            addCriterion("collection_name not in", values, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameBetween(String value1, String value2) {
            addCriterion("collection_name between", value1, value2, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameNotBetween(String value1, String value2) {
            addCriterion("collection_name not between", value1, value2, "collectionName");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeIsNull() {
            addCriterion("license_type is null");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeIsNotNull() {
            addCriterion("license_type is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeEqualTo(Integer value) {
            addCriterion("license_type =", value, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeNotEqualTo(Integer value) {
            addCriterion("license_type <>", value, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeGreaterThan(Integer value) {
            addCriterion("license_type >", value, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("license_type >=", value, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeLessThan(Integer value) {
            addCriterion("license_type <", value, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeLessThanOrEqualTo(Integer value) {
            addCriterion("license_type <=", value, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeIn(List<Integer> values) {
            addCriterion("license_type in", values, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeNotIn(List<Integer> values) {
            addCriterion("license_type not in", values, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeBetween(Integer value1, Integer value2) {
            addCriterion("license_type between", value1, value2, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("license_type not between", value1, value2, "licenseType");
            return (Criteria) this;
        }

        public Criteria andAssetFamilyIsNull() {
            addCriterion("asset_family is null");
            return (Criteria) this;
        }

        public Criteria andAssetFamilyIsNotNull() {
            addCriterion("asset_family is not null");
            return (Criteria) this;
        }

        public Criteria andAssetFamilyEqualTo(Integer value) {
            addCriterion("asset_family =", value, "assetFamily");
            return (Criteria) this;
        }

        public Criteria andAssetFamilyNotEqualTo(Integer value) {
            addCriterion("asset_family <>", value, "assetFamily");
            return (Criteria) this;
        }

        public Criteria andAssetFamilyGreaterThan(Integer value) {
            addCriterion("asset_family >", value, "assetFamily");
            return (Criteria) this;
        }

        public Criteria andAssetFamilyGreaterThanOrEqualTo(Integer value) {
            addCriterion("asset_family >=", value, "assetFamily");
            return (Criteria) this;
        }

        public Criteria andAssetFamilyLessThan(Integer value) {
            addCriterion("asset_family <", value, "assetFamily");
            return (Criteria) this;
        }

        public Criteria andAssetFamilyLessThanOrEqualTo(Integer value) {
            addCriterion("asset_family <=", value, "assetFamily");
            return (Criteria) this;
        }

        public Criteria andAssetFamilyIn(List<Integer> values) {
            addCriterion("asset_family in", values, "assetFamily");
            return (Criteria) this;
        }

        public Criteria andAssetFamilyNotIn(List<Integer> values) {
            addCriterion("asset_family not in", values, "assetFamily");
            return (Criteria) this;
        }

        public Criteria andAssetFamilyBetween(Integer value1, Integer value2) {
            addCriterion("asset_family between", value1, value2, "assetFamily");
            return (Criteria) this;
        }

        public Criteria andAssetFamilyNotBetween(Integer value1, Integer value2) {
            addCriterion("asset_family not between", value1, value2, "assetFamily");
            return (Criteria) this;
        }

        public Criteria andCaptionIsNull() {
            addCriterion("caption is null");
            return (Criteria) this;
        }

        public Criteria andCaptionIsNotNull() {
            addCriterion("caption is not null");
            return (Criteria) this;
        }

        public Criteria andCaptionEqualTo(String value) {
            addCriterion("caption =", value, "caption");
            return (Criteria) this;
        }

        public Criteria andCaptionNotEqualTo(String value) {
            addCriterion("caption <>", value, "caption");
            return (Criteria) this;
        }

        public Criteria andCaptionGreaterThan(String value) {
            addCriterion("caption >", value, "caption");
            return (Criteria) this;
        }

        public Criteria andCaptionGreaterThanOrEqualTo(String value) {
            addCriterion("caption >=", value, "caption");
            return (Criteria) this;
        }

        public Criteria andCaptionLessThan(String value) {
            addCriterion("caption <", value, "caption");
            return (Criteria) this;
        }

        public Criteria andCaptionLessThanOrEqualTo(String value) {
            addCriterion("caption <=", value, "caption");
            return (Criteria) this;
        }

        public Criteria andCaptionLike(String value) {
            addCriterion("caption like", value, "caption");
            return (Criteria) this;
        }

        public Criteria andCaptionNotLike(String value) {
            addCriterion("caption not like", value, "caption");
            return (Criteria) this;
        }

        public Criteria andCaptionIn(List<String> values) {
            addCriterion("caption in", values, "caption");
            return (Criteria) this;
        }

        public Criteria andCaptionNotIn(List<String> values) {
            addCriterion("caption not in", values, "caption");
            return (Criteria) this;
        }

        public Criteria andCaptionBetween(String value1, String value2) {
            addCriterion("caption between", value1, value2, "caption");
            return (Criteria) this;
        }

        public Criteria andCaptionNotBetween(String value1, String value2) {
            addCriterion("caption not between", value1, value2, "caption");
            return (Criteria) this;
        }

        public Criteria andSellDateIsNull() {
            addCriterion("sell_date is null");
            return (Criteria) this;
        }

        public Criteria andSellDateIsNotNull() {
            addCriterion("sell_date is not null");
            return (Criteria) this;
        }

        public Criteria andSellDateEqualTo(Date value) {
            addCriterionForJDBCDate("sell_date =", value, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("sell_date <>", value, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateGreaterThan(Date value) {
            addCriterionForJDBCDate("sell_date >", value, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sell_date >=", value, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateLessThan(Date value) {
            addCriterionForJDBCDate("sell_date <", value, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sell_date <=", value, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateIn(List<Date> values) {
            addCriterionForJDBCDate("sell_date in", values, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("sell_date not in", values, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sell_date between", value1, value2, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sell_date not between", value1, value2, "sellDate");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeIsNull() {
            addCriterion("currency_code is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeIsNotNull() {
            addCriterion("currency_code is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeEqualTo(String value) {
            addCriterion("currency_code =", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotEqualTo(String value) {
            addCriterion("currency_code <>", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeGreaterThan(String value) {
            addCriterion("currency_code >", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("currency_code >=", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeLessThan(String value) {
            addCriterion("currency_code <", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeLessThanOrEqualTo(String value) {
            addCriterion("currency_code <=", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeLike(String value) {
            addCriterion("currency_code like", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotLike(String value) {
            addCriterion("currency_code not like", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeIn(List<String> values) {
            addCriterion("currency_code in", values, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotIn(List<String> values) {
            addCriterion("currency_code not in", values, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeBetween(String value1, String value2) {
            addCriterion("currency_code between", value1, value2, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotBetween(String value1, String value2) {
            addCriterion("currency_code not between", value1, value2, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andSellPriceIsNull() {
            addCriterion("sell_price is null");
            return (Criteria) this;
        }

        public Criteria andSellPriceIsNotNull() {
            addCriterion("sell_price is not null");
            return (Criteria) this;
        }

        public Criteria andSellPriceEqualTo(BigDecimal value) {
            addCriterion("sell_price =", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceNotEqualTo(BigDecimal value) {
            addCriterion("sell_price <>", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceGreaterThan(BigDecimal value) {
            addCriterion("sell_price >", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sell_price >=", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceLessThan(BigDecimal value) {
            addCriterion("sell_price <", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sell_price <=", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceIn(List<BigDecimal> values) {
            addCriterion("sell_price in", values, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceNotIn(List<BigDecimal> values) {
            addCriterion("sell_price not in", values, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sell_price between", value1, value2, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sell_price not between", value1, value2, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateIsNull() {
            addCriterion("royalty_rate is null");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateIsNotNull() {
            addCriterion("royalty_rate is not null");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateEqualTo(BigDecimal value) {
            addCriterion("royalty_rate =", value, "royaltyRate");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateNotEqualTo(BigDecimal value) {
            addCriterion("royalty_rate <>", value, "royaltyRate");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateGreaterThan(BigDecimal value) {
            addCriterion("royalty_rate >", value, "royaltyRate");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("royalty_rate >=", value, "royaltyRate");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateLessThan(BigDecimal value) {
            addCriterion("royalty_rate <", value, "royaltyRate");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("royalty_rate <=", value, "royaltyRate");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateIn(List<BigDecimal> values) {
            addCriterion("royalty_rate in", values, "royaltyRate");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateNotIn(List<BigDecimal> values) {
            addCriterion("royalty_rate not in", values, "royaltyRate");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("royalty_rate between", value1, value2, "royaltyRate");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("royalty_rate not between", value1, value2, "royaltyRate");
            return (Criteria) this;
        }

        public Criteria andNetShareIsNull() {
            addCriterion("net_share is null");
            return (Criteria) this;
        }

        public Criteria andNetShareIsNotNull() {
            addCriterion("net_share is not null");
            return (Criteria) this;
        }

        public Criteria andNetShareEqualTo(BigDecimal value) {
            addCriterion("net_share =", value, "netShare");
            return (Criteria) this;
        }

        public Criteria andNetShareNotEqualTo(BigDecimal value) {
            addCriterion("net_share <>", value, "netShare");
            return (Criteria) this;
        }

        public Criteria andNetShareGreaterThan(BigDecimal value) {
            addCriterion("net_share >", value, "netShare");
            return (Criteria) this;
        }

        public Criteria andNetShareGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("net_share >=", value, "netShare");
            return (Criteria) this;
        }

        public Criteria andNetShareLessThan(BigDecimal value) {
            addCriterion("net_share <", value, "netShare");
            return (Criteria) this;
        }

        public Criteria andNetShareLessThanOrEqualTo(BigDecimal value) {
            addCriterion("net_share <=", value, "netShare");
            return (Criteria) this;
        }

        public Criteria andNetShareIn(List<BigDecimal> values) {
            addCriterion("net_share in", values, "netShare");
            return (Criteria) this;
        }

        public Criteria andNetShareNotIn(List<BigDecimal> values) {
            addCriterion("net_share not in", values, "netShare");
            return (Criteria) this;
        }

        public Criteria andNetShareBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("net_share between", value1, value2, "netShare");
            return (Criteria) this;
        }

        public Criteria andNetShareNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("net_share not between", value1, value2, "netShare");
            return (Criteria) this;
        }

        public Criteria andProviderNameIsNull() {
            addCriterion("provider_name is null");
            return (Criteria) this;
        }

        public Criteria andProviderNameIsNotNull() {
            addCriterion("provider_name is not null");
            return (Criteria) this;
        }

        public Criteria andProviderNameEqualTo(String value) {
            addCriterion("provider_name =", value, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameNotEqualTo(String value) {
            addCriterion("provider_name <>", value, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameGreaterThan(String value) {
            addCriterion("provider_name >", value, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameGreaterThanOrEqualTo(String value) {
            addCriterion("provider_name >=", value, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameLessThan(String value) {
            addCriterion("provider_name <", value, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameLessThanOrEqualTo(String value) {
            addCriterion("provider_name <=", value, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameLike(String value) {
            addCriterion("provider_name like", value, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameNotLike(String value) {
            addCriterion("provider_name not like", value, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameIn(List<String> values) {
            addCriterion("provider_name in", values, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameNotIn(List<String> values) {
            addCriterion("provider_name not in", values, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameBetween(String value1, String value2) {
            addCriterion("provider_name between", value1, value2, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameNotBetween(String value1, String value2) {
            addCriterion("provider_name not between", value1, value2, "providerName");
            return (Criteria) this;
        }

        public Criteria andCreditLineIsNull() {
            addCriterion("credit_line is null");
            return (Criteria) this;
        }

        public Criteria andCreditLineIsNotNull() {
            addCriterion("credit_line is not null");
            return (Criteria) this;
        }

        public Criteria andCreditLineEqualTo(String value) {
            addCriterion("credit_line =", value, "creditLine");
            return (Criteria) this;
        }

        public Criteria andCreditLineNotEqualTo(String value) {
            addCriterion("credit_line <>", value, "creditLine");
            return (Criteria) this;
        }

        public Criteria andCreditLineGreaterThan(String value) {
            addCriterion("credit_line >", value, "creditLine");
            return (Criteria) this;
        }

        public Criteria andCreditLineGreaterThanOrEqualTo(String value) {
            addCriterion("credit_line >=", value, "creditLine");
            return (Criteria) this;
        }

        public Criteria andCreditLineLessThan(String value) {
            addCriterion("credit_line <", value, "creditLine");
            return (Criteria) this;
        }

        public Criteria andCreditLineLessThanOrEqualTo(String value) {
            addCriterion("credit_line <=", value, "creditLine");
            return (Criteria) this;
        }

        public Criteria andCreditLineLike(String value) {
            addCriterion("credit_line like", value, "creditLine");
            return (Criteria) this;
        }

        public Criteria andCreditLineNotLike(String value) {
            addCriterion("credit_line not like", value, "creditLine");
            return (Criteria) this;
        }

        public Criteria andCreditLineIn(List<String> values) {
            addCriterion("credit_line in", values, "creditLine");
            return (Criteria) this;
        }

        public Criteria andCreditLineNotIn(List<String> values) {
            addCriterion("credit_line not in", values, "creditLine");
            return (Criteria) this;
        }

        public Criteria andCreditLineBetween(String value1, String value2) {
            addCriterion("credit_line between", value1, value2, "creditLine");
            return (Criteria) this;
        }

        public Criteria andCreditLineNotBetween(String value1, String value2) {
            addCriterion("credit_line not between", value1, value2, "creditLine");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberIsNull() {
            addCriterion("invoice_number is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberIsNotNull() {
            addCriterion("invoice_number is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberEqualTo(String value) {
            addCriterion("invoice_number =", value, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberNotEqualTo(String value) {
            addCriterion("invoice_number <>", value, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberGreaterThan(String value) {
            addCriterion("invoice_number >", value, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_number >=", value, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberLessThan(String value) {
            addCriterion("invoice_number <", value, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberLessThanOrEqualTo(String value) {
            addCriterion("invoice_number <=", value, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberLike(String value) {
            addCriterion("invoice_number like", value, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberNotLike(String value) {
            addCriterion("invoice_number not like", value, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberIn(List<String> values) {
            addCriterion("invoice_number in", values, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberNotIn(List<String> values) {
            addCriterion("invoice_number not in", values, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberBetween(String value1, String value2) {
            addCriterion("invoice_number between", value1, value2, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberNotBetween(String value1, String value2) {
            addCriterion("invoice_number not between", value1, value2, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andTerritoryIdIsNull() {
            addCriterion("territory_id is null");
            return (Criteria) this;
        }

        public Criteria andTerritoryIdIsNotNull() {
            addCriterion("territory_id is not null");
            return (Criteria) this;
        }

        public Criteria andTerritoryIdEqualTo(String value) {
            addCriterion("territory_id =", value, "territoryId");
            return (Criteria) this;
        }

        public Criteria andTerritoryIdNotEqualTo(String value) {
            addCriterion("territory_id <>", value, "territoryId");
            return (Criteria) this;
        }

        public Criteria andTerritoryIdGreaterThan(String value) {
            addCriterion("territory_id >", value, "territoryId");
            return (Criteria) this;
        }

        public Criteria andTerritoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("territory_id >=", value, "territoryId");
            return (Criteria) this;
        }

        public Criteria andTerritoryIdLessThan(String value) {
            addCriterion("territory_id <", value, "territoryId");
            return (Criteria) this;
        }

        public Criteria andTerritoryIdLessThanOrEqualTo(String value) {
            addCriterion("territory_id <=", value, "territoryId");
            return (Criteria) this;
        }

        public Criteria andTerritoryIdLike(String value) {
            addCriterion("territory_id like", value, "territoryId");
            return (Criteria) this;
        }

        public Criteria andTerritoryIdNotLike(String value) {
            addCriterion("territory_id not like", value, "territoryId");
            return (Criteria) this;
        }

        public Criteria andTerritoryIdIn(List<String> values) {
            addCriterion("territory_id in", values, "territoryId");
            return (Criteria) this;
        }

        public Criteria andTerritoryIdNotIn(List<String> values) {
            addCriterion("territory_id not in", values, "territoryId");
            return (Criteria) this;
        }

        public Criteria andTerritoryIdBetween(String value1, String value2) {
            addCriterion("territory_id between", value1, value2, "territoryId");
            return (Criteria) this;
        }

        public Criteria andTerritoryIdNotBetween(String value1, String value2) {
            addCriterion("territory_id not between", value1, value2, "territoryId");
            return (Criteria) this;
        }

        public Criteria andMetaTerritoryIdIsNull() {
            addCriterion("meta_territory_id is null");
            return (Criteria) this;
        }

        public Criteria andMetaTerritoryIdIsNotNull() {
            addCriterion("meta_territory_id is not null");
            return (Criteria) this;
        }

        public Criteria andMetaTerritoryIdEqualTo(Integer value) {
            addCriterion("meta_territory_id =", value, "metaTerritoryId");
            return (Criteria) this;
        }

        public Criteria andMetaTerritoryIdNotEqualTo(Integer value) {
            addCriterion("meta_territory_id <>", value, "metaTerritoryId");
            return (Criteria) this;
        }

        public Criteria andMetaTerritoryIdGreaterThan(Integer value) {
            addCriterion("meta_territory_id >", value, "metaTerritoryId");
            return (Criteria) this;
        }

        public Criteria andMetaTerritoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("meta_territory_id >=", value, "metaTerritoryId");
            return (Criteria) this;
        }

        public Criteria andMetaTerritoryIdLessThan(Integer value) {
            addCriterion("meta_territory_id <", value, "metaTerritoryId");
            return (Criteria) this;
        }

        public Criteria andMetaTerritoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("meta_territory_id <=", value, "metaTerritoryId");
            return (Criteria) this;
        }

        public Criteria andMetaTerritoryIdIn(List<Integer> values) {
            addCriterion("meta_territory_id in", values, "metaTerritoryId");
            return (Criteria) this;
        }

        public Criteria andMetaTerritoryIdNotIn(List<Integer> values) {
            addCriterion("meta_territory_id not in", values, "metaTerritoryId");
            return (Criteria) this;
        }

        public Criteria andMetaTerritoryIdBetween(Integer value1, Integer value2) {
            addCriterion("meta_territory_id between", value1, value2, "metaTerritoryId");
            return (Criteria) this;
        }

        public Criteria andMetaTerritoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("meta_territory_id not between", value1, value2, "metaTerritoryId");
            return (Criteria) this;
        }

        public Criteria andClientTypeIsNull() {
            addCriterion("client_type is null");
            return (Criteria) this;
        }

        public Criteria andClientTypeIsNotNull() {
            addCriterion("client_type is not null");
            return (Criteria) this;
        }

        public Criteria andClientTypeEqualTo(String value) {
            addCriterion("client_type =", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeNotEqualTo(String value) {
            addCriterion("client_type <>", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeGreaterThan(String value) {
            addCriterion("client_type >", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeGreaterThanOrEqualTo(String value) {
            addCriterion("client_type >=", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeLessThan(String value) {
            addCriterion("client_type <", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeLessThanOrEqualTo(String value) {
            addCriterion("client_type <=", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeLike(String value) {
            addCriterion("client_type like", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeNotLike(String value) {
            addCriterion("client_type not like", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeIn(List<String> values) {
            addCriterion("client_type in", values, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeNotIn(List<String> values) {
            addCriterion("client_type not in", values, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeBetween(String value1, String value2) {
            addCriterion("client_type between", value1, value2, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeNotBetween(String value1, String value2) {
            addCriterion("client_type not between", value1, value2, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientCnIsNull() {
            addCriterion("client_cn is null");
            return (Criteria) this;
        }

        public Criteria andClientCnIsNotNull() {
            addCriterion("client_cn is not null");
            return (Criteria) this;
        }

        public Criteria andClientCnEqualTo(String value) {
            addCriterion("client_cn =", value, "clientCn");
            return (Criteria) this;
        }

        public Criteria andClientCnNotEqualTo(String value) {
            addCriterion("client_cn <>", value, "clientCn");
            return (Criteria) this;
        }

        public Criteria andClientCnGreaterThan(String value) {
            addCriterion("client_cn >", value, "clientCn");
            return (Criteria) this;
        }

        public Criteria andClientCnGreaterThanOrEqualTo(String value) {
            addCriterion("client_cn >=", value, "clientCn");
            return (Criteria) this;
        }

        public Criteria andClientCnLessThan(String value) {
            addCriterion("client_cn <", value, "clientCn");
            return (Criteria) this;
        }

        public Criteria andClientCnLessThanOrEqualTo(String value) {
            addCriterion("client_cn <=", value, "clientCn");
            return (Criteria) this;
        }

        public Criteria andClientCnLike(String value) {
            addCriterion("client_cn like", value, "clientCn");
            return (Criteria) this;
        }

        public Criteria andClientCnNotLike(String value) {
            addCriterion("client_cn not like", value, "clientCn");
            return (Criteria) this;
        }

        public Criteria andClientCnIn(List<String> values) {
            addCriterion("client_cn in", values, "clientCn");
            return (Criteria) this;
        }

        public Criteria andClientCnNotIn(List<String> values) {
            addCriterion("client_cn not in", values, "clientCn");
            return (Criteria) this;
        }

        public Criteria andClientCnBetween(String value1, String value2) {
            addCriterion("client_cn between", value1, value2, "clientCn");
            return (Criteria) this;
        }

        public Criteria andClientCnNotBetween(String value1, String value2) {
            addCriterion("client_cn not between", value1, value2, "clientCn");
            return (Criteria) this;
        }

        public Criteria andClientEnIsNull() {
            addCriterion("client_en is null");
            return (Criteria) this;
        }

        public Criteria andClientEnIsNotNull() {
            addCriterion("client_en is not null");
            return (Criteria) this;
        }

        public Criteria andClientEnEqualTo(String value) {
            addCriterion("client_en =", value, "clientEn");
            return (Criteria) this;
        }

        public Criteria andClientEnNotEqualTo(String value) {
            addCriterion("client_en <>", value, "clientEn");
            return (Criteria) this;
        }

        public Criteria andClientEnGreaterThan(String value) {
            addCriterion("client_en >", value, "clientEn");
            return (Criteria) this;
        }

        public Criteria andClientEnGreaterThanOrEqualTo(String value) {
            addCriterion("client_en >=", value, "clientEn");
            return (Criteria) this;
        }

        public Criteria andClientEnLessThan(String value) {
            addCriterion("client_en <", value, "clientEn");
            return (Criteria) this;
        }

        public Criteria andClientEnLessThanOrEqualTo(String value) {
            addCriterion("client_en <=", value, "clientEn");
            return (Criteria) this;
        }

        public Criteria andClientEnLike(String value) {
            addCriterion("client_en like", value, "clientEn");
            return (Criteria) this;
        }

        public Criteria andClientEnNotLike(String value) {
            addCriterion("client_en not like", value, "clientEn");
            return (Criteria) this;
        }

        public Criteria andClientEnIn(List<String> values) {
            addCriterion("client_en in", values, "clientEn");
            return (Criteria) this;
        }

        public Criteria andClientEnNotIn(List<String> values) {
            addCriterion("client_en not in", values, "clientEn");
            return (Criteria) this;
        }

        public Criteria andClientEnBetween(String value1, String value2) {
            addCriterion("client_en between", value1, value2, "clientEn");
            return (Criteria) this;
        }

        public Criteria andClientEnNotBetween(String value1, String value2) {
            addCriterion("client_en not between", value1, value2, "clientEn");
            return (Criteria) this;
        }

        public Criteria andFinaluserCnIsNull() {
            addCriterion("finaluser_cn is null");
            return (Criteria) this;
        }

        public Criteria andFinaluserCnIsNotNull() {
            addCriterion("finaluser_cn is not null");
            return (Criteria) this;
        }

        public Criteria andFinaluserCnEqualTo(String value) {
            addCriterion("finaluser_cn =", value, "finaluserCn");
            return (Criteria) this;
        }

        public Criteria andFinaluserCnNotEqualTo(String value) {
            addCriterion("finaluser_cn <>", value, "finaluserCn");
            return (Criteria) this;
        }

        public Criteria andFinaluserCnGreaterThan(String value) {
            addCriterion("finaluser_cn >", value, "finaluserCn");
            return (Criteria) this;
        }

        public Criteria andFinaluserCnGreaterThanOrEqualTo(String value) {
            addCriterion("finaluser_cn >=", value, "finaluserCn");
            return (Criteria) this;
        }

        public Criteria andFinaluserCnLessThan(String value) {
            addCriterion("finaluser_cn <", value, "finaluserCn");
            return (Criteria) this;
        }

        public Criteria andFinaluserCnLessThanOrEqualTo(String value) {
            addCriterion("finaluser_cn <=", value, "finaluserCn");
            return (Criteria) this;
        }

        public Criteria andFinaluserCnLike(String value) {
            addCriterion("finaluser_cn like", value, "finaluserCn");
            return (Criteria) this;
        }

        public Criteria andFinaluserCnNotLike(String value) {
            addCriterion("finaluser_cn not like", value, "finaluserCn");
            return (Criteria) this;
        }

        public Criteria andFinaluserCnIn(List<String> values) {
            addCriterion("finaluser_cn in", values, "finaluserCn");
            return (Criteria) this;
        }

        public Criteria andFinaluserCnNotIn(List<String> values) {
            addCriterion("finaluser_cn not in", values, "finaluserCn");
            return (Criteria) this;
        }

        public Criteria andFinaluserCnBetween(String value1, String value2) {
            addCriterion("finaluser_cn between", value1, value2, "finaluserCn");
            return (Criteria) this;
        }

        public Criteria andFinaluserCnNotBetween(String value1, String value2) {
            addCriterion("finaluser_cn not between", value1, value2, "finaluserCn");
            return (Criteria) this;
        }

        public Criteria andFinaluserEnIsNull() {
            addCriterion("finaluser_en is null");
            return (Criteria) this;
        }

        public Criteria andFinaluserEnIsNotNull() {
            addCriterion("finaluser_en is not null");
            return (Criteria) this;
        }

        public Criteria andFinaluserEnEqualTo(String value) {
            addCriterion("finaluser_en =", value, "finaluserEn");
            return (Criteria) this;
        }

        public Criteria andFinaluserEnNotEqualTo(String value) {
            addCriterion("finaluser_en <>", value, "finaluserEn");
            return (Criteria) this;
        }

        public Criteria andFinaluserEnGreaterThan(String value) {
            addCriterion("finaluser_en >", value, "finaluserEn");
            return (Criteria) this;
        }

        public Criteria andFinaluserEnGreaterThanOrEqualTo(String value) {
            addCriterion("finaluser_en >=", value, "finaluserEn");
            return (Criteria) this;
        }

        public Criteria andFinaluserEnLessThan(String value) {
            addCriterion("finaluser_en <", value, "finaluserEn");
            return (Criteria) this;
        }

        public Criteria andFinaluserEnLessThanOrEqualTo(String value) {
            addCriterion("finaluser_en <=", value, "finaluserEn");
            return (Criteria) this;
        }

        public Criteria andFinaluserEnLike(String value) {
            addCriterion("finaluser_en like", value, "finaluserEn");
            return (Criteria) this;
        }

        public Criteria andFinaluserEnNotLike(String value) {
            addCriterion("finaluser_en not like", value, "finaluserEn");
            return (Criteria) this;
        }

        public Criteria andFinaluserEnIn(List<String> values) {
            addCriterion("finaluser_en in", values, "finaluserEn");
            return (Criteria) this;
        }

        public Criteria andFinaluserEnNotIn(List<String> values) {
            addCriterion("finaluser_en not in", values, "finaluserEn");
            return (Criteria) this;
        }

        public Criteria andFinaluserEnBetween(String value1, String value2) {
            addCriterion("finaluser_en between", value1, value2, "finaluserEn");
            return (Criteria) this;
        }

        public Criteria andFinaluserEnNotBetween(String value1, String value2) {
            addCriterion("finaluser_en not between", value1, value2, "finaluserEn");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeIsNull() {
            addCriterion("industry_code is null");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeIsNotNull() {
            addCriterion("industry_code is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeEqualTo(String value) {
            addCriterion("industry_code =", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeNotEqualTo(String value) {
            addCriterion("industry_code <>", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeGreaterThan(String value) {
            addCriterion("industry_code >", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("industry_code >=", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeLessThan(String value) {
            addCriterion("industry_code <", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeLessThanOrEqualTo(String value) {
            addCriterion("industry_code <=", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeLike(String value) {
            addCriterion("industry_code like", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeNotLike(String value) {
            addCriterion("industry_code not like", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeIn(List<String> values) {
            addCriterion("industry_code in", values, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeNotIn(List<String> values) {
            addCriterion("industry_code not in", values, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeBetween(String value1, String value2) {
            addCriterion("industry_code between", value1, value2, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeNotBetween(String value1, String value2) {
            addCriterion("industry_code not between", value1, value2, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryEnIsNull() {
            addCriterion("industry_en is null");
            return (Criteria) this;
        }

        public Criteria andIndustryEnIsNotNull() {
            addCriterion("industry_en is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryEnEqualTo(String value) {
            addCriterion("industry_en =", value, "industryEn");
            return (Criteria) this;
        }

        public Criteria andIndustryEnNotEqualTo(String value) {
            addCriterion("industry_en <>", value, "industryEn");
            return (Criteria) this;
        }

        public Criteria andIndustryEnGreaterThan(String value) {
            addCriterion("industry_en >", value, "industryEn");
            return (Criteria) this;
        }

        public Criteria andIndustryEnGreaterThanOrEqualTo(String value) {
            addCriterion("industry_en >=", value, "industryEn");
            return (Criteria) this;
        }

        public Criteria andIndustryEnLessThan(String value) {
            addCriterion("industry_en <", value, "industryEn");
            return (Criteria) this;
        }

        public Criteria andIndustryEnLessThanOrEqualTo(String value) {
            addCriterion("industry_en <=", value, "industryEn");
            return (Criteria) this;
        }

        public Criteria andIndustryEnLike(String value) {
            addCriterion("industry_en like", value, "industryEn");
            return (Criteria) this;
        }

        public Criteria andIndustryEnNotLike(String value) {
            addCriterion("industry_en not like", value, "industryEn");
            return (Criteria) this;
        }

        public Criteria andIndustryEnIn(List<String> values) {
            addCriterion("industry_en in", values, "industryEn");
            return (Criteria) this;
        }

        public Criteria andIndustryEnNotIn(List<String> values) {
            addCriterion("industry_en not in", values, "industryEn");
            return (Criteria) this;
        }

        public Criteria andIndustryEnBetween(String value1, String value2) {
            addCriterion("industry_en between", value1, value2, "industryEn");
            return (Criteria) this;
        }

        public Criteria andIndustryEnNotBetween(String value1, String value2) {
            addCriterion("industry_en not between", value1, value2, "industryEn");
            return (Criteria) this;
        }

        public Criteria andIndustryCnIsNull() {
            addCriterion("industry_cn is null");
            return (Criteria) this;
        }

        public Criteria andIndustryCnIsNotNull() {
            addCriterion("industry_cn is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryCnEqualTo(String value) {
            addCriterion("industry_cn =", value, "industryCn");
            return (Criteria) this;
        }

        public Criteria andIndustryCnNotEqualTo(String value) {
            addCriterion("industry_cn <>", value, "industryCn");
            return (Criteria) this;
        }

        public Criteria andIndustryCnGreaterThan(String value) {
            addCriterion("industry_cn >", value, "industryCn");
            return (Criteria) this;
        }

        public Criteria andIndustryCnGreaterThanOrEqualTo(String value) {
            addCriterion("industry_cn >=", value, "industryCn");
            return (Criteria) this;
        }

        public Criteria andIndustryCnLessThan(String value) {
            addCriterion("industry_cn <", value, "industryCn");
            return (Criteria) this;
        }

        public Criteria andIndustryCnLessThanOrEqualTo(String value) {
            addCriterion("industry_cn <=", value, "industryCn");
            return (Criteria) this;
        }

        public Criteria andIndustryCnLike(String value) {
            addCriterion("industry_cn like", value, "industryCn");
            return (Criteria) this;
        }

        public Criteria andIndustryCnNotLike(String value) {
            addCriterion("industry_cn not like", value, "industryCn");
            return (Criteria) this;
        }

        public Criteria andIndustryCnIn(List<String> values) {
            addCriterion("industry_cn in", values, "industryCn");
            return (Criteria) this;
        }

        public Criteria andIndustryCnNotIn(List<String> values) {
            addCriterion("industry_cn not in", values, "industryCn");
            return (Criteria) this;
        }

        public Criteria andIndustryCnBetween(String value1, String value2) {
            addCriterion("industry_cn between", value1, value2, "industryCn");
            return (Criteria) this;
        }

        public Criteria andIndustryCnNotBetween(String value1, String value2) {
            addCriterion("industry_cn not between", value1, value2, "industryCn");
            return (Criteria) this;
        }

        public Criteria andUsageCodeIsNull() {
            addCriterion("usage_code is null");
            return (Criteria) this;
        }

        public Criteria andUsageCodeIsNotNull() {
            addCriterion("usage_code is not null");
            return (Criteria) this;
        }

        public Criteria andUsageCodeEqualTo(String value) {
            addCriterion("usage_code =", value, "usageCode");
            return (Criteria) this;
        }

        public Criteria andUsageCodeNotEqualTo(String value) {
            addCriterion("usage_code <>", value, "usageCode");
            return (Criteria) this;
        }

        public Criteria andUsageCodeGreaterThan(String value) {
            addCriterion("usage_code >", value, "usageCode");
            return (Criteria) this;
        }

        public Criteria andUsageCodeGreaterThanOrEqualTo(String value) {
            addCriterion("usage_code >=", value, "usageCode");
            return (Criteria) this;
        }

        public Criteria andUsageCodeLessThan(String value) {
            addCriterion("usage_code <", value, "usageCode");
            return (Criteria) this;
        }

        public Criteria andUsageCodeLessThanOrEqualTo(String value) {
            addCriterion("usage_code <=", value, "usageCode");
            return (Criteria) this;
        }

        public Criteria andUsageCodeLike(String value) {
            addCriterion("usage_code like", value, "usageCode");
            return (Criteria) this;
        }

        public Criteria andUsageCodeNotLike(String value) {
            addCriterion("usage_code not like", value, "usageCode");
            return (Criteria) this;
        }

        public Criteria andUsageCodeIn(List<String> values) {
            addCriterion("usage_code in", values, "usageCode");
            return (Criteria) this;
        }

        public Criteria andUsageCodeNotIn(List<String> values) {
            addCriterion("usage_code not in", values, "usageCode");
            return (Criteria) this;
        }

        public Criteria andUsageCodeBetween(String value1, String value2) {
            addCriterion("usage_code between", value1, value2, "usageCode");
            return (Criteria) this;
        }

        public Criteria andUsageCodeNotBetween(String value1, String value2) {
            addCriterion("usage_code not between", value1, value2, "usageCode");
            return (Criteria) this;
        }

        public Criteria andUsageCnIsNull() {
            addCriterion("usage_cn is null");
            return (Criteria) this;
        }

        public Criteria andUsageCnIsNotNull() {
            addCriterion("usage_cn is not null");
            return (Criteria) this;
        }

        public Criteria andUsageCnEqualTo(String value) {
            addCriterion("usage_cn =", value, "usageCn");
            return (Criteria) this;
        }

        public Criteria andUsageCnNotEqualTo(String value) {
            addCriterion("usage_cn <>", value, "usageCn");
            return (Criteria) this;
        }

        public Criteria andUsageCnGreaterThan(String value) {
            addCriterion("usage_cn >", value, "usageCn");
            return (Criteria) this;
        }

        public Criteria andUsageCnGreaterThanOrEqualTo(String value) {
            addCriterion("usage_cn >=", value, "usageCn");
            return (Criteria) this;
        }

        public Criteria andUsageCnLessThan(String value) {
            addCriterion("usage_cn <", value, "usageCn");
            return (Criteria) this;
        }

        public Criteria andUsageCnLessThanOrEqualTo(String value) {
            addCriterion("usage_cn <=", value, "usageCn");
            return (Criteria) this;
        }

        public Criteria andUsageCnLike(String value) {
            addCriterion("usage_cn like", value, "usageCn");
            return (Criteria) this;
        }

        public Criteria andUsageCnNotLike(String value) {
            addCriterion("usage_cn not like", value, "usageCn");
            return (Criteria) this;
        }

        public Criteria andUsageCnIn(List<String> values) {
            addCriterion("usage_cn in", values, "usageCn");
            return (Criteria) this;
        }

        public Criteria andUsageCnNotIn(List<String> values) {
            addCriterion("usage_cn not in", values, "usageCn");
            return (Criteria) this;
        }

        public Criteria andUsageCnBetween(String value1, String value2) {
            addCriterion("usage_cn between", value1, value2, "usageCn");
            return (Criteria) this;
        }

        public Criteria andUsageCnNotBetween(String value1, String value2) {
            addCriterion("usage_cn not between", value1, value2, "usageCn");
            return (Criteria) this;
        }

        public Criteria andUsageEnIsNull() {
            addCriterion("usage_en is null");
            return (Criteria) this;
        }

        public Criteria andUsageEnIsNotNull() {
            addCriterion("usage_en is not null");
            return (Criteria) this;
        }

        public Criteria andUsageEnEqualTo(String value) {
            addCriterion("usage_en =", value, "usageEn");
            return (Criteria) this;
        }

        public Criteria andUsageEnNotEqualTo(String value) {
            addCriterion("usage_en <>", value, "usageEn");
            return (Criteria) this;
        }

        public Criteria andUsageEnGreaterThan(String value) {
            addCriterion("usage_en >", value, "usageEn");
            return (Criteria) this;
        }

        public Criteria andUsageEnGreaterThanOrEqualTo(String value) {
            addCriterion("usage_en >=", value, "usageEn");
            return (Criteria) this;
        }

        public Criteria andUsageEnLessThan(String value) {
            addCriterion("usage_en <", value, "usageEn");
            return (Criteria) this;
        }

        public Criteria andUsageEnLessThanOrEqualTo(String value) {
            addCriterion("usage_en <=", value, "usageEn");
            return (Criteria) this;
        }

        public Criteria andUsageEnLike(String value) {
            addCriterion("usage_en like", value, "usageEn");
            return (Criteria) this;
        }

        public Criteria andUsageEnNotLike(String value) {
            addCriterion("usage_en not like", value, "usageEn");
            return (Criteria) this;
        }

        public Criteria andUsageEnIn(List<String> values) {
            addCriterion("usage_en in", values, "usageEn");
            return (Criteria) this;
        }

        public Criteria andUsageEnNotIn(List<String> values) {
            addCriterion("usage_en not in", values, "usageEn");
            return (Criteria) this;
        }

        public Criteria andUsageEnBetween(String value1, String value2) {
            addCriterion("usage_en between", value1, value2, "usageEn");
            return (Criteria) this;
        }

        public Criteria andUsageEnNotBetween(String value1, String value2) {
            addCriterion("usage_en not between", value1, value2, "usageEn");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Integer value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Integer value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Integer value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Integer value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Integer value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<Integer> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Integer> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Integer value1, Integer value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andRightEndIsNull() {
            addCriterion("right_end is null");
            return (Criteria) this;
        }

        public Criteria andRightEndIsNotNull() {
            addCriterion("right_end is not null");
            return (Criteria) this;
        }

        public Criteria andRightEndEqualTo(Date value) {
            addCriterionForJDBCDate("right_end =", value, "rightEnd");
            return (Criteria) this;
        }

        public Criteria andRightEndNotEqualTo(Date value) {
            addCriterionForJDBCDate("right_end <>", value, "rightEnd");
            return (Criteria) this;
        }

        public Criteria andRightEndGreaterThan(Date value) {
            addCriterionForJDBCDate("right_end >", value, "rightEnd");
            return (Criteria) this;
        }

        public Criteria andRightEndGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("right_end >=", value, "rightEnd");
            return (Criteria) this;
        }

        public Criteria andRightEndLessThan(Date value) {
            addCriterionForJDBCDate("right_end <", value, "rightEnd");
            return (Criteria) this;
        }

        public Criteria andRightEndLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("right_end <=", value, "rightEnd");
            return (Criteria) this;
        }

        public Criteria andRightEndIn(List<Date> values) {
            addCriterionForJDBCDate("right_end in", values, "rightEnd");
            return (Criteria) this;
        }

        public Criteria andRightEndNotIn(List<Date> values) {
            addCriterionForJDBCDate("right_end not in", values, "rightEnd");
            return (Criteria) this;
        }

        public Criteria andRightEndBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("right_end between", value1, value2, "rightEnd");
            return (Criteria) this;
        }

        public Criteria andRightEndNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("right_end not between", value1, value2, "rightEnd");
            return (Criteria) this;
        }

        public Criteria andRightStartIsNull() {
            addCriterion("right_start is null");
            return (Criteria) this;
        }

        public Criteria andRightStartIsNotNull() {
            addCriterion("right_start is not null");
            return (Criteria) this;
        }

        public Criteria andRightStartEqualTo(Date value) {
            addCriterionForJDBCDate("right_start =", value, "rightStart");
            return (Criteria) this;
        }

        public Criteria andRightStartNotEqualTo(Date value) {
            addCriterionForJDBCDate("right_start <>", value, "rightStart");
            return (Criteria) this;
        }

        public Criteria andRightStartGreaterThan(Date value) {
            addCriterionForJDBCDate("right_start >", value, "rightStart");
            return (Criteria) this;
        }

        public Criteria andRightStartGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("right_start >=", value, "rightStart");
            return (Criteria) this;
        }

        public Criteria andRightStartLessThan(Date value) {
            addCriterionForJDBCDate("right_start <", value, "rightStart");
            return (Criteria) this;
        }

        public Criteria andRightStartLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("right_start <=", value, "rightStart");
            return (Criteria) this;
        }

        public Criteria andRightStartIn(List<Date> values) {
            addCriterionForJDBCDate("right_start in", values, "rightStart");
            return (Criteria) this;
        }

        public Criteria andRightStartNotIn(List<Date> values) {
            addCriterionForJDBCDate("right_start not in", values, "rightStart");
            return (Criteria) this;
        }

        public Criteria andRightStartBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("right_start between", value1, value2, "rightStart");
            return (Criteria) this;
        }

        public Criteria andRightStartNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("right_start not between", value1, value2, "rightStart");
            return (Criteria) this;
        }

        public Criteria andProtectionCodeIsNull() {
            addCriterion("protection_code is null");
            return (Criteria) this;
        }

        public Criteria andProtectionCodeIsNotNull() {
            addCriterion("protection_code is not null");
            return (Criteria) this;
        }

        public Criteria andProtectionCodeEqualTo(String value) {
            addCriterion("protection_code =", value, "protectionCode");
            return (Criteria) this;
        }

        public Criteria andProtectionCodeNotEqualTo(String value) {
            addCriterion("protection_code <>", value, "protectionCode");
            return (Criteria) this;
        }

        public Criteria andProtectionCodeGreaterThan(String value) {
            addCriterion("protection_code >", value, "protectionCode");
            return (Criteria) this;
        }

        public Criteria andProtectionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("protection_code >=", value, "protectionCode");
            return (Criteria) this;
        }

        public Criteria andProtectionCodeLessThan(String value) {
            addCriterion("protection_code <", value, "protectionCode");
            return (Criteria) this;
        }

        public Criteria andProtectionCodeLessThanOrEqualTo(String value) {
            addCriterion("protection_code <=", value, "protectionCode");
            return (Criteria) this;
        }

        public Criteria andProtectionCodeLike(String value) {
            addCriterion("protection_code like", value, "protectionCode");
            return (Criteria) this;
        }

        public Criteria andProtectionCodeNotLike(String value) {
            addCriterion("protection_code not like", value, "protectionCode");
            return (Criteria) this;
        }

        public Criteria andProtectionCodeIn(List<String> values) {
            addCriterion("protection_code in", values, "protectionCode");
            return (Criteria) this;
        }

        public Criteria andProtectionCodeNotIn(List<String> values) {
            addCriterion("protection_code not in", values, "protectionCode");
            return (Criteria) this;
        }

        public Criteria andProtectionCodeBetween(String value1, String value2) {
            addCriterion("protection_code between", value1, value2, "protectionCode");
            return (Criteria) this;
        }

        public Criteria andProtectionCodeNotBetween(String value1, String value2) {
            addCriterion("protection_code not between", value1, value2, "protectionCode");
            return (Criteria) this;
        }

        public Criteria andSellRegionIsNull() {
            addCriterion("sell_region is null");
            return (Criteria) this;
        }

        public Criteria andSellRegionIsNotNull() {
            addCriterion("sell_region is not null");
            return (Criteria) this;
        }

        public Criteria andSellRegionEqualTo(String value) {
            addCriterion("sell_region =", value, "sellRegion");
            return (Criteria) this;
        }

        public Criteria andSellRegionNotEqualTo(String value) {
            addCriterion("sell_region <>", value, "sellRegion");
            return (Criteria) this;
        }

        public Criteria andSellRegionGreaterThan(String value) {
            addCriterion("sell_region >", value, "sellRegion");
            return (Criteria) this;
        }

        public Criteria andSellRegionGreaterThanOrEqualTo(String value) {
            addCriterion("sell_region >=", value, "sellRegion");
            return (Criteria) this;
        }

        public Criteria andSellRegionLessThan(String value) {
            addCriterion("sell_region <", value, "sellRegion");
            return (Criteria) this;
        }

        public Criteria andSellRegionLessThanOrEqualTo(String value) {
            addCriterion("sell_region <=", value, "sellRegion");
            return (Criteria) this;
        }

        public Criteria andSellRegionLike(String value) {
            addCriterion("sell_region like", value, "sellRegion");
            return (Criteria) this;
        }

        public Criteria andSellRegionNotLike(String value) {
            addCriterion("sell_region not like", value, "sellRegion");
            return (Criteria) this;
        }

        public Criteria andSellRegionIn(List<String> values) {
            addCriterion("sell_region in", values, "sellRegion");
            return (Criteria) this;
        }

        public Criteria andSellRegionNotIn(List<String> values) {
            addCriterion("sell_region not in", values, "sellRegion");
            return (Criteria) this;
        }

        public Criteria andSellRegionBetween(String value1, String value2) {
            addCriterion("sell_region between", value1, value2, "sellRegion");
            return (Criteria) this;
        }

        public Criteria andSellRegionNotBetween(String value1, String value2) {
            addCriterion("sell_region not between", value1, value2, "sellRegion");
            return (Criteria) this;
        }

        public Criteria andOutbillDateIsNull() {
            addCriterion("outbill_date is null");
            return (Criteria) this;
        }

        public Criteria andOutbillDateIsNotNull() {
            addCriterion("outbill_date is not null");
            return (Criteria) this;
        }

        public Criteria andOutbillDateEqualTo(Date value) {
            addCriterion("outbill_date =", value, "outbillDate");
            return (Criteria) this;
        }

        public Criteria andOutbillDateNotEqualTo(Date value) {
            addCriterion("outbill_date <>", value, "outbillDate");
            return (Criteria) this;
        }

        public Criteria andOutbillDateGreaterThan(Date value) {
            addCriterion("outbill_date >", value, "outbillDate");
            return (Criteria) this;
        }

        public Criteria andOutbillDateGreaterThanOrEqualTo(Date value) {
            addCriterion("outbill_date >=", value, "outbillDate");
            return (Criteria) this;
        }

        public Criteria andOutbillDateLessThan(Date value) {
            addCriterion("outbill_date <", value, "outbillDate");
            return (Criteria) this;
        }

        public Criteria andOutbillDateLessThanOrEqualTo(Date value) {
            addCriterion("outbill_date <=", value, "outbillDate");
            return (Criteria) this;
        }

        public Criteria andOutbillDateIn(List<Date> values) {
            addCriterion("outbill_date in", values, "outbillDate");
            return (Criteria) this;
        }

        public Criteria andOutbillDateNotIn(List<Date> values) {
            addCriterion("outbill_date not in", values, "outbillDate");
            return (Criteria) this;
        }

        public Criteria andOutbillDateBetween(Date value1, Date value2) {
            addCriterion("outbill_date between", value1, value2, "outbillDate");
            return (Criteria) this;
        }

        public Criteria andOutbillDateNotBetween(Date value1, Date value2) {
            addCriterion("outbill_date not between", value1, value2, "outbillDate");
            return (Criteria) this;
        }

        public Criteria andPhotoDownloadtimeIsNull() {
            addCriterion("photo_downloadtime is null");
            return (Criteria) this;
        }

        public Criteria andPhotoDownloadtimeIsNotNull() {
            addCriterion("photo_downloadtime is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoDownloadtimeEqualTo(Date value) {
            addCriterion("photo_downloadtime =", value, "photoDownloadtime");
            return (Criteria) this;
        }

        public Criteria andPhotoDownloadtimeNotEqualTo(Date value) {
            addCriterion("photo_downloadtime <>", value, "photoDownloadtime");
            return (Criteria) this;
        }

        public Criteria andPhotoDownloadtimeGreaterThan(Date value) {
            addCriterion("photo_downloadtime >", value, "photoDownloadtime");
            return (Criteria) this;
        }

        public Criteria andPhotoDownloadtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("photo_downloadtime >=", value, "photoDownloadtime");
            return (Criteria) this;
        }

        public Criteria andPhotoDownloadtimeLessThan(Date value) {
            addCriterion("photo_downloadtime <", value, "photoDownloadtime");
            return (Criteria) this;
        }

        public Criteria andPhotoDownloadtimeLessThanOrEqualTo(Date value) {
            addCriterion("photo_downloadtime <=", value, "photoDownloadtime");
            return (Criteria) this;
        }

        public Criteria andPhotoDownloadtimeIn(List<Date> values) {
            addCriterion("photo_downloadtime in", values, "photoDownloadtime");
            return (Criteria) this;
        }

        public Criteria andPhotoDownloadtimeNotIn(List<Date> values) {
            addCriterion("photo_downloadtime not in", values, "photoDownloadtime");
            return (Criteria) this;
        }

        public Criteria andPhotoDownloadtimeBetween(Date value1, Date value2) {
            addCriterion("photo_downloadtime between", value1, value2, "photoDownloadtime");
            return (Criteria) this;
        }

        public Criteria andPhotoDownloadtimeNotBetween(Date value1, Date value2) {
            addCriterion("photo_downloadtime not between", value1, value2, "photoDownloadtime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeIsNull() {
            addCriterion("confirm_time is null");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeIsNotNull() {
            addCriterion("confirm_time is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeEqualTo(Date value) {
            addCriterion("confirm_time =", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeNotEqualTo(Date value) {
            addCriterion("confirm_time <>", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeGreaterThan(Date value) {
            addCriterion("confirm_time >", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("confirm_time >=", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeLessThan(Date value) {
            addCriterion("confirm_time <", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeLessThanOrEqualTo(Date value) {
            addCriterion("confirm_time <=", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeIn(List<Date> values) {
            addCriterion("confirm_time in", values, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeNotIn(List<Date> values) {
            addCriterion("confirm_time not in", values, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeBetween(Date value1, Date value2) {
            addCriterion("confirm_time between", value1, value2, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeNotBetween(Date value1, Date value2) {
            addCriterion("confirm_time not between", value1, value2, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andSkeletonPathIsNull() {
            addCriterion("skeleton_path is null");
            return (Criteria) this;
        }

        public Criteria andSkeletonPathIsNotNull() {
            addCriterion("skeleton_path is not null");
            return (Criteria) this;
        }

        public Criteria andSkeletonPathEqualTo(String value) {
            addCriterion("skeleton_path =", value, "skeletonPath");
            return (Criteria) this;
        }

        public Criteria andSkeletonPathNotEqualTo(String value) {
            addCriterion("skeleton_path <>", value, "skeletonPath");
            return (Criteria) this;
        }

        public Criteria andSkeletonPathGreaterThan(String value) {
            addCriterion("skeleton_path >", value, "skeletonPath");
            return (Criteria) this;
        }

        public Criteria andSkeletonPathGreaterThanOrEqualTo(String value) {
            addCriterion("skeleton_path >=", value, "skeletonPath");
            return (Criteria) this;
        }

        public Criteria andSkeletonPathLessThan(String value) {
            addCriterion("skeleton_path <", value, "skeletonPath");
            return (Criteria) this;
        }

        public Criteria andSkeletonPathLessThanOrEqualTo(String value) {
            addCriterion("skeleton_path <=", value, "skeletonPath");
            return (Criteria) this;
        }

        public Criteria andSkeletonPathLike(String value) {
            addCriterion("skeleton_path like", value, "skeletonPath");
            return (Criteria) this;
        }

        public Criteria andSkeletonPathNotLike(String value) {
            addCriterion("skeleton_path not like", value, "skeletonPath");
            return (Criteria) this;
        }

        public Criteria andSkeletonPathIn(List<String> values) {
            addCriterion("skeleton_path in", values, "skeletonPath");
            return (Criteria) this;
        }

        public Criteria andSkeletonPathNotIn(List<String> values) {
            addCriterion("skeleton_path not in", values, "skeletonPath");
            return (Criteria) this;
        }

        public Criteria andSkeletonPathBetween(String value1, String value2) {
            addCriterion("skeleton_path between", value1, value2, "skeletonPath");
            return (Criteria) this;
        }

        public Criteria andSkeletonPathNotBetween(String value1, String value2) {
            addCriterion("skeleton_path not between", value1, value2, "skeletonPath");
            return (Criteria) this;
        }

        public Criteria andOrderConfirmedIsNull() {
            addCriterion("order_confirmed is null");
            return (Criteria) this;
        }

        public Criteria andOrderConfirmedIsNotNull() {
            addCriterion("order_confirmed is not null");
            return (Criteria) this;
        }

        public Criteria andOrderConfirmedEqualTo(Integer value) {
            addCriterion("order_confirmed =", value, "orderConfirmed");
            return (Criteria) this;
        }

        public Criteria andOrderConfirmedNotEqualTo(Integer value) {
            addCriterion("order_confirmed <>", value, "orderConfirmed");
            return (Criteria) this;
        }

        public Criteria andOrderConfirmedGreaterThan(Integer value) {
            addCriterion("order_confirmed >", value, "orderConfirmed");
            return (Criteria) this;
        }

        public Criteria andOrderConfirmedGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_confirmed >=", value, "orderConfirmed");
            return (Criteria) this;
        }

        public Criteria andOrderConfirmedLessThan(Integer value) {
            addCriterion("order_confirmed <", value, "orderConfirmed");
            return (Criteria) this;
        }

        public Criteria andOrderConfirmedLessThanOrEqualTo(Integer value) {
            addCriterion("order_confirmed <=", value, "orderConfirmed");
            return (Criteria) this;
        }

        public Criteria andOrderConfirmedIn(List<Integer> values) {
            addCriterion("order_confirmed in", values, "orderConfirmed");
            return (Criteria) this;
        }

        public Criteria andOrderConfirmedNotIn(List<Integer> values) {
            addCriterion("order_confirmed not in", values, "orderConfirmed");
            return (Criteria) this;
        }

        public Criteria andOrderConfirmedBetween(Integer value1, Integer value2) {
            addCriterion("order_confirmed between", value1, value2, "orderConfirmed");
            return (Criteria) this;
        }

        public Criteria andOrderConfirmedNotBetween(Integer value1, Integer value2) {
            addCriterion("order_confirmed not between", value1, value2, "orderConfirmed");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedIsNull() {
            addCriterion("share_confirmed is null");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedIsNotNull() {
            addCriterion("share_confirmed is not null");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedEqualTo(Integer value) {
            addCriterion("share_confirmed =", value, "shareConfirmed");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedNotEqualTo(Integer value) {
            addCriterion("share_confirmed <>", value, "shareConfirmed");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedGreaterThan(Integer value) {
            addCriterion("share_confirmed >", value, "shareConfirmed");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_confirmed >=", value, "shareConfirmed");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedLessThan(Integer value) {
            addCriterion("share_confirmed <", value, "shareConfirmed");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedLessThanOrEqualTo(Integer value) {
            addCriterion("share_confirmed <=", value, "shareConfirmed");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedIn(List<Integer> values) {
            addCriterion("share_confirmed in", values, "shareConfirmed");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedNotIn(List<Integer> values) {
            addCriterion("share_confirmed not in", values, "shareConfirmed");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedBetween(Integer value1, Integer value2) {
            addCriterion("share_confirmed between", value1, value2, "shareConfirmed");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedNotBetween(Integer value1, Integer value2) {
            addCriterion("share_confirmed not between", value1, value2, "shareConfirmed");
            return (Criteria) this;
        }

        public Criteria andAgentTypeIsNull() {
            addCriterion("agent_type is null");
            return (Criteria) this;
        }

        public Criteria andAgentTypeIsNotNull() {
            addCriterion("agent_type is not null");
            return (Criteria) this;
        }

        public Criteria andAgentTypeEqualTo(Integer value) {
            addCriterion("agent_type =", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeNotEqualTo(Integer value) {
            addCriterion("agent_type <>", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeGreaterThan(Integer value) {
            addCriterion("agent_type >", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("agent_type >=", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeLessThan(Integer value) {
            addCriterion("agent_type <", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeLessThanOrEqualTo(Integer value) {
            addCriterion("agent_type <=", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeIn(List<Integer> values) {
            addCriterion("agent_type in", values, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeNotIn(List<Integer> values) {
            addCriterion("agent_type not in", values, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeBetween(Integer value1, Integer value2) {
            addCriterion("agent_type between", value1, value2, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("agent_type not between", value1, value2, "agentType");
            return (Criteria) this;
        }

        public Criteria andMonthlyConfirmedIsNull() {
            addCriterion("monthly_confirmed is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyConfirmedIsNotNull() {
            addCriterion("monthly_confirmed is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyConfirmedEqualTo(Integer value) {
            addCriterion("monthly_confirmed =", value, "monthlyConfirmed");
            return (Criteria) this;
        }

        public Criteria andMonthlyConfirmedNotEqualTo(Integer value) {
            addCriterion("monthly_confirmed <>", value, "monthlyConfirmed");
            return (Criteria) this;
        }

        public Criteria andMonthlyConfirmedGreaterThan(Integer value) {
            addCriterion("monthly_confirmed >", value, "monthlyConfirmed");
            return (Criteria) this;
        }

        public Criteria andMonthlyConfirmedGreaterThanOrEqualTo(Integer value) {
            addCriterion("monthly_confirmed >=", value, "monthlyConfirmed");
            return (Criteria) this;
        }

        public Criteria andMonthlyConfirmedLessThan(Integer value) {
            addCriterion("monthly_confirmed <", value, "monthlyConfirmed");
            return (Criteria) this;
        }

        public Criteria andMonthlyConfirmedLessThanOrEqualTo(Integer value) {
            addCriterion("monthly_confirmed <=", value, "monthlyConfirmed");
            return (Criteria) this;
        }

        public Criteria andMonthlyConfirmedIn(List<Integer> values) {
            addCriterion("monthly_confirmed in", values, "monthlyConfirmed");
            return (Criteria) this;
        }

        public Criteria andMonthlyConfirmedNotIn(List<Integer> values) {
            addCriterion("monthly_confirmed not in", values, "monthlyConfirmed");
            return (Criteria) this;
        }

        public Criteria andMonthlyConfirmedBetween(Integer value1, Integer value2) {
            addCriterion("monthly_confirmed between", value1, value2, "monthlyConfirmed");
            return (Criteria) this;
        }

        public Criteria andMonthlyConfirmedNotBetween(Integer value1, Integer value2) {
            addCriterion("monthly_confirmed not between", value1, value2, "monthlyConfirmed");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }
    }

public static class Criteria extends GeneratedCriteria implements Serializable {

	private static final long serialVersionUID = 1738370589378025841L;


        protected Criteria() {
            super();
        }
    }

public static class Criterion implements Serializable {

	private static final long serialVersionUID = 122353106018115009L;

        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
