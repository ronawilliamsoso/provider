package com.vcg.provider.model.query;

import java.io.Serializable;
import com.vcg.common.base.BaseExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProviderExample extends BaseExample {

	private static final long serialVersionUID = 6442810271507026728L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProviderExample() {
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

	private static final long serialVersionUID = 2210332208923668282L;

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

        public Criteria andPhotographerTypeIsNull() {
            addCriterion("photographer_type is null");
            return (Criteria) this;
        }

        public Criteria andPhotographerTypeIsNotNull() {
            addCriterion("photographer_type is not null");
            return (Criteria) this;
        }

        public Criteria andPhotographerTypeEqualTo(Integer value) {
            addCriterion("photographer_type =", value, "photographerType");
            return (Criteria) this;
        }

        public Criteria andPhotographerTypeNotEqualTo(Integer value) {
            addCriterion("photographer_type <>", value, "photographerType");
            return (Criteria) this;
        }

        public Criteria andPhotographerTypeGreaterThan(Integer value) {
            addCriterion("photographer_type >", value, "photographerType");
            return (Criteria) this;
        }

        public Criteria andPhotographerTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("photographer_type >=", value, "photographerType");
            return (Criteria) this;
        }

        public Criteria andPhotographerTypeLessThan(Integer value) {
            addCriterion("photographer_type <", value, "photographerType");
            return (Criteria) this;
        }

        public Criteria andPhotographerTypeLessThanOrEqualTo(Integer value) {
            addCriterion("photographer_type <=", value, "photographerType");
            return (Criteria) this;
        }

        public Criteria andPhotographerTypeIn(List<Integer> values) {
            addCriterion("photographer_type in", values, "photographerType");
            return (Criteria) this;
        }

        public Criteria andPhotographerTypeNotIn(List<Integer> values) {
            addCriterion("photographer_type not in", values, "photographerType");
            return (Criteria) this;
        }

        public Criteria andPhotographerTypeBetween(Integer value1, Integer value2) {
            addCriterion("photographer_type between", value1, value2, "photographerType");
            return (Criteria) this;
        }

        public Criteria andPhotographerTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("photographer_type not between", value1, value2, "photographerType");
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

        public Criteria andLiveCityIsNull() {
            addCriterion("live_city is null");
            return (Criteria) this;
        }

        public Criteria andLiveCityIsNotNull() {
            addCriterion("live_city is not null");
            return (Criteria) this;
        }

        public Criteria andLiveCityEqualTo(String value) {
            addCriterion("live_city =", value, "liveCity");
            return (Criteria) this;
        }

        public Criteria andLiveCityNotEqualTo(String value) {
            addCriterion("live_city <>", value, "liveCity");
            return (Criteria) this;
        }

        public Criteria andLiveCityGreaterThan(String value) {
            addCriterion("live_city >", value, "liveCity");
            return (Criteria) this;
        }

        public Criteria andLiveCityGreaterThanOrEqualTo(String value) {
            addCriterion("live_city >=", value, "liveCity");
            return (Criteria) this;
        }

        public Criteria andLiveCityLessThan(String value) {
            addCriterion("live_city <", value, "liveCity");
            return (Criteria) this;
        }

        public Criteria andLiveCityLessThanOrEqualTo(String value) {
            addCriterion("live_city <=", value, "liveCity");
            return (Criteria) this;
        }

        public Criteria andLiveCityLike(String value) {
            addCriterion("live_city like", value, "liveCity");
            return (Criteria) this;
        }

        public Criteria andLiveCityNotLike(String value) {
            addCriterion("live_city not like", value, "liveCity");
            return (Criteria) this;
        }

        public Criteria andLiveCityIn(List<String> values) {
            addCriterion("live_city in", values, "liveCity");
            return (Criteria) this;
        }

        public Criteria andLiveCityNotIn(List<String> values) {
            addCriterion("live_city not in", values, "liveCity");
            return (Criteria) this;
        }

        public Criteria andLiveCityBetween(String value1, String value2) {
            addCriterion("live_city between", value1, value2, "liveCity");
            return (Criteria) this;
        }

        public Criteria andLiveCityNotBetween(String value1, String value2) {
            addCriterion("live_city not between", value1, value2, "liveCity");
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

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
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

        public Criteria andLicencePicIsNull() {
            addCriterion("licence_pic is null");
            return (Criteria) this;
        }

        public Criteria andLicencePicIsNotNull() {
            addCriterion("licence_pic is not null");
            return (Criteria) this;
        }

        public Criteria andLicencePicEqualTo(String value) {
            addCriterion("licence_pic =", value, "licencePic");
            return (Criteria) this;
        }

        public Criteria andLicencePicNotEqualTo(String value) {
            addCriterion("licence_pic <>", value, "licencePic");
            return (Criteria) this;
        }

        public Criteria andLicencePicGreaterThan(String value) {
            addCriterion("licence_pic >", value, "licencePic");
            return (Criteria) this;
        }

        public Criteria andLicencePicGreaterThanOrEqualTo(String value) {
            addCriterion("licence_pic >=", value, "licencePic");
            return (Criteria) this;
        }

        public Criteria andLicencePicLessThan(String value) {
            addCriterion("licence_pic <", value, "licencePic");
            return (Criteria) this;
        }

        public Criteria andLicencePicLessThanOrEqualTo(String value) {
            addCriterion("licence_pic <=", value, "licencePic");
            return (Criteria) this;
        }

        public Criteria andLicencePicLike(String value) {
            addCriterion("licence_pic like", value, "licencePic");
            return (Criteria) this;
        }

        public Criteria andLicencePicNotLike(String value) {
            addCriterion("licence_pic not like", value, "licencePic");
            return (Criteria) this;
        }

        public Criteria andLicencePicIn(List<String> values) {
            addCriterion("licence_pic in", values, "licencePic");
            return (Criteria) this;
        }

        public Criteria andLicencePicNotIn(List<String> values) {
            addCriterion("licence_pic not in", values, "licencePic");
            return (Criteria) this;
        }

        public Criteria andLicencePicBetween(String value1, String value2) {
            addCriterion("licence_pic between", value1, value2, "licencePic");
            return (Criteria) this;
        }

        public Criteria andLicencePicNotBetween(String value1, String value2) {
            addCriterion("licence_pic not between", value1, value2, "licencePic");
            return (Criteria) this;
        }

        public Criteria andTaxPicIsNull() {
            addCriterion("tax_pic is null");
            return (Criteria) this;
        }

        public Criteria andTaxPicIsNotNull() {
            addCriterion("tax_pic is not null");
            return (Criteria) this;
        }

        public Criteria andTaxPicEqualTo(String value) {
            addCriterion("tax_pic =", value, "taxPic");
            return (Criteria) this;
        }

        public Criteria andTaxPicNotEqualTo(String value) {
            addCriterion("tax_pic <>", value, "taxPic");
            return (Criteria) this;
        }

        public Criteria andTaxPicGreaterThan(String value) {
            addCriterion("tax_pic >", value, "taxPic");
            return (Criteria) this;
        }

        public Criteria andTaxPicGreaterThanOrEqualTo(String value) {
            addCriterion("tax_pic >=", value, "taxPic");
            return (Criteria) this;
        }

        public Criteria andTaxPicLessThan(String value) {
            addCriterion("tax_pic <", value, "taxPic");
            return (Criteria) this;
        }

        public Criteria andTaxPicLessThanOrEqualTo(String value) {
            addCriterion("tax_pic <=", value, "taxPic");
            return (Criteria) this;
        }

        public Criteria andTaxPicLike(String value) {
            addCriterion("tax_pic like", value, "taxPic");
            return (Criteria) this;
        }

        public Criteria andTaxPicNotLike(String value) {
            addCriterion("tax_pic not like", value, "taxPic");
            return (Criteria) this;
        }

        public Criteria andTaxPicIn(List<String> values) {
            addCriterion("tax_pic in", values, "taxPic");
            return (Criteria) this;
        }

        public Criteria andTaxPicNotIn(List<String> values) {
            addCriterion("tax_pic not in", values, "taxPic");
            return (Criteria) this;
        }

        public Criteria andTaxPicBetween(String value1, String value2) {
            addCriterion("tax_pic between", value1, value2, "taxPic");
            return (Criteria) this;
        }

        public Criteria andTaxPicNotBetween(String value1, String value2) {
            addCriterion("tax_pic not between", value1, value2, "taxPic");
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

        public Criteria andSignatureNameIsNull() {
            addCriterion("signature_name is null");
            return (Criteria) this;
        }

        public Criteria andSignatureNameIsNotNull() {
            addCriterion("signature_name is not null");
            return (Criteria) this;
        }

        public Criteria andSignatureNameEqualTo(String value) {
            addCriterion("signature_name =", value, "signatureName");
            return (Criteria) this;
        }

        public Criteria andSignatureNameNotEqualTo(String value) {
            addCriterion("signature_name <>", value, "signatureName");
            return (Criteria) this;
        }

        public Criteria andSignatureNameGreaterThan(String value) {
            addCriterion("signature_name >", value, "signatureName");
            return (Criteria) this;
        }

        public Criteria andSignatureNameGreaterThanOrEqualTo(String value) {
            addCriterion("signature_name >=", value, "signatureName");
            return (Criteria) this;
        }

        public Criteria andSignatureNameLessThan(String value) {
            addCriterion("signature_name <", value, "signatureName");
            return (Criteria) this;
        }

        public Criteria andSignatureNameLessThanOrEqualTo(String value) {
            addCriterion("signature_name <=", value, "signatureName");
            return (Criteria) this;
        }

        public Criteria andSignatureNameLike(String value) {
            addCriterion("signature_name like", value, "signatureName");
            return (Criteria) this;
        }

        public Criteria andSignatureNameNotLike(String value) {
            addCriterion("signature_name not like", value, "signatureName");
            return (Criteria) this;
        }

        public Criteria andSignatureNameIn(List<String> values) {
            addCriterion("signature_name in", values, "signatureName");
            return (Criteria) this;
        }

        public Criteria andSignatureNameNotIn(List<String> values) {
            addCriterion("signature_name not in", values, "signatureName");
            return (Criteria) this;
        }

        public Criteria andSignatureNameBetween(String value1, String value2) {
            addCriterion("signature_name between", value1, value2, "signatureName");
            return (Criteria) this;
        }

        public Criteria andSignatureNameNotBetween(String value1, String value2) {
            addCriterion("signature_name not between", value1, value2, "signatureName");
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

	private static final long serialVersionUID = 584530833607318996L;


        protected Criteria() {
            super();
        }
    }

public static class Criterion implements Serializable {

	private static final long serialVersionUID = 3003179079703874154L;

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
