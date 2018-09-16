package com.zr.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaperExample() {
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
     * @date 2018-09-10
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

        public Criteria andPaIdIsNull() {
            addCriterion("pa_id is null");
            return (Criteria) this;
        }

        public Criteria andPaIdIsNotNull() {
            addCriterion("pa_id is not null");
            return (Criteria) this;
        }

        public Criteria andPaIdEqualTo(Integer value) {
            addCriterion("pa_id =", value, "paId");
            return (Criteria) this;
        }

        public Criteria andPaIdNotEqualTo(Integer value) {
            addCriterion("pa_id <>", value, "paId");
            return (Criteria) this;
        }

        public Criteria andPaIdGreaterThan(Integer value) {
            addCriterion("pa_id >", value, "paId");
            return (Criteria) this;
        }

        public Criteria andPaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pa_id >=", value, "paId");
            return (Criteria) this;
        }

        public Criteria andPaIdLessThan(Integer value) {
            addCriterion("pa_id <", value, "paId");
            return (Criteria) this;
        }

        public Criteria andPaIdLessThanOrEqualTo(Integer value) {
            addCriterion("pa_id <=", value, "paId");
            return (Criteria) this;
        }

        public Criteria andPaIdIn(List<Integer> values) {
            addCriterion("pa_id in", values, "paId");
            return (Criteria) this;
        }

        public Criteria andPaIdNotIn(List<Integer> values) {
            addCriterion("pa_id not in", values, "paId");
            return (Criteria) this;
        }

        public Criteria andPaIdBetween(Integer value1, Integer value2) {
            addCriterion("pa_id between", value1, value2, "paId");
            return (Criteria) this;
        }

        public Criteria andPaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pa_id not between", value1, value2, "paId");
            return (Criteria) this;
        }

        public Criteria andPathIsNull() {
            addCriterion("path is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("path is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("path =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("path <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("path >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("path >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("path <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("path <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("path like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("path not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("path in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("path not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("path between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("path not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPapernameIsNull() {
            addCriterion("paperName is null");
            return (Criteria) this;
        }

        public Criteria andPapernameIsNotNull() {
            addCriterion("paperName is not null");
            return (Criteria) this;
        }

        public Criteria andPapernameEqualTo(String value) {
            addCriterion("paperName =", value, "papername");
            return (Criteria) this;
        }

        public Criteria andPapernameNotEqualTo(String value) {
            addCriterion("paperName <>", value, "papername");
            return (Criteria) this;
        }

        public Criteria andPapernameGreaterThan(String value) {
            addCriterion("paperName >", value, "papername");
            return (Criteria) this;
        }

        public Criteria andPapernameGreaterThanOrEqualTo(String value) {
            addCriterion("paperName >=", value, "papername");
            return (Criteria) this;
        }

        public Criteria andPapernameLessThan(String value) {
            addCriterion("paperName <", value, "papername");
            return (Criteria) this;
        }

        public Criteria andPapernameLessThanOrEqualTo(String value) {
            addCriterion("paperName <=", value, "papername");
            return (Criteria) this;
        }

        public Criteria andPapernameLike(String value) {
            addCriterion("paperName like", value, "papername");
            return (Criteria) this;
        }

        public Criteria andPapernameNotLike(String value) {
            addCriterion("paperName not like", value, "papername");
            return (Criteria) this;
        }

        public Criteria andPapernameIn(List<String> values) {
            addCriterion("paperName in", values, "papername");
            return (Criteria) this;
        }

        public Criteria andPapernameNotIn(List<String> values) {
            addCriterion("paperName not in", values, "papername");
            return (Criteria) this;
        }

        public Criteria andPapernameBetween(String value1, String value2) {
            addCriterion("paperName between", value1, value2, "papername");
            return (Criteria) this;
        }

        public Criteria andPapernameNotBetween(String value1, String value2) {
            addCriterion("paperName not between", value1, value2, "papername");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andPaperdescIsNull() {
            addCriterion("paperDesc is null");
            return (Criteria) this;
        }

        public Criteria andPaperdescIsNotNull() {
            addCriterion("paperDesc is not null");
            return (Criteria) this;
        }

        public Criteria andPaperdescEqualTo(String value) {
            addCriterion("paperDesc =", value, "paperdesc");
            return (Criteria) this;
        }

        public Criteria andPaperdescNotEqualTo(String value) {
            addCriterion("paperDesc <>", value, "paperdesc");
            return (Criteria) this;
        }

        public Criteria andPaperdescGreaterThan(String value) {
            addCriterion("paperDesc >", value, "paperdesc");
            return (Criteria) this;
        }

        public Criteria andPaperdescGreaterThanOrEqualTo(String value) {
            addCriterion("paperDesc >=", value, "paperdesc");
            return (Criteria) this;
        }

        public Criteria andPaperdescLessThan(String value) {
            addCriterion("paperDesc <", value, "paperdesc");
            return (Criteria) this;
        }

        public Criteria andPaperdescLessThanOrEqualTo(String value) {
            addCriterion("paperDesc <=", value, "paperdesc");
            return (Criteria) this;
        }

        public Criteria andPaperdescLike(String value) {
            addCriterion("paperDesc like", value, "paperdesc");
            return (Criteria) this;
        }

        public Criteria andPaperdescNotLike(String value) {
            addCriterion("paperDesc not like", value, "paperdesc");
            return (Criteria) this;
        }

        public Criteria andPaperdescIn(List<String> values) {
            addCriterion("paperDesc in", values, "paperdesc");
            return (Criteria) this;
        }

        public Criteria andPaperdescNotIn(List<String> values) {
            addCriterion("paperDesc not in", values, "paperdesc");
            return (Criteria) this;
        }

        public Criteria andPaperdescBetween(String value1, String value2) {
            addCriterion("paperDesc between", value1, value2, "paperdesc");
            return (Criteria) this;
        }

        public Criteria andPaperdescNotBetween(String value1, String value2) {
            addCriterion("paperDesc not between", value1, value2, "paperdesc");
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
     * @date 2018-09-10
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