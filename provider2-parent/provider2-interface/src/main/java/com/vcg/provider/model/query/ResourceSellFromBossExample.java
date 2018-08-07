package com.vcg.provider.model.query;

import java.io.Serializable;
import com.vcg.common.base.BaseExample;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResourceSellFromBossExample extends BaseExample {

	private static final long serialVersionUID = 2984011814520777026L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourceSellFromBossExample() {
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

	private static final long serialVersionUID = 6515856587428144224L;

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

        public Criteria andRightStartIsNull() {
            addCriterion("right_start is null");
            return (Criteria) this;
        }

        public Criteria andRightStartIsNotNull() {
            addCriterion("right_start is not null");
            return (Criteria) this;
        }

        public Criteria andRightStartEqualTo(Date value) {
            addCriterion("right_start =", value, "rightStart");
            return (Criteria) this;
        }

        public Criteria andRightStartNotEqualTo(Date value) {
            addCriterion("right_start <>", value, "rightStart");
            return (Criteria) this;
        }

        public Criteria andRightStartGreaterThan(Date value) {
            addCriterion("right_start >", value, "rightStart");
            return (Criteria) this;
        }

        public Criteria andRightStartGreaterThanOrEqualTo(Date value) {
            addCriterion("right_start >=", value, "rightStart");
            return (Criteria) this;
        }

        public Criteria andRightStartLessThan(Date value) {
            addCriterion("right_start <", value, "rightStart");
            return (Criteria) this;
        }

        public Criteria andRightStartLessThanOrEqualTo(Date value) {
            addCriterion("right_start <=", value, "rightStart");
            return (Criteria) this;
        }

        public Criteria andRightStartIn(List<Date> values) {
            addCriterion("right_start in", values, "rightStart");
            return (Criteria) this;
        }

        public Criteria andRightStartNotIn(List<Date> values) {
            addCriterion("right_start not in", values, "rightStart");
            return (Criteria) this;
        }

        public Criteria andRightStartBetween(Date value1, Date value2) {
            addCriterion("right_start between", value1, value2, "rightStart");
            return (Criteria) this;
        }

        public Criteria andRightStartNotBetween(Date value1, Date value2) {
            addCriterion("right_start not between", value1, value2, "rightStart");
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
            addCriterion("right_end =", value, "rightEnd");
            return (Criteria) this;
        }

        public Criteria andRightEndNotEqualTo(Date value) {
            addCriterion("right_end <>", value, "rightEnd");
            return (Criteria) this;
        }

        public Criteria andRightEndGreaterThan(Date value) {
            addCriterion("right_end >", value, "rightEnd");
            return (Criteria) this;
        }

        public Criteria andRightEndGreaterThanOrEqualTo(Date value) {
            addCriterion("right_end >=", value, "rightEnd");
            return (Criteria) this;
        }

        public Criteria andRightEndLessThan(Date value) {
            addCriterion("right_end <", value, "rightEnd");
            return (Criteria) this;
        }

        public Criteria andRightEndLessThanOrEqualTo(Date value) {
            addCriterion("right_end <=", value, "rightEnd");
            return (Criteria) this;
        }

        public Criteria andRightEndIn(List<Date> values) {
            addCriterion("right_end in", values, "rightEnd");
            return (Criteria) this;
        }

        public Criteria andRightEndNotIn(List<Date> values) {
            addCriterion("right_end not in", values, "rightEnd");
            return (Criteria) this;
        }

        public Criteria andRightEndBetween(Date value1, Date value2) {
            addCriterion("right_end between", value1, value2, "rightEnd");
            return (Criteria) this;
        }

        public Criteria andRightEndNotBetween(Date value1, Date value2) {
            addCriterion("right_end not between", value1, value2, "rightEnd");
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

        public Criteria andShareConfirmedIsNull() {
            addCriterion("share_confirmed is null");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedIsNotNull() {
            addCriterion("share_confirmed is not null");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedEqualTo(String value) {
            addCriterion("share_confirmed =", value, "shareConfirmed");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedNotEqualTo(String value) {
            addCriterion("share_confirmed <>", value, "shareConfirmed");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedGreaterThan(String value) {
            addCriterion("share_confirmed >", value, "shareConfirmed");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedGreaterThanOrEqualTo(String value) {
            addCriterion("share_confirmed >=", value, "shareConfirmed");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedLessThan(String value) {
            addCriterion("share_confirmed <", value, "shareConfirmed");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedLessThanOrEqualTo(String value) {
            addCriterion("share_confirmed <=", value, "shareConfirmed");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedLike(String value) {
            addCriterion("share_confirmed like", value, "shareConfirmed");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedNotLike(String value) {
            addCriterion("share_confirmed not like", value, "shareConfirmed");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedIn(List<String> values) {
            addCriterion("share_confirmed in", values, "shareConfirmed");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedNotIn(List<String> values) {
            addCriterion("share_confirmed not in", values, "shareConfirmed");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedBetween(String value1, String value2) {
            addCriterion("share_confirmed between", value1, value2, "shareConfirmed");
            return (Criteria) this;
        }

        public Criteria andShareConfirmedNotBetween(String value1, String value2) {
            addCriterion("share_confirmed not between", value1, value2, "shareConfirmed");
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

	private static final long serialVersionUID = 4728244774791632300L;


        protected Criteria() {
            super();
        }
    }

public static class Criterion implements Serializable {

	private static final long serialVersionUID = 94065559923622725L;

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
