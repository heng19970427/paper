package com.zr.pojo;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-08-31
 */
public class Knowledgetemplet {
    private Integer ktId;

    private Integer ptId;

    private Integer kId;

    private Knowledge knowledge;

    private Integer judgequesnum;

    private Integer selectquesnum;

    private Integer fillblankquesnum;

    private Integer bigquesnum;

    public Knowledge getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(Knowledge knowledge) {
        this.knowledge = knowledge;
    }

    public Integer getKtId() {
        return ktId;
    }

    public void setKtId(Integer ktId) {
        this.ktId = ktId;
    }

    public Integer getPtId() {
        return ptId;
    }

    public void setPtId(Integer ptId) {
        this.ptId = ptId;
    }

    public Integer getkId() {
        return kId;
    }

    public void setkId(Integer kId) {
        this.kId = kId;
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

    public Integer getFillblankquesnum() {
        return fillblankquesnum;
    }

    public void setFillblankquesnum(Integer fillblankquesnum) {
        this.fillblankquesnum = fillblankquesnum;
    }

    public Integer getBigquesnum() {
        return bigquesnum;
    }

    public void setBigquesnum(Integer bigquesnum) {
        this.bigquesnum = bigquesnum;
    }
}