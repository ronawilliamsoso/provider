package com.vcg.provider.model.query;

import java.io.Serializable;
import com.vcg.common.base.BaseExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContractApplicationExample extends BaseExample {

	private static final long serialVersionUID = 334991136483868478L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContractApplicationExample() {
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

	private static final long serialVersionUID = 1298025011978149999L;

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

        public Criteria andContractIdIsNull() {
            addCriterion("contract_id is null");
            return (Criteria) this;
        }

        public Criteria andContractIdIsNotNull() {
            addCriterion("contract_id is not null");
            return (Criteria) this;
        }

        public Criteria andContractIdEqualTo(String value) {
            addCriterion("contract_id =", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotEqualTo(String value) {
            addCriterion("contract_id <>", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThan(String value) {
            addCriterion("contract_id >", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThanOrEqualTo(String value) {
            addCriterion("contract_id >=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThan(String value) {
            addCriterion("contract_id <", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThanOrEqualTo(String value) {
            addCriterion("contract_id <=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLike(String value) {
            addCriterion("contract_id like", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotLike(String value) {
            addCriterion("contract_id not like", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdIn(List<String> values) {
            addCriterion("contract_id in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotIn(List<String> values) {
            addCriterion("contract_id not in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdBetween(String value1, String value2) {
            addCriterion("contract_id between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotBetween(String value1, String value2) {
            addCriterion("contract_id not between", value1, value2, "contractId");
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

        public Criteria andPayIdIsNull() {
            addCriterion("pay_id is null");
            return (Criteria) this;
        }

        public Criteria andPayIdIsNotNull() {
            addCriterion("pay_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayIdEqualTo(Integer value) {
            addCriterion("pay_id =", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotEqualTo(Integer value) {
            addCriterion("pay_id <>", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdGreaterThan(Integer value) {
            addCriterion("pay_id >", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_id >=", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLessThan(Integer value) {
            addCriterion("pay_id <", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLessThanOrEqualTo(Integer value) {
            addCriterion("pay_id <=", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdIn(List<Integer> values) {
            addCriterion("pay_id in", values, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotIn(List<Integer> values) {
            addCriterion("pay_id not in", values, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdBetween(Integer value1, Integer value2) {
            addCriterion("pay_id between", value1, value2, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_id not between", value1, value2, "payId");
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

        public Criteria andContractTypeIsNull() {
            addCriterion("contract_type is null");
            return (Criteria) this;
        }

        public Criteria andContractTypeIsNotNull() {
            addCriterion("contract_type is not null");
            return (Criteria) this;
        }

        public Criteria andContractTypeEqualTo(Integer value) {
            addCriterion("contract_type =", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotEqualTo(Integer value) {
            addCriterion("contract_type <>", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeGreaterThan(Integer value) {
            addCriterion("contract_type >", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("contract_type >=", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeLessThan(Integer value) {
            addCriterion("contract_type <", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeLessThanOrEqualTo(Integer value) {
            addCriterion("contract_type <=", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeIn(List<Integer> values) {
            addCriterion("contract_type in", values, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotIn(List<Integer> values) {
            addCriterion("contract_type not in", values, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeBetween(Integer value1, Integer value2) {
            addCriterion("contract_type between", value1, value2, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("contract_type not between", value1, value2, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractNameIsNull() {
            addCriterion("contract_name is null");
            return (Criteria) this;
        }

        public Criteria andContractNameIsNotNull() {
            addCriterion("contract_name is not null");
            return (Criteria) this;
        }

        public Criteria andContractNameEqualTo(String value) {
            addCriterion("contract_name =", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotEqualTo(String value) {
            addCriterion("contract_name <>", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameGreaterThan(String value) {
            addCriterion("contract_name >", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameGreaterThanOrEqualTo(String value) {
            addCriterion("contract_name >=", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLessThan(String value) {
            addCriterion("contract_name <", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLessThanOrEqualTo(String value) {
            addCriterion("contract_name <=", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLike(String value) {
            addCriterion("contract_name like", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotLike(String value) {
            addCriterion("contract_name not like", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameIn(List<String> values) {
            addCriterion("contract_name in", values, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotIn(List<String> values) {
            addCriterion("contract_name not in", values, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameBetween(String value1, String value2) {
            addCriterion("contract_name between", value1, value2, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotBetween(String value1, String value2) {
            addCriterion("contract_name not between", value1, value2, "contractName");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNull() {
            addCriterion("deadline is null");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNotNull() {
            addCriterion("deadline is not null");
            return (Criteria) this;
        }

        public Criteria andDeadlineEqualTo(String value) {
            addCriterion("deadline =", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotEqualTo(String value) {
            addCriterion("deadline <>", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThan(String value) {
            addCriterion("deadline >", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThanOrEqualTo(String value) {
            addCriterion("deadline >=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThan(String value) {
            addCriterion("deadline <", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThanOrEqualTo(String value) {
            addCriterion("deadline <=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLike(String value) {
            addCriterion("deadline like", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotLike(String value) {
            addCriterion("deadline not like", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineIn(List<String> values) {
            addCriterion("deadline in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotIn(List<String> values) {
            addCriterion("deadline not in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineBetween(String value1, String value2) {
            addCriterion("deadline between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotBetween(String value1, String value2) {
            addCriterion("deadline not between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andSignDateIsNull() {
            addCriterion("sign_date is null");
            return (Criteria) this;
        }

        public Criteria andSignDateIsNotNull() {
            addCriterion("sign_date is not null");
            return (Criteria) this;
        }

        public Criteria andSignDateEqualTo(Date value) {
            addCriterion("sign_date =", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotEqualTo(Date value) {
            addCriterion("sign_date <>", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateGreaterThan(Date value) {
            addCriterion("sign_date >", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateGreaterThanOrEqualTo(Date value) {
            addCriterion("sign_date >=", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLessThan(Date value) {
            addCriterion("sign_date <", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLessThanOrEqualTo(Date value) {
            addCriterion("sign_date <=", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateIn(List<Date> values) {
            addCriterion("sign_date in", values, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotIn(List<Date> values) {
            addCriterion("sign_date not in", values, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateBetween(Date value1, Date value2) {
            addCriterion("sign_date between", value1, value2, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotBetween(Date value1, Date value2) {
            addCriterion("sign_date not between", value1, value2, "signDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNull() {
            addCriterion("begin_date is null");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNotNull() {
            addCriterion("begin_date is not null");
            return (Criteria) this;
        }

        public Criteria andBeginDateEqualTo(Date value) {
            addCriterion("begin_date =", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotEqualTo(Date value) {
            addCriterion("begin_date <>", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThan(Date value) {
            addCriterion("begin_date >", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_date >=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThan(Date value) {
            addCriterion("begin_date <", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThanOrEqualTo(Date value) {
            addCriterion("begin_date <=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateIn(List<Date> values) {
            addCriterion("begin_date in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotIn(List<Date> values) {
            addCriterion("begin_date not in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateBetween(Date value1, Date value2) {
            addCriterion("begin_date between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotBetween(Date value1, Date value2) {
            addCriterion("begin_date not between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterion("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterion("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterion("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterion("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterion("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIsNull() {
            addCriterion("payment_method is null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIsNotNull() {
            addCriterion("payment_method is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodEqualTo(String value) {
            addCriterion("payment_method =", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotEqualTo(String value) {
            addCriterion("payment_method <>", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThan(String value) {
            addCriterion("payment_method >", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThanOrEqualTo(String value) {
            addCriterion("payment_method >=", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThan(String value) {
            addCriterion("payment_method <", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThanOrEqualTo(String value) {
            addCriterion("payment_method <=", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLike(String value) {
            addCriterion("payment_method like", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotLike(String value) {
            addCriterion("payment_method not like", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIn(List<String> values) {
            addCriterion("payment_method in", values, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotIn(List<String> values) {
            addCriterion("payment_method not in", values, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodBetween(String value1, String value2) {
            addCriterion("payment_method between", value1, value2, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotBetween(String value1, String value2) {
            addCriterion("payment_method not between", value1, value2, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andBondIsNull() {
            addCriterion("bond is null");
            return (Criteria) this;
        }

        public Criteria andBondIsNotNull() {
            addCriterion("bond is not null");
            return (Criteria) this;
        }

        public Criteria andBondEqualTo(String value) {
            addCriterion("bond =", value, "bond");
            return (Criteria) this;
        }

        public Criteria andBondNotEqualTo(String value) {
            addCriterion("bond <>", value, "bond");
            return (Criteria) this;
        }

        public Criteria andBondGreaterThan(String value) {
            addCriterion("bond >", value, "bond");
            return (Criteria) this;
        }

        public Criteria andBondGreaterThanOrEqualTo(String value) {
            addCriterion("bond >=", value, "bond");
            return (Criteria) this;
        }

        public Criteria andBondLessThan(String value) {
            addCriterion("bond <", value, "bond");
            return (Criteria) this;
        }

        public Criteria andBondLessThanOrEqualTo(String value) {
            addCriterion("bond <=", value, "bond");
            return (Criteria) this;
        }

        public Criteria andBondLike(String value) {
            addCriterion("bond like", value, "bond");
            return (Criteria) this;
        }

        public Criteria andBondNotLike(String value) {
            addCriterion("bond not like", value, "bond");
            return (Criteria) this;
        }

        public Criteria andBondIn(List<String> values) {
            addCriterion("bond in", values, "bond");
            return (Criteria) this;
        }

        public Criteria andBondNotIn(List<String> values) {
            addCriterion("bond not in", values, "bond");
            return (Criteria) this;
        }

        public Criteria andBondBetween(String value1, String value2) {
            addCriterion("bond between", value1, value2, "bond");
            return (Criteria) this;
        }

        public Criteria andBondNotBetween(String value1, String value2) {
            addCriterion("bond not between", value1, value2, "bond");
            return (Criteria) this;
        }

        public Criteria andSettlementCycleIsNull() {
            addCriterion("settlement_cycle is null");
            return (Criteria) this;
        }

        public Criteria andSettlementCycleIsNotNull() {
            addCriterion("settlement_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementCycleEqualTo(String value) {
            addCriterion("settlement_cycle =", value, "settlementCycle");
            return (Criteria) this;
        }

        public Criteria andSettlementCycleNotEqualTo(String value) {
            addCriterion("settlement_cycle <>", value, "settlementCycle");
            return (Criteria) this;
        }

        public Criteria andSettlementCycleGreaterThan(String value) {
            addCriterion("settlement_cycle >", value, "settlementCycle");
            return (Criteria) this;
        }

        public Criteria andSettlementCycleGreaterThanOrEqualTo(String value) {
            addCriterion("settlement_cycle >=", value, "settlementCycle");
            return (Criteria) this;
        }

        public Criteria andSettlementCycleLessThan(String value) {
            addCriterion("settlement_cycle <", value, "settlementCycle");
            return (Criteria) this;
        }

        public Criteria andSettlementCycleLessThanOrEqualTo(String value) {
            addCriterion("settlement_cycle <=", value, "settlementCycle");
            return (Criteria) this;
        }

        public Criteria andSettlementCycleLike(String value) {
            addCriterion("settlement_cycle like", value, "settlementCycle");
            return (Criteria) this;
        }

        public Criteria andSettlementCycleNotLike(String value) {
            addCriterion("settlement_cycle not like", value, "settlementCycle");
            return (Criteria) this;
        }

        public Criteria andSettlementCycleIn(List<String> values) {
            addCriterion("settlement_cycle in", values, "settlementCycle");
            return (Criteria) this;
        }

        public Criteria andSettlementCycleNotIn(List<String> values) {
            addCriterion("settlement_cycle not in", values, "settlementCycle");
            return (Criteria) this;
        }

        public Criteria andSettlementCycleBetween(String value1, String value2) {
            addCriterion("settlement_cycle between", value1, value2, "settlementCycle");
            return (Criteria) this;
        }

        public Criteria andSettlementCycleNotBetween(String value1, String value2) {
            addCriterion("settlement_cycle not between", value1, value2, "settlementCycle");
            return (Criteria) this;
        }

        public Criteria andContractStatusIsNull() {
            addCriterion("contract_status is null");
            return (Criteria) this;
        }

        public Criteria andContractStatusIsNotNull() {
            addCriterion("contract_status is not null");
            return (Criteria) this;
        }

        public Criteria andContractStatusEqualTo(Integer value) {
            addCriterion("contract_status =", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusNotEqualTo(Integer value) {
            addCriterion("contract_status <>", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusGreaterThan(Integer value) {
            addCriterion("contract_status >", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("contract_status >=", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusLessThan(Integer value) {
            addCriterion("contract_status <", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusLessThanOrEqualTo(Integer value) {
            addCriterion("contract_status <=", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusIn(List<Integer> values) {
            addCriterion("contract_status in", values, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusNotIn(List<Integer> values) {
            addCriterion("contract_status not in", values, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusBetween(Integer value1, Integer value2) {
            addCriterion("contract_status between", value1, value2, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("contract_status not between", value1, value2, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusIsNull() {
            addCriterion("auditing_status is null");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusIsNotNull() {
            addCriterion("auditing_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusEqualTo(Integer value) {
            addCriterion("auditing_status =", value, "auditingStatus");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusNotEqualTo(Integer value) {
            addCriterion("auditing_status <>", value, "auditingStatus");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusGreaterThan(Integer value) {
            addCriterion("auditing_status >", value, "auditingStatus");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("auditing_status >=", value, "auditingStatus");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusLessThan(Integer value) {
            addCriterion("auditing_status <", value, "auditingStatus");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusLessThanOrEqualTo(Integer value) {
            addCriterion("auditing_status <=", value, "auditingStatus");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusIn(List<Integer> values) {
            addCriterion("auditing_status in", values, "auditingStatus");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusNotIn(List<Integer> values) {
            addCriterion("auditing_status not in", values, "auditingStatus");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusBetween(Integer value1, Integer value2) {
            addCriterion("auditing_status between", value1, value2, "auditingStatus");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("auditing_status not between", value1, value2, "auditingStatus");
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

        public Criteria andAgentNameIsNull() {
            addCriterion("agent_name is null");
            return (Criteria) this;
        }

        public Criteria andAgentNameIsNotNull() {
            addCriterion("agent_name is not null");
            return (Criteria) this;
        }

        public Criteria andAgentNameEqualTo(String value) {
            addCriterion("agent_name =", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotEqualTo(String value) {
            addCriterion("agent_name <>", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameGreaterThan(String value) {
            addCriterion("agent_name >", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameGreaterThanOrEqualTo(String value) {
            addCriterion("agent_name >=", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameLessThan(String value) {
            addCriterion("agent_name <", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameLessThanOrEqualTo(String value) {
            addCriterion("agent_name <=", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameLike(String value) {
            addCriterion("agent_name like", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotLike(String value) {
            addCriterion("agent_name not like", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameIn(List<String> values) {
            addCriterion("agent_name in", values, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotIn(List<String> values) {
            addCriterion("agent_name not in", values, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameBetween(String value1, String value2) {
            addCriterion("agent_name between", value1, value2, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotBetween(String value1, String value2) {
            addCriterion("agent_name not between", value1, value2, "agentName");
            return (Criteria) this;
        }

        public Criteria andCreativeRateIsNull() {
            addCriterion("creative_rate is null");
            return (Criteria) this;
        }

        public Criteria andCreativeRateIsNotNull() {
            addCriterion("creative_rate is not null");
            return (Criteria) this;
        }

        public Criteria andCreativeRateEqualTo(String value) {
            addCriterion("creative_rate =", value, "creativeRate");
            return (Criteria) this;
        }

        public Criteria andCreativeRateNotEqualTo(String value) {
            addCriterion("creative_rate <>", value, "creativeRate");
            return (Criteria) this;
        }

        public Criteria andCreativeRateGreaterThan(String value) {
            addCriterion("creative_rate >", value, "creativeRate");
            return (Criteria) this;
        }

        public Criteria andCreativeRateGreaterThanOrEqualTo(String value) {
            addCriterion("creative_rate >=", value, "creativeRate");
            return (Criteria) this;
        }

        public Criteria andCreativeRateLessThan(String value) {
            addCriterion("creative_rate <", value, "creativeRate");
            return (Criteria) this;
        }

        public Criteria andCreativeRateLessThanOrEqualTo(String value) {
            addCriterion("creative_rate <=", value, "creativeRate");
            return (Criteria) this;
        }

        public Criteria andCreativeRateLike(String value) {
            addCriterion("creative_rate like", value, "creativeRate");
            return (Criteria) this;
        }

        public Criteria andCreativeRateNotLike(String value) {
            addCriterion("creative_rate not like", value, "creativeRate");
            return (Criteria) this;
        }

        public Criteria andCreativeRateIn(List<String> values) {
            addCriterion("creative_rate in", values, "creativeRate");
            return (Criteria) this;
        }

        public Criteria andCreativeRateNotIn(List<String> values) {
            addCriterion("creative_rate not in", values, "creativeRate");
            return (Criteria) this;
        }

        public Criteria andCreativeRateBetween(String value1, String value2) {
            addCriterion("creative_rate between", value1, value2, "creativeRate");
            return (Criteria) this;
        }

        public Criteria andCreativeRateNotBetween(String value1, String value2) {
            addCriterion("creative_rate not between", value1, value2, "creativeRate");
            return (Criteria) this;
        }

        public Criteria andEditRateIsNull() {
            addCriterion("edit_rate is null");
            return (Criteria) this;
        }

        public Criteria andEditRateIsNotNull() {
            addCriterion("edit_rate is not null");
            return (Criteria) this;
        }

        public Criteria andEditRateEqualTo(String value) {
            addCriterion("edit_rate =", value, "editRate");
            return (Criteria) this;
        }

        public Criteria andEditRateNotEqualTo(String value) {
            addCriterion("edit_rate <>", value, "editRate");
            return (Criteria) this;
        }

        public Criteria andEditRateGreaterThan(String value) {
            addCriterion("edit_rate >", value, "editRate");
            return (Criteria) this;
        }

        public Criteria andEditRateGreaterThanOrEqualTo(String value) {
            addCriterion("edit_rate >=", value, "editRate");
            return (Criteria) this;
        }

        public Criteria andEditRateLessThan(String value) {
            addCriterion("edit_rate <", value, "editRate");
            return (Criteria) this;
        }

        public Criteria andEditRateLessThanOrEqualTo(String value) {
            addCriterion("edit_rate <=", value, "editRate");
            return (Criteria) this;
        }

        public Criteria andEditRateLike(String value) {
            addCriterion("edit_rate like", value, "editRate");
            return (Criteria) this;
        }

        public Criteria andEditRateNotLike(String value) {
            addCriterion("edit_rate not like", value, "editRate");
            return (Criteria) this;
        }

        public Criteria andEditRateIn(List<String> values) {
            addCriterion("edit_rate in", values, "editRate");
            return (Criteria) this;
        }

        public Criteria andEditRateNotIn(List<String> values) {
            addCriterion("edit_rate not in", values, "editRate");
            return (Criteria) this;
        }

        public Criteria andEditRateBetween(String value1, String value2) {
            addCriterion("edit_rate between", value1, value2, "editRate");
            return (Criteria) this;
        }

        public Criteria andEditRateNotBetween(String value1, String value2) {
            addCriterion("edit_rate not between", value1, value2, "editRate");
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

        public Criteria andPayMethodNameIsNull() {
            addCriterion("pay_method_name is null");
            return (Criteria) this;
        }

        public Criteria andPayMethodNameIsNotNull() {
            addCriterion("pay_method_name is not null");
            return (Criteria) this;
        }

        public Criteria andPayMethodNameEqualTo(String value) {
            addCriterion("pay_method_name =", value, "payMethodName");
            return (Criteria) this;
        }

        public Criteria andPayMethodNameNotEqualTo(String value) {
            addCriterion("pay_method_name <>", value, "payMethodName");
            return (Criteria) this;
        }

        public Criteria andPayMethodNameGreaterThan(String value) {
            addCriterion("pay_method_name >", value, "payMethodName");
            return (Criteria) this;
        }

        public Criteria andPayMethodNameGreaterThanOrEqualTo(String value) {
            addCriterion("pay_method_name >=", value, "payMethodName");
            return (Criteria) this;
        }

        public Criteria andPayMethodNameLessThan(String value) {
            addCriterion("pay_method_name <", value, "payMethodName");
            return (Criteria) this;
        }

        public Criteria andPayMethodNameLessThanOrEqualTo(String value) {
            addCriterion("pay_method_name <=", value, "payMethodName");
            return (Criteria) this;
        }

        public Criteria andPayMethodNameLike(String value) {
            addCriterion("pay_method_name like", value, "payMethodName");
            return (Criteria) this;
        }

        public Criteria andPayMethodNameNotLike(String value) {
            addCriterion("pay_method_name not like", value, "payMethodName");
            return (Criteria) this;
        }

        public Criteria andPayMethodNameIn(List<String> values) {
            addCriterion("pay_method_name in", values, "payMethodName");
            return (Criteria) this;
        }

        public Criteria andPayMethodNameNotIn(List<String> values) {
            addCriterion("pay_method_name not in", values, "payMethodName");
            return (Criteria) this;
        }

        public Criteria andPayMethodNameBetween(String value1, String value2) {
            addCriterion("pay_method_name between", value1, value2, "payMethodName");
            return (Criteria) this;
        }

        public Criteria andPayMethodNameNotBetween(String value1, String value2) {
            addCriterion("pay_method_name not between", value1, value2, "payMethodName");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("bank_name is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bank_name =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bank_name <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bank_name >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_name >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bank_name <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bank_name <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bank_name like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bank_name not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("bank_name in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("bank_name not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bank_name between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bank_name not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBranchBanknameIsNull() {
            addCriterion("branch_bankname is null");
            return (Criteria) this;
        }

        public Criteria andBranchBanknameIsNotNull() {
            addCriterion("branch_bankname is not null");
            return (Criteria) this;
        }

        public Criteria andBranchBanknameEqualTo(String value) {
            addCriterion("branch_bankname =", value, "branchBankname");
            return (Criteria) this;
        }

        public Criteria andBranchBanknameNotEqualTo(String value) {
            addCriterion("branch_bankname <>", value, "branchBankname");
            return (Criteria) this;
        }

        public Criteria andBranchBanknameGreaterThan(String value) {
            addCriterion("branch_bankname >", value, "branchBankname");
            return (Criteria) this;
        }

        public Criteria andBranchBanknameGreaterThanOrEqualTo(String value) {
            addCriterion("branch_bankname >=", value, "branchBankname");
            return (Criteria) this;
        }

        public Criteria andBranchBanknameLessThan(String value) {
            addCriterion("branch_bankname <", value, "branchBankname");
            return (Criteria) this;
        }

        public Criteria andBranchBanknameLessThanOrEqualTo(String value) {
            addCriterion("branch_bankname <=", value, "branchBankname");
            return (Criteria) this;
        }

        public Criteria andBranchBanknameLike(String value) {
            addCriterion("branch_bankname like", value, "branchBankname");
            return (Criteria) this;
        }

        public Criteria andBranchBanknameNotLike(String value) {
            addCriterion("branch_bankname not like", value, "branchBankname");
            return (Criteria) this;
        }

        public Criteria andBranchBanknameIn(List<String> values) {
            addCriterion("branch_bankname in", values, "branchBankname");
            return (Criteria) this;
        }

        public Criteria andBranchBanknameNotIn(List<String> values) {
            addCriterion("branch_bankname not in", values, "branchBankname");
            return (Criteria) this;
        }

        public Criteria andBranchBanknameBetween(String value1, String value2) {
            addCriterion("branch_bankname between", value1, value2, "branchBankname");
            return (Criteria) this;
        }

        public Criteria andBranchBanknameNotBetween(String value1, String value2) {
            addCriterion("branch_bankname not between", value1, value2, "branchBankname");
            return (Criteria) this;
        }

        public Criteria andPayeeNameIsNull() {
            addCriterion("payee_name is null");
            return (Criteria) this;
        }

        public Criteria andPayeeNameIsNotNull() {
            addCriterion("payee_name is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeNameEqualTo(String value) {
            addCriterion("payee_name =", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameNotEqualTo(String value) {
            addCriterion("payee_name <>", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameGreaterThan(String value) {
            addCriterion("payee_name >", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameGreaterThanOrEqualTo(String value) {
            addCriterion("payee_name >=", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameLessThan(String value) {
            addCriterion("payee_name <", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameLessThanOrEqualTo(String value) {
            addCriterion("payee_name <=", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameLike(String value) {
            addCriterion("payee_name like", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameNotLike(String value) {
            addCriterion("payee_name not like", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameIn(List<String> values) {
            addCriterion("payee_name in", values, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameNotIn(List<String> values) {
            addCriterion("payee_name not in", values, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameBetween(String value1, String value2) {
            addCriterion("payee_name between", value1, value2, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameNotBetween(String value1, String value2) {
            addCriterion("payee_name not between", value1, value2, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNumberIsNull() {
            addCriterion("payee_number is null");
            return (Criteria) this;
        }

        public Criteria andPayeeNumberIsNotNull() {
            addCriterion("payee_number is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeNumberEqualTo(String value) {
            addCriterion("payee_number =", value, "payeeNumber");
            return (Criteria) this;
        }

        public Criteria andPayeeNumberNotEqualTo(String value) {
            addCriterion("payee_number <>", value, "payeeNumber");
            return (Criteria) this;
        }

        public Criteria andPayeeNumberGreaterThan(String value) {
            addCriterion("payee_number >", value, "payeeNumber");
            return (Criteria) this;
        }

        public Criteria andPayeeNumberGreaterThanOrEqualTo(String value) {
            addCriterion("payee_number >=", value, "payeeNumber");
            return (Criteria) this;
        }

        public Criteria andPayeeNumberLessThan(String value) {
            addCriterion("payee_number <", value, "payeeNumber");
            return (Criteria) this;
        }

        public Criteria andPayeeNumberLessThanOrEqualTo(String value) {
            addCriterion("payee_number <=", value, "payeeNumber");
            return (Criteria) this;
        }

        public Criteria andPayeeNumberLike(String value) {
            addCriterion("payee_number like", value, "payeeNumber");
            return (Criteria) this;
        }

        public Criteria andPayeeNumberNotLike(String value) {
            addCriterion("payee_number not like", value, "payeeNumber");
            return (Criteria) this;
        }

        public Criteria andPayeeNumberIn(List<String> values) {
            addCriterion("payee_number in", values, "payeeNumber");
            return (Criteria) this;
        }

        public Criteria andPayeeNumberNotIn(List<String> values) {
            addCriterion("payee_number not in", values, "payeeNumber");
            return (Criteria) this;
        }

        public Criteria andPayeeNumberBetween(String value1, String value2) {
            addCriterion("payee_number between", value1, value2, "payeeNumber");
            return (Criteria) this;
        }

        public Criteria andPayeeNumberNotBetween(String value1, String value2) {
            addCriterion("payee_number not between", value1, value2, "payeeNumber");
            return (Criteria) this;
        }

        public Criteria andSwiftCodeIsNull() {
            addCriterion("swift_code is null");
            return (Criteria) this;
        }

        public Criteria andSwiftCodeIsNotNull() {
            addCriterion("swift_code is not null");
            return (Criteria) this;
        }

        public Criteria andSwiftCodeEqualTo(String value) {
            addCriterion("swift_code =", value, "swiftCode");
            return (Criteria) this;
        }

        public Criteria andSwiftCodeNotEqualTo(String value) {
            addCriterion("swift_code <>", value, "swiftCode");
            return (Criteria) this;
        }

        public Criteria andSwiftCodeGreaterThan(String value) {
            addCriterion("swift_code >", value, "swiftCode");
            return (Criteria) this;
        }

        public Criteria andSwiftCodeGreaterThanOrEqualTo(String value) {
            addCriterion("swift_code >=", value, "swiftCode");
            return (Criteria) this;
        }

        public Criteria andSwiftCodeLessThan(String value) {
            addCriterion("swift_code <", value, "swiftCode");
            return (Criteria) this;
        }

        public Criteria andSwiftCodeLessThanOrEqualTo(String value) {
            addCriterion("swift_code <=", value, "swiftCode");
            return (Criteria) this;
        }

        public Criteria andSwiftCodeLike(String value) {
            addCriterion("swift_code like", value, "swiftCode");
            return (Criteria) this;
        }

        public Criteria andSwiftCodeNotLike(String value) {
            addCriterion("swift_code not like", value, "swiftCode");
            return (Criteria) this;
        }

        public Criteria andSwiftCodeIn(List<String> values) {
            addCriterion("swift_code in", values, "swiftCode");
            return (Criteria) this;
        }

        public Criteria andSwiftCodeNotIn(List<String> values) {
            addCriterion("swift_code not in", values, "swiftCode");
            return (Criteria) this;
        }

        public Criteria andSwiftCodeBetween(String value1, String value2) {
            addCriterion("swift_code between", value1, value2, "swiftCode");
            return (Criteria) this;
        }

        public Criteria andSwiftCodeNotBetween(String value1, String value2) {
            addCriterion("swift_code not between", value1, value2, "swiftCode");
            return (Criteria) this;
        }

        public Criteria andBankAddressIsNull() {
            addCriterion("bank_address is null");
            return (Criteria) this;
        }

        public Criteria andBankAddressIsNotNull() {
            addCriterion("bank_address is not null");
            return (Criteria) this;
        }

        public Criteria andBankAddressEqualTo(String value) {
            addCriterion("bank_address =", value, "bankAddress");
            return (Criteria) this;
        }

        public Criteria andBankAddressNotEqualTo(String value) {
            addCriterion("bank_address <>", value, "bankAddress");
            return (Criteria) this;
        }

        public Criteria andBankAddressGreaterThan(String value) {
            addCriterion("bank_address >", value, "bankAddress");
            return (Criteria) this;
        }

        public Criteria andBankAddressGreaterThanOrEqualTo(String value) {
            addCriterion("bank_address >=", value, "bankAddress");
            return (Criteria) this;
        }

        public Criteria andBankAddressLessThan(String value) {
            addCriterion("bank_address <", value, "bankAddress");
            return (Criteria) this;
        }

        public Criteria andBankAddressLessThanOrEqualTo(String value) {
            addCriterion("bank_address <=", value, "bankAddress");
            return (Criteria) this;
        }

        public Criteria andBankAddressLike(String value) {
            addCriterion("bank_address like", value, "bankAddress");
            return (Criteria) this;
        }

        public Criteria andBankAddressNotLike(String value) {
            addCriterion("bank_address not like", value, "bankAddress");
            return (Criteria) this;
        }

        public Criteria andBankAddressIn(List<String> values) {
            addCriterion("bank_address in", values, "bankAddress");
            return (Criteria) this;
        }

        public Criteria andBankAddressNotIn(List<String> values) {
            addCriterion("bank_address not in", values, "bankAddress");
            return (Criteria) this;
        }

        public Criteria andBankAddressBetween(String value1, String value2) {
            addCriterion("bank_address between", value1, value2, "bankAddress");
            return (Criteria) this;
        }

        public Criteria andBankAddressNotBetween(String value1, String value2) {
            addCriterion("bank_address not between", value1, value2, "bankAddress");
            return (Criteria) this;
        }

        public Criteria andOpenAccountaddressIsNull() {
            addCriterion("open_accountaddress is null");
            return (Criteria) this;
        }

        public Criteria andOpenAccountaddressIsNotNull() {
            addCriterion("open_accountaddress is not null");
            return (Criteria) this;
        }

        public Criteria andOpenAccountaddressEqualTo(String value) {
            addCriterion("open_accountaddress =", value, "openAccountaddress");
            return (Criteria) this;
        }

        public Criteria andOpenAccountaddressNotEqualTo(String value) {
            addCriterion("open_accountaddress <>", value, "openAccountaddress");
            return (Criteria) this;
        }

        public Criteria andOpenAccountaddressGreaterThan(String value) {
            addCriterion("open_accountaddress >", value, "openAccountaddress");
            return (Criteria) this;
        }

        public Criteria andOpenAccountaddressGreaterThanOrEqualTo(String value) {
            addCriterion("open_accountaddress >=", value, "openAccountaddress");
            return (Criteria) this;
        }

        public Criteria andOpenAccountaddressLessThan(String value) {
            addCriterion("open_accountaddress <", value, "openAccountaddress");
            return (Criteria) this;
        }

        public Criteria andOpenAccountaddressLessThanOrEqualTo(String value) {
            addCriterion("open_accountaddress <=", value, "openAccountaddress");
            return (Criteria) this;
        }

        public Criteria andOpenAccountaddressLike(String value) {
            addCriterion("open_accountaddress like", value, "openAccountaddress");
            return (Criteria) this;
        }

        public Criteria andOpenAccountaddressNotLike(String value) {
            addCriterion("open_accountaddress not like", value, "openAccountaddress");
            return (Criteria) this;
        }

        public Criteria andOpenAccountaddressIn(List<String> values) {
            addCriterion("open_accountaddress in", values, "openAccountaddress");
            return (Criteria) this;
        }

        public Criteria andOpenAccountaddressNotIn(List<String> values) {
            addCriterion("open_accountaddress not in", values, "openAccountaddress");
            return (Criteria) this;
        }

        public Criteria andOpenAccountaddressBetween(String value1, String value2) {
            addCriterion("open_accountaddress between", value1, value2, "openAccountaddress");
            return (Criteria) this;
        }

        public Criteria andOpenAccountaddressNotBetween(String value1, String value2) {
            addCriterion("open_accountaddress not between", value1, value2, "openAccountaddress");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("currency is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("currency is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(Integer value) {
            addCriterion("currency =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(Integer value) {
            addCriterion("currency <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(Integer value) {
            addCriterion("currency >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("currency >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(Integer value) {
            addCriterion("currency <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(Integer value) {
            addCriterion("currency <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<Integer> values) {
            addCriterion("currency in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<Integer> values) {
            addCriterion("currency not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(Integer value1, Integer value2) {
            addCriterion("currency between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(Integer value1, Integer value2) {
            addCriterion("currency not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andIbanIsNull() {
            addCriterion("iban is null");
            return (Criteria) this;
        }

        public Criteria andIbanIsNotNull() {
            addCriterion("iban is not null");
            return (Criteria) this;
        }

        public Criteria andIbanEqualTo(String value) {
            addCriterion("iban =", value, "iban");
            return (Criteria) this;
        }

        public Criteria andIbanNotEqualTo(String value) {
            addCriterion("iban <>", value, "iban");
            return (Criteria) this;
        }

        public Criteria andIbanGreaterThan(String value) {
            addCriterion("iban >", value, "iban");
            return (Criteria) this;
        }

        public Criteria andIbanGreaterThanOrEqualTo(String value) {
            addCriterion("iban >=", value, "iban");
            return (Criteria) this;
        }

        public Criteria andIbanLessThan(String value) {
            addCriterion("iban <", value, "iban");
            return (Criteria) this;
        }

        public Criteria andIbanLessThanOrEqualTo(String value) {
            addCriterion("iban <=", value, "iban");
            return (Criteria) this;
        }

        public Criteria andIbanLike(String value) {
            addCriterion("iban like", value, "iban");
            return (Criteria) this;
        }

        public Criteria andIbanNotLike(String value) {
            addCriterion("iban not like", value, "iban");
            return (Criteria) this;
        }

        public Criteria andIbanIn(List<String> values) {
            addCriterion("iban in", values, "iban");
            return (Criteria) this;
        }

        public Criteria andIbanNotIn(List<String> values) {
            addCriterion("iban not in", values, "iban");
            return (Criteria) this;
        }

        public Criteria andIbanBetween(String value1, String value2) {
            addCriterion("iban between", value1, value2, "iban");
            return (Criteria) this;
        }

        public Criteria andIbanNotBetween(String value1, String value2) {
            addCriterion("iban not between", value1, value2, "iban");
            return (Criteria) this;
        }

        public Criteria andBankRemarkIsNull() {
            addCriterion("bank_remark is null");
            return (Criteria) this;
        }

        public Criteria andBankRemarkIsNotNull() {
            addCriterion("bank_remark is not null");
            return (Criteria) this;
        }

        public Criteria andBankRemarkEqualTo(String value) {
            addCriterion("bank_remark =", value, "bankRemark");
            return (Criteria) this;
        }

        public Criteria andBankRemarkNotEqualTo(String value) {
            addCriterion("bank_remark <>", value, "bankRemark");
            return (Criteria) this;
        }

        public Criteria andBankRemarkGreaterThan(String value) {
            addCriterion("bank_remark >", value, "bankRemark");
            return (Criteria) this;
        }

        public Criteria andBankRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("bank_remark >=", value, "bankRemark");
            return (Criteria) this;
        }

        public Criteria andBankRemarkLessThan(String value) {
            addCriterion("bank_remark <", value, "bankRemark");
            return (Criteria) this;
        }

        public Criteria andBankRemarkLessThanOrEqualTo(String value) {
            addCriterion("bank_remark <=", value, "bankRemark");
            return (Criteria) this;
        }

        public Criteria andBankRemarkLike(String value) {
            addCriterion("bank_remark like", value, "bankRemark");
            return (Criteria) this;
        }

        public Criteria andBankRemarkNotLike(String value) {
            addCriterion("bank_remark not like", value, "bankRemark");
            return (Criteria) this;
        }

        public Criteria andBankRemarkIn(List<String> values) {
            addCriterion("bank_remark in", values, "bankRemark");
            return (Criteria) this;
        }

        public Criteria andBankRemarkNotIn(List<String> values) {
            addCriterion("bank_remark not in", values, "bankRemark");
            return (Criteria) this;
        }

        public Criteria andBankRemarkBetween(String value1, String value2) {
            addCriterion("bank_remark between", value1, value2, "bankRemark");
            return (Criteria) this;
        }

        public Criteria andBankRemarkNotBetween(String value1, String value2) {
            addCriterion("bank_remark not between", value1, value2, "bankRemark");
            return (Criteria) this;
        }

        public Criteria andTaxCodeIsNull() {
            addCriterion("tax_code is null");
            return (Criteria) this;
        }

        public Criteria andTaxCodeIsNotNull() {
            addCriterion("tax_code is not null");
            return (Criteria) this;
        }

        public Criteria andTaxCodeEqualTo(String value) {
            addCriterion("tax_code =", value, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeNotEqualTo(String value) {
            addCriterion("tax_code <>", value, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeGreaterThan(String value) {
            addCriterion("tax_code >", value, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tax_code >=", value, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeLessThan(String value) {
            addCriterion("tax_code <", value, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeLessThanOrEqualTo(String value) {
            addCriterion("tax_code <=", value, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeLike(String value) {
            addCriterion("tax_code like", value, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeNotLike(String value) {
            addCriterion("tax_code not like", value, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeIn(List<String> values) {
            addCriterion("tax_code in", values, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeNotIn(List<String> values) {
            addCriterion("tax_code not in", values, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeBetween(String value1, String value2) {
            addCriterion("tax_code between", value1, value2, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeNotBetween(String value1, String value2) {
            addCriterion("tax_code not between", value1, value2, "taxCode");
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

        public Criteria andContractZhutiIsNull() {
            addCriterion("contract_zhuti is null");
            return (Criteria) this;
        }

        public Criteria andContractZhutiIsNotNull() {
            addCriterion("contract_zhuti is not null");
            return (Criteria) this;
        }

        public Criteria andContractZhutiEqualTo(String value) {
            addCriterion("contract_zhuti =", value, "contractZhuti");
            return (Criteria) this;
        }

        public Criteria andContractZhutiNotEqualTo(String value) {
            addCriterion("contract_zhuti <>", value, "contractZhuti");
            return (Criteria) this;
        }

        public Criteria andContractZhutiGreaterThan(String value) {
            addCriterion("contract_zhuti >", value, "contractZhuti");
            return (Criteria) this;
        }

        public Criteria andContractZhutiGreaterThanOrEqualTo(String value) {
            addCriterion("contract_zhuti >=", value, "contractZhuti");
            return (Criteria) this;
        }

        public Criteria andContractZhutiLessThan(String value) {
            addCriterion("contract_zhuti <", value, "contractZhuti");
            return (Criteria) this;
        }

        public Criteria andContractZhutiLessThanOrEqualTo(String value) {
            addCriterion("contract_zhuti <=", value, "contractZhuti");
            return (Criteria) this;
        }

        public Criteria andContractZhutiLike(String value) {
            addCriterion("contract_zhuti like", value, "contractZhuti");
            return (Criteria) this;
        }

        public Criteria andContractZhutiNotLike(String value) {
            addCriterion("contract_zhuti not like", value, "contractZhuti");
            return (Criteria) this;
        }

        public Criteria andContractZhutiIn(List<String> values) {
            addCriterion("contract_zhuti in", values, "contractZhuti");
            return (Criteria) this;
        }

        public Criteria andContractZhutiNotIn(List<String> values) {
            addCriterion("contract_zhuti not in", values, "contractZhuti");
            return (Criteria) this;
        }

        public Criteria andContractZhutiBetween(String value1, String value2) {
            addCriterion("contract_zhuti between", value1, value2, "contractZhuti");
            return (Criteria) this;
        }

        public Criteria andContractZhutiNotBetween(String value1, String value2) {
            addCriterion("contract_zhuti not between", value1, value2, "contractZhuti");
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

	private static final long serialVersionUID = 3537481778089396375L;


        protected Criteria() {
            super();
        }
    }

public static class Criterion implements Serializable {

	private static final long serialVersionUID = 6099069002880100523L;

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
