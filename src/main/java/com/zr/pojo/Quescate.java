package com.zr.pojo;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-08-26
 */
public class Quescate {
    private Integer qId;

    private Integer cId;

    private String qcname;

    private Integer pId;

    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getqId() {
        return qId;
    }

    public void setqId(Integer qId) {
        this.qId = qId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getQcname() {
        return qcname;
    }

    public void setQcname(String qcname) {
        this.qcname = qcname == null ? null : qcname.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }
}