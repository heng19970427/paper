package com.zr.pojo;

import java.util.ArrayList;
import java.util.List;

public class PapertempletExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PapertempletExample() {
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
     * @date 2018-09-02
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

        public Criteria andKnowledgeIdsIsNull() {
            addCriterion("knowledge_ids is null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdsIsNotNull() {
            addCriterion("knowledge_ids is not null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdsEqualTo(String value) {
            addCriterion("knowledge_ids =", value, "knowledgeIds");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdsNotEqualTo(String value) {
            addCriterion("knowledge_ids <>", value, "knowledgeIds");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdsGreaterThan(String value) {
            addCriterion("knowledge_ids >", value, "knowledgeIds");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdsGreaterThanOrEqualTo(String value) {
            addCriterion("knowledge_ids >=", value, "knowledgeIds");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdsLessThan(String value) {
            addCriterion("knowledge_ids <", value, "knowledgeIds");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdsLessThanOrEqualTo(String value) {
            addCriterion("knowledge_ids <=", value, "knowledgeIds");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdsLike(String value) {
            addCriterion("knowledge_ids like", value, "knowledgeIds");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdsNotLike(String value) {
            addCriterion("knowledge_ids not like", value, "knowledgeIds");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdsIn(List<String> values) {
            addCriterion("knowledge_ids in", values, "knowledgeIds");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdsNotIn(List<String> values) {
            addCriterion("knowledge_ids not in", values, "knowledgeIds");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdsBetween(String value1, String value2) {
            addCriterion("knowledge_ids between", value1, value2, "knowledgeIds");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdsNotBetween(String value1, String value2) {
            addCriterion("knowledge_ids not between", value1, value2, "knowledgeIds");
            return (Criteria) this;
        }

        public Criteria andQuescateIdsIsNull() {
            addCriterion("quescate_ids is null");
            return (Criteria) this;
        }

        public Criteria andQuescateIdsIsNotNull() {
            addCriterion("quescate_ids is not null");
            return (Criteria) this;
        }

        public Criteria andQuescateIdsEqualTo(String value) {
            addCriterion("quescate_ids =", value, "quescateIds");
            return (Criteria) this;
        }

        public Criteria andQuescateIdsNotEqualTo(String value) {
            addCriterion("quescate_ids <>", value, "quescateIds");
            return (Criteria) this;
        }

        public Criteria andQuescateIdsGreaterThan(String value) {
            addCriterion("quescate_ids >", value, "quescateIds");
            return (Criteria) this;
        }

        public Criteria andQuescateIdsGreaterThanOrEqualTo(String value) {
            addCriterion("quescate_ids >=", value, "quescateIds");
            return (Criteria) this;
        }

        public Criteria andQuescateIdsLessThan(String value) {
            addCriterion("quescate_ids <", value, "quescateIds");
            return (Criteria) this;
        }

        public Criteria andQuescateIdsLessThanOrEqualTo(String value) {
            addCriterion("quescate_ids <=", value, "quescateIds");
            return (Criteria) this;
        }

        public Criteria andQuescateIdsLike(String value) {
            addCriterion("quescate_ids like", value, "quescateIds");
            return (Criteria) this;
        }

        public Criteria andQuescateIdsNotLike(String value) {
            addCriterion("quescate_ids not like", value, "quescateIds");
            return (Criteria) this;
        }

        public Criteria andQuescateIdsIn(List<String> values) {
            addCriterion("quescate_ids in", values, "quescateIds");
            return (Criteria) this;
        }

        public Criteria andQuescateIdsNotIn(List<String> values) {
            addCriterion("quescate_ids not in", values, "quescateIds");
            return (Criteria) this;
        }

        public Criteria andQuescateIdsBetween(String value1, String value2) {
            addCriterion("quescate_ids between", value1, value2, "quescateIds");
            return (Criteria) this;
        }

        public Criteria andQuescateIdsNotBetween(String value1, String value2) {
            addCriterion("quescate_ids not between", value1, value2, "quescateIds");
            return (Criteria) this;
        }

        public Criteria andTempletnameIsNull() {
            addCriterion("templetName is null");
            return (Criteria) this;
        }

        public Criteria andTempletnameIsNotNull() {
            addCriterion("templetName is not null");
            return (Criteria) this;
        }

        public Criteria andTempletnameEqualTo(String value) {
            addCriterion("templetName =", value, "templetname");
            return (Criteria) this;
        }

        public Criteria andTempletnameNotEqualTo(String value) {
            addCriterion("templetName <>", value, "templetname");
            return (Criteria) this;
        }

        public Criteria andTempletnameGreaterThan(String value) {
            addCriterion("templetName >", value, "templetname");
            return (Criteria) this;
        }

        public Criteria andTempletnameGreaterThanOrEqualTo(String value) {
            addCriterion("templetName >=", value, "templetname");
            return (Criteria) this;
        }

        public Criteria andTempletnameLessThan(String value) {
            addCriterion("templetName <", value, "templetname");
            return (Criteria) this;
        }

        public Criteria andTempletnameLessThanOrEqualTo(String value) {
            addCriterion("templetName <=", value, "templetname");
            return (Criteria) this;
        }

        public Criteria andTempletnameLike(String value) {
            addCriterion("templetName like", value, "templetname");
            return (Criteria) this;
        }

        public Criteria andTempletnameNotLike(String value) {
            addCriterion("templetName not like", value, "templetname");
            return (Criteria) this;
        }

        public Criteria andTempletnameIn(List<String> values) {
            addCriterion("templetName in", values, "templetname");
            return (Criteria) this;
        }

        public Criteria andTempletnameNotIn(List<String> values) {
            addCriterion("templetName not in", values, "templetname");
            return (Criteria) this;
        }

        public Criteria andTempletnameBetween(String value1, String value2) {
            addCriterion("templetName between", value1, value2, "templetname");
            return (Criteria) this;
        }

        public Criteria andTempletnameNotBetween(String value1, String value2) {
            addCriterion("templetName not between", value1, value2, "templetname");
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

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
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

        public Criteria andJudgequesscoreIsNull() {
            addCriterion("judgeQuesScore is null");
            return (Criteria) this;
        }

        public Criteria andJudgequesscoreIsNotNull() {
            addCriterion("judgeQuesScore is not null");
            return (Criteria) this;
        }

        public Criteria andJudgequesscoreEqualTo(Integer value) {
            addCriterion("judgeQuesScore =", value, "judgequesscore");
            return (Criteria) this;
        }

        public Criteria andJudgequesscoreNotEqualTo(Integer value) {
            addCriterion("judgeQuesScore <>", value, "judgequesscore");
            return (Criteria) this;
        }

        public Criteria andJudgequesscoreGreaterThan(Integer value) {
            addCriterion("judgeQuesScore >", value, "judgequesscore");
            return (Criteria) this;
        }

        public Criteria andJudgequesscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("judgeQuesScore >=", value, "judgequesscore");
            return (Criteria) this;
        }

        public Criteria andJudgequesscoreLessThan(Integer value) {
            addCriterion("judgeQuesScore <", value, "judgequesscore");
            return (Criteria) this;
        }

        public Criteria andJudgequesscoreLessThanOrEqualTo(Integer value) {
            addCriterion("judgeQuesScore <=", value, "judgequesscore");
            return (Criteria) this;
        }

        public Criteria andJudgequesscoreIn(List<Integer> values) {
            addCriterion("judgeQuesScore in", values, "judgequesscore");
            return (Criteria) this;
        }

        public Criteria andJudgequesscoreNotIn(List<Integer> values) {
            addCriterion("judgeQuesScore not in", values, "judgequesscore");
            return (Criteria) this;
        }

        public Criteria andJudgequesscoreBetween(Integer value1, Integer value2) {
            addCriterion("judgeQuesScore between", value1, value2, "judgequesscore");
            return (Criteria) this;
        }

        public Criteria andJudgequesscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("judgeQuesScore not between", value1, value2, "judgequesscore");
            return (Criteria) this;
        }

        public Criteria andSelectquesscoreIsNull() {
            addCriterion("selectQuesScore is null");
            return (Criteria) this;
        }

        public Criteria andSelectquesscoreIsNotNull() {
            addCriterion("selectQuesScore is not null");
            return (Criteria) this;
        }

        public Criteria andSelectquesscoreEqualTo(Integer value) {
            addCriterion("selectQuesScore =", value, "selectquesscore");
            return (Criteria) this;
        }

        public Criteria andSelectquesscoreNotEqualTo(Integer value) {
            addCriterion("selectQuesScore <>", value, "selectquesscore");
            return (Criteria) this;
        }

        public Criteria andSelectquesscoreGreaterThan(Integer value) {
            addCriterion("selectQuesScore >", value, "selectquesscore");
            return (Criteria) this;
        }

        public Criteria andSelectquesscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("selectQuesScore >=", value, "selectquesscore");
            return (Criteria) this;
        }

        public Criteria andSelectquesscoreLessThan(Integer value) {
            addCriterion("selectQuesScore <", value, "selectquesscore");
            return (Criteria) this;
        }

        public Criteria andSelectquesscoreLessThanOrEqualTo(Integer value) {
            addCriterion("selectQuesScore <=", value, "selectquesscore");
            return (Criteria) this;
        }

        public Criteria andSelectquesscoreIn(List<Integer> values) {
            addCriterion("selectQuesScore in", values, "selectquesscore");
            return (Criteria) this;
        }

        public Criteria andSelectquesscoreNotIn(List<Integer> values) {
            addCriterion("selectQuesScore not in", values, "selectquesscore");
            return (Criteria) this;
        }

        public Criteria andSelectquesscoreBetween(Integer value1, Integer value2) {
            addCriterion("selectQuesScore between", value1, value2, "selectquesscore");
            return (Criteria) this;
        }

        public Criteria andSelectquesscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("selectQuesScore not between", value1, value2, "selectquesscore");
            return (Criteria) this;
        }

        public Criteria andBigquesscoreIsNull() {
            addCriterion("bigQuesScore is null");
            return (Criteria) this;
        }

        public Criteria andBigquesscoreIsNotNull() {
            addCriterion("bigQuesScore is not null");
            return (Criteria) this;
        }

        public Criteria andBigquesscoreEqualTo(Integer value) {
            addCriterion("bigQuesScore =", value, "bigquesscore");
            return (Criteria) this;
        }

        public Criteria andBigquesscoreNotEqualTo(Integer value) {
            addCriterion("bigQuesScore <>", value, "bigquesscore");
            return (Criteria) this;
        }

        public Criteria andBigquesscoreGreaterThan(Integer value) {
            addCriterion("bigQuesScore >", value, "bigquesscore");
            return (Criteria) this;
        }

        public Criteria andBigquesscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("bigQuesScore >=", value, "bigquesscore");
            return (Criteria) this;
        }

        public Criteria andBigquesscoreLessThan(Integer value) {
            addCriterion("bigQuesScore <", value, "bigquesscore");
            return (Criteria) this;
        }

        public Criteria andBigquesscoreLessThanOrEqualTo(Integer value) {
            addCriterion("bigQuesScore <=", value, "bigquesscore");
            return (Criteria) this;
        }

        public Criteria andBigquesscoreIn(List<Integer> values) {
            addCriterion("bigQuesScore in", values, "bigquesscore");
            return (Criteria) this;
        }

        public Criteria andBigquesscoreNotIn(List<Integer> values) {
            addCriterion("bigQuesScore not in", values, "bigquesscore");
            return (Criteria) this;
        }

        public Criteria andBigquesscoreBetween(Integer value1, Integer value2) {
            addCriterion("bigQuesScore between", value1, value2, "bigquesscore");
            return (Criteria) this;
        }

        public Criteria andBigquesscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("bigQuesScore not between", value1, value2, "bigquesscore");
            return (Criteria) this;
        }

        public Criteria andFillblankquesscoreIsNull() {
            addCriterion("fillBlankQuesScore is null");
            return (Criteria) this;
        }

        public Criteria andFillblankquesscoreIsNotNull() {
            addCriterion("fillBlankQuesScore is not null");
            return (Criteria) this;
        }

        public Criteria andFillblankquesscoreEqualTo(Integer value) {
            addCriterion("fillBlankQuesScore =", value, "fillblankquesscore");
            return (Criteria) this;
        }

        public Criteria andFillblankquesscoreNotEqualTo(Integer value) {
            addCriterion("fillBlankQuesScore <>", value, "fillblankquesscore");
            return (Criteria) this;
        }

        public Criteria andFillblankquesscoreGreaterThan(Integer value) {
            addCriterion("fillBlankQuesScore >", value, "fillblankquesscore");
            return (Criteria) this;
        }

        public Criteria andFillblankquesscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("fillBlankQuesScore >=", value, "fillblankquesscore");
            return (Criteria) this;
        }

        public Criteria andFillblankquesscoreLessThan(Integer value) {
            addCriterion("fillBlankQuesScore <", value, "fillblankquesscore");
            return (Criteria) this;
        }

        public Criteria andFillblankquesscoreLessThanOrEqualTo(Integer value) {
            addCriterion("fillBlankQuesScore <=", value, "fillblankquesscore");
            return (Criteria) this;
        }

        public Criteria andFillblankquesscoreIn(List<Integer> values) {
            addCriterion("fillBlankQuesScore in", values, "fillblankquesscore");
            return (Criteria) this;
        }

        public Criteria andFillblankquesscoreNotIn(List<Integer> values) {
            addCriterion("fillBlankQuesScore not in", values, "fillblankquesscore");
            return (Criteria) this;
        }

        public Criteria andFillblankquesscoreBetween(Integer value1, Integer value2) {
            addCriterion("fillBlankQuesScore between", value1, value2, "fillblankquesscore");
            return (Criteria) this;
        }

        public Criteria andFillblankquesscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("fillBlankQuesScore not between", value1, value2, "fillblankquesscore");
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
     * @date 2018-09-02
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