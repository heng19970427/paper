package com.zr.pojo;

import java.util.ArrayList;
import java.util.List;

public class KnowledgetempletExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KnowledgetempletExample() {
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
     * @date 2018-08-31
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

        public Criteria andKtIdIsNull() {
            addCriterion("kt_id is null");
            return (Criteria) this;
        }

        public Criteria andKtIdIsNotNull() {
            addCriterion("kt_id is not null");
            return (Criteria) this;
        }

        public Criteria andKtIdEqualTo(Integer value) {
            addCriterion("kt_id =", value, "ktId");
            return (Criteria) this;
        }

        public Criteria andKtIdNotEqualTo(Integer value) {
            addCriterion("kt_id <>", value, "ktId");
            return (Criteria) this;
        }

        public Criteria andKtIdGreaterThan(Integer value) {
            addCriterion("kt_id >", value, "ktId");
            return (Criteria) this;
        }

        public Criteria andKtIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("kt_id >=", value, "ktId");
            return (Criteria) this;
        }

        public Criteria andKtIdLessThan(Integer value) {
            addCriterion("kt_id <", value, "ktId");
            return (Criteria) this;
        }

        public Criteria andKtIdLessThanOrEqualTo(Integer value) {
            addCriterion("kt_id <=", value, "ktId");
            return (Criteria) this;
        }

        public Criteria andKtIdIn(List<Integer> values) {
            addCriterion("kt_id in", values, "ktId");
            return (Criteria) this;
        }

        public Criteria andKtIdNotIn(List<Integer> values) {
            addCriterion("kt_id not in", values, "ktId");
            return (Criteria) this;
        }

        public Criteria andKtIdBetween(Integer value1, Integer value2) {
            addCriterion("kt_id between", value1, value2, "ktId");
            return (Criteria) this;
        }

        public Criteria andKtIdNotBetween(Integer value1, Integer value2) {
            addCriterion("kt_id not between", value1, value2, "ktId");
            return (Criteria) this;
        }

        public Criteria andPtIdIsNull() {
            addCriterion("pt_id is null");
            return (Criteria) this;
        }

        public Criteria andPtIdIsNotNull() {
            addCriterion("pt_id is not null");
            return (Criteria) this;
        }

        public Criteria andPtIdEqualTo(Integer value) {
            addCriterion("pt_id =", value, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdNotEqualTo(Integer value) {
            addCriterion("pt_id <>", value, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdGreaterThan(Integer value) {
            addCriterion("pt_id >", value, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pt_id >=", value, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdLessThan(Integer value) {
            addCriterion("pt_id <", value, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdLessThanOrEqualTo(Integer value) {
            addCriterion("pt_id <=", value, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdIn(List<Integer> values) {
            addCriterion("pt_id in", values, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdNotIn(List<Integer> values) {
            addCriterion("pt_id not in", values, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdBetween(Integer value1, Integer value2) {
            addCriterion("pt_id between", value1, value2, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pt_id not between", value1, value2, "ptId");
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

        public Criteria andJudgequesnumIsNull() {
            addCriterion("judgeQuesNum is null");
            return (Criteria) this;
        }

        public Criteria andJudgequesnumIsNotNull() {
            addCriterion("judgeQuesNum is not null");
            return (Criteria) this;
        }

        public Criteria andJudgequesnumEqualTo(Integer value) {
            addCriterion("judgeQuesNum =", value, "judgequesnum");
            return (Criteria) this;
        }

        public Criteria andJudgequesnumNotEqualTo(Integer value) {
            addCriterion("judgeQuesNum <>", value, "judgequesnum");
            return (Criteria) this;
        }

        public Criteria andJudgequesnumGreaterThan(Integer value) {
            addCriterion("judgeQuesNum >", value, "judgequesnum");
            return (Criteria) this;
        }

        public Criteria andJudgequesnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("judgeQuesNum >=", value, "judgequesnum");
            return (Criteria) this;
        }

        public Criteria andJudgequesnumLessThan(Integer value) {
            addCriterion("judgeQuesNum <", value, "judgequesnum");
            return (Criteria) this;
        }

        public Criteria andJudgequesnumLessThanOrEqualTo(Integer value) {
            addCriterion("judgeQuesNum <=", value, "judgequesnum");
            return (Criteria) this;
        }

        public Criteria andJudgequesnumIn(List<Integer> values) {
            addCriterion("judgeQuesNum in", values, "judgequesnum");
            return (Criteria) this;
        }

        public Criteria andJudgequesnumNotIn(List<Integer> values) {
            addCriterion("judgeQuesNum not in", values, "judgequesnum");
            return (Criteria) this;
        }

        public Criteria andJudgequesnumBetween(Integer value1, Integer value2) {
            addCriterion("judgeQuesNum between", value1, value2, "judgequesnum");
            return (Criteria) this;
        }

        public Criteria andJudgequesnumNotBetween(Integer value1, Integer value2) {
            addCriterion("judgeQuesNum not between", value1, value2, "judgequesnum");
            return (Criteria) this;
        }

        public Criteria andSelectquesnumIsNull() {
            addCriterion("selectQuesNum is null");
            return (Criteria) this;
        }

        public Criteria andSelectquesnumIsNotNull() {
            addCriterion("selectQuesNum is not null");
            return (Criteria) this;
        }

        public Criteria andSelectquesnumEqualTo(Integer value) {
            addCriterion("selectQuesNum =", value, "selectquesnum");
            return (Criteria) this;
        }

        public Criteria andSelectquesnumNotEqualTo(Integer value) {
            addCriterion("selectQuesNum <>", value, "selectquesnum");
            return (Criteria) this;
        }

        public Criteria andSelectquesnumGreaterThan(Integer value) {
            addCriterion("selectQuesNum >", value, "selectquesnum");
            return (Criteria) this;
        }

        public Criteria andSelectquesnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("selectQuesNum >=", value, "selectquesnum");
            return (Criteria) this;
        }

        public Criteria andSelectquesnumLessThan(Integer value) {
            addCriterion("selectQuesNum <", value, "selectquesnum");
            return (Criteria) this;
        }

        public Criteria andSelectquesnumLessThanOrEqualTo(Integer value) {
            addCriterion("selectQuesNum <=", value, "selectquesnum");
            return (Criteria) this;
        }

        public Criteria andSelectquesnumIn(List<Integer> values) {
            addCriterion("selectQuesNum in", values, "selectquesnum");
            return (Criteria) this;
        }

        public Criteria andSelectquesnumNotIn(List<Integer> values) {
            addCriterion("selectQuesNum not in", values, "selectquesnum");
            return (Criteria) this;
        }

        public Criteria andSelectquesnumBetween(Integer value1, Integer value2) {
            addCriterion("selectQuesNum between", value1, value2, "selectquesnum");
            return (Criteria) this;
        }

        public Criteria andSelectquesnumNotBetween(Integer value1, Integer value2) {
            addCriterion("selectQuesNum not between", value1, value2, "selectquesnum");
            return (Criteria) this;
        }

        public Criteria andFillblankquesnumIsNull() {
            addCriterion("fillBlankQuesNum is null");
            return (Criteria) this;
        }

        public Criteria andFillblankquesnumIsNotNull() {
            addCriterion("fillBlankQuesNum is not null");
            return (Criteria) this;
        }

        public Criteria andFillblankquesnumEqualTo(Integer value) {
            addCriterion("fillBlankQuesNum =", value, "fillblankquesnum");
            return (Criteria) this;
        }

        public Criteria andFillblankquesnumNotEqualTo(Integer value) {
            addCriterion("fillBlankQuesNum <>", value, "fillblankquesnum");
            return (Criteria) this;
        }

        public Criteria andFillblankquesnumGreaterThan(Integer value) {
            addCriterion("fillBlankQuesNum >", value, "fillblankquesnum");
            return (Criteria) this;
        }

        public Criteria andFillblankquesnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("fillBlankQuesNum >=", value, "fillblankquesnum");
            return (Criteria) this;
        }

        public Criteria andFillblankquesnumLessThan(Integer value) {
            addCriterion("fillBlankQuesNum <", value, "fillblankquesnum");
            return (Criteria) this;
        }

        public Criteria andFillblankquesnumLessThanOrEqualTo(Integer value) {
            addCriterion("fillBlankQuesNum <=", value, "fillblankquesnum");
            return (Criteria) this;
        }

        public Criteria andFillblankquesnumIn(List<Integer> values) {
            addCriterion("fillBlankQuesNum in", values, "fillblankquesnum");
            return (Criteria) this;
        }

        public Criteria andFillblankquesnumNotIn(List<Integer> values) {
            addCriterion("fillBlankQuesNum not in", values, "fillblankquesnum");
            return (Criteria) this;
        }

        public Criteria andFillblankquesnumBetween(Integer value1, Integer value2) {
            addCriterion("fillBlankQuesNum between", value1, value2, "fillblankquesnum");
            return (Criteria) this;
        }

        public Criteria andFillblankquesnumNotBetween(Integer value1, Integer value2) {
            addCriterion("fillBlankQuesNum not between", value1, value2, "fillblankquesnum");
            return (Criteria) this;
        }

        public Criteria andBigquesnumIsNull() {
            addCriterion("bigQuesNum is null");
            return (Criteria) this;
        }

        public Criteria andBigquesnumIsNotNull() {
            addCriterion("bigQuesNum is not null");
            return (Criteria) this;
        }

        public Criteria andBigquesnumEqualTo(Integer value) {
            addCriterion("bigQuesNum =", value, "bigquesnum");
            return (Criteria) this;
        }

        public Criteria andBigquesnumNotEqualTo(Integer value) {
            addCriterion("bigQuesNum <>", value, "bigquesnum");
            return (Criteria) this;
        }

        public Criteria andBigquesnumGreaterThan(Integer value) {
            addCriterion("bigQuesNum >", value, "bigquesnum");
            return (Criteria) this;
        }

        public Criteria andBigquesnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("bigQuesNum >=", value, "bigquesnum");
            return (Criteria) this;
        }

        public Criteria andBigquesnumLessThan(Integer value) {
            addCriterion("bigQuesNum <", value, "bigquesnum");
            return (Criteria) this;
        }

        public Criteria andBigquesnumLessThanOrEqualTo(Integer value) {
            addCriterion("bigQuesNum <=", value, "bigquesnum");
            return (Criteria) this;
        }

        public Criteria andBigquesnumIn(List<Integer> values) {
            addCriterion("bigQuesNum in", values, "bigquesnum");
            return (Criteria) this;
        }

        public Criteria andBigquesnumNotIn(List<Integer> values) {
            addCriterion("bigQuesNum not in", values, "bigquesnum");
            return (Criteria) this;
        }

        public Criteria andBigquesnumBetween(Integer value1, Integer value2) {
            addCriterion("bigQuesNum between", value1, value2, "bigquesnum");
            return (Criteria) this;
        }

        public Criteria andBigquesnumNotBetween(Integer value1, Integer value2) {
            addCriterion("bigQuesNum not between", value1, value2, "bigquesnum");
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
     * @date 2018-08-31
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