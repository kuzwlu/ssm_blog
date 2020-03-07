package com.xxgc.po;

import java.util.ArrayList;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
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

    protected abstract static class GeneratedCriteria {
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

        public Criteria andMeidIsNull() {
            addCriterion("meid is null");
            return (Criteria) this;
        }

        public Criteria andMeidIsNotNull() {
            addCriterion("meid is not null");
            return (Criteria) this;
        }

        public Criteria andMeidEqualTo(Integer value) {
            addCriterion("meid =", value, "meid");
            return (Criteria) this;
        }

        public Criteria andMeidNotEqualTo(Integer value) {
            addCriterion("meid <>", value, "meid");
            return (Criteria) this;
        }

        public Criteria andMeidGreaterThan(Integer value) {
            addCriterion("meid >", value, "meid");
            return (Criteria) this;
        }

        public Criteria andMeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("meid >=", value, "meid");
            return (Criteria) this;
        }

        public Criteria andMeidLessThan(Integer value) {
            addCriterion("meid <", value, "meid");
            return (Criteria) this;
        }

        public Criteria andMeidLessThanOrEqualTo(Integer value) {
            addCriterion("meid <=", value, "meid");
            return (Criteria) this;
        }

        public Criteria andMeidIn(List<Integer> values) {
            addCriterion("meid in", values, "meid");
            return (Criteria) this;
        }

        public Criteria andMeidNotIn(List<Integer> values) {
            addCriterion("meid not in", values, "meid");
            return (Criteria) this;
        }

        public Criteria andMeidBetween(Integer value1, Integer value2) {
            addCriterion("meid between", value1, value2, "meid");
            return (Criteria) this;
        }

        public Criteria andMeidNotBetween(Integer value1, Integer value2) {
            addCriterion("meid not between", value1, value2, "meid");
            return (Criteria) this;
        }

        public Criteria andAridIsNull() {
            addCriterion("arid is null");
            return (Criteria) this;
        }

        public Criteria andAridIsNotNull() {
            addCriterion("arid is not null");
            return (Criteria) this;
        }

        public Criteria andAridEqualTo(Integer value) {
            addCriterion("arid =", value, "arid");
            return (Criteria) this;
        }

        public Criteria andAridNotEqualTo(Integer value) {
            addCriterion("arid <>", value, "arid");
            return (Criteria) this;
        }

        public Criteria andAridGreaterThan(Integer value) {
            addCriterion("arid >", value, "arid");
            return (Criteria) this;
        }

        public Criteria andAridGreaterThanOrEqualTo(Integer value) {
            addCriterion("arid >=", value, "arid");
            return (Criteria) this;
        }

        public Criteria andAridLessThan(Integer value) {
            addCriterion("arid <", value, "arid");
            return (Criteria) this;
        }

        public Criteria andAridLessThanOrEqualTo(Integer value) {
            addCriterion("arid <=", value, "arid");
            return (Criteria) this;
        }

        public Criteria andAridIn(List<Integer> values) {
            addCriterion("arid in", values, "arid");
            return (Criteria) this;
        }

        public Criteria andAridNotIn(List<Integer> values) {
            addCriterion("arid not in", values, "arid");
            return (Criteria) this;
        }

        public Criteria andAridBetween(Integer value1, Integer value2) {
            addCriterion("arid between", value1, value2, "arid");
            return (Criteria) this;
        }

        public Criteria andAridNotBetween(Integer value1, Integer value2) {
            addCriterion("arid not between", value1, value2, "arid");
            return (Criteria) this;
        }

        public Criteria andMetitleIsNull() {
            addCriterion("metitle is null");
            return (Criteria) this;
        }

        public Criteria andMetitleIsNotNull() {
            addCriterion("metitle is not null");
            return (Criteria) this;
        }

        public Criteria andMetitleEqualTo(String value) {
            addCriterion("metitle =", value, "metitle");
            return (Criteria) this;
        }

        public Criteria andMetitleNotEqualTo(String value) {
            addCriterion("metitle <>", value, "metitle");
            return (Criteria) this;
        }

        public Criteria andMetitleGreaterThan(String value) {
            addCriterion("metitle >", value, "metitle");
            return (Criteria) this;
        }

        public Criteria andMetitleGreaterThanOrEqualTo(String value) {
            addCriterion("metitle >=", value, "metitle");
            return (Criteria) this;
        }

        public Criteria andMetitleLessThan(String value) {
            addCriterion("metitle <", value, "metitle");
            return (Criteria) this;
        }

        public Criteria andMetitleLessThanOrEqualTo(String value) {
            addCriterion("metitle <=", value, "metitle");
            return (Criteria) this;
        }

        public Criteria andMetitleLike(String value) {
            addCriterion("metitle like", value, "metitle");
            return (Criteria) this;
        }

        public Criteria andMetitleNotLike(String value) {
            addCriterion("metitle not like", value, "metitle");
            return (Criteria) this;
        }

        public Criteria andMetitleIn(List<String> values) {
            addCriterion("metitle in", values, "metitle");
            return (Criteria) this;
        }

        public Criteria andMetitleNotIn(List<String> values) {
            addCriterion("metitle not in", values, "metitle");
            return (Criteria) this;
        }

        public Criteria andMetitleBetween(String value1, String value2) {
            addCriterion("metitle between", value1, value2, "metitle");
            return (Criteria) this;
        }

        public Criteria andMetitleNotBetween(String value1, String value2) {
            addCriterion("metitle not between", value1, value2, "metitle");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andManageridIsNull() {
            addCriterion("managerid is null");
            return (Criteria) this;
        }

        public Criteria andManageridIsNotNull() {
            addCriterion("managerid is not null");
            return (Criteria) this;
        }

        public Criteria andManageridEqualTo(Integer value) {
            addCriterion("managerid =", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridNotEqualTo(Integer value) {
            addCriterion("managerid <>", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridGreaterThan(Integer value) {
            addCriterion("managerid >", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridGreaterThanOrEqualTo(Integer value) {
            addCriterion("managerid >=", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridLessThan(Integer value) {
            addCriterion("managerid <", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridLessThanOrEqualTo(Integer value) {
            addCriterion("managerid <=", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridIn(List<Integer> values) {
            addCriterion("managerid in", values, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridNotIn(List<Integer> values) {
            addCriterion("managerid not in", values, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridBetween(Integer value1, Integer value2) {
            addCriterion("managerid between", value1, value2, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridNotBetween(Integer value1, Integer value2) {
            addCriterion("managerid not between", value1, value2, "managerid");
            return (Criteria) this;
        }

        public Criteria andMetimeIsNull() {
            addCriterion("metime is null");
            return (Criteria) this;
        }

        public Criteria andMetimeIsNotNull() {
            addCriterion("metime is not null");
            return (Criteria) this;
        }

        public Criteria andMetimeEqualTo(String value) {
            addCriterion("metime =", value, "metime");
            return (Criteria) this;
        }

        public Criteria andMetimeNotEqualTo(String value) {
            addCriterion("metime <>", value, "metime");
            return (Criteria) this;
        }

        public Criteria andMetimeGreaterThan(String value) {
            addCriterion("metime >", value, "metime");
            return (Criteria) this;
        }

        public Criteria andMetimeGreaterThanOrEqualTo(String value) {
            addCriterion("metime >=", value, "metime");
            return (Criteria) this;
        }

        public Criteria andMetimeLessThan(String value) {
            addCriterion("metime <", value, "metime");
            return (Criteria) this;
        }

        public Criteria andMetimeLessThanOrEqualTo(String value) {
            addCriterion("metime <=", value, "metime");
            return (Criteria) this;
        }

        public Criteria andMetimeLike(String value) {
            addCriterion("metime like", value, "metime");
            return (Criteria) this;
        }

        public Criteria andMetimeNotLike(String value) {
            addCriterion("metime not like", value, "metime");
            return (Criteria) this;
        }

        public Criteria andMetimeIn(List<String> values) {
            addCriterion("metime in", values, "metime");
            return (Criteria) this;
        }

        public Criteria andMetimeNotIn(List<String> values) {
            addCriterion("metime not in", values, "metime");
            return (Criteria) this;
        }

        public Criteria andMetimeBetween(String value1, String value2) {
            addCriterion("metime between", value1, value2, "metime");
            return (Criteria) this;
        }

        public Criteria andMetimeNotBetween(String value1, String value2) {
            addCriterion("metime not between", value1, value2, "metime");
            return (Criteria) this;
        }

        public Criteria andMestateIsNull() {
            addCriterion("mestate is null");
            return (Criteria) this;
        }

        public Criteria andMestateIsNotNull() {
            addCriterion("mestate is not null");
            return (Criteria) this;
        }

        public Criteria andMestateEqualTo(String value) {
            addCriterion("mestate =", value, "mestate");
            return (Criteria) this;
        }

        public Criteria andMestateNotEqualTo(String value) {
            addCriterion("mestate <>", value, "mestate");
            return (Criteria) this;
        }

        public Criteria andMestateGreaterThan(String value) {
            addCriterion("mestate >", value, "mestate");
            return (Criteria) this;
        }

        public Criteria andMestateGreaterThanOrEqualTo(String value) {
            addCriterion("mestate >=", value, "mestate");
            return (Criteria) this;
        }

        public Criteria andMestateLessThan(String value) {
            addCriterion("mestate <", value, "mestate");
            return (Criteria) this;
        }

        public Criteria andMestateLessThanOrEqualTo(String value) {
            addCriterion("mestate <=", value, "mestate");
            return (Criteria) this;
        }

        public Criteria andMestateLike(String value) {
            addCriterion("mestate like", value, "mestate");
            return (Criteria) this;
        }

        public Criteria andMestateNotLike(String value) {
            addCriterion("mestate not like", value, "mestate");
            return (Criteria) this;
        }

        public Criteria andMestateIn(List<String> values) {
            addCriterion("mestate in", values, "mestate");
            return (Criteria) this;
        }

        public Criteria andMestateNotIn(List<String> values) {
            addCriterion("mestate not in", values, "mestate");
            return (Criteria) this;
        }

        public Criteria andMestateBetween(String value1, String value2) {
            addCriterion("mestate between", value1, value2, "mestate");
            return (Criteria) this;
        }

        public Criteria andMestateNotBetween(String value1, String value2) {
            addCriterion("mestate not between", value1, value2, "mestate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
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