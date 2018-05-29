package com.zr.pojo;

public class SelectQues extends QuesQuery{
    private Integer s_id;
    private Course course;
    private Knowledge knowledge;
    private ProbCate probCate;
    private QuesCate quesCate;
    private String title;
    private Integer difficultyLevel;
    private String answer;
    private Integer selectedNum;
    private String description;

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    @Override
    public Integer getDifficultyLevel() {
        return difficultyLevel;
    }

    @Override
    public void setDifficultyLevel(Integer difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public Integer getSelectedNum() {
        return selectedNum;
    }

    @Override
    public void setSelectedNum(Integer selectedNum) {
        this.selectedNum = selectedNum;
    }

    public Course getCourse() {
        return course;
    }


    public void setCourse(Course course) {
        this.course = course;
    }


    public Knowledge getKnowledge() {
        return knowledge;
    }


    public void setKnowledge(Knowledge knowledge) {
        this.knowledge = knowledge;
    }


    public ProbCate getProbCate() {
        return probCate;
    }


    public void setProbCate(ProbCate probCate) {
        this.probCate = probCate;
    }


    public QuesCate getQuesCate() {
        return quesCate;
    }


    public void setQuesCate(QuesCate quesCate) {
        this.quesCate = quesCate;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }



    public String getAnswer() {
        return answer;
    }


    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return "SelectQues{" +
                "s_id=" + s_id +
                ", course=" + course +
                ", knowledge=" + knowledge +
                ", probCate=" + probCate +
                ", quesCate=" + quesCate +
                ", title='" + title + '\'' +
                ", difficultyLevel=" + difficultyLevel +
                ", answer='" + answer + '\'' +
                ", selectedNum=" + selectedNum +
                ", description='" + description + '\'' +
                '}';
    }
}
