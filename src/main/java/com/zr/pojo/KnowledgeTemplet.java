package com.zr.pojo;

public class KnowledgeTemplet {
    int kt_id;
    PaperTemplet paperTemplet;
    Knowledge knowledge;
    int judgeQuesNum;
    int selectQuesNum;
    int fillBlankQuesNum;
    int bigQuesNum;

    public PaperTemplet getPaperTemplet() {
        return paperTemplet;
    }

    public void setPaperTemplet(PaperTemplet paperTemplet) {
        this.paperTemplet = paperTemplet;
    }

    public Knowledge getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(Knowledge knowledge) {
        this.knowledge = knowledge;
    }

    public int getKt_id() {
        return kt_id;
    }

    public void setKt_id(int kt_id) {
        this.kt_id = kt_id;
    }

    public int getFillBlankQuesNum() {
        return fillBlankQuesNum;
    }

    public void setFillBlankQuesNum(int fillBlankQuesNum) {
        this.fillBlankQuesNum = fillBlankQuesNum;
    }

    public int getJudgeQuesNum() {
        return judgeQuesNum;
    }

    public void setJudgeQuesNum(int judgeQuesNum) {
        this.judgeQuesNum = judgeQuesNum;
    }

    public int getSelectQuesNum() {
        return selectQuesNum;
    }

    public void setSelectQuesNum(int selectQuesNum) {
        this.selectQuesNum = selectQuesNum;
    }

    public int getBigQuesNum() {
        return bigQuesNum;
    }

    public void setBigQuesNum(int bigQuesNum) {
        this.bigQuesNum = bigQuesNum;
    }
}
