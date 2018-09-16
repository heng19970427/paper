package com.zr.pojo;

import java.util.ArrayList;
import java.util.List;

public class SelectquesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SelectquesExample() {
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
     * @date 2018-08-29
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

        public Criteria andSIdIsNull() {
            addCriterion("s_id is null");
            return (Criteria) this;
        }

        public Criteria andSIdIsNotNull() {
            addCriterion("s_id is not null");
            return (Criteria) this;
        }

        public Criteria andSIdEqualTo(Integer value) {
            addCriterion("s_id =", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotEqualTo(Integer value) {
            addCriterion("s_id <>", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThan(Integer value) {
            addCriterion("s_id >", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_id >=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThan(Integer value) {
            addCriterion("s_id <", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThanOrEqualTo(Integer value) {
            addCriterion("s_id <=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdIn(List<Integer> values) {
            addCriterion("s_id in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotIn(List<Integer> values) {
            addCriterion("s_id not in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdBetween(Integer value1, Integer value2) {
            addCriterion("s_id between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotBetween(Integer value1, Integer value2) {
            addCriterion("s_id not between", value1, value2, "sId");
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

        public Criteria andKIdIsNull() {
            addCriterion("k_id is null");
            return (Criteria) this;
        }

        public Criteria andKIdIsNotNull() {
            addCriterion("k_id is not null");
            return (Criteria) this;
        }

        public Criteria andKIdEqualTo(Integer value) {
            addCriterion("k_id =", value, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdNotEqualTo(Integer value) {
            addCriterion("k_id <>", value, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdGreaterThan(Integer value) {
            addCriterion("k_id >", value, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("k_id >=", value, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdLessThan(Integer value) {
            addCriterion("k_id <", value, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdLessThanOrEqualTo(Integer value) {
            addCriterion("k_id <=", value, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdIn(List<Integer> values) {
            addCriterion("k_id in", values, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdNotIn(List<Integer> values) {
            addCriterion("k_id not in", values, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdBetween(Integer value1, Integer value2) {
            addCriterion("k_id between", value1, value2, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdNotBetween(Integer value1, Integer value2) {
            addCriterion("k_id not between", value1, value2, "kId");
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

        public Criteria andQcIdIsNull() {
            addCriterion("qc_id is null");
            return (Criteria) this;
        }

        public Criteria andQcIdIsNotNull() {
            addCriterion("qc_id is not null");
            return (Criteria) this;
        }

        public Criteria andQcIdEqualTo(Integer value) {
            addCriterion("qc_id =", value, "qcId");
            return (Criteria) this;
        }

        public Criteria andQcIdNotEqualTo(Integer value) {
            addCriterion("qc_id <>", value, "qcId");
            return (Criteria) this;
        }

        public Criteria andQcIdGreaterThan(Integer value) {
            addCriterion("qc_id >", value, "qcId");
            return (Criteria) this;
        }

        public Criteria andQcIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("qc_id >=", value, "qcId");
            return (Criteria) this;
        }

        public Criteria andQcIdLessThan(Integer value) {
            addCriterion("qc_id <", value, "qcId");
            return (Criteria) this;
        }

        public Criteria andQcIdLessThanOrEqualTo(Integer value) {
            addCriterion("qc_id <=", value, "qcId");
            return (Criteria) this;
        }

        public Criteria andQcIdIn(List<Integer> values) {
            addCriterion("qc_id in", values, "qcId");
            return (Criteria) this;
        }

        public Criteria andQcIdNotIn(List<Integer> values) {
            addCriterion("qc_id not in", values, "qcId");
            return (Criteria) this;
        }

        public Criteria andQcIdBetween(Integer value1, Integer value2) {
            addCriterion("qc_id between", value1, value2, "qcId");
            return (Criteria) this;
        }

        public Criteria andQcIdNotBetween(Integer value1, Integer value2) {
            addCriterion("qc_id not between", value1, value2, "qcId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andOptionIsNull() {
            addCriterion("option is null");
            return (Criteria) this;
        }

        public Criteria andOptionIsNotNull() {
            addCriterion("option is not null");
            return (Criteria) this;
        }

        public Criteria andOptionEqualTo(String value) {
            addCriterion("option =", value, "option");
            return (Criteria) this;
        }

        public Criteria andOptionNotEqualTo(String value) {
            addCriterion("option <>", value, "option");
            return (Criteria) this;
        }

        public Criteria andOptionGreaterThan(String value) {
            addCriterion("option >", value, "option");
            return (Criteria) this;
        }

        public Criteria andOptionGreaterThanOrEqualTo(String value) {
            addCriterion("option >=", value, "option");
            return (Criteria) this;
        }

        public Criteria andOptionLessThan(String value) {
            addCriterion("option <", value, "option");
            return (Criteria) this;
        }

        public Criteria andOptionLessThanOrEqualTo(String value) {
            addCriterion("option <=", value, "option");
            return (Criteria) this;
        }

        public Criteria andOptionLike(String value) {
            addCriterion("option like", value, "option");
            return (Criteria) this;
        }

        public Criteria andOptionNotLike(String value) {
            addCriterion("option not like", value, "option");
            return (Criteria) this;
        }

        public Criteria andOptionIn(List<String> values) {
            addCriterion("option in", values, "option");
            return (Criteria) this;
        }

        public Criteria andOptionNotIn(List<String> values) {
            addCriterion("option not in", values, "option");
            return (Criteria) this;
        }

        public Criteria andOptionBetween(String value1, String value2) {
            addCriterion("option between", value1, value2, "option");
            return (Criteria) this;
        }

        public Criteria andOptionNotBetween(String value1, String value2) {
            addCriterion("option not between", value1, value2, "option");
            return (Criteria) this;
        }

        public Criteria andDifficultylevelIsNull() {
            addCriterion("difficultyLevel is null");
            return (Criteria) this;
        }

        public Criteria andDifficultylevelIsNotNull() {
            addCriterion("difficultyLevel is not null");
            return (Criteria) this;
        }

        public Criteria andDifficultylevelEqualTo(Integer value) {
            addCriterion("difficultyLevel =", value, "difficultylevel");
            return (Criteria) this;
        }

        public Criteria andDifficultylevelNotEqualTo(Integer value) {
            addCriterion("difficultyLevel <>", value, "difficultylevel");
            return (Criteria) this;
        }

        public Criteria andDifficultylevelGreaterThan(Integer value) {
            addCriterion("difficultyLevel >", value, "difficultylevel");
            return (Criteria) this;
        }

        public Criteria andDifficultylevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("difficultyLevel >=", value, "difficultylevel");
            return (Criteria) this;
        }

        public Criteria andDifficultylevelLessThan(Integer value) {
            addCriterion("difficultyLevel <", value, "difficultylevel");
            return (Criteria) this;
        }

        public Criteria andDifficultylevelLessThanOrEqualTo(Integer value) {
            addCriterion("difficultyLevel <=", value, "difficultylevel");
            return (Criteria) this;
        }

        public Criteria andDifficultylevelIn(List<Integer> values) {
            addCriterion("difficultyLevel in", values, "difficultylevel");
            return (Criteria) this;
        }

        public Criteria andDifficultylevelNotIn(List<Integer> values) {
            addCriterion("difficultyLevel not in", values, "difficultylevel");
            return (Criteria) this;
        }

        public Criteria andDifficultylevelBetween(Integer value1, Integer value2) {
            addCriterion("difficultyLevel between", value1, value2, "difficultylevel");
            return (Criteria) this;
        }

        public Criteria andDifficultylevelNotBetween(Integer value1, Integer value2) {
            addCriterion("difficultyLevel not between", value1, value2, "difficultylevel");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("answer is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("answer is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("answer =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("answer <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("answer >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("answer >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("answer <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("answer <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("answer like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("answer not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("answer in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("answer not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("answer between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("answer not between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andSelectednumIsNull() {
            addCriterion("selectedNum is null");
            return (Criteria) this;
        }

        public Criteria andSelectednumIsNotNull() {
            addCriterion("selectedNum is not null");
            return (Criteria) this;
        }

        public Criteria andSelectednumEqualTo(Integer value) {
            addCriterion("selectedNum =", value, "selectednum");
            return (Criteria) this;
        }

        public Criteria andSelectednumNotEqualTo(Integer value) {
            addCriterion("selectedNum <>", value, "selectednum");
            return (Criteria) this;
        }

        public Criteria andSelectednumGreaterThan(Integer value) {
            addCriterion("selectedNum >", value, "selectednum");
            return (Criteria) this;
        }

        public Criteria andSelectednumGreaterThanOrEqualTo(Integer value) {
            addCriterion("selectedNum >=", value, "selectednum");
            return (Criteria) this;
        }

        public Criteria andSelectednumLessThan(Integer value) {
            addCriterion("selectedNum <", value, "selectednum");
            return (Criteria) this;
        }

        public Criteria andSelectednumLessThanOrEqualTo(Integer value) {
            addCriterion("selectedNum <=", value, "selectednum");
            return (Criteria) this;
        }

        public Criteria andSelectednumIn(List<Integer> values) {
            addCriterion("selectedNum in", values, "selectednum");
            return (Criteria) this;
        }

        public Criteria andSelectednumNotIn(List<Integer> values) {
            addCriterion("selectedNum not in", values, "selectednum");
            return (Criteria) this;
        }

        public Criteria andSelectednumBetween(Integer value1, Integer value2) {
            addCriterion("selectedNum between", value1, value2, "selectednum");
            return (Criteria) this;
        }

        public Criteria andSelectednumNotBetween(Integer value1, Integer value2) {
            addCriterion("selectedNum not between", value1, value2, "selectednum");
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
     * @date 2018-08-29
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