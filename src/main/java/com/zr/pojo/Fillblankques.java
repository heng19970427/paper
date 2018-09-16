package com.zr.pojo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-08-29
 */
public class Fillblankques {
    private Integer fId;

    private Integer kId;

    private Integer cId;

    private Integer pId;

    private Integer qcId;

    @NotNull(message = "题目名称不能为空")
    private String title;

    @NotNull(message = "难度系数不能为空")
    @Min(value=1,message="难度系数不能小于{value}")
    @Max(value=5,message="难度系数不能大于{value}")
    private Integer difficultylevel;

    @NotNull(message = "答案不能为空")
    private String answer;

    private Integer selectednum;

    private Integer blanknum;

    private String description;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Integer getkId() {
        return kId;
    }

    public void setkId(Integer kId) {
        this.kId = kId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getQcId() {
        return qcId;
    }

    public void setQcId(Integer qcId) {
        this.qcId = qcId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getDifficultylevel() {
        return difficultylevel;
    }

    public void setDifficultylevel(Integer difficultylevel) {
        this.difficultylevel = difficultylevel;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getSelectednum() {
        return selectednum;
    }

    public void setSelectednum(Integer selectednum) {
        this.selectednum = selectednum;
    }

    public Integer getBlanknum() {
        return blanknum;
    }

    public void setBlanknum(Integer blanknum) {
        this.blanknum = blanknum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}