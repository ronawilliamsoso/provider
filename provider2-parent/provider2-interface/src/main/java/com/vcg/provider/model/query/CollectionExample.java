package com.vcg.provider.model.query;

import java.io.Serializable;
import com.vcg.common.base.BaseExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CollectionExample extends BaseExample {

	private static final long serialVersionUID = 5085828402088194447L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CollectionExample() {
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

	private static final long serialVersionUID = 3417341954195770526L;

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

        public Criteria andContractIdIsNull() {
            addCriterion("contract_id is null");
            return (Criteria) this;
        }

        public Criteria andContractIdIsNotNull() {
            addCriterion("contract_id is not null");
            return (Criteria) this;
        }

        public Criteria andContractIdEqualTo(Integer value) {
            addCriterion("contract_id =", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotEqualTo(Integer value) {
            addCriterion("contract_id <>", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThan(Integer value) {
            addCriterion("contract_id >", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("contract_id >=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThan(Integer value) {
            addCriterion("contract_id <", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThanOrEqualTo(Integer value) {
            addCriterion("contract_id <=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdIn(List<Integer> values) {
            addCriterion("contract_id in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotIn(List<Integer> values) {
            addCriterion("contract_id not in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdBetween(Integer value1, Integer value2) {
            addCriterion("contract_id between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotBetween(Integer value1, Integer value2) {
            addCriterion("contract_id not between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andOriginalNameIsNull() {
            addCriterion("original_name is null");
            return (Criteria) this;
        }

        public Criteria andOriginalNameIsNotNull() {
            addCriterion("original_name is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalNameEqualTo(String value) {
            addCriterion("original_name =", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameNotEqualTo(String value) {
            addCriterion("original_name <>", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameGreaterThan(String value) {
            addCriterion("original_name >", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameGreaterThanOrEqualTo(String value) {
            addCriterion("original_name >=", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameLessThan(String value) {
            addCriterion("original_name <", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameLessThanOrEqualTo(String value) {
            addCriterion("original_name <=", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameLike(String value) {
            addCriterion("original_name like", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameNotLike(String value) {
            addCriterion("original_name not like", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameIn(List<String> values) {
            addCriterion("original_name in", values, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameNotIn(List<String> values) {
            addCriterion("original_name not in", values, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameBetween(String value1, String value2) {
            addCriterion("original_name between", value1, value2, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameNotBetween(String value1, String value2) {
            addCriterion("original_name not between", value1, value2, "originalName");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeIsNull() {
            addCriterion("collection_code is null");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeIsNotNull() {
            addCriterion("collection_code is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeEqualTo(String value) {
            addCriterion("collection_code =", value, "collectionCode");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeNotEqualTo(String value) {
            addCriterion("collection_code <>", value, "collectionCode");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeGreaterThan(String value) {
            addCriterion("collection_code >", value, "collectionCode");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("collection_code >=", value, "collectionCode");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeLessThan(String value) {
            addCriterion("collection_code <", value, "collectionCode");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeLessThanOrEqualTo(String value) {
            addCriterion("collection_code <=", value, "collectionCode");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeLike(String value) {
            addCriterion("collection_code like", value, "collectionCode");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeNotLike(String value) {
            addCriterion("collection_code not like", value, "collectionCode");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeIn(List<String> values) {
            addCriterion("collection_code in", values, "collectionCode");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeNotIn(List<String> values) {
            addCriterion("collection_code not in", values, "collectionCode");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeBetween(String value1, String value2) {
            addCriterion("collection_code between", value1, value2, "collectionCode");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeNotBetween(String value1, String value2) {
            addCriterion("collection_code not between", value1, value2, "collectionCode");
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

        public Criteria andRoyaltyRateIsNull() {
            addCriterion("royalty_rate is null");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateIsNotNull() {
            addCriterion("royalty_rate is not null");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateEqualTo(String value) {
            addCriterion("royalty_rate =", value, "royaltyRate");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateNotEqualTo(String value) {
            addCriterion("royalty_rate <>", value, "royaltyRate");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateGreaterThan(String value) {
            addCriterion("royalty_rate >", value, "royaltyRate");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateGreaterThanOrEqualTo(String value) {
            addCriterion("royalty_rate >=", value, "royaltyRate");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateLessThan(String value) {
            addCriterion("royalty_rate <", value, "royaltyRate");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateLessThanOrEqualTo(String value) {
            addCriterion("royalty_rate <=", value, "royaltyRate");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateLike(String value) {
            addCriterion("royalty_rate like", value, "royaltyRate");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateNotLike(String value) {
            addCriterion("royalty_rate not like", value, "royaltyRate");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateIn(List<String> values) {
            addCriterion("royalty_rate in", values, "royaltyRate");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateNotIn(List<String> values) {
            addCriterion("royalty_rate not in", values, "royaltyRate");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateBetween(String value1, String value2) {
            addCriterion("royalty_rate between", value1, value2, "royaltyRate");
            return (Criteria) this;
        }

        public Criteria andRoyaltyRateNotBetween(String value1, String value2) {
            addCriterion("royalty_rate not between", value1, value2, "royaltyRate");
            return (Criteria) this;
        }

        public Criteria andAuthLocationIsNull() {
            addCriterion("auth_location is null");
            return (Criteria) this;
        }

        public Criteria andAuthLocationIsNotNull() {
            addCriterion("auth_location is not null");
            return (Criteria) this;
        }

        public Criteria andAuthLocationEqualTo(String value) {
            addCriterion("auth_location =", value, "authLocation");
            return (Criteria) this;
        }

        public Criteria andAuthLocationNotEqualTo(String value) {
            addCriterion("auth_location <>", value, "authLocation");
            return (Criteria) this;
        }

        public Criteria andAuthLocationGreaterThan(String value) {
            addCriterion("auth_location >", value, "authLocation");
            return (Criteria) this;
        }

        public Criteria andAuthLocationGreaterThanOrEqualTo(String value) {
            addCriterion("auth_location >=", value, "authLocation");
            return (Criteria) this;
        }

        public Criteria andAuthLocationLessThan(String value) {
            addCriterion("auth_location <", value, "authLocation");
            return (Criteria) this;
        }

        public Criteria andAuthLocationLessThanOrEqualTo(String value) {
            addCriterion("auth_location <=", value, "authLocation");
            return (Criteria) this;
        }

        public Criteria andAuthLocationLike(String value) {
            addCriterion("auth_location like", value, "authLocation");
            return (Criteria) this;
        }

        public Criteria andAuthLocationNotLike(String value) {
            addCriterion("auth_location not like", value, "authLocation");
            return (Criteria) this;
        }

        public Criteria andAuthLocationIn(List<String> values) {
            addCriterion("auth_location in", values, "authLocation");
            return (Criteria) this;
        }

        public Criteria andAuthLocationNotIn(List<String> values) {
            addCriterion("auth_location not in", values, "authLocation");
            return (Criteria) this;
        }

        public Criteria andAuthLocationBetween(String value1, String value2) {
            addCriterion("auth_location between", value1, value2, "authLocation");
            return (Criteria) this;
        }

        public Criteria andAuthLocationNotBetween(String value1, String value2) {
            addCriterion("auth_location not between", value1, value2, "authLocation");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(Integer value) {
            addCriterion("brand_id =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(Integer value) {
            addCriterion("brand_id <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(Integer value) {
            addCriterion("brand_id >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("brand_id >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(Integer value) {
            addCriterion("brand_id <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(Integer value) {
            addCriterion("brand_id <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<Integer> values) {
            addCriterion("brand_id in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<Integer> values) {
            addCriterion("brand_id not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(Integer value1, Integer value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(Integer value1, Integer value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andAvailableStatusIsNull() {
            addCriterion("available_status is null");
            return (Criteria) this;
        }

        public Criteria andAvailableStatusIsNotNull() {
            addCriterion("available_status is not null");
            return (Criteria) this;
        }

        public Criteria andAvailableStatusEqualTo(Integer value) {
            addCriterion("available_status =", value, "availableStatus");
            return (Criteria) this;
        }

        public Criteria andAvailableStatusNotEqualTo(Integer value) {
            addCriterion("available_status <>", value, "availableStatus");
            return (Criteria) this;
        }

        public Criteria andAvailableStatusGreaterThan(Integer value) {
            addCriterion("available_status >", value, "availableStatus");
            return (Criteria) this;
        }

        public Criteria andAvailableStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("available_status >=", value, "availableStatus");
            return (Criteria) this;
        }

        public Criteria andAvailableStatusLessThan(Integer value) {
            addCriterion("available_status <", value, "availableStatus");
            return (Criteria) this;
        }

        public Criteria andAvailableStatusLessThanOrEqualTo(Integer value) {
            addCriterion("available_status <=", value, "availableStatus");
            return (Criteria) this;
        }

        public Criteria andAvailableStatusIn(List<Integer> values) {
            addCriterion("available_status in", values, "availableStatus");
            return (Criteria) this;
        }

        public Criteria andAvailableStatusNotIn(List<Integer> values) {
            addCriterion("available_status not in", values, "availableStatus");
            return (Criteria) this;
        }

        public Criteria andAvailableStatusBetween(Integer value1, Integer value2) {
            addCriterion("available_status between", value1, value2, "availableStatus");
            return (Criteria) this;
        }

        public Criteria andAvailableStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("available_status not between", value1, value2, "availableStatus");
            return (Criteria) this;
        }

        public Criteria andCollectionLevelIsNull() {
            addCriterion("collection_level is null");
            return (Criteria) this;
        }

        public Criteria andCollectionLevelIsNotNull() {
            addCriterion("collection_level is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionLevelEqualTo(String value) {
            addCriterion("collection_level =", value, "collectionLevel");
            return (Criteria) this;
        }

        public Criteria andCollectionLevelNotEqualTo(String value) {
            addCriterion("collection_level <>", value, "collectionLevel");
            return (Criteria) this;
        }

        public Criteria andCollectionLevelGreaterThan(String value) {
            addCriterion("collection_level >", value, "collectionLevel");
            return (Criteria) this;
        }

        public Criteria andCollectionLevelGreaterThanOrEqualTo(String value) {
            addCriterion("collection_level >=", value, "collectionLevel");
            return (Criteria) this;
        }

        public Criteria andCollectionLevelLessThan(String value) {
            addCriterion("collection_level <", value, "collectionLevel");
            return (Criteria) this;
        }

        public Criteria andCollectionLevelLessThanOrEqualTo(String value) {
            addCriterion("collection_level <=", value, "collectionLevel");
            return (Criteria) this;
        }

        public Criteria andCollectionLevelLike(String value) {
            addCriterion("collection_level like", value, "collectionLevel");
            return (Criteria) this;
        }

        public Criteria andCollectionLevelNotLike(String value) {
            addCriterion("collection_level not like", value, "collectionLevel");
            return (Criteria) this;
        }

        public Criteria andCollectionLevelIn(List<String> values) {
            addCriterion("collection_level in", values, "collectionLevel");
            return (Criteria) this;
        }

        public Criteria andCollectionLevelNotIn(List<String> values) {
            addCriterion("collection_level not in", values, "collectionLevel");
            return (Criteria) this;
        }

        public Criteria andCollectionLevelBetween(String value1, String value2) {
            addCriterion("collection_level between", value1, value2, "collectionLevel");
            return (Criteria) this;
        }

        public Criteria andCollectionLevelNotBetween(String value1, String value2) {
            addCriterion("collection_level not between", value1, value2, "collectionLevel");
            return (Criteria) this;
        }

        public Criteria andTargetWebsiteIsNull() {
            addCriterion("target_website is null");
            return (Criteria) this;
        }

        public Criteria andTargetWebsiteIsNotNull() {
            addCriterion("target_website is not null");
            return (Criteria) this;
        }

        public Criteria andTargetWebsiteEqualTo(String value) {
            addCriterion("target_website =", value, "targetWebsite");
            return (Criteria) this;
        }

        public Criteria andTargetWebsiteNotEqualTo(String value) {
            addCriterion("target_website <>", value, "targetWebsite");
            return (Criteria) this;
        }

        public Criteria andTargetWebsiteGreaterThan(String value) {
            addCriterion("target_website >", value, "targetWebsite");
            return (Criteria) this;
        }

        public Criteria andTargetWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("target_website >=", value, "targetWebsite");
            return (Criteria) this;
        }

        public Criteria andTargetWebsiteLessThan(String value) {
            addCriterion("target_website <", value, "targetWebsite");
            return (Criteria) this;
        }

        public Criteria andTargetWebsiteLessThanOrEqualTo(String value) {
            addCriterion("target_website <=", value, "targetWebsite");
            return (Criteria) this;
        }

        public Criteria andTargetWebsiteLike(String value) {
            addCriterion("target_website like", value, "targetWebsite");
            return (Criteria) this;
        }

        public Criteria andTargetWebsiteNotLike(String value) {
            addCriterion("target_website not like", value, "targetWebsite");
            return (Criteria) this;
        }

        public Criteria andTargetWebsiteIn(List<String> values) {
            addCriterion("target_website in", values, "targetWebsite");
            return (Criteria) this;
        }

        public Criteria andTargetWebsiteNotIn(List<String> values) {
            addCriterion("target_website not in", values, "targetWebsite");
            return (Criteria) this;
        }

        public Criteria andTargetWebsiteBetween(String value1, String value2) {
            addCriterion("target_website between", value1, value2, "targetWebsite");
            return (Criteria) this;
        }

        public Criteria andTargetWebsiteNotBetween(String value1, String value2) {
            addCriterion("target_website not between", value1, value2, "targetWebsite");
            return (Criteria) this;
        }

        public Criteria andContentTopicIsNull() {
            addCriterion("content_topic is null");
            return (Criteria) this;
        }

        public Criteria andContentTopicIsNotNull() {
            addCriterion("content_topic is not null");
            return (Criteria) this;
        }

        public Criteria andContentTopicEqualTo(String value) {
            addCriterion("content_topic =", value, "contentTopic");
            return (Criteria) this;
        }

        public Criteria andContentTopicNotEqualTo(String value) {
            addCriterion("content_topic <>", value, "contentTopic");
            return (Criteria) this;
        }

        public Criteria andContentTopicGreaterThan(String value) {
            addCriterion("content_topic >", value, "contentTopic");
            return (Criteria) this;
        }

        public Criteria andContentTopicGreaterThanOrEqualTo(String value) {
            addCriterion("content_topic >=", value, "contentTopic");
            return (Criteria) this;
        }

        public Criteria andContentTopicLessThan(String value) {
            addCriterion("content_topic <", value, "contentTopic");
            return (Criteria) this;
        }

        public Criteria andContentTopicLessThanOrEqualTo(String value) {
            addCriterion("content_topic <=", value, "contentTopic");
            return (Criteria) this;
        }

        public Criteria andContentTopicLike(String value) {
            addCriterion("content_topic like", value, "contentTopic");
            return (Criteria) this;
        }

        public Criteria andContentTopicNotLike(String value) {
            addCriterion("content_topic not like", value, "contentTopic");
            return (Criteria) this;
        }

        public Criteria andContentTopicIn(List<String> values) {
            addCriterion("content_topic in", values, "contentTopic");
            return (Criteria) this;
        }

        public Criteria andContentTopicNotIn(List<String> values) {
            addCriterion("content_topic not in", values, "contentTopic");
            return (Criteria) this;
        }

        public Criteria andContentTopicBetween(String value1, String value2) {
            addCriterion("content_topic between", value1, value2, "contentTopic");
            return (Criteria) this;
        }

        public Criteria andContentTopicNotBetween(String value1, String value2) {
            addCriterion("content_topic not between", value1, value2, "contentTopic");
            return (Criteria) this;
        }

        public Criteria andHousePartnerIsNull() {
            addCriterion("house_partner is null");
            return (Criteria) this;
        }

        public Criteria andHousePartnerIsNotNull() {
            addCriterion("house_partner is not null");
            return (Criteria) this;
        }

        public Criteria andHousePartnerEqualTo(Integer value) {
            addCriterion("house_partner =", value, "housePartner");
            return (Criteria) this;
        }

        public Criteria andHousePartnerNotEqualTo(Integer value) {
            addCriterion("house_partner <>", value, "housePartner");
            return (Criteria) this;
        }

        public Criteria andHousePartnerGreaterThan(Integer value) {
            addCriterion("house_partner >", value, "housePartner");
            return (Criteria) this;
        }

        public Criteria andHousePartnerGreaterThanOrEqualTo(Integer value) {
            addCriterion("house_partner >=", value, "housePartner");
            return (Criteria) this;
        }

        public Criteria andHousePartnerLessThan(Integer value) {
            addCriterion("house_partner <", value, "housePartner");
            return (Criteria) this;
        }

        public Criteria andHousePartnerLessThanOrEqualTo(Integer value) {
            addCriterion("house_partner <=", value, "housePartner");
            return (Criteria) this;
        }

        public Criteria andHousePartnerIn(List<Integer> values) {
            addCriterion("house_partner in", values, "housePartner");
            return (Criteria) this;
        }

        public Criteria andHousePartnerNotIn(List<Integer> values) {
            addCriterion("house_partner not in", values, "housePartner");
            return (Criteria) this;
        }

        public Criteria andHousePartnerBetween(Integer value1, Integer value2) {
            addCriterion("house_partner between", value1, value2, "housePartner");
            return (Criteria) this;
        }

        public Criteria andHousePartnerNotBetween(Integer value1, Integer value2) {
            addCriterion("house_partner not between", value1, value2, "housePartner");
            return (Criteria) this;
        }

        public Criteria andOwnedSelfcontentIsNull() {
            addCriterion("owned_selfcontent is null");
            return (Criteria) this;
        }

        public Criteria andOwnedSelfcontentIsNotNull() {
            addCriterion("owned_selfcontent is not null");
            return (Criteria) this;
        }

        public Criteria andOwnedSelfcontentEqualTo(Integer value) {
            addCriterion("owned_selfcontent =", value, "ownedSelfcontent");
            return (Criteria) this;
        }

        public Criteria andOwnedSelfcontentNotEqualTo(Integer value) {
            addCriterion("owned_selfcontent <>", value, "ownedSelfcontent");
            return (Criteria) this;
        }

        public Criteria andOwnedSelfcontentGreaterThan(Integer value) {
            addCriterion("owned_selfcontent >", value, "ownedSelfcontent");
            return (Criteria) this;
        }

        public Criteria andOwnedSelfcontentGreaterThanOrEqualTo(Integer value) {
            addCriterion("owned_selfcontent >=", value, "ownedSelfcontent");
            return (Criteria) this;
        }

        public Criteria andOwnedSelfcontentLessThan(Integer value) {
            addCriterion("owned_selfcontent <", value, "ownedSelfcontent");
            return (Criteria) this;
        }

        public Criteria andOwnedSelfcontentLessThanOrEqualTo(Integer value) {
            addCriterion("owned_selfcontent <=", value, "ownedSelfcontent");
            return (Criteria) this;
        }

        public Criteria andOwnedSelfcontentIn(List<Integer> values) {
            addCriterion("owned_selfcontent in", values, "ownedSelfcontent");
            return (Criteria) this;
        }

        public Criteria andOwnedSelfcontentNotIn(List<Integer> values) {
            addCriterion("owned_selfcontent not in", values, "ownedSelfcontent");
            return (Criteria) this;
        }

        public Criteria andOwnedSelfcontentBetween(Integer value1, Integer value2) {
            addCriterion("owned_selfcontent between", value1, value2, "ownedSelfcontent");
            return (Criteria) this;
        }

        public Criteria andOwnedSelfcontentNotBetween(Integer value1, Integer value2) {
            addCriterion("owned_selfcontent not between", value1, value2, "ownedSelfcontent");
            return (Criteria) this;
        }

        public Criteria andWhollyOwnedIsNull() {
            addCriterion("wholly_owned is null");
            return (Criteria) this;
        }

        public Criteria andWhollyOwnedIsNotNull() {
            addCriterion("wholly_owned is not null");
            return (Criteria) this;
        }

        public Criteria andWhollyOwnedEqualTo(Integer value) {
            addCriterion("wholly_owned =", value, "whollyOwned");
            return (Criteria) this;
        }

        public Criteria andWhollyOwnedNotEqualTo(Integer value) {
            addCriterion("wholly_owned <>", value, "whollyOwned");
            return (Criteria) this;
        }

        public Criteria andWhollyOwnedGreaterThan(Integer value) {
            addCriterion("wholly_owned >", value, "whollyOwned");
            return (Criteria) this;
        }

        public Criteria andWhollyOwnedGreaterThanOrEqualTo(Integer value) {
            addCriterion("wholly_owned >=", value, "whollyOwned");
            return (Criteria) this;
        }

        public Criteria andWhollyOwnedLessThan(Integer value) {
            addCriterion("wholly_owned <", value, "whollyOwned");
            return (Criteria) this;
        }

        public Criteria andWhollyOwnedLessThanOrEqualTo(Integer value) {
            addCriterion("wholly_owned <=", value, "whollyOwned");
            return (Criteria) this;
        }

        public Criteria andWhollyOwnedIn(List<Integer> values) {
            addCriterion("wholly_owned in", values, "whollyOwned");
            return (Criteria) this;
        }

        public Criteria andWhollyOwnedNotIn(List<Integer> values) {
            addCriterion("wholly_owned not in", values, "whollyOwned");
            return (Criteria) this;
        }

        public Criteria andWhollyOwnedBetween(Integer value1, Integer value2) {
            addCriterion("wholly_owned between", value1, value2, "whollyOwned");
            return (Criteria) this;
        }

        public Criteria andWhollyOwnedNotBetween(Integer value1, Integer value2) {
            addCriterion("wholly_owned not between", value1, value2, "whollyOwned");
            return (Criteria) this;
        }

        public Criteria andExclusiveAuthIsNull() {
            addCriterion("exclusive_auth is null");
            return (Criteria) this;
        }

        public Criteria andExclusiveAuthIsNotNull() {
            addCriterion("exclusive_auth is not null");
            return (Criteria) this;
        }

        public Criteria andExclusiveAuthEqualTo(String value) {
            addCriterion("exclusive_auth =", value, "exclusiveAuth");
            return (Criteria) this;
        }

        public Criteria andExclusiveAuthNotEqualTo(String value) {
            addCriterion("exclusive_auth <>", value, "exclusiveAuth");
            return (Criteria) this;
        }

        public Criteria andExclusiveAuthGreaterThan(String value) {
            addCriterion("exclusive_auth >", value, "exclusiveAuth");
            return (Criteria) this;
        }

        public Criteria andExclusiveAuthGreaterThanOrEqualTo(String value) {
            addCriterion("exclusive_auth >=", value, "exclusiveAuth");
            return (Criteria) this;
        }

        public Criteria andExclusiveAuthLessThan(String value) {
            addCriterion("exclusive_auth <", value, "exclusiveAuth");
            return (Criteria) this;
        }

        public Criteria andExclusiveAuthLessThanOrEqualTo(String value) {
            addCriterion("exclusive_auth <=", value, "exclusiveAuth");
            return (Criteria) this;
        }

        public Criteria andExclusiveAuthLike(String value) {
            addCriterion("exclusive_auth like", value, "exclusiveAuth");
            return (Criteria) this;
        }

        public Criteria andExclusiveAuthNotLike(String value) {
            addCriterion("exclusive_auth not like", value, "exclusiveAuth");
            return (Criteria) this;
        }

        public Criteria andExclusiveAuthIn(List<String> values) {
            addCriterion("exclusive_auth in", values, "exclusiveAuth");
            return (Criteria) this;
        }

        public Criteria andExclusiveAuthNotIn(List<String> values) {
            addCriterion("exclusive_auth not in", values, "exclusiveAuth");
            return (Criteria) this;
        }

        public Criteria andExclusiveAuthBetween(String value1, String value2) {
            addCriterion("exclusive_auth between", value1, value2, "exclusiveAuth");
            return (Criteria) this;
        }

        public Criteria andExclusiveAuthNotBetween(String value1, String value2) {
            addCriterion("exclusive_auth not between", value1, value2, "exclusiveAuth");
            return (Criteria) this;
        }

        public Criteria andFtpSubpathIsNull() {
            addCriterion("ftp_subpath is null");
            return (Criteria) this;
        }

        public Criteria andFtpSubpathIsNotNull() {
            addCriterion("ftp_subpath is not null");
            return (Criteria) this;
        }

        public Criteria andFtpSubpathEqualTo(String value) {
            addCriterion("ftp_subpath =", value, "ftpSubpath");
            return (Criteria) this;
        }

        public Criteria andFtpSubpathNotEqualTo(String value) {
            addCriterion("ftp_subpath <>", value, "ftpSubpath");
            return (Criteria) this;
        }

        public Criteria andFtpSubpathGreaterThan(String value) {
            addCriterion("ftp_subpath >", value, "ftpSubpath");
            return (Criteria) this;
        }

        public Criteria andFtpSubpathGreaterThanOrEqualTo(String value) {
            addCriterion("ftp_subpath >=", value, "ftpSubpath");
            return (Criteria) this;
        }

        public Criteria andFtpSubpathLessThan(String value) {
            addCriterion("ftp_subpath <", value, "ftpSubpath");
            return (Criteria) this;
        }

        public Criteria andFtpSubpathLessThanOrEqualTo(String value) {
            addCriterion("ftp_subpath <=", value, "ftpSubpath");
            return (Criteria) this;
        }

        public Criteria andFtpSubpathLike(String value) {
            addCriterion("ftp_subpath like", value, "ftpSubpath");
            return (Criteria) this;
        }

        public Criteria andFtpSubpathNotLike(String value) {
            addCriterion("ftp_subpath not like", value, "ftpSubpath");
            return (Criteria) this;
        }

        public Criteria andFtpSubpathIn(List<String> values) {
            addCriterion("ftp_subpath in", values, "ftpSubpath");
            return (Criteria) this;
        }

        public Criteria andFtpSubpathNotIn(List<String> values) {
            addCriterion("ftp_subpath not in", values, "ftpSubpath");
            return (Criteria) this;
        }

        public Criteria andFtpSubpathBetween(String value1, String value2) {
            addCriterion("ftp_subpath between", value1, value2, "ftpSubpath");
            return (Criteria) this;
        }

        public Criteria andFtpSubpathNotBetween(String value1, String value2) {
            addCriterion("ftp_subpath not between", value1, value2, "ftpSubpath");
            return (Criteria) this;
        }

        public Criteria andIsCommercialIsNull() {
            addCriterion("is_commercial is null");
            return (Criteria) this;
        }

        public Criteria andIsCommercialIsNotNull() {
            addCriterion("is_commercial is not null");
            return (Criteria) this;
        }

        public Criteria andIsCommercialEqualTo(Integer value) {
            addCriterion("is_commercial =", value, "isCommercial");
            return (Criteria) this;
        }

        public Criteria andIsCommercialNotEqualTo(Integer value) {
            addCriterion("is_commercial <>", value, "isCommercial");
            return (Criteria) this;
        }

        public Criteria andIsCommercialGreaterThan(Integer value) {
            addCriterion("is_commercial >", value, "isCommercial");
            return (Criteria) this;
        }

        public Criteria andIsCommercialGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_commercial >=", value, "isCommercial");
            return (Criteria) this;
        }

        public Criteria andIsCommercialLessThan(Integer value) {
            addCriterion("is_commercial <", value, "isCommercial");
            return (Criteria) this;
        }

        public Criteria andIsCommercialLessThanOrEqualTo(Integer value) {
            addCriterion("is_commercial <=", value, "isCommercial");
            return (Criteria) this;
        }

        public Criteria andIsCommercialIn(List<Integer> values) {
            addCriterion("is_commercial in", values, "isCommercial");
            return (Criteria) this;
        }

        public Criteria andIsCommercialNotIn(List<Integer> values) {
            addCriterion("is_commercial not in", values, "isCommercial");
            return (Criteria) this;
        }

        public Criteria andIsCommercialBetween(Integer value1, Integer value2) {
            addCriterion("is_commercial between", value1, value2, "isCommercial");
            return (Criteria) this;
        }

        public Criteria andIsCommercialNotBetween(Integer value1, Integer value2) {
            addCriterion("is_commercial not between", value1, value2, "isCommercial");
            return (Criteria) this;
        }

        public Criteria andIsCommercialNoteIsNull() {
            addCriterion("is_commercial_note is null");
            return (Criteria) this;
        }

        public Criteria andIsCommercialNoteIsNotNull() {
            addCriterion("is_commercial_note is not null");
            return (Criteria) this;
        }

        public Criteria andIsCommercialNoteEqualTo(String value) {
            addCriterion("is_commercial_note =", value, "isCommercialNote");
            return (Criteria) this;
        }

        public Criteria andIsCommercialNoteNotEqualTo(String value) {
            addCriterion("is_commercial_note <>", value, "isCommercialNote");
            return (Criteria) this;
        }

        public Criteria andIsCommercialNoteGreaterThan(String value) {
            addCriterion("is_commercial_note >", value, "isCommercialNote");
            return (Criteria) this;
        }

        public Criteria andIsCommercialNoteGreaterThanOrEqualTo(String value) {
            addCriterion("is_commercial_note >=", value, "isCommercialNote");
            return (Criteria) this;
        }

        public Criteria andIsCommercialNoteLessThan(String value) {
            addCriterion("is_commercial_note <", value, "isCommercialNote");
            return (Criteria) this;
        }

        public Criteria andIsCommercialNoteLessThanOrEqualTo(String value) {
            addCriterion("is_commercial_note <=", value, "isCommercialNote");
            return (Criteria) this;
        }

        public Criteria andIsCommercialNoteLike(String value) {
            addCriterion("is_commercial_note like", value, "isCommercialNote");
            return (Criteria) this;
        }

        public Criteria andIsCommercialNoteNotLike(String value) {
            addCriterion("is_commercial_note not like", value, "isCommercialNote");
            return (Criteria) this;
        }

        public Criteria andIsCommercialNoteIn(List<String> values) {
            addCriterion("is_commercial_note in", values, "isCommercialNote");
            return (Criteria) this;
        }

        public Criteria andIsCommercialNoteNotIn(List<String> values) {
            addCriterion("is_commercial_note not in", values, "isCommercialNote");
            return (Criteria) this;
        }

        public Criteria andIsCommercialNoteBetween(String value1, String value2) {
            addCriterion("is_commercial_note between", value1, value2, "isCommercialNote");
            return (Criteria) this;
        }

        public Criteria andIsCommercialNoteNotBetween(String value1, String value2) {
            addCriterion("is_commercial_note not between", value1, value2, "isCommercialNote");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellIsNull() {
            addCriterion("is_exclusivesell is null");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellIsNotNull() {
            addCriterion("is_exclusivesell is not null");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellEqualTo(String value) {
            addCriterion("is_exclusivesell =", value, "isExclusivesell");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellNotEqualTo(String value) {
            addCriterion("is_exclusivesell <>", value, "isExclusivesell");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellGreaterThan(String value) {
            addCriterion("is_exclusivesell >", value, "isExclusivesell");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellGreaterThanOrEqualTo(String value) {
            addCriterion("is_exclusivesell >=", value, "isExclusivesell");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellLessThan(String value) {
            addCriterion("is_exclusivesell <", value, "isExclusivesell");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellLessThanOrEqualTo(String value) {
            addCriterion("is_exclusivesell <=", value, "isExclusivesell");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellLike(String value) {
            addCriterion("is_exclusivesell like", value, "isExclusivesell");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellNotLike(String value) {
            addCriterion("is_exclusivesell not like", value, "isExclusivesell");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellIn(List<String> values) {
            addCriterion("is_exclusivesell in", values, "isExclusivesell");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellNotIn(List<String> values) {
            addCriterion("is_exclusivesell not in", values, "isExclusivesell");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellBetween(String value1, String value2) {
            addCriterion("is_exclusivesell between", value1, value2, "isExclusivesell");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellNotBetween(String value1, String value2) {
            addCriterion("is_exclusivesell not between", value1, value2, "isExclusivesell");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellNoteIsNull() {
            addCriterion("is_exclusivesell_note is null");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellNoteIsNotNull() {
            addCriterion("is_exclusivesell_note is not null");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellNoteEqualTo(String value) {
            addCriterion("is_exclusivesell_note =", value, "isExclusivesellNote");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellNoteNotEqualTo(String value) {
            addCriterion("is_exclusivesell_note <>", value, "isExclusivesellNote");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellNoteGreaterThan(String value) {
            addCriterion("is_exclusivesell_note >", value, "isExclusivesellNote");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellNoteGreaterThanOrEqualTo(String value) {
            addCriterion("is_exclusivesell_note >=", value, "isExclusivesellNote");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellNoteLessThan(String value) {
            addCriterion("is_exclusivesell_note <", value, "isExclusivesellNote");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellNoteLessThanOrEqualTo(String value) {
            addCriterion("is_exclusivesell_note <=", value, "isExclusivesellNote");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellNoteLike(String value) {
            addCriterion("is_exclusivesell_note like", value, "isExclusivesellNote");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellNoteNotLike(String value) {
            addCriterion("is_exclusivesell_note not like", value, "isExclusivesellNote");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellNoteIn(List<String> values) {
            addCriterion("is_exclusivesell_note in", values, "isExclusivesellNote");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellNoteNotIn(List<String> values) {
            addCriterion("is_exclusivesell_note not in", values, "isExclusivesellNote");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellNoteBetween(String value1, String value2) {
            addCriterion("is_exclusivesell_note between", value1, value2, "isExclusivesellNote");
            return (Criteria) this;
        }

        public Criteria andIsExclusivesellNoteNotBetween(String value1, String value2) {
            addCriterion("is_exclusivesell_note not between", value1, value2, "isExclusivesellNote");
            return (Criteria) this;
        }

        public Criteria andEzaEnabledIsNull() {
            addCriterion("eza_enabled is null");
            return (Criteria) this;
        }

        public Criteria andEzaEnabledIsNotNull() {
            addCriterion("eza_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andEzaEnabledEqualTo(Integer value) {
            addCriterion("eza_enabled =", value, "ezaEnabled");
            return (Criteria) this;
        }

        public Criteria andEzaEnabledNotEqualTo(Integer value) {
            addCriterion("eza_enabled <>", value, "ezaEnabled");
            return (Criteria) this;
        }

        public Criteria andEzaEnabledGreaterThan(Integer value) {
            addCriterion("eza_enabled >", value, "ezaEnabled");
            return (Criteria) this;
        }

        public Criteria andEzaEnabledGreaterThanOrEqualTo(Integer value) {
            addCriterion("eza_enabled >=", value, "ezaEnabled");
            return (Criteria) this;
        }

        public Criteria andEzaEnabledLessThan(Integer value) {
            addCriterion("eza_enabled <", value, "ezaEnabled");
            return (Criteria) this;
        }

        public Criteria andEzaEnabledLessThanOrEqualTo(Integer value) {
            addCriterion("eza_enabled <=", value, "ezaEnabled");
            return (Criteria) this;
        }

        public Criteria andEzaEnabledIn(List<Integer> values) {
            addCriterion("eza_enabled in", values, "ezaEnabled");
            return (Criteria) this;
        }

        public Criteria andEzaEnabledNotIn(List<Integer> values) {
            addCriterion("eza_enabled not in", values, "ezaEnabled");
            return (Criteria) this;
        }

        public Criteria andEzaEnabledBetween(Integer value1, Integer value2) {
            addCriterion("eza_enabled between", value1, value2, "ezaEnabled");
            return (Criteria) this;
        }

        public Criteria andEzaEnabledNotBetween(Integer value1, Integer value2) {
            addCriterion("eza_enabled not between", value1, value2, "ezaEnabled");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionIsNull() {
            addCriterion("is_subscription is null");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionIsNotNull() {
            addCriterion("is_subscription is not null");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionEqualTo(Integer value) {
            addCriterion("is_subscription =", value, "isSubscription");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionNotEqualTo(Integer value) {
            addCriterion("is_subscription <>", value, "isSubscription");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionGreaterThan(Integer value) {
            addCriterion("is_subscription >", value, "isSubscription");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_subscription >=", value, "isSubscription");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionLessThan(Integer value) {
            addCriterion("is_subscription <", value, "isSubscription");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionLessThanOrEqualTo(Integer value) {
            addCriterion("is_subscription <=", value, "isSubscription");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionIn(List<Integer> values) {
            addCriterion("is_subscription in", values, "isSubscription");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionNotIn(List<Integer> values) {
            addCriterion("is_subscription not in", values, "isSubscription");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionBetween(Integer value1, Integer value2) {
            addCriterion("is_subscription between", value1, value2, "isSubscription");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionNotBetween(Integer value1, Integer value2) {
            addCriterion("is_subscription not between", value1, value2, "isSubscription");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionNoteIsNull() {
            addCriterion("is_subscription_note is null");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionNoteIsNotNull() {
            addCriterion("is_subscription_note is not null");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionNoteEqualTo(String value) {
            addCriterion("is_subscription_note =", value, "isSubscriptionNote");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionNoteNotEqualTo(String value) {
            addCriterion("is_subscription_note <>", value, "isSubscriptionNote");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionNoteGreaterThan(String value) {
            addCriterion("is_subscription_note >", value, "isSubscriptionNote");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionNoteGreaterThanOrEqualTo(String value) {
            addCriterion("is_subscription_note >=", value, "isSubscriptionNote");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionNoteLessThan(String value) {
            addCriterion("is_subscription_note <", value, "isSubscriptionNote");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionNoteLessThanOrEqualTo(String value) {
            addCriterion("is_subscription_note <=", value, "isSubscriptionNote");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionNoteLike(String value) {
            addCriterion("is_subscription_note like", value, "isSubscriptionNote");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionNoteNotLike(String value) {
            addCriterion("is_subscription_note not like", value, "isSubscriptionNote");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionNoteIn(List<String> values) {
            addCriterion("is_subscription_note in", values, "isSubscriptionNote");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionNoteNotIn(List<String> values) {
            addCriterion("is_subscription_note not in", values, "isSubscriptionNote");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionNoteBetween(String value1, String value2) {
            addCriterion("is_subscription_note between", value1, value2, "isSubscriptionNote");
            return (Criteria) this;
        }

        public Criteria andIsSubscriptionNoteNotBetween(String value1, String value2) {
            addCriterion("is_subscription_note not between", value1, value2, "isSubscriptionNote");
            return (Criteria) this;
        }

        public Criteria andMinPriceIsNull() {
            addCriterion("min_price is null");
            return (Criteria) this;
        }

        public Criteria andMinPriceIsNotNull() {
            addCriterion("min_price is not null");
            return (Criteria) this;
        }

        public Criteria andMinPriceEqualTo(Integer value) {
            addCriterion("min_price =", value, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceNotEqualTo(Integer value) {
            addCriterion("min_price <>", value, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceGreaterThan(Integer value) {
            addCriterion("min_price >", value, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_price >=", value, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceLessThan(Integer value) {
            addCriterion("min_price <", value, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceLessThanOrEqualTo(Integer value) {
            addCriterion("min_price <=", value, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceIn(List<Integer> values) {
            addCriterion("min_price in", values, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceNotIn(List<Integer> values) {
            addCriterion("min_price not in", values, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceBetween(Integer value1, Integer value2) {
            addCriterion("min_price between", value1, value2, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("min_price not between", value1, value2, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceNoteIsNull() {
            addCriterion("min_price_note is null");
            return (Criteria) this;
        }

        public Criteria andMinPriceNoteIsNotNull() {
            addCriterion("min_price_note is not null");
            return (Criteria) this;
        }

        public Criteria andMinPriceNoteEqualTo(String value) {
            addCriterion("min_price_note =", value, "minPriceNote");
            return (Criteria) this;
        }

        public Criteria andMinPriceNoteNotEqualTo(String value) {
            addCriterion("min_price_note <>", value, "minPriceNote");
            return (Criteria) this;
        }

        public Criteria andMinPriceNoteGreaterThan(String value) {
            addCriterion("min_price_note >", value, "minPriceNote");
            return (Criteria) this;
        }

        public Criteria andMinPriceNoteGreaterThanOrEqualTo(String value) {
            addCriterion("min_price_note >=", value, "minPriceNote");
            return (Criteria) this;
        }

        public Criteria andMinPriceNoteLessThan(String value) {
            addCriterion("min_price_note <", value, "minPriceNote");
            return (Criteria) this;
        }

        public Criteria andMinPriceNoteLessThanOrEqualTo(String value) {
            addCriterion("min_price_note <=", value, "minPriceNote");
            return (Criteria) this;
        }

        public Criteria andMinPriceNoteLike(String value) {
            addCriterion("min_price_note like", value, "minPriceNote");
            return (Criteria) this;
        }

        public Criteria andMinPriceNoteNotLike(String value) {
            addCriterion("min_price_note not like", value, "minPriceNote");
            return (Criteria) this;
        }

        public Criteria andMinPriceNoteIn(List<String> values) {
            addCriterion("min_price_note in", values, "minPriceNote");
            return (Criteria) this;
        }

        public Criteria andMinPriceNoteNotIn(List<String> values) {
            addCriterion("min_price_note not in", values, "minPriceNote");
            return (Criteria) this;
        }

        public Criteria andMinPriceNoteBetween(String value1, String value2) {
            addCriterion("min_price_note between", value1, value2, "minPriceNote");
            return (Criteria) this;
        }

        public Criteria andMinPriceNoteNotBetween(String value1, String value2) {
            addCriterion("min_price_note not between", value1, value2, "minPriceNote");
            return (Criteria) this;
        }

        public Criteria andSalesRestrictionsIsNull() {
            addCriterion("sales_restrictions is null");
            return (Criteria) this;
        }

        public Criteria andSalesRestrictionsIsNotNull() {
            addCriterion("sales_restrictions is not null");
            return (Criteria) this;
        }

        public Criteria andSalesRestrictionsEqualTo(String value) {
            addCriterion("sales_restrictions =", value, "salesRestrictions");
            return (Criteria) this;
        }

        public Criteria andSalesRestrictionsNotEqualTo(String value) {
            addCriterion("sales_restrictions <>", value, "salesRestrictions");
            return (Criteria) this;
        }

        public Criteria andSalesRestrictionsGreaterThan(String value) {
            addCriterion("sales_restrictions >", value, "salesRestrictions");
            return (Criteria) this;
        }

        public Criteria andSalesRestrictionsGreaterThanOrEqualTo(String value) {
            addCriterion("sales_restrictions >=", value, "salesRestrictions");
            return (Criteria) this;
        }

        public Criteria andSalesRestrictionsLessThan(String value) {
            addCriterion("sales_restrictions <", value, "salesRestrictions");
            return (Criteria) this;
        }

        public Criteria andSalesRestrictionsLessThanOrEqualTo(String value) {
            addCriterion("sales_restrictions <=", value, "salesRestrictions");
            return (Criteria) this;
        }

        public Criteria andSalesRestrictionsLike(String value) {
            addCriterion("sales_restrictions like", value, "salesRestrictions");
            return (Criteria) this;
        }

        public Criteria andSalesRestrictionsNotLike(String value) {
            addCriterion("sales_restrictions not like", value, "salesRestrictions");
            return (Criteria) this;
        }

        public Criteria andSalesRestrictionsIn(List<String> values) {
            addCriterion("sales_restrictions in", values, "salesRestrictions");
            return (Criteria) this;
        }

        public Criteria andSalesRestrictionsNotIn(List<String> values) {
            addCriterion("sales_restrictions not in", values, "salesRestrictions");
            return (Criteria) this;
        }

        public Criteria andSalesRestrictionsBetween(String value1, String value2) {
            addCriterion("sales_restrictions between", value1, value2, "salesRestrictions");
            return (Criteria) this;
        }

        public Criteria andSalesRestrictionsNotBetween(String value1, String value2) {
            addCriterion("sales_restrictions not between", value1, value2, "salesRestrictions");
            return (Criteria) this;
        }

        public Criteria andOtherRestrictionsIsNull() {
            addCriterion("other_restrictions is null");
            return (Criteria) this;
        }

        public Criteria andOtherRestrictionsIsNotNull() {
            addCriterion("other_restrictions is not null");
            return (Criteria) this;
        }

        public Criteria andOtherRestrictionsEqualTo(String value) {
            addCriterion("other_restrictions =", value, "otherRestrictions");
            return (Criteria) this;
        }

        public Criteria andOtherRestrictionsNotEqualTo(String value) {
            addCriterion("other_restrictions <>", value, "otherRestrictions");
            return (Criteria) this;
        }

        public Criteria andOtherRestrictionsGreaterThan(String value) {
            addCriterion("other_restrictions >", value, "otherRestrictions");
            return (Criteria) this;
        }

        public Criteria andOtherRestrictionsGreaterThanOrEqualTo(String value) {
            addCriterion("other_restrictions >=", value, "otherRestrictions");
            return (Criteria) this;
        }

        public Criteria andOtherRestrictionsLessThan(String value) {
            addCriterion("other_restrictions <", value, "otherRestrictions");
            return (Criteria) this;
        }

        public Criteria andOtherRestrictionsLessThanOrEqualTo(String value) {
            addCriterion("other_restrictions <=", value, "otherRestrictions");
            return (Criteria) this;
        }

        public Criteria andOtherRestrictionsLike(String value) {
            addCriterion("other_restrictions like", value, "otherRestrictions");
            return (Criteria) this;
        }

        public Criteria andOtherRestrictionsNotLike(String value) {
            addCriterion("other_restrictions not like", value, "otherRestrictions");
            return (Criteria) this;
        }

        public Criteria andOtherRestrictionsIn(List<String> values) {
            addCriterion("other_restrictions in", values, "otherRestrictions");
            return (Criteria) this;
        }

        public Criteria andOtherRestrictionsNotIn(List<String> values) {
            addCriterion("other_restrictions not in", values, "otherRestrictions");
            return (Criteria) this;
        }

        public Criteria andOtherRestrictionsBetween(String value1, String value2) {
            addCriterion("other_restrictions between", value1, value2, "otherRestrictions");
            return (Criteria) this;
        }

        public Criteria andOtherRestrictionsNotBetween(String value1, String value2) {
            addCriterion("other_restrictions not between", value1, value2, "otherRestrictions");
            return (Criteria) this;
        }

        public Criteria andModelReleaseIsNull() {
            addCriterion("model_release is null");
            return (Criteria) this;
        }

        public Criteria andModelReleaseIsNotNull() {
            addCriterion("model_release is not null");
            return (Criteria) this;
        }

        public Criteria andModelReleaseEqualTo(String value) {
            addCriterion("model_release =", value, "modelRelease");
            return (Criteria) this;
        }

        public Criteria andModelReleaseNotEqualTo(String value) {
            addCriterion("model_release <>", value, "modelRelease");
            return (Criteria) this;
        }

        public Criteria andModelReleaseGreaterThan(String value) {
            addCriterion("model_release >", value, "modelRelease");
            return (Criteria) this;
        }

        public Criteria andModelReleaseGreaterThanOrEqualTo(String value) {
            addCriterion("model_release >=", value, "modelRelease");
            return (Criteria) this;
        }

        public Criteria andModelReleaseLessThan(String value) {
            addCriterion("model_release <", value, "modelRelease");
            return (Criteria) this;
        }

        public Criteria andModelReleaseLessThanOrEqualTo(String value) {
            addCriterion("model_release <=", value, "modelRelease");
            return (Criteria) this;
        }

        public Criteria andModelReleaseLike(String value) {
            addCriterion("model_release like", value, "modelRelease");
            return (Criteria) this;
        }

        public Criteria andModelReleaseNotLike(String value) {
            addCriterion("model_release not like", value, "modelRelease");
            return (Criteria) this;
        }

        public Criteria andModelReleaseIn(List<String> values) {
            addCriterion("model_release in", values, "modelRelease");
            return (Criteria) this;
        }

        public Criteria andModelReleaseNotIn(List<String> values) {
            addCriterion("model_release not in", values, "modelRelease");
            return (Criteria) this;
        }

        public Criteria andModelReleaseBetween(String value1, String value2) {
            addCriterion("model_release between", value1, value2, "modelRelease");
            return (Criteria) this;
        }

        public Criteria andModelReleaseNotBetween(String value1, String value2) {
            addCriterion("model_release not between", value1, value2, "modelRelease");
            return (Criteria) this;
        }

        public Criteria andCollectionIntroductionIsNull() {
            addCriterion("collection_introduction is null");
            return (Criteria) this;
        }

        public Criteria andCollectionIntroductionIsNotNull() {
            addCriterion("collection_introduction is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionIntroductionEqualTo(String value) {
            addCriterion("collection_introduction =", value, "collectionIntroduction");
            return (Criteria) this;
        }

        public Criteria andCollectionIntroductionNotEqualTo(String value) {
            addCriterion("collection_introduction <>", value, "collectionIntroduction");
            return (Criteria) this;
        }

        public Criteria andCollectionIntroductionGreaterThan(String value) {
            addCriterion("collection_introduction >", value, "collectionIntroduction");
            return (Criteria) this;
        }

        public Criteria andCollectionIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("collection_introduction >=", value, "collectionIntroduction");
            return (Criteria) this;
        }

        public Criteria andCollectionIntroductionLessThan(String value) {
            addCriterion("collection_introduction <", value, "collectionIntroduction");
            return (Criteria) this;
        }

        public Criteria andCollectionIntroductionLessThanOrEqualTo(String value) {
            addCriterion("collection_introduction <=", value, "collectionIntroduction");
            return (Criteria) this;
        }

        public Criteria andCollectionIntroductionLike(String value) {
            addCriterion("collection_introduction like", value, "collectionIntroduction");
            return (Criteria) this;
        }

        public Criteria andCollectionIntroductionNotLike(String value) {
            addCriterion("collection_introduction not like", value, "collectionIntroduction");
            return (Criteria) this;
        }

        public Criteria andCollectionIntroductionIn(List<String> values) {
            addCriterion("collection_introduction in", values, "collectionIntroduction");
            return (Criteria) this;
        }

        public Criteria andCollectionIntroductionNotIn(List<String> values) {
            addCriterion("collection_introduction not in", values, "collectionIntroduction");
            return (Criteria) this;
        }

        public Criteria andCollectionIntroductionBetween(String value1, String value2) {
            addCriterion("collection_introduction between", value1, value2, "collectionIntroduction");
            return (Criteria) this;
        }

        public Criteria andCollectionIntroductionNotBetween(String value1, String value2) {
            addCriterion("collection_introduction not between", value1, value2, "collectionIntroduction");
            return (Criteria) this;
        }

        public Criteria andSellPointIsNull() {
            addCriterion("sell_point is null");
            return (Criteria) this;
        }

        public Criteria andSellPointIsNotNull() {
            addCriterion("sell_point is not null");
            return (Criteria) this;
        }

        public Criteria andSellPointEqualTo(String value) {
            addCriterion("sell_point =", value, "sellPoint");
            return (Criteria) this;
        }

        public Criteria andSellPointNotEqualTo(String value) {
            addCriterion("sell_point <>", value, "sellPoint");
            return (Criteria) this;
        }

        public Criteria andSellPointGreaterThan(String value) {
            addCriterion("sell_point >", value, "sellPoint");
            return (Criteria) this;
        }

        public Criteria andSellPointGreaterThanOrEqualTo(String value) {
            addCriterion("sell_point >=", value, "sellPoint");
            return (Criteria) this;
        }

        public Criteria andSellPointLessThan(String value) {
            addCriterion("sell_point <", value, "sellPoint");
            return (Criteria) this;
        }

        public Criteria andSellPointLessThanOrEqualTo(String value) {
            addCriterion("sell_point <=", value, "sellPoint");
            return (Criteria) this;
        }

        public Criteria andSellPointLike(String value) {
            addCriterion("sell_point like", value, "sellPoint");
            return (Criteria) this;
        }

        public Criteria andSellPointNotLike(String value) {
            addCriterion("sell_point not like", value, "sellPoint");
            return (Criteria) this;
        }

        public Criteria andSellPointIn(List<String> values) {
            addCriterion("sell_point in", values, "sellPoint");
            return (Criteria) this;
        }

        public Criteria andSellPointNotIn(List<String> values) {
            addCriterion("sell_point not in", values, "sellPoint");
            return (Criteria) this;
        }

        public Criteria andSellPointBetween(String value1, String value2) {
            addCriterion("sell_point between", value1, value2, "sellPoint");
            return (Criteria) this;
        }

        public Criteria andSellPointNotBetween(String value1, String value2) {
            addCriterion("sell_point not between", value1, value2, "sellPoint");
            return (Criteria) this;
        }

        public Criteria andTargetMarketIsNull() {
            addCriterion("target_market is null");
            return (Criteria) this;
        }

        public Criteria andTargetMarketIsNotNull() {
            addCriterion("target_market is not null");
            return (Criteria) this;
        }

        public Criteria andTargetMarketEqualTo(String value) {
            addCriterion("target_market =", value, "targetMarket");
            return (Criteria) this;
        }

        public Criteria andTargetMarketNotEqualTo(String value) {
            addCriterion("target_market <>", value, "targetMarket");
            return (Criteria) this;
        }

        public Criteria andTargetMarketGreaterThan(String value) {
            addCriterion("target_market >", value, "targetMarket");
            return (Criteria) this;
        }

        public Criteria andTargetMarketGreaterThanOrEqualTo(String value) {
            addCriterion("target_market >=", value, "targetMarket");
            return (Criteria) this;
        }

        public Criteria andTargetMarketLessThan(String value) {
            addCriterion("target_market <", value, "targetMarket");
            return (Criteria) this;
        }

        public Criteria andTargetMarketLessThanOrEqualTo(String value) {
            addCriterion("target_market <=", value, "targetMarket");
            return (Criteria) this;
        }

        public Criteria andTargetMarketLike(String value) {
            addCriterion("target_market like", value, "targetMarket");
            return (Criteria) this;
        }

        public Criteria andTargetMarketNotLike(String value) {
            addCriterion("target_market not like", value, "targetMarket");
            return (Criteria) this;
        }

        public Criteria andTargetMarketIn(List<String> values) {
            addCriterion("target_market in", values, "targetMarket");
            return (Criteria) this;
        }

        public Criteria andTargetMarketNotIn(List<String> values) {
            addCriterion("target_market not in", values, "targetMarket");
            return (Criteria) this;
        }

        public Criteria andTargetMarketBetween(String value1, String value2) {
            addCriterion("target_market between", value1, value2, "targetMarket");
            return (Criteria) this;
        }

        public Criteria andTargetMarketNotBetween(String value1, String value2) {
            addCriterion("target_market not between", value1, value2, "targetMarket");
            return (Criteria) this;
        }

        public Criteria andCollectionHistoryIsNull() {
            addCriterion("collection_history is null");
            return (Criteria) this;
        }

        public Criteria andCollectionHistoryIsNotNull() {
            addCriterion("collection_history is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionHistoryEqualTo(String value) {
            addCriterion("collection_history =", value, "collectionHistory");
            return (Criteria) this;
        }

        public Criteria andCollectionHistoryNotEqualTo(String value) {
            addCriterion("collection_history <>", value, "collectionHistory");
            return (Criteria) this;
        }

        public Criteria andCollectionHistoryGreaterThan(String value) {
            addCriterion("collection_history >", value, "collectionHistory");
            return (Criteria) this;
        }

        public Criteria andCollectionHistoryGreaterThanOrEqualTo(String value) {
            addCriterion("collection_history >=", value, "collectionHistory");
            return (Criteria) this;
        }

        public Criteria andCollectionHistoryLessThan(String value) {
            addCriterion("collection_history <", value, "collectionHistory");
            return (Criteria) this;
        }

        public Criteria andCollectionHistoryLessThanOrEqualTo(String value) {
            addCriterion("collection_history <=", value, "collectionHistory");
            return (Criteria) this;
        }

        public Criteria andCollectionHistoryLike(String value) {
            addCriterion("collection_history like", value, "collectionHistory");
            return (Criteria) this;
        }

        public Criteria andCollectionHistoryNotLike(String value) {
            addCriterion("collection_history not like", value, "collectionHistory");
            return (Criteria) this;
        }

        public Criteria andCollectionHistoryIn(List<String> values) {
            addCriterion("collection_history in", values, "collectionHistory");
            return (Criteria) this;
        }

        public Criteria andCollectionHistoryNotIn(List<String> values) {
            addCriterion("collection_history not in", values, "collectionHistory");
            return (Criteria) this;
        }

        public Criteria andCollectionHistoryBetween(String value1, String value2) {
            addCriterion("collection_history between", value1, value2, "collectionHistory");
            return (Criteria) this;
        }

        public Criteria andCollectionHistoryNotBetween(String value1, String value2) {
            addCriterion("collection_history not between", value1, value2, "collectionHistory");
            return (Criteria) this;
        }

        public Criteria andPriceLimitlevelIsNull() {
            addCriterion("price_limitlevel is null");
            return (Criteria) this;
        }

        public Criteria andPriceLimitlevelIsNotNull() {
            addCriterion("price_limitlevel is not null");
            return (Criteria) this;
        }

        public Criteria andPriceLimitlevelEqualTo(String value) {
            addCriterion("price_limitlevel =", value, "priceLimitlevel");
            return (Criteria) this;
        }

        public Criteria andPriceLimitlevelNotEqualTo(String value) {
            addCriterion("price_limitlevel <>", value, "priceLimitlevel");
            return (Criteria) this;
        }

        public Criteria andPriceLimitlevelGreaterThan(String value) {
            addCriterion("price_limitlevel >", value, "priceLimitlevel");
            return (Criteria) this;
        }

        public Criteria andPriceLimitlevelGreaterThanOrEqualTo(String value) {
            addCriterion("price_limitlevel >=", value, "priceLimitlevel");
            return (Criteria) this;
        }

        public Criteria andPriceLimitlevelLessThan(String value) {
            addCriterion("price_limitlevel <", value, "priceLimitlevel");
            return (Criteria) this;
        }

        public Criteria andPriceLimitlevelLessThanOrEqualTo(String value) {
            addCriterion("price_limitlevel <=", value, "priceLimitlevel");
            return (Criteria) this;
        }

        public Criteria andPriceLimitlevelLike(String value) {
            addCriterion("price_limitlevel like", value, "priceLimitlevel");
            return (Criteria) this;
        }

        public Criteria andPriceLimitlevelNotLike(String value) {
            addCriterion("price_limitlevel not like", value, "priceLimitlevel");
            return (Criteria) this;
        }

        public Criteria andPriceLimitlevelIn(List<String> values) {
            addCriterion("price_limitlevel in", values, "priceLimitlevel");
            return (Criteria) this;
        }

        public Criteria andPriceLimitlevelNotIn(List<String> values) {
            addCriterion("price_limitlevel not in", values, "priceLimitlevel");
            return (Criteria) this;
        }

        public Criteria andPriceLimitlevelBetween(String value1, String value2) {
            addCriterion("price_limitlevel between", value1, value2, "priceLimitlevel");
            return (Criteria) this;
        }

        public Criteria andPriceLimitlevelNotBetween(String value1, String value2) {
            addCriterion("price_limitlevel not between", value1, value2, "priceLimitlevel");
            return (Criteria) this;
        }

        public Criteria andPriceLimitdetailIsNull() {
            addCriterion("price_limitdetail is null");
            return (Criteria) this;
        }

        public Criteria andPriceLimitdetailIsNotNull() {
            addCriterion("price_limitdetail is not null");
            return (Criteria) this;
        }

        public Criteria andPriceLimitdetailEqualTo(String value) {
            addCriterion("price_limitdetail =", value, "priceLimitdetail");
            return (Criteria) this;
        }

        public Criteria andPriceLimitdetailNotEqualTo(String value) {
            addCriterion("price_limitdetail <>", value, "priceLimitdetail");
            return (Criteria) this;
        }

        public Criteria andPriceLimitdetailGreaterThan(String value) {
            addCriterion("price_limitdetail >", value, "priceLimitdetail");
            return (Criteria) this;
        }

        public Criteria andPriceLimitdetailGreaterThanOrEqualTo(String value) {
            addCriterion("price_limitdetail >=", value, "priceLimitdetail");
            return (Criteria) this;
        }

        public Criteria andPriceLimitdetailLessThan(String value) {
            addCriterion("price_limitdetail <", value, "priceLimitdetail");
            return (Criteria) this;
        }

        public Criteria andPriceLimitdetailLessThanOrEqualTo(String value) {
            addCriterion("price_limitdetail <=", value, "priceLimitdetail");
            return (Criteria) this;
        }

        public Criteria andPriceLimitdetailLike(String value) {
            addCriterion("price_limitdetail like", value, "priceLimitdetail");
            return (Criteria) this;
        }

        public Criteria andPriceLimitdetailNotLike(String value) {
            addCriterion("price_limitdetail not like", value, "priceLimitdetail");
            return (Criteria) this;
        }

        public Criteria andPriceLimitdetailIn(List<String> values) {
            addCriterion("price_limitdetail in", values, "priceLimitdetail");
            return (Criteria) this;
        }

        public Criteria andPriceLimitdetailNotIn(List<String> values) {
            addCriterion("price_limitdetail not in", values, "priceLimitdetail");
            return (Criteria) this;
        }

        public Criteria andPriceLimitdetailBetween(String value1, String value2) {
            addCriterion("price_limitdetail between", value1, value2, "priceLimitdetail");
            return (Criteria) this;
        }

        public Criteria andPriceLimitdetailNotBetween(String value1, String value2) {
            addCriterion("price_limitdetail not between", value1, value2, "priceLimitdetail");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerIsNull() {
            addCriterion("business_owner is null");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerIsNotNull() {
            addCriterion("business_owner is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerEqualTo(String value) {
            addCriterion("business_owner =", value, "businessOwner");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerNotEqualTo(String value) {
            addCriterion("business_owner <>", value, "businessOwner");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerGreaterThan(String value) {
            addCriterion("business_owner >", value, "businessOwner");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("business_owner >=", value, "businessOwner");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerLessThan(String value) {
            addCriterion("business_owner <", value, "businessOwner");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerLessThanOrEqualTo(String value) {
            addCriterion("business_owner <=", value, "businessOwner");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerLike(String value) {
            addCriterion("business_owner like", value, "businessOwner");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerNotLike(String value) {
            addCriterion("business_owner not like", value, "businessOwner");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerIn(List<String> values) {
            addCriterion("business_owner in", values, "businessOwner");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerNotIn(List<String> values) {
            addCriterion("business_owner not in", values, "businessOwner");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerBetween(String value1, String value2) {
            addCriterion("business_owner between", value1, value2, "businessOwner");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerNotBetween(String value1, String value2) {
            addCriterion("business_owner not between", value1, value2, "businessOwner");
            return (Criteria) this;
        }

        public Criteria andNotesIsNull() {
            addCriterion("notes is null");
            return (Criteria) this;
        }

        public Criteria andNotesIsNotNull() {
            addCriterion("notes is not null");
            return (Criteria) this;
        }

        public Criteria andNotesEqualTo(String value) {
            addCriterion("notes =", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotEqualTo(String value) {
            addCriterion("notes <>", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThan(String value) {
            addCriterion("notes >", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThanOrEqualTo(String value) {
            addCriterion("notes >=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThan(String value) {
            addCriterion("notes <", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThanOrEqualTo(String value) {
            addCriterion("notes <=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLike(String value) {
            addCriterion("notes like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotLike(String value) {
            addCriterion("notes not like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesIn(List<String> values) {
            addCriterion("notes in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotIn(List<String> values) {
            addCriterion("notes not in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesBetween(String value1, String value2) {
            addCriterion("notes between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotBetween(String value1, String value2) {
            addCriterion("notes not between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andModifiedByIsNull() {
            addCriterion("modified_by is null");
            return (Criteria) this;
        }

        public Criteria andModifiedByIsNotNull() {
            addCriterion("modified_by is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedByEqualTo(Integer value) {
            addCriterion("modified_by =", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByNotEqualTo(Integer value) {
            addCriterion("modified_by <>", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByGreaterThan(Integer value) {
            addCriterion("modified_by >", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByGreaterThanOrEqualTo(Integer value) {
            addCriterion("modified_by >=", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByLessThan(Integer value) {
            addCriterion("modified_by <", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByLessThanOrEqualTo(Integer value) {
            addCriterion("modified_by <=", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByIn(List<Integer> values) {
            addCriterion("modified_by in", values, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByNotIn(List<Integer> values) {
            addCriterion("modified_by not in", values, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByBetween(Integer value1, Integer value2) {
            addCriterion("modified_by between", value1, value2, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByNotBetween(Integer value1, Integer value2) {
            addCriterion("modified_by not between", value1, value2, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategyIsNull() {
            addCriterion("exclusive_strategy is null");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategyIsNotNull() {
            addCriterion("exclusive_strategy is not null");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategyEqualTo(String value) {
            addCriterion("exclusive_strategy =", value, "exclusiveStrategy");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategyNotEqualTo(String value) {
            addCriterion("exclusive_strategy <>", value, "exclusiveStrategy");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategyGreaterThan(String value) {
            addCriterion("exclusive_strategy >", value, "exclusiveStrategy");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategyGreaterThanOrEqualTo(String value) {
            addCriterion("exclusive_strategy >=", value, "exclusiveStrategy");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategyLessThan(String value) {
            addCriterion("exclusive_strategy <", value, "exclusiveStrategy");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategyLessThanOrEqualTo(String value) {
            addCriterion("exclusive_strategy <=", value, "exclusiveStrategy");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategyLike(String value) {
            addCriterion("exclusive_strategy like", value, "exclusiveStrategy");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategyNotLike(String value) {
            addCriterion("exclusive_strategy not like", value, "exclusiveStrategy");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategyIn(List<String> values) {
            addCriterion("exclusive_strategy in", values, "exclusiveStrategy");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategyNotIn(List<String> values) {
            addCriterion("exclusive_strategy not in", values, "exclusiveStrategy");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategyBetween(String value1, String value2) {
            addCriterion("exclusive_strategy between", value1, value2, "exclusiveStrategy");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategyNotBetween(String value1, String value2) {
            addCriterion("exclusive_strategy not between", value1, value2, "exclusiveStrategy");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategydetailIsNull() {
            addCriterion("exclusive_strategydetail is null");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategydetailIsNotNull() {
            addCriterion("exclusive_strategydetail is not null");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategydetailEqualTo(String value) {
            addCriterion("exclusive_strategydetail =", value, "exclusiveStrategydetail");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategydetailNotEqualTo(String value) {
            addCriterion("exclusive_strategydetail <>", value, "exclusiveStrategydetail");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategydetailGreaterThan(String value) {
            addCriterion("exclusive_strategydetail >", value, "exclusiveStrategydetail");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategydetailGreaterThanOrEqualTo(String value) {
            addCriterion("exclusive_strategydetail >=", value, "exclusiveStrategydetail");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategydetailLessThan(String value) {
            addCriterion("exclusive_strategydetail <", value, "exclusiveStrategydetail");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategydetailLessThanOrEqualTo(String value) {
            addCriterion("exclusive_strategydetail <=", value, "exclusiveStrategydetail");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategydetailLike(String value) {
            addCriterion("exclusive_strategydetail like", value, "exclusiveStrategydetail");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategydetailNotLike(String value) {
            addCriterion("exclusive_strategydetail not like", value, "exclusiveStrategydetail");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategydetailIn(List<String> values) {
            addCriterion("exclusive_strategydetail in", values, "exclusiveStrategydetail");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategydetailNotIn(List<String> values) {
            addCriterion("exclusive_strategydetail not in", values, "exclusiveStrategydetail");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategydetailBetween(String value1, String value2) {
            addCriterion("exclusive_strategydetail between", value1, value2, "exclusiveStrategydetail");
            return (Criteria) this;
        }

        public Criteria andExclusiveStrategydetailNotBetween(String value1, String value2) {
            addCriterion("exclusive_strategydetail not between", value1, value2, "exclusiveStrategydetail");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsIsNull() {
            addCriterion("exclusive_clients is null");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsIsNotNull() {
            addCriterion("exclusive_clients is not null");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsEqualTo(String value) {
            addCriterion("exclusive_clients =", value, "exclusiveClients");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsNotEqualTo(String value) {
            addCriterion("exclusive_clients <>", value, "exclusiveClients");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsGreaterThan(String value) {
            addCriterion("exclusive_clients >", value, "exclusiveClients");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsGreaterThanOrEqualTo(String value) {
            addCriterion("exclusive_clients >=", value, "exclusiveClients");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsLessThan(String value) {
            addCriterion("exclusive_clients <", value, "exclusiveClients");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsLessThanOrEqualTo(String value) {
            addCriterion("exclusive_clients <=", value, "exclusiveClients");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsLike(String value) {
            addCriterion("exclusive_clients like", value, "exclusiveClients");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsNotLike(String value) {
            addCriterion("exclusive_clients not like", value, "exclusiveClients");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsIn(List<String> values) {
            addCriterion("exclusive_clients in", values, "exclusiveClients");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsNotIn(List<String> values) {
            addCriterion("exclusive_clients not in", values, "exclusiveClients");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsBetween(String value1, String value2) {
            addCriterion("exclusive_clients between", value1, value2, "exclusiveClients");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsNotBetween(String value1, String value2) {
            addCriterion("exclusive_clients not between", value1, value2, "exclusiveClients");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsdetailIsNull() {
            addCriterion("exclusive_clientsdetail is null");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsdetailIsNotNull() {
            addCriterion("exclusive_clientsdetail is not null");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsdetailEqualTo(String value) {
            addCriterion("exclusive_clientsdetail =", value, "exclusiveClientsdetail");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsdetailNotEqualTo(String value) {
            addCriterion("exclusive_clientsdetail <>", value, "exclusiveClientsdetail");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsdetailGreaterThan(String value) {
            addCriterion("exclusive_clientsdetail >", value, "exclusiveClientsdetail");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsdetailGreaterThanOrEqualTo(String value) {
            addCriterion("exclusive_clientsdetail >=", value, "exclusiveClientsdetail");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsdetailLessThan(String value) {
            addCriterion("exclusive_clientsdetail <", value, "exclusiveClientsdetail");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsdetailLessThanOrEqualTo(String value) {
            addCriterion("exclusive_clientsdetail <=", value, "exclusiveClientsdetail");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsdetailLike(String value) {
            addCriterion("exclusive_clientsdetail like", value, "exclusiveClientsdetail");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsdetailNotLike(String value) {
            addCriterion("exclusive_clientsdetail not like", value, "exclusiveClientsdetail");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsdetailIn(List<String> values) {
            addCriterion("exclusive_clientsdetail in", values, "exclusiveClientsdetail");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsdetailNotIn(List<String> values) {
            addCriterion("exclusive_clientsdetail not in", values, "exclusiveClientsdetail");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsdetailBetween(String value1, String value2) {
            addCriterion("exclusive_clientsdetail between", value1, value2, "exclusiveClientsdetail");
            return (Criteria) this;
        }

        public Criteria andExclusiveClientsdetailNotBetween(String value1, String value2) {
            addCriterion("exclusive_clientsdetail not between", value1, value2, "exclusiveClientsdetail");
            return (Criteria) this;
        }

        public Criteria andWaterIdIsNull() {
            addCriterion("water_id is null");
            return (Criteria) this;
        }

        public Criteria andWaterIdIsNotNull() {
            addCriterion("water_id is not null");
            return (Criteria) this;
        }

        public Criteria andWaterIdEqualTo(Integer value) {
            addCriterion("water_id =", value, "waterId");
            return (Criteria) this;
        }

        public Criteria andWaterIdNotEqualTo(Integer value) {
            addCriterion("water_id <>", value, "waterId");
            return (Criteria) this;
        }

        public Criteria andWaterIdGreaterThan(Integer value) {
            addCriterion("water_id >", value, "waterId");
            return (Criteria) this;
        }

        public Criteria andWaterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("water_id >=", value, "waterId");
            return (Criteria) this;
        }

        public Criteria andWaterIdLessThan(Integer value) {
            addCriterion("water_id <", value, "waterId");
            return (Criteria) this;
        }

        public Criteria andWaterIdLessThanOrEqualTo(Integer value) {
            addCriterion("water_id <=", value, "waterId");
            return (Criteria) this;
        }

        public Criteria andWaterIdIn(List<Integer> values) {
            addCriterion("water_id in", values, "waterId");
            return (Criteria) this;
        }

        public Criteria andWaterIdNotIn(List<Integer> values) {
            addCriterion("water_id not in", values, "waterId");
            return (Criteria) this;
        }

        public Criteria andWaterIdBetween(Integer value1, Integer value2) {
            addCriterion("water_id between", value1, value2, "waterId");
            return (Criteria) this;
        }

        public Criteria andWaterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("water_id not between", value1, value2, "waterId");
            return (Criteria) this;
        }

        public Criteria andBlockReasonIsNull() {
            addCriterion("block_reason is null");
            return (Criteria) this;
        }

        public Criteria andBlockReasonIsNotNull() {
            addCriterion("block_reason is not null");
            return (Criteria) this;
        }

        public Criteria andBlockReasonEqualTo(String value) {
            addCriterion("block_reason =", value, "blockReason");
            return (Criteria) this;
        }

        public Criteria andBlockReasonNotEqualTo(String value) {
            addCriterion("block_reason <>", value, "blockReason");
            return (Criteria) this;
        }

        public Criteria andBlockReasonGreaterThan(String value) {
            addCriterion("block_reason >", value, "blockReason");
            return (Criteria) this;
        }

        public Criteria andBlockReasonGreaterThanOrEqualTo(String value) {
            addCriterion("block_reason >=", value, "blockReason");
            return (Criteria) this;
        }

        public Criteria andBlockReasonLessThan(String value) {
            addCriterion("block_reason <", value, "blockReason");
            return (Criteria) this;
        }

        public Criteria andBlockReasonLessThanOrEqualTo(String value) {
            addCriterion("block_reason <=", value, "blockReason");
            return (Criteria) this;
        }

        public Criteria andBlockReasonLike(String value) {
            addCriterion("block_reason like", value, "blockReason");
            return (Criteria) this;
        }

        public Criteria andBlockReasonNotLike(String value) {
            addCriterion("block_reason not like", value, "blockReason");
            return (Criteria) this;
        }

        public Criteria andBlockReasonIn(List<String> values) {
            addCriterion("block_reason in", values, "blockReason");
            return (Criteria) this;
        }

        public Criteria andBlockReasonNotIn(List<String> values) {
            addCriterion("block_reason not in", values, "blockReason");
            return (Criteria) this;
        }

        public Criteria andBlockReasonBetween(String value1, String value2) {
            addCriterion("block_reason between", value1, value2, "blockReason");
            return (Criteria) this;
        }

        public Criteria andBlockReasonNotBetween(String value1, String value2) {
            addCriterion("block_reason not between", value1, value2, "blockReason");
            return (Criteria) this;
        }

        public Criteria andHasNegativeIsNull() {
            addCriterion("has_negative is null");
            return (Criteria) this;
        }

        public Criteria andHasNegativeIsNotNull() {
            addCriterion("has_negative is not null");
            return (Criteria) this;
        }

        public Criteria andHasNegativeEqualTo(String value) {
            addCriterion("has_negative =", value, "hasNegative");
            return (Criteria) this;
        }

        public Criteria andHasNegativeNotEqualTo(String value) {
            addCriterion("has_negative <>", value, "hasNegative");
            return (Criteria) this;
        }

        public Criteria andHasNegativeGreaterThan(String value) {
            addCriterion("has_negative >", value, "hasNegative");
            return (Criteria) this;
        }

        public Criteria andHasNegativeGreaterThanOrEqualTo(String value) {
            addCriterion("has_negative >=", value, "hasNegative");
            return (Criteria) this;
        }

        public Criteria andHasNegativeLessThan(String value) {
            addCriterion("has_negative <", value, "hasNegative");
            return (Criteria) this;
        }

        public Criteria andHasNegativeLessThanOrEqualTo(String value) {
            addCriterion("has_negative <=", value, "hasNegative");
            return (Criteria) this;
        }

        public Criteria andHasNegativeLike(String value) {
            addCriterion("has_negative like", value, "hasNegative");
            return (Criteria) this;
        }

        public Criteria andHasNegativeNotLike(String value) {
            addCriterion("has_negative not like", value, "hasNegative");
            return (Criteria) this;
        }

        public Criteria andHasNegativeIn(List<String> values) {
            addCriterion("has_negative in", values, "hasNegative");
            return (Criteria) this;
        }

        public Criteria andHasNegativeNotIn(List<String> values) {
            addCriterion("has_negative not in", values, "hasNegative");
            return (Criteria) this;
        }

        public Criteria andHasNegativeBetween(String value1, String value2) {
            addCriterion("has_negative between", value1, value2, "hasNegative");
            return (Criteria) this;
        }

        public Criteria andHasNegativeNotBetween(String value1, String value2) {
            addCriterion("has_negative not between", value1, value2, "hasNegative");
            return (Criteria) this;
        }

        public Criteria andProductLimitationIsNull() {
            addCriterion("product_limitation is null");
            return (Criteria) this;
        }

        public Criteria andProductLimitationIsNotNull() {
            addCriterion("product_limitation is not null");
            return (Criteria) this;
        }

        public Criteria andProductLimitationEqualTo(String value) {
            addCriterion("product_limitation =", value, "productLimitation");
            return (Criteria) this;
        }

        public Criteria andProductLimitationNotEqualTo(String value) {
            addCriterion("product_limitation <>", value, "productLimitation");
            return (Criteria) this;
        }

        public Criteria andProductLimitationGreaterThan(String value) {
            addCriterion("product_limitation >", value, "productLimitation");
            return (Criteria) this;
        }

        public Criteria andProductLimitationGreaterThanOrEqualTo(String value) {
            addCriterion("product_limitation >=", value, "productLimitation");
            return (Criteria) this;
        }

        public Criteria andProductLimitationLessThan(String value) {
            addCriterion("product_limitation <", value, "productLimitation");
            return (Criteria) this;
        }

        public Criteria andProductLimitationLessThanOrEqualTo(String value) {
            addCriterion("product_limitation <=", value, "productLimitation");
            return (Criteria) this;
        }

        public Criteria andProductLimitationLike(String value) {
            addCriterion("product_limitation like", value, "productLimitation");
            return (Criteria) this;
        }

        public Criteria andProductLimitationNotLike(String value) {
            addCriterion("product_limitation not like", value, "productLimitation");
            return (Criteria) this;
        }

        public Criteria andProductLimitationIn(List<String> values) {
            addCriterion("product_limitation in", values, "productLimitation");
            return (Criteria) this;
        }

        public Criteria andProductLimitationNotIn(List<String> values) {
            addCriterion("product_limitation not in", values, "productLimitation");
            return (Criteria) this;
        }

        public Criteria andProductLimitationBetween(String value1, String value2) {
            addCriterion("product_limitation between", value1, value2, "productLimitation");
            return (Criteria) this;
        }

        public Criteria andProductLimitationNotBetween(String value1, String value2) {
            addCriterion("product_limitation not between", value1, value2, "productLimitation");
            return (Criteria) this;
        }

        public Criteria andApiSendIsNull() {
            addCriterion("api_send is null");
            return (Criteria) this;
        }

        public Criteria andApiSendIsNotNull() {
            addCriterion("api_send is not null");
            return (Criteria) this;
        }

        public Criteria andApiSendEqualTo(String value) {
            addCriterion("api_send =", value, "apiSend");
            return (Criteria) this;
        }

        public Criteria andApiSendNotEqualTo(String value) {
            addCriterion("api_send <>", value, "apiSend");
            return (Criteria) this;
        }

        public Criteria andApiSendGreaterThan(String value) {
            addCriterion("api_send >", value, "apiSend");
            return (Criteria) this;
        }

        public Criteria andApiSendGreaterThanOrEqualTo(String value) {
            addCriterion("api_send >=", value, "apiSend");
            return (Criteria) this;
        }

        public Criteria andApiSendLessThan(String value) {
            addCriterion("api_send <", value, "apiSend");
            return (Criteria) this;
        }

        public Criteria andApiSendLessThanOrEqualTo(String value) {
            addCriterion("api_send <=", value, "apiSend");
            return (Criteria) this;
        }

        public Criteria andApiSendLike(String value) {
            addCriterion("api_send like", value, "apiSend");
            return (Criteria) this;
        }

        public Criteria andApiSendNotLike(String value) {
            addCriterion("api_send not like", value, "apiSend");
            return (Criteria) this;
        }

        public Criteria andApiSendIn(List<String> values) {
            addCriterion("api_send in", values, "apiSend");
            return (Criteria) this;
        }

        public Criteria andApiSendNotIn(List<String> values) {
            addCriterion("api_send not in", values, "apiSend");
            return (Criteria) this;
        }

        public Criteria andApiSendBetween(String value1, String value2) {
            addCriterion("api_send between", value1, value2, "apiSend");
            return (Criteria) this;
        }

        public Criteria andApiSendNotBetween(String value1, String value2) {
            addCriterion("api_send not between", value1, value2, "apiSend");
            return (Criteria) this;
        }

        public Criteria andDefaultQualityRankIsNull() {
            addCriterion("default_quality_rank is null");
            return (Criteria) this;
        }

        public Criteria andDefaultQualityRankIsNotNull() {
            addCriterion("default_quality_rank is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultQualityRankEqualTo(Integer value) {
            addCriterion("default_quality_rank =", value, "defaultQualityRank");
            return (Criteria) this;
        }

        public Criteria andDefaultQualityRankNotEqualTo(Integer value) {
            addCriterion("default_quality_rank <>", value, "defaultQualityRank");
            return (Criteria) this;
        }

        public Criteria andDefaultQualityRankGreaterThan(Integer value) {
            addCriterion("default_quality_rank >", value, "defaultQualityRank");
            return (Criteria) this;
        }

        public Criteria andDefaultQualityRankGreaterThanOrEqualTo(Integer value) {
            addCriterion("default_quality_rank >=", value, "defaultQualityRank");
            return (Criteria) this;
        }

        public Criteria andDefaultQualityRankLessThan(Integer value) {
            addCriterion("default_quality_rank <", value, "defaultQualityRank");
            return (Criteria) this;
        }

        public Criteria andDefaultQualityRankLessThanOrEqualTo(Integer value) {
            addCriterion("default_quality_rank <=", value, "defaultQualityRank");
            return (Criteria) this;
        }

        public Criteria andDefaultQualityRankIn(List<Integer> values) {
            addCriterion("default_quality_rank in", values, "defaultQualityRank");
            return (Criteria) this;
        }

        public Criteria andDefaultQualityRankNotIn(List<Integer> values) {
            addCriterion("default_quality_rank not in", values, "defaultQualityRank");
            return (Criteria) this;
        }

        public Criteria andDefaultQualityRankBetween(Integer value1, Integer value2) {
            addCriterion("default_quality_rank between", value1, value2, "defaultQualityRank");
            return (Criteria) this;
        }

        public Criteria andDefaultQualityRankNotBetween(Integer value1, Integer value2) {
            addCriterion("default_quality_rank not between", value1, value2, "defaultQualityRank");
            return (Criteria) this;
        }

        public Criteria andHaveUurightIsNull() {
            addCriterion("have_uuright is null");
            return (Criteria) this;
        }

        public Criteria andHaveUurightIsNotNull() {
            addCriterion("have_uuright is not null");
            return (Criteria) this;
        }

        public Criteria andHaveUurightEqualTo(Integer value) {
            addCriterion("have_uuright =", value, "haveUuright");
            return (Criteria) this;
        }

        public Criteria andHaveUurightNotEqualTo(Integer value) {
            addCriterion("have_uuright <>", value, "haveUuright");
            return (Criteria) this;
        }

        public Criteria andHaveUurightGreaterThan(Integer value) {
            addCriterion("have_uuright >", value, "haveUuright");
            return (Criteria) this;
        }

        public Criteria andHaveUurightGreaterThanOrEqualTo(Integer value) {
            addCriterion("have_uuright >=", value, "haveUuright");
            return (Criteria) this;
        }

        public Criteria andHaveUurightLessThan(Integer value) {
            addCriterion("have_uuright <", value, "haveUuright");
            return (Criteria) this;
        }

        public Criteria andHaveUurightLessThanOrEqualTo(Integer value) {
            addCriterion("have_uuright <=", value, "haveUuright");
            return (Criteria) this;
        }

        public Criteria andHaveUurightIn(List<Integer> values) {
            addCriterion("have_uuright in", values, "haveUuright");
            return (Criteria) this;
        }

        public Criteria andHaveUurightNotIn(List<Integer> values) {
            addCriterion("have_uuright not in", values, "haveUuright");
            return (Criteria) this;
        }

        public Criteria andHaveUurightBetween(Integer value1, Integer value2) {
            addCriterion("have_uuright between", value1, value2, "haveUuright");
            return (Criteria) this;
        }

        public Criteria andHaveUurightNotBetween(Integer value1, Integer value2) {
            addCriterion("have_uuright not between", value1, value2, "haveUuright");
            return (Criteria) this;
        }

        public Criteria andDeductCostIsNull() {
            addCriterion("deduct_cost is null");
            return (Criteria) this;
        }

        public Criteria andDeductCostIsNotNull() {
            addCriterion("deduct_cost is not null");
            return (Criteria) this;
        }

        public Criteria andDeductCostEqualTo(Integer value) {
            addCriterion("deduct_cost =", value, "deductCost");
            return (Criteria) this;
        }

        public Criteria andDeductCostNotEqualTo(Integer value) {
            addCriterion("deduct_cost <>", value, "deductCost");
            return (Criteria) this;
        }

        public Criteria andDeductCostGreaterThan(Integer value) {
            addCriterion("deduct_cost >", value, "deductCost");
            return (Criteria) this;
        }

        public Criteria andDeductCostGreaterThanOrEqualTo(Integer value) {
            addCriterion("deduct_cost >=", value, "deductCost");
            return (Criteria) this;
        }

        public Criteria andDeductCostLessThan(Integer value) {
            addCriterion("deduct_cost <", value, "deductCost");
            return (Criteria) this;
        }

        public Criteria andDeductCostLessThanOrEqualTo(Integer value) {
            addCriterion("deduct_cost <=", value, "deductCost");
            return (Criteria) this;
        }

        public Criteria andDeductCostIn(List<Integer> values) {
            addCriterion("deduct_cost in", values, "deductCost");
            return (Criteria) this;
        }

        public Criteria andDeductCostNotIn(List<Integer> values) {
            addCriterion("deduct_cost not in", values, "deductCost");
            return (Criteria) this;
        }

        public Criteria andDeductCostBetween(Integer value1, Integer value2) {
            addCriterion("deduct_cost between", value1, value2, "deductCost");
            return (Criteria) this;
        }

        public Criteria andDeductCostNotBetween(Integer value1, Integer value2) {
            addCriterion("deduct_cost not between", value1, value2, "deductCost");
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

	private static final long serialVersionUID = 2042668329758313888L;


        protected Criteria() {
            super();
        }
    }

public static class Criterion implements Serializable {

	private static final long serialVersionUID = 5297275960943060653L;

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
