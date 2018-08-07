package com.vcg.provider.model.query;

import java.io.Serializable;
import com.vcg.common.base.BaseExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ResourceUploadExample extends BaseExample {

	private static final long serialVersionUID = 5574545210024041225L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourceUploadExample() {
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

	private static final long serialVersionUID = 2917368869837863411L;

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

        public Criteria andFileNameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("file_name like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("file_name in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("file_name not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fileName");
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

        public Criteria andGraphicalStyleIsNull() {
            addCriterion("graphical_style is null");
            return (Criteria) this;
        }

        public Criteria andGraphicalStyleIsNotNull() {
            addCriterion("graphical_style is not null");
            return (Criteria) this;
        }

        public Criteria andGraphicalStyleEqualTo(Integer value) {
            addCriterion("graphical_style =", value, "graphicalStyle");
            return (Criteria) this;
        }

        public Criteria andGraphicalStyleNotEqualTo(Integer value) {
            addCriterion("graphical_style <>", value, "graphicalStyle");
            return (Criteria) this;
        }

        public Criteria andGraphicalStyleGreaterThan(Integer value) {
            addCriterion("graphical_style >", value, "graphicalStyle");
            return (Criteria) this;
        }

        public Criteria andGraphicalStyleGreaterThanOrEqualTo(Integer value) {
            addCriterion("graphical_style >=", value, "graphicalStyle");
            return (Criteria) this;
        }

        public Criteria andGraphicalStyleLessThan(Integer value) {
            addCriterion("graphical_style <", value, "graphicalStyle");
            return (Criteria) this;
        }

        public Criteria andGraphicalStyleLessThanOrEqualTo(Integer value) {
            addCriterion("graphical_style <=", value, "graphicalStyle");
            return (Criteria) this;
        }

        public Criteria andGraphicalStyleIn(List<Integer> values) {
            addCriterion("graphical_style in", values, "graphicalStyle");
            return (Criteria) this;
        }

        public Criteria andGraphicalStyleNotIn(List<Integer> values) {
            addCriterion("graphical_style not in", values, "graphicalStyle");
            return (Criteria) this;
        }

        public Criteria andGraphicalStyleBetween(Integer value1, Integer value2) {
            addCriterion("graphical_style between", value1, value2, "graphicalStyle");
            return (Criteria) this;
        }

        public Criteria andGraphicalStyleNotBetween(Integer value1, Integer value2) {
            addCriterion("graphical_style not between", value1, value2, "graphicalStyle");
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
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

        public Criteria andHaveModelReleaseIsNull() {
            addCriterion("have_model_release is null");
            return (Criteria) this;
        }

        public Criteria andHaveModelReleaseIsNotNull() {
            addCriterion("have_model_release is not null");
            return (Criteria) this;
        }

        public Criteria andHaveModelReleaseEqualTo(Integer value) {
            addCriterion("have_model_release =", value, "haveModelRelease");
            return (Criteria) this;
        }

        public Criteria andHaveModelReleaseNotEqualTo(Integer value) {
            addCriterion("have_model_release <>", value, "haveModelRelease");
            return (Criteria) this;
        }

        public Criteria andHaveModelReleaseGreaterThan(Integer value) {
            addCriterion("have_model_release >", value, "haveModelRelease");
            return (Criteria) this;
        }

        public Criteria andHaveModelReleaseGreaterThanOrEqualTo(Integer value) {
            addCriterion("have_model_release >=", value, "haveModelRelease");
            return (Criteria) this;
        }

        public Criteria andHaveModelReleaseLessThan(Integer value) {
            addCriterion("have_model_release <", value, "haveModelRelease");
            return (Criteria) this;
        }

        public Criteria andHaveModelReleaseLessThanOrEqualTo(Integer value) {
            addCriterion("have_model_release <=", value, "haveModelRelease");
            return (Criteria) this;
        }

        public Criteria andHaveModelReleaseIn(List<Integer> values) {
            addCriterion("have_model_release in", values, "haveModelRelease");
            return (Criteria) this;
        }

        public Criteria andHaveModelReleaseNotIn(List<Integer> values) {
            addCriterion("have_model_release not in", values, "haveModelRelease");
            return (Criteria) this;
        }

        public Criteria andHaveModelReleaseBetween(Integer value1, Integer value2) {
            addCriterion("have_model_release between", value1, value2, "haveModelRelease");
            return (Criteria) this;
        }

        public Criteria andHaveModelReleaseNotBetween(Integer value1, Integer value2) {
            addCriterion("have_model_release not between", value1, value2, "haveModelRelease");
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

        public Criteria andHavePropertyReleaseIsNull() {
            addCriterion("have_property_release is null");
            return (Criteria) this;
        }

        public Criteria andHavePropertyReleaseIsNotNull() {
            addCriterion("have_property_release is not null");
            return (Criteria) this;
        }

        public Criteria andHavePropertyReleaseEqualTo(Integer value) {
            addCriterion("have_property_release =", value, "havePropertyRelease");
            return (Criteria) this;
        }

        public Criteria andHavePropertyReleaseNotEqualTo(Integer value) {
            addCriterion("have_property_release <>", value, "havePropertyRelease");
            return (Criteria) this;
        }

        public Criteria andHavePropertyReleaseGreaterThan(Integer value) {
            addCriterion("have_property_release >", value, "havePropertyRelease");
            return (Criteria) this;
        }

        public Criteria andHavePropertyReleaseGreaterThanOrEqualTo(Integer value) {
            addCriterion("have_property_release >=", value, "havePropertyRelease");
            return (Criteria) this;
        }

        public Criteria andHavePropertyReleaseLessThan(Integer value) {
            addCriterion("have_property_release <", value, "havePropertyRelease");
            return (Criteria) this;
        }

        public Criteria andHavePropertyReleaseLessThanOrEqualTo(Integer value) {
            addCriterion("have_property_release <=", value, "havePropertyRelease");
            return (Criteria) this;
        }

        public Criteria andHavePropertyReleaseIn(List<Integer> values) {
            addCriterion("have_property_release in", values, "havePropertyRelease");
            return (Criteria) this;
        }

        public Criteria andHavePropertyReleaseNotIn(List<Integer> values) {
            addCriterion("have_property_release not in", values, "havePropertyRelease");
            return (Criteria) this;
        }

        public Criteria andHavePropertyReleaseBetween(Integer value1, Integer value2) {
            addCriterion("have_property_release between", value1, value2, "havePropertyRelease");
            return (Criteria) this;
        }

        public Criteria andHavePropertyReleaseNotBetween(Integer value1, Integer value2) {
            addCriterion("have_property_release not between", value1, value2, "havePropertyRelease");
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

        public Criteria andPropertyReleaseEqualTo(String value) {
            addCriterion("property_release =", value, "propertyRelease");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseNotEqualTo(String value) {
            addCriterion("property_release <>", value, "propertyRelease");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseGreaterThan(String value) {
            addCriterion("property_release >", value, "propertyRelease");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseGreaterThanOrEqualTo(String value) {
            addCriterion("property_release >=", value, "propertyRelease");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseLessThan(String value) {
            addCriterion("property_release <", value, "propertyRelease");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseLessThanOrEqualTo(String value) {
            addCriterion("property_release <=", value, "propertyRelease");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseLike(String value) {
            addCriterion("property_release like", value, "propertyRelease");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseNotLike(String value) {
            addCriterion("property_release not like", value, "propertyRelease");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseIn(List<String> values) {
            addCriterion("property_release in", values, "propertyRelease");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseNotIn(List<String> values) {
            addCriterion("property_release not in", values, "propertyRelease");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseBetween(String value1, String value2) {
            addCriterion("property_release between", value1, value2, "propertyRelease");
            return (Criteria) this;
        }

        public Criteria andPropertyReleaseNotBetween(String value1, String value2) {
            addCriterion("property_release not between", value1, value2, "propertyRelease");
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

        public Criteria andRestrictionIsNull() {
            addCriterion("restriction is null");
            return (Criteria) this;
        }

        public Criteria andRestrictionIsNotNull() {
            addCriterion("restriction is not null");
            return (Criteria) this;
        }

        public Criteria andRestrictionEqualTo(String value) {
            addCriterion("restriction =", value, "restriction");
            return (Criteria) this;
        }

        public Criteria andRestrictionNotEqualTo(String value) {
            addCriterion("restriction <>", value, "restriction");
            return (Criteria) this;
        }

        public Criteria andRestrictionGreaterThan(String value) {
            addCriterion("restriction >", value, "restriction");
            return (Criteria) this;
        }

        public Criteria andRestrictionGreaterThanOrEqualTo(String value) {
            addCriterion("restriction >=", value, "restriction");
            return (Criteria) this;
        }

        public Criteria andRestrictionLessThan(String value) {
            addCriterion("restriction <", value, "restriction");
            return (Criteria) this;
        }

        public Criteria andRestrictionLessThanOrEqualTo(String value) {
            addCriterion("restriction <=", value, "restriction");
            return (Criteria) this;
        }

        public Criteria andRestrictionLike(String value) {
            addCriterion("restriction like", value, "restriction");
            return (Criteria) this;
        }

        public Criteria andRestrictionNotLike(String value) {
            addCriterion("restriction not like", value, "restriction");
            return (Criteria) this;
        }

        public Criteria andRestrictionIn(List<String> values) {
            addCriterion("restriction in", values, "restriction");
            return (Criteria) this;
        }

        public Criteria andRestrictionNotIn(List<String> values) {
            addCriterion("restriction not in", values, "restriction");
            return (Criteria) this;
        }

        public Criteria andRestrictionBetween(String value1, String value2) {
            addCriterion("restriction between", value1, value2, "restriction");
            return (Criteria) this;
        }

        public Criteria andRestrictionNotBetween(String value1, String value2) {
            addCriterion("restriction not between", value1, value2, "restriction");
            return (Criteria) this;
        }

        public Criteria andShootDateIsNull() {
            addCriterion("shoot_date is null");
            return (Criteria) this;
        }

        public Criteria andShootDateIsNotNull() {
            addCriterion("shoot_date is not null");
            return (Criteria) this;
        }

        public Criteria andShootDateEqualTo(Date value) {
            addCriterionForJDBCDate("shoot_date =", value, "shootDate");
            return (Criteria) this;
        }

        public Criteria andShootDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("shoot_date <>", value, "shootDate");
            return (Criteria) this;
        }

        public Criteria andShootDateGreaterThan(Date value) {
            addCriterionForJDBCDate("shoot_date >", value, "shootDate");
            return (Criteria) this;
        }

        public Criteria andShootDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("shoot_date >=", value, "shootDate");
            return (Criteria) this;
        }

        public Criteria andShootDateLessThan(Date value) {
            addCriterionForJDBCDate("shoot_date <", value, "shootDate");
            return (Criteria) this;
        }

        public Criteria andShootDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("shoot_date <=", value, "shootDate");
            return (Criteria) this;
        }

        public Criteria andShootDateIn(List<Date> values) {
            addCriterionForJDBCDate("shoot_date in", values, "shootDate");
            return (Criteria) this;
        }

        public Criteria andShootDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("shoot_date not in", values, "shootDate");
            return (Criteria) this;
        }

        public Criteria andShootDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("shoot_date between", value1, value2, "shootDate");
            return (Criteria) this;
        }

        public Criteria andShootDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("shoot_date not between", value1, value2, "shootDate");
            return (Criteria) this;
        }

        public Criteria andShootPlaceIsNull() {
            addCriterion("shoot_place is null");
            return (Criteria) this;
        }

        public Criteria andShootPlaceIsNotNull() {
            addCriterion("shoot_place is not null");
            return (Criteria) this;
        }

        public Criteria andShootPlaceEqualTo(String value) {
            addCriterion("shoot_place =", value, "shootPlace");
            return (Criteria) this;
        }

        public Criteria andShootPlaceNotEqualTo(String value) {
            addCriterion("shoot_place <>", value, "shootPlace");
            return (Criteria) this;
        }

        public Criteria andShootPlaceGreaterThan(String value) {
            addCriterion("shoot_place >", value, "shootPlace");
            return (Criteria) this;
        }

        public Criteria andShootPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("shoot_place >=", value, "shootPlace");
            return (Criteria) this;
        }

        public Criteria andShootPlaceLessThan(String value) {
            addCriterion("shoot_place <", value, "shootPlace");
            return (Criteria) this;
        }

        public Criteria andShootPlaceLessThanOrEqualTo(String value) {
            addCriterion("shoot_place <=", value, "shootPlace");
            return (Criteria) this;
        }

        public Criteria andShootPlaceLike(String value) {
            addCriterion("shoot_place like", value, "shootPlace");
            return (Criteria) this;
        }

        public Criteria andShootPlaceNotLike(String value) {
            addCriterion("shoot_place not like", value, "shootPlace");
            return (Criteria) this;
        }

        public Criteria andShootPlaceIn(List<String> values) {
            addCriterion("shoot_place in", values, "shootPlace");
            return (Criteria) this;
        }

        public Criteria andShootPlaceNotIn(List<String> values) {
            addCriterion("shoot_place not in", values, "shootPlace");
            return (Criteria) this;
        }

        public Criteria andShootPlaceBetween(String value1, String value2) {
            addCriterion("shoot_place between", value1, value2, "shootPlace");
            return (Criteria) this;
        }

        public Criteria andShootPlaceNotBetween(String value1, String value2) {
            addCriterion("shoot_place not between", value1, value2, "shootPlace");
            return (Criteria) this;
        }

        public Criteria andOssPathIsNull() {
            addCriterion("oss_path is null");
            return (Criteria) this;
        }

        public Criteria andOssPathIsNotNull() {
            addCriterion("oss_path is not null");
            return (Criteria) this;
        }

        public Criteria andOssPathEqualTo(String value) {
            addCriterion("oss_path =", value, "ossPath");
            return (Criteria) this;
        }

        public Criteria andOssPathNotEqualTo(String value) {
            addCriterion("oss_path <>", value, "ossPath");
            return (Criteria) this;
        }

        public Criteria andOssPathGreaterThan(String value) {
            addCriterion("oss_path >", value, "ossPath");
            return (Criteria) this;
        }

        public Criteria andOssPathGreaterThanOrEqualTo(String value) {
            addCriterion("oss_path >=", value, "ossPath");
            return (Criteria) this;
        }

        public Criteria andOssPathLessThan(String value) {
            addCriterion("oss_path <", value, "ossPath");
            return (Criteria) this;
        }

        public Criteria andOssPathLessThanOrEqualTo(String value) {
            addCriterion("oss_path <=", value, "ossPath");
            return (Criteria) this;
        }

        public Criteria andOssPathLike(String value) {
            addCriterion("oss_path like", value, "ossPath");
            return (Criteria) this;
        }

        public Criteria andOssPathNotLike(String value) {
            addCriterion("oss_path not like", value, "ossPath");
            return (Criteria) this;
        }

        public Criteria andOssPathIn(List<String> values) {
            addCriterion("oss_path in", values, "ossPath");
            return (Criteria) this;
        }

        public Criteria andOssPathNotIn(List<String> values) {
            addCriterion("oss_path not in", values, "ossPath");
            return (Criteria) this;
        }

        public Criteria andOssPathBetween(String value1, String value2) {
            addCriterion("oss_path between", value1, value2, "ossPath");
            return (Criteria) this;
        }

        public Criteria andOssPathNotBetween(String value1, String value2) {
            addCriterion("oss_path not between", value1, value2, "ossPath");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
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

        public Criteria andShootEnvironmentIsNull() {
            addCriterion("shoot_environment is null");
            return (Criteria) this;
        }

        public Criteria andShootEnvironmentIsNotNull() {
            addCriterion("shoot_environment is not null");
            return (Criteria) this;
        }

        public Criteria andShootEnvironmentEqualTo(Integer value) {
            addCriterion("shoot_environment =", value, "shootEnvironment");
            return (Criteria) this;
        }

        public Criteria andShootEnvironmentNotEqualTo(Integer value) {
            addCriterion("shoot_environment <>", value, "shootEnvironment");
            return (Criteria) this;
        }

        public Criteria andShootEnvironmentGreaterThan(Integer value) {
            addCriterion("shoot_environment >", value, "shootEnvironment");
            return (Criteria) this;
        }

        public Criteria andShootEnvironmentGreaterThanOrEqualTo(Integer value) {
            addCriterion("shoot_environment >=", value, "shootEnvironment");
            return (Criteria) this;
        }

        public Criteria andShootEnvironmentLessThan(Integer value) {
            addCriterion("shoot_environment <", value, "shootEnvironment");
            return (Criteria) this;
        }

        public Criteria andShootEnvironmentLessThanOrEqualTo(Integer value) {
            addCriterion("shoot_environment <=", value, "shootEnvironment");
            return (Criteria) this;
        }

        public Criteria andShootEnvironmentIn(List<Integer> values) {
            addCriterion("shoot_environment in", values, "shootEnvironment");
            return (Criteria) this;
        }

        public Criteria andShootEnvironmentNotIn(List<Integer> values) {
            addCriterion("shoot_environment not in", values, "shootEnvironment");
            return (Criteria) this;
        }

        public Criteria andShootEnvironmentBetween(Integer value1, Integer value2) {
            addCriterion("shoot_environment between", value1, value2, "shootEnvironment");
            return (Criteria) this;
        }

        public Criteria andShootEnvironmentNotBetween(Integer value1, Integer value2) {
            addCriterion("shoot_environment not between", value1, value2, "shootEnvironment");
            return (Criteria) this;
        }

        public Criteria andResourceStatusIsNull() {
            addCriterion("resource_status is null");
            return (Criteria) this;
        }

        public Criteria andResourceStatusIsNotNull() {
            addCriterion("resource_status is not null");
            return (Criteria) this;
        }

        public Criteria andResourceStatusEqualTo(Integer value) {
            addCriterion("resource_status =", value, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusNotEqualTo(Integer value) {
            addCriterion("resource_status <>", value, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusGreaterThan(Integer value) {
            addCriterion("resource_status >", value, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource_status >=", value, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusLessThan(Integer value) {
            addCriterion("resource_status <", value, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusLessThanOrEqualTo(Integer value) {
            addCriterion("resource_status <=", value, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusIn(List<Integer> values) {
            addCriterion("resource_status in", values, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusNotIn(List<Integer> values) {
            addCriterion("resource_status not in", values, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusBetween(Integer value1, Integer value2) {
            addCriterion("resource_status between", value1, value2, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("resource_status not between", value1, value2, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andPersonNumberIsNull() {
            addCriterion("person_number is null");
            return (Criteria) this;
        }

        public Criteria andPersonNumberIsNotNull() {
            addCriterion("person_number is not null");
            return (Criteria) this;
        }

        public Criteria andPersonNumberEqualTo(Integer value) {
            addCriterion("person_number =", value, "personNumber");
            return (Criteria) this;
        }

        public Criteria andPersonNumberNotEqualTo(Integer value) {
            addCriterion("person_number <>", value, "personNumber");
            return (Criteria) this;
        }

        public Criteria andPersonNumberGreaterThan(Integer value) {
            addCriterion("person_number >", value, "personNumber");
            return (Criteria) this;
        }

        public Criteria andPersonNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("person_number >=", value, "personNumber");
            return (Criteria) this;
        }

        public Criteria andPersonNumberLessThan(Integer value) {
            addCriterion("person_number <", value, "personNumber");
            return (Criteria) this;
        }

        public Criteria andPersonNumberLessThanOrEqualTo(Integer value) {
            addCriterion("person_number <=", value, "personNumber");
            return (Criteria) this;
        }

        public Criteria andPersonNumberIn(List<Integer> values) {
            addCriterion("person_number in", values, "personNumber");
            return (Criteria) this;
        }

        public Criteria andPersonNumberNotIn(List<Integer> values) {
            addCriterion("person_number not in", values, "personNumber");
            return (Criteria) this;
        }

        public Criteria andPersonNumberBetween(Integer value1, Integer value2) {
            addCriterion("person_number between", value1, value2, "personNumber");
            return (Criteria) this;
        }

        public Criteria andPersonNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("person_number not between", value1, value2, "personNumber");
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

        public Criteria andCanSubmitIsNull() {
            addCriterion("can_submit is null");
            return (Criteria) this;
        }

        public Criteria andCanSubmitIsNotNull() {
            addCriterion("can_submit is not null");
            return (Criteria) this;
        }

        public Criteria andCanSubmitEqualTo(Integer value) {
            addCriterion("can_submit =", value, "canSubmit");
            return (Criteria) this;
        }

        public Criteria andCanSubmitNotEqualTo(Integer value) {
            addCriterion("can_submit <>", value, "canSubmit");
            return (Criteria) this;
        }

        public Criteria andCanSubmitGreaterThan(Integer value) {
            addCriterion("can_submit >", value, "canSubmit");
            return (Criteria) this;
        }

        public Criteria andCanSubmitGreaterThanOrEqualTo(Integer value) {
            addCriterion("can_submit >=", value, "canSubmit");
            return (Criteria) this;
        }

        public Criteria andCanSubmitLessThan(Integer value) {
            addCriterion("can_submit <", value, "canSubmit");
            return (Criteria) this;
        }

        public Criteria andCanSubmitLessThanOrEqualTo(Integer value) {
            addCriterion("can_submit <=", value, "canSubmit");
            return (Criteria) this;
        }

        public Criteria andCanSubmitIn(List<Integer> values) {
            addCriterion("can_submit in", values, "canSubmit");
            return (Criteria) this;
        }

        public Criteria andCanSubmitNotIn(List<Integer> values) {
            addCriterion("can_submit not in", values, "canSubmit");
            return (Criteria) this;
        }

        public Criteria andCanSubmitBetween(Integer value1, Integer value2) {
            addCriterion("can_submit between", value1, value2, "canSubmit");
            return (Criteria) this;
        }

        public Criteria andCanSubmitNotBetween(Integer value1, Integer value2) {
            addCriterion("can_submit not between", value1, value2, "canSubmit");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }
    }

public static class Criteria extends GeneratedCriteria implements Serializable {

	private static final long serialVersionUID = 1154011471072275427L;


        protected Criteria() {
            super();
        }
    }

public static class Criterion implements Serializable {

	private static final long serialVersionUID = 9186870300908746382L;

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
