package com.xxgc.po;

import java.util.ArrayList;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
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

        public Criteria andArnumberIsNull() {
            addCriterion("arnumber is null");
            return (Criteria) this;
        }

        public Criteria andArnumberIsNotNull() {
            addCriterion("arnumber is not null");
            return (Criteria) this;
        }

        public Criteria andArnumberEqualTo(String value) {
            addCriterion("arnumber =", value, "arnumber");
            return (Criteria) this;
        }

        public Criteria andArnumberNotEqualTo(String value) {
            addCriterion("arnumber <>", value, "arnumber");
            return (Criteria) this;
        }

        public Criteria andArnumberGreaterThan(String value) {
            addCriterion("arnumber >", value, "arnumber");
            return (Criteria) this;
        }

        public Criteria andArnumberGreaterThanOrEqualTo(String value) {
            addCriterion("arnumber >=", value, "arnumber");
            return (Criteria) this;
        }

        public Criteria andArnumberLessThan(String value) {
            addCriterion("arnumber <", value, "arnumber");
            return (Criteria) this;
        }

        public Criteria andArnumberLessThanOrEqualTo(String value) {
            addCriterion("arnumber <=", value, "arnumber");
            return (Criteria) this;
        }

        public Criteria andArnumberLike(String value) {
            addCriterion("arnumber like", value, "arnumber");
            return (Criteria) this;
        }

        public Criteria andArnumberNotLike(String value) {
            addCriterion("arnumber not like", value, "arnumber");
            return (Criteria) this;
        }

        public Criteria andArnumberIn(List<String> values) {
            addCriterion("arnumber in", values, "arnumber");
            return (Criteria) this;
        }

        public Criteria andArnumberNotIn(List<String> values) {
            addCriterion("arnumber not in", values, "arnumber");
            return (Criteria) this;
        }

        public Criteria andArnumberBetween(String value1, String value2) {
            addCriterion("arnumber between", value1, value2, "arnumber");
            return (Criteria) this;
        }

        public Criteria andArnumberNotBetween(String value1, String value2) {
            addCriterion("arnumber not between", value1, value2, "arnumber");
            return (Criteria) this;
        }

        public Criteria andArtitleIsNull() {
            addCriterion("artitle is null");
            return (Criteria) this;
        }

        public Criteria andArtitleIsNotNull() {
            addCriterion("artitle is not null");
            return (Criteria) this;
        }

        public Criteria andArtitleEqualTo(String value) {
            addCriterion("artitle =", value, "artitle");
            return (Criteria) this;
        }

        public Criteria andArtitleNotEqualTo(String value) {
            addCriterion("artitle <>", value, "artitle");
            return (Criteria) this;
        }

        public Criteria andArtitleGreaterThan(String value) {
            addCriterion("artitle >", value, "artitle");
            return (Criteria) this;
        }

        public Criteria andArtitleGreaterThanOrEqualTo(String value) {
            addCriterion("artitle >=", value, "artitle");
            return (Criteria) this;
        }

        public Criteria andArtitleLessThan(String value) {
            addCriterion("artitle <", value, "artitle");
            return (Criteria) this;
        }

        public Criteria andArtitleLessThanOrEqualTo(String value) {
            addCriterion("artitle <=", value, "artitle");
            return (Criteria) this;
        }

        public Criteria andArtitleLike(String value) {
            addCriterion("artitle like", value, "artitle");
            return (Criteria) this;
        }

        public Criteria andArtitleNotLike(String value) {
            addCriterion("artitle not like", value, "artitle");
            return (Criteria) this;
        }

        public Criteria andArtitleIn(List<String> values) {
            addCriterion("artitle in", values, "artitle");
            return (Criteria) this;
        }

        public Criteria andArtitleNotIn(List<String> values) {
            addCriterion("artitle not in", values, "artitle");
            return (Criteria) this;
        }

        public Criteria andArtitleBetween(String value1, String value2) {
            addCriterion("artitle between", value1, value2, "artitle");
            return (Criteria) this;
        }

        public Criteria andArtitleNotBetween(String value1, String value2) {
            addCriterion("artitle not between", value1, value2, "artitle");
            return (Criteria) this;
        }

        public Criteria andArimageIsNull() {
            addCriterion("arimage is null");
            return (Criteria) this;
        }

        public Criteria andArimageIsNotNull() {
            addCriterion("arimage is not null");
            return (Criteria) this;
        }

        public Criteria andArimageEqualTo(String value) {
            addCriterion("arimage =", value, "arimage");
            return (Criteria) this;
        }

        public Criteria andArimageNotEqualTo(String value) {
            addCriterion("arimage <>", value, "arimage");
            return (Criteria) this;
        }

        public Criteria andArimageGreaterThan(String value) {
            addCriterion("arimage >", value, "arimage");
            return (Criteria) this;
        }

        public Criteria andArimageGreaterThanOrEqualTo(String value) {
            addCriterion("arimage >=", value, "arimage");
            return (Criteria) this;
        }

        public Criteria andArimageLessThan(String value) {
            addCriterion("arimage <", value, "arimage");
            return (Criteria) this;
        }

        public Criteria andArimageLessThanOrEqualTo(String value) {
            addCriterion("arimage <=", value, "arimage");
            return (Criteria) this;
        }

        public Criteria andArimageLike(String value) {
            addCriterion("arimage like", value, "arimage");
            return (Criteria) this;
        }

        public Criteria andArimageNotLike(String value) {
            addCriterion("arimage not like", value, "arimage");
            return (Criteria) this;
        }

        public Criteria andArimageIn(List<String> values) {
            addCriterion("arimage in", values, "arimage");
            return (Criteria) this;
        }

        public Criteria andArimageNotIn(List<String> values) {
            addCriterion("arimage not in", values, "arimage");
            return (Criteria) this;
        }

        public Criteria andArimageBetween(String value1, String value2) {
            addCriterion("arimage between", value1, value2, "arimage");
            return (Criteria) this;
        }

        public Criteria andArimageNotBetween(String value1, String value2) {
            addCriterion("arimage not between", value1, value2, "arimage");
            return (Criteria) this;
        }

        public Criteria andAruserIsNull() {
            addCriterion("aruser is null");
            return (Criteria) this;
        }

        public Criteria andAruserIsNotNull() {
            addCriterion("aruser is not null");
            return (Criteria) this;
        }

        public Criteria andAruserEqualTo(String value) {
            addCriterion("aruser =", value, "aruser");
            return (Criteria) this;
        }

        public Criteria andAruserNotEqualTo(String value) {
            addCriterion("aruser <>", value, "aruser");
            return (Criteria) this;
        }

        public Criteria andAruserGreaterThan(String value) {
            addCriterion("aruser >", value, "aruser");
            return (Criteria) this;
        }

        public Criteria andAruserGreaterThanOrEqualTo(String value) {
            addCriterion("aruser >=", value, "aruser");
            return (Criteria) this;
        }

        public Criteria andAruserLessThan(String value) {
            addCriterion("aruser <", value, "aruser");
            return (Criteria) this;
        }

        public Criteria andAruserLessThanOrEqualTo(String value) {
            addCriterion("aruser <=", value, "aruser");
            return (Criteria) this;
        }

        public Criteria andAruserLike(String value) {
            addCriterion("aruser like", value, "aruser");
            return (Criteria) this;
        }

        public Criteria andAruserNotLike(String value) {
            addCriterion("aruser not like", value, "aruser");
            return (Criteria) this;
        }

        public Criteria andAruserIn(List<String> values) {
            addCriterion("aruser in", values, "aruser");
            return (Criteria) this;
        }

        public Criteria andAruserNotIn(List<String> values) {
            addCriterion("aruser not in", values, "aruser");
            return (Criteria) this;
        }

        public Criteria andAruserBetween(String value1, String value2) {
            addCriterion("aruser between", value1, value2, "aruser");
            return (Criteria) this;
        }

        public Criteria andAruserNotBetween(String value1, String value2) {
            addCriterion("aruser not between", value1, value2, "aruser");
            return (Criteria) this;
        }

        public Criteria andArtimeIsNull() {
            addCriterion("artime is null");
            return (Criteria) this;
        }

        public Criteria andArtimeIsNotNull() {
            addCriterion("artime is not null");
            return (Criteria) this;
        }

        public Criteria andArtimeEqualTo(String value) {
            addCriterion("artime =", value, "artime");
            return (Criteria) this;
        }

        public Criteria andArtimeNotEqualTo(String value) {
            addCriterion("artime <>", value, "artime");
            return (Criteria) this;
        }

        public Criteria andArtimeGreaterThan(String value) {
            addCriterion("artime >", value, "artime");
            return (Criteria) this;
        }

        public Criteria andArtimeGreaterThanOrEqualTo(String value) {
            addCriterion("artime >=", value, "artime");
            return (Criteria) this;
        }

        public Criteria andArtimeLessThan(String value) {
            addCriterion("artime <", value, "artime");
            return (Criteria) this;
        }

        public Criteria andArtimeLessThanOrEqualTo(String value) {
            addCriterion("artime <=", value, "artime");
            return (Criteria) this;
        }

        public Criteria andArtimeLike(String value) {
            addCriterion("artime like", value, "artime");
            return (Criteria) this;
        }

        public Criteria andArtimeNotLike(String value) {
            addCriterion("artime not like", value, "artime");
            return (Criteria) this;
        }

        public Criteria andArtimeIn(List<String> values) {
            addCriterion("artime in", values, "artime");
            return (Criteria) this;
        }

        public Criteria andArtimeNotIn(List<String> values) {
            addCriterion("artime not in", values, "artime");
            return (Criteria) this;
        }

        public Criteria andArtimeBetween(String value1, String value2) {
            addCriterion("artime between", value1, value2, "artime");
            return (Criteria) this;
        }

        public Criteria andArtimeNotBetween(String value1, String value2) {
            addCriterion("artime not between", value1, value2, "artime");
            return (Criteria) this;
        }

        public Criteria andArstateIsNull() {
            addCriterion("arstate is null");
            return (Criteria) this;
        }

        public Criteria andArstateIsNotNull() {
            addCriterion("arstate is not null");
            return (Criteria) this;
        }

        public Criteria andArstateEqualTo(String value) {
            addCriterion("arstate =", value, "arstate");
            return (Criteria) this;
        }

        public Criteria andArstateNotEqualTo(String value) {
            addCriterion("arstate <>", value, "arstate");
            return (Criteria) this;
        }

        public Criteria andArstateGreaterThan(String value) {
            addCriterion("arstate >", value, "arstate");
            return (Criteria) this;
        }

        public Criteria andArstateGreaterThanOrEqualTo(String value) {
            addCriterion("arstate >=", value, "arstate");
            return (Criteria) this;
        }

        public Criteria andArstateLessThan(String value) {
            addCriterion("arstate <", value, "arstate");
            return (Criteria) this;
        }

        public Criteria andArstateLessThanOrEqualTo(String value) {
            addCriterion("arstate <=", value, "arstate");
            return (Criteria) this;
        }

        public Criteria andArstateLike(String value) {
            addCriterion("arstate like", value, "arstate");
            return (Criteria) this;
        }

        public Criteria andArstateNotLike(String value) {
            addCriterion("arstate not like", value, "arstate");
            return (Criteria) this;
        }

        public Criteria andArstateIn(List<String> values) {
            addCriterion("arstate in", values, "arstate");
            return (Criteria) this;
        }

        public Criteria andArstateNotIn(List<String> values) {
            addCriterion("arstate not in", values, "arstate");
            return (Criteria) this;
        }

        public Criteria andArstateBetween(String value1, String value2) {
            addCriterion("arstate between", value1, value2, "arstate");
            return (Criteria) this;
        }

        public Criteria andArstateNotBetween(String value1, String value2) {
            addCriterion("arstate not between", value1, value2, "arstate");
            return (Criteria) this;
        }

        public Criteria andClickIsNull() {
            addCriterion("click is null");
            return (Criteria) this;
        }

        public Criteria andClickIsNotNull() {
            addCriterion("click is not null");
            return (Criteria) this;
        }

        public Criteria andClickEqualTo(Integer value) {
            addCriterion("click =", value, "click");
            return (Criteria) this;
        }

        public Criteria andClickNotEqualTo(Integer value) {
            addCriterion("click <>", value, "click");
            return (Criteria) this;
        }

        public Criteria andClickGreaterThan(Integer value) {
            addCriterion("click >", value, "click");
            return (Criteria) this;
        }

        public Criteria andClickGreaterThanOrEqualTo(Integer value) {
            addCriterion("click >=", value, "click");
            return (Criteria) this;
        }

        public Criteria andClickLessThan(Integer value) {
            addCriterion("click <", value, "click");
            return (Criteria) this;
        }

        public Criteria andClickLessThanOrEqualTo(Integer value) {
            addCriterion("click <=", value, "click");
            return (Criteria) this;
        }

        public Criteria andClickIn(List<Integer> values) {
            addCriterion("click in", values, "click");
            return (Criteria) this;
        }

        public Criteria andClickNotIn(List<Integer> values) {
            addCriterion("click not in", values, "click");
            return (Criteria) this;
        }

        public Criteria andClickBetween(Integer value1, Integer value2) {
            addCriterion("click between", value1, value2, "click");
            return (Criteria) this;
        }

        public Criteria andClickNotBetween(Integer value1, Integer value2) {
            addCriterion("click not between", value1, value2, "click");
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