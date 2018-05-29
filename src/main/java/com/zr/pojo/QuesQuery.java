package com.zr.pojo;

public class QuesQuery {
    private Integer id;
    private Course course;
    private Knowledge knowledge;
    private ProbCate probCate;
    private QuesCate quesCate;
    private String title;
    private Integer difficultyLevel;
    private String answer;
    private Integer selectedNum;
    private Integer blankNum;
    private String description;
    private String option;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(Integer difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Integer getSelectedNum() {
        return selectedNum;
    }

    public void setSelectedNum(Integer selectedNum) {
        this.selectedNum = selectedNum;
    }

    public Integer getBlankNum() {
        return blankNum;
    }

    public void setBlankNum(Integer blankNum) {
        this.blankNum = blankNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "QuesQuery{" +
                "id=" + id +
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
