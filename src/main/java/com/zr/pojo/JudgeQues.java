package com.zr.pojo;

public class JudgeQues extends QuesQuery{
    Integer j_id;
    String courseName;
    String knowledgeName;
    String qcName;
    String title;
    Integer difficultyLevel;
    String answer;
    Integer selectedNum;
    String description;
    String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getKnowledgeName() {
        return knowledgeName;
    }

    public void setKnowledgeName(String knowledgeName) {
        this.knowledgeName = knowledgeName;
    }

    public String getQcName() {
        return qcName;
    }

    public void setQcName(String qcName) {
        this.qcName = qcName;
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

    public Integer getJ_id() {
        return j_id;
    }

    public void setJ_id(Integer j_id) {
        this.j_id = j_id;
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
        return "JudgeQues{" +
                "j_id=" + j_id +
                ", courseName='" + courseName + '\'' +
                ", knowledgeName='" + knowledgeName + '\'' +
                ", qcName='" + qcName + '\'' +
                ", title='" + title + '\'' +
                ", difficultyLevel=" + difficultyLevel +
                ", answer='" + answer + '\'' +
                ", selectedNum=" + selectedNum +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
