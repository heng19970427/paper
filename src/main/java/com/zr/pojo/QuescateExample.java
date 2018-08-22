package com.zr.pojo;

import java.util.ArrayList;
import java.util.List;

public class QuescateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuescateExample() {
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

    /**
     * 
     * 
     * @author wcyong
     * 
     * @date 2018-08-13
     */
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

        public Criteria andQIdIsNull() {
            addCriterion("q_id is null");
            return (Criteria) this;
        }

        public Criteria andQIdIsNotNull() {
            addCriterion("q_id is not null");
            return (Criteria) this;
        }

        public Criteria andQIdEqualTo(Integer value) {
            addCriterion("q_id =", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotEqualTo(Integer value) {
            addCriterion("q_id <>", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdGreaterThan(Integer value) {
            addCriterion("q_id >", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("q_id >=", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdLessThan(Integer value) {
            addCriterion("q_id <", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdLessThanOrEqualTo(Integer value) {
            addCriterion("q_id <=", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdIn(List<Integer> values) {
            addCriterion("q_id in", values, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotIn(List<Integer> values) {
            addCriterion("q_id not in", values, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdBetween(Integer value1, Integer value2) {
            addCriterion("q_id between", value1, value2, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotBetween(Integer value1, Integer value2) {
            addCriterion("q_id not between", value1, value2, "qId");
            return (Criteria) this;
        }

        public Criteria andCIdIsNull() {
            addCriterion("c_id is null");
            return (Criteria) this;
        }

        public Criteria andCIdIsNotNull() {
            addCriterion("c_id is not null");
            return (Criteria) this;
        }

        public Criteria andCIdEqualTo(Integer value) {
            addCriterion("c_id =", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotEqualTo(Integer value) {
            addCriterion("c_id <>", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThan(Integer value) {
            addCriterion("c_id >", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_id >=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThan(Integer value) {
            addCriterion("c_id <", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThanOrEqualTo(Integer value) {
            addCriterion("c_id <=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdIn(List<Integer> values) {
            addCriterion("c_id in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotIn(List<Integer> values) {
            addCriterion("c_id not in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdBetween(Integer value1, Integer value2) {
            addCriterion("c_id between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotBetween(Integer value1, Integer value2) {
            addCriterion("c_id not between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andQcnameIsNull() {
            addCriterion("qcName is null");
            return (Criteria) this;
        }

        public Criteria andQcnameIsNotNull() {
            addCriterion("qcName is not null");
            return (Criteria) this;
        }

        public Criteria andQcnameEqualTo(String value) {
            addCriterion("qcName =", value, "qcname");
            return (Criteria) this;
        }

        public Criteria andQcnameNotEqualTo(String value) {
            addCriterion("qcName <>", value, "qcname");
            return (Criteria) this;
        }

        public Criteria andQcnameGreaterThan(String value) {
            addCriterion("qcName >", value, "qcname");
            return (Criteria) this;
        }

        public Criteria andQcnameGreaterThanOrEqualTo(String value) {
            addCriterion("qcName >=", value, "qcname");
            return (Criteria) this;
        }

        public Criteria andQcnameLessThan(String value) {
            addCriterion("qcName <", value, "qcname");
            return (Criteria) this;
        }

        public Criteria andQcnameLessThanOrEqualTo(String value) {
            addCriterion("qcName <=", value, "qcname");
            return (Criteria) this;
        }

        public Criteria andQcnameLike(String value) {
            addCriterion("qcName like", value, "qcname");
            return (Criteria) this;
        }

        public Criteria andQcnameNotLike(String value) {
            addCriterion("qcName not like", value, "qcname");
            return (Criteria) this;
        }

        public Criteria andQcnameIn(List<String> values) {
            addCriterion("qcName in", values, "qcname");
            return (Criteria) this;
        }

        public Criteria andQcnameNotIn(List<String> values) {
            addCriterion("qcName not in", values, "qcname");
            return (Criteria) this;
        }

        public Criteria andQcnameBetween(String value1, String value2) {
            addCriterion("qcName between", value1, value2, "qcname");
            return (Criteria) this;
        }

        public Criteria andQcnameNotBetween(String value1, String value2) {
            addCriterion("qcName not between", value1, value2, "qcname");
            return (Criteria) this;
        }

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(Integer value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(Integer value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(Integer value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(Integer value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<Integer> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<Integer> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(Integer value1, Integer value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andBlanknumIsNull() {
            addCriterion("BlankNum is null");
            return (Criteria) this;
        }

        public Criteria andBlanknumIsNotNull() {
            addCriterion("BlankNum is not null");
            return (Criteria) this;
        }

        public Criteria andBlanknumEqualTo(Integer value) {
            addCriterion("BlankNum =", value, "blanknum");
            return (Criteria) this;
        }

        public Criteria andBlanknumNotEqualTo(Integer value) {
            addCriterion("BlankNum <>", value, "blanknum");
            return (Criteria) this;
        }

        public Criteria andBlanknumGreaterThan(Integer value) {
            addCriterion("BlankNum >", value, "blanknum");
            return (Criteria) this;
        }

        public Criteria andBlanknumGreaterThanOrEqualTo(Integer value) {
            addCriterion("BlankNum >=", value, "blanknum");
            return (Criteria) this;
        }

        public Criteria andBlanknumLessThan(Integer value) {
            addCriterion("BlankNum <", value, "blanknum");
            return (Criteria) this;
        }

        public Criteria andBlanknumLessThanOrEqualTo(Integer value) {
            addCriterion("BlankNum <=", value, "blanknum");
            return (Criteria) this;
        }

        public Criteria andBlanknumIn(List<Integer> values) {
            addCriterion("BlankNum in", values, "blanknum");
            return (Criteria) this;
        }

        public Criteria andBlanknumNotIn(List<Integer> values) {
            addCriterion("BlankNum not in", values, "blanknum");
            return (Criteria) this;
        }

        public Criteria andBlanknumBetween(Integer value1, Integer value2) {
            addCriterion("BlankNum between", value1, value2, "blanknum");
            return (Criteria) this;
        }

        public Criteria andBlanknumNotBetween(Integer value1, Integer value2) {
            addCriterion("BlankNum not between", value1, value2, "blanknum");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 
     * 
     * @author wcyong
     * 
     * @date 2018-08-13
     */
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