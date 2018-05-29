package com.zr.pojo;

public class QueryVo {
    String quesName;
    String quesSub;
    String probQues;
    String category;

    //当前页码
    private int page=1;
    //从哪一条数据开始查
    private int start=0;
    //每页显示条数
    private int rows=5;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getQuesName() {
        return quesName;
    }

    public void setQuesName(String quesName) {
        this.quesName = quesName;
    }

    public String getQuesSub() {
        return quesSub;
    }

    public void setQuesSub(String quesSub) {
        this.quesSub = quesSub;
    }

    public String getProbQues() {
        return probQues;
    }

    public void setProbQues(String probQues) {
        this.probQues = probQues;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "quesName='" + quesName + '\'' +
                ", quesSub='" + quesSub + '\'' +
                ", probQues='" + probQues + '\'' +
                ", category='" + category + '\'' +
                ", page=" + page +
                ", start=" + start +
                ", rows=" + rows +
                '}';
    }
}
