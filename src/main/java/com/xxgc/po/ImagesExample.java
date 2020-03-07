package com.xxgc.po;

import java.util.ArrayList;
import java.util.List;

public class ImagesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImagesExample() {
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

        public Criteria andImidIsNull() {
            addCriterion("imid is null");
            return (Criteria) this;
        }

        public Criteria andImidIsNotNull() {
            addCriterion("imid is not null");
            return (Criteria) this;
        }

        public Criteria andImidEqualTo(Integer value) {
            addCriterion("imid =", value, "imid");
            return (Criteria) this;
        }

        public Criteria andImidNotEqualTo(Integer value) {
            addCriterion("imid <>", value, "imid");
            return (Criteria) this;
        }

        public Criteria andImidGreaterThan(Integer value) {
            addCriterion("imid >", value, "imid");
            return (Criteria) this;
        }

        public Criteria andImidGreaterThanOrEqualTo(Integer value) {
            addCriterion("imid >=", value, "imid");
            return (Criteria) this;
        }

        public Criteria andImidLessThan(Integer value) {
            addCriterion("imid <", value, "imid");
            return (Criteria) this;
        }

        public Criteria andImidLessThanOrEqualTo(Integer value) {
            addCriterion("imid <=", value, "imid");
            return (Criteria) this;
        }

        public Criteria andImidIn(List<Integer> values) {
            addCriterion("imid in", values, "imid");
            return (Criteria) this;
        }

        public Criteria andImidNotIn(List<Integer> values) {
            addCriterion("imid not in", values, "imid");
            return (Criteria) this;
        }

        public Criteria andImidBetween(Integer value1, Integer value2) {
            addCriterion("imid between", value1, value2, "imid");
            return (Criteria) this;
        }

        public Criteria andImidNotBetween(Integer value1, Integer value2) {
            addCriterion("imid not between", value1, value2, "imid");
            return (Criteria) this;
        }

        public Criteria andImtitleIsNull() {
            addCriterion("imtitle is null");
            return (Criteria) this;
        }

        public Criteria andImtitleIsNotNull() {
            addCriterion("imtitle is not null");
            return (Criteria) this;
        }

        public Criteria andImtitleEqualTo(String value) {
            addCriterion("imtitle =", value, "imtitle");
            return (Criteria) this;
        }

        public Criteria andImtitleNotEqualTo(String value) {
            addCriterion("imtitle <>", value, "imtitle");
            return (Criteria) this;
        }

        public Criteria andImtitleGreaterThan(String value) {
            addCriterion("imtitle >", value, "imtitle");
            return (Criteria) this;
        }

        public Criteria andImtitleGreaterThanOrEqualTo(String value) {
            addCriterion("imtitle >=", value, "imtitle");
            return (Criteria) this;
        }

        public Criteria andImtitleLessThan(String value) {
            addCriterion("imtitle <", value, "imtitle");
            return (Criteria) this;
        }

        public Criteria andImtitleLessThanOrEqualTo(String value) {
            addCriterion("imtitle <=", value, "imtitle");
            return (Criteria) this;
        }

        public Criteria andImtitleLike(String value) {
            addCriterion("imtitle like", value, "imtitle");
            return (Criteria) this;
        }

        public Criteria andImtitleNotLike(String value) {
            addCriterion("imtitle not like", value, "imtitle");
            return (Criteria) this;
        }

        public Criteria andImtitleIn(List<String> values) {
            addCriterion("imtitle in", values, "imtitle");
            return (Criteria) this;
        }

        public Criteria andImtitleNotIn(List<String> values) {
            addCriterion("imtitle not in", values, "imtitle");
            return (Criteria) this;
        }

        public Criteria andImtitleBetween(String value1, String value2) {
            addCriterion("imtitle between", value1, value2, "imtitle");
            return (Criteria) this;
        }

        public Criteria andImtitleNotBetween(String value1, String value2) {
            addCriterion("imtitle not between", value1, value2, "imtitle");
            return (Criteria) this;
        }

        public Criteria andImnameIsNull() {
            addCriterion("imname is null");
            return (Criteria) this;
        }

        public Criteria andImnameIsNotNull() {
            addCriterion("imname is not null");
            return (Criteria) this;
        }

        public Criteria andImnameEqualTo(String value) {
            addCriterion("imname =", value, "imname");
            return (Criteria) this;
        }

        public Criteria andImnameNotEqualTo(String value) {
            addCriterion("imname <>", value, "imname");
            return (Criteria) this;
        }

        public Criteria andImnameGreaterThan(String value) {
            addCriterion("imname >", value, "imname");
            return (Criteria) this;
        }

        public Criteria andImnameGreaterThanOrEqualTo(String value) {
            addCriterion("imname >=", value, "imname");
            return (Criteria) this;
        }

        public Criteria andImnameLessThan(String value) {
            addCriterion("imname <", value, "imname");
            return (Criteria) this;
        }

        public Criteria andImnameLessThanOrEqualTo(String value) {
            addCriterion("imname <=", value, "imname");
            return (Criteria) this;
        }

        public Criteria andImnameLike(String value) {
            addCriterion("imname like", value, "imname");
            return (Criteria) this;
        }

        public Criteria andImnameNotLike(String value) {
            addCriterion("imname not like", value, "imname");
            return (Criteria) this;
        }

        public Criteria andImnameIn(List<String> values) {
            addCriterion("imname in", values, "imname");
            return (Criteria) this;
        }

        public Criteria andImnameNotIn(List<String> values) {
            addCriterion("imname not in", values, "imname");
            return (Criteria) this;
        }

        public Criteria andImnameBetween(String value1, String value2) {
            addCriterion("imname between", value1, value2, "imname");
            return (Criteria) this;
        }

        public Criteria andImnameNotBetween(String value1, String value2) {
            addCriterion("imname not between", value1, value2, "imname");
            return (Criteria) this;
        }

        public Criteria andImdateIsNull() {
            addCriterion("imdate is null");
            return (Criteria) this;
        }

        public Criteria andImdateIsNotNull() {
            addCriterion("imdate is not null");
            return (Criteria) this;
        }

        public Criteria andImdateEqualTo(String value) {
            addCriterion("imdate =", value, "imdate");
            return (Criteria) this;
        }

        public Criteria andImdateNotEqualTo(String value) {
            addCriterion("imdate <>", value, "imdate");
            return (Criteria) this;
        }

        public Criteria andImdateGreaterThan(String value) {
            addCriterion("imdate >", value, "imdate");
            return (Criteria) this;
        }

        public Criteria andImdateGreaterThanOrEqualTo(String value) {
            addCriterion("imdate >=", value, "imdate");
            return (Criteria) this;
        }

        public Criteria andImdateLessThan(String value) {
            addCriterion("imdate <", value, "imdate");
            return (Criteria) this;
        }

        public Criteria andImdateLessThanOrEqualTo(String value) {
            addCriterion("imdate <=", value, "imdate");
            return (Criteria) this;
        }

        public Criteria andImdateLike(String value) {
            addCriterion("imdate like", value, "imdate");
            return (Criteria) this;
        }

        public Criteria andImdateNotLike(String value) {
            addCriterion("imdate not like", value, "imdate");
            return (Criteria) this;
        }

        public Criteria andImdateIn(List<String> values) {
            addCriterion("imdate in", values, "imdate");
            return (Criteria) this;
        }

        public Criteria andImdateNotIn(List<String> values) {
            addCriterion("imdate not in", values, "imdate");
            return (Criteria) this;
        }

        public Criteria andImdateBetween(String value1, String value2) {
            addCriterion("imdate between", value1, value2, "imdate");
            return (Criteria) this;
        }

        public Criteria andImdateNotBetween(String value1, String value2) {
            addCriterion("imdate not between", value1, value2, "imdate");
            return (Criteria) this;
        }

        public Criteria andImstateIsNull() {
            addCriterion("imstate is null");
            return (Criteria) this;
        }

        public Criteria andImstateIsNotNull() {
            addCriterion("imstate is not null");
            return (Criteria) this;
        }

        public Criteria andImstateEqualTo(String value) {
            addCriterion("imstate =", value, "imstate");
            return (Criteria) this;
        }

        public Criteria andImstateNotEqualTo(String value) {
            addCriterion("imstate <>", value, "imstate");
            return (Criteria) this;
        }

        public Criteria andImstateGreaterThan(String value) {
            addCriterion("imstate >", value, "imstate");
            return (Criteria) this;
        }

        public Criteria andImstateGreaterThanOrEqualTo(String value) {
            addCriterion("imstate >=", value, "imstate");
            return (Criteria) this;
        }

        public Criteria andImstateLessThan(String value) {
            addCriterion("imstate <", value, "imstate");
            return (Criteria) this;
        }

        public Criteria andImstateLessThanOrEqualTo(String value) {
            addCriterion("imstate <=", value, "imstate");
            return (Criteria) this;
        }

        public Criteria andImstateLike(String value) {
            addCriterion("imstate like", value, "imstate");
            return (Criteria) this;
        }

        public Criteria andImstateNotLike(String value) {
            addCriterion("imstate not like", value, "imstate");
            return (Criteria) this;
        }

        public Criteria andImstateIn(List<String> values) {
            addCriterion("imstate in", values, "imstate");
            return (Criteria) this;
        }

        public Criteria andImstateNotIn(List<String> values) {
            addCriterion("imstate not in", values, "imstate");
            return (Criteria) this;
        }

        public Criteria andImstateBetween(String value1, String value2) {
            addCriterion("imstate between", value1, value2, "imstate");
            return (Criteria) this;
        }

        public Criteria andImstateNotBetween(String value1, String value2) {
            addCriterion("imstate not between", value1, value2, "imstate");
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