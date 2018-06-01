package com.zr.pojo;

import java.util.List;

public class PaperTemplet {
    Integer pt_id;
    Course course;
    private List<KnowledgeTemplet> knowledgeTemplets;
    String templetName;
    Integer score;
    Integer difficultyLevel;
    Integer judgeQuesNum;
    Integer selectQuesNum;
    Integer fillBlankQuesNum;
    Integer bigQuesNum;
    Integer judgeQuesScore;
    Integer selectQuesScore;
    Integer fillBlankQuesScore;
    Integer bigQuesScore;


    public List<KnowledgeTemplet> getKnowledgeTemplets() {
        return knowledgeTemplets;
    }

    public void setKnowledgeTemplets(List<KnowledgeTemplet> knowledgeTemplets) {
        this.knowledgeTemplets = knowledgeTemplets;
    }

    public Integer getPt_id() {
        return pt_id;
    }

    public void setPt_id(Integer pt_id) {
        this.pt_id = pt_id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    public String getTempletName() {
        return templetName;
    }

    public void setTempletName(String templetName) {
        this.templetName = templetName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(Integer difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Integer getJudgeQuesNum() {
        return judgeQuesNum;
    }

    public void setJudgeQuesNum(Integer judgeQuesNum) {
        this.judgeQuesNum = judgeQuesNum;
    }

    public Integer getSelectQuesNum() {
        return selectQuesNum;
    }

    public void setSelectQuesNum(Integer selectQuesNum) {
        this.selectQuesNum = selectQuesNum;
    }

    public Integer getFillBlankQuesNum() {
        return fillBlankQuesNum;
    }

    public void setFillBlankQuesNum(Integer fillBlankQuesNum) {
        this.fillBlankQuesNum = fillBlankQuesNum;
    }

    public Integer getBigQuesNum() {
        return bigQuesNum;
    }

    public void setBigQuesNum(Integer bigQuesNum) {
        this.bigQuesNum = bigQuesNum;
    }

    public Integer getJudgeQuesScore() {
        return judgeQuesScore;
    }

    public void setJudgeQuesScore(Integer judgeQuesScore) {
        this.judgeQuesScore = judgeQuesScore;
    }

    public Integer getSelectQuesScore() {
        return selectQuesScore;
    }

    public void setSelectQuesScore(Integer selectQuesScore) {
        this.selectQuesScore = selectQuesScore;
    }

    public Integer getFillBlankQuesScore() {
        return fillBlankQuesScore;
    }

    public void setFillBlankQuesScore(Integer fillBlankQuesScore) {
        this.fillBlankQuesScore = fillBlankQuesScore;
    }

    public Integer getBigQuesScore() {
        return bigQuesScore;
    }

    public void setBigQuesScore(Integer bigQuesScore) {
        this.bigQuesScore = bigQuesScore;
    }
}
