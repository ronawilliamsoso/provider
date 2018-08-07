package com.vcg.provider.model.query;

import java.io.Serializable;
import com.vcg.common.base.BaseExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProviderApplicationExample extends BaseExample {

	private static final long serialVersionUID = 4469453927933261995L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProviderApplicationExample() {
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

	private static final long serialVersionUID = 4086638794545673556L;

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

        public Criteria andProviderIdIsNull() {
            addCriterion("provider_id is null");
            return (Criteria) this;
        }

        public Criteria andProviderIdIsNotNull() {
            addCriterion("provider_id is not null");
            return (Criteria) this;
        }

        public Criteria andProviderIdEqualTo(String value) {
            addCriterion("provider_id =", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotEqualTo(String value) {
            addCriterion("provider_id <>", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdGreaterThan(String value) {
            addCriterion("provider_id >", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdGreaterThanOrEqualTo(String value) {
            addCriterion("provider_id >=", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdLessThan(String value) {
            addCriterion("provider_id <", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdLessThanOrEqualTo(String value) {
            addCriterion("provider_id <=", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdLike(String value) {
            addCriterion("provider_id like", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotLike(String value) {
            addCriterion("provider_id not like", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdIn(List<String> values) {
            addCriterion("provider_id in", values, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotIn(List<String> values) {
            addCriterion("provider_id not in", values, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdBetween(String value1, String value2) {
            addCriterion("provider_id between", value1, value2, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotBetween(String value1, String value2) {
            addCriterion("provider_id not between", value1, value2, "providerId");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andNameCnIsNull() {
            addCriterion("name_cn is null");
            return (Criteria) this;
        }

        public Criteria andNameCnIsNotNull() {
            addCriterion("name_cn is not null");
            return (Criteria) this;
        }

        public Criteria andNameCnEqualTo(String value) {
            addCriterion("name_cn =", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotEqualTo(String value) {
            addCriterion("name_cn <>", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnGreaterThan(String value) {
            addCriterion("name_cn >", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("name_cn >=", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnLessThan(String value) {
            addCriterion("name_cn <", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnLessThanOrEqualTo(String value) {
            addCriterion("name_cn <=", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnLike(String value) {
            addCriterion("name_cn like", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotLike(String value) {
            addCriterion("name_cn not like", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnIn(List<String> values) {
            addCriterion("name_cn in", values, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotIn(List<String> values) {
            addCriterion("name_cn not in", values, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnBetween(String value1, String value2) {
            addCriterion("name_cn between", value1, value2, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotBetween(String value1, String value2) {
            addCriterion("name_cn not between", value1, value2, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameEnIsNull() {
            addCriterion("name_en is null");
            return (Criteria) this;
        }

        public Criteria andNameEnIsNotNull() {
            addCriterion("name_en is not null");
            return (Criteria) this;
        }

        public Criteria andNameEnEqualTo(String value) {
            addCriterion("name_en =", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotEqualTo(String value) {
            addCriterion("name_en <>", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnGreaterThan(String value) {
            addCriterion("name_en >", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("name_en >=", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLessThan(String value) {
            addCriterion("name_en <", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLessThanOrEqualTo(String value) {
            addCriterion("name_en <=", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLike(String value) {
            addCriterion("name_en like", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotLike(String value) {
            addCriterion("name_en not like", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnIn(List<String> values) {
            addCriterion("name_en in", values, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotIn(List<String> values) {
            addCriterion("name_en not in", values, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnBetween(String value1, String value2) {
            addCriterion("name_en between", value1, value2, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotBetween(String value1, String value2) {
            addCriterion("name_en not between", value1, value2, "nameEn");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNull() {
            addCriterion("short_name is null");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("short_name is not null");
            return (Criteria) this;
        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("short_name =", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("short_name <>", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("short_name >", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("short_name >=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("short_name <", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("short_name <=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLike(String value) {
            addCriterion("short_name like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("short_name not like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameIn(List<String> values) {
            addCriterion("short_name in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotIn(List<String> values) {
            addCriterion("short_name not in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("short_name between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("short_name not between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andAssetTypeIsNull() {
            addCriterion("asset_type is null");
            return (Criteria) this;
        }

        public Criteria andAssetTypeIsNotNull() {
            addCriterion("asset_type is not null");
            return (Criteria) this;
        }

        public Criteria andAssetTypeEqualTo(Integer value) {
            addCriterion("asset_type =", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeNotEqualTo(Integer value) {
            addCriterion("asset_type <>", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeGreaterThan(Integer value) {
            addCriterion("asset_type >", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("asset_type >=", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeLessThan(Integer value) {
            addCriterion("asset_type <", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeLessThanOrEqualTo(Integer value) {
            addCriterion("asset_type <=", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeIn(List<Integer> values) {
            addCriterion("asset_type in", values, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeNotIn(List<Integer> values) {
            addCriterion("asset_type not in", values, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeBetween(Integer value1, Integer value2) {
            addCriterion("asset_type between", value1, value2, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("asset_type not between", value1, value2, "assetType");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andProviderCompanyIsNull() {
            addCriterion("provider_company is null");
            return (Criteria) this;
        }

        public Criteria andProviderCompanyIsNotNull() {
            addCriterion("provider_company is not null");
            return (Criteria) this;
        }

        public Criteria andProviderCompanyEqualTo(String value) {
            addCriterion("provider_company =", value, "providerCompany");
            return (Criteria) this;
        }

        public Criteria andProviderCompanyNotEqualTo(String value) {
            addCriterion("provider_company <>", value, "providerCompany");
            return (Criteria) this;
        }

        public Criteria andProviderCompanyGreaterThan(String value) {
            addCriterion("provider_company >", value, "providerCompany");
            return (Criteria) this;
        }

        public Criteria andProviderCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("provider_company >=", value, "providerCompany");
            return (Criteria) this;
        }

        public Criteria andProviderCompanyLessThan(String value) {
            addCriterion("provider_company <", value, "providerCompany");
            return (Criteria) this;
        }

        public Criteria andProviderCompanyLessThanOrEqualTo(String value) {
            addCriterion("provider_company <=", value, "providerCompany");
            return (Criteria) this;
        }

        public Criteria andProviderCompanyLike(String value) {
            addCriterion("provider_company like", value, "providerCompany");
            return (Criteria) this;
        }

        public Criteria andProviderCompanyNotLike(String value) {
            addCriterion("provider_company not like", value, "providerCompany");
            return (Criteria) this;
        }

        public Criteria andProviderCompanyIn(List<String> values) {
            addCriterion("provider_company in", values, "providerCompany");
            return (Criteria) this;
        }

        public Criteria andProviderCompanyNotIn(List<String> values) {
            addCriterion("provider_company not in", values, "providerCompany");
            return (Criteria) this;
        }

        public Criteria andProviderCompanyBetween(String value1, String value2) {
            addCriterion("provider_company between", value1, value2, "providerCompany");
            return (Criteria) this;
        }

        public Criteria andProviderCompanyNotBetween(String value1, String value2) {
            addCriterion("provider_company not between", value1, value2, "providerCompany");
            return (Criteria) this;
        }

        public Criteria andJobTypeIsNull() {
            addCriterion("job_type is null");
            return (Criteria) this;
        }

        public Criteria andJobTypeIsNotNull() {
            addCriterion("job_type is not null");
            return (Criteria) this;
        }

        public Criteria andJobTypeEqualTo(Integer value) {
            addCriterion("job_type =", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotEqualTo(Integer value) {
            addCriterion("job_type <>", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeGreaterThan(Integer value) {
            addCriterion("job_type >", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("job_type >=", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeLessThan(Integer value) {
            addCriterion("job_type <", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeLessThanOrEqualTo(Integer value) {
            addCriterion("job_type <=", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeIn(List<Integer> values) {
            addCriterion("job_type in", values, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotIn(List<Integer> values) {
            addCriterion("job_type not in", values, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeBetween(Integer value1, Integer value2) {
            addCriterion("job_type between", value1, value2, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("job_type not between", value1, value2, "jobType");
            return (Criteria) this;
        }

        public Criteria andQualityRankIsNull() {
            addCriterion("quality_rank is null");
            return (Criteria) this;
        }

        public Criteria andQualityRankIsNotNull() {
            addCriterion("quality_rank is not null");
            return (Criteria) this;
        }

        public Criteria andQualityRankEqualTo(String value) {
            addCriterion("quality_rank =", value, "qualityRank");
            return (Criteria) this;
        }

        public Criteria andQualityRankNotEqualTo(String value) {
            addCriterion("quality_rank <>", value, "qualityRank");
            return (Criteria) this;
        }

        public Criteria andQualityRankGreaterThan(String value) {
            addCriterion("quality_rank >", value, "qualityRank");
            return (Criteria) this;
        }

        public Criteria andQualityRankGreaterThanOrEqualTo(String value) {
            addCriterion("quality_rank >=", value, "qualityRank");
            return (Criteria) this;
        }

        public Criteria andQualityRankLessThan(String value) {
            addCriterion("quality_rank <", value, "qualityRank");
            return (Criteria) this;
        }

        public Criteria andQualityRankLessThanOrEqualTo(String value) {
            addCriterion("quality_rank <=", value, "qualityRank");
            return (Criteria) this;
        }

        public Criteria andQualityRankLike(String value) {
            addCriterion("quality_rank like", value, "qualityRank");
            return (Criteria) this;
        }

        public Criteria andQualityRankNotLike(String value) {
            addCriterion("quality_rank not like", value, "qualityRank");
            return (Criteria) this;
        }

        public Criteria andQualityRankIn(List<String> values) {
            addCriterion("quality_rank in", values, "qualityRank");
            return (Criteria) this;
        }

        public Criteria andQualityRankNotIn(List<String> values) {
            addCriterion("quality_rank not in", values, "qualityRank");
            return (Criteria) this;
        }

        public Criteria andQualityRankBetween(String value1, String value2) {
            addCriterion("quality_rank between", value1, value2, "qualityRank");
            return (Criteria) this;
        }

        public Criteria andQualityRankNotBetween(String value1, String value2) {
            addCriterion("quality_rank not between", value1, value2, "qualityRank");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andProductionsIsNull() {
            addCriterion("productions is null");
            return (Criteria) this;
        }

        public Criteria andProductionsIsNotNull() {
            addCriterion("productions is not null");
            return (Criteria) this;
        }

        public Criteria andProductionsEqualTo(String value) {
            addCriterion("productions =", value, "productions");
            return (Criteria) this;
        }

        public Criteria andProductionsNotEqualTo(String value) {
            addCriterion("productions <>", value, "productions");
            return (Criteria) this;
        }

        public Criteria andProductionsGreaterThan(String value) {
            addCriterion("productions >", value, "productions");
            return (Criteria) this;
        }

        public Criteria andProductionsGreaterThanOrEqualTo(String value) {
            addCriterion("productions >=", value, "productions");
            return (Criteria) this;
        }

        public Criteria andProductionsLessThan(String value) {
            addCriterion("productions <", value, "productions");
            return (Criteria) this;
        }

        public Criteria andProductionsLessThanOrEqualTo(String value) {
            addCriterion("productions <=", value, "productions");
            return (Criteria) this;
        }

        public Criteria andProductionsLike(String value) {
            addCriterion("productions like", value, "productions");
            return (Criteria) this;
        }

        public Criteria andProductionsNotLike(String value) {
            addCriterion("productions not like", value, "productions");
            return (Criteria) this;
        }

        public Criteria andProductionsIn(List<String> values) {
            addCriterion("productions in", values, "productions");
            return (Criteria) this;
        }

        public Criteria andProductionsNotIn(List<String> values) {
            addCriterion("productions not in", values, "productions");
            return (Criteria) this;
        }

        public Criteria andProductionsBetween(String value1, String value2) {
            addCriterion("productions between", value1, value2, "productions");
            return (Criteria) this;
        }

        public Criteria andProductionsNotBetween(String value1, String value2) {
            addCriterion("productions not between", value1, value2, "productions");
            return (Criteria) this;
        }

        public Criteria andPasstTimeIsNull() {
            addCriterion("passt_time is null");
            return (Criteria) this;
        }

        public Criteria andPasstTimeIsNotNull() {
            addCriterion("passt_time is not null");
            return (Criteria) this;
        }

        public Criteria andPasstTimeEqualTo(Date value) {
            addCriterion("passt_time =", value, "passtTime");
            return (Criteria) this;
        }

        public Criteria andPasstTimeNotEqualTo(Date value) {
            addCriterion("passt_time <>", value, "passtTime");
            return (Criteria) this;
        }

        public Criteria andPasstTimeGreaterThan(Date value) {
            addCriterion("passt_time >", value, "passtTime");
            return (Criteria) this;
        }

        public Criteria andPasstTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("passt_time >=", value, "passtTime");
            return (Criteria) this;
        }

        public Criteria andPasstTimeLessThan(Date value) {
            addCriterion("passt_time <", value, "passtTime");
            return (Criteria) this;
        }

        public Criteria andPasstTimeLessThanOrEqualTo(Date value) {
            addCriterion("passt_time <=", value, "passtTime");
            return (Criteria) this;
        }

        public Criteria andPasstTimeIn(List<Date> values) {
            addCriterion("passt_time in", values, "passtTime");
            return (Criteria) this;
        }

        public Criteria andPasstTimeNotIn(List<Date> values) {
            addCriterion("passt_time not in", values, "passtTime");
            return (Criteria) this;
        }

        public Criteria andPasstTimeBetween(Date value1, Date value2) {
            addCriterion("passt_time between", value1, value2, "passtTime");
            return (Criteria) this;
        }

        public Criteria andPasstTimeNotBetween(Date value1, Date value2) {
            addCriterion("passt_time not between", value1, value2, "passtTime");
            return (Criteria) this;
        }

        public Criteria andPassUserIdIsNull() {
            addCriterion("pass_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPassUserIdIsNotNull() {
            addCriterion("pass_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPassUserIdEqualTo(String value) {
            addCriterion("pass_user_id =", value, "passUserId");
            return (Criteria) this;
        }

        public Criteria andPassUserIdNotEqualTo(String value) {
            addCriterion("pass_user_id <>", value, "passUserId");
            return (Criteria) this;
        }

        public Criteria andPassUserIdGreaterThan(String value) {
            addCriterion("pass_user_id >", value, "passUserId");
            return (Criteria) this;
        }

        public Criteria andPassUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("pass_user_id >=", value, "passUserId");
            return (Criteria) this;
        }

        public Criteria andPassUserIdLessThan(String value) {
            addCriterion("pass_user_id <", value, "passUserId");
            return (Criteria) this;
        }

        public Criteria andPassUserIdLessThanOrEqualTo(String value) {
            addCriterion("pass_user_id <=", value, "passUserId");
            return (Criteria) this;
        }

        public Criteria andPassUserIdLike(String value) {
            addCriterion("pass_user_id like", value, "passUserId");
            return (Criteria) this;
        }

        public Criteria andPassUserIdNotLike(String value) {
            addCriterion("pass_user_id not like", value, "passUserId");
            return (Criteria) this;
        }

        public Criteria andPassUserIdIn(List<String> values) {
            addCriterion("pass_user_id in", values, "passUserId");
            return (Criteria) this;
        }

        public Criteria andPassUserIdNotIn(List<String> values) {
            addCriterion("pass_user_id not in", values, "passUserId");
            return (Criteria) this;
        }

        public Criteria andPassUserIdBetween(String value1, String value2) {
            addCriterion("pass_user_id between", value1, value2, "passUserId");
            return (Criteria) this;
        }

        public Criteria andPassUserIdNotBetween(String value1, String value2) {
            addCriterion("pass_user_id not between", value1, value2, "passUserId");
            return (Criteria) this;
        }

        public Criteria andUserCenterIdIsNull() {
            addCriterion("user_center_id is null");
            return (Criteria) this;
        }

        public Criteria andUserCenterIdIsNotNull() {
            addCriterion("user_center_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserCenterIdEqualTo(String value) {
            addCriterion("user_center_id =", value, "userCenterId");
            return (Criteria) this;
        }

        public Criteria andUserCenterIdNotEqualTo(String value) {
            addCriterion("user_center_id <>", value, "userCenterId");
            return (Criteria) this;
        }

        public Criteria andUserCenterIdGreaterThan(String value) {
            addCriterion("user_center_id >", value, "userCenterId");
            return (Criteria) this;
        }

        public Criteria andUserCenterIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_center_id >=", value, "userCenterId");
            return (Criteria) this;
        }

        public Criteria andUserCenterIdLessThan(String value) {
            addCriterion("user_center_id <", value, "userCenterId");
            return (Criteria) this;
        }

        public Criteria andUserCenterIdLessThanOrEqualTo(String value) {
            addCriterion("user_center_id <=", value, "userCenterId");
            return (Criteria) this;
        }

        public Criteria andUserCenterIdLike(String value) {
            addCriterion("user_center_id like", value, "userCenterId");
            return (Criteria) this;
        }

        public Criteria andUserCenterIdNotLike(String value) {
            addCriterion("user_center_id not like", value, "userCenterId");
            return (Criteria) this;
        }

        public Criteria andUserCenterIdIn(List<String> values) {
            addCriterion("user_center_id in", values, "userCenterId");
            return (Criteria) this;
        }

        public Criteria andUserCenterIdNotIn(List<String> values) {
            addCriterion("user_center_id not in", values, "userCenterId");
            return (Criteria) this;
        }

        public Criteria andUserCenterIdBetween(String value1, String value2) {
            addCriterion("user_center_id between", value1, value2, "userCenterId");
            return (Criteria) this;
        }

        public Criteria andUserCenterIdNotBetween(String value1, String value2) {
            addCriterion("user_center_id not between", value1, value2, "userCenterId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andOrdersIsNull() {
            addCriterion("orders is null");
            return (Criteria) this;
        }

        public Criteria andOrdersIsNotNull() {
            addCriterion("orders is not null");
            return (Criteria) this;
        }

        public Criteria andOrdersEqualTo(Integer value) {
            addCriterion("orders =", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersNotEqualTo(Integer value) {
            addCriterion("orders <>", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersGreaterThan(Integer value) {
            addCriterion("orders >", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersGreaterThanOrEqualTo(Integer value) {
            addCriterion("orders >=", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersLessThan(Integer value) {
            addCriterion("orders <", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersLessThanOrEqualTo(Integer value) {
            addCriterion("orders <=", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersIn(List<Integer> values) {
            addCriterion("orders in", values, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersNotIn(List<Integer> values) {
            addCriterion("orders not in", values, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersBetween(Integer value1, Integer value2) {
            addCriterion("orders between", value1, value2, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersNotBetween(Integer value1, Integer value2) {
            addCriterion("orders not between", value1, value2, "orders");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andAttributeIsNull() {
            addCriterion("attribute is null");
            return (Criteria) this;
        }

        public Criteria andAttributeIsNotNull() {
            addCriterion("attribute is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeEqualTo(String value) {
            addCriterion("attribute =", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeNotEqualTo(String value) {
            addCriterion("attribute <>", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeGreaterThan(String value) {
            addCriterion("attribute >", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeGreaterThanOrEqualTo(String value) {
            addCriterion("attribute >=", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeLessThan(String value) {
            addCriterion("attribute <", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeLessThanOrEqualTo(String value) {
            addCriterion("attribute <=", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeLike(String value) {
            addCriterion("attribute like", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeNotLike(String value) {
            addCriterion("attribute not like", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeIn(List<String> values) {
            addCriterion("attribute in", values, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeNotIn(List<String> values) {
            addCriterion("attribute not in", values, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeBetween(String value1, String value2) {
            addCriterion("attribute between", value1, value2, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeNotBetween(String value1, String value2) {
            addCriterion("attribute not between", value1, value2, "attribute");
            return (Criteria) this;
        }

        public Criteria andProviderWebsiteIsNull() {
            addCriterion("provider_website is null");
            return (Criteria) this;
        }

        public Criteria andProviderWebsiteIsNotNull() {
            addCriterion("provider_website is not null");
            return (Criteria) this;
        }

        public Criteria andProviderWebsiteEqualTo(String value) {
            addCriterion("provider_website =", value, "providerWebsite");
            return (Criteria) this;
        }

        public Criteria andProviderWebsiteNotEqualTo(String value) {
            addCriterion("provider_website <>", value, "providerWebsite");
            return (Criteria) this;
        }

        public Criteria andProviderWebsiteGreaterThan(String value) {
            addCriterion("provider_website >", value, "providerWebsite");
            return (Criteria) this;
        }

        public Criteria andProviderWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("provider_website >=", value, "providerWebsite");
            return (Criteria) this;
        }

        public Criteria andProviderWebsiteLessThan(String value) {
            addCriterion("provider_website <", value, "providerWebsite");
            return (Criteria) this;
        }

        public Criteria andProviderWebsiteLessThanOrEqualTo(String value) {
            addCriterion("provider_website <=", value, "providerWebsite");
            return (Criteria) this;
        }

        public Criteria andProviderWebsiteLike(String value) {
            addCriterion("provider_website like", value, "providerWebsite");
            return (Criteria) this;
        }

        public Criteria andProviderWebsiteNotLike(String value) {
            addCriterion("provider_website not like", value, "providerWebsite");
            return (Criteria) this;
        }

        public Criteria andProviderWebsiteIn(List<String> values) {
            addCriterion("provider_website in", values, "providerWebsite");
            return (Criteria) this;
        }

        public Criteria andProviderWebsiteNotIn(List<String> values) {
            addCriterion("provider_website not in", values, "providerWebsite");
            return (Criteria) this;
        }

        public Criteria andProviderWebsiteBetween(String value1, String value2) {
            addCriterion("provider_website between", value1, value2, "providerWebsite");
            return (Criteria) this;
        }

        public Criteria andProviderWebsiteNotBetween(String value1, String value2) {
            addCriterion("provider_website not between", value1, value2, "providerWebsite");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameIsNull() {
            addCriterion("website_name is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameIsNotNull() {
            addCriterion("website_name is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameEqualTo(String value) {
            addCriterion("website_name =", value, "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameNotEqualTo(String value) {
            addCriterion("website_name <>", value, "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameGreaterThan(String value) {
            addCriterion("website_name >", value, "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameGreaterThanOrEqualTo(String value) {
            addCriterion("website_name >=", value, "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameLessThan(String value) {
            addCriterion("website_name <", value, "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameLessThanOrEqualTo(String value) {
            addCriterion("website_name <=", value, "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameLike(String value) {
            addCriterion("website_name like", value, "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameNotLike(String value) {
            addCriterion("website_name not like", value, "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameIn(List<String> values) {
            addCriterion("website_name in", values, "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameNotIn(List<String> values) {
            addCriterion("website_name not in", values, "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameBetween(String value1, String value2) {
            addCriterion("website_name between", value1, value2, "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameNotBetween(String value1, String value2) {
            addCriterion("website_name not between", value1, value2, "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsitePasswordIsNull() {
            addCriterion("website_password is null");
            return (Criteria) this;
        }

        public Criteria andWebsitePasswordIsNotNull() {
            addCriterion("website_password is not null");
            return (Criteria) this;
        }

        public Criteria andWebsitePasswordEqualTo(String value) {
            addCriterion("website_password =", value, "websitePassword");
            return (Criteria) this;
        }

        public Criteria andWebsitePasswordNotEqualTo(String value) {
            addCriterion("website_password <>", value, "websitePassword");
            return (Criteria) this;
        }

        public Criteria andWebsitePasswordGreaterThan(String value) {
            addCriterion("website_password >", value, "websitePassword");
            return (Criteria) this;
        }

        public Criteria andWebsitePasswordGreaterThanOrEqualTo(String value) {
            addCriterion("website_password >=", value, "websitePassword");
            return (Criteria) this;
        }

        public Criteria andWebsitePasswordLessThan(String value) {
            addCriterion("website_password <", value, "websitePassword");
            return (Criteria) this;
        }

        public Criteria andWebsitePasswordLessThanOrEqualTo(String value) {
            addCriterion("website_password <=", value, "websitePassword");
            return (Criteria) this;
        }

        public Criteria andWebsitePasswordLike(String value) {
            addCriterion("website_password like", value, "websitePassword");
            return (Criteria) this;
        }

        public Criteria andWebsitePasswordNotLike(String value) {
            addCriterion("website_password not like", value, "websitePassword");
            return (Criteria) this;
        }

        public Criteria andWebsitePasswordIn(List<String> values) {
            addCriterion("website_password in", values, "websitePassword");
            return (Criteria) this;
        }

        public Criteria andWebsitePasswordNotIn(List<String> values) {
            addCriterion("website_password not in", values, "websitePassword");
            return (Criteria) this;
        }

        public Criteria andWebsitePasswordBetween(String value1, String value2) {
            addCriterion("website_password between", value1, value2, "websitePassword");
            return (Criteria) this;
        }

        public Criteria andWebsitePasswordNotBetween(String value1, String value2) {
            addCriterion("website_password not between", value1, value2, "websitePassword");
            return (Criteria) this;
        }

        public Criteria andIsNativeIsNull() {
            addCriterion("is_native is null");
            return (Criteria) this;
        }

        public Criteria andIsNativeIsNotNull() {
            addCriterion("is_native is not null");
            return (Criteria) this;
        }

        public Criteria andIsNativeEqualTo(Integer value) {
            addCriterion("is_native =", value, "isNative");
            return (Criteria) this;
        }

        public Criteria andIsNativeNotEqualTo(Integer value) {
            addCriterion("is_native <>", value, "isNative");
            return (Criteria) this;
        }

        public Criteria andIsNativeGreaterThan(Integer value) {
            addCriterion("is_native >", value, "isNative");
            return (Criteria) this;
        }

        public Criteria andIsNativeGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_native >=", value, "isNative");
            return (Criteria) this;
        }

        public Criteria andIsNativeLessThan(Integer value) {
            addCriterion("is_native <", value, "isNative");
            return (Criteria) this;
        }

        public Criteria andIsNativeLessThanOrEqualTo(Integer value) {
            addCriterion("is_native <=", value, "isNative");
            return (Criteria) this;
        }

        public Criteria andIsNativeIn(List<Integer> values) {
            addCriterion("is_native in", values, "isNative");
            return (Criteria) this;
        }

        public Criteria andIsNativeNotIn(List<Integer> values) {
            addCriterion("is_native not in", values, "isNative");
            return (Criteria) this;
        }

        public Criteria andIsNativeBetween(Integer value1, Integer value2) {
            addCriterion("is_native between", value1, value2, "isNative");
            return (Criteria) this;
        }

        public Criteria andIsNativeNotBetween(Integer value1, Integer value2) {
            addCriterion("is_native not between", value1, value2, "isNative");
            return (Criteria) this;
        }

        public Criteria andLimitedPriceIsNull() {
            addCriterion("limited_price is null");
            return (Criteria) this;
        }

        public Criteria andLimitedPriceIsNotNull() {
            addCriterion("limited_price is not null");
            return (Criteria) this;
        }

        public Criteria andLimitedPriceEqualTo(String value) {
            addCriterion("limited_price =", value, "limitedPrice");
            return (Criteria) this;
        }

        public Criteria andLimitedPriceNotEqualTo(String value) {
            addCriterion("limited_price <>", value, "limitedPrice");
            return (Criteria) this;
        }

        public Criteria andLimitedPriceGreaterThan(String value) {
            addCriterion("limited_price >", value, "limitedPrice");
            return (Criteria) this;
        }

        public Criteria andLimitedPriceGreaterThanOrEqualTo(String value) {
            addCriterion("limited_price >=", value, "limitedPrice");
            return (Criteria) this;
        }

        public Criteria andLimitedPriceLessThan(String value) {
            addCriterion("limited_price <", value, "limitedPrice");
            return (Criteria) this;
        }

        public Criteria andLimitedPriceLessThanOrEqualTo(String value) {
            addCriterion("limited_price <=", value, "limitedPrice");
            return (Criteria) this;
        }

        public Criteria andLimitedPriceLike(String value) {
            addCriterion("limited_price like", value, "limitedPrice");
            return (Criteria) this;
        }

        public Criteria andLimitedPriceNotLike(String value) {
            addCriterion("limited_price not like", value, "limitedPrice");
            return (Criteria) this;
        }

        public Criteria andLimitedPriceIn(List<String> values) {
            addCriterion("limited_price in", values, "limitedPrice");
            return (Criteria) this;
        }

        public Criteria andLimitedPriceNotIn(List<String> values) {
            addCriterion("limited_price not in", values, "limitedPrice");
            return (Criteria) this;
        }

        public Criteria andLimitedPriceBetween(String value1, String value2) {
            addCriterion("limited_price between", value1, value2, "limitedPrice");
            return (Criteria) this;
        }

        public Criteria andLimitedPriceNotBetween(String value1, String value2) {
            addCriterion("limited_price not between", value1, value2, "limitedPrice");
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

        public Criteria andRejectReasonIsNull() {
            addCriterion("reject_reason is null");
            return (Criteria) this;
        }

        public Criteria andRejectReasonIsNotNull() {
            addCriterion("reject_reason is not null");
            return (Criteria) this;
        }

        public Criteria andRejectReasonEqualTo(String value) {
            addCriterion("reject_reason =", value, "rejectReason");
            return (Criteria) this;
        }

        public Criteria andRejectReasonNotEqualTo(String value) {
            addCriterion("reject_reason <>", value, "rejectReason");
            return (Criteria) this;
        }

        public Criteria andRejectReasonGreaterThan(String value) {
            addCriterion("reject_reason >", value, "rejectReason");
            return (Criteria) this;
        }

        public Criteria andRejectReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reject_reason >=", value, "rejectReason");
            return (Criteria) this;
        }

        public Criteria andRejectReasonLessThan(String value) {
            addCriterion("reject_reason <", value, "rejectReason");
            return (Criteria) this;
        }

        public Criteria andRejectReasonLessThanOrEqualTo(String value) {
            addCriterion("reject_reason <=", value, "rejectReason");
            return (Criteria) this;
        }

        public Criteria andRejectReasonLike(String value) {
            addCriterion("reject_reason like", value, "rejectReason");
            return (Criteria) this;
        }

        public Criteria andRejectReasonNotLike(String value) {
            addCriterion("reject_reason not like", value, "rejectReason");
            return (Criteria) this;
        }

        public Criteria andRejectReasonIn(List<String> values) {
            addCriterion("reject_reason in", values, "rejectReason");
            return (Criteria) this;
        }

        public Criteria andRejectReasonNotIn(List<String> values) {
            addCriterion("reject_reason not in", values, "rejectReason");
            return (Criteria) this;
        }

        public Criteria andRejectReasonBetween(String value1, String value2) {
            addCriterion("reject_reason between", value1, value2, "rejectReason");
            return (Criteria) this;
        }

        public Criteria andRejectReasonNotBetween(String value1, String value2) {
            addCriterion("reject_reason not between", value1, value2, "rejectReason");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNull() {
            addCriterion("created_by is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("created_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(String value) {
            addCriterion("created_by =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(String value) {
            addCriterion("created_by <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(String value) {
            addCriterion("created_by >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(String value) {
            addCriterion("created_by >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(String value) {
            addCriterion("created_by <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(String value) {
            addCriterion("created_by <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLike(String value) {
            addCriterion("created_by like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotLike(String value) {
            addCriterion("created_by not like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<String> values) {
            addCriterion("created_by in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<String> values) {
            addCriterion("created_by not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(String value1, String value2) {
            addCriterion("created_by between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(String value1, String value2) {
            addCriterion("created_by not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("updated_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("updated_time =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("updated_time <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("updated_time >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_time >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("updated_time <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("updated_time <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("updated_time in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("updated_time not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("updated_time between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("updated_time not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNull() {
            addCriterion("updated_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNotNull() {
            addCriterion("updated_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByEqualTo(String value) {
            addCriterion("updated_by =", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotEqualTo(String value) {
            addCriterion("updated_by <>", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThan(String value) {
            addCriterion("updated_by >", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThanOrEqualTo(String value) {
            addCriterion("updated_by >=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThan(String value) {
            addCriterion("updated_by <", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThanOrEqualTo(String value) {
            addCriterion("updated_by <=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLike(String value) {
            addCriterion("updated_by like", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotLike(String value) {
            addCriterion("updated_by not like", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIn(List<String> values) {
            addCriterion("updated_by in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotIn(List<String> values) {
            addCriterion("updated_by not in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByBetween(String value1, String value2) {
            addCriterion("updated_by between", value1, value2, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotBetween(String value1, String value2) {
            addCriterion("updated_by not between", value1, value2, "updatedBy");
            return (Criteria) this;
        }
    }

public static class Criteria extends GeneratedCriteria implements Serializable {

	private static final long serialVersionUID = 4808342613531441991L;


        protected Criteria() {
            super();
        }
    }

public static class Criterion implements Serializable {

	private static final long serialVersionUID = 8134504015439100389L;

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
