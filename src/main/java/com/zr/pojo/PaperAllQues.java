package com.zr.pojo;

import java.util.List;

public class PaperAllQues {
    private Integer pq_id;
    private Integer pa_id;
    private List<BigQues> bigQuesList;
    private List<FillBlankQues> fillBlankQuesList;
    private List<SelectQues> selectQuesList;
    private List<JudgeQues> judgeQuesList;

    public Integer getPq_id() {
        return pq_id;
    }

    public void setPq_id(Integer pq_id) {
        this.pq_id = pq_id;
    }

    public Integer getPa_id() {
        return pa_id;
    }

    public void setPa_id(Integer pa_id) {
        this.pa_id = pa_id;
    }

    public List<BigQues> getBigQuesList() {
        return bigQuesList;
    }

    public void setBigQuesList(List<BigQues> bigQuesList) {
        this.bigQuesList = bigQuesList;
    }

    public List<FillBlankQues> getFillBlankQuesList() {
        return fillBlankQuesList;
    }

    public void setFillBlankQuesList(List<FillBlankQues> fillBlankQuesList) {
        this.fillBlankQuesList = fillBlankQuesList;
    }

    public List<SelectQues> getSelectQuesList() {
        return selectQuesList;
    }

    public void setSelectQuesList(List<SelectQues> selectQuesList) {
        this.selectQuesList = selectQuesList;
    }

    public List<JudgeQues> getJudgeQuesList() {
        return judgeQuesList;
    }

    public void setJudgeQuesList(List<JudgeQues> judgeQuesList) {
        this.judgeQuesList = judgeQuesList;
    }
}
