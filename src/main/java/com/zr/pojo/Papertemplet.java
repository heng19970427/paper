package com.zr.pojo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-09-02
 */
public class Papertemplet {
    private Integer ptId;

    private Integer cId;

    private Course course;

    private String knowledgeIds;

    private String quescateIds;

    @NotNull(message = "必须选择题目类型")
    private String templetname;

    @NotNull(message = "难度系数不能为空")
    @Min(value=1,message="难度系数不能小于{value}")
    @Max(value=5,message="难度系数不能大于{value}")
    private Integer difficultylevel;

    @NotNull(message = "分数不能为空")
    @Min(value=20,message="分数不能小于{value}")
    @Max(value=150,message="分数不能大于{value}")
    private Integer score;

    private Integer judgequesnum;

    private Integer selectquesnum;

    private Integer bigquesnum;

    private Integer fillblankquesnum;

    private Integer judgequesscore;

    private Integer selectquesscore;

    private Integer bigquesscore;

    private Integer fillblankquesscore;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getPtId() {
        return ptId;
    }

    public void setPtId(Integer ptId) {
        this.ptId = ptId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getKnowledgeIds() {
        return knowledgeIds;
    }

    public void setKnowledgeIds(String knowledgeIds) {
        this.knowledgeIds = knowledgeIds == null ? null : knowledgeIds.trim();
    }

    public String getQuescateIds() {
        return quescateIds;
    }

    public void setQuescateIds(String quescateIds) {
        this.quescateIds = quescateIds == null ? null : quescateIds.trim();
    }

    public String getTempletname() {
        return templetname;
    }

    public void setTempletname(String templetname) {
        this.templetname = templetname == null ? null : templetname.trim();
    }

    public Integer getDifficultylevel() {
        return difficultylevel;
    }

    public void setDifficultylevel(Integer difficultylevel) {
        this.difficultylevel = difficultylevel;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getJudgequesnum() {
        return judgequesnum;
    }

    public void setJudgequesnum(Integer judgequesnum) {
        this.judgequesnum = judgequesnum;
    }

    public Integer getSelectquesnum() {
        return selectquesnum;
    }

    public void setSelectquesnum(Integer selectquesnum) {
        this.selectquesnum = selectquesnum;
    }

    public Integer getBigquesnum() {
        return bigquesnum;
    }

    public void setBigquesnum(Integer bigquesnum) {
        this.bigquesnum = bigquesnum;
    }

    public Integer getFillblankquesnum() {
        return fillblankquesnum;
    }

    public void setFillblankquesnum(Integer fillblankquesnum) {
        this.fillblankquesnum = fillblankquesnum;
    }

    public Integer getJudgequesscore() {
        return judgequesscore;
    }

    public void setJudgequesscore(Integer judgequesscore) {
        this.judgequesscore = judgequesscore;
    }

    public Integer getSelectquesscore() {
        return selectquesscore;
    }

    public void setSelectquesscore(Integer selectquesscore) {
        this.selectquesscore = selectquesscore;
    }

    public Integer getBigquesscore() {
        return bigquesscore;
    }

    public void setBigquesscore(Integer bigquesscore) {
        this.bigquesscore = bigquesscore;
    }

    public Integer getFillblankquesscore() {
        return fillblankquesscore;
    }

    public void setFillblankquesscore(Integer fillblankquesscore) {
        this.fillblankquesscore = fillblankquesscore;
    }
}