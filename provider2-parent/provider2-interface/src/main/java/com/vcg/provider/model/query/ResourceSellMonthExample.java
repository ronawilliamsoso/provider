package com.vcg.provider.model.query;

import java.io.Serializable;
import com.vcg.common.base.BaseExample;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResourceSellMonthExample extends BaseExample {

	private static final long serialVersionUID = 5554486519136130907L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourceSellMonthExample() {
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

	private static final long serialVersionUID = 169182337312953157L;

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

        public Criteria andSellTotalIsNull() {
            addCriterion("sell_total is null");
            return (Criteria) this;
        }

        public Criteria andSellTotalIsNotNull() {
            addCriterion("sell_total is not null");
            return (Criteria) this;
        }

        public Criteria andSellTotalEqualTo(BigDecimal value) {
            addCriterion("sell_total =", value, "sellTotal");
            return (Criteria) this;
        }

        public Criteria andSellTotalNotEqualTo(BigDecimal value) {
            addCriterion("sell_total <>", value, "sellTotal");
            return (Criteria) this;
        }

        public Criteria andSellTotalGreaterThan(BigDecimal value) {
            addCriterion("sell_total >", value, "sellTotal");
            return (Criteria) this;
        }

        public Criteria andSellTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sell_total >=", value, "sellTotal");
            return (Criteria) this;
        }

        public Criteria andSellTotalLessThan(BigDecimal value) {
            addCriterion("sell_total <", value, "sellTotal");
            return (Criteria) this;
        }

        public Criteria andSellTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sell_total <=", value, "sellTotal");
            return (Criteria) this;
        }

        public Criteria andSellTotalIn(List<BigDecimal> values) {
            addCriterion("sell_total in", values, "sellTotal");
            return (Criteria) this;
        }

        public Criteria andSellTotalNotIn(List<BigDecimal> values) {
            addCriterion("sell_total not in", values, "sellTotal");
            return (Criteria) this;
        }

        public Criteria andSellTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sell_total between", value1, value2, "sellTotal");
            return (Criteria) this;
        }

        public Criteria andSellTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sell_total not between", value1, value2, "sellTotal");
            return (Criteria) this;
        }

        public Criteria andSellTotalusIsNull() {
            addCriterion("sell_totalus is null");
            return (Criteria) this;
        }

        public Criteria andSellTotalusIsNotNull() {
            addCriterion("sell_totalus is not null");
            return (Criteria) this;
        }

        public Criteria andSellTotalusEqualTo(BigDecimal value) {
            addCriterion("sell_totalus =", value, "sellTotalus");
            return (Criteria) this;
        }

        public Criteria andSellTotalusNotEqualTo(BigDecimal value) {
            addCriterion("sell_totalus <>", value, "sellTotalus");
            return (Criteria) this;
        }

        public Criteria andSellTotalusGreaterThan(BigDecimal value) {
            addCriterion("sell_totalus >", value, "sellTotalus");
            return (Criteria) this;
        }

        public Criteria andSellTotalusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sell_totalus >=", value, "sellTotalus");
            return (Criteria) this;
        }

        public Criteria andSellTotalusLessThan(BigDecimal value) {
            addCriterion("sell_totalus <", value, "sellTotalus");
            return (Criteria) this;
        }

        public Criteria andSellTotalusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sell_totalus <=", value, "sellTotalus");
            return (Criteria) this;
        }

        public Criteria andSellTotalusIn(List<BigDecimal> values) {
            addCriterion("sell_totalus in", values, "sellTotalus");
            return (Criteria) this;
        }

        public Criteria andSellTotalusNotIn(List<BigDecimal> values) {
            addCriterion("sell_totalus not in", values, "sellTotalus");
            return (Criteria) this;
        }

        public Criteria andSellTotalusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sell_totalus between", value1, value2, "sellTotalus");
            return (Criteria) this;
        }

        public Criteria andSellTotalusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sell_totalus not between", value1, value2, "sellTotalus");
            return (Criteria) this;
        }

        public Criteria andShareTotalIsNull() {
            addCriterion("share_total is null");
            return (Criteria) this;
        }

        public Criteria andShareTotalIsNotNull() {
            addCriterion("share_total is not null");
            return (Criteria) this;
        }

        public Criteria andShareTotalEqualTo(BigDecimal value) {
            addCriterion("share_total =", value, "shareTotal");
            return (Criteria) this;
        }

        public Criteria andShareTotalNotEqualTo(BigDecimal value) {
            addCriterion("share_total <>", value, "shareTotal");
            return (Criteria) this;
        }

        public Criteria andShareTotalGreaterThan(BigDecimal value) {
            addCriterion("share_total >", value, "shareTotal");
            return (Criteria) this;
        }

        public Criteria andShareTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("share_total >=", value, "shareTotal");
            return (Criteria) this;
        }

        public Criteria andShareTotalLessThan(BigDecimal value) {
            addCriterion("share_total <", value, "shareTotal");
            return (Criteria) this;
        }

        public Criteria andShareTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("share_total <=", value, "shareTotal");
            return (Criteria) this;
        }

        public Criteria andShareTotalIn(List<BigDecimal> values) {
            addCriterion("share_total in", values, "shareTotal");
            return (Criteria) this;
        }

        public Criteria andShareTotalNotIn(List<BigDecimal> values) {
            addCriterion("share_total not in", values, "shareTotal");
            return (Criteria) this;
        }

        public Criteria andShareTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("share_total between", value1, value2, "shareTotal");
            return (Criteria) this;
        }

        public Criteria andShareTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("share_total not between", value1, value2, "shareTotal");
            return (Criteria) this;
        }

        public Criteria andShareTotalusIsNull() {
            addCriterion("share_totalus is null");
            return (Criteria) this;
        }

        public Criteria andShareTotalusIsNotNull() {
            addCriterion("share_totalus is not null");
            return (Criteria) this;
        }

        public Criteria andShareTotalusEqualTo(BigDecimal value) {
            addCriterion("share_totalus =", value, "shareTotalus");
            return (Criteria) this;
        }

        public Criteria andShareTotalusNotEqualTo(BigDecimal value) {
            addCriterion("share_totalus <>", value, "shareTotalus");
            return (Criteria) this;
        }

        public Criteria andShareTotalusGreaterThan(BigDecimal value) {
            addCriterion("share_totalus >", value, "shareTotalus");
            return (Criteria) this;
        }

        public Criteria andShareTotalusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("share_totalus >=", value, "shareTotalus");
            return (Criteria) this;
        }

        public Criteria andShareTotalusLessThan(BigDecimal value) {
            addCriterion("share_totalus <", value, "shareTotalus");
            return (Criteria) this;
        }

        public Criteria andShareTotalusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("share_totalus <=", value, "shareTotalus");
            return (Criteria) this;
        }

        public Criteria andShareTotalusIn(List<BigDecimal> values) {
            addCriterion("share_totalus in", values, "shareTotalus");
            return (Criteria) this;
        }

        public Criteria andShareTotalusNotIn(List<BigDecimal> values) {
            addCriterion("share_totalus not in", values, "shareTotalus");
            return (Criteria) this;
        }

        public Criteria andShareTotalusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("share_totalus between", value1, value2, "shareTotalus");
            return (Criteria) this;
        }

        public Criteria andShareTotalusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("share_totalus not between", value1, value2, "shareTotalus");
            return (Criteria) this;
        }

        public Criteria andBadDebtIsNull() {
            addCriterion("bad_debt is null");
            return (Criteria) this;
        }

        public Criteria andBadDebtIsNotNull() {
            addCriterion("bad_debt is not null");
            return (Criteria) this;
        }

        public Criteria andBadDebtEqualTo(BigDecimal value) {
            addCriterion("bad_debt =", value, "badDebt");
            return (Criteria) this;
        }

        public Criteria andBadDebtNotEqualTo(BigDecimal value) {
            addCriterion("bad_debt <>", value, "badDebt");
            return (Criteria) this;
        }

        public Criteria andBadDebtGreaterThan(BigDecimal value) {
            addCriterion("bad_debt >", value, "badDebt");
            return (Criteria) this;
        }

        public Criteria andBadDebtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bad_debt >=", value, "badDebt");
            return (Criteria) this;
        }

        public Criteria andBadDebtLessThan(BigDecimal value) {
            addCriterion("bad_debt <", value, "badDebt");
            return (Criteria) this;
        }

        public Criteria andBadDebtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bad_debt <=", value, "badDebt");
            return (Criteria) this;
        }

        public Criteria andBadDebtIn(List<BigDecimal> values) {
            addCriterion("bad_debt in", values, "badDebt");
            return (Criteria) this;
        }

        public Criteria andBadDebtNotIn(List<BigDecimal> values) {
            addCriterion("bad_debt not in", values, "badDebt");
            return (Criteria) this;
        }

        public Criteria andBadDebtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bad_debt between", value1, value2, "badDebt");
            return (Criteria) this;
        }

        public Criteria andBadDebtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bad_debt not between", value1, value2, "badDebt");
            return (Criteria) this;
        }

        public Criteria andTaxIsNull() {
            addCriterion("tax is null");
            return (Criteria) this;
        }

        public Criteria andTaxIsNotNull() {
            addCriterion("tax is not null");
            return (Criteria) this;
        }

        public Criteria andTaxEqualTo(BigDecimal value) {
            addCriterion("tax =", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotEqualTo(BigDecimal value) {
            addCriterion("tax <>", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxGreaterThan(BigDecimal value) {
            addCriterion("tax >", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax >=", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxLessThan(BigDecimal value) {
            addCriterion("tax <", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax <=", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxIn(List<BigDecimal> values) {
            addCriterion("tax in", values, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotIn(List<BigDecimal> values) {
            addCriterion("tax not in", values, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax between", value1, value2, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax not between", value1, value2, "tax");
            return (Criteria) this;
        }

        public Criteria andNetPaymentIsNull() {
            addCriterion("net_payment is null");
            return (Criteria) this;
        }

        public Criteria andNetPaymentIsNotNull() {
            addCriterion("net_payment is not null");
            return (Criteria) this;
        }

        public Criteria andNetPaymentEqualTo(BigDecimal value) {
            addCriterion("net_payment =", value, "netPayment");
            return (Criteria) this;
        }

        public Criteria andNetPaymentNotEqualTo(BigDecimal value) {
            addCriterion("net_payment <>", value, "netPayment");
            return (Criteria) this;
        }

        public Criteria andNetPaymentGreaterThan(BigDecimal value) {
            addCriterion("net_payment >", value, "netPayment");
            return (Criteria) this;
        }

        public Criteria andNetPaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("net_payment >=", value, "netPayment");
            return (Criteria) this;
        }

        public Criteria andNetPaymentLessThan(BigDecimal value) {
            addCriterion("net_payment <", value, "netPayment");
            return (Criteria) this;
        }

        public Criteria andNetPaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("net_payment <=", value, "netPayment");
            return (Criteria) this;
        }

        public Criteria andNetPaymentIn(List<BigDecimal> values) {
            addCriterion("net_payment in", values, "netPayment");
            return (Criteria) this;
        }

        public Criteria andNetPaymentNotIn(List<BigDecimal> values) {
            addCriterion("net_payment not in", values, "netPayment");
            return (Criteria) this;
        }

        public Criteria andNetPaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("net_payment between", value1, value2, "netPayment");
            return (Criteria) this;
        }

        public Criteria andNetPaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("net_payment not between", value1, value2, "netPayment");
            return (Criteria) this;
        }

        public Criteria andSellCountIsNull() {
            addCriterion("sell_count is null");
            return (Criteria) this;
        }

        public Criteria andSellCountIsNotNull() {
            addCriterion("sell_count is not null");
            return (Criteria) this;
        }

        public Criteria andSellCountEqualTo(Integer value) {
            addCriterion("sell_count =", value, "sellCount");
            return (Criteria) this;
        }

        public Criteria andSellCountNotEqualTo(Integer value) {
            addCriterion("sell_count <>", value, "sellCount");
            return (Criteria) this;
        }

        public Criteria andSellCountGreaterThan(Integer value) {
            addCriterion("sell_count >", value, "sellCount");
            return (Criteria) this;
        }

        public Criteria andSellCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sell_count >=", value, "sellCount");
            return (Criteria) this;
        }

        public Criteria andSellCountLessThan(Integer value) {
            addCriterion("sell_count <", value, "sellCount");
            return (Criteria) this;
        }

        public Criteria andSellCountLessThanOrEqualTo(Integer value) {
            addCriterion("sell_count <=", value, "sellCount");
            return (Criteria) this;
        }

        public Criteria andSellCountIn(List<Integer> values) {
            addCriterion("sell_count in", values, "sellCount");
            return (Criteria) this;
        }

        public Criteria andSellCountNotIn(List<Integer> values) {
            addCriterion("sell_count not in", values, "sellCount");
            return (Criteria) this;
        }

        public Criteria andSellCountBetween(Integer value1, Integer value2) {
            addCriterion("sell_count between", value1, value2, "sellCount");
            return (Criteria) this;
        }

        public Criteria andSellCountNotBetween(Integer value1, Integer value2) {
            addCriterion("sell_count not between", value1, value2, "sellCount");
            return (Criteria) this;
        }

        public Criteria andExclusiveBonusIsNull() {
            addCriterion("exclusive_bonus is null");
            return (Criteria) this;
        }

        public Criteria andExclusiveBonusIsNotNull() {
            addCriterion("exclusive_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andExclusiveBonusEqualTo(BigDecimal value) {
            addCriterion("exclusive_bonus =", value, "exclusiveBonus");
            return (Criteria) this;
        }

        public Criteria andExclusiveBonusNotEqualTo(BigDecimal value) {
            addCriterion("exclusive_bonus <>", value, "exclusiveBonus");
            return (Criteria) this;
        }

        public Criteria andExclusiveBonusGreaterThan(BigDecimal value) {
            addCriterion("exclusive_bonus >", value, "exclusiveBonus");
            return (Criteria) this;
        }

        public Criteria andExclusiveBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("exclusive_bonus >=", value, "exclusiveBonus");
            return (Criteria) this;
        }

        public Criteria andExclusiveBonusLessThan(BigDecimal value) {
            addCriterion("exclusive_bonus <", value, "exclusiveBonus");
            return (Criteria) this;
        }

        public Criteria andExclusiveBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("exclusive_bonus <=", value, "exclusiveBonus");
            return (Criteria) this;
        }

        public Criteria andExclusiveBonusIn(List<BigDecimal> values) {
            addCriterion("exclusive_bonus in", values, "exclusiveBonus");
            return (Criteria) this;
        }

        public Criteria andExclusiveBonusNotIn(List<BigDecimal> values) {
            addCriterion("exclusive_bonus not in", values, "exclusiveBonus");
            return (Criteria) this;
        }

        public Criteria andExclusiveBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("exclusive_bonus between", value1, value2, "exclusiveBonus");
            return (Criteria) this;
        }

        public Criteria andExclusiveBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("exclusive_bonus not between", value1, value2, "exclusiveBonus");
            return (Criteria) this;
        }

        public Criteria andAdditionalShareIsNull() {
            addCriterion("additional_share is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalShareIsNotNull() {
            addCriterion("additional_share is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalShareEqualTo(BigDecimal value) {
            addCriterion("additional_share =", value, "additionalShare");
            return (Criteria) this;
        }

        public Criteria andAdditionalShareNotEqualTo(BigDecimal value) {
            addCriterion("additional_share <>", value, "additionalShare");
            return (Criteria) this;
        }

        public Criteria andAdditionalShareGreaterThan(BigDecimal value) {
            addCriterion("additional_share >", value, "additionalShare");
            return (Criteria) this;
        }

        public Criteria andAdditionalShareGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("additional_share >=", value, "additionalShare");
            return (Criteria) this;
        }

        public Criteria andAdditionalShareLessThan(BigDecimal value) {
            addCriterion("additional_share <", value, "additionalShare");
            return (Criteria) this;
        }

        public Criteria andAdditionalShareLessThanOrEqualTo(BigDecimal value) {
            addCriterion("additional_share <=", value, "additionalShare");
            return (Criteria) this;
        }

        public Criteria andAdditionalShareIn(List<BigDecimal> values) {
            addCriterion("additional_share in", values, "additionalShare");
            return (Criteria) this;
        }

        public Criteria andAdditionalShareNotIn(List<BigDecimal> values) {
            addCriterion("additional_share not in", values, "additionalShare");
            return (Criteria) this;
        }

        public Criteria andAdditionalShareBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("additional_share between", value1, value2, "additionalShare");
            return (Criteria) this;
        }

        public Criteria andAdditionalShareNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("additional_share not between", value1, value2, "additionalShare");
            return (Criteria) this;
        }

        public Criteria andExchangeRateIsNull() {
            addCriterion("exchange_rate is null");
            return (Criteria) this;
        }

        public Criteria andExchangeRateIsNotNull() {
            addCriterion("exchange_rate is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeRateEqualTo(BigDecimal value) {
            addCriterion("exchange_rate =", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateNotEqualTo(BigDecimal value) {
            addCriterion("exchange_rate <>", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateGreaterThan(BigDecimal value) {
            addCriterion("exchange_rate >", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("exchange_rate >=", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateLessThan(BigDecimal value) {
            addCriterion("exchange_rate <", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("exchange_rate <=", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateIn(List<BigDecimal> values) {
            addCriterion("exchange_rate in", values, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateNotIn(List<BigDecimal> values) {
            addCriterion("exchange_rate not in", values, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("exchange_rate between", value1, value2, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("exchange_rate not between", value1, value2, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andIsPaiedIsNull() {
            addCriterion("is_paied is null");
            return (Criteria) this;
        }

        public Criteria andIsPaiedIsNotNull() {
            addCriterion("is_paied is not null");
            return (Criteria) this;
        }

        public Criteria andIsPaiedEqualTo(Integer value) {
            addCriterion("is_paied =", value, "isPaied");
            return (Criteria) this;
        }

        public Criteria andIsPaiedNotEqualTo(Integer value) {
            addCriterion("is_paied <>", value, "isPaied");
            return (Criteria) this;
        }

        public Criteria andIsPaiedGreaterThan(Integer value) {
            addCriterion("is_paied >", value, "isPaied");
            return (Criteria) this;
        }

        public Criteria andIsPaiedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_paied >=", value, "isPaied");
            return (Criteria) this;
        }

        public Criteria andIsPaiedLessThan(Integer value) {
            addCriterion("is_paied <", value, "isPaied");
            return (Criteria) this;
        }

        public Criteria andIsPaiedLessThanOrEqualTo(Integer value) {
            addCriterion("is_paied <=", value, "isPaied");
            return (Criteria) this;
        }

        public Criteria andIsPaiedIn(List<Integer> values) {
            addCriterion("is_paied in", values, "isPaied");
            return (Criteria) this;
        }

        public Criteria andIsPaiedNotIn(List<Integer> values) {
            addCriterion("is_paied not in", values, "isPaied");
            return (Criteria) this;
        }

        public Criteria andIsPaiedBetween(Integer value1, Integer value2) {
            addCriterion("is_paied between", value1, value2, "isPaied");
            return (Criteria) this;
        }

        public Criteria andIsPaiedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_paied not between", value1, value2, "isPaied");
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
    }

public static class Criteria extends GeneratedCriteria implements Serializable {

	private static final long serialVersionUID = 5218178338183602293L;


        protected Criteria() {
            super();
        }
    }

public static class Criterion implements Serializable {

	private static final long serialVersionUID = 5917233543345803962L;

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
