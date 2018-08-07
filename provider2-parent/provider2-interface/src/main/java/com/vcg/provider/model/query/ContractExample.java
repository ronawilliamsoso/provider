package com.vcg.provider.model.query;

import java.io.Serializable;
import com.vcg.common.base.BaseExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ContractExample extends BaseExample {

	private static final long serialVersionUID = 5135277631332956660L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContractExample() {
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

	private static final long serialVersionUID = 7810118532106894809L;

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

        public Criteria andContractCodeIsNull() {
            addCriterion("contract_code is null");
            return (Criteria) this;
        }

        public Criteria andContractCodeIsNotNull() {
            addCriterion("contract_code is not null");
            return (Criteria) this;
        }

        public Criteria andContractCodeEqualTo(String value) {
            addCriterion("contract_code =", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotEqualTo(String value) {
            addCriterion("contract_code <>", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeGreaterThan(String value) {
            addCriterion("contract_code >", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeGreaterThanOrEqualTo(String value) {
            addCriterion("contract_code >=", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeLessThan(String value) {
            addCriterion("contract_code <", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeLessThanOrEqualTo(String value) {
            addCriterion("contract_code <=", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeLike(String value) {
            addCriterion("contract_code like", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotLike(String value) {
            addCriterion("contract_code not like", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeIn(List<String> values) {
            addCriterion("contract_code in", values, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotIn(List<String> values) {
            addCriterion("contract_code not in", values, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeBetween(String value1, String value2) {
            addCriterion("contract_code between", value1, value2, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotBetween(String value1, String value2) {
            addCriterion("contract_code not between", value1, value2, "contractCode");
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

        public Criteria andPaymentIdIsNull() {
            addCriterion("payment_id is null");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIsNotNull() {
            addCriterion("payment_id is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentIdEqualTo(Integer value) {
            addCriterion("payment_id =", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotEqualTo(Integer value) {
            addCriterion("payment_id <>", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdGreaterThan(Integer value) {
            addCriterion("payment_id >", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("payment_id >=", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdLessThan(Integer value) {
            addCriterion("payment_id <", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdLessThanOrEqualTo(Integer value) {
            addCriterion("payment_id <=", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIn(List<Integer> values) {
            addCriterion("payment_id in", values, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotIn(List<Integer> values) {
            addCriterion("payment_id not in", values, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdBetween(Integer value1, Integer value2) {
            addCriterion("payment_id between", value1, value2, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("payment_id not between", value1, value2, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPartyBIsNull() {
            addCriterion("party_b is null");
            return (Criteria) this;
        }

        public Criteria andPartyBIsNotNull() {
            addCriterion("party_b is not null");
            return (Criteria) this;
        }

        public Criteria andPartyBEqualTo(String value) {
            addCriterion("party_b =", value, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBNotEqualTo(String value) {
            addCriterion("party_b <>", value, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBGreaterThan(String value) {
            addCriterion("party_b >", value, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBGreaterThanOrEqualTo(String value) {
            addCriterion("party_b >=", value, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBLessThan(String value) {
            addCriterion("party_b <", value, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBLessThanOrEqualTo(String value) {
            addCriterion("party_b <=", value, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBLike(String value) {
            addCriterion("party_b like", value, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBNotLike(String value) {
            addCriterion("party_b not like", value, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBIn(List<String> values) {
            addCriterion("party_b in", values, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBNotIn(List<String> values) {
            addCriterion("party_b not in", values, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBBetween(String value1, String value2) {
            addCriterion("party_b between", value1, value2, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBNotBetween(String value1, String value2) {
            addCriterion("party_b not between", value1, value2, "partyB");
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
            addCriterionForJDBCDate("sign_date =", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("sign_date <>", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateGreaterThan(Date value) {
            addCriterionForJDBCDate("sign_date >", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sign_date >=", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLessThan(Date value) {
            addCriterionForJDBCDate("sign_date <", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sign_date <=", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateIn(List<Date> values) {
            addCriterionForJDBCDate("sign_date in", values, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("sign_date not in", values, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sign_date between", value1, value2, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sign_date not between", value1, value2, "signDate");
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
            addCriterionForJDBCDate("begin_date =", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("begin_date <>", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThan(Date value) {
            addCriterionForJDBCDate("begin_date >", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("begin_date >=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThan(Date value) {
            addCriterionForJDBCDate("begin_date <", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("begin_date <=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateIn(List<Date> values) {
            addCriterionForJDBCDate("begin_date in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("begin_date not in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("begin_date between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("begin_date not between", value1, value2, "beginDate");
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
            addCriterionForJDBCDate("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date not between", value1, value2, "endDate");
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

        public Criteria andContractPdfPathIsNull() {
            addCriterion("contract_pdf_path is null");
            return (Criteria) this;
        }

        public Criteria andContractPdfPathIsNotNull() {
            addCriterion("contract_pdf_path is not null");
            return (Criteria) this;
        }

        public Criteria andContractPdfPathEqualTo(String value) {
            addCriterion("contract_pdf_path =", value, "contractPdfPath");
            return (Criteria) this;
        }

        public Criteria andContractPdfPathNotEqualTo(String value) {
            addCriterion("contract_pdf_path <>", value, "contractPdfPath");
            return (Criteria) this;
        }

        public Criteria andContractPdfPathGreaterThan(String value) {
            addCriterion("contract_pdf_path >", value, "contractPdfPath");
            return (Criteria) this;
        }

        public Criteria andContractPdfPathGreaterThanOrEqualTo(String value) {
            addCriterion("contract_pdf_path >=", value, "contractPdfPath");
            return (Criteria) this;
        }

        public Criteria andContractPdfPathLessThan(String value) {
            addCriterion("contract_pdf_path <", value, "contractPdfPath");
            return (Criteria) this;
        }

        public Criteria andContractPdfPathLessThanOrEqualTo(String value) {
            addCriterion("contract_pdf_path <=", value, "contractPdfPath");
            return (Criteria) this;
        }

        public Criteria andContractPdfPathLike(String value) {
            addCriterion("contract_pdf_path like", value, "contractPdfPath");
            return (Criteria) this;
        }

        public Criteria andContractPdfPathNotLike(String value) {
            addCriterion("contract_pdf_path not like", value, "contractPdfPath");
            return (Criteria) this;
        }

        public Criteria andContractPdfPathIn(List<String> values) {
            addCriterion("contract_pdf_path in", values, "contractPdfPath");
            return (Criteria) this;
        }

        public Criteria andContractPdfPathNotIn(List<String> values) {
            addCriterion("contract_pdf_path not in", values, "contractPdfPath");
            return (Criteria) this;
        }

        public Criteria andContractPdfPathBetween(String value1, String value2) {
            addCriterion("contract_pdf_path between", value1, value2, "contractPdfPath");
            return (Criteria) this;
        }

        public Criteria andContractPdfPathNotBetween(String value1, String value2) {
            addCriterion("contract_pdf_path not between", value1, value2, "contractPdfPath");
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

        public Criteria andPartyAIsNull() {
            addCriterion("party_a is null");
            return (Criteria) this;
        }

        public Criteria andPartyAIsNotNull() {
            addCriterion("party_a is not null");
            return (Criteria) this;
        }

        public Criteria andPartyAEqualTo(String value) {
            addCriterion("party_a =", value, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyANotEqualTo(String value) {
            addCriterion("party_a <>", value, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyAGreaterThan(String value) {
            addCriterion("party_a >", value, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyAGreaterThanOrEqualTo(String value) {
            addCriterion("party_a >=", value, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyALessThan(String value) {
            addCriterion("party_a <", value, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyALessThanOrEqualTo(String value) {
            addCriterion("party_a <=", value, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyALike(String value) {
            addCriterion("party_a like", value, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyANotLike(String value) {
            addCriterion("party_a not like", value, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyAIn(List<String> values) {
            addCriterion("party_a in", values, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyANotIn(List<String> values) {
            addCriterion("party_a not in", values, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyABetween(String value1, String value2) {
            addCriterion("party_a between", value1, value2, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyANotBetween(String value1, String value2) {
            addCriterion("party_a not between", value1, value2, "partyA");
            return (Criteria) this;
        }

        public Criteria andElectronicStampIsNull() {
            addCriterion("electronic_stamp is null");
            return (Criteria) this;
        }

        public Criteria andElectronicStampIsNotNull() {
            addCriterion("electronic_stamp is not null");
            return (Criteria) this;
        }

        public Criteria andElectronicStampEqualTo(String value) {
            addCriterion("electronic_stamp =", value, "electronicStamp");
            return (Criteria) this;
        }

        public Criteria andElectronicStampNotEqualTo(String value) {
            addCriterion("electronic_stamp <>", value, "electronicStamp");
            return (Criteria) this;
        }

        public Criteria andElectronicStampGreaterThan(String value) {
            addCriterion("electronic_stamp >", value, "electronicStamp");
            return (Criteria) this;
        }

        public Criteria andElectronicStampGreaterThanOrEqualTo(String value) {
            addCriterion("electronic_stamp >=", value, "electronicStamp");
            return (Criteria) this;
        }

        public Criteria andElectronicStampLessThan(String value) {
            addCriterion("electronic_stamp <", value, "electronicStamp");
            return (Criteria) this;
        }

        public Criteria andElectronicStampLessThanOrEqualTo(String value) {
            addCriterion("electronic_stamp <=", value, "electronicStamp");
            return (Criteria) this;
        }

        public Criteria andElectronicStampLike(String value) {
            addCriterion("electronic_stamp like", value, "electronicStamp");
            return (Criteria) this;
        }

        public Criteria andElectronicStampNotLike(String value) {
            addCriterion("electronic_stamp not like", value, "electronicStamp");
            return (Criteria) this;
        }

        public Criteria andElectronicStampIn(List<String> values) {
            addCriterion("electronic_stamp in", values, "electronicStamp");
            return (Criteria) this;
        }

        public Criteria andElectronicStampNotIn(List<String> values) {
            addCriterion("electronic_stamp not in", values, "electronicStamp");
            return (Criteria) this;
        }

        public Criteria andElectronicStampBetween(String value1, String value2) {
            addCriterion("electronic_stamp between", value1, value2, "electronicStamp");
            return (Criteria) this;
        }

        public Criteria andElectronicStampNotBetween(String value1, String value2) {
            addCriterion("electronic_stamp not between", value1, value2, "electronicStamp");
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

        public Criteria andExclusiveAuthEqualTo(Integer value) {
            addCriterion("exclusive_auth =", value, "exclusiveAuth");
            return (Criteria) this;
        }

        public Criteria andExclusiveAuthNotEqualTo(Integer value) {
            addCriterion("exclusive_auth <>", value, "exclusiveAuth");
            return (Criteria) this;
        }

        public Criteria andExclusiveAuthGreaterThan(Integer value) {
            addCriterion("exclusive_auth >", value, "exclusiveAuth");
            return (Criteria) this;
        }

        public Criteria andExclusiveAuthGreaterThanOrEqualTo(Integer value) {
            addCriterion("exclusive_auth >=", value, "exclusiveAuth");
            return (Criteria) this;
        }

        public Criteria andExclusiveAuthLessThan(Integer value) {
            addCriterion("exclusive_auth <", value, "exclusiveAuth");
            return (Criteria) this;
        }

        public Criteria andExclusiveAuthLessThanOrEqualTo(Integer value) {
            addCriterion("exclusive_auth <=", value, "exclusiveAuth");
            return (Criteria) this;
        }

        public Criteria andExclusiveAuthIn(List<Integer> values) {
            addCriterion("exclusive_auth in", values, "exclusiveAuth");
            return (Criteria) this;
        }

        public Criteria andExclusiveAuthNotIn(List<Integer> values) {
            addCriterion("exclusive_auth not in", values, "exclusiveAuth");
            return (Criteria) this;
        }

        public Criteria andExclusiveAuthBetween(Integer value1, Integer value2) {
            addCriterion("exclusive_auth between", value1, value2, "exclusiveAuth");
            return (Criteria) this;
        }

        public Criteria andExclusiveAuthNotBetween(Integer value1, Integer value2) {
            addCriterion("exclusive_auth not between", value1, value2, "exclusiveAuth");
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

        public Criteria andLeftDaysIsNull() {
            addCriterion("left_days is null");
            return (Criteria) this;
        }

        public Criteria andLeftDaysIsNotNull() {
            addCriterion("left_days is not null");
            return (Criteria) this;
        }

        public Criteria andLeftDaysEqualTo(Integer value) {
            addCriterion("left_days =", value, "leftDays");
            return (Criteria) this;
        }

        public Criteria andLeftDaysNotEqualTo(Integer value) {
            addCriterion("left_days <>", value, "leftDays");
            return (Criteria) this;
        }

        public Criteria andLeftDaysGreaterThan(Integer value) {
            addCriterion("left_days >", value, "leftDays");
            return (Criteria) this;
        }

        public Criteria andLeftDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("left_days >=", value, "leftDays");
            return (Criteria) this;
        }

        public Criteria andLeftDaysLessThan(Integer value) {
            addCriterion("left_days <", value, "leftDays");
            return (Criteria) this;
        }

        public Criteria andLeftDaysLessThanOrEqualTo(Integer value) {
            addCriterion("left_days <=", value, "leftDays");
            return (Criteria) this;
        }

        public Criteria andLeftDaysIn(List<Integer> values) {
            addCriterion("left_days in", values, "leftDays");
            return (Criteria) this;
        }

        public Criteria andLeftDaysNotIn(List<Integer> values) {
            addCriterion("left_days not in", values, "leftDays");
            return (Criteria) this;
        }

        public Criteria andLeftDaysBetween(Integer value1, Integer value2) {
            addCriterion("left_days between", value1, value2, "leftDays");
            return (Criteria) this;
        }

        public Criteria andLeftDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("left_days not between", value1, value2, "leftDays");
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
    }

public static class Criteria extends GeneratedCriteria implements Serializable {

	private static final long serialVersionUID = 1627366261141749162L;


        protected Criteria() {
            super();
        }
    }

public static class Criterion implements Serializable {

	private static final long serialVersionUID = 140366771956685113L;

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
