package com.xxgc.po;

import java.util.ArrayList;
import java.util.List;

public class CatalogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CatalogExample() {
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

        public Criteria andCaidIsNull() {
            addCriterion("caid is null");
            return (Criteria) this;
        }

        public Criteria andCaidIsNotNull() {
            addCriterion("caid is not null");
            return (Criteria) this;
        }

        public Criteria andCaidEqualTo(Integer value) {
            addCriterion("caid =", value, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidNotEqualTo(Integer value) {
            addCriterion("caid <>", value, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidGreaterThan(Integer value) {
            addCriterion("caid >", value, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("caid >=", value, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidLessThan(Integer value) {
            addCriterion("caid <", value, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidLessThanOrEqualTo(Integer value) {
            addCriterion("caid <=", value, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidIn(List<Integer> values) {
            addCriterion("caid in", values, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidNotIn(List<Integer> values) {
            addCriterion("caid not in", values, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidBetween(Integer value1, Integer value2) {
            addCriterion("caid between", value1, value2, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidNotBetween(Integer value1, Integer value2) {
            addCriterion("caid not between", value1, value2, "caid");
            return (Criteria) this;
        }

        public Criteria andCanameIsNull() {
            addCriterion("caname is null");
            return (Criteria) this;
        }

        public Criteria andCanameIsNotNull() {
            addCriterion("caname is not null");
            return (Criteria) this;
        }

        public Criteria andCanameEqualTo(String value) {
            addCriterion("caname =", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameNotEqualTo(String value) {
            addCriterion("caname <>", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameGreaterThan(String value) {
            addCriterion("caname >", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameGreaterThanOrEqualTo(String value) {
            addCriterion("caname >=", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameLessThan(String value) {
            addCriterion("caname <", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameLessThanOrEqualTo(String value) {
            addCriterion("caname <=", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameLike(String value) {
            addCriterion("caname like", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameNotLike(String value) {
            addCriterion("caname not like", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameIn(List<String> values) {
            addCriterion("caname in", values, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameNotIn(List<String> values) {
            addCriterion("caname not in", values, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameBetween(String value1, String value2) {
            addCriterion("caname between", value1, value2, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameNotBetween(String value1, String value2) {
            addCriterion("caname not between", value1, value2, "caname");
            return (Criteria) this;
        }

        public Criteria andCanumberIsNull() {
            addCriterion("canumber is null");
            return (Criteria) this;
        }

        public Criteria andCanumberIsNotNull() {
            addCriterion("canumber is not null");
            return (Criteria) this;
        }

        public Criteria andCanumberEqualTo(String value) {
            addCriterion("canumber =", value, "canumber");
            return (Criteria) this;
        }

        public Criteria andCanumberNotEqualTo(String value) {
            addCriterion("canumber <>", value, "canumber");
            return (Criteria) this;
        }

        public Criteria andCanumberGreaterThan(String value) {
            addCriterion("canumber >", value, "canumber");
            return (Criteria) this;
        }

        public Criteria andCanumberGreaterThanOrEqualTo(String value) {
            addCriterion("canumber >=", value, "canumber");
            return (Criteria) this;
        }

        public Criteria andCanumberLessThan(String value) {
            addCriterion("canumber <", value, "canumber");
            return (Criteria) this;
        }

        public Criteria andCanumberLessThanOrEqualTo(String value) {
            addCriterion("canumber <=", value, "canumber");
            return (Criteria) this;
        }

        public Criteria andCanumberLike(String value) {
            addCriterion("canumber like", value, "canumber");
            return (Criteria) this;
        }

        public Criteria andCanumberNotLike(String value) {
            addCriterion("canumber not like", value, "canumber");
            return (Criteria) this;
        }

        public Criteria andCanumberIn(List<String> values) {
            addCriterion("canumber in", values, "canumber");
            return (Criteria) this;
        }

        public Criteria andCanumberNotIn(List<String> values) {
            addCriterion("canumber not in", values, "canumber");
            return (Criteria) this;
        }

        public Criteria andCanumberBetween(String value1, String value2) {
            addCriterion("canumber between", value1, value2, "canumber");
            return (Criteria) this;
        }

        public Criteria andCanumberNotBetween(String value1, String value2) {
            addCriterion("canumber not between", value1, value2, "canumber");
            return (Criteria) this;
        }

        public Criteria andCastateIsNull() {
            addCriterion("castate is null");
            return (Criteria) this;
        }

        public Criteria andCastateIsNotNull() {
            addCriterion("castate is not null");
            return (Criteria) this;
        }

        public Criteria andCastateEqualTo(String value) {
            addCriterion("castate =", value, "castate");
            return (Criteria) this;
        }

        public Criteria andCastateNotEqualTo(String value) {
            addCriterion("castate <>", value, "castate");
            return (Criteria) this;
        }

        public Criteria andCastateGreaterThan(String value) {
            addCriterion("castate >", value, "castate");
            return (Criteria) this;
        }

        public Criteria andCastateGreaterThanOrEqualTo(String value) {
            addCriterion("castate >=", value, "castate");
            return (Criteria) this;
        }

        public Criteria andCastateLessThan(String value) {
            addCriterion("castate <", value, "castate");
            return (Criteria) this;
        }

        public Criteria andCastateLessThanOrEqualTo(String value) {
            addCriterion("castate <=", value, "castate");
            return (Criteria) this;
        }

        public Criteria andCastateLike(String value) {
            addCriterion("castate like", value, "castate");
            return (Criteria) this;
        }

        public Criteria andCastateNotLike(String value) {
            addCriterion("castate not like", value, "castate");
            return (Criteria) this;
        }

        public Criteria andCastateIn(List<String> values) {
            addCriterion("castate in", values, "castate");
            return (Criteria) this;
        }

        public Criteria andCastateNotIn(List<String> values) {
            addCriterion("castate not in", values, "castate");
            return (Criteria) this;
        }

        public Criteria andCastateBetween(String value1, String value2) {
            addCriterion("castate between", value1, value2, "castate");
            return (Criteria) this;
        }

        public Criteria andCastateNotBetween(String value1, String value2) {
            addCriterion("castate not between", value1, value2, "castate");
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