package com.zr.pojo;

public class Paper {
    private Integer pa_id;
    private PaperAllQues paperAllQues;
    private PaperTemplet paperTemplet;
    private String paperName;

    public Integer getPa_id() {
        return pa_id;
    }

    public void setPa_id(Integer pa_id) {
        this.pa_id = pa_id;
    }

    public PaperAllQues getPaperAllQues() {
        return paperAllQues;
    }

    public void setPaperAllQues(PaperAllQues paperAllQues) {
        this.paperAllQues = paperAllQues;
    }

    public PaperTemplet getPaperTemplet() {
        return paperTemplet;
    }

    public void setPaperTemplet(PaperTemplet paperTemplet) {
        this.paperTemplet = paperTemplet;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }
}
