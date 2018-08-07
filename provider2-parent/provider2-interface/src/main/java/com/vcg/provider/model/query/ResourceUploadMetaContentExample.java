package com.vcg.provider.model.query;

import java.io.Serializable;
import com.vcg.common.base.BaseExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResourceUploadMetaContentExample extends BaseExample {

	private static final long serialVersionUID = 2747753992962124619L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourceUploadMetaContentExample() {
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

	private static final long serialVersionUID = 3806549340374104568L;

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

        public Criteria andImageNameIsNull() {
            addCriterion("image_name is null");
            return (Criteria) this;
        }

        public Criteria andImageNameIsNotNull() {
            addCriterion("image_name is not null");
            return (Criteria) this;
        }

        public Criteria andImageNameEqualTo(String value) {
            addCriterion("image_name =", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameNotEqualTo(String value) {
            addCriterion("image_name <>", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameGreaterThan(String value) {
            addCriterion("image_name >", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameGreaterThanOrEqualTo(String value) {
            addCriterion("image_name >=", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameLessThan(String value) {
            addCriterion("image_name <", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameLessThanOrEqualTo(String value) {
            addCriterion("image_name <=", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameLike(String value) {
            addCriterion("image_name like", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameNotLike(String value) {
            addCriterion("image_name not like", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameIn(List<String> values) {
            addCriterion("image_name in", values, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameNotIn(List<String> values) {
            addCriterion("image_name not in", values, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameBetween(String value1, String value2) {
            addCriterion("image_name between", value1, value2, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameNotBetween(String value1, String value2) {
            addCriterion("image_name not between", value1, value2, "imageName");
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

        public Criteria andBatchIdIsNull() {
            addCriterion("batch_id is null");
            return (Criteria) this;
        }

        public Criteria andBatchIdIsNotNull() {
            addCriterion("batch_id is not null");
            return (Criteria) this;
        }

        public Criteria andBatchIdEqualTo(Integer value) {
            addCriterion("batch_id =", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotEqualTo(Integer value) {
            addCriterion("batch_id <>", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdGreaterThan(Integer value) {
            addCriterion("batch_id >", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("batch_id >=", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLessThan(Integer value) {
            addCriterion("batch_id <", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLessThanOrEqualTo(Integer value) {
            addCriterion("batch_id <=", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdIn(List<Integer> values) {
            addCriterion("batch_id in", values, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotIn(List<Integer> values) {
            addCriterion("batch_id not in", values, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdBetween(Integer value1, Integer value2) {
            addCriterion("batch_id between", value1, value2, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotBetween(Integer value1, Integer value2) {
            addCriterion("batch_id not between", value1, value2, "batchId");
            return (Criteria) this;
        }

        public Criteria andCollectionIsNull() {
            addCriterion("collection is null");
            return (Criteria) this;
        }

        public Criteria andCollectionIsNotNull() {
            addCriterion("collection is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionEqualTo(String value) {
            addCriterion("collection =", value, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionNotEqualTo(String value) {
            addCriterion("collection <>", value, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionGreaterThan(String value) {
            addCriterion("collection >", value, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionGreaterThanOrEqualTo(String value) {
            addCriterion("collection >=", value, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionLessThan(String value) {
            addCriterion("collection <", value, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionLessThanOrEqualTo(String value) {
            addCriterion("collection <=", value, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionLike(String value) {
            addCriterion("collection like", value, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionNotLike(String value) {
            addCriterion("collection not like", value, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionIn(List<String> values) {
            addCriterion("collection in", values, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionNotIn(List<String> values) {
            addCriterion("collection not in", values, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionBetween(String value1, String value2) {
            addCriterion("collection between", value1, value2, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionNotBetween(String value1, String value2) {
            addCriterion("collection not between", value1, value2, "collection");
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

        public Criteria andKeywordsIsNull() {
            addCriterion("keywords is null");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNotNull() {
            addCriterion("keywords is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordsEqualTo(String value) {
            addCriterion("keywords =", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotEqualTo(String value) {
            addCriterion("keywords <>", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThan(String value) {
            addCriterion("keywords >", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("keywords >=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThan(String value) {
            addCriterion("keywords <", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThanOrEqualTo(String value) {
            addCriterion("keywords <=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLike(String value) {
            addCriterion("keywords like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotLike(String value) {
            addCriterion("keywords not like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsIn(List<String> values) {
            addCriterion("keywords in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotIn(List<String> values) {
            addCriterion("keywords not in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsBetween(String value1, String value2) {
            addCriterion("keywords between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotBetween(String value1, String value2) {
            addCriterion("keywords not between", value1, value2, "keywords");
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

        public Criteria andModelReleaseEqualTo(Integer value) {
            addCriterion("model_release =", value, "modelRelease");
            return (Criteria) this;
        }

        public Criteria andModelReleaseNotEqualTo(Integer value) {
            addCriterion("model_release <>", value, "modelRelease");
            return (Criteria) this;
        }

        public Criteria andModelReleaseGreaterThan(Integer value) {
            addCriterion("model_release >", value, "modelRelease");
            return (Criteria) this;
        }

        public Criteria andModelReleaseGreaterThanOrEqualTo(Integer value) {
            addCriterion("model_release >=", value, "modelRelease");
            return (Criteria) this;
        }

        public Criteria andModelReleaseLessThan(Integer value) {
            addCriterion("model_release <", value, "modelRelease");
            return (Criteria) this;
        }

        public Criteria andModelReleaseLessThanOrEqualTo(Integer value) {
            addCriterion("model_release <=", value, "modelRelease");
            return (Criteria) this;
        }

        public Criteria andModelReleaseIn(List<Integer> values) {
            addCriterion("model_release in", values, "modelRelease");
            return (Criteria) this;
        }

        public Criteria andModelReleaseNotIn(List<Integer> values) {
            addCriterion("model_release not in", values, "modelRelease");
            return (Criteria) this;
        }

        public Criteria andModelReleaseBetween(Integer value1, Integer value2) {
            addCriterion("model_release between", value1, value2, "modelRelease");
            return (Criteria) this;
        }

        public Criteria andModelReleaseNotBetween(Integer value1, Integer value2) {
            addCriterion("model_release not between", value1, value2, "modelRelease");
            return (Criteria) this;
        }

        public Criteria andModelReleaseNameIsNull() {
            addCriterion("model_release_name is null");
            return (Criteria) this;
        }

        public Criteria andModelReleaseNameIsNotNull() {
            addCriterion("model_release_name is not null");
            return (Criteria) this;
        }

        public Criteria andModelReleaseNameEqualTo(String value) {
            addCriterion("model_release_name =", value, "modelReleaseName");
            return (Criteria) this;
        }

        public Criteria andModelReleaseNameNotEqualTo(String value) {
            addCriterion("model_release_name <>", value, "modelReleaseName");
            return (Criteria) this;
        }

        public Criteria andModelReleaseNameGreaterThan(String value) {
            addCriterion("model_release_name >", value, "modelReleaseName");
            return (Criteria) this;
        }

        public Criteria andModelReleaseNameGreaterThanOrEqualTo(String value) {
            addCriterion("model_release_name >=", value, "modelReleaseName");
            return (Criteria) this;
        }

        public Criteria andModelReleaseNameLessThan(String value) {
            addCriterion("model_release_name <", value, "modelReleaseName");
            return (Criteria) this;
        }

        public Criteria andModelReleaseNameLessThanOrEqualTo(String value) {
            addCriterion("model_release_name <=", value, "modelReleaseName");
            return (Criteria) this;
        }

        public Criteria andModelReleaseNameLike(String value) {
            addCriterion("model_release_name like", value, "modelReleaseName");
            return (Criteria) this;
        }

        public Criteria andModelReleaseNameNotLike(String value) {
            addCriterion("model_release_name not like", value, "modelReleaseName");
            return (Criteria) this;
        }

        public Criteria andModelReleaseNameIn(List<String> values) {
            addCriterion("model_release_name in", values, "modelReleaseName");
            return (Criteria) this;
        }

        public Criteria andModelReleaseNameNotIn(List<String> values) {
            addCriterion("model_release_name not in", values, "modelReleaseName");
            return (Criteria) this;
        }

        public Criteria andModelReleaseNameBetween(String value1, String value2) {
            addCriterion("model_release_name between", value1, value2, "modelReleaseName");
            return (Criteria) this;
        }

        public Criteria andModelReleaseNameNotBetween(String value1, String value2) {
            addCriterion("model_release_name not between", value1, value2, "modelReleaseName");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseIsNull() {
            addCriterion("property_release is null");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseIsNotNull() {
            addCriterion("property_release is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseEqualTo(Integer value) {
            addCriterion("property_release =", value, "propertyRelease");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseNotEqualTo(Integer value) {
            addCriterion("property_release <>", value, "propertyRelease");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseGreaterThan(Integer value) {
            addCriterion("property_release >", value, "propertyRelease");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseGreaterThanOrEqualTo(Integer value) {
            addCriterion("property_release >=", value, "propertyRelease");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseLessThan(Integer value) {
            addCriterion("property_release <", value, "propertyRelease");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseLessThanOrEqualTo(Integer value) {
            addCriterion("property_release <=", value, "propertyRelease");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseIn(List<Integer> values) {
            addCriterion("property_release in", values, "propertyRelease");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseNotIn(List<Integer> values) {
            addCriterion("property_release not in", values, "propertyRelease");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseBetween(Integer value1, Integer value2) {
            addCriterion("property_release between", value1, value2, "propertyRelease");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseNotBetween(Integer value1, Integer value2) {
            addCriterion("property_release not between", value1, value2, "propertyRelease");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseNameIsNull() {
            addCriterion("property_release_name is null");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseNameIsNotNull() {
            addCriterion("property_release_name is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseNameEqualTo(String value) {
            addCriterion("property_release_name =", value, "propertyReleaseName");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseNameNotEqualTo(String value) {
            addCriterion("property_release_name <>", value, "propertyReleaseName");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseNameGreaterThan(String value) {
            addCriterion("property_release_name >", value, "propertyReleaseName");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseNameGreaterThanOrEqualTo(String value) {
            addCriterion("property_release_name >=", value, "propertyReleaseName");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseNameLessThan(String value) {
            addCriterion("property_release_name <", value, "propertyReleaseName");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseNameLessThanOrEqualTo(String value) {
            addCriterion("property_release_name <=", value, "propertyReleaseName");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseNameLike(String value) {
            addCriterion("property_release_name like", value, "propertyReleaseName");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseNameNotLike(String value) {
            addCriterion("property_release_name not like", value, "propertyReleaseName");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseNameIn(List<String> values) {
            addCriterion("property_release_name in", values, "propertyReleaseName");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseNameNotIn(List<String> values) {
            addCriterion("property_release_name not in", values, "propertyReleaseName");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseNameBetween(String value1, String value2) {
            addCriterion("property_release_name between", value1, value2, "propertyReleaseName");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseNameNotBetween(String value1, String value2) {
            addCriterion("property_release_name not between", value1, value2, "propertyReleaseName");
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

        public Criteria andRestIsNull() {
            addCriterion("rest is null");
            return (Criteria) this;
        }

        public Criteria andRestIsNotNull() {
            addCriterion("rest is not null");
            return (Criteria) this;
        }

        public Criteria andRestEqualTo(String value) {
            addCriterion("rest =", value, "rest");
            return (Criteria) this;
        }

        public Criteria andRestNotEqualTo(String value) {
            addCriterion("rest <>", value, "rest");
            return (Criteria) this;
        }

        public Criteria andRestGreaterThan(String value) {
            addCriterion("rest >", value, "rest");
            return (Criteria) this;
        }

        public Criteria andRestGreaterThanOrEqualTo(String value) {
            addCriterion("rest >=", value, "rest");
            return (Criteria) this;
        }

        public Criteria andRestLessThan(String value) {
            addCriterion("rest <", value, "rest");
            return (Criteria) this;
        }

        public Criteria andRestLessThanOrEqualTo(String value) {
            addCriterion("rest <=", value, "rest");
            return (Criteria) this;
        }

        public Criteria andRestLike(String value) {
            addCriterion("rest like", value, "rest");
            return (Criteria) this;
        }

        public Criteria andRestNotLike(String value) {
            addCriterion("rest not like", value, "rest");
            return (Criteria) this;
        }

        public Criteria andRestIn(List<String> values) {
            addCriterion("rest in", values, "rest");
            return (Criteria) this;
        }

        public Criteria andRestNotIn(List<String> values) {
            addCriterion("rest not in", values, "rest");
            return (Criteria) this;
        }

        public Criteria andRestBetween(String value1, String value2) {
            addCriterion("rest between", value1, value2, "rest");
            return (Criteria) this;
        }

        public Criteria andRestNotBetween(String value1, String value2) {
            addCriterion("rest not between", value1, value2, "rest");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andMediaTypeIsNull() {
            addCriterion("media_type is null");
            return (Criteria) this;
        }

        public Criteria andMediaTypeIsNotNull() {
            addCriterion("media_type is not null");
            return (Criteria) this;
        }

        public Criteria andMediaTypeEqualTo(Integer value) {
            addCriterion("media_type =", value, "mediaType");
            return (Criteria) this;
        }

        public Criteria andMediaTypeNotEqualTo(Integer value) {
            addCriterion("media_type <>", value, "mediaType");
            return (Criteria) this;
        }

        public Criteria andMediaTypeGreaterThan(Integer value) {
            addCriterion("media_type >", value, "mediaType");
            return (Criteria) this;
        }

        public Criteria andMediaTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("media_type >=", value, "mediaType");
            return (Criteria) this;
        }

        public Criteria andMediaTypeLessThan(Integer value) {
            addCriterion("media_type <", value, "mediaType");
            return (Criteria) this;
        }

        public Criteria andMediaTypeLessThanOrEqualTo(Integer value) {
            addCriterion("media_type <=", value, "mediaType");
            return (Criteria) this;
        }

        public Criteria andMediaTypeIn(List<Integer> values) {
            addCriterion("media_type in", values, "mediaType");
            return (Criteria) this;
        }

        public Criteria andMediaTypeNotIn(List<Integer> values) {
            addCriterion("media_type not in", values, "mediaType");
            return (Criteria) this;
        }

        public Criteria andMediaTypeBetween(Integer value1, Integer value2) {
            addCriterion("media_type between", value1, value2, "mediaType");
            return (Criteria) this;
        }

        public Criteria andMediaTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("media_type not between", value1, value2, "mediaType");
            return (Criteria) this;
        }

        public Criteria andColorTypeIsNull() {
            addCriterion("color_type is null");
            return (Criteria) this;
        }

        public Criteria andColorTypeIsNotNull() {
            addCriterion("color_type is not null");
            return (Criteria) this;
        }

        public Criteria andColorTypeEqualTo(Integer value) {
            addCriterion("color_type =", value, "colorType");
            return (Criteria) this;
        }

        public Criteria andColorTypeNotEqualTo(Integer value) {
            addCriterion("color_type <>", value, "colorType");
            return (Criteria) this;
        }

        public Criteria andColorTypeGreaterThan(Integer value) {
            addCriterion("color_type >", value, "colorType");
            return (Criteria) this;
        }

        public Criteria andColorTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("color_type >=", value, "colorType");
            return (Criteria) this;
        }

        public Criteria andColorTypeLessThan(Integer value) {
            addCriterion("color_type <", value, "colorType");
            return (Criteria) this;
        }

        public Criteria andColorTypeLessThanOrEqualTo(Integer value) {
            addCriterion("color_type <=", value, "colorType");
            return (Criteria) this;
        }

        public Criteria andColorTypeIn(List<Integer> values) {
            addCriterion("color_type in", values, "colorType");
            return (Criteria) this;
        }

        public Criteria andColorTypeNotIn(List<Integer> values) {
            addCriterion("color_type not in", values, "colorType");
            return (Criteria) this;
        }

        public Criteria andColorTypeBetween(Integer value1, Integer value2) {
            addCriterion("color_type between", value1, value2, "colorType");
            return (Criteria) this;
        }

        public Criteria andColorTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("color_type not between", value1, value2, "colorType");
            return (Criteria) this;
        }
    }

public static class Criteria extends GeneratedCriteria implements Serializable {

	private static final long serialVersionUID = 2516390963054777701L;


        protected Criteria() {
            super();
        }
    }

public static class Criterion implements Serializable {

	private static final long serialVersionUID = 3362392964950362616L;

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
