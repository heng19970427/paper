package com.zr.pojo;

public class BigQues extends QuesQuery{
    Integer b_id;
    Course course;
    Knowledge knowledge;
    ProbCate probCate;
    QuesCate quesCate;
    String title;
    Integer difficultyLevel;
    String answer;
    Integer selectedNum;
    String description;



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

    public Integer getB_id() {
        return b_id;
    }

    public void setB_id(Integer b_id) {
        this.b_id = b_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BigQues{" +
                "b_id=" + b_id +
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
