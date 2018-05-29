package com.zr.pojo;

public class FillBlankQues extends QuesQuery{
    Integer f_id;
    Course course;
    Knowledge knowledge;
    ProbCate probCate;
    QuesCate quesCate;
    String title;
    Integer difficultyLevel;
    String answer;
    Integer selectedNum;
    Integer blankNum;
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

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getF_id() {
        return f_id;
    }

    public void setF_id(Integer f_id) {
        this.f_id = f_id;
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

    @Override
    public Integer getBlankNum() {
        return blankNum;
    }

    @Override
    public void setBlankNum(Integer blankNum) {
        this.blankNum = blankNum;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "FillBlankQues{" +
                "f_id=" + f_id +
                ", course=" + course +
                ", knowledge=" + knowledge +
                ", probCate=" + probCate +
                ", quesCate=" + quesCate +
                ", title='" + title + '\'' +
                ", difficultyLevel=" + difficultyLevel +
                ", answer='" + answer + '\'' +
                ", selectedNum=" + selectedNum +
                ", blankNum=" + blankNum +
                ", description='" + description + '\'' +
                '}';
    }
}
