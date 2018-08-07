package com.vcg.provider.model.query;

import java.io.Serializable;
import com.vcg.common.base.BaseExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContractInfoExample extends BaseExample {

	private static final long serialVersionUID = 7885280000832120699L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContractInfoExample() {
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

	private static final long serialVersionUID = 7713995080411006453L;

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

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andFaxIsNull() {
            addCriterion("fax is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("fax is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("fax =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("fax <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("fax >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("fax >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("fax <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("fax <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("fax like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("fax not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("fax in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("fax not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("fax between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("fax not between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("qq like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("qq not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("qq not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andMsnIsNull() {
            addCriterion("msn is null");
            return (Criteria) this;
        }

        public Criteria andMsnIsNotNull() {
            addCriterion("msn is not null");
            return (Criteria) this;
        }

        public Criteria andMsnEqualTo(String value) {
            addCriterion("msn =", value, "msn");
            return (Criteria) this;
        }

        public Criteria andMsnNotEqualTo(String value) {
            addCriterion("msn <>", value, "msn");
            return (Criteria) this;
        }

        public Criteria andMsnGreaterThan(String value) {
            addCriterion("msn >", value, "msn");
            return (Criteria) this;
        }

        public Criteria andMsnGreaterThanOrEqualTo(String value) {
            addCriterion("msn >=", value, "msn");
            return (Criteria) this;
        }

        public Criteria andMsnLessThan(String value) {
            addCriterion("msn <", value, "msn");
            return (Criteria) this;
        }

        public Criteria andMsnLessThanOrEqualTo(String value) {
            addCriterion("msn <=", value, "msn");
            return (Criteria) this;
        }

        public Criteria andMsnLike(String value) {
            addCriterion("msn like", value, "msn");
            return (Criteria) this;
        }

        public Criteria andMsnNotLike(String value) {
            addCriterion("msn not like", value, "msn");
            return (Criteria) this;
        }

        public Criteria andMsnIn(List<String> values) {
            addCriterion("msn in", values, "msn");
            return (Criteria) this;
        }

        public Criteria andMsnNotIn(List<String> values) {
            addCriterion("msn not in", values, "msn");
            return (Criteria) this;
        }

        public Criteria andMsnBetween(String value1, String value2) {
            addCriterion("msn between", value1, value2, "msn");
            return (Criteria) this;
        }

        public Criteria andMsnNotBetween(String value1, String value2) {
            addCriterion("msn not between", value1, value2, "msn");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andWeixinIsNull() {
            addCriterion("weixin is null");
            return (Criteria) this;
        }

        public Criteria andWeixinIsNotNull() {
            addCriterion("weixin is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinEqualTo(String value) {
            addCriterion("weixin =", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinNotEqualTo(String value) {
            addCriterion("weixin <>", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinGreaterThan(String value) {
            addCriterion("weixin >", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinGreaterThanOrEqualTo(String value) {
            addCriterion("weixin >=", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinLessThan(String value) {
            addCriterion("weixin <", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinLessThanOrEqualTo(String value) {
            addCriterion("weixin <=", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinLike(String value) {
            addCriterion("weixin like", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinNotLike(String value) {
            addCriterion("weixin not like", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinIn(List<String> values) {
            addCriterion("weixin in", values, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinNotIn(List<String> values) {
            addCriterion("weixin not in", values, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinBetween(String value1, String value2) {
            addCriterion("weixin between", value1, value2, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinNotBetween(String value1, String value2) {
            addCriterion("weixin not between", value1, value2, "weixin");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andSkypeIsNull() {
            addCriterion("skype is null");
            return (Criteria) this;
        }

        public Criteria andSkypeIsNotNull() {
            addCriterion("skype is not null");
            return (Criteria) this;
        }

        public Criteria andSkypeEqualTo(String value) {
            addCriterion("skype =", value, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeNotEqualTo(String value) {
            addCriterion("skype <>", value, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeGreaterThan(String value) {
            addCriterion("skype >", value, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeGreaterThanOrEqualTo(String value) {
            addCriterion("skype >=", value, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeLessThan(String value) {
            addCriterion("skype <", value, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeLessThanOrEqualTo(String value) {
            addCriterion("skype <=", value, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeLike(String value) {
            addCriterion("skype like", value, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeNotLike(String value) {
            addCriterion("skype not like", value, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeIn(List<String> values) {
            addCriterion("skype in", values, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeNotIn(List<String> values) {
            addCriterion("skype not in", values, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeBetween(String value1, String value2) {
            addCriterion("skype between", value1, value2, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeNotBetween(String value1, String value2) {
            addCriterion("skype not between", value1, value2, "skype");
            return (Criteria) this;
        }

        public Criteria andIdNumIsNull() {
            addCriterion("id_num is null");
            return (Criteria) this;
        }

        public Criteria andIdNumIsNotNull() {
            addCriterion("id_num is not null");
            return (Criteria) this;
        }

        public Criteria andIdNumEqualTo(String value) {
            addCriterion("id_num =", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumNotEqualTo(String value) {
            addCriterion("id_num <>", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumGreaterThan(String value) {
            addCriterion("id_num >", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumGreaterThanOrEqualTo(String value) {
            addCriterion("id_num >=", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumLessThan(String value) {
            addCriterion("id_num <", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumLessThanOrEqualTo(String value) {
            addCriterion("id_num <=", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumLike(String value) {
            addCriterion("id_num like", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumNotLike(String value) {
            addCriterion("id_num not like", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumIn(List<String> values) {
            addCriterion("id_num in", values, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumNotIn(List<String> values) {
            addCriterion("id_num not in", values, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumBetween(String value1, String value2) {
            addCriterion("id_num between", value1, value2, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumNotBetween(String value1, String value2) {
            addCriterion("id_num not between", value1, value2, "idNum");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNull() {
            addCriterion("postcode is null");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNotNull() {
            addCriterion("postcode is not null");
            return (Criteria) this;
        }

        public Criteria andPostcodeEqualTo(String value) {
            addCriterion("postcode =", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotEqualTo(String value) {
            addCriterion("postcode <>", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThan(String value) {
            addCriterion("postcode >", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("postcode >=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThan(String value) {
            addCriterion("postcode <", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThanOrEqualTo(String value) {
            addCriterion("postcode <=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLike(String value) {
            addCriterion("postcode like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotLike(String value) {
            addCriterion("postcode not like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeIn(List<String> values) {
            addCriterion("postcode in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotIn(List<String> values) {
            addCriterion("postcode not in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeBetween(String value1, String value2) {
            addCriterion("postcode between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotBetween(String value1, String value2) {
            addCriterion("postcode not between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andEmergencyNameIsNull() {
            addCriterion("emergency_name is null");
            return (Criteria) this;
        }

        public Criteria andEmergencyNameIsNotNull() {
            addCriterion("emergency_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmergencyNameEqualTo(String value) {
            addCriterion("emergency_name =", value, "emergencyName");
            return (Criteria) this;
        }

        public Criteria andEmergencyNameNotEqualTo(String value) {
            addCriterion("emergency_name <>", value, "emergencyName");
            return (Criteria) this;
        }

        public Criteria andEmergencyNameGreaterThan(String value) {
            addCriterion("emergency_name >", value, "emergencyName");
            return (Criteria) this;
        }

        public Criteria andEmergencyNameGreaterThanOrEqualTo(String value) {
            addCriterion("emergency_name >=", value, "emergencyName");
            return (Criteria) this;
        }

        public Criteria andEmergencyNameLessThan(String value) {
            addCriterion("emergency_name <", value, "emergencyName");
            return (Criteria) this;
        }

        public Criteria andEmergencyNameLessThanOrEqualTo(String value) {
            addCriterion("emergency_name <=", value, "emergencyName");
            return (Criteria) this;
        }

        public Criteria andEmergencyNameLike(String value) {
            addCriterion("emergency_name like", value, "emergencyName");
            return (Criteria) this;
        }

        public Criteria andEmergencyNameNotLike(String value) {
            addCriterion("emergency_name not like", value, "emergencyName");
            return (Criteria) this;
        }

        public Criteria andEmergencyNameIn(List<String> values) {
            addCriterion("emergency_name in", values, "emergencyName");
            return (Criteria) this;
        }

        public Criteria andEmergencyNameNotIn(List<String> values) {
            addCriterion("emergency_name not in", values, "emergencyName");
            return (Criteria) this;
        }

        public Criteria andEmergencyNameBetween(String value1, String value2) {
            addCriterion("emergency_name between", value1, value2, "emergencyName");
            return (Criteria) this;
        }

        public Criteria andEmergencyNameNotBetween(String value1, String value2) {
            addCriterion("emergency_name not between", value1, value2, "emergencyName");
            return (Criteria) this;
        }

        public Criteria andEmergencySexIsNull() {
            addCriterion("emergency_sex is null");
            return (Criteria) this;
        }

        public Criteria andEmergencySexIsNotNull() {
            addCriterion("emergency_sex is not null");
            return (Criteria) this;
        }

        public Criteria andEmergencySexEqualTo(Integer value) {
            addCriterion("emergency_sex =", value, "emergencySex");
            return (Criteria) this;
        }

        public Criteria andEmergencySexNotEqualTo(Integer value) {
            addCriterion("emergency_sex <>", value, "emergencySex");
            return (Criteria) this;
        }

        public Criteria andEmergencySexGreaterThan(Integer value) {
            addCriterion("emergency_sex >", value, "emergencySex");
            return (Criteria) this;
        }

        public Criteria andEmergencySexGreaterThanOrEqualTo(Integer value) {
            addCriterion("emergency_sex >=", value, "emergencySex");
            return (Criteria) this;
        }

        public Criteria andEmergencySexLessThan(Integer value) {
            addCriterion("emergency_sex <", value, "emergencySex");
            return (Criteria) this;
        }

        public Criteria andEmergencySexLessThanOrEqualTo(Integer value) {
            addCriterion("emergency_sex <=", value, "emergencySex");
            return (Criteria) this;
        }

        public Criteria andEmergencySexIn(List<Integer> values) {
            addCriterion("emergency_sex in", values, "emergencySex");
            return (Criteria) this;
        }

        public Criteria andEmergencySexNotIn(List<Integer> values) {
            addCriterion("emergency_sex not in", values, "emergencySex");
            return (Criteria) this;
        }

        public Criteria andEmergencySexBetween(Integer value1, Integer value2) {
            addCriterion("emergency_sex between", value1, value2, "emergencySex");
            return (Criteria) this;
        }

        public Criteria andEmergencySexNotBetween(Integer value1, Integer value2) {
            addCriterion("emergency_sex not between", value1, value2, "emergencySex");
            return (Criteria) this;
        }

        public Criteria andEmergencyIdnumIsNull() {
            addCriterion("emergency_IDNum is null");
            return (Criteria) this;
        }

        public Criteria andEmergencyIdnumIsNotNull() {
            addCriterion("emergency_IDNum is not null");
            return (Criteria) this;
        }

        public Criteria andEmergencyIdnumEqualTo(String value) {
            addCriterion("emergency_IDNum =", value, "emergencyIdnum");
            return (Criteria) this;
        }

        public Criteria andEmergencyIdnumNotEqualTo(String value) {
            addCriterion("emergency_IDNum <>", value, "emergencyIdnum");
            return (Criteria) this;
        }

        public Criteria andEmergencyIdnumGreaterThan(String value) {
            addCriterion("emergency_IDNum >", value, "emergencyIdnum");
            return (Criteria) this;
        }

        public Criteria andEmergencyIdnumGreaterThanOrEqualTo(String value) {
            addCriterion("emergency_IDNum >=", value, "emergencyIdnum");
            return (Criteria) this;
        }

        public Criteria andEmergencyIdnumLessThan(String value) {
            addCriterion("emergency_IDNum <", value, "emergencyIdnum");
            return (Criteria) this;
        }

        public Criteria andEmergencyIdnumLessThanOrEqualTo(String value) {
            addCriterion("emergency_IDNum <=", value, "emergencyIdnum");
            return (Criteria) this;
        }

        public Criteria andEmergencyIdnumLike(String value) {
            addCriterion("emergency_IDNum like", value, "emergencyIdnum");
            return (Criteria) this;
        }

        public Criteria andEmergencyIdnumNotLike(String value) {
            addCriterion("emergency_IDNum not like", value, "emergencyIdnum");
            return (Criteria) this;
        }

        public Criteria andEmergencyIdnumIn(List<String> values) {
            addCriterion("emergency_IDNum in", values, "emergencyIdnum");
            return (Criteria) this;
        }

        public Criteria andEmergencyIdnumNotIn(List<String> values) {
            addCriterion("emergency_IDNum not in", values, "emergencyIdnum");
            return (Criteria) this;
        }

        public Criteria andEmergencyIdnumBetween(String value1, String value2) {
            addCriterion("emergency_IDNum between", value1, value2, "emergencyIdnum");
            return (Criteria) this;
        }

        public Criteria andEmergencyIdnumNotBetween(String value1, String value2) {
            addCriterion("emergency_IDNum not between", value1, value2, "emergencyIdnum");
            return (Criteria) this;
        }

        public Criteria andEmergencyMobileIsNull() {
            addCriterion("emergency_mobile is null");
            return (Criteria) this;
        }

        public Criteria andEmergencyMobileIsNotNull() {
            addCriterion("emergency_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andEmergencyMobileEqualTo(String value) {
            addCriterion("emergency_mobile =", value, "emergencyMobile");
            return (Criteria) this;
        }

        public Criteria andEmergencyMobileNotEqualTo(String value) {
            addCriterion("emergency_mobile <>", value, "emergencyMobile");
            return (Criteria) this;
        }

        public Criteria andEmergencyMobileGreaterThan(String value) {
            addCriterion("emergency_mobile >", value, "emergencyMobile");
            return (Criteria) this;
        }

        public Criteria andEmergencyMobileGreaterThanOrEqualTo(String value) {
            addCriterion("emergency_mobile >=", value, "emergencyMobile");
            return (Criteria) this;
        }

        public Criteria andEmergencyMobileLessThan(String value) {
            addCriterion("emergency_mobile <", value, "emergencyMobile");
            return (Criteria) this;
        }

        public Criteria andEmergencyMobileLessThanOrEqualTo(String value) {
            addCriterion("emergency_mobile <=", value, "emergencyMobile");
            return (Criteria) this;
        }

        public Criteria andEmergencyMobileLike(String value) {
            addCriterion("emergency_mobile like", value, "emergencyMobile");
            return (Criteria) this;
        }

        public Criteria andEmergencyMobileNotLike(String value) {
            addCriterion("emergency_mobile not like", value, "emergencyMobile");
            return (Criteria) this;
        }

        public Criteria andEmergencyMobileIn(List<String> values) {
            addCriterion("emergency_mobile in", values, "emergencyMobile");
            return (Criteria) this;
        }

        public Criteria andEmergencyMobileNotIn(List<String> values) {
            addCriterion("emergency_mobile not in", values, "emergencyMobile");
            return (Criteria) this;
        }

        public Criteria andEmergencyMobileBetween(String value1, String value2) {
            addCriterion("emergency_mobile between", value1, value2, "emergencyMobile");
            return (Criteria) this;
        }

        public Criteria andEmergencyMobileNotBetween(String value1, String value2) {
            addCriterion("emergency_mobile not between", value1, value2, "emergencyMobile");
            return (Criteria) this;
        }

        public Criteria andEmergencyAddressIsNull() {
            addCriterion("emergency_address is null");
            return (Criteria) this;
        }

        public Criteria andEmergencyAddressIsNotNull() {
            addCriterion("emergency_address is not null");
            return (Criteria) this;
        }

        public Criteria andEmergencyAddressEqualTo(String value) {
            addCriterion("emergency_address =", value, "emergencyAddress");
            return (Criteria) this;
        }

        public Criteria andEmergencyAddressNotEqualTo(String value) {
            addCriterion("emergency_address <>", value, "emergencyAddress");
            return (Criteria) this;
        }

        public Criteria andEmergencyAddressGreaterThan(String value) {
            addCriterion("emergency_address >", value, "emergencyAddress");
            return (Criteria) this;
        }

        public Criteria andEmergencyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("emergency_address >=", value, "emergencyAddress");
            return (Criteria) this;
        }

        public Criteria andEmergencyAddressLessThan(String value) {
            addCriterion("emergency_address <", value, "emergencyAddress");
            return (Criteria) this;
        }

        public Criteria andEmergencyAddressLessThanOrEqualTo(String value) {
            addCriterion("emergency_address <=", value, "emergencyAddress");
            return (Criteria) this;
        }

        public Criteria andEmergencyAddressLike(String value) {
            addCriterion("emergency_address like", value, "emergencyAddress");
            return (Criteria) this;
        }

        public Criteria andEmergencyAddressNotLike(String value) {
            addCriterion("emergency_address not like", value, "emergencyAddress");
            return (Criteria) this;
        }

        public Criteria andEmergencyAddressIn(List<String> values) {
            addCriterion("emergency_address in", values, "emergencyAddress");
            return (Criteria) this;
        }

        public Criteria andEmergencyAddressNotIn(List<String> values) {
            addCriterion("emergency_address not in", values, "emergencyAddress");
            return (Criteria) this;
        }

        public Criteria andEmergencyAddressBetween(String value1, String value2) {
            addCriterion("emergency_address between", value1, value2, "emergencyAddress");
            return (Criteria) this;
        }

        public Criteria andEmergencyAddressNotBetween(String value1, String value2) {
            addCriterion("emergency_address not between", value1, value2, "emergencyAddress");
            return (Criteria) this;
        }

        public Criteria andEmergencyPostcodeIsNull() {
            addCriterion("emergency_postcode is null");
            return (Criteria) this;
        }

        public Criteria andEmergencyPostcodeIsNotNull() {
            addCriterion("emergency_postcode is not null");
            return (Criteria) this;
        }

        public Criteria andEmergencyPostcodeEqualTo(String value) {
            addCriterion("emergency_postcode =", value, "emergencyPostcode");
            return (Criteria) this;
        }

        public Criteria andEmergencyPostcodeNotEqualTo(String value) {
            addCriterion("emergency_postcode <>", value, "emergencyPostcode");
            return (Criteria) this;
        }

        public Criteria andEmergencyPostcodeGreaterThan(String value) {
            addCriterion("emergency_postcode >", value, "emergencyPostcode");
            return (Criteria) this;
        }

        public Criteria andEmergencyPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("emergency_postcode >=", value, "emergencyPostcode");
            return (Criteria) this;
        }

        public Criteria andEmergencyPostcodeLessThan(String value) {
            addCriterion("emergency_postcode <", value, "emergencyPostcode");
            return (Criteria) this;
        }

        public Criteria andEmergencyPostcodeLessThanOrEqualTo(String value) {
            addCriterion("emergency_postcode <=", value, "emergencyPostcode");
            return (Criteria) this;
        }

        public Criteria andEmergencyPostcodeLike(String value) {
            addCriterion("emergency_postcode like", value, "emergencyPostcode");
            return (Criteria) this;
        }

        public Criteria andEmergencyPostcodeNotLike(String value) {
            addCriterion("emergency_postcode not like", value, "emergencyPostcode");
            return (Criteria) this;
        }

        public Criteria andEmergencyPostcodeIn(List<String> values) {
            addCriterion("emergency_postcode in", values, "emergencyPostcode");
            return (Criteria) this;
        }

        public Criteria andEmergencyPostcodeNotIn(List<String> values) {
            addCriterion("emergency_postcode not in", values, "emergencyPostcode");
            return (Criteria) this;
        }

        public Criteria andEmergencyPostcodeBetween(String value1, String value2) {
            addCriterion("emergency_postcode between", value1, value2, "emergencyPostcode");
            return (Criteria) this;
        }

        public Criteria andEmergencyPostcodeNotBetween(String value1, String value2) {
            addCriterion("emergency_postcode not between", value1, value2, "emergencyPostcode");
            return (Criteria) this;
        }
    }

public static class Criteria extends GeneratedCriteria implements Serializable {

	private static final long serialVersionUID = 8131239142196945450L;


        protected Criteria() {
            super();
        }
    }

public static class Criterion implements Serializable {

	private static final long serialVersionUID = 6836258949378417191L;

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
