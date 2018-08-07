package com.vcg.provider.model.query;

import java.io.Serializable;
import com.vcg.common.base.BaseExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportDataconfirmExample extends BaseExample {

	private static final long serialVersionUID = 381257980768802257L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReportDataconfirmExample() {
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

	private static final long serialVersionUID = 8420070590047896067L;

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

        public Criteria andMonthIsNull() {
            addCriterion("month is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("month is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(String value) {
            addCriterion("month =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(String value) {
            addCriterion("month <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(String value) {
            addCriterion("month >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(String value) {
            addCriterion("month >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(String value) {
            addCriterion("month <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(String value) {
            addCriterion("month <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLike(String value) {
            addCriterion("month like", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotLike(String value) {
            addCriterion("month not like", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<String> values) {
            addCriterion("month in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<String> values) {
            addCriterion("month not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(String value1, String value2) {
            addCriterion("month between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(String value1, String value2) {
            addCriterion("month not between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(String value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(String value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(String value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(String value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(String value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(String value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLike(String value) {
            addCriterion("year like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotLike(String value) {
            addCriterion("year not like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<String> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<String> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(String value1, String value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(String value1, String value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andReportMonthIsNull() {
            addCriterion("report_month is null");
            return (Criteria) this;
        }

        public Criteria andReportMonthIsNotNull() {
            addCriterion("report_month is not null");
            return (Criteria) this;
        }

        public Criteria andReportMonthEqualTo(String value) {
            addCriterion("report_month =", value, "reportMonth");
            return (Criteria) this;
        }

        public Criteria andReportMonthNotEqualTo(String value) {
            addCriterion("report_month <>", value, "reportMonth");
            return (Criteria) this;
        }

        public Criteria andReportMonthGreaterThan(String value) {
            addCriterion("report_month >", value, "reportMonth");
            return (Criteria) this;
        }

        public Criteria andReportMonthGreaterThanOrEqualTo(String value) {
            addCriterion("report_month >=", value, "reportMonth");
            return (Criteria) this;
        }

        public Criteria andReportMonthLessThan(String value) {
            addCriterion("report_month <", value, "reportMonth");
            return (Criteria) this;
        }

        public Criteria andReportMonthLessThanOrEqualTo(String value) {
            addCriterion("report_month <=", value, "reportMonth");
            return (Criteria) this;
        }

        public Criteria andReportMonthLike(String value) {
            addCriterion("report_month like", value, "reportMonth");
            return (Criteria) this;
        }

        public Criteria andReportMonthNotLike(String value) {
            addCriterion("report_month not like", value, "reportMonth");
            return (Criteria) this;
        }

        public Criteria andReportMonthIn(List<String> values) {
            addCriterion("report_month in", values, "reportMonth");
            return (Criteria) this;
        }

        public Criteria andReportMonthNotIn(List<String> values) {
            addCriterion("report_month not in", values, "reportMonth");
            return (Criteria) this;
        }

        public Criteria andReportMonthBetween(String value1, String value2) {
            addCriterion("report_month between", value1, value2, "reportMonth");
            return (Criteria) this;
        }

        public Criteria andReportMonthNotBetween(String value1, String value2) {
            addCriterion("report_month not between", value1, value2, "reportMonth");
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

        public Criteria andIsPublishedIsNull() {
            addCriterion("is_published is null");
            return (Criteria) this;
        }

        public Criteria andIsPublishedIsNotNull() {
            addCriterion("is_published is not null");
            return (Criteria) this;
        }

        public Criteria andIsPublishedEqualTo(Integer value) {
            addCriterion("is_published =", value, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedNotEqualTo(Integer value) {
            addCriterion("is_published <>", value, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedGreaterThan(Integer value) {
            addCriterion("is_published >", value, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_published >=", value, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedLessThan(Integer value) {
            addCriterion("is_published <", value, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedLessThanOrEqualTo(Integer value) {
            addCriterion("is_published <=", value, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedIn(List<Integer> values) {
            addCriterion("is_published in", values, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedNotIn(List<Integer> values) {
            addCriterion("is_published not in", values, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedBetween(Integer value1, Integer value2) {
            addCriterion("is_published between", value1, value2, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_published not between", value1, value2, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsConfirmedIsNull() {
            addCriterion("is_confirmed is null");
            return (Criteria) this;
        }

        public Criteria andIsConfirmedIsNotNull() {
            addCriterion("is_confirmed is not null");
            return (Criteria) this;
        }

        public Criteria andIsConfirmedEqualTo(Integer value) {
            addCriterion("is_confirmed =", value, "isConfirmed");
            return (Criteria) this;
        }

        public Criteria andIsConfirmedNotEqualTo(Integer value) {
            addCriterion("is_confirmed <>", value, "isConfirmed");
            return (Criteria) this;
        }

        public Criteria andIsConfirmedGreaterThan(Integer value) {
            addCriterion("is_confirmed >", value, "isConfirmed");
            return (Criteria) this;
        }

        public Criteria andIsConfirmedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_confirmed >=", value, "isConfirmed");
            return (Criteria) this;
        }

        public Criteria andIsConfirmedLessThan(Integer value) {
            addCriterion("is_confirmed <", value, "isConfirmed");
            return (Criteria) this;
        }

        public Criteria andIsConfirmedLessThanOrEqualTo(Integer value) {
            addCriterion("is_confirmed <=", value, "isConfirmed");
            return (Criteria) this;
        }

        public Criteria andIsConfirmedIn(List<Integer> values) {
            addCriterion("is_confirmed in", values, "isConfirmed");
            return (Criteria) this;
        }

        public Criteria andIsConfirmedNotIn(List<Integer> values) {
            addCriterion("is_confirmed not in", values, "isConfirmed");
            return (Criteria) this;
        }

        public Criteria andIsConfirmedBetween(Integer value1, Integer value2) {
            addCriterion("is_confirmed between", value1, value2, "isConfirmed");
            return (Criteria) this;
        }

        public Criteria andIsConfirmedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_confirmed not between", value1, value2, "isConfirmed");
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

        public Criteria andReceiptConfirmedIsNull() {
            addCriterion("receipt_confirmed is null");
            return (Criteria) this;
        }

        public Criteria andReceiptConfirmedIsNotNull() {
            addCriterion("receipt_confirmed is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptConfirmedEqualTo(Integer value) {
            addCriterion("receipt_confirmed =", value, "receiptConfirmed");
            return (Criteria) this;
        }

        public Criteria andReceiptConfirmedNotEqualTo(Integer value) {
            addCriterion("receipt_confirmed <>", value, "receiptConfirmed");
            return (Criteria) this;
        }

        public Criteria andReceiptConfirmedGreaterThan(Integer value) {
            addCriterion("receipt_confirmed >", value, "receiptConfirmed");
            return (Criteria) this;
        }

        public Criteria andReceiptConfirmedGreaterThanOrEqualTo(Integer value) {
            addCriterion("receipt_confirmed >=", value, "receiptConfirmed");
            return (Criteria) this;
        }

        public Criteria andReceiptConfirmedLessThan(Integer value) {
            addCriterion("receipt_confirmed <", value, "receiptConfirmed");
            return (Criteria) this;
        }

        public Criteria andReceiptConfirmedLessThanOrEqualTo(Integer value) {
            addCriterion("receipt_confirmed <=", value, "receiptConfirmed");
            return (Criteria) this;
        }

        public Criteria andReceiptConfirmedIn(List<Integer> values) {
            addCriterion("receipt_confirmed in", values, "receiptConfirmed");
            return (Criteria) this;
        }

        public Criteria andReceiptConfirmedNotIn(List<Integer> values) {
            addCriterion("receipt_confirmed not in", values, "receiptConfirmed");
            return (Criteria) this;
        }

        public Criteria andReceiptConfirmedBetween(Integer value1, Integer value2) {
            addCriterion("receipt_confirmed between", value1, value2, "receiptConfirmed");
            return (Criteria) this;
        }

        public Criteria andReceiptConfirmedNotBetween(Integer value1, Integer value2) {
            addCriterion("receipt_confirmed not between", value1, value2, "receiptConfirmed");
            return (Criteria) this;
        }

        public Criteria andReportPathIsNull() {
            addCriterion("report_path is null");
            return (Criteria) this;
        }

        public Criteria andReportPathIsNotNull() {
            addCriterion("report_path is not null");
            return (Criteria) this;
        }

        public Criteria andReportPathEqualTo(String value) {
            addCriterion("report_path =", value, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathNotEqualTo(String value) {
            addCriterion("report_path <>", value, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathGreaterThan(String value) {
            addCriterion("report_path >", value, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathGreaterThanOrEqualTo(String value) {
            addCriterion("report_path >=", value, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathLessThan(String value) {
            addCriterion("report_path <", value, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathLessThanOrEqualTo(String value) {
            addCriterion("report_path <=", value, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathLike(String value) {
            addCriterion("report_path like", value, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathNotLike(String value) {
            addCriterion("report_path not like", value, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathIn(List<String> values) {
            addCriterion("report_path in", values, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathNotIn(List<String> values) {
            addCriterion("report_path not in", values, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathBetween(String value1, String value2) {
            addCriterion("report_path between", value1, value2, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathNotBetween(String value1, String value2) {
            addCriterion("report_path not between", value1, value2, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReceiptPathIsNull() {
            addCriterion("receipt_path is null");
            return (Criteria) this;
        }

        public Criteria andReceiptPathIsNotNull() {
            addCriterion("receipt_path is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptPathEqualTo(String value) {
            addCriterion("receipt_path =", value, "receiptPath");
            return (Criteria) this;
        }

        public Criteria andReceiptPathNotEqualTo(String value) {
            addCriterion("receipt_path <>", value, "receiptPath");
            return (Criteria) this;
        }

        public Criteria andReceiptPathGreaterThan(String value) {
            addCriterion("receipt_path >", value, "receiptPath");
            return (Criteria) this;
        }

        public Criteria andReceiptPathGreaterThanOrEqualTo(String value) {
            addCriterion("receipt_path >=", value, "receiptPath");
            return (Criteria) this;
        }

        public Criteria andReceiptPathLessThan(String value) {
            addCriterion("receipt_path <", value, "receiptPath");
            return (Criteria) this;
        }

        public Criteria andReceiptPathLessThanOrEqualTo(String value) {
            addCriterion("receipt_path <=", value, "receiptPath");
            return (Criteria) this;
        }

        public Criteria andReceiptPathLike(String value) {
            addCriterion("receipt_path like", value, "receiptPath");
            return (Criteria) this;
        }

        public Criteria andReceiptPathNotLike(String value) {
            addCriterion("receipt_path not like", value, "receiptPath");
            return (Criteria) this;
        }

        public Criteria andReceiptPathIn(List<String> values) {
            addCriterion("receipt_path in", values, "receiptPath");
            return (Criteria) this;
        }

        public Criteria andReceiptPathNotIn(List<String> values) {
            addCriterion("receipt_path not in", values, "receiptPath");
            return (Criteria) this;
        }

        public Criteria andReceiptPathBetween(String value1, String value2) {
            addCriterion("receipt_path between", value1, value2, "receiptPath");
            return (Criteria) this;
        }

        public Criteria andReceiptPathNotBetween(String value1, String value2) {
            addCriterion("receipt_path not between", value1, value2, "receiptPath");
            return (Criteria) this;
        }

        public Criteria andReportUploaddateIsNull() {
            addCriterion("report_uploaddate is null");
            return (Criteria) this;
        }

        public Criteria andReportUploaddateIsNotNull() {
            addCriterion("report_uploaddate is not null");
            return (Criteria) this;
        }

        public Criteria andReportUploaddateEqualTo(Date value) {
            addCriterion("report_uploaddate =", value, "reportUploaddate");
            return (Criteria) this;
        }

        public Criteria andReportUploaddateNotEqualTo(Date value) {
            addCriterion("report_uploaddate <>", value, "reportUploaddate");
            return (Criteria) this;
        }

        public Criteria andReportUploaddateGreaterThan(Date value) {
            addCriterion("report_uploaddate >", value, "reportUploaddate");
            return (Criteria) this;
        }

        public Criteria andReportUploaddateGreaterThanOrEqualTo(Date value) {
            addCriterion("report_uploaddate >=", value, "reportUploaddate");
            return (Criteria) this;
        }

        public Criteria andReportUploaddateLessThan(Date value) {
            addCriterion("report_uploaddate <", value, "reportUploaddate");
            return (Criteria) this;
        }

        public Criteria andReportUploaddateLessThanOrEqualTo(Date value) {
            addCriterion("report_uploaddate <=", value, "reportUploaddate");
            return (Criteria) this;
        }

        public Criteria andReportUploaddateIn(List<Date> values) {
            addCriterion("report_uploaddate in", values, "reportUploaddate");
            return (Criteria) this;
        }

        public Criteria andReportUploaddateNotIn(List<Date> values) {
            addCriterion("report_uploaddate not in", values, "reportUploaddate");
            return (Criteria) this;
        }

        public Criteria andReportUploaddateBetween(Date value1, Date value2) {
            addCriterion("report_uploaddate between", value1, value2, "reportUploaddate");
            return (Criteria) this;
        }

        public Criteria andReportUploaddateNotBetween(Date value1, Date value2) {
            addCriterion("report_uploaddate not between", value1, value2, "reportUploaddate");
            return (Criteria) this;
        }

        public Criteria andReceiptUploaddateIsNull() {
            addCriterion("receipt_uploaddate is null");
            return (Criteria) this;
        }

        public Criteria andReceiptUploaddateIsNotNull() {
            addCriterion("receipt_uploaddate is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptUploaddateEqualTo(Date value) {
            addCriterion("receipt_uploaddate =", value, "receiptUploaddate");
            return (Criteria) this;
        }

        public Criteria andReceiptUploaddateNotEqualTo(Date value) {
            addCriterion("receipt_uploaddate <>", value, "receiptUploaddate");
            return (Criteria) this;
        }

        public Criteria andReceiptUploaddateGreaterThan(Date value) {
            addCriterion("receipt_uploaddate >", value, "receiptUploaddate");
            return (Criteria) this;
        }

        public Criteria andReceiptUploaddateGreaterThanOrEqualTo(Date value) {
            addCriterion("receipt_uploaddate >=", value, "receiptUploaddate");
            return (Criteria) this;
        }

        public Criteria andReceiptUploaddateLessThan(Date value) {
            addCriterion("receipt_uploaddate <", value, "receiptUploaddate");
            return (Criteria) this;
        }

        public Criteria andReceiptUploaddateLessThanOrEqualTo(Date value) {
            addCriterion("receipt_uploaddate <=", value, "receiptUploaddate");
            return (Criteria) this;
        }

        public Criteria andReceiptUploaddateIn(List<Date> values) {
            addCriterion("receipt_uploaddate in", values, "receiptUploaddate");
            return (Criteria) this;
        }

        public Criteria andReceiptUploaddateNotIn(List<Date> values) {
            addCriterion("receipt_uploaddate not in", values, "receiptUploaddate");
            return (Criteria) this;
        }

        public Criteria andReceiptUploaddateBetween(Date value1, Date value2) {
            addCriterion("receipt_uploaddate between", value1, value2, "receiptUploaddate");
            return (Criteria) this;
        }

        public Criteria andReceiptUploaddateNotBetween(Date value1, Date value2) {
            addCriterion("receipt_uploaddate not between", value1, value2, "receiptUploaddate");
            return (Criteria) this;
        }

        public Criteria andReportConfirmdateIsNull() {
            addCriterion("report_confirmdate is null");
            return (Criteria) this;
        }

        public Criteria andReportConfirmdateIsNotNull() {
            addCriterion("report_confirmdate is not null");
            return (Criteria) this;
        }

        public Criteria andReportConfirmdateEqualTo(Date value) {
            addCriterion("report_confirmdate =", value, "reportConfirmdate");
            return (Criteria) this;
        }

        public Criteria andReportConfirmdateNotEqualTo(Date value) {
            addCriterion("report_confirmdate <>", value, "reportConfirmdate");
            return (Criteria) this;
        }

        public Criteria andReportConfirmdateGreaterThan(Date value) {
            addCriterion("report_confirmdate >", value, "reportConfirmdate");
            return (Criteria) this;
        }

        public Criteria andReportConfirmdateGreaterThanOrEqualTo(Date value) {
            addCriterion("report_confirmdate >=", value, "reportConfirmdate");
            return (Criteria) this;
        }

        public Criteria andReportConfirmdateLessThan(Date value) {
            addCriterion("report_confirmdate <", value, "reportConfirmdate");
            return (Criteria) this;
        }

        public Criteria andReportConfirmdateLessThanOrEqualTo(Date value) {
            addCriterion("report_confirmdate <=", value, "reportConfirmdate");
            return (Criteria) this;
        }

        public Criteria andReportConfirmdateIn(List<Date> values) {
            addCriterion("report_confirmdate in", values, "reportConfirmdate");
            return (Criteria) this;
        }

        public Criteria andReportConfirmdateNotIn(List<Date> values) {
            addCriterion("report_confirmdate not in", values, "reportConfirmdate");
            return (Criteria) this;
        }

        public Criteria andReportConfirmdateBetween(Date value1, Date value2) {
            addCriterion("report_confirmdate between", value1, value2, "reportConfirmdate");
            return (Criteria) this;
        }

        public Criteria andReportConfirmdateNotBetween(Date value1, Date value2) {
            addCriterion("report_confirmdate not between", value1, value2, "reportConfirmdate");
            return (Criteria) this;
        }

        public Criteria andReceiptConfirmdateIsNull() {
            addCriterion("receipt_confirmdate is null");
            return (Criteria) this;
        }

        public Criteria andReceiptConfirmdateIsNotNull() {
            addCriterion("receipt_confirmdate is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptConfirmdateEqualTo(Date value) {
            addCriterion("receipt_confirmdate =", value, "receiptConfirmdate");
            return (Criteria) this;
        }

        public Criteria andReceiptConfirmdateNotEqualTo(Date value) {
            addCriterion("receipt_confirmdate <>", value, "receiptConfirmdate");
            return (Criteria) this;
        }

        public Criteria andReceiptConfirmdateGreaterThan(Date value) {
            addCriterion("receipt_confirmdate >", value, "receiptConfirmdate");
            return (Criteria) this;
        }

        public Criteria andReceiptConfirmdateGreaterThanOrEqualTo(Date value) {
            addCriterion("receipt_confirmdate >=", value, "receiptConfirmdate");
            return (Criteria) this;
        }

        public Criteria andReceiptConfirmdateLessThan(Date value) {
            addCriterion("receipt_confirmdate <", value, "receiptConfirmdate");
            return (Criteria) this;
        }

        public Criteria andReceiptConfirmdateLessThanOrEqualTo(Date value) {
            addCriterion("receipt_confirmdate <=", value, "receiptConfirmdate");
            return (Criteria) this;
        }

        public Criteria andReceiptConfirmdateIn(List<Date> values) {
            addCriterion("receipt_confirmdate in", values, "receiptConfirmdate");
            return (Criteria) this;
        }

        public Criteria andReceiptConfirmdateNotIn(List<Date> values) {
            addCriterion("receipt_confirmdate not in", values, "receiptConfirmdate");
            return (Criteria) this;
        }

        public Criteria andReceiptConfirmdateBetween(Date value1, Date value2) {
            addCriterion("receipt_confirmdate between", value1, value2, "receiptConfirmdate");
            return (Criteria) this;
        }

        public Criteria andReceiptConfirmdateNotBetween(Date value1, Date value2) {
            addCriterion("receipt_confirmdate not between", value1, value2, "receiptConfirmdate");
            return (Criteria) this;
        }

        public Criteria andIsPaidIsNull() {
            addCriterion("is_paid is null");
            return (Criteria) this;
        }

        public Criteria andIsPaidIsNotNull() {
            addCriterion("is_paid is not null");
            return (Criteria) this;
        }

        public Criteria andIsPaidEqualTo(Integer value) {
            addCriterion("is_paid =", value, "isPaid");
            return (Criteria) this;
        }

        public Criteria andIsPaidNotEqualTo(Integer value) {
            addCriterion("is_paid <>", value, "isPaid");
            return (Criteria) this;
        }

        public Criteria andIsPaidGreaterThan(Integer value) {
            addCriterion("is_paid >", value, "isPaid");
            return (Criteria) this;
        }

        public Criteria andIsPaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_paid >=", value, "isPaid");
            return (Criteria) this;
        }

        public Criteria andIsPaidLessThan(Integer value) {
            addCriterion("is_paid <", value, "isPaid");
            return (Criteria) this;
        }

        public Criteria andIsPaidLessThanOrEqualTo(Integer value) {
            addCriterion("is_paid <=", value, "isPaid");
            return (Criteria) this;
        }

        public Criteria andIsPaidIn(List<Integer> values) {
            addCriterion("is_paid in", values, "isPaid");
            return (Criteria) this;
        }

        public Criteria andIsPaidNotIn(List<Integer> values) {
            addCriterion("is_paid not in", values, "isPaid");
            return (Criteria) this;
        }

        public Criteria andIsPaidBetween(Integer value1, Integer value2) {
            addCriterion("is_paid between", value1, value2, "isPaid");
            return (Criteria) this;
        }

        public Criteria andIsPaidNotBetween(Integer value1, Integer value2) {
            addCriterion("is_paid not between", value1, value2, "isPaid");
            return (Criteria) this;
        }

        public Criteria andPaidDateIsNull() {
            addCriterion("paid_date is null");
            return (Criteria) this;
        }

        public Criteria andPaidDateIsNotNull() {
            addCriterion("paid_date is not null");
            return (Criteria) this;
        }

        public Criteria andPaidDateEqualTo(Date value) {
            addCriterion("paid_date =", value, "paidDate");
            return (Criteria) this;
        }

        public Criteria andPaidDateNotEqualTo(Date value) {
            addCriterion("paid_date <>", value, "paidDate");
            return (Criteria) this;
        }

        public Criteria andPaidDateGreaterThan(Date value) {
            addCriterion("paid_date >", value, "paidDate");
            return (Criteria) this;
        }

        public Criteria andPaidDateGreaterThanOrEqualTo(Date value) {
            addCriterion("paid_date >=", value, "paidDate");
            return (Criteria) this;
        }

        public Criteria andPaidDateLessThan(Date value) {
            addCriterion("paid_date <", value, "paidDate");
            return (Criteria) this;
        }

        public Criteria andPaidDateLessThanOrEqualTo(Date value) {
            addCriterion("paid_date <=", value, "paidDate");
            return (Criteria) this;
        }

        public Criteria andPaidDateIn(List<Date> values) {
            addCriterion("paid_date in", values, "paidDate");
            return (Criteria) this;
        }

        public Criteria andPaidDateNotIn(List<Date> values) {
            addCriterion("paid_date not in", values, "paidDate");
            return (Criteria) this;
        }

        public Criteria andPaidDateBetween(Date value1, Date value2) {
            addCriterion("paid_date between", value1, value2, "paidDate");
            return (Criteria) this;
        }

        public Criteria andPaidDateNotBetween(Date value1, Date value2) {
            addCriterion("paid_date not between", value1, value2, "paidDate");
            return (Criteria) this;
        }

        public Criteria andReportOriginalnameIsNull() {
            addCriterion("report_originalname is null");
            return (Criteria) this;
        }

        public Criteria andReportOriginalnameIsNotNull() {
            addCriterion("report_originalname is not null");
            return (Criteria) this;
        }

        public Criteria andReportOriginalnameEqualTo(String value) {
            addCriterion("report_originalname =", value, "reportOriginalname");
            return (Criteria) this;
        }

        public Criteria andReportOriginalnameNotEqualTo(String value) {
            addCriterion("report_originalname <>", value, "reportOriginalname");
            return (Criteria) this;
        }

        public Criteria andReportOriginalnameGreaterThan(String value) {
            addCriterion("report_originalname >", value, "reportOriginalname");
            return (Criteria) this;
        }

        public Criteria andReportOriginalnameGreaterThanOrEqualTo(String value) {
            addCriterion("report_originalname >=", value, "reportOriginalname");
            return (Criteria) this;
        }

        public Criteria andReportOriginalnameLessThan(String value) {
            addCriterion("report_originalname <", value, "reportOriginalname");
            return (Criteria) this;
        }

        public Criteria andReportOriginalnameLessThanOrEqualTo(String value) {
            addCriterion("report_originalname <=", value, "reportOriginalname");
            return (Criteria) this;
        }

        public Criteria andReportOriginalnameLike(String value) {
            addCriterion("report_originalname like", value, "reportOriginalname");
            return (Criteria) this;
        }

        public Criteria andReportOriginalnameNotLike(String value) {
            addCriterion("report_originalname not like", value, "reportOriginalname");
            return (Criteria) this;
        }

        public Criteria andReportOriginalnameIn(List<String> values) {
            addCriterion("report_originalname in", values, "reportOriginalname");
            return (Criteria) this;
        }

        public Criteria andReportOriginalnameNotIn(List<String> values) {
            addCriterion("report_originalname not in", values, "reportOriginalname");
            return (Criteria) this;
        }

        public Criteria andReportOriginalnameBetween(String value1, String value2) {
            addCriterion("report_originalname between", value1, value2, "reportOriginalname");
            return (Criteria) this;
        }

        public Criteria andReportOriginalnameNotBetween(String value1, String value2) {
            addCriterion("report_originalname not between", value1, value2, "reportOriginalname");
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

	private static final long serialVersionUID = 5644740672080953305L;


        protected Criteria() {
            super();
        }
    }

public static class Criterion implements Serializable {

	private static final long serialVersionUID = 4294276244001984589L;

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
