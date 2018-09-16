package com.zr.pojo;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-09-02
 */
public class Knowledge {
    private Integer kId;

    private Integer cId;

    private String knowledgename;

    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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

    public String getKnowledgename() {
        return knowledgename;
    }

    public void setKnowledgename(String knowledgename) {
        this.knowledgename = knowledgename == null ? null : knowledgename.trim();
    }
}