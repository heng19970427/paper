package com.zr.pojo;

public class Quescate {
    private int q_id;
    private ProbCate probCate;
    private String qcName;
    private Course course;
    private int blankNum;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ProbCate getProbCate() {
        return probCate;
    }

    public void setProbCate(ProbCate probCate) {
        this.probCate = probCate;
    }

    public int getQ_id() {
        return q_id;
    }

    public void setQ_id(int q_id) {
        this.q_id = q_id;
    }

    public String getQcName() {
        return qcName;
    }

    public void setQcName(String qcName) {
        this.qcName = qcName;
    }

    public int getBlankNum() {
        return blankNum;
    }

    public void setBlankNum(int blankNum) {
        this.blankNum = blankNum;
    }
}
